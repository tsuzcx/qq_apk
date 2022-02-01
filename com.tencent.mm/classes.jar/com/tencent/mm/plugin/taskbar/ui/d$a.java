package com.tencent.mm.plugin.taskbar.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$Companion;", "", "()V", "DEFAULT_TIMEOUT", "", "TAG", "", "getTimeoutInMs", "plugin-taskbar_release"})
public final class d$a
{
  public static long gjV()
  {
    AppMethodBeat.i(214680);
    long l = ((b)h.ae(b.class)).a(b.a.waA, 3600L);
    AppMethodBeat.o(214680);
    return l * 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.d.a
 * JD-Core Version:    0.7.0.1
 */