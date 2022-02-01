package com.tencent.mm.plugin.xlabeffect;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/xlabeffect/WeVisFileUtil;", "", "()V", "TAG", "", "assetsModelRoot", "assetsRoot", "imageLabelName", "getImageLabelName", "()Ljava/lang/String;", "listConfig", "Lcom/tencent/mm/plugin/xlabeffect/WeVisModelListConfig;", "localRoot", "getLocalRoot", "luaPredScriptDir", "getLuaPredScriptDir", "luaPredScriptRoot", "getLuaPredScriptRoot", "lutFilterDir", "getLutFilterDir", "lutFilterRoot", "getLutFilterRoot", "makeupDir", "getMakeupDir", "makeupRoot", "getMakeupRoot", "modelDir", "getModelDir", "modelListConfig", "getModelListConfig", "()Lcom/tencent/mm/plugin/xlabeffect/WeVisModelListConfig;", "modelListFilename", "modelRoot", "getModelRoot", "modelTemp", "getModelTemp", "versionFile", "checkFile", "", "checkFileMd5", "checkFileMd5Match", "", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "checkModelFile", "config", "Lcom/tencent/mm/plugin/xlabeffect/WeVisModelConfig;", "checkVersionMatch", "copyAssets", "copyConfigFileFromAssets", "copyFromAssets", "copyModelFileFromAssets", "initModelConfig", "modelListConfigPath", "modelPathWithKey", "key", "modelVersionWithKey", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final String TAG;
  public static final d XJR;
  private static final String XJS;
  private static final String XJT;
  private static final String XJU;
  private static final String XJV;
  private static final String XJW;
  private static final String XJX;
  private static final String XJY;
  private static final String XJZ;
  private static final String XKa;
  private static final String XKb;
  private static g XKc;
  private static final String XKd;
  private static final String muL;
  
  static
  {
    AppMethodBeat.i(261777);
    XJR = new d();
    TAG = "MicroMsg.WeVisFileUtil";
    muL = s.X(com.tencent.mm.loader.i.b.bms(), "xlab");
    XJS = "Models";
    String str = muL + '/' + XJS;
    XJT = str;
    XJU = s.X(str, "/temp");
    XJV = "Makeup";
    XJW = muL + '/' + XJV;
    XJX = "LutFilters";
    XJY = muL + '/' + XJX;
    XJZ = "LuaPredScript";
    XKa = muL + '/' + XJZ;
    XKb = "ImageLabel81V1.0.0.21.xnet";
    XKc = new g();
    XKd = s.X("assets:///xlab/", XJS);
    iFT();
    iFQ();
    AppMethodBeat.o(261777);
  }
  
  /* Error */
  private static void a(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 192
    //   2: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 193
    //   8: invokestatic 197	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: ldc 198
    //   14: invokestatic 197	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_2
    //   18: ldc 199
    //   20: invokestatic 197	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: getstatic 107	com/tencent/mm/plugin/xlabeffect/d:TAG	Ljava/lang/String;
    //   26: new 128	java/lang/StringBuilder
    //   29: dup
    //   30: ldc 201
    //   32: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: aload_1
    //   36: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 206
    //   41: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_2
    //   45: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: aload_1
    //   56: invokevirtual 217	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   59: astore 5
    //   61: aload 5
    //   63: ifnonnull +9 -> 72
    //   66: ldc 192
    //   68: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: return
    //   72: aload 5
    //   74: arraylength
    //   75: ifne +97 -> 172
    //   78: iconst_1
    //   79: istore_3
    //   80: iload_3
    //   81: ifeq +140 -> 221
    //   84: aload_0
    //   85: aload_1
    //   86: invokevirtual 221	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   89: checkcast 223	java/io/Closeable
    //   92: astore_0
    //   93: aload_0
    //   94: checkcast 225	java/io/InputStream
    //   97: astore 5
    //   99: aload_2
    //   100: iconst_0
    //   101: invokestatic 231	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   104: checkcast 223	java/io/Closeable
    //   107: astore_1
    //   108: aload_1
    //   109: checkcast 233	java/io/OutputStream
    //   112: astore_2
    //   113: aload 5
    //   115: ldc 235
    //   117: invokestatic 238	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   120: aload_2
    //   121: ldc 240
    //   123: invokestatic 238	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   126: aload 5
    //   128: aload_2
    //   129: invokestatic 246	kotlin/f/a:j	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   132: pop2
    //   133: aload_1
    //   134: aconst_null
    //   135: invokestatic 251	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   138: aload_0
    //   139: aconst_null
    //   140: invokestatic 251	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   143: ldc 192
    //   145: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: return
    //   149: astore_0
    //   150: getstatic 107	com/tencent/mm/plugin/xlabeffect/d:TAG	Ljava/lang/String;
    //   153: aload_0
    //   154: checkcast 253	java/lang/Throwable
    //   157: ldc 254
    //   159: iconst_0
    //   160: anewarray 4	java/lang/Object
    //   163: invokestatic 258	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: ldc 192
    //   168: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: return
    //   172: iconst_0
    //   173: istore_3
    //   174: goto -94 -> 80
    //   177: astore_2
    //   178: ldc 192
    //   180: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_2
    //   184: athrow
    //   185: astore 5
    //   187: aload_1
    //   188: aload_2
    //   189: invokestatic 251	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   192: ldc 192
    //   194: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: aload 5
    //   199: athrow
    //   200: astore_1
    //   201: ldc 192
    //   203: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_1
    //   207: athrow
    //   208: astore_2
    //   209: aload_0
    //   210: aload_1
    //   211: invokestatic 251	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   214: ldc 192
    //   216: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_2
    //   220: athrow
    //   221: aload_2
    //   222: invokestatic 262	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   225: pop
    //   226: aload 5
    //   228: arraylength
    //   229: istore 4
    //   231: iconst_0
    //   232: istore_3
    //   233: iload_3
    //   234: iload 4
    //   236: if_icmpge +68 -> 304
    //   239: aload 5
    //   241: iload_3
    //   242: aaload
    //   243: astore 6
    //   245: aload_0
    //   246: new 128	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   253: aload_1
    //   254: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: bipush 47
    //   259: invokevirtual 136	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   262: aload 6
    //   264: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: new 128	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   277: aload_2
    //   278: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: bipush 47
    //   283: invokevirtual 136	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   286: aload 6
    //   288: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 267	com/tencent/mm/plugin/xlabeffect/d:a	(Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;)V
    //   297: iload_3
    //   298: iconst_1
    //   299: iadd
    //   300: istore_3
    //   301: goto -68 -> 233
    //   304: ldc 192
    //   306: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	paramAssetManager	AssetManager
    //   0	310	1	paramString1	String
    //   0	310	2	paramString2	String
    //   79	222	3	i	int
    //   229	8	4	j	int
    //   59	68	5	localObject1	Object
    //   185	55	5	localObject2	Object
    //   243	44	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   54	61	149	java/lang/Exception
    //   66	71	149	java/lang/Exception
    //   72	78	149	java/lang/Exception
    //   84	93	149	java/lang/Exception
    //   138	148	149	java/lang/Exception
    //   209	221	149	java/lang/Exception
    //   221	231	149	java/lang/Exception
    //   245	297	149	java/lang/Exception
    //   108	133	177	finally
    //   178	185	185	finally
    //   93	108	200	finally
    //   133	138	200	finally
    //   187	200	200	finally
    //   201	208	208	finally
  }
  
  private static boolean a(e parame)
  {
    AppMethodBeat.i(261714);
    parame.obC = -1;
    parame.boK("");
    String str = XJT + '/' + parame.getConfigFileName();
    if (!y.ZC(str))
    {
      Log.w(TAG, "checkModelFile: " + str + " file not exists");
      AppMethodBeat.o(261714);
      return false;
    }
    e locale = new e();
    a.a locala = com.tencent.mm.emoji.c.a.mhz;
    a.a.a(str, (com.tencent.mm.emoji.c.a)locale);
    if (parame.XKi != locale.obC)
    {
      y.deleteFile(str);
      y.deleteFile(XJT + '/' + parame.name);
      Log.w(TAG, "checkModelFile: version error " + str + ", " + locale.obC);
      AppMethodBeat.o(261714);
      return false;
    }
    if (!y.ZC(XJT + '/' + locale.name))
    {
      Log.w(TAG, s.X("checkModelFile: model file not exists ", locale.name));
      AppMethodBeat.o(261714);
      return false;
    }
    parame.obC = locale.obC;
    parame.boK(locale.obF);
    parame.setName(locale.name);
    AppMethodBeat.o(261714);
    return true;
  }
  
  public static void b(AssetManager paramAssetManager)
  {
    AppMethodBeat.i(261734);
    s.u(paramAssetManager, "assets");
    a(paramAssetManager, s.X("xlab/", XJV), muL + '/' + XJV);
    a(paramAssetManager, s.X("xlab/", XJX), muL + '/' + XJX);
    a(paramAssetManager, s.X("xlab/", XJZ), muL + '/' + XJZ);
    paramAssetManager = s.X(muL, "/version.txt");
    Object localObject = com.tencent.mm.xeffect.e.agXD;
    localObject = com.tencent.mm.xeffect.e.jQg();
    Charset localCharset = kotlin.n.d.UTF_8;
    if (localObject == null)
    {
      paramAssetManager = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(261734);
      throw paramAssetManager;
    }
    localObject = ((String)localObject).getBytes(localCharset);
    s.s(localObject, "(this as java.lang.String).getBytes(charset)");
    y.f(paramAssetManager, (byte[])localObject, localObject.length);
    AppMethodBeat.o(261734);
  }
  
  private static boolean b(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    AppMethodBeat.i(261756);
    for (;;)
    {
      Object localObject;
      String str;
      try
      {
        localObject = paramAssetManager.list(paramString1);
        if (localObject == null)
        {
          AppMethodBeat.o(261756);
          return true;
        }
        if (localObject.length != 0) {
          break label252;
        }
        i = 1;
        if (i != 0)
        {
          localObject = y.bub(s.X("assets:///", paramString1));
          str = y.bub(paramString2);
          if (!s.p(localObject, str))
          {
            Log.i(TAG, "checkFileMd5Match: " + paramString1 + " is " + localObject + "; " + paramString2 + " is " + str);
            a(paramAssetManager, paramString1, paramString2);
            AppMethodBeat.o(261756);
            return false;
          }
          AppMethodBeat.o(261756);
          return true;
        }
      }
      catch (Exception paramAssetManager)
      {
        Log.printErrStackTrace(TAG, (Throwable)paramAssetManager, "checkFileMd5Match", new Object[0]);
        AppMethodBeat.o(261756);
        return false;
      }
      y.bDX(paramString2);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        str = localObject[i];
        b(paramAssetManager, paramString1 + '/' + str, paramString2 + '/' + str);
        i += 1;
      }
      continue;
      label252:
      i = 0;
    }
  }
  
  public static String boI(String paramString)
  {
    AppMethodBeat.i(261696);
    s.u(paramString, "key");
    Iterator localIterator = ((Iterable)XKc.XKl).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!s.p(((e)localObject).key, paramString));
    for (;;)
    {
      localObject = (e)localObject;
      if (localObject == null) {
        break label137;
      }
      localObject = XJT + '/' + ((e)localObject).name;
      if (!y.ZC((String)localObject)) {
        break;
      }
      AppMethodBeat.o(261696);
      return localObject;
      localObject = null;
    }
    Log.w(TAG, s.X("modelPathWithKey: file not exist ", paramString));
    for (;;)
    {
      AppMethodBeat.o(261696);
      return null;
      label137:
      Log.w(TAG, s.X("modelPathWithKey: not find config ", paramString));
    }
  }
  
  public static String boJ(String paramString)
  {
    AppMethodBeat.i(261701);
    s.u(paramString, "key");
    Iterator localIterator = ((Iterable)XKc.XKl).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!s.p(((e)localObject).key, paramString));
    for (paramString = localObject;; paramString = null)
    {
      paramString = (e)paramString;
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(261701);
      return null;
    }
    paramString = paramString.obF;
    AppMethodBeat.o(261701);
    return paramString;
  }
  
  public static String iFI()
  {
    return muL;
  }
  
  public static String iFJ()
  {
    return XJT;
  }
  
  public static String iFK()
  {
    return XJU;
  }
  
  public static String iFL()
  {
    return XJV;
  }
  
  public static String iFM()
  {
    return XJW;
  }
  
  public static String iFN()
  {
    return XJX;
  }
  
  public static String iFO()
  {
    return XKb;
  }
  
  public static g iFP()
  {
    return XKc;
  }
  
  public static void iFQ()
  {
    AppMethodBeat.i(261690);
    y.bDX(XJT);
    Object localObject1 = new g();
    if (!y.ZC(iFR())) {
      iFS();
    }
    Object localObject2 = com.tencent.mm.emoji.c.a.mhz;
    a.a.a(iFR(), (com.tencent.mm.emoji.c.a)localObject1);
    Object localObject3;
    if (!((g)localObject1).isValid())
    {
      localObject2 = new g();
      localObject3 = com.tencent.mm.emoji.c.a.mhz;
      a.a.a(s.X(XKd, "/ModelListConfig.xml"), (com.tencent.mm.emoji.c.a)localObject2);
      if (((g)localObject2).isValid())
      {
        iFS();
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (((g)localObject1).isValid())
      {
        localObject2 = ((Iterable)((g)localObject1).XKl).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (e)((Iterator)localObject2).next();
          Object localObject4 = ((e)localObject3).obF;
          s.u(localObject4, "<set-?>");
          ((e)localObject3).XKj = ((String)localObject4);
          ((e)localObject3).XKi = ((e)localObject3).obC;
          if (!a((e)localObject3))
          {
            if (y.ZC(XKd + '/' + ((e)localObject3).getConfigFileName()))
            {
              localObject4 = new e();
              a.a locala = com.tencent.mm.emoji.c.a.mhz;
              a.a.a(XKd + '/' + ((e)localObject3).getConfigFileName(), (com.tencent.mm.emoji.c.a)localObject4);
              Log.i(TAG, "copyModelFileFromAssets: " + ((e)localObject4).obC + ", " + ((e)localObject3).XKi);
              if (((e)localObject4).obC == ((e)localObject3).XKi)
              {
                y.O(XKd + '/' + ((e)localObject3).getConfigFileName(), XJT + '/' + ((e)localObject3).getConfigFileName(), false);
                y.O(XKd + '/' + ((e)localObject3).name, XJT + '/' + ((e)localObject3).name, false);
              }
            }
            a((e)localObject3);
          }
        }
        XKc = (g)localObject1;
      }
      AppMethodBeat.o(261690);
      return;
    }
  }
  
  public static String iFR()
  {
    AppMethodBeat.i(261706);
    String str = s.X(XJT, "/ModelListConfig.xml");
    AppMethodBeat.o(261706);
    return str;
  }
  
  private static void iFS()
  {
    AppMethodBeat.i(261715);
    Log.i(TAG, "copyConfigFileFromAssets: ");
    AssetManager localAssetManager = MMApplicationContext.getContext().getAssets();
    s.s(localAssetManager, "assets");
    a(localAssetManager, "xlab/" + XJS + "/ModelListConfig.xml", iFR());
    AppMethodBeat.o(261715);
  }
  
  public static void iFT()
  {
    AppMethodBeat.i(261721);
    if (!iFV())
    {
      y.ew(s.X("xlab/", XJV), true);
      y.bDX(s.X("xlab/", XJV));
      y.ew(s.X("xlab/", XJX), true);
      y.bDX(s.X("xlab/", XJX));
      y.ew(s.X("xlab/", XJZ), true);
      y.bDX(s.X("xlab/", XJZ));
      Object localObject = com.tencent.mm.plugin.expansions.b.yFu;
      if (!com.tencent.mm.plugin.expansions.b.apZ("xlab"))
      {
        localObject = MMApplicationContext.getContext().getAssets();
        s.s(localObject, "getContext().assets");
        b((AssetManager)localObject);
        AppMethodBeat.o(261721);
        return;
      }
      localObject = com.tencent.mm.plugin.expansions.b.yFu;
      com.tencent.mm.plugin.expansions.b.ag((kotlin.g.a.b)d.a.XKe);
    }
    AppMethodBeat.o(261721);
  }
  
  public static void iFU()
  {
    AppMethodBeat.i(261726);
    com.tencent.mm.ae.d.d("XLabFileUtil_checkFile", (kotlin.g.a.a)b.XKh);
    AppMethodBeat.o(261726);
  }
  
  private static boolean iFV()
  {
    AppMethodBeat.i(261750);
    String str1 = s.X(muL, "/version.txt");
    if (y.ZC(str1)) {}
    for (;;)
    {
      try
      {
        str1 = y.bEn(str1);
        Object localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder("checkVersionMatch: ").append(str1).append(", ");
        com.tencent.mm.xeffect.e locale = com.tencent.mm.xeffect.e.agXD;
        Log.i((String)localObject, com.tencent.mm.xeffect.e.jQg());
        localObject = com.tencent.mm.xeffect.e.agXD;
        s.s(str1, "localVersion");
        boolean bool = com.tencent.mm.xeffect.e.bEX(str1);
        AppMethodBeat.o(261750);
        return bool;
      }
      catch (IOException localIOException)
      {
        str2 = "";
        continue;
      }
      String str2 = "";
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final b XKh;
    
    static
    {
      AppMethodBeat.i(261651);
      XKh = new b();
      AppMethodBeat.o(261651);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.d
 * JD-Core Version:    0.7.0.1
 */