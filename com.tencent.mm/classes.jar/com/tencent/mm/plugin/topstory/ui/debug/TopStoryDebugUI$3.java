package com.tencent.mm.plugin.topstory.ui.debug;

import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.websearch.api.ap;
import com.tencent.mm.vfs.e;

final class TopStoryDebugUI$3
  implements View.OnClickListener
{
  TopStoryDebugUI$3(TopStoryDebugUI paramTopStoryDebugUI, ap paramap) {}
  
  public final void onClick(View paramView)
  {
    e.K(this.pDP.aoA(), true);
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI.3
 * JD-Core Version:    0.7.0.1
 */