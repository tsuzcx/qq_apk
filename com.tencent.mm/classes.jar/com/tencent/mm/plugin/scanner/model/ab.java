package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "SCAN_CONFIG_SYNC_THREAD_TAG", "", "TAG", "callbackMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "netSceneMap", "Lcom/tencent/mm/plugin/scanner/model/NetSceneScanConfigSync;", "cancel", "", "type", "onFailed", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "removeConfigType", "configType", "runTask", "task", "Ljava/lang/Runnable;", "scanGoodsShowPreviewImage", "", "syncScanConfig", "callback", "ScanConfigSyncCallback", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  implements com.tencent.mm.am.h
{
  public static final ab OSg;
  private static HashMap<Integer, u> OSh;
  private static HashMap<Integer, ArrayList<a>> mnT;
  
  static
  {
    AppMethodBeat.i(314250);
    OSg = new ab();
    mnT = new HashMap();
    OSh = new HashMap();
    AppMethodBeat.o(314250);
  }
  
  public static final void a(int paramInt, a parama)
  {
    AppMethodBeat.i(314212);
    y(new ab..ExternalSyntheticLambda0(paramInt, parama));
    AppMethodBeat.o(314212);
  }
  
  private static final void a(p paramp, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(314248);
    int i;
    if ((paramp != null) && (paramp.getType() == 1812)) {
      i = 1;
    }
    while (i != 0) {
      if (paramp.isCanceled())
      {
        Log.w("MicroMsg.ScanConfigSyncManager", "alvinluo onSceneEnd updateScanConfig is cancelled and ignore");
        AppMethodBeat.o(314248);
        return;
        i = 0;
      }
      else
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (paramp == null)
          {
            paramp = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.scanner.model.NetSceneScanConfigSync");
            AppMethodBeat.o(314248);
            throw paramp;
          }
          paramString = (u)paramp;
          if (c.c.b(paramString.rr.otC) != null)
          {
            paramString = c.c.b(paramString.rr.otC);
            if (paramString == null)
            {
              paramp = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MMBizScanConfSyncResp");
              AppMethodBeat.o(314248);
              throw paramp;
            }
          }
          for (paramString = (dlb)paramString;; paramString = null)
          {
            a(paramp, paramString);
            AppMethodBeat.o(314248);
            return;
          }
        }
        i(paramInt1, paramInt2, paramString, paramp);
      }
    }
    AppMethodBeat.o(314248);
  }
  
  private static void a(p paramp, dlb paramdlb)
  {
    AppMethodBeat.i(314216);
    if ((paramp instanceof u))
    {
      int i = ((u)paramp).ORP;
      ArrayList localArrayList = (ArrayList)mnT.get(Integer.valueOf(i));
      if (localArrayList == null) {}
      for (paramp = null;; paramp = Integer.valueOf(localArrayList.size()))
      {
        Log.v("MicroMsg.ScanConfigSyncManager", "alvinluo onSuccess callbackList size: %d", new Object[] { paramp });
        if (localArrayList == null) {
          break;
        }
        paramp = ((Iterable)localArrayList).iterator();
        while (paramp.hasNext()) {
          ((a)paramp.next()).a(paramdlb);
        }
      }
      ahN(i);
    }
    AppMethodBeat.o(314216);
  }
  
  private static void ahN(int paramInt)
  {
    AppMethodBeat.i(314227);
    Log.v("MicroMsg.ScanConfigSyncManager", "alvinluo removeConfigType: %d", new Object[] { Integer.valueOf(paramInt) });
    mnT.remove(Integer.valueOf(paramInt));
    OSh.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(314227);
  }
  
  private static final void b(int paramInt, a parama)
  {
    AppMethodBeat.i(314238);
    ArrayList localArrayList2 = (ArrayList)mnT.get(Integer.valueOf(paramInt));
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      ((Map)mnT).put(Integer.valueOf(paramInt), localArrayList1);
    }
    if (parama != null) {
      localArrayList1.add(parama);
    }
    if (OSh.containsKey(Integer.valueOf(paramInt)))
    {
      Log.w("MicroMsg.ScanConfigSyncManager", "alvinluo syncScanConfig netScene is running and ignore");
      AppMethodBeat.o(314238);
      return;
    }
    com.tencent.mm.kernel.h.aZW().a(1812, (com.tencent.mm.am.h)OSg);
    parama = new u(paramInt);
    com.tencent.mm.kernel.h.aZW().a((p)parama, 0);
    ((Map)OSh).put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(314238);
  }
  
  public static final boolean gQV()
  {
    return true;
  }
  
  private static void i(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(314220);
    if ((paramp instanceof u))
    {
      int i = ((u)paramp).ORP;
      paramp = (ArrayList)mnT.get(Integer.valueOf(i));
      if (paramp != null)
      {
        paramp = ((Iterable)paramp).iterator();
        while (paramp.hasNext()) {
          ((a)paramp.next()).s(paramInt1, paramInt2, paramString);
        }
      }
      ahN(i);
    }
    AppMethodBeat.o(314220);
  }
  
  private static void y(Runnable paramRunnable)
  {
    AppMethodBeat.i(314232);
    com.tencent.threadpool.h.ahAA.g(paramRunnable, "ScanConfigSync");
    AppMethodBeat.o(314232);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(314263);
    Log.i("MicroMsg.ScanConfigSyncManager", "alvinluo onSceneEnd errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    y(new ab..ExternalSyntheticLambda1(paramp, paramInt1, paramInt2, paramString));
    AppMethodBeat.o(314263);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(dlb paramdlb);
    
    public abstract void s(int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ab
 * JD-Core Version:    0.7.0.1
 */