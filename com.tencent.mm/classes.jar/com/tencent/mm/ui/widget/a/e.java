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
import android.text.Layout;
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
import com.tencent.mm.ck.a.a;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.d;
import com.tencent.mm.ck.a.e;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ck.a.h;
import com.tencent.mm.ck.a.j;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.ba;
import com.tencent.mm.ui.bc;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.edittext.PasterEditText;

public class e
  extends Dialog
  implements DialogInterface
{
  private Button BoW;
  private Button SJn;
  private ImageView VPr;
  private View acrA;
  private boolean acrB;
  private Animation acrC;
  private Animation acrD;
  private Animation acrE;
  private Animation acrF;
  public DialogInterface.OnDismissListener acrH;
  private LinearLayout acrm;
  private TextView acrn;
  private TextView acro;
  private TextView acrq;
  private TextView acrr;
  private TextView acrs;
  public ImageView acrt;
  private View acru;
  private ViewStub acrv;
  private LinearLayout acrw;
  private ViewGroup acrx;
  private LinearLayout acry;
  private ViewGroup acrz;
  private LinearLayout agea;
  private e.a.d ageb;
  private boolean dqR;
  public d iOnDialogDismissListener;
  private Context mContext;
  public EditText mEditText;
  CheckBox nd;
  private boolean needEdit;
  private View oW;
  private TextView pIp;
  private LinearLayout tsG;
  
  public e(Context paramContext)
  {
    super(paramContext, a.j.mmalertdialog);
    AppMethodBeat.i(159314);
    this.acrB = false;
    this.needEdit = false;
    this.mContext = paramContext;
    ixq();
    AppMethodBeat.o(159314);
  }
  
  public e(Context paramContext, byte paramByte)
  {
    super(paramContext, a.j.mmalertdialog);
    AppMethodBeat.i(251790);
    this.acrB = false;
    this.needEdit = false;
    this.mContext = paramContext;
    ixq();
    AppMethodBeat.o(251790);
  }
  
  private void KA(boolean paramBoolean)
  {
    AppMethodBeat.i(159320);
    if (paramBoolean)
    {
      int i = bd.fromDPToPix(this.mContext, 8);
      this.acrw.setVisibility(0);
      this.acrw.setPadding(i, i, i, i);
    }
    AppMethodBeat.o(159320);
  }
  
  private void ayg(int paramInt)
  {
    AppMethodBeat.i(159318);
    if (this.acro != null) {
      this.acro.setTextColor(paramInt);
    }
    AppMethodBeat.o(159318);
  }
  
  private void ayh(int paramInt)
  {
    AppMethodBeat.i(159324);
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
    this.acrA.setVisibility(8);
    this.acrx.removeAllViews();
    this.acrx.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(159334);
  }
  
  private void br(View paramView, int paramInt)
  {
    AppMethodBeat.i(159325);
    this.oW = paramView;
    if (this.oW != null)
    {
      this.acrw.setVisibility(0);
      this.acry.setVisibility(0);
      this.acry.removeAllViews();
      this.acry.setGravity(1);
      this.acry.addView(this.oW, new LinearLayout.LayoutParams(paramInt, paramInt));
    }
    AppMethodBeat.o(159325);
  }
  
  private void ixq()
  {
    AppMethodBeat.i(251797);
    this.acrm = ((LinearLayout)View.inflate(this.mContext, a.g.mm_alert_comfirm, null));
    this.agea = ((LinearLayout)this.acrm.findViewById(a.f.alert_content_ll));
    this.BoW = ((Button)this.acrm.findViewById(a.f.mm_alert_ok_btn));
    this.SJn = ((Button)this.acrm.findViewById(a.f.mm_alert_cancel_btn));
    this.pIp = ((TextView)this.acrm.findViewById(a.f.mm_alert_title));
    this.acrn = ((TextView)this.acrm.findViewById(a.f.mm_alert_title_desc));
    this.acro = ((TextView)this.acrm.findViewById(a.f.mm_alert_msg));
    this.acrq = ((TextView)this.acrm.findViewById(a.f.mm_alert_msg_subtitle));
    this.acrr = ((TextView)this.acrm.findViewById(a.f.mm_alert_msg_subdesc));
    this.acrs = ((TextView)this.acrm.findViewById(a.f.confirm_dialog_content_desc_tv));
    this.mEditText = ((EditText)this.acrm.findViewById(a.f.confirm_dialog_text_et));
    this.nd = ((CheckBox)this.acrm.findViewById(a.f.confirm_dialog_checkbox));
    this.acrt = ((ImageView)this.acrm.findViewById(a.f.mm_alert_msg_icon));
    this.VPr = ((ImageView)this.acrm.findViewById(a.f.divider));
    this.tsG = ((LinearLayout)this.acrm.findViewById(a.f.mm_alert_title_area));
    this.acrv = ((ViewStub)this.acrm.findViewById(a.f.title_image_ll));
    this.acrw = ((LinearLayout)this.acrm.findViewById(a.f.mm_alert_msg_area));
    this.acrx = ((ViewGroup)this.acrm.findViewById(a.f.mm_alert_bottom_view));
    this.acrA = this.acrm.findViewById(a.f.mm_alert_button_view);
    this.acry = ((LinearLayout)this.acrm.findViewById(a.f.mm_alert_custom_area));
    this.acrz = ((ViewGroup)this.acrm.findViewById(a.f.title_image_detail_area));
    setCanceledOnTouchOutside(true);
    this.acrC = AnimationUtils.loadAnimation(this.mContext, a.a.alpha_in);
    this.acrD = AnimationUtils.loadAnimation(this.mContext, a.a.alpha_in);
    this.acrE = AnimationUtils.loadAnimation(this.mContext, a.a.alpha_out);
    this.acrF = AnimationUtils.loadAnimation(this.mContext, a.a.alpha_out);
    AppMethodBeat.o(251797);
  }
  
  public final void Ny(boolean paramBoolean)
  {
    AppMethodBeat.i(251897);
    if (paramBoolean)
    {
      this.mEditText.setVisibility(0);
      AppMethodBeat.o(251897);
      return;
    }
    this.mEditText.setVisibility(8);
    AppMethodBeat.o(251897);
  }
  
  public final void Nz(boolean paramBoolean)
  {
    AppMethodBeat.i(159333);
    super.setCancelable(paramBoolean);
    AppMethodBeat.o(159333);
  }
  
  public final void a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159329);
    a(com.tencent.mm.ui.d.a.np(this.mContext).getString(paramInt), true, paramOnClickListener);
    AppMethodBeat.o(159329);
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(159335);
    if ((parama.title != null) && (parama.title.length() > 0))
    {
      aEG(parama.acre);
      setTitle(parama.title);
    }
    Object localObject3;
    Object localObject1;
    if ((parama.acqw != null) && (parama.acqw.length() > 0))
    {
      localObject3 = parama.acqw;
      this.tsG.setVisibility(0);
      this.acrn.setVisibility(0);
      localObject1 = localObject3;
      if (this.ageb != null) {
        localObject1 = this.ageb.a(((CharSequence)localObject3).toString(), this.pIp.getTextSize());
      }
      this.acrn.setText((CharSequence)localObject1);
    }
    if (parama.XXf != 0) {
      setTitleColor(parama.XXf);
    }
    int i;
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
      br(parama.dyK, -1);
    }
    if (parama.acqZ != null)
    {
      localObject3 = parama.acqZ;
      this.tsG.setVisibility(0);
      this.acrv.setLayoutResource(a.g.confirm_dialog_custom_title);
    }
    label2817:
    try
    {
      localObject1 = (LinearLayout)this.acrv.inflate();
      ((LinearLayout)localObject1).addView((View)localObject3);
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
          break label2346;
        }
        localObject1 = parama.acqK;
        this.acrw.setVisibility(0);
        this.acrq.setVisibility(0);
        this.acrq.setMaxLines(2);
        this.acrq.setText((CharSequence)localObject1);
        if ((parama.acqL != null) && (parama.acqL.length() > 0))
        {
          localObject3 = parama.acqL;
          if (localObject3 != null)
          {
            this.acrw.setVisibility(0);
            this.acrr.setVisibility(0);
            localObject1 = localObject3;
            if (this.ageb != null)
            {
              localObject1 = this.ageb;
              this.acrr.getContext();
              localObject1 = ((e.a.d)localObject1).a(((CharSequence)localObject3).toString(), this.acrr.getTextSize());
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
      boolean bool;
      e.a.a locala;
      if (parama.acrk)
      {
        localObject1 = parama.acqI;
        localObject4 = parama.acqK;
        localObject3 = parama.acqL;
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
          if (this.ageb != null) {
            localObject1 = this.ageb.a(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
          }
          ((TextView)localObject6).setText((CharSequence)localObject1);
        }
        if (localObject3 != null)
        {
          localObject4 = (TextView)((View)localObject5).findViewById(a.f.mm_alert_msg_subdesc);
          ((TextView)localObject4).setVisibility(0);
          if (this.ageb == null) {
            break label2831;
          }
          localObject1 = this.ageb.a(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
          ((TextView)localObject4).setText((CharSequence)localObject1);
        }
        br((View)localObject5, -1);
        if ((parama.acqA != null) || (parama.acqB != null))
        {
          localObject6 = parama.acqA;
          localObject4 = parama.acqB;
          bool = parama.acqC;
          localObject5 = parama.agdT;
          locala = parama.agdU;
          this.acrv.setLayoutResource(a.g.confirm_dialog_title_image);
          localObject1 = null;
        }
      }
      try
      {
        localObject3 = (LinearLayout)this.acrv.inflate();
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
          this.acrv.setVisibility(0);
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
              this.BoW.setVisibility(0);
              this.BoW.setText(parama.acqM);
              this.BoW.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(251855);
                  Layout localLayout = e.i(e.this).getLayout();
                  if ((localLayout != null) && (localLayout.getEllipsisCount(0) > 0))
                  {
                    bc.i("MicroMsg.MMAlertDialog", "PositiveButton text too long, show updown mode!!", new Object[0]);
                    e.a(e.this, parama);
                  }
                  AppMethodBeat.o(251855);
                }
              });
              this.BoW.setOnClickListener(new e.11(this, parama));
              continue;
              this.SJn.setVisibility(0);
              this.SJn.setText(parama.acqN);
              this.SJn.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(251845);
                  Layout localLayout = e.j(e.this).getLayout();
                  if ((localLayout != null) && (localLayout.getEllipsisCount(0) > 0))
                  {
                    bc.i("MicroMsg.MMAlertDialog", "NegativeButton text too long, show updown mode!!", new Object[0]);
                    e.a(e.this, parama);
                  }
                  AppMethodBeat.o(251845);
                }
              });
              this.SJn.setOnClickListener(new e.13(this, parama));
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
        ((ImageView)localObject3).setImportantForAccessibility(2);
        if (locala != null) {
          locala.k((ImageView)localObject3, (String)localObject6);
        }
      }
      if ((localObject1 != null) && (localObject4 != null))
      {
        localObject6 = (TextView)((LinearLayout)localObject1).findViewById(a.f.title_text);
        ((TextView)localObject6).setVisibility(0);
        localObject3 = localObject4;
        if (this.ageb != null) {
          localObject3 = this.ageb.a(((CharSequence)localObject4).toString(), this.pIp.getTextSize());
        }
        ((TextView)localObject6).setText((CharSequence)localObject3);
      }
      if ((Boolean.valueOf(bool).booleanValue()) && (localObject1 != null))
      {
        localObject3 = (ImageView)((LinearLayout)localObject1).findViewById(a.f.image_title_detail_icon);
        ((ImageView)localObject3).setVisibility(0);
        ayh(0);
        ((LinearLayout)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(159297);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/dialog/MMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (this.agec != null) {
              this.agec.flT();
            }
            if (this.acrJ.isSelected())
            {
              e.e(e.this).startAnimation(e.d(e.this));
              e.d(e.this).setAnimationListener(new Animation.AnimationListener()
              {
                public final void onAnimationEnd(Animation paramAnonymous2Animation)
                {
                  AppMethodBeat.i(159294);
                  e.e(e.this).setVisibility(8);
                  e.a(e.this, 0);
                  AppMethodBeat.o(159294);
                }
                
                public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                
                public final void onAnimationStart(Animation paramAnonymous2Animation)
                {
                  AppMethodBeat.i(159293);
                  e.a(e.this, e.f(e.this));
                  AppMethodBeat.o(159293);
                }
              });
              ObjectAnimator.ofFloat(this.acrJ, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
              this.acrJ.setSelected(false);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMAlertDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(159297);
              return;
              e.e(e.this).startAnimation(e.g(e.this));
              e.g(e.this).setAnimationListener(new Animation.AnimationListener()
              {
                public final void onAnimationEnd(Animation paramAnonymous2Animation)
                {
                  AppMethodBeat.i(159296);
                  e.e(e.this).setVisibility(0);
                  e.a(e.this, 8);
                  AppMethodBeat.o(159296);
                }
                
                public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                
                public final void onAnimationStart(Animation paramAnonymous2Animation)
                {
                  AppMethodBeat.i(159295);
                  e.a(e.this, e.h(e.this));
                  AppMethodBeat.o(159295);
                }
              });
              ObjectAnimator.ofFloat(this.acrJ, "rotation", new float[] { 0.0F, 180.0F }).setDuration(200L).start();
              this.acrJ.setSelected(true);
            }
          }
        });
      }
      if (parama.agdV != null) {
        b(parama.agdV);
      }
      if ((parama.agdX != null) && (!parama.agdX.isRecycled()))
      {
        localObject3 = parama.agdX;
        bool = parama.acqT;
        i2 = parama.acrf;
        if (localObject3 != null)
        {
          KA(false);
          this.acrw.setVisibility(0);
          this.acrw.setGravity(1);
          this.acrw.setPadding(0, 0, 0, 0);
          localObject5 = View.inflate(this.mContext, a.g.confirm_dialog_image_center, null);
          localObject6 = (ImageView)((View)localObject5).findViewById(a.f.mm_alert_msg_icon);
          if (!bool) {
            break label2817;
          }
          i = ((Bitmap)localObject3).getWidth();
          j = ((Bitmap)localObject3).getHeight();
          localObject4 = null;
          f = j / i;
          n = 0;
          m = 0;
          i1 = bd.bs(this.mContext, a.d.DialogBigImageMinHeight);
          i = bd.bs(this.mContext, a.d.DialogBigImageMaxHeight);
          k = 0;
          j = 0;
          if ((f <= 0.0F) || (f >= 0.5D)) {
            break label2572;
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
          localObject1 = ba.b((Bitmap)localObject1, bd.fromDPToPix(this.mContext, 3));
          ((ImageView)localObject6).setImageBitmap((Bitmap)localObject1);
          localObject1 = (ImageView)((View)localObject5).findViewById(a.f.image_status_icon);
          if (i2 != 0) {
            break label2667;
          }
          ((ImageView)localObject1).setVisibility(8);
          br((View)localObject5, -2);
        }
      }
      if ((parama.acqx != null) && (parama.acqx.length() > 0))
      {
        localObject1 = parama.acqx;
        if (localObject1 != null)
        {
          this.acrs.setVisibility(0);
          this.acrs.setText((CharSequence)localObject1);
        }
        this.acrB = true;
        aEI(parama.acrd);
      }
      if ((parama.acqy != null) && (parama.acqy.length() > 0)) {
        bb(parama.acqy);
      }
      if ((parama.agdS != null) && (parama.agdS.length() > 0))
      {
        localObject1 = parama.agdS;
        this.nd.setVisibility(0);
        this.nd.setText((CharSequence)localObject1);
      }
      if (parama.acqz)
      {
        this.needEdit = parama.acqz;
        Ny(parama.acqz);
      }
      if ((parama.acqM == null) || (parama.acqM.length() <= 0) || (this.BoW == null) || (parama == null))
      {
        if ((parama.acqN != null) && (parama.acqN.length() > 0) && (this.SJn != null) && (parama != null)) {
          break label2762;
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
        if (parama.agdW != null) {
          this.ageb = parama.agdW;
        }
        if (parama.agdY != 0) {
          setBackground(parama.agdY);
        }
        setCancelable(parama.dqR);
        this.dqR = parama.dqR;
        if (!this.dqR) {
          super.setCancelable(parama.acqR);
        }
        if ((parama.acqO != null) || (parama.acqP != null) || (parama.acqQ != null))
        {
          localObject1 = View.inflate(this.mContext, a.g.confirm_dialog_multi_btn, null);
          localObject3 = (Button)((View)localObject1).findViewById(a.f.mm_alert_btn_first);
          localObject4 = (Button)((View)localObject1).findViewById(a.f.mm_alert_btn_second);
          localObject5 = (Button)((View)localObject1).findViewById(a.f.mm_alert_btn_third);
          if (parama.acqO != null)
          {
            ((Button)localObject3).setVisibility(0);
            ((Button)localObject3).setText(parama.acqO);
            ((Button)localObject3).setOnClickListener(new e.4(this, parama));
          }
          if (parama.acqP != null)
          {
            ((Button)localObject4).setVisibility(0);
            ((Button)localObject4).setText(parama.acqP);
            ((Button)localObject4).setOnClickListener(new e.5(this, parama));
          }
          if (parama.acqQ != null)
          {
            ((Button)localObject5).setVisibility(0);
            ((Button)localObject5).setText(parama.acqQ);
            ((Button)localObject5).setOnClickListener(new e.6(this, parama));
          }
          b((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
        }
        if (parama.acqD)
        {
          localObject1 = View.inflate(this.mContext, a.g.confirm_dialog_btn_up_down, null);
          this.SJn = ((Button)((View)localObject1).findViewById(a.f.mm_alert_cancel_btn));
          this.BoW = ((Button)((View)localObject1).findViewById(a.f.mm_alert_ok_btn));
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
            b(parama.acqN, true, parama.acqV);
          }
          b((View)localObject1, new LinearLayout.LayoutParams(-1, -1));
        }
        if (parama.VtK)
        {
          if (this.agea != null) {
            this.agea.setBackgroundResource(a.e.dialog_dark_bg);
          }
          ayg(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_8));
          ayj(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_6));
          if (this.VPr != null) {
            this.VPr.setBackgroundColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_0_5));
          }
          if (this.acrx != null) {
            this.acrx.setBackgroundResource(a.e.transparent_top_line_dark_bg);
          }
        }
        AppMethodBeat.o(159335);
      }
    }
    catch (Exception localException1)
    {
      label2572:
      label2831:
      for (;;)
      {
        Object localObject4;
        Object localObject5;
        Object localObject6;
        this.acrv.setVisibility(0);
        Object localObject2 = null;
        continue;
        label2346:
        KA(false);
        continue;
        label2762:
        if (parama.acrl)
        {
          localObject2 = parama.acqI;
          localObject4 = parama.acqK;
          localObject3 = parama.acqL;
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
            if (this.ageb != null) {
              localObject2 = this.ageb.a(((CharSequence)localObject4).toString(), ((TextView)localObject6).getTextSize());
            }
            ((TextView)localObject6).setText((CharSequence)localObject2);
          }
          if (localObject3 != null)
          {
            localObject4 = (TextView)((View)localObject5).findViewById(a.f.mm_alert_msg_subdesc);
            ((TextView)localObject4).setVisibility(0);
            if (this.ageb != null)
            {
              localObject2 = this.ageb.a(((CharSequence)localObject3).toString(), ((TextView)localObject4).getTextSize());
              ((TextView)localObject4).setText((CharSequence)localObject2);
            }
          }
          else
          {
            br((View)localObject5, -1);
            continue;
          }
          label2667:
          localObject2 = localException2;
        }
      }
    }
  }
  
  public final void a(CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159326);
    if (this.BoW == null)
    {
      AppMethodBeat.o(159326);
      return;
    }
    this.BoW.setVisibility(0);
    this.BoW.setText(paramCharSequence);
    this.BoW.setOnClickListener(new e.2(this, paramOnClickListener, paramBoolean));
    AppMethodBeat.o(159326);
  }
  
  public final void aEG(int paramInt)
  {
    AppMethodBeat.i(251865);
    if (this.pIp != null) {
      this.pIp.setGravity(paramInt);
    }
    AppMethodBeat.o(251865);
  }
  
  public final void aEH(int paramInt)
  {
    AppMethodBeat.i(251881);
    this.acrw.setVisibility(0);
    this.acro.setVisibility(0);
    this.acro.setText(paramInt);
    AppMethodBeat.o(251881);
  }
  
  public final void aEI(int paramInt)
  {
    AppMethodBeat.i(251887);
    if (this.acrs != null) {
      this.acrs.setGravity(paramInt);
    }
    AppMethodBeat.o(251887);
  }
  
  public final Button aEJ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case -1: 
      return this.BoW;
    }
    return this.SJn;
  }
  
  public final void ayi(int paramInt)
  {
    AppMethodBeat.i(159327);
    this.BoW.setTextColor(paramInt);
    AppMethodBeat.o(159327);
  }
  
  public final void ayj(int paramInt)
  {
    AppMethodBeat.i(159328);
    this.SJn.setTextColor(paramInt);
    AppMethodBeat.o(159328);
  }
  
  public final void b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159331);
    b(com.tencent.mm.ui.d.a.np(this.mContext).getString(paramInt), true, paramOnClickListener);
    AppMethodBeat.o(159331);
  }
  
  public final void b(e.a.b paramb)
  {
    AppMethodBeat.i(159323);
    if ((this.acrw != null) && (this.acrw.getVisibility() == 0))
    {
      this.acrw.setOnClickListener(new e.8(this, paramb));
      AppMethodBeat.o(159323);
      return;
    }
    if (this.acry != null) {
      this.acry.setOnClickListener(new e.9(this, paramb));
    }
    AppMethodBeat.o(159323);
  }
  
  public final void b(CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(159330);
    if (this.SJn == null)
    {
      AppMethodBeat.o(159330);
      return;
    }
    this.SJn.setVisibility(0);
    this.SJn.setText(paramCharSequence);
    this.SJn.setOnClickListener(new e.3(this, paramOnClickListener, paramBoolean));
    AppMethodBeat.o(159330);
  }
  
  public final void bb(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(251888);
    this.mEditText.setVisibility(0);
    this.mEditText.setHint(paramCharSequence);
    AppMethodBeat.o(251888);
  }
  
  public final void cX(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(251937);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(251937);
      return;
      if (paramBoolean)
      {
        this.BoW.setVisibility(0);
        AppMethodBeat.o(251937);
        return;
      }
      this.BoW.setVisibility(8);
      AppMethodBeat.o(251937);
      return;
      if (paramBoolean)
      {
        this.SJn.setVisibility(0);
        AppMethodBeat.o(251937);
        return;
      }
      this.SJn.setVisibility(8);
    }
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(159337);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new e.7(this));
      bc.e("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
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
        bc.e("MicroMsg.MMAlertDialog", "dismiss exception, e = " + localException.getMessage(), new Object[0]);
      }
    }
  }
  
  public View getContentView()
  {
    return this.acrm;
  }
  
  public final void jHD()
  {
    AppMethodBeat.i(251893);
    this.mEditText.requestFocus();
    AppMethodBeat.o(251893);
  }
  
  public final String jHE()
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
  
  public final int jHF()
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
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(159315);
    super.onCreate(paramBundle);
    setContentView(this.acrm);
    AppMethodBeat.o(159315);
  }
  
  public final void setBackground(int paramInt)
  {
    AppMethodBeat.i(251916);
    if (this.agea != null) {
      this.agea.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(251916);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(159332);
    super.setCancelable(paramBoolean);
    this.dqR = paramBoolean;
    setCanceledOnTouchOutside(this.dqR);
    AppMethodBeat.o(159332);
  }
  
  public final void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159319);
    this.acrw.setVisibility(0);
    this.acro.setVisibility(0);
    Object localObject = paramCharSequence;
    if (this.ageb != null)
    {
      localObject = this.ageb;
      this.acro.getContext();
      localObject = ((e.a.d)localObject).a(paramCharSequence.toString(), this.acro.getTextSize());
    }
    this.acro.setText((CharSequence)localObject);
    AppMethodBeat.o(159319);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(159317);
    this.tsG.setVisibility(0);
    this.pIp.setVisibility(0);
    this.pIp.setMaxLines(2);
    this.pIp.setText(paramInt);
    this.pIp.getPaint().setFakeBoldText(true);
    ayg(this.mContext.getResources().getColor(a.c.FG_1));
    AppMethodBeat.o(159317);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(159316);
    this.tsG.setVisibility(0);
    this.pIp.setVisibility(0);
    CharSequence localCharSequence = paramCharSequence;
    if (this.ageb != null) {
      localCharSequence = this.ageb.a(paramCharSequence.toString(), this.pIp.getTextSize());
    }
    this.pIp.setMaxLines(2);
    this.pIp.setText(localCharSequence);
    this.pIp.getPaint().setFakeBoldText(true);
    ayg(this.mContext.getResources().getColor(a.c.FG_1));
    AppMethodBeat.o(159316);
  }
  
  public final void setTitleColor(int paramInt)
  {
    AppMethodBeat.i(251875);
    this.pIp.setTextColor(ColorStateList.valueOf(paramInt));
    AppMethodBeat.o(251875);
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
      bc.printErrStackTrace("MicroMsg.MMAlertDialog", localException, "", new Object[0]);
      AppMethodBeat.o(159336);
    }
  }
  
  public static final class a
  {
    public a ageh;
    public Context mContext;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159306);
      this.mContext = paramContext;
      this.ageh = new a();
      AppMethodBeat.o(159306);
    }
    
    public final a NA(boolean paramBoolean)
    {
      this.ageh.acqS = paramBoolean;
      return this;
    }
    
    public final a NB(boolean paramBoolean)
    {
      this.ageh.acqz = paramBoolean;
      return this;
    }
    
    public final a NC(boolean paramBoolean)
    {
      this.ageh.dqR = paramBoolean;
      return this;
    }
    
    public final a ND(boolean paramBoolean)
    {
      this.ageh.acqR = paramBoolean;
      return this;
    }
    
    public final a a(DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
    {
      this.ageh.acqW = paramOnClickListener1;
      this.ageh.acqX = paramOnClickListener2;
      this.ageh.acqY = paramOnClickListener3;
      return this;
    }
    
    public final a a(e.a.d paramd)
    {
      this.ageh.agdW = paramd;
      return this;
    }
    
    public final a a(String paramString, CharSequence paramCharSequence, Boolean paramBoolean, c paramc, a parama)
    {
      AppMethodBeat.i(159309);
      this.ageh.acqA = paramString;
      this.ageh.acqB = paramCharSequence;
      this.ageh.acqC = paramBoolean.booleanValue();
      this.ageh.agdT = paramc;
      this.ageh.agdU = parama;
      AppMethodBeat.o(159309);
      return this;
    }
    
    public final a a(boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.ageh.acqU = paramOnClickListener;
      this.ageh.acrj = paramBoolean;
      return this;
    }
    
    public final a aEK(int paramInt)
    {
      AppMethodBeat.i(159307);
      this.ageh.title = com.tencent.mm.ui.d.a.np(this.mContext).getString(paramInt);
      AppMethodBeat.o(159307);
      return this;
    }
    
    public final a aEL(int paramInt)
    {
      this.ageh.XXf = paramInt;
      return this;
    }
    
    public final a aEM(int paramInt)
    {
      this.ageh.acrb = paramInt;
      return this;
    }
    
    public final a aEN(int paramInt)
    {
      this.ageh.acre = paramInt;
      return this;
    }
    
    public final a aEO(int paramInt)
    {
      AppMethodBeat.i(159308);
      this.ageh.acqJ = com.tencent.mm.ui.d.a.np(this.mContext).getString(paramInt);
      AppMethodBeat.o(159308);
      return this;
    }
    
    public final a aEP(int paramInt)
    {
      this.ageh.acrc = paramInt;
      return this;
    }
    
    public final a aEQ(int paramInt)
    {
      this.ageh.acrd = paramInt;
      return this;
    }
    
    public final a aER(int paramInt)
    {
      AppMethodBeat.i(159310);
      this.ageh.acqM = com.tencent.mm.ui.d.a.np(this.mContext).getString(paramInt);
      AppMethodBeat.o(159310);
      return this;
    }
    
    public final a aES(int paramInt)
    {
      AppMethodBeat.i(159311);
      this.ageh.acqN = com.tencent.mm.ui.d.a.np(this.mContext).getString(paramInt);
      AppMethodBeat.o(159311);
      return this;
    }
    
    public final a aET(int paramInt)
    {
      this.ageh.acri = paramInt;
      return this;
    }
    
    public final a aEU(int paramInt)
    {
      this.ageh.acrh = paramInt;
      return this;
    }
    
    public final a b(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
    {
      this.ageh.agdX = paramBitmap;
      this.ageh.acqT = paramBoolean;
      this.ageh.acrf = paramInt;
      return this;
    }
    
    public final a bDA(String paramString)
    {
      this.ageh.acqy = paramString;
      return this;
    }
    
    public final a bDB(String paramString)
    {
      this.ageh.agdS = paramString;
      return this;
    }
    
    public final a bDC(String paramString)
    {
      this.ageh.acqM = paramString;
      return this;
    }
    
    public final a bDD(String paramString)
    {
      this.ageh.acqN = paramString;
      return this;
    }
    
    public final a bDv(String paramString)
    {
      this.ageh.title = paramString;
      return this;
    }
    
    public final a bDw(String paramString)
    {
      this.ageh.acqJ = paramString;
      return this;
    }
    
    public final a bDx(String paramString)
    {
      this.ageh.acqL = paramString;
      return this;
    }
    
    public final a bDy(String paramString)
    {
      this.ageh.thumbPath = paramString;
      return this;
    }
    
    public final a bDz(String paramString)
    {
      this.ageh.acqx = paramString;
      return this;
    }
    
    public final a bN(String paramString1, String paramString2, String paramString3)
    {
      this.ageh.acqO = paramString1;
      this.ageh.acqP = paramString2;
      this.ageh.acqQ = paramString3;
      return this;
    }
    
    public final a bc(CharSequence paramCharSequence)
    {
      this.ageh.title = paramCharSequence;
      return this;
    }
    
    public final a bd(CharSequence paramCharSequence)
    {
      this.ageh.acqw = paramCharSequence;
      return this;
    }
    
    public final a be(CharSequence paramCharSequence)
    {
      this.ageh.acqK = paramCharSequence;
      return this;
    }
    
    public final a bg(Bitmap paramBitmap)
    {
      this.ageh.acqI = paramBitmap;
      return this;
    }
    
    public final a c(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.ageh.acqU = paramOnClickListener;
      return this;
    }
    
    public final a c(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.ageh.mOnDismissListener = paramOnDismissListener;
      return this;
    }
    
    public final a c(e.a.b paramb)
    {
      this.ageh.agdV = paramb;
      return this;
    }
    
    public final a d(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.ageh.acqV = paramOnClickListener;
      return this;
    }
    
    public final a e(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.ageh.mOnCancelListener = paramOnCancelListener;
      return this;
    }
    
    public final a jHG()
    {
      this.ageh.VtK = true;
      return this;
    }
    
    public final e jHH()
    {
      AppMethodBeat.i(159312);
      e locale = new e(this.mContext, (byte)0);
      locale.a(this.ageh);
      AppMethodBeat.o(159312);
      return locale;
    }
    
    public final a md(View paramView)
    {
      this.ageh.dyK = paramView;
      return this;
    }
    
    public final a me(View paramView)
    {
      this.ageh.acqZ = paramView;
      return this;
    }
    
    public final a mf(View paramView)
    {
      this.ageh.acra = paramView;
      return this;
    }
    
    public static abstract interface a
    {
      public abstract void k(ImageView paramImageView, String paramString);
    }
    
    public static abstract interface c
    {
      public abstract void flT();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.e
 * JD-Core Version:    0.7.0.1
 */