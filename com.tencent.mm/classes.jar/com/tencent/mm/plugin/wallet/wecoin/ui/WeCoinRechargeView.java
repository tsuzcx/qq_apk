package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.setting.ui.b.a.a;
import com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData;
import com.tencent.mm.plugin.wallet.wecoin.model.l;
import com.tencent.mm.plugin.wallet.wecoin.model.l.a;
import com.tencent.mm.plugin.wallet.wecoin.model.m;
import com.tencent.mm.plugin.wallet.wecoin.model.m.b;
import com.tencent.mm.plugin.wallet.wecoin.utils.c;
import com.tencent.mm.plugin.wallet.wecoin.utils.c.b;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.adz;
import com.tencent.mm.protocal.protobuf.cwm;
import com.tencent.mm.protocal.protobuf.gii;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y.b;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "mBalanceView", "Lcom/tencent/mm/plugin/wallet_core/ui/view/WcPayMoneyLoadingView;", "mBannerView", "Landroid/view/View;", "mCloseClickLl", "Landroid/widget/LinearLayout;", "mCloseClickTv", "Landroid/widget/TextView;", "mFaqLinearLayout", "mFaqTv", "mMoneyLoadingPb", "Landroid/widget/ProgressBar;", "mNoBalanceTipsTv", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mSwitchDeviceTipsView", "mTotalBalanceLl", "mTutorialClickLl", "mTutorialClickTv", "mViewModel", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinRechargeViewModel;", "mWeCoinBalanceView", "mWeCoinRechargeButton", "Landroid/widget/Button;", "bindData", "", "getLayoutId", "", "initView", "isChinaReg", "", "loadCacheData", "loadData", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "showCloseAuthDialog", "showDeviceSwitchTips", "hasShow", "(Ljava/lang/Boolean;)V", "showErrorMsg", "info", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "showGridBottomSheet", "showProgressDialog", "isShow", "showTutorialDialog", "updateCloseAuthBtn", "isAuthed", "updateFaqView", "url", "", "updateIncomeBalance", "balance", "Lcom/tencent/mm/plugin/wallet/wecoin/model/UserIncomeDetailData;", "updateMainContentView", "updateRechargeButtonState", "midasInitialized", "updateRightOptionMenu", "updateTopBannerView", "bannerContent", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "updateTotalBalance", "", "(Ljava/lang/Long;)V", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WeCoinRechargeView
  extends MMActivity
{
  public static final WeCoinRechargeView.a VwS;
  private ProgressBar KML;
  private WcPayMoneyLoadingView VcE;
  private TextView VwK;
  private m VwT;
  private LinearLayout VwU;
  private TextView VwV;
  private View VwW;
  private LinearLayout VwX;
  private LinearLayout VwY;
  private TextView VwZ;
  private LinearLayout Vxa;
  private TextView Vxb;
  private TextView Vxc;
  private Button Vxd;
  private TextView Vxe;
  private w lKp;
  
  static
  {
    AppMethodBeat.i(316186);
    VwS = new WeCoinRechargeView.a((byte)0);
    AppMethodBeat.o(316186);
  }
  
  private final void H(Boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(316077);
    Button localButton2 = this.Vxd;
    Button localButton1 = localButton2;
    if (localButton2 == null)
    {
      kotlin.g.b.s.bIx("mWeCoinRechargeButton");
      localButton1 = null;
    }
    localButton1.setEnabled(false);
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      localButton1 = this.Vxd;
      paramBoolean = localButton1;
      if (localButton1 == null)
      {
        kotlin.g.b.s.bIx("mWeCoinRechargeButton");
        paramBoolean = null;
      }
      paramBoolean.setEnabled(true);
      paramBoolean = this.Vxd;
      if (paramBoolean != null) {
        break label101;
      }
      kotlin.g.b.s.bIx("mWeCoinRechargeButton");
      paramBoolean = localObject;
    }
    label101:
    for (;;)
    {
      paramBoolean.setOnClickListener(new WeCoinRechargeView..ExternalSyntheticLambda4(this));
      AppMethodBeat.o(316077);
      return;
    }
  }
  
  private static final void a(WeCoinRechargeView paramWeCoinRechargeView)
  {
    AppMethodBeat.i(316102);
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    int j = aw.bf((Context)paramWeCoinRechargeView).y;
    Object localObject1 = (Context)paramWeCoinRechargeView;
    Object localObject2 = ((Context)localObject1).getSystemService("window");
    if (localObject2 == null)
    {
      paramWeCoinRechargeView = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(316102);
      throw paramWeCoinRechargeView;
    }
    Object localObject3 = ((WindowManager)localObject2).getDefaultDisplay();
    localObject2 = new Point();
    ((Display)localObject3).getSize((Point)localObject2);
    localObject3 = aw.bf((Context)localObject1);
    Math.max(((Point)localObject2).y, ((Point)localObject2).x);
    int i = Math.max(((Point)localObject3).y, ((Point)localObject3).x);
    localObject2 = new Rect();
    ((Activity)localObject1).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject2);
    int m = i - Math.max(((Rect)localObject2).bottom - ((Rect)localObject2).top, ((Rect)localObject2).right - ((Rect)localObject2).left) - aw.getStatusBarHeight((Context)paramWeCoinRechargeView);
    if (m > 0) {
      j -= aw.bk((Context)paramWeCoinRechargeView);
    }
    for (;;)
    {
      i = 0;
      localObject1 = paramWeCoinRechargeView.getSupportActionBar();
      if (localObject1 != null)
      {
        int k = ((ActionBar)localObject1).getHeight();
        i = k;
        if (k <= 0) {
          i = paramWeCoinRechargeView.getResources().getDimensionPixelSize(a.d.DefaultActionbarHeightPort);
        }
      }
      i = j - i - aw.getStatusBarHeight((Context)paramWeCoinRechargeView) - paramWeCoinRechargeView.getResources().getDimensionPixelSize(a.d.Edge_20A);
      j = com.tencent.mm.cd.a.fromDPToPix((Context)paramWeCoinRechargeView, 520);
      Log.i("MicroMsg.WeCoinRechargeView", "updateMainContentView, [contentViewHeight] " + i + ", [maxSpaceSize] " + j + ", [bottomHeight] " + m);
      if (i > j) {
        i = j;
      }
      for (;;)
      {
        paramWeCoinRechargeView = paramWeCoinRechargeView.findViewById(a.f.wecoin_balance_recharge_layout);
        localObject1 = paramWeCoinRechargeView.getLayoutParams();
        if (localObject1 != null)
        {
          ((ViewGroup.LayoutParams)localObject1).height = i;
          paramWeCoinRechargeView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        AppMethodBeat.o(316102);
        return;
      }
    }
  }
  
  private static final void a(WeCoinRechargeView paramWeCoinRechargeView, View paramView)
  {
    AppMethodBeat.i(316090);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramWeCoinRechargeView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    paramWeCoinRechargeView.ihD();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316090);
  }
  
  private static final void a(WeCoinRechargeView paramWeCoinRechargeView, com.tencent.mm.plugin.wallet.wecoin.model.a parama)
  {
    AppMethodBeat.i(316125);
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    paramWeCoinRechargeView = paramWeCoinRechargeView.getContext();
    kotlin.g.b.s.s(paramWeCoinRechargeView, "context");
    c.a((Context)paramWeCoinRechargeView, parama);
    AppMethodBeat.o(316125);
  }
  
  private static final void a(WeCoinRechargeView paramWeCoinRechargeView, com.tencent.mm.plugin.wallet.wecoin.model.f paramf)
  {
    AppMethodBeat.i(316112);
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    Log.i("MicroMsg.WeCoinRechargeView", kotlin.g.b.s.X("updateIncomeBalance: [blance] ", paramf));
    LinearLayout localLinearLayout = (LinearLayout)paramWeCoinRechargeView.findViewById(a.f.wecoin_income_balance_layout);
    localLinearLayout.setVisibility(8);
    if ((paramf != null) && (paramf.VuC))
    {
      if (paramWeCoinRechargeView.VwT == null) {
        kotlin.g.b.s.bIx("mViewModel");
      }
      m.asf(6);
      localLinearLayout.setOnClickListener(new WeCoinRechargeView..ExternalSyntheticLambda5(paramWeCoinRechargeView));
      String str = com.tencent.mm.wallet_core.ui.i.formatMoney2f(com.tencent.mm.wallet_core.ui.i.b(kotlin.g.b.s.X("", Long.valueOf(paramf.VuD)), "100", 2, RoundingMode.HALF_UP).doubleValue());
      paramf = paramWeCoinRechargeView.VcE;
      paramWeCoinRechargeView = paramf;
      if (paramf == null)
      {
        kotlin.g.b.s.bIx("mBalanceView");
        paramWeCoinRechargeView = null;
      }
      paramWeCoinRechargeView.dD(str, false);
      localLinearLayout.setVisibility(0);
    }
    AppMethodBeat.o(316112);
  }
  
  private static final void a(WeCoinRechargeView paramWeCoinRechargeView1, final WeCoinRechargeView paramWeCoinRechargeView2, MenuItem paramMenuItem, int paramInt)
  {
    paramInt = 1;
    AppMethodBeat.i(316177);
    kotlin.g.b.s.u(paramWeCoinRechargeView1, "this$0");
    kotlin.g.b.s.u(paramWeCoinRechargeView2, "$context");
    Log.i("MicroMsg.WeCoinRechargeView", "setOnMenuSelectedListener click.");
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 1)) {
      if (paramInt != 0)
      {
        paramMenuItem = paramWeCoinRechargeView1.VwT;
        if (paramMenuItem != null) {
          break label94;
        }
        kotlin.g.b.s.bIx("mViewModel");
        paramMenuItem = null;
      }
    }
    label94:
    for (;;)
    {
      paramMenuItem.aP((kotlin.g.a.b)new b(paramWeCoinRechargeView1, paramWeCoinRechargeView2));
      AppMethodBeat.o(316177);
      return;
      paramInt = 0;
      break;
    }
  }
  
  private static final void a(WeCoinRechargeView paramWeCoinRechargeView, adz paramadz)
  {
    Object localObject2 = null;
    AppMethodBeat.i(316130);
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    Log.i("MicroMsg.WeCoinRechargeView", kotlin.g.b.s.X("bannerContent: [bannerContent] ", paramadz));
    Object localObject3 = paramWeCoinRechargeView.VwW;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("mBannerView");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(8);
    if ((paramadz != null) && (!TextUtils.isEmpty((CharSequence)paramadz.content)))
    {
      if (paramWeCoinRechargeView.VwT == null) {
        kotlin.g.b.s.bIx("mViewModel");
      }
      m.asf(2);
      localObject3 = paramWeCoinRechargeView.VwW;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("mBannerView");
        localObject1 = null;
      }
      ((View)localObject1).setVisibility(0);
      localObject3 = paramWeCoinRechargeView.VwW;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("mBannerView");
        localObject1 = null;
      }
      ((TextView)((View)localObject1).findViewById(a.f.wecoin_notice_banner_tv)).setText((CharSequence)paramadz.content);
      localObject3 = paramWeCoinRechargeView.VwW;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("mBannerView");
        localObject1 = null;
      }
      localObject1 = (WeImageView)((View)localObject1).findViewById(a.f.wecoin_notice_banner_go_arrow);
      localObject3 = (CharSequence)paramadz.url;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        ((WeImageView)localObject1).setVisibility(8);
        AppMethodBeat.o(316130);
        return;
      }
      ((WeImageView)localObject1).setVisibility(0);
      localObject1 = paramWeCoinRechargeView.VwW;
      if (localObject1 != null) {
        break label284;
      }
      kotlin.g.b.s.bIx("mBannerView");
      localObject1 = localObject2;
    }
    label284:
    for (;;)
    {
      ((View)localObject1).setOnClickListener(new WeCoinRechargeView..ExternalSyntheticLambda6(paramWeCoinRechargeView, paramadz));
      AppMethodBeat.o(316130);
      return;
    }
  }
  
  private static final void a(WeCoinRechargeView paramWeCoinRechargeView, adz paramadz, View paramView)
  {
    AppMethodBeat.i(316161);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramWeCoinRechargeView);
    localb.cH(paramadz);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    kotlin.g.b.s.u(paramadz, "$this_apply");
    if (paramWeCoinRechargeView.VwT == null) {
      kotlin.g.b.s.bIx("mViewModel");
    }
    m.asf(3);
    paramView = new Intent();
    paramView.putExtra("rawUrl", paramadz.url);
    com.tencent.mm.wallet_core.ui.i.aS((Context)paramWeCoinRechargeView, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316161);
  }
  
  private static final void a(WeCoinRechargeView paramWeCoinRechargeView, gii paramgii)
  {
    AppMethodBeat.i(316132);
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    if (paramWeCoinRechargeView.VwT == null) {
      kotlin.g.b.s.bIx("mViewModel");
    }
    TextView localTextView;
    if (!m.ihv())
    {
      paramWeCoinRechargeView.ihD();
      paramgii = Boolean.FALSE;
      if (paramgii != null)
      {
        if (paramgii.booleanValue()) {
          break label107;
        }
        localTextView = paramWeCoinRechargeView.Vxe;
        paramgii = localTextView;
        if (localTextView == null)
        {
          kotlin.g.b.s.bIx("mSwitchDeviceTipsView");
          paramgii = null;
        }
        paramgii.setText((CharSequence)paramWeCoinRechargeView.getString(a.i.wecoin_switch_device_tips));
      }
    }
    for (;;)
    {
      if (paramWeCoinRechargeView.VwT == null) {
        kotlin.g.b.s.bIx("mViewModel");
      }
      m.ihw();
      AppMethodBeat.o(316132);
      return;
      label107:
      localTextView = paramWeCoinRechargeView.Vxe;
      paramgii = localTextView;
      if (localTextView == null)
      {
        kotlin.g.b.s.bIx("mSwitchDeviceTipsView");
        paramgii = null;
      }
      paramgii.setText((CharSequence)"");
    }
  }
  
  private static final void a(WeCoinRechargeView paramWeCoinRechargeView, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(316170);
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    params.a(1, paramWeCoinRechargeView.getResources().getColor(a.c.red), (CharSequence)paramWeCoinRechargeView.getString(a.i.wecoin_close_auth_confirm_wording));
    AppMethodBeat.o(316170);
  }
  
  private static final void a(WeCoinRechargeView paramWeCoinRechargeView, com.tencent.mm.ui.widget.a.j paramj)
  {
    AppMethodBeat.i(316181);
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    kotlin.g.b.s.u(paramj, "$bottomDialog");
    if (paramWeCoinRechargeView.VwT == null) {
      kotlin.g.b.s.bIx("mViewModel");
    }
    m.asf(10);
    paramj.cyW();
    AppMethodBeat.o(316181);
  }
  
  private static final void a(WeCoinRechargeView paramWeCoinRechargeView, Boolean paramBoolean)
  {
    AppMethodBeat.i(316105);
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    paramWeCoinRechargeView.H(paramBoolean);
    AppMethodBeat.o(316105);
  }
  
  private static final void a(WeCoinRechargeView paramWeCoinRechargeView, Long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(316116);
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    Log.i("MicroMsg.WeCoinRechargeView", kotlin.g.b.s.X("updateTotalBalance: [blance] ", paramLong));
    Object localObject3 = paramWeCoinRechargeView.VwV;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("mNoBalanceTipsTv");
      localObject1 = null;
    }
    ((TextView)localObject1).setVisibility(0);
    localObject3 = paramWeCoinRechargeView.VwU;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("mTotalBalanceLl");
      localObject1 = null;
    }
    ((LinearLayout)localObject1).setVisibility(8);
    long l;
    if (paramLong == null)
    {
      l = 0L;
      if (l > 0L)
      {
        paramLong = paramWeCoinRechargeView.Vxc;
        if (paramLong != null) {
          break label202;
        }
        kotlin.g.b.s.bIx("mWeCoinBalanceView");
        paramLong = null;
        label119:
        paramLong.setText((CharSequence)kotlin.g.b.s.X("", Long.valueOf(l)));
        localObject1 = paramWeCoinRechargeView.VwV;
        paramLong = (Long)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("mNoBalanceTipsTv");
          paramLong = null;
        }
        paramLong.setVisibility(8);
        paramWeCoinRechargeView = paramWeCoinRechargeView.VwU;
        if (paramWeCoinRechargeView != null) {
          break label205;
        }
        kotlin.g.b.s.bIx("mTotalBalanceLl");
        paramWeCoinRechargeView = localObject2;
      }
    }
    label202:
    label205:
    for (;;)
    {
      paramWeCoinRechargeView.setVisibility(0);
      AppMethodBeat.o(316116);
      return;
      l = paramLong.longValue();
      break;
      break label119;
    }
  }
  
  private static final void a(WeCoinRechargeView paramWeCoinRechargeView, String paramString)
  {
    AppMethodBeat.i(316120);
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    Log.i("MicroMsg.WeCoinRechargeView", kotlin.g.b.s.X("updateRightOptionMenu: [url] ", paramString));
    paramWeCoinRechargeView.removeAllOptionMenu();
    if (paramString != null)
    {
      String str = paramWeCoinRechargeView.getString(a.i.wecoin_balance_option_detail);
      kotlin.g.b.s.s(str, "getString(R.string.wecoin_balance_option_detail)");
      paramWeCoinRechargeView.addTextOptionMenu(0, str, new WeCoinRechargeView..ExternalSyntheticLambda1(paramWeCoinRechargeView, (kotlin.g.a.a)new WeCoinRechargeView.d(paramWeCoinRechargeView, paramString)), null, y.b.adES);
    }
    AppMethodBeat.o(316120);
  }
  
  private static final void a(WeCoinRechargeView paramWeCoinRechargeView, String paramString, View paramView)
  {
    AppMethodBeat.i(316166);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramWeCoinRechargeView);
    localb.cH(paramString);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    if (paramWeCoinRechargeView.VwT == null) {
      kotlin.g.b.s.bIx("mViewModel");
    }
    m.asf(5);
    paramView = new Intent();
    paramView.putExtra("rawUrl", paramString);
    paramView.putExtra("showShare", false);
    paramView.putExtra(f.s.adxf, true);
    com.tencent.mm.wallet_core.ui.i.aS((Context)paramWeCoinRechargeView.getContext(), paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316166);
  }
  
  private static final boolean a(WeCoinRechargeView paramWeCoinRechargeView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(316096);
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    if (paramWeCoinRechargeView.VwT == null) {
      kotlin.g.b.s.bIx("mViewModel");
    }
    m.asf(8);
    paramWeCoinRechargeView.finish();
    AppMethodBeat.o(316096);
    return false;
  }
  
  private static final boolean a(WeCoinRechargeView paramWeCoinRechargeView, kotlin.g.a.a parama, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(316158);
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    kotlin.g.b.s.u(parama, "$func");
    if (paramWeCoinRechargeView.VwT == null) {
      kotlin.g.b.s.bIx("mViewModel");
    }
    m.asf(1);
    com.tencent.mm.plugin.report.service.h.OAn.b(21658, new Object[] { Integer.valueOf(1) });
    parama.invoke();
    AppMethodBeat.o(316158);
    return true;
  }
  
  private static final void b(WeCoinRechargeView paramWeCoinRechargeView, View paramView)
  {
    AppMethodBeat.i(316094);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramWeCoinRechargeView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    paramWeCoinRechargeView.ihC();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316094);
  }
  
  private static final void b(WeCoinRechargeView paramWeCoinRechargeView, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(316175);
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    params.c(2, (CharSequence)paramWeCoinRechargeView.getString(a.i.wecoin_close_auth_cancel_wording));
    AppMethodBeat.o(316175);
  }
  
  private static final void b(WeCoinRechargeView paramWeCoinRechargeView, Boolean paramBoolean)
  {
    boolean bool1 = true;
    AppMethodBeat.i(316135);
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    kotlin.g.b.s.s(paramBoolean, "it");
    boolean bool2 = paramBoolean.booleanValue();
    paramBoolean = paramWeCoinRechargeView.findViewById(a.f.mSecondSeperatorId);
    LinearLayout localLinearLayout = (LinearLayout)paramWeCoinRechargeView.findViewById(a.f.wecoin_faq_close_info_test_ll);
    paramWeCoinRechargeView = (TextView)paramWeCoinRechargeView.findViewById(a.f.wecoin_faq_close_info_test_tv);
    if (!n.T("CN", com.tencent.mm.kernel.h.baE().ban().bbx("CN"), true)) {}
    while ((bool1 & bool2))
    {
      paramBoolean.setVisibility(0);
      localLinearLayout.setVisibility(0);
      paramWeCoinRechargeView.setVisibility(0);
      AppMethodBeat.o(316135);
      return;
      bool1 = false;
    }
    paramBoolean.setVisibility(8);
    localLinearLayout.setVisibility(8);
    paramWeCoinRechargeView.setVisibility(8);
    AppMethodBeat.o(316135);
  }
  
  private static final void b(WeCoinRechargeView paramWeCoinRechargeView, String paramString)
  {
    AppMethodBeat.i(316122);
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    Log.i("MicroMsg.WeCoinRechargeView", kotlin.g.b.s.X("updateFaqView: [url] ", paramString));
    if (paramString != null)
    {
      LinearLayout localLinearLayout2 = paramWeCoinRechargeView.VwX;
      LinearLayout localLinearLayout1 = localLinearLayout2;
      if (localLinearLayout2 == null)
      {
        kotlin.g.b.s.bIx("mFaqLinearLayout");
        localLinearLayout1 = null;
      }
      localLinearLayout1.setOnClickListener(new WeCoinRechargeView..ExternalSyntheticLambda7(paramWeCoinRechargeView, paramString));
    }
    AppMethodBeat.o(316122);
  }
  
  private static final void c(WeCoinRechargeView paramWeCoinRechargeView, View paramView)
  {
    AppMethodBeat.i(316148);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramWeCoinRechargeView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    if (!c.isFastClick())
    {
      if (paramWeCoinRechargeView.VwT == null) {
        kotlin.g.b.s.bIx("mViewModel");
      }
      m.asf(4);
      paramView = new com.tencent.mm.plugin.wallet.wecoin.a.h();
      paramView.VtZ = false;
      paramView.mScene = 0;
      paramView.VtR = ((com.tencent.mm.plugin.wallet.wecoin.a.i)new c(paramWeCoinRechargeView));
      ((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).a((FragmentActivity)paramWeCoinRechargeView.getContext(), paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316148);
  }
  
  private static final void c(WeCoinRechargeView paramWeCoinRechargeView, Boolean paramBoolean)
  {
    AppMethodBeat.i(316142);
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    Log.d("MicroMsg.WeCoinRechargeView", kotlin.g.b.s.X("showProgressDialog: ", paramBoolean));
    if (paramBoolean != null) {
      if (!paramBoolean.booleanValue()) {
        break label76;
      }
    }
    for (paramBoolean = w.a((Context)paramWeCoinRechargeView.getContext(), (CharSequence)paramWeCoinRechargeView.getContext().getString(a.i.loading_tips), false, 3, null);; paramBoolean = null)
    {
      paramWeCoinRechargeView.lKp = paramBoolean;
      AppMethodBeat.o(316142);
      return;
      label76:
      paramBoolean = paramWeCoinRechargeView.lKp;
      if (paramBoolean != null) {
        paramBoolean.dismiss();
      }
    }
  }
  
  private static final void d(WeCoinRechargeView paramWeCoinRechargeView, View paramView)
  {
    AppMethodBeat.i(316154);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramWeCoinRechargeView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramWeCoinRechargeView, "this$0");
    if (paramWeCoinRechargeView.VwT == null) {
      kotlin.g.b.s.bIx("mViewModel");
    }
    m.asf(7);
    paramView = new Intent((Context)paramWeCoinRechargeView.getContext(), WeCoinIncomeDetailView.class);
    paramView.putExtra("wecoin_enter_encash_business_kv_data", (Parcelable)new WecoinEncashKVData(2, "", ""));
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramWeCoinRechargeView, paramView.aYi(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView", "updateIncomeBalance$lambda-19$lambda-18", "(Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramWeCoinRechargeView.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramWeCoinRechargeView, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView", "updateIncomeBalance$lambda-19$lambda-18", "(Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316154);
  }
  
  private final void ihC()
  {
    AppMethodBeat.i(316081);
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f((Context)this, 1, true);
    localf.h((CharSequence)getString(a.i.wecoin_close_auth_notice), 17, 0);
    localf.Vtg = new WeCoinRechargeView..ExternalSyntheticLambda19(this);
    localf.agel = new WeCoinRechargeView..ExternalSyntheticLambda18(this);
    localf.uR(false);
    localf.GAC = new WeCoinRechargeView..ExternalSyntheticLambda20(this, this);
    localf.dDn();
    AppMethodBeat.o(316081);
  }
  
  private final void ihD()
  {
    AppMethodBeat.i(316086);
    Object localObject2 = this.VwT;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      localObject1 = null;
    }
    Object localObject3 = (gii)((LiveData)((m)localObject1).Vvu).getValue();
    if (localObject3 != null)
    {
      if (this.VwT == null) {
        kotlin.g.b.s.bIx("mViewModel");
      }
      m.asf(9);
      localObject1 = new com.tencent.mm.ui.widget.a.j((Context)getContext(), 2, 0);
      localObject2 = new LinearLayout((Context)getContext());
      ((LinearLayout)localObject2).setOrientation(1);
      Object localObject4 = new TextView((Context)getContext());
      ((LinearLayout)localObject2).addView((View)localObject4);
      Object localObject5 = new LinearLayout.LayoutParams(((TextView)localObject4).getLayoutParams());
      ((LinearLayout.LayoutParams)localObject5).width = -1;
      ((LinearLayout.LayoutParams)localObject5).height = -2;
      ((LinearLayout.LayoutParams)localObject5).topMargin = com.tencent.mm.cd.a.bs((Context)getContext(), a.d.Edge_5A);
      ((LinearLayout.LayoutParams)localObject5).bottomMargin = com.tencent.mm.cd.a.bs((Context)getContext(), a.d.Edge_3A);
      ((TextView)localObject4).setTextColor(getResources().getColor(a.c.black_text_color));
      ((TextView)localObject4).setTextSize(1, 17.0F);
      aw.a((Paint)((TextView)localObject4).getPaint(), 0.8F);
      ((TextView)localObject4).setText((CharSequence)((gii)localObject3).title);
      ((TextView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      localObject3 = ((gii)localObject3).aceT.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        localObject5 = new TextView((Context)getContext());
        ((LinearLayout)localObject2).addView((View)localObject5);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(((TextView)localObject5).getLayoutParams());
        localLayoutParams.width = -1;
        localLayoutParams.height = -2;
        localLayoutParams.bottomMargin = com.tencent.mm.cd.a.bs((Context)getContext(), a.d.Edge_A);
        ((TextView)localObject5).setTextColor(getResources().getColor(a.c.desc_text));
        ((TextView)localObject5).setTextSize(1, 17.0F);
        ((TextView)localObject5).setText((CharSequence)localObject4);
        ((TextView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      }
      ((com.tencent.mm.ui.widget.a.j)localObject1).setCustomView((View)localObject2);
      ((com.tencent.mm.ui.widget.a.j)localObject1).au((CharSequence)getString(a.i.wecoin_tutorial_dialog_button_wording));
      ((com.tencent.mm.ui.widget.a.j)localObject1).aFe(1);
      ((com.tencent.mm.ui.widget.a.j)localObject1).agfR = new WeCoinRechargeView..ExternalSyntheticLambda21(this, (com.tencent.mm.ui.widget.a.j)localObject1);
      ((com.tencent.mm.ui.widget.a.j)localObject1).dDn();
    }
    AppMethodBeat.o(316086);
  }
  
  public final int getLayoutId()
  {
    return a.g.activity_we_coin_recharge_ui;
  }
  
  public final void initView()
  {
    Object localObject3 = null;
    AppMethodBeat.i(316295);
    setContentViewVisibility(0);
    setActionbarColor(getResources().getColor(a.c.UN_Brand_BG_100));
    Object localObject1 = findViewById(a.f.wecoin_balance_account_ll);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.wecoin_balance_account_ll)");
    this.VwU = ((LinearLayout)localObject1);
    localObject1 = findViewById(a.f.we_coin_no_balance_tips_tv);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.we_coin_no_balance_tips_tv)");
    this.VwV = ((TextView)localObject1);
    localObject1 = findViewById(a.f.wecoin_recharge_banner_ll);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.wecoin_recharge_banner_ll)");
    this.VwW = ((View)localObject1);
    localObject1 = findViewById(a.f.we_coin_balance_tv);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.we_coin_balance_tv)");
    this.Vxc = ((TextView)localObject1);
    localObject1 = findViewById(a.f.wecoin_switch_device_tips);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.wecoin_switch_device_tips)");
    this.Vxe = ((TextView)localObject1);
    Object localObject4 = com.tencent.mm.wallet_core.ui.i.aGy(0);
    try
    {
      localObject2 = this.Vxc;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mWeCoinBalanceView");
        localObject1 = null;
      }
      ((TextView)localObject1).setTypeface(Typeface.createFromAsset(getContext().getAssets(), (String)localObject4));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        Log.e("MicroMsg.WeCoinRechargeView", "setTypeface() Exception:%s", new Object[] { localException.getMessage() });
      }
    }
    localObject1 = findViewById(a.f.wallet_balance_view);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.wallet_balance_view)");
    this.VcE = ((WcPayMoneyLoadingView)localObject1);
    localObject1 = findViewById(a.f.wallet_money_load_pb);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.wallet_money_load_pb)");
    this.KML = ((ProgressBar)localObject1);
    localObject2 = this.VcE;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mBalanceView");
      localObject1 = null;
    }
    localObject4 = this.KML;
    localObject2 = localObject4;
    if (localObject4 == null)
    {
      kotlin.g.b.s.bIx("mMoneyLoadingPb");
      localObject2 = null;
    }
    ((WcPayMoneyLoadingView)localObject1).setLoadingPb((ProgressBar)localObject2);
    localObject2 = this.VcE;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mBalanceView");
      localObject1 = null;
    }
    ((WcPayMoneyLoadingView)localObject1).setPrefixSymbol(getString(a.i.wallet_rmb_symbol));
    localObject4 = getLifecycle();
    localObject2 = this.VcE;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mBalanceView");
      localObject1 = null;
    }
    ((androidx.lifecycle.j)localObject4).addObserver((p)localObject1);
    localObject1 = findViewById(a.f.wecoin_detail_faq_link_ll);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.wecoin_detail_faq_link_ll)");
    this.VwX = ((LinearLayout)localObject1);
    localObject1 = findViewById(a.f.wecoin_detail_faq_link_tv);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.wecoin_detail_faq_link_tv)");
    this.VwK = ((TextView)localObject1);
    localObject2 = this.VwK;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mFaqTv");
      localObject1 = null;
    }
    aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    localObject1 = findViewById(a.f.wecoin_detail_known_tutorial_LL);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.wecoin_detail_known_tutorial_LL)");
    this.VwY = ((LinearLayout)localObject1);
    localObject1 = findViewById(a.f.wecoin_detail_known_tutorial_tv);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.wecoin_detail_known_tutorial_tv)");
    this.VwZ = ((TextView)localObject1);
    localObject2 = this.VwY;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mTutorialClickLl");
      localObject1 = null;
    }
    ((LinearLayout)localObject1).setOnClickListener(new WeCoinRechargeView..ExternalSyntheticLambda3(this));
    localObject2 = this.VwZ;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mTutorialClickTv");
      localObject1 = null;
    }
    aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    localObject1 = findViewById(a.f.wecoin_faq_close_info_test_ll);
    kotlin.g.b.s.s(localObject1, "findViewById<LinearLayou…n_faq_close_info_test_ll)");
    this.Vxa = ((LinearLayout)localObject1);
    localObject1 = findViewById(a.f.wecoin_faq_close_info_test_tv);
    kotlin.g.b.s.s(localObject1, "findViewById<TextView>(R…n_faq_close_info_test_tv)");
    this.Vxb = ((TextView)localObject1);
    localObject2 = this.Vxa;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mCloseClickLl");
      localObject1 = null;
    }
    ((LinearLayout)localObject1).setOnClickListener(new WeCoinRechargeView..ExternalSyntheticLambda2(this));
    localObject2 = this.Vxb;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mCloseClickTv");
      localObject1 = null;
    }
    aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    hideActionbarLine();
    setBackBtn(new WeCoinRechargeView..ExternalSyntheticLambda0(this));
    setMMTitle("");
    localObject1 = findViewById(a.f.wecoin_recharge_btn);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.wecoin_recharge_btn)");
    this.Vxd = ((Button)localObject1);
    getWindow().getDecorView().post(new WeCoinRechargeView..ExternalSyntheticLambda22(this));
    localObject1 = this.VcE;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mBalanceView");
      localObject1 = localObject3;
      ((WcPayMoneyLoadingView)localObject1).dD("0", false);
      H(Boolean.FALSE);
      AppMethodBeat.o(316295);
      return;
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(316275);
    if (this.VwT == null) {
      kotlin.g.b.s.bIx("mViewModel");
    }
    m.asf(8);
    super.onBackPressed();
    AppMethodBeat.o(316275);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    cwm localcwm = null;
    AppMethodBeat.i(316266);
    super.onCreate(paramBundle);
    initView();
    paramBundle = ai.a((FragmentActivity)this, null).q(m.class);
    kotlin.g.b.s.s(paramBundle, "of(this).get(WeCoinRechargeViewModel::class.java)");
    this.VwT = ((m)paramBundle);
    m localm = this.VwT;
    paramBundle = localm;
    if (localm == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.Vvr).a((q)this, new WeCoinRechargeView..ExternalSyntheticLambda12(this));
    localm = this.VwT;
    paramBundle = localm;
    if (localm == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.VuQ).a((q)this, new WeCoinRechargeView..ExternalSyntheticLambda9(this));
    localm = this.VwT;
    paramBundle = localm;
    if (localm == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.Vuq).a((q)this, new WeCoinRechargeView..ExternalSyntheticLambda15(this));
    localm = this.VwT;
    paramBundle = localm;
    if (localm == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.Vvt).a((q)this, new WeCoinRechargeView..ExternalSyntheticLambda17(this));
    localm = this.VwT;
    paramBundle = localm;
    if (localm == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.Vvs).a((q)this, new WeCoinRechargeView..ExternalSyntheticLambda16(this));
    localm = this.VwT;
    paramBundle = localm;
    if (localm == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.Vup).a((q)this, new WeCoinRechargeView..ExternalSyntheticLambda8(this));
    localm = this.VwT;
    paramBundle = localm;
    if (localm == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.VuS).a((q)this, new WeCoinRechargeView..ExternalSyntheticLambda10(this));
    localm = this.VwT;
    paramBundle = localm;
    if (localm == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.Vvu).a((q)this, new WeCoinRechargeView..ExternalSyntheticLambda11(this));
    localm = this.VwT;
    paramBundle = localm;
    if (localm == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.Vvw).a((q)this, new WeCoinRechargeView..ExternalSyntheticLambda13(this));
    localm = this.VwT;
    paramBundle = localm;
    if (localm == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.wIq).a((q)this, new WeCoinRechargeView..ExternalSyntheticLambda14(this));
    paramBundle = this.VwT;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = localcwm;
    }
    for (;;)
    {
      localcwm = c.ihG();
      if (localcwm != null)
      {
        Log.i("MicroMsg.WeCoinRechargeViewModel", "load wecoin page info snapshot");
        c.d("MicroMsg.WeCoinRechargeViewModel", (com.tencent.mm.bx.a)localcwm);
        paramBundle.VuQ.t(new com.tencent.mm.plugin.wallet.wecoin.model.f(localcwm.aaBD, localcwm.aarR));
        paramBundle.Vuq.t(Long.valueOf(localcwm.ZoU));
        paramBundle.Vvs.t(localcwm.aatC);
        paramBundle.Vvt.t(localcwm.aaBC);
        paramBundle.Vvu.t(localcwm.aaBE);
        paramBundle.VuS.t(localcwm.aatD);
        paramBundle.Vvv = localcwm;
        paramBundle.Vvw.t(Boolean.valueOf(((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).ihl()));
      }
      AppMethodBeat.o(316266);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(316281);
    super.onDestroy();
    m localm = this.VwT;
    Object localObject = localm;
    if (localm == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      localObject = null;
    }
    localObject = ((m)localObject).Vvv;
    if (localObject != null)
    {
      kotlin.g.b.s.u(localObject, "response");
      Log.d("MicroMsg.WeCoinUtils", "save WecoinPageInfoResponse snapshot");
      com.tencent.mm.ae.d.B((kotlin.g.a.a)new c.b((cwm)localObject));
    }
    AppMethodBeat.o(316281);
  }
  
  public final void onResume()
  {
    Object localObject2 = null;
    AppMethodBeat.i(316269);
    super.onResume();
    if (this.VwT == null) {
      kotlin.g.b.s.bIx("mViewModel");
    }
    m.ihv();
    Object localObject1 = this.VwT;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      localObject1 = null;
      Context localContext = (Context)this;
      kotlin.g.b.s.u(localContext, "activity");
      localObject1 = new m.b((m)localObject1);
      l.a locala = l.Vvd;
      l.iht().b(localContext, (com.tencent.mm.plugin.wallet.wecoin.a.i)localObject1);
      localObject1 = this.VwT;
      if (localObject1 != null) {
        break label118;
      }
      kotlin.g.b.s.bIx("mViewModel");
      localObject1 = localObject2;
    }
    label118:
    for (;;)
    {
      ((m)localObject1).f((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(316269);
      return;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "hasBalance", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, kotlin.ah>
  {
    b(WeCoinRechargeView paramWeCoinRechargeView1, WeCoinRechargeView paramWeCoinRechargeView2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$showGridBottomSheet$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "Ljava/lang/Void;", "onFailed", "", "errorType", "", "errorCode", "errorMsg", "", "onSuccess", "data", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.wallet.wecoin.a.i<Void>
  {
    c(WeCoinRechargeView paramWeCoinRechargeView) {}
    
    public final void s(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(316061);
      m localm = WeCoinRechargeView.b(this.Vxf);
      paramString = localm;
      if (localm == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        paramString = null;
      }
      paramString.ihx();
      AppMethodBeat.o(316061);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinRechargeView
 * JD-Core Version:    0.7.0.1
 */