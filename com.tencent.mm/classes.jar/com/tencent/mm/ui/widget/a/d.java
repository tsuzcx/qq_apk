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
  private LinearLayout ERU;
  private TextView ERV;
  public TextView ERW;
  private TextView ERX;
  private TextView ERY;
  private TextView ERZ;
  private ImageView ESa;
  private View ESb;
  private LinearLayout ESc;
  private ViewStub ESd;
  public LinearLayout ESe;
  private ViewGroup ESf;
  private LinearLayout ESg;
  private ViewGroup ESh;
  private View ESi;
  private boolean ESj;
  private Animation ESk;
  private Animation ESl;
  private Animation ESm;
  private Animation ESn;
  public DialogInterface.OnDismissListener ESp;
  private d.a.d HEI;
  CheckBox acW;
  private View aeL;
  public c iOnDialogDismissListener;
  private boolean lA;
  private TextView lWE;
  private Context mContext;
  private EditText mEditText;
  private boolean needEdit;
  private Button pRD;
  public Button zXZ;
  
  public d(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(159314);
    this.ESj = false;
    this.needEdit = false;
    this.mContext = paramContext;
    this.ERU = ((LinearLayout)View.inflate(this.mContext, 2131494764, null));
    this.zXZ = ((Button)this.ERU.findViewById(2131302314));
    this.pRD = ((Button)this.ERU.findViewById(2131302301));
    this.lWE = ((TextView)this.ERU.findViewById(2131302315));
    this.ERV = ((TextView)this.ERU.findViewById(2131302317));
    this.ERW = ((TextView)this.ERU.findViewById(2131302307));
    this.ERX = ((TextView)this.ERU.findViewById(2131302312));
    this.ERY = ((TextView)this.ERU.findViewById(2131302311));
    this.ERZ = ((TextView)this.ERU.findViewById(2131298564));
    this.mEditText = ((EditText)this.ERU.findViewById(2131298569));
    this.acW = ((CheckBox)this.ERU.findViewById(2131298561));
    this.ESa = ((ImageView)this.ERU.findViewById(2131302310));
    this.ESc = ((LinearLayout)this.ERU.findViewById(2131302316));
    this.ESd = ((ViewStub)this.ERU.findViewById(2131305933));
    this.ESe = ((LinearLayout)this.ERU.findViewById(2131302308));
    this.ESf = ((ViewGroup)this.ERU.findViewById(2131302295));
    this.ESi = this.ERU.findViewById(2131302300);
    this.ESg = ((LinearLayout)this.ERU.findViewById(2131302303));
    this.ESh = ((ViewGroup)this.ERU.findViewById(2131305932));
    setCanceledOnTouchOutside(true);
    this.ESk = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.ESl = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.ESm = AnimationUtils.loadAnimation(this.mContext, 2130771982);
    this.ESn = AnimationUtils.loadAnimation(this.mContext, 2130771982);
    AppMethodBeat.o(159314);
  }
  
  private void Wa(int paramInt)
  {
    AppMethodBeat.i(159318);
    if (this.ERW != null) {
      this.ERW.setTextColor(paramInt);
    }
    AppMethodBeat.o(159318);
  }
  
  private void Wb(int paramInt)
  {
    AppMethodBeat.i(159324);
    if (this.ESe != null) {
      this.ESe.setVisibility(paramInt);
    }
    if (this.ESg != null) {
      this.ESg.setVisibility(paramInt);
    }
    if ((this.ERZ != null) && (this.ESj)) {
      this.ERZ.setVisibility(paramInt);
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
    this.ESi.setVisibility(8);
    this.ESf.removeAllViews();
    this.ESf.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(159334);
  }
  
  private void aF(View paramView, int paramInt)
  {
    AppMethodBeat.i(159325);
    this.aeL = paramView;
    if (this.aeL != null)
    {
      this.ESe.setVisibility(0);
      this.ESg.setVisibility(0);
      this.ESg.removeAllViews();
      this.ESg.setGravity(1);
      this.ESg.addView(this.aeL, new LinearLayout.LayoutParams(paramInt, paramInt));
    }
    AppMethodBeat.o(159325);
  }
  
  private void uL(boolean paramBoolean)
  {
    AppMethodBeat.i(159320);
    if (paramBoolean)
    {
      int i = ao.fromDPToPix(this.mContext, 8);
      this.ESe.setVisibility(0);
      this.ESe.setPadding(i, i, i, i);
    }
    AppMethodBeat.o(159320);
  }
  
  public final void Wc(int paramInt)
  {
    AppMethodBeat.i(159327);
    this.zXZ.setTextColor(paramInt);
    AppMethodBeat.o(159327);
  }
  
  public final void Wd(int paramInt)
  {
    AppMethodBeat.i(159328);
    this.pRD.setTextColor(paramInt);
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
      i = parama.ERM;
      if (this.lWE != null) {
        this.lWE.setGravity(i);
      }
      setTitle(parama.title);
    }
    Object localObject3;
    Object localObject1;
    if ((parama.ERe != null) && (parama.ERe.length() > 0))
    {
      localObject3 = parama.ERe;
      this.ESc.setVisibility(0);
      this.ERV.setVisibility(0);
      localObject1 = localObject3;
      if (this.HEI != null) {
        localObject1 = this.HEI.a(((CharSequence)localObject3).toString(), this.lWE.getTextSize());
      }
      this.ERV.setText((CharSequence)localObject1);
    }
    if (parama.BTR != 0)
    {
      i = parama.BTR;
      this.lWE.setTextColor(ColorStateList.valueOf(i));
    }
    if (parama.ERJ != 0)
    {
      i = parama.ERJ;
      this.lWE.setMaxLines(i);
    }
    if (parama.ERK != 0)
    {
      i = parama.ERK;
      this.ERW.setMaxLines(i);
    }
    if (parama.sk != null) {
      aF(parama.sk, -1);
    }
    if (parama.ERH != null)
    {
      localObject3 = parama.ERH;
      this.ESc.setVisibility(0);
      this.ESd.setLayoutResource(2131493580);
    }
    try
    {
      localObject1 = (LinearLayout)this.ESd.inflate();
      ((LinearLayout)localObject1).addView((View)localObject3);
      if (parama.ERI != null)
      {
        this.ESb = parama.ERI;
        if (this.ESb != null)
        {
          this.ESe.setVisibility(8);
          this.ERZ.setVisibility(8);
          this.mEditText.setVisibility(8);
          this.ESh.removeAllViews();
          this.ESh.addView(this.ESb, new LinearLayout.LayoutParams(-1, -1));
          this.ESh.setVisibility(8);
        }
      }
      if (parama.ERp != null)
      {
        localObject1 = parama.ERp;
        if (this.aeL == null)
        {
          this.ESe.setVisibility(0);
          this.ESa.setVisibility(0);
          this.ESa.setBackgroundDrawable((Drawable)localObject1);
        }
      }
      if ((parama.ERr != null) && (parama.ERr.length() > 0)) {
        setMessage(parama.ERr);
      }
      uL(parama.ERA);
      if (parama.thumbPath != null)
      {
        localObject1 = parama.thumbPath;
        i = ao.fromDPToPix(this.mContext, 120);
        this.ESe.setVisibility(0);
        this.ESa.setVisibility(0);
        if ((this.ESa instanceof com.tencent.mm.ui.f.a)) {
          ((com.tencent.mm.ui.f.a)this.ESa).aB((String)localObject1, i, i);
        }
        i = parama.ERO;
        this.ESe.setVisibility(i);
        this.ESa.setVisibility(i);
      }
      if ((!parama.ERS) && (!parama.ERT))
      {
        if ((parama.ERr != null) && (parama.ERr.length() > 0)) {
          setMessage(parama.ERr);
        }
        if ((parama.ERs == null) || (parama.ERs.length() <= 0)) {
          break label2278;
        }
        localObject1 = parama.ERs;
        this.ESe.setVisibility(0);
        this.ERX.setVisibility(0);
        this.ERX.setMaxLines(2);
        this.ERX.setText((CharSequence)localObject1);
        if ((parama.ERt != null) && (parama.ERt.length() > 0))
        {
          localObject3 = parama.ERt;
          if (localObject3 != null)
          {
            this.ESe.setVisibility(0);
            this.ERY.setVisibility(0);
            localObject1 = localObject3;
            if (this.HEI != null)
            {
              localObject1 = this.HEI;
              this.ERY.getContext();
              localObject1 = ((d.a.d)localObject1).a(((CharSequence)localObject3).toString(), this.ERY.getTextSize());
            }
            this.ERY.setText((CharSequence)localObject1);
          }
        }
        if (parama.ERq != null)
        {
          localObject1 = parama.ERq;
          if (this.aeL == null)
          {
            this.ESe.setVisibility(0);
            this.ESa.setVisibility(0);
            this.ESa.setImageBitmap((Bitmap)localObject1);
          }
        }
      }
      boolean bool;
      d.a.a locala;
      if (parama.ERS)
      {
        localObject1 = parama.ERq;
        localObject4 = parama.ERs;
        localObject3 = parama.ERt;
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
          if (this.HEI != null) {
            localObject1 = this.HEI.a(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
          }
          ((TextView)localObject6).setText((CharSequence)localObject1);
        }
        if (localObject3 != null)
        {
          localObject4 = (TextView)((View)localObject5).findViewById(2131302311);
          ((TextView)localObject4).setVisibility(0);
          if (this.HEI == null) {
            break label2662;
          }
          localObject1 = this.HEI.a(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
          ((TextView)localObject4).setText((CharSequence)localObject1);
        }
        aF((View)localObject5, -1);
        if ((parama.ERi != null) || (parama.ERj != null))
        {
          localObject6 = parama.ERi;
          localObject4 = parama.ERj;
          bool = parama.ERk;
          localObject5 = parama.HEC;
          locala = parama.HED;
          this.ESd.setLayoutResource(2131493593);
          localObject1 = null;
        }
      }
      try
      {
        localObject3 = (LinearLayout)this.ESd.inflate();
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
          this.ESd.setVisibility(0);
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
        if (this.HEI != null) {
          localObject3 = this.HEI.a(((CharSequence)localObject4).toString(), this.lWE.getTextSize());
        }
        ((TextView)localObject6).setText((CharSequence)localObject3);
      }
      if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
      {
        localObject3 = (ImageView)((LinearLayout)localObject1).findViewById(2131300962);
        ((ImageView)localObject3).setVisibility(0);
        Wb(0);
        ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(159297);
            if (this.HEJ != null) {
              this.HEJ.eyg();
            }
            if (this.ESr.isSelected())
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
              ObjectAnimator.ofFloat(this.ESr, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
              this.ESr.setSelected(false);
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
            ObjectAnimator.ofFloat(this.ESr, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
            this.ESr.setSelected(true);
            AppMethodBeat.o(159297);
          }
        });
      }
      if (parama.HEE != null) {
        b(parama.HEE);
      }
      if ((parama.HEG != null) && (!parama.HEG.isRecycled()))
      {
        localObject3 = parama.HEG;
        bool = parama.ERB;
        i2 = parama.ERN;
        if (localObject3 != null)
        {
          uL(false);
          this.ESe.setVisibility(0);
          this.ESe.setGravity(1);
          this.ESe.setPadding(0, 0, 0, 0);
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
          i1 = ao.ap(this.mContext, 2131165260);
          i = ao.ap(this.mContext, 2131165259);
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
          aF((View)localObject5, -2);
        }
      }
      if ((parama.ERf != null) && (parama.ERf.length() > 0))
      {
        localObject1 = parama.ERf;
        if (localObject1 != null)
        {
          this.ERZ.setVisibility(0);
          this.ERZ.setText((CharSequence)localObject1);
        }
        this.ESj = true;
        i = parama.ERL;
        if (this.ERZ != null) {
          this.ERZ.setGravity(i);
        }
      }
      if ((parama.ERg != null) && (parama.ERg.length() > 0))
      {
        localObject1 = parama.ERg;
        this.mEditText.setVisibility(0);
        this.mEditText.setHint((CharSequence)localObject1);
      }
      if ((parama.HEB != null) && (parama.HEB.length() > 0))
      {
        localObject1 = parama.HEB;
        this.acW.setVisibility(0);
        this.acW.setText((CharSequence)localObject1);
      }
      if (parama.ERh)
      {
        this.needEdit = parama.ERh;
        if (parama.ERh) {
          this.mEditText.setVisibility(0);
        }
      }
      else
      {
        if ((parama.ERu != null) && (parama.ERu.length() > 0)) {
          a(parama.ERu, parama.ERR, parama.ERC);
        }
        if ((parama.ERv != null) && (parama.ERv.length() > 0)) {
          b(parama.ERv, true, parama.ERD);
        }
        if (parama.ERQ != 0) {
          Wc(parama.ERQ);
        }
        if (parama.ERP != 0) {
          Wd(parama.ERP);
        }
        if (parama.Vb != null) {
          setOnCancelListener(parama.Vb);
        }
        if (parama.Vc != null)
        {
          this.ESp = parama.Vc;
          setOnDismissListener(parama.Vc);
        }
        if (parama.HEF != null) {
          this.HEI = parama.HEF;
        }
        setCancelable(parama.lA);
        this.lA = parama.lA;
        if (!this.lA) {
          super.setCancelable(parama.ERz);
        }
        if ((parama.ERw != null) || (parama.ERx != null) || (parama.ERy != null))
        {
          localObject1 = View.inflate(this.mContext, 2131493592, null);
          localObject3 = (Button)((View)localObject1).findViewById(2131302297);
          localObject4 = (Button)((View)localObject1).findViewById(2131302298);
          localObject5 = (Button)((View)localObject1).findViewById(2131302299);
          if (parama.ERw != null)
          {
            ((Button)localObject3).setVisibility(0);
            ((Button)localObject3).setText(parama.ERw);
            ((Button)localObject3).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159302);
                if (parama.ERE != null) {
                  parama.ERE.onClick(d.this, -1);
                }
                d.this.dismiss();
                AppMethodBeat.o(159302);
              }
            });
          }
          if (parama.ERx != null)
          {
            ((Button)localObject4).setVisibility(0);
            ((Button)localObject4).setText(parama.ERx);
            ((Button)localObject4).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159303);
                if (parama.ERF != null) {
                  parama.ERF.onClick(d.this, -2);
                }
                d.this.dismiss();
                AppMethodBeat.o(159303);
              }
            });
          }
          if (parama.ERy != null)
          {
            ((Button)localObject5).setVisibility(0);
            ((Button)localObject5).setText(parama.ERy);
            ((Button)localObject5).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(159304);
                if (parama.ERG != null) {
                  parama.ERG.onClick(d.this, -3);
                }
                d.this.dismiss();
                AppMethodBeat.o(159304);
              }
            });
          }
          a((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
        }
        if (parama.ERl)
        {
          localObject1 = View.inflate(this.mContext, 2131493579, null);
          this.pRD = ((Button)((View)localObject1).findViewById(2131302301));
          this.zXZ = ((Button)((View)localObject1).findViewById(2131302314));
          if (parama.ERQ != 0) {
            Wc(parama.ERQ);
          }
          if (parama.ERP != 0) {
            Wd(parama.ERP);
          }
          if ((parama.ERu != null) && (parama.ERu.length() > 0)) {
            a(parama.ERu, parama.ERR, parama.ERC);
          }
          if ((parama.ERv != null) && (parama.ERv.length() > 0)) {
            b(parama.ERv, true, parama.ERD);
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
        this.ESd.setVisibility(0);
        Object localObject2 = null;
        continue;
        label2278:
        uL(false);
        continue;
        label2596:
        if (parama.ERT)
        {
          localObject2 = parama.ERq;
          localObject4 = parama.ERs;
          localObject3 = parama.ERt;
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
            if (this.HEI != null) {
              localObject2 = this.HEI.a(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
            }
            ((TextView)localObject6).setText((CharSequence)localObject2);
          }
          if (localObject3 != null)
          {
            localObject4 = (TextView)((View)localObject5).findViewById(2131302311);
            ((TextView)localObject4).setVisibility(0);
            if (this.HEI != null)
            {
              localObject2 = this.HEI.a(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
              ((TextView)localObject4).setText((CharSequence)localObject2);
            }
          }
          else
          {
            aF((View)localObject5, -1);
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
    if (this.zXZ == null)
    {
      AppMethodBeat.o(159326);
      return;
    }
    this.zXZ.setVisibility(0);
    this.zXZ.setText(paramCharSequence);
    this.zXZ.setOnClickListener(new View.OnClickListener()
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
    if ((this.ESe != null) && (this.ESe.getVisibility() == 0))
    {
      this.ESe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159298);
          if (paramb != null) {
            paramb.ckg();
          }
          AppMethodBeat.o(159298);
        }
      });
      AppMethodBeat.o(159323);
      return;
    }
    if (this.ESg != null) {
      this.ESg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159299);
          if (paramb != null) {
            paramb.ckg();
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
    if (this.pRD == null)
    {
      AppMethodBeat.o(159330);
      return;
    }
    this.pRD.setVisibility(0);
    this.pRD.setText(paramCharSequence);
    this.pRD.setOnClickListener(new View.OnClickListener()
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
  
  public final String ffq()
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
  
  public final int ffr()
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
  
  public final ImageView ffs()
  {
    return this.ESa;
  }
  
  public final Button getButton(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case -1: 
      return this.zXZ;
    }
    return this.pRD;
  }
  
  public View getContentView()
  {
    return this.ERU;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(159315);
    super.onCreate(paramBundle);
    setContentView(this.ERU);
    AppMethodBeat.o(159315);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(159332);
    super.setCancelable(paramBoolean);
    this.lA = paramBoolean;
    setCanceledOnTouchOutside(this.lA);
    AppMethodBeat.o(159332);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159319);
    this.ESe.setVisibility(0);
    this.ERW.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.HEI != null)
    {
      localObject = this.HEI;
      this.ERW.getContext();
      localObject = ((d.a.d)localObject).a(paramCharSequence.toString(), this.ERW.getTextSize());
    }
    this.ERW.setText((CharSequence)localObject);
    AppMethodBeat.o(159319);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(159317);
    this.ESc.setVisibility(0);
    this.lWE.setVisibility(0);
    this.lWE.setMaxLines(2);
    this.lWE.setText(paramInt);
    this.lWE.getPaint().setFakeBoldText(true);
    Wa(this.mContext.getResources().getColor(2131099734));
    AppMethodBeat.o(159317);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159316);
    this.ESc.setVisibility(0);
    this.lWE.setVisibility(0);
    CharSequence localCharSequence = paramCharSequence;
    if (this.HEI != null) {
      localCharSequence = this.HEI.a(paramCharSequence.toString(), this.lWE.getTextSize());
    }
    this.lWE.setMaxLines(2);
    this.lWE.setText(localCharSequence);
    this.lWE.getPaint().setFakeBoldText(true);
    Wa(this.mContext.getResources().getColor(2131099734));
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
  
  public final void wU(boolean paramBoolean)
  {
    AppMethodBeat.i(159333);
    super.setCancelable(paramBoolean);
    AppMethodBeat.o(159333);
  }
  
  public static final class a
  {
    public a HEO;
    public Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159306);
      this.mContext = paramContext;
      this.HEO = new a();
      AppMethodBeat.o(159306);
    }
    
    public final a a(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.HEO.Vc = paramOnDismissListener;
      return this;
    }
    
    public final a a(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
    {
      this.HEO.HEG = paramBitmap;
      this.HEO.ERB = paramBoolean;
      this.HEO.ERN = paramInt;
      return this;
    }
    
    public final a a(d paramd)
    {
      this.HEO.HEF = paramd;
      return this;
    }
    
    public final a a(String paramString, CharSequence paramCharSequence, Boolean paramBoolean, c paramc, a parama)
    {
      AppMethodBeat.i(159309);
      this.HEO.ERi = paramString;
      this.HEO.ERj = paramCharSequence;
      this.HEO.ERk = paramBoolean.booleanValue();
      this.HEO.HEC = paramc;
      this.HEO.HED = parama;
      AppMethodBeat.o(159309);
      return this;
    }
    
    public final a a(boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.HEO.ERC = paramOnClickListener;
      this.HEO.ERR = paramBoolean;
      return this;
    }
    
    public final a aF(Bitmap paramBitmap)
    {
      this.HEO.ERq = paramBitmap;
      return this;
    }
    
    public final a aMf(String paramString)
    {
      this.HEO.title = paramString;
      return this;
    }
    
    public final a aMg(String paramString)
    {
      this.HEO.ERr = paramString;
      return this;
    }
    
    public final a aMh(String paramString)
    {
      this.HEO.ERt = paramString;
      return this;
    }
    
    public final a aMi(String paramString)
    {
      this.HEO.thumbPath = paramString;
      return this;
    }
    
    public final a aMj(String paramString)
    {
      this.HEO.ERf = paramString;
      return this;
    }
    
    public final a aMk(String paramString)
    {
      this.HEO.ERg = paramString;
      return this;
    }
    
    public final a aMl(String paramString)
    {
      this.HEO.HEB = paramString;
      return this;
    }
    
    public final a aMm(String paramString)
    {
      this.HEO.ERu = paramString;
      return this;
    }
    
    public final a aMn(String paramString)
    {
      this.HEO.ERv = paramString;
      return this;
    }
    
    public final a aaA(int paramInt)
    {
      this.HEO.ERL = paramInt;
      return this;
    }
    
    public final a aaB(int paramInt)
    {
      AppMethodBeat.i(159310);
      this.HEO.ERu = this.mContext.getString(paramInt);
      AppMethodBeat.o(159310);
      return this;
    }
    
    public final a aaC(int paramInt)
    {
      AppMethodBeat.i(159311);
      this.HEO.ERv = this.mContext.getString(paramInt);
      AppMethodBeat.o(159311);
      return this;
    }
    
    public final a aaD(int paramInt)
    {
      this.HEO.ERQ = paramInt;
      return this;
    }
    
    public final a aaE(int paramInt)
    {
      this.HEO.ERP = paramInt;
      return this;
    }
    
    public final a aau(int paramInt)
    {
      AppMethodBeat.i(159307);
      this.HEO.title = this.mContext.getString(paramInt);
      AppMethodBeat.o(159307);
      return this;
    }
    
    public final a aav(int paramInt)
    {
      this.HEO.BTR = paramInt;
      return this;
    }
    
    public final a aaw(int paramInt)
    {
      this.HEO.ERJ = paramInt;
      return this;
    }
    
    public final a aax(int paramInt)
    {
      this.HEO.ERM = paramInt;
      return this;
    }
    
    public final a aay(int paramInt)
    {
      AppMethodBeat.i(159308);
      this.HEO.ERr = this.mContext.getString(paramInt);
      AppMethodBeat.o(159308);
      return this;
    }
    
    public final a aaz(int paramInt)
    {
      this.HEO.ERK = paramInt;
      return this;
    }
    
    public final a ar(CharSequence paramCharSequence)
    {
      this.HEO.title = paramCharSequence;
      return this;
    }
    
    public final a as(CharSequence paramCharSequence)
    {
      this.HEO.ERe = paramCharSequence;
      return this;
    }
    
    public final a at(CharSequence paramCharSequence)
    {
      this.HEO.ERs = paramCharSequence;
      return this;
    }
    
    public final a b(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.HEO.ERC = paramOnClickListener;
      return this;
    }
    
    public final a c(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.HEO.ERD = paramOnClickListener;
      return this;
    }
    
    public final a c(b paramb)
    {
      this.HEO.HEE = paramb;
      return this;
    }
    
    public final a e(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.HEO.Vb = paramOnCancelListener;
      return this;
    }
    
    public final d fft()
    {
      AppMethodBeat.i(159312);
      d locald = new d(this.mContext);
      locald.a(this.HEO);
      AppMethodBeat.o(159312);
      return locald;
    }
    
    public final a gs(View paramView)
    {
      this.HEO.sk = paramView;
      return this;
    }
    
    public final a gt(View paramView)
    {
      this.HEO.ERH = paramView;
      return this;
    }
    
    public final void show()
    {
      AppMethodBeat.i(202394);
      fft().show();
      AppMethodBeat.o(202394);
    }
    
    public final a wV(boolean paramBoolean)
    {
      this.HEO.ERA = paramBoolean;
      return this;
    }
    
    public final a wW(boolean paramBoolean)
    {
      this.HEO.ERh = paramBoolean;
      return this;
    }
    
    public final a wX(boolean paramBoolean)
    {
      this.HEO.lA = paramBoolean;
      return this;
    }
    
    public final a wY(boolean paramBoolean)
    {
      this.HEO.ERz = paramBoolean;
      return this;
    }
    
    public static abstract interface a
    {
      public abstract void y(ImageView paramImageView, String paramString);
    }
    
    public static abstract interface b
    {
      public abstract void ckg();
    }
    
    public static abstract interface c
    {
      public abstract void eyg();
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