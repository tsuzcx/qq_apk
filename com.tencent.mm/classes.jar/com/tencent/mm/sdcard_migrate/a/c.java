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
  private LinearLayout ERU;
  private TextView ERV;
  private TextView ERW;
  private TextView ERX;
  private TextView ERY;
  private TextView ERZ;
  private ImageView ESa;
  private View ESb;
  private LinearLayout ESc;
  private ViewStub ESd;
  private LinearLayout ESe;
  private ViewGroup ESf;
  private LinearLayout ESg;
  private ViewGroup ESh;
  private View ESi;
  private boolean ESj;
  private Animation ESk;
  private Animation ESl;
  private Animation ESm;
  private Animation ESn;
  private c.a.c ESo;
  private DialogInterface.OnDismissListener ESp;
  private View aeL;
  com.tencent.mm.ui.widget.a.c iOnDialogDismissListener;
  private boolean lA;
  private TextView lWE;
  private Context mContext;
  private EditText mEditText;
  private boolean needEdit;
  private Button pRD;
  private Button zXZ;
  
  public c(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(196870);
    this.ESj = false;
    this.needEdit = false;
    this.mContext = paramContext;
    this.ERU = ((LinearLayout)View.inflate(this.mContext, 2131494766, null));
    this.zXZ = ((Button)this.ERU.findViewById(2131302314));
    this.pRD = ((Button)this.ERU.findViewById(2131302301));
    this.lWE = ((TextView)this.ERU.findViewById(2131302315));
    this.ERV = ((TextView)this.ERU.findViewById(2131302317));
    this.ERW = ((TextView)this.ERU.findViewById(2131302307));
    this.ERX = ((TextView)this.ERU.findViewById(2131302312));
    this.ERY = ((TextView)this.ERU.findViewById(2131302311));
    this.ERZ = ((TextView)this.ERU.findViewById(2131298564));
    this.mEditText = ((EditText)this.ERU.findViewById(2131298569));
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
    AppMethodBeat.o(196870);
  }
  
  private void Wa(int paramInt)
  {
    AppMethodBeat.i(196874);
    if (this.ERW != null) {
      this.ERW.setTextColor(paramInt);
    }
    AppMethodBeat.o(196874);
  }
  
  private void Wb(int paramInt)
  {
    AppMethodBeat.i(196877);
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
        AppMethodBeat.o(196877);
        return;
      }
      this.mEditText.setVisibility(paramInt);
    }
    AppMethodBeat.o(196877);
  }
  
  private void Wc(int paramInt)
  {
    AppMethodBeat.i(196880);
    this.zXZ.setTextColor(paramInt);
    AppMethodBeat.o(196880);
  }
  
  private void Wd(int paramInt)
  {
    AppMethodBeat.i(196881);
    this.pRD.setTextColor(paramInt);
    AppMethodBeat.o(196881);
  }
  
  private void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(196884);
    this.ESi.setVisibility(8);
    this.ESf.removeAllViews();
    this.ESf.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(196884);
  }
  
  private void a(CharSequence paramCharSequence, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(196882);
    if (this.pRD != null)
    {
      this.pRD.setVisibility(0);
      this.pRD.setText(paramCharSequence);
      this.pRD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(196862);
          if (paramOnClickListener != null) {
            paramOnClickListener.onClick(c.this, -2);
          }
          if (this.ESy) {
            c.this.cancel();
          }
          AppMethodBeat.o(196862);
        }
      });
    }
    AppMethodBeat.o(196882);
  }
  
  private void a(CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(196879);
    if (this.zXZ == null)
    {
      AppMethodBeat.o(196879);
      return;
    }
    this.zXZ.setVisibility(0);
    this.zXZ.setText(paramCharSequence);
    this.zXZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196861);
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(c.this, -1);
        }
        if (paramBoolean) {
          c.this.dismiss();
        }
        AppMethodBeat.o(196861);
      }
    });
    AppMethodBeat.o(196879);
  }
  
  private void fw(View paramView)
  {
    AppMethodBeat.i(196878);
    this.aeL = paramView;
    if (this.aeL != null)
    {
      this.ESe.setVisibility(0);
      this.ESg.setVisibility(0);
      this.ESg.removeAllViews();
      this.ESg.setGravity(1);
      this.ESg.addView(this.aeL, new LinearLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(196878);
  }
  
  private void uL(boolean paramBoolean)
  {
    AppMethodBeat.i(196876);
    if (paramBoolean)
    {
      int i = ao.fromDPToPix(this.mContext, 8);
      this.ESe.setVisibility(0);
      this.ESe.setPadding(i, i, i, i);
      this.ESe.setBackgroundResource(2131231925);
    }
    AppMethodBeat.o(196876);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(196885);
    int i;
    if ((parama.title != null) && (parama.title.length() > 0))
    {
      i = parama.ERM;
      if (this.lWE != null) {
        this.lWE.setGravity(i);
      }
      setTitle(parama.title);
    }
    Object localObject4;
    Object localObject1;
    if ((parama.ERe != null) && (parama.ERe.length() > 0))
    {
      localObject4 = parama.ERe;
      this.ESc.setVisibility(0);
      this.ERV.setVisibility(0);
      localObject1 = localObject4;
      if (this.ESo != null)
      {
        localObject1 = this.ESo;
        ((CharSequence)localObject4).toString();
        this.lWE.getTextSize();
        localObject1 = ((c.a.c)localObject1).eEL();
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
      fw(parama.sk);
    }
    if (parama.ERH != null)
    {
      localObject4 = parama.ERH;
      this.ESc.setVisibility(0);
      this.ESd.setLayoutResource(2131493580);
    }
    try
    {
      localObject1 = (LinearLayout)this.ESd.inflate();
      ((LinearLayout)localObject1).addView((View)localObject4);
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
          break label1950;
        }
        localObject1 = parama.ERs;
        this.ESe.setVisibility(0);
        this.ERX.setVisibility(0);
        this.ERX.setMaxLines(2);
        this.ERX.setText((CharSequence)localObject1);
        if ((parama.ERt != null) && (parama.ERt.length() > 0))
        {
          localObject4 = parama.ERt;
          if (localObject4 != null)
          {
            this.ESe.setVisibility(0);
            this.ERY.setVisibility(0);
            localObject1 = localObject4;
            if (this.ESo != null)
            {
              localObject1 = this.ESo;
              this.ERY.getContext();
              ((CharSequence)localObject4).toString();
              this.ERY.getTextSize();
              localObject1 = ((c.a.c)localObject1).eEL();
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
      if (parama.ERS)
      {
        localObject1 = parama.ERq;
        localObject5 = parama.ERs;
        localObject4 = parama.ERt;
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
          if (this.ESo != null)
          {
            localObject1 = this.ESo;
            ((CharSequence)localObject5).toString();
            ((TextView)localObject7).getTextSize();
            localObject1 = ((c.a.c)localObject1).eEL();
          }
          ((TextView)localObject7).setText((CharSequence)localObject1);
        }
        if (localObject4 != null)
        {
          localObject5 = (TextView)((View)localObject6).findViewById(2131302311);
          ((TextView)localObject5).setVisibility(0);
          if (this.ESo == null) {
            break label2233;
          }
          localObject1 = this.ESo;
          ((CharSequence)localObject4).toString();
          ((TextView)localObject5).getTextSize();
          localObject1 = ((c.a.c)localObject1).eEL();
          ((TextView)localObject5).setText((CharSequence)localObject1);
        }
        fw((View)localObject6);
        if ((parama.ERi != null) || (parama.ERj != null))
        {
          localObject4 = parama.ERi;
          localObject5 = parama.ERj;
          bool = parama.ERk;
          localObject6 = parama.ERm;
          this.ESd.setLayoutResource(2131493593);
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
          localObject1 = (LinearLayout)this.ESd.inflate();
          if ((localObject1 != null) && (localObject4 != null)) {
            ((ImageView)((LinearLayout)localObject1).findViewById(2131305922)).setVisibility(0);
          }
          if ((localObject1 != null) && (localObject5 != null))
          {
            localObject7 = (TextView)((LinearLayout)localObject1).findViewById(2131305945);
            ((TextView)localObject7).setVisibility(0);
            localObject4 = localObject5;
            if (this.ESo != null)
            {
              localObject4 = this.ESo;
              ((CharSequence)localObject5).toString();
              this.lWE.getTextSize();
              localObject4 = ((c.a.c)localObject4).eEL();
            }
            ((TextView)localObject7).setText((CharSequence)localObject4);
          }
          if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
          {
            localObject4 = (ImageView)((LinearLayout)localObject1).findViewById(2131300962);
            ((ImageView)localObject4).setVisibility(0);
            Wb(0);
            ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(196860);
                if (this.ESr.isSelected())
                {
                  c.b(c.this).startAnimation(c.a(c.this));
                  c.a(c.this).setAnimationListener(new Animation.AnimationListener()
                  {
                    public final void onAnimationEnd(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(196857);
                      c.b(c.this).setVisibility(8);
                      c.a(c.this, 0);
                      AppMethodBeat.o(196857);
                    }
                    
                    public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                    
                    public final void onAnimationStart(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(196856);
                      c.a(c.this, c.c(c.this));
                      AppMethodBeat.o(196856);
                    }
                  });
                  ObjectAnimator.ofFloat(this.ESr, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
                  this.ESr.setSelected(false);
                  AppMethodBeat.o(196860);
                  return;
                }
                c.b(c.this).startAnimation(c.d(c.this));
                c.d(c.this).setAnimationListener(new Animation.AnimationListener()
                {
                  public final void onAnimationEnd(Animation paramAnonymous2Animation)
                  {
                    AppMethodBeat.i(196859);
                    c.b(c.this).setVisibility(0);
                    c.a(c.this, 8);
                    AppMethodBeat.o(196859);
                  }
                  
                  public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                  
                  public final void onAnimationStart(Animation paramAnonymous2Animation)
                  {
                    AppMethodBeat.i(196858);
                    c.a(c.this, c.e(c.this));
                    AppMethodBeat.o(196858);
                  }
                });
                ObjectAnimator.ofFloat(this.ESr, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
                this.ESr.setSelected(true);
                AppMethodBeat.o(196860);
              }
            });
          }
          if (parama.ERn != null)
          {
            localObject1 = parama.ERn;
            if ((this.ESe != null) && (this.ESe.getVisibility() == 0)) {
              this.ESe.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView) {}
              });
            }
          }
          else
          {
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
            if (parama.ERh)
            {
              this.needEdit = parama.ERh;
              if (!parama.ERh) {
                continue;
              }
              this.mEditText.setVisibility(0);
            }
            if ((parama.ERu != null) && (parama.ERu.length() > 0)) {
              a(parama.ERu, parama.ERR, parama.ERC);
            }
            if ((parama.ERv != null) && (parama.ERv.length() > 0)) {
              a(parama.ERv, parama.ERD);
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
            if (parama.ERo != null) {
              this.ESo = parama.ERo;
            }
            setCancelable(parama.lA);
            this.lA = parama.lA;
            if (!this.lA) {
              super.setCancelable(parama.ERz);
            }
            if ((parama.ERw != null) || (parama.ERx != null) || (parama.ERy != null))
            {
              localObject1 = View.inflate(this.mContext, 2131493592, null);
              localObject4 = (Button)((View)localObject1).findViewById(2131302297);
              localObject5 = (Button)((View)localObject1).findViewById(2131302298);
              localObject6 = (Button)((View)localObject1).findViewById(2131302299);
              if (parama.ERw != null)
              {
                ((Button)localObject4).setVisibility(0);
                ((Button)localObject4).setText(parama.ERw);
                ((Button)localObject4).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(196863);
                    if (parama.ERE != null) {
                      parama.ERE.onClick(c.this, -1);
                    }
                    c.this.dismiss();
                    AppMethodBeat.o(196863);
                  }
                });
              }
              if (parama.ERx != null)
              {
                ((Button)localObject5).setVisibility(0);
                ((Button)localObject5).setText(parama.ERx);
                ((Button)localObject5).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(196864);
                    if (parama.ERF != null) {
                      parama.ERF.onClick(c.this, -2);
                    }
                    c.this.dismiss();
                    AppMethodBeat.o(196864);
                  }
                });
              }
              if (parama.ERy != null)
              {
                ((Button)localObject6).setVisibility(0);
                ((Button)localObject6).setText(parama.ERy);
                ((Button)localObject6).setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(196865);
                    if (parama.ERG != null) {
                      parama.ERG.onClick(c.this, -3);
                    }
                    c.this.dismiss();
                    AppMethodBeat.o(196865);
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
                a(parama.ERv, parama.ERD);
              }
              a((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
            }
            AppMethodBeat.o(196885);
            return;
            localException1 = localException1;
            this.ESd.setVisibility(0);
            Object localObject2 = null;
            continue;
            label1950:
            uL(false);
            continue;
            if (!parama.ERT) {
              continue;
            }
            localObject2 = parama.ERq;
            localObject5 = parama.ERs;
            localObject4 = parama.ERt;
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
              if (this.ESo != null)
              {
                localObject2 = this.ESo;
                ((CharSequence)localObject5).toString();
                ((TextView)localObject7).getTextSize();
                localObject2 = ((c.a.c)localObject2).eEL();
              }
              ((TextView)localObject7).setText((CharSequence)localObject2);
            }
            if (localObject4 != null)
            {
              localObject5 = (TextView)((View)localObject6).findViewById(2131302311);
              ((TextView)localObject5).setVisibility(0);
              if (this.ESo == null) {
                continue;
              }
              localObject2 = this.ESo;
              ((CharSequence)localObject4).toString();
              ((TextView)localObject5).getTextSize();
              localObject2 = ((c.a.c)localObject2).eEL();
              ((TextView)localObject5).setText((CharSequence)localObject2);
            }
            fw((View)localObject6);
          }
        }
        catch (Exception localException2)
        {
          this.ESd.setVisibility(0);
          localObject3 = null;
          continue;
          if (this.ESg == null) {
            continue;
          }
          this.ESg.setOnClickListener(new View.OnClickListener()
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
    AppMethodBeat.i(196887);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196866);
          c.this.dismiss();
          AppMethodBeat.o(196866);
        }
      });
      an.e("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
      AppMethodBeat.o(196887);
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
        AppMethodBeat.o(196887);
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
    AppMethodBeat.i(196871);
    super.onCreate(paramBundle);
    setContentView(this.ERU);
    AppMethodBeat.o(196871);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(196883);
    super.setCancelable(paramBoolean);
    this.lA = paramBoolean;
    setCanceledOnTouchOutside(this.lA);
    AppMethodBeat.o(196883);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196875);
    this.ESe.setVisibility(0);
    this.ERW.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.ESo != null)
    {
      localObject = this.ESo;
      this.ERW.getContext();
      paramCharSequence.toString();
      this.ERW.getTextSize();
      localObject = ((c.a.c)localObject).eEL();
    }
    this.ERW.setText((CharSequence)localObject);
    AppMethodBeat.o(196875);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(196873);
    this.ESc.setVisibility(0);
    this.lWE.setVisibility(0);
    this.lWE.setMaxLines(2);
    this.lWE.setText(paramInt);
    this.lWE.getPaint().setFakeBoldText(true);
    Wa(this.mContext.getResources().getColor(2131099734));
    AppMethodBeat.o(196873);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196872);
    this.ESc.setVisibility(0);
    this.lWE.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.ESo != null)
    {
      localObject = this.ESo;
      paramCharSequence.toString();
      this.lWE.getTextSize();
      localObject = ((c.a.c)localObject).eEL();
    }
    this.lWE.setMaxLines(2);
    this.lWE.setText((CharSequence)localObject);
    this.lWE.getPaint().setFakeBoldText(true);
    Wa(this.mContext.getResources().getColor(2131099734));
    AppMethodBeat.o(196872);
  }
  
  public final void show()
  {
    AppMethodBeat.i(196886);
    try
    {
      super.show();
      AppMethodBeat.o(196886);
      return;
    }
    catch (Exception localException)
    {
      an.printErrStackTrace("MicroMsg.MMAlertDialog", localException, "", new Object[0]);
      AppMethodBeat.o(196886);
    }
  }
  
  public static final class a
  {
    public a ESA;
    public Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(196867);
      this.mContext = paramContext;
      this.ESA = new a();
      AppMethodBeat.o(196867);
    }
    
    public final a a(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.ESA.ERC = paramOnClickListener;
      return this;
    }
    
    public final a aEW(String paramString)
    {
      this.ESA.title = paramString;
      return this;
    }
    
    public final a aEX(String paramString)
    {
      this.ESA.ERr = paramString;
      return this;
    }
    
    public final a aEY(String paramString)
    {
      this.ESA.ERu = paramString;
      return this;
    }
    
    public final a eEI()
    {
      AppMethodBeat.i(196868);
      this.ESA.ERu = this.mContext.getString(2131755835);
      AppMethodBeat.o(196868);
      return this;
    }
    
    public final a eEJ()
    {
      this.ESA.lA = false;
      return this;
    }
    
    public final c eEK()
    {
      AppMethodBeat.i(196869);
      c localc = new c(this.mContext);
      localc.a(this.ESA);
      AppMethodBeat.o(196869);
      return localc;
    }
    
    public static abstract interface a {}
    
    public static abstract interface b {}
    
    public static abstract interface c
    {
      public abstract CharSequence eEL();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a.c
 * JD-Core Version:    0.7.0.1
 */