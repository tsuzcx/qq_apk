package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.s;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.wallet.wecoin.c.c;
import com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.akk;
import com.tencent.mm.protocal.protobuf.dms;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.fmw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ar;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.g;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView;", "Lcom/tencent/mm/wallet_core/ui/WalletBaseUI;", "()V", "autoShowWxKbRunnable", "Ljava/lang/Runnable;", "hintTextColor", "", "inputValid", "", "mEncashTitleTV", "Landroid/widget/TextView;", "mInputMoneyText", "Lcom/tencent/mm/wallet_core/ui/formview/WalletFormView;", "mTotalBalanceWithdrawTip", "mViewModel", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinEncashViewModel;", "mWxKbInterceptState", "mainContent", "Landroid/view/ViewGroup;", "originHintWording", "", "rootView", "Landroid/widget/ScrollView;", "state", "bindData", "", "checkSetSaveFetchButtonEnable", "enable", "getLayoutId", "gotoWeCoinFetchResultUI", "info", "Lcom/tencent/mm/protocal/protobuf/EncashResultPageInfo;", "handleInterceptWinInfo", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "initKVData", "initKeyBoardView", "initView", "isHandleAutoShowNormalStWcKb", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCheckPwdSucceeded", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDialogDismiss", "dialog", "Landroid/app/Dialog;", "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepareEncashRequest", "amount", "", "removeWxKbRunnables", "scrollTop", "setupViews", "showDialog", "show", "(Ljava/lang/Boolean;)V", "showErrorMsg", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "startCheckPwdUI", "params", "Lcom/tencent/mm/protocal/protobuf/WxPayUserTokenParams;", "updateTipsText", "money", "updateView", "Companion", "plugin-wxpay_release"})
public class WeCoinEncashView
  extends WalletBaseUI
{
  public static final WeCoinEncashView.a OGM;
  private TextView OGI;
  private WalletFormView OGJ;
  private TextView OGK;
  private com.tencent.mm.plugin.wallet.wecoin.model.h OGL;
  private boolean Onn;
  private ViewGroup OsE;
  private ScrollView Otc;
  private CharSequence Oth;
  private boolean Otp;
  private int hintTextColor;
  private final Runnable mMK;
  private int state;
  
  static
  {
    AppMethodBeat.i(249216);
    OGM = new WeCoinEncashView.a((byte)0);
    AppMethodBeat.o(249216);
  }
  
  public WeCoinEncashView()
  {
    AppMethodBeat.i(249215);
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    this.hintTextColor = localContext.getResources().getColor(a.c.FG_1);
    this.mMK = ((Runnable)new b(this));
    AppMethodBeat.o(249215);
  }
  
  private final void BJ(boolean paramBoolean)
  {
    AppMethodBeat.i(249213);
    Log.i("MicroMsg.WeCoinEncashView", "check enable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((!paramBoolean) || (!this.Otp))
    {
      this.mWcKeyboard.Ih(false);
      AppMethodBeat.o(249213);
      return;
    }
    this.mWcKeyboard.Ih(true);
    AppMethodBeat.o(249213);
  }
  
  public int getLayoutId()
  {
    return a.g.activity_we_coin_encash_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(249211);
    setBackBtn((MenuItem.OnMenuItemClickListener)new j(this));
    setActionbarColor(getResources().getColor(a.c.normal_actionbar_color));
    hideActionbarLine();
    Object localObject1 = findViewById(a.f.input_money_wv);
    p.j(localObject1, "findViewById(R.id.input_money_wv)");
    this.OGJ = ((WalletFormView)localObject1);
    localObject1 = findViewById(a.f.encash_money_title_tv);
    p.j(localObject1, "findViewById(R.id.encash_money_title_tv)");
    this.OGI = ((TextView)localObject1);
    localObject1 = findViewById(a.f.main_content);
    p.j(localObject1, "findViewById(R.id.main_content)");
    this.OsE = ((ViewGroup)localObject1);
    localObject1 = findViewById(a.f.total_balance_hint);
    p.j(localObject1, "findViewById(R.id.total_balance_hint)");
    this.OGK = ((TextView)localObject1);
    localObject1 = findViewById(a.f.lqt_root_view);
    p.j(localObject1, "findViewById(R.id.lqt_root_view)");
    this.Otc = ((ScrollView)localObject1);
    localObject1 = this.OGJ;
    if (localObject1 == null) {
      p.bGy("mInputMoneyText");
    }
    localObject1 = ((WalletFormView)localObject1).getTitleTv();
    p.j(localObject1, "mInputMoneyText.titleTv");
    ((TextView)localObject1).setText((CharSequence)ah.ijc());
    localObject1 = this.OGK;
    if (localObject1 == null) {
      p.bGy("mTotalBalanceWithdrawTip");
    }
    ((TextView)localObject1).setText((CharSequence)"");
    localObject1 = this.OGK;
    if (localObject1 == null) {
      p.bGy("mTotalBalanceWithdrawTip");
    }
    ((TextView)localObject1).setClickable(true);
    localObject1 = this.OGK;
    if (localObject1 == null) {
      p.bGy("mTotalBalanceWithdrawTip");
    }
    ((TextView)localObject1).setOnTouchListener((View.OnTouchListener)new o((Context)this));
    localObject1 = (TextView)findViewById(a.f.lqt_balance_bankcard);
    p.j(localObject1, "cftText");
    ar.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    setMMTitle(a.i.wallet_balance_manager_fetch);
    this.state = 1;
    this.mWcKeyboard = ((WcPayKeyboard)findViewById(a.f.wp_kb));
    localObject1 = this.mWcKeyboard;
    p.j(localObject1, "mWcKeyboard");
    localObject1 = ((WcPayKeyboard)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(249211);
      throw ((Throwable)localObject1);
    }
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    Object localObject2 = this.mWcKeyboard;
    p.j(localObject2, "mWcKeyboard");
    ((WcPayKeyboard)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.OGJ;
    if (localObject1 == null) {
      p.bGy("mInputMoneyText");
    }
    setWPKeyboard(((WalletFormView)localObject1).getContentEt(), false, false);
    this.mWcKeyboard.setActionText(getString(a.i.wallet_balance_manager_fetch));
    if (d.qX(27))
    {
      localObject1 = this.OGJ;
      if (localObject1 == null) {
        p.bGy("mInputMoneyText");
      }
      ((WalletFormView)localObject1).ijE();
    }
    localObject1 = this.OsE;
    if (localObject1 == null) {
      p.bGy("mainContent");
    }
    ((ViewGroup)localObject1).setOnTouchListener((View.OnTouchListener)new i(this));
    BJ(false);
    localObject1 = this.OGJ;
    if (localObject1 == null) {
      p.bGy("mInputMoneyText");
    }
    ((WalletFormView)localObject1).a((TextWatcher)new l(this));
    setTenpayKBStateListener((com.tencent.mm.wallet_core.ui.a)new m(this));
    localObject1 = (View.OnClickListener)new o(this);
    localObject2 = this.OGJ;
    if (localObject2 == null) {
      p.bGy("mInputMoneyText");
    }
    ((WalletFormView)localObject2).getContentEt().setOnEditorActionListener((TextView.OnEditorActionListener)new WeCoinEncashView.n((View.OnClickListener)localObject1));
    final long l = getIntent().getLongExtra("wecoin_income_balance", 0L);
    if (l > 0L)
    {
      localObject1 = getString(a.i.wecoin_income_total_fetch_balance, new Object[] { Double.valueOf(c.lL(String.valueOf(l), "100")) });
      p.j(localObject1, "getString(R.string.wecoi…igDecimal.ROUND_CEILING))");
      int i = ((String)localObject1).length();
      localObject1 = new SpannableString((CharSequence)((String)localObject1 + " " + getString(a.i.wecoin_income_total_fetch_wording)));
      ((SpannableString)localObject1).setSpan(new f((f.a)new p(this, l)), i, ((SpannableString)localObject1).length(), 18);
      this.Oth = ((CharSequence)localObject1);
      localObject2 = this.OGK;
      if (localObject2 == null) {
        p.bGy("mTotalBalanceWithdrawTip");
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    AppMethodBeat.o(249211);
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(249214);
    boolean bool = this.Onn;
    WcPayKeyboard localWcPayKeyboard = this.mWcKeyboard;
    p.j(localWcPayKeyboard, "mWcKeyboard");
    Log.d("MicroMsg.WeCoinEncashView", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localWcPayKeyboard.iit()) });
    if (!this.Onn)
    {
      localWcPayKeyboard = this.mWcKeyboard;
      p.j(localWcPayKeyboard, "mWcKeyboard");
      if (localWcPayKeyboard.iit())
      {
        AppMethodBeat.o(249214);
        return true;
      }
    }
    AppMethodBeat.o(249214);
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(249208);
    Log.i("MicroMsg.WeCoinEncashView", "onActivityResult() requestCode:%s, resultCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 3001)
    {
      AppMethodBeat.o(249208);
      return;
    }
    if (paramInt2 == -1)
    {
      Object localObject;
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("token");
        localObject = (CharSequence)paramIntent;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label146;
        }
      }
      label146:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label151;
        }
        com.tencent.mm.plugin.report.service.h.IzE.el(1581, 95);
        localObject = this.OGL;
        if (localObject == null) {
          p.bGy("mViewModel");
        }
        ((com.tencent.mm.plugin.wallet.wecoin.model.h)localObject).a(paramIntent, (com.tencent.mm.vending.e.b)this);
        AppMethodBeat.o(249208);
        return;
        paramIntent = null;
        break;
      }
      label151:
      paramIntent = this.OGL;
      if (paramIntent == null) {
        p.bGy("mViewModel");
      }
      paramIntent.amu(5);
      com.tencent.mm.plugin.report.service.h.IzE.el(1581, 94);
      AppMethodBeat.o(249208);
      return;
    }
    if (paramInt2 == 0)
    {
      paramIntent = this.OGL;
      if (paramIntent == null) {
        p.bGy("mViewModel");
      }
      paramIntent.amu(5);
      com.tencent.mm.plugin.report.service.h.IzE.el(1581, 94);
    }
    AppMethodBeat.o(249208);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(249201);
    super.onCreate(paramBundle);
    initView();
    paramBundle = z.a((FragmentActivity)this).i(com.tencent.mm.plugin.wallet.wecoin.model.h.class);
    p.j(paramBundle, "ViewModelProviders.of(th…ashViewModel::class.java)");
    this.OGL = ((com.tencent.mm.plugin.wallet.wecoin.model.h)paramBundle);
    paramBundle = this.OGL;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OFe).a((androidx.lifecycle.l)this, (s)new c(this));
    paramBundle = this.OGL;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OEM).a((androidx.lifecycle.l)this, (s)new d(this));
    paramBundle = this.OGL;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OFf).a((androidx.lifecycle.l)this, (s)new e(this));
    paramBundle = this.OGL;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.OEO).a((androidx.lifecycle.l)this, (s)new f(this));
    paramBundle = this.OGL;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.tEN).a((androidx.lifecycle.l)this, (s)new g(this));
    paramBundle = this.OGL;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    paramBundle.OFi = ((WecoinEncashKVData)getIntent().getParcelableExtra("wecoin_enter_encash_business_kv_data"));
    AppMethodBeat.o(249201);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(249204);
    super.onDestroy();
    MMHandlerThread.removeRunnable(this.mMK);
    AppMethodBeat.o(249204);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(249212);
    Log.i("MicroMsg.WeCoinEncashView", "onDialogDismiss()");
    if ((this.state == 2) && (isHandleAutoShowNormalStWcKb())) {
      MMHandlerThread.postToMainThreadDelayed(this.mMK, 300L);
    }
    AppMethodBeat.o(249212);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(249206);
    p.k(paramKeyEvent, "event");
    if ((this.mWcKeyboard != null) && (this.mWcKeyboard.onKeyUp(paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(249206);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(249206);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(249203);
    super.onPause();
    Log.i("MicroMsg.WeCoinEncashView", "onPause()");
    WcPayKeyboard localWcPayKeyboard = this.mWcKeyboard;
    p.j(localWcPayKeyboard, "mWcKeyboard");
    if (!localWcPayKeyboard.iis()) {
      this.state = 3;
    }
    AppMethodBeat.o(249203);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(249202);
    super.onResume();
    Log.i("MicroMsg.WeCoinEncashView", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      MMHandlerThread.postToMainThreadDelayed(this.mMK, 300L);
    }
    this.state = 2;
    AppMethodBeat.o(249202);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(WeCoinEncashView paramWeCoinEncashView) {}
    
    public final void run()
    {
      AppMethodBeat.i(276907);
      this.OGN.showNormalStWcKb();
      AppMethodBeat.o(276907);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/WxPayUserTokenParams;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class c<T>
    implements s<fmw>
  {
    c(WeCoinEncashView paramWeCoinEncashView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class d<T>
    implements s<com.tencent.mm.plugin.wallet.wecoin.model.a>
  {
    d(WeCoinEncashView paramWeCoinEncashView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/EncashResultPageInfo;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class e<T>
    implements s<akk>
  {
    e(WeCoinEncashView paramWeCoinEncashView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class f<T>
    implements s<doa>
  {
    f(WeCoinEncashView paramWeCoinEncashView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"})
  static final class g<T>
    implements s<Boolean>
  {
    g(WeCoinEncashView paramWeCoinEncashView) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$handleInterceptWinInfo$1$clickListener$1", "Lcom/tencent/mm/plugin/wallet/wecoin/model/InterceptWinClickListener;", "onClick", "", "item", "Lcom/tencent/mm/protocal/protobuf/PopUpJumpInfo;", "plugin-wxpay_release"})
  public static final class h
    implements com.tencent.mm.plugin.wallet.wecoin.model.b
  {
    h(fmw paramfmw, WeCoinEncashView paramWeCoinEncashView, doa paramdoa) {}
    
    public final void a(dms paramdms)
    {
      AppMethodBeat.i(269704);
      if (paramdms != null)
      {
        if (paramdms.action == 3) {
          WeCoinEncashView.a(this.OGN, this.OGO);
        }
        AppMethodBeat.o(269704);
        return;
      }
      AppMethodBeat.o(269704);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class i
    implements View.OnTouchListener
  {
    i(WeCoinEncashView paramWeCoinEncashView) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(268339);
      paramView = WeCoinEncashView.d(this.OGN);
      p.j(paramView, "mWcKeyboard");
      if (paramView.isShown())
      {
        paramView = WeCoinEncashView.d(this.OGN);
        p.j(paramView, "mWcKeyboard");
        if (paramView.iir())
        {
          WeCoinEncashView.d(this.OGN).iip();
          AppMethodBeat.o(268339);
          return true;
        }
      }
      AppMethodBeat.o(268339);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class j
    implements MenuItem.OnMenuItemClickListener
  {
    j(WeCoinEncashView paramWeCoinEncashView) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203548);
      WeCoinEncashView.a(this.OGN).amu(20);
      WeCoinEncashView.b(this.OGN);
      if (WeCoinEncashView.c(this.OGN))
      {
        this.OGN.hideVKB();
        this.OGN.showDialog(1000);
      }
      for (;;)
      {
        AppMethodBeat.o(203548);
        return true;
        this.OGN.finish();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(WeCoinEncashView paramWeCoinEncashView) {}
    
    public final void run()
    {
      AppMethodBeat.i(271935);
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      WeCoinEncashView.h(this.OGN).getLocationInWindow(arrayOfInt1);
      WeCoinEncashView.g(this.OGN).getLocationInWindow(arrayOfInt2);
      Log.d("MicroMsg.WeCoinEncashView", "scroll y: %s", new Object[] { Integer.valueOf(arrayOfInt1[1] - arrayOfInt2[1]) });
      WeCoinEncashView.g(this.OGN).scrollBy(0, arrayOfInt1[1] - arrayOfInt2[1]);
      AppMethodBeat.o(271935);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$setupViews$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-wxpay_release"})
  public static final class l
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(190948);
      p.k(paramEditable, "s");
      String str = paramEditable.toString();
      int i;
      int j;
      if (n.M(str, ".", false))
      {
        paramEditable.insert(0, (CharSequence)"0");
        str = paramEditable.toString();
        i = n.a((CharSequence)str, ".", 0, false, 6);
        j = str.length();
        if ((i < 0) || (j - i <= 3)) {
          break label141;
        }
        WalletFormView.a(WeCoinEncashView.e(this.OGN).getContentEt(), str, i + 3, j);
      }
      for (;;)
      {
        paramEditable = paramEditable.toString();
        WeCoinEncashView.a(this.OGN, paramEditable);
        AppMethodBeat.o(190948);
        return;
        if (!WalletFormView.a(str, WeCoinEncashView.e(this.OGN).getContentEt())) {
          break;
        }
        AppMethodBeat.o(190948);
        return;
        label141:
        if (i > 12) {
          WalletFormView.a(WeCoinEncashView.e(this.OGN).getContentEt(), str, 12, i);
        } else if ((i == -1) && (j > 12)) {
          WalletFormView.a(WeCoinEncashView.e(this.OGN).getContentEt(), str, 12, j);
        }
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(190940);
      p.k(paramCharSequence, "s");
      AppMethodBeat.o(190940);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(190942);
      p.k(paramCharSequence, "s");
      AppMethodBeat.o(190942);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "visitable", "", "onVisibleStateChange"})
  static final class m
    implements com.tencent.mm.wallet_core.ui.a
  {
    m(WeCoinEncashView paramWeCoinEncashView) {}
    
    public final void onVisibleStateChange(boolean paramBoolean)
    {
      AppMethodBeat.i(206979);
      if (paramBoolean)
      {
        WeCoinEncashView.f(this.OGN);
        AppMethodBeat.o(206979);
        return;
      }
      WeCoinEncashView.g(this.OGN).scrollTo(0, 0);
      AppMethodBeat.o(206979);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(WeCoinEncashView paramWeCoinEncashView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(226299);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$setupViews$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (c.isFastClick())
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$setupViews$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(226299);
        return;
      }
      paramView = WeCoinEncashView.e(this.OGN).getText();
      p.j(paramView, "mInputMoneyText.text");
      int i = c.lM(paramView, "100");
      if (i > 0)
      {
        WeCoinEncashView.a(this.OGN).amu(6);
        this.OGN.hideWcKb();
        Log.i("MicroMsg.WeCoinEncashView", "click encash to cft");
        WeCoinEncashView.a(this.OGN, i);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$setupViews$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(226299);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements f.a
  {
    p(WeCoinEncashView paramWeCoinEncashView, long paramLong) {}
    
    public final void bwz()
    {
      AppMethodBeat.i(272193);
      WeCoinEncashView.a(this.OGN).amu(4);
      WeCoinEncashView.e(this.OGN).setText(g.formatMoney2f(c.lL(String.valueOf(l), "100")));
      WeCoinEncashView.e(this.OGN).getContentEt().requestFocus();
      this.OGN.showWcKb();
      AppMethodBeat.o(272193);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinEncashView
 * JD-Core Version:    0.7.0.1
 */