package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
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
    //   0: aload_0
    //   1: aload_2
    //   2: invokespecial 99	com/tencent/qqvideo/proxy/common/ConfigStorage:getHttpsSSLContext	(Landroid/content/Context;)Ljavax/net/ssl/SSLContext;
    //   5: astore 13
    //   7: aconst_null
    //   8: astore 8
    //   10: aconst_null
    //   11: astore_2
    //   12: aload 13
    //   14: ifnonnull +6 -> 20
    //   17: ldc 71
    //   19: areturn
    //   20: iconst_0
    //   21: istore_3
    //   22: iload_3
    //   23: iconst_2
    //   24: if_icmplt +6 -> 30
    //   27: ldc 71
    //   29: areturn
    //   30: iload_3
    //   31: iconst_1
    //   32: if_icmpne +615 -> 647
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 103	com/tencent/qqvideo/proxy/common/ConfigStorage:getBkDomain	(Ljava/lang/String;)Ljava/lang/String;
    //   40: astore 12
    //   42: iconst_4
    //   43: getstatic 61	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   46: new 105	java/lang/StringBuilder
    //   49: dup
    //   50: ldc 107
    //   52: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   55: aload 12
    //   57: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 124	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   66: iconst_0
    //   67: istore 4
    //   69: iload 4
    //   71: getstatic 63	com/tencent/qqvideo/proxy/common/ConfigStorage:retryTimes	[I
    //   74: iload_3
    //   75: iaload
    //   76: if_icmplt +10 -> 86
    //   79: iload_3
    //   80: iconst_1
    //   81: iadd
    //   82: istore_3
    //   83: goto -61 -> 22
    //   86: iconst_4
    //   87: getstatic 61	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   90: new 105	java/lang/StringBuilder
    //   93: dup
    //   94: ldc 126
    //   96: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: iload 4
    //   101: iconst_1
    //   102: iadd
    //   103: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: ldc 131
    //   108: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 12
    //   113: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 124	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   122: invokestatic 137	java/lang/System:currentTimeMillis	()J
    //   125: lstore 5
    //   127: new 139	java/net/URL
    //   130: dup
    //   131: aload 12
    //   133: invokespecial 140	java/net/URL:<init>	(Ljava/lang/String;)V
    //   136: invokevirtual 144	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   139: checkcast 146	javax/net/ssl/HttpsURLConnection
    //   142: astore 9
    //   144: aload 9
    //   146: getstatic 65	com/tencent/qqvideo/proxy/common/ConfigStorage:connectTimeOut	[I
    //   149: iload 4
    //   151: iaload
    //   152: invokevirtual 150	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   155: aload 9
    //   157: getstatic 67	com/tencent/qqvideo/proxy/common/ConfigStorage:readTimeOut	[I
    //   160: iload 4
    //   162: iaload
    //   163: invokevirtual 153	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   166: aload 9
    //   168: aload 13
    //   170: invokevirtual 159	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   173: invokevirtual 163	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   176: aload 9
    //   178: invokevirtual 167	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   181: astore 9
    //   183: aload 9
    //   185: astore 8
    //   187: new 105	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   194: astore 14
    //   196: new 170	java/io/BufferedReader
    //   199: dup
    //   200: new 172	java/io/InputStreamReader
    //   203: dup
    //   204: aload 8
    //   206: ldc 174
    //   208: invokespecial 177	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   211: invokespecial 180	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   214: astore 9
    //   216: aload 9
    //   218: astore 11
    //   220: aload 8
    //   222: astore 10
    //   224: aload 9
    //   226: invokevirtual 183	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   229: astore_2
    //   230: aload_2
    //   231: ifnonnull +116 -> 347
    //   234: aload 9
    //   236: astore 11
    //   238: aload 8
    //   240: astore 10
    //   242: aload 14
    //   244: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: astore_2
    //   248: aload 9
    //   250: astore 11
    //   252: aload 8
    //   254: astore 10
    //   256: iconst_4
    //   257: getstatic 61	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   260: new 105	java/lang/StringBuilder
    //   263: dup
    //   264: ldc 185
    //   266: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   269: invokestatic 137	java/lang/System:currentTimeMillis	()J
    //   272: lload 5
    //   274: lsub
    //   275: invokevirtual 188	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   278: ldc 190
    //   280: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_2
    //   284: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 124	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   293: aload 9
    //   295: astore 11
    //   297: aload 8
    //   299: astore 10
    //   301: aload_2
    //   302: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifne +241 -> 546
    //   308: aload 9
    //   310: astore 11
    //   312: aload 8
    //   314: astore 10
    //   316: aload_2
    //   317: invokevirtual 201	java/lang/String:trim	()Ljava/lang/String;
    //   320: invokevirtual 204	java/lang/String:isEmpty	()Z
    //   323: istore 7
    //   325: iload 7
    //   327: ifne +219 -> 546
    //   330: aload 8
    //   332: ifnull +8 -> 340
    //   335: aload 8
    //   337: invokevirtual 209	java/io/InputStream:close	()V
    //   340: aload 9
    //   342: invokevirtual 210	java/io/BufferedReader:close	()V
    //   345: aload_2
    //   346: areturn
    //   347: aload 9
    //   349: astore 11
    //   351: aload 8
    //   353: astore 10
    //   355: aload 14
    //   357: aload_2
    //   358: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: goto -146 -> 216
    //   365: astore_2
    //   366: aload 9
    //   368: astore_2
    //   369: aload_2
    //   370: astore 11
    //   372: aload 8
    //   374: astore 10
    //   376: bipush 6
    //   378: getstatic 61	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   381: new 105	java/lang/StringBuilder
    //   384: dup
    //   385: ldc 212
    //   387: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: getstatic 216	java/lang/System:err	Ljava/io/PrintStream;
    //   393: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 124	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   402: aload 8
    //   404: ifnull +8 -> 412
    //   407: aload 8
    //   409: invokevirtual 209	java/io/InputStream:close	()V
    //   412: aload_2
    //   413: astore 9
    //   415: aload 8
    //   417: astore 10
    //   419: aload_2
    //   420: ifnull +14 -> 434
    //   423: aload_2
    //   424: invokevirtual 210	java/io/BufferedReader:close	()V
    //   427: aload 8
    //   429: astore 10
    //   431: aload_2
    //   432: astore 9
    //   434: iload 4
    //   436: iconst_1
    //   437: iadd
    //   438: istore 4
    //   440: aload 9
    //   442: astore_2
    //   443: aload 10
    //   445: astore 8
    //   447: goto -378 -> 69
    //   450: astore_2
    //   451: aload 9
    //   453: astore_2
    //   454: aload_2
    //   455: astore 11
    //   457: aload 8
    //   459: astore 10
    //   461: bipush 6
    //   463: getstatic 61	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   466: ldc 221
    //   468: invokestatic 124	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   471: aload 8
    //   473: ifnull +8 -> 481
    //   476: aload 8
    //   478: invokevirtual 209	java/io/InputStream:close	()V
    //   481: aload_2
    //   482: astore 9
    //   484: aload 8
    //   486: astore 10
    //   488: aload_2
    //   489: ifnull -55 -> 434
    //   492: aload_2
    //   493: invokevirtual 210	java/io/BufferedReader:close	()V
    //   496: aload_2
    //   497: astore 9
    //   499: aload 8
    //   501: astore 10
    //   503: goto -69 -> 434
    //   506: astore 9
    //   508: aload_2
    //   509: astore 9
    //   511: aload 8
    //   513: astore 10
    //   515: goto -81 -> 434
    //   518: astore_1
    //   519: aload 11
    //   521: astore_2
    //   522: aload 10
    //   524: astore 8
    //   526: aload 8
    //   528: ifnull +8 -> 536
    //   531: aload 8
    //   533: invokevirtual 209	java/io/InputStream:close	()V
    //   536: aload_2
    //   537: ifnull +7 -> 544
    //   540: aload_2
    //   541: invokevirtual 210	java/io/BufferedReader:close	()V
    //   544: aload_1
    //   545: athrow
    //   546: aload 8
    //   548: ifnull +8 -> 556
    //   551: aload 8
    //   553: invokevirtual 209	java/io/InputStream:close	()V
    //   556: aload 9
    //   558: invokevirtual 210	java/io/BufferedReader:close	()V
    //   561: aload 8
    //   563: astore 10
    //   565: goto -131 -> 434
    //   568: astore_2
    //   569: aload 8
    //   571: astore 10
    //   573: goto -139 -> 434
    //   576: astore_1
    //   577: goto -237 -> 340
    //   580: astore_1
    //   581: goto -236 -> 345
    //   584: astore 9
    //   586: goto -174 -> 412
    //   589: astore 9
    //   591: aload_2
    //   592: astore 9
    //   594: aload 8
    //   596: astore 10
    //   598: goto -164 -> 434
    //   601: astore 9
    //   603: goto -122 -> 481
    //   606: astore 8
    //   608: goto -72 -> 536
    //   611: astore_2
    //   612: goto -68 -> 544
    //   615: astore_2
    //   616: goto -60 -> 556
    //   619: astore_1
    //   620: goto -94 -> 526
    //   623: astore_1
    //   624: goto -98 -> 526
    //   627: astore 9
    //   629: goto -175 -> 454
    //   632: astore 9
    //   634: goto -180 -> 454
    //   637: astore 9
    //   639: goto -270 -> 369
    //   642: astore 9
    //   644: goto -275 -> 369
    //   647: aload_1
    //   648: astore 12
    //   650: goto -584 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	653	0	this	ConfigStorage
    //   0	653	1	paramString	String
    //   0	653	2	paramContext	Context
    //   21	62	3	i	int
    //   67	372	4	j	int
    //   125	148	5	l	long
    //   323	3	7	bool	boolean
    //   8	587	8	localObject1	Object
    //   606	1	8	localIOException1	java.io.IOException
    //   142	356	9	localObject2	Object
    //   506	1	9	localIOException2	java.io.IOException
    //   509	48	9	localContext1	Context
    //   584	1	9	localIOException3	java.io.IOException
    //   589	1	9	localIOException4	java.io.IOException
    //   592	1	9	localContext2	Context
    //   601	1	9	localIOException5	java.io.IOException
    //   627	1	9	localThrowable1	Throwable
    //   632	1	9	localThrowable2	Throwable
    //   637	1	9	localIOException6	java.io.IOException
    //   642	1	9	localIOException7	java.io.IOException
    //   222	375	10	localObject3	Object
    //   218	302	11	localObject4	Object
    //   40	609	12	str	String
    //   5	164	13	localSSLContext	javax.net.ssl.SSLContext
    //   194	162	14	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   224	230	365	java/io/IOException
    //   242	248	365	java/io/IOException
    //   256	293	365	java/io/IOException
    //   301	308	365	java/io/IOException
    //   316	325	365	java/io/IOException
    //   355	362	365	java/io/IOException
    //   224	230	450	java/lang/Throwable
    //   242	248	450	java/lang/Throwable
    //   256	293	450	java/lang/Throwable
    //   301	308	450	java/lang/Throwable
    //   316	325	450	java/lang/Throwable
    //   355	362	450	java/lang/Throwable
    //   492	496	506	java/io/IOException
    //   224	230	518	finally
    //   242	248	518	finally
    //   256	293	518	finally
    //   301	308	518	finally
    //   316	325	518	finally
    //   355	362	518	finally
    //   376	402	518	finally
    //   461	471	518	finally
    //   556	561	568	java/io/IOException
    //   335	340	576	java/io/IOException
    //   340	345	580	java/io/IOException
    //   407	412	584	java/io/IOException
    //   423	427	589	java/io/IOException
    //   476	481	601	java/io/IOException
    //   531	536	606	java/io/IOException
    //   540	544	611	java/io/IOException
    //   551	556	615	java/io/IOException
    //   86	183	619	finally
    //   187	216	623	finally
    //   86	183	627	java/lang/Throwable
    //   187	216	632	java/lang/Throwable
    //   86	183	637	java/io/IOException
    //   187	216	642	java/io/IOException
  }
  
  public static SharedPreferences getAppSharedPreferences(Context paramContext)
  {
    if (sharedPreferencesName == null) {
      sharedPreferencesName = paramContext.getPackageName() + "_httpproxy_preferences";
    }
    return getSharedPreferences(paramContext, sharedPreferencesName, 0);
  }
  
  private String getBkDomain(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return str;
  }
  
  public static String getConfigVersion()
  {
    return Config_Version;
  }
  
  private static String getConfigVersionFromSharedPreference(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    return getAppSharedPreferences(paramContext).getString("DOWNPROXY_GUID_CONFIG_VERSION", "");
  }
  
  public static String getDownProxyConfig(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    Config_Version = getConfigVersionFromSharedPreference(paramContext);
    return getAppSharedPreferences(paramContext).getString("DOWNPROXY_CONFIG", "");
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
    //   0: ldc_w 256
    //   3: invokestatic 262	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   6: astore_3
    //   7: aload_1
    //   8: invokevirtual 266	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   11: ldc 38
    //   13: invokevirtual 272	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: astore_2
    //   17: aload_2
    //   18: astore_1
    //   19: aload_3
    //   20: aload_2
    //   21: invokevirtual 276	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   24: astore 4
    //   26: aload_2
    //   27: astore_1
    //   28: invokestatic 281	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   31: invokestatic 284	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   34: astore_3
    //   35: aload_2
    //   36: astore_1
    //   37: aload_3
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 288	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   43: aload_2
    //   44: astore_1
    //   45: aload_3
    //   46: ldc_w 290
    //   49: aload 4
    //   51: invokevirtual 294	java/security/KeyStore:setCertificateEntry	(Ljava/lang/String;Ljava/security/cert/Certificate;)V
    //   54: aload_2
    //   55: astore_1
    //   56: invokestatic 299	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   59: invokestatic 302	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   62: astore 4
    //   64: aload_2
    //   65: astore_1
    //   66: aload 4
    //   68: aload_3
    //   69: invokevirtual 306	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   72: aload_2
    //   73: astore_1
    //   74: ldc_w 308
    //   77: invokestatic 311	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   80: astore_3
    //   81: aload_2
    //   82: astore_1
    //   83: aload_3
    //   84: aconst_null
    //   85: aload 4
    //   87: invokevirtual 315	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   90: aconst_null
    //   91: invokevirtual 318	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 209	java/io/InputStream:close	()V
    //   102: aload_3
    //   103: areturn
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_2
    //   107: aload_2
    //   108: astore_1
    //   109: bipush 6
    //   111: getstatic 61	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   114: new 105	java/lang/StringBuilder
    //   117: dup
    //   118: ldc_w 320
    //   121: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   124: aload_3
    //   125: invokestatic 326	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   128: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 124	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 209	java/io/InputStream:close	()V
    //   145: aconst_null
    //   146: areturn
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 209	java/io/InputStream:close	()V
    //   158: aload_2
    //   159: athrow
    //   160: astore_1
    //   161: aload_3
    //   162: areturn
    //   163: astore_1
    //   164: goto -19 -> 145
    //   167: astore_1
    //   168: goto -10 -> 158
    //   171: astore_2
    //   172: goto -22 -> 150
    //   175: astore_3
    //   176: goto -69 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	ConfigStorage
    //   0	179	1	paramContext	Context
    //   16	126	2	localInputStream	java.io.InputStream
    //   147	12	2	localObject1	Object
    //   171	1	2	localObject2	Object
    //   6	97	3	localObject3	Object
    //   104	58	3	localThrowable1	Throwable
    //   175	1	3	localThrowable2	Throwable
    //   24	62	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	17	104	java/lang/Throwable
    //   0	17	147	finally
    //   98	102	160	java/io/IOException
    //   141	145	163	java/io/IOException
    //   154	158	167	java/io/IOException
    //   19	26	171	finally
    //   28	35	171	finally
    //   37	43	171	finally
    //   45	54	171	finally
    //   56	64	171	finally
    //   66	72	171	finally
    //   74	81	171	finally
    //   83	94	171	finally
    //   109	137	171	finally
    //   19	26	175	java/lang/Throwable
    //   28	35	175	java/lang/Throwable
    //   37	43	175	java/lang/Throwable
    //   45	54	175	java/lang/Throwable
    //   56	64	175	java/lang/Throwable
    //   66	72	175	java/lang/Throwable
    //   74	81	175	java/lang/Throwable
    //   83	94	175	java/lang/Throwable
  }
  
  public static SharedPreferences getSharedPreferences(Context paramContext, String paramString, int paramInt)
  {
    return paramContext.getSharedPreferences(paramString, paramInt);
  }
  
  private String makeGetServerConfigUrl(Context paramContext)
  {
    return String.format("%s?platform=%s&appver=%s&player_channel_id=%s&otype=%s&ipflag=%s&guid=%s", new Object[] { "https://sec.video.qq.com/p/wxconf/getmfomat", "aphone", "V1.0.186.0011", "186", "json", "1", guid });
  }
  
  private boolean needGetConfig()
  {
    if (LastGetConfigTime == 0L)
    {
      LastGetConfigTime = System.currentTimeMillis();
      return true;
    }
    long l = System.currentTimeMillis();
    if ((l - LastGetConfigTime > 600000L) || (l < LastGetConfigTime))
    {
      LastGetConfigTime = System.currentTimeMillis();
      return true;
    }
    return false;
  }
  
  private static void setConfigVersionToSharedPreference(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {
      return;
    }
    getAppSharedPreferences(paramContext).edit().putString("DOWNPROXY_GUID_CONFIG_VERSION", paramString).commit();
  }
  
  public static void setDownProxyConfig(Context paramContext, String paramString)
  {
    getAppSharedPreferences(paramContext).edit().putString("DOWNPROXY_CONFIG", paramString).commit();
  }
  
  private void synGetConfig(Context paramContext)
  {
    if (!needGetConfig())
    {
      HttpproxyFacade.print(4, TAG, "last get config time:" + System.currentTimeMillis() + ",so get config just return");
      return;
    }
    Object localObject = makeGetServerConfigUrl(paramContext);
    k = -1;
    i = k;
    for (;;)
    {
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
      }
      catch (Throwable paramContext)
      {
        HttpproxyFacade.print(6, TAG, "get config exception");
        k = i;
        continue;
      }
      try
      {
        paramContext = new JSONObject();
        paramContext.put("error_code", k);
        paramContext.put("report_type", 90);
        HttpproxyFacade.jsonReport(paramContext.toString());
        return;
      }
      catch (JSONException paramContext) {}
    }
  }
  
  public void stopGetServerConfig()
  {
    try
    {
      if (this.thread != null) {
        this.thread.interrupt();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      HttpproxyFacade.print(6, TAG, "thread create exception");
    }
  }
  
  public void synGetServerConfig(Context paramContext)
  {
    if (paramContext == null)
    {
      HttpproxyFacade.print(6, TAG, "synGetServerConfig context is null");
      return;
    }
    try
    {
      this.thread = new Thread(new ConfigStorage.1(this, paramContext));
      if (this.thread == null)
      {
        HttpproxyFacade.print(6, TAG, "thread create failed");
        return;
      }
    }
    catch (Throwable paramContext)
    {
      HttpproxyFacade.print(6, TAG, "thread create exception");
      return;
    }
    this.thread.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqvideo.proxy.common.ConfigStorage
 * JD-Core Version:    0.7.0.1
 */