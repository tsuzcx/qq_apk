package com.tencent.mm.plugin.topstory.ui.debug;

import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.vfs.e;

final class TopStoryDebugUI$3
  implements View.OnClickListener
{
  TopStoryDebugUI$3(TopStoryDebugUI paramTopStoryDebugUI, ao paramao) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(1550);
    e.O(this.tfW.aLw(), true);
    Process.killProcess(Process.myPid());
    AppMethodBeat.o(1550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI.3
 * JD-Core Version:    0.7.0.1
 */