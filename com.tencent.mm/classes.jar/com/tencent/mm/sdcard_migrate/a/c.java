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
import com.tencent.mm.cr.a.j;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdcard_migrate.f.a;
import com.tencent.mm.sdcard_migrate.f.b;
import com.tencent.mm.sdcard_migrate.f.c;
import com.tencent.mm.sdcard_migrate.f.d;
import com.tencent.mm.sdcard_migrate.f.e;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.aw;

public final class c
  extends Dialog
  implements DialogInterface
{
  private Button MhR;
  private LinearLayout UWb;
  private TextView UWc;
  public TextView UWd;
  public TextView UWe;
  private TextView UWf;
  private TextView UWg;
  private TextView UWh;
  private ImageView UWi;
  private View UWj;
  private ViewStub UWk;
  public LinearLayout UWl;
  private ViewGroup UWm;
  private LinearLayout UWn;
  private ViewGroup UWo;
  private View UWp;
  private boolean UWq;
  private Animation UWr;
  private Animation UWs;
  private Animation UWt;
  private Animation UWu;
  public c.a.c UWv;
  private DialogInterface.OnDismissListener UWw;
  private boolean bxO;
  com.tencent.mm.ui.widget.a.c iOnDialogDismissListener;
  private Context mContext;
  private EditText mEditText;
  private TextView mLH;
  private View nX;
  private boolean needEdit;
  private LinearLayout qnZ;
  private Button xPd;
  
  public c(Context paramContext)
  {
    super(paramContext, a.j.mmalertdialog);
    AppMethodBeat.i(192070);
    this.UWq = false;
    this.needEdit = false;
    this.mContext = paramContext;
    this.UWb = ((LinearLayout)View.inflate(this.mContext, f.e.mm_alert_comfirm_no_svg, null));
    this.xPd = ((Button)this.UWb.findViewById(f.d.mm_alert_ok_btn));
    this.MhR = ((Button)this.UWb.findViewById(f.d.mm_alert_cancel_btn));
    this.mLH = ((TextView)this.UWb.findViewById(f.d.mm_alert_title));
    this.UWc = ((TextView)this.UWb.findViewById(f.d.mm_alert_title_desc));
    this.UWd = ((TextView)this.UWb.findViewById(f.d.mm_alert_msg));
    this.UWe = ((TextView)this.UWb.findViewById(f.d.mm_alert_msg2));
    this.UWf = ((TextView)this.UWb.findViewById(f.d.mm_alert_msg_subtitle));
    this.UWg = ((TextView)this.UWb.findViewById(f.d.mm_alert_msg_subdesc));
    this.UWh = ((TextView)this.UWb.findViewById(f.d.confirm_dialog_content_desc_tv));
    this.mEditText = ((EditText)this.UWb.findViewById(f.d.confirm_dialog_text_et));
    this.UWi = ((ImageView)this.UWb.findViewById(f.d.mm_alert_msg_icon));
    this.qnZ = ((LinearLayout)this.UWb.findViewById(f.d.mm_alert_title_area));
    this.UWk = ((ViewStub)this.UWb.findViewById(f.d.title_image_ll));
    this.UWl = ((LinearLayout)this.UWb.findViewById(f.d.mm_alert_msg_area));
    this.UWm = ((ViewGroup)this.UWb.findViewById(f.d.mm_alert_bottom_view));
    this.UWp = this.UWb.findViewById(f.d.mm_alert_button_view);
    this.UWn = ((LinearLayout)this.UWb.findViewById(f.d.mm_alert_custom_area));
    this.UWo = ((ViewGroup)this.UWb.findViewById(f.d.title_image_detail_area));
    setCanceledOnTouchOutside(true);
    this.UWr = AnimationUtils.loadAnimation(this.mContext, f.a.alpha_in);
    this.UWs = AnimationUtils.loadAnimation(this.mContext, f.a.alpha_in);
    this.UWt = AnimationUtils.loadAnimation(this.mContext, f.a.alpha_out);
    this.UWu = AnimationUtils.loadAnimation(this.mContext, f.a.alpha_out);
    AppMethodBeat.o(192070);
  }
  
  private void EO(boolean paramBoolean)
  {
    AppMethodBeat.i(192090);
    if (paramBoolean)
    {
      int i = aw.fromDPToPix(this.mContext, 8);
      this.UWl.setVisibility(0);
      this.UWl.setPadding(i, i, i, i);
      this.UWl.setBackgroundResource(f.c.dialog_content_background);
    }
    AppMethodBeat.o(192090);
  }
  
  private void a(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(192119);
    if (this.MhR != null)
    {
      this.MhR.setVisibility(0);
      this.MhR.setText(paramCharSequence);
      this.MhR.setOnClickListener(new c.5(this, paramOnClickListener));
    }
    AppMethodBeat.o(192119);
  }
  
  private void a(CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(192110);
    if (this.xPd == null)
    {
      AppMethodBeat.o(192110);
      return;
    }
    this.xPd.setVisibility(0);
    this.xPd.setText(paramCharSequence);
    this.xPd.setOnClickListener(new c.4(this, paramOnClickListener, paramBoolean));
    AppMethodBeat.o(192110);
  }
  
  private void asb(int paramInt)
  {
    AppMethodBeat.i(192083);
    if (this.UWd != null) {
      this.UWd.setTextColor(paramInt);
    }
    AppMethodBeat.o(192083);
  }
  
  private void asc(int paramInt)
  {
    AppMethodBeat.i(192098);
    if (this.UWl != null) {
      this.UWl.setVisibility(paramInt);
    }
    if (this.UWn != null) {
      this.UWn.setVisibility(paramInt);
    }
    if ((this.UWh != null) && (this.UWq)) {
      this.UWh.setVisibility(paramInt);
    }
    if (this.mEditText != null)
    {
      if (!this.needEdit)
      {
        this.mEditText.setVisibility(8);
        AppMethodBeat.o(192098);
        return;
      }
      this.mEditText.setVisibility(paramInt);
    }
    AppMethodBeat.o(192098);
  }
  
  private void asd(int paramInt)
  {
    AppMethodBeat.i(192112);
    this.xPd.setTextColor(paramInt);
    AppMethodBeat.o(192112);
  }
  
  private void ase(int paramInt)
  {
    AppMethodBeat.i(192114);
    this.MhR.setTextColor(paramInt);
    AppMethodBeat.o(192114);
  }
  
  private void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(192126);
    this.UWp.setVisibility(8);
    this.UWm.removeAllViews();
    this.UWm.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(192126);
  }
  
  private void hA(View paramView)
  {
    AppMethodBeat.i(192107);
    this.nX = paramView;
    if (this.nX != null)
    {
      this.UWl.setVisibility(0);
      this.UWn.setVisibility(0);
      this.UWn.removeAllViews();
      this.UWn.setGravity(1);
      this.UWn.addView(this.nX, new LinearLayout.LayoutParams(-1, -1));
    }
    AppMethodBeat.o(192107);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(192158);
    int i;
    if ((parama.Ig != null) && (parama.Ig.length() > 0))
    {
      i = parama.UVT;
      if (this.mLH != null) {
        this.mLH.setGravity(i);
      }
      setTitle(parama.Ig);
    }
    Object localObject4;
    Object localObject1;
    if ((parama.UVl != null) && (parama.UVl.length() > 0))
    {
      localObject4 = parama.UVl;
      this.qnZ.setVisibility(0);
      this.UWc.setVisibility(0);
      localObject1 = localObject4;
      if (this.UWv != null)
      {
        localObject1 = this.UWv;
        ((CharSequence)localObject4).toString();
        this.mLH.getTextSize();
        localObject1 = ((c.a.c)localObject1).htl();
      }
      this.UWc.setText((CharSequence)localObject1);
    }
    if (parama.RaZ != 0)
    {
      i = parama.RaZ;
      this.mLH.setTextColor(ColorStateList.valueOf(i));
    }
    if (parama.UVQ != 0)
    {
      i = parama.UVQ;
      this.mLH.setMaxLines(i);
    }
    if (parama.UVR != 0)
    {
      i = parama.UVR;
      this.UWd.setMaxLines(i);
    }
    if (parama.bFK != null) {
      hA(parama.bFK);
    }
    if (parama.UVO != null)
    {
      localObject4 = parama.UVO;
      this.qnZ.setVisibility(0);
      this.UWk.setLayoutResource(f.e.confirm_dialog_custom_title);
    }
    try
    {
      localObject1 = (LinearLayout)this.UWk.inflate();
      ((LinearLayout)localObject1).addView((View)localObject4);
      if (parama.UVP != null)
      {
        this.UWj = parama.UVP;
        if (this.UWj != null)
        {
          this.UWl.setVisibility(8);
          this.UWh.setVisibility(8);
          this.mEditText.setVisibility(8);
          this.UWo.removeAllViews();
          this.UWo.addView(this.UWj, new LinearLayout.LayoutParams(-1, -1));
          this.UWo.setVisibility(8);
        }
      }
      if (parama.UVw != null)
      {
        localObject1 = parama.UVw;
        if (this.nX == null)
        {
          this.UWl.setVisibility(0);
          this.UWi.setVisibility(0);
          this.UWi.setBackgroundDrawable((Drawable)localObject1);
        }
      }
      if ((parama.UVy != null) && (parama.UVy.length() > 0)) {
        setMessage(parama.UVy);
      }
      EO(parama.UVH);
      if (parama.thumbPath != null)
      {
        localObject1 = parama.thumbPath;
        i = aw.fromDPToPix(this.mContext, 120);
        this.UWl.setVisibility(0);
        this.UWi.setVisibility(0);
        if ((this.UWi instanceof com.tencent.mm.ui.h.a)) {
          ((com.tencent.mm.ui.h.a)this.UWi).aO((String)localObject1, i, i);
        }
        i = parama.UVV;
        this.UWl.setVisibility(i);
        this.UWi.setVisibility(i);
      }
      if ((!parama.UVZ) && (!parama.UWa))
      {
        if ((parama.UVy != null) && (parama.UVy.length() > 0)) {
          setMessage(parama.UVy);
        }
        if ((parama.UVz == null) || (parama.UVz.length() <= 0)) {
          break label1955;
        }
        localObject1 = parama.UVz;
        this.UWl.setVisibility(0);
        this.UWf.setVisibility(0);
        this.UWf.setMaxLines(2);
        this.UWf.setText((CharSequence)localObject1);
        if ((parama.UVA != null) && (parama.UVA.length() > 0))
        {
          localObject4 = parama.UVA;
          if (localObject4 != null)
          {
            this.UWl.setVisibility(0);
            this.UWg.setVisibility(0);
            localObject1 = localObject4;
            if (this.UWv != null)
            {
              localObject1 = this.UWv;
              this.UWg.getContext();
              ((CharSequence)localObject4).toString();
              this.UWg.getTextSize();
              localObject1 = ((c.a.c)localObject1).htl();
            }
            this.UWg.setText((CharSequence)localObject1);
          }
        }
        if (parama.UVx != null)
        {
          localObject1 = parama.UVx;
          if (this.nX == null)
          {
            this.UWl.setVisibility(0);
            this.UWi.setVisibility(0);
            this.UWi.setImageBitmap((Bitmap)localObject1);
          }
        }
      }
      if (parama.UVZ)
      {
        localObject1 = parama.UVx;
        localObject5 = parama.UVz;
        localObject4 = parama.UVA;
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
          if (this.UWv != null)
          {
            localObject1 = this.UWv;
            ((CharSequence)localObject5).toString();
            ((TextView)localObject7).getTextSize();
            localObject1 = ((c.a.c)localObject1).htl();
          }
          ((TextView)localObject7).setText((CharSequence)localObject1);
        }
        if (localObject4 != null)
        {
          localObject5 = (TextView)((View)localObject6).findViewById(f.d.mm_alert_msg_subdesc);
          ((TextView)localObject5).setVisibility(0);
          if (this.UWv == null) {
            break label2241;
          }
          localObject1 = this.UWv;
          ((CharSequence)localObject4).toString();
          ((TextView)localObject5).getTextSize();
          localObject1 = ((c.a.c)localObject1).htl();
          ((TextView)localObject5).setText((CharSequence)localObject1);
        }
        hA((View)localObject6);
        if ((parama.UVp != null) || (parama.UVq != null))
        {
          localObject4 = parama.UVp;
          localObject5 = parama.UVq;
          bool = parama.UVr;
          localObject6 = parama.UVt;
          this.UWk.setLayoutResource(f.e.confirm_dialog_title_image);
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
          localObject1 = (LinearLayout)this.UWk.inflate();
          if ((localObject1 != null) && (localObject4 != null)) {
            ((ImageView)((LinearLayout)localObject1).findViewById(f.d.title_image)).setVisibility(0);
          }
          if ((localObject1 != null) && (localObject5 != null))
          {
            localObject7 = (TextView)((LinearLayout)localObject1).findViewById(f.d.title_text);
            ((TextView)localObject7).setVisibility(0);
            localObject4 = localObject5;
            if (this.UWv != null)
            {
              localObject4 = this.UWv;
              ((CharSequence)localObject5).toString();
              this.mLH.getTextSize();
              localObject4 = ((c.a.c)localObject4).htl();
            }
            ((TextView)localObject7).setText((CharSequence)localObject4);
          }
          if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
          {
            localObject4 = (ImageView)((LinearLayout)localObject1).findViewById(f.d.image_title_detail_icon);
            ((ImageView)localObject4).setVisibility(0);
            asc(0);
            ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(191811);
                b localb = new b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                if (this.UWy.isSelected())
                {
                  c.b(c.this).startAnimation(c.a(c.this));
                  c.a(c.this).setAnimationListener(new Animation.AnimationListener()
                  {
                    public final void onAnimationEnd(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(191797);
                      c.b(c.this).setVisibility(8);
                      c.a(c.this, 0);
                      AppMethodBeat.o(191797);
                    }
                    
                    public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                    
                    public final void onAnimationStart(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(191794);
                      c.a(c.this, c.c(c.this));
                      AppMethodBeat.o(191794);
                    }
                  });
                  ObjectAnimator.ofFloat(this.UWy, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
                  this.UWy.setSelected(false);
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(191811);
                  return;
                  c.b(c.this).startAnimation(c.d(c.this));
                  c.d(c.this).setAnimationListener(new Animation.AnimationListener()
                  {
                    public final void onAnimationEnd(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(192038);
                      c.b(c.this).setVisibility(0);
                      c.a(c.this, 8);
                      AppMethodBeat.o(192038);
                    }
                    
                    public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                    
                    public final void onAnimationStart(Animation paramAnonymous2Animation)
                    {
                      AppMethodBeat.i(192036);
                      c.a(c.this, c.e(c.this));
                      AppMethodBeat.o(192036);
                    }
                  });
                  ObjectAnimator.ofFloat(this.UWy, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
                  this.UWy.setSelected(true);
                }
              }
            });
          }
          if (parama.UVu != null)
          {
            localObject1 = parama.UVu;
            if ((this.UWl != null) && (this.UWl.getVisibility() == 0)) {
              this.UWl.setOnClickListener(new c.2(this, (c.a.a)localObject1));
            }
          }
          else
          {
            if ((parama.UVm != null) && (parama.UVm.length() > 0))
            {
              localObject1 = parama.UVm;
              if (localObject1 != null)
              {
                this.UWh.setVisibility(0);
                this.UWh.setText((CharSequence)localObject1);
              }
              this.UWq = true;
              i = parama.UVS;
              if (this.UWh != null) {
                this.UWh.setGravity(i);
              }
            }
            if ((parama.UVn != null) && (parama.UVn.length() > 0))
            {
              localObject1 = parama.UVn;
              this.mEditText.setVisibility(0);
              this.mEditText.setHint((CharSequence)localObject1);
            }
            if (parama.UVo)
            {
              this.needEdit = parama.UVo;
              if (!parama.UVo) {
                continue;
              }
              this.mEditText.setVisibility(0);
            }
            if ((parama.UVB != null) && (parama.UVB.length() > 0)) {
              a(parama.UVB, parama.UVY, parama.UVJ);
            }
            if ((parama.UVC != null) && (parama.UVC.length() > 0)) {
              a(parama.UVC, parama.UVK);
            }
            if (parama.UVX != 0) {
              asd(parama.UVX);
            }
            if (parama.UVW != 0) {
              ase(parama.UVW);
            }
            if (parama.fs != null) {
              setOnCancelListener(parama.fs);
            }
            if (parama.ft != null)
            {
              this.UWw = parama.ft;
              setOnDismissListener(parama.ft);
            }
            if (parama.UVv != null) {
              this.UWv = parama.UVv;
            }
            setCancelable(parama.bxO);
            this.bxO = parama.bxO;
            if (!this.bxO) {
              super.setCancelable(parama.UVG);
            }
            if ((parama.UVD != null) || (parama.UVE != null) || (parama.UVF != null))
            {
              localObject1 = View.inflate(this.mContext, f.e.confirm_dialog_multi_btn, null);
              localObject4 = (Button)((View)localObject1).findViewById(f.d.mm_alert_btn_first);
              localObject5 = (Button)((View)localObject1).findViewById(f.d.mm_alert_btn_second);
              localObject6 = (Button)((View)localObject1).findViewById(f.d.mm_alert_btn_third);
              if (parama.UVD != null)
              {
                ((Button)localObject4).setVisibility(0);
                ((Button)localObject4).setText(parama.UVD);
                ((Button)localObject4).setOnClickListener(new c.6(this, parama));
              }
              if (parama.UVE != null)
              {
                ((Button)localObject5).setVisibility(0);
                ((Button)localObject5).setText(parama.UVE);
                ((Button)localObject5).setOnClickListener(new c.7(this, parama));
              }
              if (parama.UVF != null)
              {
                ((Button)localObject6).setVisibility(0);
                ((Button)localObject6).setText(parama.UVF);
                ((Button)localObject6).setOnClickListener(new c.8(this, parama));
              }
              b((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
            }
            if (parama.UVs)
            {
              localObject1 = View.inflate(this.mContext, f.e.confirm_dialog_btn_up_down, null);
              this.MhR = ((Button)((View)localObject1).findViewById(f.d.mm_alert_cancel_btn));
              this.xPd = ((Button)((View)localObject1).findViewById(f.d.mm_alert_ok_btn));
              if (parama.UVX != 0) {
                asd(parama.UVX);
              }
              if (parama.UVW != 0) {
                ase(parama.UVW);
              }
              if ((parama.UVB != null) && (parama.UVB.length() > 0)) {
                a(parama.UVB, parama.UVY, parama.UVJ);
              }
              if ((parama.UVC != null) && (parama.UVC.length() > 0)) {
                a(parama.UVC, parama.UVK);
              }
              b((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
            }
            AppMethodBeat.o(192158);
            return;
            localException1 = localException1;
            this.UWk.setVisibility(0);
            Object localObject2 = null;
            continue;
            label1955:
            EO(false);
            continue;
            if (!parama.UWa) {
              continue;
            }
            localObject2 = parama.UVx;
            localObject5 = parama.UVz;
            localObject4 = parama.UVA;
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
              if (this.UWv != null)
              {
                localObject2 = this.UWv;
                ((CharSequence)localObject5).toString();
                ((TextView)localObject7).getTextSize();
                localObject2 = ((c.a.c)localObject2).htl();
              }
              ((TextView)localObject7).setText((CharSequence)localObject2);
            }
            if (localObject4 != null)
            {
              localObject5 = (TextView)((View)localObject6).findViewById(f.d.mm_alert_msg_subdesc);
              ((TextView)localObject5).setVisibility(0);
              if (this.UWv == null) {
                continue;
              }
              localObject2 = this.UWv;
              ((CharSequence)localObject4).toString();
              ((TextView)localObject5).getTextSize();
              localObject2 = ((c.a.c)localObject2).htl();
              ((TextView)localObject5).setText((CharSequence)localObject2);
            }
            hA((View)localObject6);
          }
        }
        catch (Exception localException2)
        {
          this.UWk.setVisibility(0);
          localObject3 = null;
          continue;
          if (this.UWn == null) {
            continue;
          }
          this.UWn.setOnClickListener(new c.3(this, (c.a.a)localObject3));
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
    AppMethodBeat.i(192167);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new c.9(this));
      av.e("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
      AppMethodBeat.o(192167);
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
        AppMethodBeat.o(192167);
        return;
        super.dismiss();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        av.e("MicroMsg.MMAlertDialog", "dismiss exception, e = " + localException.getMessage(), new Object[0]);
      }
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(192073);
    super.onCreate(paramBundle);
    setContentView(this.UWb);
    AppMethodBeat.o(192073);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(192123);
    super.setCancelable(paramBoolean);
    this.bxO = paramBoolean;
    setCanceledOnTouchOutside(this.bxO);
    AppMethodBeat.o(192123);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(192087);
    this.UWl.setVisibility(0);
    this.UWd.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.UWv != null)
    {
      localObject = this.UWv;
      this.UWd.getContext();
      paramCharSequence.toString();
      this.UWd.getTextSize();
      localObject = ((c.a.c)localObject).htl();
    }
    this.UWd.setText((CharSequence)localObject);
    AppMethodBeat.o(192087);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(192081);
    this.qnZ.setVisibility(0);
    this.mLH.setVisibility(0);
    this.mLH.setMaxLines(2);
    this.mLH.setText(paramInt);
    this.mLH.getPaint().setFakeBoldText(true);
    asb(this.mContext.getResources().getColor(f.b.FG_1));
    AppMethodBeat.o(192081);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(192077);
    this.qnZ.setVisibility(0);
    this.mLH.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.UWv != null)
    {
      localObject = this.UWv;
      paramCharSequence.toString();
      this.mLH.getTextSize();
      localObject = ((c.a.c)localObject).htl();
    }
    this.mLH.setMaxLines(2);
    this.mLH.setText((CharSequence)localObject);
    this.mLH.getPaint().setFakeBoldText(true);
    asb(this.mContext.getResources().getColor(f.b.FG_1));
    AppMethodBeat.o(192077);
  }
  
  public final void show()
  {
    AppMethodBeat.i(192160);
    try
    {
      super.show();
      AppMethodBeat.o(192160);
      return;
    }
    catch (Exception localException)
    {
      av.printErrStackTrace("MicroMsg.MMAlertDialog", localException, "", new Object[0]);
      AppMethodBeat.o(192160);
    }
  }
  
  public static abstract interface a$b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a.c
 * JD-Core Version:    0.7.0.1
 */