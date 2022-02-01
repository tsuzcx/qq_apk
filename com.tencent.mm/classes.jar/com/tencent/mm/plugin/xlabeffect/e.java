package com.tencent.mm.plugin.xlabeffect;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;
import com.tencent.mm.xeffect.c;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/xlabeffect/XLabFileUtil;", "", "()V", "TAG", "", "assetsRoot", "filterPath", "getFilterPath", "()Ljava/lang/String;", "imageLabelName", "getImageLabelName", "localRoot", "getLocalRoot", "modelRoot", "getModelRoot", "versionFile", "checkFile", "", "checkVersionMatch", "", "copyAssets", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "plugin-xlabeffect_release"})
public final class e
{
  private static final String JRD;
  private static final String JRE = "ImageLabel81V1.0.0.21.xnet";
  public static final e JRF;
  private static final String TAG = "MicroMsg.XLabFileUtil";
  private static final String hDj;
  private static final String hiv;
  
  static
  {
    AppMethodBeat.i(90537);
    JRF = new e();
    TAG = "MicroMsg.XLabFileUtil";
    hiv = com.tencent.mm.loader.j.b.aKC() + "xlab";
    JRD = hiv + "/Models";
    hDj = hiv + "/filters";
    JRE = "ImageLabel81V1.0.0.21.xnet";
    AppMethodBeat.o(90537);
  }
  
  /* Error */
  public static void a(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 107
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ldc 108
    //   11: invokestatic 114	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_1
    //   15: ldc 115
    //   17: invokestatic 114	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: aload_2
    //   21: ldc 116
    //   23: invokestatic 114	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   26: getstatic 66	com/tencent/mm/plugin/xlabeffect/e:TAG	Ljava/lang/String;
    //   29: astore 6
    //   31: new 68	java/lang/StringBuilder
    //   34: dup
    //   35: ldc 118
    //   37: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: astore 7
    //   42: getstatic 127	com/tencent/mm/xeffect/c:RxL	Lcom/tencent/mm/xeffect/c;
    //   45: astore 8
    //   47: aload 6
    //   49: aload 7
    //   51: invokestatic 130	com/tencent/mm/xeffect/c:his	()Ljava/lang/String;
    //   54: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 141	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   68: astore 6
    //   70: aload 6
    //   72: ifnonnull +9 -> 81
    //   75: ldc 107
    //   77: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: return
    //   81: aload 6
    //   83: ldc 143
    //   85: invokestatic 146	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   88: aload 6
    //   90: arraylength
    //   91: ifne +121 -> 212
    //   94: iconst_1
    //   95: istore_3
    //   96: iload_3
    //   97: ifeq +186 -> 283
    //   100: aload_0
    //   101: aload_1
    //   102: invokevirtual 150	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   105: checkcast 152	java/io/Closeable
    //   108: astore 6
    //   110: aload 6
    //   112: checkcast 154	java/io/InputStream
    //   115: astore_0
    //   116: aload_2
    //   117: invokestatic 160	com/tencent/mm/vfs/s:LM	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   120: checkcast 152	java/io/Closeable
    //   123: astore_2
    //   124: aload_2
    //   125: checkcast 162	java/io/OutputStream
    //   128: astore_1
    //   129: aload_0
    //   130: ldc 164
    //   132: invokestatic 146	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   135: aload_1
    //   136: ldc 166
    //   138: invokestatic 146	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   141: aload_0
    //   142: aload_1
    //   143: invokestatic 172	kotlin/f/a:f	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   146: pop2
    //   147: aload_2
    //   148: aconst_null
    //   149: invokestatic 177	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   152: aload 6
    //   154: aconst_null
    //   155: invokestatic 177	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   158: new 68	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   165: getstatic 85	com/tencent/mm/plugin/xlabeffect/e:hiv	Ljava/lang/String;
    //   168: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc 179
    //   173: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: astore_0
    //   180: getstatic 127	com/tencent/mm/xeffect/c:RxL	Lcom/tencent/mm/xeffect/c;
    //   183: astore_1
    //   184: invokestatic 130	com/tencent/mm/xeffect/c:his	()Ljava/lang/String;
    //   187: getstatic 185	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   190: invokevirtual 191	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   193: astore_1
    //   194: aload_1
    //   195: ldc 193
    //   197: invokestatic 146	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   200: aload_0
    //   201: aload_1
    //   202: invokestatic 197	com/tencent/mm/vfs/s:C	(Ljava/lang/String;[B)I
    //   205: pop
    //   206: ldc 107
    //   208: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: return
    //   212: iconst_0
    //   213: istore_3
    //   214: goto -118 -> 96
    //   217: astore_1
    //   218: ldc 107
    //   220: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: aload_1
    //   224: athrow
    //   225: astore_0
    //   226: aload_2
    //   227: aload_1
    //   228: invokestatic 177	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   231: ldc 107
    //   233: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_0
    //   237: athrow
    //   238: astore_1
    //   239: ldc 107
    //   241: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: aload_1
    //   245: athrow
    //   246: astore_0
    //   247: aload 6
    //   249: aload_1
    //   250: invokestatic 177	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   253: ldc 107
    //   255: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aload_0
    //   259: athrow
    //   260: astore_0
    //   261: getstatic 66	com/tencent/mm/plugin/xlabeffect/e:TAG	Ljava/lang/String;
    //   264: aload_0
    //   265: checkcast 106	java/lang/Throwable
    //   268: ldc 198
    //   270: iconst_0
    //   271: anewarray 4	java/lang/Object
    //   274: invokestatic 202	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   277: ldc 107
    //   279: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: return
    //   283: aload_2
    //   284: invokestatic 206	com/tencent/mm/vfs/s:boN	(Ljava/lang/String;)Z
    //   287: pop
    //   288: aload 6
    //   290: arraylength
    //   291: istore 4
    //   293: iconst_0
    //   294: istore_3
    //   295: iload_3
    //   296: iload 4
    //   298: if_icmpge -140 -> 158
    //   301: aload 6
    //   303: iload_3
    //   304: aaload
    //   305: astore 5
    //   307: aload_0
    //   308: new 68	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   315: aload_1
    //   316: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: bipush 47
    //   321: invokevirtual 209	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   324: aload 5
    //   326: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: new 68	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   339: aload_2
    //   340: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: bipush 47
    //   345: invokevirtual 209	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   348: aload 5
    //   350: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 211	com/tencent/mm/plugin/xlabeffect/e:a	(Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;)V
    //   359: iload_3
    //   360: iconst_1
    //   361: iadd
    //   362: istore_3
    //   363: goto -68 -> 295
    //   366: astore_0
    //   367: aload 5
    //   369: astore_1
    //   370: goto -123 -> 247
    //   373: astore_0
    //   374: aconst_null
    //   375: astore_1
    //   376: goto -150 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	paramAssetManager	AssetManager
    //   0	379	1	paramString1	String
    //   0	379	2	paramString2	String
    //   95	268	3	i	int
    //   291	8	4	j	int
    //   1	367	5	str	String
    //   29	273	6	localObject	Object
    //   40	10	7	localStringBuilder	StringBuilder
    //   45	1	8	localc	c
    // Exception table:
    //   from	to	target	type
    //   124	147	217	java/lang/Throwable
    //   218	225	225	finally
    //   110	124	238	java/lang/Throwable
    //   147	152	238	java/lang/Throwable
    //   226	238	238	java/lang/Throwable
    //   239	246	246	finally
    //   63	70	260	java/lang/Exception
    //   75	80	260	java/lang/Exception
    //   81	94	260	java/lang/Exception
    //   100	110	260	java/lang/Exception
    //   152	158	260	java/lang/Exception
    //   158	206	260	java/lang/Exception
    //   247	260	260	java/lang/Exception
    //   283	293	260	java/lang/Exception
    //   307	359	260	java/lang/Exception
    //   110	124	366	finally
    //   147	152	366	finally
    //   226	238	366	finally
    //   124	147	373	finally
  }
  
