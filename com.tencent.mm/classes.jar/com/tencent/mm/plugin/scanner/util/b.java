package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.z;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/OfflineScanManager;", "", "()V", "OFFLINE_SCAN_ENABLE", "", "TAG", "", "currentNetworkStatus", "", "onNetworkChange", "com/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1", "Lcom/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1;", "canUseOfflineScan", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "isFromScanUI", "checkNeedProcessOffline", "errType", "errCode", "clearOfflineScanMessage", "", "handleNetworkUnconnected", "context", "Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "showMsg", "needNotifyMessage", "init", "insertOfflineScanMessage", "content", "notifyMessage", "release", "showNetworkAlert", "Landroid/app/Activity;", "onClickListener", "Landroid/content/DialogInterface$OnClickListener;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b PhX;
  private static int PhY;
  private static final a PhZ;
  
  static
  {
    AppMethodBeat.i(52487);
    PhX = new b();
    PhY = -1;
    PhZ = new a();
    AppMethodBeat.o(52487);
  }
  
  public static boolean Cx(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public static void a(OfflineScanContext paramOfflineScanContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(52483);
    kotlin.g.b.s.u(paramOfflineScanContext, "context");
    kotlin.g.b.s.u(paramString, "showMsg");
    Log.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScan handleNetworkUnconnected needNotifyMessage: %b, context: %s, time: %d", new Object[] { Boolean.valueOf(paramBoolean), paramOfflineScanContext, Long.valueOf(paramOfflineScanContext.timestamp) });
    paramString = OfflineScanContext.CREATOR;
    paramOfflineScanContext = OfflineScanContext.a.a(paramOfflineScanContext);
    if (paramBoolean)
    {
      aVe(paramOfflineScanContext);
      AppMethodBeat.o(52483);
      return;
    }
    paramString = h.baE().ban().get(at.a.acZi, "");
    if (paramString == null)
    {
      paramOfflineScanContext = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(52483);
      throw paramOfflineScanContext;
    }
    paramString = (String)paramString;
    int i;
    if (((CharSequence)paramString).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label200;
      }
      paramOfflineScanContext = paramString + ',' + paramOfflineScanContext;
    }
    label200:
    for (;;)
    {
      Log.i("MicroMsg.OfflineScanManager", "alvinluo handleNetworkUnconnected toSave string length: %d", new Object[] { Integer.valueOf(paramOfflineScanContext.length()) });
      h.baE().ban().set(at.a.acZi, paramOfflineScanContext);
      AppMethodBeat.o(52483);
      return;
      i = 0;
      break;
    }
  }
  
  private static void aVe(String paramString)
  {
    AppMethodBeat.i(52486);
    Log.i("MicroMsg.OfflineScanManager", "alvinluo insertOfflineScanMessage");
    cc localcc = new cc();
    localcc.BS("notifymessage");
    localcc.pI(0);
    localcc.setStatus(3);
    localcc.setType(721420337);
    localcc.setCreateTime(br.bCJ());
    localcc.setContent(paramString);
    br.B(localcc);
    paramString = new z();
    paramString.hzN.hzO = localcc;
    paramString.publish();
    AppMethodBeat.o(52486);
  }
  
  public static boolean b(int paramInt, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(52485);
    kotlin.g.b.s.u(paramp, "scene");
    if ((paramp.getType() == 233) || (paramp.getType() == 106) || (paramp.getType() == 1061)) {}
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    default: 
      AppMethodBeat.o(52485);
      return false;
    }
    AppMethodBeat.o(52485);
    return true;
  }
  
  private static final void gp(Object paramObject)
  {
    AppMethodBeat.i(314221);
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(314221);
      throw paramObject;
    }
    Object localObject = n.b((CharSequence)paramObject, new String[] { "," });
    Log.i("MicroMsg.OfflineScanManager", "alvinluo notifyMessage localStr: %d, context size: %d", new Object[] { Integer.valueOf(((String)paramObject).length()), Integer.valueOf(((List)localObject).size()) });
    paramObject = ((Iterable)localObject).iterator();
    while (paramObject.hasNext())
    {
      localObject = (String)paramObject.next();
      if (((CharSequence)localObject).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label145;
        }
        aVe((String)localObject);
        break;
      }
      label145:
      Log.i("MicroMsg.OfflineScanManager", "alvinluo notifyOfflineScanMessage context is empty, ignore");
    }
    Log.i("MicroMsg.OfflineScanManager", "alvinluo clearOfflineScanMessage");
    h.baE().ban().set(at.a.acZi, null);
    AppMethodBeat.o(314221);
  }
  
  public static void init()
  {
    AppMethodBeat.i(52480);
    Log.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScanManager init enableOfflineScan: %b", new Object[] { Boolean.TRUE });
    h.baD().a((com.tencent.mm.network.p)PhZ);
    AppMethodBeat.o(52480);
  }
  
  public static void n(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(52484);
    kotlin.g.b.s.u(paramActivity, "context");
    kotlin.g.b.s.u(paramString, "showMsg");
    k.a((Context)paramActivity, paramString, "", paramActivity.getString(l.i.app_i_known), null);
    AppMethodBeat.o(52484);
  }
  
  public static boolean o(com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(52482);
    kotlin.g.b.s.u(paramp, "scene");
    if ((paramp.getType() == 233) || (paramp.getType() == 106) || (paramp.getType() == 1061))
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
    h.baD().a((com.tencent.mm.network.p)PhZ);
    AppMethodBeat.o(52481);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/util/OfflineScanManager$onNetworkChange$1", "Lcom/tencent/mm/network/IOnNetworkChange_AIDL$Stub;", "onNetworkChange", "", "st", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends p.a
  {
    private static final void gTK()
    {
      AppMethodBeat.i(314097);
      Log.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScan onNetworkChange netWorkStatus: %d, current: %d", new Object[] { Integer.valueOf(h.aZW().bFQ()), Integer.valueOf(b.gTI()) });
      if ((h.aZW().bFQ() == 6) || (h.aZW().bFQ() == 4))
      {
        if (b.gTI() == h.aZW().bFQ())
        {
          AppMethodBeat.o(314097);
          return;
        }
        localb = b.PhX;
        b.aiC(h.aZW().bFQ());
        localb = b.PhX;
        b.gTJ();
        AppMethodBeat.o(314097);
        return;
      }
      b localb = b.PhX;
      b.aiC(h.aZW().bFQ());
      AppMethodBeat.o(314097);
    }
    
    public final void onNetworkChange(int paramInt)
    {
      AppMethodBeat.i(52479);
      new MMHandler(Looper.getMainLooper()).post(b.a..ExternalSyntheticLambda0.INSTANCE);
      AppMethodBeat.o(52479);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.b
 * JD-Core Version:    0.7.0.1
 */