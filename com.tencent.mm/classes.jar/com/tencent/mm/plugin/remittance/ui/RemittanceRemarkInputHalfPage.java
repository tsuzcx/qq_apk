package com.tencent.mm.plugin.remittance.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.f;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Lcom/tencent/mm/ui/MMActivity;", "maxLimitLength", "", "placeorderReserves", "", "(Lcom/tencent/mm/ui/MMActivity;ILjava/lang/String;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "mHalfPageDialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "mKeyboardHeight", "mKeyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "getMaxLimitLength", "()I", "getPlaceorderReserves", "()Ljava/lang/String;", "animHideKeyboard", "", "animShowKeyboard", "height", "onActivityPause", "onActivityResume", "showDialog", "desc", "callback", "Lcom/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$InputResultCallback;", "transferReportType", "actionFlow", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Companion", "InputResultCallback", "plugin-wxpay_release"})
public final class RemittanceRemarkInputHalfPage
  implements k
{
  public static final RemittanceRemarkInputHalfPage.a IuS;
  com.tencent.mm.ui.tools.i Cwc;
  g IuP;
  final int IuQ;
  final String IuR;
  final MMActivity iXq;
  private int jPS;
  
  static
  {
    AppMethodBeat.i(270522);
    IuS = new RemittanceRemarkInputHalfPage.a((byte)0);
    AppMethodBeat.o(270522);
  }
  
  public RemittanceRemarkInputHalfPage(MMActivity paramMMActivity, String paramString)
  {
    AppMethodBeat.i(270520);
    this.iXq = paramMMActivity;
    this.IuQ = 60;
    this.IuR = paramString;
    this.Cwc = new com.tencent.mm.ui.tools.i((Activity)this.iXq);
    this.iXq.getLifecycle().a((k)this);
    this.Cwc.setKeyboardHeightObserver((com.tencent.mm.ui.tools.h)new com.tencent.mm.ui.tools.h()
    {
      public final void A(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(275966);
        RemittanceRemarkInputHalfPage.a(this.IuT, paramAnonymousInt);
        if (paramAnonymousInt > 0)
        {
          RemittanceRemarkInputHalfPage.b(this.IuT, paramAnonymousInt);
          AppMethodBeat.o(275966);
          return;
        }
        RemittanceRemarkInputHalfPage.b(this.IuT);
        AppMethodBeat.o(275966);
      }
    });
    AppMethodBeat.o(270520);
  }
  
  @androidx.lifecycle.t(jl=h.a.ON_PAUSE)
  public final void onActivityPause()
  {
    AppMethodBeat.i(270519);
    com.tencent.mm.ui.tools.i locali = this.Cwc;
    if (locali != null)
    {
      locali.close();
      AppMethodBeat.o(270519);
      return;
    }
    AppMethodBeat.o(270519);
  }
  
  @androidx.lifecycle.t(jl=h.a.ON_RESUME)
  public final void onActivityResume()
  {
    AppMethodBeat.i(270517);
    com.tencent.mm.ui.tools.i locali = this.Cwc;
    if (locali != null)
    {
      locali.start();
      AppMethodBeat.o(270517);
      return;
    }
    AppMethodBeat.o(270517);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$InputResultCallback;", "", "onResult", "", "canceled", "", "result", "", "addressString", "plugin-wxpay_release"})
  public static abstract interface b
  {
    public abstract void g(boolean paramBoolean, String paramString1, String paramString2);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$animShowKeyboard$1$1"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(g paramg, RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage, int paramInt) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(210618);
      if (!u.kL((Context)this.IuT.iXq))
      {
        View localView = this.IuU.oFW;
        p.j(paramValueAnimator, "anim");
        paramValueAnimator = paramValueAnimator.getAnimatedValue();
        if (paramValueAnimator == null)
        {
          paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(210618);
          throw paramValueAnimator;
        }
        localView.setPadding(0, 0, 0, ((Integer)paramValueAnimator).intValue());
      }
      AppMethodBeat.o(210618);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKey", "com/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$showDialog$1$1"})
  static final class g
    implements DialogInterface.OnKeyListener
  {
    g(g paramg, MMEditText paramMMEditText, RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage, String paramString, aa.a parama, ArrayList paramArrayList, RemittanceRemarkInputHalfPage.b paramb) {}
    
    public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(186447);
      if ((paramInt == 4) && (this.IuU.isShowing()))
      {
        if (RemittanceRemarkInputHalfPage.a(this.IuT) <= 0) {
          break label54;
        }
        this.IuT.iXq.hideVKB((View)this.IuV);
      }
      for (;;)
      {
        AppMethodBeat.o(186447);
        return false;
        label54:
        this.IuU.bYF();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$showDialog$1$2"})
  static final class h
    implements View.OnClickListener
  {
    h(MMEditText paramMMEditText, aa.f paramf, RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage, String paramString, aa.a parama, ArrayList paramArrayList, RemittanceRemarkInputHalfPage.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(220417);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$showDialog$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = new Intent();
      paramView.putExtra("launch_from_remittance", true);
      this.IuT.iXq.mmSetOnActivityResultCallback((MMActivity.a)new MMActivity.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(274326);
          if (paramAnonymousInt1 == 123)
          {
            if (paramAnonymousInt2 != -1) {
              break label628;
            }
            Object localObject6 = paramAnonymousIntent.getStringExtra("userName");
            Object localObject5 = paramAnonymousIntent.getStringExtra("telNumber");
            Object localObject4 = paramAnonymousIntent.getStringExtra("proviceFirstStageName");
            Object localObject3 = paramAnonymousIntent.getStringExtra("addressCitySecondStageName");
            Object localObject1 = paramAnonymousIntent.getStringExtra("addressCountiesThirdStageName");
            paramAnonymousIntent = paramAnonymousIntent.getStringExtra("addressDetailInfo");
            Object localObject2 = new StringBuilder();
            CharSequence localCharSequence = (CharSequence)localObject6;
            if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
              break label588;
            }
            paramAnonymousInt1 = 1;
            if (paramAnonymousInt1 == 0) {
              ((StringBuilder)localObject2).append((String)localObject6);
            }
            localObject6 = (CharSequence)localObject5;
            if ((localObject6 != null) && (((CharSequence)localObject6).length() != 0)) {
              break label593;
            }
            paramAnonymousInt1 = 1;
            label132:
            if (paramAnonymousInt1 == 0) {
              ((StringBuilder)localObject2).append((String)localObject5);
            }
            if (((CharSequence)localObject2).length() != 0) {
              break label598;
            }
            paramAnonymousInt1 = 1;
            label159:
            if (paramAnonymousInt1 == 0) {
              ((StringBuilder)localObject2).append(" ");
            }
            localObject5 = (CharSequence)localObject4;
            if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
              break label603;
            }
            paramAnonymousInt1 = 1;
            label195:
            if (paramAnonymousInt1 == 0) {
              ((StringBuilder)localObject2).append((String)localObject4);
            }
            localObject4 = (CharSequence)localObject3;
            if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
              break label608;
            }
            paramAnonymousInt1 = 1;
            label231:
            if (paramAnonymousInt1 == 0) {
              ((StringBuilder)localObject2).append((String)localObject3);
            }
            localObject3 = (CharSequence)localObject1;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label613;
            }
            paramAnonymousInt1 = 1;
            label267:
            if (paramAnonymousInt1 == 0) {
              ((StringBuilder)localObject2).append((String)localObject1);
            }
            localObject1 = (CharSequence)paramAnonymousIntent;
            if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
              break label618;
            }
            paramAnonymousInt1 = 1;
            label302:
            if (paramAnonymousInt1 == 0) {
              ((StringBuilder)localObject2).append(paramAnonymousIntent);
            }
            paramAnonymousIntent = ((StringBuilder)localObject2).toString();
            p.j(paramAnonymousIntent, "StringBuilder().apply(builderAction).toString()");
            localObject1 = this.Ivb.IuV.getText().toString();
            localObject2 = (CharSequence)localObject1;
            if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
              break label623;
            }
            paramAnonymousInt1 = 1;
            label364:
            if ((paramAnonymousInt1 == 0) && (!n.pu((String)localObject1, ";")))
            {
              this.Ivb.IuV.getText().append((CharSequence)";");
              this.Ivb.IuV.setSelection(this.Ivb.IuV.getText().length());
            }
            this.Ivb.IuX.aaBx = true;
            this.Ivb.IuV.bBa(paramAnonymousIntent + ';');
            localObject1 = this.Ivb.Iva;
            localObject2 = (String)((aa.f)localObject1).aaBC;
            ((aa.f)localObject1).aaBC = ((String)localObject2 + paramAnonymousIntent);
            if ((this.Ivb.IuY.isEmpty()) || ((p.h((String)j.lq((List)this.Ivb.IuY), "2") ^ true))) {
              this.Ivb.IuY.add("2");
            }
          }
          for (;;)
          {
            com.tencent.e.h.ZvG.n((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(197713);
                this.Ivc.Ivb.IuT.iXq.showVKB();
                AppMethodBeat.o(197713);
              }
            }, 100L);
            AppMethodBeat.o(274326);
            return;
            label588:
            paramAnonymousInt1 = 0;
            break;
            label593:
            paramAnonymousInt1 = 0;
            break label132;
            label598:
            paramAnonymousInt1 = 0;
            break label159;
            label603:
            paramAnonymousInt1 = 0;
            break label195;
            label608:
            paramAnonymousInt1 = 0;
            break label231;
            label613:
            paramAnonymousInt1 = 0;
            break label267;
            label618:
            paramAnonymousInt1 = 0;
            break label302;
            label623:
            paramAnonymousInt1 = 0;
            break label364;
            label628:
            Log.i("MicroMsg.RemittanceRemarkInputHalfPage", "cancel select address");
          }
        }
      });
      this.IuT.iXq.hideVKB((View)this.IuV);
      c.b((Context)this.IuT.iXq, "address", ".ui.WalletSelectAddrUI", paramView, 123);
      a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$showDialog$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(220417);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$showDialog$1$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-wxpay_release"})
  public static final class i
    implements TextWatcher
  {
    i(TextView paramTextView, g paramg, aa.a parama1, RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage, String paramString, aa.a parama2, ArrayList paramArrayList, RemittanceRemarkInputHalfPage.b paramb) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(272808);
      p.k(paramEditable, "s");
      int i = paramEditable.toString().length();
      paramEditable = this.Ivd;
      p.j(paramEditable, "limitTv");
      Object localObject = af.aaBG;
      localObject = String.format("%s/%s", Arrays.copyOf(new Object[] { Integer.valueOf(i), Integer.valueOf(this.IuT.IuQ) }, 2));
      p.j(localObject, "java.lang.String.format(format, *args)");
      paramEditable.setText((CharSequence)localObject);
      if (i > this.IuT.IuQ)
      {
        this.IuU.HM(false);
        this.Ivd.setTextColor(this.IuT.iXq.getResources().getColor(a.c.Red));
        if (!this.Ive.aaBx) {
          com.tencent.mm.plugin.report.service.h.IzE.a(22750, new Object[] { Integer.valueOf(6), this.IuT.IuR });
        }
      }
      for (this.Ive.aaBx = true; !this.IuX.aaBx; this.Ive.aaBx = false)
      {
        if ((!this.IuY.isEmpty()) && (!(p.h((String)j.lq((List)this.IuY), "1") ^ true))) {
          break label282;
        }
        this.IuY.add("1");
        AppMethodBeat.o(272808);
        return;
        this.IuU.HM(true);
        this.Ivd.setTextColor(this.IuT.iXq.getResources().getColor(a.c.half_alpha_black));
      }
      this.IuX.aaBx = false;
      label282:
      AppMethodBeat.o(272808);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(272805);
      p.k(paramCharSequence, "s");
      AppMethodBeat.o(272805);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(272806);
      p.k(paramCharSequence, "s");
      AppMethodBeat.o(272806);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick", "com/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$showDialog$1$4"})
  static final class j
    implements g.a
  {
    j(aa.f paramf, MMEditText paramMMEditText, g paramg, RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage, String paramString, aa.a parama, ArrayList paramArrayList, RemittanceRemarkInputHalfPage.b paramb) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(272416);
      this.IuZ.g(true, null, (String)this.Iva.aaBC);
      this.IuT.iXq.hideVKB((View)this.IuV);
      this.IuU.bYF();
      AppMethodBeat.o(272416);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick", "com/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$showDialog$1$5"})
  static final class k
    implements g.a
  {
    k(MMEditText paramMMEditText, aa.f paramf, g paramg, RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage, String paramString, aa.a parama, ArrayList paramArrayList, RemittanceRemarkInputHalfPage.b paramb) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(218673);
      this.IuZ.g(false, this.IuV.getText().toString(), (String)this.Iva.aaBC);
      this.IuT.iXq.hideVKB((View)this.IuV);
      this.IuU.bYF();
      int i = RemittanceRemarkInputHalfPage.aT(this.IuY);
      if (i != 0) {
        com.tencent.mm.plugin.report.service.h.IzE.a(22750, new Object[] { Integer.valueOf(i), this.IuT.IuR });
      }
      AppMethodBeat.o(218673);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/remittance/ui/RemittanceRemarkInputHalfPage$showDialog$1$6"})
  static final class l
    implements Runnable
  {
    l(MMEditText paramMMEditText, WeImageView paramWeImageView, RemittanceRemarkInputHalfPage paramRemittanceRemarkInputHalfPage, String paramString, aa.a parama, ArrayList paramArrayList, RemittanceRemarkInputHalfPage.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(186668);
      this.IuV.requestFocus();
      this.IuT.iXq.showVKB();
      if (this.Ivf.isShown())
      {
        Object localObject = this.Ivf.getLayoutParams();
        if (localObject == null)
        {
          localObject = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(186668);
          throw ((Throwable)localObject);
        }
        localObject = (LinearLayout.LayoutParams)localObject;
        if ((this.IuV.getLineCount() <= 1) && (((LinearLayout.LayoutParams)localObject).gravity != 16))
        {
          ((LinearLayout.LayoutParams)localObject).gravity = 16;
          this.Ivf.setLayoutParams((ViewGroup.LayoutParams)localObject);
          AppMethodBeat.o(186668);
          return;
        }
        if ((this.IuV.getLineCount() > 1) && (((LinearLayout.LayoutParams)localObject).gravity > 0))
        {
          ((LinearLayout.LayoutParams)localObject).gravity = 0;
          this.Ivf.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(186668);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceRemarkInputHalfPage
 * JD-Core Version:    0.7.0.1
 */