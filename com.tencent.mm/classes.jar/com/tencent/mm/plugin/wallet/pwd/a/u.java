package com.tencent.mm.plugin.wallet.pwd.a;

import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public final class u
{
  /* Error */
  private static byte[] aVb(String paramString)
  {
    // Byte code:
    //   0: ldc 13
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 21	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 25	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: new 27	java/io/ByteArrayOutputStream
    //   17: dup
    //   18: aload_2
    //   19: invokevirtual 31	java/io/FileInputStream:available	()I
    //   22: invokespecial 33	java/io/ByteArrayOutputStream:<init>	(I)V
    //   25: astore_0
    //   26: sipush 1024
    //   29: newarray byte
    //   31: astore_3
    //   32: aload_2
    //   33: aload_3
    //   34: invokevirtual 37	java/io/FileInputStream:read	([B)I
    //   37: istore_1
    //   38: iload_1
    //   39: iflt +43 -> 82
    //   42: aload_0
    //   43: aload_3
    //   44: iconst_0
    //   45: iload_1
    //   46: invokevirtual 41	java/io/ByteArrayOutputStream:write	([BII)V
    //   49: goto -17 -> 32
    //   52: astore_3
    //   53: aload_0
    //   54: ifnull +7 -> 61
    //   57: aload_0
    //   58: invokevirtual 45	java/io/ByteArrayOutputStream:close	()V
    //   61: aload_2
    //   62: ifnull +149 -> 211
    //   65: aload_2
    //   66: invokevirtual 46	java/io/FileInputStream:close	()V
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull +68 -> 140
    //   75: ldc 13
    //   77: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_0
    //   81: areturn
    //   82: aload_0
    //   83: invokevirtual 53	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   86: astore_3
    //   87: aload_0
    //   88: invokevirtual 45	java/io/ByteArrayOutputStream:close	()V
    //   91: aload_2
    //   92: invokevirtual 46	java/io/FileInputStream:close	()V
    //   95: aload_3
    //   96: astore_0
    //   97: goto -26 -> 71
    //   100: astore_0
    //   101: aload_3
    //   102: astore_0
    //   103: goto -32 -> 71
    //   106: astore_0
    //   107: aconst_null
    //   108: astore_0
    //   109: goto -38 -> 71
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_2
    //   115: aconst_null
    //   116: astore_3
    //   117: aload_2
    //   118: ifnull +7 -> 125
    //   121: aload_2
    //   122: invokevirtual 45	java/io/ByteArrayOutputStream:close	()V
    //   125: aload_3
    //   126: ifnull +7 -> 133
    //   129: aload_3
    //   130: invokevirtual 46	java/io/FileInputStream:close	()V
    //   133: ldc 13
    //   135: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_0
    //   139: athrow
    //   140: ldc 55
    //   142: invokevirtual 60	java/lang/String:getBytes	()[B
    //   145: astore_0
    //   146: ldc 13
    //   148: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_0
    //   152: areturn
    //   153: astore_0
    //   154: goto -63 -> 91
    //   157: astore_0
    //   158: goto -97 -> 61
    //   161: astore_2
    //   162: goto -37 -> 125
    //   165: astore_2
    //   166: goto -33 -> 133
    //   169: astore_0
    //   170: aconst_null
    //   171: astore 4
    //   173: aload_2
    //   174: astore_3
    //   175: aload 4
    //   177: astore_2
    //   178: goto -61 -> 117
    //   181: astore 4
    //   183: aload_0
    //   184: astore 5
    //   186: aload_2
    //   187: astore_3
    //   188: aload 4
    //   190: astore_0
    //   191: aload 5
    //   193: astore_2
    //   194: goto -77 -> 117
    //   197: astore_0
    //   198: aconst_null
    //   199: astore_0
    //   200: aconst_null
    //   201: astore_2
    //   202: goto -149 -> 53
    //   205: astore_0
    //   206: aconst_null
    //   207: astore_0
    //   208: goto -155 -> 53
    //   211: aconst_null
    //   212: astore_0
    //   213: goto -142 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramString	String
    //   37	9	1	i	int
    //   13	109	2	localFileInputStream	java.io.FileInputStream
    //   161	1	2	localIOException1	java.io.IOException
    //   165	9	2	localIOException2	java.io.IOException
    //   177	25	2	localObject1	Object
    //   31	13	3	arrayOfByte	byte[]
    //   52	1	3	localThrowable	Throwable
    //   86	102	3	localObject2	Object
    //   171	5	4	localObject3	Object
    //   181	8	4	localObject4	Object
    //   184	8	5	str	String
    // Exception table:
    //   from	to	target	type
    //   26	32	52	java/lang/Throwable
    //   32	38	52	java/lang/Throwable
    //   42	49	52	java/lang/Throwable
    //   82	87	52	java/lang/Throwable
    //   91	95	100	java/io/IOException
    //   65	69	106	java/io/IOException
    //   5	14	112	finally
    //   87	91	153	java/io/IOException
    //   57	61	157	java/io/IOException
    //   121	125	161	java/io/IOException
    //   129	133	165	java/io/IOException
    //   14	26	169	finally
    //   26	32	181	finally
    //   32	38	181	finally
    //   42	49	181	finally
    //   82	87	181	finally
    //   5	14	197	java/lang/Throwable
    //   14	26	205	java/lang/Throwable
  }
  
  private static byte[] decode(String paramString)
  {
    AppMethodBeat.i(214068);
    try
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        paramString = Base64.decode(paramString.getBytes(), 0);
        AppMethodBeat.o(214068);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(214068);
    }
    return null;
  }
  
  public static boolean fOQ()
  {
    AppMethodBeat.i(214065);
    if (Build.VERSION.SDK_INT >= 8)
    {
      localObject = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Environment.DIRECTORY_DOWNLOADS + "/.tmfs/sk_k_g.dat");
      if (((File)localObject).exists())
      {
        localObject = aVb(((File)localObject).getAbsolutePath());
        if ((localObject == null) || (localObject.length <= 0)) {}
      }
    }
    for (Object localObject = new String((byte[])localObject); TextUtils.isEmpty((CharSequence)localObject); localObject = "")
    {
      AppMethodBeat.o(214065);
      return false;
    }
    String str = fOR();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(214065);
      return false;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("guid", str);
      localJSONObject2.put("secretId", localObject);
      localJSONObject1.put("req", localJSONObject2);
      label175:
      localObject = ls("https://jprx.m.qq.com/data/2241/forward", localJSONObject1.toString());
      for (;;)
      {
        try
        {
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).getInt("ret") != 0) {
            continue;
          }
          int i = ((JSONObject)localObject).getJSONObject("data").getJSONObject("resp").getInt("status");
          if (i != 1) {
            continue;
          }
          bool = true;
        }
        catch (Exception localException)
        {
          boolean bool = false;
          continue;
        }
        Log.d("MicroMsg.SgLiveChecker", "status alive: ".concat(String.valueOf(bool)));
        AppMethodBeat.o(214065);
        return bool;
        bool = false;
      }
    }
    catch (JSONException localJSONException)
    {
      break label175;
    }
  }
  
  private static String fOR()
  {
    AppMethodBeat.i(214066);
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 8) {
          continue;
        }
        localObject1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Environment.DIRECTORY_DOWNLOADS + "/.tmfs/sk_g.dat");
        if (!((File)localObject1).exists()) {
          continue;
        }
        localObject1 = aVb(((File)localObject1).getAbsolutePath());
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          continue;
        }
        localObject2 = new String((byte[])localObject1);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/com.tencent.qqpimsecure_TMF_4_C/files/sk_g.dat");
          if (!((File)localObject1).exists()) {
            continue;
          }
          localObject1 = aVb(((File)localObject1).getAbsolutePath());
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            continue;
          }
          localObject1 = new String((byte[])localObject1);
        }
        localObject2 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = new String(u.a.cr(decode((String)localObject1)), "gbk");
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        Object localObject2 = "";
        continue;
      }
      AppMethodBeat.o(214066);
      return localObject2;
      localObject2 = "";
      continue;
      localObject1 = "";
    }
  }
  
  /* Error */
  private static String ls(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 207
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 170
    //   7: new 85	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 209
    //   13: invokespecial 210	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 212
    //   22: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: new 216	java/net/URL
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 217	java/net/URL:<init>	(Ljava/lang/String;)V
    //   43: invokevirtual 221	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   46: checkcast 223	javax/net/ssl/HttpsURLConnection
    //   49: astore_0
    //   50: aload_0
    //   51: iconst_1
    //   52: invokevirtual 227	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   55: aload_0
    //   56: iconst_1
    //   57: invokevirtual 230	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   60: aload_0
    //   61: iconst_0
    //   62: invokevirtual 233	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   65: aload_0
    //   66: ldc 235
    //   68: ldc 237
    //   70: invokevirtual 240	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: ldc 242
    //   76: ldc 244
    //   78: invokevirtual 240	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_0
    //   82: ldc 246
    //   84: invokevirtual 249	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   87: new 251	java/io/BufferedWriter
    //   90: dup
    //   91: new 253	java/io/OutputStreamWriter
    //   94: dup
    //   95: aload_0
    //   96: invokevirtual 257	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   99: ldc_w 259
    //   102: invokespecial 262	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   105: invokespecial 265	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   108: astore_3
    //   109: aload_3
    //   110: aload_1
    //   111: invokevirtual 267	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   114: aload_3
    //   115: invokevirtual 268	java/io/BufferedWriter:close	()V
    //   118: aload_0
    //   119: invokevirtual 271	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   122: istore_2
    //   123: ldc_w 273
    //   126: ldc_w 275
    //   129: iload_2
    //   130: invokestatic 278	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   133: invokevirtual 180	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   136: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: new 85	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   146: astore_1
    //   147: iload_2
    //   148: sipush 200
    //   151: if_icmpne +56 -> 207
    //   154: new 280	java/io/BufferedReader
    //   157: dup
    //   158: new 282	java/io/InputStreamReader
    //   161: dup
    //   162: aload_0
    //   163: invokevirtual 286	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   166: invokespecial 289	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   169: invokespecial 292	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   172: astore_0
    //   173: aload_0
    //   174: invokevirtual 295	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   177: astore_3
    //   178: aload_3
    //   179: ifnull +28 -> 207
    //   182: aload_1
    //   183: aload_3
    //   184: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_1
    //   189: ldc_w 297
    //   192: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: goto -23 -> 173
    //   199: astore_0
    //   200: ldc 207
    //   202: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aconst_null
    //   206: areturn
    //   207: ldc 170
    //   209: new 85	java/lang/StringBuilder
    //   212: dup
    //   213: ldc_w 299
    //   216: invokespecial 210	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: aload_1
    //   220: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload_1
    //   233: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: astore_0
    //   237: ldc 207
    //   239: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: aload_0
    //   243: areturn
    //   244: astore_0
    //   245: goto -45 -> 200
    //   248: astore_0
    //   249: goto -49 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramString1	String
    //   0	252	1	paramString2	String
    //   122	30	2	i	int
    //   108	76	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   35	147	199	java/net/MalformedURLException
    //   154	173	199	java/net/MalformedURLException
    //   173	178	199	java/net/MalformedURLException
    //   182	196	199	java/net/MalformedURLException
    //   207	237	199	java/net/MalformedURLException
    //   35	147	244	java/io/IOException
    //   154	173	244	java/io/IOException
    //   173	178	244	java/io/IOException
    //   182	196	244	java/io/IOException
    //   207	237	244	java/io/IOException
    //   35	147	248	java/net/ProtocolException
    //   154	173	248	java/net/ProtocolException
    //   173	178	248	java/net/ProtocolException
    //   182	196	248	java/net/ProtocolException
    //   207	237	248	java/net/ProtocolException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.u
 * JD-Core Version:    0.7.0.1
 */