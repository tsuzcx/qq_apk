package com.tencent.mm.plugin.xlabeffect;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/xlabeffect/XLabFileUtil;", "", "()V", "TAG", "", "alignmentPath", "getAlignmentPath", "()Ljava/lang/String;", "assetsRoot", "core3DModelPath", "getCore3DModelPath", "core3DParamPath", "getCore3DParamPath", "detectModelPath", "getDetectModelPath", "filterPath", "getFilterPath", "gestureClsPath", "getGestureClsPath", "gestureDetPath", "getGestureDetPath", "licensePath", "getLicensePath", "localRoot", "getLocalRoot", "segModelPath", "getSegModelPath", "trackModelPath", "getTrackModelPath", "versionFile", "checkAssetsVersion", "", "checkFile", "", "copyAssets", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "plugin-xlabeffect_release"})
public final class c
{
  private static final String Ark;
  private static final String Dem;
  private static final String Den;
  private static final String Deo;
  private static final String Dep;
  private static final String Deq;
  private static final String Der;
  private static final String Des;
  private static final String Det;
  public static final c Deu;
  private static final String TAG = "MicroMsg.XLabFileUtil";
  private static final String fZD;
  private static final String licensePath;
  
  static
  {
    AppMethodBeat.i(90537);
    Deu = new c();
    TAG = "MicroMsg.XLabFileUtil";
    fZD = com.tencent.mm.loader.j.b.apa() + "xlab";
    licensePath = fZD + "/lic/wechat_face_effect.lic";
    Dem = fZD + "/Models/XNet/face_det_v4.16.xnet";
    Den = fZD + "/Models/XNet/track_reg_v8.16.xnet";
    Deo = fZD + "/Models/XNet/face_alignment_v26.4.16.xbin";
    Dep = fZD + "/Models/XNet/portrait_seg_v10.16.xnet";
    Deq = fZD + "/Models/XNet/gesture_detect.6.16.xnet";
    Der = fZD + "/Models/XNet/gesture_cls13.13.16.xnet";
    Des = fZD + "/Models/FaceKit10K/model_sticker.xbin";
    Det = fZD + "/Models/Params_FaceSticker.json";
    Ark = fZD + "/filters";
    AppMethodBeat.o(90537);
  }
  
