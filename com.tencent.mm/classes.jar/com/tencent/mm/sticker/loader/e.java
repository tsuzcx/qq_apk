package com.tencent.mm.sticker.loader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.blr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.FileSystem.a;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/loader/StickerFileManager;", "", "()V", "TAG", "", "callback", "com/tencent/mm/sticker/loader/StickerFileManager$callback$1", "Lcom/tencent/mm/sticker/loader/StickerFileManager$callback$1;", "maxPackageCount", "", "getMaxPackageCount", "()I", "processTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "Lkotlin/collections/HashMap;", "stickerDir", "getStickerDir", "()Ljava/lang/String;", "stickerPackage", "getStickerPackage", "stickerTemp", "getStickerTemp", "stickerThumb", "getStickerThumb", "taskQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "checkLocal", "", "lensId", "cleanDir", "", "dir", "maxCount", "cleanFile", "getPackById", "loadByFileId", "Lcom/tencent/mm/loader/loader/WorkStatus;", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "loadByInfo", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "loadByUrl", "url", "loadFromRemote", "Lkotlin/Function1;", "notifyProcessTask", "taskKey", "success", "register", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "unregister", "plugin-sticker_release"})
public final class e
{
  private static final String Fdl;
  private static final String Fdm;
  private static final String Fdn;
  private static final String Fdo;
  private static final int Fdp = 50;
  private static final HashMap<String, g> Fdq;
  private static final a Fdr;
  public static final e Fds;
  private static final String TAG = "MicroMsg.StickerFileManager";
  private static final com.tencent.mm.loader.g.d<g> fLk;
  
