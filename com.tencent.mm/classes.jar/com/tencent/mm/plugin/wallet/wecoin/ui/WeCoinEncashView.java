package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.wecoin.c.c;
import com.tencent.mm.plugin.wallet.wecoin.model.WeCoinEncashViewModel;
import com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.dek;
import com.tencent.mm.protocal.protobuf.fbz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView;", "Lcom/tencent/mm/wallet_core/ui/WalletBaseUI;", "()V", "autoShowWxKbRunnable", "Ljava/lang/Runnable;", "hintTextColor", "", "inputValid", "", "mEncashTitleTV", "Landroid/widget/TextView;", "mInputMoneyText", "Lcom/tencent/mm/wallet_core/ui/formview/WalletFormView;", "mTotalBalanceWithdrawTip", "mViewModel", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinEncashViewModel;", "mWxKbInterceptState", "mainContent", "Landroid/view/ViewGroup;", "originHintWording", "", "rootView", "Landroid/widget/ScrollView;", "state", "bindData", "", "checkSetSaveFetchButtonEnable", "enable", "getLayoutId", "gotoWeCoinFetchResultUI", "info", "Lcom/tencent/mm/protocal/protobuf/EncashResultPageInfo;", "handleInterceptWinInfo", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "initKVData", "initKeyBoardView", "initView", "isHandleAutoShowNormalStWcKb", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCheckPwdSucceeded", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDialogDismiss", "dialog", "Landroid/app/Dialog;", "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepareEncashRequest", "amount", "", "removeWxKbRunnables", "scrollTop", "setupViews", "showDialog", "show", "(Ljava/lang/Boolean;)V", "showErrorMsg", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "startCheckPwdUI", "params", "Lcom/tencent/mm/protocal/protobuf/WxPayUserTokenParams;", "updateTipsText", "money", "updateView", "Companion", "plugin-wxpay_release"})
public class WeCoinEncashView
  extends WalletBaseUI
{
  public static final WeCoinEncashView.a HOP;
  private ViewGroup HAO;
  private ScrollView HBm;
  private CharSequence HBr;
  private boolean HBz;
  private TextView HOL;
  private WalletFormView HOM;
  private TextView HON;
  private WeCoinEncashViewModel HOO;
  private boolean HvA;
  private final Runnable jVx;
  private int state;
  private int wfU;
  
  static
  {
    AppMethodBeat.i(212826);
    HOP = new WeCoinEncashView.a((byte)0);
    AppMethodBeat.o(212826);
  }
  
  public WeCoinEncashView()
  {
    AppMethodBeat.i(212825);
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    this.wfU = localContext.getResources().getColor(2131099748);
    this.jVx = ((Runnable)new b(this));
    AppMethodBeat.o(212825);
  }
  
  private final void xP(boolean paramBoolean)
  {
    AppMethodBeat.i(212823);
    Log.i("MicroMsg.WeCoinEncashView", "check enable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((!paramBoolean) || (!this.HBz))
    {
      this.mWcKeyboard.DH(false);
      AppMethodBeat.o(212823);
      return;
    }
    this.mWcKeyboard.DH(true);
    AppMethodBeat.o(212823);
  }
  
  public int getLayoutId()
  {
    return 2131492965;
  }
  
  public void initView()
  {
    AppMethodBeat.i(212821);
    setBackBtn((MenuItem.OnMenuItemClickListener)new j(this));
    setActionbarColor(getResources().getColor(2131100898));
    hideActionbarLine();
    Object localObject1 = findViewById(2131302681);
    p.g(localObject1, "findViewById(R.id.input_money_wv)");
    this.HOM = ((WalletFormView)localObject1);
    localObject1 = findViewById(2131300119);
    p.g(localObject1, "findViewById(R.id.encash_money_title_tv)");
    this.HOL = ((TextView)localObject1);
    localObject1 = findViewById(2131304321);
    p.g(localObject1, "findViewById(R.id.main_content)");
    this.HAO = ((ViewGroup)localObject1);
    localObject1 = findViewById(2131309361);
    p.g(localObject1, "findViewById(R.id.total_balance_hint)");
    this.HON = ((TextView)localObject1);
    localObject1 = findViewById(2131303992);
    p.g(localObject1, "findViewById(R.id.lqt_root_view)");
    this.HBm = ((ScrollView)localObject1);
    localObject1 = this.HOM;
    if (localObject1 == null) {
      p.btv("mInputMoneyText");
    }
    localObject1 = ((WalletFormView)localObject1).getTitleTv();
    p.g(localObject1, "mInputMoneyText.titleTv");
    ((TextView)localObject1).setText((CharSequence)ah.hhA());
    localObject1 = this.HON;
    if (localObject1 == null) {
      p.btv("mTotalBalanceWithdrawTip");
    }
    ((TextView)localObject1).setText((CharSequence)"");
    localObject1 = this.HON;
    if (localObject1 == null) {
      p.btv("mTotalBalanceWithdrawTip");
    }
    ((TextView)localObject1).setClickable(true);
    localObject1 = this.HON;
    if (localObject1 == null) {
      p.btv("mTotalBalanceWithdrawTip");
    }
    ((TextView)localObject1).setOnTouchListener((View.OnTouchListener)new o((Context)this));
    localObject1 = (TextView)findViewById(2131303907);
    p.g(localObject1, "cftText");
    ao.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    setMMTitle(2131767447);
    this.state = 1;
    this.mWcKeyboard = ((WcPayKeyboard)findViewById(2131310544));
    localObject1 = this.mWcKeyboard;
    p.g(localObject1, "mWcKeyboard");
    localObject1 = ((WcPayKeyboard)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(212821);
      throw ((Throwable)localObject1);
    }
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    Object localObject2 = this.mWcKeyboard;
    p.g(localObject2, "mWcKeyboard");
    ((WcPayKeyboard)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.HOM;
    if (localObject1 == null) {
      p.btv("mInputMoneyText");
    }
    setWPKeyboard(((WalletFormView)localObject1).getContentEt(), false, false);
    this.mWcKeyboard.setActionText(getString(2131767447));
    if (d.oF(27))
    {
      localObject1 = this.HOM;
      if (localObject1 == null) {
        p.btv("mInputMoneyText");
      }
      ((WalletFormView)localObject1).hic();
    }
    localObject1 = this.HAO;
    if (localObject1 == null) {
      p.btv("mainContent");
    }
    ((ViewGroup)localObject1).setOnTouchListener((View.OnTouchListener)new i(this));
    xP(false);
    localObject1 = this.HOM;
    if (localObject1 == null) {
      p.btv("mInputMoneyText");
    }
    ((WalletFormView)localObject1).a((TextWatcher)new l(this));
    setTenpayKBStateListener((com.tencent.mm.wallet_core.ui.a)new m(this));
    localObject1 = (View.OnClickListener)new o(this);
    localObject2 = this.HOM;
    if (localObject2 == null) {
      p.btv("mInputMoneyText");
    }
    ((WalletFormView)localObject2).getContentEt().setOnEditorActionListener((TextView.OnEditorActionListener)new WeCoinEncashView.n((View.OnClickListener)localObject1));
    final long l = getIntent().getLongExtra("wecoin_income_balance", 0L);
    if (l > 0L)
    {
      localObject1 = getString(2131768690, new Object[] { Double.valueOf(c.lo(String.valueOf(l), "100")) });
      p.g(localObject1, "getString(R.string.wecoi…igDecimal.ROUND_CEILING))");
      int i = ((String)localObject1).length();
      localObject1 = new SpannableString((CharSequence)((String)localObject1 + " " + getString(2131768691)));
      ((SpannableString)localObject1).setSpan(new e((e.a)new p(this, l)), i, ((SpannableString)localObject1).length(), 18);
      this.HBr = ((CharSequence)localObject1);
      localObject2 = this.HON;
      if (localObject2 == null) {
        p.btv("mTotalBalanceWithdrawTip");
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    AppMethodBeat.o(212821);
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(212824);
    boolean bool = this.HvA;
    WcPayKeyboard localWcPayKeyboard = this.mWcKeyboard;
    p.g(localWcPayKeyboard, "mWcKeyboard");
    Log.d("MicroMsg.WeCoinEncashView", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localWcPayKeyboard.hgR()) });
    if (!this.HvA)
    {
      localWcPayKeyboard = this.mWcKeyboard;
      p.g(localWcPayKeyboard, "mWcKeyboard");
      if (localWcPayKeyboard.hgR())
      {
        AppMethodBeat.o(212824);
        return true;
      }
    }
    AppMethodBeat.o(212824);
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(212820);
    Log.i("MicroMsg.WeCoinEncashView", "onActivityResult() requestCode:%s, resultCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 3001)
    {
      AppMethodBeat.o(212820);
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
        h.CyF.dN(1581, 95);
        localObject = this.HOO;
        if (localObject == null) {
          p.btv("mViewModel");
        }
        ((WeCoinEncashViewModel)localObject).a(paramIntent, (com.tencent.mm.vending.e.b)this);
        AppMethodBeat.o(212820);
        return;
        paramIntent = null;
        break;
      }
      label151:
      paramIntent = this.HOO;
      if (paramIntent == null) {
        p.btv("mViewModel");
      }
      paramIntent.aeH(5);
      h.CyF.dN(1581, 94);
      AppMethodBeat.o(212820);
      return;
    }
    if (paramInt2 == 0)
    {
      paramIntent = this.HOO;
      if (paramIntent == null) {
        p.btv("mViewModel");
      }
      paramIntent.aeH(5);
      h.CyF.dN(1581, 94);
    }
    AppMethodBeat.o(212820);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212815);
    super.onCreate(paramBundle);
    initView();
    paramBundle = ViewModelProviders.of((FragmentActivity)this).get(WeCoinEncashViewModel.class);
    p.g(paramBundle, "ViewModelProviders.of(th…ashViewModel::class.java)");
    this.HOO = ((WeCoinEncashViewModel)paramBundle);
    paramBundle = this.HOO;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HNi).observe((LifecycleOwner)this, (Observer)new c(this));
    paramBundle = this.HOO;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HMQ).observe((LifecycleOwner)this, (Observer)new d(this));
    paramBundle = this.HOO;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HNj).observe((LifecycleOwner)this, (Observer)new e(this));
    paramBundle = this.HOO;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.HMS).observe((LifecycleOwner)this, (Observer)new f(this));
    paramBundle = this.HOO;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.qiR).observe((LifecycleOwner)this, (Observer)new g(this));
    paramBundle = this.HOO;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    paramBundle.HNm = ((WecoinEncashKVData)getIntent().getParcelableExtra("wecoin_enter_encash_business_kv_data"));
    AppMethodBeat.o(212815);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(212818);
    super.onDestroy();
    MMHandlerThread.removeRunnable(this.jVx);
    AppMethodBeat.o(212818);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(212822);
    Log.i("MicroMsg.WeCoinEncashView", "onDialogDismiss()");
    if ((this.state == 2) && (isHandleAutoShowNormalStWcKb())) {
      MMHandlerThread.postToMainThreadDelayed(this.jVx, 300L);
    }
    AppMethodBeat.o(212822);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(212819);
    p.h(paramKeyEvent, "event");
    if ((this.mWcKeyboard != null) && (this.mWcKeyboard.onKeyUp(paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(212819);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(212819);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(212817);
    super.onPause();
    Log.i("MicroMsg.WeCoinEncashView", "onPause()");
    WcPayKeyboard localWcPayKeyboard = this.mWcKeyboard;
    p.g(localWcPayKeyboard, "mWcKeyboard");
    if (!localWcPayKeyboard.hgQ()) {
      this.state = 3;
    }
    AppMethodBeat.o(212817);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(212816);
    super.onResume();
    Log.i("MicroMsg.WeCoinEncashView", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      MMHandlerThread.postToMainThreadDelayed(this.jVx, 300L);
    }
    this.state = 2;
    AppMethodBeat.o(212816);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(WeCoinEncashView paramWeCoinEncashView) {}
    
    public final void run()
    {
      AppMethodBeat.i(212798);
      this.HOQ.showNormalStWcKb();
      AppMethodBeat.o(212798);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/WxPayUserTokenParams;", "onChanged"})
  static final class c<T>
    implements Observer<fbz>
  {
    c(WeCoinEncashView paramWeCoinEncashView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "onChanged"})
  static final class d<T>
    implements Observer<com.tencent.mm.plugin.wallet.wecoin.model.a>
  {
    d(WeCoinEncashView paramWeCoinEncashView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/EncashResultPageInfo;", "onChanged"})
  static final class e<T>
    implements Observer<ajj>
  {
    e(WeCoinEncashView paramWeCoinEncashView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "onChanged"})
  static final class f<T>
    implements Observer<dek>
  {
    f(WeCoinEncashView paramWeCoinEncashView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onChanged", "(Ljava/lang/Boolean;)V"})
  static final class g<T>
    implements Observer<Boolean>
  {
    g(WeCoinEncashView paramWeCoinEncashView) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$handleInterceptWinInfo$1$clickListener$1", "Lcom/tencent/mm/plugin/wallet/wecoin/model/InterceptWinClickListener;", "onClick", "", "item", "Lcom/tencent/mm/protocal/protobuf/PopUpJumpInfo;", "plugin-wxpay_release"})
  public static final class h
    implements com.tencent.mm.plugin.wallet.wecoin.model.b
  {
    h(fbz paramfbz, WeCoinEncashView paramWeCoinEncashView, dek paramdek) {}
    
    public final void a(ddc paramddc)
    {
      AppMethodBeat.i(212804);
      if (paramddc != null)
      {
        if (paramddc.action == 3) {
          WeCoinEncashView.a(this.HOQ, this.HOR);
        }
        AppMethodBeat.o(212804);
        return;
      }
      AppMethodBeat.o(212804);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class i
    implements View.OnTouchListener
  {
    i(WeCoinEncashView paramWeCoinEncashView) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(212805);
      paramView = WeCoinEncashView.d(this.HOQ);
      p.g(paramView, "mWcKeyboard");
      if (paramView.isShown())
      {
        paramView = WeCoinEncashView.d(this.HOQ);
        p.g(paramView, "mWcKeyboard");
        if (paramView.hgP())
        {
          WeCoinEncashView.d(this.HOQ).hgN();
          AppMethodBeat.o(212805);
          return true;
        }
      }
      AppMethodBeat.o(212805);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class j
    implements MenuItem.OnMenuItemClickListener
  {
    j(WeCoinEncashView paramWeCoinEncashView) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(212806);
      WeCoinEncashView.a(this.HOQ).aeH(20);
      WeCoinEncashView.b(this.HOQ);
      if (WeCoinEncashView.c(this.HOQ))
      {
        this.HOQ.hideVKB();
        this.HOQ.showDialog(1000);
      }
      for (;;)
      {
        AppMethodBeat.o(212806);
        return true;
        this.HOQ.finish();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(WeCoinEncashView paramWeCoinEncashView) {}
    
    public final void run()
    {
      AppMethodBeat.i(212807);
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      WeCoinEncashView.h(this.HOQ).getLocationInWindow(arrayOfInt1);
      WeCoinEncashView.g(this.HOQ).getLocationInWindow(arrayOfInt2);
      Log.d("MicroMsg.WeCoinEncashView", "scroll y: %s", new Object[] { Integer.valueOf(arrayOfInt1[1] - arrayOfInt2[1]) });
      WeCoinEncashView.g(this.HOQ).scrollBy(0, arrayOfInt1[1] - arrayOfInt2[1]);
      AppMethodBeat.o(212807);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$setupViews$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-wxpay_release"})
  public static final class l
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(212810);
      p.h(paramEditable, "s");
      String str = paramEditable.toString();
      int i;
      int j;
      if (n.J(str, ".", false))
      {
        paramEditable.insert(0, (CharSequence)"0");
        str = paramEditable.toString();
        i = n.a((CharSequence)str, ".", 0, false, 6);
        j = str.length();
        if ((i < 0) || (j - i <= 3)) {
          break label141;
        }
        WalletFormView.a(WeCoinEncashView.e(this.HOQ).getContentEt(), str, i + 3, j);
      }
      for (;;)
      {
        paramEditable = paramEditable.toString();
        WeCoinEncashView.a(this.HOQ, paramEditable);
        AppMethodBeat.o(212810);
        return;
        if (!WalletFormView.a(str, WeCoinEncashView.e(this.HOQ).getContentEt())) {
          break;
        }
        AppMethodBeat.o(212810);
        return;
        label141:
        if (i > 12) {
          WalletFormView.a(WeCoinEncashView.e(this.HOQ).getContentEt(), str, 12, i);
        } else if ((i == -1) && (j > 12)) {
          WalletFormView.a(WeCoinEncashView.e(this.HOQ).getContentEt(), str, 12, j);
        }
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(212808);
      p.h(paramCharSequence, "s");
      AppMethodBeat.o(212808);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(212809);
      p.h(paramCharSequence, "s");
      AppMethodBeat.o(212809);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "visitable", "", "onVisibleStateChange"})
  static final class m
    implements com.tencent.mm.wallet_core.ui.a
  {
    m(WeCoinEncashView paramWeCoinEncashView) {}
    
    public final void onVisibleStateChange(boolean paramBoolean)
    {
      AppMethodBeat.i(212811);
      if (paramBoolean)
      {
        WeCoinEncashView.f(this.HOQ);
        AppMethodBeat.o(212811);
        return;
      }
      WeCoinEncashView.g(this.HOQ).scrollTo(0, 0);
      AppMethodBeat.o(212811);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class o
    implements View.OnClickListener
  {
    o(WeCoinEncashView paramWeCoinEncashView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212813);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$setupViews$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (c.isFastClick())
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$setupViews$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212813);
        return;
      }
      paramView = WeCoinEncashView.e(this.HOQ).getText();
      p.g(paramView, "mInputMoneyText.text");
      int i = c.lp(paramView, "100");
      if (i > 0)
      {
        WeCoinEncashView.a(this.HOQ).aeH(6);
        this.HOQ.hideWcKb();
        Log.i("MicroMsg.WeCoinEncashView", "click encash to cft");
        WeCoinEncashView.a(this.HOQ, i);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$setupViews$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212813);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements e.a
  {
    p(WeCoinEncashView paramWeCoinEncashView, long paramLong) {}
    
    public final void bmr()
    {
      AppMethodBeat.i(212814);
      WeCoinEncashView.a(this.HOQ).aeH(4);
      WeCoinEncashView.e(this.HOQ).setText(f.formatMoney2f(c.lo(String.valueOf(l), "100")));
      WeCoinEncashView.e(this.HOQ).getContentEt().requestFocus();
      this.HOQ.showWcKb();
      AppMethodBeat.o(212814);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinEncashView
 * JD-Core Version:    0.7.0.1
 */