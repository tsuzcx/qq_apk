package com.tencent.mm.plugin.wallet.wecoin.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI;
import com.tencent.mm.plugin.wallet.wecoin.a.j;
import com.tencent.mm.plugin.wallet.wecoin.a.k;
import com.tencent.mm.plugin.wallet.wecoin.b.g;
import com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinEncashView;
import com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinEncashView.a;
import com.tencent.mm.plugin.wallet.wecoin.ui.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.emd;
import com.tencent.mm.protocal.protobuf.gim;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vending.e.b;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONArray;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/logic/WeCoinEncashLogic;", "Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashViewDelegate;", "context", "Lcom/tencent/mm/ui/MMActivity;", "parameter", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinEncashParameter;", "delegate", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinEncashLogicDelegate;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinEncashParameter;Ljava/lang/ref/WeakReference;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getDelegate", "()Ljava/lang/ref/WeakReference;", "getParameter", "()Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinEncashParameter;", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "encashDidFail", "", "activity", "Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView;", "encashDidSuccess", "getRealNameAuthRequest", "token", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getRealNameInfo", "info", "Lcom/tencent/mm/protocal/protobuf/RealNameAuthInfo;", "gotoEnCashView", "startEncash", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements e
{
  public static final a Vui;
  private final k Vuj;
  private final WeakReference<j> dsH;
  private final MMActivity lzt;
  private w psR;
  
  static
  {
    AppMethodBeat.i(315729);
    Vui = new a((byte)0);
    AppMethodBeat.o(315729);
  }
  
  public a(MMActivity paramMMActivity, k paramk, WeakReference<j> paramWeakReference)
  {
    AppMethodBeat.i(315708);
    this.lzt = paramMMActivity;
    this.Vuj = paramk;
    this.dsH = paramWeakReference;
    AppMethodBeat.o(315708);
  }
  
  private static final ah a(a parama, b.a parama1)
  {
    AppMethodBeat.i(315726);
    s.u(parama, "this$0");
    Log.i("WeCoinEncashLogic", "getRealNameAuthRequest errorType: " + parama1.errType + ", errorCode: " + parama1.errCode + ", errorMsg: " + parama1.errMsg);
    w localw = parama.psR;
    if (localw != null) {
      localw.dismiss();
    }
    s.s(parama1, "cgiBack");
    if (com.tencent.mm.plugin.wallet.wecoin.utils.c.p(parama1))
    {
      parama.dsH.get();
      parama = ah.aiuX;
      AppMethodBeat.o(315726);
      return parama;
    }
    parama1 = (j)parama.dsH.get();
    if (parama1 != null) {
      parama1.fod();
    }
    parama.ihn();
    parama = ah.aiuX;
    AppMethodBeat.o(315726);
    return parama;
  }
  
  private static final void a(a parama, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(315719);
    s.u(parama, "this$0");
    if (paramInt1 == 20001) {
      if (paramInt2 == -1)
      {
        Object localObject;
        if (paramIntent == null)
        {
          paramIntent = null;
          localObject = (CharSequence)paramIntent;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label164;
          }
        }
        label164:
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            break label169;
          }
          localObject = (b)parama.lzt;
          parama.psR = w.a((Context)parama.lzt, (CharSequence)parama.lzt.getString(a.i.loading_tips), false, 3, null);
          String str = UUID.randomUUID().toString();
          s.s(str, "uuid.toString()");
          new g(paramIntent, str, parama.Vuj.Vuf).bFJ().b(new a..ExternalSyntheticLambda1(parama)).a((b)localObject);
          AppMethodBeat.o(315719);
          return;
          paramIntent = paramIntent.getStringExtra("intent_auth_token");
          break;
        }
        label169:
        if ((j)parama.dsH.get() != null) {
          AppMethodBeat.o(315719);
        }
      }
      else
      {
        parama.dsH.get();
      }
    }
    AppMethodBeat.o(315719);
  }
  
  private final void ihn()
  {
    AppMethodBeat.i(315714);
    Log.d("WeCoinEncashLogic", "gotoIncomeBalanceView: ");
    Object localObject1 = new Intent((Context)this.lzt, WeCoinEncashView.class);
    ((Intent)localObject1).putExtra("wecoin_income_balance", this.Vuj.Vug);
    ((Intent)localObject1).putExtra("WECOIN_BUSINESS_ID", this.Vuj.Vuf);
    Object localObject2 = this.Vuj.GSm;
    if (localObject2 != null) {
      ((Intent)localObject1).putExtra("WECOIN_TAX_CUT_ENTRANCE_INFO", ((gim)localObject2).toByteArray());
    }
    localObject2 = WeCoinEncashView.Vwo;
    WeCoinEncashView.a.m(new WeakReference(this));
    localObject2 = this.lzt;
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/wallet/wecoin/logic/WeCoinEncashLogic", "gotoEnCashView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((MMActivity)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/wallet/wecoin/logic/WeCoinEncashLogic", "gotoEnCashView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(315714);
  }
  
  public final void a(WeCoinEncashView paramWeCoinEncashView)
  {
    AppMethodBeat.i(315746);
    s.u(paramWeCoinEncashView, "activity");
    this.dsH.get();
    AppMethodBeat.o(315746);
  }
  
  public final void ihm()
  {
    AppMethodBeat.i(315742);
    emd localemd = this.Vuj.GSn;
    if ((localemd != null) && (localemd.status == 1))
    {
      Log.i("WeCoinEncashLogic", s.X("openRealNameAuth, info: ", localemd));
      Intent localIntent = new Intent((Context)this.lzt, AppBrandIDCardUI.class);
      localIntent.putExtra("intent_appid", localemd.appid);
      localIntent.putExtra("intent_category_id", new JSONArray((Collection)localemd.abqA).toString());
      localIntent.putExtra("intent_auth_type", localemd.auth_type);
      localIntent.putExtra("id_ui_theme", 2);
      localIntent.putExtra("wecoin_apply_info", localemd.abqB);
      localIntent.putExtra("wecoin_protocol_url", localemd.igL);
      this.lzt.mmSetOnActivityResultCallback(new a..ExternalSyntheticLambda0(this));
      com.tencent.mm.br.c.b((Context)this.lzt, "appbrand", ".ui.autofill.AppBrandIDCardUI", localIntent, 20001);
      AppMethodBeat.o(315742);
      return;
    }
    ihn();
    AppMethodBeat.o(315742);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/logic/WeCoinEncashLogic$Companion;", "", "()V", "REQUEST_CODE_GET_REALNAME_INFO", "", "TAG", "", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.c.a
 * JD-Core Version:    0.7.0.1
 */