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
import com.tencent.mm.sdk.platformtools.bt;

public class ViewTitleWithAnimation
  extends LinearLayout
{
  private ImageView HCS;
  private TextView HCT;
  private TextView HCU;
  private ImageView HCV;
  private TextView HCW;
  private View HCX;
  private TextView avQ;
  private ViewGroup tpf;
  
  public ViewTitleWithAnimation(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143504);
    aL(paramContext);
    AppMethodBeat.o(143504);
  }
  
  public ViewTitleWithAnimation(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143505);
    aL(paramContext);
    AppMethodBeat.o(143505);
  }
  
  public ViewTitleWithAnimation(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143506);
    aL(paramContext);
    AppMethodBeat.o(143506);
  }
  
  private void aL(Context paramContext)
  {
    AppMethodBeat.i(143507);
    LayoutInflater.from(paramContext).inflate(2131493234, this);
    this.avQ = ((TextView)findViewById(2131306161));
    this.HCX = findViewById(2131306006);
    this.HCS = ((ImageView)findViewById(2131301215));
    this.HCT = ((TextView)findViewById(2131306155));
    this.HCU = ((TextView)findViewById(2131306124));
    this.HCV = ((ImageView)findViewById(2131301216));
    this.HCW = ((TextView)findViewById(2131306125));
    this.tpf = ((ViewGroup)findViewById(2131301356));
    AppMethodBeat.o(143507);
  }
  
  public final void ffh()
  {
    AppMethodBeat.i(143511);
    this.tpf.setVisibility(4);
    this.HCW.setVisibility(0);
    AppMethodBeat.o(143511);
  }
  
  public ImageView getIconImageView()
  {
    return this.HCS;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(143513);
    this.HCV.clearAnimation();
    this.HCV.setVisibility(8);
    this.avQ.setVisibility(0);
    this.HCS.setVisibility(0);
    this.HCU.setVisibility(0);
    AppMethodBeat.o(143513);
  }
  
  public void setCompanyText(String paramString)
  {
    AppMethodBeat.i(143510);
    if (!bt.isNullOrNil(paramString))
    {
      this.HCU.setVisibility(0);
      this.HCU.setText(paramString);
      AppMethodBeat.o(143510);
      return;
    }
    this.HCU.setVisibility(8);
    AppMethodBeat.o(143510);
  }
  
  public void setSubTitle(String paramString)
  {
    AppMethodBeat.i(143509);
    this.HCT.setText(paramString);
    AppMethodBeat.o(143509);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(143508);
    this.avQ.setText(paramString);
    AppMethodBeat.o(143508);
  }
  
  public void setTopPaddingVisibility(int paramInt)
  {
    AppMethodBeat.i(175969);
    this.HCX.setVisibility(paramInt);
    AppMethodBeat.o(175969);
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(143512);
    this.HCV.clearAnimation();
    this.avQ.setVisibility(8);
    this.HCU.setVisibility(8);
    this.HCS.setVisibility(8);
    this.HCV.setVisibility(0);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1000L);
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    this.HCV.startAnimation(localRotateAnimation);
    AppMethodBeat.o(143512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation
 * JD-Core Version:    0.7.0.1
 */