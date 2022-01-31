package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

final class a$a
  extends FrameLayout
{
  View QR;
  Vibrator hpm;
  ImageView jEm;
  
  public a$a(Context paramContext)
  {
    super(paramContext);
    this.hpm = ((Vibrator)paramContext.getSystemService("vibrator"));
    LayoutInflater.from(paramContext).inflate(R.i.webview_bag_canceller, this);
    this.jEm = ((ImageView)findViewById(R.h.bg));
    this.QR = findViewById(R.h.content);
  }
  
  final void aa(float paramFloat1, float paramFloat2)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 1.0F, 1, 1.0F);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setDuration(50L);
    this.jEm.startAnimation(localScaleAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.a.a
 * JD-Core Version:    0.7.0.1
 */