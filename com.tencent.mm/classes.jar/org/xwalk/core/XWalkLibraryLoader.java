package org.xwalk.core;

import android.content.Context;
import android.os.AsyncTask;
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
    return (sActiveTask != null) && ((sActiveTask instanceof HttpDownloadTask)) && (sActiveTask.cancel(true));
  }
  
  public static void finishInit(Context paramContext)
  {
    XWalkCoreWrapper.handlePostInit(paramContext.getClass().getName());
  }
  
  public static int getLibraryStatus()
  {
    return XWalkCoreWrapper.getCoreStatus();
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
    return XWalkCoreWrapper.getInstance() != null;
  }
  
  public static boolean isSharedLibrary()
  {
    return XWalkCoreWrapper.getInstance().isSharedMode();
  }
  
  public static void prepareToInit(Context paramContext)
  {
    XWalkEnvironment.init(paramContext);
    XWalkCoreWrapper.handlePreInit(paramContext.getClass().getName());
  }
  
  public static void startHttpDownload(DownloadListener paramDownloadListener, Context paramContext, XWalkUpdater.UpdateConfig paramUpdateConfig)
  {
    paramContext = new XWalkLibraryLoader.WXFileDownloaderTask(true, paramDownloadListener, paramUpdateConfig.downUrl, paramUpdateConfig.getDownloadPath(), paramUpdateConfig.getUpdateBizType());
    if ((paramUpdateConfig.bUseCdn) && (paramContext.isValid()))
    {
      Log.i("XWalkLib", "use wx file downloader");
      paramContext.execute(new Void[0]);
      return;
    }
    Log.i("XWalkLib", "use default file downloader");
    new HttpDownloadTask(true, paramDownloadListener, paramUpdateConfig.downUrl, paramUpdateConfig.getDownloadPath()).execute(new Void[0]);
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
      this.mListener = paramDownloadListener;
      this.mDownloadInfo = new XWalkLibraryLoader.DownloadInfo();
      this.mDownloadInfo.mErrorType = 0;
      this.mDownloadInfo.mErrorCode = 0;
      this.mDownloadInfo.mDownloadType = 1;
      this.mDownloadInfo.mUrl = paramString1;
      this.mDownloadInfo.mSavePath = paramString2;
      this.mDownloadInfo.mIsRuntime = paramBoolean;
    }
    
    /* Error */
    protected Integer doInBackground(Void... paramVarArgs)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 14
      //   3: aconst_null
      //   4: astore 16
      //   6: aconst_null
      //   7: astore 17
      //   9: aconst_null
      //   10: astore_1
      //   11: aload_1
      //   12: astore 12
      //   14: new 67	java/net/URL
      //   17: dup
      //   18: aload_0
      //   19: getfield 39	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
      //   22: getfield 51	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mUrl	Ljava/lang/String;
      //   25: invokespecial 70	java/net/URL:<init>	(Ljava/lang/String;)V
      //   28: astore 15
      //   30: aload_1
      //   31: astore 12
      //   33: aload 15
      //   35: invokevirtual 74	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   38: checkcast 76	java/net/HttpURLConnection
      //   41: astore 13
      //   43: aload 13
      //   45: astore_1
      //   46: aload 13
      //   48: astore 12
      //   50: aload 13
      //   52: sipush 30000
      //   55: invokevirtual 80	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   58: aload 13
      //   60: astore_1
      //   61: aload 13
      //   63: astore 12
      //   65: aload 13
      //   67: sipush 30000
      //   70: invokevirtual 83	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   73: aload 13
      //   75: astore_1
      //   76: aload 13
      //   78: astore 12
      //   80: aload 13
      //   82: invokevirtual 86	java/net/HttpURLConnection:connect	()V
      //   85: aload 13
      //   87: astore_1
      //   88: aload 13
      //   90: astore 12
      //   92: aload 13
      //   94: invokevirtual 90	java/net/HttpURLConnection:getResponseCode	()I
      //   97: sipush 200
      //   100: if_icmpeq +85 -> 185
      //   103: aload 13
      //   105: astore_1
      //   106: aload 13
      //   108: astore 12
      //   110: aload 13
      //   112: invokevirtual 90	java/net/HttpURLConnection:getResponseCode	()I
      //   115: sipush 206
      //   118: if_icmpeq +67 -> 185
      //   121: aload 13
      //   123: astore_1
      //   124: aload 13
      //   126: astore 12
      //   128: ldc 92
      //   130: new 94	java/lang/StringBuilder
      //   133: dup
      //   134: ldc 96
      //   136: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   139: aload 13
      //   141: invokevirtual 90	java/net/HttpURLConnection:getResponseCode	()I
      //   144: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   147: ldc 103
      //   149: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   152: aload 13
      //   154: invokevirtual 110	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
      //   157: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   160: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   163: invokestatic 119	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   166: aload 13
      //   168: ifnull +8 -> 176
      //   171: aload 13
      //   173: invokevirtual 122	java/net/HttpURLConnection:disconnect	()V
      //   176: iconst_m1
      //   177: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   180: astore 12
      //   182: aload 12
      //   184: areturn
      //   185: aload 13
      //   187: astore_1
      //   188: aload 13
      //   190: astore 12
      //   192: aload 13
      //   194: invokevirtual 131	java/net/HttpURLConnection:getContentLength	()I
      //   197: istore_2
      //   198: aload 13
      //   200: astore_1
      //   201: aload 13
      //   203: astore 12
      //   205: aload_0
      //   206: getfield 133	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
      //   209: invokevirtual 139	java/io/File:exists	()Z
      //   212: ifeq +771 -> 983
      //   215: aload 13
      //   217: astore_1
      //   218: aload 13
      //   220: astore 12
      //   222: aload_0
      //   223: getfield 133	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
      //   226: invokevirtual 143	java/io/File:length	()J
      //   229: lstore 4
      //   231: iload_2
      //   232: i2l
      //   233: lload 4
      //   235: lcmp
      //   236: ifne +32 -> 268
      //   239: aload 13
      //   241: astore_1
      //   242: aload 13
      //   244: astore 12
      //   246: ldc 92
      //   248: ldc 145
      //   250: invokestatic 148	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   253: aload 13
      //   255: ifnull +8 -> 263
      //   258: aload 13
      //   260: invokevirtual 122	java/net/HttpURLConnection:disconnect	()V
      //   263: iconst_0
      //   264: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   267: areturn
      //   268: lload 4
      //   270: lconst_0
      //   271: lcmp
      //   272: ifle +32 -> 304
      //   275: aload 13
      //   277: astore_1
      //   278: aload 13
      //   280: astore 12
      //   282: aload_0
      //   283: getfield 39	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
      //   286: iconst_1
      //   287: putfield 151	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mIsDownloadResume	Z
      //   290: aload 13
      //   292: astore_1
      //   293: aload 13
      //   295: astore 12
      //   297: ldc 92
      //   299: ldc 153
      //   301: invokestatic 148	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   304: aload 13
      //   306: astore_1
      //   307: aload 13
      //   309: astore 12
      //   311: aload 13
      //   313: invokevirtual 122	java/net/HttpURLConnection:disconnect	()V
      //   316: aload 13
      //   318: astore_1
      //   319: aload 13
      //   321: astore 12
      //   323: aload 15
      //   325: invokevirtual 74	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   328: checkcast 76	java/net/HttpURLConnection
      //   331: astore 13
      //   333: aload 13
      //   335: astore_1
      //   336: aload 13
      //   338: astore 12
      //   340: aload 13
      //   342: sipush 30000
      //   345: invokevirtual 80	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   348: aload 13
      //   350: astore_1
      //   351: aload 13
      //   353: astore 12
      //   355: aload 13
      //   357: sipush 30000
      //   360: invokevirtual 83	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   363: aload 13
      //   365: astore_1
      //   366: aload 13
      //   368: astore 12
      //   370: aload 13
      //   372: ldc 155
      //   374: new 94	java/lang/StringBuilder
      //   377: dup
      //   378: ldc 157
      //   380: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   383: lload 4
      //   385: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   388: ldc 162
      //   390: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   393: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   396: invokevirtual 165	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   399: aload 13
      //   401: astore_1
      //   402: aload 13
      //   404: astore 12
      //   406: ldc 92
      //   408: new 94	java/lang/StringBuilder
      //   411: dup
      //   412: ldc 167
      //   414: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   417: lload 4
      //   419: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   422: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   425: invokestatic 148	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   428: aload 13
      //   430: astore_1
      //   431: aload 13
      //   433: astore 12
      //   435: aload 13
      //   437: invokevirtual 86	java/net/HttpURLConnection:connect	()V
      //   440: aload 13
      //   442: astore_1
      //   443: aload 13
      //   445: astore 12
      //   447: aload 13
      //   449: invokevirtual 90	java/net/HttpURLConnection:getResponseCode	()I
      //   452: sipush 200
      //   455: if_icmpeq +81 -> 536
      //   458: aload 13
      //   460: astore_1
      //   461: aload 13
      //   463: astore 12
      //   465: aload 13
      //   467: invokevirtual 90	java/net/HttpURLConnection:getResponseCode	()I
      //   470: sipush 206
      //   473: if_icmpeq +63 -> 536
      //   476: aload 13
      //   478: astore_1
      //   479: aload 13
      //   481: astore 12
      //   483: ldc 92
      //   485: new 94	java/lang/StringBuilder
      //   488: dup
      //   489: ldc 96
      //   491: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   494: aload 13
      //   496: invokevirtual 90	java/net/HttpURLConnection:getResponseCode	()I
      //   499: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   502: ldc 103
      //   504: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   507: aload 13
      //   509: invokevirtual 110	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
      //   512: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   515: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   518: invokestatic 119	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   521: aload 13
      //   523: ifnull +8 -> 531
      //   526: aload 13
      //   528: invokevirtual 122	java/net/HttpURLConnection:disconnect	()V
      //   531: iconst_m1
      //   532: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   535: areturn
      //   536: aload 13
      //   538: astore_1
      //   539: aload 13
      //   541: astore 12
      //   543: aload 13
      //   545: invokevirtual 131	java/net/HttpURLConnection:getContentLength	()I
      //   548: istore_2
      //   549: aload 13
      //   551: astore_1
      //   552: aload_1
      //   553: astore 12
      //   555: aload_1
      //   556: invokevirtual 171	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   559: astore 13
      //   561: aload 13
      //   563: astore 12
      //   565: aload_1
      //   566: astore 14
      //   568: aload 12
      //   570: astore 15
      //   572: new 173	java/io/FileOutputStream
      //   575: dup
      //   576: aload_0
      //   577: getfield 133	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
      //   580: iconst_1
      //   581: invokespecial 176	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   584: astore 13
      //   586: sipush 4096
      //   589: newarray byte
      //   591: astore 14
      //   593: lconst_0
      //   594: lstore 6
      //   596: aload 12
      //   598: aload 14
      //   600: invokevirtual 182	java/io/InputStream:read	([B)I
      //   603: istore_3
      //   604: iload_3
      //   605: iconst_m1
      //   606: if_icmpeq +173 -> 779
      //   609: aload_0
      //   610: invokevirtual 185	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:isCancelled	()Z
      //   613: ifeq +39 -> 652
      //   616: iconst_m1
      //   617: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   620: astore 14
      //   622: aload 13
      //   624: invokevirtual 190	java/io/OutputStream:close	()V
      //   627: aload 12
      //   629: ifnull +8 -> 637
      //   632: aload 12
      //   634: invokevirtual 191	java/io/InputStream:close	()V
      //   637: aload 14
      //   639: astore 12
      //   641: aload_1
      //   642: ifnull -460 -> 182
      //   645: aload_1
      //   646: invokevirtual 122	java/net/HttpURLConnection:disconnect	()V
      //   649: aload 14
      //   651: areturn
      //   652: lload 6
      //   654: iload_3
      //   655: i2l
      //   656: ladd
      //   657: lstore 8
      //   659: aload 13
      //   661: aload 14
      //   663: iconst_0
      //   664: iload_3
      //   665: invokevirtual 195	java/io/OutputStream:write	([BII)V
      //   668: invokestatic 200	android/os/SystemClock:uptimeMillis	()J
      //   671: lstore 10
      //   673: lload 8
      //   675: lstore 6
      //   677: lload 10
      //   679: aload_0
      //   680: getfield 202	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mProgressUpdateTime	J
      //   683: lsub
      //   684: ldc2_w 203
      //   687: lcmp
      //   688: ifle -92 -> 596
      //   691: aload_0
      //   692: lload 10
      //   694: putfield 202	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mProgressUpdateTime	J
      //   697: aload_0
      //   698: iconst_2
      //   699: anewarray 124	java/lang/Integer
      //   702: dup
      //   703: iconst_0
      //   704: lload 8
      //   706: lload 4
      //   708: ladd
      //   709: l2i
      //   710: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   713: aastore
      //   714: dup
      //   715: iconst_1
      //   716: iload_2
      //   717: i2l
      //   718: lload 4
      //   720: ladd
      //   721: l2i
      //   722: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   725: aastore
      //   726: invokevirtual 208	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:publishProgress	([Ljava/lang/Object;)V
      //   729: lload 8
      //   731: lstore 6
      //   733: goto -137 -> 596
      //   736: astore 14
      //   738: iconst_m1
      //   739: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   742: astore 14
      //   744: aload 13
      //   746: ifnull +8 -> 754
      //   749: aload 13
      //   751: invokevirtual 190	java/io/OutputStream:close	()V
      //   754: aload 12
      //   756: ifnull +8 -> 764
      //   759: aload 12
      //   761: invokevirtual 191	java/io/InputStream:close	()V
      //   764: aload 14
      //   766: astore 12
      //   768: aload_1
      //   769: ifnull -587 -> 182
      //   772: aload_1
      //   773: invokevirtual 122	java/net/HttpURLConnection:disconnect	()V
      //   776: aload 14
      //   778: areturn
      //   779: aload 13
      //   781: invokevirtual 211	java/io/OutputStream:flush	()V
      //   784: aload 13
      //   786: invokevirtual 190	java/io/OutputStream:close	()V
      //   789: aload 12
      //   791: ifnull +8 -> 799
      //   794: aload 12
      //   796: invokevirtual 191	java/io/InputStream:close	()V
      //   799: aload_1
      //   800: ifnull +7 -> 807
      //   803: aload_1
      //   804: invokevirtual 122	java/net/HttpURLConnection:disconnect	()V
      //   807: aload_0
      //   808: getfield 39	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
      //   811: aload_0
      //   812: getfield 133	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
      //   815: invokevirtual 143	java/io/File:length	()J
      //   818: putfield 214	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mFileTotalSize	J
      //   821: iconst_0
      //   822: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   825: areturn
      //   826: astore 12
      //   828: aconst_null
      //   829: astore 13
      //   831: aconst_null
      //   832: astore_1
      //   833: aload 14
      //   835: ifnull +8 -> 843
      //   838: aload 14
      //   840: invokevirtual 190	java/io/OutputStream:close	()V
      //   843: aload_1
      //   844: ifnull +7 -> 851
      //   847: aload_1
      //   848: invokevirtual 191	java/io/InputStream:close	()V
      //   851: aload 13
      //   853: ifnull +8 -> 861
      //   856: aload 13
      //   858: invokevirtual 122	java/net/HttpURLConnection:disconnect	()V
      //   861: aload 12
      //   863: athrow
      //   864: astore_1
      //   865: goto -14 -> 851
      //   868: astore 12
      //   870: aload_1
      //   871: astore 13
      //   873: aconst_null
      //   874: astore_1
      //   875: goto -42 -> 833
      //   878: astore 12
      //   880: aload_1
      //   881: astore 13
      //   883: aconst_null
      //   884: astore_1
      //   885: goto -52 -> 833
      //   888: astore 12
      //   890: aload 14
      //   892: astore 13
      //   894: aload 16
      //   896: astore 14
      //   898: aload 15
      //   900: astore_1
      //   901: goto -68 -> 833
      //   904: astore 15
      //   906: aload_1
      //   907: astore 16
      //   909: aload 13
      //   911: astore 14
      //   913: aload 12
      //   915: astore_1
      //   916: aload 15
      //   918: astore 12
      //   920: aload 16
      //   922: astore 13
      //   924: goto -91 -> 833
      //   927: astore 12
      //   929: goto -165 -> 764
      //   932: astore_1
      //   933: aconst_null
      //   934: astore 14
      //   936: aload 12
      //   938: astore_1
      //   939: aload 17
      //   941: astore 13
      //   943: aload 14
      //   945: astore 12
      //   947: goto -209 -> 738
      //   950: astore_1
      //   951: aload 12
      //   953: astore_1
      //   954: aconst_null
      //   955: astore 12
      //   957: aload 17
      //   959: astore 13
      //   961: goto -223 -> 738
      //   964: astore 13
      //   966: aload 17
      //   968: astore 13
      //   970: goto -232 -> 738
      //   973: astore 12
      //   975: goto -176 -> 799
      //   978: astore 12
      //   980: goto -343 -> 637
      //   983: lconst_0
      //   984: lstore 4
      //   986: aload 13
      //   988: astore_1
      //   989: goto -437 -> 552
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	992	0	this	HttpDownloadTask
      //   0	992	1	paramVarArgs	Void[]
      //   197	520	2	i	int
      //   603	62	3	j	int
      //   229	756	4	l1	long
      //   594	138	6	l2	long
      //   657	73	8	l3	long
      //   671	22	10	l4	long
      //   12	783	12	localObject1	Object
      //   826	36	12	localObject2	Object
      //   868	1	12	localObject3	Object
      //   878	1	12	localObject4	Object
      //   888	26	12	localObject5	Object
      //   918	1	12	localObject6	Object
      //   927	10	12	localIOException1	java.io.IOException
      //   945	11	12	localObject7	Object
      //   973	1	12	localIOException2	java.io.IOException
      //   978	1	12	localIOException3	java.io.IOException
      //   41	919	13	localObject8	Object
      //   964	1	13	localException1	java.lang.Exception
      //   968	19	13	localObject9	Object
      //   1	661	14	localObject10	Object
      //   736	1	14	localException2	java.lang.Exception
      //   742	202	14	localObject11	Object
      //   28	871	15	localObject12	Object
      //   904	13	15	localObject13	Object
      //   4	917	16	arrayOfVoid	Void[]
      //   7	960	17	localObject14	Object
      // Exception table:
      //   from	to	target	type
      //   586	593	736	java/lang/Exception
      //   596	604	736	java/lang/Exception
      //   609	616	736	java/lang/Exception
      //   659	673	736	java/lang/Exception
      //   677	729	736	java/lang/Exception
      //   779	784	736	java/lang/Exception
      //   14	30	826	finally
      //   33	43	826	finally
      //   838	843	864	java/io/IOException
      //   847	851	864	java/io/IOException
      //   50	58	868	finally
      //   65	73	868	finally
      //   80	85	868	finally
      //   92	103	868	finally
      //   110	121	868	finally
      //   128	166	868	finally
      //   192	198	868	finally
      //   205	215	868	finally
      //   222	231	868	finally
      //   246	253	868	finally
      //   282	290	868	finally
      //   297	304	868	finally
      //   311	316	868	finally
      //   323	333	868	finally
      //   340	348	868	finally
      //   355	363	868	finally
      //   370	399	868	finally
      //   406	428	868	finally
      //   435	440	868	finally
      //   447	458	868	finally
      //   465	476	868	finally
      //   483	521	868	finally
      //   543	549	868	finally
      //   555	561	878	finally
      //   572	586	888	finally
      //   586	593	904	finally
      //   596	604	904	finally
      //   609	616	904	finally
      //   659	673	904	finally
      //   677	729	904	finally
      //   779	784	904	finally
      //   749	754	927	java/io/IOException
      //   759	764	927	java/io/IOException
      //   14	30	932	java/lang/Exception
      //   33	43	932	java/lang/Exception
      //   555	561	932	java/lang/Exception
      //   50	58	950	java/lang/Exception
      //   65	73	950	java/lang/Exception
      //   80	85	950	java/lang/Exception
      //   92	103	950	java/lang/Exception
      //   110	121	950	java/lang/Exception
      //   128	166	950	java/lang/Exception
      //   192	198	950	java/lang/Exception
      //   205	215	950	java/lang/Exception
      //   222	231	950	java/lang/Exception
      //   246	253	950	java/lang/Exception
      //   282	290	950	java/lang/Exception
      //   297	304	950	java/lang/Exception
      //   311	316	950	java/lang/Exception
      //   323	333	950	java/lang/Exception
      //   340	348	950	java/lang/Exception
      //   355	363	950	java/lang/Exception
      //   370	399	950	java/lang/Exception
      //   406	428	950	java/lang/Exception
      //   435	440	950	java/lang/Exception
      //   447	458	950	java/lang/Exception
      //   465	476	950	java/lang/Exception
      //   483	521	950	java/lang/Exception
      //   543	549	950	java/lang/Exception
      //   572	586	964	java/lang/Exception
      //   784	789	973	java/io/IOException
      //   794	799	973	java/io/IOException
      //   622	627	978	java/io/IOException
      //   632	637	978	java/io/IOException
    }
    
    protected void onCancelled(Integer paramInteger)
    {
      if (this.mDownloadInfo.mIsRuntime)
      {
        XWalkLibraryLoader.access$002(null);
        Log.i("XWalkLib", "HttpDownloadTask runtime onCancelled: " + this.mDownloadInfo.mSavePath);
      }
      for (;;)
      {
        this.mListener.onDownloadCancelled();
        return;
        Log.i("XWalkLib", "HttpDownloadTask other onCancelled: " + this.mDownloadInfo.mSavePath);
      }
    }
    
    protected void onPostExecute(Integer paramInteger)
    {
      if (this.mDownloadInfo.mIsRuntime)
      {
        XWalkLibraryLoader.access$002(null);
        Log.i("XWalkLib", "HttpDownloadTask runtime onPostExecute result " + paramInteger + " " + this.mDownloadInfo.mSavePath);
      }
      while (paramInteger.intValue() == 0)
      {
        this.mDownloadInfo.mErrorCode = 0;
        this.mListener.onDownloadCompleted(this.mDownloadInfo);
        return;
        Log.i("XWalkLib", "HttpDownloadTask other onPostExecute result " + paramInteger + " " + this.mDownloadInfo.mSavePath);
      }
      this.mDownloadInfo.mErrorCode = -1;
      this.mListener.onDownloadFailed(this.mDownloadInfo);
    }
    
    protected void onPreExecute()
    {
      if (this.mDownloadInfo.mIsRuntime)
      {
        XWalkLibraryLoader.access$002(this);
        Log.i("XWalkLib", "HttpDownloadTask runtime onPreExecute: " + this.mDownloadInfo.mSavePath);
      }
      for (;;)
      {
        this.mDownloadedFile = new File(this.mDownloadInfo.mSavePath);
        this.mListener.onDownloadStarted(this.mDownloadInfo.mDownloadType);
        this.mDownloadInfo.mStartTimestamp = System.currentTimeMillis();
        Context localContext = XWalkEnvironment.getApplicationContext();
        this.mDownloadInfo.mNetWorkType = NetworkUtil.getCurrentNetWorkStatus(localContext);
        return;
        Log.i("XWalkLib", "HttpDownloadTask other onPreExecute: " + this.mDownloadInfo.mSavePath);
      }
    }
    
    protected void onProgressUpdate(Integer... paramVarArgs)
    {
      int i = 0;
      Log.d("XWalkLib", "HttpDownloadTask updated: " + paramVarArgs[0] + "/" + paramVarArgs[1]);
      if (paramVarArgs[1].intValue() > 0) {
        i = (int)(paramVarArgs[0].intValue() * 100.0D / paramVarArgs[1].intValue());
      }
      this.mListener.onDownloadUpdated(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.XWalkLibraryLoader
 * JD-Core Version:    0.7.0.1
 */