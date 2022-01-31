package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;

final class tt$4
  extends tr
{
  tt$4(tt paramtt, View paramView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    new Handler().post(new tt.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.tt.4
 * JD-Core Version:    0.7.0.1
 */