package com.tencent.tmassistantsdk.downloadservice;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.sdk.platformtools.ad;
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
  protected DownloadInfo mDownloadInfo;
  HttpClient mHttpClient;
  HttpGet mHttpGet;
  private boolean mIsRedirect;
  protected final byte[] mRecvBuf;
  private String mRequestUrl;
  TMAssistantFile mSaveFile;
  protected boolean mStopTask;
  protected final int mTaskId;
  private String startDownloadNetType;
  
  public DownloadTask(DownloadInfo paramDownloadInfo)
  {
    AppMethodBeat.i(101990);
    this.mStopTask = false;
    this.mHttpClient = null;
    this.mHttpGet = null;
    this.mDownloadInfo = null;
    this.mRecvBuf = new byte[4096];
    this.mTaskId = GlobalUtil.getMemUUID();
    this.startDownloadNetType = "wifi";
    this.mIsRedirect = false;
    this.mDownloadInfo = paramDownloadInfo;
    AppMethodBeat.o(101990);
  }
  
  private void cancelInWorkThread()
  {
    AppMethodBeat.i(101992);
    this.mStopTask = true;
    if ((this.mHttpGet != null) && (!this.mHttpGet.isAborted())) {
      this.mHttpGet.abort();
    }
    AppMethodBeat.o(101992);
  }
  
  private void handleResponseCode(HttpResponse paramHttpResponse, DownloadChunkLogInfo paramDownloadChunkLogInfo)
  {
    AppMethodBeat.i(101996);
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
      paramHttpResponse = new StopRequestException(i, "HTTP response code error, code = ".concat(String.valueOf(i)));
      AppMethodBeat.o(101996);
      throw paramHttpResponse;
    case 200: 
      localObject = paramHttpResponse.getHeaders("Content-Type");
      if ((localObject != null) && (localObject.length > 0))
      {
        if (!this.mDownloadInfo.mContentType.equals("resource/tm.android.unknown")) {
          break label262;
        }
        localObject = DownloadHelper.renameAPKFileName(this.mDownloadInfo.mFileName);
        this.mDownloadInfo.mFileName = ((String)localObject);
      }
      for (;;)
      {
        onReceivedResponseData(paramHttpResponse, paramDownloadChunkLogInfo);
        AppMethodBeat.o(101996);
        return;
        localObject = localObject[0].getValue();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("text")))
        {
          paramHttpResponse = new StopRequestException(708, "Return contenttype = text " + Thread.currentThread().getName());
          AppMethodBeat.o(101996);
          throw paramHttpResponse;
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
        AppMethodBeat.o(101996);
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
        paramHttpResponse = new StopRequestException(709, "Redirect cnt many times.");
        AppMethodBeat.o(101996);
        throw paramHttpResponse;
      }
      paramHttpResponse = paramHttpResponse.getFirstHeader("location");
      if (paramHttpResponse != null)
      {
        paramHttpResponse = paramHttpResponse.getValue();
        TMLog.i("_DownloadTask", "jumpURL = ".concat(String.valueOf(paramHttpResponse)));
        if (DownloadHelper.isValidURL(paramHttpResponse))
        {
          this.mRequestUrl = DownloadHelper.correctURL(paramHttpResponse);
          this.mIsRedirect = true;
          paramHttpResponse = this.mDownloadInfo;
          paramHttpResponse.mRedirectCnt += 1;
          AppMethodBeat.o(101996);
          return;
        }
        paramHttpResponse = new StopRequestException(700, "Jump url is not valid. httpResponseCode = " + i + " url: " + paramHttpResponse);
        AppMethodBeat.o(101996);
        throw paramHttpResponse;
      }
      TMLog.e("_DownloadTask", "location header is null. httpResponseCode = ".concat(String.valueOf(i)));
      paramHttpResponse = new StopRequestException(702, "location header is null. httpResponseCode = ".concat(String.valueOf(i)));
      AppMethodBeat.o(101996);
      throw paramHttpResponse;
    case 416: 
      paramHttpResponse = new StopRequestException(i, "HTTP response code error, code = ".concat(String.valueOf(i)));
      AppMethodBeat.o(101996);
      throw paramHttpResponse;
    case 503: 
      label262:
      paramHttpResponse = new StopRequestException(i, "HTTP response code error, code = ".concat(String.valueOf(i)));
      AppMethodBeat.o(101996);
      throw paramHttpResponse;
    }
    paramHttpResponse = new StopRequestException(i, "HTTP response code error, code = ".concat(String.valueOf(i)));
    AppMethodBeat.o(101996);
    throw paramHttpResponse;
  }
  
  private void onDownloadError(Throwable paramThrowable)
  {
    AppMethodBeat.i(101995);
    if (paramThrowable != null) {
      ad.printErrStackTrace("_DownloadTask", paramThrowable, "", new Object[0]);
    }
    AppMethodBeat.o(101995);
  }
  
  /* Error */
  private void onReceivedResponseData(HttpResponse paramHttpResponse, DownloadChunkLogInfo paramDownloadChunkLogInfo)
  {
    // Byte code:
    //   0: ldc_w 270
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokeinterface 274 1 0
    //   12: astore 9
    //   14: aload_0
    //   15: aload_1
    //   16: aload 9
    //   18: invokespecial 278	com/tencent/tmassistantsdk/downloadservice/DownloadTask:verifyTotalLen	(Lorg/apache/http/HttpResponse;Lorg/apache/http/HttpEntity;)Z
    //   21: ifne +33 -> 54
    //   24: ldc 10
    //   26: ldc_w 280
    //   29: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: new 153	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   35: dup
    //   36: sipush 705
    //   39: ldc_w 282
    //   42: invokespecial 168	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/String;)V
    //   45: astore_1
    //   46: ldc_w 270
    //   49: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_1
    //   53: athrow
    //   54: aload_0
    //   55: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   58: invokevirtual 285	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   61: lconst_0
    //   62: lcmp
    //   63: ifne +403 -> 466
    //   66: aload_1
    //   67: invokeinterface 92 1 0
    //   72: invokeinterface 97 1 0
    //   77: sipush 200
    //   80: if_icmpne +269 -> 349
    //   83: aload_0
    //   84: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   87: aload 9
    //   89: invokeinterface 290 1 0
    //   94: invokevirtual 294	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:setTotalSize	(J)V
    //   97: ldc 10
    //   99: new 99	java/lang/StringBuilder
    //   102: dup
    //   103: ldc_w 296
    //   106: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   109: aload_0
    //   110: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   113: invokevirtual 285	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   116: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   119: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: ldc 10
    //   127: new 99	java/lang/StringBuilder
    //   130: dup
    //   131: ldc_w 301
    //   134: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: aload_0
    //   138: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   141: invokevirtual 285	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   144: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   147: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 304	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_1
    //   154: ldc_w 306
    //   157: invokeinterface 232 2 0
    //   162: astore_1
    //   163: aload_1
    //   164: ifnull +36 -> 200
    //   167: aload_1
    //   168: invokeinterface 199 1 0
    //   173: invokestatic 312	com/tencent/tmassistantsdk/downloadservice/ByteRange:parseContentRange	(Ljava/lang/String;)Lcom/tencent/tmassistantsdk/downloadservice/ByteRange;
    //   176: astore_1
    //   177: aload_2
    //   178: aload_1
    //   179: invokevirtual 315	com/tencent/tmassistantsdk/downloadservice/ByteRange:getStart	()J
    //   182: putfield 318	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseRangePosition	J
    //   185: aload_2
    //   186: aload_1
    //   187: invokevirtual 321	com/tencent/tmassistantsdk/downloadservice/ByteRange:getEnd	()J
    //   190: aload_1
    //   191: invokevirtual 315	com/tencent/tmassistantsdk/downloadservice/ByteRange:getStart	()J
    //   194: lsub
    //   195: lconst_1
    //   196: ladd
    //   197: putfield 324	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseRangeLength	J
    //   200: aload_2
    //   201: aload_0
    //   202: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   205: invokevirtual 285	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   208: putfield 327	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseContentLength	J
    //   211: aload_0
    //   212: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   215: ifnonnull +28 -> 243
    //   218: aload_0
    //   219: new 331	com/tencent/tmassistantsdk/storage/TMAssistantFile
    //   222: dup
    //   223: aload_0
    //   224: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   227: getfield 334	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mTempFileName	Ljava/lang/String;
    //   230: aload_0
    //   231: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   234: getfield 186	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mFileName	Ljava/lang/String;
    //   237: invokespecial 336	com/tencent/tmassistantsdk/storage/TMAssistantFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: putfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   243: lconst_0
    //   244: lstore 6
    //   246: lload 6
    //   248: lstore 4
    //   250: aload 9
    //   252: invokeinterface 340 1 0
    //   257: astore_1
    //   258: lload 6
    //   260: lstore 4
    //   262: ldc 10
    //   264: new 99	java/lang/StringBuilder
    //   267: dup
    //   268: ldc_w 342
    //   271: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   274: aload_0
    //   275: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   278: getfield 186	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mFileName	Ljava/lang/String;
    //   281: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: lconst_0
    //   291: lstore 4
    //   293: aload_1
    //   294: aload_0
    //   295: getfield 49	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mRecvBuf	[B
    //   298: invokevirtual 348	java/io/InputStream:read	([B)I
    //   301: istore_3
    //   302: iload_3
    //   303: ifle +14 -> 317
    //   306: aload_0
    //   307: getfield 41	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   310: ifeq +503 -> 813
    //   313: aload_1
    //   314: invokevirtual 351	java/io/InputStream:close	()V
    //   317: aload_0
    //   318: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   321: ifnull +15 -> 336
    //   324: aload_0
    //   325: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   328: invokevirtual 352	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   331: aload_0
    //   332: aconst_null
    //   333: putfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   336: aload_2
    //   337: lload 4
    //   339: putfield 355	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:receiveDataSize	J
    //   342: ldc_w 270
    //   345: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   348: return
    //   349: aload_1
    //   350: invokeinterface 92 1 0
    //   355: invokeinterface 97 1 0
    //   360: sipush 206
    //   363: if_icmpne +62 -> 425
    //   366: aload_1
    //   367: ldc_w 306
    //   370: invokeinterface 232 2 0
    //   375: astore 10
    //   377: aload_0
    //   378: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   381: aload 10
    //   383: invokeinterface 199 1 0
    //   388: invokestatic 358	com/tencent/tmassistantsdk/downloadservice/ByteRange:getTotalSize	(Ljava/lang/String;)J
    //   391: invokevirtual 294	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:setTotalSize	(J)V
    //   394: ldc 10
    //   396: new 99	java/lang/StringBuilder
    //   399: dup
    //   400: ldc_w 360
    //   403: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   406: aload_0
    //   407: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   410: invokevirtual 285	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   413: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   416: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: goto -297 -> 125
    //   425: ldc 10
    //   427: new 99	java/lang/StringBuilder
    //   430: dup
    //   431: ldc_w 362
    //   434: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   437: aload_1
    //   438: invokeinterface 92 1 0
    //   443: invokeinterface 97 1 0
    //   448: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   451: ldc_w 364
    //   454: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 304	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: goto -338 -> 125
    //   466: aload_1
    //   467: invokeinterface 92 1 0
    //   472: invokeinterface 97 1 0
    //   477: sipush 206
    //   480: if_icmpne -269 -> 211
    //   483: aload_1
    //   484: ldc_w 306
    //   487: invokeinterface 232 2 0
    //   492: astore_1
    //   493: aload_1
    //   494: invokeinterface 199 1 0
    //   499: invokestatic 312	com/tencent/tmassistantsdk/downloadservice/ByteRange:parseContentRange	(Ljava/lang/String;)Lcom/tencent/tmassistantsdk/downloadservice/ByteRange;
    //   502: astore 10
    //   504: aload_1
    //   505: invokeinterface 199 1 0
    //   510: invokestatic 358	com/tencent/tmassistantsdk/downloadservice/ByteRange:getTotalSize	(Ljava/lang/String;)J
    //   513: lstore 4
    //   515: aload_2
    //   516: aload 10
    //   518: invokevirtual 315	com/tencent/tmassistantsdk/downloadservice/ByteRange:getStart	()J
    //   521: putfield 318	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseRangePosition	J
    //   524: aload_2
    //   525: aload 10
    //   527: invokevirtual 321	com/tencent/tmassistantsdk/downloadservice/ByteRange:getEnd	()J
    //   530: aload 10
    //   532: invokevirtual 315	com/tencent/tmassistantsdk/downloadservice/ByteRange:getStart	()J
    //   535: lsub
    //   536: lconst_1
    //   537: ladd
    //   538: putfield 324	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseRangeLength	J
    //   541: aload_2
    //   542: lload 4
    //   544: putfield 327	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseContentLength	J
    //   547: ldc 10
    //   549: new 99	java/lang/StringBuilder
    //   552: dup
    //   553: ldc_w 366
    //   556: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   559: lload 4
    //   561: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   564: ldc_w 368
    //   567: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: aload_0
    //   571: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   574: invokevirtual 285	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   577: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   580: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 304	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: ldc 10
    //   588: new 99	java/lang/StringBuilder
    //   591: dup
    //   592: ldc_w 370
    //   595: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   598: aload_0
    //   599: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   602: getfield 373	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mReceivedBytes	J
    //   605: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   608: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: ldc 10
    //   616: new 99	java/lang/StringBuilder
    //   619: dup
    //   620: ldc_w 375
    //   623: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   626: aload 10
    //   628: invokevirtual 315	com/tencent/tmassistantsdk/downloadservice/ByteRange:getStart	()J
    //   631: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   634: ldc_w 377
    //   637: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: aload 10
    //   642: invokevirtual 321	com/tencent/tmassistantsdk/downloadservice/ByteRange:getEnd	()J
    //   645: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   648: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   654: aload 10
    //   656: invokevirtual 315	com/tencent/tmassistantsdk/downloadservice/ByteRange:getStart	()J
    //   659: aload_0
    //   660: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   663: getfield 373	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mReceivedBytes	J
    //   666: lcmp
    //   667: ifeq +74 -> 741
    //   670: new 153	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   673: dup
    //   674: sipush 706
    //   677: ldc_w 379
    //   680: invokespecial 168	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/String;)V
    //   683: astore_1
    //   684: ldc_w 270
    //   687: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   690: aload_1
    //   691: athrow
    //   692: astore_1
    //   693: new 153	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   696: dup
    //   697: sipush 704
    //   700: aload_1
    //   701: invokespecial 382	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/Throwable;)V
    //   704: astore_1
    //   705: ldc_w 270
    //   708: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   711: aload_1
    //   712: athrow
    //   713: astore_1
    //   714: aload_0
    //   715: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   718: ifnull +15 -> 733
    //   721: aload_0
    //   722: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   725: invokevirtual 352	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   728: aload_0
    //   729: aconst_null
    //   730: putfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   733: ldc_w 270
    //   736: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   739: aload_1
    //   740: athrow
    //   741: lload 4
    //   743: aload_0
    //   744: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   747: invokevirtual 285	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   750: lcmp
    //   751: ifeq +25 -> 776
    //   754: new 153	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   757: dup
    //   758: sipush 705
    //   761: ldc_w 384
    //   764: invokespecial 168	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/String;)V
    //   767: astore_1
    //   768: ldc_w 270
    //   771: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   774: aload_1
    //   775: athrow
    //   776: ldc 10
    //   778: ldc_w 386
    //   781: aload_1
    //   782: invokestatic 237	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   785: invokevirtual 165	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   788: invokestatic 389	com/tencent/tmassistantsdk/util/TMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   791: aload_0
    //   792: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   795: ifnull -584 -> 211
    //   798: aload_0
    //   799: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   802: invokevirtual 352	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   805: aload_0
    //   806: aconst_null
    //   807: putfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   810: goto -599 -> 211
    //   813: aload_0
    //   814: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   817: getfield 373	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mReceivedBytes	J
    //   820: iload_3
    //   821: i2l
    //   822: ladd
    //   823: lstore 6
    //   825: lload 6
    //   827: aload_0
    //   828: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   831: invokevirtual 285	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   834: lcmp
    //   835: ifgt +455 -> 1290
    //   838: lload 6
    //   840: aload_0
    //   841: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   844: invokevirtual 285	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   847: lcmp
    //   848: ifne +233 -> 1081
    //   851: iconst_1
    //   852: istore 8
    //   854: aload_0
    //   855: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   858: aload_0
    //   859: getfield 49	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mRecvBuf	[B
    //   862: iconst_0
    //   863: iload_3
    //   864: aload_0
    //   865: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   868: getfield 373	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mReceivedBytes	J
    //   871: iload 8
    //   873: invokevirtual 393	com/tencent/tmassistantsdk/storage/TMAssistantFile:write	([BIIJZ)Z
    //   876: ifne +395 -> 1271
    //   879: invokestatic 396	com/tencent/tmassistantsdk/storage/TMAssistantFile:getSavePathRootDir	()Ljava/lang/String;
    //   882: aload_0
    //   883: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   886: invokevirtual 285	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   889: invokestatic 400	com/tencent/tmassistantsdk/downloadservice/DownloadHelper:isSpaceEnough	(Ljava/lang/String;J)Z
    //   892: ifeq +287 -> 1179
    //   895: invokestatic 403	com/tencent/tmassistantsdk/storage/TMAssistantFile:isSDCardExistAndCanWrite	()Z
    //   898: ifeq +189 -> 1087
    //   901: new 99	java/lang/StringBuilder
    //   904: dup
    //   905: ldc_w 405
    //   908: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   911: aload_0
    //   912: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   915: getfield 186	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mFileName	Ljava/lang/String;
    //   918: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: ldc_w 407
    //   924: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: aload_0
    //   928: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   931: getfield 373	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mReceivedBytes	J
    //   934: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   937: ldc_w 409
    //   940: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: iload_3
    //   944: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   947: ldc_w 411
    //   950: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: aload_0
    //   954: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   957: invokevirtual 285	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   960: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   963: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: astore_1
    //   967: ldc 10
    //   969: aload_1
    //   970: invokestatic 304	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   973: new 153	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   976: dup
    //   977: sipush 703
    //   980: aload_1
    //   981: invokespecial 168	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/String;)V
    //   984: astore_1
    //   985: ldc_w 270
    //   988: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   991: aload_1
    //   992: athrow
    //   993: astore_1
    //   994: lload 4
    //   996: lstore 6
    //   998: lload 6
    //   1000: lstore 4
    //   1002: ldc 10
    //   1004: aload_1
    //   1005: ldc_w 259
    //   1008: iconst_0
    //   1009: anewarray 4	java/lang/Object
    //   1012: invokestatic 265	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1015: lload 6
    //   1017: lstore 4
    //   1019: new 153	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   1022: dup
    //   1023: sipush 605
    //   1026: aload_1
    //   1027: invokespecial 382	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/Throwable;)V
    //   1030: astore_1
    //   1031: lload 6
    //   1033: lstore 4
    //   1035: ldc_w 270
    //   1038: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1041: lload 6
    //   1043: lstore 4
    //   1045: aload_1
    //   1046: athrow
    //   1047: astore_1
    //   1048: aload_0
    //   1049: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1052: ifnull +15 -> 1067
    //   1055: aload_0
    //   1056: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1059: invokevirtual 352	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   1062: aload_0
    //   1063: aconst_null
    //   1064: putfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1067: aload_2
    //   1068: lload 4
    //   1070: putfield 355	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:receiveDataSize	J
    //   1073: ldc_w 270
    //   1076: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1079: aload_1
    //   1080: athrow
    //   1081: iconst_0
    //   1082: istore 8
    //   1084: goto -230 -> 854
    //   1087: new 99	java/lang/StringBuilder
    //   1090: dup
    //   1091: ldc_w 413
    //   1094: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1097: aload_0
    //   1098: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1101: getfield 186	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mFileName	Ljava/lang/String;
    //   1104: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: ldc_w 407
    //   1110: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: aload_0
    //   1114: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1117: getfield 373	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mReceivedBytes	J
    //   1120: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1123: ldc_w 409
    //   1126: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: iload_3
    //   1130: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1133: ldc_w 411
    //   1136: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1139: aload_0
    //   1140: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1143: invokevirtual 285	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   1146: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1149: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1152: astore_1
    //   1153: ldc 10
    //   1155: aload_1
    //   1156: invokestatic 304	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1159: new 153	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   1162: dup
    //   1163: sipush 711
    //   1166: aload_1
    //   1167: invokespecial 168	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/String;)V
    //   1170: astore_1
    //   1171: ldc_w 270
    //   1174: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1177: aload_1
    //   1178: athrow
    //   1179: new 99	java/lang/StringBuilder
    //   1182: dup
    //   1183: ldc_w 415
    //   1186: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1189: aload_0
    //   1190: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1193: getfield 186	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mFileName	Ljava/lang/String;
    //   1196: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: ldc_w 407
    //   1202: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: aload_0
    //   1206: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1209: getfield 373	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mReceivedBytes	J
    //   1212: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1215: ldc_w 409
    //   1218: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: iload_3
    //   1222: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1225: ldc_w 411
    //   1228: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: aload_0
    //   1232: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1235: invokevirtual 285	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   1238: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1241: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1244: astore_1
    //   1245: ldc 10
    //   1247: aload_1
    //   1248: invokestatic 304	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1251: new 153	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   1254: dup
    //   1255: sipush 710
    //   1258: aload_1
    //   1259: invokespecial 168	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/String;)V
    //   1262: astore_1
    //   1263: ldc_w 270
    //   1266: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1269: aload_1
    //   1270: athrow
    //   1271: aload_0
    //   1272: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1275: iload_3
    //   1276: i2l
    //   1277: invokevirtual 418	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:updateReceivedSize	(J)V
    //   1280: lload 4
    //   1282: iload_3
    //   1283: i2l
    //   1284: ladd
    //   1285: lstore 4
    //   1287: goto -994 -> 293
    //   1290: ldc 10
    //   1292: new 99	java/lang/StringBuilder
    //   1295: dup
    //   1296: ldc_w 420
    //   1299: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1302: iload_3
    //   1303: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1306: ldc_w 422
    //   1309: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: aload_0
    //   1313: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1316: getfield 373	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mReceivedBytes	J
    //   1319: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1322: ldc_w 424
    //   1325: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: aload_0
    //   1329: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1332: invokevirtual 285	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getTotalSize	()J
    //   1335: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1338: ldc_w 426
    //   1341: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1347: invokestatic 304	com/tencent/tmassistantsdk/util/TMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1350: new 153	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   1353: dup
    //   1354: sipush 703
    //   1357: ldc_w 428
    //   1360: invokespecial 168	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/String;)V
    //   1363: astore_1
    //   1364: ldc_w 270
    //   1367: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1370: aload_1
    //   1371: athrow
    //   1372: astore_1
    //   1373: goto -375 -> 998
    //   1376: astore_1
    //   1377: goto -329 -> 1048
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1380	0	this	DownloadTask
    //   0	1380	1	paramHttpResponse	HttpResponse
    //   0	1380	2	paramDownloadChunkLogInfo	DownloadChunkLogInfo
    //   301	1002	3	i	int
    //   248	1038	4	l1	long
    //   244	798	6	l2	long
    //   852	231	8	bool	boolean
    //   12	239	9	localHttpEntity	HttpEntity
    //   375	280	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   483	692	692	java/lang/Throwable
    //   741	776	692	java/lang/Throwable
    //   776	791	692	java/lang/Throwable
    //   483	692	713	finally
    //   693	713	713	finally
    //   741	776	713	finally
    //   776	791	713	finally
    //   293	302	993	java/net/SocketException
    //   306	317	993	java/net/SocketException
    //   813	851	993	java/net/SocketException
    //   854	993	993	java/net/SocketException
    //   1087	1179	993	java/net/SocketException
    //   1179	1271	993	java/net/SocketException
    //   1271	1280	993	java/net/SocketException
    //   1290	1372	993	java/net/SocketException
    //   250	258	1047	finally
    //   262	290	1047	finally
    //   1002	1015	1047	finally
    //   1019	1031	1047	finally
    //   1035	1041	1047	finally
    //   1045	1047	1047	finally
    //   250	258	1372	java/net/SocketException
    //   262	290	1372	java/net/SocketException
    //   293	302	1376	finally
    //   306	317	1376	finally
    //   813	851	1376	finally
    //   854	993	1376	finally
    //   1087	1179	1376	finally
    //   1179	1271	1376	finally
    //   1271	1280	1376	finally
    //   1290	1372	1376	finally
  }
  
  private void renameApkFileName(HttpResponse paramHttpResponse)
  {
    AppMethodBeat.i(102000);
    if (paramHttpResponse == null)
    {
      AppMethodBeat.o(102000);
      return;
    }
    if (this.mDownloadInfo.mContentType.equals("application/vnd.android.package-archive"))
    {
      Object localObject = null;
      paramHttpResponse = paramHttpResponse.getHeaders("Content-Disposition");
      if ((paramHttpResponse == null) || (paramHttpResponse.length <= 0)) {
        break label191;
      }
      paramHttpResponse = paramHttpResponse[0].getValue();
      TMLog.i("_DownloadTask", "headerFileName = ".concat(String.valueOf(paramHttpResponse)));
      if ((TextUtils.isEmpty(paramHttpResponse)) || (!paramHttpResponse.contains("filename=\""))) {
        break label177;
      }
      String str = paramHttpResponse.substring(paramHttpResponse.indexOf("filename=\"") + 10);
      paramHttpResponse = localObject;
      if (!TextUtils.isEmpty(str))
      {
        paramHttpResponse = str.substring(0, str.indexOf("\""));
        TMLog.i("_DownloadTask", "header file Name =".concat(String.valueOf(paramHttpResponse)));
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramHttpResponse))
      {
        paramHttpResponse = DownloadHelper.correctFileName(DownloadHelper.decodeFileName(paramHttpResponse));
        this.mDownloadInfo.mFileName = paramHttpResponse;
      }
      AppMethodBeat.o(102000);
      return;
      label177:
      paramHttpResponse = DownloadHelper.genAPKFileName(this.mDownloadInfo.mRequestURL);
      continue;
      label191:
      paramHttpResponse = DownloadHelper.genAPKFileName(this.mDownloadInfo.mRequestURL);
    }
  }
  
  private void setExtraHeaderParam(HttpGet paramHttpGet, Map<String, String> paramMap)
  {
    AppMethodBeat.i(102001);
    if ((paramHttpGet != null) && (paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        paramHttpGet.addHeader((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    AppMethodBeat.o(102001);
  }
  
  private void setRangeHeader(HttpGet paramHttpGet, DownloadChunkLogInfo paramDownloadChunkLogInfo)
  {
    AppMethodBeat.i(101999);
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
          TMLog.d("_DownloadTask", "set range header: ".concat(String.valueOf(str)));
          paramDownloadChunkLogInfo.responseContentLength = this.mDownloadInfo.getTotalSize();
          paramDownloadChunkLogInfo.requestRanagePosition = l3;
          paramDownloadChunkLogInfo.requestRanageSize = i;
          AppMethodBeat.o(101999);
          return;
        }
        str = "bytes=" + this.mDownloadInfo.mReceivedBytes + "-";
      }
      catch (UnsupportedOperationException paramHttpGet)
      {
        ad.printErrStackTrace("_DownloadTask", paramHttpGet, "", new Object[0]);
        AppMethodBeat.o(101999);
        return;
      }
    }
    paramHttpGet.addHeader("range", str);
    TMLog.d("_DownloadTask", "set range header: ".concat(String.valueOf(str)));
    paramDownloadChunkLogInfo.responseContentLength = this.mDownloadInfo.getTotalSize();
    paramDownloadChunkLogInfo.requestRanagePosition = this.mDownloadInfo.mReceivedBytes;
    paramDownloadChunkLogInfo.requestRanageSize = 0L;
    AppMethodBeat.o(101999);
  }
  
  private boolean shouldRetryConnect()
  {
    boolean bool2 = false;
    AppMethodBeat.i(101994);
    if (this.mStopTask)
    {
      TMLog.i("_DownloadTask", "mStopTask = " + this.mStopTask);
      AppMethodBeat.o(101994);
      return false;
    }
    try
    {
      Thread.sleep(5000L);
      label54:
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
        AppMethodBeat.o(101994);
        return false;
      }
      if ((!DownloadHelper.getNetStatus().equalsIgnoreCase("wifi")) && (!DownloadHelper.getNetStatus().equalsIgnoreCase(this.startDownloadNetType)))
      {
        TMLog.i("_DownloadTask", "not equal netType, current: " + DownloadHelper.getNetStatus() + ", startNetType: " + this.startDownloadNetType);
        AppMethodBeat.o(101994);
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
      AppMethodBeat.o(101994);
      return bool1;
    }
    catch (InterruptedException localInterruptedException3)
    {
      boolean bool1;
      break label54;
    }
  }
  
  private boolean verifyTotalLen(HttpResponse paramHttpResponse, HttpEntity paramHttpEntity)
  {
    AppMethodBeat.i(101997);
    long l;
    if (paramHttpResponse.getStatusLine().getStatusCode() == 200)
    {
      l = paramHttpEntity.getContentLength();
      TMLog.i("_DownloadTask", "verifyTotalLen,totalLen = " + l + "mRequestFileSize = " + this.mDownloadInfo.mRequestFileSize);
      if ((l == -1L) || ((this.mDownloadInfo.mRequestFileSize.longValue() > 0L) && (l != this.mDownloadInfo.mRequestFileSize.longValue())))
      {
        AppMethodBeat.o(101997);
        return false;
      }
    }
    else if (paramHttpResponse.getStatusLine().getStatusCode() == 206)
    {
      l = ByteRange.getTotalSize(paramHttpResponse.getFirstHeader("content-range").getValue());
      TMLog.i("_DownloadTask", "verifyTotalLen,totalLen = " + l + "mRequestFileSize = " + this.mDownloadInfo.mRequestFileSize);
      if ((l == -1L) || ((this.mDownloadInfo.mRequestFileSize.longValue() > 0L) && (l != this.mDownloadInfo.mRequestFileSize.longValue())))
      {
        AppMethodBeat.o(101997);
        return false;
      }
    }
    AppMethodBeat.o(101997);
    return true;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(101991);
    TMLog.i("_DownloadTask", "DownloadTask::cancel url: " + this.mDownloadInfo.mURL);
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      p.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(101989);
          DownloadTask.access$000(DownloadTask.this);
          AppMethodBeat.o(101989);
        }
      });
      AppMethodBeat.o(101991);
      return;
    }
    cancelInWorkThread();
    AppMethodBeat.o(101991);
  }
  
  /* Error */
  public void exec(String paramString)
  {
    // Byte code:
    //   0: ldc_w 635
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 513	com/tencent/tmassistantsdk/downloadservice/DownloadHelper:getNetStatus	()Ljava/lang/String;
    //   10: putfield 61	com/tencent/tmassistantsdk/downloadservice/DownloadTask:startDownloadNetType	Ljava/lang/String;
    //   13: aload_0
    //   14: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   17: iconst_1
    //   18: putfield 638	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mTaskIsRunning	Z
    //   21: aload_0
    //   22: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   25: iconst_2
    //   26: iconst_0
    //   27: invokevirtual 642	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:updateStatus	(IZ)V
    //   30: iconst_0
    //   31: istore_3
    //   32: iconst_1
    //   33: istore_2
    //   34: iload_2
    //   35: ifeq +1987 -> 2022
    //   38: invokestatic 648	com/tencent/tmassistantsdk/logreport/DownloadReportManager:getInstance	()Lcom/tencent/tmassistantsdk/logreport/DownloadReportManager;
    //   41: iconst_0
    //   42: invokevirtual 652	com/tencent/tmassistantsdk/logreport/DownloadReportManager:createNewChunkLogInfo	(B)Lcom/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo;
    //   45: astore 5
    //   47: aload 5
    //   49: aload_0
    //   50: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   53: getfield 655	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mUUID	Ljava/lang/String;
    //   56: putfield 658	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:UUID	Ljava/lang/String;
    //   59: aload 5
    //   61: aload_0
    //   62: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   65: getfield 151	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mRetryCnt	I
    //   68: i2b
    //   69: putfield 662	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:currentRetryCnt	B
    //   72: aload 5
    //   74: aload_0
    //   75: invokevirtual 665	com/tencent/tmassistantsdk/downloadservice/DownloadTask:getDownloadURI	()Ljava/lang/String;
    //   78: putfield 668	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:requestUrl	Ljava/lang/String;
    //   81: aload_0
    //   82: getfield 41	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   85: ifne +1937 -> 2022
    //   88: aload_0
    //   89: getfield 63	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mIsRedirect	Z
    //   92: ifeq +20 -> 112
    //   95: aload_0
    //   96: getfield 245	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mRequestUrl	Ljava/lang/String;
    //   99: ifnull +13 -> 112
    //   102: aload_0
    //   103: getfield 245	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mRequestUrl	Ljava/lang/String;
    //   106: invokevirtual 671	java/lang/String:length	()I
    //   109: ifne +404 -> 513
    //   112: iload_3
    //   113: ifeq +386 -> 499
    //   116: aload_0
    //   117: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   120: getfield 674	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mSecondaryUrl	Ljava/lang/String;
    //   123: invokestatic 679	com/tencent/mm/plugin/downloader/a/c:Sg	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore_1
    //   127: aload_0
    //   128: aload_1
    //   129: putfield 245	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mRequestUrl	Ljava/lang/String;
    //   132: ldc 10
    //   134: new 99	java/lang/StringBuilder
    //   137: dup
    //   138: ldc_w 681
    //   141: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   144: aload_0
    //   145: getfield 63	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mIsRedirect	Z
    //   148: invokevirtual 548	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   151: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: ldc 10
    //   159: ldc_w 683
    //   162: iload_3
    //   163: invokestatic 686	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   166: invokevirtual 165	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   169: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: ldc 10
    //   174: ldc_w 688
    //   177: aload_1
    //   178: invokestatic 237	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   181: invokevirtual 165	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   184: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_0
    //   188: iconst_0
    //   189: putfield 63	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mIsRedirect	Z
    //   192: aload_0
    //   193: invokestatic 694	com/tencent/tmassistantsdk/downloadservice/HttpClientUtil:createHttpClient	()Lorg/apache/http/client/HttpClient;
    //   196: putfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   199: aload_0
    //   200: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   203: invokestatic 698	com/tencent/tmassistantsdk/downloadservice/HttpClientUtil:setProxy	(Lorg/apache/http/client/HttpClient;)V
    //   206: aload_0
    //   207: new 76	org/apache/http/client/methods/HttpGet
    //   210: dup
    //   211: invokespecial 699	org/apache/http/client/methods/HttpGet:<init>	()V
    //   214: putfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   217: new 701	java/net/URI
    //   220: dup
    //   221: aload_1
    //   222: invokespecial 702	java/net/URI:<init>	(Ljava/lang/String;)V
    //   225: astore_1
    //   226: aload_0
    //   227: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   230: aload_1
    //   231: invokevirtual 706	org/apache/http/client/methods/HttpGet:setURI	(Ljava/net/URI;)V
    //   234: aload_0
    //   235: aload_0
    //   236: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   239: aload_0
    //   240: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   243: invokevirtual 710	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:getHeaderParams	()Ljava/util/HashMap;
    //   246: invokespecial 712	com/tencent/tmassistantsdk/downloadservice/DownloadTask:setExtraHeaderParam	(Lorg/apache/http/client/methods/HttpGet;Ljava/util/Map;)V
    //   249: aload_0
    //   250: aload_0
    //   251: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   254: aload 5
    //   256: invokespecial 714	com/tencent/tmassistantsdk/downloadservice/DownloadTask:setRangeHeader	(Lorg/apache/http/client/methods/HttpGet;Lcom/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo;)V
    //   259: aload_1
    //   260: invokevirtual 717	java/net/URI:getScheme	()Ljava/lang/String;
    //   263: ldc_w 719
    //   266: invokevirtual 183	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   269: ifeq +48 -> 317
    //   272: invokestatic 725	org/apache/http/conn/ssl/SSLSocketFactory:getSocketFactory	()Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   275: astore_1
    //   276: aload_1
    //   277: getstatic 729	org/apache/http/conn/ssl/SSLSocketFactory:BROWSER_COMPATIBLE_HOSTNAME_VERIFIER	Lorg/apache/http/conn/ssl/X509HostnameVerifier;
    //   280: invokevirtual 733	org/apache/http/conn/ssl/SSLSocketFactory:setHostnameVerifier	(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V
    //   283: new 735	org/apache/http/conn/scheme/Scheme
    //   286: dup
    //   287: ldc_w 719
    //   290: aload_1
    //   291: sipush 443
    //   294: invokespecial 738	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   297: astore_1
    //   298: aload_0
    //   299: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   302: invokeinterface 744 1 0
    //   307: invokeinterface 750 1 0
    //   312: aload_1
    //   313: invokevirtual 756	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   316: pop
    //   317: ldc 10
    //   319: new 99	java/lang/StringBuilder
    //   322: dup
    //   323: ldc_w 758
    //   326: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   329: invokestatic 119	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   332: invokevirtual 123	java/lang/Thread:getName	()Ljava/lang/String;
    //   335: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload_0
    //   345: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   348: aload_0
    //   349: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   352: invokeinterface 762 2 0
    //   357: astore_1
    //   358: aload_1
    //   359: ifnonnull +162 -> 521
    //   362: new 153	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   365: dup
    //   366: sipush 701
    //   369: new 99	java/lang/StringBuilder
    //   372: dup
    //   373: ldc_w 764
    //   376: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   379: invokestatic 119	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   382: invokevirtual 123	java/lang/Thread:getName	()Ljava/lang/String;
    //   385: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokespecial 168	com/tencent/tmassistantsdk/downloadservice/StopRequestException:<init>	(ILjava/lang/String;)V
    //   394: astore_1
    //   395: ldc_w 635
    //   398: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   401: aload_1
    //   402: athrow
    //   403: astore_1
    //   404: aload_0
    //   405: getfield 41	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   408: istore_2
    //   409: iload_2
    //   410: ifeq +222 -> 632
    //   413: iconst_0
    //   414: istore 4
    //   416: aload_0
    //   417: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   420: ifnull +25 -> 445
    //   423: aload_0
    //   424: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   427: invokevirtual 80	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   430: ifne +10 -> 440
    //   433: aload_0
    //   434: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   437: invokevirtual 83	org/apache/http/client/methods/HttpGet:abort	()V
    //   440: aload_0
    //   441: aconst_null
    //   442: putfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   445: aload_0
    //   446: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   449: ifnull +22 -> 471
    //   452: aload_0
    //   453: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   456: invokeinterface 744 1 0
    //   461: invokeinterface 767 1 0
    //   466: aload_0
    //   467: aconst_null
    //   468: putfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   471: iload 4
    //   473: istore_2
    //   474: aload_0
    //   475: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   478: ifnull +1706 -> 2184
    //   481: aload_0
    //   482: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   485: invokevirtual 352	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   488: aload_0
    //   489: aconst_null
    //   490: putfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   493: iload 4
    //   495: istore_2
    //   496: goto -462 -> 34
    //   499: aload_0
    //   500: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   503: getfield 463	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mRequestURL	Ljava/lang/String;
    //   506: invokestatic 679	com/tencent/mm/plugin/downloader/a/c:Sg	(Ljava/lang/String;)Ljava/lang/String;
    //   509: astore_1
    //   510: goto -383 -> 127
    //   513: aload_0
    //   514: getfield 245	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mRequestUrl	Ljava/lang/String;
    //   517: astore_1
    //   518: goto -386 -> 132
    //   521: aload_0
    //   522: aload_1
    //   523: aload 5
    //   525: invokespecial 769	com/tencent/tmassistantsdk/downloadservice/DownloadTask:handleResponseCode	(Lorg/apache/http/HttpResponse;Lcom/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo;)V
    //   528: aload_0
    //   529: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   532: invokevirtual 772	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:hasReceivedAllDataBytes	()Z
    //   535: istore_2
    //   536: iload_2
    //   537: ifne +89 -> 626
    //   540: iconst_1
    //   541: istore 4
    //   543: aload_0
    //   544: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   547: ifnull +25 -> 572
    //   550: aload_0
    //   551: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   554: invokevirtual 80	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   557: ifne +10 -> 567
    //   560: aload_0
    //   561: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   564: invokevirtual 83	org/apache/http/client/methods/HttpGet:abort	()V
    //   567: aload_0
    //   568: aconst_null
    //   569: putfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   572: aload_0
    //   573: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   576: ifnull +22 -> 598
    //   579: aload_0
    //   580: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   583: invokeinterface 744 1 0
    //   588: invokeinterface 767 1 0
    //   593: aload_0
    //   594: aconst_null
    //   595: putfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   598: iload 4
    //   600: istore_2
    //   601: aload_0
    //   602: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   605: ifnull +1579 -> 2184
    //   608: aload_0
    //   609: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   612: invokevirtual 352	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   615: aload_0
    //   616: aconst_null
    //   617: putfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   620: iload 4
    //   622: istore_2
    //   623: goto -589 -> 34
    //   626: iconst_0
    //   627: istore 4
    //   629: goto -86 -> 543
    //   632: ldc 10
    //   634: new 99	java/lang/StringBuilder
    //   637: dup
    //   638: ldc_w 774
    //   641: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   644: invokestatic 119	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   647: invokevirtual 123	java/lang/Thread:getName	()Ljava/lang/String;
    //   650: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   659: ldc 10
    //   661: aload_1
    //   662: ldc_w 259
    //   665: iconst_0
    //   666: anewarray 4	java/lang/Object
    //   669: invokestatic 265	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   672: aload_0
    //   673: invokespecial 776	com/tencent/tmassistantsdk/downloadservice/DownloadTask:shouldRetryConnect	()Z
    //   676: istore_2
    //   677: iload_2
    //   678: istore 4
    //   680: iload_2
    //   681: ifne -265 -> 416
    //   684: aload_0
    //   685: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   688: sipush 601
    //   691: putfield 561	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   694: iload_2
    //   695: istore 4
    //   697: goto -281 -> 416
    //   700: astore_1
    //   701: aload_0
    //   702: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   705: ifnull +25 -> 730
    //   708: aload_0
    //   709: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   712: invokevirtual 80	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   715: ifne +10 -> 725
    //   718: aload_0
    //   719: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   722: invokevirtual 83	org/apache/http/client/methods/HttpGet:abort	()V
    //   725: aload_0
    //   726: aconst_null
    //   727: putfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   730: aload_0
    //   731: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   734: ifnull +22 -> 756
    //   737: aload_0
    //   738: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   741: invokeinterface 744 1 0
    //   746: invokeinterface 767 1 0
    //   751: aload_0
    //   752: aconst_null
    //   753: putfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   756: aload_0
    //   757: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   760: ifnull +15 -> 775
    //   763: aload_0
    //   764: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   767: invokevirtual 352	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   770: aload_0
    //   771: aconst_null
    //   772: putfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   775: ldc_w 635
    //   778: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   781: aload_1
    //   782: athrow
    //   783: astore_1
    //   784: aload_0
    //   785: getfield 41	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   788: istore_2
    //   789: iload_2
    //   790: ifeq +89 -> 879
    //   793: iconst_0
    //   794: istore 4
    //   796: aload_0
    //   797: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   800: ifnull +25 -> 825
    //   803: aload_0
    //   804: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   807: invokevirtual 80	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   810: ifne +10 -> 820
    //   813: aload_0
    //   814: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   817: invokevirtual 83	org/apache/http/client/methods/HttpGet:abort	()V
    //   820: aload_0
    //   821: aconst_null
    //   822: putfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   825: aload_0
    //   826: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   829: ifnull +22 -> 851
    //   832: aload_0
    //   833: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   836: invokeinterface 744 1 0
    //   841: invokeinterface 767 1 0
    //   846: aload_0
    //   847: aconst_null
    //   848: putfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   851: iload 4
    //   853: istore_2
    //   854: aload_0
    //   855: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   858: ifnull +1326 -> 2184
    //   861: aload_0
    //   862: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   865: invokevirtual 352	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   868: aload_0
    //   869: aconst_null
    //   870: putfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   873: iload 4
    //   875: istore_2
    //   876: goto -842 -> 34
    //   879: ldc 10
    //   881: new 99	java/lang/StringBuilder
    //   884: dup
    //   885: ldc_w 778
    //   888: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   891: invokestatic 119	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   894: invokevirtual 123	java/lang/Thread:getName	()Ljava/lang/String;
    //   897: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   906: ldc 10
    //   908: aload_1
    //   909: ldc_w 259
    //   912: iconst_0
    //   913: anewarray 4	java/lang/Object
    //   916: invokestatic 265	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   919: aload_0
    //   920: invokespecial 776	com/tencent/tmassistantsdk/downloadservice/DownloadTask:shouldRetryConnect	()Z
    //   923: istore_2
    //   924: iload_2
    //   925: istore 4
    //   927: iload_2
    //   928: ifne -132 -> 796
    //   931: aload_0
    //   932: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   935: sipush 602
    //   938: putfield 561	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   941: iload_2
    //   942: istore 4
    //   944: goto -148 -> 796
    //   947: astore_1
    //   948: aload_0
    //   949: getfield 41	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   952: istore_2
    //   953: iload_2
    //   954: ifeq +89 -> 1043
    //   957: iconst_0
    //   958: istore 4
    //   960: aload_0
    //   961: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   964: ifnull +25 -> 989
    //   967: aload_0
    //   968: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   971: invokevirtual 80	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   974: ifne +10 -> 984
    //   977: aload_0
    //   978: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   981: invokevirtual 83	org/apache/http/client/methods/HttpGet:abort	()V
    //   984: aload_0
    //   985: aconst_null
    //   986: putfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   989: aload_0
    //   990: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   993: ifnull +22 -> 1015
    //   996: aload_0
    //   997: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1000: invokeinterface 744 1 0
    //   1005: invokeinterface 767 1 0
    //   1010: aload_0
    //   1011: aconst_null
    //   1012: putfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1015: iload 4
    //   1017: istore_2
    //   1018: aload_0
    //   1019: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1022: ifnull +1162 -> 2184
    //   1025: aload_0
    //   1026: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1029: invokevirtual 352	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   1032: aload_0
    //   1033: aconst_null
    //   1034: putfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1037: iload 4
    //   1039: istore_2
    //   1040: goto -1006 -> 34
    //   1043: ldc 10
    //   1045: new 99	java/lang/StringBuilder
    //   1048: dup
    //   1049: ldc_w 780
    //   1052: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1055: invokestatic 119	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1058: invokevirtual 123	java/lang/Thread:getName	()Ljava/lang/String;
    //   1061: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1067: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1070: ldc 10
    //   1072: aload_1
    //   1073: ldc_w 259
    //   1076: iconst_0
    //   1077: anewarray 4	java/lang/Object
    //   1080: invokestatic 265	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1083: aload_0
    //   1084: invokespecial 776	com/tencent/tmassistantsdk/downloadservice/DownloadTask:shouldRetryConnect	()Z
    //   1087: istore_2
    //   1088: iload_2
    //   1089: istore 4
    //   1091: iload_2
    //   1092: ifne -132 -> 960
    //   1095: aload_0
    //   1096: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1099: sipush 603
    //   1102: putfield 561	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   1105: iload_2
    //   1106: istore 4
    //   1108: goto -148 -> 960
    //   1111: astore_1
    //   1112: aload_0
    //   1113: getfield 41	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   1116: istore_2
    //   1117: iload_2
    //   1118: ifeq +82 -> 1200
    //   1121: aload_0
    //   1122: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1125: ifnull +25 -> 1150
    //   1128: aload_0
    //   1129: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1132: invokevirtual 80	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   1135: ifne +10 -> 1145
    //   1138: aload_0
    //   1139: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1142: invokevirtual 83	org/apache/http/client/methods/HttpGet:abort	()V
    //   1145: aload_0
    //   1146: aconst_null
    //   1147: putfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1150: aload_0
    //   1151: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1154: ifnull +22 -> 1176
    //   1157: aload_0
    //   1158: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1161: invokeinterface 744 1 0
    //   1166: invokeinterface 767 1 0
    //   1171: aload_0
    //   1172: aconst_null
    //   1173: putfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1176: aload_0
    //   1177: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1180: ifnull +1015 -> 2195
    //   1183: aload_0
    //   1184: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1187: invokevirtual 352	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   1190: aload_0
    //   1191: aconst_null
    //   1192: putfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1195: iconst_0
    //   1196: istore_2
    //   1197: goto -1163 -> 34
    //   1200: ldc 10
    //   1202: new 99	java/lang/StringBuilder
    //   1205: dup
    //   1206: ldc_w 782
    //   1209: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1212: invokestatic 119	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1215: invokevirtual 123	java/lang/Thread:getName	()Ljava/lang/String;
    //   1218: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1224: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1227: ldc 10
    //   1229: aload_1
    //   1230: ldc_w 259
    //   1233: iconst_0
    //   1234: anewarray 4	java/lang/Object
    //   1237: invokestatic 265	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1240: aload_0
    //   1241: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1244: sipush 600
    //   1247: putfield 561	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   1250: goto -129 -> 1121
    //   1253: astore_1
    //   1254: aload_0
    //   1255: getfield 41	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   1258: istore_2
    //   1259: iload_2
    //   1260: ifeq +82 -> 1342
    //   1263: aload_0
    //   1264: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1267: ifnull +25 -> 1292
    //   1270: aload_0
    //   1271: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1274: invokevirtual 80	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   1277: ifne +10 -> 1287
    //   1280: aload_0
    //   1281: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1284: invokevirtual 83	org/apache/http/client/methods/HttpGet:abort	()V
    //   1287: aload_0
    //   1288: aconst_null
    //   1289: putfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1292: aload_0
    //   1293: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1296: ifnull +22 -> 1318
    //   1299: aload_0
    //   1300: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1303: invokeinterface 744 1 0
    //   1308: invokeinterface 767 1 0
    //   1313: aload_0
    //   1314: aconst_null
    //   1315: putfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1318: aload_0
    //   1319: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1322: ifnull +873 -> 2195
    //   1325: aload_0
    //   1326: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1329: invokevirtual 352	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   1332: aload_0
    //   1333: aconst_null
    //   1334: putfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1337: iconst_0
    //   1338: istore_2
    //   1339: goto -1305 -> 34
    //   1342: ldc 10
    //   1344: new 99	java/lang/StringBuilder
    //   1347: dup
    //   1348: ldc_w 784
    //   1351: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1354: invokestatic 119	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1357: invokevirtual 123	java/lang/Thread:getName	()Ljava/lang/String;
    //   1360: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1366: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1369: ldc 10
    //   1371: aload_1
    //   1372: ldc_w 259
    //   1375: iconst_0
    //   1376: anewarray 4	java/lang/Object
    //   1379: invokestatic 265	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1382: aload_0
    //   1383: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1386: sipush 607
    //   1389: putfield 561	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   1392: goto -129 -> 1263
    //   1395: astore_1
    //   1396: aload_0
    //   1397: getfield 41	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   1400: istore_2
    //   1401: iload_2
    //   1402: ifeq +89 -> 1491
    //   1405: iconst_0
    //   1406: istore 4
    //   1408: aload_0
    //   1409: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1412: ifnull +25 -> 1437
    //   1415: aload_0
    //   1416: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1419: invokevirtual 80	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   1422: ifne +10 -> 1432
    //   1425: aload_0
    //   1426: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1429: invokevirtual 83	org/apache/http/client/methods/HttpGet:abort	()V
    //   1432: aload_0
    //   1433: aconst_null
    //   1434: putfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1437: aload_0
    //   1438: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1441: ifnull +22 -> 1463
    //   1444: aload_0
    //   1445: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1448: invokeinterface 744 1 0
    //   1453: invokeinterface 767 1 0
    //   1458: aload_0
    //   1459: aconst_null
    //   1460: putfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1463: iload 4
    //   1465: istore_2
    //   1466: aload_0
    //   1467: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1470: ifnull +714 -> 2184
    //   1473: aload_0
    //   1474: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1477: invokevirtual 352	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   1480: aload_0
    //   1481: aconst_null
    //   1482: putfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1485: iload 4
    //   1487: istore_2
    //   1488: goto -1454 -> 34
    //   1491: ldc 10
    //   1493: new 99	java/lang/StringBuilder
    //   1496: dup
    //   1497: ldc_w 786
    //   1500: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1503: invokestatic 119	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1506: invokevirtual 123	java/lang/Thread:getName	()Ljava/lang/String;
    //   1509: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1515: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1518: ldc 10
    //   1520: aload_1
    //   1521: ldc_w 259
    //   1524: iconst_0
    //   1525: anewarray 4	java/lang/Object
    //   1528: invokestatic 265	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1531: aload_0
    //   1532: invokespecial 776	com/tencent/tmassistantsdk/downloadservice/DownloadTask:shouldRetryConnect	()Z
    //   1535: istore_2
    //   1536: iload_2
    //   1537: istore 4
    //   1539: iload_2
    //   1540: ifne -132 -> 1408
    //   1543: aload_0
    //   1544: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1547: sipush 606
    //   1550: putfield 561	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   1553: iload_2
    //   1554: istore 4
    //   1556: goto -148 -> 1408
    //   1559: astore_1
    //   1560: aload_0
    //   1561: getfield 41	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   1564: istore_2
    //   1565: iload_2
    //   1566: ifeq +90 -> 1656
    //   1569: iload_3
    //   1570: istore_2
    //   1571: iconst_0
    //   1572: istore 4
    //   1574: aload_0
    //   1575: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1578: ifnull +25 -> 1603
    //   1581: aload_0
    //   1582: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1585: invokevirtual 80	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   1588: ifne +10 -> 1598
    //   1591: aload_0
    //   1592: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1595: invokevirtual 83	org/apache/http/client/methods/HttpGet:abort	()V
    //   1598: aload_0
    //   1599: aconst_null
    //   1600: putfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1603: aload_0
    //   1604: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1607: ifnull +22 -> 1629
    //   1610: aload_0
    //   1611: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1614: invokeinterface 744 1 0
    //   1619: invokeinterface 767 1 0
    //   1624: aload_0
    //   1625: aconst_null
    //   1626: putfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1629: aload_0
    //   1630: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1633: ifnull +554 -> 2187
    //   1636: aload_0
    //   1637: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1640: invokevirtual 352	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   1643: aload_0
    //   1644: aconst_null
    //   1645: putfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1648: iload_2
    //   1649: istore_3
    //   1650: iload 4
    //   1652: istore_2
    //   1653: goto -1619 -> 34
    //   1656: ldc 10
    //   1658: new 99	java/lang/StringBuilder
    //   1661: dup
    //   1662: ldc_w 788
    //   1665: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1668: aload_1
    //   1669: getfield 791	com/tencent/tmassistantsdk/downloadservice/StopRequestException:mFinalErrCode	I
    //   1672: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1675: ldc 110
    //   1677: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: invokestatic 119	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1683: invokevirtual 123	java/lang/Thread:getName	()Ljava/lang/String;
    //   1686: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1689: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1692: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1695: ldc 10
    //   1697: aload_1
    //   1698: ldc_w 259
    //   1701: iconst_0
    //   1702: anewarray 4	java/lang/Object
    //   1705: invokestatic 265	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1708: aload_0
    //   1709: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1712: aload_1
    //   1713: getfield 791	com/tencent/tmassistantsdk/downloadservice/StopRequestException:mFinalErrCode	I
    //   1716: putfield 561	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   1719: aload_1
    //   1720: getfield 791	com/tencent/tmassistantsdk/downloadservice/StopRequestException:mFinalErrCode	I
    //   1723: sipush 703
    //   1726: if_icmpeq +474 -> 2200
    //   1729: aload_1
    //   1730: getfield 791	com/tencent/tmassistantsdk/downloadservice/StopRequestException:mFinalErrCode	I
    //   1733: sipush 710
    //   1736: if_icmpeq +464 -> 2200
    //   1739: aload_1
    //   1740: getfield 791	com/tencent/tmassistantsdk/downloadservice/StopRequestException:mFinalErrCode	I
    //   1743: sipush 711
    //   1746: if_icmpne +6 -> 1752
    //   1749: goto +451 -> 2200
    //   1752: sipush 704
    //   1755: aload_1
    //   1756: getfield 791	com/tencent/tmassistantsdk/downloadservice/StopRequestException:mFinalErrCode	I
    //   1759: if_icmpne +43 -> 1802
    //   1762: aload_0
    //   1763: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1766: lconst_0
    //   1767: invokevirtual 294	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:setTotalSize	(J)V
    //   1770: new 331	com/tencent/tmassistantsdk/storage/TMAssistantFile
    //   1773: dup
    //   1774: aload_0
    //   1775: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1778: getfield 334	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mTempFileName	Ljava/lang/String;
    //   1781: aload_0
    //   1782: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1785: getfield 186	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mFileName	Ljava/lang/String;
    //   1788: invokespecial 336	com/tencent/tmassistantsdk/storage/TMAssistantFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1791: invokevirtual 794	com/tencent/tmassistantsdk/storage/TMAssistantFile:deleteTempFile	()V
    //   1794: iload_3
    //   1795: istore_2
    //   1796: iconst_0
    //   1797: istore 4
    //   1799: goto -225 -> 1574
    //   1802: sipush 705
    //   1805: aload_1
    //   1806: getfield 791	com/tencent/tmassistantsdk/downloadservice/StopRequestException:mFinalErrCode	I
    //   1809: if_icmpne +38 -> 1847
    //   1812: iload_3
    //   1813: ifne +395 -> 2208
    //   1816: aload_0
    //   1817: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1820: invokevirtual 573	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:hasRetryChance	()Z
    //   1823: ifeq +385 -> 2208
    //   1826: aload_0
    //   1827: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   1830: getfield 674	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mSecondaryUrl	Ljava/lang/String;
    //   1833: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1836: ifne +372 -> 2208
    //   1839: iconst_1
    //   1840: istore_2
    //   1841: iconst_1
    //   1842: istore 4
    //   1844: goto -270 -> 1574
    //   1847: aload_0
    //   1848: invokespecial 776	com/tencent/tmassistantsdk/downloadservice/DownloadTask:shouldRetryConnect	()Z
    //   1851: istore 4
    //   1853: iload_3
    //   1854: istore_2
    //   1855: goto -281 -> 1574
    //   1858: astore_1
    //   1859: aload_0
    //   1860: getfield 41	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   1863: istore_2
    //   1864: iload_2
    //   1865: ifeq +89 -> 1954
    //   1868: iconst_0
    //   1869: istore 4
    //   1871: aload_0
    //   1872: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1875: ifnull +25 -> 1900
    //   1878: aload_0
    //   1879: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1882: invokevirtual 80	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   1885: ifne +10 -> 1895
    //   1888: aload_0
    //   1889: getfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1892: invokevirtual 83	org/apache/http/client/methods/HttpGet:abort	()V
    //   1895: aload_0
    //   1896: aconst_null
    //   1897: putfield 45	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   1900: aload_0
    //   1901: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1904: ifnull +22 -> 1926
    //   1907: aload_0
    //   1908: getfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1911: invokeinterface 744 1 0
    //   1916: invokeinterface 767 1 0
    //   1921: aload_0
    //   1922: aconst_null
    //   1923: putfield 43	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mHttpClient	Lorg/apache/http/client/HttpClient;
    //   1926: iload 4
    //   1928: istore_2
    //   1929: aload_0
    //   1930: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1933: ifnull +251 -> 2184
    //   1936: aload_0
    //   1937: getfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1940: invokevirtual 352	com/tencent/tmassistantsdk/storage/TMAssistantFile:close	()V
    //   1943: aload_0
    //   1944: aconst_null
    //   1945: putfield 329	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mSaveFile	Lcom/tencent/tmassistantsdk/storage/TMAssistantFile;
    //   1948: iload 4
    //   1950: istore_2
    //   1951: goto -1917 -> 34
    //   1954: ldc 10
    //   1956: new 99	java/lang/StringBuilder
    //   1959: dup
    //   1960: ldc_w 796
    //   1963: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1966: invokestatic 119	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1969: invokevirtual 123	java/lang/Thread:getName	()Ljava/lang/String;
    //   1972: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1975: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1978: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1981: ldc 10
    //   1983: aload_1
    //   1984: ldc_w 259
    //   1987: iconst_0
    //   1988: anewarray 4	java/lang/Object
    //   1991: invokestatic 265	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1994: aload_0
    //   1995: invokespecial 776	com/tencent/tmassistantsdk/downloadservice/DownloadTask:shouldRetryConnect	()Z
    //   1998: istore_2
    //   1999: iload_2
    //   2000: istore 4
    //   2002: iload_2
    //   2003: ifne -132 -> 1871
    //   2006: aload_0
    //   2007: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   2010: sipush 604
    //   2013: putfield 561	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   2016: iload_2
    //   2017: istore 4
    //   2019: goto -148 -> 1871
    //   2022: ldc 10
    //   2024: new 99	java/lang/StringBuilder
    //   2027: dup
    //   2028: ldc_w 545
    //   2031: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2034: aload_0
    //   2035: getfield 41	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   2038: invokevirtual 548	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2041: ldc 110
    //   2043: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2046: invokestatic 119	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2049: invokevirtual 123	java/lang/Thread:getName	()Ljava/lang/String;
    //   2052: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2055: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2058: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2061: aload_0
    //   2062: getfield 41	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mStopTask	Z
    //   2065: ifne +108 -> 2173
    //   2068: ldc 10
    //   2070: new 99	java/lang/StringBuilder
    //   2073: dup
    //   2074: ldc_w 798
    //   2077: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2080: invokestatic 119	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2083: invokevirtual 123	java/lang/Thread:getName	()Ljava/lang/String;
    //   2086: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2089: ldc_w 800
    //   2092: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2095: aload_0
    //   2096: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   2099: getfield 803	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mStatus	I
    //   2102: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2105: ldc_w 805
    //   2108: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2111: aload_0
    //   2112: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   2115: getfield 561	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   2118: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2121: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2124: invokestatic 131	com/tencent/tmassistantsdk/util/TMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2127: aload_0
    //   2128: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   2131: invokevirtual 772	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:hasReceivedAllDataBytes	()Z
    //   2134: ifeq +27 -> 2161
    //   2137: aload_0
    //   2138: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   2141: iconst_4
    //   2142: iload_3
    //   2143: invokevirtual 642	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:updateStatus	(IZ)V
    //   2146: aload_0
    //   2147: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   2150: iconst_0
    //   2151: putfield 638	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mTaskIsRunning	Z
    //   2154: ldc_w 635
    //   2157: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2160: return
    //   2161: aload_0
    //   2162: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   2165: iconst_5
    //   2166: iload_3
    //   2167: invokevirtual 642	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:updateStatus	(IZ)V
    //   2170: goto -24 -> 2146
    //   2173: aload_0
    //   2174: getfield 47	com/tencent/tmassistantsdk/downloadservice/DownloadTask:mDownloadInfo	Lcom/tencent/tmassistantsdk/downloadservice/DownloadInfo;
    //   2177: iconst_0
    //   2178: putfield 561	com/tencent/tmassistantsdk/downloadservice/DownloadInfo:mDownloadFailedErrCode	I
    //   2181: goto -35 -> 2146
    //   2184: goto -2150 -> 34
    //   2187: iload_2
    //   2188: istore_3
    //   2189: iload 4
    //   2191: istore_2
    //   2192: goto -2158 -> 34
    //   2195: iconst_0
    //   2196: istore_2
    //   2197: goto -2163 -> 34
    //   2200: iload_3
    //   2201: istore_2
    //   2202: iconst_0
    //   2203: istore 4
    //   2205: goto -631 -> 1574
    //   2208: iload_3
    //   2209: istore_2
    //   2210: iconst_0
    //   2211: istore 4
    //   2213: goto -639 -> 1574
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2216	0	this	DownloadTask
    //   0	2216	1	paramString	String
    //   33	2177	2	bool1	boolean
    //   31	2178	3	bool2	boolean
    //   414	1798	4	bool3	boolean
    //   45	479	5	localDownloadChunkLogInfo	DownloadChunkLogInfo
    // Exception table:
    //   from	to	target	type
    //   88	112	403	org/apache/http/conn/ConnectTimeoutException
    //   116	127	403	org/apache/http/conn/ConnectTimeoutException
    //   127	132	403	org/apache/http/conn/ConnectTimeoutException
    //   132	317	403	org/apache/http/conn/ConnectTimeoutException
    //   317	358	403	org/apache/http/conn/ConnectTimeoutException
    //   362	403	403	org/apache/http/conn/ConnectTimeoutException
    //   499	510	403	org/apache/http/conn/ConnectTimeoutException
    //   513	518	403	org/apache/http/conn/ConnectTimeoutException
    //   521	536	403	org/apache/http/conn/ConnectTimeoutException
    //   88	112	700	finally
    //   116	127	700	finally
    //   127	132	700	finally
    //   132	317	700	finally
    //   317	358	700	finally
    //   362	403	700	finally
    //   404	409	700	finally
    //   499	510	700	finally
    //   513	518	700	finally
    //   521	536	700	finally
    //   632	677	700	finally
    //   684	694	700	finally
    //   784	789	700	finally
    //   879	924	700	finally
    //   931	941	700	finally
    //   948	953	700	finally
    //   1043	1088	700	finally
    //   1095	1105	700	finally
    //   1112	1117	700	finally
    //   1200	1250	700	finally
    //   1254	1259	700	finally
    //   1342	1392	700	finally
    //   1396	1401	700	finally
    //   1491	1536	700	finally
    //   1543	1553	700	finally
    //   1560	1565	700	finally
    //   1656	1749	700	finally
    //   1752	1794	700	finally
    //   1802	1812	700	finally
    //   1816	1839	700	finally
    //   1847	1853	700	finally
    //   1859	1864	700	finally
    //   1954	1999	700	finally
    //   2006	2016	700	finally
    //   88	112	783	java/net/SocketTimeoutException
    //   116	127	783	java/net/SocketTimeoutException
    //   127	132	783	java/net/SocketTimeoutException
    //   132	317	783	java/net/SocketTimeoutException
    //   317	358	783	java/net/SocketTimeoutException
    //   362	403	783	java/net/SocketTimeoutException
    //   499	510	783	java/net/SocketTimeoutException
    //   513	518	783	java/net/SocketTimeoutException
    //   521	536	783	java/net/SocketTimeoutException
    //   88	112	947	java/net/UnknownHostException
    //   116	127	947	java/net/UnknownHostException
    //   127	132	947	java/net/UnknownHostException
    //   132	317	947	java/net/UnknownHostException
    //   317	358	947	java/net/UnknownHostException
    //   362	403	947	java/net/UnknownHostException
    //   499	510	947	java/net/UnknownHostException
    //   513	518	947	java/net/UnknownHostException
    //   521	536	947	java/net/UnknownHostException
    //   88	112	1111	java/lang/InterruptedException
    //   116	127	1111	java/lang/InterruptedException
    //   127	132	1111	java/lang/InterruptedException
    //   132	317	1111	java/lang/InterruptedException
    //   317	358	1111	java/lang/InterruptedException
    //   362	403	1111	java/lang/InterruptedException
    //   499	510	1111	java/lang/InterruptedException
    //   513	518	1111	java/lang/InterruptedException
    //   521	536	1111	java/lang/InterruptedException
    //   88	112	1253	javax/net/ssl/SSLHandshakeException
    //   116	127	1253	javax/net/ssl/SSLHandshakeException
    //   127	132	1253	javax/net/ssl/SSLHandshakeException
    //   132	317	1253	javax/net/ssl/SSLHandshakeException
    //   317	358	1253	javax/net/ssl/SSLHandshakeException
    //   362	403	1253	javax/net/ssl/SSLHandshakeException
    //   499	510	1253	javax/net/ssl/SSLHandshakeException
    //   513	518	1253	javax/net/ssl/SSLHandshakeException
    //   521	536	1253	javax/net/ssl/SSLHandshakeException
    //   88	112	1395	java/io/IOException
    //   116	127	1395	java/io/IOException
    //   127	132	1395	java/io/IOException
    //   132	317	1395	java/io/IOException
    //   317	358	1395	java/io/IOException
    //   362	403	1395	java/io/IOException
    //   499	510	1395	java/io/IOException
    //   513	518	1395	java/io/IOException
    //   521	536	1395	java/io/IOException
    //   88	112	1559	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   116	127	1559	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   127	132	1559	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   132	317	1559	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   317	358	1559	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   362	403	1559	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   499	510	1559	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   513	518	1559	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   521	536	1559	com/tencent/tmassistantsdk/downloadservice/StopRequestException
    //   88	112	1858	java/lang/Throwable
    //   116	127	1858	java/lang/Throwable
    //   127	132	1858	java/lang/Throwable
    //   132	317	1858	java/lang/Throwable
    //   317	358	1858	java/lang/Throwable
    //   362	403	1858	java/lang/Throwable
    //   499	510	1858	java/lang/Throwable
    //   513	518	1858	java/lang/Throwable
    //   521	536	1858	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.DownloadTask
 * JD-Core Version:    0.7.0.1
 */