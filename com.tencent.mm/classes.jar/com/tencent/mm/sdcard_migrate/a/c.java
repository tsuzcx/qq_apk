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
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.ao;

public final class c
  extends Dialog
  implements DialogInterface
{
  private Button Bqt;
  private Animation GpA;
  private c.a.c GpB;
  private DialogInterface.OnDismissListener GpC;
  private LinearLayout Gph;
  private TextView Gpi;
  private TextView Gpj;
  private TextView Gpk;
  private TextView Gpl;
  private TextView Gpm;
  private ImageView Gpn;
  private View Gpo;
  private LinearLayout Gpp;
  private ViewStub Gpq;
  private LinearLayout Gpr;
  private ViewGroup Gps;
  private LinearLayout Gpt;
  private ViewGroup Gpu;
  private View Gpv;
  private boolean Gpw;
  private Animation Gpx;
  private Animation Gpy;
  private Animation Gpz;
  private View afF;
  com.tencent.mm.ui.widget.a.c iOnDialogDismissListener;
  private Context mContext;
  private EditText mEditText;
  private TextView myG;
  private boolean mz;
  private boolean needEdit;
  private Button qAl;
  
  public c(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(195890);
    this.Gpw = false;
    this.needEdit = false;
    this.mContext = paramContext;
    this.Gph = ((LinearLayout)View.inflate(this.mContext, 2131494766, null));
    this.Bqt = ((Button)this.Gph.findViewById(2131302314));
    this.qAl = ((Button)this.Gph.findViewById(2131302301));
    this.myG = ((TextView)this.Gph.findViewById(2131302315));
    this.Gpi = ((TextView)this.Gph.findViewById(2131302317));
    this.Gpj = ((TextView)this.Gph.findViewById(2131302307));
    this.Gpk = ((TextView)this.Gph.findViewById(2131302312));
    this.Gpl = ((TextView)this.Gph.findViewById(2131302311));
    this.Gpm = ((TextView)this.Gph.findViewById(2131298564));
    this.mEditText = ((EditText)this.Gph.findViewById(2131298569));
    this.Gpn = ((ImageView)this.Gph.findViewById(2131302310));
    this.Gpp = ((LinearLayout)this.Gph.findViewById(2131302316));
    this.Gpq = ((ViewStub)this.Gph.findViewById(2131305933));
    this.Gpr = ((LinearLayout)this.Gph.findViewById(2131302308));
    this.Gps = ((ViewGroup)this.Gph.findViewById(2131302295));
    this.Gpv = this.Gph.findViewById(2131302300);
    this.Gpt = ((LinearLayout)this.Gph.findViewById(2131302303));
    this.Gpu = ((ViewGroup)this.Gph.findViewById(2131305932));
    setCanceledOnTouchOutside(true);
    this.Gpx = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.Gpy = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.Gpz = AnimationUtils.loadAnimation(this.mContext, 2130771982);
    this.GpA = AnimationUtils.loadAnimation(this.mContext, 2130771982);
    AppMethodBeat.o(195890);
  }
  
  private void Yj(int paramInt)
  {
    AppMethodBeat.i(195894);
    if (this.Gpj != null) {
      this.Gpj.setTextColor(paramInt);
    }
    AppMethodBeat.o(195894);
  }
  
  private void Yk(int paramInt)
  {
    AppMethodBeat.i(195897);
    if (this.Gpr != null) {
      this.Gpr.setVisibility(paramInt);
    }
    if (this.Gpt != null) {
      this.Gpt.setVisibility(paramInt);
    }
    if ((this.Gpm != null) && (this.Gpw)) {
      this.Gpm.setVisibility(paramInt);
    }
    if (this.mEditText != null)
    {
      if (!this.needEdit)
      {
        this.mEditText.setVisibility(8);
        AppMethodBeat.o(195897);
        return;
      }
      this.mEditText.setVisibility(paramInt);
    }
    AppMethodBeat.o(195897);
  }
  
  private void Yl(int paramInt)
  {
    AppMethodBeat.i(195900);
    this.Bqt.setTextColor(paramInt);
    AppMethodBeat.o(195900);
  }
  
  private void Ym(int paramInt)
  {
    AppMethodBeat.i(195901);
    this.qAl.setTextColor(paramInt);
    AppMethodBeat.o(195901);
  }
  
  private void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(195904);
    this.Gpv.setVisibility(8);
    this.Gps.removeAllViews();
    this.Gps.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(195904);
  }
  
  private void a(CharSequence paramCharSequence, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(195902);
    if (this.qAl != null)
    {
      this.qAl.setVisibility(0);
      this.qAl.setText(paramCharSequence);
      this.qAl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(195882);
          if (paramOnClickListener != null) {
            paramOnClickListener.onClick(c.this, -2);
          }
          if (this.GpL) {
            c.this.cancel();
          }
          AppMethodBeat.o(195882);
        }
      });
    }
    AppMethodBeat.o(195902);
  }
  
  private void a(CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(195899);
    if (this.Bqt == null)
    {
      AppMethodBeat.o(195899);
      return;
    }
    this.Bqt.setVisibility(0);
    this.Bqt.setText(paramCharSequence);
    this.Bqt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(195881);
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(c.this, -1);
        }
        if (paramBoolean) {
          c.this.dismiss();
        }
        AppMethodBeat.o(195881);
      }
    });
    AppMethodBeat.o(195899);
  }
  
  private void fJ(View paramView)
  {
    AppMethodBeat.i(195898);
    this.afF = paramView;
    if (this.afF != null)
    {
      this.Gpr.setVisibility(0);
      this.Gpt.setVisibility(0);
      this.Gpt.removeAllViews();
      this.Gpt.setGravity(1);
      this.Gpt.addView(this.afF, new LinearLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(195898);
  }
  
  private void vN(boolean paramBoolean)
  {
    AppMethodBeat.i(195896);
    if (paramBoolean)
    {
      int i = ao.fromDPToPix(this.mContext, 8);
      this.Gpr.setVisibility(0);
      this.Gpr.setPadding(i, i, i, i);
      this.Gpr.setBackgroundResource(2131231925);
    }
    AppMethodBeat.o(195896);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(195905);
    int i;
    if ((parama.title != null) && (parama.title.length() > 0))
    {
      i = parama.GoZ;
      if (this.myG != null) {
        this.myG.setGravity(i);
      }
      setTitle(parama.title);
    }
    Object localObject4;
    Object localObject1;
    if ((parama.Gor != null) && (parama.Gor.length() > 0))
    {
      localObject4 = parama.Gor;
      this.Gpp.setVisibility(0);
      this.Gpi.setVisibility(0);
      localObject1 = localObject4;
      if (this.GpB != null)
      {
        localObject1 = this.GpB;
        ((CharSequence)localObject4).toString();
        this.myG.getTextSize();
        localObject1 = ((c.a.c)localObject1).eUf();
      }
      this.Gpi.setText((CharSequence)localObject1);
    }
    if (parama.Dmh != 0)
    {
      i = parama.Dmh;
      this.myG.setTextColor(ColorStateList.valueOf(i));
    }
    if (parama.GoW != 0)
    {
      i = parama.GoW;
      this.myG.setMaxLines(i);
    }
    if (parama.GoX != 0)
    {
      i = parama.GoX;
      this.Gpj.setMaxLines(i);
    }
    if (parama.tk != null) {
      fJ(parama.tk);
    }
    if (parama.GoU != null)
    {
      localObject4 = parama.GoU;
      this.Gpp.setVisibility(0);
      this.Gpq.setLayoutResource(2131493580);
    }
    try
    {
      localObject1 = (LinearLayout)this.Gpq.inflate();
      ((LinearLayout)localObject1).addView((View)localObject4);
      if (parama.GoV != null)
      {
        this.Gpo = parama.GoV;
        if (this.Gpo != null)
        {
          this.Gpr.setVisibility(8);
          this.Gpm.setVisibility(8);
          this.mEditText.setVisibility(8);
          this.Gpu.removeAllViews();
          this.Gpu.addView(this.Gpo, new LinearLayout.LayoutParams(-1, -1));
          this.Gpu.setVisibility(8);
        }
      }
      if (parama.GoC != null)
      {
        localObject1 = parama.GoC;
        if (this.afF == null)
        {
          this.Gpr.setVisibility(0);
          this.Gpn.setVisibility(0);
          this.Gpn.setBackgroundDrawable((Drawable)localObject1);
        }
      }
      if ((parama.GoE != null) && (parama.GoE.length() > 0)) {
        setMessage(parama.GoE);
      }
      vN(parama.GoN);
      if (parama.thumbPath != null)
      {
        localObject1 = parama.thumbPath;
        i = ao.fromDPToPix(this.mContext, 120);
        this.Gpr.setVisibility(0);
        this.Gpn.setVisibility(0);
        if ((this.Gpn instanceof com.tencent.mm.ui.f.a)) {
          ((com.tencent.mm.ui.f.a)this.Gpn).aE((String)localObject1, i, i);
        }
        i = parama.Gpb;
        this.Gpr.setVisibility(i);
        this.Gpn.setVisibility(i);
      }
      if ((!parama.Gpf) && (!parama.Gpg))
      {
        if ((parama.GoE != null) && (parama.GoE.length() > 0)) {
          setMessage(parama.GoE);
        }
        if ((parama.GoF == null) || (parama.GoF.length() <= 0)) {
          break label1950;
        }
        localObject1 = parama.GoF;
        this.Gpr.setVisibility(0);
        this.Gpk.setVisibility(0);
        this.Gpk.setMaxLines(2);
        this.Gpk.setText((CharSequence)localObject1);
        if ((parama.GoG != null) && (parama.GoG.length() > 0))
        {
          localObject4 = parama.GoG;
          if (localObject4 != null)
          {
            this.Gpr.setVisibility(0);
            this.Gpl.setVisibility(0);
            localObject1 = localObject4;
            if (this.GpB != null)
            {
              localObject1 = this.GpB;
              this.Gpl.getContext();
              ((CharSequence)localObject4).toString();
              this.Gpl.getTextSize();
              localObject1 = ((c.a.c)localObject1).eUf();
            }
            this.Gpl.setText((CharSequence)localObject1);
          }
        }
        if (parama.GoD != null)
        {
          localObject1 = parama.GoD;
          if (this.afF == null)
          {
            this.Gpr.setVisibility(0);
            this.Gpn.setVisibility(0);
            this.Gpn.setImageBitmap((Bitmap)localObject1);
          }
        }
      }
      if (parama.Gpf)
      {
        localObject1 = parama.GoD;
        localObject5 = parama.GoF;
        localObject4 = parama.GoG;
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
          if (this.GpB != null)
          {
            localObject1 = this.GpB;
            ((CharSequence)localObject5).toString();
            ((TextView)localObject7).getTextSize();
            localObject1 = ((c.a.c)localObject1).eUf();
          }
          ((TextView)localObject7).setText((CharSequence)localObject1);
        }
        if (localObject4 != null)
        {
          localObject5 = (TextView)((View)localObject6).findViewById(2131302311);
          ((TextView)localObject5).setVisibility(0);
          if (this.GpB == null) {
            break label2233;
          }
          localObject1 = this.GpB;
          ((CharSequence)localObject4).toString();
          ((TextView)localObject5).getTextSize();
          localObject1 = ((c.a.c)localObject1).eUf();
          ((TextView)localObject5).setText((CharSequence)localObject1);
        }
        fJ((View)localObject6);
        if ((parama.Gov != null) || (parama.Gow != null))
        {
          localObject4 = parama.Gov;
          localObject5 = parama.Gow;
          bool = parama.Gox;
          localObject6 = parama.Goz;
          this.Gpq.setLayoutResource(2131493593);
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
          localObject1 = (LinearLayout)this.Gpq.inflate();
          if ((localObject1 != null) && (localObject4 != null)) {
            ((ImageView)((LinearLayout)localObject1).findViewById(2131305922)).setVisibility(0);
          }
          if ((localObject1 != null) && (localObject5 != null))
          {
            localObject7 = (TextView)((LinearLayout)localObject1).findViewById(2131305945);
            ((TextView)localObject7).setVisibility(0);
            localObject4 = localObject5;
            if (this.GpB != null)
            {
              localObject4 = this.GpB;
              ((CharSequence)localObject5).toString();
              this.myG.getTextSize();
              localObject4 = ((c.a.c)localObject4).eUf();
            }
            ((TextView)localObject7).setText((CharSequence)localObject4);
          }
          if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
          {
            localObject4 = (ImageView)((LinearLayout)localObject1).findViewById(2131300962);
            ((ImageView)localObject4).setVisibility(0);
            Yk(0);
            ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(195880);
                if (this.GpE.isSelected())
                {
                  c.b(c.this).startAnimation(c.a(c.this));
                  c.a(c.this).setAnimationListener(new Animation.AnimationListener()
                  {
                    public final void onAnimationEnd(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(195877);
                      c.b(c.this).setVisibility(8);
                      c.a(c.this, 0);
                      AppMethodBeat.o(195877);
                    }
                    
                    public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                    
                    public final void onAnimationStart(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(195876);
                      c.a(c.this, c.c(c.this));
                      AppMethodBeat.o(195876);
                    }
                  });
                  ObjectAnimator.ofFloat(this.GpE, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
                  this.GpE.setSelected(false);
                  AppMethodBeat.o(195880);
                  return;
                }
                c.b(c.this).startAnimation(c.d(c.this));
                c.d(c.this).setAnimationListener(new Animation.AnimationListener()
                {
                  public final void onAnimationEnd(Animation paramAnonymous2Animation)
                  {
                    AppMethodBeat.i(195879);
                    c.b(c.this).setVisibility(0);
                    c.a(c.this, 8);
                    AppMethodBeat.o(195879);
                  }
                  
                  public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                  
                  public final void onAnimationStart(Animation paramAnonymous2Animation)
                  {
                    AppMethodBeat.i(195878);
                    c.a(c.this, c.e(c.this));
                    AppMethodBeat.o(195878);
                  }
                });
                ObjectAnimator.ofFloat(this.GpE, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
                this.GpE.setSelected(true);
                AppMethodBeat.o(195880);
              }
            });
          }
          if (parama.GoA != null)
          {
            localObject1 = parama.GoA;
            if ((this.Gpr != null) && (this.Gpr.getVisibility() == 0)) {
              this.Gpr.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView) {}
              });
            }
          }
          else
          {
            if ((parama.Gos != null) && (parama.Gos.length() > 0))
            {
              localObject1 = parama.Gos;
              if (localObject1 != null)
              {
                this.Gpm.setVisibility(0);
                this.Gpm.setText((CharSequence)localObject1);
              }
              this.Gpw = true;
              i = parama.GoY;
              if (this.Gpm != null) {
                this.Gpm.setGravity(i);
              }
            }
            if ((parama.Got != null) && (parama.Got.length() > 0))
            {
              localObject1 = parama.Got;
              this.mEditText.setVisibility(0);
              this.mEditText.setHint((CharSequence)localObject1);
            }
            if (parama.Gou)
            {
              this.needEdit = parama.Gou;
              if (!parama.Gou) {
                continue;
              }
              this.mEditText.setVisibility(0);
            }
            if ((parama.GoH != null) && (parama.GoH.length() > 0)) {
              a(parama.GoH, parama.Gpe, parama.GoP);
            }
            if ((parama.GoI != null) && (parama.GoI.length() > 0)) {
              a(parama.GoI, parama.GoQ);
            }
            if (parama.Gpd != 0) {
              Yl(parama.Gpd);
            }
            if (parama.Gpc != 0) {
              Ym(parama.Gpc);
            }
            if (parama.VW != null) {
              setOnCancelListener(parama.VW);
            }
            if (parama.VX != null)
            {
              this.GpC = parama.VX;
              setOnDismissListener(parama.VX);
            }
            if (parama.GoB != null) {
              this.GpB = parama.GoB;
            }
            setCancelable(parama.mz);
            this.mz = parama.mz;
            if (!this.mz) {
              super.setCancelable(parama.GoM);
            }
            if ((parama.GoJ != null) || (parama.GoK != null) || (parama.GoL != null))
            {
              localObject1 = View.inflate(this.mContext, 2131493592, null);
              localObject4 = (Button)((View)localObject1).findViewById(2131302297);
              localObject5 = (Button)((View)localObject1).findViewById(2131302298);
              localObject6 = (Button)((View)localObject1).findViewById(2131302299);
              if (parama.GoJ != null)
              {
                ((Button)localObject4).setVisibility(0);
                ((Button)localObject4).setText(parama.GoJ);
                ((Button)localObject4).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(195883);
                    if (parama.GoR != null) {
                      parama.GoR.onClick(c.this, -1);
                    }
                    c.this.dismiss();
                    AppMethodBeat.o(195883);
                  }
                });
              }
              if (parama.GoK != null)
              {
                ((Button)localObject5).setVisibility(0);
                ((Button)localObject5).setText(parama.GoK);
                ((Button)localObject5).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(195884);
                    if (parama.GoS != null) {
                      parama.GoS.onClick(c.this, -2);
                    }
                    c.this.dismiss();
                    AppMethodBeat.o(195884);
                  }
                });
              }
              if (parama.GoL != null)
              {
                ((Button)localObject6).setVisibility(0);
                ((Button)localObject6).setText(parama.GoL);
                ((Button)localObject6).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(195885);
                    if (parama.GoT != null) {
                      parama.GoT.onClick(c.this, -3);
                    }
                    c.this.dismiss();
                    AppMethodBeat.o(195885);
                  }
                });
              }
              a((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
            }
            if (parama.Goy)
            {
              localObject1 = View.inflate(this.mContext, 2131493579, null);
              this.qAl = ((Button)((View)localObject1).findViewById(2131302301));
              this.Bqt = ((Button)((View)localObject1).findViewById(2131302314));
              if (parama.Gpd != 0) {
                Yl(parama.Gpd);
              }
              if (parama.Gpc != 0) {
                Ym(parama.Gpc);
              }
              if ((parama.GoH != null) && (parama.GoH.length() > 0)) {
                a(parama.GoH, parama.Gpe, parama.GoP);
              }
              if ((parama.GoI != null) && (parama.GoI.length() > 0)) {
                a(parama.GoI, parama.GoQ);
              }
              a((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
            }
            AppMethodBeat.o(195905);
            return;
            localException1 = localException1;
            this.Gpq.setVisibility(0);
            Object localObject2 = null;
            continue;
            label1950:
            vN(false);
            continue;
            if (!parama.Gpg) {
              continue;
            }
            localObject2 = parama.GoD;
            localObject5 = parama.GoF;
            localObject4 = parama.GoG;
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
              if (this.GpB != null)
              {
                localObject2 = this.GpB;
                ((CharSequence)localObject5).toString();
                ((TextView)localObject7).getTextSize();
                localObject2 = ((c.a.c)localObject2).eUf();
              }
              ((TextView)localObject7).setText((CharSequence)localObject2);
            }
            if (localObject4 != null)
            {
              localObject5 = (TextView)((View)localObject6).findViewById(2131302311);
              ((TextView)localObject5).setVisibility(0);
              if (this.GpB == null) {
                continue;
              }
              localObject2 = this.GpB;
              ((CharSequence)localObject4).toString();
              ((TextView)localObject5).getTextSize();
              localObject2 = ((c.a.c)localObject2).eUf();
              ((TextView)localObject5).setText((CharSequence)localObject2);
            }
            fJ((View)localObject6);
          }
        }
        catch (Exception localException2)
        {
          this.Gpq.setVisibility(0);
          localObject3 = null;
          continue;
          if (this.Gpt == null) {
            continue;
          }
          this.Gpt.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView) {}
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
    AppMethodBeat.i(195907);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195886);
          c.this.dismiss();
          AppMethodBeat.o(195886);
        }
      });
      an.e("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
      AppMethodBeat.o(195907);
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
        AppMethodBeat.o(195907);
        return;
        super.dismiss();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        an.e("MicroMsg.MMAlertDialog", "dismiss exception, e = " + localException.getMessage(), new Object[0]);
      }
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(195891);
    super.onCreate(paramBundle);
    setContentView(this.Gph);
    AppMethodBeat.o(195891);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(195903);
    super.setCancelable(paramBoolean);
    this.mz = paramBoolean;
    setCanceledOnTouchOutside(this.mz);
    AppMethodBeat.o(195903);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(195895);
    this.Gpr.setVisibility(0);
    this.Gpj.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.GpB != null)
    {
      localObject = this.GpB;
      this.Gpj.getContext();
      paramCharSequence.toString();
      this.Gpj.getTextSize();
      localObject = ((c.a.c)localObject).eUf();
    }
    this.Gpj.setText((CharSequence)localObject);
    AppMethodBeat.o(195895);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(195893);
    this.Gpp.setVisibility(0);
    this.myG.setVisibility(0);
    this.myG.setMaxLines(2);
    this.myG.setText(paramInt);
    this.myG.getPaint().setFakeBoldText(true);
    Yj(this.mContext.getResources().getColor(2131099734));
    AppMethodBeat.o(195893);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(195892);
    this.Gpp.setVisibility(0);
    this.myG.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.GpB != null)
    {
      localObject = this.GpB;
      paramCharSequence.toString();
      this.myG.getTextSize();
      localObject = ((c.a.c)localObject).eUf();
    }
    this.myG.setMaxLines(2);
    this.myG.setText((CharSequence)localObject);
    this.myG.getPaint().setFakeBoldText(true);
    Yj(this.mContext.getResources().getColor(2131099734));
    AppMethodBeat.o(195892);
  }
  
  public final void show()
  {
    AppMethodBeat.i(195906);
    try
    {
      super.show();
      AppMethodBeat.o(195906);
      return;
    }
    catch (Exception localException)
    {
      an.printErrStackTrace("MicroMsg.MMAlertDialog", localException, "", new Object[0]);
      AppMethodBeat.o(195906);
    }
  }
  
  public static final class a
  {
    public a GpN;
    public Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(195887);
      this.mContext = paramContext;
      this.GpN = new a();
      AppMethodBeat.o(195887);
    }
    
    public final a a(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.GpN.GoP = paramOnClickListener;
      return this;
    }
    
    public final a aKn(String paramString)
    {
      this.GpN.title = paramString;
      return this;
    }
    
    public final a aKo(String paramString)
    {
      this.GpN.GoE = paramString;
      return this;
    }
    
    public final a aKp(String paramString)
    {
      this.GpN.GoH = paramString;
      return this;
    }
    
    public final a eUc()
    {
      AppMethodBeat.i(195888);
      this.GpN.GoH = this.mContext.getString(2131755835);
      AppMethodBeat.o(195888);
      return this;
    }
    
    public final a eUd()
    {
      this.GpN.mz = false;
      return this;
    }
    
    public final c eUe()
    {
      AppMethodBeat.i(195889);
      c localc = new c(this.mContext);
      localc.a(this.GpN);
      AppMethodBeat.o(195889);
      return localc;
    }
    
    public static abstract interface a {}
    
    public static abstract interface b {}
    
    public static abstract interface c
    {
      public abstract CharSequence eUf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a.c
 * JD-Core Version:    0.7.0.1
 */