package com.tencent.mm.plugin.xlabeffect;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.u;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/xlabeffect/XLabFileUtil;", "", "()V", "TAG", "", "assetsRoot", "filterPath", "getFilterPath", "()Ljava/lang/String;", "imageLabelName", "getImageLabelName", "localRoot", "getLocalRoot", "makeupRoot", "getMakeupRoot", "modelRoot", "getModelRoot", "versionFile", "checkFile", "", "checkFileMd5", "checkFileMd5Match", "", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "checkVersionMatch", "copyAssets", "plugin-xlabeffect_release"})
public final class h
{
  private static final String QQE;
  private static final String QQF;
  private static final String QQG = "ImageLabel81V1.0.0.21.xnet";
  public static final h QQH;
  private static final String TAG = "MicroMsg.XLabFileUtil";
  private static final String jUt;
  private static final String krc;
  
  static
  {
    AppMethodBeat.i(90537);
    QQH = new h();
    TAG = "MicroMsg.XLabFileUtil";
    jUt = com.tencent.mm.loader.j.b.aSE() + "xlab";
    QQE = jUt + "/Models";
    QQF = jUt + "/Makeup";
    krc = jUt + "/filters";
    QQG = "ImageLabel81V1.0.0.21.xnet";
    AppMethodBeat.o(90537);
  }
  
  /* Error */
  public static void a(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 118
    //   5: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ldc 119
    //   11: invokestatic 125	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_1
    //   15: ldc 126
    //   17: invokestatic 125	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: aload_2
    //   21: ldc 127
    //   23: invokestatic 125	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   26: getstatic 73	com/tencent/mm/plugin/xlabeffect/h:TAG	Ljava/lang/String;
    //   29: new 75	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 129
    //   35: invokespecial 132	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: aload_1
    //   39: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 134
    //   44: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_2
    //   48: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 139	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_0
    //   58: aload_1
    //   59: invokevirtual 145	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   62: astore 6
    //   64: aload 6
    //   66: ifnonnull +9 -> 75
    //   69: ldc 118
    //   71: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: return
    //   75: aload 6
    //   77: ldc 147
    //   79: invokestatic 150	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   82: aload 6
    //   84: arraylength
    //   85: ifne +121 -> 206
    //   88: iconst_1
    //   89: istore_3
    //   90: iload_3
    //   91: ifeq +186 -> 277
    //   94: aload_0
    //   95: aload_1
    //   96: invokevirtual 154	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   99: checkcast 156	java/io/Closeable
    //   102: astore 6
    //   104: aload 6
    //   106: checkcast 158	java/io/InputStream
    //   109: astore_0
    //   110: aload_2
    //   111: invokestatic 164	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   114: checkcast 156	java/io/Closeable
    //   117: astore_2
    //   118: aload_2
    //   119: checkcast 166	java/io/OutputStream
    //   122: astore_1
    //   123: aload_0
    //   124: ldc 168
    //   126: invokestatic 150	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   129: aload_1
    //   130: ldc 170
    //   132: invokestatic 150	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   135: aload_0
    //   136: aload_1
    //   137: invokestatic 176	kotlin/f/a:g	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   140: pop2
    //   141: aload_2
    //   142: aconst_null
    //   143: invokestatic 181	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   146: aload 6
    //   148: aconst_null
    //   149: invokestatic 181	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   152: new 75	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   159: getstatic 92	com/tencent/mm/plugin/xlabeffect/h:jUt	Ljava/lang/String;
    //   162: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc 183
    //   167: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: astore_0
    //   174: getstatic 189	com/tencent/mm/xeffect/d:YZr	Lcom/tencent/mm/xeffect/d;
    //   177: astore_1
    //   178: invokestatic 192	com/tencent/mm/xeffect/d:ijY	()Ljava/lang/String;
    //   181: getstatic 198	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   184: invokevirtual 204	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   187: astore_1
    //   188: aload_1
    //   189: ldc 206
    //   191: invokestatic 150	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   194: aload_0
    //   195: aload_1
    //   196: invokestatic 210	com/tencent/mm/vfs/u:H	(Ljava/lang/String;[B)I
    //   199: pop
    //   200: ldc 118
    //   202: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: return
    //   206: iconst_0
    //   207: istore_3
    //   208: goto -118 -> 90
    //   211: astore_1
    //   212: ldc 118
    //   214: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_1
    //   218: athrow
    //   219: astore_0
    //   220: aload_2
    //   221: aload_1
    //   222: invokestatic 181	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   225: ldc 118
    //   227: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: aload_0
    //   231: athrow
    //   232: astore_1
    //   233: ldc 118
    //   235: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_1
    //   239: athrow
    //   240: astore_0
    //   241: aload 6
    //   243: aload_1
    //   244: invokestatic 181	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   247: ldc 118
    //   249: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_0
    //   253: athrow
    //   254: astore_0
    //   255: getstatic 73	com/tencent/mm/plugin/xlabeffect/h:TAG	Ljava/lang/String;
    //   258: aload_0
    //   259: checkcast 117	java/lang/Throwable
    //   262: ldc 211
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: ldc 118
    //   273: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: return
    //   277: aload_2
    //   278: invokestatic 219	com/tencent/mm/vfs/u:bBD	(Ljava/lang/String;)Z
    //   281: pop
    //   282: aload 6
    //   284: arraylength
    //   285: istore 4
    //   287: iconst_0
    //   288: istore_3
    //   289: iload_3
    //   290: iload 4
    //   292: if_icmpge -140 -> 152
    //   295: aload 6
    //   297: iload_3
    //   298: aaload
    //   299: astore 5
    //   301: aload_0
    //   302: new 75	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   309: aload_1
    //   310: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: bipush 47
    //   315: invokevirtual 222	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   318: aload 5
    //   320: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: new 75	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   333: aload_2
    //   334: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: bipush 47
    //   339: invokevirtual 222	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   342: aload 5
    //   344: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 224	com/tencent/mm/plugin/xlabeffect/h:a	(Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;)V
    //   353: iload_3
    //   354: iconst_1
    //   355: iadd
    //   356: istore_3
    //   357: goto -68 -> 289
    //   360: astore_0
    //   361: aload 5
    //   363: astore_1
    //   364: goto -123 -> 241
    //   367: astore_0
    //   368: aconst_null
    //   369: astore_1
    //   370: goto -150 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	paramAssetManager	AssetManager
    //   0	373	1	paramString1	String
    //   0	373	2	paramString2	String
    //   89	268	3	i	int
    //   285	8	4	j	int
    //   1	361	5	str	String
    //   62	234	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   118	141	211	java/lang/Throwable
    //   212	219	219	finally
    //   104	118	232	java/lang/Throwable
    //   141	146	232	java/lang/Throwable
    //   220	232	232	java/lang/Throwable
    //   233	240	240	finally
    //   57	64	254	java/lang/Exception
    //   69	74	254	java/lang/Exception
    //   75	88	254	java/lang/Exception
    //   94	104	254	java/lang/Exception
    //   146	152	254	java/lang/Exception
    //   152	200	254	java/lang/Exception
    //   241	254	254	java/lang/Exception
    //   277	287	254	java/lang/Exception
    //   301	353	254	java/lang/Exception
    //   104	118	360	finally
    //   141	146	360	finally
    //   220	232	360	finally
    //   118	141	367	finally
  }
  
