package org.xwalk.core;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.downloader.WXFileDownloaderBridge;
import com.tencent.xweb.downloader.a;
import com.tencent.xweb.downloader.c;
import com.tencent.xweb.xwalk.updater.UpdateConfig;
import java.io.File;

public class XWebDownloader
{
  private static final int DOWNLOAD_TYPE_CDN = 2;
  private static final int DOWNLOAD_TYPE_HTTP = 1;
  private static final int ERROR_CODE_DOWNLOADER_TIMEOUT = -100;
  private static final int ERROR_CODE_EXCEPTION = -101;
  private static final int ERROR_CODE_FAILED = -1;
  private static final int ERROR_CODE_SUCCESS = 0;
  private static final int ERROR_TYPE_DOWNLOADER = 1;
  private static final int ERROR_TYPE_NONE = 0;
  private static final int ERROR_TYPE_USER = 2;
  private static final String TAG = "XWebDownloader";
  private static AsyncTask<Void, Integer, Integer> sDownloadTask;
  
  public static boolean isDownloading()
  {
    return sDownloadTask instanceof HttpDownloadTask;
  }
  
  public static void startDownload(DownloadListener paramDownloadListener, Context paramContext, UpdateConfig paramUpdateConfig)
  {
    AppMethodBeat.i(187521);
    paramContext = paramUpdateConfig.aiqM;
    String str = paramUpdateConfig.gEb();
    if (paramUpdateConfig.ailq) {}
    for (int i = 2;; i = 1)
    {
      paramContext = new WXFileDownloaderTask(true, paramDownloadListener, paramContext, str, i);
      if ((!paramUpdateConfig.aiiL) || (!paramContext.isValid())) {
        break;
      }
      Log.i("XWebDownloader", "startDownload, use wx file downloader");
      paramContext.execute(new Void[0]);
      AppMethodBeat.o(187521);
      return;
    }
    Log.i("XWebDownloader", "startDownload, use default file downloader");
    new HttpDownloadTask(true, paramDownloadListener, paramUpdateConfig.aiqM, paramUpdateConfig.gEb()).execute(new Void[0]);
    AppMethodBeat.o(187521);
  }
  
  public static class DownloadInfo
  {
    public int mBizType = 0;
    public int mDownloadType = 1;
    public int mErrorCode = 0;
    public int mErrorType = 0;
    public long mFileTotalSize = 0L;
    public boolean mIsDownloadResume = false;
    public boolean mIsRuntime = false;
    public int mNetWorkType = 0;
    public int mRetryTimes = 0;
    public String mSavePath = "";
    public long mStartTimestamp = 0L;
    public String mUrl = "";
  }
  
  public static abstract interface DownloadListener
  {
    public abstract void onDownloadCancelled();
    
    public abstract void onDownloadCompleted(XWebDownloader.DownloadInfo paramDownloadInfo);
    
    public abstract void onDownloadFailed(XWebDownloader.DownloadInfo paramDownloadInfo);
    
    public abstract void onDownloadStarted(int paramInt);
    
    public abstract void onDownloadUpdated(int paramInt);
  }
  
