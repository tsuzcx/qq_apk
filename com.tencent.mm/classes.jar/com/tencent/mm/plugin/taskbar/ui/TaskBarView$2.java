package com.tencent.mm.plugin.taskbar.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;

final class TaskBarView$2
  implements Runnable
{
  TaskBarView$2(TaskBarView paramTaskBarView) {}
  
  public final void run()
  {
    AppMethodBeat.i(238233);
    TaskBarView localTaskBarView = this.FUt;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localTaskBarView, locala.axQ(), "com/tencent/mm/plugin/taskbar/ui/TaskBarView$10", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
    localTaskBarView.scrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localTaskBarView, "com/tencent/mm/plugin/taskbar/ui/TaskBarView$10", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
    this.FUt.setTranslationY(0.0F);
    AppMethodBeat.o(238233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.TaskBarView.2
 * JD-Core Version:    0.7.0.1
 */