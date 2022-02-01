package com.tencent.mm.plugin.xlabeffect;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.i;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/xlabeffect/XLabFileUtil;", "", "()V", "TAG", "", "assetsRoot", "filterPath", "getFilterPath", "()Ljava/lang/String;", "localRoot", "getLocalRoot", "modelRoot", "getModelRoot", "versionFile", "checkFile", "", "checkVersionMatch", "", "copyAssets", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "plugin-xlabeffect_release"})
public final class d
{
  private static final String EIl;
  private static final String EIm;
  public static final d EIn;
  private static final String TAG = "MicroMsg.XLabFileUtil";
  private static final String gsZ;
  
  static
  {
    AppMethodBeat.i(90537);
    EIn = new d();
    TAG = "MicroMsg.XLabFileUtil";
    gsZ = com.tencent.mm.loader.j.b.arN() + "xlab";
    EIl = gsZ + "/Models";
    EIm = gsZ + "/filters";
    AppMethodBeat.o(90537);
  }
  
  /* Error */
  public static void a(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 100
    //   5: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ldc 101
    //   11: invokestatic 107	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_1
    //   15: ldc 108
    //   17: invokestatic 107	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: aload_2
    //   21: ldc 109
    //   23: invokestatic 107	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   26: getstatic 61	com/tencent/mm/plugin/xlabeffect/d:TAG	Ljava/lang/String;
    //   29: astore 6
    //   31: new 63	java/lang/StringBuilder
    //   34: dup
    //   35: ldc 111
    //   37: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: astore 7
    //   42: getstatic 120	com/tencent/mm/xeffect/d:LBD	Lcom/tencent/mm/xeffect/d;
    //   45: astore 8
    //   47: aload 6
    //   49: aload 7
    //   51: invokestatic 123	com/tencent/mm/xeffect/d:fSt	()Ljava/lang/String;
    //   54: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 128	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 134	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   68: astore 6
    //   70: aload 6
    //   72: ifnonnull +9 -> 81
    //   75: ldc 100
    //   77: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: return
    //   81: aload 6
    //   83: arraylength
    //   84: ifne +121 -> 205
    //   87: iconst_1
    //   88: istore_3
    //   89: iload_3
    //   90: ifeq +186 -> 276
    //   93: aload_0
    //   94: aload_1
    //   95: invokevirtual 138	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   98: checkcast 140	java/io/Closeable
    //   101: astore 6
    //   103: aload 6
    //   105: checkcast 142	java/io/InputStream
    //   108: astore_0
    //   109: aload_2
    //   110: invokestatic 148	com/tencent/mm/vfs/i:Cz	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   113: checkcast 140	java/io/Closeable
    //   116: astore_2
    //   117: aload_2
    //   118: checkcast 150	java/io/OutputStream
    //   121: astore_1
    //   122: aload_0
    //   123: ldc 152
    //   125: invokestatic 155	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   128: aload_1
    //   129: ldc 157
    //   131: invokestatic 155	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   134: aload_0
    //   135: aload_1
    //   136: invokestatic 162	d/f/a:g	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   139: pop2
    //   140: aload_2
    //   141: aconst_null
    //   142: invokestatic 167	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   145: aload 6
    //   147: aconst_null
    //   148: invokestatic 167	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   151: new 63	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   158: getstatic 80	com/tencent/mm/plugin/xlabeffect/d:gsZ	Ljava/lang/String;
    //   161: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 169
    //   166: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: astore_0
    //   173: getstatic 120	com/tencent/mm/xeffect/d:LBD	Lcom/tencent/mm/xeffect/d;
    //   176: astore_1
    //   177: invokestatic 123	com/tencent/mm/xeffect/d:fSt	()Ljava/lang/String;
    //   180: getstatic 175	d/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   183: invokevirtual 181	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   186: astore_1
    //   187: aload_1
    //   188: ldc 183
    //   190: invokestatic 155	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   193: aload_0
    //   194: aload_1
    //   195: invokestatic 187	com/tencent/mm/vfs/i:C	(Ljava/lang/String;[B)I
    //   198: pop
    //   199: ldc 100
    //   201: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: return
    //   205: iconst_0
    //   206: istore_3
    //   207: goto -118 -> 89
    //   210: astore_1
    //   211: ldc 100
    //   213: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: aload_1
    //   217: athrow
    //   218: astore_0
    //   219: aload_2
    //   220: aload_1
    //   221: invokestatic 167	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   224: ldc 100
    //   226: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: aload_0
    //   230: athrow
    //   231: astore_1
    //   232: ldc 100
    //   234: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_1
    //   238: athrow
    //   239: astore_0
    //   240: aload 6
    //   242: aload_1
    //   243: invokestatic 167	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   246: ldc 100
    //   248: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: aload_0
    //   252: athrow
    //   253: astore_0
    //   254: getstatic 61	com/tencent/mm/plugin/xlabeffect/d:TAG	Ljava/lang/String;
    //   257: aload_0
    //   258: checkcast 99	java/lang/Throwable
    //   261: ldc 188
    //   263: iconst_0
    //   264: anewarray 4	java/lang/Object
    //   267: invokestatic 192	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: ldc 100
    //   272: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: return
    //   276: aload_2
    //   277: invokestatic 196	com/tencent/mm/vfs/i:aYg	(Ljava/lang/String;)Z
    //   280: pop
    //   281: aload 6
    //   283: arraylength
    //   284: istore 4
    //   286: iconst_0
    //   287: istore_3
    //   288: iload_3
    //   289: iload 4
    //   291: if_icmpge -140 -> 151
    //   294: aload 6
    //   296: iload_3
    //   297: aaload
    //   298: astore 5
    //   300: aload_0
    //   301: new 63	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   308: aload_1
    //   309: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: bipush 47
    //   314: invokevirtual 199	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   317: aload 5
    //   319: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: new 63	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   332: aload_2
    //   333: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: bipush 47
    //   338: invokevirtual 199	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   341: aload 5
    //   343: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 201	com/tencent/mm/plugin/xlabeffect/d:a	(Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;)V
    //   352: iload_3
    //   353: iconst_1
    //   354: iadd
    //   355: istore_3
    //   356: goto -68 -> 288
    //   359: astore_0
    //   360: aload 5
    //   362: astore_1
    //   363: goto -123 -> 240
    //   366: astore_0
    //   367: aconst_null
    //   368: astore_1
    //   369: goto -150 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	paramAssetManager	AssetManager
    //   0	372	1	paramString1	String
    //   0	372	2	paramString2	String
    //   88	268	3	i	int
    //   284	8	4	j	int
    //   1	360	5	str	String
    //   29	266	6	localObject	Object
    //   40	10	7	localStringBuilder	StringBuilder
    //   45	1	8	locald	com.tencent.mm.xeffect.d
    // Exception table:
    //   from	to	target	type
    //   117	140	210	java/lang/Throwable
    //   211	218	218	finally
    //   103	117	231	java/lang/Throwable
    //   140	145	231	java/lang/Throwable
    //   219	231	231	java/lang/Throwable
    //   232	239	239	finally
    //   63	70	253	java/lang/Exception
    //   75	80	253	java/lang/Exception
    //   81	87	253	java/lang/Exception
    //   93	103	253	java/lang/Exception
    //   145	151	253	java/lang/Exception
    //   151	199	253	java/lang/Exception
    //   240	253	253	java/lang/Exception
    //   276	286	253	java/lang/Exception
    //   300	352	253	java/lang/Exception
    //   103	117	359	finally
    //   140	145	359	finally
    //   219	231	359	finally
    //   117	140	366	finally
  }
  
