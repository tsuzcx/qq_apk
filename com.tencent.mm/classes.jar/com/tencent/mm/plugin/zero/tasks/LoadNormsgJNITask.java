package com.tencent.mm.plugin.zero.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;

public final class LoadNormsgJNITask
  extends a
{
  public final void execute(g paramg)
  {
    AppMethodBeat.i(133030);
    getClass().getClassLoader();
    j.sC("stlport_shared");
    getClass().getClassLoader();
    j.sC("wechatxlog");
    getClass().getClassLoader();
    j.sC("wechatnormsg");
    AppMethodBeat.o(133030);
  }
  
  public final String name()
  {
    return "boot-load-wechatnormsg-library";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.LoadNormsgJNITask
 * JD-Core Version:    0.7.0.1
 */