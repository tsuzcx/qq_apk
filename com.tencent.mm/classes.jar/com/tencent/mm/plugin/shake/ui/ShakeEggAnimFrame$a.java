package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.animation.Animation;
import junit.framework.Assert;

abstract class ShakeEggAnimFrame$a
  extends Animation
{
  protected int duration = 100;
  View targetView;
  
  ShakeEggAnimFrame$a(ShakeEggAnimFrame paramShakeEggAnimFrame) {}
  
  public final void clV()
  {
    if (this.targetView != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.targetView.post(new ShakeEggAnimFrame.a.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeEggAnimFrame.a
 * JD-Core Version:    0.7.0.1
 */