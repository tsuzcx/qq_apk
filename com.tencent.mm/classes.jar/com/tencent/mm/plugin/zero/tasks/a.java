package com.tencent.mm.plugin.zero.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.g;
import com.tencent.wcdb.support.Log;

public final class a
  extends com.tencent.mm.kernel.a.c.a
{
  public final void execute(g paramg)
  {
    AppMethodBeat.i(133029);
    if (!j.vO("wcdb"))
    {
      getClass().getClassLoader();
      j.vN("wcdb");
    }
    Log.setLogger(new a.1(this));
    AppMethodBeat.o(133029);
  }
  
  public final String name()
  {
    return "boot-db-prepare";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.a
 * JD-Core Version:    0.7.0.1
 */