  /* Error */
  public static void a(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 155
    //   5: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ldc 156
    //   11: invokestatic 162	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_1
    //   15: ldc 163
    //   17: invokestatic 162	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: aload_2
    //   21: ldc 164
    //   23: invokestatic 162	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 170	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   31: astore 6
    //   33: aload 6
    //   35: ifnonnull +9 -> 44
    //   38: ldc 155
    //   40: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: return
    //   44: aload 6
    //   46: arraylength
    //   47: ifne +96 -> 143
    //   50: iconst_1
    //   51: istore_3
    //   52: iload_3
    //   53: ifeq +138 -> 191
    //   56: aload_0
    //   57: aload_1
    //   58: invokevirtual 174	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   61: checkcast 176	java/io/Closeable
    //   64: astore 6
    //   66: aload 6
    //   68: checkcast 178	java/io/InputStream
    //   71: astore_0
    //   72: aload_2
    //   73: invokestatic 184	com/tencent/mm/vfs/i:zA	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   76: checkcast 176	java/io/Closeable
    //   79: astore_2
    //   80: aload_2
    //   81: checkcast 186	java/io/OutputStream
    //   84: astore_1
    //   85: aload_0
    //   86: ldc 188
    //   88: invokestatic 191	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   91: aload_1
    //   92: ldc 193
    //   94: invokestatic 191	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   97: aload_0
    //   98: aload_1
    //   99: invokestatic 199	d/f/a:f	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   102: pop2
    //   103: aload_2
    //   104: aconst_null
    //   105: invokestatic 204	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   108: aload 6
    //   110: aconst_null
    //   111: invokestatic 204	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   114: ldc 155
    //   116: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: return
    //   120: astore_0
    //   121: getstatic 84	com/tencent/mm/plugin/xlabeffect/c:TAG	Ljava/lang/String;
    //   124: aload_0
    //   125: checkcast 154	java/lang/Throwable
    //   128: ldc 205
    //   130: iconst_0
    //   131: anewarray 4	java/lang/Object
    //   134: invokestatic 211	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: ldc 155
    //   139: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: return
    //   143: iconst_0
    //   144: istore_3
    //   145: goto -93 -> 52
    //   148: astore_1
    //   149: ldc 155
    //   151: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload_1
    //   155: athrow
    //   156: astore_0
    //   157: aload_2
    //   158: aload_1
    //   159: invokestatic 204	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   162: ldc 155
    //   164: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload_0
    //   168: athrow
    //   169: astore_1
    //   170: ldc 155
    //   172: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload_1
    //   176: athrow
    //   177: astore_0
    //   178: aload 6
    //   180: aload_1
    //   181: invokestatic 204	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   184: ldc 155
    //   186: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload_0
    //   190: athrow
    //   191: aload_2
    //   192: invokestatic 215	com/tencent/mm/vfs/i:aSh	(Ljava/lang/String;)Z
    //   195: pop
    //   196: aload 6
    //   198: arraylength
    //   199: istore 4
    //   201: iconst_0
    //   202: istore_3
    //   203: iload_3
    //   204: iload 4
    //   206: if_icmpge +68 -> 274
    //   209: aload 6
    //   211: iload_3
    //   212: aaload
    //   213: astore 5
    //   215: aload_0
    //   216: new 86	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   223: aload_1
    //   224: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: bipush 47
    //   229: invokevirtual 218	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   232: aload 5
    //   234: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: new 86	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   247: aload_2
    //   248: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: bipush 47
    //   253: invokevirtual 218	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   256: aload 5
    //   258: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 220	com/tencent/mm/plugin/xlabeffect/c:a	(Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;)V
    //   267: iload_3
    //   268: iconst_1
    //   269: iadd
    //   270: istore_3
    //   271: goto -68 -> 203
    //   274: ldc 155
    //   276: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: return
    //   280: astore_0
    //   281: aload 5
    //   283: astore_1
    //   284: goto -106 -> 178
    //   287: astore_0
    //   288: aconst_null
    //   289: astore_1
    //   290: goto -133 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramAssetManager	AssetManager
    //   0	293	1	paramString1	String
    //   0	293	2	paramString2	String
    //   51	220	3	i	int
    //   199	8	4	j	int
    //   1	281	5	str	String
    //   31	179	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	33	120	java/lang/Exception
    //   38	43	120	java/lang/Exception
    //   44	50	120	java/lang/Exception
    //   56	66	120	java/lang/Exception
    //   108	119	120	java/lang/Exception
    //   178	191	120	java/lang/Exception
    //   191	201	120	java/lang/Exception
    //   215	267	120	java/lang/Exception
    //   80	103	148	java/lang/Throwable
    //   149	156	156	finally
    //   66	80	169	java/lang/Throwable
    //   103	108	169	java/lang/Throwable
    //   157	169	169	java/lang/Throwable
    //   170	177	177	finally
    //   66	80	280	finally
    //   103	108	280	finally
    //   157	169	280	finally
    //   80	103	287	finally
  }
  
  public static String eJD()
  {
    return fZD;
  }
  
  public static String eJE()
  {
    return Dem;
  }
  
  public static String eJF()
  {
    return Den;
  }
  
  public static String eJG()
  {
    return Deo;
  }
  
  public static String eJH()
  {
    return Dep;
  }
  
  public static String eJI()
  {
    return Deq;
  }
  
  public static String eJJ()
  {
    return Der;
  }
  
  public static String eJK()
  {
    return Des;
  }
  
  public static String eJL()
  {
    return Det;
  }
  
  public static void eJM()
  {
    int j = 0;
    AppMethodBeat.i(90535);
    Object localObject = fZD + "/version.txt";
    if (i.eA((String)localObject)) {}
    for (int i = bs.aLy(i.aSr((String)localObject));; i = 0)
    {
      ac.i(TAG, "checkAssetsVersion: 7, ".concat(String.valueOf(i)));
      if (7 != i) {
        j = 1;
      }
      if (j == 0) {
        break label153;
      }
      i.deleteDir(fZD);
      i.aSh(fZD);
      localObject = d.pLO;
      if (d.Zv("xlab")) {
        break;
      }
      localObject = ai.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getAssets();
      k.g(localObject, "MMApplicationContext.getContext().assets");
      a((AssetManager)localObject, "xlab", fZD);
      AppMethodBeat.o(90535);
      return;
    }
    localObject = d.pLO;
    d.y((d.g.a.b)a.Dev);
    label153:
    AppMethodBeat.o(90535);
  }
  
  public static String getLicensePath()
  {
    return licensePath;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/mm/plugin/expansions/ExpansionsKtWrapper;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.expansions.b, y>
  {
    public static final a Dev;
    
    static
    {
      AppMethodBeat.i(90534);
      Dev = new a();
      AppMethodBeat.o(90534);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.c
 * JD-Core Version:    0.7.0.1
 */