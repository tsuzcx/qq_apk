package com.tencent.ttpic.device;

import com.tencent.ttpic.baseutils.LogUtils;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class NetworkUtils
{
  private static final String CHARSET_UTF8 = "UTF-8";
  private static final int DEFAULT_TIMEOUT_MILLIS = 10000;
  private static final String TAG = NetworkUtils.class.getSimpleName();
  
  private static HttpURLConnection buildConnection(String paramString, int paramInt)
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setConnectTimeout(paramInt);
    paramString.setReadTimeout(paramInt);
    return paramString;
  }
  
  public static String checkConfigVersion(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PackageName", paramString2);
    localHashMap.put("camCoreVersion", paramString3);
    localHashMap.put("AppId", paramString4);
    localHashMap.put("AppVersion", paramString5);
    try
    {
      paramString1 = post(paramString1, localHashMap);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      LogUtils.d(TAG, "checkConfigVersion Exception! e = " + paramString1);
    }
    return null;
  }
  
  public static String get(String paramString)
  {
    return get(paramString, 10000);
  }
  
  public static String get(String paramString, int paramInt)
  {
    paramString = buildConnection(paramString, paramInt);
    paramString.setRequestMethod("GET");
    return getResponse(paramString);
  }
  
  private static String getResponse(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection.getResponseCode() == 200)
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      StringBuilder localStringBuilder = new StringBuilder();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramHttpURLConnection.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localStringBuilder.append(new String(arrayOfByte, 0, i));
      }
      paramHttpURLConnection.close();
      return localStringBuilder.toString();
    }
    return null;
  }
  
  /* Error */
  public static boolean httpDownloadFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 22	com/tencent/ttpic/device/NetworkUtils:TAG	Ljava/lang/String;
    //   3: ldc 135
    //   5: invokestatic 87	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: new 30	java/net/URL
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 33	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: invokevirtual 37	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   19: checkcast 39	java/net/HttpURLConnection
    //   22: astore 6
    //   24: aload 6
    //   26: sipush 5000
    //   29: invokevirtual 43	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   32: aload 6
    //   34: ldc 96
    //   36: invokevirtual 99	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   39: new 137	java/io/File
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore_1
    //   48: aload_1
    //   49: invokevirtual 142	java/io/File:exists	()Z
    //   52: ifeq +16 -> 68
    //   55: getstatic 22	com/tencent/ttpic/device/NetworkUtils:TAG	Ljava/lang/String;
    //   58: ldc 144
    //   60: invokestatic 87	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_1
    //   64: invokevirtual 147	java/io/File:delete	()Z
    //   67: pop
    //   68: getstatic 22	com/tencent/ttpic/device/NetworkUtils:TAG	Ljava/lang/String;
    //   71: ldc 149
    //   73: invokestatic 87	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_1
    //   77: invokevirtual 152	java/io/File:createNewFile	()Z
    //   80: pop
    //   81: aload 6
    //   83: invokevirtual 111	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   86: astore_0
    //   87: new 154	java/io/FileOutputStream
    //   90: dup
    //   91: aload_1
    //   92: invokespecial 157	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   95: astore_1
    //   96: aload_1
    //   97: astore 4
    //   99: aload_0
    //   100: astore_3
    //   101: sipush 4096
    //   104: newarray byte
    //   106: astore 5
    //   108: aload_1
    //   109: astore 4
    //   111: aload_0
    //   112: astore_3
    //   113: aload_0
    //   114: aload 5
    //   116: invokevirtual 118	java/io/InputStream:read	([B)I
    //   119: istore_2
    //   120: iload_2
    //   121: iconst_m1
    //   122: if_icmpeq +72 -> 194
    //   125: aload_1
    //   126: astore 4
    //   128: aload_0
    //   129: astore_3
    //   130: aload_1
    //   131: aload 5
    //   133: iconst_0
    //   134: iload_2
    //   135: invokevirtual 162	java/io/OutputStream:write	([BII)V
    //   138: goto -30 -> 108
    //   141: astore 5
    //   143: aload_1
    //   144: astore 4
    //   146: aload_0
    //   147: astore_3
    //   148: getstatic 22	com/tencent/ttpic/device/NetworkUtils:TAG	Ljava/lang/String;
    //   151: ldc 164
    //   153: invokestatic 87	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload_1
    //   157: astore 4
    //   159: aload_0
    //   160: astore_3
    //   161: aload 5
    //   163: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   166: aload 6
    //   168: ifnull +8 -> 176
    //   171: aload 6
    //   173: invokevirtual 171	java/net/HttpURLConnection:disconnect	()V
    //   176: aload_0
    //   177: ifnull +7 -> 184
    //   180: aload_0
    //   181: invokevirtual 129	java/io/InputStream:close	()V
    //   184: aload_1
    //   185: ifnull +79 -> 264
    //   188: aload_1
    //   189: invokevirtual 172	java/io/OutputStream:close	()V
    //   192: iconst_0
    //   193: ireturn
    //   194: aload_1
    //   195: astore 4
    //   197: aload_0
    //   198: astore_3
    //   199: aload_1
    //   200: invokevirtual 175	java/io/OutputStream:flush	()V
    //   203: aload 6
    //   205: ifnull +8 -> 213
    //   208: aload 6
    //   210: invokevirtual 171	java/net/HttpURLConnection:disconnect	()V
    //   213: aload_0
    //   214: ifnull +7 -> 221
    //   217: aload_0
    //   218: invokevirtual 129	java/io/InputStream:close	()V
    //   221: aload_1
    //   222: invokevirtual 172	java/io/OutputStream:close	()V
    //   225: iconst_1
    //   226: ireturn
    //   227: aload 6
    //   229: ifnull +8 -> 237
    //   232: aload 6
    //   234: invokevirtual 171	java/net/HttpURLConnection:disconnect	()V
    //   237: aload_0
    //   238: ifnull +7 -> 245
    //   241: aload_0
    //   242: invokevirtual 129	java/io/InputStream:close	()V
    //   245: aload 4
    //   247: ifnull +8 -> 255
    //   250: aload 4
    //   252: invokevirtual 172	java/io/OutputStream:close	()V
    //   255: aload_1
    //   256: athrow
    //   257: astore_0
    //   258: aload_0
    //   259: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   262: iconst_0
    //   263: ireturn
    //   264: iconst_0
    //   265: ireturn
    //   266: astore_1
    //   267: aconst_null
    //   268: astore 4
    //   270: goto -43 -> 227
    //   273: astore_1
    //   274: aload_3
    //   275: astore_0
    //   276: goto -49 -> 227
    //   279: astore 5
    //   281: aconst_null
    //   282: astore_1
    //   283: aconst_null
    //   284: astore_0
    //   285: goto -142 -> 143
    //   288: astore 5
    //   290: aconst_null
    //   291: astore_1
    //   292: goto -149 -> 143
    //   295: astore_1
    //   296: aconst_null
    //   297: astore 4
    //   299: aconst_null
    //   300: astore_0
    //   301: goto -74 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramString1	String
    //   0	304	1	paramString2	String
    //   119	16	2	i	int
    //   100	175	3	str1	String
    //   97	201	4	str2	String
    //   106	26	5	arrayOfByte	byte[]
    //   141	21	5	localException1	Exception
    //   279	1	5	localException2	Exception
    //   288	1	5	localException3	Exception
    //   22	211	6	localHttpURLConnection	HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   101	108	141	java/lang/Exception
    //   113	120	141	java/lang/Exception
    //   130	138	141	java/lang/Exception
    //   199	203	141	java/lang/Exception
    //   8	68	257	java/io/IOException
    //   68	81	257	java/io/IOException
    //   171	176	257	java/io/IOException
    //   180	184	257	java/io/IOException
    //   188	192	257	java/io/IOException
    //   208	213	257	java/io/IOException
    //   217	221	257	java/io/IOException
    //   221	225	257	java/io/IOException
    //   232	237	257	java/io/IOException
    //   241	245	257	java/io/IOException
    //   250	255	257	java/io/IOException
    //   255	257	257	java/io/IOException
    //   87	96	266	finally
    //   101	108	273	finally
    //   113	120	273	finally
    //   130	138	273	finally
    //   148	156	273	finally
    //   161	166	273	finally
    //   199	203	273	finally
    //   81	87	279	java/lang/Exception
    //   87	96	288	java/lang/Exception
    //   81	87	295	finally
  }
  
  public static String post(String paramString, HashMap<String, String> paramHashMap)
  {
    return post(paramString, paramHashMap, 10000);
  }
  
  public static String post(String paramString, HashMap<String, String> paramHashMap, int paramInt)
  {
    paramString = buildConnection(paramString, paramInt);
    paramString.setRequestMethod("POST");
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      OutputStream localOutputStream = paramString.getOutputStream();
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(localOutputStream, "UTF-8"));
      StringBuilder localStringBuilder = new StringBuilder("");
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        if (localStringBuilder.indexOf("=") > 0) {
          localStringBuilder.append("&");
        }
        String str = (String)localIterator.next();
        localStringBuilder.append(URLEncoder.encode(str, "UTF-8")).append("=").append(URLEncoder.encode((String)paramHashMap.get(str), "UTF-8"));
      }
      localBufferedWriter.write(localStringBuilder.toString());
      localBufferedWriter.flush();
      localBufferedWriter.close();
      localOutputStream.close();
    }
    return getResponse(paramString);
  }
  
  /* Error */
  public static String unZip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 201
    //   2: astore 5
    //   4: new 247	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 248	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore 8
    //   14: aload 5
    //   16: astore_0
    //   17: aload 8
    //   19: ifnull +382 -> 401
    //   22: new 250	java/util/zip/ZipInputStream
    //   25: dup
    //   26: new 252	java/io/BufferedInputStream
    //   29: dup
    //   30: aload 8
    //   32: invokespecial 255	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: invokespecial 256	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore 9
    //   40: aconst_null
    //   41: astore_0
    //   42: aconst_null
    //   43: astore_3
    //   44: aload 9
    //   46: invokevirtual 260	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull +521 -> 574
    //   56: aload 4
    //   58: invokevirtual 265	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   61: astore 4
    //   63: aload 4
    //   65: ldc_w 267
    //   68: invokevirtual 271	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   71: ifne -27 -> 44
    //   74: new 137	java/io/File
    //   77: dup
    //   78: new 71	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   85: aload_1
    //   86: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 4
    //   91: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: astore 10
    //   102: aload 10
    //   104: invokevirtual 274	java/io/File:getParent	()Ljava/lang/String;
    //   107: astore 4
    //   109: aload 4
    //   111: ifnull -67 -> 44
    //   114: new 137	java/io/File
    //   117: dup
    //   118: aload 4
    //   120: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: astore 4
    //   125: aload 4
    //   127: invokevirtual 142	java/io/File:exists	()Z
    //   130: ifne +9 -> 139
    //   133: aload 4
    //   135: invokevirtual 277	java/io/File:mkdirs	()Z
    //   138: pop
    //   139: new 154	java/io/FileOutputStream
    //   142: dup
    //   143: aload 10
    //   145: invokespecial 157	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   148: astore 4
    //   150: new 279	java/io/BufferedOutputStream
    //   153: dup
    //   154: aload 4
    //   156: sipush 4096
    //   159: invokespecial 282	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   162: astore_3
    //   163: aload_3
    //   164: astore 7
    //   166: aload 4
    //   168: astore 6
    //   170: sipush 4096
    //   173: newarray byte
    //   175: astore_0
    //   176: aload_3
    //   177: astore 7
    //   179: aload 4
    //   181: astore 6
    //   183: aload 9
    //   185: aload_0
    //   186: iconst_0
    //   187: sipush 4096
    //   190: invokevirtual 285	java/util/zip/ZipInputStream:read	([BII)I
    //   193: istore_2
    //   194: iload_2
    //   195: iconst_m1
    //   196: if_icmpeq +73 -> 269
    //   199: aload_3
    //   200: astore 7
    //   202: aload 4
    //   204: astore 6
    //   206: aload_3
    //   207: aload_0
    //   208: iconst_0
    //   209: iload_2
    //   210: invokevirtual 286	java/io/BufferedOutputStream:write	([BII)V
    //   213: goto -37 -> 176
    //   216: astore 6
    //   218: aload_3
    //   219: astore_0
    //   220: aload 6
    //   222: astore_3
    //   223: aload_0
    //   224: astore 7
    //   226: aload 4
    //   228: astore 6
    //   230: aload_3
    //   231: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   234: aload_0
    //   235: ifnull +7 -> 242
    //   238: aload_0
    //   239: invokevirtual 287	java/io/BufferedOutputStream:close	()V
    //   242: aload 4
    //   244: ifnull +8 -> 252
    //   247: aload 4
    //   249: invokevirtual 288	java/io/FileOutputStream:close	()V
    //   252: aload 4
    //   254: astore_3
    //   255: goto -211 -> 44
    //   258: astore_0
    //   259: aload_0
    //   260: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   263: aconst_null
    //   264: astore 8
    //   266: goto -252 -> 14
    //   269: aload_3
    //   270: astore 7
    //   272: aload 4
    //   274: astore 6
    //   276: aload_3
    //   277: invokevirtual 289	java/io/BufferedOutputStream:flush	()V
    //   280: aload_3
    //   281: astore 7
    //   283: aload 4
    //   285: astore 6
    //   287: aload 10
    //   289: invokevirtual 292	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   292: astore_0
    //   293: aload_3
    //   294: invokevirtual 287	java/io/BufferedOutputStream:close	()V
    //   297: aload 4
    //   299: invokevirtual 288	java/io/FileOutputStream:close	()V
    //   302: aload_0
    //   303: astore 5
    //   305: aload_3
    //   306: astore_0
    //   307: aload 4
    //   309: astore_3
    //   310: goto -266 -> 44
    //   313: astore 5
    //   315: aload 5
    //   317: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   320: aload_0
    //   321: astore 5
    //   323: aload_3
    //   324: astore_0
    //   325: aload 4
    //   327: astore_3
    //   328: goto -284 -> 44
    //   331: astore 5
    //   333: aload 5
    //   335: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   338: aload 4
    //   340: invokevirtual 288	java/io/FileOutputStream:close	()V
    //   343: aload_0
    //   344: astore 5
    //   346: aload_3
    //   347: astore_0
    //   348: aload 4
    //   350: astore_3
    //   351: goto -307 -> 44
    //   354: astore 5
    //   356: aload 5
    //   358: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   361: aload_0
    //   362: astore 5
    //   364: aload_3
    //   365: astore_0
    //   366: aload 4
    //   368: astore_3
    //   369: goto -325 -> 44
    //   372: astore_1
    //   373: aload 4
    //   375: invokevirtual 288	java/io/FileOutputStream:close	()V
    //   378: aload_1
    //   379: athrow
    //   380: astore_1
    //   381: aload_0
    //   382: astore 5
    //   384: aload_1
    //   385: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   388: aload 9
    //   390: invokevirtual 293	java/util/zip/ZipInputStream:close	()V
    //   393: aload 8
    //   395: invokevirtual 294	java/io/FileInputStream:close	()V
    //   398: aload 5
    //   400: astore_0
    //   401: aload_0
    //   402: areturn
    //   403: astore_3
    //   404: aload_3
    //   405: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   408: goto -30 -> 378
    //   411: astore_0
    //   412: aload 9
    //   414: invokevirtual 293	java/util/zip/ZipInputStream:close	()V
    //   417: aload 8
    //   419: invokevirtual 294	java/io/FileInputStream:close	()V
    //   422: aload_0
    //   423: athrow
    //   424: astore_3
    //   425: aload_3
    //   426: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   429: aload 4
    //   431: astore_3
    //   432: goto -388 -> 44
    //   435: astore_3
    //   436: aload_3
    //   437: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   440: aload 4
    //   442: ifnull +8 -> 450
    //   445: aload 4
    //   447: invokevirtual 288	java/io/FileOutputStream:close	()V
    //   450: aload 4
    //   452: astore_3
    //   453: goto -409 -> 44
    //   456: astore_3
    //   457: aload_3
    //   458: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   461: aload 4
    //   463: astore_3
    //   464: goto -420 -> 44
    //   467: astore_0
    //   468: aload 4
    //   470: ifnull +8 -> 478
    //   473: aload 4
    //   475: invokevirtual 288	java/io/FileOutputStream:close	()V
    //   478: aload_0
    //   479: athrow
    //   480: astore_1
    //   481: aload_1
    //   482: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   485: goto -7 -> 478
    //   488: astore_1
    //   489: aload_3
    //   490: astore 4
    //   492: aload_0
    //   493: astore 7
    //   495: aload_1
    //   496: astore_0
    //   497: aload 7
    //   499: ifnull +8 -> 507
    //   502: aload 7
    //   504: invokevirtual 287	java/io/BufferedOutputStream:close	()V
    //   507: aload 4
    //   509: ifnull +8 -> 517
    //   512: aload 4
    //   514: invokevirtual 288	java/io/FileOutputStream:close	()V
    //   517: aload_0
    //   518: athrow
    //   519: astore_1
    //   520: aload_1
    //   521: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   524: goto -7 -> 517
    //   527: astore_1
    //   528: aload_1
    //   529: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   532: aload 4
    //   534: ifnull -17 -> 517
    //   537: aload 4
    //   539: invokevirtual 288	java/io/FileOutputStream:close	()V
    //   542: goto -25 -> 517
    //   545: astore_1
    //   546: aload_1
    //   547: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   550: goto -33 -> 517
    //   553: astore_0
    //   554: aload 4
    //   556: ifnull +8 -> 564
    //   559: aload 4
    //   561: invokevirtual 288	java/io/FileOutputStream:close	()V
    //   564: aload_0
    //   565: athrow
    //   566: astore_1
    //   567: aload_1
    //   568: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   571: goto -7 -> 564
    //   574: aload 9
    //   576: invokevirtual 293	java/util/zip/ZipInputStream:close	()V
    //   579: aload 8
    //   581: invokevirtual 294	java/io/FileInputStream:close	()V
    //   584: aload 5
    //   586: areturn
    //   587: astore_0
    //   588: aload_0
    //   589: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   592: aload 5
    //   594: areturn
    //   595: astore_0
    //   596: aload_0
    //   597: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   600: aload 8
    //   602: invokevirtual 294	java/io/FileInputStream:close	()V
    //   605: aload 5
    //   607: areturn
    //   608: astore_0
    //   609: aload_0
    //   610: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   613: aload 5
    //   615: areturn
    //   616: astore_0
    //   617: aload 8
    //   619: invokevirtual 294	java/io/FileInputStream:close	()V
    //   622: aload_0
    //   623: athrow
    //   624: astore_1
    //   625: aload_1
    //   626: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   629: goto -7 -> 622
    //   632: astore_0
    //   633: aload_0
    //   634: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   637: aload 5
    //   639: areturn
    //   640: astore_0
    //   641: aload_0
    //   642: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   645: aload 8
    //   647: invokevirtual 294	java/io/FileInputStream:close	()V
    //   650: aload 5
    //   652: areturn
    //   653: astore_0
    //   654: aload_0
    //   655: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   658: aload 5
    //   660: areturn
    //   661: astore_0
    //   662: aload 8
    //   664: invokevirtual 294	java/io/FileInputStream:close	()V
    //   667: aload_0
    //   668: athrow
    //   669: astore_1
    //   670: aload_1
    //   671: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   674: goto -7 -> 667
    //   677: astore_1
    //   678: aload_1
    //   679: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   682: goto -260 -> 422
    //   685: astore_1
    //   686: aload_1
    //   687: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   690: aload 8
    //   692: invokevirtual 294	java/io/FileInputStream:close	()V
    //   695: goto -273 -> 422
    //   698: astore_1
    //   699: aload_1
    //   700: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   703: goto -281 -> 422
    //   706: astore_0
    //   707: aload 8
    //   709: invokevirtual 294	java/io/FileInputStream:close	()V
    //   712: aload_0
    //   713: athrow
    //   714: astore_1
    //   715: aload_1
    //   716: invokestatic 168	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   719: goto -7 -> 712
    //   722: astore_1
    //   723: aload_0
    //   724: astore 7
    //   726: aload_1
    //   727: astore_0
    //   728: goto -231 -> 497
    //   731: astore_0
    //   732: aload 6
    //   734: astore 4
    //   736: goto -239 -> 497
    //   739: astore 6
    //   741: aload_3
    //   742: astore 4
    //   744: aload 6
    //   746: astore_3
    //   747: goto -524 -> 223
    //   750: astore_3
    //   751: goto -528 -> 223
    //   754: astore_1
    //   755: goto -371 -> 384
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	758	0	paramString1	String
    //   0	758	1	paramString2	String
    //   193	17	2	i	int
    //   43	326	3	localObject1	Object
    //   403	2	3	localException1	Exception
    //   424	2	3	localException2	Exception
    //   431	1	3	localObject2	Object
    //   435	2	3	localException3	Exception
    //   452	1	3	localObject3	Object
    //   456	2	3	localException4	Exception
    //   463	284	3	localObject4	Object
    //   750	1	3	localException5	Exception
    //   49	694	4	localObject5	Object
    //   2	302	5	str1	String
    //   313	3	5	localException6	Exception
    //   321	1	5	str2	String
    //   331	3	5	localException7	Exception
    //   344	1	5	str3	String
    //   354	3	5	localException8	Exception
    //   362	297	5	str4	String
    //   168	37	6	localObject6	Object
    //   216	5	6	localException9	Exception
    //   228	505	6	localObject7	Object
    //   739	6	6	localException10	Exception
    //   164	561	7	localObject8	Object
    //   12	696	8	localFileInputStream	java.io.FileInputStream
    //   38	537	9	localZipInputStream	java.util.zip.ZipInputStream
    //   100	188	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   170	176	216	java/lang/Exception
    //   183	194	216	java/lang/Exception
    //   206	213	216	java/lang/Exception
    //   276	280	216	java/lang/Exception
    //   287	293	216	java/lang/Exception
    //   4	14	258	java/io/FileNotFoundException
    //   297	302	313	java/lang/Exception
    //   293	297	331	java/lang/Exception
    //   338	343	354	java/lang/Exception
    //   293	297	372	finally
    //   333	338	372	finally
    //   315	320	380	java/lang/Exception
    //   356	361	380	java/lang/Exception
    //   378	380	380	java/lang/Exception
    //   404	408	380	java/lang/Exception
    //   373	378	403	java/lang/Exception
    //   44	51	411	finally
    //   56	109	411	finally
    //   114	139	411	finally
    //   247	252	411	finally
    //   297	302	411	finally
    //   315	320	411	finally
    //   338	343	411	finally
    //   356	361	411	finally
    //   373	378	411	finally
    //   378	380	411	finally
    //   384	388	411	finally
    //   404	408	411	finally
    //   425	429	411	finally
    //   445	450	411	finally
    //   457	461	411	finally
    //   473	478	411	finally
    //   478	480	411	finally
    //   481	485	411	finally
    //   512	517	411	finally
    //   517	519	411	finally
    //   520	524	411	finally
    //   537	542	411	finally
    //   546	550	411	finally
    //   559	564	411	finally
    //   564	566	411	finally
    //   567	571	411	finally
    //   247	252	424	java/lang/Exception
    //   238	242	435	java/lang/Exception
    //   445	450	456	java/lang/Exception
    //   238	242	467	finally
    //   436	440	467	finally
    //   473	478	480	java/lang/Exception
    //   139	150	488	finally
    //   512	517	519	java/lang/Exception
    //   502	507	527	java/lang/Exception
    //   537	542	545	java/lang/Exception
    //   502	507	553	finally
    //   528	532	553	finally
    //   559	564	566	java/lang/Exception
    //   579	584	587	java/io/IOException
    //   574	579	595	java/io/IOException
    //   600	605	608	java/io/IOException
    //   574	579	616	finally
    //   596	600	616	finally
    //   617	622	624	java/io/IOException
    //   393	398	632	java/io/IOException
    //   388	393	640	java/io/IOException
    //   645	650	653	java/io/IOException
    //   388	393	661	finally
    //   641	645	661	finally
    //   662	667	669	java/io/IOException
    //   417	422	677	java/io/IOException
    //   412	417	685	java/io/IOException
    //   690	695	698	java/io/IOException
    //   412	417	706	finally
    //   686	690	706	finally
    //   707	712	714	java/io/IOException
    //   150	163	722	finally
    //   170	176	731	finally
    //   183	194	731	finally
    //   206	213	731	finally
    //   230	234	731	finally
    //   276	280	731	finally
    //   287	293	731	finally
    //   139	150	739	java/lang/Exception
    //   150	163	750	java/lang/Exception
    //   44	51	754	java/lang/Exception
    //   56	109	754	java/lang/Exception
    //   114	139	754	java/lang/Exception
    //   425	429	754	java/lang/Exception
    //   457	461	754	java/lang/Exception
    //   478	480	754	java/lang/Exception
    //   481	485	754	java/lang/Exception
    //   517	519	754	java/lang/Exception
    //   520	524	754	java/lang/Exception
    //   546	550	754	java/lang/Exception
    //   564	566	754	java/lang/Exception
    //   567	571	754	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.device.NetworkUtils
 * JD-Core Version:    0.7.0.1
 */