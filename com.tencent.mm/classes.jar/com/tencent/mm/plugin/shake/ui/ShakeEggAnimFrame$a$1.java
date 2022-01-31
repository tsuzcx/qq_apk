package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class ShakeEggAnimFrame$a$1
  implements Runnable
{
  ShakeEggAnimFrame$a$1(ShakeEggAnimFrame.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(24710);
    if (this.qPy.targetView != null)
    {
      this.qPy.targetView.clearAnimation();
      ShakeEggAnimFrame localShakeEggAnimFrame = this.qPy.qPx;
      View localView = this.qPy.targetView;
      localShakeEggAnimFrame.qPv.remove(localView);
      localShakeEggAnimFrame.removeView(localView);
    }
    AppMethodBeat.o(24710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeEggAnimFrame.a.1
 * JD-Core Version:    0.7.0.1
 */