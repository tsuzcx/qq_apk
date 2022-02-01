package com.tencent.mm.plugin.scanner.model;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.clg;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "SCAN_CONFIG_SYNC_THREAD_TAG", "", "TAG", "callbackMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "netSceneMap", "Lcom/tencent/mm/plugin/scanner/model/NetSceneScanConfigSync;", "scanGoodsResultShowPreviewImage", "", "cancel", "", "type", "onFailed", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "removeConfigType", "configType", "runTask", "task", "Ljava/lang/Runnable;", "scanGoodsShowPreviewImage", "syncScanConfig", "callback", "updateScanExptConfig", "ScanConfigSyncCallback", "plugin-scan_release"})
public final class w
  implements com.tencent.mm.ak.i
{
  private static HashMap<Integer, o> CFX;
  private static boolean CFY;
  public static final w CFZ;
  private static HashMap<Integer, ArrayList<a>> hdu;
  
  static
  {
    AppMethodBeat.i(240419);
    CFZ = new w();
    hdu = new HashMap();
    CFX = new HashMap();
    AppMethodBeat.o(240419);
  }
  
  private static void Wv(int paramInt)
  {
    AppMethodBeat.i(240417);
    Log.v("MicroMsg.ScanConfigSyncManager", "alvinluo removeConfigType: %d", new Object[] { Integer.valueOf(paramInt) });
    hdu.remove(Integer.valueOf(paramInt));
    CFX.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(240417);
  }
  
  public static final void a(int paramInt, final a parama)
  {
    AppMethodBeat.i(240415);
    v((Runnable)new c(paramInt, parama));
    AppMethodBeat.o(240415);
  }
  
  public static final void ePT()
  {
    AppMethodBeat.i(240414);
    int i = ((b)g.af(b.class)).a(b.a.seD, 0);
    if ((i == 1) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      CFY = bool;
      Log.i("MicroMsg.ScanConfigSyncManager", "updateScanExptConfig showPreviewImage: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(CFY) });
      AppMethodBeat.o(240414);
      return;
    }
  }
  
  public static final boolean ePU()
  {
    return CFY;
  }
  
  private static void v(Runnable paramRunnable)
  {
    AppMethodBeat.i(240418);
    h.RTc.b(paramRunnable, "ScanConfigSync");
    AppMethodBeat.o(240418);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(240416);
    Log.i("MicroMsg.ScanConfigSyncManager", "alvinluo onSceneEnd errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    v((Runnable)new b(paramq, paramInt1, paramInt2, paramString));
    AppMethodBeat.o(240416);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void a(clg paramclg);
    
    public abstract void p(int paramInt1, int paramInt2, String paramString);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(q paramq, int paramInt1, int paramInt2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(240412);
      Object localObject = this.hvN;
      if (localObject != null)
      {
        if (((q)localObject).getType() != 1812) {
          break label188;
        }
        if (this.hvN.isCanceled())
        {
          Log.w("MicroMsg.ScanConfigSyncManager", "alvinluo onSceneEnd updateScanConfig is cancelled and ignore");
          AppMethodBeat.o(240412);
        }
      }
      else
      {
        AppMethodBeat.o(240412);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = this.hvN;
        if (localObject == null)
        {
          localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneScanConfigSync");
          AppMethodBeat.o(240412);
          throw ((Throwable)localObject);
        }
        localObject = (o)localObject;
        if (((o)localObject).rr.aYK() != null)
        {
          localObject = ((o)localObject).rr.aYK();
          if (localObject == null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MMBizScanConfSyncResp");
            AppMethodBeat.o(240412);
            throw ((Throwable)localObject);
          }
        }
        for (localObject = (clg)localObject;; localObject = null)
        {
          w localw = w.CFZ;
          w.a(this.hvN, (clg)localObject);
          AppMethodBeat.o(240412);
          return;
        }
      }
      localObject = w.CFZ;
      w.h(paramInt1, paramInt2, paramString, this.hvN);
      label188:
      AppMethodBeat.o(240412);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(int paramInt, w.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(240413);
      Object localObject1 = w.CFZ;
      Object localObject2 = (ArrayList)w.ePV().get(Integer.valueOf(this.$type));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localObject2 = w.CFZ;
        ((Map)w.ePV()).put(Integer.valueOf(this.$type), localObject1);
      }
      if (parama != null) {
        ((ArrayList)localObject1).add(parama);
      }
      localObject1 = w.CFZ;
      if (w.ePW().containsKey(Integer.valueOf(this.$type)))
      {
        Log.w("MicroMsg.ScanConfigSyncManager", "alvinluo syncScanConfig netScene is running and ignore");
        AppMethodBeat.o(240413);
        return;
      }
      g.azz().a(1812, (com.tencent.mm.ak.i)w.CFZ);
      localObject1 = new o(this.$type);
      g.azz().b((q)localObject1);
      localObject2 = w.CFZ;
      ((Map)w.ePW()).put(Integer.valueOf(this.$type), localObject1);
      AppMethodBeat.o(240413);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.w
 * JD-Core Version:    0.7.0.1
 */