package com.tencent.tbs.one.impl.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.m;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public final class a
  extends com.tencent.tbs.one.impl.a.a<Integer>
{
  String b;
  String c;
  Map<String, String> d;
  byte[] e;
  public a f;
  public boolean g;
  private Context h;
  private int i;
  
  public a(Context paramContext, String paramString)
  {
    this(paramContext, paramString, "GET");
  }
  
  private a(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, paramString1, paramString2, (byte)0);
  }
  
  private a(Context paramContext, String paramString1, String paramString2, byte paramByte)
  {
    this(paramContext, paramString1, paramString2, null, null);
  }
  
  public a(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    this.h = paramContext;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramMap;
    this.e = paramArrayOfByte;
  }
  
  private HttpURLConnection a(String paramString)
  {
    AppMethodBeat.i(174148);
    a(5);
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setConnectTimeout(20000);
      localHttpURLConnection.setRequestProperty("Connection", "close");
      AppMethodBeat.o(174148);
      return localHttpURLConnection;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      a(202, "Failed to parse url ".concat(String.valueOf(paramString)), localMalformedURLException);
      AppMethodBeat.o(174148);
      return null;
    }
    catch (IOException localIOException)
    {
      a(203, "Failed to open connection, url: ".concat(String.valueOf(paramString)), localIOException);
      AppMethodBeat.o(174148);
    }
    return null;
  }
  
  /* Error */
  private boolean a(HttpURLConnection paramHttpURLConnection, String paramString1, String paramString2, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 265
    //   3: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: bipush 10
    //   9: invokevirtual 70	com/tencent/tbs/one/impl/d/a:a	(I)V
    //   12: aload 4
    //   14: ifnull +66 -> 80
    //   17: aload 4
    //   19: invokeinterface 271 1 0
    //   24: invokeinterface 277 1 0
    //   29: astore 6
    //   31: aload 6
    //   33: invokeinterface 282 1 0
    //   38: ifeq +42 -> 80
    //   41: aload 6
    //   43: invokeinterface 286 1 0
    //   48: checkcast 288	java/util/Map$Entry
    //   51: astore 7
    //   53: aload_1
    //   54: aload 7
    //   56: invokeinterface 291 1 0
    //   61: checkcast 106	java/lang/String
    //   64: aload 7
    //   66: invokeinterface 294 1 0
    //   71: checkcast 106	java/lang/String
    //   74: invokevirtual 99	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: goto -46 -> 31
    //   80: aconst_null
    //   81: astore 7
    //   83: aload_1
    //   84: aload_3
    //   85: invokevirtual 297	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   88: aload 7
    //   90: astore 6
    //   92: aload_3
    //   93: ldc_w 299
    //   96: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifeq +103 -> 202
    //   102: aload 7
    //   104: astore 6
    //   106: aload 5
    //   108: ifnull +94 -> 202
    //   111: aload_1
    //   112: invokevirtual 307	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   115: astore_1
    //   116: aload 4
    //   118: ifnull +236 -> 354
    //   121: aload_1
    //   122: astore 6
    //   124: aload 4
    //   126: ldc_w 309
    //   129: invokeinterface 313 2 0
    //   134: checkcast 106	java/lang/String
    //   137: astore 4
    //   139: aload_1
    //   140: astore 6
    //   142: aload 4
    //   144: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   147: ifne +207 -> 354
    //   150: aload_1
    //   151: astore 6
    //   153: aload 4
    //   155: ldc 218
    //   157: invokevirtual 303	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +194 -> 354
    //   163: aload_1
    //   164: astore 6
    //   166: new 321	java/util/zip/GZIPOutputStream
    //   169: dup
    //   170: new 323	java/io/BufferedOutputStream
    //   173: dup
    //   174: aload_1
    //   175: ldc_w 324
    //   178: invokespecial 327	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   181: invokespecial 330	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   184: astore 4
    //   186: aload 4
    //   188: astore_1
    //   189: aload_1
    //   190: aload 5
    //   192: invokevirtual 336	java/io/OutputStream:write	([B)V
    //   195: aload_1
    //   196: invokevirtual 339	java/io/OutputStream:flush	()V
    //   199: aload_1
    //   200: astore 6
    //   202: aload 6
    //   204: invokestatic 237	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   207: ldc_w 265
    //   210: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: iconst_1
    //   214: ireturn
    //   215: astore 4
    //   217: aconst_null
    //   218: astore_1
    //   219: aload_1
    //   220: astore 6
    //   222: aload_0
    //   223: sipush 204
    //   226: new 172	java/lang/StringBuilder
    //   229: dup
    //   230: ldc_w 341
    //   233: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   236: aload_3
    //   237: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc_w 343
    //   243: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_2
    //   247: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: aload 4
    //   255: invokevirtual 117	com/tencent/tbs/one/impl/d/a:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: aload_1
    //   259: invokestatic 237	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   262: ldc_w 265
    //   265: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: iconst_0
    //   269: ireturn
    //   270: astore_3
    //   271: aconst_null
    //   272: astore_1
    //   273: aload_1
    //   274: astore 6
    //   276: aload_0
    //   277: sipush 205
    //   280: ldc_w 345
    //   283: aload_2
    //   284: invokestatic 110	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   287: invokevirtual 114	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   290: aload_3
    //   291: invokevirtual 117	com/tencent/tbs/one/impl/d/a:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   294: aload_1
    //   295: invokestatic 237	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   298: ldc_w 265
    //   301: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: iconst_0
    //   305: ireturn
    //   306: astore_1
    //   307: aconst_null
    //   308: astore 6
    //   310: aload 6
    //   312: invokestatic 237	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   315: ldc_w 265
    //   318: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: aload_1
    //   322: athrow
    //   323: astore_1
    //   324: goto -14 -> 310
    //   327: astore_2
    //   328: aload_1
    //   329: astore 6
    //   331: aload_2
    //   332: astore_1
    //   333: goto -23 -> 310
    //   336: astore_3
    //   337: goto -64 -> 273
    //   340: astore_3
    //   341: goto -68 -> 273
    //   344: astore 4
    //   346: goto -127 -> 219
    //   349: astore 4
    //   351: goto -132 -> 219
    //   354: goto -165 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	a
    //   0	357	1	paramHttpURLConnection	HttpURLConnection
    //   0	357	2	paramString1	String
    //   0	357	3	paramString2	String
    //   0	357	4	paramMap	Map<String, String>
    //   0	357	5	paramArrayOfByte	byte[]
    //   29	301	6	localObject	Object
    //   51	52	7	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   83	88	215	java/net/ProtocolException
    //   92	102	215	java/net/ProtocolException
    //   111	116	215	java/net/ProtocolException
    //   83	88	270	java/lang/Exception
    //   92	102	270	java/lang/Exception
    //   111	116	270	java/lang/Exception
    //   83	88	306	finally
    //   92	102	306	finally
    //   111	116	306	finally
    //   124	139	323	finally
    //   142	150	323	finally
    //   153	163	323	finally
    //   166	186	323	finally
    //   222	258	323	finally
    //   276	294	323	finally
    //   189	199	327	finally
    //   124	139	336	java/lang/Exception
    //   142	150	336	java/lang/Exception
    //   153	163	336	java/lang/Exception
    //   166	186	336	java/lang/Exception
    //   189	199	340	java/lang/Exception
    //   124	139	344	java/net/ProtocolException
    //   142	150	344	java/net/ProtocolException
    //   153	163	344	java/net/ProtocolException
    //   166	186	344	java/net/ProtocolException
    //   189	199	349	java/net/ProtocolException
  }
  
  private boolean c()
  {
    AppMethodBeat.i(174147);
    if (this.a)
    {
      a(104, "Aborted", null);
      AppMethodBeat.o(174147);
      return false;
    }
    AppMethodBeat.o(174147);
    return true;
  }
  
  public final void a()
  {
    AppMethodBeat.i(174146);
    m.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174152);
        a.a(a.this, a.this.b, a.this.c, a.this.d, a.this.e);
        AppMethodBeat.o(174152);
      }
    });
    AppMethodBeat.o(174146);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, Map<String, List<String>> paramMap, InputStream paramInputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.d.a
 * JD-Core Version:    0.7.0.1
 */