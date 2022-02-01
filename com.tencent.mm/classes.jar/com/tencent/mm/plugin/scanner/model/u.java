package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.q;
import com.tencent.mm.protocal.protobuf.ctz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "SCAN_CONFIG_SYNC_THREAD_TAG", "", "TAG", "callbackMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "netSceneMap", "Lcom/tencent/mm/plugin/scanner/model/NetSceneScanConfigSync;", "cancel", "", "type", "onFailed", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "removeConfigType", "configType", "runTask", "task", "Ljava/lang/Runnable;", "scanGoodsShowPreviewImage", "", "syncScanConfig", "callback", "ScanConfigSyncCallback", "plugin-scan_release"})
public final class u
  implements com.tencent.mm.an.i
{
  private static HashMap<Integer, m> ILj;
  public static final u ILk;
  private static HashMap<Integer, ArrayList<a>> jPb;
  
  static
  {
    AppMethodBeat.i(223527);
    ILk = new u();
    jPb = new HashMap();
    ILj = new HashMap();
    AppMethodBeat.o(223527);
  }
  
  public static final void a(int paramInt, final a parama)
  {
    AppMethodBeat.i(223514);
    u((Runnable)new c(paramInt, parama));
    AppMethodBeat.o(223514);
  }
  
  private static void adq(int paramInt)
  {
    AppMethodBeat.i(223522);
    Log.v("MicroMsg.ScanConfigSyncManager", "alvinluo removeConfigType: %d", new Object[] { Integer.valueOf(paramInt) });
    jPb.remove(Integer.valueOf(paramInt));
    ILj.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(223522);
  }
  
  public static final boolean fCO()
  {
    return true;
  }
  
  private static void u(Runnable paramRunnable)
  {
    AppMethodBeat.i(223525);
    com.tencent.e.h.ZvG.d(paramRunnable, "ScanConfigSync");
    AppMethodBeat.o(223525);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(223518);
    Log.i("MicroMsg.ScanConfigSyncManager", "alvinluo onSceneEnd errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    u((Runnable)new b(paramq, paramInt1, paramInt2, paramString));
    AppMethodBeat.o(223518);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void a(ctz paramctz);
    
    public abstract void p(int paramInt1, int paramInt2, String paramString);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(q paramq, int paramInt1, int paramInt2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(217673);
      Object localObject = this.khQ;
      if (localObject != null)
      {
        if (((q)localObject).getType() != 1812) {
          break label188;
        }
        if (this.khQ.isCanceled())
        {
          Log.w("MicroMsg.ScanConfigSyncManager", "alvinluo onSceneEnd updateScanConfig is cancelled and ignore");
          AppMethodBeat.o(217673);
        }
      }
      else
      {
        AppMethodBeat.o(217673);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = this.khQ;
        if (localObject == null)
        {
          localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneScanConfigSync");
          AppMethodBeat.o(217673);
          throw ((Throwable)localObject);
        }
        localObject = (m)localObject;
        if (((m)localObject).rr.bhY() != null)
        {
          localObject = ((m)localObject).rr.bhY();
          if (localObject == null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MMBizScanConfSyncResp");
            AppMethodBeat.o(217673);
            throw ((Throwable)localObject);
          }
        }
        for (localObject = (ctz)localObject;; localObject = null)
        {
          u localu = u.ILk;
          u.a(this.khQ, (ctz)localObject);
          AppMethodBeat.o(217673);
          return;
        }
      }
      localObject = u.ILk;
      u.i(paramInt1, paramInt2, paramString, this.khQ);
      label188:
      AppMethodBeat.o(217673);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(int paramInt, u.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(218431);
      Object localObject1 = u.ILk;
      Object localObject2 = (ArrayList)u.fCP().get(Integer.valueOf(this.cPi));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localObject2 = u.ILk;
        ((Map)u.fCP()).put(Integer.valueOf(this.cPi), localObject1);
      }
      if (parama != null) {
        ((ArrayList)localObject1).add(parama);
      }
      localObject1 = u.ILk;
      if (u.fCQ().containsKey(Integer.valueOf(this.cPi)))
      {
        Log.w("MicroMsg.ScanConfigSyncManager", "alvinluo syncScanConfig netScene is running and ignore");
        AppMethodBeat.o(218431);
        return;
      }
      com.tencent.mm.kernel.h.aGY().a(1812, (com.tencent.mm.an.i)u.ILk);
      localObject1 = new m(this.cPi);
      com.tencent.mm.kernel.h.aGY().b((q)localObject1);
      localObject2 = u.ILk;
      ((Map)u.fCQ()).put(Integer.valueOf(this.cPi), localObject1);
      AppMethodBeat.o(218431);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.u
 * JD-Core Version:    0.7.0.1
 */