package com.tencent.mm.plugin.scanner.model;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.sdk.platformtools.ad;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "SCAN_CONFIG_SYNC_THREAD_TAG", "", "TAG", "callbackMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "netSceneMap", "Lcom/tencent/mm/plugin/scanner/model/NetSceneScanConfigSync;", "scanGoodsResultShowPreviewImage", "", "cancel", "", "type", "onFailed", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "removeConfigType", "configType", "runTask", "task", "Ljava/lang/Runnable;", "scanGoodsShowPreviewImage", "syncScanConfig", "callback", "updateScanExptConfig", "ScanConfigSyncCallback", "plugin-scan_release"})
public final class t
  implements f
{
  private static HashMap<Integer, ArrayList<a>> gpP;
  private static HashMap<Integer, l> ynj;
  private static boolean ynk;
  public static final t ynl;
  
  static
  {
    AppMethodBeat.i(186287);
    ynl = new t();
    gpP = new HashMap();
    ynj = new HashMap();
    AppMethodBeat.o(186287);
  }
  
  private static void Or(int paramInt)
  {
    AppMethodBeat.i(186285);
    ad.v("MicroMsg.ScanConfigSyncManager", "alvinluo removeConfigType: %d", new Object[] { Integer.valueOf(paramInt) });
    gpP.remove(Integer.valueOf(paramInt));
    ynj.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(186285);
  }
  
  public static final void a(a parama)
  {
    AppMethodBeat.i(186283);
    v((Runnable)new c(parama));
    AppMethodBeat.o(186283);
  }
  
  public static final void dKV()
  {
    AppMethodBeat.i(186282);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBL, 0);
    if ((i == 1) || (com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      ynk = bool;
      ad.i("MicroMsg.ScanConfigSyncManager", "updateScanExptConfig showPreviewImage: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(ynk) });
      AppMethodBeat.o(186282);
      return;
    }
  }
  
  public static final boolean dKW()
  {
    return ynk;
  }
  
  private static void v(Runnable paramRunnable)
  {
    AppMethodBeat.i(186286);
    h.LTJ.f(paramRunnable, "ScanConfigSync");
    AppMethodBeat.o(186286);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(186284);
    ad.i("MicroMsg.ScanConfigSyncManager", "alvinluo onSceneEnd errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    v((Runnable)new b(paramn, paramInt1, paramInt2, paramString));
    AppMethodBeat.o(186284);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void a(bwu parambwu);
    
    public abstract void p(int paramInt1, int paramInt2, String paramString);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(n paramn, int paramInt1, int paramInt2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(186280);
      Object localObject = this.gTZ;
      if (localObject != null)
      {
        if (((n)localObject).getType() != 1812) {
          break label188;
        }
        if (this.gTZ.isCanceled())
        {
          ad.w("MicroMsg.ScanConfigSyncManager", "alvinluo onSceneEnd updateScanConfig is cancelled and ignore");
          AppMethodBeat.o(186280);
        }
      }
      else
      {
        AppMethodBeat.o(186280);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = this.gTZ;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneScanConfigSync");
          AppMethodBeat.o(186280);
          throw ((Throwable)localObject);
        }
        localObject = (l)localObject;
        if (((l)localObject).rr.aEF() != null)
        {
          localObject = ((l)localObject).rr.aEF();
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MMBizScanConfSyncResp");
            AppMethodBeat.o(186280);
            throw ((Throwable)localObject);
          }
        }
        for (localObject = (bwu)localObject;; localObject = null)
        {
          t localt = t.ynl;
          t.a(this.gTZ, (bwu)localObject);
          AppMethodBeat.o(186280);
          return;
        }
      }
      localObject = t.ynl;
      t.i(paramInt1, paramInt2, paramString, this.gTZ);
      label188:
      AppMethodBeat.o(186280);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(t.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(186281);
      Object localObject1 = t.ynl;
      Object localObject2 = (ArrayList)t.dKX().get(Integer.valueOf(this.czG));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localObject2 = t.ynl;
        ((Map)t.dKX()).put(Integer.valueOf(this.czG), localObject1);
      }
      if (this.ynm != null) {
        ((ArrayList)localObject1).add(this.ynm);
      }
      localObject1 = t.ynl;
      if (t.dKY().containsKey(Integer.valueOf(this.czG)))
      {
        ad.w("MicroMsg.ScanConfigSyncManager", "alvinluo syncScanConfig netScene is running and ignore");
        AppMethodBeat.o(186281);
        return;
      }
      g.aiU().a(1812, (f)t.ynl);
      localObject1 = new l(this.czG);
      g.aiU().b((n)localObject1);
      localObject2 = t.ynl;
      ((Map)t.dKY()).put(Integer.valueOf(this.czG), localObject1);
      AppMethodBeat.o(186281);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.t
 * JD-Core Version:    0.7.0.1
 */