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

public class b
{
  public static byte[] a;
  private static ThirdAppInfoNew b;
  
  static
  {
    AppMethodBeat.i(219776);
    a = null;
    try
    {
      a = "65dRa93L".getBytes("utf-8");
      AppMethodBeat.o(219776);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      AppMethodBeat.o(219776);
    }
  }
  
  static File a(Context paramContext)
  {
    AppMethodBeat.i(219764);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_private");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(219764);
      return null;
    }
    AppMethodBeat.o(219764);
    return paramContext;
  }
  
  public static void a(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    AppMethodBeat.i(219701);
    a(paramThirdAppInfoNew, paramContext, null, null);
    AppMethodBeat.o(219701);
  }
  
  public static void a(final ThirdAppInfoNew paramThirdAppInfoNew, final Context paramContext, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(219707);
    new Thread("HttpUtils")
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 42
        //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 19	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   9: aload_0
        //   10: getfield 21	com/tencent/smtt/sdk/c/b$1:b	LMTT/ThirdAppInfoNew;
        //   13: getfield 53	MTT/ThirdAppInfoNew:sGuid	Ljava/lang/String;
        //   16: invokestatic 58	com/tencent/smtt/utils/b:b	(Landroid/content/Context;Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 21	com/tencent/smtt/sdk/c/b$1:b	LMTT/ThirdAppInfoNew;
        //   23: invokestatic 61	com/tencent/smtt/utils/b:a	()Ljava/lang/String;
        //   26: putfield 64	MTT/ThirdAppInfoNew:sCpu	Ljava/lang/String;
        //   29: getstatic 70	android/os/Build$VERSION:SDK_INT	I
        //   32: bipush 8
        //   34: if_icmpge +9 -> 43
        //   37: ldc 42
        //   39: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   42: return
        //   43: getstatic 76	com/tencent/smtt/sdk/c/b:a	[B
        //   46: ifnonnull +13 -> 59
        //   49: ldc 78
        //   51: ldc 80
        //   53: invokevirtual 86	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   56: putstatic 76	com/tencent/smtt/sdk/c/b:a	[B
        //   59: getstatic 76	com/tencent/smtt/sdk/c/b:a	[B
        //   62: ifnonnull +31 -> 93
        //   65: ldc 88
        //   67: ldc 90
        //   69: invokestatic 96	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   72: ldc 42
        //   74: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   77: return
        //   78: astore_2
        //   79: aconst_null
        //   80: putstatic 76	com/tencent/smtt/sdk/c/b:a	[B
        //   83: ldc 88
        //   85: ldc 98
        //   87: invokestatic 96	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   90: goto -31 -> 59
        //   93: aload_0
        //   94: getfield 19	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   97: invokestatic 104	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
        //   100: getfield 108	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
        //   103: ldc 110
        //   105: ldc 112
        //   107: invokeinterface 118 3 0
        //   112: astore_2
        //   113: ldc 112
        //   115: astore_3
        //   116: aload_2
        //   117: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   120: ifne +767 -> 887
        //   123: aload_2
        //   124: iconst_0
        //   125: aload_2
        //   126: ldc 126
        //   128: invokevirtual 130	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   131: invokevirtual 134	java/lang/String:substring	(II)Ljava/lang/String;
        //   134: astore_3
        //   135: aload_2
        //   136: aload_2
        //   137: ldc 126
        //   139: invokevirtual 130	java/lang/String:indexOf	(Ljava/lang/String;)I
        //   142: iconst_1
        //   143: iadd
        //   144: aload_2
        //   145: invokevirtual 138	java/lang/String:length	()I
        //   148: invokevirtual 134	java/lang/String:substring	(II)Ljava/lang/String;
        //   151: astore_2
        //   152: aload_3
        //   153: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   156: ifne +28 -> 184
        //   159: aload_3
        //   160: invokevirtual 138	java/lang/String:length	()I
        //   163: bipush 96
        //   165: if_icmpne +19 -> 184
        //   168: aload_2
        //   169: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   172: ifne +12 -> 184
        //   175: aload_2
        //   176: invokevirtual 138	java/lang/String:length	()I
        //   179: bipush 24
        //   181: if_icmpeq +151 -> 332
        //   184: iconst_1
        //   185: istore_1
        //   186: invokestatic 143	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
        //   189: astore 4
        //   191: iload_1
        //   192: ifeq +145 -> 337
        //   195: new 145	java/lang/StringBuilder
        //   198: dup
        //   199: invokespecial 147	java/lang/StringBuilder:<init>	()V
        //   202: aload 4
        //   204: invokevirtual 149	com/tencent/smtt/utils/o:b	()Ljava/lang/String;
        //   207: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   210: invokestatic 158	com/tencent/smtt/utils/h:a	()Lcom/tencent/smtt/utils/h;
        //   213: invokevirtual 159	com/tencent/smtt/utils/h:b	()Ljava/lang/String;
        //   216: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   219: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   222: astore_3
        //   223: ldc 88
        //   225: ldc 164
        //   227: aload_3
        //   228: invokestatic 168	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   231: invokevirtual 172	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   234: invokestatic 174	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   237: new 176	java/net/URL
        //   240: dup
        //   241: aload_3
        //   242: invokespecial 177	java/net/URL:<init>	(Ljava/lang/String;)V
        //   245: invokevirtual 181	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   248: checkcast 183	java/net/HttpURLConnection
        //   251: astore 6
        //   253: aload 6
        //   255: ldc 185
        //   257: invokevirtual 188	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   260: aload 6
        //   262: iconst_1
        //   263: invokevirtual 192	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   266: aload 6
        //   268: iconst_1
        //   269: invokevirtual 195	java/net/HttpURLConnection:setDoInput	(Z)V
        //   272: aload 6
        //   274: iconst_0
        //   275: invokevirtual 198	java/net/HttpURLConnection:setUseCaches	(Z)V
        //   278: aload 6
        //   280: sipush 20000
        //   283: invokevirtual 201	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   286: getstatic 70	android/os/Build$VERSION:SDK_INT	I
        //   289: bipush 13
        //   291: if_icmple +12 -> 303
        //   294: aload 6
        //   296: ldc 203
        //   298: ldc 205
        //   300: invokevirtual 208	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   303: aload_0
        //   304: getfield 21	com/tencent/smtt/sdk/c/b$1:b	LMTT/ThirdAppInfoNew;
        //   307: aload_0
        //   308: getfield 19	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   311: invokestatic 211	com/tencent/smtt/sdk/c/b:b	(LMTT/ThirdAppInfoNew;Landroid/content/Context;)Lorg/json/JSONObject;
        //   314: astore_3
        //   315: aload_3
        //   316: ifnonnull +116 -> 432
        //   319: ldc 88
        //   321: ldc 213
        //   323: invokestatic 96	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   326: ldc 42
        //   328: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   331: return
        //   332: iconst_0
        //   333: istore_1
        //   334: goto -148 -> 186
        //   337: new 145	java/lang/StringBuilder
        //   340: dup
        //   341: invokespecial 147	java/lang/StringBuilder:<init>	()V
        //   344: aload 4
        //   346: invokevirtual 216	com/tencent/smtt/utils/o:f	()Ljava/lang/String;
        //   349: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   352: aload_3
        //   353: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   356: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   359: astore_3
        //   360: goto -137 -> 223
        //   363: astore_2
        //   364: ldc 88
        //   366: ldc 218
        //   368: aload_2
        //   369: invokestatic 168	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   372: invokevirtual 172	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   375: invokestatic 96	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   378: ldc 42
        //   380: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   383: return
        //   384: astore_2
        //   385: ldc 88
        //   387: ldc 220
        //   389: aload_2
        //   390: invokestatic 168	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   393: invokevirtual 172	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   396: invokestatic 96	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   399: ldc 42
        //   401: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   404: return
        //   405: astore_2
        //   406: ldc 88
        //   408: ldc 222
        //   410: aload_2
        //   411: invokestatic 168	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   414: invokevirtual 172	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
        //   417: invokestatic 96	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   420: ldc 42
        //   422: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   425: return
        //   426: astore_3
        //   427: aconst_null
        //   428: astore_3
        //   429: goto -114 -> 315
        //   432: aload_0
        //   433: getfield 23	com/tencent/smtt/sdk/c/b$1:c	Ljava/lang/String;
        //   436: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   439: ifne +68 -> 507
        //   442: aload_0
        //   443: getfield 25	com/tencent/smtt/sdk/c/b$1:d	Ljava/lang/String;
        //   446: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   449: ifne +58 -> 507
        //   452: ldc 112
        //   454: astore 4
        //   456: new 224	org/json/JSONObject
        //   459: dup
        //   460: invokespecial 225	org/json/JSONObject:<init>	()V
        //   463: astore 5
        //   465: aload 5
        //   467: aload_0
        //   468: getfield 23	com/tencent/smtt/sdk/c/b$1:c	Ljava/lang/String;
        //   471: aload_0
        //   472: getfield 25	com/tencent/smtt/sdk/c/b$1:d	Ljava/lang/String;
        //   475: invokevirtual 229	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   478: pop
        //   479: aload 5
        //   481: invokevirtual 230	org/json/JSONObject:toString	()Ljava/lang/String;
        //   484: astore 5
        //   486: aload 5
        //   488: astore 4
        //   490: aload_3
        //   491: ldc 232
        //   493: aload 4
        //   495: invokevirtual 229	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   498: pop
        //   499: aload_3
        //   500: ldc 234
        //   502: iconst_0
        //   503: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
        //   506: pop
        //   507: ldc 88
        //   509: new 145	java/lang/StringBuilder
        //   512: dup
        //   513: ldc 239
        //   515: invokespecial 240	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   518: aload_3
        //   519: invokevirtual 230	org/json/JSONObject:toString	()Ljava/lang/String;
        //   522: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   525: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   528: invokestatic 174	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   531: aload_3
        //   532: invokevirtual 230	org/json/JSONObject:toString	()Ljava/lang/String;
        //   535: ldc 80
        //   537: invokevirtual 86	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   540: astore 4
        //   542: iload_1
        //   543: ifeq +168 -> 711
        //   546: invokestatic 158	com/tencent/smtt/utils/h:a	()Lcom/tencent/smtt/utils/h;
        //   549: aload 4
        //   551: invokevirtual 243	com/tencent/smtt/utils/h:a	([B)[B
        //   554: astore 4
        //   556: aload 6
        //   558: ldc 245
        //   560: ldc 247
        //   562: invokevirtual 208	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   565: aload 6
        //   567: ldc 249
        //   569: aload 4
        //   571: arraylength
        //   572: invokestatic 252	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   575: invokevirtual 208	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   578: aload 6
        //   580: invokevirtual 256	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   583: astore 5
        //   585: aload 5
        //   587: aload 4
        //   589: invokevirtual 262	java/io/OutputStream:write	([B)V
        //   592: aload 5
        //   594: invokevirtual 265	java/io/OutputStream:flush	()V
        //   597: aload 6
        //   599: invokevirtual 268	java/net/HttpURLConnection:getResponseCode	()I
        //   602: sipush 200
        //   605: if_icmpne +124 -> 729
        //   608: ldc 88
        //   610: ldc_w 270
        //   613: invokestatic 174	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   616: ldc 88
        //   618: new 145	java/lang/StringBuilder
        //   621: dup
        //   622: ldc_w 272
        //   625: invokespecial 240	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   628: aload_3
        //   629: ldc_w 274
        //   632: invokevirtual 276	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   635: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   638: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   641: invokestatic 174	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   644: aload 6
        //   646: aload_2
        //   647: iload_1
        //   648: invokestatic 279	com/tencent/smtt/sdk/c/b:a	(Ljava/net/HttpURLConnection;Ljava/lang/String;Z)Ljava/lang/String;
        //   651: astore_2
        //   652: aload_0
        //   653: getfield 19	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   656: aload_2
        //   657: invokestatic 281	com/tencent/smtt/sdk/c/b:a	(Landroid/content/Context;Ljava/lang/String;)V
        //   660: new 283	com/tencent/smtt/sdk/TbsDownloadUpload
        //   663: dup
        //   664: aload_0
        //   665: getfield 19	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   668: invokespecial 286	com/tencent/smtt/sdk/TbsDownloadUpload:<init>	(Landroid/content/Context;)V
        //   671: invokevirtual 289	com/tencent/smtt/sdk/TbsDownloadUpload:clearUploadCode	()V
        //   674: ldc 42
        //   676: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   679: return
        //   680: astore 4
        //   682: ldc 88
        //   684: new 145	java/lang/StringBuilder
        //   687: dup
        //   688: ldc_w 291
        //   691: invokespecial 240	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   694: aload 4
        //   696: invokevirtual 294	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   699: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   702: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   705: invokestatic 96	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   708: goto -201 -> 507
        //   711: aload 4
        //   713: aload_2
        //   714: invokestatic 297	com/tencent/smtt/utils/h:a	([BLjava/lang/String;)[B
        //   717: astore 4
        //   719: goto -163 -> 556
        //   722: astore_2
        //   723: ldc 42
        //   725: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   728: return
        //   729: ldc 88
        //   731: new 145	java/lang/StringBuilder
        //   734: dup
        //   735: ldc_w 299
        //   738: invokespecial 240	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   741: aload 6
        //   743: invokevirtual 268	java/net/HttpURLConnection:getResponseCode	()I
        //   746: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   749: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   752: invokestatic 96	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   755: aload_0
        //   756: getfield 19	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   759: invokestatic 307	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
        //   762: invokevirtual 311	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
        //   765: astore_2
        //   766: aload_2
        //   767: bipush 126
        //   769: invokevirtual 316	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
        //   772: aload_2
        //   773: new 145	java/lang/StringBuilder
        //   776: dup
        //   777: invokespecial 147	java/lang/StringBuilder:<init>	()V
        //   780: aload 6
        //   782: invokevirtual 268	java/net/HttpURLConnection:getResponseCode	()I
        //   785: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   788: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   791: invokevirtual 319	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
        //   794: aload_0
        //   795: getfield 19	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   798: invokestatic 307	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
        //   801: getstatic 325	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
        //   804: aload_2
        //   805: invokevirtual 329	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
        //   808: ldc 42
        //   810: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   813: return
        //   814: astore_2
        //   815: ldc 88
        //   817: new 145	java/lang/StringBuilder
        //   820: dup
        //   821: ldc_w 291
        //   824: invokespecial 240	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   827: aload_2
        //   828: invokevirtual 332	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   831: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   834: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   837: invokestatic 96	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   840: aload_0
        //   841: getfield 19	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   844: invokestatic 307	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
        //   847: invokevirtual 311	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
        //   850: astore_3
        //   851: aload_3
        //   852: bipush 126
        //   854: invokevirtual 316	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
        //   857: aload_3
        //   858: aload_2
        //   859: invokevirtual 335	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/Throwable;)V
        //   862: aload_0
        //   863: getfield 19	com/tencent/smtt/sdk/c/b$1:a	Landroid/content/Context;
        //   866: invokestatic 307	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
        //   869: getstatic 325	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
        //   872: aload_3
        //   873: invokevirtual 329	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
        //   876: ldc 42
        //   878: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   881: return
        //   882: astore 5
        //   884: goto -394 -> 490
        //   887: ldc 112
        //   889: astore_2
        //   890: goto -738 -> 152
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	893	0	this	1
        //   185	463	1	bool	boolean
        //   78	1	2	localUnsupportedEncodingException	UnsupportedEncodingException
        //   112	64	2	str1	String
        //   363	6	2	localIOException	java.io.IOException
        //   384	6	2	localAssertionError	java.lang.AssertionError
        //   405	242	2	localNoClassDefFoundError	java.lang.NoClassDefFoundError
        //   651	63	2	str2	String
        //   722	1	2	localObject1	Object
        //   765	40	2	localTbsLogInfo1	com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo
        //   814	45	2	localThrowable	java.lang.Throwable
        //   889	1	2	str3	String
        //   115	245	3	localObject2	Object
        //   426	1	3	localException1	Exception
        //   428	445	3	localTbsLogInfo2	com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo
        //   189	399	4	localObject3	Object
        //   680	32	4	localException2	Exception
        //   717	1	4	arrayOfByte	byte[]
        //   463	130	5	localObject4	Object
        //   882	1	5	localObject5	Object
        //   251	530	6	localHttpURLConnection	java.net.HttpURLConnection
        // Exception table:
        //   from	to	target	type
        //   49	59	78	java/io/UnsupportedEncodingException
        //   186	191	363	java/io/IOException
        //   195	223	363	java/io/IOException
        //   223	260	363	java/io/IOException
        //   337	360	363	java/io/IOException
        //   186	191	384	java/lang/AssertionError
        //   195	223	384	java/lang/AssertionError
        //   223	260	384	java/lang/AssertionError
        //   337	360	384	java/lang/AssertionError
        //   186	191	405	java/lang/NoClassDefFoundError
        //   195	223	405	java/lang/NoClassDefFoundError
        //   223	260	405	java/lang/NoClassDefFoundError
        //   337	360	405	java/lang/NoClassDefFoundError
        //   303	315	426	java/lang/Exception
        //   432	452	680	java/lang/Exception
        //   490	507	680	java/lang/Exception
        //   507	542	722	finally
        //   546	556	722	finally
        //   711	719	722	finally
        //   578	674	814	finally
        //   729	808	814	finally
        //   456	486	882	finally
      }
    }.start();
    AppMethodBeat.o(219707);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(219767);
    if (("reset".equals(paramString1)) && ("true".equals(paramString2)))
    {
      QbSdk.reset(paramContext);
      AppMethodBeat.o(219767);
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
      AppMethodBeat.o(219767);
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
      AppMethodBeat.o(219767);
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
      AppMethodBeat.o(219767);
      return;
    }
    TbsPVConfig.getInstance(paramContext).putData(paramString1, paramString2);
    AppMethodBeat.o(219767);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    AppMethodBeat.i(219735);
    if ((QbSdk.getSettings() != null) && (QbSdk.getSettings().containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) && (QbSdk.getSettings().get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")))
    {
      TbsLog.i("sdkreport", "[HttpUtils.doReport] -- SET_SENDREQUEST_AND_UPLOAD is false");
      AppMethodBeat.o(219735);
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
          ((ThirdAppInfoNew)localObject2).sVersionCode = com.tencent.smtt.utils.b.e(paramContext);
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
            paramString1 = com.tencent.smtt.utils.b.j(paramContext);
            paramString2 = com.tencent.smtt.utils.b.h(paramContext);
            TbsLog.i("sdkreport", "HttpUtils.doReport():  imei is ".concat(String.valueOf(paramString2)));
            paramString3 = com.tencent.smtt.utils.b.i(paramContext);
            localObject3 = com.tencent.smtt.utils.b.k(paramContext);
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
              break label638;
            }
            if (TbsShareManager.getCoreFormOwn())
            {
              ((ThirdAppInfoNew)localObject2).iCoreType = 2;
              if (paramBoolean2) {
                ((ThirdAppInfoNew)localObject2).iCoreType = 3;
              }
              ((ThirdAppInfoNew)localObject2).sAppVersionName = localObject1;
              ((ThirdAppInfoNew)localObject2).sAppSignature = b(paramContext);
              if (!paramBoolean1)
              {
                ((ThirdAppInfoNew)localObject2).sWifiConnectedTime = paramLong;
                ((ThirdAppInfoNew)localObject2).localCoreVersion = QbSdk.getTbsVersion(paramContext);
              }
              b = (ThirdAppInfoNew)localObject2;
              r.a(paramContext, "pv_report", "");
              r.e(paramContext);
              a((ThirdAppInfoNew)localObject2, paramContext.getApplicationContext());
              AppMethodBeat.o(219735);
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
        finally
        {
          AppMethodBeat.o(219735);
          return;
        }
      }
      label638:
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
    int i = 0;
    AppMethodBeat.i(219744);
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
            AppMethodBeat.o(219744);
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
          AppMethodBeat.o(219744);
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(219744);
    }
    return null;
  }
  
  /* Error */
  private static String b(java.net.HttpURLConnection paramHttpURLConnection, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 486
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 226
    //   8: astore 5
    //   10: aload_0
    //   11: invokevirtual 492	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   14: astore 4
    //   16: aload_0
    //   17: invokevirtual 495	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull +133 -> 155
    //   25: aload_0
    //   26: ldc_w 497
    //   29: invokevirtual 500	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   32: ifeq +123 -> 155
    //   35: new 502	java/util/zip/GZIPInputStream
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 505	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore_0
    //   45: new 507	java/io/ByteArrayOutputStream
    //   48: dup
    //   49: invokespecial 508	java/io/ByteArrayOutputStream:<init>	()V
    //   52: astore 4
    //   54: sipush 128
    //   57: newarray byte
    //   59: astore 6
    //   61: aload_0
    //   62: aload 6
    //   64: invokevirtual 514	java/io/InputStream:read	([B)I
    //   67: istore_3
    //   68: iload_3
    //   69: iconst_m1
    //   70: if_icmpeq +134 -> 204
    //   73: aload 4
    //   75: aload 6
    //   77: iconst_0
    //   78: iload_3
    //   79: invokevirtual 518	java/io/ByteArrayOutputStream:write	([BII)V
    //   82: goto -21 -> 61
    //   85: astore_1
    //   86: aload 4
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +7 -> 97
    //   93: aload_1
    //   94: invokevirtual 521	java/io/ByteArrayOutputStream:close	()V
    //   97: aload 5
    //   99: astore 4
    //   101: aload_0
    //   102: ifnull +11 -> 113
    //   105: aload_0
    //   106: invokevirtual 522	java/io/InputStream:close	()V
    //   109: aload 5
    //   111: astore 4
    //   113: ldc 71
    //   115: new 232	java/lang/StringBuilder
    //   118: dup
    //   119: ldc_w 524
    //   122: invokespecial 237	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload 4
    //   127: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc_w 526
    //   133: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload_2
    //   137: invokevirtual 529	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   140: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 216	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: ldc_w 486
    //   149: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload 4
    //   154: areturn
    //   155: aload_0
    //   156: ifnull +42 -> 198
    //   159: aload_0
    //   160: ldc_w 531
    //   163: invokevirtual 500	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   166: ifeq +32 -> 198
    //   169: new 533	java/util/zip/InflaterInputStream
    //   172: dup
    //   173: aload 4
    //   175: new 535	java/util/zip/Inflater
    //   178: dup
    //   179: iconst_1
    //   180: invokespecial 538	java/util/zip/Inflater:<init>	(Z)V
    //   183: invokespecial 541	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
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
    //   208: new 29	java/lang/String
    //   211: dup
    //   212: invokestatic 546	com/tencent/smtt/utils/h:a	()Lcom/tencent/smtt/utils/h;
    //   215: aload 4
    //   217: invokevirtual 547	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   220: invokevirtual 551	com/tencent/smtt/utils/h:c	([B)[B
    //   223: invokespecial 553	java/lang/String:<init>	([B)V
    //   226: astore_1
    //   227: aload 4
    //   229: invokevirtual 521	java/io/ByteArrayOutputStream:close	()V
    //   232: aload_1
    //   233: astore 4
    //   235: aload_0
    //   236: ifnull -123 -> 113
    //   239: aload_0
    //   240: invokevirtual 522	java/io/InputStream:close	()V
    //   243: aload_1
    //   244: astore 4
    //   246: goto -133 -> 113
    //   249: astore_0
    //   250: aload_1
    //   251: astore 4
    //   253: goto -140 -> 113
    //   256: new 29	java/lang/String
    //   259: dup
    //   260: aload 4
    //   262: invokevirtual 547	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   265: aload_1
    //   266: invokestatic 556	com/tencent/smtt/utils/h:b	([BLjava/lang/String;)[B
    //   269: invokespecial 553	java/lang/String:<init>	([B)V
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
    //   289: invokevirtual 521	java/io/ByteArrayOutputStream:close	()V
    //   292: aload_0
    //   293: ifnull +7 -> 300
    //   296: aload_0
    //   297: invokevirtual 522	java/io/InputStream:close	()V
    //   300: ldc_w 486
    //   303: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 561
    //   5: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 564	com/tencent/smtt/sdk/TbsPVConfig:releaseInstance	()V
    //   11: aload_0
    //   12: invokestatic 182	com/tencent/smtt/sdk/TbsPVConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsPVConfig;
    //   15: invokevirtual 567	com/tencent/smtt/sdk/TbsPVConfig:clear	()V
    //   18: aload_1
    //   19: invokestatic 278	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: istore 4
    //   24: iload 4
    //   26: ifeq +10 -> 36
    //   29: ldc_w 561
    //   32: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: return
    //   36: aload_1
    //   37: ldc_w 569
    //   40: invokevirtual 573	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   59: ldc_w 575
    //   62: invokevirtual 573	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   83: invokestatic 576	com/tencent/smtt/sdk/c/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   86: iload_2
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: goto -43 -> 47
    //   93: aload_0
    //   94: invokestatic 182	com/tencent/smtt/sdk/TbsPVConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsPVConfig;
    //   97: invokevirtual 577	com/tencent/smtt/sdk/TbsPVConfig:commit	()V
    //   100: aload_0
    //   101: invokestatic 182	com/tencent/smtt/sdk/TbsPVConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsPVConfig;
    //   104: aload_0
    //   105: invokevirtual 580	com/tencent/smtt/sdk/TbsPVConfig:refreshSyncMap	(Landroid/content/Context;)V
    //   108: ldc_w 561
    //   111: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: astore_0
    //   116: ldc_w 561
    //   119: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  /* Error */
  private static org.json.JSONObject c(ThirdAppInfoNew paramThirdAppInfoNew, Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 581
    //   5: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 583	org/json/JSONObject
    //   11: dup
    //   12: invokespecial 584	org/json/JSONObject:<init>	()V
    //   15: astore 7
    //   17: aload 7
    //   19: ldc_w 586
    //   22: aload_0
    //   23: getfield 294	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   26: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload 7
    //   32: ldc_w 591
    //   35: aload_0
    //   36: getfield 332	MTT/ThirdAppInfoNew:sTime	Ljava/lang/String;
    //   39: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   42: pop
    //   43: aload 7
    //   45: ldc_w 593
    //   48: aload_0
    //   49: getfield 356	MTT/ThirdAppInfoNew:sQua2	Ljava/lang/String;
    //   52: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   55: pop
    //   56: aload 7
    //   58: ldc_w 595
    //   61: aload_0
    //   62: getfield 363	MTT/ThirdAppInfoNew:sLc	Ljava/lang/String;
    //   65: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   68: pop
    //   69: aload 7
    //   71: ldc_w 597
    //   74: aload_0
    //   75: getfield 353	MTT/ThirdAppInfoNew:sGuid	Ljava/lang/String;
    //   78: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   81: pop
    //   82: aload 7
    //   84: ldc_w 599
    //   87: aload_0
    //   88: getfield 380	MTT/ThirdAppInfoNew:sImei	Ljava/lang/String;
    //   91: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   94: pop
    //   95: aload 7
    //   97: ldc_w 601
    //   100: aload_0
    //   101: getfield 383	MTT/ThirdAppInfoNew:sImsi	Ljava/lang/String;
    //   104: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   107: pop
    //   108: aload 7
    //   110: ldc_w 603
    //   113: aload_0
    //   114: getfield 389	MTT/ThirdAppInfoNew:sMac	Ljava/lang/String;
    //   117: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   120: pop
    //   121: aload 7
    //   123: ldc_w 605
    //   126: aload_0
    //   127: getfield 393	MTT/ThirdAppInfoNew:iPv	J
    //   130: invokevirtual 608	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   133: pop
    //   134: aload 7
    //   136: ldc_w 610
    //   139: aload_0
    //   140: getfield 405	MTT/ThirdAppInfoNew:iCoreType	I
    //   143: invokevirtual 613	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   146: pop
    //   147: aload 7
    //   149: ldc_w 615
    //   152: aload_0
    //   153: getfield 408	MTT/ThirdAppInfoNew:sAppVersionName	Ljava/lang/String;
    //   156: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   159: pop
    //   160: aload 7
    //   162: ldc_w 617
    //   165: aload_0
    //   166: getfield 350	MTT/ThirdAppInfoNew:sMetaData	Ljava/lang/String;
    //   169: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   172: pop
    //   173: aload 7
    //   175: ldc_w 619
    //   178: aload_0
    //   179: getfield 342	MTT/ThirdAppInfoNew:sVersionCode	I
    //   182: invokevirtual 613	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   185: pop
    //   186: aload 7
    //   188: ldc_w 621
    //   191: aload_0
    //   192: getfield 624	MTT/ThirdAppInfoNew:sCpu	Ljava/lang/String;
    //   195: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   198: pop
    //   199: ldc_w 626
    //   202: aload_0
    //   203: getfield 294	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   206: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   209: ifne +28 -> 237
    //   212: ldc 252
    //   214: aload_0
    //   215: getfield 294	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   218: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   221: ifne +16 -> 237
    //   224: ldc_w 628
    //   227: aload_0
    //   228: getfield 294	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   231: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   234: ifeq +325 -> 559
    //   237: new 630	com/tencent/smtt/sdk/TbsDownloadUpload
    //   240: dup
    //   241: aload_1
    //   242: invokespecial 632	com/tencent/smtt/sdk/TbsDownloadUpload:<init>	(Landroid/content/Context;)V
    //   245: astore 8
    //   247: aload 8
    //   249: aload_1
    //   250: invokevirtual 635	com/tencent/smtt/sdk/TbsDownloadUpload:readTbsDownloadInfo	(Landroid/content/Context;)V
    //   253: aload 8
    //   255: invokevirtual 638	com/tencent/smtt/sdk/TbsDownloadUpload:getNeedDownloadCode	()I
    //   258: istore_3
    //   259: aload 8
    //   261: invokevirtual 641	com/tencent/smtt/sdk/TbsDownloadUpload:getStartDownloadCode	()I
    //   264: istore 4
    //   266: aload 8
    //   268: invokevirtual 644	com/tencent/smtt/sdk/TbsDownloadUpload:getNeedDownloadReturn	()I
    //   271: istore 5
    //   273: aload 8
    //   275: invokevirtual 647	com/tencent/smtt/sdk/TbsDownloadUpload:getLocalCoreVersion	()I
    //   278: istore 6
    //   280: aload 7
    //   282: ldc_w 649
    //   285: new 232	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   292: iload_3
    //   293: invokevirtual 483	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   296: ldc_w 476
    //   299: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: iload 4
    //   304: invokevirtual 483	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: ldc_w 476
    //   310: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: iload 5
    //   315: invokevirtual 483	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: ldc_w 476
    //   321: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: iload 6
    //   326: invokevirtual 483	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   329: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   335: pop
    //   336: ldc 226
    //   338: invokestatic 278	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   341: ifne +14 -> 355
    //   344: aload 7
    //   346: ldc_w 651
    //   349: ldc 226
    //   351: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   354: pop
    //   355: aload 7
    //   357: ldc_w 653
    //   360: iconst_3
    //   361: invokevirtual 613	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   364: pop
    //   365: aload 7
    //   367: ldc_w 655
    //   370: aload_0
    //   371: getfield 386	MTT/ThirdAppInfoNew:sAndroidID	Ljava/lang/String;
    //   374: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   377: pop
    //   378: aload_1
    //   379: invokestatic 399	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   382: ifeq +232 -> 614
    //   385: aload 7
    //   387: ldc_w 657
    //   390: aload_1
    //   391: invokestatic 661	com/tencent/smtt/sdk/TbsShareManager:getHostCoreVersions	(Landroid/content/Context;)J
    //   394: invokevirtual 608	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   397: pop
    //   398: aload_0
    //   399: getfield 405	MTT/ThirdAppInfoNew:iCoreType	I
    //   402: ifne +69 -> 471
    //   405: aload 7
    //   407: ldc_w 663
    //   410: aload_0
    //   411: getfield 416	MTT/ThirdAppInfoNew:sWifiConnectedTime	J
    //   414: invokevirtual 608	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   417: pop
    //   418: aload 7
    //   420: ldc_w 665
    //   423: aload_0
    //   424: getfield 422	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   427: invokevirtual 613	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   430: pop
    //   431: getstatic 670	com/tencent/smtt/sdk/TbsCoreLoadStat:mLoadErrorCode	I
    //   434: istore_3
    //   435: aload_0
    //   436: getfield 422	MTT/ThirdAppInfoNew:localCoreVersion	I
    //   439: ifgt +204 -> 643
    //   442: aload 7
    //   444: ldc_w 672
    //   447: aload_1
    //   448: invokestatic 116	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   451: invokevirtual 675	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadInterruptCode	()I
    //   454: invokevirtual 613	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   457: pop
    //   458: iload_3
    //   459: iconst_m1
    //   460: if_icmpne +11 -> 471
    //   463: ldc 210
    //   465: ldc_w 677
    //   468: invokestatic 679	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: invokestatic 682	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   474: ifnull +43 -> 517
    //   477: aload_0
    //   478: getfield 294	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   481: ldc 252
    //   483: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   486: ifeq +170 -> 656
    //   489: aload 7
    //   491: ldc_w 684
    //   494: invokestatic 689	com/tencent/smtt/utils/i:a	()Lcom/tencent/smtt/utils/i;
    //   497: invokestatic 682	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   500: invokevirtual 691	com/tencent/smtt/utils/i:a	(Ljava/lang/String;)Ljava/lang/String;
    //   503: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   506: pop
    //   507: aload 7
    //   509: ldc_w 693
    //   512: iconst_1
    //   513: invokevirtual 613	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   516: pop
    //   517: invokestatic 695	com/tencent/smtt/utils/b:b	()Z
    //   520: ifeq +178 -> 698
    //   523: aload 7
    //   525: ldc_w 697
    //   528: iload_2
    //   529: invokevirtual 613	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   532: pop
    //   533: aload_1
    //   534: invokestatic 702	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:isOneModeAvailable	(Landroid/content/Context;)Z
    //   537: ifeq +166 -> 703
    //   540: aload 7
    //   542: ldc_w 704
    //   545: iconst_3
    //   546: invokevirtual 613	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   549: pop
    //   550: ldc_w 581
    //   553: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   556: aload 7
    //   558: areturn
    //   559: aload_0
    //   560: getfield 413	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   563: ifnonnull +35 -> 598
    //   566: aload 7
    //   568: ldc_w 649
    //   571: ldc_w 706
    //   574: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   577: pop
    //   578: goto -223 -> 355
    //   581: astore_0
    //   582: ldc 210
    //   584: ldc_w 708
    //   587: invokestatic 679	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: ldc_w 581
    //   593: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   596: aconst_null
    //   597: areturn
    //   598: aload 7
    //   600: ldc_w 649
    //   603: aload_0
    //   604: getfield 413	MTT/ThirdAppInfoNew:sAppSignature	Ljava/lang/String;
    //   607: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   610: pop
    //   611: goto -256 -> 355
    //   614: aload 7
    //   616: ldc_w 657
    //   619: aload_1
    //   620: invokestatic 713	com/tencent/smtt/sdk/TbsDownloader:getCoreShareDecoupleCoreVersionByContext	(Landroid/content/Context;)I
    //   623: invokevirtual 613	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   626: pop
    //   627: aload 7
    //   629: ldc_w 715
    //   632: aload_1
    //   633: invokestatic 713	com/tencent/smtt/sdk/TbsDownloader:getCoreShareDecoupleCoreVersionByContext	(Landroid/content/Context;)I
    //   636: invokevirtual 613	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   639: pop
    //   640: goto -242 -> 398
    //   643: aload 7
    //   645: ldc_w 672
    //   648: iload_3
    //   649: invokevirtual 613	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   652: pop
    //   653: goto -195 -> 458
    //   656: aload_0
    //   657: getfield 294	MTT/ThirdAppInfoNew:sAppName	Ljava/lang/String;
    //   660: ldc_w 626
    //   663: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   666: ifeq -149 -> 517
    //   669: aload 7
    //   671: ldc_w 684
    //   674: invokestatic 682	com/tencent/smtt/sdk/QbSdk:getTID	()Ljava/lang/String;
    //   677: invokevirtual 589	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   680: pop
    //   681: aload 7
    //   683: ldc_w 693
    //   686: iconst_0
    //   687: invokevirtual 613	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   690: pop
    //   691: goto -174 -> 517
    //   694: astore_0
    //   695: goto -178 -> 517
    //   698: iconst_0
    //   699: istore_2
    //   700: goto -177 -> 523
    //   703: aload_1
    //   704: invokestatic 718	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:isTbsOneModeEnable	(Landroid/content/Context;)Z
    //   707: ifeq +16 -> 723
    //   710: aload 7
    //   712: ldc_w 704
    //   715: iconst_2
    //   716: invokevirtual 613	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   719: pop
    //   720: goto -170 -> 550
    //   723: aload 7
    //   725: ldc_w 704
    //   728: iconst_1
    //   729: invokevirtual 613	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   732: pop
    //   733: goto -183 -> 550
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	736	0	paramThirdAppInfoNew	ThirdAppInfoNew
    //   0	736	1	paramContext	Context
    //   1	699	2	i	int
    //   258	391	3	j	int
    //   264	39	4	k	int
    //   271	43	5	m	int
    //   278	47	6	n	int
    //   15	709	7	localJSONObject	org.json.JSONObject
    //   245	29	8	localTbsDownloadUpload	com.tencent.smtt.sdk.TbsDownloadUpload
    // Exception table:
    //   from	to	target	type
    //   8	237	581	java/lang/Exception
    //   237	355	581	java/lang/Exception
    //   355	398	581	java/lang/Exception
    //   398	458	581	java/lang/Exception
    //   463	471	581	java/lang/Exception
    //   517	523	581	java/lang/Exception
    //   523	550	581	java/lang/Exception
    //   559	578	581	java/lang/Exception
    //   598	611	581	java/lang/Exception
    //   614	640	581	java/lang/Exception
    //   643	653	581	java/lang/Exception
    //   703	720	581	java/lang/Exception
    //   723	733	581	java/lang/Exception
    //   471	517	694	java/lang/Exception
    //   656	691	694	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.c.b
 * JD-Core Version:    0.7.0.1
 */