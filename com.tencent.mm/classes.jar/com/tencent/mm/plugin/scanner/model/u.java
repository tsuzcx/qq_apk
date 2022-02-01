package com.tencent.mm.plugin.scanner.model;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.bxo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "SCAN_CONFIG_SYNC_THREAD_TAG", "", "TAG", "callbackMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "netSceneMap", "Lcom/tencent/mm/plugin/scanner/model/NetSceneScanConfigSync;", "scanGoodsResultShowPreviewImage", "", "cancel", "", "type", "onFailed", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "removeConfigType", "configType", "runTask", "task", "Ljava/lang/Runnable;", "scanGoodsShowPreviewImage", "syncScanConfig", "callback", "updateScanExptConfig", "ScanConfigSyncCallback", "plugin-scan_release"})
public final class u
  implements f
{
  private static HashMap<Integer, ArrayList<a>> gsk;
  private static HashMap<Integer, m> yDi;
  private static boolean yDj;
  public static final u yDk;
  
  static
  {
    AppMethodBeat.i(189576);
    yDk = new u();
    gsk = new HashMap();
    yDi = new HashMap();
    AppMethodBeat.o(189576);
  }
  
  private static void OX(int paramInt)
  {
    AppMethodBeat.i(189574);
    ae.v("MicroMsg.ScanConfigSyncManager", "alvinluo removeConfigType: %d", new Object[] { Integer.valueOf(paramInt) });
    gsk.remove(Integer.valueOf(paramInt));
    yDi.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(189574);
  }
  
  public static final void a(int paramInt, final a parama)
  {
    AppMethodBeat.i(189572);
    t((Runnable)new c(paramInt, parama));
    AppMethodBeat.o(189572);
  }
  
  public static final void dOn()
  {
    AppMethodBeat.i(189571);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qJe, 0);
    if ((i == 1) || (j.DEBUG) || (j.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      yDj = bool;
      ae.i("MicroMsg.ScanConfigSyncManager", "updateScanExptConfig showPreviewImage: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(yDj) });
      AppMethodBeat.o(189571);
      return;
    }
  }
  
  public static final boolean dOo()
  {
    return yDj;
  }
  
  private static void t(Runnable paramRunnable)
  {
    AppMethodBeat.i(189575);
    h.MqF.f(paramRunnable, "ScanConfigSync");
    AppMethodBeat.o(189575);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(189573);
    ae.i("MicroMsg.ScanConfigSyncManager", "alvinluo onSceneEnd errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    t((Runnable)new b(paramn, paramInt1, paramInt2, paramString));
    AppMethodBeat.o(189573);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void a(bxo parambxo);
    
    public abstract void p(int paramInt1, int paramInt2, String paramString);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(n paramn, int paramInt1, int paramInt2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(189569);
      Object localObject = this.gIU;
      if (localObject != null)
      {
        if (((n)localObject).getType() != 1812) {
          break label188;
        }
        if (this.gIU.isCanceled())
        {
          ae.w("MicroMsg.ScanConfigSyncManager", "alvinluo onSceneEnd updateScanConfig is cancelled and ignore");
          AppMethodBeat.o(189569);
        }
      }
      else
      {
        AppMethodBeat.o(189569);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = this.gIU;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneScanConfigSync");
          AppMethodBeat.o(189569);
          throw ((Throwable)localObject);
        }
        localObject = (m)localObject;
        if (((m)localObject).rr.aEV() != null)
        {
          localObject = ((m)localObject).rr.aEV();
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MMBizScanConfSyncResp");
            AppMethodBeat.o(189569);
            throw ((Throwable)localObject);
          }
        }
        for (localObject = (bxo)localObject;; localObject = null)
        {
          u localu = u.yDk;
          u.a(this.gIU, (bxo)localObject);
          AppMethodBeat.o(189569);
          return;
        }
      }
      localObject = u.yDk;
      u.i(paramInt1, paramInt2, paramString, this.gIU);
      label188:
      AppMethodBeat.o(189569);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(int paramInt, u.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(189570);
      Object localObject1 = u.yDk;
      Object localObject2 = (ArrayList)u.dOp().get(Integer.valueOf(this.cAn));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localObject2 = u.yDk;
        ((Map)u.dOp()).put(Integer.valueOf(this.cAn), localObject1);
      }
      if (parama != null) {
        ((ArrayList)localObject1).add(parama);
      }
      localObject1 = u.yDk;
      if (u.dOq().containsKey(Integer.valueOf(this.cAn)))
      {
        ae.w("MicroMsg.ScanConfigSyncManager", "alvinluo syncScanConfig netScene is running and ignore");
        AppMethodBeat.o(189570);
        return;
      }
      g.ajj().a(1812, (f)u.yDk);
      localObject1 = new m(this.cAn);
      g.ajj().b((n)localObject1);
      localObject2 = u.yDk;
      ((Map)u.dOq()).put(Integer.valueOf(this.cAn), localObject1);
      AppMethodBeat.o(189570);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.u
 * JD-Core Version:    0.7.0.1
 */