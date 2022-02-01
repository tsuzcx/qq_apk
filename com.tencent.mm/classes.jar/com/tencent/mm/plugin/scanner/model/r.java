package com.tencent.mm.plugin.scanner.model;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/ScanConfigSyncManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "SCAN_CONFIG_SYNC_THREAD_TAG", "", "TAG", "callbackMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanConfigSyncManager$ScanConfigSyncCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "netSceneMap", "Lcom/tencent/mm/plugin/scanner/model/NetSceneScanConfigSync;", "cancel", "", "type", "onFailed", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "removeConfigType", "configType", "runTask", "task", "Ljava/lang/Runnable;", "syncScanConfig", "callback", "ScanConfigSyncCallback", "plugin-scan_release"})
public final class r
  implements com.tencent.mm.al.g
{
  private static HashMap<Integer, ArrayList<a>> fSr;
  private static HashMap<Integer, j> vOS;
  public static final r vOT;
  
  static
  {
    AppMethodBeat.i(52195);
    vOT = new r();
    fSr = new HashMap();
    vOS = new HashMap();
    AppMethodBeat.o(52195);
  }
  
  private static void KO(int paramInt)
  {
    AppMethodBeat.i(52193);
    ad.v("MicroMsg.ScanConfigSyncManager", "alvinluo removeConfigType: %d", new Object[] { Integer.valueOf(paramInt) });
    fSr.remove(Integer.valueOf(paramInt));
    vOS.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(52193);
  }
  
  public static final void a(a parama)
  {
    AppMethodBeat.i(52191);
    u((Runnable)new c(parama));
    AppMethodBeat.o(52191);
  }
  
  private static void u(Runnable paramRunnable)
  {
    AppMethodBeat.i(52194);
    h.Iye.f(paramRunnable, "ScanConfigSync");
    AppMethodBeat.o(52194);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(52192);
    ad.i("MicroMsg.ScanConfigSyncManager", "alvinluo onSceneEnd errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    u((Runnable)new b(paramn, paramInt1, paramInt2, paramString));
    AppMethodBeat.o(52192);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/ScanConfigSyncManager$ScanConfigSyncCallback;", "", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void a(bnr parambnr);
    
    public abstract void p(int paramInt1, int paramInt2, String paramString);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(n paramn, int paramInt1, int paramInt2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(52189);
      Object localObject = this.qLb;
      if (localObject != null)
      {
        if (((n)localObject).getType() != 1812) {
          break label188;
        }
        if (this.qLb.isCanceled())
        {
          ad.w("MicroMsg.ScanConfigSyncManager", "alvinluo onSceneEnd updateScanConfig is cancelled and ignore");
          AppMethodBeat.o(52189);
        }
      }
      else
      {
        AppMethodBeat.o(52189);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = this.qLb;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneScanConfigSync");
          AppMethodBeat.o(52189);
          throw ((Throwable)localObject);
        }
        localObject = (j)localObject;
        if (((j)localObject).rr.auM() != null)
        {
          localObject = ((j)localObject).rr.auM();
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MMBizScanConfSyncResp");
            AppMethodBeat.o(52189);
            throw ((Throwable)localObject);
          }
        }
        for (localObject = (bnr)localObject;; localObject = null)
        {
          r localr = r.vOT;
          r.a(this.qLb, (bnr)localObject);
          AppMethodBeat.o(52189);
          return;
        }
      }
      localObject = r.vOT;
      r.i(paramInt1, paramInt2, paramString, this.qLb);
      label188:
      AppMethodBeat.o(52189);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(r.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(52190);
      Object localObject1 = r.vOT;
      Object localObject2 = (ArrayList)r.dlv().get(Integer.valueOf(this.crJ));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localObject2 = r.vOT;
        ((Map)r.dlv()).put(Integer.valueOf(this.crJ), localObject1);
      }
      if (this.vOU != null) {
        ((ArrayList)localObject1).add(this.vOU);
      }
      localObject1 = r.vOT;
      if (r.dlw().containsKey(Integer.valueOf(this.crJ)))
      {
        ad.w("MicroMsg.ScanConfigSyncManager", "alvinluo syncScanConfig netScene is running and ignore");
        AppMethodBeat.o(52190);
        return;
      }
      com.tencent.mm.kernel.g.aeS().a(1812, (com.tencent.mm.al.g)r.vOT);
      localObject1 = new j(this.crJ);
      com.tencent.mm.kernel.g.aeS().b((n)localObject1);
      localObject2 = r.vOT;
      ((Map)r.dlw()).put(Integer.valueOf(this.crJ), localObject1);
      AppMethodBeat.o(52190);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.r
 * JD-Core Version:    0.7.0.1
 */