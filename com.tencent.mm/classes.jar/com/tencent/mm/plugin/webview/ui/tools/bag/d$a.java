package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

final class d$a
  extends FrameLayout
{
  ImageView hok;
  Vibrator hpm;
  private ImageView jEm;
  d.a.a rrI;
  
  public d$a(Context paramContext)
  {
    super(paramContext);
    this.hpm = ((Vibrator)paramContext.getSystemService("vibrator"));
    LayoutInflater.from(paramContext).inflate(R.i.webview_bag_indicator, this);
    this.jEm = ((ImageView)findViewById(R.h.bg));
    this.hok = ((ImageView)findViewById(R.h.icon));
  }
  
  final void aa(float paramFloat1, float paramFloat2)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setDuration(50L);
    this.jEm.startAnimation(localScaleAnimation);
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    d.a.a locala;
    if ((this.rrI != null) && (paramConfiguration != null))
    {
      locala = this.rrI;
      if (paramConfiguration.orientation != 2) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      locala.onChange(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.d.a
 * JD-Core Version:    0.7.0.1
 */