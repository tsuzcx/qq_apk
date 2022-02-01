package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public final class b
{
  private static long INf = 2592000L;
  private static b INg;
  private c INh;
  private Map<String, Long> INi;
  private long INj;
  
  public b()
  {
    AppMethodBeat.i(77829);
    this.INi = new HashMap();
    this.INj = 0L;
    AppMethodBeat.o(77829);
  }
  
  /* Error */
  public static String aXS(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 52
    //   5: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 58	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifeq +10 -> 22
    //   15: ldc 52
    //   17: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aconst_null
    //   21: areturn
    //   22: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   25: lstore_1
    //   26: new 66	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   33: invokestatic 73	com/tencent/mm/plugin/webview/b/c:gao	()Ljava/lang/String;
    //   36: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: astore_0
    //   47: new 82	com/tencent/mm/vfs/o
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 85	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   55: astore 4
    //   57: aload 4
    //   59: invokevirtual 89	com/tencent/mm/vfs/o:exists	()Z
    //   62: istore_3
    //   63: iload_3
    //   64: ifne +10 -> 74
    //   67: ldc 52
    //   69: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aconst_null
    //   73: areturn
    //   74: aload 4
    //   76: invokestatic 95	com/tencent/mm/vfs/s:ao	(Lcom/tencent/mm/vfs/o;)Ljava/io/InputStream;
    //   79: astore_0
    //   80: aload 4
    //   82: invokevirtual 98	com/tencent/mm/vfs/o:length	()J
    //   85: l2i
    //   86: newarray byte
    //   88: astore 4
    //   90: aload_0
    //   91: aload 4
    //   93: invokevirtual 104	java/io/InputStream:read	([B)I
    //   96: pop
    //   97: new 106	java/lang/String
    //   100: dup
    //   101: aload 4
    //   103: invokespecial 109	java/lang/String:<init>	([B)V
    //   106: astore 4
    //   108: aload_0
    //   109: ifnull +7 -> 116
    //   112: aload_0
    //   113: invokevirtual 112	java/io/InputStream:close	()V
    //   116: ldc 114
    //   118: ldc 116
    //   120: iconst_1
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   129: lload_1
    //   130: lsub
    //   131: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   134: aastore
    //   135: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: ldc 52
    //   140: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload 4
    //   145: areturn
    //   146: astore 4
    //   148: aconst_null
    //   149: astore_0
    //   150: ldc 114
    //   152: new 66	java/lang/StringBuilder
    //   155: dup
    //   156: ldc 129
    //   158: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload 4
    //   163: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   166: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  private long aXU(String paramString)
  {
    AppMethodBeat.i(77840);
    if (this.INi.containsKey(paramString))
    {
      l = ((Long)this.INi.get(paramString)).longValue();
      AppMethodBeat.o(77840);
      return l;
    }
    long l = gan().aXU(paramString);
    AppMethodBeat.o(77840);
    return l;
  }
  
  private static long bx(String paramString, long paramLong)
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
  
  public static b gam()
  {
    AppMethodBeat.i(77830);
    if (INg == null) {
      INg = new b();
    }
    b localb = INg;
    AppMethodBeat.o(77830);
    return localb;
  }
  
  public static boolean lL(String paramString1, String paramString2)
  {
    bool = false;
    AppMethodBeat.i(77833);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(77833);
      return false;
    }
    Log.d("MicroMsg.WebViewDataCenter", "PageCache cache_size:%d, cache_content:%s", new Object[] { Integer.valueOf(paramString2.getBytes().length), paramString2 });
    String str = c.gao() + paramString1;
    paramString1 = new o(c.gao());
    if ((!paramString1.exists()) || (!paramString1.isDirectory())) {
      paramString1.mkdirs();
    }
    Object localObject = null;
    paramString1 = localObject;
    try
    {
      byte[] arrayOfByte = paramString2.getBytes();
      paramString1 = localObject;
      paramString2 = s.dw(str, false);
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
        Log.e("MicroMsg.WebViewDataCenter", "savePageCache: " + paramString2.getMessage());
      }
      catch (IOException paramString1)
      {
        break label148;
      }
    }
    if (paramString1 == null) {}
  }
  
  public static long lM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77836);
    long l = paramString1.getBytes().length + paramString2.getBytes().length;
    AppMethodBeat.o(77836);
    return l;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    AppMethodBeat.i(77832);
    paramBoolean = a(paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean, lM(paramString2, paramString3), "");
    AppMethodBeat.o(77832);
    return paramBoolean;
  }
  
  public final boolean a(String paramString1, String paramString2, final String paramString3, final String paramString4, final String paramString5, boolean paramBoolean, long paramLong, final String paramString6)
  {
    AppMethodBeat.i(77835);
    long l1 = gan().lO(paramString1, paramString2);
    long l2 = paramLong - l1;
    final long l3 = aXU(paramString1) + l2;
    final long l4 = bx(paramString1, l3);
    Log.i("MicroMsg.WebViewDataCenter", "prevSize = %d, valueSize = %d, diffSize = %d, newAppSize = %d, expireSize = %d", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4) });
    if ((l4 > 0L) && (!paramBoolean))
    {
      AppMethodBeat.o(77835);
      return false;
    }
    com.tencent.mm.plugin.webview.a.a.aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(77828);
        label109:
        c localc;
        String str;
        if (l4 > 0L)
        {
          l = b.this.gan().bz(l3, l4);
          b.a(b.this).put(l3, Long.valueOf(paramString3 - l));
          if (!Util.isNullOrNil(paramString4)) {
            break label191;
          }
          b.this.gan().a(l3, paramString5, "", Util.nullAs(paramString6, "1"), b.aXV(this.INn), this.val$fileName);
          localc = b.this.gan();
          str = l3;
          if (b.a(b.this).get(l3) != null) {
            break label234;
          }
        }
        label191:
        label234:
        for (long l = 0L;; l = ((Long)b.a(b.this).get(l3)).longValue())
        {
          localc.by(str, l);
          b.b(b.this);
          AppMethodBeat.o(77828);
          return;
          b.a(b.this).put(l3, Long.valueOf(paramString3));
          break;
          b.this.gan().a(l3, paramString5, paramString4, Util.nullAs(paramString6, "1"), b.aXV(this.INn), "");
          break label109;
        }
      }
    });
    AppMethodBeat.o(77835);
    return true;
  }
  
  public final void aXT(String paramString)
  {
    AppMethodBeat.i(77839);
    gan().aXT(paramString);
    AppMethodBeat.o(77839);
  }
  
  public final void b(String paramString, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(77838);
    gan().b(paramString, paramJSONArray);
    AppMethodBeat.o(77838);
  }
  
  public final c gan()
  {
    AppMethodBeat.i(77831);
    if (this.INh == null)
    {
      g.aAi();
      this.INh = new c(g.aAh().hqK);
    }
    c localc = this.INh;
    AppMethodBeat.o(77831);
    return localc;
  }
  
  public final a lN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77837);
    paramString1 = gan().lN(paramString1, paramString2);
    AppMethodBeat.o(77837);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.b
 * JD-Core Version:    0.7.0.1
 */