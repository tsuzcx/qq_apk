package com.tencent.smtt.utils;

import java.io.Closeable;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class m
{
  public static String a(String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte, m.a parama, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      paramString = a(paramString, paramMap);
    } while (paramString == null);
    if (paramBoolean) {
      a(paramString, paramArrayOfByte);
    }
    for (;;)
    {
      return a(paramString, parama, false);
      b(paramString, paramArrayOfByte);
    }
  }
  
  public static String a(String paramString, byte[] paramArrayOfByte, m.a parama, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      String str = o.a().c();
      str = paramString + str;
      if (paramBoolean) {}
      try
      {
        paramString = o.a().a(paramArrayOfByte);
        paramArrayOfByte = paramString;
      }
      catch (Exception paramString)
      {
        label47:
        break label47;
      }
      if (paramArrayOfByte == null) {}
      for (;;)
      {
        return null;
        str = n.a().b();
        break;
        paramString = n.a().a(paramArrayOfByte);
        paramArrayOfByte = paramString;
        break label47;
        paramString = new HashMap();
        paramString.put("Content-Type", "application/x-www-form-urlencoded");
        paramString.put("Content-Length", String.valueOf(paramArrayOfByte.length));
        paramString = a(str, paramString);
        if (paramString != null)
        {
          b(paramString, paramArrayOfByte);
          return a(paramString, parama, paramBoolean);
        }
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  /* Error */
  private static String a(HttpURLConnection paramHttpURLConnection, m.a parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 88	java/net/HttpURLConnection:getResponseCode	()I
    //   4: istore_3
    //   5: aload_1
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: iload_3
    //   11: invokeinterface 91 2 0
    //   16: iload_3
    //   17: sipush 200
    //   20: if_icmpne +224 -> 244
    //   23: aload_0
    //   24: invokevirtual 95	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   27: astore_1
    //   28: aload_0
    //   29: invokevirtual 98	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   32: astore_0
    //   33: aload_0
    //   34: ifnull +71 -> 105
    //   37: aload_0
    //   38: ldc 100
    //   40: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   43: ifeq +62 -> 105
    //   46: new 106	java/util/zip/GZIPInputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 109	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   54: astore_0
    //   55: new 111	java/io/ByteArrayOutputStream
    //   58: dup
    //   59: invokespecial 112	java/io/ByteArrayOutputStream:<init>	()V
    //   62: astore_1
    //   63: sipush 128
    //   66: newarray byte
    //   68: astore 4
    //   70: aload_0
    //   71: aload 4
    //   73: invokevirtual 118	java/io/InputStream:read	([B)I
    //   76: istore_3
    //   77: iload_3
    //   78: iconst_m1
    //   79: if_icmpeq +72 -> 151
    //   82: aload_1
    //   83: aload 4
    //   85: iconst_0
    //   86: iload_3
    //   87: invokevirtual 122	java/io/ByteArrayOutputStream:write	([BII)V
    //   90: goto -20 -> 70
    //   93: astore 4
    //   95: aload_0
    //   96: invokestatic 125	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   99: aload_1
    //   100: invokestatic 125	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   103: aconst_null
    //   104: areturn
    //   105: aload_0
    //   106: ifnull +40 -> 146
    //   109: aload_0
    //   110: ldc 127
    //   112: invokevirtual 104	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   115: ifeq +31 -> 146
    //   118: new 129	java/util/zip/InflaterInputStream
    //   121: dup
    //   122: aload_1
    //   123: new 131	java/util/zip/Inflater
    //   126: dup
    //   127: iconst_1
    //   128: invokespecial 134	java/util/zip/Inflater:<init>	(Z)V
    //   131: invokespecial 137	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   134: astore_0
    //   135: goto -80 -> 55
    //   138: astore_0
    //   139: aconst_null
    //   140: astore_1
    //   141: aconst_null
    //   142: astore_0
    //   143: goto -48 -> 95
    //   146: aload_1
    //   147: astore_0
    //   148: goto -93 -> 55
    //   151: iload_2
    //   152: ifeq +29 -> 181
    //   155: new 76	java/lang/String
    //   158: dup
    //   159: aload_1
    //   160: invokevirtual 141	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   163: ldc 143
    //   165: invokespecial 146	java/lang/String:<init>	([BLjava/lang/String;)V
    //   168: astore 4
    //   170: aload_0
    //   171: invokestatic 125	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   174: aload_1
    //   175: invokestatic 125	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   178: aload 4
    //   180: areturn
    //   181: new 76	java/lang/String
    //   184: dup
    //   185: invokestatic 56	com/tencent/smtt/utils/n:a	()Lcom/tencent/smtt/utils/n;
    //   188: aload_1
    //   189: invokevirtual 141	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   192: invokevirtual 148	com/tencent/smtt/utils/n:c	([B)[B
    //   195: invokespecial 151	java/lang/String:<init>	([B)V
    //   198: astore 4
    //   200: goto -30 -> 170
    //   203: astore 5
    //   205: aload_1
    //   206: astore 4
    //   208: aload 5
    //   210: astore_1
    //   211: aload_0
    //   212: invokestatic 125	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   215: aload 4
    //   217: invokestatic 125	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   220: aload_1
    //   221: athrow
    //   222: astore_1
    //   223: aconst_null
    //   224: astore 4
    //   226: aconst_null
    //   227: astore_0
    //   228: goto -17 -> 211
    //   231: astore_1
    //   232: aconst_null
    //   233: astore 4
    //   235: goto -24 -> 211
    //   238: astore_1
    //   239: aconst_null
    //   240: astore_1
    //   241: goto -146 -> 95
    //   244: aconst_null
    //   245: astore_1
    //   246: aconst_null
    //   247: astore_0
    //   248: aconst_null
    //   249: astore 4
    //   251: goto -81 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramHttpURLConnection	HttpURLConnection
    //   0	254	1	parama	m.a
    //   0	254	2	paramBoolean	boolean
    //   4	83	3	i	int
    //   68	16	4	arrayOfByte	byte[]
    //   93	1	4	localThrowable	java.lang.Throwable
    //   168	82	4	localObject1	Object
    //   203	6	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   63	70	93	java/lang/Throwable
    //   70	77	93	java/lang/Throwable
    //   82	90	93	java/lang/Throwable
    //   155	170	93	java/lang/Throwable
    //   181	200	93	java/lang/Throwable
    //   0	5	138	java/lang/Throwable
    //   9	16	138	java/lang/Throwable
    //   23	33	138	java/lang/Throwable
    //   37	55	138	java/lang/Throwable
    //   109	135	138	java/lang/Throwable
    //   63	70	203	finally
    //   70	77	203	finally
    //   82	90	203	finally
    //   155	170	203	finally
    //   181	200	203	finally
    //   0	5	222	finally
    //   9	16	222	finally
    //   23	33	222	finally
    //   37	55	222	finally
    //   109	135	222	finally
    //   55	63	231	finally
    //   55	63	238	java/lang/Throwable
  }
  
  /* Error */
  private static HttpURLConnection a(String paramString, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: new 153	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 156	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 160	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 84	java/net/HttpURLConnection
    //   14: astore_2
    //   15: aload_2
    //   16: ldc 162
    //   18: invokevirtual 165	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   21: aload_2
    //   22: iconst_1
    //   23: invokevirtual 168	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   26: aload_2
    //   27: iconst_1
    //   28: invokevirtual 171	java/net/HttpURLConnection:setDoInput	(Z)V
    //   31: aload_2
    //   32: iconst_0
    //   33: invokevirtual 174	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   36: aload_2
    //   37: sipush 20000
    //   40: invokevirtual 177	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   43: getstatic 183	android/os/Build$VERSION:SDK_INT	I
    //   46: bipush 13
    //   48: if_icmple +69 -> 117
    //   51: aload_2
    //   52: ldc 185
    //   54: ldc 187
    //   56: invokevirtual 191	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_1
    //   60: invokeinterface 195 1 0
    //   65: invokeinterface 201 1 0
    //   70: astore_1
    //   71: aload_2
    //   72: astore_0
    //   73: aload_1
    //   74: invokeinterface 207 1 0
    //   79: ifeq +52 -> 131
    //   82: aload_1
    //   83: invokeinterface 211 1 0
    //   88: checkcast 213	java/util/Map$Entry
    //   91: astore_0
    //   92: aload_2
    //   93: aload_0
    //   94: invokeinterface 216 1 0
    //   99: checkcast 76	java/lang/String
    //   102: aload_0
    //   103: invokeinterface 219 1 0
    //   108: checkcast 76	java/lang/String
    //   111: invokevirtual 191	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: goto -43 -> 71
    //   117: aload_2
    //   118: ldc 221
    //   120: ldc 223
    //   122: invokevirtual 191	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: goto -66 -> 59
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_0
    //   131: aload_0
    //   132: areturn
    //   133: astore_0
    //   134: aload_2
    //   135: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   0	136	1	paramMap	Map<String, String>
    //   14	121	2	localHttpURLConnection	HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   0	15	128	java/lang/Exception
    //   15	21	133	java/lang/Exception
  }
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  /* Error */
  private static void a(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 230	java/util/zip/GZIPOutputStream
    //   3: dup
    //   4: new 232	java/io/BufferedOutputStream
    //   7: dup
    //   8: aload_0
    //   9: invokevirtual 236	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   12: ldc 237
    //   14: invokespecial 240	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   17: invokespecial 243	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore_0
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 247	java/io/OutputStream:write	([B)V
    //   26: aload_0
    //   27: invokevirtual 250	java/io/OutputStream:flush	()V
    //   30: aconst_null
    //   31: invokestatic 125	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   34: aload_0
    //   35: invokestatic 125	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   38: return
    //   39: astore_0
    //   40: aconst_null
    //   41: astore_0
    //   42: aconst_null
    //   43: invokestatic 125	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   46: aload_0
    //   47: invokestatic 125	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   50: return
    //   51: astore_0
    //   52: aconst_null
    //   53: astore_1
    //   54: aconst_null
    //   55: invokestatic 125	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   58: aload_1
    //   59: invokestatic 125	com/tencent/smtt/utils/m:a	(Ljava/io/Closeable;)V
    //   62: aload_0
    //   63: athrow
    //   64: astore_2
    //   65: aload_0
    //   66: astore_1
    //   67: aload_2
    //   68: astore_0
    //   69: goto -15 -> 54
    //   72: astore_1
    //   73: goto -31 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	paramHttpURLConnection	HttpURLConnection
    //   0	76	1	paramArrayOfByte	byte[]
    //   64	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	21	39	java/lang/Exception
    //   0	21	51	finally
    //   21	30	64	finally
    //   21	30	72	java/lang/Exception
  }
  
  private static void b(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getOutputStream();
      paramHttpURLConnection.write(paramArrayOfByte);
      paramHttpURLConnection.flush();
      return;
    }
    catch (Exception paramHttpURLConnection) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.m
 * JD-Core Version:    0.7.0.1
 */