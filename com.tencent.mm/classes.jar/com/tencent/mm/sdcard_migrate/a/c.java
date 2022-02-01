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
  private Button CQI;
  private LinearLayout IaU;
  private TextView IaV;
  public TextView IaW;
  private TextView IaX;
  private TextView IaY;
  private TextView IaZ;
  private ImageView Iba;
  private View Ibb;
  private LinearLayout Ibc;
  private ViewStub Ibd;
  public LinearLayout Ibe;
  private ViewGroup Ibf;
  private LinearLayout Ibg;
  private ViewGroup Ibh;
  private View Ibi;
  private boolean Ibj;
  private Animation Ibk;
  private Animation Ibl;
  private Animation Ibm;
  private Animation Ibn;
  public c.a.c Ibo;
  private DialogInterface.OnDismissListener Ibp;
  public TextView OeD;
  private View ahw;
  com.tencent.mm.ui.widget.a.c iOnDialogDismissListener;
  private Context mContext;
  private EditText mEditText;
  private TextView mZo;
  private boolean needEdit;
  private boolean ov;
  private Button rka;
  
  public c(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(211127);
    this.Ibj = false;
    this.needEdit = false;
    this.mContext = paramContext;
    this.IaU = ((LinearLayout)View.inflate(this.mContext, 2131494766, null));
    this.CQI = ((Button)this.IaU.findViewById(2131302314));
    this.rka = ((Button)this.IaU.findViewById(2131302301));
    this.mZo = ((TextView)this.IaU.findViewById(2131302315));
    this.IaV = ((TextView)this.IaU.findViewById(2131302317));
    this.IaW = ((TextView)this.IaU.findViewById(2131302307));
    this.OeD = ((TextView)this.IaU.findViewById(2131307292));
    this.IaX = ((TextView)this.IaU.findViewById(2131302312));
    this.IaY = ((TextView)this.IaU.findViewById(2131302311));
    this.IaZ = ((TextView)this.IaU.findViewById(2131298564));
    this.mEditText = ((EditText)this.IaU.findViewById(2131298569));
    this.Iba = ((ImageView)this.IaU.findViewById(2131302310));
    this.Ibc = ((LinearLayout)this.IaU.findViewById(2131302316));
    this.Ibd = ((ViewStub)this.IaU.findViewById(2131305933));
    this.Ibe = ((LinearLayout)this.IaU.findViewById(2131302308));
    this.Ibf = ((ViewGroup)this.IaU.findViewById(2131302295));
    this.Ibi = this.IaU.findViewById(2131302300);
    this.Ibg = ((LinearLayout)this.IaU.findViewById(2131302303));
    this.Ibh = ((ViewGroup)this.IaU.findViewById(2131305932));
    setCanceledOnTouchOutside(true);
    this.Ibk = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.Ibl = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.Ibm = AnimationUtils.loadAnimation(this.mContext, 2130771982);
    this.Ibn = AnimationUtils.loadAnimation(this.mContext, 2130771982);
    AppMethodBeat.o(211127);
  }
  
  private void a(CharSequence paramCharSequence, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(211139);
    if (this.rka != null)
    {
      this.rka.setVisibility(0);
      this.rka.setText(paramCharSequence);
      this.rka.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(211119);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (paramOnClickListener != null) {
            paramOnClickListener.onClick(c.this, -2);
          }
          if (this.Iby) {
            c.this.cancel();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(211119);
        }
      });
    }
    AppMethodBeat.o(211139);
  }
  
  private void a(CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(211136);
    if (this.CQI == null)
    {
      AppMethodBeat.o(211136);
      return;
    }
    this.CQI.setVisibility(0);
    this.CQI.setText(paramCharSequence);
    this.CQI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(211118);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(c.this, -1);
        }
        if (paramBoolean) {
          c.this.dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(211118);
      }
    });
    AppMethodBeat.o(211136);
  }
  
  private void aao(int paramInt)
  {
    AppMethodBeat.i(211131);
    if (this.IaW != null) {
      this.IaW.setTextColor(paramInt);
    }
    AppMethodBeat.o(211131);
  }
  
  private void aap(int paramInt)
  {
    AppMethodBeat.i(211134);
    if (this.Ibe != null) {
      this.Ibe.setVisibility(paramInt);
    }
    if (this.Ibg != null) {
      this.Ibg.setVisibility(paramInt);
    }
    if ((this.IaZ != null) && (this.Ibj)) {
      this.IaZ.setVisibility(paramInt);
    }
    if (this.mEditText != null)
    {
      if (!this.needEdit)
      {
        this.mEditText.setVisibility(8);
        AppMethodBeat.o(211134);
        return;
      }
      this.mEditText.setVisibility(paramInt);
    }
    AppMethodBeat.o(211134);
  }
  
  private void aaq(int paramInt)
  {
    AppMethodBeat.i(211137);
    this.CQI.setTextColor(paramInt);
    AppMethodBeat.o(211137);
  }
  
  private void aar(int paramInt)
  {
    AppMethodBeat.i(211138);
    this.rka.setTextColor(paramInt);
    AppMethodBeat.o(211138);
  }
  
  private void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(211141);
    this.Ibi.setVisibility(8);
    this.Ibf.removeAllViews();
    this.Ibf.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(211141);
  }
  
  private void fY(View paramView)
  {
    AppMethodBeat.i(211135);
    this.ahw = paramView;
    if (this.ahw != null)
    {
      this.Ibe.setVisibility(0);
      this.Ibg.setVisibility(0);
      this.Ibg.removeAllViews();
      this.Ibg.setGravity(1);
      this.Ibg.addView(this.ahw, new LinearLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(211135);
  }
  
  private void wz(boolean paramBoolean)
  {
    AppMethodBeat.i(211133);
    if (paramBoolean)
    {
      int i = aq.fromDPToPix(this.mContext, 8);
      this.Ibe.setVisibility(0);
      this.Ibe.setPadding(i, i, i, i);
      this.Ibe.setBackgroundResource(2131231925);
    }
    AppMethodBeat.o(211133);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(211142);
    int i;
    if ((parama.title != null) && (parama.title.length() > 0))
    {
      i = parama.IaM;
      if (this.mZo != null) {
        this.mZo.setGravity(i);
      }
      setTitle(parama.title);
    }
    Object localObject4;
    Object localObject1;
    if ((parama.Iae != null) && (parama.Iae.length() > 0))
    {
      localObject4 = parama.Iae;
      this.Ibc.setVisibility(0);
      this.IaV.setVisibility(0);
      localObject1 = localObject4;
      if (this.Ibo != null)
      {
        localObject1 = this.Ibo;
        ((CharSequence)localObject4).toString();
        this.mZo.getTextSize();
        localObject1 = ((c.a.c)localObject1).fjI();
      }
      this.IaV.setText((CharSequence)localObject1);
    }
    if (parama.ERj != 0)
    {
      i = parama.ERj;
      this.mZo.setTextColor(ColorStateList.valueOf(i));
    }
    if (parama.IaJ != 0)
    {
      i = parama.IaJ;
      this.mZo.setMaxLines(i);
    }
    if (parama.IaK != 0)
    {
      i = parama.IaK;
      this.IaW.setMaxLines(i);
    }
    if (parama.vd != null) {
      fY(parama.vd);
    }
    if (parama.IaH != null)
    {
      localObject4 = parama.IaH;
      this.Ibc.setVisibility(0);
      this.Ibd.setLayoutResource(2131493580);
    }
    try
    {
      localObject1 = (LinearLayout)this.Ibd.inflate();
      ((LinearLayout)localObject1).addView((View)localObject4);
      if (parama.IaI != null)
      {
        this.Ibb = parama.IaI;
        if (this.Ibb != null)
        {
          this.Ibe.setVisibility(8);
          this.IaZ.setVisibility(8);
          this.mEditText.setVisibility(8);
          this.Ibh.removeAllViews();
          this.Ibh.addView(this.Ibb, new LinearLayout.LayoutParams(-1, -1));
          this.Ibh.setVisibility(8);
        }
      }
      if (parama.Iap != null)
      {
        localObject1 = parama.Iap;
        if (this.ahw == null)
        {
          this.Ibe.setVisibility(0);
          this.Iba.setVisibility(0);
          this.Iba.setBackgroundDrawable((Drawable)localObject1);
        }
      }
      if ((parama.Iar != null) && (parama.Iar.length() > 0)) {
        setMessage(parama.Iar);
      }
      wz(parama.IaA);
      if (parama.thumbPath != null)
      {
        localObject1 = parama.thumbPath;
        i = aq.fromDPToPix(this.mContext, 120);
        this.Ibe.setVisibility(0);
        this.Iba.setVisibility(0);
        if ((this.Iba instanceof com.tencent.mm.ui.f.a)) {
          ((com.tencent.mm.ui.f.a)this.Iba).aI((String)localObject1, i, i);
        }
        i = parama.IaO;
        this.Ibe.setVisibility(i);
        this.Iba.setVisibility(i);
      }
      if ((!parama.IaS) && (!parama.IaT))
      {
        if ((parama.Iar != null) && (parama.Iar.length() > 0)) {
          setMessage(parama.Iar);
        }
        if ((parama.Ias == null) || (parama.Ias.length() <= 0)) {
          break label1950;
        }
        localObject1 = parama.Ias;
        this.Ibe.setVisibility(0);
        this.IaX.setVisibility(0);
        this.IaX.setMaxLines(2);
        this.IaX.setText((CharSequence)localObject1);
        if ((parama.Iat != null) && (parama.Iat.length() > 0))
        {
          localObject4 = parama.Iat;
          if (localObject4 != null)
          {
            this.Ibe.setVisibility(0);
            this.IaY.setVisibility(0);
            localObject1 = localObject4;
            if (this.Ibo != null)
            {
              localObject1 = this.Ibo;
              this.IaY.getContext();
              ((CharSequence)localObject4).toString();
              this.IaY.getTextSize();
              localObject1 = ((c.a.c)localObject1).fjI();
            }
            this.IaY.setText((CharSequence)localObject1);
          }
        }
        if (parama.Iaq != null)
        {
          localObject1 = parama.Iaq;
          if (this.ahw == null)
          {
            this.Ibe.setVisibility(0);
            this.Iba.setVisibility(0);
            this.Iba.setImageBitmap((Bitmap)localObject1);
          }
        }
      }
      if (parama.IaS)
      {
        localObject1 = parama.Iaq;
        localObject5 = parama.Ias;
        localObject4 = parama.Iat;
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
          if (this.Ibo != null)
          {
            localObject1 = this.Ibo;
            ((CharSequence)localObject5).toString();
            ((TextView)localObject7).getTextSize();
            localObject1 = ((c.a.c)localObject1).fjI();
          }
          ((TextView)localObject7).setText((CharSequence)localObject1);
        }
        if (localObject4 != null)
        {
          localObject5 = (TextView)((View)localObject6).findViewById(2131302311);
          ((TextView)localObject5).setVisibility(0);
          if (this.Ibo == null) {
            break label2233;
          }
          localObject1 = this.Ibo;
          ((CharSequence)localObject4).toString();
          ((TextView)localObject5).getTextSize();
          localObject1 = ((c.a.c)localObject1).fjI();
          ((TextView)localObject5).setText((CharSequence)localObject1);
        }
        fY((View)localObject6);
        if ((parama.Iai != null) || (parama.Iaj != null))
        {
          localObject4 = parama.Iai;
          localObject5 = parama.Iaj;
          bool = parama.Iak;
          localObject6 = parama.Iam;
          this.Ibd.setLayoutResource(2131493593);
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
          localObject1 = (LinearLayout)this.Ibd.inflate();
          if ((localObject1 != null) && (localObject4 != null)) {
            ((ImageView)((LinearLayout)localObject1).findViewById(2131305922)).setVisibility(0);
          }
          if ((localObject1 != null) && (localObject5 != null))
          {
            localObject7 = (TextView)((LinearLayout)localObject1).findViewById(2131305945);
            ((TextView)localObject7).setVisibility(0);
            localObject4 = localObject5;
            if (this.Ibo != null)
            {
              localObject4 = this.Ibo;
              ((CharSequence)localObject5).toString();
              this.mZo.getTextSize();
              localObject4 = ((c.a.c)localObject4).fjI();
            }
            ((TextView)localObject7).setText((CharSequence)localObject4);
          }
          if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
          {
            localObject4 = (ImageView)((LinearLayout)localObject1).findViewById(2131300962);
            ((ImageView)localObject4).setVisibility(0);
            aap(0);
            ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(211115);
                b localb = new b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                if (this.Ibr.isSelected())
                {
                  c.b(c.this).startAnimation(c.a(c.this));
                  c.a(c.this).setAnimationListener(new Animation.AnimationListener()
                  {
                    public final void onAnimationEnd(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(211112);
                      c.b(c.this).setVisibility(8);
                      c.a(c.this, 0);
                      AppMethodBeat.o(211112);
                    }
                    
                    public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                    
                    public final void onAnimationStart(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(211111);
                      c.a(c.this, c.c(c.this));
                      AppMethodBeat.o(211111);
                    }
                  });
                  ObjectAnimator.ofFloat(this.Ibr, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
                  this.Ibr.setSelected(false);
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(211115);
                  return;
                  c.b(c.this).startAnimation(c.d(c.this));
                  c.d(c.this).setAnimationListener(new Animation.AnimationListener()
                  {
                    public final void onAnimationEnd(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(211114);
                      c.b(c.this).setVisibility(0);
                      c.a(c.this, 8);
                      AppMethodBeat.o(211114);
                    }
                    
                    public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                    
                    public final void onAnimationStart(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(211113);
                      c.a(c.this, c.e(c.this));
                      AppMethodBeat.o(211113);
                    }
                  });
                  ObjectAnimator.ofFloat(this.Ibr, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
                  this.Ibr.setSelected(true);
                }
              }
            });
          }
          if (parama.Ian != null)
          {
            localObject1 = parama.Ian;
            if ((this.Ibe != null) && (this.Ibe.getVisibility() == 0)) {
              this.Ibe.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(211116);
                  b localb = new b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(211116);
                }
              });
            }
          }
          else
          {
            if ((parama.Iaf != null) && (parama.Iaf.length() > 0))
            {
              localObject1 = parama.Iaf;
              if (localObject1 != null)
              {
                this.IaZ.setVisibility(0);
                this.IaZ.setText((CharSequence)localObject1);
              }
              this.Ibj = true;
              i = parama.IaL;
              if (this.IaZ != null) {
                this.IaZ.setGravity(i);
              }
            }
            if ((parama.Iag != null) && (parama.Iag.length() > 0))
            {
              localObject1 = parama.Iag;
              this.mEditText.setVisibility(0);
              this.mEditText.setHint((CharSequence)localObject1);
            }
            if (parama.Iah)
            {
              this.needEdit = parama.Iah;
              if (!parama.Iah) {
                continue;
              }
              this.mEditText.setVisibility(0);
            }
            if ((parama.Iau != null) && (parama.Iau.length() > 0)) {
              a(parama.Iau, parama.IaR, parama.IaC);
            }
            if ((parama.Iav != null) && (parama.Iav.length() > 0)) {
              a(parama.Iav, parama.IaD);
            }
            if (parama.IaQ != 0) {
              aaq(parama.IaQ);
            }
            if (parama.IaP != 0) {
              aar(parama.IaP);
            }
            if (parama.XL != null) {
              setOnCancelListener(parama.XL);
            }
            if (parama.XM != null)
            {
              this.Ibp = parama.XM;
              setOnDismissListener(parama.XM);
            }
            if (parama.Iao != null) {
              this.Ibo = parama.Iao;
            }
            setCancelable(parama.ov);
            this.ov = parama.ov;
            if (!this.ov) {
              super.setCancelable(parama.Iaz);
            }
            if ((parama.Iaw != null) || (parama.Iax != null) || (parama.Iay != null))
            {
              localObject1 = View.inflate(this.mContext, 2131493592, null);
              localObject4 = (Button)((View)localObject1).findViewById(2131302297);
              localObject5 = (Button)((View)localObject1).findViewById(2131302298);
              localObject6 = (Button)((View)localObject1).findViewById(2131302299);
              if (parama.Iaw != null)
              {
                ((Button)localObject4).setVisibility(0);
                ((Button)localObject4).setText(parama.Iaw);
                ((Button)localObject4).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(211120);
                    b localb = new b();
                    localb.bd(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                    if (parama.IaE != null) {
                      parama.IaE.onClick(c.this, -1);
                    }
                    c.this.dismiss();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(211120);
                  }
                });
              }
              if (parama.Iax != null)
              {
                ((Button)localObject5).setVisibility(0);
                ((Button)localObject5).setText(parama.Iax);
                ((Button)localObject5).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(211121);
                    b localb = new b();
                    localb.bd(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                    if (parama.IaF != null) {
                      parama.IaF.onClick(c.this, -2);
                    }
                    c.this.dismiss();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(211121);
                  }
                });
              }
              if (parama.Iay != null)
              {
                ((Button)localObject6).setVisibility(0);
                ((Button)localObject6).setText(parama.Iay);
                ((Button)localObject6).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(211122);
                    b localb = new b();
                    localb.bd(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                    if (parama.IaG != null) {
                      parama.IaG.onClick(c.this, -3);
                    }
                    c.this.dismiss();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(211122);
                  }
                });
              }
              b((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
            }
            if (parama.Ial)
            {
              localObject1 = View.inflate(this.mContext, 2131493579, null);
              this.rka = ((Button)((View)localObject1).findViewById(2131302301));
              this.CQI = ((Button)((View)localObject1).findViewById(2131302314));
              if (parama.IaQ != 0) {
                aaq(parama.IaQ);
              }
              if (parama.IaP != 0) {
                aar(parama.IaP);
              }
              if ((parama.Iau != null) && (parama.Iau.length() > 0)) {
                a(parama.Iau, parama.IaR, parama.IaC);
              }
              if ((parama.Iav != null) && (parama.Iav.length() > 0)) {
                a(parama.Iav, parama.IaD);
              }
              b((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
            }
            AppMethodBeat.o(211142);
            return;
            localException1 = localException1;
            this.Ibd.setVisibility(0);
            Object localObject2 = null;
            continue;
            label1950:
            wz(false);
            continue;
            if (!parama.IaT) {
              continue;
            }
            localObject2 = parama.Iaq;
            localObject5 = parama.Ias;
            localObject4 = parama.Iat;
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
              if (this.Ibo != null)
              {
                localObject2 = this.Ibo;
                ((CharSequence)localObject5).toString();
                ((TextView)localObject7).getTextSize();
                localObject2 = ((c.a.c)localObject2).fjI();
              }
              ((TextView)localObject7).setText((CharSequence)localObject2);
            }
            if (localObject4 != null)
            {
              localObject5 = (TextView)((View)localObject6).findViewById(2131302311);
              ((TextView)localObject5).setVisibility(0);
              if (this.Ibo == null) {
                continue;
              }
              localObject2 = this.Ibo;
              ((CharSequence)localObject4).toString();
              ((TextView)localObject5).getTextSize();
              localObject2 = ((c.a.c)localObject2).fjI();
              ((TextView)localObject5).setText((CharSequence)localObject2);
            }
            fY((View)localObject6);
          }
        }
        catch (Exception localException2)
        {
          this.Ibd.setVisibility(0);
          localObject3 = null;
          continue;
          if (this.Ibg == null) {
            continue;
          }
          this.Ibg.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(211117);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(211117);
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
    AppMethodBeat.i(211144);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211123);
          c.this.dismiss();
          AppMethodBeat.o(211123);
        }
      });
      ap.e("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
      AppMethodBeat.o(211144);
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
        AppMethodBeat.o(211144);
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
    AppMethodBeat.i(211128);
    super.onCreate(paramBundle);
    setContentView(this.IaU);
    AppMethodBeat.o(211128);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(211140);
    super.setCancelable(paramBoolean);
    this.ov = paramBoolean;
    setCanceledOnTouchOutside(this.ov);
    AppMethodBeat.o(211140);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(211132);
    this.Ibe.setVisibility(0);
    this.IaW.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.Ibo != null)
    {
      localObject = this.Ibo;
      this.IaW.getContext();
      paramCharSequence.toString();
      this.IaW.getTextSize();
      localObject = ((c.a.c)localObject).fjI();
    }
    this.IaW.setText((CharSequence)localObject);
    AppMethodBeat.o(211132);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(211130);
    this.Ibc.setVisibility(0);
    this.mZo.setVisibility(0);
    this.mZo.setMaxLines(2);
    this.mZo.setText(paramInt);
    this.mZo.getPaint().setFakeBoldText(true);
    aao(this.mContext.getResources().getColor(2131099734));
    AppMethodBeat.o(211130);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(211129);
    this.Ibc.setVisibility(0);
    this.mZo.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.Ibo != null)
    {
      localObject = this.Ibo;
      paramCharSequence.toString();
      this.mZo.getTextSize();
      localObject = ((c.a.c)localObject).fjI();
    }
    this.mZo.setMaxLines(2);
    this.mZo.setText((CharSequence)localObject);
    this.mZo.getPaint().setFakeBoldText(true);
    aao(this.mContext.getResources().getColor(2131099734));
    AppMethodBeat.o(211129);
  }
  
  public final void show()
  {
    AppMethodBeat.i(211143);
    try
    {
      super.show();
      AppMethodBeat.o(211143);
      return;
    }
    catch (Exception localException)
    {
      ap.printErrStackTrace("MicroMsg.MMAlertDialog", localException, "", new Object[0]);
      AppMethodBeat.o(211143);
    }
  }
  
  public static final class a
  {
    private a IbA;
    private Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(211124);
      this.mContext = paramContext;
      this.IbA = new a();
      AppMethodBeat.o(211124);
    }
    
    public final a a(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.IbA.IaC = paramOnClickListener;
      return this;
    }
    
    public final a aPS(String paramString)
    {
      this.IbA.title = paramString;
      return this;
    }
    
    public final a aPT(String paramString)
    {
      this.IbA.Iar = paramString;
      return this;
    }
    
    public final a aPU(String paramString)
    {
      this.IbA.Iau = paramString;
      return this;
    }
    
    public final a aPV(String paramString)
    {
      this.IbA.Iav = paramString;
      return this;
    }
    
    public final a b(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.IbA.IaD = paramOnClickListener;
      return this;
    }
    
    public final a fjF()
    {
      AppMethodBeat.i(211125);
      this.IbA.Iau = this.mContext.getString(2131755835);
      AppMethodBeat.o(211125);
      return this;
    }
    
    public final a fjG()
    {
      this.IbA.ov = false;
      return this;
    }
    
    public final c fjH()
    {
      AppMethodBeat.i(211126);
      c localc = new c(this.mContext);
      localc.a(this.IbA);
      AppMethodBeat.o(211126);
      return localc;
    }
    
    public static abstract interface a {}
    
    public static abstract interface b {}
    
    public static abstract interface c
    {
      public abstract CharSequence fjI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a.c
 * JD-Core Version:    0.7.0.1
 */