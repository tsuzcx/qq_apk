package com.tencent.mm.sticker.loader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.protocal.protobuf.buu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/loader/StickerFileManager;", "", "()V", "TAG", "", "callback", "com/tencent/mm/sticker/loader/StickerFileManager$callback$1", "Lcom/tencent/mm/sticker/loader/StickerFileManager$callback$1;", "maxPackageCount", "", "getMaxPackageCount", "()I", "processTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "Lkotlin/collections/HashMap;", "stickerDir", "getStickerDir", "()Ljava/lang/String;", "stickerPackage", "getStickerPackage", "stickerTemp", "getStickerTemp", "stickerThumb", "getStickerThumb", "taskQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "checkLocal", "", "lensId", "cleanDir", "", "dir", "maxCount", "cleanFile", "getPackById", "loadByFileId", "Lcom/tencent/mm/loader/loader/WorkStatus;", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "loadByInfo", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "loadByUrl", "url", "loadFromRemote", "Lkotlin/Function1;", "notifyProcessTask", "taskKey", "success", "register", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "unregister", "plugin-sticker_release"})
public final class e
{
  private static final String IGN;
  private static final String IGO;
  private static final String IGP;
  private static final String IGQ;
  private static final int IGR = 50;
  private static final HashMap<String, g> IGS;
  private static final a IGT;
  public static final e IGU;
  private static final String TAG = "MicroMsg.StickerFileManager";
  private static final com.tencent.mm.loader.g.d<g> gkO;
  
