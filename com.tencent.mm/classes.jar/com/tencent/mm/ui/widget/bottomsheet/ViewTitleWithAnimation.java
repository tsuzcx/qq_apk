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
import com.tencent.mm.sdk.platformtools.bu;

public class ViewTitleWithAnimation
  extends LinearLayout
{
  private ImageView LqV;
  private TextView LqW;
  private ImageView LqX;
  private TextView LqY;
  private View LqZ;
  private TextView ayB;
  private ViewGroup vMe;
  private TextView zrl;
  
  public ViewTitleWithAnimation(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143504);
    aN(paramContext);
    AppMethodBeat.o(143504);
  }
  
  public ViewTitleWithAnimation(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143505);
    aN(paramContext);
    AppMethodBeat.o(143505);
  }
  
  public ViewTitleWithAnimation(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143506);
    aN(paramContext);
    AppMethodBeat.o(143506);
  }
  
  private void aN(Context paramContext)
  {
    AppMethodBeat.i(143507);
    LayoutInflater.from(paramContext).inflate(2131493234, this);
    this.ayB = ((TextView)findViewById(2131306161));
    this.LqZ = findViewById(2131306006);
    this.LqV = ((ImageView)findViewById(2131301215));
    this.zrl = ((TextView)findViewById(2131306155));
    this.LqW = ((TextView)findViewById(2131306124));
    this.LqX = ((ImageView)findViewById(2131301216));
    this.LqY = ((TextView)findViewById(2131306125));
    this.vMe = ((ViewGroup)findViewById(2131301356));
    AppMethodBeat.o(143507);
  }
  
  public final void fQi()
  {
    AppMethodBeat.i(143511);
    this.vMe.setVisibility(4);
    this.LqY.setVisibility(0);
    AppMethodBeat.o(143511);
  }
  
  public ImageView getIconImageView()
  {
    return this.LqV;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(143513);
    this.LqX.clearAnimation();
    this.LqX.setVisibility(8);
    this.ayB.setVisibility(0);
    this.LqV.setVisibility(0);
    this.LqW.setVisibility(0);
    AppMethodBeat.o(143513);
  }
  
  public void setCompanyText(String paramString)
  {
    AppMethodBeat.i(143510);
    if (!bu.isNullOrNil(paramString))
    {
      this.LqW.setVisibility(0);
      this.LqW.setText(paramString);
      AppMethodBeat.o(143510);
      return;
    }
    this.LqW.setVisibility(8);
    AppMethodBeat.o(143510);
  }
  
  public void setSubTitle(String paramString)
  {
    AppMethodBeat.i(143509);
    this.zrl.setText(paramString);
    AppMethodBeat.o(143509);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(143508);
    this.ayB.setText(paramString);
    AppMethodBeat.o(143508);
  }
  
  public void setTopPaddingVisibility(int paramInt)
  {
    AppMethodBeat.i(175969);
    this.LqZ.setVisibility(paramInt);
    AppMethodBeat.o(175969);
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(143512);
    this.LqX.clearAnimation();
    this.ayB.setVisibility(8);
    this.LqW.setVisibility(8);
    this.LqV.setVisibility(8);
    this.LqX.setVisibility(0);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1000L);
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    this.LqX.startAnimation(localRotateAnimation);
    AppMethodBeat.o(143512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation
 * JD-Core Version:    0.7.0.1
 */