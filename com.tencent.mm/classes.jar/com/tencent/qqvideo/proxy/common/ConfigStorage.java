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
    //   0: ldc 108
    //   2: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_2
    //   7: invokespecial 112	com/tencent/qqvideo/proxy/common/ConfigStorage:getHttpsSSLContext	(Landroid/content/Context;)Ljavax/net/ssl/SSLContext;
    //   10: astore 13
    //   12: aconst_null
    //   13: astore 8
    //   15: aconst_null
    //   16: astore_2
    //   17: aload 13
    //   19: ifnonnull +11 -> 30
    //   22: ldc 108
    //   24: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: ldc 73
    //   29: areturn
    //   30: iconst_0
    //   31: istore_3
    //   32: iload_3
    //   33: iconst_2
    //   34: if_icmplt +11 -> 45
    //   37: ldc 108
    //   39: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: ldc 73
    //   44: areturn
    //   45: iload_3
    //   46: iconst_1
    //   47: if_icmpne +618 -> 665
    //   50: aload_0
    //   51: aload_1
    //   52: invokespecial 116	com/tencent/qqvideo/proxy/common/ConfigStorage:getBkDomain	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore 12
    //   57: iconst_4
    //   58: getstatic 63	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   61: ldc 118
    //   63: aload 12
    //   65: invokestatic 124	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   68: invokevirtual 127	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   71: invokestatic 133	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
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
    //   98: new 135	java/lang/StringBuilder
    //   101: dup
    //   102: ldc 137
    //   104: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: iload 4
    //   109: iconst_1
    //   110: iadd
    //   111: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: ldc 146
    //   116: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 12
    //   121: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 133	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   130: invokestatic 159	java/lang/System:currentTimeMillis	()J
    //   133: lstore 5
    //   135: new 161	java/net/URL
    //   138: dup
    //   139: aload 12
    //   141: invokespecial 162	java/net/URL:<init>	(Ljava/lang/String;)V
    //   144: invokevirtual 166	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   147: checkcast 168	javax/net/ssl/HttpsURLConnection
    //   150: astore 9
    //   152: aload 9
    //   154: getstatic 67	com/tencent/qqvideo/proxy/common/ConfigStorage:connectTimeOut	[I
    //   157: iload 4
    //   159: iaload
    //   160: invokevirtual 171	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   163: aload 9
    //   165: getstatic 69	com/tencent/qqvideo/proxy/common/ConfigStorage:readTimeOut	[I
    //   168: iload 4
    //   170: iaload
    //   171: invokevirtual 174	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   174: aload 9
    //   176: aload 13
    //   178: invokevirtual 180	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   181: invokevirtual 184	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   184: aload 9
    //   186: invokevirtual 188	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   189: astore 9
    //   191: aload 9
    //   193: astore 8
    //   195: new 135	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   202: astore 14
    //   204: new 191	java/io/BufferedReader
    //   207: dup
    //   208: new 193	java/io/InputStreamReader
    //   211: dup
    //   212: aload 8
    //   214: ldc 195
    //   216: invokespecial 198	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   219: invokespecial 201	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   222: astore 9
    //   224: aload 9
    //   226: astore 11
    //   228: aload 8
    //   230: astore 10
    //   232: aload 9
    //   234: invokevirtual 204	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   237: astore_2
    //   238: aload_2
    //   239: ifnonnull +121 -> 360
    //   242: aload 9
    //   244: astore 11
    //   246: aload 8
    //   248: astore 10
    //   250: aload 14
    //   252: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: astore_2
    //   256: aload 9
    //   258: astore 11
    //   260: aload 8
    //   262: astore 10
    //   264: iconst_4
    //   265: getstatic 63	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   268: new 135	java/lang/StringBuilder
    //   271: dup
    //   272: ldc 206
    //   274: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   277: invokestatic 159	java/lang/System:currentTimeMillis	()J
    //   280: lload 5
    //   282: lsub
    //   283: invokevirtual 209	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   286: ldc 211
    //   288: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_2
    //   292: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 133	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   301: aload 9
    //   303: astore 11
    //   305: aload 8
    //   307: astore 10
    //   309: aload_2
    //   310: invokestatic 217	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   313: ifne +251 -> 564
    //   316: aload 9
    //   318: astore 11
    //   320: aload 8
    //   322: astore 10
    //   324: aload_2
    //   325: invokevirtual 220	java/lang/String:trim	()Ljava/lang/String;
    //   328: invokevirtual 223	java/lang/String:isEmpty	()Z
    //   331: istore 7
    //   333: iload 7
    //   335: ifne +229 -> 564
    //   338: aload 8
    //   340: ifnull +8 -> 348
    //   343: aload 8
    //   345: invokevirtual 228	java/io/InputStream:close	()V
    //   348: aload 9
    //   350: invokevirtual 229	java/io/BufferedReader:close	()V
    //   353: ldc 108
    //   355: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   358: aload_2
    //   359: areturn
    //   360: aload 9
    //   362: astore 11
    //   364: aload 8
    //   366: astore 10
    //   368: aload 14
    //   370: aload_2
    //   371: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: goto -151 -> 224
    //   378: astore_2
    //   379: aload 9
    //   381: astore_2
    //   382: aload_2
    //   383: astore 11
    //   385: aload 8
    //   387: astore 10
    //   389: bipush 6
    //   391: getstatic 63	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   394: new 135	java/lang/StringBuilder
    //   397: dup
    //   398: ldc 231
    //   400: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   403: getstatic 235	java/lang/System:err	Ljava/io/PrintStream;
    //   406: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 133	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   415: aload 8
    //   417: ifnull +8 -> 425
    //   420: aload 8
    //   422: invokevirtual 228	java/io/InputStream:close	()V
    //   425: aload_2
    //   426: astore 9
    //   428: aload 8
    //   430: astore 10
    //   432: aload_2
    //   433: ifnull +14 -> 447
    //   436: aload_2
    //   437: invokevirtual 229	java/io/BufferedReader:close	()V
    //   440: aload 8
    //   442: astore 10
    //   444: aload_2
    //   445: astore 9
    //   447: iload 4
    //   449: iconst_1
    //   450: iadd
    //   451: istore 4
    //   453: aload 9
    //   455: astore_2
    //   456: aload 10
    //   458: astore 8
    //   460: goto -383 -> 77
    //   463: astore_2
    //   464: aload 9
    //   466: astore_2
    //   467: aload_2
    //   468: astore 11
    //   470: aload 8
    //   472: astore 10
    //   474: bipush 6
    //   476: getstatic 63	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   479: ldc 240
    //   481: invokestatic 133	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   484: aload 8
    //   486: ifnull +8 -> 494
    //   489: aload 8
    //   491: invokevirtual 228	java/io/InputStream:close	()V
    //   494: aload_2
    //   495: astore 9
    //   497: aload 8
    //   499: astore 10
    //   501: aload_2
    //   502: ifnull -55 -> 447
    //   505: aload_2
    //   506: invokevirtual 229	java/io/BufferedReader:close	()V
    //   509: aload_2
    //   510: astore 9
    //   512: aload 8
    //   514: astore 10
    //   516: goto -69 -> 447
    //   519: astore 9
    //   521: aload_2
    //   522: astore 9
    //   524: aload 8
    //   526: astore 10
    //   528: goto -81 -> 447
    //   531: astore_1
    //   532: aload 11
    //   534: astore_2
    //   535: aload 10
    //   537: astore 8
    //   539: aload 8
    //   541: ifnull +8 -> 549
    //   544: aload 8
    //   546: invokevirtual 228	java/io/InputStream:close	()V
    //   549: aload_2
    //   550: ifnull +7 -> 557
    //   553: aload_2
    //   554: invokevirtual 229	java/io/BufferedReader:close	()V
    //   557: ldc 108
    //   559: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   562: aload_1
    //   563: athrow
    //   564: aload 8
    //   566: ifnull +8 -> 574
    //   569: aload 8
    //   571: invokevirtual 228	java/io/InputStream:close	()V
    //   574: aload 9
    //   576: invokevirtual 229	java/io/BufferedReader:close	()V
    //   579: aload 8
    //   581: astore 10
    //   583: goto -136 -> 447
    //   586: astore_2
    //   587: aload 8
    //   589: astore 10
    //   591: goto -144 -> 447
    //   594: astore_1
    //   595: goto -247 -> 348
    //   598: astore_1
    //   599: goto -246 -> 353
    //   602: astore 9
    //   604: goto -179 -> 425
    //   607: astore 9
    //   609: aload_2
    //   610: astore 9
    //   612: aload 8
    //   614: astore 10
    //   616: goto -169 -> 447
    //   619: astore 9
    //   621: goto -127 -> 494
    //   624: astore 8
    //   626: goto -77 -> 549
    //   629: astore_2
    //   630: goto -73 -> 557
    //   633: astore_2
    //   634: goto -60 -> 574
    //   637: astore_1
    //   638: goto -99 -> 539
    //   641: astore_1
    //   642: goto -103 -> 539
    //   645: astore 9
    //   647: goto -180 -> 467
    //   650: astore 9
    //   652: goto -185 -> 467
    //   655: astore 9
    //   657: goto -275 -> 382
    //   660: astore 9
    //   662: goto -280 -> 382
    //   665: aload_1
    //   666: astore 12
    //   668: goto -594 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	671	0	this	ConfigStorage
    //   0	671	1	paramString	String
    //   0	671	2	paramContext	Context
    //   31	60	3	i	int
    //   75	377	4	j	int
    //   133	148	5	l	long
    //   331	3	7	bool	boolean
    //   13	600	8	localObject1	Object
    //   624	1	8	localIOException1	java.io.IOException
    //   150	361	9	localObject2	Object
    //   519	1	9	localIOException2	java.io.IOException
    //   522	53	9	localContext1	Context
    //   602	1	9	localIOException3	java.io.IOException
    //   607	1	9	localIOException4	java.io.IOException
    //   610	1	9	localContext2	Context
    //   619	1	9	localIOException5	java.io.IOException
    //   645	1	9	localThrowable1	Throwable
    //   650	1	9	localThrowable2	Throwable
    //   655	1	9	localIOException6	java.io.IOException
    //   660	1	9	localIOException7	java.io.IOException
    //   230	385	10	localObject3	Object
    //   226	307	11	localObject4	Object
    //   55	612	12	str	String
    //   10	167	13	localSSLContext	javax.net.ssl.SSLContext
    //   202	167	14	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   232	238	378	java/io/IOException
    //   250	256	378	java/io/IOException
    //   264	301	378	java/io/IOException
    //   309	316	378	java/io/IOException
    //   324	333	378	java/io/IOException
    //   368	375	378	java/io/IOException
    //   232	238	463	java/lang/Throwable
    //   250	256	463	java/lang/Throwable
    //   264	301	463	java/lang/Throwable
    //   309	316	463	java/lang/Throwable
    //   324	333	463	java/lang/Throwable
    //   368	375	463	java/lang/Throwable
    //   505	509	519	java/io/IOException
    //   232	238	531	finally
    //   250	256	531	finally
    //   264	301	531	finally
    //   309	316	531	finally
    //   324	333	531	finally
    //   368	375	531	finally
    //   389	415	531	finally
    //   474	484	531	finally
    //   574	579	586	java/io/IOException
    //   343	348	594	java/io/IOException
    //   348	353	598	java/io/IOException
    //   420	425	602	java/io/IOException
    //   436	440	607	java/io/IOException
    //   489	494	619	java/io/IOException
    //   544	549	624	java/io/IOException
    //   553	557	629	java/io/IOException
    //   569	574	633	java/io/IOException
    //   94	191	637	finally
    //   195	224	641	finally
    //   94	191	645	java/lang/Throwable
    //   195	224	650	java/lang/Throwable
    //   94	191	655	java/io/IOException
    //   195	224	660	java/io/IOException
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
    //   0: ldc_w 274
    //   3: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 276
    //   9: invokestatic 282	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   12: astore_3
    //   13: aload_1
    //   14: invokevirtual 286	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   17: ldc 40
    //   19: invokevirtual 292	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_2
    //   23: aload_2
    //   24: astore_1
    //   25: aload_3
    //   26: aload_2
    //   27: invokevirtual 296	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   30: astore 4
    //   32: aload_2
    //   33: astore_1
    //   34: invokestatic 301	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   37: invokestatic 304	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   40: astore_3
    //   41: aload_2
    //   42: astore_1
    //   43: aload_3
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 308	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   49: aload_2
    //   50: astore_1
    //   51: aload_3
    //   52: ldc_w 310
    //   55: aload 4
    //   57: invokevirtual 314	java/security/KeyStore:setCertificateEntry	(Ljava/lang/String;Ljava/security/cert/Certificate;)V
    //   60: aload_2
    //   61: astore_1
    //   62: invokestatic 319	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   65: invokestatic 322	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   68: astore 4
    //   70: aload_2
    //   71: astore_1
    //   72: aload 4
    //   74: aload_3
    //   75: invokevirtual 326	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   78: aload_2
    //   79: astore_1
    //   80: ldc_w 328
    //   83: invokestatic 331	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   86: astore_3
    //   87: aload_2
    //   88: astore_1
    //   89: aload_3
    //   90: aconst_null
    //   91: aload 4
    //   93: invokevirtual 335	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   96: aconst_null
    //   97: invokevirtual 338	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 228	java/io/InputStream:close	()V
    //   108: ldc_w 274
    //   111: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_3
    //   115: areturn
    //   116: astore_3
    //   117: aconst_null
    //   118: astore_2
    //   119: aload_2
    //   120: astore_1
    //   121: bipush 6
    //   123: getstatic 63	com/tencent/qqvideo/proxy/common/ConfigStorage:TAG	Ljava/lang/String;
    //   126: new 135	java/lang/StringBuilder
    //   129: dup
    //   130: ldc_w 340
    //   133: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   136: aload_3
    //   137: invokestatic 346	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   140: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 133	com/tencent/qqvideo/proxy/httpproxy/HttpproxyFacade:print	(ILjava/lang/String;Ljava/lang/String;)V
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 228	java/io/InputStream:close	()V
    //   157: ldc_w 274
    //   160: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aconst_null
    //   164: areturn
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_1
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 228	java/io/InputStream:close	()V
    //   176: ldc_w 274
    //   179: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_2
    //   183: athrow
    //   184: astore_1
    //   185: goto -77 -> 108
    //   188: astore_1
    //   189: goto -32 -> 157
    //   192: astore_1
    //   193: goto -17 -> 176
    //   196: astore_2
    //   197: goto -29 -> 168
    //   200: astore_3
    //   201: goto -82 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	ConfigStorage
    //   0	204	1	paramContext	Context
    //   22	132	2	localInputStream	java.io.InputStream
    //   165	18	2	localObject1	Object
    //   196	1	2	localObject2	Object
    //   12	103	3	localObject3	Object
    //   116	21	3	localThrowable1	Throwable
    //   200	1	3	localThrowable2	Throwable
    //   30	62	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   6	23	116	java/lang/Throwable
    //   6	23	165	finally
    //   104	108	184	java/io/IOException
    //   153	157	188	java/io/IOException
    //   172	176	192	java/io/IOException
    //   25	32	196	finally
    //   34	41	196	finally
    //   43	49	196	finally
    //   51	60	196	finally
    //   62	70	196	finally
    //   72	78	196	finally
    //   80	87	196	finally
    //   89	100	196	finally
    //   121	149	196	finally
    //   25	32	200	java/lang/Throwable
    //   34	41	200	java/lang/Throwable
    //   43	49	200	java/lang/Throwable
    //   51	60	200	java/lang/Throwable
    //   62	70	200	java/lang/Throwable
    //   72	78	200	java/lang/Throwable
    //   80	87	200	java/lang/Throwable
    //   89	100	200	java/lang/Throwable
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
    catch (Throwable paramContext)
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
        paramContext = paramContext;
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
    catch (Throwable localThrowable)
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
      if (this.thread == null)
      {
        HttpproxyFacade.print(6, TAG, "thread create failed");
        AppMethodBeat.o(89737);
        return;
      }
      this.thread.start();
      AppMethodBeat.o(89737);
      return;
    }
    catch (Throwable paramContext)
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