package com.tencent.mm.ui.chatting;

import com.tencent.mm.plugin.gif.MMAnimateView;
import java.util.List;

final class ChattingAnimFrame$c$2
  implements Runnable
{
  ChattingAnimFrame$c$2(ChattingAnimFrame.c paramc) {}
  
  public final void run()
  {
    MMAnimateView localMMAnimateView;
    if (this.viV.viT != null)
    {
      this.viV.viT.clearAnimation();
      ChattingAnimFrame localChattingAnimFrame = this.viV.viK;
      localMMAnimateView = this.viV.viT;
      if ((localMMAnimateView != null) && (localChattingAnimFrame.viE != null))
      {
        localChattingAnimFrame.viE.remove(localMMAnimateView);
        localMMAnimateView.recycle();
        if (!localChattingAnimFrame.viE.isEmpty()) {
          break label85;
        }
        localMMAnimateView.setLayerType(0, null);
        localChattingAnimFrame.removeAllViews();
      }
    }
    return;
    label85:
    localMMAnimateView.setVisibility(4);
    localMMAnimateView.setLayerType(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingAnimFrame.c.2
 * JD-Core Version:    0.7.0.1
 */