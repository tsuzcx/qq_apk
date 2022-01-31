package com.tencent.mm.ui.widget.b;

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
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.edittext.PasterEditText;

public class c
  extends Dialog
  implements DialogInterface
{
  private boolean AGA;
  private Animation AGB;
  private Animation AGC;
  private Animation AGD;
  private Animation AGE;
  private c.a.d AGF;
  public DialogInterface.OnDismissListener AGG;
  private TextView AGq;
  private TextView AGr;
  private TextView AGs;
  public ImageView AGt;
  private View AGu;
  private LinearLayout AGv;
  private ViewStub AGw;
  private ViewGroup AGx;
  private ViewGroup AGy;
  private View AGz;
  CheckBox VR;
  private boolean gKc;
  private TextView jhF;
  private View lX;
  private Context mContext;
  private EditText mEditText;
  private Button mkS;
  private boolean needEdit;
  public Button usy;
  private LinearLayout zaf;
  public TextView zag;
  private TextView zah;
  public LinearLayout zai;
  private LinearLayout zaj;
  
  public c(Context paramContext)
  {
    super(paramContext, 2131493881);
    AppMethodBeat.i(112622);
    this.AGA = false;
    this.needEdit = false;
    this.mContext = paramContext;
    this.zaf = ((LinearLayout)View.inflate(this.mContext, 2130970142, null));
    this.usy = ((Button)this.zaf.findViewById(2131822981));
    this.mkS = ((Button)this.zaf.findViewById(2131822980));
    this.jhF = ((TextView)this.zaf.findViewById(2131826145));
    this.AGq = ((TextView)this.zaf.findViewById(2131826146));
    this.zag = ((TextView)this.zaf.findViewById(2131826150));
    this.zah = ((TextView)this.zaf.findViewById(2131822986));
    this.AGr = ((TextView)this.zaf.findViewById(2131822987));
    this.AGs = ((TextView)this.zaf.findViewById(2131822993));
    this.mEditText = ((EditText)this.zaf.findViewById(2131822990));
    this.VR = ((CheckBox)this.zaf.findViewById(2131826152));
    this.AGt = ((ImageView)this.zaf.findViewById(2131822985));
    this.AGv = ((LinearLayout)this.zaf.findViewById(2131826144));
    this.AGw = ((ViewStub)this.zaf.findViewById(2131826147));
    this.zai = ((LinearLayout)this.zaf.findViewById(2131824644));
    this.AGx = ((ViewGroup)this.zaf.findViewById(2131826153));
    this.AGz = this.zaf.findViewById(2131826154);
    this.zaj = ((LinearLayout)this.zaf.findViewById(2131826151));
    this.AGy = ((ViewGroup)this.zaf.findViewById(2131826148));
    setCanceledOnTouchOutside(true);
    this.AGB = AnimationUtils.loadAnimation(this.mContext, 2131034125);
    this.AGC = AnimationUtils.loadAnimation(this.mContext, 2131034125);
    this.AGD = AnimationUtils.loadAnimation(this.mContext, 2131034126);
    this.AGE = AnimationUtils.loadAnimation(this.mContext, 2131034126);
    AppMethodBeat.o(112622);
  }
  
  private void QY(int paramInt)
  {
    AppMethodBeat.i(112631);
    if (this.zai != null) {
      this.zai.setVisibility(paramInt);
    }
    if (this.zaj != null) {
      this.zaj.setVisibility(paramInt);
    }
    if ((this.AGs != null) && (this.AGA)) {
      this.AGs.setVisibility(paramInt);
    }
    if (this.mEditText != null)
    {
      if (!this.needEdit)
      {
        this.mEditText.setVisibility(8);
        AppMethodBeat.o(112631);
        return;
      }
      this.mEditText.setVisibility(paramInt);
    }
    AppMethodBeat.o(112631);
  }
  
  private void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(112641);
    this.AGz.setVisibility(8);
    this.AGx.removeAllViews();
    this.AGx.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(112641);
  }
  
  private void as(View paramView, int paramInt)
  {
    AppMethodBeat.i(112632);
    this.lX = paramView;
    if (this.lX != null)
    {
      this.zai.setVisibility(0);
      this.zaj.setVisibility(0);
      this.zaj.removeAllViews();
      this.zaj.setGravity(1);
      this.zaj.addView(this.lX, new LinearLayout.LayoutParams(paramInt, paramInt));
    }
    AppMethodBeat.o(112632);
  }
  
  private void dCo()
  {
    AppMethodBeat.i(112626);
    if (this.zag != null) {
      this.zag.setTextColor(this.zag.getContext().getResources().getColor(2131689956));
    }
    AppMethodBeat.o(112626);
  }
  
  private void rC(boolean paramBoolean)
  {
    AppMethodBeat.i(112628);
    if (paramBoolean)
    {
      int i = al.fromDPToPix(this.mContext, 8);
      this.zai.setVisibility(0);
      this.zai.setPadding(i, i, i, i);
      this.zai.setBackgroundResource(2130838541);
    }
    AppMethodBeat.o(112628);
  }
  
  public final void QZ(int paramInt)
  {
    AppMethodBeat.i(112634);
    this.usy.setTextColor(paramInt);
    AppMethodBeat.o(112634);
  }
  
  public final void Ra(int paramInt)
  {
    AppMethodBeat.i(112635);
    this.mkS.setTextColor(paramInt);
    AppMethodBeat.o(112635);
  }
  
  public final void a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(112636);
    a(this.mContext.getString(paramInt), true, paramOnClickListener);
    AppMethodBeat.o(112636);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(112642);
    int i;
    if ((parama.title != null) && (parama.title.length() > 0))
    {
      i = parama.zrv;
      if (this.jhF != null) {
        this.jhF.setGravity(i);
      }
      setTitle(parama.title);
    }
    Object localObject3;
    Object localObject1;
    if ((parama.AFx != null) && (parama.AFx.length() > 0))
    {
      localObject3 = parama.AFx;
      this.AGv.setVisibility(0);
      this.AGq.setVisibility(0);
      localObject1 = localObject3;
      if (this.AGF != null) {
        localObject1 = this.AGF.a(((CharSequence)localObject3).toString(), this.jhF.getTextSize());
      }
      this.AGq.setText((CharSequence)localObject1);
    }
    if (parama.vOR != 0)
    {
      i = parama.vOR;
      this.jhF.setTextColor(ColorStateList.valueOf(i));
    }
    if (parama.AGf != 0)
    {
      i = parama.AGf;
      this.jhF.setMaxLines(i);
    }
    if (parama.AGg != 0)
    {
      i = parama.AGg;
      this.zag.setMaxLines(i);
    }
    if (parama.veX != null) {
      as(parama.veX, -1);
    }
    if (parama.AGd != null)
    {
      localObject3 = parama.AGd;
      this.AGv.setVisibility(0);
      this.AGw.setLayoutResource(2130969195);
    }
    try
    {
      localObject1 = (LinearLayout)this.AGw.inflate();
      ((LinearLayout)localObject1).addView((View)localObject3);
      if (parama.AGe != null)
      {
        this.AGu = parama.AGe;
        if (this.AGu != null)
        {
          this.zai.setVisibility(8);
          this.AGs.setVisibility(8);
          this.mEditText.setVisibility(8);
          this.AGy.removeAllViews();
          this.AGy.addView(this.AGu, new LinearLayout.LayoutParams(-1, -1));
          this.AGy.setVisibility(8);
        }
      }
      if (parama.AFK != null)
      {
        localObject1 = parama.AFK;
        if (this.lX == null)
        {
          this.zai.setVisibility(0);
          this.AGt.setVisibility(0);
          this.AGt.setBackgroundDrawable((Drawable)localObject1);
        }
      }
      if ((parama.AFN != null) && (parama.AFN.length() > 0)) {
        setMessage(parama.AFN);
      }
      rC(parama.AFW);
      if (parama.thumbPath != null)
      {
        localObject1 = parama.thumbPath;
        i = al.fromDPToPix(this.mContext, 120);
        this.zai.setVisibility(0);
        this.AGt.setVisibility(0);
        if ((this.AGt instanceof com.tencent.mm.ui.f.a)) {
          ((com.tencent.mm.ui.f.a)this.AGt).ax((String)localObject1, i, i);
        }
        i = parama.AGj;
        this.zai.setVisibility(i);
        this.AGt.setVisibility(i);
      }
      if ((!parama.AGn) && (!parama.AGo))
      {
        if ((parama.AFN != null) && (parama.AFN.length() > 0)) {
          setMessage(parama.AFN);
        }
        if ((parama.AFO == null) || (parama.AFO.length() <= 0)) {
          break label2278;
        }
        localObject1 = parama.AFO;
        this.zai.setVisibility(0);
        this.zah.setVisibility(0);
        this.zah.setMaxLines(2);
        this.zah.setText((CharSequence)localObject1);
        if ((parama.AFP != null) && (parama.AFP.length() > 0))
        {
          localObject3 = parama.AFP;
          if (localObject3 != null)
          {
            this.zai.setVisibility(0);
            this.AGr.setVisibility(0);
            localObject1 = localObject3;
            if (this.AGF != null)
            {
              localObject1 = this.AGF;
              this.AGr.getContext();
              localObject1 = ((c.a.d)localObject1).a(((CharSequence)localObject3).toString(), this.AGr.getTextSize());
            }
            this.AGr.setText((CharSequence)localObject1);
          }
        }
        if (parama.AFL != null)
        {
          localObject1 = parama.AFL;
          if (this.lX == null)
          {
            this.zai.setVisibility(0);
            this.AGt.setVisibility(0);
            this.AGt.setImageBitmap((Bitmap)localObject1);
          }
        }
      }
      boolean bool;
      c.a.a locala;
      if (parama.AGn)
      {
        localObject1 = parama.AFL;
        localObject4 = parama.AFO;
        localObject3 = parama.AFP;
        localObject5 = View.inflate(this.mContext, 2130969198, null);
        if (localObject1 != null)
        {
          localObject6 = (ImageView)((View)localObject5).findViewById(2131822985);
          ((ImageView)localObject6).setVisibility(0);
          ((ImageView)localObject6).setImageBitmap((Bitmap)localObject1);
        }
        if (localObject4 != null)
        {
          localObject6 = (TextView)((View)localObject5).findViewById(2131822986);
          ((TextView)localObject6).setVisibility(0);
          localObject1 = localObject4;
          if (this.AGF != null) {
            localObject1 = this.AGF.a(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
          }
          ((TextView)localObject6).setText((CharSequence)localObject1);
        }
        if (localObject3 != null)
        {
          localObject4 = (TextView)((View)localObject5).findViewById(2131822987);
          ((TextView)localObject4).setVisibility(0);
          if (this.AGF == null) {
            break label2662;
          }
          localObject1 = this.AGF.a(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
          ((TextView)localObject4).setText((CharSequence)localObject1);
        }
        as((View)localObject5, -1);
        if ((parama.AFC != null) || (parama.AFD != null))
        {
          localObject6 = parama.AFC;
          localObject4 = parama.AFD;
          bool = parama.AFE;
          localObject5 = parama.AFG;
          locala = parama.AFH;
          this.AGw.setLayoutResource(2130969208);
          localObject1 = null;
        }
      }
      try
      {
        localObject3 = (LinearLayout)this.AGw.inflate();
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
          this.AGw.setVisibility(0);
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
              ((ImageView)localObject2).setImageResource(2131231988);
            }
            else if (i2 == 2)
            {
              ((ImageView)localObject2).setImageResource(2131232155);
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
        localObject3 = (ImageView)((LinearLayout)localObject1).findViewById(2131823006);
        ((ImageView)localObject3).setVisibility(0);
        if (locala != null) {
          locala.v((ImageView)localObject3, (String)localObject6);
        }
      }
      if ((localObject1 != null) && (localObject4 != null))
      {
        localObject6 = (TextView)((LinearLayout)localObject1).findViewById(2131823007);
        ((TextView)localObject6).setVisibility(0);
        localObject3 = localObject4;
        if (this.AGF != null) {
          localObject3 = this.AGF.a(((CharSequence)localObject4).toString(), this.jhF.getTextSize());
        }
        ((TextView)localObject6).setText((CharSequence)localObject3);
      }
      if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
      {
        localObject3 = (ImageView)((LinearLayout)localObject1).findViewById(2131823008);
        ((ImageView)localObject3).setVisibility(0);
        QY(0);
        ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(112605);
            if (this.AGH != null) {
              this.AGH.dnx();
            }
            if (this.AGI.isSelected())
            {
              c.c(c.this).startAnimation(c.b(c.this));
              c.b(c.this).setAnimationListener(new Animation.AnimationListener()
              {
                public final void onAnimationEnd(Animation paramAnonymous2Animation)
                {
                  AppMethodBeat.i(112602);
                  c.c(c.this).setVisibility(8);
                  c.a(c.this, 0);
                  AppMethodBeat.o(112602);
                }
                
                public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                
                public final void onAnimationStart(Animation paramAnonymous2Animation)
                {
                  AppMethodBeat.i(112601);
                  c.a(c.this, c.d(c.this));
                  AppMethodBeat.o(112601);
                }
              });
              ObjectAnimator.ofFloat(this.AGI, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
              this.AGI.setSelected(false);
              AppMethodBeat.o(112605);
              return;
            }
            c.c(c.this).startAnimation(c.e(c.this));
            c.e(c.this).setAnimationListener(new Animation.AnimationListener()
            {
              public final void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(112604);
                c.c(c.this).setVisibility(0);
                c.a(c.this, 8);
                AppMethodBeat.o(112604);
              }
              
              public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public final void onAnimationStart(Animation paramAnonymous2Animation)
              {
                AppMethodBeat.i(112603);
                c.a(c.this, c.f(c.this));
                AppMethodBeat.o(112603);
              }
            });
            ObjectAnimator.ofFloat(this.AGI, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
            this.AGI.setSelected(true);
            AppMethodBeat.o(112605);
          }
        });
      }
      if (parama.AFI != null) {
        b(parama.AFI);
      }
      if ((parama.AFM != null) && (!parama.AFM.isRecycled()))
      {
        localObject3 = parama.AFM;
        bool = parama.AFX;
        i2 = parama.AGi;
        if (localObject3 != null)
        {
          rC(false);
          this.zai.setVisibility(0);
          this.zai.setGravity(1);
          this.zai.setPadding(0, 0, 0, 0);
          localObject5 = View.inflate(this.mContext, 2130969200, null);
          localObject6 = (ImageView)((View)localObject5).findViewById(2131822985);
          if (!bool) {
            break label2648;
          }
          i = ((Bitmap)localObject3).getWidth();
          j = ((Bitmap)localObject3).getHeight();
          localObject4 = null;
          f = j / i;
          n = 0;
          m = 0;
          i1 = al.ap(this.mContext, 2131427567);
          i = al.ap(this.mContext, 2131427566);
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
          localObject1 = ai.d((Bitmap)localObject1, al.fromDPToPix(this.mContext, 3));
          ((ImageView)localObject6).setImageBitmap((Bitmap)localObject1);
          localObject1 = (ImageView)((View)localObject5).findViewById(2131822988);
          if (i2 != 0) {
            break label2596;
          }
          ((ImageView)localObject1).setVisibility(8);
          as((View)localObject5, -2);
        }
      }
      if ((parama.AFy != null) && (parama.AFy.length() > 0))
      {
        localObject1 = parama.AFy;
        if (localObject1 != null)
        {
          this.AGs.setVisibility(0);
          this.AGs.setText((CharSequence)localObject1);
        }
        this.AGA = true;
        i = parama.AGh;
        if (this.AGs != null) {
          this.AGs.setGravity(i);
        }
      }
      if ((parama.AFz != null) && (parama.AFz.length() > 0))
      {
        localObject1 = parama.AFz;
        this.mEditText.setVisibility(0);
        this.mEditText.setHint((CharSequence)localObject1);
      }
      if ((parama.AFA != null) && (parama.AFA.length() > 0))
      {
        localObject1 = parama.AFA;
        this.VR.setVisibility(0);
        this.VR.setText((CharSequence)localObject1);
      }
      if (parama.AFB)
      {
        this.needEdit = parama.AFB;
        if (parama.AFB) {
          this.mEditText.setVisibility(0);
        }
      }
      else
      {
        if ((parama.AFQ != null) && (parama.AFQ.length() > 0)) {
          a(parama.AFQ, parama.AGm, parama.AFY);
        }
        if ((parama.AFR != null) && (parama.AFR.length() > 0)) {
          b(parama.AFR, true, parama.AFZ);
        }
        if (parama.AGl != 0) {
          QZ(parama.AGl);
        }
        if (parama.AGk != 0) {
          Ra(parama.AGk);
        }
        if (parama.NW != null) {
          setOnCancelListener(parama.NW);
        }
        if (parama.NX != null)
        {
          this.AGG = parama.NX;
          setOnDismissListener(parama.NX);
        }
        if (parama.AFJ != null) {
          this.AGF = parama.AFJ;
        }
        setCancelable(parama.gKc);
        this.gKc = parama.gKc;
        if (!this.gKc) {
          super.setCancelable(parama.AFV);
        }
        if ((parama.AFS != null) || (parama.AFT != null) || (parama.AFU != null))
        {
          localObject1 = View.inflate(this.mContext, 2130969207, null);
          localObject3 = (Button)((View)localObject1).findViewById(2131823003);
          localObject4 = (Button)((View)localObject1).findViewById(2131823004);
          localObject5 = (Button)((View)localObject1).findViewById(2131823005);
          if (parama.AFS != null)
          {
            ((Button)localObject3).setVisibility(0);
            ((Button)localObject3).setText(parama.AFS);
            ((Button)localObject3).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112610);
                if (parama.AGa != null) {
                  parama.AGa.onClick(c.this, -1);
                }
                c.this.dismiss();
                AppMethodBeat.o(112610);
              }
            });
          }
          if (parama.AFT != null)
          {
            ((Button)localObject4).setVisibility(0);
            ((Button)localObject4).setText(parama.AFT);
            ((Button)localObject4).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112611);
                if (parama.AGb != null) {
                  parama.AGb.onClick(c.this, -2);
                }
                c.this.dismiss();
                AppMethodBeat.o(112611);
              }
            });
          }
          if (parama.AFU != null)
          {
            ((Button)localObject5).setVisibility(0);
            ((Button)localObject5).setText(parama.AFU);
            ((Button)localObject5).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112612);
                if (parama.AGc != null) {
                  parama.AGc.onClick(c.this, -3);
                }
                c.this.dismiss();
                AppMethodBeat.o(112612);
              }
            });
          }
          a((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
        }
        if (parama.AFF)
        {
          localObject1 = View.inflate(this.mContext, 2130969194, null);
          this.mkS = ((Button)((View)localObject1).findViewById(2131822980));
          this.usy = ((Button)((View)localObject1).findViewById(2131822981));
          if (parama.AGl != 0) {
            QZ(parama.AGl);
          }
          if (parama.AGk != 0) {
            Ra(parama.AGk);
          }
          if ((parama.AFQ != null) && (parama.AFQ.length() > 0)) {
            a(parama.AFQ, parama.AGm, parama.AFY);
          }
          if ((parama.AFR != null) && (parama.AFR.length() > 0)) {
            b(parama.AFR, true, parama.AFZ);
          }
          a((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(112642);
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
        this.AGw.setVisibility(0);
        Object localObject2 = null;
        continue;
        label2278:
        rC(false);
        continue;
        label2596:
        if (parama.AGo)
        {
          localObject2 = parama.AFL;
          localObject4 = parama.AFO;
          localObject3 = parama.AFP;
          localObject5 = View.inflate(this.mContext, 2130969199, null);
          if (localObject2 != null)
          {
            localObject6 = (ImageView)((View)localObject5).findViewById(2131822985);
            ((ImageView)localObject6).setVisibility(0);
            ((ImageView)localObject6).setImageBitmap((Bitmap)localObject2);
          }
          if (localObject4 != null)
          {
            localObject6 = (TextView)((View)localObject5).findViewById(2131822986);
            ((TextView)localObject6).setVisibility(0);
            localObject2 = localObject4;
            if (this.AGF != null) {
              localObject2 = this.AGF.a(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
            }
            ((TextView)localObject6).setText((CharSequence)localObject2);
          }
          if (localObject3 != null)
          {
            localObject4 = (TextView)((View)localObject5).findViewById(2131822987);
            ((TextView)localObject4).setVisibility(0);
            if (this.AGF != null)
            {
              localObject2 = this.AGF.a(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
              ((TextView)localObject4).setText((CharSequence)localObject2);
            }
          }
          else
          {
            as((View)localObject5, -1);
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
    AppMethodBeat.i(112633);
    if (this.usy == null)
    {
      AppMethodBeat.o(112633);
      return;
    }
    this.usy.setVisibility(0);
    this.usy.setText(paramCharSequence);
    this.usy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112608);
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(c.this, -1);
        }
        if (paramBoolean) {
          c.this.dismiss();
        }
        AppMethodBeat.o(112608);
      }
    });
    AppMethodBeat.o(112633);
  }
  
  public final void b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(112638);
    b(this.mContext.getString(paramInt), true, paramOnClickListener);
    AppMethodBeat.o(112638);
  }
  
  public final void b(final c.a.b paramb)
  {
    AppMethodBeat.i(139657);
    if ((this.zai != null) && (this.zai.getVisibility() == 0))
    {
      this.zai.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(112606);
          if (paramb != null) {
            paramb.byw();
          }
          AppMethodBeat.o(112606);
        }
      });
      AppMethodBeat.o(139657);
      return;
    }
    if (this.zaj != null) {
      this.zaj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(112607);
          if (paramb != null) {
            paramb.byw();
          }
          AppMethodBeat.o(112607);
        }
      });
    }
    AppMethodBeat.o(139657);
  }
  
  public final void b(CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(112637);
    if (this.mkS == null)
    {
      AppMethodBeat.o(112637);
      return;
    }
    this.mkS.setVisibility(0);
    this.mkS.setText(paramCharSequence);
    this.mkS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112609);
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(c.this, -2);
        }
        if (paramBoolean) {
          c.this.cancel();
        }
        AppMethodBeat.o(112609);
      }
    });
    AppMethodBeat.o(112637);
  }
  
  public final String dOY()
  {
    AppMethodBeat.i(112629);
    if (this.mEditText == null)
    {
      AppMethodBeat.o(112629);
      return null;
    }
    String str = this.mEditText.getText().toString();
    AppMethodBeat.o(112629);
    return str;
  }
  
  public final int dOZ()
  {
    AppMethodBeat.i(112630);
    if ((this.mEditText instanceof PasterEditText))
    {
      int i = ((PasterEditText)this.mEditText).getPasterLen();
      AppMethodBeat.o(112630);
      return i;
    }
    AppMethodBeat.o(112630);
    return 0;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(112644);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(112613);
          c.this.dismiss();
          AppMethodBeat.o(112613);
        }
      });
      ak.e("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
      AppMethodBeat.o(112644);
      return;
    }
    try
    {
      if ((this.mContext != null) && ((this.mContext instanceof Activity)))
      {
        if (((Activity)this.mContext).isFinishing()) {
          break label140;
        }
        super.dismiss();
        AppMethodBeat.o(112644);
        return;
      }
    }
    catch (Exception localException)
    {
      ak.e("MicroMsg.MMAlertDialog", "dismiss exception, e = " + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(112644);
      return;
    }
    super.dismiss();
    label140:
    AppMethodBeat.o(112644);
  }
  
  public final Button getButton(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case -1: 
      return this.usy;
    }
    return this.mkS;
  }
  
  public View getContentView()
  {
    return this.zaf;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112623);
    super.onCreate(paramBundle);
    setContentView(this.zaf);
    AppMethodBeat.o(112623);
  }
  
  public final void rD(boolean paramBoolean)
  {
    AppMethodBeat.i(112640);
    super.setCancelable(paramBoolean);
    AppMethodBeat.o(112640);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(112639);
    super.setCancelable(paramBoolean);
    this.gKc = paramBoolean;
    setCanceledOnTouchOutside(this.gKc);
    AppMethodBeat.o(112639);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(112627);
    this.zai.setVisibility(0);
    this.zag.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.AGF != null)
    {
      localObject = this.AGF;
      this.zag.getContext();
      localObject = ((c.a.d)localObject).a(paramCharSequence.toString(), this.zag.getTextSize());
    }
    this.zag.setText((CharSequence)localObject);
    AppMethodBeat.o(112627);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(112625);
    this.AGv.setVisibility(0);
    this.jhF.setVisibility(0);
    this.jhF.setMaxLines(2);
    this.jhF.setText(paramInt);
    this.jhF.getPaint().setFakeBoldText(true);
    dCo();
    AppMethodBeat.o(112625);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(112624);
    this.AGv.setVisibility(0);
    this.jhF.setVisibility(0);
    CharSequence localCharSequence = paramCharSequence;
    if (this.AGF != null) {
      localCharSequence = this.AGF.a(paramCharSequence.toString(), this.jhF.getTextSize());
    }
    this.jhF.setMaxLines(2);
    this.jhF.setText(localCharSequence);
    this.jhF.getPaint().setFakeBoldText(true);
    dCo();
    AppMethodBeat.o(112624);
  }
  
  public void show()
  {
    AppMethodBeat.i(112643);
    try
    {
      super.show();
      AppMethodBeat.o(112643);
      return;
    }
    catch (Exception localException)
    {
      ak.printErrStackTrace("MicroMsg.MMAlertDialog", localException, "", new Object[0]);
      AppMethodBeat.o(112643);
    }
  }
  
  public static class a
  {
    public a AGP;
    public Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(112614);
      this.mContext = paramContext;
      this.AGP = new a();
      AppMethodBeat.o(112614);
    }
    
    public final a Rb(int paramInt)
    {
      AppMethodBeat.i(112615);
      this.AGP.title = this.mContext.getString(paramInt);
      AppMethodBeat.o(112615);
      return this;
    }
    
    public final a Rc(int paramInt)
    {
      this.AGP.vOR = paramInt;
      return this;
    }
    
    public final a Rd(int paramInt)
    {
      this.AGP.AGf = paramInt;
      return this;
    }
    
    public final a Re(int paramInt)
    {
      this.AGP.zrv = paramInt;
      return this;
    }
    
    public final a Rf(int paramInt)
    {
      AppMethodBeat.i(112616);
      this.AGP.AFN = this.mContext.getString(paramInt);
      AppMethodBeat.o(112616);
      return this;
    }
    
    public final a Rg(int paramInt)
    {
      this.AGP.AGg = paramInt;
      return this;
    }
    
    public final a Rh(int paramInt)
    {
      this.AGP.AGh = paramInt;
      return this;
    }
    
    public final a Ri(int paramInt)
    {
      AppMethodBeat.i(112618);
      this.AGP.AFQ = this.mContext.getString(paramInt);
      AppMethodBeat.o(112618);
      return this;
    }
    
    public final a Rj(int paramInt)
    {
      AppMethodBeat.i(112619);
      this.AGP.AFR = this.mContext.getString(paramInt);
      AppMethodBeat.o(112619);
      return this;
    }
    
    public final a Rk(int paramInt)
    {
      this.AGP.AGl = paramInt;
      return this;
    }
    
    public final a Rl(int paramInt)
    {
      this.AGP.AGk = paramInt;
      return this;
    }
    
    public final a a(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.AGP.AFY = paramOnClickListener;
      return this;
    }
    
    public final a a(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.AGP.NX = paramOnDismissListener;
      return this;
    }
    
    public final a a(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
    {
      this.AGP.AFM = paramBitmap;
      this.AGP.AFX = paramBoolean;
      this.AGP.AGi = paramInt;
      return this;
    }
    
    public final a a(d paramd)
    {
      this.AGP.AFJ = paramd;
      return this;
    }
    
    public final a a(String paramString, CharSequence paramCharSequence, Boolean paramBoolean, c paramc, a parama)
    {
      AppMethodBeat.i(112617);
      this.AGP.AFC = paramString;
      this.AGP.AFD = paramCharSequence;
      this.AGP.AFE = paramBoolean.booleanValue();
      this.AGP.AFG = paramc;
      this.AGP.AFH = parama;
      AppMethodBeat.o(112617);
      return this;
    }
    
    public final a a(boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.AGP.AFY = paramOnClickListener;
      this.AGP.AGm = paramBoolean;
      return this;
    }
    
    public c aLZ()
    {
      AppMethodBeat.i(112620);
      c localc = new c(this.mContext);
      localc.a(this.AGP);
      AppMethodBeat.o(112620);
      return localc;
    }
    
    public final a ag(CharSequence paramCharSequence)
    {
      this.AGP.title = paramCharSequence;
      return this;
    }
    
    public final a ah(CharSequence paramCharSequence)
    {
      this.AGP.AFx = paramCharSequence;
      return this;
    }
    
    public final a ai(CharSequence paramCharSequence)
    {
      this.AGP.AFO = paramCharSequence;
      return this;
    }
    
    public final a ar(Bitmap paramBitmap)
    {
      this.AGP.AFL = paramBitmap;
      return this;
    }
    
    public final a avm(String paramString)
    {
      this.AGP.title = paramString;
      return this;
    }
    
    public final a avn(String paramString)
    {
      this.AGP.AFN = paramString;
      return this;
    }
    
    public final a avo(String paramString)
    {
      this.AGP.thumbPath = paramString;
      return this;
    }
    
    public final a avp(String paramString)
    {
      this.AGP.AFy = paramString;
      return this;
    }
    
    public final a avq(String paramString)
    {
      this.AGP.AFz = paramString;
      return this;
    }
    
    public final a avr(String paramString)
    {
      this.AGP.AFA = paramString;
      return this;
    }
    
    public final a avs(String paramString)
    {
      this.AGP.AFQ = paramString;
      return this;
    }
    
    public final a avt(String paramString)
    {
      this.AGP.AFR = paramString;
      return this;
    }
    
    public final a b(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.AGP.AFZ = paramOnClickListener;
      return this;
    }
    
    public final a c(b paramb)
    {
      this.AGP.AFI = paramb;
      return this;
    }
    
    public final a e(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.AGP.NW = paramOnCancelListener;
      return this;
    }
    
    public final a fu(View paramView)
    {
      this.AGP.veX = paramView;
      return this;
    }
    
    public final a rE(boolean paramBoolean)
    {
      this.AGP.AFW = paramBoolean;
      return this;
    }
    
    public final a rF(boolean paramBoolean)
    {
      this.AGP.AFB = paramBoolean;
      return this;
    }
    
    public final a rG(boolean paramBoolean)
    {
      this.AGP.gKc = paramBoolean;
      return this;
    }
    
    public final a rH(boolean paramBoolean)
    {
      this.AGP.AFV = paramBoolean;
      return this;
    }
    
    public final void show()
    {
      AppMethodBeat.i(156752);
      aLZ().show();
      AppMethodBeat.o(156752);
    }
    
    public static abstract interface a
    {
      public abstract void v(ImageView paramImageView, String paramString);
    }
    
    public static abstract interface b
    {
      public abstract void byw();
    }
    
    public static abstract interface c
    {
      public abstract void dnx();
    }
    
    public static abstract interface d
    {
      public abstract CharSequence a(CharSequence paramCharSequence, float paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.c
 * JD-Core Version:    0.7.0.1
 */