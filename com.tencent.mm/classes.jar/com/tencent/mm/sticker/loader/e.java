package com.tencent.mm.sticker.loader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/loader/StickerFileManager;", "", "()V", "TAG", "", "callback", "com/tencent/mm/sticker/loader/StickerFileManager$callback$1", "Lcom/tencent/mm/sticker/loader/StickerFileManager$callback$1;", "maxPackageCount", "", "getMaxPackageCount", "()I", "processTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "Lkotlin/collections/HashMap;", "stickerDir", "getStickerDir", "()Ljava/lang/String;", "stickerPackage", "getStickerPackage", "stickerTemp", "getStickerTemp", "stickerThumb", "getStickerThumb", "taskQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "checkLocal", "", "lensId", "cleanDir", "", "dir", "maxCount", "cleanFile", "getPackById", "loadByFileId", "Lcom/tencent/mm/loader/loader/WorkStatus;", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "loadByInfo", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "loadByUrl", "url", "loadFromRemote", "Lkotlin/Function1;", "notifyProcessTask", "taskKey", "success", "register", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "unregister", "plugin-sticker_release"})
public final class e
{
  private static final String ImC;
  private static final String ImD;
  private static final String ImE;
  private static final String ImF;
  private static final int ImG = 50;
  private static final HashMap<String, g> ImH;
  private static final a ImI;
  public static final e ImJ;
  private static final String TAG = "MicroMsg.StickerFileManager";
  private static final com.tencent.mm.loader.g.d<g> giw;
  
