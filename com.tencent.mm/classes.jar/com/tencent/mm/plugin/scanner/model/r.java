package com.tencent.mm.plugin.scanner.model;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.protocal.protobuf.bsh;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "SCAN_CONFIG_SYNC_THREAD_TAG", "", "TAG", "callbackMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "netSceneMap", "Lcom/tencent/mm/plugin/scanner/model/NetSceneScanConfigSync;", "scanGoodsResultShowPreviewImage", "", "cancel", "", "type", "onFailed", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "removeConfigType", "configType", "runTask", "task", "Ljava/lang/Runnable;", "scanGoodsShowPreviewImage", "syncScanConfig", "callback", "updateScanExptConfig", "ScanConfigSyncCallback", "plugin-scan_release"})
public final class r
  implements com.tencent.mm.ak.g
{
  private static HashMap<Integer, j> ByS;
  private static boolean ByT;
  public static final r ByU;
  private static HashMap<Integer, ArrayList<a>> fWm;
  
  static
  {
    AppMethodBeat.i(210226);
    ByU = new r();
    fWm = new HashMap();
    ByS = new HashMap();
    AppMethodBeat.o(210226);
  }
  
  private static void YQ(int paramInt)
  {
    AppMethodBeat.i(210224);
    ac.v("MicroMsg.ScanConfigSyncManager", "alvinluo removeConfigType: %d", new Object[] { Integer.valueOf(paramInt) });
    fWm.remove(Integer.valueOf(paramInt));
    ByS.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(210224);
  }
  
  public static final void a(a parama)
  {
    AppMethodBeat.i(210222);
    v((Runnable)new c(parama));
    AppMethodBeat.o(210222);
  }
  
  public static final void eBu()
  {
    AppMethodBeat.i(210221);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.rEE, 0);
    if ((i == 1) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      ByT = bool;
      ac.i("MicroMsg.ScanConfigSyncManager", "updateScanExptConfig showPreviewImage: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(ByT) });
      AppMethodBeat.o(210221);
      return;
    }
  }
  
  public static final boolean eBv()
  {
    return ByT;
  }
  
  private static void v(Runnable paramRunnable)
  {
    AppMethodBeat.i(210225);
    com.tencent.e.h.JZN.f(paramRunnable, "ScanConfigSync");
    AppMethodBeat.o(210225);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(210223);
    ac.i("MicroMsg.ScanConfigSyncManager", "alvinluo onSceneEnd errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    v((Runnable)new b(paramn, paramInt1, paramInt2, paramString));
    AppMethodBeat.o(210223);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void a(bsh parambsh);
    
    public abstract void p(int paramInt1, int paramInt2, String paramString);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(n paramn, int paramInt1, int paramInt2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(210219);
      Object localObject = this.gAp;
      if (localObject != null)
      {
        if (((n)localObject).getType() != 1812) {
          break label188;
        }
        if (this.gAp.isCanceled())
        {
          ac.w("MicroMsg.ScanConfigSyncManager", "alvinluo onSceneEnd updateScanConfig is cancelled and ignore");
          AppMethodBeat.o(210219);
        }
      }
      else
      {
        AppMethodBeat.o(210219);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = this.gAp;
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneScanConfigSync");
          AppMethodBeat.o(210219);
          throw ((Throwable)localObject);
        }
        localObject = (j)localObject;
        if (((j)localObject).rr.aBD() != null)
        {
          localObject = ((j)localObject).rr.aBD();
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MMBizScanConfSyncResp");
            AppMethodBeat.o(210219);
            throw ((Throwable)localObject);
          }
        }
        for (localObject = (bsh)localObject;; localObject = null)
        {
          r localr = r.ByU;
          r.a(this.gAp, (bsh)localObject);
          AppMethodBeat.o(210219);
          return;
        }
      }
      localObject = r.ByU;
      r.i(paramInt1, paramInt2, paramString, this.gAp);
      label188:
      AppMethodBeat.o(210219);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(r.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(210220);
      Object localObject1 = r.ByU;
      Object localObject2 = (ArrayList)r.eBw().get(Integer.valueOf(this.coP));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localObject2 = r.ByU;
        ((Map)r.eBw()).put(Integer.valueOf(this.coP), localObject1);
      }
      if (this.ByV != null) {
        ((ArrayList)localObject1).add(this.ByV);
      }
      localObject1 = r.ByU;
      if (r.eBx().containsKey(Integer.valueOf(this.coP)))
      {
        ac.w("MicroMsg.ScanConfigSyncManager", "alvinluo syncScanConfig netScene is running and ignore");
        AppMethodBeat.o(210220);
        return;
      }
      com.tencent.mm.kernel.g.agi().a(1812, (com.tencent.mm.ak.g)r.ByU);
      localObject1 = new j(this.coP);
      com.tencent.mm.kernel.g.agi().b((n)localObject1);
      localObject2 = r.ByU;
      ((Map)r.eBx()).put(Integer.valueOf(this.coP), localObject1);
      AppMethodBeat.o(210220);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.r
 * JD-Core Version:    0.7.0.1
 */