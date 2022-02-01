package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.v;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.List;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/util/OfflineScanManager;", "", "()V", "OFFLINE_SCAN_ENABLE", "", "TAG", "", "currentNetworkStatus", "", "onNetworkChange", "com/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1", "Lcom/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1;", "canUseOfflineScan", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "isFromScanUI", "checkNeedProcessOffline", "errType", "errCode", "clearOfflineScanMessage", "", "handleNetworkUnconnected", "context", "Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "showMsg", "needNotifyMessage", "init", "insertOfflineScanMessage", "content", "notifyMessage", "release", "showNetworkAlert", "Landroid/app/Activity;", "onClickListener", "Landroid/content/DialogInterface$OnClickListener;", "plugin-scan_release"})
public final class b
{
  private static int CTg;
  private static final b CTh;
  public static final b CTi;
  
  static
  {
    AppMethodBeat.i(52487);
    CTi = new b();
    CTg = -1;
    CTh = new b();
    AppMethodBeat.o(52487);
  }
  
  public static void a(OfflineScanContext paramOfflineScanContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(52483);
    kotlin.g.b.p.h(paramOfflineScanContext, "context");
    kotlin.g.b.p.h(paramString, "showMsg");
    Log.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScan handleNetworkUnconnected needNotifyMessage: %b, context: %s, time: %d", new Object[] { Boolean.valueOf(paramBoolean), paramOfflineScanContext, Long.valueOf(paramOfflineScanContext.timestamp) });
    paramString = OfflineScanContext.CREATOR;
    paramOfflineScanContext = OfflineScanContext.a.a(paramOfflineScanContext);
    if (paramBoolean)
    {
      aMO(paramOfflineScanContext);
      AppMethodBeat.o(52483);
      return;
    }
    paramString = g.aAh();
    kotlin.g.b.p.g(paramString, "MMKernel.storage()");
    paramString = paramString.azQ().get(ar.a.Ojg, "");
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
      paramString = g.aAh();
      kotlin.g.b.p.g(paramString, "MMKernel.storage()");
      paramString.azQ().set(ar.a.Ojg, paramOfflineScanContext);
      AppMethodBeat.o(52483);
      return;
      i = 0;
      break;
    }
  }
  
  private static void aMO(String paramString)
  {
    AppMethodBeat.i(52486);
    Log.i("MicroMsg.OfflineScanManager", "alvinluo insertOfflineScanMessage");
    ca localca = new ca();
    localca.Cy("notifymessage");
    localca.nv(0);
    localca.setStatus(3);
    localca.setType(721420337);
    localca.setCreateTime(bp.aVP());
    localca.setContent(paramString);
    bp.x(localca);
    paramString = new v();
    paramString.dCL.dCM = localca;
    EventCenter.instance.publish((IEvent)paramString);
    AppMethodBeat.o(52486);
  }
  
  public static boolean b(int paramInt, q paramq)
  {
    AppMethodBeat.i(52485);
    kotlin.g.b.p.h(paramq, "scene");
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
    g.aAg().a((com.tencent.mm.network.p)CTh);
    AppMethodBeat.o(52480);
  }
  
  public static void k(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(52484);
    kotlin.g.b.p.h(paramActivity, "context");
    kotlin.g.b.p.h(paramString, "showMsg");
    h.a((Context)paramActivity, paramString, "", paramActivity.getString(2131755874), null);
    AppMethodBeat.o(52484);
  }
  
  public static boolean o(q paramq)
  {
    AppMethodBeat.i(52482);
    kotlin.g.b.p.h(paramq, "scene");
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
    g.aAg().a((com.tencent.mm.network.p)CTh);
    AppMethodBeat.o(52481);
  }
  
  public static boolean uk(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(Object paramObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(52476);
      Object localObject = this.CTj;
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(52476);
        throw ((Throwable)localObject);
      }
      localObject = n.a((CharSequence)localObject, new String[] { "," });
      Log.i("MicroMsg.OfflineScanManager", "alvinluo notifyMessage localStr: %d, context size: %d", new Object[] { Integer.valueOf(((String)this.CTj).length()), Integer.valueOf(((List)localObject).size()) });
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (((CharSequence)str).length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label154;
          }
          b localb = b.CTi;
          b.aMP(str);
          break;
        }
        label154:
        Log.i("MicroMsg.OfflineScanManager", "alvinluo notifyOfflineScanMessage context is empty, ignore");
      }
      localObject = b.CTi;
      b.eRO();
      AppMethodBeat.o(52476);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1", "Lcom/tencent/mm/network/IOnNetworkChange_AIDL$Stub;", "onNetworkChange", "", "st", "", "plugin-scan_release"})
  public static final class b
    extends p.a
  {
    public final void onNetworkChange(int paramInt)
    {
      AppMethodBeat.i(52479);
      new MMHandler(Looper.getMainLooper()).post((Runnable)a.CTk);
      AppMethodBeat.o(52479);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a CTk;
      
      static
      {
        AppMethodBeat.i(52478);
        CTk = new a();
        AppMethodBeat.o(52478);
      }
      
      public final void run()
      {
        AppMethodBeat.i(52477);
        Object localObject = g.azz();
        kotlin.g.b.p.g(localObject, "MMKernel.getNetSceneQueue()");
        int i = ((com.tencent.mm.ak.t)localObject).aYS();
        localObject = b.CTi;
        Log.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScan onNetworkChange netWorkStatus: %d, current: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(b.eRP()) });
        localObject = g.azz();
        kotlin.g.b.p.g(localObject, "MMKernel.getNetSceneQueue()");
        if (((com.tencent.mm.ak.t)localObject).aYS() != 6)
        {
          localObject = g.azz();
          kotlin.g.b.p.g(localObject, "MMKernel.getNetSceneQueue()");
          if (((com.tencent.mm.ak.t)localObject).aYS() != 4) {}
        }
        else
        {
          localObject = b.CTi;
          i = b.eRP();
          localObject = g.azz();
          kotlin.g.b.p.g(localObject, "MMKernel.getNetSceneQueue()");
          if (i == ((com.tencent.mm.ak.t)localObject).aYS())
          {
            AppMethodBeat.o(52477);
            return;
          }
          localObject = b.CTi;
          localObject = g.azz();
          kotlin.g.b.p.g(localObject, "MMKernel.getNetSceneQueue()");
          b.WZ(((com.tencent.mm.ak.t)localObject).aYS());
          localObject = b.CTi;
          b.eRQ();
          AppMethodBeat.o(52477);
          return;
        }
        localObject = b.CTi;
        localObject = g.azz();
        kotlin.g.b.p.g(localObject, "MMKernel.getNetSceneQueue()");
        b.WZ(((com.tencent.mm.ak.t)localObject).aYS());
        AppMethodBeat.o(52477);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.b
 * JD-Core Version:    0.7.0.1
 */