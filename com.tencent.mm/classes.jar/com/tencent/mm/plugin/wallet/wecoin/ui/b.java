package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinCustomAmountInputDialog;", "", "context", "Landroid/content/Context;", "parameter", "Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinCustomAmountInputDialogParameter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinCustomAmountInputDialogParameter;)V", "coinAmount", "Lcom/tencent/mm/wallet_core/ui/WalletTextView;", "confirmButton", "Landroid/widget/Button;", "getContext", "()Landroid/content/Context;", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "inputArea", "Lcom/tencent/mm/wallet_core/ui/formview/WalletFormView;", "inputTips", "Landroid/widget/TextView;", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "getParameter", "()Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinCustomAmountInputDialogParameter;", "animHideKeyboard", "", "animShowKeyboard", "height", "", "bindAction", "customView", "Landroid/view/View;", "hide", "initCustomView", "layoutAlwaysDark", "show", "updateTipsText", "money", "", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a Vwe;
  private final d Vwf;
  private Button Vwg;
  private WalletTextView Vwh;
  private WalletFormView Vwi;
  private TextView Vwj;
  private final Context context;
  private final j lCH;
  private final i lKz;
  
  static
  {
    AppMethodBeat.i(316011);
    Vwe = new b.a((byte)0);
    AppMethodBeat.o(316011);
  }
  
  public b(Context paramContext, d paramd)
  {
    AppMethodBeat.i(315965);
    this.context = paramContext;
    this.Vwf = paramd;
    this.lCH = new j(this.context, 0, 0, this.Vwf.Vwm, (byte)0);
    j localj = this.lCH;
    View localView = View.inflate(this.context, a.g.wallet_coin_custom_amount_input_layout, null);
    paramContext = localView.findViewById(a.f.wecoin_recharge_btn);
    s.s(paramContext, "result.findViewById(R.id.wecoin_recharge_btn)");
    this.Vwg = ((Button)paramContext);
    paramContext = localView.findViewById(a.f.coin_amount);
    s.s(paramContext, "result.findViewById(R.id.coin_amount)");
    this.Vwh = ((WalletTextView)paramContext);
    paramContext = localView.findViewById(a.f.input_area);
    s.s(paramContext, "result.findViewById(R.id.input_area)");
    this.Vwi = ((WalletFormView)paramContext);
    paramContext = localView.findViewById(a.f.input_tips);
    s.s(paramContext, "result.findViewById(R.id.input_tips)");
    this.Vwj = ((TextView)paramContext);
    paramd = this.Vwi;
    paramContext = paramd;
    if (paramd == null)
    {
      s.bIx("inputArea");
      paramContext = null;
    }
    paramContext.setmContentAbnormalMoneyCheck(true);
    paramd = this.Vwg;
    paramContext = paramd;
    if (paramd == null)
    {
      s.bIx("confirmButton");
      paramContext = null;
    }
    paramContext.setEnabled(false);
    s.s(localView, "result");
    if (this.Vwf.Vwm)
    {
      int i = this.context.getResources().getColor(a.c.BW_100_Alpha_0_8);
      int j = this.context.getResources().getColor(a.c.BW_100_Alpha_0_3);
      ((WeImageView)localView.findViewById(a.f.back_btn)).setIconColor(i);
      ((TextView)localView.findViewById(a.f.title)).setTextColor(i);
      ((TextView)localView.findViewById(a.f.exchange_text_view)).setTextColor(j);
      ((WeImageView)localView.findViewById(a.f.wecoin_icon)).setIconColor(j);
      ((WalletTextView)localView.findViewById(a.f.wallet_title)).setTextColor(i);
      ((LinearLayout)localView.findViewById(a.f.money_et_layout)).setBackgroundResource(a.e.wccoin_round_corner_bg_dark);
      paramd = this.Vwi;
      paramContext = paramd;
      if (paramd == null)
      {
        s.bIx("inputArea");
        paramContext = null;
      }
      paramContext.setContentTextColor(i);
      paramd = this.Vwh;
      paramContext = paramd;
      if (paramd == null)
      {
        s.bIx("coinAmount");
        paramContext = null;
      }
      paramContext.setTextColor(j);
      paramd = this.Vwg;
      paramContext = paramd;
      if (paramd == null)
      {
        s.bIx("confirmButton");
        paramContext = null;
      }
      paramContext.setTextColor(this.context.getResources().getColor(a.c.color_btn_alwaydark_text_selector));
      paramd = this.Vwg;
      paramContext = paramd;
      if (paramd == null)
      {
        s.bIx("confirmButton");
        paramContext = null;
      }
      paramContext.setBackgroundResource(a.e.btn_solid_green_dark);
    }
    ((WeImageView)localView.findViewById(a.f.back_btn)).setOnClickListener(new b..ExternalSyntheticLambda2(this));
    paramContext = this.Vwi;
    if (paramContext == null)
    {
      s.bIx("inputArea");
      paramContext = null;
      paramContext.a((TextWatcher)new b.d(this));
      paramContext = this.Vwg;
      if (paramContext != null) {
        break label607;
      }
      s.bIx("confirmButton");
      paramContext = localObject;
    }
    label607:
    for (;;)
    {
      paramContext.setOnClickListener(new b..ExternalSyntheticLambda3(this));
      localj.F(localView, 0, 0);
      this.lCH.jHS();
      paramContext = new i((Activity)this.context);
      paramContext.afIL = new b..ExternalSyntheticLambda4(this);
      paramd = ah.aiuX;
      this.lKz = paramContext;
      AppMethodBeat.o(315965);
      return;
      break;
    }
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(315979);
    s.u(paramb, "this$0");
    WalletFormView localWalletFormView = paramb.Vwi;
    paramb = localWalletFormView;
    if (localWalletFormView == null)
    {
      s.bIx("inputArea");
      paramb = null;
    }
    paramb.jPE();
    AppMethodBeat.o(315979);
  }
  
  private static final void a(b paramb, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(315977);
    s.u(paramb, "this$0");
    Log.i("WeCoinCustomAmountInputDialog", "KeyboardHeightObserver " + paramInt + ' ' + paramBoolean);
    Object localObject;
    if (paramInt > 0)
    {
      localObject = paramb.lCH;
      if (((j)localObject).isShowing())
      {
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, paramInt });
        localValueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
        localValueAnimator.addUpdateListener(new b..ExternalSyntheticLambda0(paramb, (j)localObject));
        localValueAnimator.addListener((Animator.AnimatorListener)new b.c((j)localObject));
        localValueAnimator.setDuration(200L);
        localValueAnimator.start();
      }
      AppMethodBeat.o(315977);
      return;
    }
    paramb = paramb.lCH;
    if (paramb.isShowing())
    {
      localObject = ValueAnimator.ofInt(new int[] { paramb.rootView.getPaddingBottom(), 0 });
      ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ((ValueAnimator)localObject).addUpdateListener(new b..ExternalSyntheticLambda1(paramb));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new b.b(paramb));
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).start();
    }
    AppMethodBeat.o(315977);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(315986);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinCustomAmountInputDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.hide();
    a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinCustomAmountInputDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(315986);
  }
  
  private static final void a(b paramb, j paramj, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(315994);
    s.u(paramb, "this$0");
    s.u(paramj, "$it");
    if ((!w.mO(paramb.context)) && (!aw.jlb()) && (com.tencent.mm.compatible.util.d.rc(30)))
    {
      paramb = paramj.rootView;
      paramj = paramValueAnimator.getAnimatedValue();
      if (paramj == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(315994);
        throw paramb;
      }
      paramb.setPadding(0, 0, 0, ((Integer)paramj).intValue());
    }
    AppMethodBeat.o(315994);
  }
  
  private static final void b(b paramb, View paramView)
  {
    AppMethodBeat.i(315990);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinCustomAmountInputDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.hide();
    localObject = paramb.Vwi;
    paramView = (View)localObject;
    if (localObject == null)
    {
      s.bIx("inputArea");
      paramView = null;
    }
    paramView = paramView.getText();
    s.s(paramView, "inputArea.text");
    int i = com.tencent.mm.plugin.wallet.wecoin.utils.c.ny(paramView, "10");
    paramb.Vwf.Vwn.xy(i);
    a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinCustomAmountInputDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(315990);
  }
  
  private static final void b(j paramj, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(315999);
    s.u(paramj, "$it");
    paramj = paramj.rootView;
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramj = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(315999);
      throw paramj;
    }
    paramj.setPadding(0, 0, 0, ((Integer)paramValueAnimator).intValue());
    AppMethodBeat.o(315999);
  }
  
  private void hide()
  {
    AppMethodBeat.i(315970);
    WalletFormView localWalletFormView = this.Vwi;
    if (localWalletFormView == null)
    {
      s.bIx("inputArea");
      localWalletFormView = null;
    }
    for (;;)
    {
      if (localWalletFormView.agVJ != null)
      {
        localWalletFormView.agVJ.clearFocus();
        ((InputMethodManager)localWalletFormView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(localWalletFormView.agVJ.getWindowToken(), 0);
      }
      this.lKz.close();
      this.lCH.cyW();
      AppMethodBeat.o(315970);
      return;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(316043);
    this.lKz.start();
    this.lCH.dDn();
    WalletFormView localWalletFormView2 = this.Vwi;
    WalletFormView localWalletFormView1 = localWalletFormView2;
    if (localWalletFormView2 == null)
    {
      s.bIx("inputArea");
      localWalletFormView1 = null;
    }
    localWalletFormView1.post(new b..ExternalSyntheticLambda5(this));
    AppMethodBeat.o(316043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.b
 * JD-Core Version:    0.7.0.1
 */