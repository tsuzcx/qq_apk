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
  private TextView KUA;
  private View KUB;
  private ImageView KUx;
  private TextView KUy;
  private ImageView KUz;
  private TextView ayB;
  private ViewGroup vAa;
  private TextView zaK;
  
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
    this.ayB = ((TextView)findViewById(2131306161));
    this.KUB = findViewById(2131306006);
    this.KUx = ((ImageView)findViewById(2131301215));
    this.zaK = ((TextView)findViewById(2131306155));
    this.KUy = ((TextView)findViewById(2131306124));
    this.KUz = ((ImageView)findViewById(2131301216));
    this.KUA = ((TextView)findViewById(2131306125));
    this.vAa = ((ViewGroup)findViewById(2131301356));
    AppMethodBeat.o(143507);
  }
  
  public final void fLO()
  {
    AppMethodBeat.i(143511);
    this.vAa.setVisibility(4);
    this.KUA.setVisibility(0);
    AppMethodBeat.o(143511);
  }
  
  public ImageView getIconImageView()
  {
    return this.KUx;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(143513);
    this.KUz.clearAnimation();
    this.KUz.setVisibility(8);
    this.ayB.setVisibility(0);
    this.KUx.setVisibility(0);
    this.KUy.setVisibility(0);
    AppMethodBeat.o(143513);
  }
  
  public void setCompanyText(String paramString)
  {
    AppMethodBeat.i(143510);
    if (!bt.isNullOrNil(paramString))
    {
      this.KUy.setVisibility(0);
      this.KUy.setText(paramString);
      AppMethodBeat.o(143510);
      return;
    }
    this.KUy.setVisibility(8);
    AppMethodBeat.o(143510);
  }
  
  public void setSubTitle(String paramString)
  {
    AppMethodBeat.i(143509);
    this.zaK.setText(paramString);
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
    this.KUB.setVisibility(paramInt);
    AppMethodBeat.o(175969);
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(143512);
    this.KUz.clearAnimation();
    this.ayB.setVisibility(8);
    this.KUy.setVisibility(8);
    this.KUx.setVisibility(8);
    this.KUz.setVisibility(0);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1000L);
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    this.KUz.startAnimation(localRotateAnimation);
    AppMethodBeat.o(143512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation
 * JD-Core Version:    0.7.0.1
 */