  public static class HttpDownloadTask
    extends AsyncTask<Void, Integer, Integer>
  {
    private static final int DOWNLOAD_FAILED = -1;
    private static final int DOWNLOAD_SUCCESS = 0;
    public static final String TAG_TASK = "HttpDownloadTask";
    private static final int UPDATE_INTERVAL_MS = 500;
    private XWebDownloader.DownloadInfo mDownloadInfo;
    private File mDownloadedFile;
    private XWebDownloader.DownloadListener mListener;
    private long mProgressUpdateTime;
    
    public HttpDownloadTask(boolean paramBoolean, XWebDownloader.DownloadListener paramDownloadListener, String paramString1, String paramString2)
    {
      AppMethodBeat.i(187498);
      this.mListener = paramDownloadListener;
      this.mDownloadInfo = new XWebDownloader.DownloadInfo();
      this.mDownloadInfo.mErrorType = 0;
      this.mDownloadInfo.mErrorCode = 0;
      this.mDownloadInfo.mDownloadType = 1;
      this.mDownloadInfo.mUrl = paramString1;
      this.mDownloadInfo.mSavePath = paramString2;
      this.mDownloadInfo.mIsRuntime = paramBoolean;
      AppMethodBeat.o(187498);
    }
    
    /* Error */
    protected Integer doInBackground(Void... paramVarArgs)
    {
      // Byte code:
      //   0: ldc 73
      //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 40	org/xwalk/core/XWebDownloader$HttpDownloadTask:mListener	Lorg/xwalk/core/XWebDownloader$DownloadListener;
      //   9: ifnull +19 -> 28
      //   12: aload_0
      //   13: getfield 40	org/xwalk/core/XWebDownloader$HttpDownloadTask:mListener	Lorg/xwalk/core/XWebDownloader$DownloadListener;
      //   16: aload_0
      //   17: getfield 45	org/xwalk/core/XWebDownloader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWebDownloader$DownloadInfo;
      //   20: getfield 54	org/xwalk/core/XWebDownloader$DownloadInfo:mDownloadType	I
      //   23: invokeinterface 78 2 0
      //   28: aload_0
      //   29: getfield 45	org/xwalk/core/XWebDownloader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWebDownloader$DownloadInfo;
      //   32: invokestatic 84	java/lang/System:currentTimeMillis	()J
      //   35: putfield 87	org/xwalk/core/XWebDownloader$DownloadInfo:mStartTimestamp	J
      //   38: invokestatic 93	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
      //   41: astore_1
      //   42: aload_0
      //   43: getfield 45	org/xwalk/core/XWebDownloader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWebDownloader$DownloadInfo;
      //   46: aload_1
      //   47: invokestatic 99	org/xwalk/core/NetworkUtil:getCurrentNetWorkStatus	(Landroid/content/Context;)I
      //   50: putfield 102	org/xwalk/core/XWebDownloader$DownloadInfo:mNetWorkType	I
      //   53: aconst_null
      //   54: astore 14
      //   56: aconst_null
      //   57: astore_1
      //   58: lconst_0
      //   59: lstore 4
      //   61: aload_1
      //   62: astore 13
      //   64: new 104	java/net/URL
      //   67: dup
      //   68: aload_0
      //   69: getfield 45	org/xwalk/core/XWebDownloader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWebDownloader$DownloadInfo;
      //   72: getfield 57	org/xwalk/core/XWebDownloader$DownloadInfo:mUrl	Ljava/lang/String;
      //   75: invokespecial 107	java/net/URL:<init>	(Ljava/lang/String;)V
      //   78: astore 15
      //   80: aload_1
      //   81: astore 13
      //   83: aload 15
      //   85: invokevirtual 111	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   88: checkcast 113	java/net/HttpURLConnection
      //   91: astore 12
      //   93: aload 12
      //   95: astore_1
      //   96: aload 12
      //   98: sipush 30000
      //   101: invokevirtual 116	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   104: aload 12
      //   106: astore_1
      //   107: aload 12
      //   109: sipush 30000
      //   112: invokevirtual 119	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   115: aload 12
      //   117: astore_1
      //   118: aload 12
      //   120: invokevirtual 122	java/net/HttpURLConnection:connect	()V
      //   123: aload 12
      //   125: astore_1
      //   126: aload 12
      //   128: invokevirtual 126	java/net/HttpURLConnection:getResponseCode	()I
      //   131: sipush 200
      //   134: if_icmpeq +78 -> 212
      //   137: aload 12
      //   139: astore_1
      //   140: aload 12
      //   142: invokevirtual 126	java/net/HttpURLConnection:getResponseCode	()I
      //   145: sipush 206
      //   148: if_icmpeq +64 -> 212
      //   151: aload 12
      //   153: astore_1
      //   154: ldc 16
      //   156: new 128	java/lang/StringBuilder
      //   159: dup
      //   160: ldc 130
      //   162: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   165: aload 12
      //   167: invokevirtual 126	java/net/HttpURLConnection:getResponseCode	()I
      //   170: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   173: ldc 137
      //   175: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   178: aload 12
      //   180: invokevirtual 144	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
      //   183: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   186: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   189: invokestatic 153	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   192: aload 12
      //   194: ifnull +8 -> 202
      //   197: aload 12
      //   199: invokevirtual 156	java/net/HttpURLConnection:disconnect	()V
      //   202: ldc 73
      //   204: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   207: iconst_m1
      //   208: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   211: areturn
      //   212: aload 12
      //   214: astore_1
      //   215: aload 12
      //   217: invokevirtual 165	java/net/HttpURLConnection:getContentLength	()I
      //   220: istore_2
      //   221: aload 12
      //   223: astore_1
      //   224: aload_0
      //   225: getfield 167	org/xwalk/core/XWebDownloader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
      //   228: invokevirtual 173	java/io/File:exists	()Z
      //   231: ifeq +654 -> 885
      //   234: aload 12
      //   236: astore_1
      //   237: aload_0
      //   238: getfield 167	org/xwalk/core/XWebDownloader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
      //   241: invokevirtual 176	java/io/File:length	()J
      //   244: lstore 4
      //   246: iload_2
      //   247: i2l
      //   248: lload 4
      //   250: lcmp
      //   251: ifne +33 -> 284
      //   254: aload 12
      //   256: astore_1
      //   257: ldc 16
      //   259: ldc 178
      //   261: invokestatic 180	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   264: aload 12
      //   266: ifnull +8 -> 274
      //   269: aload 12
      //   271: invokevirtual 156	java/net/HttpURLConnection:disconnect	()V
      //   274: ldc 73
      //   276: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   279: iconst_0
      //   280: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   283: areturn
      //   284: lload 4
      //   286: lconst_0
      //   287: lcmp
      //   288: ifle +24 -> 312
      //   291: aload 12
      //   293: astore_1
      //   294: aload_0
      //   295: getfield 45	org/xwalk/core/XWebDownloader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWebDownloader$DownloadInfo;
      //   298: iconst_1
      //   299: putfield 183	org/xwalk/core/XWebDownloader$DownloadInfo:mIsDownloadResume	Z
      //   302: aload 12
      //   304: astore_1
      //   305: ldc 16
      //   307: ldc 185
      //   309: invokestatic 180	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   312: aload 12
      //   314: astore_1
      //   315: aload 12
      //   317: invokevirtual 156	java/net/HttpURLConnection:disconnect	()V
      //   320: aload 12
      //   322: astore_1
      //   323: aload 15
      //   325: invokevirtual 111	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   328: checkcast 113	java/net/HttpURLConnection
      //   331: astore 12
      //   333: aload 12
      //   335: astore_1
      //   336: aload 12
      //   338: sipush 30000
      //   341: invokevirtual 116	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   344: aload 12
      //   346: astore_1
      //   347: aload 12
      //   349: sipush 30000
      //   352: invokevirtual 119	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   355: aload 12
      //   357: astore_1
      //   358: aload 12
      //   360: ldc 187
      //   362: new 128	java/lang/StringBuilder
      //   365: dup
      //   366: ldc 189
      //   368: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   371: lload 4
      //   373: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   376: ldc 194
      //   378: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   381: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   384: invokevirtual 197	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   387: aload 12
      //   389: astore_1
      //   390: ldc 16
      //   392: ldc 199
      //   394: lload 4
      //   396: invokestatic 204	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   399: invokevirtual 208	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   402: invokestatic 180	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   405: aload 12
      //   407: astore_1
      //   408: aload 12
      //   410: invokevirtual 122	java/net/HttpURLConnection:connect	()V
      //   413: aload 12
      //   415: astore_1
      //   416: aload 12
      //   418: invokevirtual 126	java/net/HttpURLConnection:getResponseCode	()I
      //   421: sipush 200
      //   424: if_icmpeq +78 -> 502
      //   427: aload 12
      //   429: astore_1
      //   430: aload 12
      //   432: invokevirtual 126	java/net/HttpURLConnection:getResponseCode	()I
      //   435: sipush 206
      //   438: if_icmpeq +64 -> 502
      //   441: aload 12
      //   443: astore_1
      //   444: ldc 16
      //   446: new 128	java/lang/StringBuilder
      //   449: dup
      //   450: ldc 130
      //   452: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   455: aload 12
      //   457: invokevirtual 126	java/net/HttpURLConnection:getResponseCode	()I
      //   460: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   463: ldc 137
      //   465: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   468: aload 12
      //   470: invokevirtual 144	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
      //   473: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   476: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   479: invokestatic 153	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   482: aload 12
      //   484: ifnull +8 -> 492
      //   487: aload 12
      //   489: invokevirtual 156	java/net/HttpURLConnection:disconnect	()V
      //   492: ldc 73
      //   494: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   497: iconst_m1
      //   498: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   501: areturn
      //   502: aload 12
      //   504: astore_1
      //   505: aload 12
      //   507: invokevirtual 165	java/net/HttpURLConnection:getContentLength	()I
      //   510: istore_2
      //   511: aload 12
      //   513: astore_1
      //   514: aload_1
      //   515: astore 13
      //   517: aload_1
      //   518: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   521: astore 12
      //   523: aload 12
      //   525: astore 13
      //   527: new 214	java/io/FileOutputStream
      //   530: dup
      //   531: aload_0
      //   532: getfield 167	org/xwalk/core/XWebDownloader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
      //   535: iconst_1
      //   536: invokespecial 217	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   539: astore 15
      //   541: sipush 4096
      //   544: newarray byte
      //   546: astore 12
      //   548: lconst_0
      //   549: lstore 6
      //   551: aload 13
      //   553: aload 12
      //   555: invokevirtual 223	java/io/InputStream:read	([B)I
      //   558: istore_3
      //   559: iload_3
      //   560: iconst_m1
      //   561: if_icmpeq +186 -> 747
      //   564: aload_0
      //   565: invokevirtual 226	org/xwalk/core/XWebDownloader$HttpDownloadTask:isCancelled	()Z
      //   568: ifeq +36 -> 604
      //   571: aload 15
      //   573: invokevirtual 231	java/io/OutputStream:close	()V
      //   576: aload 13
      //   578: ifnull +8 -> 586
      //   581: aload 13
      //   583: invokevirtual 232	java/io/InputStream:close	()V
      //   586: aload_1
      //   587: ifnull +7 -> 594
      //   590: aload_1
      //   591: invokevirtual 156	java/net/HttpURLConnection:disconnect	()V
      //   594: ldc 73
      //   596: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   599: iconst_m1
      //   600: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   603: areturn
      //   604: lload 6
      //   606: iload_3
      //   607: i2l
      //   608: ladd
      //   609: lstore 8
      //   611: aload 15
      //   613: aload 12
      //   615: iconst_0
      //   616: iload_3
      //   617: invokevirtual 236	java/io/OutputStream:write	([BII)V
      //   620: invokestatic 241	android/os/SystemClock:uptimeMillis	()J
      //   623: lstore 10
      //   625: lload 8
      //   627: lstore 6
      //   629: lload 10
      //   631: aload_0
      //   632: getfield 243	org/xwalk/core/XWebDownloader$HttpDownloadTask:mProgressUpdateTime	J
      //   635: lsub
      //   636: ldc2_w 244
      //   639: lcmp
      //   640: ifle -89 -> 551
      //   643: aload_0
      //   644: lload 10
      //   646: putfield 243	org/xwalk/core/XWebDownloader$HttpDownloadTask:mProgressUpdateTime	J
      //   649: aload_0
      //   650: iconst_2
      //   651: anewarray 158	java/lang/Integer
      //   654: dup
      //   655: iconst_0
      //   656: lload 8
      //   658: lload 4
      //   660: ladd
      //   661: l2i
      //   662: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   665: aastore
      //   666: dup
      //   667: iconst_1
      //   668: iload_2
      //   669: i2l
      //   670: lload 4
      //   672: ladd
      //   673: l2i
      //   674: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   677: aastore
      //   678: invokevirtual 249	org/xwalk/core/XWebDownloader$HttpDownloadTask:publishProgress	([Ljava/lang/Object;)V
      //   681: lload 8
      //   683: lstore 6
      //   685: goto -134 -> 551
      //   688: astore 12
      //   690: aload 15
      //   692: astore 14
      //   694: ldc 251
      //   696: ldc 253
      //   698: aload 12
      //   700: invokestatic 256	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   703: invokevirtual 208	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   706: invokestatic 153	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   709: aload 14
      //   711: ifnull +8 -> 719
      //   714: aload 14
      //   716: invokevirtual 231	java/io/OutputStream:close	()V
      //   719: aload 13
      //   721: ifnull +8 -> 729
      //   724: aload 13
      //   726: invokevirtual 232	java/io/InputStream:close	()V
      //   729: aload_1
      //   730: ifnull +7 -> 737
      //   733: aload_1
      //   734: invokevirtual 156	java/net/HttpURLConnection:disconnect	()V
      //   737: ldc 73
      //   739: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   742: iconst_m1
      //   743: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   746: areturn
      //   747: aload 15
      //   749: invokevirtual 259	java/io/OutputStream:flush	()V
      //   752: aload 15
      //   754: invokevirtual 231	java/io/OutputStream:close	()V
      //   757: aload 13
      //   759: ifnull +8 -> 767
      //   762: aload 13
      //   764: invokevirtual 232	java/io/InputStream:close	()V
      //   767: aload_1
      //   768: ifnull +7 -> 775
      //   771: aload_1
      //   772: invokevirtual 156	java/net/HttpURLConnection:disconnect	()V
      //   775: aload_0
      //   776: getfield 45	org/xwalk/core/XWebDownloader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWebDownloader$DownloadInfo;
      //   779: aload_0
      //   780: getfield 167	org/xwalk/core/XWebDownloader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
      //   783: invokevirtual 176	java/io/File:length	()J
      //   786: putfield 262	org/xwalk/core/XWebDownloader$DownloadInfo:mFileTotalSize	J
      //   789: ldc 73
      //   791: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   794: iconst_0
      //   795: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   798: areturn
      //   799: astore 12
      //   801: aload 14
      //   803: ifnull +8 -> 811
      //   806: aload 14
      //   808: invokevirtual 231	java/io/OutputStream:close	()V
      //   811: aload 13
      //   813: ifnull +8 -> 821
      //   816: aload 13
      //   818: invokevirtual 232	java/io/InputStream:close	()V
      //   821: aload_1
      //   822: ifnull +7 -> 829
      //   825: aload_1
      //   826: invokevirtual 156	java/net/HttpURLConnection:disconnect	()V
      //   829: ldc 73
      //   831: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   834: aload 12
      //   836: athrow
      //   837: astore 13
      //   839: goto -18 -> 821
      //   842: astore 12
      //   844: goto -115 -> 729
      //   847: astore 12
      //   849: aconst_null
      //   850: astore 15
      //   852: aload 13
      //   854: astore_1
      //   855: aload 15
      //   857: astore 13
      //   859: goto -165 -> 694
      //   862: astore 12
      //   864: aconst_null
      //   865: astore 13
      //   867: goto -173 -> 694
      //   870: astore 12
      //   872: goto -178 -> 694
      //   875: astore 12
      //   877: goto -110 -> 767
      //   880: astore 12
      //   882: goto -296 -> 586
      //   885: aload 12
      //   887: astore_1
      //   888: goto -374 -> 514
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	891	0	this	HttpDownloadTask
      //   0	891	1	paramVarArgs	Void[]
      //   220	449	2	i	int
      //   558	59	3	j	int
      //   59	612	4	l1	long
      //   549	135	6	l2	long
      //   609	73	8	l3	long
      //   623	22	10	l4	long
      //   91	523	12	localObject1	Object
      //   688	11	12	localObject2	Object
      //   799	36	12	localObject3	Object
      //   842	1	12	localIOException1	java.io.IOException
      //   847	1	12	localObject4	Object
      //   862	1	12	localObject5	Object
      //   870	1	12	localObject6	Object
      //   875	1	12	localIOException2	java.io.IOException
      //   880	6	12	localIOException3	java.io.IOException
      //   62	755	13	localObject7	Object
      //   837	16	13	localIOException4	java.io.IOException
      //   857	9	13	localObject8	Object
      //   54	753	14	localObject9	Object
      //   78	778	15	localObject10	Object
      // Exception table:
      //   from	to	target	type
      //   541	548	688	finally
      //   551	559	688	finally
      //   564	571	688	finally
      //   611	625	688	finally
      //   629	681	688	finally
      //   747	752	688	finally
      //   694	709	799	finally
      //   806	811	837	java/io/IOException
      //   816	821	837	java/io/IOException
      //   714	719	842	java/io/IOException
      //   724	729	842	java/io/IOException
      //   64	80	847	finally
      //   83	93	847	finally
      //   517	523	847	finally
      //   96	104	862	finally
      //   107	115	862	finally
      //   118	123	862	finally
      //   126	137	862	finally
      //   140	151	862	finally
      //   154	192	862	finally
      //   215	221	862	finally
      //   224	234	862	finally
      //   237	246	862	finally
      //   257	264	862	finally
      //   294	302	862	finally
      //   305	312	862	finally
      //   315	320	862	finally
      //   323	333	862	finally
      //   336	344	862	finally
      //   347	355	862	finally
      //   358	387	862	finally
      //   390	405	862	finally
      //   408	413	862	finally
      //   416	427	862	finally
      //   430	441	862	finally
      //   444	482	862	finally
      //   505	511	862	finally
      //   527	541	870	finally
      //   752	757	875	java/io/IOException
      //   762	767	875	java/io/IOException
      //   571	576	880	java/io/IOException
      //   581	586	880	java/io/IOException
    }
    
    protected void onCancelled(Integer paramInteger)
    {
      AppMethodBeat.i(187518);
      if (this.mDownloadInfo.mIsRuntime)
      {
        XWebDownloader.access$002(null);
        Log.i("HttpDownloadTask", "runtime onCancelled");
      }
      for (;;)
      {
        if (this.mListener != null) {
          this.mListener.onDownloadCancelled();
        }
        AppMethodBeat.o(187518);
        return;
        Log.i("HttpDownloadTask", "plugin onCancelled");
      }
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      AppMethodBeat.i(187524);
      if (this.mDownloadInfo.mIsRuntime)
      {
        XWebDownloader.access$002(null);
        Log.i("HttpDownloadTask", "runtime onPostExecute result:".concat(String.valueOf(paramInteger)));
      }
      while (paramInteger.intValue() == 0)
      {
        this.mDownloadInfo.mErrorCode = 0;
        if (this.mListener == null) {
          break label124;
        }
        this.mListener.onDownloadCompleted(this.mDownloadInfo);
        AppMethodBeat.o(187524);
        return;
        Log.i("HttpDownloadTask", "plugin onPostExecute result:".concat(String.valueOf(paramInteger)));
      }
      this.mDownloadInfo.mErrorCode = -1;
      if (this.mListener != null) {
        this.mListener.onDownloadFailed(this.mDownloadInfo);
      }
      label124:
      AppMethodBeat.o(187524);
    }
    
    protected void onPreExecute()
    {
      AppMethodBeat.i(187503);
      if (this.mDownloadInfo.mIsRuntime)
      {
        XWebDownloader.access$002(this);
        Log.i("HttpDownloadTask", "runtime onPreExecute, savePath:" + this.mDownloadInfo.mSavePath);
      }
      for (;;)
      {
        this.mDownloadedFile = new File(this.mDownloadInfo.mSavePath);
        AppMethodBeat.o(187503);
        return;
        Log.i("HttpDownloadTask", "plugin onPreExecute, savePath:" + this.mDownloadInfo.mSavePath);
      }
    }
    
    protected void onProgressUpdate(Integer... paramVarArgs)
    {
      int i = 0;
      AppMethodBeat.i(187515);
      Log.d("HttpDownloadTask", "onProgressUpdate: " + paramVarArgs[0] + "/" + paramVarArgs[1]);
      if (paramVarArgs[1].intValue() > 0) {
        i = (int)(paramVarArgs[0].intValue() * 100.0D / paramVarArgs[1].intValue());
      }
      if (this.mListener != null) {
        this.mListener.onDownloadUpdated(i);
      }
      AppMethodBeat.o(187515);
    }
  }
  
