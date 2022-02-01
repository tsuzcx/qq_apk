package com.tencent.mm.sticker.loader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f.a;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/loader/StickerFileManager;", "", "()V", "TAG", "", "callback", "com/tencent/mm/sticker/loader/StickerFileManager$callback$1", "Lcom/tencent/mm/sticker/loader/StickerFileManager$callback$1;", "maxPackageCount", "", "getMaxPackageCount", "()I", "processTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "Lkotlin/collections/HashMap;", "stickerDir", "getStickerDir", "()Ljava/lang/String;", "stickerPackage", "getStickerPackage", "stickerTemp", "getStickerTemp", "stickerThumb", "getStickerThumb", "taskQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "checkLocal", "", "lensId", "cleanDir", "", "dir", "maxCount", "cleanFile", "getPackById", "loadByFileId", "Lcom/tencent/mm/loader/loader/WorkStatus;", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "loadByInfo", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "loadByUrl", "url", "loadFromRemote", "Lkotlin/Function1;", "notifyProcessTask", "taskKey", "success", "register", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "unregister", "plugin-sticker_release"})
public final class e
{
  private static final String NNG;
  private static final String NNH;
  private static final String NNI;
  private static final String NNJ;
  private static final int NNK = 50;
  private static final HashMap<String, g> NNL;
  private static final a NNM;
  public static final e NNN;
  private static final String TAG = "MicroMsg.StickerFileManager";
  private static final com.tencent.mm.loader.g.d<g> gVJ;
  
