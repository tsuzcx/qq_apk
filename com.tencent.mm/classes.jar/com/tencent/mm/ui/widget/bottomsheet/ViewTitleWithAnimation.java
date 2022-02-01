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
  private ViewGroup KGL;
  private TextView PZh;
  private ImageView afWt;
  private TextView afWu;
  private ImageView afWv;
  private TextView afWw;
  private View afWx;
  private TextView xw;
  
  public ViewTitleWithAnimation(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143504);
    ci(paramContext);
    AppMethodBeat.o(143504);
  }
  
  public ViewTitleWithAnimation(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143505);
    ci(paramContext);
    AppMethodBeat.o(143505);
  }
  
  public ViewTitleWithAnimation(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143506);
    ci(paramContext);
    AppMethodBeat.o(143506);
  }
  
  private void ci(Context paramContext)
  {
    AppMethodBeat.i(143507);
    LayoutInflater.from(paramContext).inflate(a.h.bottom_sheet_view_title_with_animation, this);
    this.xw = ((TextView)findViewById(a.g.tv_title));
    this.afWx = findViewById(a.g.top_gap);
    this.afWt = ((ImageView)findViewById(a.g.iv_icon));
    this.PZh = ((TextView)findViewById(a.g.tv_subtitle));
    this.afWu = ((TextView)findViewById(a.g.tv_extra));
    this.afWv = ((ImageView)findViewById(a.g.iv_loading));
    this.afWw = ((TextView)findViewById(a.g.tv_fallback_text));
    this.KGL = ((ViewGroup)findViewById(a.g.layout_content));
    AppMethodBeat.o(143507);
  }
  
  public ImageView getIconImageView()
  {
    return this.afWt;
  }
  
  public final void hideLoading()
  {
    AppMethodBeat.i(143513);
    this.afWv.clearAnimation();
    this.afWv.setVisibility(8);
    this.xw.setVisibility(0);
    this.afWt.setVisibility(0);
    this.afWu.setVisibility(0);
    AppMethodBeat.o(143513);
  }
  
  public final void jFk()
  {
    AppMethodBeat.i(143511);
    this.KGL.setVisibility(4);
    this.afWw.setVisibility(0);
    AppMethodBeat.o(143511);
  }
  
  public void setCompanyText(String paramString)
  {
    AppMethodBeat.i(143510);
    if (!Util.isNullOrNil(paramString))
    {
      this.afWu.setVisibility(0);
      this.afWu.setText(paramString);
      AppMethodBeat.o(143510);
      return;
    }
    this.afWu.setVisibility(8);
    AppMethodBeat.o(143510);
  }
  
  public void setSubTitle(String paramString)
  {
    AppMethodBeat.i(143509);
    this.PZh.setText(paramString);
    AppMethodBeat.o(143509);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(143508);
    this.xw.setText(paramString);
    AppMethodBeat.o(143508);
  }
  
  public void setTopPaddingVisibility(int paramInt)
  {
    AppMethodBeat.i(175969);
    this.afWx.setVisibility(paramInt);
    AppMethodBeat.o(175969);
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(143512);
    this.afWv.clearAnimation();
    this.xw.setVisibility(8);
    this.afWu.setVisibility(8);
    this.afWt.setVisibility(8);
    this.afWv.setVisibility(0);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1000L);
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    this.afWv.startAnimation(localRotateAnimation);
    AppMethodBeat.o(143512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.bottomsheet.ViewTitleWithAnimation
 * JD-Core Version:    0.7.0.1
 */