  public static class WXFileDownloaderTask
    extends AsyncTask<Void, Integer, Integer>
    implements c
  {
    private static final int DOWNLOAD_FAILED = -1;
    private static final int DOWNLOAD_SUCCESS = 0;
    public static final String TAG_TASK = "WXFileDownloaderTask";
    private final Object lockObj;
    private XWebDownloader.DownloadInfo mDownloadInfo;
    private XWebDownloader.DownloadListener mListener;
    private WXFileDownloaderBridge mWXFileDownloaderBridge;
    private boolean mWaitTimeout;
    
    public WXFileDownloaderTask(boolean paramBoolean, XWebDownloader.DownloadListener paramDownloadListener, String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(187508);
      this.lockObj = new Object();
      this.mWaitTimeout = false;
      this.mListener = paramDownloadListener;
      this.mDownloadInfo = new XWebDownloader.DownloadInfo();
      this.mDownloadInfo.mErrorType = 0;
      this.mDownloadInfo.mErrorCode = 0;
      this.mDownloadInfo.mDownloadType = 2;
      this.mDownloadInfo.mUrl = paramString1;
      this.mDownloadInfo.mSavePath = paramString2;
      this.mDownloadInfo.mIsRuntime = paramBoolean;
      this.mDownloadInfo.mBizType = paramInt;
      this.mWXFileDownloaderBridge = new WXFileDownloaderBridge();
      this.mWXFileDownloaderBridge.aigs = this;
      AppMethodBeat.o(187508);
    }
    
    protected Integer doInBackground(Void... arg1)
    {
      AppMethodBeat.i(187525);
      if (this.mListener != null) {
        this.mListener.onDownloadStarted(this.mDownloadInfo.mDownloadType);
      }
      this.mDownloadInfo.mStartTimestamp = System.currentTimeMillis();
      ??? = XWalkEnvironment.getApplicationContext();
      this.mDownloadInfo.mNetWorkType = NetworkUtil.getCurrentNetWorkStatus(???);
      if ((this.mWXFileDownloaderBridge == null) || (!WXFileDownloaderBridge.isValid()))
      {
        this.mDownloadInfo.mErrorType = 2;
        this.mDownloadInfo.mErrorCode = -1;
        AppMethodBeat.o(187525);
        return Integer.valueOf(-1);
      }
      ??? = this.mWXFileDownloaderBridge;
      String str1 = this.mDownloadInfo.mUrl;
      String str2 = this.mDownloadInfo.mSavePath;
      int i = this.mDownloadInfo.mBizType;
      if (WXFileDownloaderBridge.aigr != null) {}
      for (i = WXFileDownloaderBridge.aigr.a(str1, str2, i, ???);; i = -1)
      {
        if (i != 0)
        {
          this.mDownloadInfo.mErrorType = 1;
          this.mDownloadInfo.mErrorCode = -1;
          AppMethodBeat.o(187525);
          return Integer.valueOf(-1);
        }
        synchronized (this.lockObj)
        {
          try
          {
            this.mWaitTimeout = true;
            this.lockObj.wait(600000L);
            if (this.mWaitTimeout)
            {
              this.mDownloadInfo.mErrorType = 1;
              this.mDownloadInfo.mErrorCode = -100;
            }
            if ((this.mDownloadInfo.mErrorType == 0) && (this.mDownloadInfo.mErrorCode == 0))
            {
              AppMethodBeat.o(187525);
              return Integer.valueOf(0);
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              Log.e("WXFileDownloaderTask", "download error:".concat(String.valueOf(localInterruptedException)));
              this.mWaitTimeout = false;
              this.mDownloadInfo.mErrorType = 2;
              this.mDownloadInfo.mErrorCode = -101;
            }
          }
        }
        Log.e("WXFileDownloaderTask", "download errorType:" + this.mDownloadInfo.mErrorType + ", errorcode:" + this.mDownloadInfo.mErrorCode + ", waitTimeout:" + this.mWaitTimeout);
        AppMethodBeat.o(187525);
        return Integer.valueOf(-1);
      }
    }
    
    public boolean isValid()
    {
      AppMethodBeat.i(187511);
      if (this.mWXFileDownloaderBridge == null)
      {
        AppMethodBeat.o(187511);
        return false;
      }
      boolean bool = WXFileDownloaderBridge.isValid();
      AppMethodBeat.o(187511);
      return bool;
    }
    
    protected void onCancelled(Integer paramInteger)
    {
      AppMethodBeat.i(187536);
      if (this.mDownloadInfo.mIsRuntime)
      {
        XWebDownloader.access$002(null);
        Log.i("WXFileDownloaderTask", "runtime onCancelled");
      }
      for (;;)
      {
        if (this.mListener != null) {
          this.mListener.onDownloadCancelled();
        }
        AppMethodBeat.o(187536);
        return;
        Log.i("WXFileDownloaderTask", "plugin onCancelled");
      }
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      AppMethodBeat.i(187539);
      if (this.mDownloadInfo.mIsRuntime)
      {
        XWebDownloader.access$002(null);
        Log.i("WXFileDownloaderTask", "runtime onPostExecute result:".concat(String.valueOf(paramInteger)));
      }
      while (paramInteger.intValue() == 0)
      {
        if (this.mListener == null) {
          break label104;
        }
        this.mListener.onDownloadCompleted(this.mDownloadInfo);
        AppMethodBeat.o(187539);
        return;
        Log.i("WXFileDownloaderTask", "plugin onPostExecute result:".concat(String.valueOf(paramInteger)));
      }
      if (this.mListener != null) {
        this.mListener.onDownloadFailed(this.mDownloadInfo);
      }
      label104:
      AppMethodBeat.o(187539);
    }
    
    protected void onPreExecute()
    {
      AppMethodBeat.i(187516);
      if (this.mDownloadInfo.mIsRuntime)
      {
        XWebDownloader.access$002(this);
        Log.i("WXFileDownloaderTask", "runtime onPreExecute, savePath:" + this.mDownloadInfo.mSavePath);
        AppMethodBeat.o(187516);
        return;
      }
      Log.i("WXFileDownloaderTask", "plugin onPreExecute, savePath:" + this.mDownloadInfo.mSavePath);
      AppMethodBeat.o(187516);
    }
    
    public void onProgressChange(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(187541);
      if (this.mDownloadInfo.mFileTotalSize != paramLong2) {
        this.mDownloadInfo.mFileTotalSize = paramLong2;
      }
      publishProgress(new Integer[] { Integer.valueOf((int)paramLong1), Integer.valueOf((int)paramLong2) });
      AppMethodBeat.o(187541);
    }
    
    protected void onProgressUpdate(Integer... paramVarArgs)
    {
      int i = 0;
      AppMethodBeat.i(187530);
      if (paramVarArgs[1].intValue() > 0) {
        i = (int)(paramVarArgs[0].intValue() * 100.0D / paramVarArgs[1].intValue());
      }
      if (this.mListener != null) {
        this.mListener.onDownloadUpdated(i);
      }
      AppMethodBeat.o(187530);
    }
    
    public void onTaskFail(String arg1, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(187555);
      synchronized (this.lockObj)
      {
        this.mDownloadInfo.mErrorType = 1;
        this.mDownloadInfo.mErrorCode = paramInt;
        this.mDownloadInfo.mIsDownloadResume = paramBoolean;
        this.mWaitTimeout = false;
        this.lockObj.notify();
        AppMethodBeat.o(187555);
        return;
      }
    }
    
    public void onTaskFinish(String arg1, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(187549);
      synchronized (this.lockObj)
      {
        this.mDownloadInfo.mIsDownloadResume = paramBoolean;
        this.mWaitTimeout = false;
        this.lockObj.notify();
        AppMethodBeat.o(187549);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWebDownloader
 * JD-Core Version:    0.7.0.1
 */