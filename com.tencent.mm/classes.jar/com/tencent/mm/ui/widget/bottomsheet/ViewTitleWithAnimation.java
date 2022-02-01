package com.tencent.mm.ui.widget.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public class ViewTitleWithAnimation
  extends LinearLayout
{
  private ImageView Jdp;
  private TextView Jdq;
  private ImageView Jdr;
  private TextView Jds;
  private View Jdt;
  private TextView awK;
  private ViewGroup uxx;
  private TextView xLv;
  
  public ViewTitleWithAnimation(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143504);
    aM(paramContext);
    AppMethodBeat.o(143504);
  }
  
  public ViewTitleWithAnimation(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143505);
    aM(paramContext);
    AppMethodBeat.o(143505);
  }
  
  public ViewTitleWithAnimation(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143506);
    aM(paramContext);
    AppMethodBeat.o(143506);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(143507);
    LayoutInflater.from(paramContext).inflate(2131493234, this);
    this.awK = ((TextView)findViewById(2131306161));
    this.Jdt = findViewById(2131306006);
    this.Jdp = ((ImageView)findViewById(2131301215));
    this.xLv = ((TextView)findViewById(2131306155));
    this.Jdq = ((TextView)findViewById(2131306124));
    this.Jdr = ((ImageView)findViewById(2131301216));
    this.Jds = ((TextView)findViewById(2131306125));
    this.uxx = ((ViewGroup)findViewById(2131301356));
    AppMethodBeat.o(143507);
  }
  
  public final void fvd()
  {
    AppMethodBeat.i(143511);
    this.uxx.setVisibility(4);
    this.Jds.setVisibility(0);
    AppMethodBeat.o(143511);
  }
  
  public ImageView getIconImageView()
  {
    return this.Jdp;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(143513);
    this.Jdr.clearAnimation();
    this.Jdr.setVisibility(8);
    this.awK.setVisibility(0);
    this.Jdp.setVisibility(0);
    this.Jdq.setVisibility(0);
    AppMethodBeat.o(143513);
  }
  
  public void setCompanyText(String paramString)
  {
    AppMethodBeat.i(143510);
    if (!bs.isNullOrNil(paramString))
    {
      this.Jdq.setVisibility(0);
      this.Jdq.setText(paramString);
      AppMethodBeat.o(143510);
      return;
    }
    this.Jdq.setVisibility(8);
    AppMethodBeat.o(143510);
  }
  
  public void setSubTitle(String paramString)
  {
    AppMethodBeat.i(143509);
    this.xLv.setText(paramString);
    AppMethodBeat.o(143509);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(143508);
    this.awK.setText(paramString);
    AppMethodBeat.o(143508);
  }
  
  public void setTopPaddingVisibility(int paramInt)
  {
    AppMethodBeat.i(175969);
    this.Jdt.setVisibility(paramInt);
    AppMethodBeat.o(175969);
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(143512);
    this.Jdr.clearAnimation();
    this.awK.setVisibility(8);
    this.Jdq.setVisibility(8);
    this.Jdp.setVisibility(8);
    this.Jdr.setVisibility(0);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1000L);
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    this.Jdr.startAnimation(localRotateAnimation);
    AppMethodBeat.o(143512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation
 * JD-Core Version:    0.7.0.1
 */