  public static String glt()
  {
    return hiv;
  }
  
  public static String glu()
  {
    return JRD;
  }
  
  public static String glv()
  {
    return JRE;
  }
  
  public static void glw()
  {
    AppMethodBeat.i(90535);
    if (!glx())
    {
      s.deleteDir(hiv);
      s.boN(hiv);
      Object localObject = d.rNG;
      if (!d.aob("xlab"))
      {
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        localObject = ((Context)localObject).getAssets();
        p.g(localObject, "MMApplicationContext.getContext().assets");
        a((AssetManager)localObject, "xlab", hiv);
        AppMethodBeat.o(90535);
        return;
      }
      localObject = d.rNG;
      d.z((kotlin.g.a.b)a.JRG);
    }
    AppMethodBeat.o(90535);
  }
  
  private static boolean glx()
  {
    AppMethodBeat.i(215244);
    String str = hiv + "/version.txt";
    if (s.YS(str)) {}
    for (str = s.boY(str);; str = "")
    {
      Object localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder("checkVersionMatch: ").append(str).append(", ");
      c localc = c.RxL;
      Log.i((String)localObject, c.his());
      localObject = c.RxL;
      p.g(str, "localVersion");
      boolean bool = c.bpD(str);
      AppMethodBeat.o(215244);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/mm/plugin/expansions/ExpansionsKtWrapper;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.expansions.b, x>
  {
    public static final a JRG;
    
    static
    {
      AppMethodBeat.i(90534);
      JRG = new a();
      AppMethodBeat.o(90534);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.e
 * JD-Core Version:    0.7.0.1
 */