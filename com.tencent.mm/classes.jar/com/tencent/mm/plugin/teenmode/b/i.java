package com.tencent.mm.plugin.teenmode.b;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class i
  extends t
{
  private long JSX = -1L;
  
  public i()
  {
    super(1, null);
  }
  
  public abstract void fSP();
  
  public void onClick(View paramView)
  {
    if (Util.ticksToNow(this.JSX) > 1000L)
    {
      super.onClick(paramView);
      fSP();
    }
    for (;;)
    {
      this.JSX = Util.currentTicks();
      return;
      Log.w("MicroMsg.AvoidDuplicatedPressableSpan", "hy: too often click");
      setIsPressed(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.i
 * JD-Core Version:    0.7.0.1
 */