  static
  {
    AppMethodBeat.i(105939);
    NNN = new e();
    TAG = "MicroMsg.StickerFileManager";
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = MMApplicationContext.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getCacheDir();
    p.g(localObject, "MMApplicationContext.getContext().cacheDir");
    NNG = ((File)localObject).getAbsolutePath() + "/sticker/";
    NNH = NNG + "package/";
    NNI = NNG + "temp/";
    NNJ = NNG + "thumb/";
    NNK = 50;
    gVJ = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a((byte)0), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "StickerTask"));
    NNL = new HashMap();
    NNM = new a();
    s.boN(NNG);
    s.bpc(NNG);
    gVJ.a((com.tencent.mm.loader.g.f)NNM);
    AppMethodBeat.o(105939);
  }
  
  public static void a(com.tencent.mm.loader.g.f<g> paramf)
  {
    AppMethodBeat.i(105930);
    p.h(paramf, "callback");
    gVJ.a(paramf);
    AppMethodBeat.o(105930);
  }
  
  private static void a(StickerLoadInfo paramStickerLoadInfo)
  {
    AppMethodBeat.i(105936);
    p.h(paramStickerLoadInfo, "info");
    if (NNL.containsKey(paramStickerLoadInfo.Lb()))
    {
      Log.i(TAG, "loadByInfo: " + paramStickerLoadInfo.Lb() + " waiting in queue");
      AppMethodBeat.o(105936);
      return;
    }
    Object localObject = com.tencent.mm.kernel.g.aAe().azG();
    p.g(localObject, "MMKernel.process().current()");
    if (((h)localObject).aBb()) {
      if (paramStickerLoadInfo.type == 1) {
        paramStickerLoadInfo = (g)new i(paramStickerLoadInfo);
      }
    }
    for (;;)
    {
      gVJ.c((com.tencent.mm.loader.g.c)paramStickerLoadInfo);
      AppMethodBeat.o(105936);
      return;
      paramStickerLoadInfo = (g)new d(paramStickerLoadInfo);
      continue;
      localObject = new f(paramStickerLoadInfo);
      ((Map)NNL).put(paramStickerLoadInfo.Lb(), localObject);
      paramStickerLoadInfo = (g)localObject;
    }
  }
  
  public static void a(StickerLoadInfo paramStickerLoadInfo, b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(194225);
    p.h(paramStickerLoadInfo, "info");
    Log.i(TAG, "loadFromRemote: " + paramStickerLoadInfo.Lb());
    if (paramStickerLoadInfo.type == 1) {}
    for (g localg = (g)new i(paramStickerLoadInfo);; localg = (g)new d(paramStickerLoadInfo))
    {
      if ((paramb != null) && (!localg.NNT.contains(paramb))) {
        localg.NNT.add(paramb);
      }
      ((Map)NNL).put(paramStickerLoadInfo.Lb(), localg);
      gVJ.c((com.tencent.mm.loader.g.c)localg);
      AppMethodBeat.o(194225);
      return;
    }
  }
  
  public static void b(com.tencent.mm.loader.g.f<g> paramf)
  {
    AppMethodBeat.i(105931);
    p.h(paramf, "callback");
    gVJ.b(paramf);
    AppMethodBeat.o(105931);
  }
  
  public static void biv(String paramString)
  {
    AppMethodBeat.i(105932);
    p.h(paramString, "url");
    Object localObject = StickerLoadInfo.NNP;
    p.h(paramString, "url");
    localObject = new StickerLoadInfo(1);
    p.h(paramString, "<set-?>");
    ((StickerLoadInfo)localObject).url = paramString;
    a((StickerLoadInfo)localObject);
    AppMethodBeat.o(105932);
  }
  
  public static String biw(String paramString)
  {
    AppMethodBeat.i(105934);
    p.h(paramString, "lensId");
    paramString = NNH + paramString + '/';
    AppMethodBeat.o(105934);
    return paramString;
  }
  
  public static boolean bix(String paramString)
  {
    AppMethodBeat.i(105935);
    p.h(paramString, "lensId");
    paramString = biw(paramString);
    f.a locala = com.tencent.mm.sticker.f.NNw;
    boolean bool = f.a.biu(paramString);
    AppMethodBeat.o(105935);
    return bool;
  }
  
  public static j d(chz paramchz)
  {
    AppMethodBeat.i(105933);
    p.h(paramchz, "lensInfo");
    Log.i(TAG, "loadByFileId: " + paramchz.Lso);
    if (Util.isNullOrNil(paramchz.Lso))
    {
      paramchz = j.ibx;
      AppMethodBeat.o(105933);
      return paramchz;
    }
    Object localObject = paramchz.Lso;
    p.g(localObject, "lensInfo.LensId");
    if (bix((String)localObject))
    {
      paramchz = j.ibw;
      AppMethodBeat.o(105933);
      return paramchz;
    }
    localObject = StickerLoadInfo.NNP;
    p.h(paramchz, "lensInfo");
    StickerLoadInfo localStickerLoadInfo = new StickerLoadInfo();
    String str = paramchz.Lso;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    p.h(localObject, "<set-?>");
    localStickerLoadInfo.rnS = ((String)localObject);
    localObject = paramchz.Mns;
    if (localObject != null)
    {
      str = ((cib)localObject).KMl;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    p.h(localObject, "<set-?>");
    localStickerLoadInfo.fileId = ((String)localObject);
    localObject = paramchz.Mns;
    if (localObject != null)
    {
      str = ((cib)localObject).AesKey;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    p.h(localObject, "<set-?>");
    localStickerLoadInfo.aesKey = ((String)localObject);
    paramchz = paramchz.Mns;
    if (paramchz != null) {}
    for (int i = paramchz.FileSize;; i = 0)
    {
      localStickerLoadInfo.kKK = i;
      a(localStickerLoadInfo);
      paramchz = j.ibz;
      AppMethodBeat.o(105933);
      return paramchz;
    }
  }
  
  public static void dh(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105938);
    p.h(paramString, "taskKey");
    Log.i(TAG, "notifyProcessTask: ".concat(String.valueOf(paramString)));
    paramString = (g)NNL.remove(paramString);
    if (paramString != null)
    {
      paramString.dQ(paramBoolean);
      AppMethodBeat.o(105938);
      return;
    }
    AppMethodBeat.o(105938);
  }
  
  public static String gyW()
  {
    return NNG;
  }
  
  public static String gyX()
  {
    return NNH;
  }
  
  public static String gyY()
  {
    return NNI;
  }
  
  public static String gyZ()
  {
    return NNJ;
  }
  
  public static int gza()
  {
    return NNK;
  }
  
  public static void gzb()
  {
    AppMethodBeat.i(105929);
    com.tencent.mm.ac.d.b("StickerFileManager_cleanFile", (kotlin.g.a.a)c.NNO);
    AppMethodBeat.o(105929);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/sticker/loader/StickerFileManager$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-sticker_release"})
  public static final class a
    implements com.tencent.mm.loader.g.f<g>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final c NNO;
    
    static
    {
      AppMethodBeat.i(105928);
      NNO = new c();
      AppMethodBeat.o(105928);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.e
 * JD-Core Version:    0.7.0.1
 */