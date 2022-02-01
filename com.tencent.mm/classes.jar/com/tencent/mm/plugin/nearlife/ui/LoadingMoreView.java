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

public class LoadingMoreView
  extends LinearLayout
{
  private Context context;
  private ImageView dPk;
  protected LinearLayout pXt;
  
  public LoadingMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26591);
    this.context = paramContext;
    paramContext = LayoutInflater.from(this.context).inflate(2131495209, this, true);
    this.dPk = ((ImageView)findViewById(2131303168));
    this.pXt = ((LinearLayout)paramContext.findViewById(2131303707));
    this.pXt.setVisibility(0);
    paramContext = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    paramContext.setDuration(1000L);
    paramContext.setRepeatCount(-1);
    paramContext.setInterpolator(new LinearInterpolator());
    this.dPk.startAnimation(paramContext);
    AppMethodBeat.o(26591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.LoadingMoreView
 * JD-Core Version:    0.7.0.1
 */