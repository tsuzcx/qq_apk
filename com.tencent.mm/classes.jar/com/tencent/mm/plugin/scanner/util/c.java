package com.tencent.mm.plugin.scanner.util;

import a.f.b.j;
import a.l;
import a.v;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/scanner/util/OfflineScanManager;", "", "()V", "OFFLINE_SCAN_ENABLE", "", "TAG", "", "currentNetworkStatus", "", "onNetworkChange", "com/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1", "Lcom/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1;", "canUseOfflineScan", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "scanEntryScene", "checkNeedProcessOffline", "errType", "errCode", "clearOfflineScanMessage", "", "handleNetworkUnconnected", "context", "Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "showMsg", "needNotifyMessage", "init", "insertOfflineScanMessage", "content", "notifyMessage", "release", "showNetworkAlert", "Landroid/app/Activity;", "onClickListener", "Landroid/content/DialogInterface$OnClickListener;", "plugin-scan_release"})
public final class c
{
  private static int qCf;
  private static final c qCg;
  public static final c qCh;
  
  static
  {
    AppMethodBeat.i(151726);
    qCh = new c();
    qCf = -1;
    qCg = new c();
    AppMethodBeat.o(151726);
  }
  
  public static boolean CL(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 3);
  }
  
  private static void YH(String paramString)
  {
    AppMethodBeat.i(151725);
    ab.i("MicroMsg.OfflineScanManager", "alvinluo insertOfflineScanMessage");
    bi localbi = new bi();
    localbi.kj("notifymessage");
    localbi.hL(0);
    localbi.setStatus(3);
    localbi.setType(721420337);
    localbi.fQ(bf.aaM());
    localbi.setContent(paramString);
    bf.l(localbi);
    AppMethodBeat.o(151725);
  }
  
  public static void a(Activity paramActivity, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(151723);
    j.q(paramActivity, "context");
    j.q(paramString, "showMsg");
    h.a((Context)paramActivity, paramString, "", paramActivity.getString(2131296977), paramOnClickListener);
    AppMethodBeat.o(151723);
  }
  
  public static void a(OfflineScanContext paramOfflineScanContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151722);
    j.q(paramOfflineScanContext, "context");
    j.q(paramString, "showMsg");
    ab.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScan handleNetworkUnconnected needNotifyMessage: %b, context: %s, time: %d", new Object[] { Boolean.valueOf(paramBoolean), paramOfflineScanContext, Long.valueOf(paramOfflineScanContext.timestamp) });
    a(paramOfflineScanContext.getActivity(), paramString, (DialogInterface.OnClickListener)new c.a(paramOfflineScanContext));
    paramString = OfflineScanContext.CREATOR;
    paramOfflineScanContext = OfflineScanContext.a.a(paramOfflineScanContext);
    if (paramBoolean)
    {
      YH(paramOfflineScanContext);
      AppMethodBeat.o(151722);
      return;
    }
    paramString = g.RL();
    j.p(paramString, "MMKernel.storage()");
    paramString = paramString.Ru().get(ac.a.yLZ, "");
    if (paramString == null)
    {
      paramOfflineScanContext = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(151722);
      throw paramOfflineScanContext;
    }
    paramString = (String)paramString;
    int i;
    if (((CharSequence)paramString).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label236;
      }
      paramOfflineScanContext = paramString + "," + paramOfflineScanContext;
    }
    label236:
    for (;;)
    {
      ab.i("MicroMsg.OfflineScanManager", "alvinluo handleNetworkUnconnected toSave string length: %d", new Object[] { Integer.valueOf(paramOfflineScanContext.length()) });
      paramString = g.RL();
      j.p(paramString, "MMKernel.storage()");
      paramString.Ru().set(ac.a.yLZ, paramOfflineScanContext);
      AppMethodBeat.o(151722);
      return;
      i = 0;
      break;
    }
  }
  
  public static boolean b(int paramInt, m paramm)
  {
    AppMethodBeat.i(151724);
    j.q(paramm, "scene");
    if (((paramm.getType() == 233) || (paramm.getType() == 106) || (paramm.getType() == 1061)) && ((paramInt == 1) || (paramInt == 2) || (paramInt == 7) || (paramInt == 8) || (paramInt == 3) || (paramInt == 9)))
    {
      AppMethodBeat.o(151724);
      return true;
    }
    AppMethodBeat.o(151724);
    return false;
  }
  
  public static void init()
  {
    AppMethodBeat.i(151719);
    ab.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScanManager init enableOfflineScan: %b", new Object[] { Boolean.TRUE });
    g.RK().a((n)qCg);
    AppMethodBeat.o(151719);
  }
  
  public static boolean n(m paramm)
  {
    AppMethodBeat.i(151721);
    j.q(paramm, "scene");
    if ((paramm.getType() == 233) || (paramm.getType() == 106) || (paramm.getType() == 1061))
    {
      AppMethodBeat.o(151721);
      return true;
    }
    AppMethodBeat.o(151721);
    return false;
  }
  
  public static void release()
  {
    AppMethodBeat.i(151720);
    ab.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScanManager release");
    g.RK().a((n)qCg);
    AppMethodBeat.o(151720);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1", "Lcom/tencent/mm/network/IOnNetworkChange_AIDL$Stub;", "onNetworkChange", "", "st", "", "plugin-scan_release"})
  public static final class c
    extends n.a
  {
    public final void onNetworkChange(int paramInt)
    {
      AppMethodBeat.i(151718);
      new ak(Looper.getMainLooper()).post((Runnable)c.c.a.qCk);
      AppMethodBeat.o(151718);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.c
 * JD-Core Version:    0.7.0.1
 */