package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.dvq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/offline/ui/WalletOfflineEnableUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "enableCodePage", "Lcom/tencent/mm/protocal/protobuf/EnableCodePage;", "menuLayout", "Landroid/view/ViewGroup;", "getMenuLayout", "()Landroid/view/ViewGroup;", "menuLayout$delegate", "Lkotlin/Lazy;", "offlineAlertView", "Lcom/tencent/mm/plugin/offline/ui/OfflineAlertView;", "getOfflineAlertView", "()Lcom/tencent/mm/plugin/offline/ui/OfflineAlertView;", "offlineAlertView$delegate", "qrcodeView", "getQrcodeView", "qrcodeView$delegate", "doGetTokenNetScene", "", "gotoCheckPwdUI", "initEnableCodePage", "isEnableToken", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "showEnableTokenAlert", "Companion", "EnableTokenCheckPwdController", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends UIComponent
  implements MStorageEx.IOnStorageChange
{
  public static final d.a MCO;
  private final j MCP;
  private final j MCQ;
  private final j MCR;
  private anq Mzj;
  
  static
  {
    AppMethodBeat.i(269243);
    MCO = new d.a((byte)0);
    AppMethodBeat.o(269243);
  }
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(269212);
    this.MCP = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.MCQ = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.MCR = kotlin.k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(269212);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(269229);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/offline/ui/WalletOfflineEnableUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    Log.i("MicroMsg.WalletOfflineEnableUIC", "goto pwd ui");
    paramView = new Intent((Context)paramd.getActivity(), WalletCheckPwdNewUI.class);
    paramView.putExtra("scene", 4);
    paramd.getActivity().startActivityForResult(paramView, 256);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/offline/ui/WalletOfflineEnableUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(269229);
  }
  
  private final OfflineAlertView gwk()
  {
    AppMethodBeat.i(269213);
    Object localObject = this.MCP.getValue();
    s.s(localObject, "<get-offlineAlertView>(...)");
    localObject = (OfflineAlertView)localObject;
    AppMethodBeat.o(269213);
    return localObject;
  }
  
  private final ViewGroup gwl()
  {
    AppMethodBeat.i(269216);
    Object localObject = this.MCQ.getValue();
    s.s(localObject, "<get-qrcodeView>(...)");
    localObject = (ViewGroup)localObject;
    AppMethodBeat.o(269216);
    return localObject;
  }
  
  private final ViewGroup gwm()
  {
    AppMethodBeat.i(269219);
    Object localObject = this.MCR.getValue();
    s.s(localObject, "<get-menuLayout>(...)");
    localObject = (ViewGroup)localObject;
    AppMethodBeat.o(269219);
    return localObject;
  }
  
  private final void gwn()
  {
    AppMethodBeat.i(269221);
    String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVL, null);
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0) {
      try
      {
        this.Mzj = o.bB(new JSONObject(str));
        AppMethodBeat.o(269221);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.WalletOfflineEnableUIC", (Throwable)localException, "", new Object[0]);
        AppMethodBeat.o(269221);
        return;
      }
    }
    this.Mzj = null;
    AppMethodBeat.o(269221);
  }
  
  private final void gwo()
  {
    AppMethodBeat.i(269225);
    if (this.Mzj != null)
    {
      anq localanq = this.Mzj;
      if ((localanq == null) || (localanq.Zvn != 0)) {
        break label61;
      }
    }
    label61:
    for (int i = 1; i != 0; i = 0)
    {
      if (gwk().MzP == 9) {
        gwk().dismiss();
      }
      AppMethodBeat.o(269225);
      return;
    }
    if (!gwk().afe(9))
    {
      AppMethodBeat.o(269225);
      return;
    }
    if (gwk().MzP == 9) {
      gwk().dismiss();
    }
    gwm().setVisibility(4);
    gwk().a((View)gwl(), this.Mzj, new d..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(269225);
  }
  
  public final boolean gwp()
  {
    AppMethodBeat.i(269270);
    if (this.Mzj != null)
    {
      anq localanq = this.Mzj;
      s.checkNotNull(localanq);
      if (localanq.Zvn != 0) {}
    }
    else
    {
      AppMethodBeat.o(269270);
      return true;
    }
    AppMethodBeat.o(269270);
    return false;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(269266);
    Log.i("MicroMsg.WalletOfflineEnableUIC", "onActivityResult: " + paramInt1 + ", " + paramInt2);
    if ((paramInt1 == 256) && (paramInt2 == -1))
    {
      paramIntent = new o(s.X("", Integer.valueOf((int)(System.currentTimeMillis() / 1000L))), 0);
      ((WalletOfflineCoinPurseUI)getActivity()).doSceneProgress((p)paramIntent, false);
    }
    AppMethodBeat.o(269266);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(269250);
    super.onCreate(paramBundle);
    gwn();
    gwo();
    com.tencent.mm.kernel.h.baE().ban().add((MStorageEx.IOnStorageChange)this);
    AppMethodBeat.o(269250);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(269258);
    super.onDestroy();
    com.tencent.mm.kernel.h.baE().ban().remove((MStorageEx.IOnStorageChange)this);
    AppMethodBeat.o(269258);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(269263);
    if (s.p(paramMStorageEx, com.tencent.mm.kernel.h.baE().ban()))
    {
      Log.d("MicroMsg.WalletOfflineEnableUIC", "on configstg change: " + paramInt + ", " + paramObject);
      if (paramObject == at.a.acVL)
      {
        Log.i("MicroMsg.WalletOfflineEnableUIC", "update enableCodePage changed");
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this));
      }
    }
    AppMethodBeat.o(269263);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/offline/ui/WalletOfflineEnableUIC$EnableTokenCheckPwdController;", "Lcom/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdNewUI$CheckPwdController;", "activity", "Lcom/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdNewUI;", "(Lcom/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdNewUI;)V", "getActivity", "()Lcom/tencent/mm/plugin/wallet_core/ui/WalletCheckPwdNewUI;", "afterInputPwd", "", "pwd", "", "onClickClose", "", "onCreate", "onDestroy", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements WalletCheckPwdNewUI.a
  {
    final WalletCheckPwdNewUI MCS;
    
    public b(WalletCheckPwdNewUI paramWalletCheckPwdNewUI)
    {
      AppMethodBeat.i(269191);
      this.MCS = paramWalletCheckPwdNewUI;
      AppMethodBeat.o(269191);
    }
    
    public final void aQI(String paramString)
    {
      AppMethodBeat.i(269199);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(269199);
        return;
      }
      Log.i("MicroMsg.WalletOfflineEnableUIC", "do offline enable token cgi");
      this.MCS.showLoading();
      s.checkNotNull(paramString);
      paramString = new com.tencent.mm.plugin.offline.a.a(paramString).bFJ();
      s.s(paramString, "CgiOfflineEnableToken(pwd!!).run()");
      com.tencent.mm.ae.d.b((c)paramString, (kotlin.g.a.b)new a(this)).b((com.tencent.mm.vending.e.b)this.MCS);
      AppMethodBeat.o(269199);
    }
    
    public final boolean gwq()
    {
      return false;
    }
    
    public final boolean gwr()
    {
      return false;
    }
    
    public final void onCreate() {}
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/OfflineEnableResponse;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b
    {
      a(d.b paramb)
      {
        super();
      }
      
      private static final void a(d.b paramb, DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(269138);
        s.u(paramb, "this$0");
        s.u(paramDialogInterface, "dialog");
        paramDialogInterface.dismiss();
        paramb.MCS.Vjw.gGd();
        AppMethodBeat.o(269138);
      }
      
      private static final void b(d.b paramb, DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(269141);
        s.u(paramb, "this$0");
        s.u(paramDialogInterface, "dialog");
        paramDialogInterface.dismiss();
        paramb.MCS.finish();
        AppMethodBeat.o(269141);
      }
      
      private Void m(b.a<dvq> parama)
      {
        AppMethodBeat.i(269136);
        this.MCT.MCS.hideLoading();
        if (parama != null)
        {
          Log.i("MicroMsg.WalletOfflineEnableUIC", "enable token response: " + parama.errType + ", " + parama.errCode + ", " + ((dvq)parama.ott).wuz);
          if ((parama.errType != 0) || (parama.errCode != 0)) {
            break label241;
          }
          if (((dvq)parama.ott).wuz != 0) {
            break label142;
          }
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acVL, "");
          this.MCT.MCS.setResult(-1);
          this.MCT.MCS.finish();
        }
        for (;;)
        {
          AppMethodBeat.o(269136);
          return null;
          label142:
          if ((!com.tencent.mm.wallet_core.c.h.a((WalletBaseUI)this.MCT.MCS, parama.hEi, 1000, ((dvq)parama.ott).wuz, ((dvq)parama.ott).wuA)) && (!Util.isNullOrNil(((dvq)parama.ott).wuA)))
          {
            com.tencent.mm.ui.base.k.d((Context)this.MCT.MCS, ((dvq)parama.ott).wuA, "", new d.b.a..ExternalSyntheticLambda1(this.MCT));
            continue;
            label241:
            com.tencent.mm.ui.base.k.a((Context)this.MCT.MCS, this.MCT.MCS.getString(a.i.wallet_net_err), "", this.MCT.MCS.getString(a.i.app_i_known), new d.b.a..ExternalSyntheticLambda0(this.MCT));
            this.MCT.MCS.Vjw.gGd();
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/offline/ui/OfflineAlertView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<OfflineAlertView>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    f(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.d
 * JD-Core Version:    0.7.0.1
 */