  static
  {
    AppMethodBeat.i(105939);
    IGU = new e();
    TAG = "MicroMsg.StickerFileManager";
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = ak.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getCacheDir();
    p.g(localObject, "MMApplicationContext.getContext().cacheDir");
    IGN = ((File)localObject).getAbsolutePath() + "/sticker/";
    IGO = IGN + "package/";
    IGP = IGN + "temp/";
    IGQ = IGN + "thumb/";
    IGR = 50;
    gkO = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a((byte)0), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "StickerTask"));
    IGS = new HashMap();
    IGT = new a();
    o.aZI(IGN);
    o.aZX(IGN);
    gkO.a((com.tencent.mm.loader.g.f)IGT);
    AppMethodBeat.o(105939);
  }
  
  public static void a(com.tencent.mm.loader.g.f<g> paramf)
  {
    AppMethodBeat.i(105930);
    p.h(paramf, "callback");
    gkO.a(paramf);
    AppMethodBeat.o(105930);
  }
  
  private static void a(StickerLoadInfo paramStickerLoadInfo)
  {
    AppMethodBeat.i(105936);
    p.h(paramStickerLoadInfo, "info");
    if (IGS.containsKey(paramStickerLoadInfo.BN()))
    {
      ae.i(TAG, "loadByInfo: " + paramStickerLoadInfo.BN() + " waiting in queue");
      AppMethodBeat.o(105936);
      return;
    }
    Object localObject = com.tencent.mm.kernel.g.ajO().ajq();
    p.g(localObject, "MMKernel.process().current()");
    if (((h)localObject).akL()) {
      if (paramStickerLoadInfo.type == 1) {
        paramStickerLoadInfo = (g)new i(paramStickerLoadInfo);
      }
    }
    for (;;)
    {
      gkO.b((com.tencent.mm.loader.g.c)paramStickerLoadInfo);
      AppMethodBeat.o(105936);
      return;
      paramStickerLoadInfo = (g)new d(paramStickerLoadInfo);
      continue;
      localObject = new f(paramStickerLoadInfo);
      ((Map)IGS).put(paramStickerLoadInfo.BN(), localObject);
      paramStickerLoadInfo = (g)localObject;
    }
  }
  
  public static void a(StickerLoadInfo paramStickerLoadInfo, b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(208257);
    p.h(paramStickerLoadInfo, "info");
    ae.i(TAG, "loadFromRemote: " + paramStickerLoadInfo.BN());
    if (paramStickerLoadInfo.type == 1) {}
    for (g localg = (g)new i(paramStickerLoadInfo);; localg = (g)new d(paramStickerLoadInfo))
    {
      if ((paramb != null) && (!localg.IHa.contains(paramb))) {
        localg.IHa.add(paramb);
      }
      ((Map)IGS).put(paramStickerLoadInfo.BN(), localg);
      gkO.b((com.tencent.mm.loader.g.c)localg);
      AppMethodBeat.o(208257);
      return;
    }
  }
  
  public static void aTA(String paramString)
  {
    AppMethodBeat.i(105932);
    p.h(paramString, "url");
    Object localObject = StickerLoadInfo.IGW;
    p.h(paramString, "url");
    localObject = new StickerLoadInfo(1);
    p.h(paramString, "<set-?>");
    ((StickerLoadInfo)localObject).url = paramString;
    a((StickerLoadInfo)localObject);
    AppMethodBeat.o(105932);
  }
  
  public static String aTB(String paramString)
  {
    AppMethodBeat.i(105934);
    p.h(paramString, "lensId");
    paramString = IGO + paramString + '/';
    AppMethodBeat.o(105934);
    return paramString;
  }
  
  public static boolean aTC(String paramString)
  {
    AppMethodBeat.i(105935);
    p.h(paramString, "lensId");
    boolean bool = o.fB(aTB(paramString));
    AppMethodBeat.o(105935);
    return bool;
  }
  
  public static void b(com.tencent.mm.loader.g.f<g> paramf)
  {
    AppMethodBeat.i(105931);
    p.h(paramf, "callback");
    gkO.b(paramf);
    AppMethodBeat.o(105931);
  }
  
  public static void cM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105938);
    p.h(paramString, "taskKey");
    ae.i(TAG, "notifyProcessTask: ".concat(String.valueOf(paramString)));
    paramString = (g)IGS.remove(paramString);
    if (paramString != null)
    {
      paramString.dg(paramBoolean);
      AppMethodBeat.o(105938);
      return;
    }
    AppMethodBeat.o(105938);
  }
  
  public static void cOs()
  {
    AppMethodBeat.i(105929);
    com.tencent.mm.ac.c.b("StickerFileManager_cleanFile", (d.g.a.a)c.IGV);
    AppMethodBeat.o(105929);
  }
  
  public static j d(bus parambus)
  {
    AppMethodBeat.i(105933);
    p.h(parambus, "lensInfo");
    ae.i(TAG, "loadByFileId: " + parambus.GwI);
    if (bu.isNullOrNil(parambus.GwI))
    {
      parambus = j.hiz;
      AppMethodBeat.o(105933);
      return parambus;
    }
    Object localObject = parambus.GwI;
    p.g(localObject, "lensInfo.LensId");
    if (aTC((String)localObject))
    {
      parambus = j.hiy;
      AppMethodBeat.o(105933);
      return parambus;
    }
    localObject = StickerLoadInfo.IGW;
    p.h(parambus, "lensInfo");
    StickerLoadInfo localStickerLoadInfo = new StickerLoadInfo();
    String str = parambus.GwI;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    p.h(localObject, "<set-?>");
    localStickerLoadInfo.pWT = ((String)localObject);
    localObject = parambus.HhQ;
    if (localObject != null)
    {
      str = ((buu)localObject).FSC;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    p.h(localObject, "<set-?>");
    localStickerLoadInfo.fileId = ((String)localObject);
    localObject = parambus.HhQ;
    if (localObject != null)
    {
      str = ((buu)localObject).AesKey;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    p.h(localObject, "<set-?>");
    localStickerLoadInfo.gmb = ((String)localObject);
    parambus = parambus.HhQ;
    if (parambus != null) {}
    for (int i = parambus.FileSize;; i = 0)
    {
      localStickerLoadInfo.jIO = i;
      a(localStickerLoadInfo);
      parambus = j.hiB;
      AppMethodBeat.o(105933);
      return parambus;
    }
  }
  
  public static String frX()
  {
    return IGO;
  }
  
  public static String frY()
  {
    return IGP;
  }
  
  public static String frZ()
  {
    return IGQ;
  }
  
  public static int fsa()
  {
    return IGR;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/sticker/loader/StickerFileManager$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-sticker_release"})
  public static final class a
    implements com.tencent.mm.loader.g.f<g>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(105926);
      int i = d.b.a.a((Comparable)Long.valueOf(((com.tencent.mm.vfs.c)paramT2).LGc), (Comparable)Long.valueOf(((com.tencent.mm.vfs.c)paramT1).LGc));
      AppMethodBeat.o(105926);
      return i;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    public static final c IGV;
    
    static
    {
      AppMethodBeat.i(105928);
      IGV = new c();
      AppMethodBeat.o(105928);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.e
 * JD-Core Version:    0.7.0.1
 */