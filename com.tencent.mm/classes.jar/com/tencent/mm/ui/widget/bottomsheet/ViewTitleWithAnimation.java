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
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.sdk.platformtools.Util;

public class ViewTitleWithAnimation
  extends LinearLayout
{
  private ViewGroup EMs;
  private TextView JIh;
  private ImageView YeA;
  private TextView YeB;
  private View YeC;
  private ImageView Yey;
  private TextView Yez;
  private TextView wB;
  
  public ViewTitleWithAnimation(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143504);
    bv(paramContext);
    AppMethodBeat.o(143504);
  }
  
  public ViewTitleWithAnimation(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143505);
    bv(paramContext);
    AppMethodBeat.o(143505);
  }
  
  public ViewTitleWithAnimation(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143506);
    bv(paramContext);
    AppMethodBeat.o(143506);
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(143507);
    LayoutInflater.from(paramContext).inflate(a.h.bottom_sheet_view_title_with_animation, this);
    this.wB = ((TextView)findViewById(a.g.tv_title));
    this.YeC = findViewById(a.g.top_gap);
    this.Yey = ((ImageView)findViewById(a.g.iv_icon));
    this.JIh = ((TextView)findViewById(a.g.tv_subtitle));
    this.Yez = ((TextView)findViewById(a.g.tv_extra));
    this.YeA = ((ImageView)findViewById(a.g.iv_loading));
    this.YeB = ((TextView)findViewById(a.g.tv_fallback_text));
    this.EMs = ((ViewGroup)findViewById(a.g.layout_content));
    AppMethodBeat.o(143507);
  }
  
  public ImageView getIconImageView()
  {
    return this.Yey;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(143513);
    this.YeA.clearAnimation();
    this.YeA.setVisibility(8);
    this.wB.setVisibility(0);
    this.Yey.setVisibility(0);
    this.Yez.setVisibility(0);
    AppMethodBeat.o(143513);
  }
  
  public final void iad()
  {
    AppMethodBeat.i(143511);
    this.EMs.setVisibility(4);
    this.YeB.setVisibility(0);
    AppMethodBeat.o(143511);
  }
  
  public void setCompanyText(String paramString)
  {
    AppMethodBeat.i(143510);
    if (!Util.isNullOrNil(paramString))
    {
      this.Yez.setVisibility(0);
      this.Yez.setText(paramString);
      AppMethodBeat.o(143510);
      return;
    }
    this.Yez.setVisibility(8);
    AppMethodBeat.o(143510);
  }
  
  public void setSubTitle(String paramString)
  {
    AppMethodBeat.i(143509);
    this.JIh.setText(paramString);
    AppMethodBeat.o(143509);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(143508);
    this.wB.setText(paramString);
    AppMethodBeat.o(143508);
  }
  
  public void setTopPaddingVisibility(int paramInt)
  {
    AppMethodBeat.i(175969);
    this.YeC.setVisibility(paramInt);
    AppMethodBeat.o(175969);
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(143512);
    this.YeA.clearAnimation();
    this.wB.setVisibility(8);
    this.Yez.setVisibility(8);
    this.Yey.setVisibility(8);
    this.YeA.setVisibility(0);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1000L);
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    this.YeA.startAnimation(localRotateAnimation);
    AppMethodBeat.o(143512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation
 * JD-Core Version:    0.7.0.1
 */