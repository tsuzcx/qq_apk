package com.tencent.mm.plugin.qqmail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.qqmail.a.a;
import com.tencent.mm.plugin.qqmail.model.ab;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements com.tencent.mm.pluginsdk.c.d
{
  private d NiZ;
  
  public Plugin()
  {
    AppMethodBeat.i(122626);
    this.NiZ = new d();
    AppMethodBeat.o(122626);
  }
  
  public final n createApplication()
  {
    AppMethodBeat.i(122627);
    a locala = new a();
    AppMethodBeat.o(122627);
    return locala;
  }
  
  public final be createSubCore()
  {
    AppMethodBeat.i(122628);
    ab localab = new ab();
    AppMethodBeat.o(122628);
    return localab;
  }
  
  public final c getContactWidgetFactory()
  {
    return this.NiZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.Plugin
 * JD-Core Version:    0.7.0.1
 */