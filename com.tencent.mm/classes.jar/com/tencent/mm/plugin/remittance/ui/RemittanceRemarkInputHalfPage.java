package com.tencent.mm.plugin.remittance.ui;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.j.a;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.remittance.model.al;
import com.tencent.mm.plugin.wallet_core.utils.WcPayTextApppearanceSpan;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Lcom/tencent/mm/ui/MMActivity;", "maxLimitLength", "", "placeorderReserves", "", "entryScene", "Lcom/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$EntryScene;", "(Lcom/tencent/mm/ui/MMActivity;ILjava/lang/String;Lcom/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$EntryScene;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getEntryScene", "()Lcom/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$EntryScene;", "mHalfPageDialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "mKeyboardHeight", "mKeyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "getMaxLimitLength", "()I", "getPlaceorderReserves", "()Ljava/lang/String;", "animHideKeyboard", "", "animShowKeyboard", "height", "onActivityPause", "onActivityResume", "showDialog", "desc", "hint", "callback", "Lcom/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$InputResultCallback;", "transferReportType", "actionFlow", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Companion", "EntryScene", "InputResultCallback", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RemittanceRemarkInputHalfPage
  implements androidx.lifecycle.p
{
  public static final RemittanceRemarkInputHalfPage.a Ost;
  final int Osu;
  final String Osv;
  final RemittanceRemarkInputHalfPage.b Osw;
  private com.tencent.mm.ui.widget.a.j Osx;
  private com.tencent.mm.ui.tools.i Osy;
  final MMActivity lzt;
  private int moI;
  
  static
  {
    AppMethodBeat.i(289055);
    Ost = new RemittanceRemarkInputHalfPage.a((byte)0);
    AppMethodBeat.o(289055);
  }
  
  public RemittanceRemarkInputHalfPage(MMActivity paramMMActivity, int paramInt, String paramString, RemittanceRemarkInputHalfPage.b paramb)
  {
    AppMethodBeat.i(288999);
    this.lzt = paramMMActivity;
    this.Osu = paramInt;
    this.Osv = paramString;
    this.Osw = paramb;
    this.Osy = new com.tencent.mm.ui.tools.i((Activity)this.lzt);
    this.lzt.getLifecycle().addObserver((androidx.lifecycle.p)this);
    this.Osy.afIL = new RemittanceRemarkInputHalfPage..ExternalSyntheticLambda5(this);
    AppMethodBeat.o(288999);
  }
  
  private static final void a(c paramc, MMEditText paramMMEditText, ah.f paramf, RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage, com.tencent.mm.ui.widget.a.j paramj, ArrayList paramArrayList)
  {
    AppMethodBeat.i(289042);
    s.u(paramc, "$callback");
    s.u(paramMMEditText, "$remarkEt");
    s.u(paramf, "$addressString");
    s.u(paramRemittanceRemarkInputHalfPage, "this$0");
    s.u(paramj, "$it");
    s.u(paramArrayList, "$actionFlow");
    paramc.f(false, paramMMEditText.getText().toString(), (String)paramf.aqH);
    paramRemittanceRemarkInputHalfPage.lzt.hideVKB((View)paramMMEditText);
    paramj.cyW();
    int i;
    if (!paramArrayList.isEmpty())
    {
      paramc = Util.listToString((List)paramArrayList, ",");
      Log.i("MicroMsg.RemittanceRemarkInputHalfPage", "action flow: %s", new Object[] { paramc });
      s.s(paramc, "s");
      if ((n.U(paramc, "1,2,1", false)) || (n.U(paramc, "2,1", false))) {
        i = 5;
      }
    }
    for (;;)
    {
      if ((i != 0) && (paramRemittanceRemarkInputHalfPage.Osw == RemittanceRemarkInputHalfPage.b.Osz)) {
        com.tencent.mm.plugin.report.service.h.OAn.b(22750, new Object[] { Integer.valueOf(i), paramRemittanceRemarkInputHalfPage.Osv });
      }
      AppMethodBeat.o(289042);
      return;
      if (n.U(paramc, "1,2", false)) {
        i = 3;
      } else if (n.U(paramc, "1", false)) {
        i = 2;
      } else if (n.U(paramc, "2", false)) {
        i = 4;
      } else {
        i = 0;
      }
    }
  }
  
  private static final void a(c paramc, ah.f paramf, RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage, MMEditText paramMMEditText, com.tencent.mm.ui.widget.a.j paramj)
  {
    AppMethodBeat.i(289032);
    s.u(paramc, "$callback");
    s.u(paramf, "$addressString");
    s.u(paramRemittanceRemarkInputHalfPage, "this$0");
    s.u(paramMMEditText, "$remarkEt");
    s.u(paramj, "$it");
    paramc.f(true, null, (String)paramf.aqH);
    paramRemittanceRemarkInputHalfPage.lzt.hideVKB((View)paramMMEditText);
    paramj.cyW();
    AppMethodBeat.o(289032);
  }
  
  private static final void a(RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage)
  {
    AppMethodBeat.i(289010);
    s.u(paramRemittanceRemarkInputHalfPage, "this$0");
    paramRemittanceRemarkInputHalfPage.lzt.showVKB();
    AppMethodBeat.o(289010);
  }
  
  private static final void a(RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(289001);
    s.u(paramRemittanceRemarkInputHalfPage, "this$0");
    paramRemittanceRemarkInputHalfPage.moI = paramInt;
    Object localObject;
    if (paramInt > 0)
    {
      localObject = paramRemittanceRemarkInputHalfPage.Osx;
      if ((localObject != null) && (((com.tencent.mm.ui.widget.a.j)localObject).isShowing()))
      {
        if (((com.tencent.mm.ui.widget.a.j)localObject).rootView.getLayoutParams() == null)
        {
          paramRemittanceRemarkInputHalfPage = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(289001);
          throw paramRemittanceRemarkInputHalfPage;
        }
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, paramInt });
        localValueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
        localValueAnimator.addUpdateListener(new RemittanceRemarkInputHalfPage..ExternalSyntheticLambda0(paramRemittanceRemarkInputHalfPage, (com.tencent.mm.ui.widget.a.j)localObject));
        localValueAnimator.addListener((Animator.AnimatorListener)new RemittanceRemarkInputHalfPage.e((com.tencent.mm.ui.widget.a.j)localObject));
        localValueAnimator.setDuration(200L);
        localValueAnimator.start();
      }
      AppMethodBeat.o(289001);
      return;
    }
    paramRemittanceRemarkInputHalfPage = paramRemittanceRemarkInputHalfPage.Osx;
    if ((paramRemittanceRemarkInputHalfPage != null) && (paramRemittanceRemarkInputHalfPage.isShowing()))
    {
      if (paramRemittanceRemarkInputHalfPage.rootView.getLayoutParams() == null)
      {
        paramRemittanceRemarkInputHalfPage = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(289001);
        throw paramRemittanceRemarkInputHalfPage;
      }
      localObject = ValueAnimator.ofInt(new int[] { paramRemittanceRemarkInputHalfPage.rootView.getPaddingBottom(), 0 });
      ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      ((ValueAnimator)localObject).addUpdateListener(new RemittanceRemarkInputHalfPage..ExternalSyntheticLambda1(paramRemittanceRemarkInputHalfPage));
      paramRemittanceRemarkInputHalfPage.rootView.getPaddingBottom();
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new RemittanceRemarkInputHalfPage.d(paramRemittanceRemarkInputHalfPage));
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).start();
    }
    AppMethodBeat.o(289001);
  }
  
  private static final void a(RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage, MMEditText paramMMEditText, ah.a parama, ah.f paramf, ArrayList paramArrayList, View paramView)
  {
    AppMethodBeat.i(289026);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRemittanceRemarkInputHalfPage);
    localb.cH(paramMMEditText);
    localb.cH(parama);
    localb.cH(paramf);
    localb.cH(paramArrayList);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRemittanceRemarkInputHalfPage, "this$0");
    s.u(paramMMEditText, "$remarkEt");
    s.u(parama, "$isInsertAddress");
    s.u(paramf, "$addressString");
    s.u(paramArrayList, "$actionFlow");
    paramView = new Intent();
    paramView.putExtra("launch_from_remittance", true);
    paramRemittanceRemarkInputHalfPage.lzt.mmSetOnActivityResultCallback(new RemittanceRemarkInputHalfPage..ExternalSyntheticLambda4(paramMMEditText, parama, paramf, paramArrayList, paramRemittanceRemarkInputHalfPage));
    paramRemittanceRemarkInputHalfPage.lzt.hideVKB((View)paramMMEditText);
    c.b((Context)paramRemittanceRemarkInputHalfPage.lzt, "address", ".ui.WalletSelectAddrUI", paramView, 123);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289026);
  }
  
  private static final void a(RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage, com.tencent.mm.ui.widget.a.j paramj, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(289046);
    s.u(paramRemittanceRemarkInputHalfPage, "this$0");
    s.u(paramj, "$it");
    if ((!w.mO((Context)paramRemittanceRemarkInputHalfPage.lzt)) && (!aw.jlb()) && (d.rc(30)))
    {
      paramRemittanceRemarkInputHalfPage = paramj.rootView;
      paramj = paramValueAnimator.getAnimatedValue();
      if (paramj == null)
      {
        paramRemittanceRemarkInputHalfPage = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(289046);
        throw paramRemittanceRemarkInputHalfPage;
      }
      paramRemittanceRemarkInputHalfPage.setPadding(0, 0, 0, ((Integer)paramj).intValue());
    }
    AppMethodBeat.o(289046);
  }
  
  private static final void a(MMEditText paramMMEditText, RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage, WeImageView paramWeImageView)
  {
    AppMethodBeat.i(289045);
    s.u(paramMMEditText, "$remarkEt");
    s.u(paramRemittanceRemarkInputHalfPage, "this$0");
    s.u(paramWeImageView, "$addressIcon");
    paramMMEditText.requestFocus();
    paramRemittanceRemarkInputHalfPage.lzt.showVKB();
    if (paramWeImageView.isShown())
    {
      paramRemittanceRemarkInputHalfPage = paramWeImageView.getLayoutParams();
      if (paramRemittanceRemarkInputHalfPage == null)
      {
        paramMMEditText = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(289045);
        throw paramMMEditText;
      }
      paramRemittanceRemarkInputHalfPage = (LinearLayout.LayoutParams)paramRemittanceRemarkInputHalfPage;
      if ((paramMMEditText.getLineCount() <= 1) && (paramRemittanceRemarkInputHalfPage.gravity != 16))
      {
        paramRemittanceRemarkInputHalfPage.gravity = 16;
        paramWeImageView.setLayoutParams((ViewGroup.LayoutParams)paramRemittanceRemarkInputHalfPage);
        AppMethodBeat.o(289045);
        return;
      }
      if ((paramMMEditText.getLineCount() > 1) && (paramRemittanceRemarkInputHalfPage.gravity > 0))
      {
        paramRemittanceRemarkInputHalfPage.gravity = 0;
        paramWeImageView.setLayoutParams((ViewGroup.LayoutParams)paramRemittanceRemarkInputHalfPage);
      }
    }
    AppMethodBeat.o(289045);
  }
  
  private static final void a(MMEditText paramMMEditText, ah.a parama, ah.f paramf, ArrayList paramArrayList, RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(289017);
    s.u(paramMMEditText, "$remarkEt");
    s.u(parama, "$isInsertAddress");
    s.u(paramf, "$addressString");
    s.u(paramArrayList, "$actionFlow");
    s.u(paramRemittanceRemarkInputHalfPage, "this$0");
    if (paramInt1 == 123)
    {
      if (paramInt2 != -1) {
        break label612;
      }
      Object localObject6 = paramIntent.getStringExtra("userName");
      Object localObject5 = paramIntent.getStringExtra("telNumber");
      Object localObject4 = paramIntent.getStringExtra("proviceFirstStageName");
      Object localObject3 = paramIntent.getStringExtra("addressCitySecondStageName");
      Object localObject1 = paramIntent.getStringExtra("addressCountiesThirdStageName");
      paramIntent = paramIntent.getStringExtra("addressDetailInfo");
      Object localObject2 = new StringBuilder();
      CharSequence localCharSequence = (CharSequence)localObject6;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label564;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        ((StringBuilder)localObject2).append((String)localObject6);
      }
      localObject6 = (CharSequence)localObject5;
      if ((localObject6 != null) && (((CharSequence)localObject6).length() != 0)) {
        break label570;
      }
      paramInt1 = 1;
      label183:
      if (paramInt1 == 0) {
        ((StringBuilder)localObject2).append((String)localObject5);
      }
      if (((CharSequence)localObject2).length() != 0) {
        break label576;
      }
      paramInt1 = 1;
      label212:
      if (paramInt1 == 0) {
        ((StringBuilder)localObject2).append(" ");
      }
      localObject5 = (CharSequence)localObject4;
      if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
        break label582;
      }
      paramInt1 = 1;
      label251:
      if (paramInt1 == 0) {
        ((StringBuilder)localObject2).append((String)localObject4);
      }
      localObject4 = (CharSequence)localObject3;
      if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
        break label588;
      }
      paramInt1 = 1;
      label289:
      if (paramInt1 == 0) {
        ((StringBuilder)localObject2).append((String)localObject3);
      }
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label594;
      }
      paramInt1 = 1;
      label327:
      if (paramInt1 == 0) {
        ((StringBuilder)localObject2).append((String)localObject1);
      }
      localObject1 = (CharSequence)paramIntent;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label600;
      }
      paramInt1 = 1;
      label365:
      if (paramInt1 == 0) {
        ((StringBuilder)localObject2).append(paramIntent);
      }
      paramIntent = ((StringBuilder)localObject2).toString();
      s.s(paramIntent, "StringBuilder().apply(builderAction).toString()");
      localObject1 = paramMMEditText.getText().toString();
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label606;
      }
      paramInt1 = 1;
      label427:
      if ((paramInt1 == 0) && (!n.rs((String)localObject1, ";")))
      {
        paramMMEditText.getText().append((CharSequence)";");
        paramMMEditText.setSelection(paramMMEditText.getText().length());
      }
      parama.aiwY = true;
      paramMMEditText.bDt(s.X(paramIntent, ";"));
      paramf.aqH = s.X((String)paramf.aqH, paramIntent);
      if ((paramArrayList.isEmpty()) || (!s.p(kotlin.a.p.oM((List)paramArrayList), "2"))) {
        paramArrayList.add("2");
      }
    }
    for (;;)
    {
      com.tencent.threadpool.h.ahAA.o(new RemittanceRemarkInputHalfPage..ExternalSyntheticLambda8(paramRemittanceRemarkInputHalfPage), 100L);
      AppMethodBeat.o(289017);
      return;
      label564:
      paramInt1 = 0;
      break;
      label570:
      paramInt1 = 0;
      break label183;
      label576:
      paramInt1 = 0;
      break label212;
      label582:
      paramInt1 = 0;
      break label251;
      label588:
      paramInt1 = 0;
      break label289;
      label594:
      paramInt1 = 0;
      break label327;
      label600:
      paramInt1 = 0;
      break label365;
      label606:
      paramInt1 = 0;
      break label427;
      label612:
      Log.i("MicroMsg.RemittanceRemarkInputHalfPage", "cancel select address");
    }
  }
  
  private static final void a(com.tencent.mm.ui.widget.a.j paramj, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(289051);
    s.u(paramj, "$it");
    paramj = paramj.rootView;
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramj = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(289051);
      throw paramj;
    }
    paramj.setPadding(0, 0, 0, ((Integer)paramValueAnimator).intValue());
    AppMethodBeat.o(289051);
  }
  
  private static final boolean a(com.tencent.mm.ui.widget.a.j paramj, RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage, MMEditText paramMMEditText, DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(289006);
    s.u(paramj, "$it");
    s.u(paramRemittanceRemarkInputHalfPage, "this$0");
    s.u(paramMMEditText, "$remarkEt");
    if ((paramInt == 4) && (paramj.isShowing()))
    {
      if (paramRemittanceRemarkInputHalfPage.moI <= 0) {
        break label63;
      }
      paramRemittanceRemarkInputHalfPage.lzt.hideVKB((View)paramMMEditText);
    }
    for (;;)
    {
      AppMethodBeat.o(289006);
      return false;
      label63:
      paramj.cyW();
    }
  }
  
  public final void a(String paramString1, String paramString2, c paramc)
  {
    AppMethodBeat.i(289100);
    s.u(paramString1, "desc");
    s.u(paramString2, "hint");
    s.u(paramc, "callback");
    final com.tencent.mm.ui.widget.a.j localj = this.Osx;
    if (localj != null) {
      localj.cyW();
    }
    this.Osx = new com.tencent.mm.ui.widget.a.j((Context)this.lzt, 1, 2, false);
    final ArrayList localArrayList = new ArrayList();
    Object localObject1 = new ah.a();
    localj = this.Osx;
    Object localObject2;
    Object localObject3;
    ViewGroup localViewGroup;
    TextView localTextView;
    Object localObject4;
    if (localj != null)
    {
      localj.jHS();
      localObject2 = LayoutInflater.from((Context)this.lzt);
      i = a.g.remittance_remark_input_half_page;
      localObject3 = localj.rootView;
      if (localObject3 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(289100);
        throw paramString1;
      }
      localObject2 = ((LayoutInflater)localObject2).inflate(i, (ViewGroup)localObject3, false);
      if (localObject2 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(289100);
        throw paramString1;
      }
      localViewGroup = (ViewGroup)localObject2;
      localObject2 = localViewGroup.findViewById(a.f.remittance_remark_input_et);
      s.s(localObject2, "rootView.findViewById(R.…mittance_remark_input_et)");
      localObject2 = (MMEditText)localObject2;
      localObject3 = localViewGroup.findViewById(a.f.remittance_remark_address_icon);
      s.s(localObject3, "rootView.findViewById(R.…ance_remark_address_icon)");
      localObject3 = (WeImageView)localObject3;
      localTextView = (TextView)localViewGroup.findViewById(a.f.remittance_remark_limit_tv);
      localObject4 = localViewGroup.findViewById(a.f.remittance_input_bg_ll);
      s.s(localObject4, "rootView.findViewById(R.id.remittance_input_bg_ll)");
      localObject4 = (LinearLayout)localObject4;
      if (!Util.isNullOrNil(paramString2)) {
        ((MMEditText)localObject2).setHint((CharSequence)paramString2);
      }
      paramString2 = new RemittanceRemarkInputHalfPage..ExternalSyntheticLambda2(localj, this, (MMEditText)localObject2);
      localj.sRs.setOnKeyListener(paramString2);
      com.tencent.mm.wallet_core.ui.i.bG((View)localObject3, com.tencent.mm.cd.a.fromDPToPix((Context)this.lzt, 20));
      if (this.Osw != RemittanceRemarkInputHalfPage.b.Osz) {
        break label902;
      }
      ((LinearLayout)localObject4).setPadding(com.tencent.mm.cd.a.fromDPToPix((Context)this.lzt, 16), com.tencent.mm.cd.a.fromDPToPix((Context)this.lzt, 16), com.tencent.mm.cd.a.fromDPToPix((Context)this.lzt, 6), com.tencent.mm.cd.a.fromDPToPix((Context)this.lzt, 16));
    }
    label896:
    label902:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ((WeImageView)localObject3).setVisibility(0);
        if (Build.VERSION.SDK_INT >= 23) {
          ((WeImageView)localObject3).setForeground(this.lzt.getDrawable(a.e.remittance_address_icon_selector));
        }
        paramString2 = new ah.f();
        paramString2.aqH = "";
        i = paramString1.length();
        if (i <= this.Osu) {
          break label881;
        }
        localj.NG(false);
        localTextView.setTextColor(this.lzt.getResources().getColor(a.c.Red));
        localTextView.setVisibility(0);
        label498:
        ((WeImageView)localObject3).setOnClickListener(new RemittanceRemarkInputHalfPage..ExternalSyntheticLambda3(this, (MMEditText)localObject2, (ah.a)localObject1, paramString2, localArrayList));
        localObject4 = am.aixg;
        localObject4 = String.format("%s/%s", Arrays.copyOf(new Object[] { Integer.valueOf(i), Integer.valueOf(this.Osu) }, 2));
        s.s(localObject4, "java.lang.String.format(format, *args)");
        localTextView.setText((CharSequence)localObject4);
        ((MMEditText)localObject2).addTextChangedListener((TextWatcher)new f(localTextView, this, localj, new ah.a(), (ah.a)localObject1, localArrayList));
        if (((CharSequence)paramString1).length() != 0) {
          break label896;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          ((MMEditText)localObject2).setText((CharSequence)paramString1);
          ((MMEditText)localObject2).setSelection(paramString1.length());
        }
        localj.setCustomView((View)localViewGroup);
        paramString1 = new SpannableStringBuilder();
        paramString1.append((CharSequence)this.lzt.getString(a.i.bank_remit_remittance_desc_text));
        localObject1 = new WcPayTextApppearanceSpan(0, null);
        ((WcPayTextApppearanceSpan)localObject1).VYt = 1;
        paramString1.setSpan(localObject1, 0, paramString1.length(), 18);
        localj.bh((CharSequence)paramString1);
        localj.d((CharSequence)this.lzt.getString(a.i.app_cancel), (CharSequence)this.lzt.getString(a.i.app_ok));
        localj.a(new RemittanceRemarkInputHalfPage..ExternalSyntheticLambda7(paramc, paramString2, this, (MMEditText)localObject2, localj), new RemittanceRemarkInputHalfPage..ExternalSyntheticLambda6(paramc, (MMEditText)localObject2, paramString2, this, localj, localArrayList));
        paramString1 = this.Osy;
        if (paramString1 != null) {
          paramString1.start();
        }
        localj.dDn();
        com.tencent.threadpool.h.ahAA.o(new RemittanceRemarkInputHalfPage..ExternalSyntheticLambda9((MMEditText)localObject2, this, (WeImageView)localObject3), 50L);
        if (this.Osw == RemittanceRemarkInputHalfPage.b.Osz) {
          com.tencent.mm.plugin.report.service.h.OAn.b(22750, new Object[] { Integer.valueOf(1), this.Osv });
        }
        AppMethodBeat.o(289100);
        return;
        ((WeImageView)localObject3).setVisibility(8);
        break;
        label881:
        localj.NG(true);
        localTextView.setVisibility(4);
        break label498;
      }
    }
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public final void onActivityPause()
  {
    AppMethodBeat.i(289109);
    com.tencent.mm.ui.tools.i locali = this.Osy;
    if (locali != null) {
      locali.close();
    }
    AppMethodBeat.o(289109);
  }
  
  @z(Ho=j.a.ON_RESUME)
  public final void onActivityResume()
  {
    AppMethodBeat.i(289103);
    com.tencent.mm.ui.tools.i locali = this.Osy;
    if (locali != null) {
      locali.start();
    }
    AppMethodBeat.o(289103);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$InputResultCallback;", "", "onResult", "", "canceled", "", "result", "", "addressString", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void f(boolean paramBoolean, String paramString1, String paramString2);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$showDialog$1$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements TextWatcher
  {
    f(TextView paramTextView, RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage, com.tencent.mm.ui.widget.a.j paramj, ah.a parama1, ah.a parama2, ArrayList<String> paramArrayList) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(288931);
      s.u(paramEditable, "s");
      int i = paramEditable.toString().length();
      paramEditable = this.OsD;
      Object localObject = am.aixg;
      localObject = String.format("%s/%s", Arrays.copyOf(new Object[] { Integer.valueOf(i), Integer.valueOf(jdField_this.Osu) }, 2));
      s.s(localObject, "java.lang.String.format(format, *args)");
      paramEditable.setText((CharSequence)localObject);
      paramEditable = k.aeZF;
      ((al)k.d((AppCompatActivity)jdField_this.lzt).q(al.class)).setValue("desc_length_key", String.valueOf(i));
      paramEditable = k.aeZF;
      ((al)k.d((AppCompatActivity)jdField_this.lzt).q(al.class)).setValue("desc_max_length_key", String.valueOf(jdField_this.Osu));
      if (i > jdField_this.Osu)
      {
        localj.NG(false);
        this.OsD.setTextColor(jdField_this.lzt.getResources().getColor(a.c.Red));
        this.OsD.setVisibility(0);
        if ((!this.OsF.aiwY) && (jdField_this.Osw == RemittanceRemarkInputHalfPage.b.Osz)) {
          com.tencent.mm.plugin.report.service.h.OAn.b(22750, new Object[] { Integer.valueOf(6), jdField_this.Osv });
        }
      }
      for (this.OsF.aiwY = true; !this.OsG.aiwY; this.OsF.aiwY = false)
      {
        if ((!localArrayList.isEmpty()) && (s.p(kotlin.a.p.oM((List)localArrayList), "1"))) {
          break label351;
        }
        localArrayList.add("1");
        AppMethodBeat.o(288931);
        return;
        localj.NG(true);
        this.OsD.setVisibility(4);
      }
      this.OsG.aiwY = false;
      label351:
      AppMethodBeat.o(288931);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(288924);
      s.u(paramCharSequence, "s");
      AppMethodBeat.o(288924);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(288926);
      s.u(paramCharSequence, "s");
      AppMethodBeat.o(288926);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceRemarkInputHalfPage
 * JD-Core Version:    0.7.0.1
 */