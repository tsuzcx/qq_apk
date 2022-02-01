package com.tencent.mm.sdcard_migrate.a;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.aq;

public final class c
  extends Dialog
  implements DialogInterface
{
  private Button Dim;
  private LinearLayout Ivb;
  private TextView Ivc;
  public TextView Ivd;
  public TextView Ive;
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
  public c.a.c Ivw;
  private DialogInterface.OnDismissListener Ivx;
  private View ahw;
  com.tencent.mm.ui.widget.a.c iOnDialogDismissListener;
  private Context mContext;
  private EditText mEditText;
  private boolean needEdit;
  private TextView jdField_new;
  private boolean ov;
  private Button rse;
  
  public c(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(211911);
    this.Ivr = false;
    this.needEdit = false;
    this.mContext = paramContext;
    this.Ivb = ((LinearLayout)View.inflate(this.mContext, 2131494766, null));
    this.Dim = ((Button)this.Ivb.findViewById(2131302314));
    this.rse = ((Button)this.Ivb.findViewById(2131302301));
    this.jdField_new = ((TextView)this.Ivb.findViewById(2131302315));
    this.Ivc = ((TextView)this.Ivb.findViewById(2131302317));
    this.Ivd = ((TextView)this.Ivb.findViewById(2131302307));
    this.Ive = ((TextView)this.Ivb.findViewById(2131307292));
    this.Ivf = ((TextView)this.Ivb.findViewById(2131302312));
    this.Ivg = ((TextView)this.Ivb.findViewById(2131302311));
    this.Ivh = ((TextView)this.Ivb.findViewById(2131298564));
    this.mEditText = ((EditText)this.Ivb.findViewById(2131298569));
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
    AppMethodBeat.o(211911);
  }
  
  private void a(CharSequence paramCharSequence, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(211923);
    if (this.rse != null)
    {
      this.rse.setVisibility(0);
      this.rse.setText(paramCharSequence);
      this.rse.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(211903);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (paramOnClickListener != null) {
            paramOnClickListener.onClick(c.this, -2);
          }
          if (this.IvG) {
            c.this.cancel();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(211903);
        }
      });
    }
    AppMethodBeat.o(211923);
  }
  
  private void a(CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(211920);
    if (this.Dim == null)
    {
      AppMethodBeat.o(211920);
      return;
    }
    this.Dim.setVisibility(0);
    this.Dim.setText(paramCharSequence);
    this.Dim.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(211902);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(c.this, -1);
        }
        if (paramBoolean) {
          c.this.dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(211902);
      }
    });
    AppMethodBeat.o(211920);
  }
  
  private void aaU(int paramInt)
  {
    AppMethodBeat.i(211915);
    if (this.Ivd != null) {
      this.Ivd.setTextColor(paramInt);
    }
    AppMethodBeat.o(211915);
  }
  
  private void aaV(int paramInt)
  {
    AppMethodBeat.i(211918);
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
        AppMethodBeat.o(211918);
        return;
      }
      this.mEditText.setVisibility(paramInt);
    }
    AppMethodBeat.o(211918);
  }
  
  private void aaW(int paramInt)
  {
    AppMethodBeat.i(211921);
    this.Dim.setTextColor(paramInt);
    AppMethodBeat.o(211921);
  }
  
  private void aaX(int paramInt)
  {
    AppMethodBeat.i(211922);
    this.rse.setTextColor(paramInt);
    AppMethodBeat.o(211922);
  }
  
  private void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(211925);
    this.Ivq.setVisibility(8);
    this.Ivn.removeAllViews();
    this.Ivn.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(211925);
  }
  
  private void fX(View paramView)
  {
    AppMethodBeat.i(211919);
    this.ahw = paramView;
    if (this.ahw != null)
    {
      this.Ivm.setVisibility(0);
      this.Ivo.setVisibility(0);
      this.Ivo.removeAllViews();
      this.Ivo.setGravity(1);
      this.Ivo.addView(this.ahw, new LinearLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(211919);
  }
  
  private void wH(boolean paramBoolean)
  {
    AppMethodBeat.i(211917);
    if (paramBoolean)
    {
      int i = aq.fromDPToPix(this.mContext, 8);
      this.Ivm.setVisibility(0);
      this.Ivm.setPadding(i, i, i, i);
      this.Ivm.setBackgroundResource(2131231925);
    }
    AppMethodBeat.o(211917);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(211926);
    int i;
    if ((parama.title != null) && (parama.title.length() > 0))
    {
      i = parama.IuT;
      if (this.jdField_new != null) {
        this.jdField_new.setGravity(i);
      }
      setTitle(parama.title);
    }
    Object localObject4;
    Object localObject1;
    if ((parama.Iul != null) && (parama.Iul.length() > 0))
    {
      localObject4 = parama.Iul;
      this.Ivk.setVisibility(0);
      this.Ivc.setVisibility(0);
      localObject1 = localObject4;
      if (this.Ivw != null)
      {
        localObject1 = this.Ivw;
        ((CharSequence)localObject4).toString();
        this.jdField_new.getTextSize();
        localObject1 = ((c.a.c)localObject1).fnA();
      }
      this.Ivc.setText((CharSequence)localObject1);
    }
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
      fX(parama.vd);
    }
    if (parama.IuO != null)
    {
      localObject4 = parama.IuO;
      this.Ivk.setVisibility(0);
      this.Ivl.setLayoutResource(2131493580);
    }
    try
    {
      localObject1 = (LinearLayout)this.Ivl.inflate();
      ((LinearLayout)localObject1).addView((View)localObject4);
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
          break label1950;
        }
        localObject1 = parama.Iuz;
        this.Ivm.setVisibility(0);
        this.Ivf.setVisibility(0);
        this.Ivf.setMaxLines(2);
        this.Ivf.setText((CharSequence)localObject1);
        if ((parama.IuA != null) && (parama.IuA.length() > 0))
        {
          localObject4 = parama.IuA;
          if (localObject4 != null)
          {
            this.Ivm.setVisibility(0);
            this.Ivg.setVisibility(0);
            localObject1 = localObject4;
            if (this.Ivw != null)
            {
              localObject1 = this.Ivw;
              this.Ivg.getContext();
              ((CharSequence)localObject4).toString();
              this.Ivg.getTextSize();
              localObject1 = ((c.a.c)localObject1).fnA();
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
      if (parama.IuZ)
      {
        localObject1 = parama.Iux;
        localObject5 = parama.Iuz;
        localObject4 = parama.IuA;
        localObject6 = View.inflate(this.mContext, 2131493583, null);
        if (localObject1 != null)
        {
          localObject7 = (ImageView)((View)localObject6).findViewById(2131302310);
          ((ImageView)localObject7).setVisibility(0);
          ((ImageView)localObject7).setImageBitmap((Bitmap)localObject1);
        }
        if (localObject5 != null)
        {
          localObject7 = (TextView)((View)localObject6).findViewById(2131302312);
          ((TextView)localObject7).setVisibility(0);
          localObject1 = localObject5;
          if (this.Ivw != null)
          {
            localObject1 = this.Ivw;
            ((CharSequence)localObject5).toString();
            ((TextView)localObject7).getTextSize();
            localObject1 = ((c.a.c)localObject1).fnA();
          }
          ((TextView)localObject7).setText((CharSequence)localObject1);
        }
        if (localObject4 != null)
        {
          localObject5 = (TextView)((View)localObject6).findViewById(2131302311);
          ((TextView)localObject5).setVisibility(0);
          if (this.Ivw == null) {
            break label2233;
          }
          localObject1 = this.Ivw;
          ((CharSequence)localObject4).toString();
          ((TextView)localObject5).getTextSize();
          localObject1 = ((c.a.c)localObject1).fnA();
          ((TextView)localObject5).setText((CharSequence)localObject1);
        }
        fX((View)localObject6);
        if ((parama.Iup != null) || (parama.Iuq != null))
        {
          localObject4 = parama.Iup;
          localObject5 = parama.Iuq;
          bool = parama.Iur;
          localObject6 = parama.Iut;
          this.Ivl.setLayoutResource(2131493593);
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject5;
          Object localObject6;
          Object localObject7;
          boolean bool;
          localObject1 = (LinearLayout)this.Ivl.inflate();
          if ((localObject1 != null) && (localObject4 != null)) {
            ((ImageView)((LinearLayout)localObject1).findViewById(2131305922)).setVisibility(0);
          }
          if ((localObject1 != null) && (localObject5 != null))
          {
            localObject7 = (TextView)((LinearLayout)localObject1).findViewById(2131305945);
            ((TextView)localObject7).setVisibility(0);
            localObject4 = localObject5;
            if (this.Ivw != null)
            {
              localObject4 = this.Ivw;
              ((CharSequence)localObject5).toString();
              this.jdField_new.getTextSize();
              localObject4 = ((c.a.c)localObject4).fnA();
            }
            ((TextView)localObject7).setText((CharSequence)localObject4);
          }
          if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
          {
            localObject4 = (ImageView)((LinearLayout)localObject1).findViewById(2131300962);
            ((ImageView)localObject4).setVisibility(0);
            aaV(0);
            ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(211899);
                b localb = new b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                if (this.Ivz.isSelected())
                {
                  c.b(c.this).startAnimation(c.a(c.this));
                  c.a(c.this).setAnimationListener(new Animation.AnimationListener()
                  {
                    public final void onAnimationEnd(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(211896);
                      c.b(c.this).setVisibility(8);
                      c.a(c.this, 0);
                      AppMethodBeat.o(211896);
                    }
                    
                    public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                    
                    public final void onAnimationStart(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(211895);
                      c.a(c.this, c.c(c.this));
                      AppMethodBeat.o(211895);
                    }
                  });
                  ObjectAnimator.ofFloat(this.Ivz, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
                  this.Ivz.setSelected(false);
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(211899);
                  return;
                  c.b(c.this).startAnimation(c.d(c.this));
                  c.d(c.this).setAnimationListener(new Animation.AnimationListener()
                  {
                    public final void onAnimationEnd(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(211898);
                      c.b(c.this).setVisibility(0);
                      c.a(c.this, 8);
                      AppMethodBeat.o(211898);
                    }
                    
                    public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                    
                    public final void onAnimationStart(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(211897);
                      c.a(c.this, c.e(c.this));
                      AppMethodBeat.o(211897);
                    }
                  });
                  ObjectAnimator.ofFloat(this.Ivz, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
                  this.Ivz.setSelected(true);
                }
              }
            });
          }
          if (parama.Iuu != null)
          {
            localObject1 = parama.Iuu;
            if ((this.Ivm != null) && (this.Ivm.getVisibility() == 0)) {
              this.Ivm.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(211900);
                  b localb = new b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(211900);
                }
              });
            }
          }
          else
          {
            if ((parama.Ium != null) && (parama.Ium.length() > 0))
            {
              localObject1 = parama.Ium;
              if (localObject1 != null)
              {
                this.Ivh.setVisibility(0);
                this.Ivh.setText((CharSequence)localObject1);
              }
              this.Ivr = true;
              i = parama.IuS;
              if (this.Ivh != null) {
                this.Ivh.setGravity(i);
              }
            }
            if ((parama.Iun != null) && (parama.Iun.length() > 0))
            {
              localObject1 = parama.Iun;
              this.mEditText.setVisibility(0);
              this.mEditText.setHint((CharSequence)localObject1);
            }
            if (parama.Iuo)
            {
              this.needEdit = parama.Iuo;
              if (!parama.Iuo) {
                continue;
              }
              this.mEditText.setVisibility(0);
            }
            if ((parama.IuB != null) && (parama.IuB.length() > 0)) {
              a(parama.IuB, parama.IuY, parama.IuJ);
            }
            if ((parama.IuC != null) && (parama.IuC.length() > 0)) {
              a(parama.IuC, parama.IuK);
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
            if (parama.Iuv != null) {
              this.Ivw = parama.Iuv;
            }
            setCancelable(parama.ov);
            this.ov = parama.ov;
            if (!this.ov) {
              super.setCancelable(parama.IuG);
            }
            if ((parama.IuD != null) || (parama.IuE != null) || (parama.IuF != null))
            {
              localObject1 = View.inflate(this.mContext, 2131493592, null);
              localObject4 = (Button)((View)localObject1).findViewById(2131302297);
              localObject5 = (Button)((View)localObject1).findViewById(2131302298);
              localObject6 = (Button)((View)localObject1).findViewById(2131302299);
              if (parama.IuD != null)
              {
                ((Button)localObject4).setVisibility(0);
                ((Button)localObject4).setText(parama.IuD);
                ((Button)localObject4).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(211904);
                    b localb = new b();
                    localb.bd(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                    if (parama.IuL != null) {
                      parama.IuL.onClick(c.this, -1);
                    }
                    c.this.dismiss();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(211904);
                  }
                });
              }
              if (parama.IuE != null)
              {
                ((Button)localObject5).setVisibility(0);
                ((Button)localObject5).setText(parama.IuE);
                ((Button)localObject5).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(211905);
                    b localb = new b();
                    localb.bd(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                    if (parama.IuM != null) {
                      parama.IuM.onClick(c.this, -2);
                    }
                    c.this.dismiss();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(211905);
                  }
                });
              }
              if (parama.IuF != null)
              {
                ((Button)localObject6).setVisibility(0);
                ((Button)localObject6).setText(parama.IuF);
                ((Button)localObject6).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(211906);
                    b localb = new b();
                    localb.bd(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                    if (parama.IuN != null) {
                      parama.IuN.onClick(c.this, -3);
                    }
                    c.this.dismiss();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(211906);
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
                a(parama.IuC, parama.IuK);
              }
              b((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
            }
            AppMethodBeat.o(211926);
            return;
            localException1 = localException1;
            this.Ivl.setVisibility(0);
            Object localObject2 = null;
            continue;
            label1950:
            wH(false);
            continue;
            if (!parama.Iva) {
              continue;
            }
            localObject2 = parama.Iux;
            localObject5 = parama.Iuz;
            localObject4 = parama.IuA;
            localObject6 = View.inflate(this.mContext, 2131493584, null);
            if (localObject2 != null)
            {
              localObject7 = (ImageView)((View)localObject6).findViewById(2131302310);
              ((ImageView)localObject7).setVisibility(0);
              ((ImageView)localObject7).setImageBitmap((Bitmap)localObject2);
            }
            if (localObject5 != null)
            {
              localObject7 = (TextView)((View)localObject6).findViewById(2131302312);
              ((TextView)localObject7).setVisibility(0);
              localObject2 = localObject5;
              if (this.Ivw != null)
              {
                localObject2 = this.Ivw;
                ((CharSequence)localObject5).toString();
                ((TextView)localObject7).getTextSize();
                localObject2 = ((c.a.c)localObject2).fnA();
              }
              ((TextView)localObject7).setText((CharSequence)localObject2);
            }
            if (localObject4 != null)
            {
              localObject5 = (TextView)((View)localObject6).findViewById(2131302311);
              ((TextView)localObject5).setVisibility(0);
              if (this.Ivw == null) {
                continue;
              }
              localObject2 = this.Ivw;
              ((CharSequence)localObject4).toString();
              ((TextView)localObject5).getTextSize();
              localObject2 = ((c.a.c)localObject2).fnA();
              ((TextView)localObject5).setText((CharSequence)localObject2);
            }
            fX((View)localObject6);
          }
        }
        catch (Exception localException2)
        {
          this.Ivl.setVisibility(0);
          localObject3 = null;
          continue;
          if (this.Ivo == null) {
            continue;
          }
          this.Ivo.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(211901);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(211901);
            }
          });
          continue;
          this.mEditText.setVisibility(8);
          continue;
          localObject3 = localObject4;
          continue;
        }
        label2233:
        Object localObject3 = localObject4;
      }
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(211928);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211907);
          c.this.dismiss();
          AppMethodBeat.o(211907);
        }
      });
      ap.e("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
      AppMethodBeat.o(211928);
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
        AppMethodBeat.o(211928);
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
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(211912);
    super.onCreate(paramBundle);
    setContentView(this.Ivb);
    AppMethodBeat.o(211912);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(211924);
    super.setCancelable(paramBoolean);
    this.ov = paramBoolean;
    setCanceledOnTouchOutside(this.ov);
    AppMethodBeat.o(211924);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(211916);
    this.Ivm.setVisibility(0);
    this.Ivd.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.Ivw != null)
    {
      localObject = this.Ivw;
      this.Ivd.getContext();
      paramCharSequence.toString();
      this.Ivd.getTextSize();
      localObject = ((c.a.c)localObject).fnA();
    }
    this.Ivd.setText((CharSequence)localObject);
    AppMethodBeat.o(211916);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(211914);
    this.Ivk.setVisibility(0);
    this.jdField_new.setVisibility(0);
    this.jdField_new.setMaxLines(2);
    this.jdField_new.setText(paramInt);
    this.jdField_new.getPaint().setFakeBoldText(true);
    aaU(this.mContext.getResources().getColor(2131099734));
    AppMethodBeat.o(211914);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(211913);
    this.Ivk.setVisibility(0);
    this.jdField_new.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.Ivw != null)
    {
      localObject = this.Ivw;
      paramCharSequence.toString();
      this.jdField_new.getTextSize();
      localObject = ((c.a.c)localObject).fnA();
    }
    this.jdField_new.setMaxLines(2);
    this.jdField_new.setText((CharSequence)localObject);
    this.jdField_new.getPaint().setFakeBoldText(true);
    aaU(this.mContext.getResources().getColor(2131099734));
    AppMethodBeat.o(211913);
  }
  
  public final void show()
  {
    AppMethodBeat.i(211927);
    try
    {
      super.show();
      AppMethodBeat.o(211927);
      return;
    }
    catch (Exception localException)
    {
      ap.printErrStackTrace("MicroMsg.MMAlertDialog", localException, "", new Object[0]);
      AppMethodBeat.o(211927);
    }
  }
  
  public static final class a
  {
    private a IvI;
    private Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(211908);
      this.mContext = paramContext;
      this.IvI = new a();
      AppMethodBeat.o(211908);
    }
    
    public final a a(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.IvI.IuJ = paramOnClickListener;
      return this;
    }
    
    public final a aRp(String paramString)
    {
      this.IvI.title = paramString;
      return this;
    }
    
    public final a aRq(String paramString)
    {
      this.IvI.Iuy = paramString;
      return this;
    }
    
    public final a aRr(String paramString)
    {
      this.IvI.IuB = paramString;
      return this;
    }
    
    public final a aRs(String paramString)
    {
      this.IvI.IuC = paramString;
      return this;
    }
    
    public final a b(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.IvI.IuK = paramOnClickListener;
      return this;
    }
    
    public final a fnx()
    {
      AppMethodBeat.i(211909);
      this.IvI.IuB = this.mContext.getString(2131755835);
      AppMethodBeat.o(211909);
      return this;
    }
    
    public final a fny()
    {
      this.IvI.ov = false;
      return this;
    }
    
    public final c fnz()
    {
      AppMethodBeat.i(211910);
      c localc = new c(this.mContext);
      localc.a(this.IvI);
      AppMethodBeat.o(211910);
      return localc;
    }
    
    public static abstract interface a {}
    
    public static abstract interface b {}
    
    public static abstract interface c
    {
      public abstract CharSequence fnA();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a.c
 * JD-Core Version:    0.7.0.1
 */