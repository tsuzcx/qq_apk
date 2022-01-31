package com.tencent.tmassistantsdk.downloadservice;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public class DownloadTask
{
  public static final String TAG = "_DownloadTask";
  protected DownloadInfo mDownloadInfo = null;
  HttpClient mHttpClient = null;
  HttpGet mHttpGet = null;
  private boolean mIsRedirect = false;
  protected final byte[] mRecvBuf = new byte[4096];
  private String mRequestUrl;
  TMAssistantFile mSaveFile;
  protected boolean mStopTask = false;
  protected final int mTaskId = GlobalUtil.getMemUUID();
  private String startDownloadNetType = "wifi";
  
  public DownloadTask(DownloadInfo paramDownloadInfo)
  {
    this.mDownloadInfo = paramDownloadInfo;
  }
  
  private void cancelInWorkThread()
  {
    this.mStopTask = true;
    if ((this.mHttpGet != null) && (!this.mHttpGet.isAborted())) {
      this.mHttpGet.abort();
    }
  }
  
  private void handleResponseCode(HttpResponse paramHttpResponse, DownloadChunkLogInfo paramDownloadChunkLogInfo)
  {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    TMLog.i("_DownloadTask", "httpResponseCode = " + i + " " + Thread.currentThread().getName());
    paramDownloadChunkLogInfo.readHeaderTime = System.currentTimeMillis();
    paramDownloadChunkLogInfo.responseHttpCode = i;
    if ((i == 200) || (i == 206)) {
      this.mDownloadInfo.mRetryCnt = 0;
    }
    Object localObject;
    switch (i)
    {
    default: 
      throw new StopRequestException(i, "HTTP response code error, code = " + i);
    case 200: 
      localObject = paramHttpResponse.getHeaders("Content-Type");
      if ((localObject != null) && (localObject.length > 0))
      {
        if (!this.mDownloadInfo.mContentType.equals("resource/tm.android.unknown")) {
          break label253;
        }
        localObject = DownloadHelper.renameAPKFileName(this.mDownloadInfo.mFileName);
        this.mDownloadInfo.mFileName = ((String)localObject);
      }
      for (;;)
      {
        onReceivedResponseData(paramHttpResponse, paramDownloadChunkLogInfo);
        return;
        localObject = localObject[0].getValue();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("text"))) {
          throw new StopRequestException(708, "Return contenttype = text " + Thread.currentThread().getName());
        }
        renameApkFileName(paramHttpResponse);
      }
    case 206: 
      if (this.mDownloadInfo.mContentType.equals("resource/tm.android.unknown"))
      {
        localObject = DownloadHelper.renameAPKFileName(this.mDownloadInfo.mFileName);
        this.mDownloadInfo.mFileName = ((String)localObject);
      }
      for (;;)
      {
        onReceivedResponseData(paramHttpResponse, paramDownloadChunkLogInfo);
        return;
        renameApkFileName(paramHttpResponse);
      }
    case 301: 
    case 302: 
    case 303: 
    case 307: 
      if (this.mDownloadInfo.mRedirectCnt > 5)
      {
        TMLog.i("_DownloadTask", "mRedirectCnt = " + this.mDownloadInfo.mRedirectCnt + ",MAX_REDIRESTS = 5");
        throw new StopRequestException(709, "Redirect cnt many times.");
      }
      paramHttpResponse = paramHttpResponse.getFirstHeader("location");
      if (paramHttpResponse != null)
      {
        paramHttpResponse = paramHttpResponse.getValue();
        TMLog.i("_DownloadTask", "jumpURL = " + paramHttpResponse);
        if (DownloadHelper.isValidURL(paramHttpResponse))
        {
          this.mRequestUrl = DownloadHelper.correctURL(paramHttpResponse);
          this.mIsRedirect = true;
          paramHttpResponse = this.mDownloadInfo;
          paramHttpResponse.mRedirectCnt += 1;
          return;
        }
        throw new StopRequestException(700, "Jump url is not valid. httpResponseCode = " + i + " url: " + paramHttpResponse);
      }
      TMLog.e("_DownloadTask", "location header is null. httpResponseCode = " + i);
      throw new StopRequestException(702, "location header is null. httpResponseCode = " + i);
    case 416: 
      throw new StopRequestException(i, "HTTP response code error, code = " + i);
    case 503: 
      label253:
      throw new StopRequestException(i, "HTTP response code error, code = " + i);
    }
    throw new StopRequestException(i, "HTTP response code error, code = " + i);
  }
  
  private void onDownloadError(Throwable paramThrowable)
  {
    if (paramThrowable != null) {
      y.printErrStackTrace("_DownloadTask", paramThrowable, "", new Object[0]);
    }
  }
  
  /* Error */
  private void onReceivedResponseData(HttpResponse paramHttpResponse, DownloadChunkLogInfo paramDownloadChunkLogInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 248 1 0
    //   6: astore 9
    //   8: aload_0
    //   9: aload_1
    //   10: aload 9
    //   12: invokespecial 252	com/tencent/tmassistantsdk/downloadservice/DownloadTask:verifyTotalLen	(Lorg/apache/http/HttpResponse;Lorg/apache/http/HttpEntity;)Z
    //   15: ifne +24 -> 39
    //   18: ldc 8
    //   20: ldc 254
    //   22: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: new 139	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   28: dup
    //   29: sipush 705
    //   32: ldc_w 256
    //   35: invokespecial 144	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/String;)V
    //   38: athrow
    //   39: aload_0
    //   40: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   43: invokevirtual 259	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   46: lconst_0
    //   47: lcmp
    //   48: ifne +397 -> 445
    //   51: aload_1
    //   52: invokeinterface 77 1 0
    //   57: invokeinterface 82 1 0
    //   62: sipush 200
    //   65: if_icmpne +263 -> 328
    //   68: aload_0
    //   69: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   72: aload 9
    //   74: invokeinterface 264 1 0
    //   79: invokevirtual 268	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:setTotalSize	(J)V
    //   82: ldc 8
    //   84: new 84	java/lang/StringBuilder
    //   87: dup
    //   88: ldc_w 270
    //   91: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload_0
    //   95: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   98: invokevirtual 259	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   101: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   104: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: ldc 8
    //   112: new 84	java/lang/StringBuilder
    //   115: dup
    //   116: ldc_w 275
    //   119: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload_0
    //   123: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   126: invokevirtual 259	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   129: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   132: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 278	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload_1
    //   139: ldc_w 280
    //   142: invokeinterface 211 2 0
    //   147: astore_1
    //   148: aload_1
    //   149: ifnull +36 -> 185
    //   152: aload_1
    //   153: invokeinterface 178 1 0
    //   158: invokestatic 286	com/tencent/tmassistantsdk/downloadservice/ByteRange:parseContentRange	(Ljava/lang/String;)Lcom/tencent/tmassistantsdk/downloadservice/ByteRange;
    //   161: astore_1
    //   162: aload_2
    //   163: aload_1
    //   164: invokevirtual 289	com/tencent/tmassistantsdk/downloadservice/ByteRange:getStart	()J
    //   167: putfield 292	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseRangePosition	J
    //   170: aload_2
    //   171: aload_1
    //   172: invokevirtual 295	com/tencent/tmassistantsdk/downloadservice/ByteRange:getEnd	()J
    //   175: aload_1
    //   176: invokevirtual 289	com/tencent/tmassistantsdk/downloadservice/ByteRange:getStart	()J
    //   179: lsub
    //   180: lconst_1
    //   181: ladd
    //   182: putfield 298	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseRangeLength	J
    //   185: aload_2
    //   186: aload_0
    //   187: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   190: invokevirtual 259	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   193: putfield 301	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseContentLength	J
    //   196: aload_0
    //   197: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   200: ifnonnull +28 -> 228
    //   203: aload_0
    //   204: new 305	com/tencent/tmassistantsdk/storage/TMAssistantFile
    //   207: dup
    //   208: aload_0
    //   209: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   212: getfield 308	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mTempFileName	Ljava/lang/String;
    //   215: aload_0
    //   216: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   219: getfield 164	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mFileName	Ljava/lang/String;
    //   222: invokespecial 310	com/tencent/tmassistantsdk/storage/TMAssistantFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: putfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   228: lconst_0
    //   229: lstore 6
    //   231: lload 6
    //   233: lstore 4
    //   235: aload 9
    //   237: invokeinterface 314 1 0
    //   242: astore_1
    //   243: lload 6
    //   245: lstore 4
    //   247: ldc 8
    //   249: new 84	java/lang/StringBuilder
    //   252: dup
    //   253: ldc_w 316
    //   256: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   259: aload_0
    //   260: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   263: getfield 164	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mFileName	Ljava/lang/String;
    //   266: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: lconst_0
    //   276: lstore 4
    //   278: aload_1
    //   279: aload_0
    //   280: getfield 40	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mRecvBuf	[B
    //   283: invokevirtual 322	java/io/InputStream:read	([B)I
    //   286: istore_3
    //   287: iload_3
    //   288: ifle +14 -> 302
    //   291: aload_0
    //   292: getfield 32	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   295: ifeq +474 -> 769
    //   298: aload_1
    //   299: invokevirtual 325	java/io/InputStream:close	()V
    //   302: aload_0
    //   303: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   306: ifnull +15 -> 321
    //   309: aload_0
    //   310: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   313: invokevirtual 326	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   316: aload_0
    //   317: aconst_null
    //   318: putfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   321: aload_2
    //   322: lload 4
    //   324: putfield 329	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:receiveDataSize	J
    //   327: return
    //   328: aload_1
    //   329: invokeinterface 77 1 0
    //   334: invokeinterface 82 1 0
    //   339: sipush 206
    //   342: if_icmpne +62 -> 404
    //   345: aload_1
    //   346: ldc_w 280
    //   349: invokeinterface 211 2 0
    //   354: astore 10
    //   356: aload_0
    //   357: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   360: aload 10
    //   362: invokeinterface 178 1 0
    //   367: invokestatic 332	com/tencent/tmassistantsdk/downloadservice/ByteRange:getTotalSize	(Ljava/lang/String;)J
    //   370: invokevirtual 268	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:setTotalSize	(J)V
    //   373: ldc 8
    //   375: new 84	java/lang/StringBuilder
    //   378: dup
    //   379: ldc_w 334
    //   382: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   385: aload_0
    //   386: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   389: invokevirtual 259	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   392: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   395: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   401: goto -291 -> 110
    //   404: ldc 8
    //   406: new 84	java/lang/StringBuilder
    //   409: dup
    //   410: ldc_w 336
    //   413: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   416: aload_1
    //   417: invokeinterface 77 1 0
    //   422: invokeinterface 82 1 0
    //   427: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   430: ldc_w 338
    //   433: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 278	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: goto -332 -> 110
    //   445: aload_1
    //   446: invokeinterface 77 1 0
    //   451: invokeinterface 82 1 0
    //   456: sipush 206
    //   459: if_icmpne -263 -> 196
    //   462: aload_1
    //   463: ldc_w 280
    //   466: invokeinterface 211 2 0
    //   471: astore_1
    //   472: aload_1
    //   473: invokeinterface 178 1 0
    //   478: invokestatic 286	com/tencent/tmassistantsdk/downloadservice/ByteRange:parseContentRange	(Ljava/lang/String;)Lcom/tencent/tmassistantsdk/downloadservice/ByteRange;
    //   481: astore 10
    //   483: aload_1
    //   484: invokeinterface 178 1 0
    //   489: invokestatic 332	com/tencent/tmassistantsdk/downloadservice/ByteRange:getTotalSize	(Ljava/lang/String;)J
    //   492: lstore 4
    //   494: aload_2
    //   495: aload 10
    //   497: invokevirtual 289	com/tencent/tmassistantsdk/downloadservice/ByteRange:getStart	()J
    //   500: putfield 292	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseRangePosition	J
    //   503: aload_2
    //   504: aload 10
    //   506: invokevirtual 295	com/tencent/tmassistantsdk/downloadservice/ByteRange:getEnd	()J
    //   509: aload 10
    //   511: invokevirtual 289	com/tencent/tmassistantsdk/downloadservice/ByteRange:getStart	()J
    //   514: lsub
    //   515: lconst_1
    //   516: ladd
    //   517: putfield 298	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseRangeLength	J
    //   520: aload_2
    //   521: lload 4
    //   523: putfield 301	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseContentLength	J
    //   526: ldc 8
    //   528: new 84	java/lang/StringBuilder
    //   531: dup
    //   532: ldc_w 340
    //   535: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   538: lload 4
    //   540: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   543: ldc_w 342
    //   546: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload_0
    //   550: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   553: invokevirtual 259	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   556: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   559: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 278	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   565: ldc 8
    //   567: new 84	java/lang/StringBuilder
    //   570: dup
    //   571: ldc_w 344
    //   574: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   577: aload_0
    //   578: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   581: getfield 347	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mReceivedBytes	J
    //   584: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   587: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: ldc 8
    //   595: new 84	java/lang/StringBuilder
    //   598: dup
    //   599: ldc_w 349
    //   602: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   605: aload 10
    //   607: invokevirtual 289	com/tencent/tmassistantsdk/downloadservice/ByteRange:getStart	()J
    //   610: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   613: ldc_w 351
    //   616: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload 10
    //   621: invokevirtual 295	com/tencent/tmassistantsdk/downloadservice/ByteRange:getEnd	()J
    //   624: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   627: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   633: aload 10
    //   635: invokevirtual 289	com/tencent/tmassistantsdk/downloadservice/ByteRange:getStart	()J
    //   638: aload_0
    //   639: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   642: getfield 347	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mReceivedBytes	J
    //   645: lcmp
    //   646: ifeq +52 -> 698
    //   649: new 139	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   652: dup
    //   653: sipush 706
    //   656: ldc_w 353
    //   659: invokespecial 144	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/String;)V
    //   662: athrow
    //   663: astore_1
    //   664: new 139	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   667: dup
    //   668: sipush 704
    //   671: aload_1
    //   672: invokespecial 356	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/Throwable;)V
    //   675: athrow
    //   676: astore_1
    //   677: aload_0
    //   678: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   681: ifnull +15 -> 696
    //   684: aload_0
    //   685: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   688: invokevirtual 326	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   691: aload_0
    //   692: aconst_null
    //   693: putfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   696: aload_1
    //   697: athrow
    //   698: lload 4
    //   700: aload_0
    //   701: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   704: invokevirtual 259	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   707: lcmp
    //   708: ifeq +17 -> 725
    //   711: new 139	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   714: dup
    //   715: sipush 705
    //   718: ldc_w 358
    //   721: invokespecial 144	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/String;)V
    //   724: athrow
    //   725: ldc 8
    //   727: new 84	java/lang/StringBuilder
    //   730: dup
    //   731: ldc_w 360
    //   734: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   737: aload_1
    //   738: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   741: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: invokestatic 366	com/tencent/tmassistantsdk/util/TMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: aload_0
    //   748: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   751: ifnull -555 -> 196
    //   754: aload_0
    //   755: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   758: invokevirtual 326	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   761: aload_0
    //   762: aconst_null
    //   763: putfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   766: goto -570 -> 196
    //   769: aload_0
    //   770: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   773: getfield 347	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mReceivedBytes	J
    //   776: iload_3
    //   777: i2l
    //   778: ladd
    //   779: lstore 6
    //   781: lload 6
    //   783: aload_0
    //   784: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   787: invokevirtual 259	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   790: lcmp
    //   791: ifgt +408 -> 1199
    //   794: lload 6
    //   796: aload_0
    //   797: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   800: invokevirtual 259	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   803: lcmp
    //   804: ifne +202 -> 1006
    //   807: iconst_1
    //   808: istore 8
    //   810: aload_0
    //   811: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   814: aload_0
    //   815: getfield 40	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mRecvBuf	[B
    //   818: iconst_0
    //   819: iload_3
    //   820: aload_0
    //   821: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   824: getfield 347	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mReceivedBytes	J
    //   827: iload 8
    //   829: invokevirtual 370	com/tencent/tmassistantsdk/storage/TMAssistantFile:write	([BIIJZ)Z
    //   832: ifne +348 -> 1180
    //   835: invokestatic 373	com/tencent/tmassistantsdk/storage/TMAssistantFile:getSavePathRootDir	()Ljava/lang/String;
    //   838: aload_0
    //   839: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   842: invokevirtual 259	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   845: invokestatic 377	com/tencent/tmassistantsdk/downloadservice/DownloadHelper:isSpaceEnough	(Ljava/lang/String;J)Z
    //   848: ifeq +248 -> 1096
    //   851: invokestatic 380	com/tencent/tmassistantsdk/storage/TMAssistantFile:isSDCardExistAndCanWrite	()Z
    //   854: ifeq +158 -> 1012
    //   857: new 84	java/lang/StringBuilder
    //   860: dup
    //   861: ldc_w 382
    //   864: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   867: aload_0
    //   868: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   871: getfield 164	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mFileName	Ljava/lang/String;
    //   874: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: ldc_w 384
    //   880: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: aload_0
    //   884: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   887: getfield 347	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mReceivedBytes	J
    //   890: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   893: ldc_w 386
    //   896: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: iload_3
    //   900: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   903: ldc_w 388
    //   906: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: aload_0
    //   910: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   913: invokevirtual 259	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   916: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   919: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   922: astore_1
    //   923: ldc 8
    //   925: aload_1
    //   926: invokestatic 278	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   929: new 139	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   932: dup
    //   933: sipush 703
    //   936: aload_1
    //   937: invokespecial 144	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/String;)V
    //   940: athrow
    //   941: astore_1
    //   942: lload 4
    //   944: lstore 6
    //   946: lload 6
    //   948: lstore 4
    //   950: ldc 8
    //   952: aload_1
    //   953: ldc 234
    //   955: iconst_0
    //   956: anewarray 4	java/lang/Object
    //   959: invokestatic 240	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   962: lload 6
    //   964: lstore 4
    //   966: new 139	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   969: dup
    //   970: sipush 605
    //   973: aload_1
    //   974: invokespecial 356	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/Throwable;)V
    //   977: athrow
    //   978: astore_1
    //   979: aload_0
    //   980: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   983: ifnull +15 -> 998
    //   986: aload_0
    //   987: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   990: invokevirtual 326	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   993: aload_0
    //   994: aconst_null
    //   995: putfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   998: aload_2
    //   999: lload 4
    //   1001: putfield 329	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:receiveDataSize	J
    //   1004: aload_1
    //   1005: athrow
    //   1006: iconst_0
    //   1007: istore 8
    //   1009: goto -199 -> 810
    //   1012: new 84	java/lang/StringBuilder
    //   1015: dup
    //   1016: ldc_w 390
    //   1019: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1022: aload_0
    //   1023: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1026: getfield 164	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mFileName	Ljava/lang/String;
    //   1029: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: ldc_w 384
    //   1035: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: aload_0
    //   1039: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1042: getfield 347	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mReceivedBytes	J
    //   1045: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1048: ldc_w 386
    //   1051: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: iload_3
    //   1055: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1058: ldc_w 388
    //   1061: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: aload_0
    //   1065: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1068: invokevirtual 259	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   1071: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1074: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1077: astore_1
    //   1078: ldc 8
    //   1080: aload_1
    //   1081: invokestatic 278	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1084: new 139	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   1087: dup
    //   1088: sipush 711
    //   1091: aload_1
    //   1092: invokespecial 144	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/String;)V
    //   1095: athrow
    //   1096: new 84	java/lang/StringBuilder
    //   1099: dup
    //   1100: ldc_w 392
    //   1103: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1106: aload_0
    //   1107: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1110: getfield 164	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mFileName	Ljava/lang/String;
    //   1113: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: ldc_w 384
    //   1119: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: aload_0
    //   1123: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1126: getfield 347	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mReceivedBytes	J
    //   1129: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1132: ldc_w 386
    //   1135: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: iload_3
    //   1139: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1142: ldc_w 388
    //   1145: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: aload_0
    //   1149: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1152: invokevirtual 259	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   1155: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1158: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1161: astore_1
    //   1162: ldc 8
    //   1164: aload_1
    //   1165: invokestatic 278	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1168: new 139	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   1171: dup
    //   1172: sipush 710
    //   1175: aload_1
    //   1176: invokespecial 144	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/String;)V
    //   1179: athrow
    //   1180: aload_0
    //   1181: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1184: iload_3
    //   1185: i2l
    //   1186: invokevirtual 395	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:updateReceivedSize	(J)V
    //   1189: lload 4
    //   1191: iload_3
    //   1192: i2l
    //   1193: ladd
    //   1194: lstore 4
    //   1196: goto -918 -> 278
    //   1199: ldc 8
    //   1201: new 84	java/lang/StringBuilder
    //   1204: dup
    //   1205: ldc_w 397
    //   1208: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1211: iload_3
    //   1212: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1215: ldc_w 399
    //   1218: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: aload_0
    //   1222: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1225: getfield 347	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mReceivedBytes	J
    //   1228: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1231: ldc_w 401
    //   1234: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: aload_0
    //   1238: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1241: invokevirtual 259	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   1244: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1247: ldc_w 403
    //   1250: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1256: invokestatic 278	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1259: new 139	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   1262: dup
    //   1263: sipush 703
    //   1266: ldc_w 405
    //   1269: invokespecial 144	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/String;)V
    //   1272: athrow
    //   1273: astore_1
    //   1274: goto -328 -> 946
    //   1277: astore_1
    //   1278: goto -299 -> 979
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1281	0	this	DownloadTask
    //   0	1281	1	paramHttpResponse	HttpResponse
    //   0	1281	2	paramDownloadChunkLogInfo	DownloadChunkLogInfo
    //   286	926	3	i	int
    //   233	962	4	l1	long
    //   229	734	6	l2	long
    //   808	200	8	bool	boolean
    //   6	230	9	localHttpEntity	HttpEntity
    //   354	280	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   462	663	663	java/lang/Throwable
    //   698	725	663	java/lang/Throwable
    //   725	747	663	java/lang/Throwable
    //   462	663	676	finally
    //   664	676	676	finally
    //   698	725	676	finally
    //   725	747	676	finally
    //   278	287	941	java/net/SocketException
    //   291	302	941	java/net/SocketException
    //   769	807	941	java/net/SocketException
    //   810	941	941	java/net/SocketException
    //   1012	1096	941	java/net/SocketException
    //   1096	1180	941	java/net/SocketException
    //   1180	1189	941	java/net/SocketException
    //   1199	1273	941	java/net/SocketException
    //   235	243	978	finally
    //   247	275	978	finally
    //   950	962	978	finally
    //   966	978	978	finally
    //   235	243	1273	java/net/SocketException
    //   247	275	1273	java/net/SocketException
    //   278	287	1277	finally
    //   291	302	1277	finally
    //   769	807	1277	finally
    //   810	941	1277	finally
    //   1012	1096	1277	finally
    //   1096	1180	1277	finally
    //   1180	1189	1277	finally
    //   1199	1273	1277	finally
  }
  
  private void renameApkFileName(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null) {}
    for (;;)
    {
      return;
      if (this.mDownloadInfo.mContentType.equals("application/vnd.android.package-archive"))
      {
        Object localObject = null;
        paramHttpResponse = paramHttpResponse.getHeaders("Content-Disposition");
        if ((paramHttpResponse != null) && (paramHttpResponse.length > 0))
        {
          paramHttpResponse = paramHttpResponse[0].getValue();
          TMLog.i("_DownloadTask", "headerFileName = " + paramHttpResponse);
          if ((!TextUtils.isEmpty(paramHttpResponse)) && (paramHttpResponse.contains("filename=\"")))
          {
            String str = paramHttpResponse.substring(paramHttpResponse.indexOf("filename=\"") + 10);
            paramHttpResponse = localObject;
            if (!TextUtils.isEmpty(str))
            {
              paramHttpResponse = str.substring(0, str.indexOf("\""));
              TMLog.i("_DownloadTask", "header file Name =" + paramHttpResponse);
            }
          }
        }
        while (!TextUtils.isEmpty(paramHttpResponse))
        {
          paramHttpResponse = DownloadHelper.correctFileName(DownloadHelper.decodeFileName(paramHttpResponse));
          this.mDownloadInfo.mFileName = paramHttpResponse;
          return;
          paramHttpResponse = DownloadHelper.genAPKFileName(this.mDownloadInfo.mRequestURL);
          continue;
          paramHttpResponse = DownloadHelper.genAPKFileName(this.mDownloadInfo.mRequestURL);
        }
      }
    }
  }
  
  private void setExtraHeaderParam(HttpGet paramHttpGet, Map<String, String> paramMap)
  {
    if ((paramHttpGet != null) && (paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        paramHttpGet.addHeader((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  private void setRangeHeader(HttpGet paramHttpGet, DownloadChunkLogInfo paramDownloadChunkLogInfo)
  {
    String str = DownloadHelper.getNetStatus();
    this.mDownloadInfo.mNetType = str;
    if ((!TextUtils.isEmpty(str)) && ((str.contains("wap")) || ((str.contains("net")) && (this.mDownloadInfo.mRetryCnt > 0)))) {
      try
      {
        int i = DownloadSetting.getSplitSizeInBytes(str);
        long l3 = this.mDownloadInfo.mReceivedBytes;
        if (this.mDownloadInfo.getTotalSize() > 0L)
        {
          long l2 = this.mDownloadInfo.mReceivedBytes + i - 1L;
          l1 = l2;
          if (l2 < this.mDownloadInfo.getTotalSize()) {}
        }
        for (long l1 = this.mDownloadInfo.getTotalSize() - 1L;; l1 = i - 1)
        {
          str = "bytes=" + l3 + "-" + l1;
          paramHttpGet.addHeader("range", str);
          TMLog.d("_DownloadTask", "set range header: " + str);
          paramDownloadChunkLogInfo.responseContentLength = this.mDownloadInfo.getTotalSize();
          paramDownloadChunkLogInfo.requestRanagePosition = l3;
          paramDownloadChunkLogInfo.requestRanageSize = i;
          return;
        }
        str = "bytes=" + this.mDownloadInfo.mReceivedBytes + "-";
      }
      catch (UnsupportedOperationException paramHttpGet)
      {
        y.printErrStackTrace("_DownloadTask", paramHttpGet, "", new Object[0]);
        return;
      }
    }
    paramHttpGet.addHeader("range", str);
    TMLog.d("_DownloadTask", "set range header: " + str);
    paramDownloadChunkLogInfo.responseContentLength = this.mDownloadInfo.getTotalSize();
    paramDownloadChunkLogInfo.requestRanagePosition = this.mDownloadInfo.mReceivedBytes;
    paramDownloadChunkLogInfo.requestRanageSize = 0L;
  }
  
  private boolean shouldRetryConnect()
  {
    boolean bool2 = false;
    if (this.mStopTask)
    {
      TMLog.i("_DownloadTask", "mStopTask = " + this.mStopTask);
      return false;
    }
    try
    {
      Thread.sleep(5000L);
      label42:
      if (!DownloadHelper.isNetworkConncted())
      {
        int i = 0;
        for (;;)
        {
          if ((!DownloadHelper.isNetworkConncted()) && (i < 5))
          {
            i += 1;
            try
            {
              Thread.sleep(10000L);
            }
            catch (InterruptedException localInterruptedException1)
            {
              this.mDownloadInfo.mDownloadFailedErrCode = 600;
            }
          }
        }
      }
      if (!DownloadHelper.isNetworkConncted())
      {
        TMLog.i("_DownloadTask", "network unconnected");
        return false;
      }
      if ((!DownloadHelper.getNetStatus().equalsIgnoreCase("wifi")) && (!DownloadHelper.getNetStatus().equalsIgnoreCase(this.startDownloadNetType)))
      {
        TMLog.i("_DownloadTask", "not equal netType, current: " + DownloadHelper.getNetStatus() + ", startNetType: " + this.startDownloadNetType);
        return false;
      }
      bool1 = bool2;
      if (this.mDownloadInfo.hasRetryChance())
      {
        DownloadInfo localDownloadInfo = this.mDownloadInfo;
        localDownloadInfo.mRetryCnt += 1;
        this.mDownloadInfo.mRedirectCnt = 0;
      }
      try
      {
        Thread.sleep(5000L);
        bool1 = true;
      }
      catch (InterruptedException localInterruptedException2)
      {
        for (;;)
        {
          this.mDownloadInfo.mDownloadFailedErrCode = 600;
          bool1 = bool2;
        }
      }
      TMLog.i("_DownloadTask", "shouldRetryConnect(" + bool1 + "), retryCnt = " + this.mDownloadInfo.mRetryCnt);
      return bool1;
    }
    catch (InterruptedException localInterruptedException3)
    {
      boolean bool1;
      break label42;
    }
  }
  
  private boolean verifyTotalLen(HttpResponse paramHttpResponse, HttpEntity paramHttpEntity)
  {
    long l;
    if (paramHttpResponse.getStatusLine().getStatusCode() == 200)
    {
      l = paramHttpEntity.getContentLength();
      TMLog.i("_DownloadTask", "verifyTotalLen,totalLen = " + l + "mRequestFileSize = " + this.mDownloadInfo.mRequestFileSize);
      if ((l != -1L) && ((this.mDownloadInfo.mRequestFileSize.longValue() <= 0L) || (l == this.mDownloadInfo.mRequestFileSize.longValue()))) {}
    }
    else
    {
      do
      {
        return false;
        if (paramHttpResponse.getStatusLine().getStatusCode() != 206) {
          break;
        }
        l = ByteRange.getTotalSize(paramHttpResponse.getFirstHeader("content-range").getValue());
        TMLog.i("_DownloadTask", "verifyTotalLen,totalLen = " + l + "mRequestFileSize = " + this.mDownloadInfo.mRequestFileSize);
      } while ((l == -1L) || ((this.mDownloadInfo.mRequestFileSize.longValue() > 0L) && (l != this.mDownloadInfo.mRequestFileSize.longValue())));
    }
    return true;
  }
  
  public void cancel()
  {
    TMLog.i("_DownloadTask", "DownloadTask::cancel url: " + this.mDownloadInfo.mURL);
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      l.post(new DownloadTask.1(this));
      return;
    }
    cancelInWorkThread();
  }
  
  /* Error */
  public void exec(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 488	com/tencent/tmassistantsdk/downloadservice/DownloadHelper:getNetStatus	()Ljava/lang/String;
    //   4: putfield 52	com/tencent/tmassistantsdk/downloadservice/DownloadTask:startDownloadNetType	Ljava/lang/String;
    //   7: aload_0
    //   8: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   11: iconst_1
    //   12: putfield 608	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mTaskIsRunning	Z
    //   15: aload_0
    //   16: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   19: iconst_2
    //   20: iconst_0
    //   21: invokevirtual 612	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:updateStatus	(IZ)V
    //   24: iconst_0
    //   25: istore_3
    //   26: iconst_1
    //   27: istore_2
    //   28: iload_2
    //   29: ifeq +1973 -> 2002
    //   32: invokestatic 618	com/tencent/tmassistantsdk/logreport/DownloadReportManager:getInstance	()Lcom/tencent/tmassistantsdk/logreport/DownloadReportManager;
    //   35: iconst_0
    //   36: invokevirtual 622	com/tencent/tmassistantsdk/logreport/DownloadReportManager:createNewChunkLogInfo	(B)Lcom/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo;
    //   39: astore 5
    //   41: aload 5
    //   43: aload_0
    //   44: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   47: getfield 625	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mUUID	Ljava/lang/String;
    //   50: putfield 628	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:UUID	Ljava/lang/String;
    //   53: aload 5
    //   55: aload_0
    //   56: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   59: getfield 137	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mRetryCnt	I
    //   62: i2b
    //   63: putfield 632	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:currentRetryCnt	B
    //   66: aload 5
    //   68: aload_0
    //   69: invokevirtual 635	com/tencent/tmassistantsdk/downloadservice/DownloadTask:getDownloadURI	()Ljava/lang/String;
    //   72: putfield 638	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:requestUrl	Ljava/lang/String;
    //   75: aload_0
    //   76: getfield 32	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   79: ifne +1923 -> 2002
    //   82: aload_0
    //   83: getfield 54	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mIsRedirect	Z
    //   86: ifeq +20 -> 106
    //   89: aload_0
    //   90: getfield 221	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mRequestUrl	Ljava/lang/String;
    //   93: ifnull +13 -> 106
    //   96: aload_0
    //   97: getfield 221	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mRequestUrl	Ljava/lang/String;
    //   100: invokevirtual 641	java/lang/String:length	()I
    //   103: ifne +404 -> 507
    //   106: iload_3
    //   107: ifeq +389 -> 496
    //   110: aload_0
    //   111: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   114: getfield 644	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mSecondaryUrl	Ljava/lang/String;
    //   117: astore_1
    //   118: aload_0
    //   119: aload_1
    //   120: putfield 221	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mRequestUrl	Ljava/lang/String;
    //   123: ldc 8
    //   125: new 84	java/lang/StringBuilder
    //   128: dup
    //   129: ldc_w 646
    //   132: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload_0
    //   136: getfield 54	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mIsRedirect	Z
    //   139: invokevirtual 522	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   142: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: ldc 8
    //   150: new 84	java/lang/StringBuilder
    //   153: dup
    //   154: ldc_w 648
    //   157: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   160: iload_3
    //   161: invokevirtual 522	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   164: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: ldc 8
    //   172: new 84	java/lang/StringBuilder
    //   175: dup
    //   176: ldc_w 650
    //   179: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: aload_1
    //   183: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload_0
    //   193: iconst_0
    //   194: putfield 54	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mIsRedirect	Z
    //   197: aload_0
    //   198: invokestatic 656	com/tencent/tmassistantsdk/downloadservice/HttpClientUtil:createHttpClient	()Lorg/apache/http/client/HttpClient;
    //   201: putfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   204: aload_0
    //   205: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   208: invokestatic 660	com/tencent/tmassistantsdk/downloadservice/HttpClientUtil:setProxy	(Lorg/apache/http/client/HttpClient;)V
    //   211: aload_0
    //   212: new 62	org/apache/http/client/methods/HttpGet
    //   215: dup
    //   216: invokespecial 661	org/apache/http/client/methods/HttpGet:<init>	()V
    //   219: putfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   222: new 663	java/net/URI
    //   225: dup
    //   226: aload_1
    //   227: invokespecial 664	java/net/URI:<init>	(Ljava/lang/String;)V
    //   230: astore_1
    //   231: aload_0
    //   232: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   235: aload_1
    //   236: invokevirtual 668	org/apache/http/client/methods/HttpGet:setURI	(Ljava/net/URI;)V
    //   239: aload_0
    //   240: aload_0
    //   241: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   244: aload_0
    //   245: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   248: invokevirtual 672	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getHeaderParams	()Ljava/util/HashMap;
    //   251: invokespecial 674	com/tencent/tmassistantsdk/downloadservice/DownloadTask:setExtraHeaderParam	(Lorg/apache/http/client/methods/HttpGet;Ljava/util/Map;)V
    //   254: aload_0
    //   255: aload_0
    //   256: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   259: aload 5
    //   261: invokespecial 676	com/tencent/tmassistantsdk/downloadservice/DownloadTask:setRangeHeader	(Lorg/apache/http/client/methods/HttpGet;Lcom/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo;)V
    //   264: aload_1
    //   265: invokevirtual 679	java/net/URI:getScheme	()Ljava/lang/String;
    //   268: ldc_w 681
    //   271: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   274: ifeq +48 -> 322
    //   277: invokestatic 687	org/apache/http/conn/ssl/SSLSocketFactory:getSocketFactory	()Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   280: astore_1
    //   281: aload_1
    //   282: getstatic 691	org/apache/http/conn/ssl/SSLSocketFactory:BROWSER_COMPATIBLE_HOSTNAME_VERIFIER	Lorg/apache/http/conn/ssl/X509HostnameVerifier;
    //   285: invokevirtual 695	org/apache/http/conn/ssl/SSLSocketFactory:setHostnameVerifier	(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V
    //   288: new 697	org/apache/http/conn/scheme/Scheme
    //   291: dup
    //   292: ldc_w 681
    //   295: aload_1
    //   296: sipush 443
    //   299: invokespecial 700	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   302: astore_1
    //   303: aload_0
    //   304: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   307: invokeinterface 706 1 0
    //   312: invokeinterface 712 1 0
    //   317: aload_1
    //   318: invokevirtual 718	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   321: pop
    //   322: ldc 8
    //   324: new 84	java/lang/StringBuilder
    //   327: dup
    //   328: ldc_w 720
    //   331: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   334: invokestatic 104	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   337: invokevirtual 108	java/lang/Thread:getName	()Ljava/lang/String;
    //   340: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   349: aload_0
    //   350: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   353: aload_0
    //   354: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   357: invokeinterface 724 2 0
    //   362: astore_1
    //   363: aload_1
    //   364: ifnonnull +151 -> 515
    //   367: new 139	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   370: dup
    //   371: sipush 701
    //   374: new 84	java/lang/StringBuilder
    //   377: dup
    //   378: ldc_w 726
    //   381: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   384: invokestatic 104	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   387: invokevirtual 108	java/lang/Thread:getName	()Ljava/lang/String;
    //   390: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokespecial 144	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/String;)V
    //   399: athrow
    //   400: astore_1
    //   401: aload_0
    //   402: getfield 32	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   405: istore_2
    //   406: iload_2
    //   407: ifeq +219 -> 626
    //   410: iconst_0
    //   411: istore 4
    //   413: aload_0
    //   414: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   417: ifnull +25 -> 442
    //   420: aload_0
    //   421: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   424: invokevirtual 66	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   427: ifne +10 -> 437
    //   430: aload_0
    //   431: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   434: invokevirtual 69	org/apache/http/client/methods/HttpGet:abort	()V
    //   437: aload_0
    //   438: aconst_null
    //   439: putfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   442: aload_0
    //   443: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   446: ifnull +22 -> 468
    //   449: aload_0
    //   450: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   453: invokeinterface 706 1 0
    //   458: invokeinterface 729 1 0
    //   463: aload_0
    //   464: aconst_null
    //   465: putfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   468: iload 4
    //   470: istore_2
    //   471: aload_0
    //   472: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   475: ifnull +1683 -> 2158
    //   478: aload_0
    //   479: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   482: invokevirtual 326	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   485: aload_0
    //   486: aconst_null
    //   487: putfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   490: iload 4
    //   492: istore_2
    //   493: goto -465 -> 28
    //   496: aload_0
    //   497: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   500: getfield 440	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mRequestURL	Ljava/lang/String;
    //   503: astore_1
    //   504: goto -386 -> 118
    //   507: aload_0
    //   508: getfield 221	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mRequestUrl	Ljava/lang/String;
    //   511: astore_1
    //   512: goto -389 -> 123
    //   515: aload_0
    //   516: aload_1
    //   517: aload 5
    //   519: invokespecial 731	com/tencent/tmassistantsdk/downloadservice/DownloadTask:handleResponseCode	(Lorg/apache/http/HttpResponse;Lcom/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo;)V
    //   522: aload_0
    //   523: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   526: invokevirtual 734	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:hasReceivedAllDataBytes	()Z
    //   529: istore_2
    //   530: iload_2
    //   531: ifne +89 -> 620
    //   534: iconst_1
    //   535: istore 4
    //   537: aload_0
    //   538: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   541: ifnull +25 -> 566
    //   544: aload_0
    //   545: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   548: invokevirtual 66	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   551: ifne +10 -> 561
    //   554: aload_0
    //   555: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   558: invokevirtual 69	org/apache/http/client/methods/HttpGet:abort	()V
    //   561: aload_0
    //   562: aconst_null
    //   563: putfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   566: aload_0
    //   567: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   570: ifnull +22 -> 592
    //   573: aload_0
    //   574: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   577: invokeinterface 706 1 0
    //   582: invokeinterface 729 1 0
    //   587: aload_0
    //   588: aconst_null
    //   589: putfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   592: iload 4
    //   594: istore_2
    //   595: aload_0
    //   596: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   599: ifnull +1559 -> 2158
    //   602: aload_0
    //   603: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   606: invokevirtual 326	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   609: aload_0
    //   610: aconst_null
    //   611: putfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   614: iload 4
    //   616: istore_2
    //   617: goto -589 -> 28
    //   620: iconst_0
    //   621: istore 4
    //   623: goto -86 -> 537
    //   626: ldc 8
    //   628: new 84	java/lang/StringBuilder
    //   631: dup
    //   632: ldc_w 736
    //   635: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   638: invokestatic 104	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   641: invokevirtual 108	java/lang/Thread:getName	()Ljava/lang/String;
    //   644: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   653: ldc 8
    //   655: aload_1
    //   656: ldc 234
    //   658: iconst_0
    //   659: anewarray 4	java/lang/Object
    //   662: invokestatic 240	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   665: aload_0
    //   666: invokespecial 738	com/tencent/tmassistantsdk/downloadservice/DownloadTask:shouldRetryConnect	()Z
    //   669: istore_2
    //   670: iload_2
    //   671: istore 4
    //   673: iload_2
    //   674: ifne -261 -> 413
    //   677: aload_0
    //   678: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   681: sipush 601
    //   684: putfield 535	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   687: iload_2
    //   688: istore 4
    //   690: goto -277 -> 413
    //   693: astore_1
    //   694: aload_0
    //   695: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   698: ifnull +25 -> 723
    //   701: aload_0
    //   702: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   705: invokevirtual 66	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   708: ifne +10 -> 718
    //   711: aload_0
    //   712: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   715: invokevirtual 69	org/apache/http/client/methods/HttpGet:abort	()V
    //   718: aload_0
    //   719: aconst_null
    //   720: putfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   723: aload_0
    //   724: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   727: ifnull +22 -> 749
    //   730: aload_0
    //   731: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   734: invokeinterface 706 1 0
    //   739: invokeinterface 729 1 0
    //   744: aload_0
    //   745: aconst_null
    //   746: putfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   749: aload_0
    //   750: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   753: ifnull +15 -> 768
    //   756: aload_0
    //   757: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   760: invokevirtual 326	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   763: aload_0
    //   764: aconst_null
    //   765: putfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   768: aload_1
    //   769: athrow
    //   770: astore_1
    //   771: aload_0
    //   772: getfield 32	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   775: istore_2
    //   776: iload_2
    //   777: ifeq +89 -> 866
    //   780: iconst_0
    //   781: istore 4
    //   783: aload_0
    //   784: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   787: ifnull +25 -> 812
    //   790: aload_0
    //   791: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   794: invokevirtual 66	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   797: ifne +10 -> 807
    //   800: aload_0
    //   801: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   804: invokevirtual 69	org/apache/http/client/methods/HttpGet:abort	()V
    //   807: aload_0
    //   808: aconst_null
    //   809: putfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   812: aload_0
    //   813: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   816: ifnull +22 -> 838
    //   819: aload_0
    //   820: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   823: invokeinterface 706 1 0
    //   828: invokeinterface 729 1 0
    //   833: aload_0
    //   834: aconst_null
    //   835: putfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   838: iload 4
    //   840: istore_2
    //   841: aload_0
    //   842: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   845: ifnull +1313 -> 2158
    //   848: aload_0
    //   849: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   852: invokevirtual 326	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   855: aload_0
    //   856: aconst_null
    //   857: putfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   860: iload 4
    //   862: istore_2
    //   863: goto -835 -> 28
    //   866: ldc 8
    //   868: new 84	java/lang/StringBuilder
    //   871: dup
    //   872: ldc_w 740
    //   875: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   878: invokestatic 104	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   881: invokevirtual 108	java/lang/Thread:getName	()Ljava/lang/String;
    //   884: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   893: ldc 8
    //   895: aload_1
    //   896: ldc 234
    //   898: iconst_0
    //   899: anewarray 4	java/lang/Object
    //   902: invokestatic 240	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   905: aload_0
    //   906: invokespecial 738	com/tencent/tmassistantsdk/downloadservice/DownloadTask:shouldRetryConnect	()Z
    //   909: istore_2
    //   910: iload_2
    //   911: istore 4
    //   913: iload_2
    //   914: ifne -131 -> 783
    //   917: aload_0
    //   918: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   921: sipush 602
    //   924: putfield 535	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   927: iload_2
    //   928: istore 4
    //   930: goto -147 -> 783
    //   933: astore_1
    //   934: aload_0
    //   935: getfield 32	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   938: istore_2
    //   939: iload_2
    //   940: ifeq +89 -> 1029
    //   943: iconst_0
    //   944: istore 4
    //   946: aload_0
    //   947: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   950: ifnull +25 -> 975
    //   953: aload_0
    //   954: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   957: invokevirtual 66	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   960: ifne +10 -> 970
    //   963: aload_0
    //   964: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   967: invokevirtual 69	org/apache/http/client/methods/HttpGet:abort	()V
    //   970: aload_0
    //   971: aconst_null
    //   972: putfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   975: aload_0
    //   976: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   979: ifnull +22 -> 1001
    //   982: aload_0
    //   983: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   986: invokeinterface 706 1 0
    //   991: invokeinterface 729 1 0
    //   996: aload_0
    //   997: aconst_null
    //   998: putfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1001: iload 4
    //   1003: istore_2
    //   1004: aload_0
    //   1005: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1008: ifnull +1150 -> 2158
    //   1011: aload_0
    //   1012: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1015: invokevirtual 326	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   1018: aload_0
    //   1019: aconst_null
    //   1020: putfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1023: iload 4
    //   1025: istore_2
    //   1026: goto -998 -> 28
    //   1029: ldc 8
    //   1031: new 84	java/lang/StringBuilder
    //   1034: dup
    //   1035: ldc_w 742
    //   1038: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1041: invokestatic 104	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1044: invokevirtual 108	java/lang/Thread:getName	()Ljava/lang/String;
    //   1047: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1053: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1056: ldc 8
    //   1058: aload_1
    //   1059: ldc 234
    //   1061: iconst_0
    //   1062: anewarray 4	java/lang/Object
    //   1065: invokestatic 240	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1068: aload_0
    //   1069: invokespecial 738	com/tencent/tmassistantsdk/downloadservice/DownloadTask:shouldRetryConnect	()Z
    //   1072: istore_2
    //   1073: iload_2
    //   1074: istore 4
    //   1076: iload_2
    //   1077: ifne -131 -> 946
    //   1080: aload_0
    //   1081: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1084: sipush 603
    //   1087: putfield 535	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   1090: iload_2
    //   1091: istore 4
    //   1093: goto -147 -> 946
    //   1096: astore_1
    //   1097: aload_0
    //   1098: getfield 32	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   1101: istore_2
    //   1102: iload_2
    //   1103: ifeq +82 -> 1185
    //   1106: aload_0
    //   1107: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1110: ifnull +25 -> 1135
    //   1113: aload_0
    //   1114: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1117: invokevirtual 66	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   1120: ifne +10 -> 1130
    //   1123: aload_0
    //   1124: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1127: invokevirtual 69	org/apache/http/client/methods/HttpGet:abort	()V
    //   1130: aload_0
    //   1131: aconst_null
    //   1132: putfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1135: aload_0
    //   1136: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1139: ifnull +22 -> 1161
    //   1142: aload_0
    //   1143: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1146: invokeinterface 706 1 0
    //   1151: invokeinterface 729 1 0
    //   1156: aload_0
    //   1157: aconst_null
    //   1158: putfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1161: aload_0
    //   1162: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1165: ifnull +1004 -> 2169
    //   1168: aload_0
    //   1169: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1172: invokevirtual 326	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   1175: aload_0
    //   1176: aconst_null
    //   1177: putfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1180: iconst_0
    //   1181: istore_2
    //   1182: goto -1154 -> 28
    //   1185: ldc 8
    //   1187: new 84	java/lang/StringBuilder
    //   1190: dup
    //   1191: ldc_w 744
    //   1194: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1197: invokestatic 104	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1200: invokevirtual 108	java/lang/Thread:getName	()Ljava/lang/String;
    //   1203: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1209: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1212: ldc 8
    //   1214: aload_1
    //   1215: ldc 234
    //   1217: iconst_0
    //   1218: anewarray 4	java/lang/Object
    //   1221: invokestatic 240	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1224: aload_0
    //   1225: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1228: sipush 600
    //   1231: putfield 535	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   1234: goto -128 -> 1106
    //   1237: astore_1
    //   1238: aload_0
    //   1239: getfield 32	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   1242: istore_2
    //   1243: iload_2
    //   1244: ifeq +82 -> 1326
    //   1247: aload_0
    //   1248: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1251: ifnull +25 -> 1276
    //   1254: aload_0
    //   1255: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1258: invokevirtual 66	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   1261: ifne +10 -> 1271
    //   1264: aload_0
    //   1265: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1268: invokevirtual 69	org/apache/http/client/methods/HttpGet:abort	()V
    //   1271: aload_0
    //   1272: aconst_null
    //   1273: putfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1276: aload_0
    //   1277: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1280: ifnull +22 -> 1302
    //   1283: aload_0
    //   1284: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1287: invokeinterface 706 1 0
    //   1292: invokeinterface 729 1 0
    //   1297: aload_0
    //   1298: aconst_null
    //   1299: putfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1302: aload_0
    //   1303: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1306: ifnull +863 -> 2169
    //   1309: aload_0
    //   1310: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1313: invokevirtual 326	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   1316: aload_0
    //   1317: aconst_null
    //   1318: putfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1321: iconst_0
    //   1322: istore_2
    //   1323: goto -1295 -> 28
    //   1326: ldc 8
    //   1328: new 84	java/lang/StringBuilder
    //   1331: dup
    //   1332: ldc_w 746
    //   1335: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1338: invokestatic 104	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1341: invokevirtual 108	java/lang/Thread:getName	()Ljava/lang/String;
    //   1344: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1347: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1350: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1353: ldc 8
    //   1355: aload_1
    //   1356: ldc 234
    //   1358: iconst_0
    //   1359: anewarray 4	java/lang/Object
    //   1362: invokestatic 240	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1365: aload_0
    //   1366: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1369: sipush 607
    //   1372: putfield 535	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   1375: goto -128 -> 1247
    //   1378: astore_1
    //   1379: aload_0
    //   1380: getfield 32	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   1383: istore_2
    //   1384: iload_2
    //   1385: ifeq +89 -> 1474
    //   1388: iconst_0
    //   1389: istore 4
    //   1391: aload_0
    //   1392: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1395: ifnull +25 -> 1420
    //   1398: aload_0
    //   1399: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1402: invokevirtual 66	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   1405: ifne +10 -> 1415
    //   1408: aload_0
    //   1409: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1412: invokevirtual 69	org/apache/http/client/methods/HttpGet:abort	()V
    //   1415: aload_0
    //   1416: aconst_null
    //   1417: putfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1420: aload_0
    //   1421: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1424: ifnull +22 -> 1446
    //   1427: aload_0
    //   1428: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1431: invokeinterface 706 1 0
    //   1436: invokeinterface 729 1 0
    //   1441: aload_0
    //   1442: aconst_null
    //   1443: putfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1446: iload 4
    //   1448: istore_2
    //   1449: aload_0
    //   1450: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1453: ifnull +705 -> 2158
    //   1456: aload_0
    //   1457: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1460: invokevirtual 326	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   1463: aload_0
    //   1464: aconst_null
    //   1465: putfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1468: iload 4
    //   1470: istore_2
    //   1471: goto -1443 -> 28
    //   1474: ldc 8
    //   1476: new 84	java/lang/StringBuilder
    //   1479: dup
    //   1480: ldc_w 748
    //   1483: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1486: invokestatic 104	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1489: invokevirtual 108	java/lang/Thread:getName	()Ljava/lang/String;
    //   1492: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1498: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1501: ldc 8
    //   1503: aload_1
    //   1504: ldc 234
    //   1506: iconst_0
    //   1507: anewarray 4	java/lang/Object
    //   1510: invokestatic 240	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1513: aload_0
    //   1514: invokespecial 738	com/tencent/tmassistantsdk/downloadservice/DownloadTask:shouldRetryConnect	()Z
    //   1517: istore_2
    //   1518: iload_2
    //   1519: istore 4
    //   1521: iload_2
    //   1522: ifne -131 -> 1391
    //   1525: aload_0
    //   1526: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1529: sipush 606
    //   1532: putfield 535	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   1535: iload_2
    //   1536: istore 4
    //   1538: goto -147 -> 1391
    //   1541: astore_1
    //   1542: aload_0
    //   1543: getfield 32	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   1546: istore_2
    //   1547: iload_2
    //   1548: ifeq +90 -> 1638
    //   1551: iload_3
    //   1552: istore_2
    //   1553: iconst_0
    //   1554: istore 4
    //   1556: aload_0
    //   1557: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1560: ifnull +25 -> 1585
    //   1563: aload_0
    //   1564: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1567: invokevirtual 66	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   1570: ifne +10 -> 1580
    //   1573: aload_0
    //   1574: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1577: invokevirtual 69	org/apache/http/client/methods/HttpGet:abort	()V
    //   1580: aload_0
    //   1581: aconst_null
    //   1582: putfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1585: aload_0
    //   1586: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1589: ifnull +22 -> 1611
    //   1592: aload_0
    //   1593: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1596: invokeinterface 706 1 0
    //   1601: invokeinterface 729 1 0
    //   1606: aload_0
    //   1607: aconst_null
    //   1608: putfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1611: aload_0
    //   1612: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1615: ifnull +546 -> 2161
    //   1618: aload_0
    //   1619: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1622: invokevirtual 326	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   1625: aload_0
    //   1626: aconst_null
    //   1627: putfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1630: iload_2
    //   1631: istore_3
    //   1632: iload 4
    //   1634: istore_2
    //   1635: goto -1607 -> 28
    //   1638: ldc 8
    //   1640: new 84	java/lang/StringBuilder
    //   1643: dup
    //   1644: ldc_w 750
    //   1647: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1650: aload_1
    //   1651: getfield 753	com/tencent/tmassistantsdk/downloadservice/StopRequestException:mFinalErrCode	I
    //   1654: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1657: ldc 95
    //   1659: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1662: invokestatic 104	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1665: invokevirtual 108	java/lang/Thread:getName	()Ljava/lang/String;
    //   1668: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1671: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1674: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1677: ldc 8
    //   1679: aload_1
    //   1680: ldc 234
    //   1682: iconst_0
    //   1683: anewarray 4	java/lang/Object
    //   1686: invokestatic 240	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1689: aload_0
    //   1690: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1693: aload_1
    //   1694: getfield 753	com/tencent/tmassistantsdk/downloadservice/StopRequestException:mFinalErrCode	I
    //   1697: putfield 535	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   1700: aload_1
    //   1701: getfield 753	com/tencent/tmassistantsdk/downloadservice/StopRequestException:mFinalErrCode	I
    //   1704: sipush 703
    //   1707: if_icmpeq +467 -> 2174
    //   1710: aload_1
    //   1711: getfield 753	com/tencent/tmassistantsdk/downloadservice/StopRequestException:mFinalErrCode	I
    //   1714: sipush 710
    //   1717: if_icmpeq +457 -> 2174
    //   1720: aload_1
    //   1721: getfield 753	com/tencent/tmassistantsdk/downloadservice/StopRequestException:mFinalErrCode	I
    //   1724: sipush 711
    //   1727: if_icmpne +6 -> 1733
    //   1730: goto +444 -> 2174
    //   1733: sipush 704
    //   1736: aload_1
    //   1737: getfield 753	com/tencent/tmassistantsdk/downloadservice/StopRequestException:mFinalErrCode	I
    //   1740: if_icmpne +43 -> 1783
    //   1743: aload_0
    //   1744: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1747: lconst_0
    //   1748: invokevirtual 268	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:setTotalSize	(J)V
    //   1751: new 305	com/tencent/tmassistantsdk/storage/TMAssistantFile
    //   1754: dup
    //   1755: aload_0
    //   1756: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1759: getfield 308	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mTempFileName	Ljava/lang/String;
    //   1762: aload_0
    //   1763: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1766: getfield 164	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mFileName	Ljava/lang/String;
    //   1769: invokespecial 310	com/tencent/tmassistantsdk/storage/TMAssistantFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1772: invokevirtual 756	com/tencent/tmassistantsdk/storage/TMAssistantFile:deleteTempFile	()V
    //   1775: iload_3
    //   1776: istore_2
    //   1777: iconst_0
    //   1778: istore 4
    //   1780: goto -224 -> 1556
    //   1783: sipush 705
    //   1786: aload_1
    //   1787: getfield 753	com/tencent/tmassistantsdk/downloadservice/StopRequestException:mFinalErrCode	I
    //   1790: if_icmpne +38 -> 1828
    //   1793: iload_3
    //   1794: ifne +388 -> 2182
    //   1797: aload_0
    //   1798: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1801: invokevirtual 547	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:hasRetryChance	()Z
    //   1804: ifeq +378 -> 2182
    //   1807: aload_0
    //   1808: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1811: getfield 644	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mSecondaryUrl	Ljava/lang/String;
    //   1814: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1817: ifne +365 -> 2182
    //   1820: iconst_1
    //   1821: istore_2
    //   1822: iconst_1
    //   1823: istore 4
    //   1825: goto -269 -> 1556
    //   1828: aload_0
    //   1829: invokespecial 738	com/tencent/tmassistantsdk/downloadservice/DownloadTask:shouldRetryConnect	()Z
    //   1832: istore 4
    //   1834: iload_3
    //   1835: istore_2
    //   1836: goto -280 -> 1556
    //   1839: astore_1
    //   1840: aload_0
    //   1841: getfield 32	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   1844: istore_2
    //   1845: iload_2
    //   1846: ifeq +89 -> 1935
    //   1849: iconst_0
    //   1850: istore 4
    //   1852: aload_0
    //   1853: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1856: ifnull +25 -> 1881
    //   1859: aload_0
    //   1860: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1863: invokevirtual 66	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   1866: ifne +10 -> 1876
    //   1869: aload_0
    //   1870: getfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1873: invokevirtual 69	org/apache/http/client/methods/HttpGet:abort	()V
    //   1876: aload_0
    //   1877: aconst_null
    //   1878: putfield 36	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1881: aload_0
    //   1882: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1885: ifnull +22 -> 1907
    //   1888: aload_0
    //   1889: getfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1892: invokeinterface 706 1 0
    //   1897: invokeinterface 729 1 0
    //   1902: aload_0
    //   1903: aconst_null
    //   1904: putfield 34	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1907: iload 4
    //   1909: istore_2
    //   1910: aload_0
    //   1911: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1914: ifnull +244 -> 2158
    //   1917: aload_0
    //   1918: getfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1921: invokevirtual 326	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   1924: aload_0
    //   1925: aconst_null
    //   1926: putfield 303	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1929: iload 4
    //   1931: istore_2
    //   1932: goto -1904 -> 28
    //   1935: ldc 8
    //   1937: new 84	java/lang/StringBuilder
    //   1940: dup
    //   1941: ldc_w 758
    //   1944: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1947: invokestatic 104	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1950: invokevirtual 108	java/lang/Thread:getName	()Ljava/lang/String;
    //   1953: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1956: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1959: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1962: ldc 8
    //   1964: aload_1
    //   1965: ldc 234
    //   1967: iconst_0
    //   1968: anewarray 4	java/lang/Object
    //   1971: invokestatic 240	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1974: aload_0
    //   1975: invokespecial 738	com/tencent/tmassistantsdk/downloadservice/DownloadTask:shouldRetryConnect	()Z
    //   1978: istore_2
    //   1979: iload_2
    //   1980: istore 4
    //   1982: iload_2
    //   1983: ifne -131 -> 1852
    //   1986: aload_0
    //   1987: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1990: sipush 604
    //   1993: putfield 535	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   1996: iload_2
    //   1997: istore 4
    //   1999: goto -147 -> 1852
    //   2002: ldc 8
    //   2004: new 84	java/lang/StringBuilder
    //   2007: dup
    //   2008: ldc_w 519
    //   2011: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2014: aload_0
    //   2015: getfield 32	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   2018: invokevirtual 522	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2021: ldc 95
    //   2023: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2026: invokestatic 104	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2029: invokevirtual 108	java/lang/Thread:getName	()Ljava/lang/String;
    //   2032: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2035: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2038: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2041: aload_0
    //   2042: getfield 32	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   2045: ifne +102 -> 2147
    //   2048: ldc 8
    //   2050: new 84	java/lang/StringBuilder
    //   2053: dup
    //   2054: ldc_w 760
    //   2057: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2060: invokestatic 104	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2063: invokevirtual 108	java/lang/Thread:getName	()Ljava/lang/String;
    //   2066: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2069: ldc_w 762
    //   2072: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2075: aload_0
    //   2076: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   2079: getfield 765	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mStatus	I
    //   2082: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2085: ldc_w 767
    //   2088: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2091: aload_0
    //   2092: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   2095: getfield 535	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   2098: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2101: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2104: invokestatic 117	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2107: aload_0
    //   2108: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   2111: invokevirtual 734	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:hasReceivedAllDataBytes	()Z
    //   2114: ifeq +21 -> 2135
    //   2117: aload_0
    //   2118: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   2121: iconst_4
    //   2122: iload_3
    //   2123: invokevirtual 612	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:updateStatus	(IZ)V
    //   2126: aload_0
    //   2127: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   2130: iconst_0
    //   2131: putfield 608	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mTaskIsRunning	Z
    //   2134: return
    //   2135: aload_0
    //   2136: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   2139: iconst_5
    //   2140: iload_3
    //   2141: invokevirtual 612	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:updateStatus	(IZ)V
    //   2144: goto -18 -> 2126
    //   2147: aload_0
    //   2148: getfield 38	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   2151: iconst_0
    //   2152: putfield 535	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   2155: goto -29 -> 2126
    //   2158: goto -2130 -> 28
    //   2161: iload_2
    //   2162: istore_3
    //   2163: iload 4
    //   2165: istore_2
    //   2166: goto -2138 -> 28
    //   2169: iconst_0
    //   2170: istore_2
    //   2171: goto -2143 -> 28
    //   2174: iload_3
    //   2175: istore_2
    //   2176: iconst_0
    //   2177: istore 4
    //   2179: goto -623 -> 1556
    //   2182: iload_3
    //   2183: istore_2
    //   2184: iconst_0
    //   2185: istore 4
    //   2187: goto -631 -> 1556
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2190	0	this	DownloadTask
    //   0	2190	1	paramString	String
    //   27	2157	2	bool1	boolean
    //   25	2158	3	bool2	boolean
    //   411	1775	4	bool3	boolean
    //   39	479	5	localDownloadChunkLogInfo	DownloadChunkLogInfo
    // Exception table:
    //   from	to	target	type
    //   82	106	400	org/apache/http/conn/ConnectTimeoutException
    //   110	118	400	org/apache/http/conn/ConnectTimeoutException
    //   118	123	400	org/apache/http/conn/ConnectTimeoutException
    //   123	322	400	org/apache/http/conn/ConnectTimeoutException
    //   322	363	400	org/apache/http/conn/ConnectTimeoutException
    //   367	400	400	org/apache/http/conn/ConnectTimeoutException
    //   496	504	400	org/apache/http/conn/ConnectTimeoutException
    //   507	512	400	org/apache/http/conn/ConnectTimeoutException
    //   515	530	400	org/apache/http/conn/ConnectTimeoutException
    //   82	106	693	finally
    //   110	118	693	finally
    //   118	123	693	finally
    //   123	322	693	finally
    //   322	363	693	finally
    //   367	400	693	finally
    //   401	406	693	finally
    //   496	504	693	finally
    //   507	512	693	finally
    //   515	530	693	finally
    //   626	670	693	finally
    //   677	687	693	finally
    //   771	776	693	finally
    //   866	910	693	finally
    //   917	927	693	finally
    //   934	939	693	finally
    //   1029	1073	693	finally
    //   1080	1090	693	finally
    //   1097	1102	693	finally
    //   1185	1234	693	finally
    //   1238	1243	693	finally
    //   1326	1375	693	finally
    //   1379	1384	693	finally
    //   1474	1518	693	finally
    //   1525	1535	693	finally
    //   1542	1547	693	finally
    //   1638	1730	693	finally
    //   1733	1775	693	finally
    //   1783	1793	693	finally
    //   1797	1820	693	finally
    //   1828	1834	693	finally
    //   1840	1845	693	finally
    //   1935	1979	693	finally
    //   1986	1996	693	finally
    //   82	106	770	java/net/SocketTimeoutException
    //   110	118	770	java/net/SocketTimeoutException
    //   118	123	770	java/net/SocketTimeoutException
    //   123	322	770	java/net/SocketTimeoutException
    //   322	363	770	java/net/SocketTimeoutException
    //   367	400	770	java/net/SocketTimeoutException
    //   496	504	770	java/net/SocketTimeoutException
    //   507	512	770	java/net/SocketTimeoutException
    //   515	530	770	java/net/SocketTimeoutException
    //   82	106	933	java/net/UnknownHostException
    //   110	118	933	java/net/UnknownHostException
    //   118	123	933	java/net/UnknownHostException
    //   123	322	933	java/net/UnknownHostException
    //   322	363	933	java/net/UnknownHostException
    //   367	400	933	java/net/UnknownHostException
    //   496	504	933	java/net/UnknownHostException
    //   507	512	933	java/net/UnknownHostException
    //   515	530	933	java/net/UnknownHostException
    //   82	106	1096	java/lang/InterruptedException
    //   110	118	1096	java/lang/InterruptedException
    //   118	123	1096	java/lang/InterruptedException
    //   123	322	1096	java/lang/InterruptedException
    //   322	363	1096	java/lang/InterruptedException
    //   367	400	1096	java/lang/InterruptedException
    //   496	504	1096	java/lang/InterruptedException
    //   507	512	1096	java/lang/InterruptedException
    //   515	530	1096	java/lang/InterruptedException
    //   82	106	1237	javax/net/ssl/SSLHandshakeException
    //   110	118	1237	javax/net/ssl/SSLHandshakeException
    //   118	123	1237	javax/net/ssl/SSLHandshakeException
    //   123	322	1237	javax/net/ssl/SSLHandshakeException
    //   322	363	1237	javax/net/ssl/SSLHandshakeException
    //   367	400	1237	javax/net/ssl/SSLHandshakeException
    //   496	504	1237	javax/net/ssl/SSLHandshakeException
    //   507	512	1237	javax/net/ssl/SSLHandshakeException
    //   515	530	1237	javax/net/ssl/SSLHandshakeException
    //   82	106	1378	java/io/IOException
    //   110	118	1378	java/io/IOException
    //   118	123	1378	java/io/IOException
    //   123	322	1378	java/io/IOException
    //   322	363	1378	java/io/IOException
    //   367	400	1378	java/io/IOException
    //   496	504	1378	java/io/IOException
    //   507	512	1378	java/io/IOException
    //   515	530	1378	java/io/IOException
    //   82	106	1541	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   110	118	1541	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   118	123	1541	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   123	322	1541	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   322	363	1541	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   367	400	1541	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   496	504	1541	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   507	512	1541	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   515	530	1541	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   82	106	1839	java/lang/Throwable
    //   110	118	1839	java/lang/Throwable
    //   118	123	1839	java/lang/Throwable
    //   123	322	1839	java/lang/Throwable
    //   322	363	1839	java/lang/Throwable
    //   367	400	1839	java/lang/Throwable
    //   496	504	1839	java/lang/Throwable
    //   507	512	1839	java/lang/Throwable
    //   515	530	1839	java/lang/Throwable
  }
  
  public String getDownloadURI()
  {
    return this.mDownloadInfo.mURL;
  }
  
  public int getPriority()
  {
    return this.mDownloadInfo.mPriority;
  }
  
  public int getTaskId()
  {
    return this.mTaskId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.DownloadTask
 * JD-Core Version:    0.7.0.1
 */