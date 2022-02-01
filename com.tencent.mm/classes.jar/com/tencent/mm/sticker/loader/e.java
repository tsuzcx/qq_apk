package com.tencent.mm.sticker.loader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.protocal.protobuf.cqx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f.a;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/loader/StickerFileManager;", "", "()V", "TAG", "", "callback", "com/tencent/mm/sticker/loader/StickerFileManager$callback$1", "Lcom/tencent/mm/sticker/loader/StickerFileManager$callback$1;", "maxPackageCount", "", "getMaxPackageCount", "()I", "processTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "Lkotlin/collections/HashMap;", "stickerDir", "getStickerDir", "()Ljava/lang/String;", "stickerPackage", "getStickerPackage", "stickerTemp", "getStickerTemp", "stickerThumb", "getStickerThumb", "taskQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "checkLocal", "", "lensId", "cleanDir", "", "dir", "maxCount", "cleanFile", "getPackById", "loadByFileId", "Lcom/tencent/mm/loader/loader/WorkStatus;", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "loadByInfo", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "loadByUrl", "url", "loadFromRemote", "Lkotlin/Function1;", "notifyProcessTask", "taskKey", "success", "register", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "unregister", "plugin-sticker_release"})
public final class e
{
  private static final String TAG = "MicroMsg.StickerFileManager";
  private static final String Vbq;
  private static final String Vbr;
  private static final String Vbs;
  private static final String Vbt;
  private static final int Vbu = 50;
  private static final HashMap<String, g> Vbv;
  private static final a Vbw;
  public static final e Vbx;
  private static final com.tencent.mm.loader.g.d<g> jGF;
  
