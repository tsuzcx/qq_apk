package com.tencent.ttpic.device;

import com.tencent.matrix.trace.core.AppMethodBeat;
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

public class DeviceUpdate
{
  private static final String CHARSET_UTF8 = "UTF-8";
  private static final int DEFAULT_TIMEOUT_MILLIS = 10000;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(49867);
    TAG = DeviceUpdate.class.getSimpleName();
    AppMethodBeat.o(49867);
  }
  
  private static HttpURLConnection buildConnection(String paramString, int paramInt)
  {
    AppMethodBeat.i(49864);
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setConnectTimeout(paramInt);
    paramString.setReadTimeout(paramInt);
    AppMethodBeat.o(49864);
    return paramString;
  }
  
  public static String checkConfigVersion(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(49859);
    Object localObject = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("PackageName", paramString2);
    localHashMap.put("camCoreVersion", paramString3);
    localHashMap.put("AppId", paramString4);
    localHashMap.put("AppVersion", paramString5);
    try
    {
      paramString1 = post(paramString1, localHashMap);
      AppMethodBeat.o(49859);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        LogUtils.d(TAG, "checkConfigVersion Exception! e = ".concat(String.valueOf(paramString1)));
        paramString1 = localObject;
      }
    }
  }
  
  public static String get(String paramString)
  {
    AppMethodBeat.i(49860);
    paramString = get(paramString, 10000);
    AppMethodBeat.o(49860);
    return paramString;
  }
  
  public static String get(String paramString, int paramInt)
  {
    AppMethodBeat.i(49861);
    paramString = buildConnection(paramString, paramInt);
    paramString.setRequestMethod("GET");
    paramString = getResponse(paramString);
    AppMethodBeat.o(49861);
    return paramString;
  }
  
  private static String getResponse(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(49865);
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
      paramHttpURLConnection = localStringBuilder.toString();
      AppMethodBeat.o(49865);
      return paramHttpURLConnection;
    }
    AppMethodBeat.o(49865);
    return null;
  }
  
  /* Error */
  public static boolean httpDownloadFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 151
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 29	com/tencent/ttpic/device/DeviceUpdate:TAG	Ljava/lang/String;
    //   8: ldc 153
    //   10: invokestatic 98	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: new 41	java/net/URL
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 44	java/net/URL:<init>	(Ljava/lang/String;)V
    //   21: invokevirtual 48	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   24: checkcast 50	java/net/HttpURLConnection
    //   27: astore 7
    //   29: aload 7
    //   31: sipush 5000
    //   34: invokevirtual 53	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   37: aload 7
    //   39: ldc 108
    //   41: invokevirtual 111	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   44: new 155	java/io/File
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 160	java/io/File:exists	()Z
    //   57: ifeq +16 -> 73
    //   60: getstatic 29	com/tencent/ttpic/device/DeviceUpdate:TAG	Ljava/lang/String;
    //   63: ldc 162
    //   65: invokestatic 98	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_1
    //   69: invokevirtual 165	java/io/File:delete	()Z
    //   72: pop
    //   73: getstatic 29	com/tencent/ttpic/device/DeviceUpdate:TAG	Ljava/lang/String;
    //   76: ldc 167
    //   78: invokestatic 98	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_1
    //   82: invokevirtual 170	java/io/File:createNewFile	()Z
    //   85: pop
    //   86: aload 7
    //   88: invokevirtual 124	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   91: astore_0
    //   92: new 172	java/io/FileOutputStream
    //   95: dup
    //   96: aload_1
    //   97: invokespecial 175	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   100: astore_1
    //   101: aload_1
    //   102: astore 5
    //   104: aload_0
    //   105: astore 4
    //   107: sipush 4096
    //   110: newarray byte
    //   112: astore 6
    //   114: aload_1
    //   115: astore 5
    //   117: aload_0
    //   118: astore 4
    //   120: aload_0
    //   121: aload 6
    //   123: invokevirtual 133	java/io/InputStream:read	([B)I
    //   126: istore_2
    //   127: iload_2
    //   128: iconst_m1
    //   129: if_icmpeq +82 -> 211
    //   132: aload_1
    //   133: astore 5
    //   135: aload_0
    //   136: astore 4
    //   138: aload_1
    //   139: aload 6
    //   141: iconst_0
    //   142: iload_2
    //   143: invokevirtual 180	java/io/OutputStream:write	([BII)V
    //   146: goto -32 -> 114
    //   149: astore 6
    //   151: aload_1
    //   152: astore 5
    //   154: aload_0
    //   155: astore 4
    //   157: getstatic 29	com/tencent/ttpic/device/DeviceUpdate:TAG	Ljava/lang/String;
    //   160: ldc 182
    //   162: invokestatic 98	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_1
    //   166: astore 5
    //   168: aload_0
    //   169: astore 4
    //   171: aload 6
    //   173: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   176: aload 7
    //   178: ifnull +8 -> 186
    //   181: aload 7
    //   183: invokevirtual 189	java/net/HttpURLConnection:disconnect	()V
    //   186: aload_0
    //   187: ifnull +7 -> 194
    //   190: aload_0
    //   191: invokevirtual 143	java/io/InputStream:close	()V
    //   194: aload_1
    //   195: ifnull +112 -> 307
    //   198: aload_1
    //   199: invokevirtual 190	java/io/OutputStream:close	()V
    //   202: iconst_0
    //   203: istore_3
    //   204: ldc 151
    //   206: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: iload_3
    //   210: ireturn
    //   211: aload_1
    //   212: astore 5
    //   214: aload_0
    //   215: astore 4
    //   217: aload_1
    //   218: invokevirtual 193	java/io/OutputStream:flush	()V
    //   221: aload_1
    //   222: astore 5
    //   224: aload_0
    //   225: astore 4
    //   227: getstatic 29	com/tencent/ttpic/device/DeviceUpdate:TAG	Ljava/lang/String;
    //   230: ldc 195
    //   232: invokestatic 98	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload 7
    //   237: ifnull +8 -> 245
    //   240: aload 7
    //   242: invokevirtual 189	java/net/HttpURLConnection:disconnect	()V
    //   245: aload_0
    //   246: ifnull +7 -> 253
    //   249: aload_0
    //   250: invokevirtual 143	java/io/InputStream:close	()V
    //   253: aload_1
    //   254: invokevirtual 190	java/io/OutputStream:close	()V
    //   257: iconst_1
    //   258: istore_3
    //   259: goto -55 -> 204
    //   262: aload 7
    //   264: ifnull +8 -> 272
    //   267: aload 7
    //   269: invokevirtual 189	java/net/HttpURLConnection:disconnect	()V
    //   272: aload_0
    //   273: ifnull +7 -> 280
    //   276: aload_0
    //   277: invokevirtual 143	java/io/InputStream:close	()V
    //   280: aload 5
    //   282: ifnull +8 -> 290
    //   285: aload 5
    //   287: invokevirtual 190	java/io/OutputStream:close	()V
    //   290: ldc 151
    //   292: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   295: aload_1
    //   296: athrow
    //   297: astore_0
    //   298: aload_0
    //   299: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   302: iconst_0
    //   303: istore_3
    //   304: goto -100 -> 204
    //   307: iconst_0
    //   308: istore_3
    //   309: goto -105 -> 204
    //   312: astore_1
    //   313: aconst_null
    //   314: astore 5
    //   316: goto -54 -> 262
    //   319: astore_1
    //   320: aload 4
    //   322: astore_0
    //   323: goto -61 -> 262
    //   326: astore 6
    //   328: aconst_null
    //   329: astore_1
    //   330: aconst_null
    //   331: astore_0
    //   332: goto -181 -> 151
    //   335: astore 6
    //   337: aconst_null
    //   338: astore_1
    //   339: goto -188 -> 151
    //   342: astore_1
    //   343: aconst_null
    //   344: astore 5
    //   346: aconst_null
    //   347: astore_0
    //   348: goto -86 -> 262
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramString1	String
    //   0	351	1	paramString2	String
    //   126	17	2	i	int
    //   203	106	3	bool	boolean
    //   105	216	4	str1	String
    //   102	243	5	str2	String
    //   112	28	6	arrayOfByte	byte[]
    //   149	23	6	localException1	Exception
    //   326	1	6	localException2	Exception
    //   335	1	6	localException3	Exception
    //   27	241	7	localHttpURLConnection	HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   107	114	149	java/lang/Exception
    //   120	127	149	java/lang/Exception
    //   138	146	149	java/lang/Exception
    //   217	221	149	java/lang/Exception
    //   227	235	149	java/lang/Exception
    //   13	73	297	java/io/IOException
    //   73	86	297	java/io/IOException
    //   181	186	297	java/io/IOException
    //   190	194	297	java/io/IOException
    //   198	202	297	java/io/IOException
    //   240	245	297	java/io/IOException
    //   249	253	297	java/io/IOException
    //   253	257	297	java/io/IOException
    //   267	272	297	java/io/IOException
    //   276	280	297	java/io/IOException
    //   285	290	297	java/io/IOException
    //   290	297	297	java/io/IOException
    //   92	101	312	finally
    //   107	114	319	finally
    //   120	127	319	finally
    //   138	146	319	finally
    //   157	165	319	finally
    //   171	176	319	finally
    //   217	221	319	finally
    //   227	235	319	finally
    //   86	92	326	java/lang/Exception
    //   92	101	335	java/lang/Exception
    //   86	92	342	finally
  }
  
  public static String post(String paramString, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(49862);
    paramString = post(paramString, paramHashMap, 10000);
    AppMethodBeat.o(49862);
    return paramString;
  }
  
  public static String post(String paramString, HashMap<String, String> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(49863);
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
    paramString = getResponse(paramString);
    AppMethodBeat.o(49863);
    return paramString;
  }
  
  /* Error */
  public static String unZip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 269
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 223
    //   8: astore 5
    //   10: new 271	java/io/FileInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 272	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: astore 8
    //   20: aload 5
    //   22: astore 4
    //   24: aload 8
    //   26: ifnull +389 -> 415
    //   29: new 274	java/util/zip/ZipInputStream
    //   32: dup
    //   33: new 276	java/io/BufferedInputStream
    //   36: dup
    //   37: aload 8
    //   39: invokespecial 279	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: invokespecial 280	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore 9
    //   47: aconst_null
    //   48: astore_0
    //   49: aconst_null
    //   50: astore_3
    //   51: aload 5
    //   53: astore 4
    //   55: aload 9
    //   57: invokevirtual 284	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   60: astore 5
    //   62: aload 5
    //   64: ifnull +555 -> 619
    //   67: aload 5
    //   69: invokevirtual 289	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   72: astore 5
    //   74: aload 5
    //   76: ldc_w 291
    //   79: invokevirtual 295	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   82: ifne -27 -> 55
    //   85: new 155	java/io/File
    //   88: dup
    //   89: new 126	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   96: aload_1
    //   97: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload 5
    //   102: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   111: astore 10
    //   113: aload 10
    //   115: invokevirtual 298	java/io/File:getParent	()Ljava/lang/String;
    //   118: astore 5
    //   120: aload 5
    //   122: ifnull -67 -> 55
    //   125: new 155	java/io/File
    //   128: dup
    //   129: aload 5
    //   131: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   134: astore 5
    //   136: aload 5
    //   138: invokevirtual 160	java/io/File:exists	()Z
    //   141: ifne +9 -> 150
    //   144: aload 5
    //   146: invokevirtual 301	java/io/File:mkdirs	()Z
    //   149: pop
    //   150: new 172	java/io/FileOutputStream
    //   153: dup
    //   154: aload 10
    //   156: invokespecial 175	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   159: astore 5
    //   161: new 303	java/io/BufferedOutputStream
    //   164: dup
    //   165: aload 5
    //   167: sipush 4096
    //   170: invokespecial 306	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   173: astore_3
    //   174: aload_3
    //   175: astore 7
    //   177: aload 5
    //   179: astore 6
    //   181: sipush 4096
    //   184: newarray byte
    //   186: astore_0
    //   187: aload_3
    //   188: astore 7
    //   190: aload 5
    //   192: astore 6
    //   194: aload 9
    //   196: aload_0
    //   197: iconst_0
    //   198: sipush 4096
    //   201: invokevirtual 309	java/util/zip/ZipInputStream:read	([BII)I
    //   204: istore_2
    //   205: iload_2
    //   206: iconst_m1
    //   207: if_icmpeq +73 -> 280
    //   210: aload_3
    //   211: astore 7
    //   213: aload 5
    //   215: astore 6
    //   217: aload_3
    //   218: aload_0
    //   219: iconst_0
    //   220: iload_2
    //   221: invokevirtual 310	java/io/BufferedOutputStream:write	([BII)V
    //   224: goto -37 -> 187
    //   227: astore 6
    //   229: aload_3
    //   230: astore_0
    //   231: aload 6
    //   233: astore_3
    //   234: aload_0
    //   235: astore 7
    //   237: aload 5
    //   239: astore 6
    //   241: aload_3
    //   242: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   245: aload_0
    //   246: ifnull +7 -> 253
    //   249: aload_0
    //   250: invokevirtual 311	java/io/BufferedOutputStream:close	()V
    //   253: aload 5
    //   255: ifnull +8 -> 263
    //   258: aload 5
    //   260: invokevirtual 312	java/io/FileOutputStream:close	()V
    //   263: aload 5
    //   265: astore_3
    //   266: goto -211 -> 55
    //   269: astore_0
    //   270: aload_0
    //   271: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   274: aconst_null
    //   275: astore 8
    //   277: goto -257 -> 20
    //   280: aload_3
    //   281: astore 7
    //   283: aload 5
    //   285: astore 6
    //   287: aload_3
    //   288: invokevirtual 313	java/io/BufferedOutputStream:flush	()V
    //   291: aload_3
    //   292: astore 7
    //   294: aload 5
    //   296: astore 6
    //   298: aload 10
    //   300: invokevirtual 316	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   303: astore_0
    //   304: aload_3
    //   305: invokevirtual 311	java/io/BufferedOutputStream:close	()V
    //   308: aload 5
    //   310: invokevirtual 312	java/io/FileOutputStream:close	()V
    //   313: aload_0
    //   314: astore 4
    //   316: aload_3
    //   317: astore_0
    //   318: aload 5
    //   320: astore_3
    //   321: goto -266 -> 55
    //   324: astore 4
    //   326: aload 4
    //   328: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   331: aload_0
    //   332: astore 4
    //   334: aload_3
    //   335: astore_0
    //   336: aload 5
    //   338: astore_3
    //   339: goto -284 -> 55
    //   342: astore 4
    //   344: aload 4
    //   346: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   349: aload 5
    //   351: invokevirtual 312	java/io/FileOutputStream:close	()V
    //   354: aload_0
    //   355: astore 4
    //   357: aload_3
    //   358: astore_0
    //   359: aload 5
    //   361: astore_3
    //   362: goto -307 -> 55
    //   365: astore 4
    //   367: aload 4
    //   369: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   372: aload_0
    //   373: astore 4
    //   375: aload_3
    //   376: astore_0
    //   377: aload 5
    //   379: astore_3
    //   380: goto -325 -> 55
    //   383: astore_1
    //   384: aload 5
    //   386: invokevirtual 312	java/io/FileOutputStream:close	()V
    //   389: ldc_w 269
    //   392: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   395: aload_1
    //   396: athrow
    //   397: astore_1
    //   398: aload_0
    //   399: astore 4
    //   401: aload_1
    //   402: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   405: aload 9
    //   407: invokevirtual 317	java/util/zip/ZipInputStream:close	()V
    //   410: aload 8
    //   412: invokevirtual 318	java/io/FileInputStream:close	()V
    //   415: ldc_w 269
    //   418: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: aload 4
    //   423: areturn
    //   424: astore_3
    //   425: aload_3
    //   426: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   429: goto -40 -> 389
    //   432: astore_0
    //   433: aload 9
    //   435: invokevirtual 317	java/util/zip/ZipInputStream:close	()V
    //   438: aload 8
    //   440: invokevirtual 318	java/io/FileInputStream:close	()V
    //   443: ldc_w 269
    //   446: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   449: aload_0
    //   450: athrow
    //   451: astore_3
    //   452: aload_3
    //   453: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   456: aload 5
    //   458: astore_3
    //   459: goto -404 -> 55
    //   462: astore_3
    //   463: aload_3
    //   464: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   467: aload 5
    //   469: ifnull +8 -> 477
    //   472: aload 5
    //   474: invokevirtual 312	java/io/FileOutputStream:close	()V
    //   477: aload 5
    //   479: astore_3
    //   480: goto -425 -> 55
    //   483: astore_3
    //   484: aload_3
    //   485: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   488: aload 5
    //   490: astore_3
    //   491: goto -436 -> 55
    //   494: astore_0
    //   495: aload 5
    //   497: ifnull +8 -> 505
    //   500: aload 5
    //   502: invokevirtual 312	java/io/FileOutputStream:close	()V
    //   505: ldc_w 269
    //   508: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   511: aload_0
    //   512: athrow
    //   513: astore_1
    //   514: aload_1
    //   515: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   518: goto -13 -> 505
    //   521: astore_1
    //   522: aload_3
    //   523: astore 5
    //   525: aload_0
    //   526: astore 7
    //   528: aload_1
    //   529: astore_0
    //   530: aload 7
    //   532: ifnull +8 -> 540
    //   535: aload 7
    //   537: invokevirtual 311	java/io/BufferedOutputStream:close	()V
    //   540: aload 5
    //   542: ifnull +8 -> 550
    //   545: aload 5
    //   547: invokevirtual 312	java/io/FileOutputStream:close	()V
    //   550: ldc_w 269
    //   553: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   556: aload_0
    //   557: athrow
    //   558: astore_1
    //   559: aload_1
    //   560: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   563: goto -13 -> 550
    //   566: astore_1
    //   567: aload_1
    //   568: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   571: aload 5
    //   573: ifnull -23 -> 550
    //   576: aload 5
    //   578: invokevirtual 312	java/io/FileOutputStream:close	()V
    //   581: goto -31 -> 550
    //   584: astore_1
    //   585: aload_1
    //   586: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   589: goto -39 -> 550
    //   592: astore_0
    //   593: aload 5
    //   595: ifnull +8 -> 603
    //   598: aload 5
    //   600: invokevirtual 312	java/io/FileOutputStream:close	()V
    //   603: ldc_w 269
    //   606: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   609: aload_0
    //   610: athrow
    //   611: astore_1
    //   612: aload_1
    //   613: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   616: goto -13 -> 603
    //   619: aload 9
    //   621: invokevirtual 317	java/util/zip/ZipInputStream:close	()V
    //   624: aload 8
    //   626: invokevirtual 318	java/io/FileInputStream:close	()V
    //   629: goto -214 -> 415
    //   632: astore_0
    //   633: aload_0
    //   634: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   637: goto -222 -> 415
    //   640: astore_0
    //   641: aload_0
    //   642: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   645: aload 8
    //   647: invokevirtual 318	java/io/FileInputStream:close	()V
    //   650: goto -235 -> 415
    //   653: astore_0
    //   654: aload_0
    //   655: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   658: goto -243 -> 415
    //   661: astore_0
    //   662: aload 8
    //   664: invokevirtual 318	java/io/FileInputStream:close	()V
    //   667: ldc_w 269
    //   670: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   673: aload_0
    //   674: athrow
    //   675: astore_1
    //   676: aload_1
    //   677: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   680: goto -13 -> 667
    //   683: astore_0
    //   684: aload_0
    //   685: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   688: goto -273 -> 415
    //   691: astore_0
    //   692: aload_0
    //   693: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   696: aload 8
    //   698: invokevirtual 318	java/io/FileInputStream:close	()V
    //   701: goto -286 -> 415
    //   704: astore_0
    //   705: aload_0
    //   706: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   709: goto -294 -> 415
    //   712: astore_0
    //   713: aload 8
    //   715: invokevirtual 318	java/io/FileInputStream:close	()V
    //   718: ldc_w 269
    //   721: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   724: aload_0
    //   725: athrow
    //   726: astore_1
    //   727: aload_1
    //   728: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   731: goto -13 -> 718
    //   734: astore_1
    //   735: aload_1
    //   736: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   739: goto -296 -> 443
    //   742: astore_1
    //   743: aload_1
    //   744: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   747: aload 8
    //   749: invokevirtual 318	java/io/FileInputStream:close	()V
    //   752: goto -309 -> 443
    //   755: astore_1
    //   756: aload_1
    //   757: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   760: goto -317 -> 443
    //   763: astore_0
    //   764: aload 8
    //   766: invokevirtual 318	java/io/FileInputStream:close	()V
    //   769: ldc_w 269
    //   772: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   775: aload_0
    //   776: athrow
    //   777: astore_1
    //   778: aload_1
    //   779: invokestatic 186	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   782: goto -13 -> 769
    //   785: astore_1
    //   786: aload_0
    //   787: astore 7
    //   789: aload_1
    //   790: astore_0
    //   791: goto -261 -> 530
    //   794: astore_0
    //   795: aload 6
    //   797: astore 5
    //   799: goto -269 -> 530
    //   802: astore 6
    //   804: aload_3
    //   805: astore 5
    //   807: aload 6
    //   809: astore_3
    //   810: goto -576 -> 234
    //   813: astore_3
    //   814: goto -580 -> 234
    //   817: astore_1
    //   818: goto -417 -> 401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	821	0	paramString1	String
    //   0	821	1	paramString2	String
    //   204	17	2	i	int
    //   50	330	3	localObject1	Object
    //   424	2	3	localException1	Exception
    //   451	2	3	localException2	Exception
    //   458	1	3	localObject2	Object
    //   462	2	3	localException3	Exception
    //   479	1	3	localObject3	Object
    //   483	2	3	localException4	Exception
    //   490	320	3	localObject4	Object
    //   813	1	3	localException5	Exception
    //   22	293	4	localObject5	Object
    //   324	3	4	localException6	Exception
    //   332	1	4	str1	String
    //   342	3	4	localException7	Exception
    //   355	1	4	str2	String
    //   365	3	4	localException8	Exception
    //   373	49	4	str3	String
    //   8	798	5	localObject6	Object
    //   179	37	6	localObject7	Object
    //   227	5	6	localException9	Exception
    //   239	557	6	localObject8	Object
    //   802	6	6	localException10	Exception
    //   175	613	7	localObject9	Object
    //   18	747	8	localFileInputStream	java.io.FileInputStream
    //   45	575	9	localZipInputStream	java.util.zip.ZipInputStream
    //   111	188	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   181	187	227	java/lang/Exception
    //   194	205	227	java/lang/Exception
    //   217	224	227	java/lang/Exception
    //   287	291	227	java/lang/Exception
    //   298	304	227	java/lang/Exception
    //   10	20	269	java/io/FileNotFoundException
    //   308	313	324	java/lang/Exception
    //   304	308	342	java/lang/Exception
    //   349	354	365	java/lang/Exception
    //   304	308	383	finally
    //   344	349	383	finally
    //   326	331	397	java/lang/Exception
    //   367	372	397	java/lang/Exception
    //   389	397	397	java/lang/Exception
    //   425	429	397	java/lang/Exception
    //   384	389	424	java/lang/Exception
    //   55	62	432	finally
    //   67	120	432	finally
    //   125	150	432	finally
    //   258	263	432	finally
    //   308	313	432	finally
    //   326	331	432	finally
    //   349	354	432	finally
    //   367	372	432	finally
    //   384	389	432	finally
    //   389	397	432	finally
    //   401	405	432	finally
    //   425	429	432	finally
    //   452	456	432	finally
    //   472	477	432	finally
    //   484	488	432	finally
    //   500	505	432	finally
    //   505	513	432	finally
    //   514	518	432	finally
    //   545	550	432	finally
    //   550	558	432	finally
    //   559	563	432	finally
    //   576	581	432	finally
    //   585	589	432	finally
    //   598	603	432	finally
    //   603	611	432	finally
    //   612	616	432	finally
    //   258	263	451	java/lang/Exception
    //   249	253	462	java/lang/Exception
    //   472	477	483	java/lang/Exception
    //   249	253	494	finally
    //   463	467	494	finally
    //   500	505	513	java/lang/Exception
    //   150	161	521	finally
    //   545	550	558	java/lang/Exception
    //   535	540	566	java/lang/Exception
    //   576	581	584	java/lang/Exception
    //   535	540	592	finally
    //   567	571	592	finally
    //   598	603	611	java/lang/Exception
    //   624	629	632	java/io/IOException
    //   619	624	640	java/io/IOException
    //   645	650	653	java/io/IOException
    //   619	624	661	finally
    //   641	645	661	finally
    //   662	667	675	java/io/IOException
    //   410	415	683	java/io/IOException
    //   405	410	691	java/io/IOException
    //   696	701	704	java/io/IOException
    //   405	410	712	finally
    //   692	696	712	finally
    //   713	718	726	java/io/IOException
    //   438	443	734	java/io/IOException
    //   433	438	742	java/io/IOException
    //   747	752	755	java/io/IOException
    //   433	438	763	finally
    //   743	747	763	finally
    //   764	769	777	java/io/IOException
    //   161	174	785	finally
    //   181	187	794	finally
    //   194	205	794	finally
    //   217	224	794	finally
    //   241	245	794	finally
    //   287	291	794	finally
    //   298	304	794	finally
    //   150	161	802	java/lang/Exception
    //   161	174	813	java/lang/Exception
    //   55	62	817	java/lang/Exception
    //   67	120	817	java/lang/Exception
    //   125	150	817	java/lang/Exception
    //   452	456	817	java/lang/Exception
    //   484	488	817	java/lang/Exception
    //   505	513	817	java/lang/Exception
    //   514	518	817	java/lang/Exception
    //   550	558	817	java/lang/Exception
    //   559	563	817	java/lang/Exception
    //   585	589	817	java/lang/Exception
    //   603	611	817	java/lang/Exception
    //   612	616	817	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.device.DeviceUpdate
 * JD-Core Version:    0.7.0.1
 */