package com.tencent.mm.plugin.wallet_index.model;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.wecoin.a.c;
import com.tencent.mm.plugin.wallet.wecoin.a.f;
import com.tencent.mm.plugin.wallet.wecoin.a.g;
import com.tencent.mm.plugin.wallet.wecoin.a.i;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.g.a;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet_index/model/WecoinPurchaseTool;", "", "()V", "Companion", "Holder", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final a WaC;
  
  static
  {
    AppMethodBeat.i(263680);
    WaC = new a((byte)0);
    AppMethodBeat.o(263680);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet_index/model/WecoinPurchaseTool$Companion;", "", "()V", "TAG", "", "getInstance", "Lcom/tencent/mm/plugin/wallet_index/model/WecoinPurchaseTool;", "getNowWecoinBalance", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "balance", "context", "Landroid/content/Context;", "getWeCoinBalanceFromCache", "requestNowWeCoinBalance", "requestId", "Lkotlin/Function2;", "showRechargeFoodsDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "Landroidx/fragment/app/FragmentActivity;", "scene", "", "panelShowType", "Lcom/tencent/mm/plugin/wallet/wecoin/api/PanelShowType;", "successCallback", "Lkotlin/Function0;", "failedCallback", "showWeCoinEntranceTutorialDialog", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinEntranceTutorialDialog;", "clickCallback", "showWecoinPayDialog", "Lcom/tencent/mm/plugin/emoji/ui/widget/MMWecoinPayHalfDialog;", "goodName", "wecoinBalance", "wecoinPrice", "launchWecoinPurchaseCallback", "userCancelCallback", "showWecoinRechargeDialog", "notEnough", "", "showWecoinSuccessRechargeDialog", "positiveClickCallback", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static com.tencent.mm.plugin.wallet.wecoin.a.e a(FragmentActivity paramFragmentActivity, boolean paramBoolean, final a<? extends Object> parama1, final a<? extends Object> parama2)
    {
      AppMethodBeat.i(263707);
      s.u(paramFragmentActivity, "context");
      s.u(parama1, "successCallback");
      s.u(parama2, "failedCallback");
      int i;
      if (paramBoolean)
      {
        i = 10;
        if (!paramBoolean) {
          break label203;
        }
      }
      label203:
      for (f localf = f.VtT;; localf = f.VtU)
      {
        s.u(paramFragmentActivity, "context");
        s.u(localf, "panelShowType");
        s.u(parama1, "successCallback");
        s.u(parama2, "failedCallback");
        Object localObject2 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHQ();
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        Log.i("MicroMsg.WecoinPurchaseTool", s.X("[WeCoin] showRechargeFoodsDialog sessionId:", localObject1));
        localObject2 = new WeakReference(paramFragmentActivity);
        com.tencent.mm.plugin.wallet.wecoin.a.h localh = new com.tencent.mm.plugin.wallet.wecoin.a.h();
        localh.mScene = i;
        localh.Vub = localf;
        localh.Vua = ((String)localObject1);
        localh.VtR = ((i)new c((WeakReference)localObject2, parama1, parama2));
        localh.Vud = g.VtX;
        paramFragmentActivity = ((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).a(paramFragmentActivity, localh);
        AppMethodBeat.o(263707);
        return paramFragmentActivity;
        i = 9;
        break;
      }
    }
    
    public static c b(Context paramContext, a<? extends Object> parama)
    {
      AppMethodBeat.i(263711);
      s.u(paramContext, "context");
      s.u(parama, "clickCallback");
      paramContext = ((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).T(paramContext, false);
      if (paramContext != null) {
        paramContext.a(new o.a..ExternalSyntheticLambda0(parama));
      }
      AppMethodBeat.o(263711);
      return paramContext;
    }
    
    private static final void b(a parama, c paramc)
    {
      AppMethodBeat.i(263721);
      s.u(parama, "$clickCallback");
      parama.invoke();
      AppMethodBeat.o(263721);
    }
    
    public static void c(Context paramContext, a<ah> parama)
    {
      AppMethodBeat.i(263716);
      s.u(paramContext, "context");
      s.u(parama, "positiveClickCallback");
      g.a locala = new g.a(paramContext);
      locala.bf((CharSequence)paramContext.getString(a.i.wecoin_recharge_success_title)).bDE(paramContext.getString(a.i.wecoin_recharge_success_wording)).bDI(paramContext.getString(a.i.wecoin_recharge_success_positive_text)).c(new o.a..ExternalSyntheticLambda1(parama)).show();
      locala.pRv.cX(-2, false);
      AppMethodBeat.o(263716);
    }
    
    private static final void c(a parama, boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(263727);
      s.u(parama, "$positiveClickCallback");
      if (paramBoolean) {
        parama.invoke();
      }
      AppMethodBeat.o(263727);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/wallet_index/model/WecoinPurchaseTool$Companion$showRechargeFoodsDialog$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "Ljava/lang/Void;", "onFailed", "", "errorType", "", "errorCode", "errorMsg", "", "onSuccess", "data", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      implements i<Void>
    {
      c(WeakReference<FragmentActivity> paramWeakReference, a<? extends Object> parama1, a<? extends Object> parama2) {}
      
      public final void s(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(263660);
        s.u(paramString, "errorMsg");
        parama2.invoke();
        Log.i("MicroMsg.WecoinPurchaseTool", "[WeCoin] showRechargeFoodsDialog onFailed, errorType:%s, errorCode:%s, msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(263660);
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements a<ah>
      {
        a(FragmentActivity paramFragmentActivity, a<? extends Object> parama)
        {
          super();
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    public static final class d
      extends u
      implements a<ah>
    {
      public d(WeakReference<FragmentActivity> paramWeakReference, a<ah> parama1, a<ah> parama2)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    public static final class g
      extends u
      implements a<ah>
    {
      public g(ah.f<WeakReference<com.tencent.mm.plugin.emoji.ui.widget.b>> paramf)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.model.o
 * JD-Core Version:    0.7.0.1
 */