package com.tencent.mm.sticker.loader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.bpn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.FileSystem.a;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/loader/StickerFileManager;", "", "()V", "TAG", "", "callback", "com/tencent/mm/sticker/loader/StickerFileManager$callback$1", "Lcom/tencent/mm/sticker/loader/StickerFileManager$callback$1;", "maxPackageCount", "", "getMaxPackageCount", "()I", "processTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "Lkotlin/collections/HashMap;", "stickerDir", "getStickerDir", "()Ljava/lang/String;", "stickerPackage", "getStickerPackage", "stickerTemp", "getStickerTemp", "stickerThumb", "getStickerThumb", "taskQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "checkLocal", "", "lensId", "cleanDir", "", "dir", "maxCount", "cleanFile", "getPackById", "loadByFileId", "Lcom/tencent/mm/loader/loader/WorkStatus;", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "loadByInfo", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "loadByUrl", "url", "loadFromRemote", "Lkotlin/Function1;", "notifyProcessTask", "taskKey", "success", "register", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "unregister", "plugin-sticker_release"})
public final class e
{
  private static final String GAI;
  private static final String GAJ;
  private static final String GAK;
  private static final String GAL;
  private static final int GAM = 50;
  private static final HashMap<String, g> GAN;
  private static final a GAO;
  public static final e GAP;
  private static final String TAG = "MicroMsg.StickerFileManager";
  private static final com.tencent.mm.loader.g.d<g> fOW;
  
