package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

public class LoadingMoreView
  extends LinearLayout
{
  private Context context;
  private ImageView hNV;
  protected LinearLayout wxN;
  
  public LoadingMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26591);
    this.context = paramContext;
    paramContext = LayoutInflater.from(this.context).inflate(R.i.glk, this, true);
    this.hNV = ((ImageView)findViewById(R.h.fMN));
    this.wxN = ((LinearLayout)paramContext.findViewById(R.h.loading_more_state));
    this.wxN.setVisibility(0);
    paramContext = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    paramContext.setDuration(1000L);
    paramContext.setRepeatCount(-1);
    paramContext.setInterpolator(new LinearInterpolator());
    this.hNV.startAnimation(paramContext);
    AppMethodBeat.o(26591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.LoadingMoreView
 * JD-Core Version:    0.7.0.1
 */