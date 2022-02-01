package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.wecoin.a.e.a;
import com.tencent.mm.plugin.wallet.wecoin.a.g;
import com.tencent.mm.plugin.wallet.wecoin.b.m;
import com.tencent.mm.plugin.wallet.wecoin.model.e.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.protocal.protobuf.cwo;
import com.tencent.mm.protocal.protobuf.efg;
import com.tencent.mm.protocal.protobuf.egw;
import com.tencent.mm.protocal.protobuf.gih;
import com.tencent.mm.protocal.protobuf.gij;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog;", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog;", "context", "Landroidx/fragment/app/FragmentActivity;", "params", "Lcom/tencent/mm/plugin/wallet/wecoin/api/RechargeProductDialogParam;", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/mm/plugin/wallet/wecoin/api/RechargeProductDialogParam;)V", "getContext", "()Landroidx/fragment/app/FragmentActivity;", "mBottomSheet", "Lcom/tencent/mm/plugin/wallet/ui/CommonBottomSheet;", "mCancelListener", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinRechargeDialog$OnCancelListener;", "mCustomView", "Landroid/view/View;", "mFirstAdapter", "Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter;", "mHeaderView", "mIsItemClicked", "", "mMenuClickListener", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IBtnClickListener;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mSecondAdapter", "mViewModel", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogViewModel;", "getParams", "()Lcom/tencent/mm/plugin/wallet/wecoin/api/RechargeProductDialogParam;", "showDarkAlways", "bindData", "", "createExitAnimation", "Landroid/animation/Animator;", "dialogView", "handleClickCustomInputItem", "response", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPriceListResponse;", "handleInterceptWinInfo", "info", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeInterceptWinInfo;", "handleItemClicked", "Lcom/tencent/mm/protocal/protobuf/WecoinPriceInfo;", "initCustomView", "initHeaderView", "initKVData", "initView", "Landroid/content/Context;", "isLandscape", "isPushPanelShowType", "loadData", "removeObserver", "setAnimationOut", "setDialogCancelListener", "listener", "setMenuClickListener", "shakeIt", "showErrorMsg", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "tryHide", "updateAgreementLinkText", "url", "", "updateCheckBox", "status", "", "(Ljava/lang/Integer;)V", "updatePriceItem", "updateTitleBalance", "balance", "", "(Ljava/lang/Long;)V", "Companion", "RecycleViewAdapter", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.wallet.wecoin.a.e
{
  public static final a.a VvA;
  private final boolean VtZ;
  final FragmentActivity VvB;
  final com.tencent.mm.plugin.wallet.wecoin.a.h VvC;
  private com.tencent.mm.plugin.wallet.ui.b VvD;
  private final com.tencent.mm.plugin.wallet.wecoin.model.e VvE;
  private b VvF;
  private b VvG;
  private boolean VvH;
  private e.a VvI;
  private com.tencent.mm.plugin.wallet.wecoin.a.b VvJ;
  private w lKp;
  private View nJ;
  private View oW;
  
  static
  {
    AppMethodBeat.i(316225);
    VvA = new a.a((byte)0);
    AppMethodBeat.o(316225);
  }
  
  public a(FragmentActivity paramFragmentActivity, com.tencent.mm.plugin.wallet.wecoin.a.h paramh)
  {
    AppMethodBeat.i(316026);
    this.VvB = paramFragmentActivity;
    this.VvC = paramh;
    this.VtZ = this.VvC.VtZ;
    paramFragmentActivity = ai.a(this.VvB, null).q(com.tencent.mm.plugin.wallet.wecoin.model.e.class);
    kotlin.g.b.s.s(paramFragmentActivity, "of(context).get(Recharge…logViewModel::class.java)");
    this.VvE = ((com.tencent.mm.plugin.wallet.wecoin.model.e)paramFragmentActivity);
    Object localObject2 = this.VvE;
    paramFragmentActivity = this.VvC;
    kotlin.g.b.s.u(paramFragmentActivity, "params");
    ((com.tencent.mm.plugin.wallet.wecoin.model.e)localObject2).Vuz = paramFragmentActivity;
    ((com.tencent.mm.plugin.wallet.wecoin.model.e)localObject2).KzF = com.tencent.mm.plugin.wallet.wecoin.utils.c.asg(paramFragmentActivity.mScene);
    ((com.tencent.mm.plugin.wallet.wecoin.model.e)localObject2).Vuy = ((com.tencent.mm.plugin.wallet.wecoin.model.e)localObject2).ihq();
    label156:
    label361:
    int i;
    switch (paramFragmentActivity.mScene)
    {
    default: 
      paramFragmentActivity = "";
      ((com.tencent.mm.plugin.wallet.wecoin.model.e)localObject2).Vux = paramFragmentActivity;
      ((LiveData)this.VvE.Vuq).j((q)this.VvB);
      ((LiveData)this.VvE.wIq).j((q)this.VvB);
      ((LiveData)this.VvE.Vun).j((q)this.VvB);
      ((LiveData)this.VvE.Vuo).j((q)this.VvB);
      ((LiveData)this.VvE.Vup).j((q)this.VvB);
      ((LiveData)this.VvE.Vur).j((q)this.VvB);
      ((LiveData)this.VvE.Vus).j((q)this.VvB);
      paramFragmentActivity = (Context)this.VvB;
      switch (this.VvC.mScene)
      {
      default: 
        paramFragmentActivity = new com.tencent.mm.plugin.wallet.ui.b(paramFragmentActivity);
        this.VvD = paramFragmentActivity;
        paramh = this.VvD;
        paramFragmentActivity = paramh;
        if (paramh == null)
        {
          kotlin.g.b.s.bIx("mBottomSheet");
          paramFragmentActivity = null;
        }
        paramFragmentActivity.HF(this.VtZ);
        if (ihz())
        {
          paramh = this.VvD;
          paramFragmentActivity = paramh;
          if (paramh == null)
          {
            kotlin.g.b.s.bIx("mBottomSheet");
            paramFragmentActivity = null;
          }
          paramFragmentActivity = paramFragmentActivity.sRs.getWindow();
          if (paramFragmentActivity != null) {
            paramFragmentActivity.setWindowAnimations(a.j.InFromRightOutToBottomAnimation);
          }
        }
        paramh = this.VvD;
        paramFragmentActivity = paramh;
        if (paramh == null)
        {
          kotlin.g.b.s.bIx("mBottomSheet");
          paramFragmentActivity = null;
        }
        paramFragmentActivity.VtG = new a..ExternalSyntheticLambda14(this);
        paramh = this.VvD;
        paramFragmentActivity = paramh;
        if (paramh == null)
        {
          kotlin.g.b.s.bIx("mBottomSheet");
          paramFragmentActivity = null;
        }
        paramh = new a..ExternalSyntheticLambda0(this);
        if (paramFragmentActivity.sRs != null) {
          paramFragmentActivity.sRs.setOnCancelListener(paramh);
        }
        paramFragmentActivity = View.inflate((Context)this.VvB, a.g.buy_goods_half_dialog_title, null);
        kotlin.g.b.s.s(paramFragmentActivity, "inflate(context, R.layou…_half_dialog_title, null)");
        this.nJ = paramFragmentActivity;
        paramh = this.nJ;
        paramFragmentActivity = paramh;
        if (paramh == null)
        {
          kotlin.g.b.s.bIx("mHeaderView");
          paramFragmentActivity = null;
        }
        paramFragmentActivity = paramFragmentActivity.findViewById(a.f.by_goods_half_dialog_title_tv);
        kotlin.g.b.s.s(paramFragmentActivity, "mHeaderView.findViewById…ods_half_dialog_title_tv)");
        localObject2 = (TextView)paramFragmentActivity;
        paramh = this.nJ;
        paramFragmentActivity = paramh;
        if (paramh == null)
        {
          kotlin.g.b.s.bIx("mHeaderView");
          paramFragmentActivity = null;
        }
        paramFragmentActivity = paramFragmentActivity.findViewById(a.f.wecoin_header_back_icon_iv);
        kotlin.g.b.s.s(paramFragmentActivity, "mHeaderView.findViewById…coin_header_back_icon_iv)");
        Object localObject3 = (WeImageView)paramFragmentActivity;
        aw.a((Paint)((TextView)localObject2).getPaint(), 0.8F);
        com.tencent.mm.plugin.wallet.wecoin.utils.c.s((TextView)localObject2, 15);
        if ((this.VvC.mScene == 0) || (this.VvC.mScene == 11) || (this.VvC.mScene == 12) || (this.VvC.mScene == 2) || (this.VvC.Vub == com.tencent.mm.plugin.wallet.wecoin.a.f.VtT)) {
          ((WeImageView)localObject3).setImageResource(a.h.icons_outlined_close);
        }
        switch (this.VvC.mScene)
        {
        case 3: 
        case 5: 
        case 6: 
        case 7: 
        case 9: 
        case 11: 
        case 13: 
        case 15: 
        default: 
          i = 0;
          label790:
          if (i != 0) {
            ((TextView)localObject2).setText(a.i.wecoin_buy_goods_dialog_not_enough);
          }
          if (this.VtZ)
          {
            ((TextView)localObject2).setTextColor(this.VvB.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.BW_100_Alpha_0_8));
            ((WeImageView)localObject3).setIconColor(this.VvB.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.BW_100_Alpha_0_8));
          }
          paramh = this.VvD;
          paramFragmentActivity = paramh;
          if (paramh == null)
          {
            kotlin.g.b.s.bIx("mBottomSheet");
            paramFragmentActivity = null;
          }
          localObject2 = this.nJ;
          paramh = (com.tencent.mm.plugin.wallet.wecoin.a.h)localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("mHeaderView");
            paramh = null;
          }
          if (paramFragmentActivity.VtC != null)
          {
            paramFragmentActivity.VtC.setVisibility(0);
            paramFragmentActivity.VtC.removeAllViews();
            paramFragmentActivity.VtC.setGravity(17);
            paramFragmentActivity.VtC.addView(paramh, -1, -2);
          }
          ((WeImageView)localObject3).setOnClickListener(new a..ExternalSyntheticLambda4(this));
          localObject2 = new androidx.recyclerview.widget.h((Context)this.VvB, 0);
          ((androidx.recyclerview.widget.h)localObject2).w(this.VvB.getResources().getDrawable(com.tencent.mm.plugin.wxpay.a.e.wecoin_recharge_recycler_hor_divider, null));
          paramFragmentActivity = View.inflate((Context)this.VvB, a.g.buy_goods_half_dialog_custom_view, null);
          kotlin.g.b.s.s(paramFragmentActivity, "inflate(context, R.layou…dialog_custom_view, null)");
          this.oW = paramFragmentActivity;
          paramh = this.oW;
          paramFragmentActivity = paramh;
          if (paramh == null)
          {
            kotlin.g.b.s.bIx("mCustomView");
            paramFragmentActivity = null;
          }
          paramFragmentActivity = paramFragmentActivity.findViewById(a.f.bottom_sheet_menu_reccycleview);
          kotlin.g.b.s.s(paramFragmentActivity, "mCustomView.findViewById…_sheet_menu_reccycleview)");
          localObject3 = (RecyclerView)paramFragmentActivity;
          paramFragmentActivity = new BuyGoodsBottomDialog.initCustomView.layoutManager.1();
          paramFragmentActivity.setOrientation(0);
          ((RecyclerView)localObject3).setLayoutManager((RecyclerView.LayoutManager)paramFragmentActivity);
          ((RecyclerView)localObject3).a((RecyclerView.h)localObject2);
          this.VvF = new b();
          paramh = this.VvF;
          paramFragmentActivity = paramh;
          if (paramh == null)
          {
            kotlin.g.b.s.bIx("mFirstAdapter");
            paramFragmentActivity = null;
          }
          ((RecyclerView)localObject3).setAdapter((RecyclerView.a)paramFragmentActivity);
          localObject3 = new BuyGoodsBottomDialog.initCustomView.secondLayoutManager.1();
          ((BuyGoodsBottomDialog.initCustomView.secondLayoutManager.1)localObject3).setOrientation(0);
          paramh = this.oW;
          paramFragmentActivity = paramh;
          if (paramh == null)
          {
            kotlin.g.b.s.bIx("mCustomView");
            paramFragmentActivity = null;
          }
          paramFragmentActivity = paramFragmentActivity.findViewById(a.f.bottom_sheet_second_reccycleview);
          kotlin.g.b.s.s(paramFragmentActivity, "mCustomView.findViewById…heet_second_reccycleview)");
          RecyclerView localRecyclerView = (RecyclerView)paramFragmentActivity;
          localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject3);
          localRecyclerView.a((RecyclerView.h)localObject2);
          this.VvG = new b();
          paramh = this.VvG;
          paramFragmentActivity = paramh;
          if (paramh == null)
          {
            kotlin.g.b.s.bIx("mSecondAdapter");
            paramFragmentActivity = null;
          }
          localRecyclerView.setAdapter((RecyclerView.a)paramFragmentActivity);
          paramh = this.VvD;
          paramFragmentActivity = paramh;
          if (paramh == null)
          {
            kotlin.g.b.s.bIx("mBottomSheet");
            paramFragmentActivity = null;
          }
          paramh = this.oW;
          if (paramh == null)
          {
            kotlin.g.b.s.bIx("mCustomView");
            paramh = localObject1;
          }
          break;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      if (paramFragmentActivity.VtE != null)
      {
        paramFragmentActivity.VtE.setVisibility(0);
        paramFragmentActivity.VtE.removeAllViews();
        paramFragmentActivity.VtE.setGravity(17);
        paramFragmentActivity.VtE.addView(paramh, -1, -2);
      }
      p(Boolean.TRUE);
      ((LiveData)this.VvE.Vun).a((q)this.VvB, new a..ExternalSyntheticLambda13(this));
      ((LiveData)this.VvE.Vuo).a((q)this.VvB, new a..ExternalSyntheticLambda11(this));
      ((LiveData)this.VvE.Vup).a((q)this.VvB, new a..ExternalSyntheticLambda7(this));
      ((LiveData)this.VvE.Vuq).a((q)this.VvB, new a..ExternalSyntheticLambda12(this));
      ((LiveData)this.VvE.wIq).a((q)this.VvB, new a..ExternalSyntheticLambda10(this));
      ((LiveData)this.VvE.Vur).a((q)this.VvB, new a..ExternalSyntheticLambda8(this));
      ((LiveData)this.VvE.Vus).a((q)this.VvB, new a..ExternalSyntheticLambda9(this));
      paramFragmentActivity = this.VvE;
      Log.i("MicroMsg.RechargeProductsDialogViewModel", "getCacheData, isCacheDataLoaded: %s", new Object[] { Boolean.valueOf(paramFragmentActivity.Vuw) });
      if (!paramFragmentActivity.Vuw)
      {
        paramFragmentActivity.Vuw = true;
        paramh = com.tencent.mm.plugin.wallet.wecoin.utils.c.ash(paramFragmentActivity.iho());
        if (paramh != null) {
          paramFragmentActivity.Vus.t(paramh);
        }
        paramh = (cwo)paramFragmentActivity.Vus.getValue();
        if (paramh != null)
        {
          paramFragmentActivity.Vun.t(paramh.aaBH);
          paramFragmentActivity.Vuo.t(Integer.valueOf(paramh.aaBI));
          paramFragmentActivity.Vuv = paramh.aaBJ;
        }
        long l = com.tencent.mm.plugin.wallet.wecoin.utils.c.ihF();
        if (l > 0L) {
          paramFragmentActivity.Vuq.t(Long.valueOf(l));
        }
      }
      this.VvE.ase(this.VvC.mScene);
      this.VvE.ihp();
      AppMethodBeat.o(316026);
      return;
      paramh = ((com.tencent.mm.plugin.wallet.wecoin.model.e)localObject2).Vuy;
      paramFragmentActivity = paramh;
      if (paramh != null) {
        break label156;
      }
      kotlin.g.b.s.bIx("mSessionid");
      paramFragmentActivity = null;
      break label156;
      paramFragmentActivity = paramFragmentActivity.Vua;
      if (paramFragmentActivity == null) {
        break;
      }
      break label156;
      paramFragmentActivity = new com.tencent.mm.plugin.wallet.ui.b(paramFragmentActivity);
      break label361;
      paramFragmentActivity = new com.tencent.mm.plugin.wallet.ui.b(paramFragmentActivity, (byte)0);
      break label361;
      i = 1;
      break label790;
    }
  }
  
  private static final void a(CheckBox paramCheckBox, a parama, View paramView)
  {
    AppMethodBeat.i(316165);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramCheckBox);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    if (paramCheckBox.isChecked())
    {
      paramCheckBox.setChecked(false);
      parama.VvE.asf(4);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(316165);
      return;
    }
    paramCheckBox.setChecked(true);
    parama.VvE.asf(3);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(316165);
  }
  
  private static final void a(com.tencent.mm.plugin.wallet.wecoin.model.a parama, a parama1, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(316179);
    kotlin.g.b.s.u(parama1, "this$0");
    if (parama != null)
    {
      parama1 = parama1.VvC;
      if (parama1 != null)
      {
        parama1 = parama1.VtR;
        if (parama1 != null) {
          parama1.s(parama.hDx, parama.errorCode, parama.errorMsg);
        }
      }
    }
    AppMethodBeat.o(316179);
  }
  
  private static final void a(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(316074);
    kotlin.g.b.s.u(parama, "this$0");
    if (!parama.VvH)
    {
      parama.VvE.asf(2);
      parama = parama.VvE.Vuz;
      if (parama != null)
      {
        parama = parama.VtR;
        if (parama != null) {
          parama.s(3, -3, "");
        }
      }
    }
    AppMethodBeat.o(316074);
  }
  
  private static final void a(a parama, final View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(316147);
    Object localObject2 = new Object();
    Object localObject3 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, ((com.tencent.mm.hellhoundlib.b.b)localObject3).aYj());
    kotlin.g.b.s.u(parama, "this$0");
    parama.VvE.ihr();
    paramView = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
    com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a.reportGiftOnReturn();
    if (parama.ihz())
    {
      localObject1 = parama.VvD;
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("mBottomSheet");
        paramView = null;
      }
      paramView = paramView.rootView;
      paramView.animate().cancel();
      paramView.clearAnimation();
      kotlin.g.b.s.s(paramView, "dialogView");
      localObject1 = (Interpolator)new AccelerateInterpolator();
      localObject2 = new AnimatorSet();
      localObject3 = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { 0.0F, paramView.getWidth() });
      ((ObjectAnimator)localObject3).setDuration(200L);
      ((ObjectAnimator)localObject3).setInterpolator((TimeInterpolator)localObject1);
      ((AnimatorSet)localObject2).playTogether(new Animator[] { (Animator)localObject3 });
      localObject1 = (Animator)localObject2;
      ((Animator)localObject1).addListener((Animator.AnimatorListener)new e(parama, paramView));
      ((Animator)localObject1).start();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(316147);
      return;
    }
    parama = parama.VvD;
    if (parama == null)
    {
      kotlin.g.b.s.bIx("mBottomSheet");
      parama = (a)localObject1;
    }
    for (;;)
    {
      parama.cyW();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(316147);
      return;
    }
  }
  
  private static final void a(a parama, com.tencent.mm.plugin.wallet.wecoin.model.a parama1)
  {
    AppMethodBeat.i(316099);
    kotlin.g.b.s.u(parama, "this$0");
    Log.d("MicroMsg.BuyGoodsBottomDialog", kotlin.g.b.s.X("showErrorMsg: ", parama1));
    a..ExternalSyntheticLambda2 localExternalSyntheticLambda2 = new a..ExternalSyntheticLambda2(parama1, parama);
    parama = (Context)parama.VvB;
    kotlin.g.b.s.u(parama, "context");
    if ((parama1 != null) && ((parama1.hDx != 0) || (parama1.errorCode != 0)))
    {
      CharSequence localCharSequence = (CharSequence)parama1.errorMsg;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        com.tencent.mm.ui.base.k.a(parama, parama.getString(a.i.wecoin_network_dialog_common_wording), "", parama.getString(a.i.wecoin_dialog_left_button_common_wording), false, localExternalSyntheticLambda2);
        AppMethodBeat.o(316099);
        return;
      }
      com.tencent.mm.ui.base.k.a(parama, parama1.errorMsg, "", parama.getString(a.i.wecoin_dialog_left_button_common_wording), false, localExternalSyntheticLambda2);
    }
    AppMethodBeat.o(316099);
  }
  
  private static final void a(a parama, final com.tencent.mm.plugin.wallet.wecoin.model.d paramd)
  {
    AppMethodBeat.i(316117);
    kotlin.g.b.s.u(parama, "this$0");
    Log.d("MicroMsg.BuyGoodsBottomDialog", kotlin.g.b.s.X("handleInterceptWinInfo: ", paramd));
    final egw localegw;
    if (paramd != null)
    {
      localegw = paramd.Vuk;
      if (localegw != null)
      {
        paramd = paramd.Vul;
        if (paramd != null) {
          break label86;
        }
      }
    }
    label86:
    for (paramd = null;; paramd = paramd.MQZ)
    {
      paramd = new d(parama, paramd, localegw);
      com.tencent.mm.plugin.wallet.wecoin.utils.c.a((Context)parama.VvB, localegw.ablX, (com.tencent.mm.plugin.wallet.wecoin.model.b)paramd);
      AppMethodBeat.o(316117);
      return;
    }
  }
  
  private static final void a(a parama, cwo paramcwo)
  {
    AppMethodBeat.i(316137);
    kotlin.g.b.s.u(parama, "this$0");
    Object localObject2;
    Object localObject1;
    Object localObject3;
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    int i;
    int k;
    if (paramcwo != null)
    {
      localObject2 = parama.VvD;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mBottomSheet");
        localObject1 = null;
      }
      Log.d("MicroMsg.BuyGoodsBottomDialog", kotlin.g.b.s.X("mBottomSheet: showing ", Boolean.valueOf(((com.tencent.mm.plugin.wallet.ui.b)localObject1).isShowing())));
      localObject2 = parama.VvD;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mBottomSheet");
        localObject1 = null;
      }
      if (!((com.tencent.mm.plugin.wallet.ui.b)localObject1).isShowing()) {
        parama.VvE.asf(1);
      }
      parama.p(Boolean.FALSE);
      localObject1 = paramcwo.aaBG;
      kotlin.g.b.s.s(localObject1, "response.price_infos");
      localObject3 = p.J((Collection)localObject1);
      if ((paramcwo.aaBK != null) && (paramcwo.aaBK.aceP == 1)) {
        if (paramcwo.aaBK.aceS < ((List)localObject3).size())
        {
          ((List)localObject3).remove(paramcwo.aaBK.aceS);
          localObject2 = parama.VvG;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("mSecondAdapter");
            localObject1 = null;
          }
          ((b)localObject1).VvK = true;
          localArrayList2 = new ArrayList();
          localArrayList1 = new ArrayList();
          i = 0;
          k = ((List)localObject3).size() - 1;
          if (k < 0) {}
        }
      }
    }
    for (;;)
    {
      int j = i + 1;
      if (i < 3) {
        localArrayList2.add(((List)localObject3).get(i));
      }
      label1418:
      for (;;)
      {
        label271:
        if (j > k)
        {
          com.tencent.mm.ui.base.s locals = new com.tencent.mm.ui.base.s((Context)parama.VvB);
          localObject3 = new com.tencent.mm.ui.base.s((Context)parama.VvB);
          localObject1 = ((Iterable)localArrayList2).iterator();
          i = 0;
          long l;
          String str;
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = ((Iterator)localObject1).next();
              if (i < 0) {
                p.kkW();
              }
              localObject2 = (gij)localObject2;
              l = com.tencent.mm.wallet_core.ui.i.a(kotlin.g.b.s.X("", Integer.valueOf(((gij)localObject2).MRD)), "100", RoundingMode.CEILING);
              str = parama.VvB.getString(a.i.wecoin_recharge_price_yuan, new Object[] { String.valueOf(l) });
              kotlin.g.b.s.s(str, "context.getString(R.stri…an, avgAmount.toString())");
              locals.a(i, (CharSequence)kotlin.g.b.s.X("", Integer.valueOf(((gij)localObject2).aceU)), (CharSequence)str, -1);
              i += 1;
              continue;
              localObject2 = parama.VvG;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                kotlin.g.b.s.bIx("mSecondAdapter");
                localObject1 = null;
              }
              ((b)localObject1).VvK = false;
              break;
              localObject2 = parama.VvG;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                kotlin.g.b.s.bIx("mSecondAdapter");
                localObject1 = null;
              }
              ((b)localObject1).VvK = false;
              break;
              localArrayList1.add(((List)localObject3).get(i));
              break label271;
            }
          }
          localObject1 = ((Iterable)localArrayList1).iterator();
          i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              p.kkW();
            }
            localObject2 = (gij)localObject2;
            l = com.tencent.mm.wallet_core.ui.i.a(kotlin.g.b.s.X("", Integer.valueOf(((gij)localObject2).MRD)), "100", RoundingMode.CEILING);
            str = parama.VvB.getString(a.i.wecoin_recharge_price_yuan, new Object[] { String.valueOf(l) });
            kotlin.g.b.s.s(str, "context.getString(R.stri…an, avgAmount.toString())");
            ((com.tencent.mm.ui.base.s)localObject3).a(i, (CharSequence)kotlin.g.b.s.X("", Integer.valueOf(((gij)localObject2).aceU)), (CharSequence)str, -1);
            i += 1;
          }
          localObject2 = parama.VvG;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("mSecondAdapter");
            localObject1 = null;
          }
          if (((b)localObject1).VvK)
          {
            localObject1 = parama.VvB.getString(a.i.wecoin_other_amount);
            kotlin.g.b.s.s(localObject1, "context.getString(R.string.wecoin_other_amount)");
            localObject2 = parama.VvB.getString(a.i.wecoin_max_custom_coin_amount, new Object[] { String.valueOf(paramcwo.aaBK.aceR / 100L) });
            kotlin.g.b.s.s(localObject2, "context.getString(R.stri…perbound/100).toString())");
            ((com.tencent.mm.ui.base.s)localObject3).a(2, (CharSequence)localObject1, (CharSequence)localObject2, -1);
          }
          localObject2 = parama.VvF;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("mFirstAdapter");
            localObject1 = null;
          }
          ((b)localObject1).GAB = locals;
          localObject2 = parama.VvF;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("mFirstAdapter");
            localObject1 = null;
          }
          ((b)localObject1).un = new a..ExternalSyntheticLambda6(parama, localArrayList2);
          localObject2 = parama.VvG;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("mSecondAdapter");
            localObject1 = null;
          }
          ((b)localObject1).GAB = ((com.tencent.mm.ui.base.s)localObject3);
          localObject2 = parama.VvG;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("mSecondAdapter");
            localObject1 = null;
          }
          ((b)localObject1).un = new a..ExternalSyntheticLambda5(parama, paramcwo, localArrayList1);
          localObject1 = parama.VvF;
          paramcwo = (cwo)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("mFirstAdapter");
            paramcwo = null;
          }
          paramcwo.bZE.notifyChanged();
          localObject1 = parama.VvG;
          paramcwo = (cwo)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("mSecondAdapter");
            paramcwo = null;
          }
          paramcwo.bZE.notifyChanged();
          parama = parama.VvD;
          if (parama == null)
          {
            kotlin.g.b.s.bIx("mBottomSheet");
            parama = null;
            parama.sRw = parama.isLandscape();
            parama.sRx = parama.getRotation();
            if (parama.sRs != null)
            {
              ((ViewGroup)parama.rootView.getParent()).setVisibility(0);
              paramcwo = (FrameLayout.LayoutParams)parama.rootView.getLayoutParams();
              if ((parama.sRw) && (parama.mF != null))
              {
                localObject1 = new Rect();
                parama.mF.getWindowVisibleDisplayFrame((Rect)localObject1);
                paramcwo.width = Math.min(((Rect)localObject1).right, ((Rect)localObject1).bottom);
                if (parama.sRA)
                {
                  paramcwo.height = bf.bf(parama.mContext).y;
                  paramcwo.width = bf.bf(parama.mContext).y;
                }
              }
              parama.rootView.setLayoutParams(paramcwo);
              if (Build.VERSION.SDK_INT >= 21) {
                parama.sRs.getWindow().addFlags(-2147483648);
              }
              if ((parama.GwR) && (Build.VERSION.SDK_INT >= 23) && (parama.sRs != null))
              {
                parama.sRs.getWindow().getDecorView().setSystemUiVisibility(9216);
                parama.sRs.getWindow().setStatusBarColor(0);
              }
              paramcwo = parama.sRs.getWindow();
              if (!parama.sRz) {
                break label1380;
              }
              paramcwo.setFlags(8, 8);
              paramcwo.addFlags(131200);
              paramcwo.addFlags(1024);
              com.tencent.mm.plugin.wallet.ui.b.b(paramcwo);
              label1252:
              if (parama.mF != null) {
                if (parama.mP != null) {
                  break label1418;
                }
              }
            }
          }
          for (i = 1;; i = 0)
          {
            parama.mP = parama.mF.getViewTreeObserver();
            if (i != 0) {
              parama.mP.addOnGlobalLayoutListener(parama);
            }
            if (((parama.mContext instanceof Activity)) && (!((Activity)parama.mContext).isFinishing()))
            {
              localObject1 = ((Activity)parama.mContext).getWindow();
              if (parama.sRz) {
                ((Window)localObject1).addFlags(512);
              }
              parama.sRs.show();
              if (parama.sRz)
              {
                com.tencent.mm.plugin.wallet.ui.b.b(paramcwo);
                com.tencent.mm.plugin.wallet.ui.b.b((Window)localObject1);
                paramcwo.clearFlags(8);
              }
            }
            AppMethodBeat.o(316137);
            return;
            break;
            label1380:
            paramcwo.clearFlags(8);
            paramcwo.clearFlags(131072);
            paramcwo.clearFlags(128);
            paramcwo.clearFlags(1024);
            paramcwo.getDecorView().setSystemUiVisibility(0);
            break label1252;
          }
        }
      }
      i = j;
    }
  }
  
  private static final void a(a parama, cwo paramcwo, ArrayList paramArrayList, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = null;
    AppMethodBeat.i(316159);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramcwo);
    localb.cH(paramArrayList);
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", localObject2, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramArrayList, "$secondMenuArray");
    paramView = parama.VvG;
    paramAdapterView = paramView;
    if (paramView == null)
    {
      kotlin.g.b.s.bIx("mSecondAdapter");
      paramAdapterView = null;
    }
    if ((paramAdapterView.VvK) && (paramInt == 2))
    {
      paramArrayList = parama.oW;
      if (paramArrayList == null)
      {
        kotlin.g.b.s.bIx("mCustomView");
        paramArrayList = localObject1;
        if (!((CheckBox)paramArrayList.findViewById(a.f.recharge_agreement_link_checkbox)).isChecked()) {
          break label259;
        }
        paramArrayList = new c(parama);
        paramcwo = new d(paramcwo.aaBK.aceR, parama.VtZ, (c)paramArrayList);
        new b((Context)parama.VvB, paramcwo).show();
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(316159);
      return;
      break;
      label259:
      parama.ihy();
      continue;
      paramcwo = paramArrayList.get(paramInt);
      kotlin.g.b.s.s(paramcwo, "secondMenuArray[position]");
      parama.a((gij)paramcwo);
    }
  }
  
  private static final void a(a parama, Boolean paramBoolean)
  {
    AppMethodBeat.i(316110);
    kotlin.g.b.s.u(parama, "this$0");
    parama.p(paramBoolean);
    AppMethodBeat.o(316110);
  }
  
  private static final void a(a parama, Integer paramInteger)
  {
    AppMethodBeat.i(316092);
    kotlin.g.b.s.u(parama, "this$0");
    Log.d("MicroMsg.BuyGoodsBottomDialog", kotlin.g.b.s.X("updateCheckBox: ", paramInteger));
    int i;
    label45:
    Object localObject;
    CheckBox localCheckBox;
    if (paramInteger != null)
    {
      ((Number)paramInteger).intValue();
      if (paramInteger != null) {
        break label187;
      }
      i = 6;
      parama.VvE.asf(i);
      View localView = parama.oW;
      localObject = localView;
      if (localView == null)
      {
        kotlin.g.b.s.bIx("mCustomView");
        localObject = null;
      }
      localCheckBox = (CheckBox)((View)localObject).findViewById(a.f.recharge_agreement_link_checkbox);
      localView = parama.oW;
      localObject = localView;
      if (localView == null)
      {
        kotlin.g.b.s.bIx("mCustomView");
        localObject = null;
      }
      localObject = (LinearLayout)((View)localObject).findViewById(a.f.recharge_agreement_checkbox_ll);
      if (parama.VtZ) {
        localCheckBox.setBackground(parama.VvB.getResources().getDrawable(com.tencent.mm.plugin.wxpay.a.e.wecoin_checkbox_dark_btn, null));
      }
      if (paramInteger != null) {
        break label200;
      }
    }
    label157:
    for (boolean bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      ((LinearLayout)localObject).setOnClickListener(new a..ExternalSyntheticLambda3(localCheckBox, parama));
      AppMethodBeat.o(316092);
      return;
      label187:
      if (paramInteger.intValue() != 0) {
        break;
      }
      i = 7;
      break label45;
      label200:
      if (paramInteger.intValue() != 0) {
        break label157;
      }
    }
  }
  
  private static final void a(a parama, Long paramLong)
  {
    Object localObject = null;
    AppMethodBeat.i(316104);
    kotlin.g.b.s.u(parama, "this$0");
    Log.d("MicroMsg.BuyGoodsBottomDialog", kotlin.g.b.s.X("updateTitleBalance: ", paramLong));
    long l;
    View localView;
    if (paramLong != null)
    {
      l = ((Number)paramLong).longValue();
      localView = parama.nJ;
      paramLong = localView;
      if (localView == null)
      {
        kotlin.g.b.s.bIx("mHeaderView");
        paramLong = null;
      }
      localView = paramLong.findViewById(a.f.right_balance_ll);
      localView.setVisibility(0);
      paramLong = parama.nJ;
      if (paramLong != null) {
        break label212;
      }
      kotlin.g.b.s.bIx("mHeaderView");
      paramLong = localObject;
    }
    label212:
    for (;;)
    {
      paramLong = paramLong.findViewById(a.f.recharge_product_total_balance_tv);
      kotlin.g.b.s.s(paramLong, "mHeaderView.findViewById…product_total_balance_tv)");
      paramLong = (TextView)paramLong;
      com.tencent.mm.plugin.wallet.wecoin.utils.c.s(paramLong, 15);
      aw.a((Paint)paramLong.getPaint(), 0.8F);
      if (parama.VtZ) {
        paramLong.setTextColor(parama.VvB.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.BW_100_Alpha_0_8));
      }
      paramLong.setText((CharSequence)kotlin.g.b.s.X("", Long.valueOf(l)));
      localView.setContentDescription((CharSequence)parama.VvB.getString(a.i.wecoin_balance_accessibility, new Object[] { String.valueOf(l) }));
      AppMethodBeat.o(316104);
      return;
    }
  }
  
  private static final void a(a parama, String paramString)
  {
    AppMethodBeat.i(316085);
    kotlin.g.b.s.u(parama, "this$0");
    Log.d("MicroMsg.BuyGoodsBottomDialog", kotlin.g.b.s.X("updateAgreementLinkText: ", paramString));
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Object localObject2 = parama.oW;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("mCustomView");
          localObject1 = null;
        }
        localObject1 = (TextView)((View)localObject1).findViewById(a.f.recharge_agreement_link_text);
        kotlin.g.b.s.s(localObject1, "linkText");
        com.tencent.mm.plugin.wallet.wecoin.utils.c.s((TextView)localObject1, 14);
        if (parama.VtZ) {
          ((TextView)localObject1).setTextColor(parama.VvB.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.BW_100_Alpha_0_3));
        }
        localObject2 = parama.VvB.getString(a.i.wallet_lqt_plan_protocal_prefix_text);
        kotlin.g.b.s.s(localObject2, "context.getString(R.stri…lan_protocal_prefix_text)");
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject2);
        String str = parama.VvB.getString(a.i.wecoin_recharge_agreement_link_text);
        kotlin.g.b.s.s(str, "context.getString(R.stri…arge_agreement_link_text)");
        localSpannableStringBuilder.append((CharSequence)str);
        localSpannableStringBuilder.setSpan(new com.tencent.mm.wallet_core.ui.f(new a..ExternalSyntheticLambda15(parama, paramString)), ((String)localObject2).length(), localSpannableStringBuilder.length(), 18);
        ((TextView)localObject1).setText((CharSequence)localSpannableStringBuilder);
        ((TextView)localObject1).setClickable(true);
        ((TextView)localObject1).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s((Context)parama.VvB));
        ((TextView)localObject1).setVisibility(0);
      }
      AppMethodBeat.o(316085);
      return;
    }
  }
  
  private static final void a(a parama, String paramString, View paramView)
  {
    AppMethodBeat.i(316171);
    kotlin.g.b.s.u(parama, "this$0");
    parama.VvE.asf(8);
    com.tencent.mm.wallet_core.ui.i.p((Context)parama.VvB, paramString, true);
    AppMethodBeat.o(316171);
  }
  
  private static final void a(a parama, ArrayList paramArrayList, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(316153);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramArrayList);
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramArrayList, "$firstMenuArray");
    paramArrayList = paramArrayList.get(paramInt);
    kotlin.g.b.s.s(paramArrayList, "firstMenuArray[position]");
    parama.a((gij)paramArrayList);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(316153);
  }
  
  private final void a(gij paramgij)
  {
    Object localObject2 = null;
    AppMethodBeat.i(316047);
    View localView = this.oW;
    Object localObject1 = localView;
    if (localView == null)
    {
      kotlin.g.b.s.bIx("mCustomView");
      localObject1 = null;
    }
    if (((CheckBox)((View)localObject1).findViewById(a.f.recharge_agreement_link_checkbox)).isChecked())
    {
      this.VvH = true;
      localObject1 = this.VvI;
      if (localObject1 != null) {
        ((e.a)localObject1).onCancel((com.tencent.mm.plugin.wallet.wecoin.a.e)this);
      }
      localObject1 = this.VvJ;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.wallet.wecoin.a.b)localObject1).onClick();
      }
      localObject1 = this.VvD;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("mBottomSheet");
        localObject1 = localObject2;
        ((com.tencent.mm.plugin.wallet.ui.b)localObject1).cyW();
        localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
        com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a.reportGiftOnReturn();
        this.VvE.a((Activity)this.VvB, paramgij, this.VvC.mScene);
      }
    }
    for (;;)
    {
      this.VvE.asf(5);
      AppMethodBeat.o(316047);
      return;
      break;
      ihy();
    }
  }
  
  private static final void b(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(316078);
    kotlin.g.b.s.u(parama, "this$0");
    Log.d("MicroMsg.BuyGoodsBottomDialog", "setCancelCallback");
    paramDialogInterface = parama.VvI;
    if (paramDialogInterface != null) {
      paramDialogInterface.onCancel((com.tencent.mm.plugin.wallet.wecoin.a.e)parama);
    }
    AppMethodBeat.o(316078);
  }
  
  private static final void c(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(316184);
    kotlin.g.b.s.u(parama, "this$0");
    if ((!parama.VvB.isFinishing()) && (!parama.VvB.isDestroyed()))
    {
      paramDialogInterface = parama.VvE;
      Log.i("MicroMsg.RechargeProductsDialogViewModel", kotlin.g.b.s.X("cancelPrepareRecharge, mPrepareCgi: ", paramDialogInterface.Vut));
      Object localObject = paramDialogInterface.Vut;
      if (localObject != null) {
        ((m)localObject).cancel();
      }
      paramDialogInterface.h(3, 2, 0, "");
      paramDialogInterface = parama.VvE;
      Log.i("MicroMsg.RechargeProductsDialogViewModel", kotlin.g.b.s.X("cancelGetPriceListRequest, mGetPriceListCgi: ", paramDialogInterface.Vuu));
      localObject = paramDialogInterface.Vuu;
      if (localObject != null) {
        ((com.tencent.mm.plugin.wallet.wecoin.b.k)localObject).cancel();
      }
      paramDialogInterface.h(8, 2, 0, "");
      parama.VvB.finish();
    }
    paramDialogInterface = parama.lKp;
    if ((paramDialogInterface != null) && (paramDialogInterface.isShowing()))
    {
      paramDialogInterface.dismiss();
      parama.lKp = null;
    }
    AppMethodBeat.o(316184);
  }
  
  private final void ihy()
  {
    AppMethodBeat.i(316055);
    Animation localAnimation = AnimationUtils.loadAnimation((Context)this.VvB, com.tencent.mm.plugin.wxpay.a.a.anim_shake_horizontal);
    View localView2 = this.oW;
    View localView1 = localView2;
    if (localView2 == null)
    {
      kotlin.g.b.s.bIx("mCustomView");
      localView1 = null;
    }
    ((LinearLayout)localView1.findViewById(a.f.recharge_agreement_link_ll)).startAnimation(localAnimation);
    AppMethodBeat.o(316055);
  }
  
  private final boolean ihz()
  {
    AppMethodBeat.i(316068);
    int i;
    int j;
    if ((this.VvC.mScene == 1) && (!isLandscape()))
    {
      i = 1;
      if ((this.VvC.mScene != 3) && (this.VvC.mScene != 4)) {
        break label115;
      }
      j = 1;
      label50:
      if ((j == 0) || (this.VvC.Vub != com.tencent.mm.plugin.wallet.wecoin.a.f.VtU)) {
        break label120;
      }
      j = 1;
      label69:
      if ((this.VvC.mScene != 9) || (isLandscape())) {
        break label125;
      }
    }
    label115:
    label120:
    label125:
    for (int k = 1;; k = 0)
    {
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label130;
      }
      AppMethodBeat.o(316068);
      return true;
      i = 0;
      break;
      j = 0;
      break label50;
      j = 0;
      break label69;
    }
    label130:
    AppMethodBeat.o(316068);
    return false;
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(316058);
    if (this.VvB.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(316058);
      return true;
    }
    AppMethodBeat.o(316058);
    return false;
  }
  
  private final void p(Boolean paramBoolean)
  {
    AppMethodBeat.i(316036);
    Log.d("MicroMsg.BuyGoodsBottomDialog", kotlin.g.b.s.X("showProgressDialog: ", paramBoolean));
    if (paramBoolean == null)
    {
      AppMethodBeat.o(316036);
      return;
    }
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = w.a((Context)this.VvB, (CharSequence)this.VvB.getString(a.i.loading_tips), true, 3, new a..ExternalSyntheticLambda1(this));; paramBoolean = null)
    {
      this.lKp = paramBoolean;
      AppMethodBeat.o(316036);
      return;
      paramBoolean = this.lKp;
      if (paramBoolean != null) {
        paramBoolean.dismiss();
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.wallet.wecoin.a.b paramb)
  {
    this.VvJ = paramb;
  }
  
  public final void a(e.a parama)
  {
    this.VvI = parama;
  }
  
  public final void cyW()
  {
    AppMethodBeat.i(316337);
    com.tencent.mm.plugin.wallet.ui.b localb2 = this.VvD;
    com.tencent.mm.plugin.wallet.ui.b localb1 = localb2;
    if (localb2 == null)
    {
      kotlin.g.b.s.bIx("mBottomSheet");
      localb1 = null;
    }
    localb1.cyW();
    AppMethodBeat.o(316337);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$ViewHolder;", "Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog;", "(Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog;)V", "mItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "getMItemClickListener", "()Landroid/widget/AdapterView$OnItemClickListener;", "setMItemClickListener", "(Landroid/widget/AdapterView$OnItemClickListener;)V", "mViewWidth", "", "mmMenu", "Lcom/tencent/mm/ui/base/MMMenu;", "shouldShowCustomInput", "", "getShouldShowCustomInput", "()Z", "setShouldShowCustomInput", "(Z)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setMenu", "menu", "setOnItemClickListener", "listener", "ViewHolder", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.a<a>
  {
    com.tencent.mm.ui.base.s GAB;
    boolean VvK;
    private int mViewWidth;
    AdapterView.OnItemClickListener un;
    
    public b()
    {
      AppMethodBeat.i(315903);
      AppMethodBeat.o(315903);
    }
    
    private static final void ca(kotlin.g.a.a parama)
    {
      AppMethodBeat.i(315911);
      kotlin.g.b.s.u(parama, "$func");
      parama.invoke();
      AppMethodBeat.o(315911);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(315928);
      com.tencent.mm.ui.base.s locals = this.GAB;
      if (locals == null)
      {
        AppMethodBeat.o(315928);
        return 0;
      }
      int i = locals.size();
      AppMethodBeat.o(315928);
      return i;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter;Landroid/view/View;)V", "balanceCountTV", "Landroid/widget/TextView;", "getBalanceCountTV", "()Landroid/widget/TextView;", "setBalanceCountTV", "(Landroid/widget/TextView;)V", "icon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "rootView", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "topArea", "getTopArea", "totalBalanceTV", "getTotalBalanceTV", "setTotalBalanceTV", "customInputLayout", "", "normalLayout", "onClick", "v", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class a
      extends RecyclerView.v
      implements View.OnClickListener
    {
      final WeImageView EoD;
      final View VvM;
      TextView VvN;
      TextView VvO;
      private View rootView;
      
      public a()
      {
        super();
        AppMethodBeat.i(315874);
        localObject.setOnClickListener((View.OnClickListener)this);
        this$1 = localObject.findViewById(a.f.recharge_product_balance_count_tv);
        kotlin.g.b.s.s(a.b.this, "itemView.findViewById(R.…product_balance_count_tv)");
        this.VvN = ((TextView)a.b.this);
        aw.a((Paint)this.VvN.getPaint(), 0.8F);
        com.tencent.mm.plugin.wallet.wecoin.utils.c.s(this.VvN, 24);
        this$1 = localObject.findViewById(a.f.recharge_product_total_balance_tv);
        kotlin.g.b.s.s(a.b.this, "itemView.findViewById(R.…product_total_balance_tv)");
        this.VvO = ((TextView)a.b.this);
        com.tencent.mm.plugin.wallet.wecoin.utils.c.s(this.VvO, 14);
        this$1 = localObject.findViewById(a.f.root);
        kotlin.g.b.s.s(a.b.this, "itemView.findViewById(R.id.root)");
        this.rootView = a.b.this;
        if ((a.f(a.b.this.VvL)) || (aw.isDarkMode())) {
          this.rootView.setBackground(a.b.this.VvL.VvB.getResources().getDrawable(com.tencent.mm.plugin.wxpay.a.e.wecoin_product_bar_dark_bg, null));
        }
        this$1 = localObject.findViewById(a.f.wecoin_show_product_icon_iv);
        kotlin.g.b.s.s(a.b.this, "itemView.findViewById(R.…oin_show_product_icon_iv)");
        this.EoD = ((WeImageView)a.b.this);
        this$1 = localObject.findViewById(a.f.top_area);
        kotlin.g.b.s.s(a.b.this, "itemView.findViewById(R.id.top_area)");
        this.VvM = a.b.this;
        AppMethodBeat.o(315874);
      }
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(315883);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        kotlin.g.b.s.u(paramView, "v");
        localObject = a.b.this.un;
        if (localObject != null) {
          ((AdapterView.OnItemClickListener)localObject).onItemClick(null, paramView, getPosition(), getPosition());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(315883);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<kotlin.ah>
    {
      b(a parama, a.b paramb, a.b.a parama1)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$handleClickCustomInputItem$callback$1", "Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinCustomAmountInputDialogCallback;", "confirmWithAmount", "", "amount", "", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements c
  {
    c(a parama) {}
    
    public final void xy(long paramLong)
    {
      Object localObject2 = null;
      AppMethodBeat.i(315917);
      a.a(this.VvL);
      Object localObject1 = a.b(this.VvL);
      if (localObject1 != null) {
        ((e.a)localObject1).onCancel((com.tencent.mm.plugin.wallet.wecoin.a.e)this.VvL);
      }
      localObject1 = a.c(this.VvL);
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.wallet.wecoin.a.b)localObject1).onClick();
      }
      Object localObject3 = a.d(this.VvL);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("mBottomSheet");
        localObject1 = null;
      }
      ((com.tencent.mm.plugin.wallet.ui.b)localObject1).cyW();
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
      com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a.reportGiftOnReturn();
      localObject1 = a.e(this.VvL);
      localObject3 = (Activity)this.VvL.VvB;
      kotlin.g.b.s.u(localObject3, "context");
      Log.i("MicroMsg.RechargeProductsDialogViewModel", kotlin.g.b.s.X("directRecharge, amount: ", Long.valueOf(paramLong)));
      ((com.tencent.mm.plugin.wallet.wecoin.model.e)localObject1).wIq.t(Boolean.TRUE);
      e.c localc = new e.c((com.tencent.mm.plugin.wallet.wecoin.model.e)localObject1);
      com.tencent.mm.plugin.wallet.wecoin.a.h localh = new com.tencent.mm.plugin.wallet.wecoin.a.h();
      Object localObject4 = (cwo)((LiveData)((com.tencent.mm.plugin.wallet.wecoin.model.e)localObject1).Vus).getValue();
      if (localObject4 != null)
      {
        localh.hBT = ((cwo)localObject4).aaBK.aceQ.MQZ;
        localh.Vuc = ((cwo)localObject4).aaBJ;
      }
      localh.Vue = paramLong;
      localObject4 = ((com.tencent.mm.plugin.wallet.wecoin.model.e)localObject1).Vuz;
      int i;
      if (localObject4 == null)
      {
        i = 0;
        localh.mScene = i;
        localObject1 = ((com.tencent.mm.plugin.wallet.wecoin.model.e)localObject1).Vux;
        if (localObject1 != null) {
          break label334;
        }
        kotlin.g.b.s.bIx("mSceneSessionID");
        localObject1 = localObject2;
      }
      label334:
      for (;;)
      {
        localh.Vua = ((String)localObject1);
        localh.VtR = ((com.tencent.mm.plugin.wallet.wecoin.a.i)localc);
        localh.Vud = g.VtW;
        ((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).a((FragmentActivity)localObject3, localh);
        AppMethodBeat.o(315917);
        return;
        i = ((com.tencent.mm.plugin.wallet.wecoin.a.h)localObject4).mScene;
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$handleInterceptWinInfo$1$clickListener$1", "Lcom/tencent/mm/plugin/wallet/wecoin/model/InterceptWinClickListener;", "onClick", "", "item", "Lcom/tencent/mm/protocal/protobuf/PopUpJumpInfo;", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.plugin.wallet.wecoin.model.b
  {
    d(a parama, String paramString, egw paramegw) {}
    
    public final void a(efg paramefg)
    {
      AppMethodBeat.i(315909);
      if (paramefg != null)
      {
        String str = paramd;
        a locala = this.VvL;
        egw localegw = localegw;
        if (paramefg.action == 3)
        {
          paramefg = (CharSequence)str;
          if ((paramefg == null) || (paramefg.length() == 0)) {}
          for (int i = 1; i == 0; i = 0)
          {
            a.e(locala).a((Activity)locala.VvB, localegw, "release", str);
            AppMethodBeat.o(315909);
            return;
          }
        }
      }
      paramefg = this.VvL.VvC;
      if (paramefg != null)
      {
        paramefg = paramefg.VtR;
        if (paramefg != null) {
          paramefg.s(4, 10000, "");
        }
      }
      AppMethodBeat.o(315909);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$setAnimationOut$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends AnimatorListenerAdapter
  {
    e(a parama, View paramView) {}
    
    private static final void h(a parama)
    {
      AppMethodBeat.i(315912);
      kotlin.g.b.s.u(parama, "this$0");
      com.tencent.mm.plugin.wallet.ui.b localb = a.d(parama);
      parama = localb;
      if (localb == null)
      {
        kotlin.g.b.s.bIx("mBottomSheet");
        parama = null;
      }
      parama.cyW();
      AppMethodBeat.o(315912);
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(315922);
      kotlin.g.b.s.u(paramAnimator, "animation");
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(315922);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(315932);
      kotlin.g.b.s.u(paramAnimator, "animation");
      com.tencent.mm.plugin.wallet.ui.b localb = a.d(this.VvL);
      paramAnimator = localb;
      if (localb == null)
      {
        kotlin.g.b.s.bIx("mBottomSheet");
        paramAnimator = null;
      }
      paramAnimator = paramAnimator.rootView.getParent();
      if (paramAnimator == null)
      {
        paramAnimator = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(315932);
        throw paramAnimator;
      }
      ((ViewGroup)paramAnimator).setVisibility(8);
      paramView.post(new a.e..ExternalSyntheticLambda0(this.VvL));
      AppMethodBeat.o(315932);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.a
 * JD-Core Version:    0.7.0.1
 */