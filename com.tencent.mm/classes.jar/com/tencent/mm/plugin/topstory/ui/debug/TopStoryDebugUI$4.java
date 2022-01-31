package com.tencent.mm.plugin.topstory.ui.debug;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TopStoryDebugUI$4
  implements View.OnClickListener
{
  TopStoryDebugUI$4(TopStoryDebugUI paramTopStoryDebugUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(1551);
    try
    {
      paramView = com.tencent.mm.vfs.e.cS(com.tencent.mm.compatible.util.e.eQz + "topstory/trace.info");
      TopStoryDebugUI.aU(this.tfV, paramView);
      AppMethodBeat.o(1551);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(1551);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI.4
 * JD-Core Version:    0.7.0.1
 */