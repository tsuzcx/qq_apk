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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

public class LoadingMoreView
  extends LinearLayout
{
  private ImageView bQf;
  private Context context;
  protected LinearLayout iqi;
  
  public LoadingMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    paramContext = LayoutInflater.from(this.context).inflate(R.i.life_loading_more, this, true);
    this.bQf = ((ImageView)findViewById(R.h.life_next_progress));
    this.iqi = ((LinearLayout)paramContext.findViewById(R.h.loading_more_state));
    this.iqi.setVisibility(0);
    paramContext = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    paramContext.setDuration(1000L);
    paramContext.setRepeatCount(-1);
    paramContext.setInterpolator(new LinearInterpolator());
    this.bQf.startAnimation(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.LoadingMoreView
 * JD-Core Version:    0.7.0.1
 */