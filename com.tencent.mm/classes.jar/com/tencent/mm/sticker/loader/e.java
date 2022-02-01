package com.tencent.mm.sticker.loader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.protocal.protobuf.dhr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f.a;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/loader/StickerFileManager;", "", "()V", "TAG", "", "callback", "com/tencent/mm/sticker/loader/StickerFileManager$callback$1", "Lcom/tencent/mm/sticker/loader/StickerFileManager$callback$1;", "maxPackageCount", "", "getMaxPackageCount", "()I", "processTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "Lkotlin/collections/HashMap;", "stickerDir", "getStickerDir", "()Ljava/lang/String;", "stickerPackage", "getStickerPackage", "stickerTemp", "getStickerTemp", "stickerThumb", "getStickerThumb", "taskQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "checkLocal", "", "lensId", "cleanDir", "", "dir", "maxCount", "cleanFile", "getPackById", "loadByFileId", "Lcom/tencent/mm/loader/loader/WorkStatus;", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "loadByInfo", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "loadByUrl", "url", "loadFromRemote", "Lkotlin/Function1;", "notifyProcessTask", "taskKey", "success", "register", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "unregister", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final String TAG;
  public static final e acCJ;
  private static final String acCK;
  private static final String acCL;
  private static final String acCM;
  private static final String acCN;
  private static final int acCO;
  private static final HashMap<String, g> acCP;
  private static final a acCQ;
  private static final com.tencent.mm.loader.f.d<g> mgn;
  
  static
  {
    AppMethodBeat.i(105939);
    acCJ = new e();
    TAG = "MicroMsg.StickerFileManager";
    String str = s.X(MMApplicationContext.getContext().getCacheDir().getAbsolutePath(), "/sticker/");
    acCK = str;
    acCL = s.X(str, "package/");
    acCM = s.X(acCK, "temp/");
    acCN = s.X(acCK, "thumb/");
    acCO = 50;
    mgn = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new com.tencent.mm.loader.f.a.f((com.tencent.mm.loader.f.a.c)new com.tencent.mm.loader.f.a.a((byte)0), new com.tencent.mm.loader.f.a.g(1, (byte)0), 1, "StickerTask"));
    acCP = new HashMap();
    acCQ = new a();
    y.bDX(acCK);
    y.bEr(acCK);
    mgn.a((com.tencent.mm.loader.f.e)acCQ);
    AppMethodBeat.o(105939);
  }
  
  public static void a(com.tencent.mm.loader.f.e<g> parame)
  {
    AppMethodBeat.i(105930);
    s.u(parame, "callback");
    mgn.a(parame);
    AppMethodBeat.o(105930);
  }
  
  private static void a(StickerLoadInfo paramStickerLoadInfo)
  {
    AppMethodBeat.i(105936);
    s.u(paramStickerLoadInfo, "info");
    if (acCP.containsKey(paramStickerLoadInfo.key()))
    {
      Log.i(TAG, "loadByInfo: " + paramStickerLoadInfo.key() + " waiting in queue");
      AppMethodBeat.o(105936);
      return;
    }
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) {
      if (paramStickerLoadInfo.type == 1) {
        paramStickerLoadInfo = (g)new i(paramStickerLoadInfo);
      }
    }
    for (;;)
    {
      mgn.c((com.tencent.mm.loader.f.c)paramStickerLoadInfo);
      AppMethodBeat.o(105936);
      return;
      paramStickerLoadInfo = (g)new d(paramStickerLoadInfo);
      continue;
      f localf = new f(paramStickerLoadInfo);
      ((Map)acCP).put(paramStickerLoadInfo.key(), localf);
      paramStickerLoadInfo = (g)localf;
    }
  }
  
  public static void a(StickerLoadInfo paramStickerLoadInfo, b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(233911);
    s.u(paramStickerLoadInfo, "info");
    Log.i(TAG, s.X("loadFromRemote: ", paramStickerLoadInfo.key()));
    if (paramStickerLoadInfo.type == 1) {}
    for (g localg = (g)new i(paramStickerLoadInfo);; localg = (g)new d(paramStickerLoadInfo))
    {
      if (!localg.acCV.contains(paramb)) {
        localg.acCV.add(paramb);
      }
      ((Map)acCP).put(paramStickerLoadInfo.key(), localg);
      mgn.c((com.tencent.mm.loader.f.c)localg);
      AppMethodBeat.o(233911);
      return;
    }
  }
  
  public static void b(com.tencent.mm.loader.f.e<g> parame)
  {
    AppMethodBeat.i(105931);
    s.u(parame, "callback");
    mgn.b(parame);
    AppMethodBeat.o(105931);
  }
  
  public static void buT(String paramString)
  {
    AppMethodBeat.i(105932);
    s.u(paramString, "url");
    Object localObject = StickerLoadInfo.acCS;
    s.u(paramString, "url");
    localObject = new StickerLoadInfo(1);
    s.u(paramString, "<set-?>");
    ((StickerLoadInfo)localObject).url = paramString;
    a((StickerLoadInfo)localObject);
    AppMethodBeat.o(105932);
  }
  
  public static String buU(String paramString)
  {
    AppMethodBeat.i(105934);
    s.u(paramString, "lensId");
    paramString = acCL + paramString + '/';
    AppMethodBeat.o(105934);
    return paramString;
  }
  
  public static boolean buV(String paramString)
  {
    AppMethodBeat.i(105935);
    s.u(paramString, "lensId");
    paramString = buU(paramString);
    f.a locala = com.tencent.mm.sticker.f.acCu;
    boolean bool = f.a.buR(paramString);
    AppMethodBeat.o(105935);
    return bool;
  }
  
  public static com.tencent.mm.loader.f.i d(dhp paramdhp)
  {
    AppMethodBeat.i(105933);
    s.u(paramdhp, "lensInfo");
    Log.i(TAG, s.X("loadByFileId: ", paramdhp.LensId));
    if (Util.isNullOrNil(paramdhp.LensId))
    {
      paramdhp = com.tencent.mm.loader.f.i.nrH;
      AppMethodBeat.o(105933);
      return paramdhp;
    }
    Object localObject = paramdhp.LensId;
    s.s(localObject, "lensInfo.LensId");
    if (buV((String)localObject))
    {
      paramdhp = com.tencent.mm.loader.f.i.nrG;
      AppMethodBeat.o(105933);
      return paramdhp;
    }
    localObject = StickerLoadInfo.acCS;
    s.u(paramdhp, "lensInfo");
    StickerLoadInfo localStickerLoadInfo = new StickerLoadInfo();
    String str = paramdhp.LensId;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    s.u(localObject, "<set-?>");
    localStickerLoadInfo.ygo = ((String)localObject);
    localObject = paramdhp.aaMU;
    if (localObject == null)
    {
      localObject = "";
      s.u(localObject, "<set-?>");
      localStickerLoadInfo.fileId = ((String)localObject);
      localObject = paramdhp.aaMU;
      if (localObject != null) {
        break label234;
      }
      localObject = "";
      label169:
      s.u(localObject, "<set-?>");
      localStickerLoadInfo.aesKey = ((String)localObject);
      paramdhp = paramdhp.aaMU;
      if (paramdhp != null) {
        break label252;
      }
    }
    label234:
    label252:
    for (int i = 0;; i = paramdhp.Nju)
    {
      localStickerLoadInfo.qEw = i;
      a(localStickerLoadInfo);
      paramdhp = com.tencent.mm.loader.f.i.nrJ;
      AppMethodBeat.o(105933);
      return paramdhp;
      str = ((dhr)localObject).YKw;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      str = ((dhr)localObject).AesKey;
      localObject = str;
      if (str != null) {
        break label169;
      }
      localObject = "";
      break label169;
    }
  }
  
  public static void fio()
  {
    AppMethodBeat.i(105929);
    com.tencent.mm.ae.d.d("StickerFileManager_cleanFile", (kotlin.g.a.a)c.acCR);
    AppMethodBeat.o(105929);
  }
  
  public static String iWA()
  {
    return acCL;
  }
  
  public static String iWB()
  {
    return acCM;
  }
  
  public static String iWC()
  {
    return acCN;
  }
  
  public static int iWD()
  {
    return acCO;
  }
  
  public static String iWz()
  {
    return acCK;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/sticker/loader/StickerFileManager$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.loader.f.e<g>
  {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final c acCR;
    
    static
    {
      AppMethodBeat.i(105928);
      acCR = new c();
      AppMethodBeat.o(105928);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.e
 * JD-Core Version:    0.7.0.1
 */