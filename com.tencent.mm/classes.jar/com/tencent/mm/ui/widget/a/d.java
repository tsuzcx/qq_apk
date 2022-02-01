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
  public DialogInterface.OnDismissListener Ibp;
  private d.a.d KWl;
  CheckBox afH;
  private View ahw;
  public c iOnDialogDismissListener;
  private Context mContext;
  private EditText mEditText;
  private TextView mZo;
  private boolean needEdit;
  private boolean ov;
  private Button rka;
  
  public d(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(159314);
    this.Ibj = false;
    this.needEdit = false;
    this.mContext = paramContext;
    fLX();
    AppMethodBeat.o(159314);
  }
  
  public d(Context paramContext, byte paramByte)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(192586);
    this.Ibj = false;
    this.needEdit = false;
    this.mContext = paramContext;
    fLX();
    AppMethodBeat.o(192586);
  }
  
  private void aJ(View paramView, int paramInt)
  {
    AppMethodBeat.i(159325);
    this.ahw = paramView;
    if (this.ahw != null)
    {
      this.Ibe.setVisibility(0);
      this.Ibg.setVisibility(0);
      this.Ibg.removeAllViews();
      this.Ibg.setGravity(1);
      this.Ibg.addView(this.ahw, new LinearLayout.LayoutParams(paramInt, paramInt));
    }
    AppMethodBeat.o(159325);
  }
  
  private void aao(int paramInt)
  {
    AppMethodBeat.i(159318);
    if (this.IaW != null) {
      this.IaW.setTextColor(paramInt);
    }
    AppMethodBeat.o(159318);
  }
  
  private void aap(int paramInt)
  {
    AppMethodBeat.i(159324);
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
    this.Ibi.setVisibility(8);
    this.Ibf.removeAllViews();
    this.Ibf.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(159334);
  }
  
  private void fLX()
  {
    AppMethodBeat.i(192587);
    this.IaU = ((LinearLayout)View.inflate(this.mContext, 2131494764, null));
    this.CQI = ((Button)this.IaU.findViewById(2131302314));
    this.rka = ((Button)this.IaU.findViewById(2131302301));
    this.mZo = ((TextView)this.IaU.findViewById(2131302315));
    this.IaV = ((TextView)this.IaU.findViewById(2131302317));
    this.IaW = ((TextView)this.IaU.findViewById(2131302307));
    this.IaX = ((TextView)this.IaU.findViewById(2131302312));
    this.IaY = ((TextView)this.IaU.findViewById(2131302311));
    this.IaZ = ((TextView)this.IaU.findViewById(2131298564));
    this.mEditText = ((EditText)this.IaU.findViewById(2131298569));
    this.afH = ((CheckBox)this.IaU.findViewById(2131298561));
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
    AppMethodBeat.o(192587);
  }
  
  private void wz(boolean paramBoolean)
  {
    AppMethodBeat.i(159320);
    if (paramBoolean)
    {
      int i = aq.fromDPToPix(this.mContext, 8);
      this.Ibe.setVisibility(0);
      this.Ibe.setPadding(i, i, i, i);
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
      afc(parama.IaM);
      setTitle(parama.title);
    }
    Object localObject3;
    Object localObject1;
    if ((parama.Iae != null) && (parama.Iae.length() > 0))
    {
      localObject3 = parama.Iae;
      this.Ibc.setVisibility(0);
      this.IaV.setVisibility(0);
      localObject1 = localObject3;
      if (this.KWl != null) {
        localObject1 = this.KWl.a(((CharSequence)localObject3).toString(), this.mZo.getTextSize());
      }
      this.IaV.setText((CharSequence)localObject1);
    }
    int i;
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
      aJ(parama.vd, -1);
    }
    if (parama.IaH != null)
    {
      localObject3 = parama.IaH;
      this.Ibc.setVisibility(0);
      this.Ibd.setLayoutResource(2131493580);
    }
    try
    {
      localObject1 = (LinearLayout)this.Ibd.inflate();
      ((LinearLayout)localObject1).addView((View)localObject3);
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
          break label2254;
        }
        localObject1 = parama.Ias;
        this.Ibe.setVisibility(0);
        this.IaX.setVisibility(0);
        this.IaX.setMaxLines(2);
        this.IaX.setText((CharSequence)localObject1);
        if ((parama.Iat != null) && (parama.Iat.length() > 0))
        {
          localObject3 = parama.Iat;
          if (localObject3 != null)
          {
            this.Ibe.setVisibility(0);
            this.IaY.setVisibility(0);
            localObject1 = localObject3;
            if (this.KWl != null)
            {
              localObject1 = this.KWl;
              this.IaY.getContext();
              localObject1 = ((d.a.d)localObject1).a(((CharSequence)localObject3).toString(), this.IaY.getTextSize());
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
      boolean bool;
      d.a.a locala;
      if (parama.IaS)
      {
        localObject1 = parama.Iaq;
        localObject4 = parama.Ias;
        localObject3 = parama.Iat;
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
          if (this.KWl != null) {
            localObject1 = this.KWl.a(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
          }
          ((TextView)localObject6).setText((CharSequence)localObject1);
        }
        if (localObject3 != null)
        {
          localObject4 = (TextView)((View)localObject5).findViewById(2131302311);
          ((TextView)localObject4).setVisibility(0);
          if (this.KWl == null) {
            break label2638;
          }
          localObject1 = this.KWl.a(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
          ((TextView)localObject4).setText((CharSequence)localObject1);
        }
        aJ((View)localObject5, -1);
        if ((parama.Iai != null) || (parama.Iaj != null))
        {
          localObject6 = parama.Iai;
          localObject4 = parama.Iaj;
          bool = parama.Iak;
          localObject5 = parama.KWf;
          locala = parama.KWg;
          this.Ibd.setLayoutResource(2131493593);
          localObject1 = null;
        }
      }
      try
      {
        localObject3 = (LinearLayout)this.Ibd.inflate();
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
          this.Ibd.setVisibility(0);
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
        if (this.KWl != null) {
          localObject3 = this.KWl.a(((CharSequence)localObject4).toString(), this.mZo.getTextSize());
        }
        ((TextView)localObject6).setText((CharSequence)localObject3);
      }
      if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
      {
        localObject3 = (ImageView)((LinearLayout)localObject1).findViewById(2131300962);
        ((ImageView)localObject3).setVisibility(0);
        aap(0);
        ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(159297);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (this.KWm != null) {
              this.KWm.fcz();
            }
            if (this.Ibr.isSelected())
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
              ObjectAnimator.ofFloat(this.Ibr, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
              this.Ibr.setSelected(false);
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
              ObjectAnimator.ofFloat(this.Ibr, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
              this.Ibr.setSelected(true);
            }
          }
        });
      }
      if (parama.KWh != null) {
        b(parama.KWh);
      }
      if ((parama.KWj != null) && (!parama.KWj.isRecycled()))
      {
        localObject3 = parama.KWj;
        bool = parama.IaB;
        i2 = parama.IaN;
        if (localObject3 != null)
        {
          wz(false);
          this.Ibe.setVisibility(0);
          this.Ibe.setGravity(1);
          this.Ibe.setPadding(0, 0, 0, 0);
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
      if ((parama.Iaf != null) && (parama.Iaf.length() > 0))
      {
        localObject1 = parama.Iaf;
        if (localObject1 != null)
        {
          this.IaZ.setVisibility(0);
          this.IaZ.setText((CharSequence)localObject1);
        }
        this.Ibj = true;
        afd(parama.IaL);
      }
      if ((parama.Iag != null) && (parama.Iag.length() > 0))
      {
        localObject1 = parama.Iag;
        this.mEditText.setVisibility(0);
        this.mEditText.setHint((CharSequence)localObject1);
      }
      if ((parama.KWe != null) && (parama.KWe.length() > 0))
      {
        localObject1 = parama.KWe;
        this.afH.setVisibility(0);
        this.afH.setText((CharSequence)localObject1);
      }
      if (parama.Iah)
      {
        this.needEdit = parama.Iah;
        if (parama.Iah) {
          this.mEditText.setVisibility(0);
        }
      }
      else
      {
        if ((parama.Iau != null) && (parama.Iau.length() > 0)) {
          a(parama.Iau, parama.IaR, parama.IaC);
        }
        if ((parama.Iav != null) && (parama.Iav.length() > 0)) {
          b(parama.Iav, true, parama.IaD);
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
        if (parama.KWi != null) {
          this.KWl = parama.KWi;
        }
        setCancelable(parama.ov);
        this.ov = parama.ov;
        if (!this.ov) {
          super.setCancelable(parama.Iaz);
        }
        if ((parama.Iaw != null) || (parama.Iax != null) || (parama.Iay != null))
        {
          localObject1 = View.inflate(this.mContext, 2131493592, null);
          localObject3 = (Button)((View)localObject1).findViewById(2131302297);
          localObject4 = (Button)((View)localObject1).findViewById(2131302298);
          localObject5 = (Button)((View)localObject1).findViewById(2131302299);
          if (parama.Iaw != null)
          {
            ((Button)localObject3).setVisibility(0);
            ((Button)localObject3).setText(parama.Iaw);
            ((Button)localObject3).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159302);
                b localb = new b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                if (parama.IaE != null) {
                  parama.IaE.onClick(d.this, -1);
                }
                d.this.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159302);
              }
            });
          }
          if (parama.Iax != null)
          {
            ((Button)localObject4).setVisibility(0);
            ((Button)localObject4).setText(parama.Iax);
            ((Button)localObject4).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159303);
                b localb = new b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                if (parama.IaF != null) {
                  parama.IaF.onClick(d.this, -2);
                }
                d.this.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159303);
              }
            });
          }
          if (parama.Iay != null)
          {
            ((Button)localObject5).setVisibility(0);
            ((Button)localObject5).setText(parama.Iay);
            ((Button)localObject5).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159304);
                b localb = new b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                if (parama.IaG != null) {
                  parama.IaG.onClick(d.this, -3);
                }
                d.this.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159304);
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
            b(parama.Iav, true, parama.IaD);
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
        this.Ibd.setVisibility(0);
        Object localObject2 = null;
        continue;
        label2254:
        wz(false);
        continue;
        label2572:
        if (parama.IaT)
        {
          localObject2 = parama.Iaq;
          localObject4 = parama.Ias;
          localObject3 = parama.Iat;
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
            if (this.KWl != null) {
              localObject2 = this.KWl.a(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
            }
            ((TextView)localObject6).setText((CharSequence)localObject2);
          }
          if (localObject3 != null)
          {
            localObject4 = (TextView)((View)localObject5).findViewById(2131302311);
            ((TextView)localObject4).setVisibility(0);
            if (this.KWl != null)
            {
              localObject2 = this.KWl.a(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
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
    if (this.CQI == null)
    {
      AppMethodBeat.o(159326);
      return;
    }
    this.CQI.setVisibility(0);
    this.CQI.setText(paramCharSequence);
    this.CQI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159300);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
  
  public final void aaq(int paramInt)
  {
    AppMethodBeat.i(159327);
    this.CQI.setTextColor(paramInt);
    AppMethodBeat.o(159327);
  }
  
  public final void aar(int paramInt)
  {
    AppMethodBeat.i(159328);
    this.rka.setTextColor(paramInt);
    AppMethodBeat.o(159328);
  }
  
  public final void afc(int paramInt)
  {
    AppMethodBeat.i(192588);
    if (this.mZo != null) {
      this.mZo.setGravity(paramInt);
    }
    AppMethodBeat.o(192588);
  }
  
  public final void afd(int paramInt)
  {
    AppMethodBeat.i(192589);
    if (this.IaZ != null) {
      this.IaZ.setGravity(paramInt);
    }
    AppMethodBeat.o(192589);
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
    if ((this.Ibe != null) && (this.Ibe.getVisibility() == 0))
    {
      this.Ibe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159298);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (paramb != null) {
            paramb.cxz();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159298);
        }
      });
      AppMethodBeat.o(159323);
      return;
    }
    if (this.Ibg != null) {
      this.Ibg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159299);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (paramb != null) {
            paramb.cxz();
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
    if (this.rka == null)
    {
      AppMethodBeat.o(159330);
      return;
    }
    this.rka.setVisibility(0);
    this.rka.setText(paramCharSequence);
    this.rka.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159301);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMAlertDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
  
  public final void bl(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(192590);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(192590);
      return;
      if (paramBoolean)
      {
        this.CQI.setVisibility(0);
        AppMethodBeat.o(192590);
        return;
      }
      this.CQI.setVisibility(8);
      AppMethodBeat.o(192590);
      return;
      if (paramBoolean)
      {
        this.rka.setVisibility(0);
        AppMethodBeat.o(192590);
        return;
      }
      this.rka.setVisibility(8);
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
  
  public final String fLY()
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
  
  public final int fLZ()
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
  
  public final ImageView fMa()
  {
    return this.Iba;
  }
  
  public final Button getButton(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case -1: 
      return this.CQI;
    }
    return this.rka;
  }
  
  public View getContentView()
  {
    return this.IaU;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(159315);
    super.onCreate(paramBundle);
    setContentView(this.IaU);
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
    this.Ibe.setVisibility(0);
    this.IaW.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.KWl != null)
    {
      localObject = this.KWl;
      this.IaW.getContext();
      localObject = ((d.a.d)localObject).a(paramCharSequence.toString(), this.IaW.getTextSize());
    }
    this.IaW.setText((CharSequence)localObject);
    AppMethodBeat.o(159319);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(159317);
    this.Ibc.setVisibility(0);
    this.mZo.setVisibility(0);
    this.mZo.setMaxLines(2);
    this.mZo.setText(paramInt);
    this.mZo.getPaint().setFakeBoldText(true);
    aao(this.mContext.getResources().getColor(2131099734));
    AppMethodBeat.o(159317);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159316);
    this.Ibc.setVisibility(0);
    this.mZo.setVisibility(0);
    CharSequence localCharSequence = paramCharSequence;
    if (this.KWl != null) {
      localCharSequence = this.KWl.a(paramCharSequence.toString(), this.mZo.getTextSize());
    }
    this.mZo.setMaxLines(2);
    this.mZo.setText(localCharSequence);
    this.mZo.getPaint().setFakeBoldText(true);
    aao(this.mContext.getResources().getColor(2131099734));
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
  
  public final void yO(boolean paramBoolean)
  {
    AppMethodBeat.i(159333);
    super.setCancelable(paramBoolean);
    AppMethodBeat.o(159333);
  }
  
  public static final class a
  {
    public a KWr;
    public Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159306);
      this.mContext = paramContext;
      this.KWr = new a();
      AppMethodBeat.o(159306);
    }
    
    public final a a(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.KWr.XM = paramOnDismissListener;
      return this;
    }
    
    public final a a(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
    {
      this.KWr.KWj = paramBitmap;
      this.KWr.IaB = paramBoolean;
      this.KWr.IaN = paramInt;
      return this;
    }
    
    public final a a(d paramd)
    {
      this.KWr.KWi = paramd;
      return this;
    }
    
    public final a a(String paramString, CharSequence paramCharSequence, Boolean paramBoolean, c paramc, a parama)
    {
      AppMethodBeat.i(159309);
      this.KWr.Iai = paramString;
      this.KWr.Iaj = paramCharSequence;
      this.KWr.Iak = paramBoolean.booleanValue();
      this.KWr.KWf = paramc;
      this.KWr.KWg = parama;
      AppMethodBeat.o(159309);
      return this;
    }
    
    public final a a(boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.KWr.IaC = paramOnClickListener;
      this.KWr.IaR = paramBoolean;
      return this;
    }
    
    public final a aJ(Bitmap paramBitmap)
    {
      this.KWr.Iaq = paramBitmap;
      return this;
    }
    
    public final a aXF(String paramString)
    {
      this.KWr.title = paramString;
      return this;
    }
    
    public final a aXG(String paramString)
    {
      this.KWr.Iar = paramString;
      return this;
    }
    
    public final a aXH(String paramString)
    {
      this.KWr.Iat = paramString;
      return this;
    }
    
    public final a aXI(String paramString)
    {
      this.KWr.thumbPath = paramString;
      return this;
    }
    
    public final a aXJ(String paramString)
    {
      this.KWr.Iaf = paramString;
      return this;
    }
    
    public final a aXK(String paramString)
    {
      this.KWr.Iag = paramString;
      return this;
    }
    
    public final a aXL(String paramString)
    {
      this.KWr.KWe = paramString;
      return this;
    }
    
    public final a aXM(String paramString)
    {
      this.KWr.Iau = paramString;
      return this;
    }
    
    public final a aXN(String paramString)
    {
      this.KWr.Iav = paramString;
      return this;
    }
    
    public final a afe(int paramInt)
    {
      AppMethodBeat.i(159307);
      this.KWr.title = this.mContext.getString(paramInt);
      AppMethodBeat.o(159307);
      return this;
    }
    
    public final a aff(int paramInt)
    {
      this.KWr.ERj = paramInt;
      return this;
    }
    
    public final a afg(int paramInt)
    {
      this.KWr.IaJ = paramInt;
      return this;
    }
    
    public final a afh(int paramInt)
    {
      this.KWr.IaM = paramInt;
      return this;
    }
    
    public final a afi(int paramInt)
    {
      AppMethodBeat.i(159308);
      this.KWr.Iar = this.mContext.getString(paramInt);
      AppMethodBeat.o(159308);
      return this;
    }
    
    public final a afj(int paramInt)
    {
      this.KWr.IaK = paramInt;
      return this;
    }
    
    public final a afk(int paramInt)
    {
      this.KWr.IaL = paramInt;
      return this;
    }
    
    public final a afl(int paramInt)
    {
      AppMethodBeat.i(159310);
      this.KWr.Iau = this.mContext.getString(paramInt);
      AppMethodBeat.o(159310);
      return this;
    }
    
    public final a afm(int paramInt)
    {
      AppMethodBeat.i(159311);
      this.KWr.Iav = this.mContext.getString(paramInt);
      AppMethodBeat.o(159311);
      return this;
    }
    
    public final a afn(int paramInt)
    {
      this.KWr.IaQ = paramInt;
      return this;
    }
    
    public final a afo(int paramInt)
    {
      this.KWr.IaP = paramInt;
      return this;
    }
    
    public final a as(CharSequence paramCharSequence)
    {
      this.KWr.title = paramCharSequence;
      return this;
    }
    
    public final a at(CharSequence paramCharSequence)
    {
      this.KWr.Iae = paramCharSequence;
      return this;
    }
    
    public final a au(CharSequence paramCharSequence)
    {
      this.KWr.Ias = paramCharSequence;
      return this;
    }
    
    public final a c(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.KWr.IaC = paramOnClickListener;
      return this;
    }
    
    public final a c(b paramb)
    {
      this.KWr.KWh = paramb;
      return this;
    }
    
    public final a d(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.KWr.IaD = paramOnClickListener;
      return this;
    }
    
    public final a e(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.KWr.XL = paramOnCancelListener;
      return this;
    }
    
    public final d fMb()
    {
      AppMethodBeat.i(159312);
      d locald = new d(this.mContext, (byte)0);
      locald.a(this.KWr);
      AppMethodBeat.o(159312);
      return locald;
    }
    
    public final a gY(View paramView)
    {
      this.KWr.vd = paramView;
      return this;
    }
    
    public final a gZ(View paramView)
    {
      this.KWr.IaH = paramView;
      return this;
    }
    
    public final void show()
    {
      AppMethodBeat.i(221677);
      fMb().show();
      AppMethodBeat.o(221677);
    }
    
    public final a yP(boolean paramBoolean)
    {
      this.KWr.IaA = paramBoolean;
      return this;
    }
    
    public final a yQ(boolean paramBoolean)
    {
      this.KWr.Iah = paramBoolean;
      return this;
    }
    
    public final a yR(boolean paramBoolean)
    {
      this.KWr.ov = paramBoolean;
      return this;
    }
    
    public final a yS(boolean paramBoolean)
    {
      this.KWr.Iaz = paramBoolean;
      return this;
    }
    
    public static abstract interface a
    {
      public abstract void y(ImageView paramImageView, String paramString);
    }
    
    public static abstract interface b
    {
      public abstract void cxz();
    }
    
    public static abstract interface c
    {
      public abstract void fcz();
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