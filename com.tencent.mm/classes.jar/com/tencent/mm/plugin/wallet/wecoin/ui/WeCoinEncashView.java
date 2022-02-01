package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ah.b;
import androidx.lifecycle.ai;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData;
import com.tencent.mm.plugin.wallet.wecoin.model.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.dcl;
import com.tencent.mm.protocal.protobuf.efg;
import com.tencent.mm.protocal.protobuf.egr;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.gim;
import com.tencent.mm.protocal.protobuf.gin;
import com.tencent.mm.protocal.protobuf.gjo;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.i;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView;", "Lcom/tencent/mm/wallet_core/ui/WalletBaseUI;", "()V", "autoShowWxKbRunnable", "Ljava/lang/Runnable;", "checkPwdToken", "", "cutTaxDesc", "Landroid/widget/TextView;", "cutTaxEntrace", "Landroid/view/ViewGroup;", "cutTaxTitle", "hintTextColor", "", "inputValid", "", "mEncashTitleTV", "mInputMoneyText", "Lcom/tencent/mm/wallet_core/ui/formview/WalletFormView;", "mTotalBalanceWithdrawTip", "mViewModel", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinEncashViewModel;", "mWxKbInterceptState", "mainContent", "originHintWording", "", "rootView", "Landroid/widget/ScrollView;", "state", "bindData", "", "checkSetSaveFetchButtonEnable", "enable", "getLayoutId", "gotoWeCoinFetchResultUI", "info", "Lcom/tencent/mm/protocal/protobuf/EncashResultPageInfo;", "handleInterceptWinInfo", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "initKVData", "initKeyBoardView", "initModel", "initView", "isHandleAutoShowNormalStWcKb", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCheckPwdSucceeded", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDialogDismiss", "dialog", "Landroid/app/Dialog;", "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepareEncashRequest", "businessID", "amount", "", "removeWxKbRunnables", "scrollTop", "setupViews", "showDialog", "show", "(Ljava/lang/Boolean;)V", "showErrorMsg", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "showTaxCutConfirmHalfPage", "Lcom/tencent/mm/protocal/protobuf/WecoinTaxReConfirmHalfPageInfo;", "startCheckPwdUI", "params", "Lcom/tencent/mm/protocal/protobuf/WxPayUserTokenParams;", "updateTaxCutEntrance", "Lcom/tencent/mm/protocal/protobuf/WecoinTaxCutEntranceInfo;", "updateTipsText", "money", "updateView", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public class WeCoinEncashView
  extends WalletBaseUI
{
  public static final WeCoinEncashView.a Vwo;
  private static WeakReference<e> dsH;
  private boolean Vcb;
  private ViewGroup VhJ;
  private ScrollView Vii;
  private CharSequence Vio;
  private boolean Viw;
  private TextView Vwp;
  private WalletFormView Vwq;
  private TextView Vwr;
  private g Vws;
  private ViewGroup Vwt;
  private TextView Vwu;
  private TextView Vwv;
  private String Vww;
  private int hintTextColor;
  private final Runnable pJs;
  private int state;
  
  static
  {
    AppMethodBeat.i(316119);
    Vwo = new WeCoinEncashView.a((byte)0);
    dsH = new WeakReference(null);
    AppMethodBeat.o(316119);
  }
  
  public WeCoinEncashView()
  {
    AppMethodBeat.i(315904);
    this.hintTextColor = MMApplicationContext.getContext().getResources().getColor(a.c.FG_1);
    this.pJs = new WeCoinEncashView..ExternalSyntheticLambda18(this);
    AppMethodBeat.o(315904);
  }
  
  private final void Ho(boolean paramBoolean)
  {
    AppMethodBeat.i(315934);
    Log.i("MicroMsg.WeCoinEncashView", "check enable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((!paramBoolean) || (!this.Viw))
    {
      this.mWcKeyboard.Oi(false);
      AppMethodBeat.o(315934);
      return;
    }
    this.mWcKeyboard.Oi(true);
    AppMethodBeat.o(315934);
  }
  
  private static final void a(WeCoinEncashView paramWeCoinEncashView, long paramLong, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(316028);
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    Object localObject2 = paramWeCoinEncashView.Vws;
    paramView = (View)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramView = null;
    }
    paramView.asf(4);
    localObject2 = paramWeCoinEncashView.Vwq;
    paramView = (View)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mInputMoneyText");
      paramView = null;
    }
    paramView.setText(i.formatMoney2f(com.tencent.mm.plugin.wallet.wecoin.utils.c.nx(String.valueOf(paramLong), "100")));
    paramView = paramWeCoinEncashView.Vwq;
    if (paramView == null)
    {
      kotlin.g.b.s.bIx("mInputMoneyText");
      paramView = localObject1;
    }
    for (;;)
    {
      paramView.getContentEt().requestFocus();
      paramWeCoinEncashView.showWcKb();
      AppMethodBeat.o(316028);
      return;
    }
  }
  
  private static final void a(WeCoinEncashView paramWeCoinEncashView, View paramView)
  {
    AppMethodBeat.i(315957);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramWeCoinEncashView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    localObject = paramWeCoinEncashView.Vws;
    paramView = (View)localObject;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramView = null;
    }
    paramView = (gim)((LiveData)paramView.VuL).getValue();
    if (paramView != null)
    {
      paramView = paramView.url;
      if (paramView != null) {
        i.a((Context)paramWeCoinEncashView, paramView, false, 1001);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(315957);
  }
  
  private static final void a(WeCoinEncashView paramWeCoinEncashView, com.tencent.mm.plugin.wallet.wecoin.model.a parama)
  {
    AppMethodBeat.i(315981);
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    Object localObject;
    if (parama == null) {
      localObject = null;
    }
    while (localObject != null)
    {
      if (((parama.ott instanceof ans)) && (parama.ott.BaseResponse.Idd == 10006))
      {
        gin localgin = ((ans)parama.ott).Zvr;
        if (localgin != null)
        {
          j localj = new j((Context)paramWeCoinEncashView, 1, 0);
          localObject = paramWeCoinEncashView.getString(a.i.wecoin_disagree);
          kotlin.g.b.s.s(localObject, "getString(R.string.wecoin_disagree)");
          String str = paramWeCoinEncashView.getString(a.i.wecoin_agree_and_sign);
          kotlin.g.b.s.s(str, "getString(R.string.wecoin_agree_and_sign)");
          parama = (com.tencent.mm.plugin.wallet.wecoin.model.a)localObject;
          if (localgin.abkC != null)
          {
            parama = (com.tencent.mm.plugin.wallet.wecoin.model.a)localObject;
            if (localgin.abkC.length() > 0)
            {
              parama = localgin.abkC;
              kotlin.g.b.s.s(parama, "info.cancel_button_wording");
            }
          }
          localObject = str;
          if (localgin.VmH != null)
          {
            localObject = str;
            if (localgin.VmH.length() > 0)
            {
              localObject = localgin.VmH;
              kotlin.g.b.s.s(localObject, "info.confirm_button_wording");
            }
          }
          localj.d((CharSequence)parama, (CharSequence)localObject);
          localj.a(new WeCoinEncashView..ExternalSyntheticLambda12(localj, paramWeCoinEncashView, localgin), new WeCoinEncashView..ExternalSyntheticLambda13(localj, paramWeCoinEncashView, localgin));
          parama = View.inflate((Context)paramWeCoinEncashView, a.g.wccoin_cut_tax_confirm_half_page_content, null);
          ((ImageView)parama.findViewById(a.f.close)).setOnClickListener(new WeCoinEncashView..ExternalSyntheticLambda3(localj));
          localObject = (TextView)parama.findViewById(a.f.title);
          str = localgin.title;
          if (str != null)
          {
            ((TextView)localObject).setText((CharSequence)str);
            aw.d((Paint)((TextView)localObject).getPaint());
          }
          localObject = (TextView)parama.findViewById(a.f.desc);
          str = localgin.aceV;
          if (str != null)
          {
            ((TextView)localObject).setText((CharSequence)str);
            i.a((TextView)localObject, str, 0, str.length(), new f(new WeCoinEncashView..ExternalSyntheticLambda16(localgin, paramWeCoinEncashView)), (Context)paramWeCoinEncashView);
          }
          localj.setCustomView(parama);
          localj.dDn();
          AppMethodBeat.o(315981);
          return;
          localObject = parama.ott;
          continue;
        }
      }
      if (((parama.ott instanceof ans)) && (parama.ott.BaseResponse.Idd == 10008)) {
        break label430;
      }
    }
    paramWeCoinEncashView = paramWeCoinEncashView.getContext();
    kotlin.g.b.s.s(paramWeCoinEncashView, "context");
    com.tencent.mm.plugin.wallet.wecoin.utils.c.a((Context)paramWeCoinEncashView, parama);
    label430:
    AppMethodBeat.o(315981);
  }
  
  private static final void a(WeCoinEncashView paramWeCoinEncashView, anu paramanu)
  {
    Object localObject2 = null;
    AppMethodBeat.i(315991);
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    Log.i("MicroMsg.WeCoinEncashView", kotlin.g.b.s.X("gotoWeCoinFetchResultUI, info ", paramanu));
    Object localObject3;
    Object localObject1;
    if (paramanu != null)
    {
      paramWeCoinEncashView.finish();
      localObject3 = paramWeCoinEncashView.Vws;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        localObject1 = null;
      }
      ((g)localObject1).asf(21);
      Orders localOrders = new Orders();
      localObject3 = paramWeCoinEncashView.Vws;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        localObject1 = null;
      }
      localOrders.hAW = ((g)localObject1).VuI;
      localOrders.MEq = "CNY";
      localOrders.VGQ = paramanu.Zvs;
      localOrders.VGR = paramanu.Zvt;
      localObject3 = new Intent((Context)paramWeCoinEncashView.getContext(), WeCoinBalanceDetailView.class);
      ((Intent)localObject3).putExtra("key_orders", (Parcelable)localOrders);
      localObject1 = paramWeCoinEncashView.Vws;
      if (localObject1 != null) {
        break label311;
      }
      kotlin.g.b.s.bIx("mViewModel");
      localObject1 = localObject2;
    }
    label311:
    for (;;)
    {
      ((Intent)localObject3).putExtra("wecoin_fetch_result_kv_data", (Parcelable)((g)localObject1).VuK);
      ((Intent)localObject3).putExtra("WECOIN_ENCASH_RESULT_PAGE_INFO", paramanu.toByteArray());
      paramanu = new com.tencent.mm.hellhoundlib.b.a().cG(localObject3);
      com.tencent.mm.hellhoundlib.a.a.b(paramWeCoinEncashView, paramanu.aYi(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView", "gotoWeCoinFetchResultUI", "(Lcom/tencent/mm/protocal/protobuf/EncashResultPageInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramWeCoinEncashView.startActivity((Intent)paramanu.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramWeCoinEncashView, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView", "gotoWeCoinFetchResultUI", "(Lcom/tencent/mm/protocal/protobuf/EncashResultPageInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramanu = (e)dsH.get();
      if (paramanu != null) {
        paramanu.a(paramWeCoinEncashView);
      }
      AppMethodBeat.o(315991);
      return;
    }
  }
  
  private static final void a(WeCoinEncashView paramWeCoinEncashView, final egr paramegr)
  {
    AppMethodBeat.i(316002);
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    Log.d("MicroMsg.WeCoinEncashView", kotlin.g.b.s.X("handleInterceptWinInfo: ", paramegr));
    dcl localdcl;
    if (paramegr != null)
    {
      localdcl = paramegr.ablX;
      if (localdcl != null) {
        if (paramegr != null) {
          break label86;
        }
      }
    }
    label86:
    for (paramegr = null;; paramegr = paramegr.ablW)
    {
      paramegr = new b(paramWeCoinEncashView, paramegr);
      paramWeCoinEncashView = paramWeCoinEncashView.getContext();
      kotlin.g.b.s.s(paramWeCoinEncashView, "context");
      com.tencent.mm.plugin.wallet.wecoin.utils.c.a((Context)paramWeCoinEncashView, localdcl, (com.tencent.mm.plugin.wallet.wecoin.model.b)paramegr);
      AppMethodBeat.o(316002);
      return;
    }
  }
  
  private static final void a(WeCoinEncashView paramWeCoinEncashView, gim paramgim)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(315966);
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    if (paramgim != null)
    {
      ViewGroup localViewGroup = paramWeCoinEncashView.Vwt;
      localObject1 = localViewGroup;
      if (localViewGroup == null)
      {
        kotlin.g.b.s.bIx("cutTaxEntrace");
        localObject1 = null;
      }
      ((ViewGroup)localObject1).setVisibility(0);
      localObject1 = paramWeCoinEncashView.Vwu;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("cutTaxTitle");
        localObject1 = null;
        ((TextView)localObject1).setText((CharSequence)paramgim.title);
        paramWeCoinEncashView = paramWeCoinEncashView.Vwv;
        if (paramWeCoinEncashView != null) {
          break label114;
        }
        kotlin.g.b.s.bIx("cutTaxDesc");
        paramWeCoinEncashView = localObject2;
      }
      label114:
      for (;;)
      {
        paramWeCoinEncashView.setText((CharSequence)paramgim.desc);
        AppMethodBeat.o(315966);
        return;
        break;
      }
    }
    paramWeCoinEncashView = paramWeCoinEncashView.Vwt;
    if (paramWeCoinEncashView == null)
    {
      kotlin.g.b.s.bIx("cutTaxEntrace");
      paramWeCoinEncashView = (WeCoinEncashView)localObject1;
    }
    for (;;)
    {
      paramWeCoinEncashView.setVisibility(8);
      AppMethodBeat.o(315966);
      return;
    }
  }
  
  private static final void a(WeCoinEncashView paramWeCoinEncashView, gjo paramgjo)
  {
    AppMethodBeat.i(315973);
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    paramWeCoinEncashView.a(paramgjo);
    AppMethodBeat.o(315973);
  }
  
  private static final void a(WeCoinEncashView paramWeCoinEncashView, Boolean paramBoolean)
  {
    AppMethodBeat.i(316009);
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    if (paramBoolean != null)
    {
      if (paramBoolean.booleanValue())
      {
        paramWeCoinEncashView.showLoading(true);
        AppMethodBeat.o(316009);
        return;
      }
      paramWeCoinEncashView.hideLoading();
    }
    AppMethodBeat.o(316009);
  }
  
  private static final void a(WeCoinEncashView paramWeCoinEncashView, boolean paramBoolean)
  {
    ScrollView localScrollView2 = null;
    ScrollView localScrollView1 = null;
    AppMethodBeat.i(316037);
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    if (paramBoolean)
    {
      localScrollView2 = paramWeCoinEncashView.Vii;
      if (localScrollView2 == null) {
        kotlin.g.b.s.bIx("rootView");
      }
      for (;;)
      {
        localScrollView1.postDelayed(new WeCoinEncashView..ExternalSyntheticLambda17(paramWeCoinEncashView), 100L);
        AppMethodBeat.o(316037);
        return;
        localScrollView1 = localScrollView2;
      }
    }
    paramWeCoinEncashView = paramWeCoinEncashView.Vii;
    if (paramWeCoinEncashView == null)
    {
      kotlin.g.b.s.bIx("rootView");
      paramWeCoinEncashView = localScrollView2;
    }
    for (;;)
    {
      paramWeCoinEncashView.scrollTo(0, 0);
      AppMethodBeat.o(316037);
      return;
    }
  }
  
  private static final void a(gin paramgin, WeCoinEncashView paramWeCoinEncashView, View paramView)
  {
    AppMethodBeat.i(316093);
    kotlin.g.b.s.u(paramgin, "$info");
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    paramgin = paramgin.VHT;
    if (paramgin != null) {
      i.p((Context)paramWeCoinEncashView, paramgin, false);
    }
    AppMethodBeat.o(316093);
  }
  
  private final void a(gjo paramgjo)
  {
    AppMethodBeat.i(315943);
    Log.i("MicroMsg.WeCoinEncashView", kotlin.g.b.s.X("startCheckPwdUI, params ", paramgjo));
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 93);
    if (paramgjo != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("appId", paramgjo.appid);
      localIntent.putExtra("timeStamp", paramgjo.hhx);
      localIntent.putExtra("nonceStr", paramgjo.wDg);
      localIntent.putExtra("packageExt", paramgjo.acfJ);
      localIntent.putExtra("signtype", paramgjo.wDe);
      localIntent.putExtra("paySignature", paramgjo.aaGN);
      localIntent.putExtra("scene", 1);
      com.tencent.mm.br.c.a((Context)this, "wallet_core", ".ui.WalletCheckPwdUI", localIntent, 3001, false);
    }
    AppMethodBeat.o(315943);
  }
  
  private static final void a(j paramj, WeCoinEncashView paramWeCoinEncashView, gin paramgin)
  {
    AppMethodBeat.i(316076);
    kotlin.g.b.s.u(paramj, "$halfPage");
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    kotlin.g.b.s.u(paramgin, "$info");
    Log.i("MicroMsg.WeCoinEncashView", "click disagree ");
    paramj.cyW();
    String str = paramWeCoinEncashView.Vww;
    if (str != null)
    {
      g localg = paramWeCoinEncashView.Vws;
      paramj = localg;
      if (localg == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        paramj = null;
      }
      paramj.a(str, paramgin.Zvp, 2, (com.tencent.mm.vending.e.b)paramWeCoinEncashView);
    }
    AppMethodBeat.o(316076);
  }
  
  private static final boolean a(View.OnClickListener paramOnClickListener, TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(316056);
    kotlin.g.b.s.u(paramOnClickListener, "$clickListener");
    if (paramKeyEvent == null)
    {
      AppMethodBeat.o(316056);
      return true;
    }
    if ((paramKeyEvent.getAction() == 1) && (paramKeyEvent.getKeyCode() == 66))
    {
      Log.i("MicroMsg.WeCoinEncashView", "click enter");
      paramOnClickListener.onClick(null);
      AppMethodBeat.o(316056);
      return true;
    }
    AppMethodBeat.o(316056);
    return true;
  }
  
  private static final boolean a(WeCoinEncashView paramWeCoinEncashView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(315952);
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    g localg = paramWeCoinEncashView.Vws;
    paramMenuItem = localg;
    if (localg == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramMenuItem = null;
    }
    paramMenuItem.asf(20);
    paramWeCoinEncashView.mPayResultType = 4;
    if (paramWeCoinEncashView.needConfirmFinish())
    {
      paramWeCoinEncashView.hideVKB();
      paramWeCoinEncashView.showDialog(1000);
    }
    for (;;)
    {
      AppMethodBeat.o(315952);
      return true;
      paramWeCoinEncashView.finish();
    }
  }
  
  private static final boolean a(WeCoinEncashView paramWeCoinEncashView, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(316018);
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    paramWeCoinEncashView.handleKeyboardTouchEvent(paramMotionEvent);
    AppMethodBeat.o(316018);
    return false;
  }
  
  private static final void b(WeCoinEncashView paramWeCoinEncashView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(316063);
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    Object localObject3 = paramWeCoinEncashView.Vwp;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("mEncashTitleTV");
      localObject1 = null;
    }
    localObject1.getLocationInWindow(arrayOfInt1);
    localObject3 = paramWeCoinEncashView.Vii;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("rootView");
      localObject1 = null;
    }
    localObject1.getLocationInWindow(arrayOfInt2);
    Log.d("MicroMsg.WeCoinEncashView", "scroll y: %s", new Object[] { Integer.valueOf(arrayOfInt1[1] - arrayOfInt2[1]) });
    paramWeCoinEncashView = paramWeCoinEncashView.Vii;
    if (paramWeCoinEncashView == null)
    {
      kotlin.g.b.s.bIx("rootView");
      paramWeCoinEncashView = localObject2;
    }
    for (;;)
    {
      paramWeCoinEncashView.scrollBy(0, arrayOfInt1[1] - arrayOfInt2[1]);
      AppMethodBeat.o(316063);
      return;
    }
  }
  
  private static final void b(WeCoinEncashView paramWeCoinEncashView, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(316049);
    Object localObject2 = new Object();
    Object localObject3 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramWeCoinEncashView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, ((com.tencent.mm.hellhoundlib.b.b)localObject3).aYj());
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    if (com.tencent.mm.plugin.wallet.wecoin.utils.c.isFastClick())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(316049);
      return;
    }
    localObject2 = paramWeCoinEncashView.Vwq;
    paramView = (View)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mInputMoneyText");
      paramView = null;
    }
    paramView = paramView.getText();
    kotlin.g.b.s.s(paramView, "mInputMoneyText.text");
    int i = com.tencent.mm.plugin.wallet.wecoin.utils.c.ny(paramView, "100");
    int j;
    long l;
    if (i > 0)
    {
      localObject2 = paramWeCoinEncashView.Vws;
      paramView = (View)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        paramView = null;
      }
      paramView.asf(6);
      paramWeCoinEncashView.hideWcKb();
      localObject3 = new StringBuilder("click encash to cft ");
      localObject2 = paramWeCoinEncashView.Vws;
      paramView = (View)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        paramView = null;
      }
      Log.i("MicroMsg.WeCoinEncashView", paramView.VuF + ", " + i);
      localObject2 = paramWeCoinEncashView.Vws;
      paramView = (View)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        paramView = null;
      }
      j = paramView.VuF;
      l = i;
      Log.i("MicroMsg.WeCoinEncashView", kotlin.g.b.s.X("prepareEncashRequest, amount ", Long.valueOf(l)));
      paramView = paramWeCoinEncashView.Vws;
      if (paramView != null) {
        break label349;
      }
      kotlin.g.b.s.bIx("mViewModel");
      paramView = localObject1;
    }
    label349:
    for (;;)
    {
      paramView.a(j, l, (com.tencent.mm.vending.e.b)paramWeCoinEncashView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(316049);
      return;
    }
  }
  
  private static final void b(j paramj, WeCoinEncashView paramWeCoinEncashView, gin paramgin)
  {
    AppMethodBeat.i(316083);
    kotlin.g.b.s.u(paramj, "$halfPage");
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    kotlin.g.b.s.u(paramgin, "$info");
    Log.i("MicroMsg.WeCoinEncashView", "click agree");
    paramj.cyW();
    String str = paramWeCoinEncashView.Vww;
    if (str != null)
    {
      g localg = paramWeCoinEncashView.Vws;
      paramj = localg;
      if (localg == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        paramj = null;
      }
      paramj.a(str, paramgin.Zvp, 1, (com.tencent.mm.vending.e.b)paramWeCoinEncashView);
    }
    AppMethodBeat.o(316083);
  }
  
  private static final void c(WeCoinEncashView paramWeCoinEncashView)
  {
    AppMethodBeat.i(316072);
    kotlin.g.b.s.u(paramWeCoinEncashView, "this$0");
    paramWeCoinEncashView.showNormalStWcKb();
    AppMethodBeat.o(316072);
  }
  
  private static final void d(j paramj, View paramView)
  {
    AppMethodBeat.i(316087);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "$halfPage");
    Log.i("MicroMsg.WeCoinEncashView", "click close");
    paramj.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316087);
  }
  
  public int getLayoutId()
  {
    return a.g.activity_we_coin_encash_ui;
  }
  
  public void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(316297);
    setBackBtn(new WeCoinEncashView..ExternalSyntheticLambda0(this));
    setActionbarColor(getResources().getColor(a.c.normal_actionbar_color));
    hideActionbarLine();
    this.Vwq = ((WalletFormView)findViewById(a.f.input_money_wv));
    this.Vwp = ((TextView)findViewById(a.f.encash_money_title_tv));
    this.VhJ = ((ViewGroup)findViewById(a.f.main_content));
    this.Vwr = ((TextView)findViewById(a.f.total_balance_hint));
    this.Vii = ((ScrollView)findViewById(a.f.lqt_root_view));
    Object localObject3 = this.Vwq;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("mInputMoneyText");
      localObject1 = null;
    }
    ((WalletFormView)localObject1).getTitleTv().setText((CharSequence)"¥");
    localObject1 = this.Vwr;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mTotalBalanceWithdrawTip");
      localObject1 = null;
      ((TextView)localObject1).setText((CharSequence)"");
      localObject3 = this.Vwr;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("mTotalBalanceWithdrawTip");
        localObject1 = null;
      }
      ((TextView)localObject1).setClickable(true);
      localObject1 = this.Vwr;
      if (localObject1 != null) {
        break label412;
      }
      kotlin.g.b.s.bIx("mTotalBalanceWithdrawTip");
      localObject1 = null;
    }
    label412:
    for (;;)
    {
      ((TextView)localObject1).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s((Context)this));
      aw.a((Paint)((TextView)findViewById(a.f.lqt_balance_bankcard)).getPaint(), 0.8F);
      setMMTitle(a.i.wallet_balance_manager_fetch);
      this.state = 1;
      this.Vwt = ((ViewGroup)findViewById(a.f.cut_tax_entrance));
      localObject3 = this.Vwt;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("cutTaxEntrace");
        localObject1 = null;
      }
      ((ViewGroup)localObject1).setOnClickListener(new WeCoinEncashView..ExternalSyntheticLambda2(this));
      this.Vwu = ((TextView)findViewById(a.f.cut_tax_title));
      this.Vwv = ((TextView)findViewById(a.f.cut_taxt_desc));
      this.mWcKeyboard = ((WcPayKeyboard)findViewById(a.f.wp_kb));
      localObject1 = this.mWcKeyboard.getLayoutParams();
      if (localObject1 != null) {
        break label415;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(316297);
      throw ((Throwable)localObject1);
      break;
    }
    label415:
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    this.mWcKeyboard.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject3 = this.Vwq;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("mInputMoneyText");
      localObject1 = null;
    }
    setWPKeyboard(((WalletFormView)localObject1).getContentEt(), false, false);
    this.mWcKeyboard.setActionText(getString(a.i.wallet_balance_manager_fetch));
    if (d.rd(27))
    {
      localObject3 = this.Vwq;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("mInputMoneyText");
        localObject1 = null;
      }
      ((WalletFormView)localObject1).jPE();
    }
    localObject3 = this.VhJ;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("mainContent");
      localObject1 = null;
    }
    ((ViewGroup)localObject1).setOnTouchListener(new WeCoinEncashView..ExternalSyntheticLambda4(this));
    Ho(false);
    localObject1 = this.Vwq;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mInputMoneyText");
      localObject1 = null;
      ((WalletFormView)localObject1).a((TextWatcher)new c(this));
      setTenpayKBStateListener(new WeCoinEncashView..ExternalSyntheticLambda14(this));
      WeCoinEncashView..ExternalSyntheticLambda1 localExternalSyntheticLambda1 = new WeCoinEncashView..ExternalSyntheticLambda1(this);
      localObject3 = this.Vwq;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("mInputMoneyText");
        localObject1 = null;
      }
      ((WalletFormView)localObject1).getContentEt().setOnEditorActionListener(new WeCoinEncashView..ExternalSyntheticLambda5(localExternalSyntheticLambda1));
      long l = getIntent().getLongExtra("wecoin_income_balance", 0L);
      if (l > 0L)
      {
        localObject1 = getString(a.i.wecoin_income_total_fetch_balance, new Object[] { Double.valueOf(com.tencent.mm.plugin.wallet.wecoin.utils.c.nx(String.valueOf(l), "100")) });
        kotlin.g.b.s.s(localObject1, "getString(R.string.wecoi…igDecimal.ROUND_CEILING))");
        int i = ((String)localObject1).length();
        localObject3 = new SpannableString((CharSequence)((String)localObject1 + ' ' + getString(a.i.wecoin_income_total_fetch_wording)));
        ((SpannableString)localObject3).setSpan(new f(new WeCoinEncashView..ExternalSyntheticLambda15(this, l)), i, ((SpannableString)localObject3).length(), 18);
        this.Vio = ((CharSequence)localObject3);
        localObject1 = this.Vwr;
        if (localObject1 != null) {
          break label850;
        }
        kotlin.g.b.s.bIx("mTotalBalanceWithdrawTip");
        localObject1 = localObject2;
      }
    }
    label850:
    for (;;)
    {
      ((TextView)localObject1).setText((CharSequence)localObject3);
      AppMethodBeat.o(316297);
      return;
      break;
    }
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    AppMethodBeat.i(316311);
    Log.d("MicroMsg.WeCoinEncashView", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", new Object[] { Boolean.valueOf(this.Vcb), Boolean.valueOf(this.mWcKeyboard.jOo()) });
    if ((!this.Vcb) && (this.mWcKeyboard.jOo()))
    {
      AppMethodBeat.o(316311);
      return true;
    }
    AppMethodBeat.o(316311);
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str = null;
    g localg = null;
    AppMethodBeat.i(316279);
    Log.i("MicroMsg.WeCoinEncashView", "onActivityResult() requestCode:%s, resultCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 3001)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent == null)
        {
          paramIntent = null;
          this.Vww = paramIntent;
          paramIntent = (CharSequence)this.Vww;
          if ((paramIntent != null) && (paramIntent.length() != 0)) {
            break label170;
          }
        }
        label170:
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            break label175;
          }
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 95);
          str = this.Vww;
          if (str != null)
          {
            localg = this.Vws;
            paramIntent = localg;
            if (localg == null)
            {
              kotlin.g.b.s.bIx("mViewModel");
              paramIntent = null;
            }
            paramIntent.a(str, null, 0, (com.tencent.mm.vending.e.b)this);
          }
          AppMethodBeat.o(316279);
          return;
          paramIntent = paramIntent.getStringExtra("token");
          break;
        }
        label175:
        paramIntent = this.Vws;
        if (paramIntent == null)
        {
          kotlin.g.b.s.bIx("mViewModel");
          paramIntent = localg;
        }
        for (;;)
        {
          paramIntent.asf(5);
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 94);
          AppMethodBeat.o(316279);
          return;
        }
      }
      if (paramInt2 == 0)
      {
        paramIntent = this.Vws;
        if (paramIntent != null) {
          break label264;
        }
        kotlin.g.b.s.bIx("mViewModel");
        paramIntent = str;
      }
    }
    label264:
    for (;;)
    {
      paramIntent.asf(5);
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1581, 94);
      AppMethodBeat.o(316279);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(316231);
    super.onCreate(paramBundle);
    paramBundle = new com.tencent.mm.plugin.wallet.wecoin.model.h(getIntent().getByteArrayExtra("WECOIN_TAX_CUT_ENTRANCE_INFO"), getIntent().getIntExtra("WECOIN_BUSINESS_ID", 1));
    paramBundle = ai.a((FragmentActivity)this, (ah.b)paramBundle).q(g.class);
    kotlin.g.b.s.s(paramBundle, "of(this, factory).get(We…ashViewModel::class.java)");
    this.Vws = ((g)paramBundle);
    initView();
    g localg = this.Vws;
    paramBundle = localg;
    if (localg == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.VuL).a((q)this, new WeCoinEncashView..ExternalSyntheticLambda9(this));
    localg = this.Vws;
    paramBundle = localg;
    if (localg == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.VuG).a((q)this, new WeCoinEncashView..ExternalSyntheticLambda10(this));
    localg = this.Vws;
    paramBundle = localg;
    if (localg == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.Vup).a((q)this, new WeCoinEncashView..ExternalSyntheticLambda6(this));
    localg = this.Vws;
    paramBundle = localg;
    if (localg == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.VuH).a((q)this, new WeCoinEncashView..ExternalSyntheticLambda7(this));
    localg = this.Vws;
    paramBundle = localg;
    if (localg == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.Vur).a((q)this, new WeCoinEncashView..ExternalSyntheticLambda8(this));
    localg = this.Vws;
    paramBundle = localg;
    if (localg == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.wIq).a((q)this, new WeCoinEncashView..ExternalSyntheticLambda11(this));
    paramBundle = this.Vws;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = localObject;
    }
    for (;;)
    {
      paramBundle.VuK = ((WecoinEncashKVData)getIntent().getParcelableExtra("wecoin_enter_encash_business_kv_data"));
      AppMethodBeat.o(316231);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(316247);
    super.onDestroy();
    MMHandlerThread.removeRunnable(this.pJs);
    AppMethodBeat.o(316247);
  }
  
  public void onDialogDismiss(Dialog paramDialog)
  {
    AppMethodBeat.i(316305);
    Log.i("MicroMsg.WeCoinEncashView", "onDialogDismiss()");
    if ((this.state == 2) && (isHandleAutoShowNormalStWcKb())) {
      MMHandlerThread.postToMainThreadDelayed(this.pJs, 300L);
    }
    AppMethodBeat.o(316305);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(316261);
    kotlin.g.b.s.u(paramKeyEvent, "event");
    if ((this.mWcKeyboard != null) && (this.mWcKeyboard.onKeyUp(paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(316261);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(316261);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(316243);
    super.onPause();
    Log.i("MicroMsg.WeCoinEncashView", "onPause()");
    if (!this.mWcKeyboard.jOn()) {
      this.state = 3;
    }
    AppMethodBeat.o(316243);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(316237);
    super.onResume();
    Log.i("MicroMsg.WeCoinEncashView", "onResume()");
    if ((this.state == 3) && (isHandleAutoShowNormalStWcKb())) {
      MMHandlerThread.postToMainThreadDelayed(this.pJs, 300L);
    }
    this.state = 2;
    AppMethodBeat.o(316237);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$handleInterceptWinInfo$1$clickListener$1", "Lcom/tencent/mm/plugin/wallet/wecoin/model/InterceptWinClickListener;", "onClick", "", "item", "Lcom/tencent/mm/protocal/protobuf/PopUpJumpInfo;", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.wallet.wecoin.model.b
  {
    b(WeCoinEncashView paramWeCoinEncashView, gjo paramgjo) {}
    
    public final void a(efg paramefg)
    {
      AppMethodBeat.i(315927);
      if (paramefg != null)
      {
        WeCoinEncashView localWeCoinEncashView = this.Vwx;
        gjo localgjo = paramegr;
        if (paramefg.action == 3) {
          WeCoinEncashView.b(localWeCoinEncashView, localgjo);
        }
      }
      AppMethodBeat.o(315927);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$setupViews$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements TextWatcher
  {
    c(WeCoinEncashView paramWeCoinEncashView) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject2 = null;
      AppMethodBeat.i(315944);
      kotlin.g.b.s.u(paramEditable, "s");
      String str = paramEditable.toString();
      Object localObject5;
      int i;
      int j;
      if (n.U(str, ".", false))
      {
        paramEditable.insert(0, (CharSequence)"0");
        localObject5 = paramEditable.toString();
        i = n.a((CharSequence)localObject5, ".", 0, false, 6);
        j = ((String)localObject5).length();
        if ((i < 0) || (j - i <= 3)) {
          break label192;
        }
        localObject1 = WeCoinEncashView.d(this.Vwx);
        if (localObject1 != null) {
          break label189;
        }
        kotlin.g.b.s.bIx("mInputMoneyText");
        localObject1 = localObject2;
        label111:
        WalletFormView.a(((WalletFormView)localObject1).getContentEt(), (String)localObject5, i + 3, j);
      }
      label189:
      label192:
      do
      {
        paramEditable = paramEditable.toString();
        WeCoinEncashView.a(this.Vwx, paramEditable);
        AppMethodBeat.o(315944);
        return;
        localObject5 = WeCoinEncashView.d(this.Vwx);
        localObject1 = localObject5;
        if (localObject5 == null)
        {
          kotlin.g.b.s.bIx("mInputMoneyText");
          localObject1 = null;
        }
        if (!WalletFormView.a(str, ((WalletFormView)localObject1).getContentEt())) {
          break;
        }
        AppMethodBeat.o(315944);
        return;
        break label111;
        if (i > 12)
        {
          localObject1 = WeCoinEncashView.d(this.Vwx);
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("mInputMoneyText");
            localObject1 = localObject3;
          }
          for (;;)
          {
            WalletFormView.a(((WalletFormView)localObject1).getContentEt(), (String)localObject5, 12, i);
            break;
          }
        }
      } while ((i != -1) || (j <= 12));
      Object localObject1 = WeCoinEncashView.d(this.Vwx);
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("mInputMoneyText");
        localObject1 = localObject4;
      }
      for (;;)
      {
        WalletFormView.a(((WalletFormView)localObject1).getContentEt(), (String)localObject5, 12, j);
        break;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(315935);
      kotlin.g.b.s.u(paramCharSequence, "s");
      AppMethodBeat.o(315935);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(315942);
      kotlin.g.b.s.u(paramCharSequence, "s");
      AppMethodBeat.o(315942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.WeCoinEncashView
 * JD-Core Version:    0.7.0.1
 */