  private static boolean b(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    AppMethodBeat.i(186942);
    for (;;)
    {
      Object localObject;
      String str;
      try
      {
        localObject = paramAssetManager.list(paramString1);
        if (localObject == null)
        {
          AppMethodBeat.o(186942);
          return true;
        }
        p.j(localObject, "assets.list(assetsPath) ?: return true");
        if (localObject.length != 0) {
          break label254;
        }
        i = 1;
        if (i != 0)
        {
          localObject = u.buc("assets:///".concat(String.valueOf(paramString1)));
          str = u.buc(paramString2);
          if ((p.h(localObject, str) ^ true))
          {
            Log.i(TAG, "checkFileMd5Match: " + paramString1 + " is " + (String)localObject + "; " + paramString2 + " is " + str);
            a(paramAssetManager, paramString1, paramString2);
            AppMethodBeat.o(186942);
            return false;
          }
          AppMethodBeat.o(186942);
          return true;
        }
      }
      catch (Exception paramAssetManager)
      {
        Log.printErrStackTrace(TAG, (Throwable)paramAssetManager, "checkFileMd5Match", new Object[0]);
        AppMethodBeat.o(186942);
        return false;
      }
      u.bBD(paramString2);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        str = localObject[i];
        b(paramAssetManager, paramString1 + '/' + str, paramString2 + '/' + str);
        i += 1;
      }
      continue;
      label254:
      i = 0;
    }
  }
  
  public static String hfi()
  {
    return jUt;
  }
  
  public static String hfj()
  {
    return QQE;
  }
  
  public static String hfk()
  {
    return QQF;
  }
  
  public static String hfl()
  {
    return QQG;
  }
  
  public static void hfm()
  {
    AppMethodBeat.i(90535);
    if (!hfo())
    {
      u.deleteDir(jUt);
      u.bBD(jUt);
      Object localObject = com.tencent.mm.plugin.expansions.d.vtq;
      if (!com.tencent.mm.plugin.expansions.d.avZ("xlab"))
      {
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        localObject = ((Context)localObject).getAssets();
        p.j(localObject, "MMApplicationContext.getContext().assets");
        a((AssetManager)localObject, "xlab", jUt);
        AppMethodBeat.o(90535);
        return;
      }
      localObject = com.tencent.mm.plugin.expansions.d.vtq;
      com.tencent.mm.plugin.expansions.d.D((kotlin.g.a.b)a.QQI);
    }
    AppMethodBeat.o(90535);
  }
  
  public static void hfn()
  {
    AppMethodBeat.i(186934);
    com.tencent.mm.ae.d.b("XLabFileUtil_checkFile", (a)b.QQL);
    AppMethodBeat.o(186934);
  }
  
  private static boolean hfo()
  {
    AppMethodBeat.i(186938);
    String str = jUt + "/version.txt";
    if (u.agG(str)) {}
    for (str = u.bBS(str);; str = "")
    {
      Object localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder("checkVersionMatch: ").append(str).append(", ");
      com.tencent.mm.xeffect.d locald = com.tencent.mm.xeffect.d.YZr;
      Log.i((String)localObject, com.tencent.mm.xeffect.d.ijY());
      localObject = com.tencent.mm.xeffect.d.YZr;
      p.j(str, "localVersion");
      boolean bool = com.tencent.mm.xeffect.d.bCA(str);
      AppMethodBeat.o(186938);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/plugin/expansions/ExpansionsKtWrapper;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.expansions.b, x>
  {
    public static final a QQI;
    
    static
    {
      AppMethodBeat.i(90534);
      QQI = new a();
      AppMethodBeat.o(90534);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    public static final b QQL;
    
    static
    {
      AppMethodBeat.i(186883);
      QQL = new b();
      AppMethodBeat.o(186883);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.h
 * JD-Core Version:    0.7.0.1
 */