package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.y;

public class VoiceTipInfoView
  extends LinearLayout
{
  public ProgressBar fsc;
  TextView haW;
  boolean pMU = false;
  private boolean pMV = false;
  private TextView pMW;
  private boolean pMX = false;
  private float pMY = 0.0F;
  TextView pMv;
  
  public VoiceTipInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(R.i.voice_tip_info_view, this, true);
    this.fsc = ((ProgressBar)paramContext.findViewById(R.h.load_progress));
    bPr();
    this.haW = ((TextView)paramContext.findViewById(R.h.voice_print_title));
    this.pMv = ((TextView)paramContext.findViewById(R.h.voice_print_title_tip));
    this.pMW = ((TextView)paramContext.findViewById(R.h.voice_print_title_error));
    reset();
  }
  
  public final void bPq()
  {
    y.d("MicroMsg.VoiceTipInfoView", "mProgressBar show");
    this.fsc.setVisibility(0);
  }
  
  public final void bPr()
  {
    y.d("MicroMsg.VoiceTipInfoView", "mProgressBar hide");
    this.fsc.setVisibility(8);
  }
  
  public final void bPs()
  {
    y.d("MicroMsg.VoiceTipInfoView", "showTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(this.haW.getVisibility()), Boolean.valueOf(this.pMU) });
    if (((this.haW.getVisibility() == 4) || (this.haW.getVisibility() == 8)) && (!this.pMU))
    {
      this.haW.clearAnimation();
      this.pMU = true;
      TextView localTextView = this.haW;
      Object localObject = getContext();
      VoiceTipInfoView.2 local2 = new VoiceTipInfoView.2(this);
      localObject = AnimationUtils.loadAnimation((Context)localObject, R.a.fast_faded_in);
      ((Animation)localObject).setDuration(300L);
      ((Animation)localObject).setFillAfter(true);
      ((Animation)localObject).setRepeatCount(0);
      ((Animation)localObject).setAnimationListener(new a.4(local2));
      localTextView.startAnimation((Animation)localObject);
      return;
    }
    y.d("MicroMsg.VoiceTipInfoView", "showTitle, directly set to VISIBLE");
    this.haW.clearAnimation();
    this.haW.setVisibility(0);
    this.haW.invalidate();
  }
  
  public final void bPt()
  {
    this.pMv.setVisibility(8);
  }
  
  public final void bPu()
  {
    if ((this.pMW.getVisibility() == 4) && (!this.pMX))
    {
      this.pMW.clearAnimation();
      this.pMX = true;
      TextView localTextView = this.pMW;
      getContext();
      VoiceTipInfoView.4 local4 = new VoiceTipInfoView.4(this);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, -1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
      localTranslateAnimation.setDuration(200L);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setRepeatCount(0);
      localTranslateAnimation.setAnimationListener(new a.5(local4));
      localTextView.startAnimation(localTranslateAnimation);
      return;
    }
    this.pMW.clearAnimation();
    this.pMW.setVisibility(0);
  }
  
  public final void bPv()
  {
    if ((this.pMW.getVisibility() == 0) && (!this.pMX))
    {
      this.pMW.clearAnimation();
      this.pMX = true;
      a.a(this.pMW, getContext(), new a.a()
      {
        public final void bPi() {}
        
        public final void bPj()
        {
          VoiceTipInfoView.c(VoiceTipInfoView.this).setVisibility(4);
          VoiceTipInfoView.d(VoiceTipInfoView.this);
        }
      });
      return;
    }
    this.pMW.clearAnimation();
    this.pMW.setVisibility(4);
  }
  
  public final void reset()
  {
    this.pMv.setTextSize(0, getContext().getResources().getDimension(R.f.voice_print_tip_normal_size));
    this.pMY = this.pMv.getTextSize();
    this.pMv.clearAnimation();
    y.d("MicroMsg.VoiceTipInfoView", "mTipSize %f", new Object[] { Float.valueOf(this.pMY) });
  }
  
  public void setErr(int paramInt)
  {
    this.pMW.setText(paramInt);
  }
  
  public void setErr(String paramString)
  {
    this.pMW.setText(paramString);
  }
  
  public void setTipText(int paramInt)
  {
    this.pMv.setText(paramInt);
    this.pMv.setVisibility(0);
  }
  
  public void setTipText(String paramString)
  {
    this.pMv.setText(paramString);
    this.pMv.setVisibility(0);
  }
  
  public void setTitleText(int paramInt)
  {
    this.haW.setText(paramInt);
    this.haW.setVisibility(0);
  }
  
  public void setTitleText(String paramString)
  {
    this.haW.setText(paramString);
    this.haW.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView
 * JD-Core Version:    0.7.0.1
 */