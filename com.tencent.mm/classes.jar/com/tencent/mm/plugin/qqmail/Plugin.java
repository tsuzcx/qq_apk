package com.tencent.mm.plugin.qqmail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.qqmail.a.a;
import com.tencent.mm.plugin.qqmail.d.ac;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements com.tencent.mm.pluginsdk.b.d
{
  private d BqT;
  
  public Plugin()
  {
    AppMethodBeat.i(122626);
    this.BqT = new d();
    AppMethodBeat.o(122626);
  }
  
  public final n createApplication()
  {
    AppMethodBeat.i(122627);
    a locala = new a();
    AppMethodBeat.o(122627);
    return locala;
  }
  
  public final bd createSubCore()
  {
    AppMethodBeat.i(122628);
    ac localac = new ac();
    AppMethodBeat.o(122628);
    return localac;
  }
  
  public final c getContactWidgetFactory()
  {
    return this.BqT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.Plugin
 * JD-Core Version:    0.7.0.1
 */