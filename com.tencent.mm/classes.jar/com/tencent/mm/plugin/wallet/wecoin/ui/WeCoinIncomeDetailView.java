package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ah.b;
import androidx.lifecycle.ai;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI;
import com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData;
import com.tencent.mm.plugin.wallet.wecoin.utils.c.a;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.adz;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.emd;
import com.tencent.mm.protocal.protobuf.gim;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y.b;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "cocertActivateModeLayout", "Landroid/view/View;", "cocertActivateModeTips", "Landroid/widget/TextView;", "mActionGroup", "mBalanceView", "Lcom/tencent/mm/plugin/wallet_core/ui/view/WcPayMoneyLoadingView;", "mCloseBtn", "Landroid/widget/Button;", "mFaqTv", "mFetchBtn", "mIncomeBalanceLL", "Landroid/widget/LinearLayout;", "mLiveSettlementDesc", "mLiveSettlementTv", "mLiveTaskArrow", "Landroid/widget/ImageView;", "mLiveTaskLayout", "mLiveTaskTv", "mMarginLine", "mMoneyLoadingPb", "Landroid/widget/ProgressBar;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mViewModel", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinIncomeDetailViewModel;", "normalModeContentLayout", "normalModeTips", "normalModeTitleLayout", "bindData", "", "getLayoutId", "", "gotoIncomeBalanceView", "initKVData", "initLiveSettlement", "initLiveTaskEntrance", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "openRealNameAuth", "info", "Lcom/tencent/mm/protocal/protobuf/RealNameAuthInfo;", "showAlertDialog", "showErrorMsg", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "showProgressDialog", "isShow", "", "(Ljava/lang/Boolean;)V", "updateAuthored", "authored", "updateClickButtonEvent", "updateFaqView", "url", "", "updateIncomeBalanceView", "balance", "", "(Ljava/lang/Long;)V", "updateRightOptionMenu", "updateTopBannerView", "bannerContent", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public class WeCoinIncomeDetailView
  extends MMActivity
{
  public static final WeCoinIncomeDetailView.a VwB;
  private ProgressBar KML;
  private WcPayMoneyLoadingView VcE;
  private Button Vcy;
  private View VwC;
  private View VwD;
  private TextView VwE;
  private View VwF;
  private TextView VwG;
  private LinearLayout VwH;
  private Button VwI;
  private com.tencent.mm.plugin.wallet.wecoin.model.i VwJ;
  private TextView VwK;
  private TextView VwL;
  private View VwM;
  private ImageView VwN;
  private View VwO;
  private TextView VwP;
  private TextView VwQ;
  private View VwR;
  private w lKp;
  
  static
  {
    AppMethodBeat.i(316164);
    VwB = new WeCoinIncomeDetailView.a((byte)0);
    AppMethodBeat.o(316164);
  }
  
  private static final void Q(DialogInterface paramDialogInterface, int paramInt) {}
  
  private static final void a(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, View paramView)
  {
    AppMethodBeat.i(316100);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramWeCoinIncomeDetailView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramWeCoinIncomeDetailView, "this$0");
    localObject = paramWeCoinIncomeDetailView.VwJ;
    paramView = (View)localObject;
    if (localObject == null)
    {
      s.bIx("mViewModel");
      paramView = null;
    }
    paramView.asf(1);
    paramView = paramWeCoinIncomeDetailView.getString(a.i.wecoin_income_encash_tips_dialog_content);
    s.s(paramView, "getString(R.string.wecoi…cash_tips_dialog_content)");
    localObject = paramWeCoinIncomeDetailView.getString(a.i.wecoin_dialog_left_button_common_wording);
    s.s(localObject, "getString(R.string.wecoi…ft_button_common_wording)");
    k.a((Context)paramWeCoinIncomeDetailView.getContext(), paramView, "", (String)localObject, false, WeCoinIncomeDetailView..ExternalSyntheticLambda0.INSTANCE);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316100);
  }
  
  private static final void a(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, com.tencent.mm.plugin.wallet.wecoin.model.a parama)
  {
    AppMethodBeat.i(316121);
    s.u(paramWeCoinIncomeDetailView, "this$0");
    paramWeCoinIncomeDetailView = paramWeCoinIncomeDetailView.getContext();
    s.s(paramWeCoinIncomeDetailView, "context");
    com.tencent.mm.plugin.wallet.wecoin.utils.c.a((Context)paramWeCoinIncomeDetailView, parama);
    AppMethodBeat.o(316121);
  }
  
  private static final void a(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, adz paramadz)
  {
    Object localObject2 = null;
    AppMethodBeat.i(316127);
    s.u(paramWeCoinIncomeDetailView, "this$0");
    Object localObject3 = paramWeCoinIncomeDetailView.VwH;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mIncomeBalanceLL");
      localObject1 = null;
    }
    ((LinearLayout)localObject1).setVisibility(8);
    if (paramadz != null)
    {
      localObject1 = (CharSequence)paramadz.content;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label293;
        }
        localObject3 = paramWeCoinIncomeDetailView.VwJ;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("mViewModel");
          localObject1 = null;
        }
        ((com.tencent.mm.plugin.wallet.wecoin.model.i)localObject1).asf(8);
        localObject3 = paramWeCoinIncomeDetailView.VwH;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("mIncomeBalanceLL");
          localObject1 = null;
        }
        ((LinearLayout)localObject1).setVisibility(0);
        localObject3 = paramWeCoinIncomeDetailView.VwH;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("mIncomeBalanceLL");
          localObject1 = null;
        }
        ((TextView)((LinearLayout)localObject1).findViewById(a.f.wecoin_income_banner_tv)).setText((CharSequence)paramadz.content);
        localObject3 = paramWeCoinIncomeDetailView.VwH;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("mIncomeBalanceLL");
          localObject1 = null;
        }
        localObject1 = (WeImageView)((LinearLayout)localObject1).findViewById(a.f.wecoin_income_banner_right_arrow);
        localObject3 = (CharSequence)paramadz.url;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label252;
        }
      }
      label252:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label257;
        }
        ((WeImageView)localObject1).setVisibility(8);
        AppMethodBeat.o(316127);
        return;
        i = 0;
        break;
      }
      label257:
      ((WeImageView)localObject1).setVisibility(0);
      localObject1 = paramWeCoinIncomeDetailView.VwH;
      if (localObject1 != null) {
        break label300;
      }
      s.bIx("mIncomeBalanceLL");
      localObject1 = localObject2;
    }
    label293:
    label300:
    for (;;)
    {
      ((LinearLayout)localObject1).setOnClickListener(new WeCoinIncomeDetailView..ExternalSyntheticLambda5(paramWeCoinIncomeDetailView, paramadz));
      AppMethodBeat.o(316127);
      return;
    }
  }
  
  private static final void a(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, adz paramadz, View paramView)
  {
    AppMethodBeat.i(316146);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramWeCoinIncomeDetailView);
    localb.cH(paramadz);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramWeCoinIncomeDetailView, "this$0");
    s.u(paramadz, "$this_apply");
    localObject = paramWeCoinIncomeDetailView.VwJ;
    paramView = (View)localObject;
    if (localObject == null)
    {
      s.bIx("mViewModel");
      paramView = null;
    }
    paramView.asf(9);
    paramView = new Intent();
    paramView.putExtra("rawUrl", paramadz.url);
    com.tencent.mm.wallet_core.ui.i.aS((Context)paramWeCoinIncomeDetailView, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316146);
  }
  
  private static final void a(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, emd paramemd)
  {
    AppMethodBeat.i(316118);
    s.u(paramWeCoinIncomeDetailView, "this$0");
    paramWeCoinIncomeDetailView.ihA();
    AppMethodBeat.o(316118);
  }
  
  private static final void a(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, emd paramemd, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(316163);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramWeCoinIncomeDetailView);
    localb.cH(paramemd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, localb.aYj());
    s.u(paramWeCoinIncomeDetailView, "this$0");
    localObject2 = paramWeCoinIncomeDetailView.VwJ;
    paramView = (View)localObject2;
    if (localObject2 == null)
    {
      s.bIx("mViewModel");
      paramView = null;
    }
    paramView.asf(2);
    if ((paramemd != null) && (paramemd.status == 1))
    {
      localObject2 = paramWeCoinIncomeDetailView.VwJ;
      paramView = (View)localObject2;
      if (localObject2 == null)
      {
        s.bIx("mViewModel");
        paramView = null;
      }
      paramView.asf(11);
      Log.d("MicroMsg.WeCoinIncomeDetailView", s.X("openRealNameAuth, info: ", paramemd));
      localObject2 = new Intent((Context)paramWeCoinIncomeDetailView, AppBrandIDCardUI.class);
      ((Intent)localObject2).putExtra("intent_appid", paramemd.appid);
      ((Intent)localObject2).putExtra("intent_category_id", new JSONArray((Collection)paramemd.abqA).toString());
      ((Intent)localObject2).putExtra("intent_auth_type", paramemd.auth_type);
      ((Intent)localObject2).putExtra("id_ui_theme", 2);
      ((Intent)localObject2).putExtra("wecoin_apply_info", paramemd.abqB);
      ((Intent)localObject2).putExtra("wecoin_protocol_url", paramemd.igL);
      paramView = paramWeCoinIncomeDetailView.VwJ;
      paramemd = paramView;
      if (paramView == null)
      {
        s.bIx("mViewModel");
        paramemd = null;
      }
      paramemd = paramemd.VuK;
      if (paramemd == null)
      {
        paramemd = null;
        ((Intent)localObject2).putExtra("wecoin_kv_scene_id", (Serializable)paramemd);
        paramView = paramWeCoinIncomeDetailView.VwJ;
        paramemd = paramView;
        if (paramView == null)
        {
          s.bIx("mViewModel");
          paramemd = null;
        }
        paramemd = paramemd.VuK;
        if (paramemd != null) {
          break label432;
        }
        paramemd = null;
        label325:
        ((Intent)localObject2).putExtra("wecoin_kv_session_id", paramemd);
        paramView = paramWeCoinIncomeDetailView.VwJ;
        paramemd = paramView;
        if (paramView == null)
        {
          s.bIx("mViewModel");
          paramemd = null;
        }
        paramemd = paramemd.VuK;
        if (paramemd != null) {
          break label440;
        }
      }
      label432:
      label440:
      for (paramemd = localObject1;; paramemd = paramemd.ugZ)
      {
        ((Intent)localObject2).putExtra("wecoin_kv_cgi_session_id", paramemd);
        com.tencent.mm.br.c.b((Context)paramWeCoinIncomeDetailView.getContext(), "appbrand", ".ui.autofill.AppBrandIDCardUI", (Intent)localObject2, 2001);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(316163);
        return;
        paramemd = Integer.valueOf(paramemd.Vvz);
        break;
        paramemd = paramemd.Vua;
        break label325;
      }
    }
    paramWeCoinIncomeDetailView.ihB();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316163);
  }
  
  private static final void a(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, Boolean paramBoolean)
  {
    AppMethodBeat.i(316124);
    s.u(paramWeCoinIncomeDetailView, "this$0");
    Log.d("MicroMsg.WeCoinIncomeDetailView", s.X("updateAuthored: ", paramBoolean));
    if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
      paramWeCoinIncomeDetailView.ihB();
    }
    AppMethodBeat.o(316124);
  }
  
  private static final void a(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, Long paramLong)
  {
    AppMethodBeat.i(316111);
    s.u(paramWeCoinIncomeDetailView, "this$0");
    paramWeCoinIncomeDetailView.u(paramLong);
    paramWeCoinIncomeDetailView.ihA();
    AppMethodBeat.o(316111);
  }
  
  private static final void a(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, String paramString)
  {
    AppMethodBeat.i(316107);
    s.u(paramWeCoinIncomeDetailView, "this$0");
    paramWeCoinIncomeDetailView.removeAllOptionMenu();
    if (paramString != null)
    {
      String str = paramWeCoinIncomeDetailView.getString(a.i.wecoin_pretax_income_option_detail);
      s.s(str, "getString(R.string.wecoi…tax_income_option_detail)");
      paramWeCoinIncomeDetailView.addTextOptionMenu(0, str, new WeCoinIncomeDetailView..ExternalSyntheticLambda2(paramWeCoinIncomeDetailView, paramString), null, y.b.adES);
    }
    AppMethodBeat.o(316107);
  }
  
  private static final void a(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, String paramString, View paramView)
  {
    AppMethodBeat.i(316141);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramWeCoinIncomeDetailView);
    localb.cH(paramString);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramWeCoinIncomeDetailView, "this$0");
    localObject = paramWeCoinIncomeDetailView.VwJ;
    paramView = (View)localObject;
    if (localObject == null)
    {
      s.bIx("mViewModel");
      paramView = null;
    }
    paramView.asf(7);
    paramView = new Intent();
    paramView.putExtra("rawUrl", paramString);
    paramView.putExtra("showShare", false);
    paramView.putExtra(f.s.adxf, true);
    com.tencent.mm.wallet_core.ui.i.aS((Context)paramWeCoinIncomeDetailView.getContext(), paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316141);
  }
  
  private static final void a(bmq parambmq, WeCoinIncomeDetailView paramWeCoinIncomeDetailView, View paramView)
  {
    AppMethodBeat.i(316138);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambmq);
    localb.cH(paramWeCoinIncomeDetailView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramWeCoinIncomeDetailView, "this$0");
    paramView = new Intent();
    paramView.putExtra("rawUrl", parambmq.mdK);
    com.tencent.mm.wallet_core.ui.i.aS((Context)paramWeCoinIncomeDetailView, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316138);
  }
  
  private static final boolean a(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(316103);
    s.u(paramWeCoinIncomeDetailView, "this$0");
    com.tencent.mm.plugin.wallet.wecoin.model.i locali = paramWeCoinIncomeDetailView.VwJ;
    paramMenuItem = locali;
    if (locali == null)
    {
      s.bIx("mViewModel");
      paramMenuItem = null;
    }
    paramMenuItem.asf(10);
    paramWeCoinIncomeDetailView.finish();
    AppMethodBeat.o(316103);
    return true;
  }
  
  private static final boolean a(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, String paramString, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(316134);
    s.u(paramWeCoinIncomeDetailView, "this$0");
    com.tencent.mm.plugin.wallet.wecoin.model.i locali = paramWeCoinIncomeDetailView.VwJ;
    paramMenuItem = locali;
    if (locali == null)
    {
      s.bIx("mViewModel");
      paramMenuItem = null;
    }
    paramMenuItem.asf(3);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("rawUrl", paramString);
    paramMenuItem.putExtra("showShare", false);
    paramMenuItem.putExtra(f.s.adxf, true);
    com.tencent.mm.wallet_core.ui.i.aS((Context)paramWeCoinIncomeDetailView.getContext(), paramMenuItem);
    AppMethodBeat.o(316134);
    return true;
  }
  
  private static final void b(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, View paramView)
  {
    AppMethodBeat.i(316157);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramWeCoinIncomeDetailView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramWeCoinIncomeDetailView, "this$0");
    paramWeCoinIncomeDetailView.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316157);
  }
  
  private static final void b(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, Boolean paramBoolean)
  {
    AppMethodBeat.i(316131);
    s.u(paramWeCoinIncomeDetailView, "this$0");
    Log.d("MicroMsg.WeCoinIncomeDetailView", s.X("showProgressDialog: ", paramBoolean));
    if (paramBoolean != null) {
      if (!paramBoolean.booleanValue()) {
        break label75;
      }
    }
    for (paramBoolean = w.a((Context)paramWeCoinIncomeDetailView.getContext(), (CharSequence)paramWeCoinIncomeDetailView.getContext().getString(a.i.loading_tips), false, 3, null);; paramBoolean = null)
    {
      paramWeCoinIncomeDetailView.lKp = paramBoolean;
      AppMethodBeat.o(316131);
      return;
      label75:
      paramBoolean = paramWeCoinIncomeDetailView.lKp;
      if (paramBoolean != null) {
        paramBoolean.dismiss();
      }
    }
  }
  
  private static final void b(WeCoinIncomeDetailView paramWeCoinIncomeDetailView, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(316115);
    s.u(paramWeCoinIncomeDetailView, "this$0");
    TextView localTextView2 = paramWeCoinIncomeDetailView.VwK;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      s.bIx("mFaqTv");
      localTextView1 = null;
    }
    localTextView1.setVisibility(4);
    if (paramString != null)
    {
      localTextView2 = paramWeCoinIncomeDetailView.VwK;
      localTextView1 = localTextView2;
      if (localTextView2 == null)
      {
        s.bIx("mFaqTv");
        localTextView1 = null;
      }
      localTextView1.setOnClickListener(new WeCoinIncomeDetailView..ExternalSyntheticLambda7(paramWeCoinIncomeDetailView, paramString));
      paramWeCoinIncomeDetailView = paramWeCoinIncomeDetailView.VwK;
      if (paramWeCoinIncomeDetailView != null) {
        break label109;
      }
      s.bIx("mFaqTv");
      paramWeCoinIncomeDetailView = localObject;
    }
    label109:
    for (;;)
    {
      paramWeCoinIncomeDetailView.setVisibility(0);
      AppMethodBeat.o(316115);
      return;
    }
  }
  
  private final void ihA()
  {
    Object localObject2 = null;
    AppMethodBeat.i(316089);
    Object localObject3 = this.VwJ;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mViewModel");
      localObject1 = null;
    }
    emd localemd = (emd)((LiveData)((com.tencent.mm.plugin.wallet.wecoin.model.i)localObject1).VuR).getValue();
    localObject3 = this.VwJ;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mViewModel");
      localObject1 = null;
    }
    localObject3 = (Long)((LiveData)((com.tencent.mm.plugin.wallet.wecoin.model.i)localObject1).VuQ).getValue();
    localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = Long.valueOf(0L);
    }
    long l = ((Number)localObject1).longValue();
    if (l == 0L)
    {
      localObject3 = this.VwJ;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("mViewModel");
        localObject1 = null;
      }
      if (((com.tencent.mm.plugin.wallet.wecoin.model.i)localObject1).VuV)
      {
        localObject3 = this.VwI;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("mCloseBtn");
          localObject1 = null;
        }
        ((Button)localObject1).setVisibility(0);
        localObject3 = this.Vcy;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("mFetchBtn");
          localObject1 = null;
        }
        ((Button)localObject1).setVisibility(8);
        localObject3 = this.VwI;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("mCloseBtn");
          localObject1 = null;
        }
        ((Button)localObject1).setOnClickListener(new WeCoinIncomeDetailView..ExternalSyntheticLambda3(this));
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.WeCoinIncomeDetailView", "updateClickButtonEvent, AuthInfo: " + localemd + ", balance: " + l);
      localObject3 = this.Vcy;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("mFetchBtn");
        localObject1 = null;
      }
      ((Button)localObject1).setEnabled(false);
      if (l > 0L) {
        break;
      }
      AppMethodBeat.o(316089);
      return;
      localObject3 = this.VwI;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("mCloseBtn");
        localObject1 = null;
      }
      ((Button)localObject1).setVisibility(8);
      localObject3 = this.Vcy;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("mFetchBtn");
        localObject1 = null;
      }
      ((Button)localObject1).setVisibility(0);
    }
    localObject3 = this.Vcy;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mFetchBtn");
      localObject1 = null;
    }
    ((Button)localObject1).setEnabled(true);
    localObject1 = this.Vcy;
    if (localObject1 == null)
    {
      s.bIx("mFetchBtn");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((Button)localObject1).setOnClickListener(new WeCoinIncomeDetailView..ExternalSyntheticLambda6(this, localemd));
      AppMethodBeat.o(316089);
      return;
    }
  }
  
  private final void ihB()
  {
    Object localObject2 = null;
    AppMethodBeat.i(316095);
    Log.d("MicroMsg.WeCoinIncomeDetailView", "gotoIncomeBalanceView: ");
    Intent localIntent = new Intent((Context)getContext(), WeCoinEncashView.class);
    com.tencent.mm.plugin.wallet.wecoin.model.i locali = this.VwJ;
    Object localObject1 = locali;
    if (locali == null)
    {
      s.bIx("mViewModel");
      localObject1 = null;
    }
    localObject1 = (Long)((LiveData)((com.tencent.mm.plugin.wallet.wecoin.model.i)localObject1).VuQ).getValue();
    if (localObject1 != null) {
      localIntent.putExtra("wecoin_income_balance", ((Number)localObject1).longValue());
    }
    locali = this.VwJ;
    localObject1 = locali;
    if (locali == null)
    {
      s.bIx("mViewModel");
      localObject1 = null;
    }
    localIntent.putExtra("wecoin_enter_encash_business_kv_data", (Parcelable)((com.tencent.mm.plugin.wallet.wecoin.model.i)localObject1).VuK);
    locali = this.VwJ;
    localObject1 = locali;
    if (locali == null)
    {
      s.bIx("mViewModel");
      localObject1 = null;
    }
    localIntent.putExtra("WECOIN_BUSINESS_ID", ((com.tencent.mm.plugin.wallet.wecoin.model.i)localObject1).VuF);
    localObject1 = this.VwJ;
    if (localObject1 == null)
    {
      s.bIx("mViewModel");
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.wallet.wecoin.model.i)localObject1).VuU;
      if (localObject1 != null)
      {
        localObject1 = ((clp)localObject1).aarU;
        if (localObject1 != null) {
          localIntent.putExtra("WECOIN_TAX_CUT_ENTRANCE_INFO", ((gim)localObject1).toByteArray());
        }
      }
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "gotoIncomeBalanceView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "gotoIncomeBalanceView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(316095);
      return;
    }
  }
  
  private final void u(Long paramLong)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(316084);
    label253:
    int i;
    if (paramLong != null)
    {
      long l = ((Number)paramLong).longValue();
      if (l == 0L)
      {
        com.tencent.mm.plugin.wallet.wecoin.model.i locali = this.VwJ;
        paramLong = locali;
        if (locali == null)
        {
          s.bIx("mViewModel");
          paramLong = null;
        }
        if (paramLong.VuV)
        {
          localObject2 = this.VwC;
          paramLong = (Long)localObject2;
          if (localObject2 == null)
          {
            s.bIx("normalModeTitleLayout");
            paramLong = null;
          }
          paramLong.setVisibility(8);
          localObject2 = this.VwD;
          paramLong = (Long)localObject2;
          if (localObject2 == null)
          {
            s.bIx("normalModeContentLayout");
            paramLong = null;
          }
          paramLong.setVisibility(8);
          localObject2 = this.VwE;
          paramLong = (Long)localObject2;
          if (localObject2 == null)
          {
            s.bIx("normalModeTips");
            paramLong = null;
          }
          paramLong.setVisibility(8);
          localObject2 = this.VwF;
          paramLong = (Long)localObject2;
          if (localObject2 == null)
          {
            s.bIx("cocertActivateModeLayout");
            paramLong = null;
          }
          paramLong.setVisibility(0);
          localObject2 = this.VwG;
          paramLong = (Long)localObject2;
          if (localObject2 == null)
          {
            s.bIx("cocertActivateModeTips");
            paramLong = null;
          }
          paramLong.setVisibility(0);
          paramLong = this.VwG;
          if (paramLong == null)
          {
            s.bIx("cocertActivateModeTips");
            paramLong = null;
            localObject2 = this.VwJ;
            if (localObject2 != null) {
              break label253;
            }
            s.bIx("mViewModel");
          }
          for (;;)
          {
            paramLong.setText((CharSequence)((com.tencent.mm.plugin.wallet.wecoin.model.i)localObject1).lym);
            AppMethodBeat.o(316084);
            return;
            break;
            localObject1 = localObject2;
          }
        }
      }
      localObject1 = this.VwC;
      paramLong = (Long)localObject1;
      if (localObject1 == null)
      {
        s.bIx("normalModeTitleLayout");
        paramLong = null;
      }
      paramLong.setVisibility(0);
      localObject1 = this.VwD;
      paramLong = (Long)localObject1;
      if (localObject1 == null)
      {
        s.bIx("normalModeContentLayout");
        paramLong = null;
      }
      paramLong.setVisibility(0);
      localObject1 = this.VwE;
      paramLong = (Long)localObject1;
      if (localObject1 == null)
      {
        s.bIx("normalModeTips");
        paramLong = null;
      }
      paramLong.setVisibility(0);
      localObject1 = this.VwF;
      paramLong = (Long)localObject1;
      if (localObject1 == null)
      {
        s.bIx("cocertActivateModeLayout");
        paramLong = null;
      }
      paramLong.setVisibility(8);
      localObject1 = this.VwG;
      paramLong = (Long)localObject1;
      if (localObject1 == null)
      {
        s.bIx("cocertActivateModeTips");
        paramLong = null;
      }
      paramLong.setVisibility(8);
      localObject1 = this.VwJ;
      paramLong = (Long)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mViewModel");
        paramLong = null;
      }
      paramLong = paramLong.lym;
      if (((CharSequence)paramLong).length() <= 0) {
        break label549;
      }
      i = 1;
      if (i == 0) {
        break label554;
      }
      label442:
      if (paramLong != null)
      {
        localObject1 = this.VwE;
        if (localObject1 != null) {
          break label559;
        }
        s.bIx("normalModeTips");
        localObject1 = null;
        label466:
        ((TextView)localObject1).setText((CharSequence)getString(a.i.wallet_balance_manager_cocert_activate_title_2, new Object[] { paramLong }));
      }
      localObject1 = com.tencent.mm.wallet_core.ui.i.formatMoney2f(com.tencent.mm.wallet_core.ui.i.b(s.X("", Long.valueOf(l)), "100", 2, RoundingMode.HALF_UP).doubleValue());
      paramLong = this.VcE;
      if (paramLong != null) {
        break label562;
      }
      s.bIx("mBalanceView");
      paramLong = (Long)localObject2;
    }
    label549:
    label554:
    label559:
    label562:
    for (;;)
    {
      paramLong.dD((String)localObject1, false);
      AppMethodBeat.o(316084);
      return;
      i = 0;
      break;
      paramLong = null;
      break label442;
      break label466;
    }
  }
  
  public int getLayoutId()
  {
    return a.g.activity_we_coin_income_ui;
  }
  
  public void initView()
  {
    Object localObject3 = null;
    Object localObject4 = null;
    ViewGroup.MarginLayoutParams localMarginLayoutParams = null;
    AppMethodBeat.i(316246);
    setActionbarColor(getResources().getColor(a.c.white));
    hideActionbarLine();
    setMMTitle("");
    Object localObject1 = findViewById(a.f.normal_mode_title_layout);
    s.s(localObject1, "findViewById(R.id.normal_mode_title_layout)");
    this.VwC = ((View)localObject1);
    localObject1 = findViewById(a.f.normal_mode_content_layout);
    s.s(localObject1, "findViewById(R.id.normal_mode_content_layout)");
    this.VwD = ((View)localObject1);
    localObject1 = findViewById(a.f.normal_mode_tips);
    s.s(localObject1, "findViewById(R.id.normal_mode_tips)");
    this.VwE = ((TextView)localObject1);
    localObject1 = findViewById(a.f.cocert_activate_mode_content_layout);
    s.s(localObject1, "findViewById(R.id.cocert…vate_mode_content_layout)");
    this.VwF = ((View)localObject1);
    localObject1 = findViewById(a.f.cocert_activate_tips);
    s.s(localObject1, "findViewById(R.id.cocert_activate_tips)");
    this.VwG = ((TextView)localObject1);
    localObject1 = findViewById(a.f.wallet_balance_view);
    s.s(localObject1, "findViewById(R.id.wallet_balance_view)");
    this.VcE = ((WcPayMoneyLoadingView)localObject1);
    localObject1 = findViewById(a.f.wallet_money_load_pb);
    s.s(localObject1, "findViewById(R.id.wallet_money_load_pb)");
    this.KML = ((ProgressBar)localObject1);
    localObject1 = findViewById(a.f.wecoin_income_banner_ll);
    s.s(localObject1, "findViewById(R.id.wecoin_income_banner_ll)");
    this.VwH = ((LinearLayout)localObject1);
    this.VwL = ((TextView)findViewById(a.f.balance_action_tv));
    this.VwM = findViewById(a.f.balance_action_layout);
    this.VwN = ((ImageView)findViewById(a.f.balance_action_iv));
    this.VwO = findViewById(a.f.wallet_balance_manager_margin_line);
    this.VwQ = ((TextView)findViewById(a.f.live_settlement_desc_tv));
    this.VwP = ((TextView)findViewById(a.f.wallet_balance_manager_settlement));
    this.VwR = findViewById(a.f.action_group);
    Object localObject2 = this.VcE;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("mBalanceView");
      localObject1 = null;
    }
    Object localObject5 = this.KML;
    localObject2 = localObject5;
    if (localObject5 == null)
    {
      s.bIx("mMoneyLoadingPb");
      localObject2 = null;
    }
    ((WcPayMoneyLoadingView)localObject1).setLoadingPb((ProgressBar)localObject2);
    localObject2 = this.VcE;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("mBalanceView");
      localObject1 = null;
    }
    ((WcPayMoneyLoadingView)localObject1).setPrefixSymbol(getString(a.i.wallet_rmb_symbol));
    localObject5 = getLifecycle();
    localObject2 = this.VcE;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("mBalanceView");
      localObject1 = null;
    }
    ((androidx.lifecycle.j)localObject5).addObserver((p)localObject1);
    localObject1 = findViewById(a.f.wallet_balance_manager_fetch_btn);
    s.s(localObject1, "findViewById(R.id.wallet…alance_manager_fetch_btn)");
    this.Vcy = ((Button)localObject1);
    localObject1 = findViewById(a.f.wallet_balance_manager_cocert_activate_mode_finish);
    s.s(localObject1, "findViewById(R.id.wallet…ert_activate_mode_finish)");
    this.VwI = ((Button)localObject1);
    localObject1 = findViewById(a.f.wallet_balance_manager_qanda);
    s.s(localObject1, "findViewById(R.id.wallet_balance_manager_qanda)");
    this.VwK = ((TextView)localObject1);
    ((WeImageView)findViewById(a.f.wecoin_income_help_tips)).setOnClickListener(new WeCoinIncomeDetailView..ExternalSyntheticLambda4(this));
    localObject2 = this.VwK;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("mFaqTv");
      localObject1 = null;
    }
    aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    localObject1 = this.VwP;
    label611:
    label629:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      aw.a((Paint)localObject1, 0.8F);
      setBackBtn(new WeCoinIncomeDetailView..ExternalSyntheticLambda1(this), a.h.actionbar_icon_dark_back);
      u(Long.valueOf(0L));
      localObject1 = this.VwM;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
      if (localObject1 != null) {
        break label857;
      }
      localObject1 = null;
      localObject5 = new StringBuilder("settlementEnable:");
      if (localObject1 != null) {
        break label867;
      }
      localObject2 = null;
      localObject5 = ((StringBuilder)localObject5).append(localObject2).append(", url:");
      if (localObject1 != null) {
        break label878;
      }
      localObject2 = null;
      label649:
      localObject5 = ((StringBuilder)localObject5).append(localObject2).append(", tip:");
      if (localObject1 != null) {
        break label886;
      }
      localObject2 = null;
      label669:
      Log.i("MicroMsg.WeCoinIncomeDetailView", localObject2);
      if ((localObject1 == null) || (((bmq)localObject1).enable != true)) {
        break label894;
      }
      i = 1;
      label698:
      if (i == 0) {
        break label1002;
      }
      localObject2 = this.VwO;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
      localObject2 = this.VwP;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(0);
      }
      localObject2 = this.VwP;
      if (localObject2 != null) {
        ((TextView)localObject2).setOnClickListener(new WeCoinIncomeDetailView..ExternalSyntheticLambda8((bmq)localObject1, this));
      }
      if (Util.isNullOrNil(((bmq)localObject1).ZVg)) {
        break label907;
      }
      localObject2 = this.VwR;
      if (localObject2 != null) {
        break label899;
      }
    }
    label899:
    for (localObject2 = null;; localObject2 = ((View)localObject2).getLayoutParams())
    {
      if ((localObject2 instanceof ViewGroup.MarginLayoutParams)) {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localObject2;
      }
      if (localMarginLayoutParams != null) {
        localMarginLayoutParams.bottomMargin = bd.fromDPToPix((Context)getContext(), 48);
      }
      localObject2 = this.VwQ;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(0);
      }
      localObject2 = this.VwQ;
      if (localObject2 == null) {
        break label1093;
      }
      ((TextView)localObject2).setText((CharSequence)((bmq)localObject1).ZVg);
      AppMethodBeat.o(316246);
      return;
      localObject1 = ((TextView)localObject1).getPaint();
      break;
      label857:
      localObject1 = ((com.tencent.d.a.a.a.b)localObject1).getLiveSettlementInfo();
      break label611;
      label867:
      localObject2 = Boolean.valueOf(((bmq)localObject1).enable);
      break label629;
      label878:
      localObject2 = ((bmq)localObject1).mdK;
      break label649;
      label886:
      localObject2 = ((bmq)localObject1).ZVg;
      break label669;
      label894:
      i = 0;
      break label698;
    }
    label907:
    localObject1 = this.VwR;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((View)localObject1).getLayoutParams())
    {
      localObject2 = localObject3;
      if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        localObject2 = (ViewGroup.MarginLayoutParams)localObject1;
      }
      if (localObject2 != null) {
        ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = bd.fromDPToPix((Context)getContext(), 64);
      }
      localObject1 = this.VwQ;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = this.VwQ;
      if (localObject1 == null) {
        break;
      }
      ((TextView)localObject1).setText((CharSequence)"");
      AppMethodBeat.o(316246);
      return;
    }
    label1002:
    localObject1 = this.VwR;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((View)localObject1).getLayoutParams())
    {
      localObject2 = localObject4;
      if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        localObject2 = (ViewGroup.MarginLayoutParams)localObject1;
      }
      if (localObject2 != null) {
        ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = bd.fromDPToPix((Context)getContext(), 64);
      }
      localObject1 = this.VwO;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = this.VwP;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = this.VwQ;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      label1093:
      AppMethodBeat.o(316246);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.tencent.mm.plugin.wallet.wecoin.model.i locali2 = null;
    com.tencent.mm.plugin.wallet.wecoin.model.i locali1 = null;
    AppMethodBeat.i(316256);
    Log.d("MicroMsg.WeCoinIncomeDetailView", "onActivityResult() requestCode:%d resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 2001)
    {
      AppMethodBeat.o(316256);
      return;
    }
    if (paramInt2 == -1)
    {
      if (paramIntent == null)
      {
        paramIntent = null;
        CharSequence localCharSequence = (CharSequence)paramIntent;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label143;
        }
        paramInt1 = 1;
        label94:
        if (paramInt1 != 0) {
          break label155;
        }
        locali2 = this.VwJ;
        if (locali2 != null) {
          break label148;
        }
        s.bIx("mViewModel");
      }
      for (;;)
      {
        locali1.a(paramIntent, (com.tencent.mm.vending.e.b)this);
        AppMethodBeat.o(316256);
        return;
        paramIntent = paramIntent.getStringExtra("intent_auth_token");
        break;
        label143:
        paramInt1 = 0;
        break label94;
        label148:
        locali1 = locali2;
      }
    }
    label155:
    paramIntent = this.VwJ;
    if (paramIntent == null)
    {
      s.bIx("mViewModel");
      paramIntent = locali2;
    }
    for (;;)
    {
      paramIntent.asf(19);
      AppMethodBeat.o(316256);
      return;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(316236);
    com.tencent.mm.plugin.wallet.wecoin.model.i locali2 = this.VwJ;
    com.tencent.mm.plugin.wallet.wecoin.model.i locali1 = locali2;
    if (locali2 == null)
    {
      s.bIx("mViewModel");
      locali1 = null;
    }
    locali1.asf(10);
    super.onBackPressed();
    AppMethodBeat.o(316236);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(316227);
    super.onCreate(paramBundle);
    paramBundle = new com.tencent.mm.plugin.wallet.wecoin.model.j(getIntent().getIntExtra("WECOIN_BUSINESS_ID", 1));
    paramBundle = ai.a((FragmentActivity)this, (ah.b)paramBundle).q(com.tencent.mm.plugin.wallet.wecoin.model.i.class);
    s.s(paramBundle, "of(this, factory).get(We…ailViewModel::class.java)");
    this.VwJ = ((com.tencent.mm.plugin.wallet.wecoin.model.i)paramBundle);
    initView();
    Object localObject1 = this.VwJ;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.VuO).a((q)this, new WeCoinIncomeDetailView..ExternalSyntheticLambda15(this));
    localObject1 = this.VwJ;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.VuQ).a((q)this, new WeCoinIncomeDetailView..ExternalSyntheticLambda14(this));
    localObject1 = this.VwJ;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.VuP).a((q)this, new WeCoinIncomeDetailView..ExternalSyntheticLambda16(this));
    localObject1 = this.VwJ;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.VuR).a((q)this, new WeCoinIncomeDetailView..ExternalSyntheticLambda11(this));
    localObject1 = this.VwJ;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.Vup).a((q)this, new WeCoinIncomeDetailView..ExternalSyntheticLambda9(this));
    localObject1 = this.VwJ;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.VuT).a((q)this, new WeCoinIncomeDetailView..ExternalSyntheticLambda13(this));
    localObject1 = this.VwJ;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.VuS).a((q)this, new WeCoinIncomeDetailView..ExternalSyntheticLambda10(this));
    localObject1 = this.VwJ;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.wIq).a((q)this, new WeCoinIncomeDetailView..ExternalSyntheticLambda12(this));
    paramBundle = this.VwJ;
    if (paramBundle == null)
    {
      s.bIx("mViewModel");
      paramBundle = null;
      localObject1 = (WecoinEncashKVData)getIntent().getParcelableExtra("wecoin_enter_encash_business_kv_data");
      if (localObject1 != null) {
        paramBundle.VuK = new WecoinEncashKVData(((WecoinEncashKVData)localObject1).Vvz, ((WecoinEncashKVData)localObject1).Vua, com.tencent.mm.plugin.wallet.wecoin.utils.c.ihq());
      }
      localObject1 = this.VwJ;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mViewModel");
        paramBundle = null;
      }
      paramBundle.VuV = getIntent().getBooleanExtra("wecoin_enter_encash_business_kv_is_cocert_activate", false);
      localObject1 = this.VwJ;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mViewModel");
        paramBundle = null;
      }
      String str = getIntent().getStringExtra("wecoin_enter_encash_business_kv_tips");
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      s.u(localObject1, "<set-?>");
      paramBundle.lym = ((String)localObject1);
      paramBundle = this.VwJ;
      if (paramBundle != null) {
        break label641;
      }
      s.bIx("mViewModel");
      paramBundle = localObject2;
    }
    label641:
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.wallet.wecoin.utils.c.ihH();
      if (localObject1 != null)
      {
        paramBundle.VuO.t(((clp)localObject1).aarS);
        paramBundle.VuP.t(((clp)localObject1).aatC);
        paramBundle.VuQ.t(Long.valueOf(((clp)localObject1).aarR));
        paramBundle.VuR.t(((clp)localObject1).aarT);
        paramBundle.VuS.t(((clp)localObject1).aatD);
        paramBundle.VuU = ((clp)localObject1);
      }
      AppMethodBeat.o(316227);
      return;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(316233);
    super.onDestroy();
    com.tencent.mm.plugin.wallet.wecoin.model.i locali = this.VwJ;
    Object localObject = locali;
    if (locali == null)
    {
      s.bIx("mViewModel");
      localObject = null;
    }
    localObject = ((com.tencent.mm.plugin.wallet.wecoin.model.i)localObject).VuU;
    if (localObject != null)
    {
      s.u(localObject, "response");
      Log.d("MicroMsg.WeCoinUtils", "save WecoinIncomePageInfoResponse snapshot");
      d.B((kotlin.g.a.a)new c.a((clp)localObject));
    }
    AppMethodBeat.o(316233);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(316229);
    super.onResume();
    com.tencent.mm.plugin.wallet.wecoin.model.i locali2 = this.VwJ;
    com.tencent.mm.plugin.wallet.wecoin.model.i locali1 = locali2;
    if (locali2 == null)
    {
      s.bIx("mViewModel");
      locali1 = null;
    }
    locali1.e((com.tencent.mm.vending.e.b)this);
    AppMethodBeat.o(316229);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinIncomeDetailView
 * JD-Core Version:    0.7.0.1
 */