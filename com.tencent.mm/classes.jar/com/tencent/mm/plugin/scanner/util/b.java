package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/util/OfflineScanManager;", "", "()V", "OFFLINE_SCAN_ENABLE", "", "TAG", "", "currentNetworkStatus", "", "onNetworkChange", "com/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1", "Lcom/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1;", "canUseOfflineScan", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "isFromScanUI", "scanEntryScene", "checkNeedProcessOffline", "errType", "errCode", "clearOfflineScanMessage", "", "handleNetworkUnconnected", "context", "Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "showMsg", "needNotifyMessage", "init", "insertOfflineScanMessage", "content", "notifyMessage", "release", "showNetworkAlert", "Landroid/app/Activity;", "onClickListener", "Landroid/content/DialogInterface$OnClickListener;", "plugin-scan_release"})
public final class b
{
  private static int yPh;
  private static final b yPi;
  public static final b yPj;
  
  static
  {
    AppMethodBeat.i(52487);
    yPj = new b();
    yPh = -1;
    yPi = new b();
    AppMethodBeat.o(52487);
  }
  
  public static void a(OfflineScanContext paramOfflineScanContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(52483);
    p.h(paramOfflineScanContext, "context");
    p.h(paramString, "showMsg");
    ae.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScan handleNetworkUnconnected needNotifyMessage: %b, context: %s, time: %d", new Object[] { Boolean.valueOf(paramBoolean), paramOfflineScanContext, Long.valueOf(paramOfflineScanContext.timestamp) });
    paramString = OfflineScanContext.CREATOR;
    paramOfflineScanContext = OfflineScanContext.a.a(paramOfflineScanContext);
    if (paramBoolean)
    {
      ayj(paramOfflineScanContext);
      AppMethodBeat.o(52483);
      return;
    }
    paramString = g.ajR();
    p.g(paramString, "MMKernel.storage()");
    paramString = paramString.ajA().get(am.a.JaA, "");
    if (paramString == null)
    {
      paramOfflineScanContext = new v("null cannot be cast to non-null type kotlin.String");
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
      ae.i("MicroMsg.OfflineScanManager", "alvinluo handleNetworkUnconnected toSave string length: %d", new Object[] { Integer.valueOf(paramOfflineScanContext.length()) });
      paramString = g.ajR();
      p.g(paramString, "MMKernel.storage()");
      paramString.ajA().set(am.a.JaA, paramOfflineScanContext);
      AppMethodBeat.o(52483);
      return;
      i = 0;
      break;
    }
  }
  
  private static void ayj(String paramString)
  {
    AppMethodBeat.i(52486);
    ae.i("MicroMsg.OfflineScanManager", "alvinluo insertOfflineScanMessage");
    bv localbv = new bv();
    localbv.ui("notifymessage");
    localbv.kt(0);
    localbv.setStatus(3);
    localbv.setType(721420337);
    localbv.qN(bl.aCr());
    localbv.setContent(paramString);
    bl.v(localbv);
    paramString = new t();
    paramString.dlv.dlw = localbv;
    a.IvT.l((com.tencent.mm.sdk.b.b)paramString);
    AppMethodBeat.o(52486);
  }
  
  public static boolean b(int paramInt, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(52485);
    p.h(paramn, "scene");
    if (((paramn.getType() == 233) || (paramn.getType() == 106) || (paramn.getType() == 1061)) && ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8) || (paramInt == 3) || (paramInt == 9)))
    {
      AppMethodBeat.o(52485);
      return true;
    }
    AppMethodBeat.o(52485);
    return false;
  }
  
  public static void g(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(52484);
    p.h(paramActivity, "context");
    p.h(paramString, "showMsg");
    h.a((Context)paramActivity, paramString, "", paramActivity.getString(2131755793), null);
    AppMethodBeat.o(52484);
  }
  
  public static void init()
  {
    AppMethodBeat.i(52480);
    ae.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScanManager init enableOfflineScan: %b", new Object[] { Boolean.TRUE });
    g.ajQ().a((com.tencent.mm.network.n)yPi);
    AppMethodBeat.o(52480);
  }
  
  public static boolean m(com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(52482);
    p.h(paramn, "scene");
    if ((paramn.getType() == 233) || (paramn.getType() == 106) || (paramn.getType() == 1061))
    {
      AppMethodBeat.o(52482);
      return true;
    }
    AppMethodBeat.o(52482);
    return false;
  }
  
  public static boolean qR(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public static void release()
  {
    AppMethodBeat.i(52481);
    ae.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScanManager release");
    g.ajQ().a((com.tencent.mm.network.n)yPi);
    AppMethodBeat.o(52481);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(Object paramObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(52476);
      Object localObject = this.yPk;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(52476);
        throw ((Throwable)localObject);
      }
      localObject = d.n.n.a((CharSequence)localObject, new String[] { "," });
      ae.i("MicroMsg.OfflineScanManager", "alvinluo notifyMessage localStr: %d, context size: %d", new Object[] { Integer.valueOf(((String)this.yPk).length()), Integer.valueOf(((List)localObject).size()) });
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
          b localb = b.yPj;
          b.ayk(str);
          break;
        }
        label154:
        ae.i("MicroMsg.OfflineScanManager", "alvinluo notifyOfflineScanMessage context is empty, ignore");
      }
      localObject = b.yPj;
      b.dQb();
      AppMethodBeat.o(52476);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1", "Lcom/tencent/mm/network/IOnNetworkChange_AIDL$Stub;", "onNetworkChange", "", "st", "", "plugin-scan_release"})
  public static final class b
    extends n.a
  {
    public final void onNetworkChange(int paramInt)
    {
      AppMethodBeat.i(52479);
      new aq(Looper.getMainLooper()).post((Runnable)a.yPl);
      AppMethodBeat.o(52479);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a yPl;
      
      static
      {
        AppMethodBeat.i(52478);
        yPl = new a();
        AppMethodBeat.o(52478);
      }
      
      public final void run()
      {
        AppMethodBeat.i(52477);
        Object localObject = g.ajj();
        p.g(localObject, "MMKernel.getNetSceneQueue()");
        int i = ((q)localObject).aFd();
        localObject = b.yPj;
        ae.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScan onNetworkChange netWorkStatus: %d, current: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(b.dQc()) });
        localObject = g.ajj();
        p.g(localObject, "MMKernel.getNetSceneQueue()");
        if (((q)localObject).aFd() != 6)
        {
          localObject = g.ajj();
          p.g(localObject, "MMKernel.getNetSceneQueue()");
          if (((q)localObject).aFd() != 4) {}
        }
        else
        {
          localObject = b.yPj;
          i = b.dQc();
          localObject = g.ajj();
          p.g(localObject, "MMKernel.getNetSceneQueue()");
          if (i == ((q)localObject).aFd())
          {
            AppMethodBeat.o(52477);
            return;
          }
          localObject = b.yPj;
          localObject = g.ajj();
          p.g(localObject, "MMKernel.getNetSceneQueue()");
          b.Pz(((q)localObject).aFd());
          localObject = b.yPj;
          b.dQd();
          AppMethodBeat.o(52477);
          return;
        }
        localObject = b.yPj;
        localObject = g.ajj();
        p.g(localObject, "MMKernel.getNetSceneQueue()");
        b.Pz(((q)localObject).aFd());
        AppMethodBeat.o(52477);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.b
 * JD-Core Version:    0.7.0.1
 */