package com.tencent.mm.plugin.taskbar.ui;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.taskbar.d.a;
import com.tencent.mm.ui.aw;

public final class TaskBarContainer$4
  implements Runnable
{
  public TaskBarContainer$4(TaskBarContainer paramTaskBarContainer) {}
  
  public final void run()
  {
    AppMethodBeat.i(264052);
    TaskBarContainer.b(this.SSw);
    if (aw.isDarkMode())
    {
      this.SSw.anX(this.SSw.getResources().getColor(d.a.dark_actionbar_color));
      AppMethodBeat.o(264052);
      return;
    }
    this.SSw.anX(this.SSw.getResources().getColor(d.a.normal_actionbar_color));
    AppMethodBeat.o(264052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.TaskBarContainer.4
 * JD-Core Version:    0.7.0.1
 */