  static
  {
    AppMethodBeat.i(105939);
    Fds = new e();
    TAG = "MicroMsg.StickerFileManager";
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = aj.getContext();
    k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getCacheDir();
    k.g(localObject, "MMApplicationContext.getContext().cacheDir");
    Fdl = ((File)localObject).getAbsolutePath() + "/sticker/";
    Fdm = Fdl + "package/";
    Fdn = Fdl + "temp/";
    Fdo = Fdl + "thumb/";
    Fdp = 50;
    fLk = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a((byte)0), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "StickerTask"));
    Fdq = new HashMap();
    Fdr = new a();
    com.tencent.mm.vfs.i.aMF(Fdl);
    com.tencent.mm.vfs.i.aMT(Fdl);
    fLk.a((com.tencent.mm.loader.g.f)Fdr);
    AppMethodBeat.o(105939);
  }
  
  public static void a(com.tencent.mm.loader.g.f<g> paramf)
  {
    AppMethodBeat.i(105930);
    k.h(paramf, "callback");
    fLk.a(paramf);
    AppMethodBeat.o(105930);
  }
  
  private static void a(StickerLoadInfo paramStickerLoadInfo)
  {
    AppMethodBeat.i(105936);
    k.h(paramStickerLoadInfo, "info");
    if (Fdq.containsKey(paramStickerLoadInfo.AL()))
    {
      ad.i(TAG, "loadByInfo: " + paramStickerLoadInfo.AL() + " waiting in queue");
      AppMethodBeat.o(105936);
      return;
    }
    Object localObject = com.tencent.mm.kernel.g.afy().aeZ();
    k.g(localObject, "MMKernel.process().current()");
    if (((com.tencent.mm.kernel.b.h)localObject).agu()) {
      if (paramStickerLoadInfo.type == 1) {
        paramStickerLoadInfo = (g)new i(paramStickerLoadInfo);
      }
    }
    for (;;)
    {
      fLk.b((com.tencent.mm.loader.g.c)paramStickerLoadInfo);
      AppMethodBeat.o(105936);
      return;
      paramStickerLoadInfo = (g)new d(paramStickerLoadInfo);
      continue;
      localObject = new f(paramStickerLoadInfo);
      ((Map)Fdq).put(paramStickerLoadInfo.AL(), localObject);
      paramStickerLoadInfo = (g)localObject;
    }
  }
  
  public static void a(StickerLoadInfo paramStickerLoadInfo, b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(202298);
    k.h(paramStickerLoadInfo, "info");
    ad.i(TAG, "loadFromRemote: " + paramStickerLoadInfo.AL());
    if (paramStickerLoadInfo.type == 1) {}
    for (g localg = (g)new i(paramStickerLoadInfo);; localg = (g)new d(paramStickerLoadInfo))
    {
      if ((paramb != null) && (!localg.LAA.contains(paramb))) {
        localg.LAA.add(paramb);
      }
      ((Map)Fdq).put(paramStickerLoadInfo.AL(), localg);
      fLk.b((com.tencent.mm.loader.g.c)localg);
      AppMethodBeat.o(202298);
      return;
    }
  }
  
  public static void aHc(String paramString)
  {
    AppMethodBeat.i(105932);
    k.h(paramString, "url");
    Object localObject = StickerLoadInfo.Fdu;
    k.h(paramString, "url");
    localObject = new StickerLoadInfo(1);
    k.h(paramString, "<set-?>");
    ((StickerLoadInfo)localObject).url = paramString;
    a((StickerLoadInfo)localObject);
    AppMethodBeat.o(105932);
  }
  
  public static String aHd(String paramString)
  {
    AppMethodBeat.i(105934);
    k.h(paramString, "lensId");
    paramString = Fdm + paramString + '/';
    AppMethodBeat.o(105934);
    return paramString;
  }
  
  public static boolean aHe(String paramString)
  {
    AppMethodBeat.i(105935);
    k.h(paramString, "lensId");
    boolean bool = com.tencent.mm.vfs.i.eK(aHd(paramString));
    AppMethodBeat.o(105935);
    return bool;
  }
  
  public static void b(com.tencent.mm.loader.g.f<g> paramf)
  {
    AppMethodBeat.i(105931);
    k.h(paramf, "callback");
    fLk.b(paramf);
    AppMethodBeat.o(105931);
  }
  
  public static void cx(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105938);
    k.h(paramString, "taskKey");
    ad.i(TAG, "notifyProcessTask: ".concat(String.valueOf(paramString)));
    paramString = (g)Fdq.remove(paramString);
    if (paramString != null)
    {
      paramString.df(paramBoolean);
      AppMethodBeat.o(105938);
      return;
    }
    AppMethodBeat.o(105938);
  }
  
  public static com.tencent.mm.loader.g.h d(blp paramblp)
  {
    AppMethodBeat.i(105933);
    k.h(paramblp, "lensInfo");
    ad.i(TAG, "loadByFileId: " + paramblp.Dds);
    if (bt.isNullOrNil(paramblp.Dds))
    {
      paramblp = com.tencent.mm.loader.g.h.glb;
      AppMethodBeat.o(105933);
      return paramblp;
    }
    Object localObject = paramblp.Dds;
    k.g(localObject, "lensInfo.LensId");
    if (aHe((String)localObject))
    {
      paramblp = com.tencent.mm.loader.g.h.gla;
      AppMethodBeat.o(105933);
      return paramblp;
    }
    localObject = StickerLoadInfo.Fdu;
    k.h(paramblp, "lensInfo");
    StickerLoadInfo localStickerLoadInfo = new StickerLoadInfo();
    String str = paramblp.Dds;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    k.h(localObject, "<set-?>");
    localStickerLoadInfo.oJp = ((String)localObject);
    localObject = paramblp.DJr;
    if (localObject != null)
    {
      str = ((blr)localObject).CCm;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    k.h(localObject, "<set-?>");
    localStickerLoadInfo.fileId = ((String)localObject);
    localObject = paramblp.DJr;
    if (localObject != null)
    {
      str = ((blr)localObject).AesKey;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    k.h(localObject, "<set-?>");
    localStickerLoadInfo.fMw = ((String)localObject);
    paramblp = paramblp.DJr;
    if (paramblp != null) {}
    for (int i = paramblp.FileSize;; i = 0)
    {
      localStickerLoadInfo.iLS = i;
      a(localStickerLoadInfo);
      paramblp = com.tencent.mm.loader.g.h.gld;
      AppMethodBeat.o(105933);
      return paramblp;
    }
  }
  
  public static String eIY()
  {
    return Fdm;
  }
  
  public static String eIZ()
  {
    return Fdn;
  }
  
  public static String eJa()
  {
    return Fdo;
  }
  
  public static int eJb()
  {
    return Fdp;
  }
  
  public static void eJc()
  {
    AppMethodBeat.i(105929);
    com.tencent.mm.ad.c.b("StickerFileManager_cleanFile", (d.g.a.a)c.Fdt);
    AppMethodBeat.o(105929);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/sticker/loader/StickerFileManager$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-sticker_release"})
  public static final class a
    implements com.tencent.mm.loader.g.f<g>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(105926);
      int i = d.b.a.a((Comparable)Long.valueOf(((FileSystem.a)paramT2).HRA), (Comparable)Long.valueOf(((FileSystem.a)paramT1).HRA));
      AppMethodBeat.o(105926);
      return i;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final c Fdt;
    
    static
    {
      AppMethodBeat.i(105928);
      Fdt = new c();
      AppMethodBeat.o(105928);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.e
 * JD-Core Version:    0.7.0.1
 */