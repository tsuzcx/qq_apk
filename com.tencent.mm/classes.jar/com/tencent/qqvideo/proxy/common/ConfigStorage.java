package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigStorage
{
  private static String Config_Version = "";
  private static final long GET_CONFIG_INTERVAL = 600000L;
  private static long LastGetConfigTime = 0L;
  private static final String PREFERENCE = "_httpproxy_preferences";
  public static final String PREF_DOWNPROXY_CONFIG = "DOWNPROXY_CONFIG";
  public static final String PREF_DOWNPROXY_CONFIG_VERSION = "DOWNPROXY_GUID_CONFIG_VERSION";
  private static String TAG = "TV_Httpproxy";
  private static final String TVHttpProxy_Version = "V1.0.186.0011";
  private static final String TVHttpProxy_Version_Code = "101860011";
  private static final String TVHttpProxy_channel_id = "186";
  private static final int[] connectTimeOut;
  private static String guid = "123";
  private static final String httpsCrtFileName = "videosdkcrt/sec.video.qq.com.crt";
  private static final String ipflag = "1";
  private static final String otype = "json";
  private static final String platform = "aphone";
  private static final int[] readTimeOut;
  private static final int[] retryTimes = { 3, 2 };
  private static String sharedPreferencesName;
  private static final String url = "https://sec.video.qq.com/p/wxconf/getmfomat";
  private Thread thread = null;
  
  static
  {
    connectTimeOut = new int[] { 5000, 5000, 10000 };
    readTimeOut = new int[] { 10000, 10000, 15000 };
    LastGetConfigTime = 0L;
  }
  
  /* Error */
  private String fetchTextFromUrl(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: ldc 106
    //   2: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_2
    //   7: invokespecial 110	com/tencent/qqvideo/proxy/common/ConfigStorage:getHttpsSSLContext	(Landroid/content/Context;)Ljavax/net/ssl/SSLContext;
    //   10: astore 12
    //   12: aconst_null
    //   13: astore 8
    //   15: aconst_null
    //   16: astore_2
    //   17: aload 12
    //   19: ifnonnull +11 -> 30
    //   22: ldc 106
    //   24: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 73
    //   29: areturn
    //   30: iconst_0
    //   31: istore_3
    //   32: iload_3
    //   33: iconst_2
    //   34: if_icmplt +11 -> 45
    //   37: ldc 106
    //   39: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: ldc 73
    //   44: areturn
    //   45: iload_3
    //   46: iconst_1
    //   47: if_icmpne +556 -> 603
    //   50: aload_0
    //   51: aload_1
    //   52: invokespecial 114	com/tencent/qqvideo/proxy/common/ConfigStorage:getBkDomain	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore 11
    //   57: iconst_4
    //   58: getstatic 63	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   61: ldc 116
    //   63: aload 11
    //   65: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   68: invokevirtual 125	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   71: invokestatic 131	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   74: iconst_0
    //   75: istore 4
    //   77: iload 4
    //   79: getstatic 65	com/tencent/qqvideo/proxy/common/ConfigStorage:retryTimes	[I
    //   82: iload_3
    //   83: iaload
    //   84: if_icmplt +10 -> 94
    //   87: iload_3
    //   88: iconst_1
    //   89: iadd
    //   90: istore_3
    //   91: goto -59 -> 32
    //   94: iconst_4
    //   95: getstatic 63	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   98: new 133	java/lang/StringBuilder
    //   101: dup
    //   102: ldc 135
    //   104: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: iload 4
    //   109: iconst_1
    //   110: iadd
    //   111: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: ldc 144
    //   116: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 11
    //   121: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 131	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   130: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   133: lstore 5
    //   135: new 159	java/net/URL
    //   138: dup
    //   139: aload 11
    //   141: invokespecial 160	java/net/URL:<init>	(Ljava/lang/String;)V
    //   144: invokevirtual 164	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   147: checkcast 166	javax/net/ssl/HttpsURLConnection
    //   150: astore 9
    //   152: aload 9
    //   154: getstatic 67	com/tencent/qqvideo/proxy/common/ConfigStorage:connectTimeOut	[I
    //   157: iload 4
    //   159: iaload
    //   160: invokevirtual 169	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   163: aload 9
    //   165: getstatic 69	com/tencent/qqvideo/proxy/common/ConfigStorage:readTimeOut	[I
    //   168: iload 4
    //   170: iaload
    //   171: invokevirtual 172	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   174: aload 9
    //   176: aload 12
    //   178: invokevirtual 178	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   181: invokevirtual 182	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   184: aload 9
    //   186: invokevirtual 186	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   189: astore 9
    //   191: aload 9
    //   193: astore 8
    //   195: new 133	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   202: astore 10
    //   204: new 189	java/io/BufferedReader
    //   207: dup
    //   208: new 191	java/io/InputStreamReader
    //   211: dup
    //   212: aload 8
    //   214: ldc 193
    //   216: invokespecial 196	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   219: invokespecial 199	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   222: astore 9
    //   224: aload 9
    //   226: invokevirtual 202	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   229: astore_2
    //   230: aload_2
    //   231: ifnonnull +89 -> 320
    //   234: aload 10
    //   236: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: astore_2
    //   240: iconst_4
    //   241: getstatic 63	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   244: new 133	java/lang/StringBuilder
    //   247: dup
    //   248: ldc 204
    //   250: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   256: lload 5
    //   258: lsub
    //   259: invokevirtual 207	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   262: ldc 209
    //   264: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_2
    //   268: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 131	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   277: aload_2
    //   278: invokestatic 215	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   281: ifne +230 -> 511
    //   284: aload_2
    //   285: invokevirtual 218	java/lang/String:trim	()Ljava/lang/String;
    //   288: invokevirtual 221	java/lang/String:isEmpty	()Z
    //   291: istore 7
    //   293: iload 7
    //   295: ifne +216 -> 511
    //   298: aload 8
    //   300: ifnull +8 -> 308
    //   303: aload 8
    //   305: invokevirtual 226	java/io/InputStream:close	()V
    //   308: aload 9
    //   310: invokevirtual 227	java/io/BufferedReader:close	()V
    //   313: ldc 106
    //   315: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: aload_2
    //   319: areturn
    //   320: aload 10
    //   322: aload_2
    //   323: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: goto -103 -> 224
    //   330: astore_2
    //   331: aload 9
    //   333: astore_2
    //   334: aload_2
    //   335: astore 9
    //   337: aload 8
    //   339: astore 10
    //   341: bipush 6
    //   343: getstatic 63	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   346: new 133	java/lang/StringBuilder
    //   349: dup
    //   350: ldc 229
    //   352: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   355: getstatic 233	java/lang/System:err	Ljava/io/PrintStream;
    //   358: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 131	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   367: aload 8
    //   369: ifnull +8 -> 377
    //   372: aload 8
    //   374: invokevirtual 226	java/io/InputStream:close	()V
    //   377: aload_2
    //   378: astore 9
    //   380: aload 8
    //   382: astore 10
    //   384: aload_2
    //   385: ifnull +14 -> 399
    //   388: aload_2
    //   389: invokevirtual 227	java/io/BufferedReader:close	()V
    //   392: aload 8
    //   394: astore 10
    //   396: aload_2
    //   397: astore 9
    //   399: iload 4
    //   401: iconst_1
    //   402: iadd
    //   403: istore 4
    //   405: aload 9
    //   407: astore_2
    //   408: aload 10
    //   410: astore 8
    //   412: goto -335 -> 77
    //   415: astore_2
    //   416: aload 9
    //   418: astore_2
    //   419: aload_2
    //   420: astore 9
    //   422: aload 8
    //   424: astore 10
    //   426: bipush 6
    //   428: getstatic 63	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   431: ldc 238
    //   433: invokestatic 131	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   436: aload 8
    //   438: ifnull +8 -> 446
    //   441: aload 8
    //   443: invokevirtual 226	java/io/InputStream:close	()V
    //   446: aload_2
    //   447: astore 9
    //   449: aload 8
    //   451: astore 10
    //   453: aload_2
    //   454: ifnull -55 -> 399
    //   457: aload_2
    //   458: invokevirtual 227	java/io/BufferedReader:close	()V
    //   461: aload_2
    //   462: astore 9
    //   464: aload 8
    //   466: astore 10
    //   468: goto -69 -> 399
    //   471: astore 9
    //   473: aload_2
    //   474: astore 9
    //   476: aload 8
    //   478: astore 10
    //   480: goto -81 -> 399
    //   483: astore_1
    //   484: aload 10
    //   486: ifnull +8 -> 494
    //   489: aload 10
    //   491: invokevirtual 226	java/io/InputStream:close	()V
    //   494: aload 9
    //   496: ifnull +8 -> 504
    //   499: aload 9
    //   501: invokevirtual 227	java/io/BufferedReader:close	()V
    //   504: ldc 106
    //   506: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   509: aload_1
    //   510: athrow
    //   511: aload 8
    //   513: ifnull +8 -> 521
    //   516: aload 8
    //   518: invokevirtual 226	java/io/InputStream:close	()V
    //   521: aload 9
    //   523: invokevirtual 227	java/io/BufferedReader:close	()V
    //   526: aload 8
    //   528: astore 10
    //   530: goto -131 -> 399
    //   533: astore_2
    //   534: aload 8
    //   536: astore 10
    //   538: goto -139 -> 399
    //   541: astore_1
    //   542: goto -234 -> 308
    //   545: astore_1
    //   546: goto -233 -> 313
    //   549: astore 9
    //   551: goto -174 -> 377
    //   554: astore 9
    //   556: aload_2
    //   557: astore 9
    //   559: aload 8
    //   561: astore 10
    //   563: goto -164 -> 399
    //   566: astore 9
    //   568: goto -122 -> 446
    //   571: astore_2
    //   572: goto -78 -> 494
    //   575: astore_2
    //   576: goto -72 -> 504
    //   579: astore_2
    //   580: goto -59 -> 521
    //   583: astore 9
    //   585: goto -166 -> 419
    //   588: astore 9
    //   590: goto -171 -> 419
    //   593: astore 9
    //   595: goto -261 -> 334
    //   598: astore 9
    //   600: goto -266 -> 334
    //   603: aload_1
    //   604: astore 11
    //   606: goto -532 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	609	0	this	ConfigStorage
    //   0	609	1	paramString	String
    //   0	609	2	paramContext	Context
    //   31	60	3	i	int
    //   75	329	4	j	int
    //   133	124	5	l	long
    //   291	3	7	bool	boolean
    //   13	547	8	localObject1	Object
    //   150	313	9	localObject2	Object
    //   471	1	9	localIOException1	java.io.IOException
    //   474	48	9	localContext1	Context
    //   549	1	9	localIOException2	java.io.IOException
    //   554	1	9	localIOException3	java.io.IOException
    //   557	1	9	localContext2	Context
    //   566	1	9	localIOException4	java.io.IOException
    //   583	1	9	localObject3	Object
    //   588	1	9	localObject4	Object
    //   593	1	9	localIOException5	java.io.IOException
    //   598	1	9	localIOException6	java.io.IOException
    //   202	360	10	localObject5	Object
    //   55	550	11	str	String
    //   10	167	12	localSSLContext	javax.net.ssl.SSLContext
    // Exception table:
    //   from	to	target	type
    //   224	230	330	java/io/IOException
    //   234	293	330	java/io/IOException
    //   320	327	330	java/io/IOException
    //   224	230	415	finally
    //   234	293	415	finally
    //   320	327	415	finally
    //   457	461	471	java/io/IOException
    //   341	367	483	finally
    //   426	436	483	finally
    //   521	526	533	java/io/IOException
    //   303	308	541	java/io/IOException
    //   308	313	545	java/io/IOException
    //   372	377	549	java/io/IOException
    //   388	392	554	java/io/IOException
    //   441	446	566	java/io/IOException
    //   489	494	571	java/io/IOException
    //   499	504	575	java/io/IOException
    //   516	521	579	java/io/IOException
    //   94	191	583	finally
    //   195	224	588	finally
    //   94	191	593	java/io/IOException
    //   195	224	598	java/io/IOException
  }
  
  public static SharedPreferences getAppSharedPreferences(Context paramContext)
  {
    AppMethodBeat.i(89732);
    if (sharedPreferencesName == null) {
      sharedPreferencesName = paramContext.getPackageName() + "_httpproxy_preferences";
    }
    paramContext = getSharedPreferences(paramContext, sharedPreferencesName, 0);
    AppMethodBeat.o(89732);
    return paramContext;
  }
  
  private String getBkDomain(String paramString)
  {
    AppMethodBeat.i(89744);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(89744);
      return "";
    }
    AppMethodBeat.o(89744);
    return paramString;
  }
  
  public static String getConfigVersion()
  {
    return Config_Version;
  }
  
  private static String getConfigVersionFromSharedPreference(Context paramContext)
  {
    AppMethodBeat.i(89735);
    if (paramContext == null)
    {
      AppMethodBeat.o(89735);
      return "";
    }
    paramContext = getAppSharedPreferences(paramContext).getString("DOWNPROXY_GUID_CONFIG_VERSION", "");
    AppMethodBeat.o(89735);
    return paramContext;
  }
  
  public static String getDownProxyConfig(Context paramContext)
  {
    AppMethodBeat.i(89733);
    if (paramContext == null)
    {
      AppMethodBeat.o(89733);
      return "";
    }
    Config_Version = getConfigVersionFromSharedPreference(paramContext);
    paramContext = getAppSharedPreferences(paramContext).getString("DOWNPROXY_CONFIG", "");
    AppMethodBeat.o(89733);
    return paramContext;
  }
  
  public static String getHttpProxyVersion()
  {
    return "V1.0.186.0011";
  }
  
  public static String getHttpProxyVersionCode()
  {
    return "101860011";
  }
  
  /* Error */
  private javax.net.ssl.SSLContext getHttpsSSLContext(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 272
    //   3: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 274
    //   9: invokestatic 280	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   12: astore_2
    //   13: aload_1
    //   14: invokevirtual 284	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   17: ldc 40
    //   19: invokevirtual 290	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_1
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual 294	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   28: astore_3
    //   29: invokestatic 299	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   32: invokestatic 302	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   35: astore_2
    //   36: aload_2
    //   37: aconst_null
    //   38: aconst_null
    //   39: invokevirtual 306	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   42: aload_2
    //   43: ldc_w 308
    //   46: aload_3
    //   47: invokevirtual 312	java/security/KeyStore:setCertificateEntry	(Ljava/lang/String;Ljava/security/cert/Certificate;)V
    //   50: invokestatic 317	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   53: invokestatic 320	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   56: astore_3
    //   57: aload_3
    //   58: aload_2
    //   59: invokevirtual 324	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   62: ldc_w 326
    //   65: invokestatic 329	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   68: astore_2
    //   69: aload_2
    //   70: aconst_null
    //   71: aload_3
    //   72: invokevirtual 333	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   75: aconst_null
    //   76: invokevirtual 336	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokevirtual 226	java/io/InputStream:close	()V
    //   87: ldc_w 272
    //   90: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_2
    //   94: areturn
    //   95: astore_2
    //   96: aconst_null
    //   97: astore_1
    //   98: bipush 6
    //   100: getstatic 63	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   103: new 133	java/lang/StringBuilder
    //   106: dup
    //   107: ldc_w 338
    //   110: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   113: aload_2
    //   114: invokestatic 344	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   117: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 131	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 226	java/io/InputStream:close	()V
    //   134: ldc_w 272
    //   137: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_2
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 226	java/io/InputStream:close	()V
    //   151: ldc_w 272
    //   154: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload_2
    //   158: athrow
    //   159: astore_1
    //   160: goto -73 -> 87
    //   163: astore_1
    //   164: goto -30 -> 134
    //   167: astore_1
    //   168: goto -17 -> 151
    //   171: astore_2
    //   172: goto -74 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	ConfigStorage
    //   0	175	1	paramContext	Context
    //   12	82	2	localObject1	Object
    //   95	19	2	localThrowable	java.lang.Throwable
    //   142	16	2	localObject2	Object
    //   171	1	2	localObject3	Object
    //   28	44	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   6	23	95	finally
    //   98	126	142	finally
    //   83	87	159	java/io/IOException
    //   130	134	163	java/io/IOException
    //   147	151	167	java/io/IOException
    //   23	79	171	finally
  }
  
  public static SharedPreferences getSharedPreferences(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(89731);
    paramContext = paramContext.getSharedPreferences(paramString, paramInt);
    AppMethodBeat.o(89731);
    return paramContext;
  }
  
  private String makeGetServerConfigUrl(Context paramContext)
  {
    AppMethodBeat.i(89741);
    paramContext = String.format("%s?platform=%s&appver=%s&player_channel_id=%s&otype=%s&ipflag=%s&guid=%s", new Object[] { "https://sec.video.qq.com/p/wxconf/getmfomat", "aphone", "V1.0.186.0011", "186", "json", "1", guid });
    AppMethodBeat.o(89741);
    return paramContext;
  }
  
  private boolean needGetConfig()
  {
    AppMethodBeat.i(89739);
    if (LastGetConfigTime == 0L)
    {
      LastGetConfigTime = System.currentTimeMillis();
      AppMethodBeat.o(89739);
      return true;
    }
    long l = System.currentTimeMillis();
    if ((l - LastGetConfigTime > 600000L) || (l < LastGetConfigTime))
    {
      LastGetConfigTime = System.currentTimeMillis();
      AppMethodBeat.o(89739);
      return true;
    }
    AppMethodBeat.o(89739);
    return false;
  }
  
  private static void setConfigVersionToSharedPreference(Context paramContext, String paramString)
  {
    AppMethodBeat.i(89736);
    if ((paramContext == null) || (paramString == null))
    {
      AppMethodBeat.o(89736);
      return;
    }
    getAppSharedPreferences(paramContext).edit().putString("DOWNPROXY_GUID_CONFIG_VERSION", paramString).commit();
    AppMethodBeat.o(89736);
  }
  
  public static void setDownProxyConfig(Context paramContext, String paramString)
  {
    AppMethodBeat.i(89734);
    getAppSharedPreferences(paramContext).edit().putString("DOWNPROXY_CONFIG", paramString).commit();
    AppMethodBeat.o(89734);
  }
  
  private void synGetConfig(Context paramContext)
  {
    AppMethodBeat.i(89740);
    if (!needGetConfig())
    {
      HttpproxyFacade.print(4, TAG, "last get config time:" + System.currentTimeMillis() + ",so get config just return");
      AppMethodBeat.o(89740);
      return;
    }
    Object localObject = makeGetServerConfigUrl(paramContext);
    int k = -1;
    int i = k;
    try
    {
      localObject = new JSONObject(fetchTextFromUrl((String)localObject, paramContext));
      int j = k;
      i = k;
      if (((JSONObject)localObject).has("httpproxy_config"))
      {
        k = 0;
        j = 0;
        i = k;
        HttpproxyFacade.print(3, TAG, "get httpproxy_config:" + ((JSONObject)localObject).getString("httpproxy_config"));
        i = k;
        setDownProxyConfig(paramContext, ((JSONObject)localObject).getString("httpproxy_config"));
      }
      k = j;
      i = j;
      if (((JSONObject)localObject).has("config_ver"))
      {
        i = j;
        setConfigVersionToSharedPreference(paramContext, ((JSONObject)localObject).getString("config_ver"));
        k = j;
      }
      return;
    }
    finally
    {
      for (;;)
      {
        try
        {
          paramContext = new JSONObject();
          paramContext.put("error_code", k);
          paramContext.put("report_type", 90);
          HttpproxyFacade.jsonReport(paramContext.toString());
          AppMethodBeat.o(89740);
          return;
        }
        catch (JSONException paramContext)
        {
          AppMethodBeat.o(89740);
        }
        paramContext = finally;
        HttpproxyFacade.print(6, TAG, "get config exception");
        k = i;
      }
    }
  }
  
  public void stopGetServerConfig()
  {
    AppMethodBeat.i(89738);
    try
    {
      if (this.thread != null)
      {
        this.thread.interrupt();
        AppMethodBeat.o(89738);
        return;
      }
    }
    finally
    {
      HttpproxyFacade.print(6, TAG, "thread create exception");
      AppMethodBeat.o(89738);
    }
  }
  
  public void synGetServerConfig(final Context paramContext)
  {
    AppMethodBeat.i(89737);
    if (paramContext == null)
    {
      HttpproxyFacade.print(6, TAG, "synGetServerConfig context is null");
      AppMethodBeat.o(89737);
      return;
    }
    try
    {
      this.thread = new Thread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(89730);
          ConfigStorage.access$0(ConfigStorage.this, paramContext);
          AppMethodBeat.o(89730);
        }
      });
      if (this.thread == null) {
        return;
      }
      this.thread.start();
      AppMethodBeat.o(89737);
      return;
    }
    finally
    {
      HttpproxyFacade.print(6, TAG, "thread create exception");
      AppMethodBeat.o(89737);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqvideo.proxy.common.ConfigStorage
 * JD-Core Version:    0.7.0.1
 */