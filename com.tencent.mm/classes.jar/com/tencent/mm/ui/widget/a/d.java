package com.tencent.mm.ui.widget.a;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.edittext.PasterEditText;

public class d
  extends Dialog
  implements DialogInterface
{
  private Button Dim;
  private LinearLayout Ivb;
  private TextView Ivc;
  public TextView Ivd;
  private TextView Ivf;
  private TextView Ivg;
  private TextView Ivh;
  private ImageView Ivi;
  private View Ivj;
  private LinearLayout Ivk;
  private ViewStub Ivl;
  public LinearLayout Ivm;
  private ViewGroup Ivn;
  private LinearLayout Ivo;
  private ViewGroup Ivp;
  private View Ivq;
  private boolean Ivr;
  private Animation Ivs;
  private Animation Ivt;
  private Animation Ivu;
  private Animation Ivv;
  public DialogInterface.OnDismissListener Ivx;
  private d.a.d LsJ;
  CheckBox afH;
  private View ahw;
  public c iOnDialogDismissListener;
  private Context mContext;
  private EditText mEditText;
  private boolean needEdit;
  private TextView jdField_new;
  private boolean ov;
  private Button rse;
  
  public d(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(159314);
    this.Ivr = false;
    this.needEdit = false;
    this.mContext = paramContext;
    fQr();
    AppMethodBeat.o(159314);
  }
  
  public d(Context paramContext, byte paramByte)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(200351);
    this.Ivr = false;
    this.needEdit = false;
    this.mContext = paramContext;
    fQr();
    AppMethodBeat.o(200351);
  }
  
  private void aJ(View paramView, int paramInt)
  {
    AppMethodBeat.i(159325);
    this.ahw = paramView;
    if (this.ahw != null)
    {
      this.Ivm.setVisibility(0);
      this.Ivo.setVisibility(0);
      this.Ivo.removeAllViews();
      this.Ivo.setGravity(1);
      this.Ivo.addView(this.ahw, new LinearLayout.LayoutParams(paramInt, paramInt));
    }
    AppMethodBeat.o(159325);
  }
  
  private void aaU(int paramInt)
  {
    AppMethodBeat.i(159318);
    if (this.Ivd != null) {
      this.Ivd.setTextColor(paramInt);
    }
    AppMethodBeat.o(159318);
  }
  
  private void aaV(int paramInt)
  {
    AppMethodBeat.i(159324);
    if (this.Ivm != null) {
      this.Ivm.setVisibility(paramInt);
    }
    if (this.Ivo != null) {
      this.Ivo.setVisibility(paramInt);
    }
    if ((this.Ivh != null) && (this.Ivr)) {
      this.Ivh.setVisibility(paramInt);
    }
    if (this.mEditText != null)
    {
      if (!this.needEdit)
      {
        this.mEditText.setVisibility(8);
        AppMethodBeat.o(159324);
        return;
      }
      this.mEditText.setVisibility(paramInt);
    }
    AppMethodBeat.o(159324);
  }
  
  private void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(159334);
    this.Ivq.setVisibility(8);
    this.Ivn.removeAllViews();
    this.Ivn.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(159334);
  }
  
  private void fQr()
  {
    AppMethodBeat.i(200352);
    this.Ivb = ((LinearLayout)View.inflate(this.mContext, 2131494764, null));
    this.Dim = ((Button)this.Ivb.findViewById(2131302314));
    this.rse = ((Button)this.Ivb.findViewById(2131302301));
    this.jdField_new = ((TextView)this.Ivb.findViewById(2131302315));
    this.Ivc = ((TextView)this.Ivb.findViewById(2131302317));
    this.Ivd = ((TextView)this.Ivb.findViewById(2131302307));
    this.Ivf = ((TextView)this.Ivb.findViewById(2131302312));
    this.Ivg = ((TextView)this.Ivb.findViewById(2131302311));
    this.Ivh = ((TextView)this.Ivb.findViewById(2131298564));
    this.mEditText = ((EditText)this.Ivb.findViewById(2131298569));
    this.afH = ((CheckBox)this.Ivb.findViewById(2131298561));
    this.Ivi = ((ImageView)this.Ivb.findViewById(2131302310));
    this.Ivk = ((LinearLayout)this.Ivb.findViewById(2131302316));
    this.Ivl = ((ViewStub)this.Ivb.findViewById(2131305933));
    this.Ivm = ((LinearLayout)this.Ivb.findViewById(2131302308));
    this.Ivn = ((ViewGroup)this.Ivb.findViewById(2131302295));
    this.Ivq = this.Ivb.findViewById(2131302300);
    this.Ivo = ((LinearLayout)this.Ivb.findViewById(2131302303));
    this.Ivp = ((ViewGroup)this.Ivb.findViewById(2131305932));
    setCanceledOnTouchOutside(true);
    this.Ivs = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.Ivt = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.Ivu = AnimationUtils.loadAnimation(this.mContext, 2130771982);
    this.Ivv = AnimationUtils.loadAnimation(this.mContext, 2130771982);
    AppMethodBeat.o(200352);
  }
  
  private void wH(boolean paramBoolean)
  {
    AppMethodBeat.i(159320);
    if (paramBoolean)
    {
      int i = aq.fromDPToPix(this.mContext, 8);
      this.Ivm.setVisibility(0);
      this.Ivm.setPadding(i, i, i, i);
    }
    AppMethodBeat.o(159320);
  }
  
  public final void a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159329);
    a(this.mContext.getString(paramInt), true, paramOnClickListener);
    AppMethodBeat.o(159329);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(159335);
    if ((parama.title != null) && (parama.title.length() > 0))
    {
      afL(parama.IuT);
      setTitle(parama.title);
    }
    Object localObject3;
    Object localObject1;
    if ((parama.Iul != null) && (parama.Iul.length() > 0))
    {
      localObject3 = parama.Iul;
      this.Ivk.setVisibility(0);
      this.Ivc.setVisibility(0);
      localObject1 = localObject3;
      if (this.LsJ != null) {
        localObject1 = this.LsJ.a(((CharSequence)localObject3).toString(), this.jdField_new.getTextSize());
      }
      this.Ivc.setText((CharSequence)localObject1);
    }
    int i;
    if (parama.FjE != 0)
    {
      i = parama.FjE;
      this.jdField_new.setTextColor(ColorStateList.valueOf(i));
    }
    if (parama.IuQ != 0)
    {
      i = parama.IuQ;
      this.jdField_new.setMaxLines(i);
    }
    if (parama.IuR != 0)
    {
      i = parama.IuR;
      this.Ivd.setMaxLines(i);
    }
    if (parama.vd != null) {
      aJ(parama.vd, -1);
    }
    if (parama.IuO != null)
    {
      localObject3 = parama.IuO;
      this.Ivk.setVisibility(0);
      this.Ivl.setLayoutResource(2131493580);
    }
    try
    {
      localObject1 = (LinearLayout)this.Ivl.inflate();
      ((LinearLayout)localObject1).addView((View)localObject3);
      if (parama.IuP != null)
      {
        this.Ivj = parama.IuP;
        if (this.Ivj != null)
        {
          this.Ivm.setVisibility(8);
          this.Ivh.setVisibility(8);
          this.mEditText.setVisibility(8);
          this.Ivp.removeAllViews();
          this.Ivp.addView(this.Ivj, new LinearLayout.LayoutParams(-1, -1));
          this.Ivp.setVisibility(8);
        }
      }
      if (parama.Iuw != null)
      {
        localObject1 = parama.Iuw;
        if (this.ahw == null)
        {
          this.Ivm.setVisibility(0);
          this.Ivi.setVisibility(0);
          this.Ivi.setBackgroundDrawable((Drawable)localObject1);
        }
      }
      if ((parama.Iuy != null) && (parama.Iuy.length() > 0)) {
        setMessage(parama.Iuy);
      }
      wH(parama.IuH);
      if (parama.thumbPath != null)
      {
        localObject1 = parama.thumbPath;
        i = aq.fromDPToPix(this.mContext, 120);
        this.Ivm.setVisibility(0);
        this.Ivi.setVisibility(0);
        if ((this.Ivi instanceof com.tencent.mm.ui.f.a)) {
          ((com.tencent.mm.ui.f.a)this.Ivi).aK((String)localObject1, i, i);
        }
        i = parama.IuV;
        this.Ivm.setVisibility(i);
        this.Ivi.setVisibility(i);
      }
      if ((!parama.IuZ) && (!parama.Iva))
      {
        if ((parama.Iuy != null) && (parama.Iuy.length() > 0)) {
          setMessage(parama.Iuy);
        }
        if ((parama.Iuz == null) || (parama.Iuz.length() <= 0)) {
          break label2254;
        }
        localObject1 = parama.Iuz;
        this.Ivm.setVisibility(0);
        this.Ivf.setVisibility(0);
        this.Ivf.setMaxLines(2);
        this.Ivf.setText((CharSequence)localObject1);
        if ((parama.IuA != null) && (parama.IuA.length() > 0))
        {
          localObject3 = parama.IuA;
          if (localObject3 != null)
          {
            this.Ivm.setVisibility(0);
            this.Ivg.setVisibility(0);
            localObject1 = localObject3;
            if (this.LsJ != null)
            {
              localObject1 = this.LsJ;
              this.Ivg.getContext();
              localObject1 = ((d.a.d)localObject1).a(((CharSequence)localObject3).toString(), this.Ivg.getTextSize());
            }
            this.Ivg.setText((CharSequence)localObject1);
          }
        }
        if (parama.Iux != null)
        {
          localObject1 = parama.Iux;
          if (this.ahw == null)
          {
            this.Ivm.setVisibility(0);
            this.Ivi.setVisibility(0);
            this.Ivi.setImageBitmap((Bitmap)localObject1);
          }
        }
      }
      boolean bool;
      d.a.a locala;
      if (parama.IuZ)
      {
        localObject1 = parama.Iux;
        localObject4 = parama.Iuz;
        localObject3 = parama.IuA;
        localObject5 = View.inflate(this.mContext, 2131493583, null);
        if (localObject1 != null)
        {
          localObject6 = (ImageView)((View)localObject5).findViewById(2131302310);
          ((ImageView)localObject6).setVisibility(0);
          ((ImageView)localObject6).setImageBitmap((Bitmap)localObject1);
        }
        if (localObject4 != null)
        {
          localObject6 = (TextView)((View)localObject5).findViewById(2131302312);
          ((TextView)localObject6).setVisibility(0);
          localObject1 = localObject4;
          if (this.LsJ != null) {
            localObject1 = this.LsJ.a(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
          }
          ((TextView)localObject6).setText((CharSequence)localObject1);
        }
        if (localObject3 != null)
        {
          localObject4 = (TextView)((View)localObject5).findViewById(2131302311);
          ((TextView)localObject4).setVisibility(0);
          if (this.LsJ == null) {
            break label2638;
          }
          localObject1 = this.LsJ.a(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
          ((TextView)localObject4).setText((CharSequence)localObject1);
        }
        aJ((View)localObject5, -1);
        if ((parama.Iup != null) || (parama.Iuq != null))
        {
          localObject6 = parama.Iup;
          localObject4 = parama.Iuq;
          bool = parama.Iur;
          localObject5 = parama.LsD;
          locala = parama.LsE;
          this.Ivl.setLayoutResource(2131493593);
          localObject1 = null;
        }
      }
      try
      {
        localObject3 = (LinearLayout)this.Ivl.inflate();
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int i2;
          int j;
          float f;
          int n;
          int m;
          int i1;
          int k;
          this.Ivl.setVisibility(0);
          continue;
          if ((f >= 0.5D) && (f < 1.0F))
          {
            n = (int)(i * f);
            j = n;
            k = i;
            m = i;
          }
          else if ((f >= 1.0F) && (f < 2.0F))
          {
            m = (int)(i / f);
            j = i;
            k = m;
            n = i;
          }
          else if (f >= 2.0F)
          {
            n = (int)(i1 * f);
            k = i1;
            m = i1;
            j = i;
            continue;
            ((ImageView)localObject2).setVisibility(0);
            if (i2 == 1)
            {
              ((ImageView)localObject2).setImageResource(2131691174);
            }
            else if (i2 == 2)
            {
              ((ImageView)localObject2).setImageResource(2131691361);
              continue;
              this.mEditText.setVisibility(8);
              continue;
              localObject2 = localException2;
              continue;
              localObject2 = localException2;
            }
          }
        }
      }
      if ((localObject1 != null) && (localObject6 != null))
      {
        localObject3 = (ImageView)((LinearLayout)localObject1).findViewById(2131305922);
        ((ImageView)localObject3).setVisibility(0);
        if (locala != null) {
          locala.y((ImageView)localObject3, (String)localObject6);
        }
      }
      if ((localObject1 != null) && (localObject4 != null))
      {
        localObject6 = (TextView)((LinearLayout)localObject1).findViewById(2131305945);
        ((TextView)localObject6).setVisibility(0);
        localObject3 = localObject4;
        if (this.LsJ != null) {
          localObject3 = this.LsJ.a(((CharSequence)localObject4).toString(), this.jdField_new.getTextSize());
        }
        ((TextView)localObject6).setText((CharSequence)localObject3);
      }
      if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
      {
        localObject3 = (ImageView)((LinearLayout)localObject1).findViewById(2131300962);
        ((ImageView)localObject3).setVisibility(0);
        aaV(0);
        ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(159297);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (this.LsK != null) {
              this.LsK.fgn();
            }
            if (this.Ivz.isSelected())
            {
              d.e(d.this).startAnimation(d.d(d.this));
              d.d(d.this).setAnimationListener(new Animation.AnimationListener()
              {
                public final void onAnimationEnd(Animation paramAnonymous2Animation)
                {
                  AppMethodBeat.i(159294);
                  d.e(d.this).setVisibility(8);
                  d.a(d.this, 0);
                  AppMethodBeat.o(159294);
                }
                
                public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                
                public final void onAnimationStart(Animation paramAnonymous2Animation)
                {
                  AppMethodBeat.i(159293);
                  d.a(d.this, d.f(d.this));
                  AppMethodBeat.o(159293);
                }
              });
              ObjectAnimator.ofFloat(this.Ivz, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
              this.Ivz.setSelected(false);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(159297);
              return;
              d.e(d.this).startAnimation(d.g(d.this));
              d.g(d.this).setAnimationListener(new Animation.AnimationListener()
              {
                public final void onAnimationEnd(Animation paramAnonymous2Animation)
                {
                  AppMethodBeat.i(159296);
                  d.e(d.this).setVisibility(0);
                  d.a(d.this, 8);
                  AppMethodBeat.o(159296);
                }
                
                public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                
                public final void onAnimationStart(Animation paramAnonymous2Animation)
                {
                  AppMethodBeat.i(159295);
                  d.a(d.this, d.h(d.this));
                  AppMethodBeat.o(159295);
                }
              });
              ObjectAnimator.ofFloat(this.Ivz, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
              this.Ivz.setSelected(true);
            }
          }
        });
      }
      if (parama.LsF != null) {
        b(parama.LsF);
      }
      if ((parama.LsH != null) && (!parama.LsH.isRecycled()))
      {
        localObject3 = parama.LsH;
        bool = parama.IuI;
        i2 = parama.IuU;
        if (localObject3 != null)
        {
          wH(false);
          this.Ivm.setVisibility(0);
          this.Ivm.setGravity(1);
          this.Ivm.setPadding(0, 0, 0, 0);
          localObject5 = View.inflate(this.mContext, 2131493585, null);
          localObject6 = (ImageView)((View)localObject5).findViewById(2131302310);
          if (!bool) {
            break label2624;
          }
          i = ((Bitmap)localObject3).getWidth();
          j = ((Bitmap)localObject3).getHeight();
          localObject4 = null;
          f = j / i;
          n = 0;
          m = 0;
          i1 = aq.ay(this.mContext, 2131165260);
          i = aq.ay(this.mContext, 2131165259);
          k = 0;
          j = 0;
          if ((f <= 0.0F) || (f >= 0.5D)) {
            break label2477;
          }
          m = (int)(i1 / f);
          j = i1;
          n = i1;
          k = i;
          localObject1 = localObject4;
          if (n > 0)
          {
            localObject1 = localObject4;
            if (m > 0)
            {
              localObject1 = localObject4;
              if (localObject3 != null)
              {
                localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject3, m, n, true);
                ((ImageView)localObject6).setLayoutParams(new FrameLayout.LayoutParams(k, j));
              }
            }
          }
          localObject1 = an.c((Bitmap)localObject1, aq.fromDPToPix(this.mContext, 3));
          ((ImageView)localObject6).setImageBitmap((Bitmap)localObject1);
          localObject1 = (ImageView)((View)localObject5).findViewById(2131300961);
          if (i2 != 0) {
            break label2572;
          }
          ((ImageView)localObject1).setVisibility(8);
          aJ((View)localObject5, -2);
        }
      }
      if ((parama.Ium != null) && (parama.Ium.length() > 0))
      {
        localObject1 = parama.Ium;
        if (localObject1 != null)
        {
          this.Ivh.setVisibility(0);
          this.Ivh.setText((CharSequence)localObject1);
        }
        this.Ivr = true;
        afM(parama.IuS);
      }
      if ((parama.Iun != null) && (parama.Iun.length() > 0))
      {
        localObject1 = parama.Iun;
        this.mEditText.setVisibility(0);
        this.mEditText.setHint((CharSequence)localObject1);
      }
      if ((parama.LsC != null) && (parama.LsC.length() > 0))
      {
        localObject1 = parama.LsC;
        this.afH.setVisibility(0);
        this.afH.setText((CharSequence)localObject1);
      }
      if (parama.Iuo)
      {
        this.needEdit = parama.Iuo;
        if (parama.Iuo) {
          this.mEditText.setVisibility(0);
        }
      }
      else
      {
        if ((parama.IuB != null) && (parama.IuB.length() > 0)) {
          a(parama.IuB, parama.IuY, parama.IuJ);
        }
        if ((parama.IuC != null) && (parama.IuC.length() > 0)) {
          b(parama.IuC, true, parama.IuK);
        }
        if (parama.IuX != 0) {
          aaW(parama.IuX);
        }
        if (parama.IuW != 0) {
          aaX(parama.IuW);
        }
        if (parama.XL != null) {
          setOnCancelListener(parama.XL);
        }
        if (parama.XM != null)
        {
          this.Ivx = parama.XM;
          setOnDismissListener(parama.XM);
        }
        if (parama.LsG != null) {
          this.LsJ = parama.LsG;
        }
        setCancelable(parama.ov);
        this.ov = parama.ov;
        if (!this.ov) {
          super.setCancelable(parama.IuG);
        }
        if ((parama.IuD != null) || (parama.IuE != null) || (parama.IuF != null))
        {
          localObject1 = View.inflate(this.mContext, 2131493592, null);
          localObject3 = (Button)((View)localObject1).findViewById(2131302297);
          localObject4 = (Button)((View)localObject1).findViewById(2131302298);
          localObject5 = (Button)((View)localObject1).findViewById(2131302299);
          if (parama.IuD != null)
          {
            ((Button)localObject3).setVisibility(0);
            ((Button)localObject3).setText(parama.IuD);
            ((Button)localObject3).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159302);
                b localb = new b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                if (parama.IuL != null) {
                  parama.IuL.onClick(d.this, -1);
                }
                d.this.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159302);
              }
            });
          }
          if (parama.IuE != null)
          {
            ((Button)localObject4).setVisibility(0);
            ((Button)localObject4).setText(parama.IuE);
            ((Button)localObject4).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159303);
                b localb = new b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                if (parama.IuM != null) {
                  parama.IuM.onClick(d.this, -2);
                }
                d.this.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159303);
              }
            });
          }
          if (parama.IuF != null)
          {
            ((Button)localObject5).setVisibility(0);
            ((Button)localObject5).setText(parama.IuF);
            ((Button)localObject5).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159304);
                b localb = new b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                if (parama.IuN != null) {
                  parama.IuN.onClick(d.this, -3);
                }
                d.this.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159304);
              }
            });
          }
          b((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
        }
        if (parama.Ius)
        {
          localObject1 = View.inflate(this.mContext, 2131493579, null);
          this.rse = ((Button)((View)localObject1).findViewById(2131302301));
          this.Dim = ((Button)((View)localObject1).findViewById(2131302314));
          if (parama.IuX != 0) {
            aaW(parama.IuX);
          }
          if (parama.IuW != 0) {
            aaX(parama.IuW);
          }
          if ((parama.IuB != null) && (parama.IuB.length() > 0)) {
            a(parama.IuB, parama.IuY, parama.IuJ);
          }
          if ((parama.IuC != null) && (parama.IuC.length() > 0)) {
            b(parama.IuC, true, parama.IuK);
          }
          b((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(159335);
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject4;
        Object localObject5;
        Object localObject6;
        this.Ivl.setVisibility(0);
        Object localObject2 = null;
        continue;
        label2254:
        wH(false);
        continue;
        label2572:
        if (parama.Iva)
        {
          localObject2 = parama.Iux;
          localObject4 = parama.Iuz;
          localObject3 = parama.IuA;
          localObject5 = View.inflate(this.mContext, 2131493584, null);
          if (localObject2 != null)
          {
            localObject6 = (ImageView)((View)localObject5).findViewById(2131302310);
            ((ImageView)localObject6).setVisibility(0);
            ((ImageView)localObject6).setImageBitmap((Bitmap)localObject2);
          }
          if (localObject4 != null)
          {
            localObject6 = (TextView)((View)localObject5).findViewById(2131302312);
            ((TextView)localObject6).setVisibility(0);
            localObject2 = localObject4;
            if (this.LsJ != null) {
              localObject2 = this.LsJ.a(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
            }
            ((TextView)localObject6).setText((CharSequence)localObject2);
          }
          if (localObject3 != null)
          {
            localObject4 = (TextView)((View)localObject5).findViewById(2131302311);
            ((TextView)localObject4).setVisibility(0);
            if (this.LsJ != null)
            {
              localObject2 = this.LsJ.a(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
              ((TextView)localObject4).setText((CharSequence)localObject2);
            }
          }
          else
          {
            aJ((View)localObject5, -1);
            continue;
          }
          label2477:
          label2624:
          label2638:
          localObject2 = localException2;
        }
      }
    }
  }
  
  public final void a(CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159326);
    if (this.Dim == null)
    {
      AppMethodBeat.o(159326);
      return;
    }
    this.Dim.setVisibility(0);
    this.Dim.setText(paramCharSequence);
    this.Dim.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159300);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(d.this, -1);
        }
        if (paramBoolean) {
          d.this.dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159300);
      }
    });
    AppMethodBeat.o(159326);
  }
  
  public final void aaW(int paramInt)
  {
    AppMethodBeat.i(159327);
    this.Dim.setTextColor(paramInt);
    AppMethodBeat.o(159327);
  }
  
  public final void aaX(int paramInt)
  {
    AppMethodBeat.i(159328);
    this.rse.setTextColor(paramInt);
    AppMethodBeat.o(159328);
  }
  
  public final void afL(int paramInt)
  {
    AppMethodBeat.i(200353);
    if (this.jdField_new != null) {
      this.jdField_new.setGravity(paramInt);
    }
    AppMethodBeat.o(200353);
  }
  
  public final void afM(int paramInt)
  {
    AppMethodBeat.i(200354);
    if (this.Ivh != null) {
      this.Ivh.setGravity(paramInt);
    }
    AppMethodBeat.o(200354);
  }
  
  public final void b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159331);
    b(this.mContext.getString(paramInt), true, paramOnClickListener);
    AppMethodBeat.o(159331);
  }
  
  public final void b(final d.a.b paramb)
  {
    AppMethodBeat.i(159323);
    if ((this.Ivm != null) && (this.Ivm.getVisibility() == 0))
    {
      this.Ivm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159298);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (paramb != null) {
            paramb.cza();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159298);
        }
      });
      AppMethodBeat.o(159323);
      return;
    }
    if (this.Ivo != null) {
      this.Ivo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159299);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (paramb != null) {
            paramb.cza();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159299);
        }
      });
    }
    AppMethodBeat.o(159323);
  }
  
  public final void b(CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159330);
    if (this.rse == null)
    {
      AppMethodBeat.o(159330);
      return;
    }
    this.rse.setVisibility(0);
    this.rse.setText(paramCharSequence);
    this.rse.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159301);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(d.this, -2);
        }
        if (paramBoolean) {
          d.this.cancel();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159301);
      }
    });
    AppMethodBeat.o(159330);
  }
  
  public final void bu(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(200355);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(200355);
      return;
      if (paramBoolean)
      {
        this.Dim.setVisibility(0);
        AppMethodBeat.o(200355);
        return;
      }
      this.Dim.setVisibility(8);
      AppMethodBeat.o(200355);
      return;
      if (paramBoolean)
      {
        this.rse.setVisibility(0);
        AppMethodBeat.o(200355);
        return;
      }
      this.rse.setVisibility(8);
    }
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(159337);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(159305);
          d.this.dismiss();
          AppMethodBeat.o(159305);
        }
      });
      ap.e("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
      AppMethodBeat.o(159337);
      return;
    }
    try
    {
      if ((this.mContext != null) && ((this.mContext instanceof Activity))) {
        if (!((Activity)this.mContext).isFinishing()) {
          super.dismiss();
        }
      }
      for (;;)
      {
        if (this.iOnDialogDismissListener != null) {
          this.iOnDialogDismissListener.onDialogDismiss(this);
        }
        AppMethodBeat.o(159337);
        return;
        super.dismiss();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ap.e("MicroMsg.MMAlertDialog", "dismiss exception, e = " + localException.getMessage(), new Object[0]);
      }
    }
  }
  
  public final String fQs()
  {
    AppMethodBeat.i(159321);
    if (this.mEditText == null)
    {
      AppMethodBeat.o(159321);
      return null;
    }
    String str = this.mEditText.getText().toString();
    AppMethodBeat.o(159321);
    return str;
  }
  
  public final int fQt()
  {
    AppMethodBeat.i(159322);
    if ((this.mEditText instanceof PasterEditText))
    {
      int i = ((PasterEditText)this.mEditText).getPasterLen();
      AppMethodBeat.o(159322);
      return i;
    }
    AppMethodBeat.o(159322);
    return 0;
  }
  
  public final ImageView fQu()
  {
    return this.Ivi;
  }
  
  public final Button getButton(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case -1: 
      return this.Dim;
    }
    return this.rse;
  }
  
  public View getContentView()
  {
    return this.Ivb;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(159315);
    super.onCreate(paramBundle);
    setContentView(this.Ivb);
    AppMethodBeat.o(159315);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(159332);
    super.setCancelable(paramBoolean);
    this.ov = paramBoolean;
    setCanceledOnTouchOutside(this.ov);
    AppMethodBeat.o(159332);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159319);
    this.Ivm.setVisibility(0);
    this.Ivd.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.LsJ != null)
    {
      localObject = this.LsJ;
      this.Ivd.getContext();
      localObject = ((d.a.d)localObject).a(paramCharSequence.toString(), this.Ivd.getTextSize());
    }
    this.Ivd.setText((CharSequence)localObject);
    AppMethodBeat.o(159319);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(159317);
    this.Ivk.setVisibility(0);
    this.jdField_new.setVisibility(0);
    this.jdField_new.setMaxLines(2);
    this.jdField_new.setText(paramInt);
    this.jdField_new.getPaint().setFakeBoldText(true);
    aaU(this.mContext.getResources().getColor(2131099734));
    AppMethodBeat.o(159317);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159316);
    this.Ivk.setVisibility(0);
    this.jdField_new.setVisibility(0);
    CharSequence localCharSequence = paramCharSequence;
    if (this.LsJ != null) {
      localCharSequence = this.LsJ.a(paramCharSequence.toString(), this.jdField_new.getTextSize());
    }
    this.jdField_new.setMaxLines(2);
    this.jdField_new.setText(localCharSequence);
    this.jdField_new.getPaint().setFakeBoldText(true);
    aaU(this.mContext.getResources().getColor(2131099734));
    AppMethodBeat.o(159316);
  }
  
  public void show()
  {
    AppMethodBeat.i(159336);
    try
    {
      super.show();
      AppMethodBeat.o(159336);
      return;
    }
    catch (Exception localException)
    {
      ap.printErrStackTrace("MicroMsg.MMAlertDialog", localException, "", new Object[0]);
      AppMethodBeat.o(159336);
    }
  }
  
  public final void zc(boolean paramBoolean)
  {
    AppMethodBeat.i(159333);
    super.setCancelable(paramBoolean);
    AppMethodBeat.o(159333);
  }
  
  public static final class a
  {
    public a LsP;
    public Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159306);
      this.mContext = paramContext;
      this.LsP = new a();
      AppMethodBeat.o(159306);
    }
    
    public final a a(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.LsP.XM = paramOnDismissListener;
      return this;
    }
    
    public final a a(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
    {
      this.LsP.LsH = paramBitmap;
      this.LsP.IuI = paramBoolean;
      this.LsP.IuU = paramInt;
      return this;
    }
    
    public final a a(d paramd)
    {
      this.LsP.LsG = paramd;
      return this;
    }
    
    public final a a(String paramString, CharSequence paramCharSequence, Boolean paramBoolean, c paramc, a parama)
    {
      AppMethodBeat.i(159309);
      this.LsP.Iup = paramString;
      this.LsP.Iuq = paramCharSequence;
      this.LsP.Iur = paramBoolean.booleanValue();
      this.LsP.LsD = paramc;
      this.LsP.LsE = parama;
      AppMethodBeat.o(159309);
      return this;
    }
    
    public final a a(boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.LsP.IuJ = paramOnClickListener;
      this.LsP.IuY = paramBoolean;
      return this;
    }
    
    public final a aK(Bitmap paramBitmap)
    {
      this.LsP.Iux = paramBitmap;
      return this;
    }
    
    public final a aZh(String paramString)
    {
      this.LsP.title = paramString;
      return this;
    }
    
    public final a aZi(String paramString)
    {
      this.LsP.Iuy = paramString;
      return this;
    }
    
    public final a aZj(String paramString)
    {
      this.LsP.IuA = paramString;
      return this;
    }
    
    public final a aZk(String paramString)
    {
      this.LsP.thumbPath = paramString;
      return this;
    }
    
    public final a aZl(String paramString)
    {
      this.LsP.Ium = paramString;
      return this;
    }
    
    public final a aZm(String paramString)
    {
      this.LsP.Iun = paramString;
      return this;
    }
    
    public final a aZn(String paramString)
    {
      this.LsP.LsC = paramString;
      return this;
    }
    
    public final a aZo(String paramString)
    {
      this.LsP.IuB = paramString;
      return this;
    }
    
    public final a aZp(String paramString)
    {
      this.LsP.IuC = paramString;
      return this;
    }
    
    public final a afN(int paramInt)
    {
      AppMethodBeat.i(159307);
      this.LsP.title = this.mContext.getString(paramInt);
      AppMethodBeat.o(159307);
      return this;
    }
    
    public final a afO(int paramInt)
    {
      this.LsP.FjE = paramInt;
      return this;
    }
    
    public final a afP(int paramInt)
    {
      this.LsP.IuQ = paramInt;
      return this;
    }
    
    public final a afQ(int paramInt)
    {
      this.LsP.IuT = paramInt;
      return this;
    }
    
    public final a afR(int paramInt)
    {
      AppMethodBeat.i(159308);
      this.LsP.Iuy = this.mContext.getString(paramInt);
      AppMethodBeat.o(159308);
      return this;
    }
    
    public final a afS(int paramInt)
    {
      this.LsP.IuR = paramInt;
      return this;
    }
    
    public final a afT(int paramInt)
    {
      this.LsP.IuS = paramInt;
      return this;
    }
    
    public final a afU(int paramInt)
    {
      AppMethodBeat.i(159310);
      this.LsP.IuB = this.mContext.getString(paramInt);
      AppMethodBeat.o(159310);
      return this;
    }
    
    public final a afV(int paramInt)
    {
      AppMethodBeat.i(159311);
      this.LsP.IuC = this.mContext.getString(paramInt);
      AppMethodBeat.o(159311);
      return this;
    }
    
    public final a afW(int paramInt)
    {
      this.LsP.IuX = paramInt;
      return this;
    }
    
    public final a afX(int paramInt)
    {
      this.LsP.IuW = paramInt;
      return this;
    }
    
    public final a ar(CharSequence paramCharSequence)
    {
      this.LsP.title = paramCharSequence;
      return this;
    }
    
    public final a as(CharSequence paramCharSequence)
    {
      this.LsP.Iul = paramCharSequence;
      return this;
    }
    
    public final a at(CharSequence paramCharSequence)
    {
      this.LsP.Iuz = paramCharSequence;
      return this;
    }
    
    public final a c(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.LsP.IuJ = paramOnClickListener;
      return this;
    }
    
    public final a c(b paramb)
    {
      this.LsP.LsF = paramb;
      return this;
    }
    
    public final a d(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.LsP.IuK = paramOnClickListener;
      return this;
    }
    
    public final a e(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.LsP.XL = paramOnCancelListener;
      return this;
    }
    
    public final d fQv()
    {
      AppMethodBeat.i(159312);
      d locald = new d(this.mContext, (byte)0);
      locald.a(this.LsP);
      AppMethodBeat.o(159312);
      return locald;
    }
    
    public final a hd(View paramView)
    {
      this.LsP.vd = paramView;
      return this;
    }
    
    public final a he(View paramView)
    {
      this.LsP.IuO = paramView;
      return this;
    }
    
    public final void show()
    {
      AppMethodBeat.i(224515);
      fQv().show();
      AppMethodBeat.o(224515);
    }
    
    public final a zd(boolean paramBoolean)
    {
      this.LsP.IuH = paramBoolean;
      return this;
    }
    
    public final a ze(boolean paramBoolean)
    {
      this.LsP.Iuo = paramBoolean;
      return this;
    }
    
    public final a zf(boolean paramBoolean)
    {
      this.LsP.ov = paramBoolean;
      return this;
    }
    
    public final a zg(boolean paramBoolean)
    {
      this.LsP.IuG = paramBoolean;
      return this;
    }
    
    public static abstract interface a
    {
      public abstract void y(ImageView paramImageView, String paramString);
    }
    
    public static abstract interface b
    {
      public abstract void cza();
    }
    
    public static abstract interface c
    {
      public abstract void fgn();
    }
    
    public static abstract interface d
    {
      public abstract CharSequence a(CharSequence paramCharSequence, float paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.d
 * JD-Core Version:    0.7.0.1
 */