package com.tencent.mm.plugin.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.record.model.v;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements d
{
  public final n createApplication()
  {
    AppMethodBeat.i(27798);
    b localb = new b();
    AppMethodBeat.o(27798);
    return localb;
  }
  
  public final be createSubCore()
  {
    AppMethodBeat.i(27799);
    v localv = new v();
    AppMethodBeat.o(27799);
    return localv;
  }
  
  public final c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.Plugin
 * JD-Core Version:    0.7.0.1
 */