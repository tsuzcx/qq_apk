package org.xwalk.core;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.downloader.WXFileDownloaderBridge;
import com.tencent.xweb.downloader.a;
import com.tencent.xweb.downloader.c;
import java.io.File;

public class XWalkLibraryLoader
{
  private static final String DEFAULT_DOWNLOAD_FILE_NAME = "xwalk_download.tmp";
  private static final int DOWNLOAD_TYPE_CDN = 2;
  private static final int DOWNLOAD_TYPE_HTTP = 1;
  private static final String DOWNLOAD_WITHOUT_NOTIFICATION = "android.permission.DOWNLOAD_WITHOUT_NOTIFICATION";
  private static final int ERROR_CODE_DOWNLOADER_TIMEOUT = -100;
  private static final int ERROR_CODE_EXCEPTION = -101;
  private static final int ERROR_CODE_FAILED = -1;
  private static final int ERROR_CODE_SUCCESS = 0;
  private static final int ERROR_TYPE_DOWNLOADER = 1;
  private static final int ERROR_TYPE_NONE = 0;
  private static final int ERROR_TYPE_USER = 2;
  private static final String TAG = "XWalkLib";
  private static AsyncTask<Void, Integer, Integer> sActiveTask;
  
  public static boolean cancelHttpDownload()
  {
    AppMethodBeat.i(154796);
    if ((sActiveTask != null) && ((sActiveTask instanceof HttpDownloadTask)) && (sActiveTask.cancel(true)))
    {
      AppMethodBeat.o(154796);
      return true;
    }
    AppMethodBeat.o(154796);
    return false;
  }
  
  public static void finishInit(Context paramContext)
  {
    AppMethodBeat.i(154794);
    XWalkCoreWrapper.handlePostInit(paramContext.getClass().getName());
    AppMethodBeat.o(154794);
  }
  
  public static int getLibraryStatus()
  {
    AppMethodBeat.i(154792);
    int i = XWalkCoreWrapper.getCoreStatus();
    AppMethodBeat.o(154792);
    return i;
  }
  
  public static boolean isDownloading()
  {
    return (sActiveTask != null) && ((sActiveTask instanceof HttpDownloadTask));
  }
  
  public static boolean isInitializing()
  {
    return false;
  }
  
  public static boolean isLibraryReady()
  {
    AppMethodBeat.i(154791);
    if (XWalkCoreWrapper.getInstance() != null)
    {
      AppMethodBeat.o(154791);
      return true;
    }
    AppMethodBeat.o(154791);
    return false;
  }
  
  public static boolean isSharedLibrary()
  {
    AppMethodBeat.i(154790);
    boolean bool = XWalkCoreWrapper.getInstance().isSharedMode();
    AppMethodBeat.o(154790);
    return bool;
  }
  
  public static void prepareToInit(Context paramContext)
  {
    AppMethodBeat.i(154793);
    XWalkEnvironment.init(paramContext);
    XWalkCoreWrapper.handlePreInit(paramContext.getClass().getName());
    AppMethodBeat.o(154793);
  }
  
  public static void startHttpDownload(DownloadListener paramDownloadListener, Context paramContext, XWalkUpdater.UpdateConfig paramUpdateConfig)
  {
    AppMethodBeat.i(154795);
    paramContext = new WXFileDownloaderTask(true, paramDownloadListener, paramUpdateConfig.downUrl, paramUpdateConfig.getDownloadPath(), paramUpdateConfig.getUpdateBizType());
    if ((paramUpdateConfig.bUseCdn) && (paramContext.isValid()))
    {
      Log.i("XWalkLib", "use wx file downloader");
      paramContext.execute(new Void[0]);
      AppMethodBeat.o(154795);
      return;
    }
    Log.i("XWalkLib", "use default file downloader");
    new HttpDownloadTask(true, paramDownloadListener, paramUpdateConfig.downUrl, paramUpdateConfig.getDownloadPath()).execute(new Void[0]);
    AppMethodBeat.o(154795);
  }
  
  public static abstract interface ActivateListener
  {
    public abstract void onActivateCompleted();
    
    public abstract void onActivateFailed();
    
    public abstract void onActivateStarted();
  }
  
  public static abstract interface DecompressListener
  {
    public abstract void onDecompressCancelled();
    
    public abstract void onDecompressCompleted();
    
    public abstract void onDecompressStarted();
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
    
    public abstract void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo paramDownloadInfo);
    
