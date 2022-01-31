package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import java.util.List;

final class ShakeEggAnimFrame$a$1
  implements Runnable
{
  ShakeEggAnimFrame$a$1(ShakeEggAnimFrame.a parama) {}
  
  public final void run()
  {
    if (this.obq.targetView != null)
    {
      this.obq.targetView.clearAnimation();
      ShakeEggAnimFrame localShakeEggAnimFrame = this.obq.obp;
      View localView = this.obq.targetView;
      localShakeEggAnimFrame.obn.remove(localView);
      localShakeEggAnimFrame.removeView(localView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeEggAnimFrame.a.1
 * JD-Core Version:    0.7.0.1
 */