  static
  {
    AppMethodBeat.i(105939);
    Vbx = new e();
    TAG = "MicroMsg.StickerFileManager";
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getCacheDir();
    p.j(localObject, "MMApplicationContext.getContext().cacheDir");
    Vbq = ((File)localObject).getAbsolutePath() + "/sticker/";
    Vbr = Vbq + "package/";
    Vbs = Vbq + "temp/";
    Vbt = Vbq + "thumb/";
    Vbu = 50;
    jGF = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a((byte)0), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "StickerTask"));
    Vbv = new HashMap();
    Vbw = new a();
    u.bBD(Vbq);
    u.bBX(Vbq);
    jGF.a((com.tencent.mm.loader.g.f)Vbw);
    AppMethodBeat.o(105939);
  }
  
  public static void a(com.tencent.mm.loader.g.f<g> paramf)
  {
    AppMethodBeat.i(105930);
    p.k(paramf, "callback");
    jGF.a(paramf);
    AppMethodBeat.o(105930);
  }
  
  private static void a(StickerLoadInfo paramStickerLoadInfo)
  {
    AppMethodBeat.i(105936);
    p.k(paramStickerLoadInfo, "info");
    if (Vbv.containsKey(paramStickerLoadInfo.key()))
    {
      Log.i(TAG, "loadByInfo: " + paramStickerLoadInfo.key() + " waiting in queue");
      AppMethodBeat.o(105936);
      return;
    }
    Object localObject = com.tencent.mm.kernel.h.aHD().aHf();
    p.j(localObject, "MMKernel.process().current()");
    if (((com.tencent.mm.kernel.b.h)localObject).aIE()) {
      if (paramStickerLoadInfo.type == 1) {
        paramStickerLoadInfo = (g)new i(paramStickerLoadInfo);
      }
    }
    for (;;)
    {
      jGF.b((com.tencent.mm.loader.g.c)paramStickerLoadInfo);
      AppMethodBeat.o(105936);
      return;
      paramStickerLoadInfo = (g)new d(paramStickerLoadInfo);
      continue;
      localObject = new f(paramStickerLoadInfo);
      ((Map)Vbv).put(paramStickerLoadInfo.key(), localObject);
      paramStickerLoadInfo = (g)localObject;
    }
  }
  
  public static void a(StickerLoadInfo paramStickerLoadInfo, b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(232519);
    p.k(paramStickerLoadInfo, "info");
    Log.i(TAG, "loadFromRemote: " + paramStickerLoadInfo.key());
    if (paramStickerLoadInfo.type == 1) {}
    for (g localg = (g)new i(paramStickerLoadInfo);; localg = (g)new d(paramStickerLoadInfo))
    {
      if ((paramb != null) && (!localg.VbD.contains(paramb))) {
        localg.VbD.add(paramb);
      }
      ((Map)Vbv).put(paramStickerLoadInfo.key(), localg);
      jGF.b((com.tencent.mm.loader.g.c)localg);
      AppMethodBeat.o(232519);
      return;
    }
  }
  
  public static void b(com.tencent.mm.loader.g.f<g> paramf)
  {
    AppMethodBeat.i(105931);
    p.k(paramf, "callback");
    jGF.b(paramf);
    AppMethodBeat.o(105931);
  }
  
  public static void buM(String paramString)
  {
    AppMethodBeat.i(105932);
    p.k(paramString, "url");
    Object localObject = StickerLoadInfo.Vbz;
    p.k(paramString, "url");
    localObject = new StickerLoadInfo(1);
    p.k(paramString, "<set-?>");
    ((StickerLoadInfo)localObject).url = paramString;
    a((StickerLoadInfo)localObject);
    AppMethodBeat.o(105932);
  }
  
  public static String buN(String paramString)
  {
    AppMethodBeat.i(105934);
    p.k(paramString, "lensId");
    paramString = Vbr + paramString + '/';
    AppMethodBeat.o(105934);
    return paramString;
  }
  
  public static boolean buO(String paramString)
  {
    AppMethodBeat.i(105935);
    p.k(paramString, "lensId");
    paramString = buN(paramString);
    f.a locala = com.tencent.mm.sticker.f.Vbg;
    boolean bool = f.a.buL(paramString);
    AppMethodBeat.o(105935);
    return bool;
  }
  
  public static j d(cqv paramcqv)
  {
    AppMethodBeat.i(105933);
    p.k(paramcqv, "lensInfo");
    Log.i(TAG, "loadByFileId: " + paramcqv.LensId);
    if (Util.isNullOrNil(paramcqv.LensId))
    {
      paramcqv = j.kQe;
      AppMethodBeat.o(105933);
      return paramcqv;
    }
    Object localObject = paramcqv.LensId;
    p.j(localObject, "lensInfo.LensId");
    if (buO((String)localObject))
    {
      paramcqv = j.kQd;
      AppMethodBeat.o(105933);
      return paramcqv;
    }
    localObject = StickerLoadInfo.Vbz;
    p.k(paramcqv, "lensInfo");
    StickerLoadInfo localStickerLoadInfo = new StickerLoadInfo();
    String str = paramcqv.LensId;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    p.k(localObject, "<set-?>");
    localStickerLoadInfo.uTz = ((String)localObject);
    localObject = paramcqv.Tyn;
    if (localObject != null)
    {
      str = ((cqx)localObject).RNi;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    p.k(localObject, "<set-?>");
    localStickerLoadInfo.fileId = ((String)localObject);
    localObject = paramcqv.Tyn;
    if (localObject != null)
    {
      str = ((cqx)localObject).AesKey;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    p.k(localObject, "<set-?>");
    localStickerLoadInfo.aesKey = ((String)localObject);
    paramcqv = paramcqv.Tyn;
    if (paramcqv != null) {}
    for (int i = paramcqv.HlG;; i = 0)
    {
      localStickerLoadInfo.nEz = i;
      a(localStickerLoadInfo);
      paramcqv = j.kQg;
      AppMethodBeat.o(105933);
      return paramcqv;
    }
  }
  
  public static void ds(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105938);
    p.k(paramString, "taskKey");
    Log.i(TAG, "notifyProcessTask: ".concat(String.valueOf(paramString)));
    paramString = (g)Vbv.remove(paramString);
    if (paramString != null)
    {
      paramString.ep(paramBoolean);
      AppMethodBeat.o(105938);
      return;
    }
    AppMethodBeat.o(105938);
  }
  
  public static void hqw()
  {
    AppMethodBeat.i(105929);
    com.tencent.mm.ae.d.b("StickerFileManager_cleanFile", (kotlin.g.a.a)c.Vby);
    AppMethodBeat.o(105929);
  }
  
  public static String huX()
  {
    return Vbq;
  }
  
  public static String huY()
  {
    return Vbr;
  }
  
  public static String huZ()
  {
    return Vbs;
  }
  
  public static String hva()
  {
    return Vbt;
  }
  
  public static int hvb()
  {
    return Vbu;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/sticker/loader/StickerFileManager$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-sticker_release"})
  public static final class a
    implements com.tencent.mm.loader.g.f<g>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final c Vby;
    
    static
    {
      AppMethodBeat.i(105928);
      Vby = new c();
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