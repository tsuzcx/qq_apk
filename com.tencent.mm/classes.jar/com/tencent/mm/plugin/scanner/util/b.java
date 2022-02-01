package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.h;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/util/OfflineScanManager;", "", "()V", "OFFLINE_SCAN_ENABLE", "", "TAG", "", "currentNetworkStatus", "", "onNetworkChange", "com/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1", "Lcom/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1;", "canUseOfflineScan", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "isFromScanUI", "scanEntryScene", "checkNeedProcessOffline", "errType", "errCode", "clearOfflineScanMessage", "", "handleNetworkUnconnected", "context", "Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "showMsg", "needNotifyMessage", "init", "insertOfflineScanMessage", "content", "notifyMessage", "release", "showNetworkAlert", "Landroid/app/Activity;", "onClickListener", "Landroid/content/DialogInterface$OnClickListener;", "plugin-scan_release"})
public final class b
{
  private static int yzh;
  private static final b yzi;
  public static final b yzj;
  
  static
  {
    AppMethodBeat.i(52487);
    yzj = new b();
    yzh = -1;
    yzi = new b();
    AppMethodBeat.o(52487);
  }
  
  public static void a(OfflineScanContext paramOfflineScanContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(52483);
    p.h(paramOfflineScanContext, "context");
    p.h(paramString, "showMsg");
    ad.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScan handleNetworkUnconnected needNotifyMessage: %b, context: %s, time: %d", new Object[] { Boolean.valueOf(paramBoolean), paramOfflineScanContext, Long.valueOf(paramOfflineScanContext.timestamp) });
    paramString = OfflineScanContext.CREATOR;
    paramOfflineScanContext = OfflineScanContext.a.a(paramOfflineScanContext);
    if (paramBoolean)
    {
      awU(paramOfflineScanContext);
      AppMethodBeat.o(52483);
      return;
    }
    paramString = g.ajC();
    p.g(paramString, "MMKernel.storage()");
    paramString = paramString.ajl().get(al.a.IGa, "");
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
      paramString = g.ajC();
      p.g(paramString, "MMKernel.storage()");
      paramString.ajl().set(al.a.IGa, paramOfflineScanContext);
      AppMethodBeat.o(52483);
      return;
      i = 0;
      break;
    }
  }
  
  private static void awU(String paramString)
  {
    AppMethodBeat.i(52486);
    ad.i("MicroMsg.OfflineScanManager", "alvinluo insertOfflineScanMessage");
    bu localbu = new bu();
    localbu.tN("notifymessage");
    localbu.kr(0);
    localbu.setStatus(3);
    localbu.setType(721420337);
    localbu.qA(bj.aCb());
    localbu.setContent(paramString);
    bj.v(localbu);
    paramString = new t();
    paramString.dkt.dku = localbu;
    a.IbL.l((com.tencent.mm.sdk.b.b)paramString);
    AppMethodBeat.o(52486);
  }
  
  public static boolean b(int paramInt, com.tencent.mm.al.n paramn)
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
  
  public static void f(Activity paramActivity, String paramString)
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
    ad.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScanManager init enableOfflineScan: %b", new Object[] { Boolean.TRUE });
    g.ajB().a((com.tencent.mm.network.n)yzi);
    AppMethodBeat.o(52480);
  }
  
  public static boolean m(com.tencent.mm.al.n paramn)
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
  
  public static boolean qK(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public static void release()
  {
    AppMethodBeat.i(52481);
    ad.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScanManager release");
    g.ajB().a((com.tencent.mm.network.n)yzi);
    AppMethodBeat.o(52481);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1", "Lcom/tencent/mm/network/IOnNetworkChange_AIDL$Stub;", "onNetworkChange", "", "st", "", "plugin-scan_release"})
  public static final class b
    extends n.a
  {
    public final void onNetworkChange(int paramInt)
    {
      AppMethodBeat.i(52479);
      new ap(Looper.getMainLooper()).post((Runnable)a.yzl);
      AppMethodBeat.o(52479);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a yzl;
      
      static
      {
        AppMethodBeat.i(52478);
        yzl = new a();
        AppMethodBeat.o(52478);
      }
      
      public final void run()
      {
        AppMethodBeat.i(52477);
        Object localObject = g.aiU();
        p.g(localObject, "MMKernel.getNetSceneQueue()");
        int i = ((q)localObject).aEN();
        localObject = b.yzj;
        ad.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScan onNetworkChange netWorkStatus: %d, current: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(b.dMJ()) });
        localObject = g.aiU();
        p.g(localObject, "MMKernel.getNetSceneQueue()");
        if (((q)localObject).aEN() != 6)
        {
          localObject = g.aiU();
          p.g(localObject, "MMKernel.getNetSceneQueue()");
          if (((q)localObject).aEN() != 4) {}
        }
        else
        {
          localObject = b.yzj;
          i = b.dMJ();
          localObject = g.aiU();
          p.g(localObject, "MMKernel.getNetSceneQueue()");
          if (i == ((q)localObject).aEN())
          {
            AppMethodBeat.o(52477);
            return;
          }
          localObject = b.yzj;
          localObject = g.aiU();
          p.g(localObject, "MMKernel.getNetSceneQueue()");
          b.OS(((q)localObject).aEN());
          localObject = b.yzj;
          b.dMK();
          AppMethodBeat.o(52477);
          return;
        }
        localObject = b.yzj;
        localObject = g.aiU();
        p.g(localObject, "MMKernel.getNetSceneQueue()");
        b.OS(((q)localObject).aEN());
        AppMethodBeat.o(52477);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.b
 * JD-Core Version:    0.7.0.1
 */