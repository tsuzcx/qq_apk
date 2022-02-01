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
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.edittext.PasterEditText;

public class d
  extends Dialog
  implements DialogInterface
{
  public Button Bqt;
  private Animation GpA;
  public DialogInterface.OnDismissListener GpC;
  private LinearLayout Gph;
  private TextView Gpi;
  public TextView Gpj;
  private TextView Gpk;
  private TextView Gpl;
  private TextView Gpm;
  private ImageView Gpn;
  private View Gpo;
  private LinearLayout Gpp;
  private ViewStub Gpq;
  public LinearLayout Gpr;
  private ViewGroup Gps;
  private LinearLayout Gpt;
  private ViewGroup Gpu;
  private View Gpv;
  private boolean Gpw;
  private Animation Gpx;
  private Animation Gpy;
  private Animation Gpz;
  private d.a.d Jfc;
  CheckBox adQ;
  private View afF;
  public c iOnDialogDismissListener;
  private Context mContext;
  private EditText mEditText;
  private TextView myG;
  private boolean mz;
  private boolean needEdit;
  private Button qAl;
  
  public d(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(159314);
    this.Gpw = false;
    this.needEdit = false;
    this.mContext = paramContext;
    this.Gph = ((LinearLayout)View.inflate(this.mContext, 2131494764, null));
    this.Bqt = ((Button)this.Gph.findViewById(2131302314));
    this.qAl = ((Button)this.Gph.findViewById(2131302301));
    this.myG = ((TextView)this.Gph.findViewById(2131302315));
    this.Gpi = ((TextView)this.Gph.findViewById(2131302317));
    this.Gpj = ((TextView)this.Gph.findViewById(2131302307));
    this.Gpk = ((TextView)this.Gph.findViewById(2131302312));
    this.Gpl = ((TextView)this.Gph.findViewById(2131302311));
    this.Gpm = ((TextView)this.Gph.findViewById(2131298564));
    this.mEditText = ((EditText)this.Gph.findViewById(2131298569));
    this.adQ = ((CheckBox)this.Gph.findViewById(2131298561));
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
    AppMethodBeat.o(159314);
  }
  
  private void Yj(int paramInt)
  {
    AppMethodBeat.i(159318);
    if (this.Gpj != null) {
      this.Gpj.setTextColor(paramInt);
    }
    AppMethodBeat.o(159318);
  }
  
  private void Yk(int paramInt)
  {
    AppMethodBeat.i(159324);
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
        AppMethodBeat.o(159324);
        return;
      }
      this.mEditText.setVisibility(paramInt);
    }
    AppMethodBeat.o(159324);
  }
  
  private void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(159334);
    this.Gpv.setVisibility(8);
    this.Gps.removeAllViews();
    this.Gps.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(159334);
  }
  
  private void aH(View paramView, int paramInt)
  {
    AppMethodBeat.i(159325);
    this.afF = paramView;
    if (this.afF != null)
    {
      this.Gpr.setVisibility(0);
      this.Gpt.setVisibility(0);
      this.Gpt.removeAllViews();
      this.Gpt.setGravity(1);
      this.Gpt.addView(this.afF, new LinearLayout.LayoutParams(paramInt, paramInt));
    }
    AppMethodBeat.o(159325);
  }
  
  private void vN(boolean paramBoolean)
  {
    AppMethodBeat.i(159320);
    if (paramBoolean)
    {
      int i = ao.fromDPToPix(this.mContext, 8);
      this.Gpr.setVisibility(0);
      this.Gpr.setPadding(i, i, i, i);
    }
    AppMethodBeat.o(159320);
  }
  
  public final void Yl(int paramInt)
  {
    AppMethodBeat.i(159327);
    this.Bqt.setTextColor(paramInt);
    AppMethodBeat.o(159327);
  }
  
  public final void Ym(int paramInt)
  {
    AppMethodBeat.i(159328);
    this.qAl.setTextColor(paramInt);
    AppMethodBeat.o(159328);
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
    int i;
    if ((parama.title != null) && (parama.title.length() > 0))
    {
      i = parama.GoZ;
      if (this.myG != null) {
        this.myG.setGravity(i);
      }
      setTitle(parama.title);
    }
    Object localObject3;
    Object localObject1;
    if ((parama.Gor != null) && (parama.Gor.length() > 0))
    {
      localObject3 = parama.Gor;
      this.Gpp.setVisibility(0);
      this.Gpi.setVisibility(0);
      localObject1 = localObject3;
      if (this.Jfc != null) {
        localObject1 = this.Jfc.a(((CharSequence)localObject3).toString(), this.myG.getTextSize());
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
      aH(parama.tk, -1);
    }
    if (parama.GoU != null)
    {
      localObject3 = parama.GoU;
      this.Gpp.setVisibility(0);
      this.Gpq.setLayoutResource(2131493580);
    }
    try
    {
      localObject1 = (LinearLayout)this.Gpq.inflate();
      ((LinearLayout)localObject1).addView((View)localObject3);
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
          break label2278;
        }
        localObject1 = parama.GoF;
        this.Gpr.setVisibility(0);
        this.Gpk.setVisibility(0);
        this.Gpk.setMaxLines(2);
        this.Gpk.setText((CharSequence)localObject1);
        if ((parama.GoG != null) && (parama.GoG.length() > 0))
        {
          localObject3 = parama.GoG;
          if (localObject3 != null)
          {
            this.Gpr.setVisibility(0);
            this.Gpl.setVisibility(0);
            localObject1 = localObject3;
            if (this.Jfc != null)
            {
              localObject1 = this.Jfc;
              this.Gpl.getContext();
              localObject1 = ((d.a.d)localObject1).a(((CharSequence)localObject3).toString(), this.Gpl.getTextSize());
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
      boolean bool;
      d.a.a locala;
      if (parama.Gpf)
      {
        localObject1 = parama.GoD;
        localObject4 = parama.GoF;
        localObject3 = parama.GoG;
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
          if (this.Jfc != null) {
            localObject1 = this.Jfc.a(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
          }
          ((TextView)localObject6).setText((CharSequence)localObject1);
        }
        if (localObject3 != null)
        {
          localObject4 = (TextView)((View)localObject5).findViewById(2131302311);
          ((TextView)localObject4).setVisibility(0);
          if (this.Jfc == null) {
            break label2662;
          }
          localObject1 = this.Jfc.a(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
          ((TextView)localObject4).setText((CharSequence)localObject1);
        }
        aH((View)localObject5, -1);
        if ((parama.Gov != null) || (parama.Gow != null))
        {
          localObject6 = parama.Gov;
          localObject4 = parama.Gow;
          bool = parama.Gox;
          localObject5 = parama.JeW;
          locala = parama.JeX;
          this.Gpq.setLayoutResource(2131493593);
          localObject1 = null;
        }
      }
      try
      {
        localObject3 = (LinearLayout)this.Gpq.inflate();
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
          this.Gpq.setVisibility(0);
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
        if (this.Jfc != null) {
          localObject3 = this.Jfc.a(((CharSequence)localObject4).toString(), this.myG.getTextSize());
        }
        ((TextView)localObject6).setText((CharSequence)localObject3);
      }
      if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
      {
        localObject3 = (ImageView)((LinearLayout)localObject1).findViewById(2131300962);
        ((ImageView)localObject3).setVisibility(0);
        Yk(0);
        ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(159297);
            if (this.Jfd != null) {
              this.Jfd.eNA();
            }
            if (this.GpE.isSelected())
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
              ObjectAnimator.ofFloat(this.GpE, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
              this.GpE.setSelected(false);
              AppMethodBeat.o(159297);
              return;
            }
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
            ObjectAnimator.ofFloat(this.GpE, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
            this.GpE.setSelected(true);
            AppMethodBeat.o(159297);
          }
        });
      }
      if (parama.JeY != null) {
        b(parama.JeY);
      }
      if ((parama.Jfa != null) && (!parama.Jfa.isRecycled()))
      {
        localObject3 = parama.Jfa;
        bool = parama.GoO;
        i2 = parama.Gpa;
        if (localObject3 != null)
        {
          vN(false);
          this.Gpr.setVisibility(0);
          this.Gpr.setGravity(1);
          this.Gpr.setPadding(0, 0, 0, 0);
          localObject5 = View.inflate(this.mContext, 2131493585, null);
          localObject6 = (ImageView)((View)localObject5).findViewById(2131302310);
          if (!bool) {
            break label2648;
          }
          i = ((Bitmap)localObject3).getWidth();
          j = ((Bitmap)localObject3).getHeight();
          localObject4 = null;
          f = j / i;
          n = 0;
          m = 0;
          i1 = ao.av(this.mContext, 2131165260);
          i = ao.av(this.mContext, 2131165259);
          k = 0;
          j = 0;
          if ((f <= 0.0F) || (f >= 0.5D)) {
            break label2501;
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
          localObject1 = al.c((Bitmap)localObject1, ao.fromDPToPix(this.mContext, 3));
          ((ImageView)localObject6).setImageBitmap((Bitmap)localObject1);
          localObject1 = (ImageView)((View)localObject5).findViewById(2131300961);
          if (i2 != 0) {
            break label2596;
          }
          ((ImageView)localObject1).setVisibility(8);
          aH((View)localObject5, -2);
        }
      }
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
      if ((parama.JeV != null) && (parama.JeV.length() > 0))
      {
        localObject1 = parama.JeV;
        this.adQ.setVisibility(0);
        this.adQ.setText((CharSequence)localObject1);
      }
      if (parama.Gou)
      {
        this.needEdit = parama.Gou;
        if (parama.Gou) {
          this.mEditText.setVisibility(0);
        }
      }
      else
      {
        if ((parama.GoH != null) && (parama.GoH.length() > 0)) {
          a(parama.GoH, parama.Gpe, parama.GoP);
        }
        if ((parama.GoI != null) && (parama.GoI.length() > 0)) {
          b(parama.GoI, true, parama.GoQ);
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
        if (parama.JeZ != null) {
          this.Jfc = parama.JeZ;
        }
        setCancelable(parama.mz);
        this.mz = parama.mz;
        if (!this.mz) {
          super.setCancelable(parama.GoM);
        }
        if ((parama.GoJ != null) || (parama.GoK != null) || (parama.GoL != null))
        {
          localObject1 = View.inflate(this.mContext, 2131493592, null);
          localObject3 = (Button)((View)localObject1).findViewById(2131302297);
          localObject4 = (Button)((View)localObject1).findViewById(2131302298);
          localObject5 = (Button)((View)localObject1).findViewById(2131302299);
          if (parama.GoJ != null)
          {
            ((Button)localObject3).setVisibility(0);
            ((Button)localObject3).setText(parama.GoJ);
            ((Button)localObject3).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159302);
                if (parama.GoR != null) {
                  parama.GoR.onClick(d.this, -1);
                }
                d.this.dismiss();
                AppMethodBeat.o(159302);
              }
            });
          }
          if (parama.GoK != null)
          {
            ((Button)localObject4).setVisibility(0);
            ((Button)localObject4).setText(parama.GoK);
            ((Button)localObject4).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159303);
                if (parama.GoS != null) {
                  parama.GoS.onClick(d.this, -2);
                }
                d.this.dismiss();
                AppMethodBeat.o(159303);
              }
            });
          }
          if (parama.GoL != null)
          {
            ((Button)localObject5).setVisibility(0);
            ((Button)localObject5).setText(parama.GoL);
            ((Button)localObject5).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159304);
                if (parama.GoT != null) {
                  parama.GoT.onClick(d.this, -3);
                }
                d.this.dismiss();
                AppMethodBeat.o(159304);
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
            b(parama.GoI, true, parama.GoQ);
          }
          a((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
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
        this.Gpq.setVisibility(0);
        Object localObject2 = null;
        continue;
        label2278:
        vN(false);
        continue;
        label2596:
        if (parama.Gpg)
        {
          localObject2 = parama.GoD;
          localObject4 = parama.GoF;
          localObject3 = parama.GoG;
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
            if (this.Jfc != null) {
              localObject2 = this.Jfc.a(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
            }
            ((TextView)localObject6).setText((CharSequence)localObject2);
          }
          if (localObject3 != null)
          {
            localObject4 = (TextView)((View)localObject5).findViewById(2131302311);
            ((TextView)localObject4).setVisibility(0);
            if (this.Jfc != null)
            {
              localObject2 = this.Jfc.a(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
              ((TextView)localObject4).setText((CharSequence)localObject2);
            }
          }
          else
          {
            aH((View)localObject5, -1);
            continue;
          }
          label2501:
          label2648:
          label2662:
          localObject2 = localException2;
        }
      }
    }
  }
  
  public final void a(CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159326);
    if (this.Bqt == null)
    {
      AppMethodBeat.o(159326);
      return;
    }
    this.Bqt.setVisibility(0);
    this.Bqt.setText(paramCharSequence);
    this.Bqt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159300);
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(d.this, -1);
        }
        if (paramBoolean) {
          d.this.dismiss();
        }
        AppMethodBeat.o(159300);
      }
    });
    AppMethodBeat.o(159326);
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
    if ((this.Gpr != null) && (this.Gpr.getVisibility() == 0))
    {
      this.Gpr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159298);
          if (paramb != null) {
            paramb.crN();
          }
          AppMethodBeat.o(159298);
        }
      });
      AppMethodBeat.o(159323);
      return;
    }
    if (this.Gpt != null) {
      this.Gpt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159299);
          if (paramb != null) {
            paramb.crN();
          }
          AppMethodBeat.o(159299);
        }
      });
    }
    AppMethodBeat.o(159323);
  }
  
  public final void b(CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159330);
    if (this.qAl == null)
    {
      AppMethodBeat.o(159330);
      return;
    }
    this.qAl.setVisibility(0);
    this.qAl.setText(paramCharSequence);
    this.qAl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159301);
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(d.this, -2);
        }
        if (paramBoolean) {
          d.this.cancel();
        }
        AppMethodBeat.o(159301);
      }
    });
    AppMethodBeat.o(159330);
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
      an.e("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
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
        an.e("MicroMsg.MMAlertDialog", "dismiss exception, e = " + localException.getMessage(), new Object[0]);
      }
    }
  }
  
  public final String fvm()
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
  
  public final int fvn()
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
  
  public final ImageView fvo()
  {
    return this.Gpn;
  }
  
  public final Button getButton(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case -1: 
      return this.Bqt;
    }
    return this.qAl;
  }
  
  public View getContentView()
  {
    return this.Gph;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(159315);
    super.onCreate(paramBundle);
    setContentView(this.Gph);
    AppMethodBeat.o(159315);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(159332);
    super.setCancelable(paramBoolean);
    this.mz = paramBoolean;
    setCanceledOnTouchOutside(this.mz);
    AppMethodBeat.o(159332);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159319);
    this.Gpr.setVisibility(0);
    this.Gpj.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.Jfc != null)
    {
      localObject = this.Jfc;
      this.Gpj.getContext();
      localObject = ((d.a.d)localObject).a(paramCharSequence.toString(), this.Gpj.getTextSize());
    }
    this.Gpj.setText((CharSequence)localObject);
    AppMethodBeat.o(159319);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(159317);
    this.Gpp.setVisibility(0);
    this.myG.setVisibility(0);
    this.myG.setMaxLines(2);
    this.myG.setText(paramInt);
    this.myG.getPaint().setFakeBoldText(true);
    Yj(this.mContext.getResources().getColor(2131099734));
    AppMethodBeat.o(159317);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159316);
    this.Gpp.setVisibility(0);
    this.myG.setVisibility(0);
    CharSequence localCharSequence = paramCharSequence;
    if (this.Jfc != null) {
      localCharSequence = this.Jfc.a(paramCharSequence.toString(), this.myG.getTextSize());
    }
    this.myG.setMaxLines(2);
    this.myG.setText(localCharSequence);
    this.myG.getPaint().setFakeBoldText(true);
    Yj(this.mContext.getResources().getColor(2131099734));
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
      an.printErrStackTrace("MicroMsg.MMAlertDialog", localException, "", new Object[0]);
      AppMethodBeat.o(159336);
    }
  }
  
  public final void yc(boolean paramBoolean)
  {
    AppMethodBeat.i(159333);
    super.setCancelable(paramBoolean);
    AppMethodBeat.o(159333);
  }
  
  public static final class a
  {
    public a Jfi;
    public Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159306);
      this.mContext = paramContext;
      this.Jfi = new a();
      AppMethodBeat.o(159306);
    }
    
    public final a a(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.Jfi.VX = paramOnDismissListener;
      return this;
    }
    
    public final a a(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
    {
      this.Jfi.Jfa = paramBitmap;
      this.Jfi.GoO = paramBoolean;
      this.Jfi.Gpa = paramInt;
      return this;
    }
    
    public final a a(d paramd)
    {
      this.Jfi.JeZ = paramd;
      return this;
    }
    
    public final a a(String paramString, CharSequence paramCharSequence, Boolean paramBoolean, c paramc, a parama)
    {
      AppMethodBeat.i(159309);
      this.Jfi.Gov = paramString;
      this.Jfi.Gow = paramCharSequence;
      this.Jfi.Gox = paramBoolean.booleanValue();
      this.Jfi.JeW = paramc;
      this.Jfi.JeX = parama;
      AppMethodBeat.o(159309);
      return this;
    }
    
    public final a a(boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.Jfi.GoP = paramOnClickListener;
      this.Jfi.Gpe = paramBoolean;
      return this;
    }
    
    public final a aH(Bitmap paramBitmap)
    {
      this.Jfi.GoD = paramBitmap;
      return this;
    }
    
    public final a aRH(String paramString)
    {
      this.Jfi.title = paramString;
      return this;
    }
    
    public final a aRI(String paramString)
    {
      this.Jfi.GoE = paramString;
      return this;
    }
    
    public final a aRJ(String paramString)
    {
      this.Jfi.GoG = paramString;
      return this;
    }
    
    public final a aRK(String paramString)
    {
      this.Jfi.thumbPath = paramString;
      return this;
    }
    
    public final a aRL(String paramString)
    {
      this.Jfi.Gos = paramString;
      return this;
    }
    
    public final a aRM(String paramString)
    {
      this.Jfi.Got = paramString;
      return this;
    }
    
    public final a aRN(String paramString)
    {
      this.Jfi.JeV = paramString;
      return this;
    }
    
    public final a aRO(String paramString)
    {
      this.Jfi.GoH = paramString;
      return this;
    }
    
    public final a aRP(String paramString)
    {
      this.Jfi.GoI = paramString;
      return this;
    }
    
    public final a acF(int paramInt)
    {
      AppMethodBeat.i(159307);
      this.Jfi.title = this.mContext.getString(paramInt);
      AppMethodBeat.o(159307);
      return this;
    }
    
    public final a acG(int paramInt)
    {
      this.Jfi.Dmh = paramInt;
      return this;
    }
    
    public final a acH(int paramInt)
    {
      this.Jfi.GoW = paramInt;
      return this;
    }
    
    public final a acI(int paramInt)
    {
      this.Jfi.GoZ = paramInt;
      return this;
    }
    
    public final a acJ(int paramInt)
    {
      AppMethodBeat.i(159308);
      this.Jfi.GoE = this.mContext.getString(paramInt);
      AppMethodBeat.o(159308);
      return this;
    }
    
    public final a acK(int paramInt)
    {
      this.Jfi.GoX = paramInt;
      return this;
    }
    
    public final a acL(int paramInt)
    {
      this.Jfi.GoY = paramInt;
      return this;
    }
    
    public final a acM(int paramInt)
    {
      AppMethodBeat.i(159310);
      this.Jfi.GoH = this.mContext.getString(paramInt);
      AppMethodBeat.o(159310);
      return this;
    }
    
    public final a acN(int paramInt)
    {
      AppMethodBeat.i(159311);
      this.Jfi.GoI = this.mContext.getString(paramInt);
      AppMethodBeat.o(159311);
      return this;
    }
    
    public final a acO(int paramInt)
    {
      this.Jfi.Gpd = paramInt;
      return this;
    }
    
    public final a acP(int paramInt)
    {
      this.Jfi.Gpc = paramInt;
      return this;
    }
    
    public final a as(CharSequence paramCharSequence)
    {
      this.Jfi.title = paramCharSequence;
      return this;
    }
    
    public final a at(CharSequence paramCharSequence)
    {
      this.Jfi.Gor = paramCharSequence;
      return this;
    }
    
    public final a au(CharSequence paramCharSequence)
    {
      this.Jfi.GoF = paramCharSequence;
      return this;
    }
    
    public final a b(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.Jfi.GoP = paramOnClickListener;
      return this;
    }
    
    public final a c(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.Jfi.GoQ = paramOnClickListener;
      return this;
    }
    
    public final a c(b paramb)
    {
      this.Jfi.JeY = paramb;
      return this;
    }
    
    public final a e(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.Jfi.VW = paramOnCancelListener;
      return this;
    }
    
    public final d fvp()
    {
      AppMethodBeat.i(159312);
      d locald = new d(this.mContext);
      locald.a(this.Jfi);
      AppMethodBeat.o(159312);
      return locald;
    }
    
    public final a gH(View paramView)
    {
      this.Jfi.tk = paramView;
      return this;
    }
    
    public final a gI(View paramView)
    {
      this.Jfi.GoU = paramView;
      return this;
    }
    
    public final void show()
    {
      AppMethodBeat.i(210314);
      fvp().show();
      AppMethodBeat.o(210314);
    }
    
    public final a yd(boolean paramBoolean)
    {
      this.Jfi.GoN = paramBoolean;
      return this;
    }
    
    public final a ye(boolean paramBoolean)
    {
      this.Jfi.Gou = paramBoolean;
      return this;
    }
    
    public final a yf(boolean paramBoolean)
    {
      this.Jfi.mz = paramBoolean;
      return this;
    }
    
    public final a yg(boolean paramBoolean)
    {
      this.Jfi.GoM = paramBoolean;
      return this;
    }
    
    public static abstract interface a
    {
      public abstract void y(ImageView paramImageView, String paramString);
    }
    
    public static abstract interface b
    {
      public abstract void crN();
    }
    
    public static abstract interface c
    {
      public abstract void eNA();
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