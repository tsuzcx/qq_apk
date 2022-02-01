package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.h;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/util/OfflineScanManager;", "", "()V", "OFFLINE_SCAN_ENABLE", "", "TAG", "", "currentNetworkStatus", "", "onNetworkChange", "com/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1", "Lcom/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1;", "canUseOfflineScan", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "isFromScanUI", "scanEntryScene", "checkNeedProcessOffline", "errType", "errCode", "clearOfflineScanMessage", "", "handleNetworkUnconnected", "context", "Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "showMsg", "needNotifyMessage", "init", "insertOfflineScanMessage", "content", "notifyMessage", "release", "showNetworkAlert", "Landroid/app/Activity;", "onClickListener", "Landroid/content/DialogInterface$OnClickListener;", "plugin-scan_release"})
public final class b
{
  private static int vZZ;
  private static final b waa;
  public static final b wab;
  
  static
  {
    AppMethodBeat.i(52487);
    wab = new b();
    vZZ = -1;
    waa = new b();
    AppMethodBeat.o(52487);
  }
  
  public static void a(OfflineScanContext paramOfflineScanContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(52483);
    k.h(paramOfflineScanContext, "context");
    k.h(paramString, "showMsg");
    ad.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScan handleNetworkUnconnected needNotifyMessage: %b, context: %s, time: %d", new Object[] { Boolean.valueOf(paramBoolean), paramOfflineScanContext, Long.valueOf(paramOfflineScanContext.timestamp) });
    paramString = OfflineScanContext.CREATOR;
    paramOfflineScanContext = OfflineScanContext.a.a(paramOfflineScanContext);
    if (paramBoolean)
    {
      amK(paramOfflineScanContext);
      AppMethodBeat.o(52483);
      return;
    }
    paramString = g.afB();
    k.g(paramString, "MMKernel.storage()");
    paramString = paramString.afk().get(ae.a.FvB, "");
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
      ad.i("MicroMsg.OfflineScanManager", "alvinluo handleNetworkUnconnected toSave string length: %d", new Object[] { Integer.valueOf(paramOfflineScanContext.length()) });
      paramString = g.afB();
      k.g(paramString, "MMKernel.storage()");
      paramString.afk().set(ae.a.FvB, paramOfflineScanContext);
      AppMethodBeat.o(52483);
      return;
      i = 0;
      break;
    }
  }
  
  private static void amK(String paramString)
  {
    AppMethodBeat.i(52486);
    ad.i("MicroMsg.OfflineScanManager", "alvinluo insertOfflineScanMessage");
    bl localbl = new bl();
    localbl.nY("notifymessage");
    localbl.jV(0);
    localbl.setStatus(3);
    localbl.setType(721420337);
    localbl.kY(bi.asg());
    localbl.setContent(paramString);
    bi.u(localbl);
    AppMethodBeat.o(52486);
  }
  
  public static boolean b(int paramInt, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(52485);
    k.h(paramn, "scene");
    if (((paramn.getType() == 233) || (paramn.getType() == 106) || (paramn.getType() == 1061)) && ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8) || (paramInt == 3) || (paramInt == 9)))
    {
      AppMethodBeat.o(52485);
      return true;
    }
    AppMethodBeat.o(52485);
    return false;
  }
  
  public static void f(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(52484);
    k.h(paramActivity, "context");
    k.h(paramString, "showMsg");
    h.a((Context)paramActivity, paramString, "", paramActivity.getString(2131755793), null);
    AppMethodBeat.o(52484);
  }
  
  public static void init()
  {
    AppMethodBeat.i(52480);
    ad.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScanManager init enableOfflineScan: %b", new Object[] { Boolean.TRUE });
    g.afA().a((com.tencent.mm.network.n)waa);
    AppMethodBeat.o(52480);
  }
  
  public static boolean n(com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(52482);
    k.h(paramn, "scene");
    if ((paramn.getType() == 233) || (paramn.getType() == 106) || (paramn.getType() == 1061))
    {
      AppMethodBeat.o(52482);
      return true;
    }
    AppMethodBeat.o(52482);
    return false;
  }
  
  public static boolean pm(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public static void release()
  {
    AppMethodBeat.i(52481);
    ad.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScanManager release");
    g.afA().a((com.tencent.mm.network.n)waa);
    AppMethodBeat.o(52481);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1", "Lcom/tencent/mm/network/IOnNetworkChange_AIDL$Stub;", "onNetworkChange", "", "st", "", "plugin-scan_release"})
  public static final class b
    extends n.a
  {
    public final void onNetworkChange(int paramInt)
    {
      AppMethodBeat.i(52479);
      new ap(Looper.getMainLooper()).post((Runnable)a.wad);
      AppMethodBeat.o(52479);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a wad;
      
      static
      {
        AppMethodBeat.i(52478);
        wad = new a();
        AppMethodBeat.o(52478);
      }
      
      public final void run()
      {
        AppMethodBeat.i(52477);
        Object localObject = g.aeS();
        k.g(localObject, "MMKernel.getNetSceneQueue()");
        int i = ((q)localObject).auR();
        localObject = b.wab;
        ad.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScan onNetworkChange netWorkStatus: %d, current: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(b.dnd()) });
        localObject = g.aeS();
        k.g(localObject, "MMKernel.getNetSceneQueue()");
        if (((q)localObject).auR() != 6)
        {
          localObject = g.aeS();
          k.g(localObject, "MMKernel.getNetSceneQueue()");
          if (((q)localObject).auR() != 4) {}
        }
        else
        {
          localObject = b.wab;
          i = b.dnd();
          localObject = g.aeS();
          k.g(localObject, "MMKernel.getNetSceneQueue()");
          if (i == ((q)localObject).auR())
          {
            AppMethodBeat.o(52477);
            return;
          }
          localObject = b.wab;
          localObject = g.aeS();
          k.g(localObject, "MMKernel.getNetSceneQueue()");
          b.Lq(((q)localObject).auR());
          localObject = b.wab;
          b.dne();
          AppMethodBeat.o(52477);
          return;
        }
        localObject = b.wab;
        localObject = g.aeS();
        k.g(localObject, "MMKernel.getNetSceneQueue()");
        b.Lq(((q)localObject).auR());
        AppMethodBeat.o(52477);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.b
 * JD-Core Version:    0.7.0.1
 */