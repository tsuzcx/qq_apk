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
import com.tencent.mm.sdk.platformtools.Util;

public class ViewTitleWithAnimation
  extends LinearLayout
{
  private TextView Dym;
  private ImageView QFI;
  private TextView QFJ;
  private ImageView QFK;
  private TextView QFL;
  private View QFM;
  private TextView ayz;
  private ViewGroup zhm;
  
  public ViewTitleWithAnimation(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143504);
    bh(paramContext);
    AppMethodBeat.o(143504);
  }
  
  public ViewTitleWithAnimation(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143505);
    bh(paramContext);
    AppMethodBeat.o(143505);
  }
  
  public ViewTitleWithAnimation(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143506);
    bh(paramContext);
    AppMethodBeat.o(143506);
  }
  
  private void bh(Context paramContext)
  {
    AppMethodBeat.i(143507);
    LayoutInflater.from(paramContext).inflate(2131493310, this);
    this.ayz = ((TextView)findViewById(2131309539));
    this.QFM = findViewById(2131309315);
    this.QFI = ((ImageView)findViewById(2131302896));
    this.Dym = ((TextView)findViewById(2131309530));
    this.QFJ = ((TextView)findViewById(2131309482));
    this.QFK = ((ImageView)findViewById(2131302898));
    this.QFL = ((TextView)findViewById(2131309483));
    this.zhm = ((ViewGroup)findViewById(2131303086));
    AppMethodBeat.o(143507);
  }
  
  public final void gZm()
  {
    AppMethodBeat.i(143511);
    this.zhm.setVisibility(4);
    this.QFL.setVisibility(0);
    AppMethodBeat.o(143511);
  }
  
  public ImageView getIconImageView()
  {
    return this.QFI;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(143513);
    this.QFK.clearAnimation();
    this.QFK.setVisibility(8);
    this.ayz.setVisibility(0);
    this.QFI.setVisibility(0);
    this.QFJ.setVisibility(0);
    AppMethodBeat.o(143513);
  }
  
  public void setCompanyText(String paramString)
  {
    AppMethodBeat.i(143510);
    if (!Util.isNullOrNil(paramString))
    {
      this.QFJ.setVisibility(0);
      this.QFJ.setText(paramString);
      AppMethodBeat.o(143510);
      return;
    }
    this.QFJ.setVisibility(8);
    AppMethodBeat.o(143510);
  }
  
  public void setSubTitle(String paramString)
  {
    AppMethodBeat.i(143509);
    this.Dym.setText(paramString);
    AppMethodBeat.o(143509);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(143508);
    this.ayz.setText(paramString);
    AppMethodBeat.o(143508);
  }
  
  public void setTopPaddingVisibility(int paramInt)
  {
    AppMethodBeat.i(175969);
    this.QFM.setVisibility(paramInt);
    AppMethodBeat.o(175969);
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(143512);
    this.QFK.clearAnimation();
    this.ayz.setVisibility(8);
    this.QFJ.setVisibility(8);
    this.QFI.setVisibility(8);
    this.QFK.setVisibility(0);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1000L);
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    this.QFK.startAnimation(localRotateAnimation);
    AppMethodBeat.o(143512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation
 * JD-Core Version:    0.7.0.1
 */