  public static String eYw()
  {
    return gsZ;
  }
  
  public static String eYx()
  {
    return EIl;
  }
  
  public static void eYy()
  {
    AppMethodBeat.i(90535);
    if (!eYz())
    {
      i.deleteDir(gsZ);
      i.aYg(gsZ);
      Object localObject = com.tencent.mm.plugin.expansions.d.qpt;
      if (!com.tencent.mm.plugin.expansions.d.adb("xlab"))
      {
        localObject = aj.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        localObject = ((Context)localObject).getAssets();
        p.g(localObject, "MMApplicationContext.getContext().assets");
        a((AssetManager)localObject, "xlab", gsZ);
        AppMethodBeat.o(90535);
        return;
      }
      localObject = com.tencent.mm.plugin.expansions.d.qpt;
      com.tencent.mm.plugin.expansions.d.z((d.g.a.b)a.EIo);
    }
    AppMethodBeat.o(90535);
  }
  
  private static boolean eYz()
  {
    AppMethodBeat.i(220335);
    String str = gsZ + "/version.txt";
    if (i.fv(str)) {}
    for (str = i.aYq(str);; str = "")
    {
      Object localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder("checkVersionMatch: ").append(str).append(", ");
      com.tencent.mm.xeffect.d locald = com.tencent.mm.xeffect.d.LBD;
      ad.i((String)localObject, com.tencent.mm.xeffect.d.fSt());
      localObject = com.tencent.mm.xeffect.d.LBD;
      p.g(str, "localVersion");
      boolean bool = com.tencent.mm.xeffect.d.aYS(str);
      AppMethodBeat.o(220335);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/mm/plugin/expansions/ExpansionsKtWrapper;", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<com.tencent.mm.plugin.expansions.b, z>
  {
    public static final a EIo;
    
    static
    {
      AppMethodBeat.i(90534);
      EIo = new a();
      AppMethodBeat.o(90534);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.d
 * JD-Core Version:    0.7.0.1
 */