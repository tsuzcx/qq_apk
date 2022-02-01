package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.w;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.bq;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/util/OfflineScanManager;", "", "()V", "OFFLINE_SCAN_ENABLE", "", "TAG", "", "currentNetworkStatus", "", "onNetworkChange", "com/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1", "Lcom/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1;", "canUseOfflineScan", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "isFromScanUI", "checkNeedProcessOffline", "errType", "errCode", "clearOfflineScanMessage", "", "handleNetworkUnconnected", "context", "Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "showMsg", "needNotifyMessage", "init", "insertOfflineScanMessage", "content", "notifyMessage", "release", "showNetworkAlert", "Landroid/app/Activity;", "onClickListener", "Landroid/content/DialogInterface$OnClickListener;", "plugin-scan_release"})
public final class b
{
  public static final b IYA;
  private static int IYy;
  private static final b IYz;
  
  static
  {
    AppMethodBeat.i(52487);
    IYA = new b();
    IYy = -1;
    IYz = new b();
    AppMethodBeat.o(52487);
  }
  
  public static void a(OfflineScanContext paramOfflineScanContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(52483);
    kotlin.g.b.p.k(paramOfflineScanContext, "context");
    kotlin.g.b.p.k(paramString, "showMsg");
    Log.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScan handleNetworkUnconnected needNotifyMessage: %b, context: %s, time: %d", new Object[] { Boolean.valueOf(paramBoolean), paramOfflineScanContext, Long.valueOf(paramOfflineScanContext.timestamp) });
    paramString = OfflineScanContext.CREATOR;
    paramOfflineScanContext = OfflineScanContext.a.a(paramOfflineScanContext);
    if (paramBoolean)
    {
      aXv(paramOfflineScanContext);
      AppMethodBeat.o(52483);
      return;
    }
    paramString = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(paramString, "MMKernel.storage()");
    paramString = paramString.aHp().get(ar.a.Vxw, "");
    if (paramString == null)
    {
      paramOfflineScanContext = new kotlin.t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(52483);
      throw paramOfflineScanContext;
    }
    paramString = (String)paramString;
    int i;
    if (((CharSequence)paramString).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label216;
      }
      paramOfflineScanContext = paramString + "," + paramOfflineScanContext;
    }
    label216:
    for (;;)
    {
      Log.i("MicroMsg.OfflineScanManager", "alvinluo handleNetworkUnconnected toSave string length: %d", new Object[] { Integer.valueOf(paramOfflineScanContext.length()) });
      paramString = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(paramString, "MMKernel.storage()");
      paramString.aHp().set(ar.a.Vxw, paramOfflineScanContext);
      AppMethodBeat.o(52483);
      return;
      i = 0;
      break;
    }
  }
  
  private static void aXv(String paramString)
  {
    AppMethodBeat.i(52486);
    Log.i("MicroMsg.OfflineScanManager", "alvinluo insertOfflineScanMessage");
    ca localca = new ca();
    localca.Jm("notifymessage");
    localca.pJ(0);
    localca.setStatus(3);
    localca.setType(721420337);
    localca.setCreateTime(bq.beS());
    localca.setContent(paramString);
    bq.z(localca);
    paramString = new w();
    paramString.fvs.fvt = localca;
    EventCenter.instance.publish((IEvent)paramString);
    AppMethodBeat.o(52486);
  }
  
  public static boolean b(int paramInt, q paramq)
  {
    AppMethodBeat.i(52485);
    kotlin.g.b.p.k(paramq, "scene");
    if (((paramq.getType() == 233) || (paramq.getType() == 106) || (paramq.getType() == 1061)) && ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8) || (paramInt == 3) || (paramInt == 9)))
    {
      AppMethodBeat.o(52485);
      return true;
    }
    AppMethodBeat.o(52485);
    return false;
  }
  
  public static void init()
  {
    AppMethodBeat.i(52480);
    Log.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScanManager init enableOfflineScan: %b", new Object[] { Boolean.TRUE });
    com.tencent.mm.kernel.h.aHF().a((com.tencent.mm.network.p)IYz);
    AppMethodBeat.o(52480);
  }
  
  public static void k(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(52484);
    kotlin.g.b.p.k(paramActivity, "context");
    kotlin.g.b.p.k(paramString, "showMsg");
    com.tencent.mm.ui.base.h.a((Context)paramActivity, paramString, "", paramActivity.getString(l.i.app_i_known), null);
    AppMethodBeat.o(52484);
  }
  
  public static boolean o(q paramq)
  {
    AppMethodBeat.i(52482);
    kotlin.g.b.p.k(paramq, "scene");
    if ((paramq.getType() == 233) || (paramq.getType() == 106) || (paramq.getType() == 1061))
    {
      AppMethodBeat.o(52482);
      return true;
    }
    AppMethodBeat.o(52482);
    return false;
  }
  
  public static void release()
  {
    AppMethodBeat.i(52481);
    Log.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScanManager release");
    com.tencent.mm.kernel.h.aHF().a((com.tencent.mm.network.p)IYz);
    AppMethodBeat.o(52481);
  }
  
  public static boolean xI(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1", "Lcom/tencent/mm/network/IOnNetworkChange_AIDL$Stub;", "onNetworkChange", "", "st", "", "plugin-scan_release"})
  public static final class b
    extends p.a
  {
    public final void onNetworkChange(int paramInt)
    {
      AppMethodBeat.i(52479);
      new MMHandler(Looper.getMainLooper()).post((Runnable)a.IYC);
      AppMethodBeat.o(52479);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a IYC;
      
      static
      {
        AppMethodBeat.i(52478);
        IYC = new a();
        AppMethodBeat.o(52478);
      }
      
      public final void run()
      {
        AppMethodBeat.i(52477);
        Object localObject = com.tencent.mm.kernel.h.aGY();
        kotlin.g.b.p.j(localObject, "MMKernel.getNetSceneQueue()");
        int i = ((com.tencent.mm.an.t)localObject).bih();
        localObject = b.IYA;
        Log.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScan onNetworkChange netWorkStatus: %d, current: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(b.fEO()) });
        localObject = com.tencent.mm.kernel.h.aGY();
        kotlin.g.b.p.j(localObject, "MMKernel.getNetSceneQueue()");
        if (((com.tencent.mm.an.t)localObject).bih() != 6)
        {
          localObject = com.tencent.mm.kernel.h.aGY();
          kotlin.g.b.p.j(localObject, "MMKernel.getNetSceneQueue()");
          if (((com.tencent.mm.an.t)localObject).bih() != 4) {}
        }
        else
        {
          localObject = b.IYA;
          i = b.fEO();
          localObject = com.tencent.mm.kernel.h.aGY();
          kotlin.g.b.p.j(localObject, "MMKernel.getNetSceneQueue()");
          if (i == ((com.tencent.mm.an.t)localObject).bih())
          {
            AppMethodBeat.o(52477);
            return;
          }
          localObject = b.IYA;
          localObject = com.tencent.mm.kernel.h.aGY();
          kotlin.g.b.p.j(localObject, "MMKernel.getNetSceneQueue()");
          b.adX(((com.tencent.mm.an.t)localObject).bih());
          localObject = b.IYA;
          b.fEP();
          AppMethodBeat.o(52477);
          return;
        }
        localObject = b.IYA;
        localObject = com.tencent.mm.kernel.h.aGY();
        kotlin.g.b.p.j(localObject, "MMKernel.getNetSceneQueue()");
        b.adX(((com.tencent.mm.an.t)localObject).bih());
        AppMethodBeat.o(52477);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.b
 * JD-Core Version:    0.7.0.1
 */