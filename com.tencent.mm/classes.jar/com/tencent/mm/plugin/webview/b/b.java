package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public final class b
{
  private static long DIV = 2592000L;
  private static b DIW;
  private c DIX;
  private Map<String, Long> DIY;
  private long DIZ;
  
  public b()
  {
    AppMethodBeat.i(77829);
    this.DIY = new HashMap();
    this.DIZ = 0L;
    AppMethodBeat.o(77829);
  }
  
  private long aGA(String paramString)
  {
    AppMethodBeat.i(77840);
    if (this.DIY.containsKey(paramString))
    {
      l = ((Long)this.DIY.get(paramString)).longValue();
      AppMethodBeat.o(77840);
      return l;
    }
    long l = eNU().aGA(paramString);
    AppMethodBeat.o(77840);
    return l;
  }
  
  /* Error */
  public static String aGy(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 89
    //   5: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 93	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifeq +10 -> 22
    //   15: ldc 89
    //   17: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aconst_null
    //   21: areturn
    //   22: invokestatic 98	java/lang/System:currentTimeMillis	()J
    //   25: lstore_1
    //   26: new 100	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   33: invokestatic 105	com/tencent/mm/plugin/webview/b/c:eNV	()Ljava/lang/String;
    //   36: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: astore_0
    //   47: new 114	com/tencent/mm/vfs/e
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 117	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   55: astore 4
    //   57: aload 4
    //   59: invokevirtual 121	com/tencent/mm/vfs/e:exists	()Z
    //   62: istore_3
    //   63: iload_3
    //   64: ifne +10 -> 74
    //   67: ldc 89
    //   69: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aconst_null
    //   73: areturn
    //   74: aload 4
    //   76: invokestatic 127	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   79: astore_0
    //   80: aload 4
    //   82: invokevirtual 130	com/tencent/mm/vfs/e:length	()J
    //   85: l2i
    //   86: newarray byte
    //   88: astore 4
    //   90: aload_0
    //   91: aload 4
    //   93: invokevirtual 136	java/io/InputStream:read	([B)I
    //   96: pop
    //   97: new 138	java/lang/String
    //   100: dup
    //   101: aload 4
    //   103: invokespecial 141	java/lang/String:<init>	([B)V
    //   106: astore 4
    //   108: aload_0
    //   109: ifnull +7 -> 116
    //   112: aload_0
    //   113: invokevirtual 144	java/io/InputStream:close	()V
    //   116: ldc 146
    //   118: ldc 148
    //   120: iconst_1
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: invokestatic 98	java/lang/System:currentTimeMillis	()J
    //   129: lload_1
    //   130: lsub
    //   131: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   134: aastore
    //   135: invokestatic 157	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: ldc 89
    //   140: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload 4
    //   145: areturn
    //   146: astore 4
    //   148: aconst_null
    //   149: astore_0
    //   150: ldc 146
    //   152: new 100	java/lang/StringBuilder
    //   155: dup
    //   156: ldc 159
    //   158: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload 4
    //   163: invokevirtual 163	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   166: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 167	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: aload 5
    //   177: astore 4
    //   179: goto -71 -> 108
    //   182: astore_0
    //   183: goto -67 -> 116
    //   186: astore 4
    //   188: goto -38 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramString	String
    //   25	105	1	l	long
    //   62	2	3	bool	boolean
    //   55	89	4	localObject1	Object
    //   146	16	4	localException1	java.lang.Exception
    //   177	1	4	localObject2	Object
    //   186	1	4	localException2	java.lang.Exception
    //   1	175	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   47	63	146	java/lang/Exception
    //   74	80	146	java/lang/Exception
    //   112	116	182	java/io/IOException
    //   80	108	186	java/lang/Exception
  }
  
  private static long bv(String paramString, long paramLong)
  {
    AppMethodBeat.i(77841);
    if (paramString.equals("wx62d9035fd4fd2059"))
    {
      AppMethodBeat.o(77841);
      return paramLong - 104857600L;
    }
    AppMethodBeat.o(77841);
    return paramLong - 10485760L;
  }
  
  public static b eNT()
  {
    AppMethodBeat.i(77830);
    if (DIW == null) {
      DIW = new b();
    }
    b localb = DIW;
    AppMethodBeat.o(77830);
    return localb;
  }
  
  public static boolean kH(String paramString1, String paramString2)
  {
    bool = false;
    AppMethodBeat.i(77833);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(77833);
      return false;
    }
    ad.d("MicroMsg.WebViewDataCenter", "PageCache cache_size:%d, cache_content:%s", new Object[] { Integer.valueOf(paramString2.getBytes().length), paramString2 });
    String str = c.eNV() + paramString1;
    paramString1 = new com.tencent.mm.vfs.e(c.eNV());
    if ((!paramString1.exists()) || (!paramString1.isDirectory())) {
      paramString1.mkdirs();
    }
    Object localObject = null;
    paramString1 = localObject;
    try
    {
      byte[] arrayOfByte = paramString2.getBytes();
      paramString1 = localObject;
      paramString2 = i.cX(str, false);
      paramString1 = paramString2;
      paramString2.write(arrayOfByte);
      bool = true;
      paramString1 = paramString2;
    }
    catch (IOException paramString2)
    {
      try
      {
        paramString1.close();
        AppMethodBeat.o(77833);
        return bool;
        paramString2 = paramString2;
        ad.e("MicroMsg.WebViewDataCenter", "savePageCache: " + paramString2.getMessage());
      }
      catch (IOException paramString1)
      {
        break label148;
      }
    }
    if (paramString1 == null) {}
  }
  
  public static long kI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77836);
    long l = paramString1.getBytes().length + paramString2.getBytes().length;
    AppMethodBeat.o(77836);
    return l;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    AppMethodBeat.i(77832);
    paramBoolean = a(paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean, kI(paramString2, paramString3), "");
    AppMethodBeat.o(77832);
    return paramBoolean;
  }
  
  public final boolean a(String paramString1, String paramString2, final String paramString3, final String paramString4, final String paramString5, boolean paramBoolean, long paramLong, final String paramString6)
  {
    AppMethodBeat.i(77835);
    long l1 = eNU().kK(paramString1, paramString2);
    long l2 = paramLong - l1;
    final long l3 = aGA(paramString1) + l2;
    final long l4 = bv(paramString1, l3);
    ad.i("MicroMsg.WebViewDataCenter", "prevSize = %d, valueSize = %d, diffSize = %d, newAppSize = %d, expireSize = %d", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4) });
    if ((l4 > 0L) && (!paramBoolean))
    {
      AppMethodBeat.o(77835);
      return false;
    }
    com.tencent.mm.plugin.webview.a.a.af(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(77828);
        label109:
        c localc;
        String str;
        if (l4 > 0L)
        {
          l = b.this.eNU().bx(l3, l4);
          b.a(b.this).put(l3, Long.valueOf(paramString3 - l));
          if (!bt.isNullOrNil(paramString4)) {
            break label191;
          }
          b.this.eNU().a(l3, paramString5, "", bt.bI(paramString6, "1"), b.aGB(this.DJd), this.cYz);
          localc = b.this.eNU();
          str = l3;
          if (b.a(b.this).get(l3) != null) {
            break label234;
          }
        }
        label191:
        label234:
        for (long l = 0L;; l = ((Long)b.a(b.this).get(l3)).longValue())
        {
          localc.bw(str, l);
          b.b(b.this);
          AppMethodBeat.o(77828);
          return;
          b.a(b.this).put(l3, Long.valueOf(paramString3));
          break;
          b.this.eNU().a(l3, paramString5, paramString4, bt.bI(paramString6, "1"), b.aGB(this.DJd), "");
          break label109;
        }
      }
    });
    AppMethodBeat.o(77835);
    return true;
  }
  
  public final void aGz(String paramString)
  {
    AppMethodBeat.i(77839);
    eNU().aGz(paramString);
    AppMethodBeat.o(77839);
  }
  
  public final void b(String paramString, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(77838);
    eNU().b(paramString, paramJSONArray);
    AppMethodBeat.o(77838);
  }
  
  public final c eNU()
  {
    AppMethodBeat.i(77831);
    if (this.DIX == null)
    {
      g.ajD();
      this.DIX = new c(g.ajC().gBq);
    }
    c localc = this.DIX;
    AppMethodBeat.o(77831);
    return localc;
  }
  
  public final a kJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77837);
    paramString1 = eNU().kJ(paramString1, paramString2);
    AppMethodBeat.o(77837);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.b
 * JD-Core Version:    0.7.0.1
 */