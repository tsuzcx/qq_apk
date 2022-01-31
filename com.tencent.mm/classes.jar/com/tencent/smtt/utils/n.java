package com.tencent.smtt.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class n
{
  public static String a(String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte, n.a parama, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(65255);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(65255);
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
      AppMethodBeat.o(65255);
      return paramString;
      label56:
      b(paramMap, paramArrayOfByte);
    }
  }
  
  public static String a(String paramString, byte[] paramArrayOfByte, n.a parama, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(65254);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localObject1 = p.a().c();
        localObject1 = paramString + (String)localObject1;
        if (!paramBoolean) {}
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(65254);
        return null;
      }
      try
      {
        paramString = p.a().a(paramArrayOfByte);
        paramArrayOfByte = paramString;
      }
      catch (Exception paramString)
      {
        continue;
      }
      if (paramArrayOfByte != null) {
        break;
      }
      AppMethodBeat.o(65254);
      return null;
      localObject1 = o.a().b();
      continue;
      paramString = o.a().a(paramArrayOfByte);
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
    AppMethodBeat.o(65254);
    return paramString;
  }
  
  /* Error */
  private static String a(HttpURLConnection paramHttpURLConnection, n.a parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 94
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 100	java/net/HttpURLConnection:getResponseCode	()I
    //   9: istore_3
    //   10: aload_1
    //   11: ifnull +10 -> 21
    //   14: aload_1
    //   15: iload_3
    //   16: invokeinterface 102 2 0
    //   21: iload_3
    //   22: sipush 200
    //   25: if_icmpne +231 -> 256
    //   28: aload_0
    //   29: invokevirtual 106	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   32: astore_1
    //   33: aload_0
    //   34: invokevirtual 109	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   37: astore_0
    //   38: aload_0
    //   39: ifnull +77 -> 116
    //   42: aload_0
    //   43: ldc 111
    //   45: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   48: ifeq +68 -> 116
    //   51: new 117	java/util/zip/GZIPInputStream
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 120	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   59: astore_0
    //   60: new 122	java/io/ByteArrayOutputStream
    //   63: dup
    //   64: invokespecial 123	java/io/ByteArrayOutputStream:<init>	()V
    //   67: astore 4
    //   69: sipush 128
    //   72: newarray byte
    //   74: astore_1
    //   75: aload_0
    //   76: aload_1
    //   77: invokevirtual 129	java/io/InputStream:read	([B)I
    //   80: istore_3
    //   81: iload_3
    //   82: iconst_m1
    //   83: if_icmpeq +80 -> 163
    //   86: aload 4
    //   88: aload_1
    //   89: iconst_0
    //   90: iload_3
    //   91: invokevirtual 133	java/io/ByteArrayOutputStream:write	([BII)V
    //   94: goto -19 -> 75
    //   97: astore_1
    //   98: aload_0
    //   99: invokestatic 136	com/tencent/smtt/utils/n:a	(Ljava/io/Closeable;)V
    //   102: aload 4
    //   104: invokestatic 136	com/tencent/smtt/utils/n:a	(Ljava/io/Closeable;)V
    //   107: aconst_null
    //   108: astore_1
    //   109: ldc 94
    //   111: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_1
    //   115: areturn
    //   116: aload_0
    //   117: ifnull +41 -> 158
    //   120: aload_0
    //   121: ldc 138
    //   123: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   126: ifeq +32 -> 158
    //   129: new 140	java/util/zip/InflaterInputStream
    //   132: dup
    //   133: aload_1
    //   134: new 142	java/util/zip/Inflater
    //   137: dup
    //   138: iconst_1
    //   139: invokespecial 145	java/util/zip/Inflater:<init>	(Z)V
    //   142: invokespecial 148	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   145: astore_0
    //   146: goto -86 -> 60
    //   149: astore_0
    //   150: aconst_null
    //   151: astore 4
    //   153: aconst_null
    //   154: astore_0
    //   155: goto -57 -> 98
    //   158: aload_1
    //   159: astore_0
    //   160: goto -100 -> 60
    //   163: iload_2
    //   164: ifeq +30 -> 194
    //   167: new 87	java/lang/String
    //   170: dup
    //   171: aload 4
    //   173: invokevirtual 152	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   176: ldc 154
    //   178: invokespecial 157	java/lang/String:<init>	([BLjava/lang/String;)V
    //   181: astore_1
    //   182: aload_0
    //   183: invokestatic 136	com/tencent/smtt/utils/n:a	(Ljava/io/Closeable;)V
    //   186: aload 4
    //   188: invokestatic 136	com/tencent/smtt/utils/n:a	(Ljava/io/Closeable;)V
    //   191: goto -82 -> 109
    //   194: new 87	java/lang/String
    //   197: dup
    //   198: invokestatic 67	com/tencent/smtt/utils/o:a	()Lcom/tencent/smtt/utils/o;
    //   201: aload 4
    //   203: invokevirtual 152	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   206: invokevirtual 159	com/tencent/smtt/utils/o:c	([B)[B
    //   209: invokespecial 162	java/lang/String:<init>	([B)V
    //   212: astore_1
    //   213: goto -31 -> 182
    //   216: astore_1
    //   217: aload_0
    //   218: invokestatic 136	com/tencent/smtt/utils/n:a	(Ljava/io/Closeable;)V
    //   221: aload 4
    //   223: invokestatic 136	com/tencent/smtt/utils/n:a	(Ljava/io/Closeable;)V
    //   226: ldc 94
    //   228: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: aload_1
    //   232: athrow
    //   233: astore_1
    //   234: aconst_null
    //   235: astore 4
    //   237: aconst_null
    //   238: astore_0
    //   239: goto -22 -> 217
    //   242: astore_1
    //   243: aconst_null
    //   244: astore 4
    //   246: goto -29 -> 217
    //   249: astore_1
    //   250: aconst_null
    //   251: astore 4
    //   253: goto -155 -> 98
    //   256: aconst_null
    //   257: astore 4
    //   259: aconst_null
    //   260: astore_0
    //   261: aconst_null
    //   262: astore_1
    //   263: goto -81 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	paramHttpURLConnection	HttpURLConnection
    //   0	266	1	parama	n.a
    //   0	266	2	paramBoolean	boolean
    //   9	82	3	i	int
    //   67	191	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   69	75	97	java/lang/Throwable
    //   75	81	97	java/lang/Throwable
    //   86	94	97	java/lang/Throwable
    //   167	182	97	java/lang/Throwable
    //   194	213	97	java/lang/Throwable
    //   5	10	149	java/lang/Throwable
    //   14	21	149	java/lang/Throwable
    //   28	38	149	java/lang/Throwable
    //   42	60	149	java/lang/Throwable
    //   120	146	149	java/lang/Throwable
    //   69	75	216	finally
    //   75	81	216	finally
    //   86	94	216	finally
    //   167	182	216	finally
    //   194	213	216	finally
    //   5	10	233	finally
    //   14	21	233	finally
    //   28	38	233	finally
    //   42	60	233	finally
    //   120	146	233	finally
    //   60	69	242	finally
    //   60	69	249	java/lang/Throwable
  }
  
  /* Error */
  private static HttpURLConnection a(String paramString, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: ldc 163
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 165	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 168	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 172	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: checkcast 96	java/net/HttpURLConnection
    //   19: astore_0
    //   20: aload_0
    //   21: ldc 174
    //   23: invokevirtual 177	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: iconst_1
    //   28: invokevirtual 180	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   31: aload_0
    //   32: iconst_1
    //   33: invokevirtual 183	java/net/HttpURLConnection:setDoInput	(Z)V
    //   36: aload_0
    //   37: iconst_0
    //   38: invokevirtual 186	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   41: aload_0
    //   42: sipush 20000
    //   45: invokevirtual 189	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   48: getstatic 195	android/os/Build$VERSION:SDK_INT	I
    //   51: bipush 13
    //   53: if_icmple +77 -> 130
    //   56: aload_0
    //   57: ldc 197
    //   59: ldc 199
    //   61: invokevirtual 203	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_1
    //   65: invokeinterface 207 1 0
    //   70: invokeinterface 213 1 0
    //   75: astore_1
    //   76: aload_1
    //   77: invokeinterface 219 1 0
    //   82: ifeq +59 -> 141
    //   85: aload_1
    //   86: invokeinterface 223 1 0
    //   91: checkcast 225	java/util/Map$Entry
    //   94: astore_2
    //   95: aload_0
    //   96: aload_2
    //   97: invokeinterface 228 1 0
    //   102: checkcast 87	java/lang/String
    //   105: aload_2
    //   106: invokeinterface 231 1 0
    //   111: checkcast 87	java/lang/String
    //   114: invokevirtual 203	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: goto -41 -> 76
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_0
    //   123: ldc 163
    //   125: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_0
    //   129: areturn
    //   130: aload_0
    //   131: ldc 233
    //   133: ldc 235
    //   135: invokevirtual 203	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: goto -74 -> 64
    //   141: ldc 163
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
    AppMethodBeat.i(65260);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(65260);
        return;
      }
      catch (Exception paramCloseable) {}
    }
    AppMethodBeat.o(65260);
  }
  
  /* Error */
  private static void a(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 242
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 244	java/util/zip/GZIPOutputStream
    //   8: dup
    //   9: new 246	java/io/BufferedOutputStream
    //   12: dup
    //   13: aload_0
    //   14: invokevirtual 250	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   17: ldc 251
    //   19: invokespecial 254	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   22: invokespecial 257	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: astore_0
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 261	java/io/OutputStream:write	([B)V
    //   31: aload_0
    //   32: invokevirtual 264	java/io/OutputStream:flush	()V
    //   35: aconst_null
    //   36: invokestatic 136	com/tencent/smtt/utils/n:a	(Ljava/io/Closeable;)V
    //   39: aload_0
    //   40: invokestatic 136	com/tencent/smtt/utils/n:a	(Ljava/io/Closeable;)V
    //   43: ldc 242
    //   45: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: return
    //   49: astore_0
    //   50: aconst_null
    //   51: astore_0
    //   52: aconst_null
    //   53: invokestatic 136	com/tencent/smtt/utils/n:a	(Ljava/io/Closeable;)V
    //   56: aload_0
    //   57: invokestatic 136	com/tencent/smtt/utils/n:a	(Ljava/io/Closeable;)V
    //   60: ldc 242
    //   62: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: return
    //   66: astore_0
    //   67: aconst_null
    //   68: astore_1
    //   69: aconst_null
    //   70: invokestatic 136	com/tencent/smtt/utils/n:a	(Ljava/io/Closeable;)V
    //   73: aload_1
    //   74: invokestatic 136	com/tencent/smtt/utils/n:a	(Ljava/io/Closeable;)V
    //   77: ldc 242
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
    AppMethodBeat.i(65258);
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
      AppMethodBeat.o(65258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.n
 * JD-Core Version:    0.7.0.1
 */