  static
  {
    AppMethodBeat.i(105939);
    GAP = new e();
    TAG = "MicroMsg.StickerFileManager";
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = ai.getContext();
    k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getCacheDir();
    k.g(localObject, "MMApplicationContext.getContext().cacheDir");
    GAI = ((File)localObject).getAbsolutePath() + "/sticker/";
    GAJ = GAI + "package/";
    GAK = GAI + "temp/";
    GAL = GAI + "thumb/";
    GAM = 50;
    fOW = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a((byte)0), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "StickerTask"));
    GAN = new HashMap();
    GAO = new a();
    com.tencent.mm.vfs.i.aSh(GAI);
    com.tencent.mm.vfs.i.aSv(GAI);
    fOW.a((com.tencent.mm.loader.g.f)GAO);
    AppMethodBeat.o(105939);
  }
  
  public static void a(com.tencent.mm.loader.g.f<g> paramf)
  {
    AppMethodBeat.i(105930);
    k.h(paramf, "callback");
    fOW.a(paramf);
    AppMethodBeat.o(105930);
  }
  
  private static void a(StickerLoadInfo paramStickerLoadInfo)
  {
    AppMethodBeat.i(105936);
    k.h(paramStickerLoadInfo, "info");
    if (GAN.containsKey(paramStickerLoadInfo.Ap()))
    {
      ac.i(TAG, "loadByInfo: " + paramStickerLoadInfo.Ap() + " waiting in queue");
      AppMethodBeat.o(105936);
      return;
    }
    Object localObject = com.tencent.mm.kernel.g.agO().agp();
    k.g(localObject, "MMKernel.process().current()");
    if (((com.tencent.mm.kernel.b.h)localObject).ahL()) {
      if (paramStickerLoadInfo.type == 1) {
        paramStickerLoadInfo = (g)new i(paramStickerLoadInfo);
      }
    }
    for (;;)
    {
      fOW.b((com.tencent.mm.loader.g.c)paramStickerLoadInfo);
      AppMethodBeat.o(105936);
      return;
      paramStickerLoadInfo = (g)new d(paramStickerLoadInfo);
      continue;
      localObject = new f(paramStickerLoadInfo);
      ((Map)GAN).put(paramStickerLoadInfo.Ap(), localObject);
      paramStickerLoadInfo = (g)localObject;
    }
  }
  
  public static void a(StickerLoadInfo paramStickerLoadInfo, b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(204909);
    k.h(paramStickerLoadInfo, "info");
    ac.i(TAG, "loadFromRemote: " + paramStickerLoadInfo.Ap());
    if (paramStickerLoadInfo.type == 1) {}
    for (g localg = (g)new i(paramStickerLoadInfo);; localg = (g)new d(paramStickerLoadInfo))
    {
      if ((paramb != null) && (!localg.GAV.contains(paramb))) {
        localg.GAV.add(paramb);
      }
      ((Map)GAN).put(paramStickerLoadInfo.Ap(), localg);
      fOW.b((com.tencent.mm.loader.g.c)localg);
      AppMethodBeat.o(204909);
      return;
    }
  }
  
  public static void aMw(String paramString)
  {
    AppMethodBeat.i(105932);
    k.h(paramString, "url");
    Object localObject = StickerLoadInfo.GAR;
    k.h(paramString, "url");
    localObject = new StickerLoadInfo(1);
    k.h(paramString, "<set-?>");
    ((StickerLoadInfo)localObject).url = paramString;
    a((StickerLoadInfo)localObject);
    AppMethodBeat.o(105932);
  }
  
  public static String aMx(String paramString)
  {
    AppMethodBeat.i(105934);
    k.h(paramString, "lensId");
    paramString = GAJ + paramString + '/';
    AppMethodBeat.o(105934);
    return paramString;
  }
  
  public static boolean aMy(String paramString)
  {
    AppMethodBeat.i(105935);
    k.h(paramString, "lensId");
    boolean bool = com.tencent.mm.vfs.i.eA(aMx(paramString));
    AppMethodBeat.o(105935);
    return bool;
  }
  
  public static void b(com.tencent.mm.loader.g.f<g> paramf)
  {
    AppMethodBeat.i(105931);
    k.h(paramf, "callback");
    fOW.b(paramf);
    AppMethodBeat.o(105931);
  }
  
  public static void cD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105938);
    k.h(paramString, "taskKey");
    ac.i(TAG, "notifyProcessTask: ".concat(String.valueOf(paramString)));
    paramString = (g)GAN.remove(paramString);
    if (paramString != null)
    {
      paramString.de(paramBoolean);
      AppMethodBeat.o(105938);
      return;
    }
    AppMethodBeat.o(105938);
  }
  
  public static void cDq()
  {
    AppMethodBeat.i(105929);
    com.tencent.mm.ac.c.b("StickerFileManager_cleanFile", (d.g.a.a)c.GAQ);
    AppMethodBeat.o(105929);
  }
  
  public static com.tencent.mm.loader.g.h d(bpl parambpl)
  {
    AppMethodBeat.i(105933);
    k.h(parambpl, "lensInfo");
    ac.i(TAG, "loadByFileId: " + parambpl.Ewy);
    if (bs.isNullOrNil(parambpl.Ewy))
    {
      parambpl = com.tencent.mm.loader.g.h.gLO;
      AppMethodBeat.o(105933);
      return parambpl;
    }
    Object localObject = parambpl.Ewy;
    k.g(localObject, "lensInfo.LensId");
    if (aMy((String)localObject))
    {
      parambpl = com.tencent.mm.loader.g.h.gLN;
      AppMethodBeat.o(105933);
      return parambpl;
    }
    localObject = StickerLoadInfo.GAR;
    k.h(parambpl, "lensInfo");
    StickerLoadInfo localStickerLoadInfo = new StickerLoadInfo();
    String str = parambpl.Ewy;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    k.h(localObject, "<set-?>");
    localStickerLoadInfo.pmO = ((String)localObject);
    localObject = parambpl.FeM;
    if (localObject != null)
    {
      str = ((bpn)localObject).DUJ;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    k.h(localObject, "<set-?>");
    localStickerLoadInfo.fileId = ((String)localObject);
    localObject = parambpl.FeM;
    if (localObject != null)
    {
      str = ((bpn)localObject).AesKey;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    k.h(localObject, "<set-?>");
    localStickerLoadInfo.fQi = ((String)localObject);
    parambpl = parambpl.FeM;
    if (parambpl != null) {}
    for (int i = parambpl.FileSize;; i = 0)
    {
      localStickerLoadInfo.jlZ = i;
      a(localStickerLoadInfo);
      parambpl = com.tencent.mm.loader.g.h.gLQ;
      AppMethodBeat.o(105933);
      return parambpl;
    }
  }
  
  public static String eYu()
  {
    return GAJ;
  }
  
  public static String eYv()
  {
    return GAK;
  }
  
  public static String eYw()
  {
    return GAL;
  }
  
  public static int eYx()
  {
    return GAM;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/sticker/loader/StickerFileManager$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-sticker_release"})
  public static final class a
    implements com.tencent.mm.loader.g.f<g>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(105926);
      int i = d.b.a.a((Comparable)Long.valueOf(((FileSystem.a)paramT2).Jsf), (Comparable)Long.valueOf(((FileSystem.a)paramT1).Jsf));
      AppMethodBeat.o(105926);
      return i;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final c GAQ;
    
    static
    {
      AppMethodBeat.i(105928);
      GAQ = new c();
      AppMethodBeat.o(105928);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.e
 * JD-Core Version:    0.7.0.1
 */