  static
  {
    AppMethodBeat.i(105939);
    ImJ = new e();
    TAG = "MicroMsg.StickerFileManager";
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = aj.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getCacheDir();
    p.g(localObject, "MMApplicationContext.getContext().cacheDir");
    ImC = ((File)localObject).getAbsolutePath() + "/sticker/";
    ImD = ImC + "package/";
    ImE = ImC + "temp/";
    ImF = ImC + "thumb/";
    ImG = 50;
    giw = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a((byte)0), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "StickerTask"));
    ImH = new HashMap();
    ImI = new a();
    com.tencent.mm.vfs.i.aYg(ImC);
    com.tencent.mm.vfs.i.aYu(ImC);
    giw.a((com.tencent.mm.loader.g.f)ImI);
    AppMethodBeat.o(105939);
  }
  
  public static void a(com.tencent.mm.loader.g.f<g> paramf)
  {
    AppMethodBeat.i(105930);
    p.h(paramf, "callback");
    giw.a(paramf);
    AppMethodBeat.o(105930);
  }
  
  private static void a(StickerLoadInfo paramStickerLoadInfo)
  {
    AppMethodBeat.i(105936);
    p.h(paramStickerLoadInfo, "info");
    if (ImH.containsKey(paramStickerLoadInfo.BM()))
    {
      ad.i(TAG, "loadByInfo: " + paramStickerLoadInfo.BM() + " waiting in queue");
      AppMethodBeat.o(105936);
      return;
    }
    Object localObject = com.tencent.mm.kernel.g.ajz().ajb();
    p.g(localObject, "MMKernel.process().current()");
    if (((h)localObject).akw()) {
      if (paramStickerLoadInfo.type == 1) {
        paramStickerLoadInfo = (g)new i(paramStickerLoadInfo);
      }
    }
    for (;;)
    {
      giw.b((com.tencent.mm.loader.g.c)paramStickerLoadInfo);
      AppMethodBeat.o(105936);
      return;
      paramStickerLoadInfo = (g)new d(paramStickerLoadInfo);
      continue;
      localObject = new f(paramStickerLoadInfo);
      ((Map)ImH).put(paramStickerLoadInfo.BM(), localObject);
      paramStickerLoadInfo = (g)localObject;
    }
  }
  
  public static void a(StickerLoadInfo paramStickerLoadInfo, b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(215378);
    p.h(paramStickerLoadInfo, "info");
    ad.i(TAG, "loadFromRemote: " + paramStickerLoadInfo.BM());
    if (paramStickerLoadInfo.type == 1) {}
    for (g localg = (g)new i(paramStickerLoadInfo);; localg = (g)new d(paramStickerLoadInfo))
    {
      if ((paramb != null) && (!localg.ImP.contains(paramb))) {
        localg.ImP.add(paramb);
      }
      ((Map)ImH).put(paramStickerLoadInfo.BM(), localg);
      giw.b((com.tencent.mm.loader.g.c)localg);
      AppMethodBeat.o(215378);
      return;
    }
  }
  
  public static void aSd(String paramString)
  {
    AppMethodBeat.i(105932);
    p.h(paramString, "url");
    Object localObject = StickerLoadInfo.ImL;
    p.h(paramString, "url");
    localObject = new StickerLoadInfo(1);
    p.h(paramString, "<set-?>");
    ((StickerLoadInfo)localObject).url = paramString;
    a((StickerLoadInfo)localObject);
    AppMethodBeat.o(105932);
  }
  
  public static String aSe(String paramString)
  {
    AppMethodBeat.i(105934);
    p.h(paramString, "lensId");
    paramString = ImD + paramString + '/';
    AppMethodBeat.o(105934);
    return paramString;
  }
  
  public static boolean aSf(String paramString)
  {
    AppMethodBeat.i(105935);
    p.h(paramString, "lensId");
    boolean bool = com.tencent.mm.vfs.i.fv(aSe(paramString));
    AppMethodBeat.o(105935);
    return bool;
  }
  
  public static void b(com.tencent.mm.loader.g.f<g> paramf)
  {
    AppMethodBeat.i(105931);
    p.h(paramf, "callback");
    giw.b(paramf);
    AppMethodBeat.o(105931);
  }
  
  public static void cI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105938);
    p.h(paramString, "taskKey");
    ad.i(TAG, "notifyProcessTask: ".concat(String.valueOf(paramString)));
    paramString = (g)ImH.remove(paramString);
    if (paramString != null)
    {
      paramString.dg(paramBoolean);
      AppMethodBeat.o(105938);
      return;
    }
    AppMethodBeat.o(105938);
  }
  
  public static void cLK()
  {
    AppMethodBeat.i(105929);
    com.tencent.mm.ad.c.b("StickerFileManager_cleanFile", (d.g.a.a)c.ImK);
    AppMethodBeat.o(105929);
  }
  
  public static j d(bty parambty)
  {
    AppMethodBeat.i(105933);
    p.h(parambty, "lensInfo");
    ad.i(TAG, "loadByFileId: " + parambty.Geb);
    if (bt.isNullOrNil(parambty.Geb))
    {
      parambty = j.hfL;
      AppMethodBeat.o(105933);
      return parambty;
    }
    Object localObject = parambty.Geb;
    p.g(localObject, "lensInfo.LensId");
    if (aSf((String)localObject))
    {
      parambty = j.hfK;
      AppMethodBeat.o(105933);
      return parambty;
    }
    localObject = StickerLoadInfo.ImL;
    p.h(parambty, "lensInfo");
    StickerLoadInfo localStickerLoadInfo = new StickerLoadInfo();
    String str = parambty.Geb;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    p.h(localObject, "<set-?>");
    localStickerLoadInfo.pQo = ((String)localObject);
    localObject = parambty.GOq;
    if (localObject != null)
    {
      str = ((bua)localObject).FAe;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    p.h(localObject, "<set-?>");
    localStickerLoadInfo.fileId = ((String)localObject);
    localObject = parambty.GOq;
    if (localObject != null)
    {
      str = ((bua)localObject).AesKey;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    p.h(localObject, "<set-?>");
    localStickerLoadInfo.gjI = ((String)localObject);
    parambty = parambty.GOq;
    if (parambty != null) {}
    for (int i = parambty.FileSize;; i = 0)
    {
      localStickerLoadInfo.jFP = i;
      a(localStickerLoadInfo);
      parambty = j.hfN;
      AppMethodBeat.o(105933);
      return parambty;
    }
  }
  
  public static String foe()
  {
    return ImD;
  }
  
  public static String fof()
  {
    return ImE;
  }
  
  public static String fog()
  {
    return ImF;
  }
  
  public static int foh()
  {
    return ImG;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/sticker/loader/StickerFileManager$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-sticker_release"})
  public static final class a
    implements com.tencent.mm.loader.g.f<g>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    public static final c ImK;
    
    static
    {
      AppMethodBeat.i(105928);
      ImK = new c();
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