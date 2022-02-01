package com.tencent.mm.plugin.taskbar.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;

final class TaskBarView$10
  implements Runnable
{
  TaskBarView$10(TaskBarView paramTaskBarView) {}
  
  public final void run()
  {
    AppMethodBeat.i(264151);
    TaskBarView localTaskBarView = this.STb;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localTaskBarView, locala.aYi(), "com/tencent/mm/plugin/taskbar/ui/TaskBarView$8", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
    localTaskBarView.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localTaskBarView, "com/tencent/mm/plugin/taskbar/ui/TaskBarView$8", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
    this.STb.setTranslationY(0.0F);
    AppMethodBeat.o(264151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.TaskBarView.10
 * JD-Core Version:    0.7.0.1
 */