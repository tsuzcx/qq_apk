package com.tencent.smtt.sdk.c;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.m;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.r;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

public class b
{
  public static byte[] a;
  
  static
  {
    AppMethodBeat.i(192142);
    a = null;
    try
    {
      a = "65dRa93L".getBytes("utf-8");
      AppMethodBeat.o(192142);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      AppMethodBeat.o(192142);
    }
  }
  
  static File a(Context paramContext)
  {
    AppMethodBeat.i(192118);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_private");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(192118);
      return null;
    }
    AppMethodBeat.o(192118);
    return paramContext;
  }
  
  public static void a(final ThirdAppInfoNew paramThirdAppInfoNew, final Context paramContext)
  {
    AppMethodBeat.i(192043);
    new Thread("HttpUtils")
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 37
        //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 16	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   9: aload_0
        //   10: getfield 18	com/tencent/smtt/sdk/c/b$1:b	LMTT/ThirdAppInfoNew;
        //   13: getfield 49	MTT/ThirdAppInfoNew:sGuid	Ljava/lang/String;
        //   16: invokestatic 54	com/tencent/smtt/utils/b:b	(Landroid/content/Context;Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 18	com/tencent/smtt/sdk/c/b$1:b	LMTT/ThirdAppInfoNew;
        //   23: invokestatic 57	com/tencent/smtt/utils/b:b	()Ljava/lang/String;
        //   26: putfield 60	MTT/ThirdAppInfoNew:sCpu	Ljava/lang/String;
        //   29: getstatic 66	android/os/Build$VERSION:SDK_INT	I
        //   32: bipush 8
        //   34: if_icmpge +9 -> 43
        //   37: ldc 37
        //   39: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   42: return
        //   43: getstatic 72	com/tencent/smtt/sdk/c/b:a	[B
        //   46: ifnonnull +13 -> 59
        //   49: ldc 74
        //   51: ldc 76
        //   53: invokevirtual 82	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   56: putstatic 72	com/tencent/smtt/sdk/c/b:a	[B
        //   59: getstatic 72	com/tencent/smtt/sdk/c/b:a	[B
        //   62: ifnonnull +31 -> 93
        //   65: ldc 84
        //   67: ldc 86
        //   69: invokestatic 92	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   72: ldc 37
        //   74: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   77: return
        //   78: astore_2
        //   79: aconst_null
        //   80: putstatic 72	com/tencent/smtt/sdk/c/b:a	[B
        //   83: ldc 84
        //   85: ldc 94
        //   87: invokestatic 92	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   90: goto -31 -> 59
        //   93: aload_0
        //   94: getfield 16	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   97: invokestatic 100	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
        //   100: getfield 104	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
        //   103: ldc 106
        //   105: ldc 108
        //   107: invokeinterface 114 3 0
        //   112: astore_2
        //   113: ldc 108
        //   115: astore_3
        //   116: aload_2
        //   117: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   120: ifne +615 -> 735
        //   123: aload_2
        //   124: iconst_0
        //   125: aload_2
        //   126: ldc 122
        //   128: invokevirtual 126	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   131: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
        //   134: astore_3
        //   135: aload_2
        //   136: aload_2
        //   137: ldc 122
        //   139: invokevirtual 126	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   142: iconst_1
        //   143: iadd
        //   144: aload_2
        //   145: invokevirtual 134	java/lang/String:length	()I
        //   148: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
        //   151: astore_2
        //   152: aload_3
        //   153: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   156: ifne +28 -> 184
        //   159: aload_3
        //   160: invokevirtual 134	java/lang/String:length	()I
        //   163: bipush 96
        //   165: if_icmpne +19 -> 184
        //   168: aload_2
        //   169: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   172: ifne +12 -> 184
        //   175: aload_2
        //   176: invokevirtual 134	java/lang/String:length	()I
        //   179: bipush 24
        //   181: if_icmpeq +137 -> 318
        //   184: iconst_1
        //   185: istore_1
        //   186: invokestatic 139	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
        //   189: astore 4
        //   191: iload_1
        //   192: ifeq +131 -> 323
        //   195: new 141	java/lang/StringBuilder
        //   198: dup
        //   199: invokespecial 143	java/lang/StringBuilder:<init>	()V
        //   202: aload 4
        //   204: invokevirtual 144	com/tencent/smtt/utils/o:b	()Ljava/lang/String;
        //   207: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   210: invokestatic 153	com/tencent/smtt/utils/h:a	()Lcom/tencent/smtt/utils/h;
        //   213: invokevirtual 154	com/tencent/smtt/utils/h:b	()Ljava/lang/String;
        //   216: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   219: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   222: astore_3
        //   223: new 159	java/net/URL
        //   226: dup
        //   227: aload_3
        //   228: invokespecial 160	java/net/URL:<init>	(Ljava/lang/String;)V
        //   231: invokevirtual 164	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   234: checkcast 166	java/net/HttpURLConnection
        //   237: astore 5
        //   239: aload 5
        //   241: ldc 168
        //   243: invokevirtual 171	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   246: aload 5
        //   248: iconst_1
        //   249: invokevirtual 175	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   252: aload 5
        //   254: iconst_1
        //   255: invokevirtual 178	java/net/HttpURLConnection:setDoInput	(Z)V
        //   258: aload 5
        //   260: iconst_0
        //   261: invokevirtual 181	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   264: aload 5
        //   266: sipush 20000
        //   269: invokevirtual 184	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   272: getstatic 66	android/os/Build$VERSION:SDK_INT	I
        //   275: bipush 13
        //   277: if_icmple +12 -> 289
        //   280: aload 5
        //   282: ldc 186
        //   284: ldc 188
        //   286: invokevirtual 191	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   289: aload_0
        //   290: getfield 18	com/tencent/smtt/sdk/c/b$1:b	LMTT/ThirdAppInfoNew;
        //   293: aload_0
        //   294: getfield 16	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   297: invokestatic 194	com/tencent/smtt/sdk/c/b:b	(LMTT/ThirdAppInfoNew;Landroid/content/Context;)Lorg/json/JSONObject;
        //   300: astore_3
        //   301: aload_3
        //   302: ifnonnull +116 -> 418
        //   305: ldc 84
        //   307: ldc 196
        //   309: invokestatic 92	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   312: ldc 37
        //   314: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   317: return
        //   318: iconst_0
        //   319: istore_1
        //   320: goto -134 -> 186
        //   323: new 141	java/lang/StringBuilder
        //   326: dup
        //   327: invokespecial 143	java/lang/StringBuilder:<init>	()V
        //   330: aload 4
        //   332: invokevirtual 199	com/tencent/smtt/utils/o:f	()Ljava/lang/String;
        //   335: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   338: aload_3
        //   339: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   342: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   345: astore_3
        //   346: goto -123 -> 223
        //   349: astore_2
        //   350: ldc 84
        //   352: ldc 201
        //   354: aload_2
        //   355: invokestatic 205	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   358: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   361: invokestatic 92	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   364: ldc 37
        //   366: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   369: return
        //   370: astore_2
        //   371: ldc 84
        //   373: ldc 211
        //   375: aload_2
        //   376: invokestatic 205	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   379: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   382: invokestatic 92	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   385: ldc 37
        //   387: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   390: return
        //   391: astore_2
        //   392: ldc 84
        //   394: ldc 213
        //   396: aload_2
        //   397: invokestatic 205	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   400: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   403: invokestatic 92	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   406: ldc 37
        //   408: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   411: return
        //   412: astore_3
        //   413: aconst_null
        //   414: astore_3
        //   415: goto -114 -> 301
        //   418: aload_3
        //   419: invokevirtual 216	org/json/JSONObject:toString	()Ljava/lang/String;
        //   422: ldc 76
        //   424: invokevirtual 82	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   427: astore 4
        //   429: iload_1
        //   430: ifeq +134 -> 564
        //   433: invokestatic 153	com/tencent/smtt/utils/h:a	()Lcom/tencent/smtt/utils/h;
        //   436: aload 4
        //   438: invokevirtual 219	com/tencent/smtt/utils/h:a	([B)[B
        //   441: astore 4
        //   443: aload 5
        //   445: ldc 221
        //   447: ldc 223
        //   449: invokevirtual 191	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   452: aload 5
        //   454: ldc 225
        //   456: aload 4
        //   458: arraylength
        //   459: invokestatic 228	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   462: invokevirtual 191	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   465: aload 5
        //   467: invokevirtual 232	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   470: astore 6
        //   472: aload 6
        //   474: aload 4
        //   476: invokevirtual 238	java/io/OutputStream:write	([B)V
        //   479: aload 6
        //   481: invokevirtual 241	java/io/OutputStream:flush	()V
        //   484: aload 5
        //   486: invokevirtual 244	java/net/HttpURLConnection:getResponseCode	()I
        //   489: sipush 200
        //   492: if_icmpne +90 -> 582
        //   495: ldc 84
        //   497: ldc 246
        //   499: invokestatic 248	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   502: ldc 84
        //   504: new 141	java/lang/StringBuilder
        //   507: dup
        //   508: ldc 250
        //   510: invokespecial 251	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   513: aload_3
        //   514: ldc 253
        //   516: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   519: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   522: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   525: invokestatic 248	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   528: aload 5
        //   530: aload_2
        //   531: iload_1
        //   532: invokestatic 258	com/tencent/smtt/sdk/c/b:a	(Ljava/net/HttpURLConnection;Ljava/lang/String;Z)Ljava/lang/String;
        //   535: astore_2
        //   536: aload_0
        //   537: getfield 16	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   540: aload_2
        //   541: invokestatic 260	com/tencent/smtt/sdk/c/b:a	(Landroid/content/Context;Ljava/lang/String;)V
        //   544: new 262	com/tencent/smtt/sdk/TbsDownloadUpload
        //   547: dup
        //   548: aload_0
        //   549: getfield 16	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   552: invokespecial 265	com/tencent/smtt/sdk/TbsDownloadUpload:<init>	(Landroid/content/Context;)V
        //   555: invokevirtual 268	com/tencent/smtt/sdk/TbsDownloadUpload:clearUploadCode	()V
        //   558: ldc 37
        //   560: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   563: return
        //   564: aload 4
        //   566: aload_2
        //   567: invokestatic 271	com/tencent/smtt/utils/h:a	([BLjava/lang/String;)[B
        //   570: astore 4
        //   572: goto -129 -> 443
        //   575: astore_2
        //   576: ldc 37
        //   578: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   581: return
        //   582: ldc 84
        //   584: new 141	java/lang/StringBuilder
        //   587: dup
        //   588: ldc_w 273
        //   591: invokespecial 251	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   594: aload 5
        //   596: invokevirtual 244	java/net/HttpURLConnection:getResponseCode	()I
        //   599: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   602: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   605: invokestatic 92	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   608: aload_0
        //   609: getfield 16	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   612: invokestatic 281	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
        //   615: invokevirtual 285	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
        //   618: astore_2
        //   619: aload_2
        //   620: bipush 126
        //   622: invokevirtual 290	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
        //   625: aload_2
        //   626: new 141	java/lang/StringBuilder
        //   629: dup
        //   630: invokespecial 143	java/lang/StringBuilder:<init>	()V
        //   633: aload 5
        //   635: invokevirtual 244	java/net/HttpURLConnection:getResponseCode	()I
        //   638: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   641: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   644: invokevirtual 293	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
        //   647: aload_0
        //   648: getfield 16	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   651: invokestatic 281	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
        //   654: getstatic 299	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
        //   657: aload_2
        //   658: invokevirtual 303	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
        //   661: ldc 37
        //   663: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   666: return
        //   667: astore_2
        //   668: ldc 84
        //   670: new 141	java/lang/StringBuilder
        //   673: dup
        //   674: ldc_w 305
        //   677: invokespecial 251	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   680: aload_2
        //   681: invokevirtual 308	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   684: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   687: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   690: invokestatic 92	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   693: aload_0
        //   694: getfield 16	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   697: invokestatic 281	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
        //   700: invokevirtual 285	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
        //   703: astore_3
        //   704: aload_3
        //   705: bipush 126
        //   707: invokevirtual 290	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
        //   710: aload_3
        //   711: aload_2
        //   712: invokevirtual 311	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/Throwable;)V
        //   715: aload_0
        //   716: getfield 16	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   719: invokestatic 281	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
        //   722: getstatic 299	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
        //   725: aload_3
        //   726: invokevirtual 303	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
        //   729: ldc 37
        //   731: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   734: return
        //   735: ldc 108
        //   737: astore_2
        //   738: goto -586 -> 152
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	741	0	this	1
        //   185	347	1	bool	boolean
        //   78	1	2	localUnsupportedEncodingException	UnsupportedEncodingException
        //   112	64	2	str1	String
        //   349	6	2	localIOException	java.io.IOException
        //   370	6	2	localAssertionError	java.lang.AssertionError
        //   391	140	2	localNoClassDefFoundError	java.lang.NoClassDefFoundError
        //   535	32	2	str2	String
        //   575	1	2	localThrowable1	Throwable
        //   618	40	2	localTbsLogInfo1	com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo
        //   667	45	2	localThrowable2	Throwable
        //   737	1	2	str3	String
        //   115	231	3	localObject1	Object
        //   412	1	3	localException	Exception
        //   414	312	3	localTbsLogInfo2	com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo
        //   189	382	4	localObject2	Object
        //   237	397	5	localHttpURLConnection	java.net.HttpURLConnection
        //   470	10	6	localOutputStream	java.io.OutputStream
        // Exception table:
        //   from	to	target	type
        //   49	59	78	java/io/UnsupportedEncodingException
        //   186	191	349	java/io/IOException
        //   195	223	349	java/io/IOException
        //   223	246	349	java/io/IOException
        //   323	346	349	java/io/IOException
        //   186	191	370	java/lang/AssertionError
        //   195	223	370	java/lang/AssertionError
        //   223	246	370	java/lang/AssertionError
        //   323	346	370	java/lang/AssertionError
        //   186	191	391	java/lang/NoClassDefFoundError
        //   195	223	391	java/lang/NoClassDefFoundError
        //   223	246	391	java/lang/NoClassDefFoundError
        //   323	346	391	java/lang/NoClassDefFoundError
        //   289	301	412	java/lang/Exception
        //   418	429	575	java/lang/Throwable
        //   433	443	575	java/lang/Throwable
        //   564	572	575	java/lang/Throwable
        //   465	558	667	java/lang/Throwable
        //   582	661	667	java/lang/Throwable
      }
    }.start();
    AppMethodBeat.o(192043);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(192128);
    if (("reset".equals(paramString1)) && ("true".equals(paramString2)))
    {
      QbSdk.reset(paramContext);
      AppMethodBeat.o(192128);
      return;
    }
    if ("clear_sdk_timestamp".equals(paramString1))
    {
      paramString1 = paramContext.getSharedPreferences("sdk_status", 0);
      if (!paramString1.contains(paramString2))
      {
        TbsDownloadConfig.getInstance(paramContext).mSyncMap.put("last_check", Long.valueOf(0L));
        TbsDownloadConfig.getInstance(paramContext).commit();
        paramString1.edit().putString("sdk_status", paramString2).apply();
      }
      AppMethodBeat.o(192128);
      return;
    }
    if ("clear_extension_timestamp".equals(paramString1))
    {
      paramString1 = paramContext.getSharedPreferences("extension_status", 0);
      if (!paramString1.contains(paramString2))
      {
        f.b(new File(a(paramContext), "tbs_extension.conf"));
        paramString1.edit().putString("extension_status", paramString2).apply();
      }
      AppMethodBeat.o(192128);
      return;
    }
    if ("clear_switch_file".equals(paramString1))
    {
      paramContext = a(paramContext);
      if ((paramContext != null) && (paramContext.exists()))
      {
        paramContext = new File(paramContext, "tbs_switch_disable_".concat(String.valueOf(paramString2)));
        if (paramContext.exists()) {
          f.b(paramContext);
        }
      }
      AppMethodBeat.o(192128);
      return;
    }
    TbsPVConfig.getInstance(paramContext).putData(paramString1, paramString2);
    AppMethodBeat.o(192128);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(192094);
    if ((QbSdk.getSettings() != null) && (QbSdk.getSettings().containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) && (QbSdk.getSettings().get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")))
    {
      TbsLog.i("sdkreport", "[HttpUtils.doReport] -- SET_SENDREQUEST_AND_UPLOAD is false");
      AppMethodBeat.o(192094);
      return;
    }
    TbsLog.d("sdkreport", "HttpUtils.doReport(): pv = ".concat(String.valueOf(paramInt)));
    Object localObject3 = "";
    Object localObject1 = localObject3;
    for (;;)
    {
      try
      {
        ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
        localObject1 = localObject3;
        TbsLog.d("sdkreport", "HttpUtils.doReport()--appInfo.packageName = " + localApplicationInfo.packageName);
        Object localObject2 = localObject3;
        localObject1 = localObject3;
        if ("com.tencent.mobileqq".equals(localApplicationInfo.packageName))
        {
          localObject1 = localObject3;
          localObject3 = paramContext.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0).versionName;
          localObject1 = localObject3;
          TbsLog.d("sdkreport", "HttpUtils.doReport()--appVersionName = ".concat(String.valueOf(localObject3)));
          localObject2 = localObject3;
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber()))
          {
            localObject1 = localObject3;
            localObject2 = (String)localObject3 + "." + QbSdk.getQQBuildNumber();
          }
          localObject1 = localObject2;
          TbsLog.d("sdkreport", "HttpUtils.doReport()--appVersionName with build number = ".concat(String.valueOf(localObject2)));
        }
        localObject1 = localObject2;
        continue;
      }
      catch (Exception localException)
      {
        try
        {
          localObject2 = new ThirdAppInfoNew();
          ((ThirdAppInfoNew)localObject2).sAppName = paramContext.getApplicationContext().getApplicationInfo().packageName;
          o.a(paramContext);
          localObject3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
          ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+08"));
          ((ThirdAppInfoNew)localObject2).sTime = ((SimpleDateFormat)localObject3).format(Calendar.getInstance().getTime());
          ((ThirdAppInfoNew)localObject2).sVersionCode = com.tencent.smtt.utils.b.d(paramContext);
          localObject3 = com.tencent.smtt.utils.b.a(paramContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((ThirdAppInfoNew)localObject2).sMetaData = ((String)localObject3);
          }
          ((ThirdAppInfoNew)localObject2).sGuid = paramString1;
          if (paramBoolean1)
          {
            ((ThirdAppInfoNew)localObject2).sQua2 = paramString2;
            ((ThirdAppInfoNew)localObject2).bIsSandboxMode = paramBoolean2;
            ((ThirdAppInfoNew)localObject2).sLc = paramString3;
            paramString1 = com.tencent.smtt.utils.b.i(paramContext);
            paramString2 = com.tencent.smtt.utils.b.g(paramContext);
            TbsLog.i("sdkreport", "HttpUtils.doReport():  imei is ".concat(String.valueOf(paramString2)));
            paramString3 = com.tencent.smtt.utils.b.h(paramContext);
            localObject3 = com.tencent.smtt.utils.b.j(paramContext);
            if ((paramString2 != null) && (!"".equals(paramString2))) {
              ((ThirdAppInfoNew)localObject2).sImei = paramString2;
            }
            if ((paramString3 != null) && (!"".equals(paramString3))) {
              ((ThirdAppInfoNew)localObject2).sImsi = paramString3;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              ((ThirdAppInfoNew)localObject2).sAndroidID = ((String)localObject3);
            }
            if ((paramString1 != null) && (!"".equals(paramString1))) {
              ((ThirdAppInfoNew)localObject2).sMac = paramString1;
            }
            ((ThirdAppInfoNew)localObject2).iPv = paramInt;
            if (!TbsShareManager.isThirdPartyApp(paramContext)) {
              break;
            }
            if (!paramBoolean1) {
              break label619;
            }
            if (TbsShareManager.getCoreFormOwn())
            {
              ((ThirdAppInfoNew)localObject2).iCoreType = 2;
              if (paramBoolean2) {
                ((ThirdAppInfoNew)localObject2).iCoreType = 3;
              }
              ((ThirdAppInfoNew)localObject2).sAppVersionName = localObject1;
              ((ThirdAppInfoNew)localObject2).sAppSignature = c(paramContext);
              if (!paramBoolean1)
              {
                ((ThirdAppInfoNew)localObject2).sWifiConnectedTime = paramLong;
                ((ThirdAppInfoNew)localObject2).localCoreVersion = QbSdk.getTbsVersion(paramContext);
              }
              a((ThirdAppInfoNew)localObject2, paramContext.getApplicationContext());
              AppMethodBeat.o(192094);
              return;
              localException = localException;
            }
          }
          else
          {
            localException.sQua2 = m.a(paramContext);
            continue;
          }
          localException.iCoreType = 1;
        }
        catch (Throwable paramContext)
        {
          AppMethodBeat.o(192094);
          return;
        }
      }
      label619:
      localException.iCoreType = 0;
    }
    for (;;)
    {
      localException.iCoreType = paramInt;
      if ((!paramBoolean1) || (!paramBoolean2)) {
        break;
      }
      localException.iCoreType = 3;
      break;
      do
      {
        paramInt = 0;
        break;
      } while (!paramBoolean1);
      paramInt = 1;
    }
  }
  
  private static String b(Context paramContext)
  {
    AppMethodBeat.i(192048);
    try
    {
      localJSONObject2 = new JSONObject();
      localJSONObject1 = localJSONObject2;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        label53:
        localJSONObject1 = null;
      }
    }
    try
    {
      if (r.b(paramContext))
      {
        localJSONObject2.put("stableCore32", TbsShareManager.getTbsStableCoreVersion(paramContext, 32));
        localJSONObject2.put("stableCore64", TbsShareManager.getTbsStableCoreVersion(paramContext, 64));
        localJSONObject1 = localJSONObject2;
      }
    }
    catch (Throwable paramContext)
    {
      localJSONObject1 = localJSONObject2;
      break label53;
    }
    if (localJSONObject1 == null)
    {
      AppMethodBeat.o(192048);
      return "";
    }
    paramContext = localJSONObject1.toString();
    AppMethodBeat.o(192048);
    return paramContext;
  }
  
  /* Error */
  private static String b(java.net.HttpURLConnection paramHttpURLConnection, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 448
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 223
    //   8: astore 5
    //   10: aload_0
    //   11: invokevirtual 454	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   14: astore 4
    //   16: aload_0
    //   17: invokevirtual 457	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull +133 -> 155
    //   25: aload_0
    //   26: ldc_w 459
    //   29: invokevirtual 462	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   32: ifeq +123 -> 155
    //   35: new 464	java/util/zip/GZIPInputStream
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 467	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore_0
    //   45: new 469	java/io/ByteArrayOutputStream
    //   48: dup
    //   49: invokespecial 470	java/io/ByteArrayOutputStream:<init>	()V
    //   52: astore 4
    //   54: sipush 128
    //   57: newarray byte
    //   59: astore 6
    //   61: aload_0
    //   62: aload 6
    //   64: invokevirtual 476	java/io/InputStream:read	([B)I
    //   67: istore_3
    //   68: iload_3
    //   69: iconst_m1
    //   70: if_icmpeq +134 -> 204
    //   73: aload 4
    //   75: aload 6
    //   77: iconst_0
    //   78: iload_3
    //   79: invokevirtual 480	java/io/ByteArrayOutputStream:write	([BII)V
    //   82: goto -21 -> 61
    //   85: astore_1
    //   86: aload 4
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +7 -> 97
    //   93: aload_1
    //   94: invokevirtual 483	java/io/ByteArrayOutputStream:close	()V
    //   97: aload 5
    //   99: astore 4
    //   101: aload_0
    //   102: ifnull +11 -> 113
    //   105: aload_0
    //   106: invokevirtual 484	java/io/InputStream:close	()V
    //   109: aload 5
    //   111: astore 4
    //   113: ldc 66
    //   115: new 229	java/lang/StringBuilder
    //   118: dup
    //   119: ldc_w 486
    //   122: invokespecial 234	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload 4
    //   127: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc_w 488
    //   133: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload_2
    //   137: invokevirtual 491	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   140: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 213	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: ldc_w 448
    //   149: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload 4
    //   154: areturn
    //   155: aload_0
    //   156: ifnull +42 -> 198
    //   159: aload_0
    //   160: ldc_w 493
    //   163: invokevirtual 462	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   166: ifeq +32 -> 198
    //   169: new 495	java/util/zip/InflaterInputStream
    //   172: dup
    //   173: aload 4
    //   175: new 497	java/util/zip/Inflater
    //   178: dup
    //   179: iconst_1
    //   180: invokespecial 500	java/util/zip/Inflater:<init>	(Z)V
    //   183: invokespecial 503	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   186: astore_0
    //   187: goto -142 -> 45
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_1
    //   193: aconst_null
    //   194: astore_0
    //   195: goto -106 -> 89
    //   198: aload 4
    //   200: astore_0
    //   201: goto -156 -> 45
    //   204: iload_2
    //   205: ifeq +51 -> 256
    //   208: new 27	java/lang/String
    //   211: dup
    //   212: invokestatic 508	com/tencent/smtt/utils/h:a	()Lcom/tencent/smtt/utils/h;
    //   215: aload 4
    //   217: invokevirtual 512	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   220: invokevirtual 515	com/tencent/smtt/utils/h:c	([B)[B
    //   223: invokespecial 518	java/lang/String:<init>	([B)V
    //   226: astore_1
    //   227: aload 4
    //   229: invokevirtual 483	java/io/ByteArrayOutputStream:close	()V
    //   232: aload_1
    //   233: astore 4
    //   235: aload_0
    //   236: ifnull -123 -> 113
    //   239: aload_0
    //   240: invokevirtual 484	java/io/InputStream:close	()V
    //   243: aload_1
    //   244: astore 4
    //   246: goto -133 -> 113
    //   249: astore_0
    //   250: aload_1
    //   251: astore 4
    //   253: goto -140 -> 113
    //   256: new 27	java/lang/String
    //   259: dup
    //   260: aload 4
    //   262: invokevirtual 512	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   265: aload_1
    //   266: invokestatic 521	com/tencent/smtt/utils/h:b	([BLjava/lang/String;)[B
    //   269: invokespecial 518	java/lang/String:<init>	([B)V
    //   272: astore_1
    //   273: goto -46 -> 227
    //   276: astore_1
    //   277: aconst_null
    //   278: astore 4
    //   280: aconst_null
    //   281: astore_0
    //   282: aload 4
    //   284: ifnull +8 -> 292
    //   287: aload 4
    //   289: invokevirtual 483	java/io/ByteArrayOutputStream:close	()V
    //   292: aload_0
    //   293: ifnull +7 -> 300
    //   296: aload_0
    //   297: invokevirtual 484	java/io/InputStream:close	()V
    //   300: ldc_w 448
    //   303: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload_1
    //   307: athrow
    //   308: astore 4
    //   310: goto -78 -> 232
    //   313: astore_1
    //   314: goto -217 -> 97
    //   317: astore_0
    //   318: aload 5
    //   320: astore 4
    //   322: goto -209 -> 113
    //   325: astore 4
    //   327: goto -35 -> 292
    //   330: astore_0
    //   331: goto -31 -> 300
    //   334: astore_1
    //   335: aconst_null
    //   336: astore 4
    //   338: goto -56 -> 282
    //   341: astore_1
    //   342: goto -60 -> 282
    //   345: astore_1
    //   346: aconst_null
    //   347: astore_1
    //   348: goto -259 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramHttpURLConnection	java.net.HttpURLConnection
    //   0	351	1	paramString	String
    //   0	351	2	paramBoolean	boolean
    //   67	12	3	i	int
    //   14	274	4	localObject1	Object
    //   308	1	4	localIOException1	java.io.IOException
    //   320	1	4	str1	String
    //   325	1	4	localIOException2	java.io.IOException
    //   336	1	4	localObject2	Object
    //   8	311	5	str2	String
    //   59	17	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   54	61	85	java/lang/Exception
    //   61	68	85	java/lang/Exception
    //   73	82	85	java/lang/Exception
    //   208	227	85	java/lang/Exception
    //   256	273	85	java/lang/Exception
    //   10	21	190	java/lang/Exception
    //   25	45	190	java/lang/Exception
    //   159	187	190	java/lang/Exception
    //   239	243	249	java/io/IOException
    //   10	21	276	finally
    //   25	45	276	finally
    //   159	187	276	finally
    //   227	232	308	java/io/IOException
    //   93	97	313	java/io/IOException
    //   105	109	317	java/io/IOException
    //   287	292	325	java/io/IOException
    //   296	300	330	java/io/IOException
    //   45	54	334	finally
    //   54	61	341	finally
    //   61	68	341	finally
    //   73	82	341	finally
    //   208	227	341	finally
    //   256	273	341	finally
    //   45	54	345	java/lang/Exception
  }
  
  /* Error */
  private static void b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc_w 526
    //   5: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 529	com/tencent/smtt/sdk/TbsPVConfig:releaseInstance	()V
    //   11: aload_0
    //   12: invokestatic 177	com/tencent/smtt/sdk/TbsPVConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsPVConfig;
    //   15: invokevirtual 532	com/tencent/smtt/sdk/TbsPVConfig:clear	()V
    //   18: aload_1
    //   19: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: istore 4
    //   24: iload 4
    //   26: ifeq +10 -> 36
    //   29: ldc_w 526
    //   32: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: return
    //   36: aload_1
    //   37: ldc_w 534
    //   40: invokevirtual 538	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   43: astore_1
    //   44: aload_1
    //   45: arraylength
    //   46: istore_3
    //   47: iload_2
    //   48: iload_3
    //   49: if_icmpge +44 -> 93
    //   52: aload_1
    //   53: iload_2
    //   54: aaload
    //   55: astore 5
    //   57: aload 5
    //   59: ldc_w 540
    //   62: invokevirtual 538	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   65: astore 5
    //   67: aload 5
    //   69: arraylength
    //   70: iconst_2
    //   71: if_icmpne +15 -> 86
    //   74: aload_0
    //   75: aload 5
    //   77: iconst_0
    //   78: aaload
    //   79: aload 5
    //   81: iconst_1
    //   82: aaload
    //   83: invokestatic 542	com/tencent/smtt/sdk/c/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   86: iload_2
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: goto -43 -> 47
    //   93: aload_0
    //   94: invokestatic 177	com/tencent/smtt/sdk/TbsPVConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsPVConfig;
    //   97: invokevirtual 543	com/tencent/smtt/sdk/TbsPVConfig:commit	()V
    //   100: aload_0
    //   101: invokestatic 177	com/tencent/smtt/sdk/TbsPVConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsPVConfig;
    //   104: aload_0
    //   105: invokevirtual 546	com/tencent/smtt/sdk/TbsPVConfig:refreshSyncMap	(Landroid/content/Context;)V
    //   108: ldc_w 526
    //   111: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: astore_0
    //   116: ldc_w 526
    //   119: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: return
    //   123: astore 5
    //   125: goto -39 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramContext	Context
    //   0	128	1	paramString	String
    //   1	89	2	i	int
    //   46	4	3	j	int
    //   22	3	4	bool	boolean
    //   55	25	5	arrayOfString	String[]
    //   123	1	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   8	24	115	java/lang/Exception
    //   36	47	115	java/lang/Exception
    //   93	108	115	java/lang/Exception
    //   57	86	123	java/lang/Exception
  }
  
  private static String c(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(192102);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray();
      if (paramContext != null)
      {
        Object localObject = MessageDigest.getInstance("SHA-1");
        ((MessageDigest)localObject).update(paramContext);
        paramContext = ((MessageDigest)localObject).digest();
        if (paramContext != null)
        {
          localObject = new StringBuilder("");
          if (paramContext != null)
          {
            int j = paramContext.length;
            if (j > 0) {}
          }
          else
          {
            AppMethodBeat.o(192102);
            return null;
          }
          while (i < paramContext.length)
          {
            String str = Integer.toHexString(paramContext[i] & 0xFF).toUpperCase();
            if (i > 0) {
              ((StringBuilder)localObject).append(":");
            }
            if (str.length() < 2) {
              ((StringBuilder)localObject).append(0);
            }
            ((StringBuilder)localObject).append(str);
            i += 1;
          }
          paramContext = ((StringBuilder)localObject).toString();
          AppMethodBeat.o(192102);
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(192102);
    }
    return null;
  }
  
  /* Error */
  private static JSONObject c(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 588
    //   5: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 428	org/json/JSONObject
    //   11: dup
    //   12: invokespecial 429	org/json/JSONObject:<init>	()V
    //   15: astore 7
    //   17: aload 7
    //   19: ldc_w 590
    //   22: aload_0
    //   23: getfield 291	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   26: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload 7
    //   32: ldc_w 595
    //   35: aload_0
    //   36: getfield 329	MTT/ThirdAppInfoNew:sTime	Ljava/lang/String;
    //   39: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   42: pop
    //   43: aload 7
    //   45: ldc_w 597
    //   48: aload_0
    //   49: getfield 352	MTT/ThirdAppInfoNew:sQua2	Ljava/lang/String;
    //   52: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   55: pop
    //   56: aload 7
    //   58: ldc_w 599
    //   61: aload_0
    //   62: getfield 359	MTT/ThirdAppInfoNew:sLc	Ljava/lang/String;
    //   65: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   68: pop
    //   69: aload 7
    //   71: ldc_w 601
    //   74: aload_0
    //   75: getfield 349	MTT/ThirdAppInfoNew:sGuid	Ljava/lang/String;
    //   78: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   81: pop
    //   82: aload 7
    //   84: ldc_w 603
    //   87: aload_0
    //   88: getfield 376	MTT/ThirdAppInfoNew:sImei	Ljava/lang/String;
    //   91: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   94: pop
    //   95: aload 7
    //   97: ldc_w 605
    //   100: aload_0
    //   101: getfield 379	MTT/ThirdAppInfoNew:sImsi	Ljava/lang/String;
    //   104: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   107: pop
    //   108: aload 7
    //   110: ldc_w 607
    //   113: aload_0
    //   114: getfield 385	MTT/ThirdAppInfoNew:sMac	Ljava/lang/String;
    //   117: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   120: pop
    //   121: aload 7
    //   123: ldc_w 609
    //   126: aload_0
    //   127: getfield 389	MTT/ThirdAppInfoNew:iPv	J
    //   130: invokevirtual 612	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   133: pop
    //   134: aload 7
    //   136: ldc_w 614
    //   139: aload_0
    //   140: getfield 401	MTT/ThirdAppInfoNew:iCoreType	I
    //   143: invokevirtual 442	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   146: pop
    //   147: aload 7
    //   149: ldc_w 616
    //   152: aload_0
    //   153: getfield 404	MTT/ThirdAppInfoNew:sAppVersionName	Ljava/lang/String;
    //   156: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   159: pop
    //   160: aload 7
    //   162: ldc_w 618
    //   165: aload_0
    //   166: getfield 346	MTT/ThirdAppInfoNew:sMetaData	Ljava/lang/String;
    //   169: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   172: pop
    //   173: aload 7
    //   175: ldc_w 620
    //   178: aload_0
    //   179: getfield 338	MTT/ThirdAppInfoNew:sVersionCode	I
    //   182: invokevirtual 442	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   185: pop
    //   186: aload 7
    //   188: ldc_w 622
    //   191: aload_0
    //   192: getfield 625	MTT/ThirdAppInfoNew:sCpu	Ljava/lang/String;
    //   195: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   198: pop
    //   199: ldc_w 627
    //   202: aload_0
    //   203: getfield 291	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   206: invokevirtual 84	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   209: ifne +28 -> 237
    //   212: ldc 249
    //   214: aload_0
    //   215: getfield 291	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   218: invokevirtual 84	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   221: ifne +16 -> 237
    //   224: ldc_w 629
    //   227: aload_0
    //   228: getfield 291	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   231: invokevirtual 84	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   234: ifeq +357 -> 591
    //   237: new 631	com/tencent/smtt/sdk/TbsDownloadUpload
    //   240: dup
    //   241: aload_1
    //   242: invokespecial 633	com/tencent/smtt/sdk/TbsDownloadUpload:<init>	(Landroid/content/Context;)V
    //   245: astore 8
    //   247: aload 8
    //   249: aload_1
    //   250: invokevirtual 636	com/tencent/smtt/sdk/TbsDownloadUpload:readTbsDownloadInfo	(Landroid/content/Context;)V
    //   253: aload 8
    //   255: invokevirtual 639	com/tencent/smtt/sdk/TbsDownloadUpload:getNeedDownloadCode	()I
    //   258: istore_3
    //   259: aload 8
    //   261: invokevirtual 642	com/tencent/smtt/sdk/TbsDownloadUpload:getStartDownloadCode	()I
    //   264: istore 4
    //   266: aload 8
    //   268: invokevirtual 645	com/tencent/smtt/sdk/TbsDownloadUpload:getNeedDownloadReturn	()I
    //   271: istore 5
    //   273: aload 8
    //   275: invokevirtual 648	com/tencent/smtt/sdk/TbsDownloadUpload:getLocalCoreVersion	()I
    //   278: istore 6
    //   280: aload 7
    //   282: ldc_w 650
    //   285: new 229	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   292: iload_3
    //   293: invokevirtual 587	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   296: ldc_w 580
    //   299: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: iload 4
    //   304: invokevirtual 587	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: ldc_w 580
    //   310: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: iload 5
    //   315: invokevirtual 587	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: ldc_w 580
    //   321: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: iload 6
    //   326: invokevirtual 587	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   329: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   335: pop
    //   336: aload_1
    //   337: invokestatic 652	com/tencent/smtt/sdk/c/b:b	(Landroid/content/Context;)Ljava/lang/String;
    //   340: astore 8
    //   342: aload 8
    //   344: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   347: ifne +14 -> 361
    //   350: aload 7
    //   352: ldc_w 654
    //   355: aload 8
    //   357: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   360: pop
    //   361: aload 7
    //   363: ldc_w 656
    //   366: iconst_3
    //   367: invokevirtual 442	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   370: pop
    //   371: aload 7
    //   373: ldc_w 658
    //   376: aload_0
    //   377: getfield 382	MTT/ThirdAppInfoNew:sAndroidID	Ljava/lang/String;
    //   380: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   383: pop
    //   384: aload_1
    //   385: invokestatic 395	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   388: ifeq +258 -> 646
    //   391: aload 7
    //   393: ldc_w 660
    //   396: aload_1
    //   397: invokestatic 664	com/tencent/smtt/sdk/TbsShareManager:getHostCoreVersions	(Landroid/content/Context;)J
    //   400: invokevirtual 612	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   403: pop
    //   404: aload_0
    //   405: getfield 401	MTT/ThirdAppInfoNew:iCoreType	I
    //   408: ifne +69 -> 477
    //   411: aload 7
    //   413: ldc_w 666
    //   416: aload_0
    //   417: getfield 413	MTT/ThirdAppInfoNew:sWifiConnectedTime	J
    //   420: invokevirtual 612	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   423: pop
    //   424: aload 7
    //   426: ldc_w 668
    //   429: aload_0
    //   430: getfield 419	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   433: invokevirtual 442	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   436: pop
    //   437: getstatic 673	com/tencent/smtt/sdk/TbsCoreLoadStat:mLoadErrorCode	I
    //   440: istore_3
    //   441: aload_0
    //   442: getfield 419	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   445: ifgt +230 -> 675
    //   448: aload 7
    //   450: ldc_w 675
    //   453: aload_1
    //   454: invokestatic 111	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   457: invokevirtual 678	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadInterruptCode	()I
    //   460: invokevirtual 442	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   463: pop
    //   464: iload_3
    //   465: iconst_m1
    //   466: if_icmpne +11 -> 477
    //   469: ldc 207
    //   471: ldc_w 680
    //   474: invokestatic 683	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: invokestatic 686	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   480: ifnull +43 -> 523
    //   483: aload_0
    //   484: getfield 291	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   487: ldc 249
    //   489: invokevirtual 84	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   492: ifeq +196 -> 688
    //   495: aload 7
    //   497: ldc_w 688
    //   500: invokestatic 693	com/tencent/smtt/utils/i:a	()Lcom/tencent/smtt/utils/i;
    //   503: invokestatic 686	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   506: invokevirtual 695	com/tencent/smtt/utils/i:a	(Ljava/lang/String;)Ljava/lang/String;
    //   509: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   512: pop
    //   513: aload 7
    //   515: ldc_w 697
    //   518: iconst_1
    //   519: invokevirtual 442	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   522: pop
    //   523: invokestatic 699	com/tencent/smtt/utils/b:d	()Z
    //   526: ifeq +204 -> 730
    //   529: aload 7
    //   531: ldc_w 701
    //   534: iload_2
    //   535: invokevirtual 442	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   538: pop
    //   539: aload_1
    //   540: invokestatic 706	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:isOneModeAvailable	(Landroid/content/Context;)Z
    //   543: ifeq +192 -> 735
    //   546: aload 7
    //   548: ldc_w 708
    //   551: iconst_3
    //   552: invokevirtual 442	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   555: pop
    //   556: ldc 207
    //   558: new 229	java/lang/StringBuilder
    //   561: dup
    //   562: ldc_w 710
    //   565: invokespecial 234	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   568: aload 7
    //   570: invokevirtual 445	org/json/JSONObject:toString	()Ljava/lang/String;
    //   573: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 221	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   582: ldc_w 588
    //   585: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   588: aload 7
    //   590: areturn
    //   591: aload_0
    //   592: getfield 410	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   595: ifnonnull +35 -> 630
    //   598: aload 7
    //   600: ldc_w 650
    //   603: ldc_w 712
    //   606: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   609: pop
    //   610: goto -249 -> 361
    //   613: astore_0
    //   614: ldc 207
    //   616: ldc_w 714
    //   619: invokestatic 683	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   622: ldc_w 588
    //   625: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   628: aconst_null
    //   629: areturn
    //   630: aload 7
    //   632: ldc_w 650
    //   635: aload_0
    //   636: getfield 410	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   639: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   642: pop
    //   643: goto -282 -> 361
    //   646: aload 7
    //   648: ldc_w 660
    //   651: aload_1
    //   652: invokestatic 719	com/tencent/smtt/sdk/TbsDownloader:getCoreShareDecoupleCoreVersionByContext	(Landroid/content/Context;)I
    //   655: invokevirtual 442	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   658: pop
    //   659: aload 7
    //   661: ldc_w 721
    //   664: aload_1
    //   665: invokestatic 719	com/tencent/smtt/sdk/TbsDownloader:getCoreShareDecoupleCoreVersionByContext	(Landroid/content/Context;)I
    //   668: invokevirtual 442	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   671: pop
    //   672: goto -268 -> 404
    //   675: aload 7
    //   677: ldc_w 675
    //   680: iload_3
    //   681: invokevirtual 442	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   684: pop
    //   685: goto -221 -> 464
    //   688: aload_0
    //   689: getfield 291	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   692: ldc_w 627
    //   695: invokevirtual 84	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   698: ifeq -175 -> 523
    //   701: aload 7
    //   703: ldc_w 688
    //   706: invokestatic 686	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   709: invokevirtual 593	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   712: pop
    //   713: aload 7
    //   715: ldc_w 697
    //   718: iconst_0
    //   719: invokevirtual 442	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   722: pop
    //   723: goto -200 -> 523
    //   726: astore_0
    //   727: goto -204 -> 523
    //   730: iconst_0
    //   731: istore_2
    //   732: goto -203 -> 529
    //   735: aload_1
    //   736: invokestatic 724	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:isTbsOneModeEnable	(Landroid/content/Context;)Z
    //   739: ifeq +16 -> 755
    //   742: aload 7
    //   744: ldc_w 708
    //   747: iconst_2
    //   748: invokevirtual 442	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   751: pop
    //   752: goto -196 -> 556
    //   755: aload 7
    //   757: ldc_w 708
    //   760: iconst_1
    //   761: invokevirtual 442	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   764: pop
    //   765: goto -209 -> 556
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	768	0	paramThirdAppInfoNew	ThirdAppInfoNew
    //   0	768	1	paramContext	Context
    //   1	731	2	i	int
    //   258	423	3	j	int
    //   264	39	4	k	int
    //   271	43	5	m	int
    //   278	47	6	n	int
    //   15	741	7	localJSONObject	JSONObject
    //   245	111	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	237	613	java/lang/Exception
    //   237	361	613	java/lang/Exception
    //   361	404	613	java/lang/Exception
    //   404	464	613	java/lang/Exception
    //   469	477	613	java/lang/Exception
    //   523	529	613	java/lang/Exception
    //   529	556	613	java/lang/Exception
    //   591	610	613	java/lang/Exception
    //   630	643	613	java/lang/Exception
    //   646	672	613	java/lang/Exception
    //   675	685	613	java/lang/Exception
    //   735	752	613	java/lang/Exception
    //   755	765	613	java/lang/Exception
    //   477	523	726	java/lang/Exception
    //   688	723	726	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.c.b
 * JD-Core Version:    0.7.0.1
 */