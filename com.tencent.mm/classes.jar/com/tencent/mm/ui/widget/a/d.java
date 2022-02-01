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
import com.tencent.mm.cr.a.a;
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.d;
import com.tencent.mm.cr.a.e;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.cr.a.h;
import com.tencent.mm.cr.a.j;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.edittext.PasterEditText;

public class d
  extends Dialog
  implements DialogInterface
{
  private Button MhR;
  private ImageView OZd;
  private LinearLayout UWb;
  private TextView UWc;
  private TextView UWd;
  private TextView UWf;
  private TextView UWg;
  private TextView UWh;
  private ImageView UWi;
  private View UWj;
  private ViewStub UWk;
  private LinearLayout UWl;
  private ViewGroup UWm;
  private LinearLayout UWn;
  private ViewGroup UWo;
  private View UWp;
  private boolean UWq;
  private Animation UWr;
  private Animation UWs;
  private Animation UWt;
  private Animation UWu;
  public DialogInterface.OnDismissListener UWw;
  private LinearLayout Ymo;
  private d.a.d Ymp;
  private boolean bxO;
  public c iOnDialogDismissListener;
  private Context mContext;
  public EditText mEditText;
  private TextView mLH;
  CheckBox me;
  private View nX;
  private boolean needEdit;
  private LinearLayout qnZ;
  private Button xPd;
  
  public d(Context paramContext)
  {
    super(paramContext, a.j.mmalertdialog);
    AppMethodBeat.i(159314);
    this.UWq = false;
    this.needEdit = false;
    this.mContext = paramContext;
    icp();
    AppMethodBeat.o(159314);
  }
  
  public d(Context paramContext, byte paramByte)
  {
    super(paramContext, a.j.mmalertdialog);
    AppMethodBeat.i(250710);
    this.UWq = false;
    this.needEdit = false;
    this.mContext = paramContext;
    icp();
    AppMethodBeat.o(250710);
  }
  
  private void EO(boolean paramBoolean)
  {
    AppMethodBeat.i(159320);
    if (paramBoolean)
    {
      int i = aw.fromDPToPix(this.mContext, 8);
      this.UWl.setVisibility(0);
      this.UWl.setPadding(i, i, i, i);
    }
    AppMethodBeat.o(159320);
  }
  
  private void aU(View paramView, int paramInt)
  {
    AppMethodBeat.i(159325);
    this.nX = paramView;
    if (this.nX != null)
    {
      this.UWl.setVisibility(0);
      this.UWn.setVisibility(0);
      this.UWn.removeAllViews();
      this.UWn.setGravity(1);
      this.UWn.addView(this.nX, new LinearLayout.LayoutParams(paramInt, paramInt));
    }
    AppMethodBeat.o(159325);
  }
  
  private void asb(int paramInt)
  {
    AppMethodBeat.i(159318);
    if (this.UWd != null) {
      this.UWd.setTextColor(paramInt);
    }
    AppMethodBeat.o(159318);
  }
  
  private void asc(int paramInt)
  {
    AppMethodBeat.i(159324);
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
    this.UWp.setVisibility(8);
    this.UWm.removeAllViews();
    this.UWm.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(159334);
  }
  
  private void icp()
  {
    AppMethodBeat.i(250714);
    this.UWb = ((LinearLayout)View.inflate(this.mContext, a.g.mm_alert_comfirm, null));
    this.Ymo = ((LinearLayout)this.UWb.findViewById(a.f.alert_content_ll));
    this.xPd = ((Button)this.UWb.findViewById(a.f.mm_alert_ok_btn));
    this.MhR = ((Button)this.UWb.findViewById(a.f.mm_alert_cancel_btn));
    this.mLH = ((TextView)this.UWb.findViewById(a.f.mm_alert_title));
    this.UWc = ((TextView)this.UWb.findViewById(a.f.mm_alert_title_desc));
    this.UWd = ((TextView)this.UWb.findViewById(a.f.mm_alert_msg));
    this.UWf = ((TextView)this.UWb.findViewById(a.f.mm_alert_msg_subtitle));
    this.UWg = ((TextView)this.UWb.findViewById(a.f.mm_alert_msg_subdesc));
    this.UWh = ((TextView)this.UWb.findViewById(a.f.confirm_dialog_content_desc_tv));
    this.mEditText = ((EditText)this.UWb.findViewById(a.f.confirm_dialog_text_et));
    this.me = ((CheckBox)this.UWb.findViewById(a.f.confirm_dialog_checkbox));
    this.UWi = ((ImageView)this.UWb.findViewById(a.f.mm_alert_msg_icon));
    this.OZd = ((ImageView)this.UWb.findViewById(a.f.divider));
    this.qnZ = ((LinearLayout)this.UWb.findViewById(a.f.mm_alert_title_area));
    this.UWk = ((ViewStub)this.UWb.findViewById(a.f.title_image_ll));
    this.UWl = ((LinearLayout)this.UWb.findViewById(a.f.mm_alert_msg_area));
    this.UWm = ((ViewGroup)this.UWb.findViewById(a.f.mm_alert_bottom_view));
    this.UWp = this.UWb.findViewById(a.f.mm_alert_button_view);
    this.UWn = ((LinearLayout)this.UWb.findViewById(a.f.mm_alert_custom_area));
    this.UWo = ((ViewGroup)this.UWb.findViewById(a.f.title_image_detail_area));
    setCanceledOnTouchOutside(true);
    this.UWr = AnimationUtils.loadAnimation(this.mContext, a.a.alpha_in);
    this.UWs = AnimationUtils.loadAnimation(this.mContext, a.a.alpha_in);
    this.UWt = AnimationUtils.loadAnimation(this.mContext, a.a.alpha_out);
    this.UWu = AnimationUtils.loadAnimation(this.mContext, a.a.alpha_out);
    AppMethodBeat.o(250714);
  }
  
  public final void HC(boolean paramBoolean)
  {
    AppMethodBeat.i(250724);
    if (paramBoolean)
    {
      this.mEditText.setVisibility(0);
      AppMethodBeat.o(250724);
      return;
    }
    this.mEditText.setVisibility(8);
    AppMethodBeat.o(250724);
  }
  
  public final void HD(boolean paramBoolean)
  {
    AppMethodBeat.i(159333);
    super.setCancelable(paramBoolean);
    AppMethodBeat.o(159333);
  }
  
  public final void a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159329);
    a(com.tencent.mm.ui.e.a.ll(this.mContext).getString(paramInt), true, paramOnClickListener);
    AppMethodBeat.o(159329);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(159335);
    if ((parama.Ig != null) && (parama.Ig.length() > 0))
    {
      axY(parama.UVT);
      setTitle(parama.Ig);
    }
    Object localObject3;
    Object localObject1;
    if ((parama.UVl != null) && (parama.UVl.length() > 0))
    {
      localObject3 = parama.UVl;
      this.qnZ.setVisibility(0);
      this.UWc.setVisibility(0);
      localObject1 = localObject3;
      if (this.Ymp != null) {
        localObject1 = this.Ymp.a(((CharSequence)localObject3).toString(), this.mLH.getTextSize());
      }
      this.UWc.setText((CharSequence)localObject1);
    }
    int i;
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
      aU(parama.bFK, -1);
    }
    if (parama.UVO != null)
    {
      localObject3 = parama.UVO;
      this.qnZ.setVisibility(0);
      this.UWk.setLayoutResource(a.g.confirm_dialog_custom_title);
    }
    try
    {
      localObject1 = (LinearLayout)this.UWk.inflate();
      ((LinearLayout)localObject1).addView((View)localObject3);
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
          break label2367;
        }
        localObject1 = parama.UVz;
        this.UWl.setVisibility(0);
        this.UWf.setVisibility(0);
        this.UWf.setMaxLines(2);
        this.UWf.setText((CharSequence)localObject1);
        if ((parama.UVA != null) && (parama.UVA.length() > 0))
        {
          localObject3 = parama.UVA;
          if (localObject3 != null)
          {
            this.UWl.setVisibility(0);
            this.UWg.setVisibility(0);
            localObject1 = localObject3;
            if (this.Ymp != null)
            {
              localObject1 = this.Ymp;
              this.UWg.getContext();
              localObject1 = ((d.a.d)localObject1).a(((CharSequence)localObject3).toString(), this.UWg.getTextSize());
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
      boolean bool;
      d.a.a locala;
      if (parama.UVZ)
      {
        localObject1 = parama.UVx;
        localObject4 = parama.UVz;
        localObject3 = parama.UVA;
        localObject5 = View.inflate(this.mContext, a.g.confirm_dialog_icon_left, null);
        if (localObject1 != null)
        {
          localObject6 = (ImageView)((View)localObject5).findViewById(a.f.mm_alert_msg_icon);
          ((ImageView)localObject6).setVisibility(0);
          ((ImageView)localObject6).setImageBitmap((Bitmap)localObject1);
        }
        if (localObject4 != null)
        {
          localObject6 = (TextView)((View)localObject5).findViewById(a.f.mm_alert_msg_subtitle);
          ((TextView)localObject6).setVisibility(0);
          localObject1 = localObject4;
          if (this.Ymp != null) {
            localObject1 = this.Ymp.a(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
          }
          ((TextView)localObject6).setText((CharSequence)localObject1);
        }
        if (localObject3 != null)
        {
          localObject4 = (TextView)((View)localObject5).findViewById(a.f.mm_alert_msg_subdesc);
          ((TextView)localObject4).setVisibility(0);
          if (this.Ymp == null) {
            break label2742;
          }
          localObject1 = this.Ymp.a(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
          ((TextView)localObject4).setText((CharSequence)localObject1);
        }
        aU((View)localObject5, -1);
        if ((parama.UVp != null) || (parama.UVq != null))
        {
          localObject6 = parama.UVp;
          localObject4 = parama.UVq;
          bool = parama.UVr;
          localObject5 = parama.Ymh;
          locala = parama.Ymi;
          this.UWk.setLayoutResource(a.g.confirm_dialog_title_image);
          localObject1 = null;
        }
      }
      try
      {
        localObject3 = (LinearLayout)this.UWk.inflate();
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
          this.UWk.setVisibility(0);
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
              ((ImageView)localObject2).setImageResource(a.h.sight_icon_in_gird);
            }
            else if (i2 == 2)
            {
              ((ImageView)localObject2).setImageResource(a.h.video_icon_in_gird);
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
        localObject3 = (ImageView)((LinearLayout)localObject1).findViewById(a.f.title_image);
        ((ImageView)localObject3).setVisibility(0);
        if (locala != null) {
          locala.E((ImageView)localObject3, (String)localObject6);
        }
      }
      if ((localObject1 != null) && (localObject4 != null))
      {
        localObject6 = (TextView)((LinearLayout)localObject1).findViewById(a.f.title_text);
        ((TextView)localObject6).setVisibility(0);
        localObject3 = localObject4;
        if (this.Ymp != null) {
          localObject3 = this.Ymp.a(((CharSequence)localObject4).toString(), this.mLH.getTextSize());
        }
        ((TextView)localObject6).setText((CharSequence)localObject3);
      }
      if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
      {
        localObject3 = (ImageView)((LinearLayout)localObject1).findViewById(a.f.image_title_detail_icon);
        ((ImageView)localObject3).setVisibility(0);
        asc(0);
        ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(159297);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/dialog/MMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (this.Ymq != null) {
              this.Ymq.hku();
            }
            if (this.UWy.isSelected())
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
              ObjectAnimator.ofFloat(this.UWy, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
              this.UWy.setSelected(false);
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
              ObjectAnimator.ofFloat(this.UWy, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
              this.UWy.setSelected(true);
            }
          }
        });
      }
      if (parama.Ymj != null) {
        b(parama.Ymj);
      }
      if ((parama.Yml != null) && (!parama.Yml.isRecycled()))
      {
        localObject3 = parama.Yml;
        bool = parama.UVI;
        i2 = parama.UVU;
        if (localObject3 != null)
        {
          EO(false);
          this.UWl.setVisibility(0);
          this.UWl.setGravity(1);
          this.UWl.setPadding(0, 0, 0, 0);
          localObject5 = View.inflate(this.mContext, a.g.confirm_dialog_image_center, null);
          localObject6 = (ImageView)((View)localObject5).findViewById(a.f.mm_alert_msg_icon);
          if (!bool) {
            break label2728;
          }
          i = ((Bitmap)localObject3).getWidth();
          j = ((Bitmap)localObject3).getHeight();
          localObject4 = null;
          f = j / i;
          n = 0;
          m = 0;
          i1 = aw.aZ(this.mContext, a.d.DialogBigImageMinHeight);
          i = aw.aZ(this.mContext, a.d.DialogBigImageMaxHeight);
          k = 0;
          j = 0;
          if ((f <= 0.0F) || (f >= 0.5D)) {
            break label2593;
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
          localObject1 = at.a((Bitmap)localObject1, aw.fromDPToPix(this.mContext, 3));
          ((ImageView)localObject6).setImageBitmap((Bitmap)localObject1);
          localObject1 = (ImageView)((View)localObject5).findViewById(a.f.image_status_icon);
          if (i2 != 0) {
            break label2688;
          }
          ((ImageView)localObject1).setVisibility(8);
          aU((View)localObject5, -2);
        }
      }
      if ((parama.UVm != null) && (parama.UVm.length() > 0))
      {
        localObject1 = parama.UVm;
        if (localObject1 != null)
        {
          this.UWh.setVisibility(0);
          this.UWh.setText((CharSequence)localObject1);
        }
        this.UWq = true;
        aya(parama.UVS);
      }
      if ((parama.UVn != null) && (parama.UVn.length() > 0)) {
        aN(parama.UVn);
      }
      if ((parama.Ymg != null) && (parama.Ymg.length() > 0))
      {
        localObject1 = parama.Ymg;
        this.me.setVisibility(0);
        this.me.setText((CharSequence)localObject1);
      }
      if (parama.UVo)
      {
        this.needEdit = parama.UVo;
        HC(parama.UVo);
      }
      if ((parama.UVB != null) && (parama.UVB.length() > 0)) {
        a(parama.UVB, parama.UVY, parama.UVJ);
      }
      if ((parama.UVC != null) && (parama.UVC.length() > 0)) {
        b(parama.UVC, true, parama.UVK);
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
      if (parama.Ymk != null) {
        this.Ymp = parama.Ymk;
      }
      if (parama.Ymm != 0)
      {
        i = parama.Ymm;
        if (this.Ymo != null) {
          this.Ymo.setBackgroundResource(i);
        }
      }
      setCancelable(parama.bxO);
      this.bxO = parama.bxO;
      if (!this.bxO) {
        super.setCancelable(parama.UVG);
      }
      if ((parama.UVD != null) || (parama.UVE != null) || (parama.UVF != null))
      {
        localObject1 = View.inflate(this.mContext, a.g.confirm_dialog_multi_btn, null);
        localObject3 = (Button)((View)localObject1).findViewById(a.f.mm_alert_btn_first);
        localObject4 = (Button)((View)localObject1).findViewById(a.f.mm_alert_btn_second);
        localObject5 = (Button)((View)localObject1).findViewById(a.f.mm_alert_btn_third);
        if (parama.UVD != null)
        {
          ((Button)localObject3).setVisibility(0);
          ((Button)localObject3).setText(parama.UVD);
          ((Button)localObject3).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(159302);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/dialog/MMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (parama.UVL != null) {
                parama.UVL.onClick(d.this, -1);
              }
              d.this.dismiss();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(159302);
            }
          });
        }
        if (parama.UVE != null)
        {
          ((Button)localObject4).setVisibility(0);
          ((Button)localObject4).setText(parama.UVE);
          ((Button)localObject4).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(159303);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/dialog/MMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (parama.UVM != null) {
                parama.UVM.onClick(d.this, -2);
              }
              d.this.dismiss();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(159303);
            }
          });
        }
        if (parama.UVF != null)
        {
          ((Button)localObject5).setVisibility(0);
          ((Button)localObject5).setText(parama.UVF);
          ((Button)localObject5).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(159304);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/dialog/MMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (parama.UVN != null) {
                parama.UVN.onClick(d.this, -3);
              }
              d.this.dismiss();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(159304);
            }
          });
        }
        b((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
      }
      if (parama.UVs)
      {
        localObject1 = View.inflate(this.mContext, a.g.confirm_dialog_btn_up_down, null);
        this.MhR = ((Button)((View)localObject1).findViewById(a.f.mm_alert_cancel_btn));
        this.xPd = ((Button)((View)localObject1).findViewById(a.f.mm_alert_ok_btn));
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
          b(parama.UVC, true, parama.UVK);
        }
        b((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
      }
      if (parama.OEz)
      {
        if (this.Ymo != null) {
          this.Ymo.setBackgroundResource(a.e.dialog_dark_bg);
        }
        asb(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_8));
        ase(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_6));
        if (this.OZd != null) {
          this.OZd.setBackgroundColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_0_5));
        }
        if (this.UWm != null) {
          this.UWm.setBackgroundResource(a.e.transparent_top_line_dark_bg);
        }
      }
      AppMethodBeat.o(159335);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject4;
        Object localObject5;
        Object localObject6;
        this.UWk.setVisibility(0);
        Object localObject2 = null;
        continue;
        label2367:
        EO(false);
        continue;
        label2688:
        if (parama.UWa)
        {
          localObject2 = parama.UVx;
          localObject4 = parama.UVz;
          localObject3 = parama.UVA;
          localObject5 = View.inflate(this.mContext, a.g.confirm_dialog_icon_right, null);
          if (localObject2 != null)
          {
            localObject6 = (ImageView)((View)localObject5).findViewById(a.f.mm_alert_msg_icon);
            ((ImageView)localObject6).setVisibility(0);
            ((ImageView)localObject6).setImageBitmap((Bitmap)localObject2);
          }
          if (localObject4 != null)
          {
            localObject6 = (TextView)((View)localObject5).findViewById(a.f.mm_alert_msg_subtitle);
            ((TextView)localObject6).setVisibility(0);
            localObject2 = localObject4;
            if (this.Ymp != null) {
              localObject2 = this.Ymp.a(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
            }
            ((TextView)localObject6).setText((CharSequence)localObject2);
          }
          if (localObject3 != null)
          {
            localObject4 = (TextView)((View)localObject5).findViewById(a.f.mm_alert_msg_subdesc);
            ((TextView)localObject4).setVisibility(0);
            if (this.Ymp != null)
            {
              localObject2 = this.Ymp.a(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
              ((TextView)localObject4).setText((CharSequence)localObject2);
            }
          }
          else
          {
            aU((View)localObject5, -1);
            continue;
          }
          label2593:
          label2728:
          label2742:
          localObject2 = localException2;
        }
      }
    }
  }
  
  public final void a(CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159326);
    if (this.xPd == null)
    {
      AppMethodBeat.o(159326);
      return;
    }
    this.xPd.setVisibility(0);
    this.xPd.setText(paramCharSequence);
    this.xPd.setOnClickListener(new d.4(this, paramOnClickListener, paramBoolean));
    AppMethodBeat.o(159326);
  }
  
  public final void aN(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(250722);
    this.mEditText.setVisibility(0);
    this.mEditText.setHint(paramCharSequence);
    AppMethodBeat.o(250722);
  }
  
  public final void asd(int paramInt)
  {
    AppMethodBeat.i(159327);
    this.xPd.setTextColor(paramInt);
    AppMethodBeat.o(159327);
  }
  
  public final void ase(int paramInt)
  {
    AppMethodBeat.i(159328);
    this.MhR.setTextColor(paramInt);
    AppMethodBeat.o(159328);
  }
  
  public final void axY(int paramInt)
  {
    AppMethodBeat.i(250716);
    if (this.mLH != null) {
      this.mLH.setGravity(paramInt);
    }
    AppMethodBeat.o(250716);
  }
  
  public final void axZ(int paramInt)
  {
    AppMethodBeat.i(250719);
    this.UWl.setVisibility(0);
    this.UWd.setVisibility(0);
    this.UWd.setText(paramInt);
    AppMethodBeat.o(250719);
  }
  
  public final void aya(int paramInt)
  {
    AppMethodBeat.i(250721);
    if (this.UWh != null) {
      this.UWh.setGravity(paramInt);
    }
    AppMethodBeat.o(250721);
  }
  
  public final Button ayb(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case -1: 
      return this.xPd;
    }
    return this.MhR;
  }
  
  public final void b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159331);
    b(com.tencent.mm.ui.e.a.ll(this.mContext).getString(paramInt), true, paramOnClickListener);
    AppMethodBeat.o(159331);
  }
  
  public final void b(d.a.b paramb)
  {
    AppMethodBeat.i(159323);
    if ((this.UWl != null) && (this.UWl.getVisibility() == 0))
    {
      this.UWl.setOnClickListener(new d.2(this, paramb));
      AppMethodBeat.o(159323);
      return;
    }
    if (this.UWn != null) {
      this.UWn.setOnClickListener(new d.3(this, paramb));
    }
    AppMethodBeat.o(159323);
  }
  
  public final void b(CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159330);
    if (this.MhR == null)
    {
      AppMethodBeat.o(159330);
      return;
    }
    this.MhR.setVisibility(0);
    this.MhR.setText(paramCharSequence);
    this.MhR.setOnClickListener(new d.5(this, paramOnClickListener, paramBoolean));
    AppMethodBeat.o(159330);
  }
  
  public final void cg(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(250732);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(250732);
      return;
      if (paramBoolean)
      {
        this.xPd.setVisibility(0);
        AppMethodBeat.o(250732);
        return;
      }
      this.xPd.setVisibility(8);
      AppMethodBeat.o(250732);
      return;
      if (paramBoolean)
      {
        this.MhR.setVisibility(0);
        AppMethodBeat.o(250732);
        return;
      }
      this.MhR.setVisibility(8);
    }
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(159337);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new d.9(this));
      av.e("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
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
        av.e("MicroMsg.MMAlertDialog", "dismiss exception, e = " + localException.getMessage(), new Object[0]);
      }
    }
  }
  
  public View getContentView()
  {
    return this.UWb;
  }
  
  public final String icq()
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
  
  public final int icr()
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
  
  public final ImageView ics()
  {
    return this.UWi;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(159315);
    super.onCreate(paramBundle);
    setContentView(this.UWb);
    AppMethodBeat.o(159315);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(159332);
    super.setCancelable(paramBoolean);
    this.bxO = paramBoolean;
    setCanceledOnTouchOutside(this.bxO);
    AppMethodBeat.o(159332);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159319);
    this.UWl.setVisibility(0);
    this.UWd.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.Ymp != null)
    {
      localObject = this.Ymp;
      this.UWd.getContext();
      localObject = ((d.a.d)localObject).a(paramCharSequence.toString(), this.UWd.getTextSize());
    }
    this.UWd.setText((CharSequence)localObject);
    AppMethodBeat.o(159319);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(159317);
    this.qnZ.setVisibility(0);
    this.mLH.setVisibility(0);
    this.mLH.setMaxLines(2);
    this.mLH.setText(paramInt);
    this.mLH.getPaint().setFakeBoldText(true);
    asb(this.mContext.getResources().getColor(a.c.FG_1));
    AppMethodBeat.o(159317);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159316);
    this.qnZ.setVisibility(0);
    this.mLH.setVisibility(0);
    CharSequence localCharSequence = paramCharSequence;
    if (this.Ymp != null) {
      localCharSequence = this.Ymp.a(paramCharSequence.toString(), this.mLH.getTextSize());
    }
    this.mLH.setMaxLines(2);
    this.mLH.setText(localCharSequence);
    this.mLH.getPaint().setFakeBoldText(true);
    asb(this.mContext.getResources().getColor(a.c.FG_1));
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
      av.printErrStackTrace("MicroMsg.MMAlertDialog", localException, "", new Object[0]);
      AppMethodBeat.o(159336);
    }
  }
  
  public static final class a
  {
    public a Ymv;
    public Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159306);
      this.mContext = paramContext;
      this.Ymv = new a();
      AppMethodBeat.o(159306);
    }
    
    public final a HE(boolean paramBoolean)
    {
      this.Ymv.UVH = paramBoolean;
      return this;
    }
    
    public final a HF(boolean paramBoolean)
    {
      this.Ymv.UVo = paramBoolean;
      return this;
    }
    
    public final a HG(boolean paramBoolean)
    {
      this.Ymv.bxO = paramBoolean;
      return this;
    }
    
    public final a HH(boolean paramBoolean)
    {
      this.Ymv.UVG = paramBoolean;
      return this;
    }
    
    public final a a(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.Ymv.ft = paramOnDismissListener;
      return this;
    }
    
    public final a a(d.a.d paramd)
    {
      this.Ymv.Ymk = paramd;
      return this;
    }
    
    public final a a(String paramString, CharSequence paramCharSequence, Boolean paramBoolean, c paramc, a parama)
    {
      AppMethodBeat.i(159309);
      this.Ymv.UVp = paramString;
      this.Ymv.UVq = paramCharSequence;
      this.Ymv.UVr = paramBoolean.booleanValue();
      this.Ymv.Ymh = paramc;
      this.Ymv.Ymi = parama;
      AppMethodBeat.o(159309);
      return this;
    }
    
    public final a a(boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.Ymv.UVJ = paramOnClickListener;
      this.Ymv.UVY = paramBoolean;
      return this;
    }
    
    public final a aM(Bitmap paramBitmap)
    {
      this.Ymv.UVx = paramBitmap;
      return this;
    }
    
    public final a aO(CharSequence paramCharSequence)
    {
      this.Ymv.Ig = paramCharSequence;
      return this;
    }
    
    public final a aP(CharSequence paramCharSequence)
    {
      this.Ymv.UVl = paramCharSequence;
      return this;
    }
    
    public final a aQ(CharSequence paramCharSequence)
    {
      this.Ymv.UVz = paramCharSequence;
      return this;
    }
    
    public final a ayc(int paramInt)
    {
      AppMethodBeat.i(159307);
      this.Ymv.Ig = com.tencent.mm.ui.e.a.ll(this.mContext).getString(paramInt);
      AppMethodBeat.o(159307);
      return this;
    }
    
    public final a ayd(int paramInt)
    {
      this.Ymv.RaZ = paramInt;
      return this;
    }
    
    public final a aye(int paramInt)
    {
      this.Ymv.UVQ = paramInt;
      return this;
    }
    
    public final a ayf(int paramInt)
    {
      this.Ymv.UVT = paramInt;
      return this;
    }
    
    public final a ayg(int paramInt)
    {
      AppMethodBeat.i(159308);
      this.Ymv.UVy = com.tencent.mm.ui.e.a.ll(this.mContext).getString(paramInt);
      AppMethodBeat.o(159308);
      return this;
    }
    
    public final a ayh(int paramInt)
    {
      this.Ymv.UVR = paramInt;
      return this;
    }
    
    public final a ayi(int paramInt)
    {
      this.Ymv.UVS = paramInt;
      return this;
    }
    
    public final a ayj(int paramInt)
    {
      AppMethodBeat.i(159310);
      this.Ymv.UVB = com.tencent.mm.ui.e.a.ll(this.mContext).getString(paramInt);
      AppMethodBeat.o(159310);
      return this;
    }
    
    public final a ayk(int paramInt)
    {
      AppMethodBeat.i(159311);
      this.Ymv.UVC = com.tencent.mm.ui.e.a.ll(this.mContext).getString(paramInt);
      AppMethodBeat.o(159311);
      return this;
    }
    
    public final a ayl(int paramInt)
    {
      this.Ymv.UVX = paramInt;
      return this;
    }
    
    public final a aym(int paramInt)
    {
      this.Ymv.UVW = paramInt;
      return this;
    }
    
    public final a b(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
    {
      this.Ymv.Yml = paramBitmap;
      this.Ymv.UVI = paramBoolean;
      this.Ymv.UVU = paramInt;
      return this;
    }
    
    public final a bBc(String paramString)
    {
      this.Ymv.Ig = paramString;
      return this;
    }
    
    public final a bBd(String paramString)
    {
      this.Ymv.UVy = paramString;
      return this;
    }
    
    public final a bBe(String paramString)
    {
      this.Ymv.UVA = paramString;
      return this;
    }
    
    public final a bBf(String paramString)
    {
      this.Ymv.thumbPath = paramString;
      return this;
    }
    
    public final a bBg(String paramString)
    {
      this.Ymv.UVm = paramString;
      return this;
    }
    
    public final a bBh(String paramString)
    {
      this.Ymv.UVn = paramString;
      return this;
    }
    
    public final a bBi(String paramString)
    {
      this.Ymv.Ymg = paramString;
      return this;
    }
    
    public final a bBj(String paramString)
    {
      this.Ymv.UVB = paramString;
      return this;
    }
    
    public final a bBk(String paramString)
    {
      this.Ymv.UVC = paramString;
      return this;
    }
    
    public final a c(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.Ymv.UVJ = paramOnClickListener;
      return this;
    }
    
    public final a c(d.a.b paramb)
    {
      this.Ymv.Ymj = paramb;
      return this;
    }
    
    public final a d(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.Ymv.UVK = paramOnClickListener;
      return this;
    }
    
    public final a f(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.Ymv.fs = paramOnCancelListener;
      return this;
    }
    
    public final a iI(View paramView)
    {
      this.Ymv.bFK = paramView;
      return this;
    }
    
    public final a iJ(View paramView)
    {
      this.Ymv.UVO = paramView;
      return this;
    }
    
    public final a ict()
    {
      this.Ymv.OEz = true;
      return this;
    }
    
    public final d icu()
    {
      AppMethodBeat.i(159312);
      d locald = new d(this.mContext, (byte)0);
      locald.a(this.Ymv);
      AppMethodBeat.o(159312);
      return locald;
    }
    
    public final void show()
    {
      AppMethodBeat.i(292984);
      icu().show();
      AppMethodBeat.o(292984);
    }
    
    public static abstract interface a
    {
      public abstract void E(ImageView paramImageView, String paramString);
    }
    
    public static abstract interface c
    {
      public abstract void hku();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.d
 * JD-Core Version:    0.7.0.1
 */