    public abstract void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo);
    
    public abstract void onDownloadStarted(int paramInt);
    
    public abstract void onDownloadUpdated(int paramInt);
  }
  
  public static class HttpDownloadTask
    extends AsyncTask<Void, Integer, Integer>
  {
    private static final int DOWNLOAD_FAILED = -1;
    private static final int DOWNLOAD_SUCCESS = 0;
    private static final int UPDATE_INTERVAL_MS = 500;
    private static final String XWALK_DOWNLOAD_DIR = "xwalk_download";
    private XWalkLibraryLoader.DownloadInfo mDownloadInfo;
    private File mDownloadedFile;
    private XWalkLibraryLoader.DownloadListener mListener;
    private long mProgressUpdateTime;
    
    public HttpDownloadTask(boolean paramBoolean, XWalkLibraryLoader.DownloadListener paramDownloadListener, String paramString1, String paramString2)
    {
      AppMethodBeat.i(154766);
      this.mListener = paramDownloadListener;
      this.mDownloadInfo = new XWalkLibraryLoader.DownloadInfo();
      this.mDownloadInfo.mErrorType = 0;
      this.mDownloadInfo.mErrorCode = 0;
      this.mDownloadInfo.mDownloadType = 1;
      this.mDownloadInfo.mUrl = paramString1;
      this.mDownloadInfo.mSavePath = paramString2;
      this.mDownloadInfo.mIsRuntime = paramBoolean;
      AppMethodBeat.o(154766);
    }
    
    /* Error */
    protected Integer doInBackground(Void... paramVarArgs)
    {
      // Byte code:
      //   0: ldc 76
      //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 41	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mListener	Lorg/xwalk/core/XWalkLibraryLoader$DownloadListener;
      //   9: aload_0
      //   10: getfield 46	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
      //   13: getfield 55	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mDownloadType	I
      //   16: invokeinterface 81 2 0
      //   21: aload_0
      //   22: getfield 46	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
      //   25: invokestatic 87	java/lang/System:currentTimeMillis	()J
      //   28: putfield 90	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mStartTimestamp	J
      //   31: invokestatic 96	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
      //   34: astore_1
      //   35: aload_0
      //   36: getfield 46	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
      //   39: aload_1
      //   40: invokestatic 102	org/xwalk/core/NetworkUtil:getCurrentNetWorkStatus	(Landroid/content/Context;)I
      //   43: putfield 105	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mNetWorkType	I
      //   46: aconst_null
      //   47: astore 14
      //   49: aconst_null
      //   50: astore 16
      //   52: aconst_null
      //   53: astore 17
      //   55: aconst_null
      //   56: astore_1
      //   57: aload_1
      //   58: astore 12
      //   60: new 107	java/net/URL
      //   63: dup
      //   64: aload_0
      //   65: getfield 46	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
      //   68: getfield 58	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mUrl	Ljava/lang/String;
      //   71: invokespecial 110	java/net/URL:<init>	(Ljava/lang/String;)V
      //   74: astore 15
      //   76: aload_1
      //   77: astore 12
      //   79: aload 15
      //   81: invokevirtual 114	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   84: checkcast 116	java/net/HttpURLConnection
      //   87: astore 13
      //   89: aload 13
      //   91: astore_1
      //   92: aload 13
      //   94: astore 12
      //   96: aload 13
      //   98: sipush 30000
      //   101: invokevirtual 119	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   104: aload 13
      //   106: astore_1
      //   107: aload 13
      //   109: astore 12
      //   111: aload 13
      //   113: sipush 30000
      //   116: invokevirtual 122	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   119: aload 13
      //   121: astore_1
      //   122: aload 13
      //   124: astore 12
      //   126: aload 13
      //   128: invokevirtual 125	java/net/HttpURLConnection:connect	()V
      //   131: aload 13
      //   133: astore_1
      //   134: aload 13
      //   136: astore 12
      //   138: aload 13
      //   140: invokevirtual 129	java/net/HttpURLConnection:getResponseCode	()I
      //   143: sipush 200
      //   146: if_icmpeq +86 -> 232
      //   149: aload 13
      //   151: astore_1
      //   152: aload 13
      //   154: astore 12
      //   156: aload 13
      //   158: invokevirtual 129	java/net/HttpURLConnection:getResponseCode	()I
      //   161: sipush 206
      //   164: if_icmpeq +68 -> 232
      //   167: aload 13
      //   169: astore_1
      //   170: aload 13
      //   172: astore 12
      //   174: ldc 131
      //   176: new 133	java/lang/StringBuilder
      //   179: dup
      //   180: ldc 135
      //   182: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   185: aload 13
      //   187: invokevirtual 129	java/net/HttpURLConnection:getResponseCode	()I
      //   190: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   193: ldc 142
      //   195: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   198: aload 13
      //   200: invokevirtual 149	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
      //   203: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   206: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   209: invokestatic 158	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   212: aload 13
      //   214: ifnull +8 -> 222
      //   217: aload 13
      //   219: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
      //   222: ldc 76
      //   224: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   227: iconst_m1
      //   228: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   231: areturn
      //   232: aload 13
      //   234: astore_1
      //   235: aload 13
      //   237: astore 12
      //   239: aload 13
      //   241: invokevirtual 170	java/net/HttpURLConnection:getContentLength	()I
      //   244: istore_2
      //   245: aload 13
      //   247: astore_1
      //   248: aload 13
      //   250: astore 12
      //   252: aload_0
      //   253: getfield 172	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
      //   256: invokevirtual 178	java/io/File:exists	()Z
      //   259: ifeq +778 -> 1037
      //   262: aload 13
      //   264: astore_1
      //   265: aload 13
      //   267: astore 12
      //   269: aload_0
      //   270: getfield 172	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
      //   273: invokevirtual 181	java/io/File:length	()J
      //   276: lstore 4
      //   278: iload_2
      //   279: i2l
      //   280: lload 4
      //   282: lcmp
      //   283: ifne +37 -> 320
      //   286: aload 13
      //   288: astore_1
      //   289: aload 13
      //   291: astore 12
      //   293: ldc 131
      //   295: ldc 183
      //   297: invokestatic 185	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   300: aload 13
      //   302: ifnull +8 -> 310
      //   305: aload 13
      //   307: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
      //   310: ldc 76
      //   312: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   315: iconst_0
      //   316: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   319: areturn
      //   320: lload 4
      //   322: lconst_0
      //   323: lcmp
      //   324: ifle +32 -> 356
      //   327: aload 13
      //   329: astore_1
      //   330: aload 13
      //   332: astore 12
      //   334: aload_0
      //   335: getfield 46	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
      //   338: iconst_1
      //   339: putfield 188	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mIsDownloadResume	Z
      //   342: aload 13
      //   344: astore_1
      //   345: aload 13
      //   347: astore 12
      //   349: ldc 131
      //   351: ldc 190
      //   353: invokestatic 185	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   356: aload 13
      //   358: astore_1
      //   359: aload 13
      //   361: astore 12
      //   363: aload 13
      //   365: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
      //   368: aload 13
      //   370: astore_1
      //   371: aload 13
      //   373: astore 12
      //   375: aload 15
      //   377: invokevirtual 114	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   380: checkcast 116	java/net/HttpURLConnection
      //   383: astore 13
      //   385: aload 13
      //   387: astore_1
      //   388: aload 13
      //   390: astore 12
      //   392: aload 13
      //   394: sipush 30000
      //   397: invokevirtual 119	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   400: aload 13
      //   402: astore_1
      //   403: aload 13
      //   405: astore 12
      //   407: aload 13
      //   409: sipush 30000
      //   412: invokevirtual 122	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   415: aload 13
      //   417: astore_1
      //   418: aload 13
      //   420: astore 12
      //   422: aload 13
      //   424: ldc 192
      //   426: new 133	java/lang/StringBuilder
      //   429: dup
      //   430: ldc 194
      //   432: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   435: lload 4
      //   437: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   440: ldc 199
      //   442: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   445: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   448: invokevirtual 202	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   451: aload 13
      //   453: astore_1
      //   454: aload 13
      //   456: astore 12
      //   458: ldc 131
      //   460: ldc 204
      //   462: lload 4
      //   464: invokestatic 209	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   467: invokevirtual 213	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   470: invokestatic 185	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   473: aload 13
      //   475: astore_1
      //   476: aload 13
      //   478: astore 12
      //   480: aload 13
      //   482: invokevirtual 125	java/net/HttpURLConnection:connect	()V
      //   485: aload 13
      //   487: astore_1
      //   488: aload 13
      //   490: astore 12
      //   492: aload 13
      //   494: invokevirtual 129	java/net/HttpURLConnection:getResponseCode	()I
      //   497: sipush 200
      //   500: if_icmpeq +86 -> 586
      //   503: aload 13
      //   505: astore_1
      //   506: aload 13
      //   508: astore 12
      //   510: aload 13
      //   512: invokevirtual 129	java/net/HttpURLConnection:getResponseCode	()I
      //   515: sipush 206
      //   518: if_icmpeq +68 -> 586
      //   521: aload 13
      //   523: astore_1
      //   524: aload 13
      //   526: astore 12
      //   528: ldc 131
      //   530: new 133	java/lang/StringBuilder
      //   533: dup
      //   534: ldc 135
      //   536: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   539: aload 13
      //   541: invokevirtual 129	java/net/HttpURLConnection:getResponseCode	()I
      //   544: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   547: ldc 142
      //   549: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   552: aload 13
      //   554: invokevirtual 149	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
      //   557: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   560: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   563: invokestatic 158	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   566: aload 13
      //   568: ifnull +8 -> 576
      //   571: aload 13
      //   573: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
      //   576: ldc 76
      //   578: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   581: iconst_m1
      //   582: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   585: areturn
      //   586: aload 13
      //   588: astore_1
      //   589: aload 13
      //   591: astore 12
      //   593: aload 13
      //   595: invokevirtual 170	java/net/HttpURLConnection:getContentLength	()I
      //   598: istore_2
      //   599: aload 13
      //   601: astore_1
      //   602: aload_1
      //   603: astore 12
      //   605: aload_1
      //   606: invokevirtual 217	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   609: astore 13
      //   611: aload 13
      //   613: astore 12
      //   615: aload_1
      //   616: astore 14
      //   618: aload 12
      //   620: astore 15
      //   622: new 219	java/io/FileOutputStream
      //   625: dup
      //   626: aload_0
      //   627: getfield 172	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
      //   630: iconst_1
      //   631: invokespecial 222	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   634: astore 13
      //   636: sipush 4096
      //   639: newarray byte
      //   641: astore 14
      //   643: lconst_0
      //   644: lstore 6
      //   646: aload 12
      //   648: aload 14
      //   650: invokevirtual 228	java/io/InputStream:read	([B)I
      //   653: istore_3
      //   654: iload_3
      //   655: iconst_m1
      //   656: if_icmpeq +167 -> 823
      //   659: aload_0
      //   660: invokevirtual 231	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:isCancelled	()Z
      //   663: ifeq +36 -> 699
      //   666: aload 13
      //   668: invokevirtual 236	java/io/OutputStream:close	()V
      //   671: aload 12
      //   673: ifnull +8 -> 681
      //   676: aload 12
      //   678: invokevirtual 237	java/io/InputStream:close	()V
      //   681: aload_1
      //   682: ifnull +7 -> 689
      //   685: aload_1
      //   686: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
      //   689: ldc 76
      //   691: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   694: iconst_m1
      //   695: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   698: areturn
      //   699: lload 6
      //   701: iload_3
      //   702: i2l
      //   703: ladd
      //   704: lstore 8
      //   706: aload 13
      //   708: aload 14
      //   710: iconst_0
      //   711: iload_3
      //   712: invokevirtual 241	java/io/OutputStream:write	([BII)V
      //   715: invokestatic 246	android/os/SystemClock:uptimeMillis	()J
      //   718: lstore 10
      //   720: lload 8
      //   722: lstore 6
      //   724: lload 10
      //   726: aload_0
      //   727: getfield 248	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mProgressUpdateTime	J
      //   730: lsub
      //   731: ldc2_w 249
      //   734: lcmp
      //   735: ifle -89 -> 646
      //   738: aload_0
      //   739: lload 10
      //   741: putfield 248	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mProgressUpdateTime	J
      //   744: aload_0
      //   745: iconst_2
      //   746: anewarray 163	java/lang/Integer
      //   749: dup
      //   750: iconst_0
      //   751: lload 8
      //   753: lload 4
      //   755: ladd
      //   756: l2i
      //   757: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   760: aastore
      //   761: dup
      //   762: iconst_1
      //   763: iload_2
      //   764: i2l
      //   765: lload 4
      //   767: ladd
      //   768: l2i
      //   769: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   772: aastore
      //   773: invokevirtual 254	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:publishProgress	([Ljava/lang/Object;)V
      //   776: lload 8
      //   778: lstore 6
      //   780: goto -134 -> 646
      //   783: astore 14
      //   785: aload 13
      //   787: ifnull +8 -> 795
      //   790: aload 13
      //   792: invokevirtual 236	java/io/OutputStream:close	()V
      //   795: aload 12
      //   797: ifnull +8 -> 805
      //   800: aload 12
      //   802: invokevirtual 237	java/io/InputStream:close	()V
      //   805: aload_1
      //   806: ifnull +7 -> 813
      //   809: aload_1
      //   810: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
      //   813: ldc 76
      //   815: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   818: iconst_m1
      //   819: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   822: areturn
      //   823: aload 13
      //   825: invokevirtual 257	java/io/OutputStream:flush	()V
      //   828: aload 13
      //   830: invokevirtual 236	java/io/OutputStream:close	()V
      //   833: aload 12
      //   835: ifnull +8 -> 843
      //   838: aload 12
      //   840: invokevirtual 237	java/io/InputStream:close	()V
      //   843: aload_1
      //   844: ifnull +7 -> 851
      //   847: aload_1
      //   848: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
      //   851: aload_0
      //   852: getfield 46	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
      //   855: aload_0
      //   856: getfield 172	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
      //   859: invokevirtual 181	java/io/File:length	()J
      //   862: putfield 260	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mFileTotalSize	J
      //   865: ldc 76
      //   867: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   870: iconst_0
      //   871: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   874: areturn
      //   875: astore 12
      //   877: aconst_null
      //   878: astore 13
      //   880: aconst_null
      //   881: astore_1
      //   882: aload 14
      //   884: ifnull +8 -> 892
      //   887: aload 14
      //   889: invokevirtual 236	java/io/OutputStream:close	()V
      //   892: aload_1
      //   893: ifnull +7 -> 900
      //   896: aload_1
      //   897: invokevirtual 237	java/io/InputStream:close	()V
      //   900: aload 13
      //   902: ifnull +8 -> 910
      //   905: aload 13
      //   907: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
      //   910: ldc 76
      //   912: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   915: aload 12
      //   917: athrow
      //   918: astore_1
      //   919: goto -19 -> 900
      //   922: astore 12
      //   924: aload_1
      //   925: astore 13
      //   927: aconst_null
      //   928: astore_1
      //   929: goto -47 -> 882
      //   932: astore 12
      //   934: aload_1
      //   935: astore 13
      //   937: aconst_null
      //   938: astore_1
      //   939: goto -57 -> 882
      //   942: astore 12
      //   944: aload 14
      //   946: astore 13
      //   948: aload 16
      //   950: astore 14
      //   952: aload 15
      //   954: astore_1
      //   955: goto -73 -> 882
      //   958: astore 15
      //   960: aload_1
      //   961: astore 16
      //   963: aload 13
      //   965: astore 14
      //   967: aload 12
      //   969: astore_1
      //   970: aload 15
      //   972: astore 12
      //   974: aload 16
      //   976: astore 13
      //   978: goto -96 -> 882
      //   981: astore 12
      //   983: goto -178 -> 805
      //   986: astore_1
      //   987: aconst_null
      //   988: astore 14
      //   990: aload 12
      //   992: astore_1
      //   993: aload 17
      //   995: astore 13
      //   997: aload 14
      //   999: astore 12
      //   1001: goto -216 -> 785
      //   1004: astore_1
      //   1005: aload 12
      //   1007: astore_1
      //   1008: aconst_null
      //   1009: astore 12
      //   1011: aload 17
      //   1013: astore 13
      //   1015: goto -230 -> 785
      //   1018: astore 13
      //   1020: aload 17
      //   1022: astore 13
      //   1024: goto -239 -> 785
      //   1027: astore 12
      //   1029: goto -186 -> 843
      //   1032: astore 12
      //   1034: goto -353 -> 681
      //   1037: lconst_0
      //   1038: lstore 4
      //   1040: aload 13
      //   1042: astore_1
      //   1043: goto -441 -> 602
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1046	0	this	HttpDownloadTask
      //   0	1046	1	paramVarArgs	Void[]
      //   244	520	2	i	int
      //   653	59	3	j	int
      //   276	763	4	l1	long
      //   644	135	6	l2	long
      //   704	73	8	l3	long
      //   718	22	10	l4	long
      //   58	781	12	localObject1	Object
      //   875	41	12	localObject2	Object
      //   922	1	12	localObject3	Object
      //   932	1	12	localObject4	Object
      //   942	26	12	localObject5	Object
      //   972	1	12	localObject6	Object
      //   981	10	12	localIOException1	java.io.IOException
      //   999	11	12	localObject7	Object
      //   1027	1	12	localIOException2	java.io.IOException
      //   1032	1	12	localIOException3	java.io.IOException
      //   87	927	13	localObject8	Object
      //   1018	1	13	localException1	java.lang.Exception
      //   1022	19	13	localObject9	Object
      //   47	662	14	localObject10	Object
      //   783	162	14	localException2	java.lang.Exception
      //   950	48	14	localObject11	Object
      //   74	879	15	localObject12	Object
      //   958	13	15	localObject13	Object
      //   50	925	16	arrayOfVoid	Void[]
      //   53	968	17	localObject14	Object
      // Exception table:
      //   from	to	target	type
      //   636	643	783	java/lang/Exception
      //   646	654	783	java/lang/Exception
      //   659	666	783	java/lang/Exception
      //   706	720	783	java/lang/Exception
      //   724	776	783	java/lang/Exception
      //   823	828	783	java/lang/Exception
      //   60	76	875	finally
      //   79	89	875	finally
      //   887	892	918	java/io/IOException
      //   896	900	918	java/io/IOException
      //   96	104	922	finally
      //   111	119	922	finally
      //   126	131	922	finally
      //   138	149	922	finally
      //   156	167	922	finally
      //   174	212	922	finally
      //   239	245	922	finally
      //   252	262	922	finally
      //   269	278	922	finally
      //   293	300	922	finally
      //   334	342	922	finally
      //   349	356	922	finally
      //   363	368	922	finally
      //   375	385	922	finally
      //   392	400	922	finally
      //   407	415	922	finally
      //   422	451	922	finally
      //   458	473	922	finally
      //   480	485	922	finally
      //   492	503	922	finally
      //   510	521	922	finally
      //   528	566	922	finally
      //   593	599	922	finally
      //   605	611	932	finally
      //   622	636	942	finally
      //   636	643	958	finally
      //   646	654	958	finally
      //   659	666	958	finally
      //   706	720	958	finally
      //   724	776	958	finally
      //   823	828	958	finally
      //   790	795	981	java/io/IOException
      //   800	805	981	java/io/IOException
      //   60	76	986	java/lang/Exception
      //   79	89	986	java/lang/Exception
      //   605	611	986	java/lang/Exception
      //   96	104	1004	java/lang/Exception
      //   111	119	1004	java/lang/Exception
      //   126	131	1004	java/lang/Exception
      //   138	149	1004	java/lang/Exception
      //   156	167	1004	java/lang/Exception
      //   174	212	1004	java/lang/Exception
      //   239	245	1004	java/lang/Exception
      //   252	262	1004	java/lang/Exception
      //   269	278	1004	java/lang/Exception
      //   293	300	1004	java/lang/Exception
      //   334	342	1004	java/lang/Exception
      //   349	356	1004	java/lang/Exception
      //   363	368	1004	java/lang/Exception
      //   375	385	1004	java/lang/Exception
      //   392	400	1004	java/lang/Exception
      //   407	415	1004	java/lang/Exception
      //   422	451	1004	java/lang/Exception
      //   458	473	1004	java/lang/Exception
      //   480	485	1004	java/lang/Exception
      //   492	503	1004	java/lang/Exception
      //   510	521	1004	java/lang/Exception
      //   528	566	1004	java/lang/Exception
      //   593	599	1004	java/lang/Exception
      //   622	636	1018	java/lang/Exception
      //   828	833	1027	java/io/IOException
      //   838	843	1027	java/io/IOException
      //   666	671	1032	java/io/IOException
      //   676	681	1032	java/io/IOException
    }
    
    protected void onCancelled(Integer paramInteger)
    {
      AppMethodBeat.i(154770);
      if (this.mDownloadInfo.mIsRuntime)
      {
        XWalkLibraryLoader.access$002(null);
        Log.i("XWalkLib", "HttpDownloadTask runtime onCancelled: " + this.mDownloadInfo.mSavePath);
      }
      for (;;)
      {
        this.mListener.onDownloadCancelled();
        AppMethodBeat.o(154770);
        return;
        Log.i("XWalkLib", "HttpDownloadTask other onCancelled: " + this.mDownloadInfo.mSavePath);
      }
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      AppMethodBeat.i(154771);
      if (this.mDownloadInfo.mIsRuntime)
      {
        XWalkLibraryLoader.access$002(null);
        Log.i("XWalkLib", "HttpDownloadTask runtime onPostExecute result " + paramInteger + " " + this.mDownloadInfo.mSavePath);
      }
      while (paramInteger.intValue() == 0)
      {
        this.mDownloadInfo.mErrorCode = 0;
        this.mListener.onDownloadCompleted(this.mDownloadInfo);
        AppMethodBeat.o(154771);
        return;
        Log.i("XWalkLib", "HttpDownloadTask other onPostExecute result " + paramInteger + " " + this.mDownloadInfo.mSavePath);
      }
      this.mDownloadInfo.mErrorCode = -1;
      this.mListener.onDownloadFailed(this.mDownloadInfo);
      AppMethodBeat.o(154771);
    }
    
    protected void onPreExecute()
    {
      AppMethodBeat.i(154767);
      if (this.mDownloadInfo.mIsRuntime)
      {
        XWalkLibraryLoader.access$002(this);
        Log.i("XWalkLib", "HttpDownloadTask runtime onPreExecute: " + this.mDownloadInfo.mSavePath);
      }
      for (;;)
      {
        this.mDownloadedFile = new File(this.mDownloadInfo.mSavePath);
        AppMethodBeat.o(154767);
        return;
        Log.i("XWalkLib", "HttpDownloadTask other onPreExecute: " + this.mDownloadInfo.mSavePath);
      }
    }
    
    protected void onProgressUpdate(Integer... paramVarArgs)
    {
      int i = 0;
      AppMethodBeat.i(154769);
      Log.d("XWalkLib", "HttpDownloadTask updated: " + paramVarArgs[0] + "/" + paramVarArgs[1]);
      if (paramVarArgs[1].intValue() > 0) {
        i = (int)(paramVarArgs[0].intValue() * 100.0D / paramVarArgs[1].intValue());
      }
      this.mListener.onDownloadUpdated(i);
      AppMethodBeat.o(154769);
    }
  }
  
  public static class WXFileDownloaderTask
    extends AsyncTask<Void, Integer, Integer>
    implements c
  {
    private static final int DOWNLOAD_FAILED = -1;
    private static final int DOWNLOAD_SUCCESS = 0;
    private static final int UPDATE_INTERVAL_MS = 500;
    private final Object lockObj;
    private XWalkLibraryLoader.DownloadInfo mDownloadInfo;
    private XWalkLibraryLoader.DownloadListener mListener;
    private long mProgressUpdateTime;
    private WXFileDownloaderBridge mWXFileDownloaderBridge;
    private boolean mWaitTimeout;
    
    public WXFileDownloaderTask(boolean paramBoolean, XWalkLibraryLoader.DownloadListener paramDownloadListener, String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(154777);
      this.mProgressUpdateTime = 0L;
      this.mWXFileDownloaderBridge = null;
      this.lockObj = new Object();
      this.mWaitTimeout = false;
      this.mListener = paramDownloadListener;
      this.mDownloadInfo = new XWalkLibraryLoader.DownloadInfo();
      this.mDownloadInfo.mErrorType = 0;
      this.mDownloadInfo.mErrorCode = 0;
      this.mDownloadInfo.mDownloadType = 2;
      this.mDownloadInfo.mUrl = paramString1;
      this.mDownloadInfo.mSavePath = paramString2;
      this.mDownloadInfo.mIsRuntime = paramBoolean;
      this.mDownloadInfo.mBizType = paramInt;
      this.mWXFileDownloaderBridge = new WXFileDownloaderBridge();
      this.mWXFileDownloaderBridge.KAD = this;
      AppMethodBeat.o(154777);
    }
    
    protected Integer doInBackground(Void... arg1)
    {
      AppMethodBeat.i(154779);
      this.mListener.onDownloadStarted(this.mDownloadInfo.mDownloadType);
      this.mDownloadInfo.mStartTimestamp = System.currentTimeMillis();
      ??? = XWalkEnvironment.getApplicationContext();
      this.mDownloadInfo.mNetWorkType = NetworkUtil.getCurrentNetWorkStatus(???);
      if ((this.mWXFileDownloaderBridge == null) || (!WXFileDownloaderBridge.isValid()))
      {
        this.mDownloadInfo.mErrorType = 2;
        this.mDownloadInfo.mErrorCode = -1;
        AppMethodBeat.o(154779);
        return Integer.valueOf(-1);
      }
      ??? = this.mWXFileDownloaderBridge;
      String str1 = this.mDownloadInfo.mUrl;
      String str2 = this.mDownloadInfo.mSavePath;
      if (WXFileDownloaderBridge.KAC != null) {}
      for (int i = WXFileDownloaderBridge.KAC.a(str1, str2, ???);; i = -1)
      {
        if (i != 0)
        {
          this.mDownloadInfo.mErrorType = 1;
          this.mDownloadInfo.mErrorCode = -1;
          AppMethodBeat.o(154779);
          return Integer.valueOf(-1);
        }
        synchronized (this.lockObj)
        {
          try
          {
            this.mWaitTimeout = true;
            this.lockObj.wait(300000L);
            if ((this.mDownloadInfo.mErrorType == 0) && (this.mDownloadInfo.mErrorCode == 0))
            {
              AppMethodBeat.o(154779);
              return Integer.valueOf(0);
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              this.mWaitTimeout = false;
              this.mDownloadInfo.mErrorType = 2;
              this.mDownloadInfo.mErrorCode = -101;
            }
          }
        }
        Log.e("XWalkLib", "download errortype:" + this.mDownloadInfo.mErrorType + ", errorcode:" + this.mDownloadInfo.mErrorCode + ", waitTimeout:" + this.mWaitTimeout);
        if (this.mWaitTimeout)
        {
          this.mDownloadInfo.mErrorType = 1;
          this.mDownloadInfo.mErrorCode = -100;
        }
        AppMethodBeat.o(154779);
        return Integer.valueOf(-1);
      }
    }
    
    public boolean isValid()
    {
      AppMethodBeat.i(154776);
      if (this.mWXFileDownloaderBridge == null)
      {
        AppMethodBeat.o(154776);
        return false;
      }
      boolean bool = WXFileDownloaderBridge.isValid();
      AppMethodBeat.o(154776);
      return bool;
    }
    
    protected void onCancelled(Integer paramInteger)
    {
      AppMethodBeat.i(154781);
      if (this.mDownloadInfo.mIsRuntime)
      {
        XWalkLibraryLoader.access$002(null);
        Log.i("XWalkLib", "WXFileDownloaderTask runtime onCancelled: " + this.mDownloadInfo.mSavePath);
      }
      for (;;)
      {
        this.mListener.onDownloadCancelled();
        AppMethodBeat.o(154781);
        return;
        Log.i("XWalkLib", "WXFileDownloaderTask other onCancelled: " + this.mDownloadInfo.mSavePath);
      }
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      AppMethodBeat.i(154782);
      if (this.mDownloadInfo.mIsRuntime)
      {
        XWalkLibraryLoader.access$002(null);
        Log.i("XWalkLib", "WXFileDownloaderTask runtime onPostExecute result " + paramInteger + " " + this.mDownloadInfo.mSavePath);
      }
      while (paramInteger.intValue() == 0)
      {
        this.mListener.onDownloadCompleted(this.mDownloadInfo);
        AppMethodBeat.o(154782);
        return;
        Log.i("XWalkLib", "WXFileDownloaderTask other onPostExecute result " + paramInteger + " " + this.mDownloadInfo.mSavePath);
      }
      this.mListener.onDownloadFailed(this.mDownloadInfo);
      AppMethodBeat.o(154782);
    }
    
    protected void onPreExecute()
    {
      AppMethodBeat.i(154778);
      if (this.mDownloadInfo.mIsRuntime)
      {
        XWalkLibraryLoader.access$002(this);
        Log.i("XWalkLib", "WXFileDownloaderTask runtime onPreExecute: " + this.mDownloadInfo.mSavePath);
        AppMethodBeat.o(154778);
        return;
      }
      Log.i("XWalkLib", "WXFileDownloaderTask other onPreExecute: " + this.mDownloadInfo.mSavePath);
      AppMethodBeat.o(154778);
    }
    
    public void onProgressChange(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(154783);
      Log.d("XWalkLib", "url:" + paramString + ", cur_size:" + paramLong1 + ", total_size:" + paramLong2);
      if (this.mDownloadInfo.mFileTotalSize != paramLong2) {
        this.mDownloadInfo.mFileTotalSize = paramLong2;
      }
      publishProgress(new Integer[] { Integer.valueOf((int)paramLong1), Integer.valueOf((int)paramLong2) });
      AppMethodBeat.o(154783);
    }
    
    protected void onProgressUpdate(Integer... paramVarArgs)
    {
      int i = 0;
      AppMethodBeat.i(154780);
      Log.d("XWalkLib", "WXFileDownloaderTask updated: " + paramVarArgs[0] + "/" + paramVarArgs[1]);
      if (paramVarArgs[1].intValue() > 0) {
        i = (int)(paramVarArgs[0].intValue() * 100.0D / paramVarArgs[1].intValue());
      }
      this.mListener.onDownloadUpdated(i);
      AppMethodBeat.o(154780);
    }
    
    public void onTaskFail(String arg1, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(154785);
      synchronized (this.lockObj)
      {
        this.mDownloadInfo.mErrorType = 1;
        this.mDownloadInfo.mErrorCode = paramInt;
        this.mDownloadInfo.mIsDownloadResume = paramBoolean;
        this.mWaitTimeout = false;
        this.lockObj.notify();
        AppMethodBeat.o(154785);
        return;
      }
    }
    
    public void onTaskSucc(String arg1, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(154784);
      synchronized (this.lockObj)
      {
        this.mDownloadInfo.mIsDownloadResume = paramBoolean;
        this.mWaitTimeout = false;
        this.lockObj.notify();
        AppMethodBeat.o(154784);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkLibraryLoader
 * JD-Core Version:    0.7.0.1
 */