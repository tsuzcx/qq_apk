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
import com.tencent.mm.ck.a.j;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdcard_migrate.f.a;
import com.tencent.mm.sdcard_migrate.f.b;
import com.tencent.mm.sdcard_migrate.f.c;
import com.tencent.mm.sdcard_migrate.f.d;
import com.tencent.mm.sdcard_migrate.f.e;
import com.tencent.mm.ui.bc;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.a.d;

public final class c
  extends Dialog
  implements DialogInterface
{
  private Button BoW;
  private Button SJn;
  private View acrA;
  private boolean acrB;
  private Animation acrC;
  private Animation acrD;
  private Animation acrE;
  private Animation acrF;
  public c.a.c acrG;
  private DialogInterface.OnDismissListener acrH;
  private LinearLayout acrm;
  private TextView acrn;
  public TextView acro;
  public TextView acrp;
  private TextView acrq;
  private TextView acrr;
  private TextView acrs;
  private ImageView acrt;
  private View acru;
  private ViewStub acrv;
  public LinearLayout acrw;
  private ViewGroup acrx;
  private LinearLayout acry;
  private ViewGroup acrz;
  private boolean dqR;
  d iOnDialogDismissListener;
  private Context mContext;
  private EditText mEditText;
  private boolean needEdit;
  private View oW;
  private TextView pIp;
  private LinearLayout tsG;
  
  public c(Context paramContext)
  {
    super(paramContext, a.j.mmalertdialog);
    AppMethodBeat.i(257249);
    this.acrB = false;
    this.needEdit = false;
    this.mContext = paramContext;
    this.acrm = ((LinearLayout)View.inflate(this.mContext, f.e.mm_alert_comfirm_no_svg, null));
    this.BoW = ((Button)this.acrm.findViewById(f.d.mm_alert_ok_btn));
    this.SJn = ((Button)this.acrm.findViewById(f.d.mm_alert_cancel_btn));
    this.pIp = ((TextView)this.acrm.findViewById(f.d.mm_alert_title));
    this.acrn = ((TextView)this.acrm.findViewById(f.d.mm_alert_title_desc));
    this.acro = ((TextView)this.acrm.findViewById(f.d.mm_alert_msg));
    this.acrp = ((TextView)this.acrm.findViewById(f.d.mm_alert_msg2));
    this.acrq = ((TextView)this.acrm.findViewById(f.d.mm_alert_msg_subtitle));
    this.acrr = ((TextView)this.acrm.findViewById(f.d.mm_alert_msg_subdesc));
    this.acrs = ((TextView)this.acrm.findViewById(f.d.confirm_dialog_content_desc_tv));
    this.mEditText = ((EditText)this.acrm.findViewById(f.d.confirm_dialog_text_et));
    this.acrt = ((ImageView)this.acrm.findViewById(f.d.mm_alert_msg_icon));
    this.tsG = ((LinearLayout)this.acrm.findViewById(f.d.mm_alert_title_area));
    this.acrv = ((ViewStub)this.acrm.findViewById(f.d.title_image_ll));
    this.acrw = ((LinearLayout)this.acrm.findViewById(f.d.mm_alert_msg_area));
    this.acrx = ((ViewGroup)this.acrm.findViewById(f.d.mm_alert_bottom_view));
    this.acrA = this.acrm.findViewById(f.d.mm_alert_button_view);
    this.acry = ((LinearLayout)this.acrm.findViewById(f.d.mm_alert_custom_area));
    this.acrz = ((ViewGroup)this.acrm.findViewById(f.d.title_image_detail_area));
    setCanceledOnTouchOutside(true);
    this.acrC = AnimationUtils.loadAnimation(this.mContext, f.a.alpha_in);
    this.acrD = AnimationUtils.loadAnimation(this.mContext, f.a.alpha_in);
    this.acrE = AnimationUtils.loadAnimation(this.mContext, f.a.alpha_out);
    this.acrF = AnimationUtils.loadAnimation(this.mContext, f.a.alpha_out);
    AppMethodBeat.o(257249);
  }
  
  private void KA(boolean paramBoolean)
  {
    AppMethodBeat.i(257256);
    if (paramBoolean)
    {
      int i = bd.fromDPToPix(this.mContext, 8);
      this.acrw.setVisibility(0);
      this.acrw.setPadding(i, i, i, i);
      this.acrw.setBackgroundResource(f.c.dialog_content_background);
    }
    AppMethodBeat.o(257256);
  }
  
  private void a(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(257275);
    if (this.SJn != null)
    {
      this.SJn.setVisibility(0);
      this.SJn.setText(paramCharSequence);
      this.SJn.setOnClickListener(new c.5(this, paramOnClickListener));
    }
    AppMethodBeat.o(257275);
  }
  
  private void a(CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(257268);
    if (this.BoW == null)
    {
      AppMethodBeat.o(257268);
      return;
    }
    this.BoW.setVisibility(0);
    this.BoW.setText(paramCharSequence);
    this.BoW.setOnClickListener(new c.4(this, paramOnClickListener, paramBoolean));
    AppMethodBeat.o(257268);
  }
  
  private void ayg(int paramInt)
  {
    AppMethodBeat.i(257254);
    if (this.acro != null) {
      this.acro.setTextColor(paramInt);
    }
    AppMethodBeat.o(257254);
  }
  
  private void ayh(int paramInt)
  {
    AppMethodBeat.i(257259);
    if (this.acrw != null) {
      this.acrw.setVisibility(paramInt);
    }
    if (this.acry != null) {
      this.acry.setVisibility(paramInt);
    }
    if ((this.acrs != null) && (this.acrB)) {
      this.acrs.setVisibility(paramInt);
    }
    if (this.mEditText != null)
    {
      if (!this.needEdit)
      {
        this.mEditText.setVisibility(8);
        AppMethodBeat.o(257259);
        return;
      }
      this.mEditText.setVisibility(paramInt);
    }
    AppMethodBeat.o(257259);
  }
  
  private void ayi(int paramInt)
  {
    AppMethodBeat.i(257270);
    this.BoW.setTextColor(paramInt);
    AppMethodBeat.o(257270);
  }
  
  private void ayj(int paramInt)
  {
    AppMethodBeat.i(257273);
    this.SJn.setTextColor(paramInt);
    AppMethodBeat.o(257273);
  }
  
  private void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(257277);
    this.acrA.setVisibility(8);
    this.acrx.removeAllViews();
    this.acrx.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(257277);
  }
  
  private void kT(View paramView)
  {
    AppMethodBeat.i(257262);
    this.oW = paramView;
    if (this.oW != null)
    {
      this.acrw.setVisibility(0);
      this.acry.setVisibility(0);
      this.acry.removeAllViews();
      this.acry.setGravity(1);
      this.acry.addView(this.oW, new LinearLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(257262);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(257290);
    int i;
    if ((parama.title != null) && (parama.title.length() > 0))
    {
      i = parama.acre;
      if (this.pIp != null) {
        this.pIp.setGravity(i);
      }
      setTitle(parama.title);
    }
    Object localObject4;
    Object localObject1;
    if ((parama.acqw != null) && (parama.acqw.length() > 0))
    {
      localObject4 = parama.acqw;
      this.tsG.setVisibility(0);
      this.acrn.setVisibility(0);
      localObject1 = localObject4;
      if (this.acrG != null)
      {
        localObject1 = this.acrG;
        ((CharSequence)localObject4).toString();
        this.pIp.getTextSize();
        localObject1 = ((c.a.c)localObject1).iTr();
      }
      this.acrn.setText((CharSequence)localObject1);
    }
    if (parama.XXf != 0)
    {
      i = parama.XXf;
      this.pIp.setTextColor(ColorStateList.valueOf(i));
    }
    if (parama.acrb != 0)
    {
      i = parama.acrb;
      this.pIp.setMaxLines(i);
    }
    if (parama.acrc != 0)
    {
      i = parama.acrc;
      this.acro.setMaxLines(i);
    }
    if (parama.dyK != null) {
      kT(parama.dyK);
    }
    if (parama.acqZ != null)
    {
      localObject4 = parama.acqZ;
      this.tsG.setVisibility(0);
      this.acrv.setLayoutResource(f.e.confirm_dialog_custom_title);
    }
    try
    {
      localObject1 = (LinearLayout)this.acrv.inflate();
      ((LinearLayout)localObject1).addView((View)localObject4);
      if (parama.acra != null)
      {
        this.acru = parama.acra;
        if (this.acru != null)
        {
          this.acrw.setVisibility(8);
          this.acrs.setVisibility(8);
          this.mEditText.setVisibility(8);
          this.acrz.removeAllViews();
          this.acrz.addView(this.acru, new LinearLayout.LayoutParams(-1, -1));
          this.acrz.setVisibility(8);
        }
      }
      if (parama.acqH != null)
      {
        localObject1 = parama.acqH;
        if (this.oW == null)
        {
          this.acrw.setVisibility(0);
          this.acrt.setVisibility(0);
          this.acrt.setBackgroundDrawable((Drawable)localObject1);
        }
      }
      if ((parama.acqJ != null) && (parama.acqJ.length() > 0)) {
        setMessage(parama.acqJ);
      }
      KA(parama.acqS);
      if (parama.thumbPath != null)
      {
        localObject1 = parama.thumbPath;
        i = bd.fromDPToPix(this.mContext, 120);
        this.acrw.setVisibility(0);
        this.acrt.setVisibility(0);
        if ((this.acrt instanceof com.tencent.mm.ui.i.a)) {
          ((com.tencent.mm.ui.i.a)this.acrt).aW((String)localObject1, i, i);
        }
        i = parama.acrg;
        this.acrw.setVisibility(i);
        this.acrt.setVisibility(i);
      }
      if ((!parama.acrk) && (!parama.acrl))
      {
        if ((parama.acqJ != null) && (parama.acqJ.length() > 0)) {
          setMessage(parama.acqJ);
        }
        if ((parama.acqK == null) || (parama.acqK.length() <= 0)) {
          break label1955;
        }
        localObject1 = parama.acqK;
        this.acrw.setVisibility(0);
        this.acrq.setVisibility(0);
        this.acrq.setMaxLines(2);
        this.acrq.setText((CharSequence)localObject1);
        if ((parama.acqL != null) && (parama.acqL.length() > 0))
        {
          localObject4 = parama.acqL;
          if (localObject4 != null)
          {
            this.acrw.setVisibility(0);
            this.acrr.setVisibility(0);
            localObject1 = localObject4;
            if (this.acrG != null)
            {
              localObject1 = this.acrG;
              this.acrr.getContext();
              ((CharSequence)localObject4).toString();
              this.acrr.getTextSize();
              localObject1 = ((c.a.c)localObject1).iTr();
            }
            this.acrr.setText((CharSequence)localObject1);
          }
        }
        if (parama.acqI != null)
        {
          localObject1 = parama.acqI;
          if (this.oW == null)
          {
            this.acrw.setVisibility(0);
            this.acrt.setVisibility(0);
            this.acrt.setImageBitmap((Bitmap)localObject1);
          }
        }
      }
      if (parama.acrk)
      {
        localObject1 = parama.acqI;
        localObject5 = parama.acqK;
        localObject4 = parama.acqL;
        localObject6 = View.inflate(this.mContext, f.e.confirm_dialog_icon_left, null);
        if (localObject1 != null)
        {
          localObject7 = (ImageView)((View)localObject6).findViewById(f.d.mm_alert_msg_icon);
          ((ImageView)localObject7).setVisibility(0);
          ((ImageView)localObject7).setImageBitmap((Bitmap)localObject1);
        }
        if (localObject5 != null)
        {
          localObject7 = (TextView)((View)localObject6).findViewById(f.d.mm_alert_msg_subtitle);
          ((TextView)localObject7).setVisibility(0);
          localObject1 = localObject5;
          if (this.acrG != null)
          {
            localObject1 = this.acrG;
            ((CharSequence)localObject5).toString();
            ((TextView)localObject7).getTextSize();
            localObject1 = ((c.a.c)localObject1).iTr();
          }
          ((TextView)localObject7).setText((CharSequence)localObject1);
        }
        if (localObject4 != null)
        {
          localObject5 = (TextView)((View)localObject6).findViewById(f.d.mm_alert_msg_subdesc);
          ((TextView)localObject5).setVisibility(0);
          if (this.acrG == null) {
            break label2241;
          }
          localObject1 = this.acrG;
          ((CharSequence)localObject4).toString();
          ((TextView)localObject5).getTextSize();
          localObject1 = ((c.a.c)localObject1).iTr();
          ((TextView)localObject5).setText((CharSequence)localObject1);
        }
        kT((View)localObject6);
        if ((parama.acqA != null) || (parama.acqB != null))
        {
          localObject4 = parama.acqA;
          localObject5 = parama.acqB;
          bool = parama.acqC;
          localObject6 = parama.acqE;
          this.acrv.setLayoutResource(f.e.confirm_dialog_title_image);
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
          localObject1 = (LinearLayout)this.acrv.inflate();
          if ((localObject1 != null) && (localObject4 != null)) {
            ((ImageView)((LinearLayout)localObject1).findViewById(f.d.title_image)).setVisibility(0);
          }
          if ((localObject1 != null) && (localObject5 != null))
          {
            localObject7 = (TextView)((LinearLayout)localObject1).findViewById(f.d.title_text);
            ((TextView)localObject7).setVisibility(0);
            localObject4 = localObject5;
            if (this.acrG != null)
            {
              localObject4 = this.acrG;
              ((CharSequence)localObject5).toString();
              this.pIp.getTextSize();
              localObject4 = ((c.a.c)localObject4).iTr();
            }
            ((TextView)localObject7).setText((CharSequence)localObject4);
          }
          if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
          {
            localObject4 = (ImageView)((LinearLayout)localObject1).findViewById(f.d.image_title_detail_icon);
            ((ImageView)localObject4).setVisibility(0);
            ayh(0);
            ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(257215);
                b localb = new b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                if (this.acrJ.isSelected())
                {
                  c.b(c.this).startAnimation(c.a(c.this));
                  c.a(c.this).setAnimationListener(new Animation.AnimationListener()
                  {
                    public final void onAnimationEnd(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(257234);
                      c.b(c.this).setVisibility(8);
                      c.a(c.this, 0);
                      AppMethodBeat.o(257234);
                    }
                    
                    public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                    
                    public final void onAnimationStart(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(257228);
                      c.a(c.this, c.c(c.this));
                      AppMethodBeat.o(257228);
                    }
                  });
                  ObjectAnimator.ofFloat(this.acrJ, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
                  this.acrJ.setSelected(false);
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(257215);
                  return;
                  c.b(c.this).startAnimation(c.d(c.this));
                  c.d(c.this).setAnimationListener(new Animation.AnimationListener()
                  {
                    public final void onAnimationEnd(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(257235);
                      c.b(c.this).setVisibility(0);
                      c.a(c.this, 8);
                      AppMethodBeat.o(257235);
                    }
                    
                    public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                    
                    public final void onAnimationStart(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(257229);
                      c.a(c.this, c.e(c.this));
                      AppMethodBeat.o(257229);
                    }
                  });
                  ObjectAnimator.ofFloat(this.acrJ, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
                  this.acrJ.setSelected(true);
                }
              }
            });
          }
          if (parama.acqF != null)
          {
            localObject1 = parama.acqF;
            if ((this.acrw != null) && (this.acrw.getVisibility() == 0)) {
              this.acrw.setOnClickListener(new c.2(this, (c.a.a)localObject1));
            }
          }
          else
          {
            if ((parama.acqx != null) && (parama.acqx.length() > 0))
            {
              localObject1 = parama.acqx;
              if (localObject1 != null)
              {
                this.acrs.setVisibility(0);
                this.acrs.setText((CharSequence)localObject1);
              }
              this.acrB = true;
              i = parama.acrd;
              if (this.acrs != null) {
                this.acrs.setGravity(i);
              }
            }
            if ((parama.acqy != null) && (parama.acqy.length() > 0))
            {
              localObject1 = parama.acqy;
              this.mEditText.setVisibility(0);
              this.mEditText.setHint((CharSequence)localObject1);
            }
            if (parama.acqz)
            {
              this.needEdit = parama.acqz;
              if (!parama.acqz) {
                continue;
              }
              this.mEditText.setVisibility(0);
            }
            if ((parama.acqM != null) && (parama.acqM.length() > 0)) {
              a(parama.acqM, parama.acrj, parama.acqU);
            }
            if ((parama.acqN != null) && (parama.acqN.length() > 0)) {
              a(parama.acqN, parama.acqV);
            }
            if (parama.acri != 0) {
              ayi(parama.acri);
            }
            if (parama.acrh != 0) {
              ayj(parama.acrh);
            }
            if (parama.mOnCancelListener != null) {
              setOnCancelListener(parama.mOnCancelListener);
            }
            if (parama.mOnDismissListener != null)
            {
              this.acrH = parama.mOnDismissListener;
              setOnDismissListener(parama.mOnDismissListener);
            }
            if (parama.acqG != null) {
              this.acrG = parama.acqG;
            }
            setCancelable(parama.dqR);
            this.dqR = parama.dqR;
            if (!this.dqR) {
              super.setCancelable(parama.acqR);
            }
            if ((parama.acqO != null) || (parama.acqP != null) || (parama.acqQ != null))
            {
              localObject1 = View.inflate(this.mContext, f.e.confirm_dialog_multi_btn, null);
              localObject4 = (Button)((View)localObject1).findViewById(f.d.mm_alert_btn_first);
              localObject5 = (Button)((View)localObject1).findViewById(f.d.mm_alert_btn_second);
              localObject6 = (Button)((View)localObject1).findViewById(f.d.mm_alert_btn_third);
              if (parama.acqO != null)
              {
                ((Button)localObject4).setVisibility(0);
                ((Button)localObject4).setText(parama.acqO);
                ((Button)localObject4).setOnClickListener(new c.6(this, parama));
              }
              if (parama.acqP != null)
              {
                ((Button)localObject5).setVisibility(0);
                ((Button)localObject5).setText(parama.acqP);
                ((Button)localObject5).setOnClickListener(new c.7(this, parama));
              }
              if (parama.acqQ != null)
              {
                ((Button)localObject6).setVisibility(0);
                ((Button)localObject6).setText(parama.acqQ);
                ((Button)localObject6).setOnClickListener(new c.8(this, parama));
              }
              b((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
            }
            if (parama.acqD)
            {
              localObject1 = View.inflate(this.mContext, f.e.confirm_dialog_btn_up_down, null);
              this.SJn = ((Button)((View)localObject1).findViewById(f.d.mm_alert_cancel_btn));
              this.BoW = ((Button)((View)localObject1).findViewById(f.d.mm_alert_ok_btn));
              if (parama.acri != 0) {
                ayi(parama.acri);
              }
              if (parama.acrh != 0) {
                ayj(parama.acrh);
              }
              if ((parama.acqM != null) && (parama.acqM.length() > 0)) {
                a(parama.acqM, parama.acrj, parama.acqU);
              }
              if ((parama.acqN != null) && (parama.acqN.length() > 0)) {
                a(parama.acqN, parama.acqV);
              }
              b((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
            }
            AppMethodBeat.o(257290);
            return;
            localException1 = localException1;
            this.acrv.setVisibility(0);
            Object localObject2 = null;
            continue;
            label1955:
            KA(false);
            continue;
            if (!parama.acrl) {
              continue;
            }
            localObject2 = parama.acqI;
            localObject5 = parama.acqK;
            localObject4 = parama.acqL;
            localObject6 = View.inflate(this.mContext, f.e.confirm_dialog_icon_right, null);
            if (localObject2 != null)
            {
              localObject7 = (ImageView)((View)localObject6).findViewById(f.d.mm_alert_msg_icon);
              ((ImageView)localObject7).setVisibility(0);
              ((ImageView)localObject7).setImageBitmap((Bitmap)localObject2);
            }
            if (localObject5 != null)
            {
              localObject7 = (TextView)((View)localObject6).findViewById(f.d.mm_alert_msg_subtitle);
              ((TextView)localObject7).setVisibility(0);
              localObject2 = localObject5;
              if (this.acrG != null)
              {
                localObject2 = this.acrG;
                ((CharSequence)localObject5).toString();
                ((TextView)localObject7).getTextSize();
                localObject2 = ((c.a.c)localObject2).iTr();
              }
              ((TextView)localObject7).setText((CharSequence)localObject2);
            }
            if (localObject4 != null)
            {
              localObject5 = (TextView)((View)localObject6).findViewById(f.d.mm_alert_msg_subdesc);
              ((TextView)localObject5).setVisibility(0);
              if (this.acrG == null) {
                continue;
              }
              localObject2 = this.acrG;
              ((CharSequence)localObject4).toString();
              ((TextView)localObject5).getTextSize();
              localObject2 = ((c.a.c)localObject2).iTr();
              ((TextView)localObject5).setText((CharSequence)localObject2);
            }
            kT((View)localObject6);
          }
        }
        catch (Exception localException2)
        {
          this.acrv.setVisibility(0);
          localObject3 = null;
          continue;
          if (this.acry == null) {
            continue;
          }
          this.acry.setOnClickListener(new c.3(this, (c.a.a)localObject3));
          continue;
          this.mEditText.setVisibility(8);
          continue;
          localObject3 = localObject4;
          continue;
        }
        label2241:
        Object localObject3 = localObject4;
      }
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(257292);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new c.9(this));
      bc.e("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
      AppMethodBeat.o(257292);
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
        AppMethodBeat.o(257292);
        return;
        super.dismiss();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bc.e("MicroMsg.MMAlertDialog", "dismiss exception, e = " + localException.getMessage(), new Object[0]);
      }
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(257284);
    super.onCreate(paramBundle);
    setContentView(this.acrm);
    AppMethodBeat.o(257284);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(257288);
    super.setCancelable(paramBoolean);
    this.dqR = paramBoolean;
    setCanceledOnTouchOutside(this.dqR);
    AppMethodBeat.o(257288);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(257287);
    this.acrw.setVisibility(0);
    this.acro.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.acrG != null)
    {
      localObject = this.acrG;
      this.acro.getContext();
      paramCharSequence.toString();
      this.acro.getTextSize();
      localObject = ((c.a.c)localObject).iTr();
    }
    this.acro.setText((CharSequence)localObject);
    AppMethodBeat.o(257287);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(257286);
    this.tsG.setVisibility(0);
    this.pIp.setVisibility(0);
    this.pIp.setMaxLines(2);
    this.pIp.setText(paramInt);
    this.pIp.getPaint().setFakeBoldText(true);
    ayg(this.mContext.getResources().getColor(f.b.FG_1));
    AppMethodBeat.o(257286);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(257285);
    this.tsG.setVisibility(0);
    this.pIp.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.acrG != null)
    {
      localObject = this.acrG;
      paramCharSequence.toString();
      this.pIp.getTextSize();
      localObject = ((c.a.c)localObject).iTr();
    }
    this.pIp.setMaxLines(2);
    this.pIp.setText((CharSequence)localObject);
    this.pIp.getPaint().setFakeBoldText(true);
    ayg(this.mContext.getResources().getColor(f.b.FG_1));
    AppMethodBeat.o(257285);
  }
  
  public final void show()
  {
    AppMethodBeat.i(257291);
    try
    {
      super.show();
      AppMethodBeat.o(257291);
      return;
    }
    catch (Exception localException)
    {
      bc.printErrStackTrace("MicroMsg.MMAlertDialog", localException, "", new Object[0]);
      AppMethodBeat.o(257291);
    }
  }
  
  public static abstract interface a$b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a.c
 * JD-Core Version:    0.7.0.1
 */