package com.tencent.mm.plugin.wallet.pwd.a;

import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
{
  /* Error */
  private static byte[] bgq(String paramString)
  {
    // Byte code:
    //   0: ldc 12
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 20	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 24	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: new 26	java/io/ByteArrayOutputStream
    //   17: dup
    //   18: aload_2
    //   19: invokevirtual 30	java/io/FileInputStream:available	()I
    //   22: invokespecial 32	java/io/ByteArrayOutputStream:<init>	(I)V
    //   25: astore_3
    //   26: sipush 1024
    //   29: newarray byte
    //   31: astore_0
    //   32: aload_2
    //   33: aload_0
    //   34: invokevirtual 36	java/io/FileInputStream:read	([B)I
    //   37: istore_1
    //   38: iload_1
    //   39: iflt +45 -> 84
    //   42: aload_3
    //   43: aload_0
    //   44: iconst_0
    //   45: iload_1
    //   46: invokevirtual 40	java/io/ByteArrayOutputStream:write	([BII)V
    //   49: goto -17 -> 32
    //   52: astore_0
    //   53: aload_3
    //   54: astore_0
    //   55: aload_0
    //   56: ifnull +7 -> 63
    //   59: aload_0
    //   60: invokevirtual 44	java/io/ByteArrayOutputStream:close	()V
    //   63: aload_2
    //   64: ifnull +81 -> 145
    //   67: aload_2
    //   68: invokevirtual 45	java/io/FileInputStream:close	()V
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull +36 -> 110
    //   77: ldc 12
    //   79: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_0
    //   83: areturn
    //   84: aload_3
    //   85: invokevirtual 52	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   88: astore_0
    //   89: aload_3
    //   90: invokevirtual 44	java/io/ByteArrayOutputStream:close	()V
    //   93: aload_2
    //   94: invokevirtual 45	java/io/FileInputStream:close	()V
    //   97: goto -24 -> 73
    //   100: astore_2
    //   101: goto -28 -> 73
    //   104: astore_0
    //   105: aconst_null
    //   106: astore_0
    //   107: goto -34 -> 73
    //   110: ldc 54
    //   112: invokevirtual 59	java/lang/String:getBytes	()[B
    //   115: astore_0
    //   116: ldc 12
    //   118: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_0
    //   122: areturn
    //   123: astore_3
    //   124: goto -31 -> 93
    //   127: astore_0
    //   128: goto -65 -> 63
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_0
    //   134: aconst_null
    //   135: astore_2
    //   136: goto -81 -> 55
    //   139: astore_0
    //   140: aconst_null
    //   141: astore_0
    //   142: goto -87 -> 55
    //   145: aconst_null
    //   146: astore_0
    //   147: goto -74 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramString	String
    //   37	9	1	i	int
    //   13	81	2	localFileInputStream	java.io.FileInputStream
    //   100	1	2	localIOException1	java.io.IOException
    //   135	1	2	localObject	Object
    //   25	65	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   123	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   26	32	52	finally
    //   32	38	52	finally
    //   42	49	52	finally
    //   84	89	52	finally
    //   93	97	100	java/io/IOException
    //   67	71	104	java/io/IOException
    //   89	93	123	java/io/IOException
    //   59	63	127	java/io/IOException
    //   5	14	131	finally
    //   14	26	139	finally
  }
  
  private static byte[] decode(String paramString)
  {
    AppMethodBeat.i(315586);
    try
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        paramString = Base64.decode(paramString.getBytes(), 0);
        AppMethodBeat.o(315586);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(315586);
    }
    return null;
  }
  
  public static boolean igA()
  {
    AppMethodBeat.i(315578);
    if (Build.VERSION.SDK_INT >= 8)
    {
      localObject = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Environment.DIRECTORY_DOWNLOADS + "/.tmfs/sk_k_g.dat");
      if (((File)localObject).exists())
      {
        localObject = bgq(((File)localObject).getAbsolutePath());
        if ((localObject == null) || (localObject.length <= 0)) {}
      }
    }
    for (Object localObject = new String((byte[])localObject); TextUtils.isEmpty((CharSequence)localObject); localObject = "")
    {
      AppMethodBeat.o(315578);
      return false;
    }
    String str = igB();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(315578);
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
      localObject = nB("https://jprx.m.qq.com/data/2241/forward", localJSONObject1.toString());
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
        AppMethodBeat.o(315578);
        return bool;
        bool = false;
      }
    }
    catch (JSONException localJSONException)
    {
      break label175;
    }
  }
  
  private static String igB()
  {
    AppMethodBeat.i(315580);
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
        localObject1 = bgq(((File)localObject1).getAbsolutePath());
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          continue;
        }
        localObject3 = new String((byte[])localObject1);
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/com.tencent.qqpimsecure_TMF_4_C/files/sk_g.dat");
          if (!((File)localObject1).exists()) {
            continue;
          }
          localObject1 = bgq(((File)localObject1).getAbsolutePath());
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            continue;
          }
          localObject1 = new String((byte[])localObject1);
        }
        localObject3 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject3 = new String(a.cK(decode((String)localObject1)), "gbk");
        }
      }
      finally
      {
        Object localObject1;
        Object localObject3 = "";
        continue;
      }
      AppMethodBeat.o(315580);
      return localObject3;
      localObject3 = "";
      continue;
      localObject1 = "";
    }
  }
  
  /* Error */
  private static String nB(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 206
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 169
    //   7: new 84	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 208
    //   13: invokespecial 209	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 211
    //   22: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 213	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: new 215	java/net/URL
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 216	java/net/URL:<init>	(Ljava/lang/String;)V
    //   43: invokevirtual 220	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   46: checkcast 222	javax/net/ssl/HttpsURLConnection
    //   49: astore_0
    //   50: aload_0
    //   51: iconst_1
    //   52: invokevirtual 226	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   55: aload_0
    //   56: iconst_1
    //   57: invokevirtual 229	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   60: aload_0
    //   61: iconst_0
    //   62: invokevirtual 232	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   65: aload_0
    //   66: ldc 234
    //   68: ldc 236
    //   70: invokevirtual 239	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: ldc 241
    //   76: ldc 243
    //   78: invokevirtual 239	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_0
    //   82: ldc 245
    //   84: invokevirtual 248	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   87: new 250	java/io/BufferedWriter
    //   90: dup
    //   91: new 252	java/io/OutputStreamWriter
    //   94: dup
    //   95: aload_0
    //   96: invokevirtual 256	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   99: ldc_w 258
    //   102: invokespecial 261	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   105: invokespecial 264	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   108: astore_3
    //   109: aload_3
    //   110: aload_1
    //   111: invokevirtual 266	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   114: aload_3
    //   115: invokevirtual 267	java/io/BufferedWriter:close	()V
    //   118: aload_0
    //   119: invokevirtual 270	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   122: istore_2
    //   123: ldc_w 272
    //   126: ldc_w 274
    //   129: iload_2
    //   130: invokestatic 277	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   133: invokevirtual 179	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   136: invokestatic 213	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: new 84	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   146: astore_1
    //   147: iload_2
    //   148: sipush 200
    //   151: if_icmpne +56 -> 207
    //   154: new 279	java/io/BufferedReader
    //   157: dup
    //   158: new 281	java/io/InputStreamReader
    //   161: dup
    //   162: aload_0
    //   163: invokevirtual 285	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   166: invokespecial 288	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   169: invokespecial 291	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   172: astore_0
    //   173: aload_0
    //   174: invokevirtual 294	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   177: astore_3
    //   178: aload_3
    //   179: ifnull +28 -> 207
    //   182: aload_1
    //   183: aload_3
    //   184: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_1
    //   189: ldc_w 296
    //   192: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: goto -23 -> 173
    //   199: astore_0
    //   200: ldc 206
    //   202: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aconst_null
    //   206: areturn
    //   207: ldc 169
    //   209: new 84	java/lang/StringBuilder
    //   212: dup
    //   213: ldc_w 298
    //   216: invokespecial 209	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: aload_1
    //   220: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 213	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload_1
    //   233: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: astore_0
    //   237: ldc 206
    //   239: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  static final class a
  {
    private static void a(byte[] paramArrayOfByte, int[] paramArrayOfInt)
    {
      int k = paramArrayOfByte.length;
      int i = 0;
      int m;
      for (int j = 0; i < k >> 2; j = m + 1)
      {
        m = j + 1;
        paramArrayOfByte[j] &= 0xFF;
        int n = paramArrayOfInt[i];
        j = m + 1;
        paramArrayOfInt[i] = ((paramArrayOfByte[m] & 0xFF) << 8 | n);
        n = paramArrayOfInt[i];
        m = j + 1;
        paramArrayOfInt[i] = (n | (paramArrayOfByte[j] & 0xFF) << 16);
        paramArrayOfInt[i] |= (paramArrayOfByte[m] & 0xFF) << 24;
        i += 1;
      }
      if (j < paramArrayOfByte.length)
      {
        k = j + 1;
        paramArrayOfByte[j] &= 0xFF;
        j = 8;
        while (k < paramArrayOfByte.length)
        {
          paramArrayOfInt[i] |= (paramArrayOfByte[k] & 0xFF) << j;
          k += 1;
          j += 8;
        }
      }
    }
    
    private static byte[] cJ(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(315595);
      Object localObject = paramArrayOfByte;
      if (paramArrayOfByte != null)
      {
        localObject = paramArrayOfByte;
        if (paramArrayOfByte.length <= 16) {}
      }
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        localObject = ((MessageDigest)localObject).digest();
        AppMethodBeat.o(315595);
        return localObject;
      }
      catch (NoSuchAlgorithmException paramArrayOfByte)
      {
        for (;;)
        {
          localObject = null;
        }
      }
    }
    
    public static byte[] cK(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(315598);
      byte[] arrayOfByte = cJ(igC());
      if ((paramArrayOfByte == null) || (arrayOfByte == null) || (paramArrayOfByte.length == 0))
      {
        AppMethodBeat.o(315598);
        return paramArrayOfByte;
      }
      if ((paramArrayOfByte.length % 4 != 0) || (paramArrayOfByte.length < 8))
      {
        AppMethodBeat.o(315598);
        return null;
      }
      int[] arrayOfInt = new int[paramArrayOfByte.length >>> 2];
      a(paramArrayOfByte, arrayOfInt);
      if (arrayOfByte.length % 4 == 0) {}
      for (int i = arrayOfByte.length >>> 2;; i = (arrayOfByte.length >>> 2) + 1)
      {
        j = i;
        if (i < 4) {
          j = 4;
        }
        paramArrayOfByte = new int[j];
        i = 0;
        while (i < j)
        {
          paramArrayOfByte[i] = 0;
          i += 1;
        }
      }
      a(arrayOfByte, paramArrayOfByte);
      int n = arrayOfInt.length - 1;
      i = arrayOfInt[0];
      int j = (52 / (n + 1) + 6) * -1640531527;
      while (j != 0)
      {
        int i1 = j >>> 2 & 0x3;
        m = n;
        k = i;
        i = m;
        while (i > 0)
        {
          m = arrayOfInt[(i - 1)];
          k = arrayOfInt[i] - ((k ^ j) + (m ^ paramArrayOfByte[(i & 0x3 ^ i1)]) ^ (m >>> 5 ^ k << 2) + (k >>> 3 ^ m << 4));
          arrayOfInt[i] = k;
          i -= 1;
        }
        m = arrayOfInt[n];
        i = arrayOfInt[0] - ((paramArrayOfByte[(i & 0x3 ^ i1)] ^ m) + (k ^ j) ^ (m >>> 5 ^ k << 2) + (k >>> 3 ^ m << 4));
        arrayOfInt[0] = i;
        j += 1640531527;
      }
      i = arrayOfInt[n];
      if ((i < 0) || (i > arrayOfInt.length - 1 << 2))
      {
        AppMethodBeat.o(315598);
        return null;
      }
      paramArrayOfByte = new byte[i];
      int m = arrayOfInt.length - 1;
      int k = 0;
      i = paramArrayOfByte.length >> 2;
      j = i;
      if (i > m) {
        j = m;
      }
      i = 0;
      while (i < j)
      {
        n = k + 1;
        paramArrayOfByte[k] = ((byte)(arrayOfInt[i] & 0xFF));
        k = n + 1;
        paramArrayOfByte[n] = ((byte)(arrayOfInt[i] >>> 8 & 0xFF));
        n = k + 1;
        paramArrayOfByte[k] = ((byte)(arrayOfInt[i] >>> 16 & 0xFF));
        k = n + 1;
        paramArrayOfByte[n] = ((byte)(arrayOfInt[i] >>> 24 & 0xFF));
        i += 1;
      }
      if ((m > j) && (k < paramArrayOfByte.length))
      {
        j = k + 1;
        paramArrayOfByte[k] = ((byte)(arrayOfInt[i] & 0xFF));
        k = 8;
        while ((k <= 24) && (j < paramArrayOfByte.length))
        {
          paramArrayOfByte[j] = ((byte)(arrayOfInt[i] >>> k & 0xFF));
          k += 8;
          j += 1;
        }
      }
      AppMethodBeat.o(315598);
      return paramArrayOfByte;
    }
    
    private static byte[] igC()
    {
      AppMethodBeat.i(315590);
      try
      {
        byte[] arrayOfByte = "DFG#$%^#%$RGHR(&*M<><".getBytes("UTF-8");
        AppMethodBeat.o(315590);
        return arrayOfByte;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        AppMethodBeat.o(315590);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.t
 * JD-Core Version:    0.7.0.1
 */