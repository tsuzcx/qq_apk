package com.tencent.mm.plugin.topstory.ui.debug;

import android.view.View;
import android.view.View.OnClickListener;

final class TopStoryDebugUI$4
  implements View.OnClickListener
{
  TopStoryDebugUI$4(TopStoryDebugUI paramTopStoryDebugUI) {}
  
  public final void onClick(View paramView)
  {
    try
    {
      paramView = com.tencent.mm.vfs.e.bP(com.tencent.mm.compatible.util.e.bkH + "topstory/trace.info");
      TopStoryDebugUI.aK(this.pDO, paramView);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI.4
 * JD-Core Version:    0.7.0.1
 */