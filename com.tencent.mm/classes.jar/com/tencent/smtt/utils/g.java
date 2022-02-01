package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class g
{
  public static String a(String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte, a parama, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(54017);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(54017);
      return null;
    }
    paramMap = a(paramString, paramMap);
    paramString = localObject;
    if (paramMap != null)
    {
      if (!paramBoolean) {
        break label56;
      }
      a(paramMap, paramArrayOfByte);
    }
    for (;;)
    {
      paramString = a(paramMap, parama, false);
      AppMethodBeat.o(54017);
      return paramString;
      label56:
      b(paramMap, paramArrayOfByte);
    }
  }
  
  public static String a(String paramString, byte[] paramArrayOfByte, a parama, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(54016);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localObject1 = i.a().c();
        localObject1 = paramString + (String)localObject1;
        if (!paramBoolean) {}
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(54016);
        return null;
      }
      try
      {
        paramString = i.a().a(paramArrayOfByte);
        paramArrayOfByte = paramString;
      }
      catch (Exception paramString)
      {
        continue;
      }
      if (paramArrayOfByte != null) {
        break;
      }
      AppMethodBeat.o(54016);
      return null;
      localObject1 = h.a().b();
      continue;
      paramString = h.a().a(paramArrayOfByte);
      paramArrayOfByte = paramString;
    }
    paramString = new HashMap();
    paramString.put("Content-Type", "application/x-www-form-urlencoded");
    paramString.put("Content-Length", String.valueOf(paramArrayOfByte.length));
    Object localObject1 = a((String)localObject1, paramString);
    paramString = localObject2;
    if (localObject1 != null)
    {
      b((HttpURLConnection)localObject1, paramArrayOfByte);
      paramString = a((HttpURLConnection)localObject1, parama, paramBoolean);
    }
    AppMethodBeat.o(54016);
    return paramString;
  }
  
  /* Error */
  private static String a(HttpURLConnection paramHttpURLConnection, a parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 92
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 98	java/net/HttpURLConnection:getResponseCode	()I
    //   9: istore_3
    //   10: aload_1
    //   11: ifnull +10 -> 21
    //   14: aload_1
    //   15: iload_3
    //   16: invokeinterface 100 2 0
    //   21: iload_3
    //   22: sipush 200
    //   25: if_icmpne +198 -> 223
    //   28: aload_0
    //   29: invokevirtual 104	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   32: astore_1
    //   33: aload_0
    //   34: invokevirtual 107	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   37: astore_0
    //   38: aload_0
    //   39: ifnull +79 -> 118
    //   42: aload_0
    //   43: ldc 109
    //   45: invokevirtual 113	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   48: ifeq +70 -> 118
    //   51: new 115	java/util/zip/GZIPInputStream
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 118	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   59: astore_0
    //   60: new 120	java/io/ByteArrayOutputStream
    //   63: dup
    //   64: invokespecial 121	java/io/ByteArrayOutputStream:<init>	()V
    //   67: astore 4
    //   69: sipush 128
    //   72: newarray byte
    //   74: astore_1
    //   75: aload_0
    //   76: aload_1
    //   77: invokevirtual 127	java/io/InputStream:read	([B)I
    //   80: istore_3
    //   81: iload_3
    //   82: iconst_m1
    //   83: if_icmpeq +81 -> 164
    //   86: aload 4
    //   88: aload_1
    //   89: iconst_0
    //   90: iload_3
    //   91: invokevirtual 131	java/io/ByteArrayOutputStream:write	([BII)V
    //   94: goto -19 -> 75
    //   97: astore_1
    //   98: aload 4
    //   100: astore_1
    //   101: aload_0
    //   102: invokestatic 134	com/tencent/smtt/utils/g:a	(Ljava/io/Closeable;)V
    //   105: aload_1
    //   106: invokestatic 134	com/tencent/smtt/utils/g:a	(Ljava/io/Closeable;)V
    //   109: aconst_null
    //   110: astore_1
    //   111: ldc 92
    //   113: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: aload_1
    //   117: areturn
    //   118: aload_0
    //   119: ifnull +40 -> 159
    //   122: aload_0
    //   123: ldc 136
    //   125: invokevirtual 113	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   128: ifeq +31 -> 159
    //   131: new 138	java/util/zip/InflaterInputStream
    //   134: dup
    //   135: aload_1
    //   136: new 140	java/util/zip/Inflater
    //   139: dup
    //   140: iconst_1
    //   141: invokespecial 143	java/util/zip/Inflater:<init>	(Z)V
    //   144: invokespecial 146	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   147: astore_0
    //   148: goto -88 -> 60
    //   151: astore_0
    //   152: aconst_null
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_0
    //   156: goto -55 -> 101
    //   159: aload_1
    //   160: astore_0
    //   161: goto -101 -> 60
    //   164: iload_2
    //   165: ifeq +30 -> 195
    //   168: new 87	java/lang/String
    //   171: dup
    //   172: aload 4
    //   174: invokevirtual 150	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   177: ldc 152
    //   179: invokespecial 155	java/lang/String:<init>	([BLjava/lang/String;)V
    //   182: astore_1
    //   183: aload_0
    //   184: invokestatic 134	com/tencent/smtt/utils/g:a	(Ljava/io/Closeable;)V
    //   187: aload 4
    //   189: invokestatic 134	com/tencent/smtt/utils/g:a	(Ljava/io/Closeable;)V
    //   192: goto -81 -> 111
    //   195: new 87	java/lang/String
    //   198: dup
    //   199: invokestatic 67	com/tencent/smtt/utils/h:a	()Lcom/tencent/smtt/utils/h;
    //   202: aload 4
    //   204: invokevirtual 150	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   207: invokevirtual 157	com/tencent/smtt/utils/h:c	([B)[B
    //   210: invokespecial 160	java/lang/String:<init>	([B)V
    //   213: astore_1
    //   214: goto -31 -> 183
    //   217: astore_1
    //   218: aconst_null
    //   219: astore_1
    //   220: goto -119 -> 101
    //   223: aconst_null
    //   224: astore 4
    //   226: aconst_null
    //   227: astore_0
    //   228: aconst_null
    //   229: astore_1
    //   230: goto -47 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramHttpURLConnection	HttpURLConnection
    //   0	233	1	parama	a
    //   0	233	2	paramBoolean	boolean
    //   9	82	3	i	int
    //   67	158	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   69	75	97	finally
    //   75	81	97	finally
    //   86	94	97	finally
    //   168	183	97	finally
    //   195	214	97	finally
    //   5	10	151	finally
    //   14	21	151	finally
    //   28	38	151	finally
    //   42	60	151	finally
    //   122	148	151	finally
    //   60	69	217	finally
  }
  
  /* Error */
  private static HttpURLConnection a(String paramString, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: ldc 161
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 163	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 166	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 170	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: checkcast 94	java/net/HttpURLConnection
    //   19: astore_0
    //   20: aload_0
    //   21: ldc 172
    //   23: invokevirtual 175	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: iconst_1
    //   28: invokevirtual 178	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   31: aload_0
    //   32: iconst_1
    //   33: invokevirtual 181	java/net/HttpURLConnection:setDoInput	(Z)V
    //   36: aload_0
    //   37: iconst_0
    //   38: invokevirtual 184	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   41: aload_0
    //   42: sipush 20000
    //   45: invokevirtual 187	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   48: getstatic 193	android/os/Build$VERSION:SDK_INT	I
    //   51: bipush 13
    //   53: if_icmple +77 -> 130
    //   56: aload_0
    //   57: ldc 195
    //   59: ldc 197
    //   61: invokevirtual 201	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_1
    //   65: invokeinterface 205 1 0
    //   70: invokeinterface 211 1 0
    //   75: astore_1
    //   76: aload_1
    //   77: invokeinterface 217 1 0
    //   82: ifeq +59 -> 141
    //   85: aload_1
    //   86: invokeinterface 221 1 0
    //   91: checkcast 223	java/util/Map$Entry
    //   94: astore_2
    //   95: aload_0
    //   96: aload_2
    //   97: invokeinterface 226 1 0
    //   102: checkcast 87	java/lang/String
    //   105: aload_2
    //   106: invokeinterface 229 1 0
    //   111: checkcast 87	java/lang/String
    //   114: invokevirtual 201	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: goto -41 -> 76
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_0
    //   123: ldc 161
    //   125: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_0
    //   129: areturn
    //   130: aload_0
    //   131: ldc 231
    //   133: ldc 233
    //   135: invokevirtual 201	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: goto -74 -> 64
    //   141: ldc 161
    //   143: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_0
    //   147: areturn
    //   148: astore_1
    //   149: goto -26 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramString	String
    //   0	152	1	paramMap	Map<String, String>
    //   94	12	2	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   5	20	120	java/lang/Exception
    //   20	26	148	java/lang/Exception
  }
  
  private static void a(Closeable paramCloseable)
  {
    AppMethodBeat.i(54022);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(54022);
        return;
      }
      catch (Exception paramCloseable) {}
    }
    AppMethodBeat.o(54022);
  }
  
  /* Error */
  private static void a(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 240
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 242	java/util/zip/GZIPOutputStream
    //   8: dup
    //   9: new 244	java/io/BufferedOutputStream
    //   12: dup
    //   13: aload_0
    //   14: invokevirtual 248	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   17: ldc 249
    //   19: invokespecial 252	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   22: invokespecial 255	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: astore_0
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 259	java/io/OutputStream:write	([B)V
    //   31: aload_0
    //   32: invokevirtual 262	java/io/OutputStream:flush	()V
    //   35: aconst_null
    //   36: invokestatic 134	com/tencent/smtt/utils/g:a	(Ljava/io/Closeable;)V
    //   39: aload_0
    //   40: invokestatic 134	com/tencent/smtt/utils/g:a	(Ljava/io/Closeable;)V
    //   43: ldc 240
    //   45: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: return
    //   49: astore_0
    //   50: aconst_null
    //   51: astore_0
    //   52: aconst_null
    //   53: invokestatic 134	com/tencent/smtt/utils/g:a	(Ljava/io/Closeable;)V
    //   56: aload_0
    //   57: invokestatic 134	com/tencent/smtt/utils/g:a	(Ljava/io/Closeable;)V
    //   60: ldc 240
    //   62: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: return
    //   66: astore_0
    //   67: aconst_null
    //   68: astore_1
    //   69: aconst_null
    //   70: invokestatic 134	com/tencent/smtt/utils/g:a	(Ljava/io/Closeable;)V
    //   73: aload_1
    //   74: invokestatic 134	com/tencent/smtt/utils/g:a	(Ljava/io/Closeable;)V
    //   77: ldc 240
    //   79: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_0
    //   83: athrow
    //   84: astore_2
    //   85: aload_0
    //   86: astore_1
    //   87: aload_2
    //   88: astore_0
    //   89: goto -20 -> 69
    //   92: astore_1
    //   93: goto -41 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramHttpURLConnection	HttpURLConnection
    //   0	96	1	paramArrayOfByte	byte[]
    //   84	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	26	49	java/lang/Exception
    //   5	26	66	finally
    //   26	35	84	finally
    //   26	35	92	java/lang/Exception
  }
  
  private static void b(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(54020);
    HttpURLConnection localHttpURLConnection2 = null;
    HttpURLConnection localHttpURLConnection1 = null;
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getOutputStream();
      localHttpURLConnection1 = paramHttpURLConnection;
      localHttpURLConnection2 = paramHttpURLConnection;
      paramHttpURLConnection.write(paramArrayOfByte);
      localHttpURLConnection1 = paramHttpURLConnection;
      localHttpURLConnection2 = paramHttpURLConnection;
      paramHttpURLConnection.flush();
      return;
    }
    catch (Exception paramHttpURLConnection) {}finally
    {
      a(localHttpURLConnection2);
      AppMethodBeat.o(54020);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.utils.g
 * JD-Core Version:    0.7.0.1
 */