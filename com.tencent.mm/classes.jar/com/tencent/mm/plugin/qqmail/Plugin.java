package com.tencent.mm.plugin.qqmail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.qqmail.b.ad;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public final class Plugin
  implements d
{
  private a uKE;
  
  public Plugin()
  {
    AppMethodBeat.i(122626);
    this.uKE = new a();
    AppMethodBeat.o(122626);
  }
  
  public final m createApplication()
  {
    AppMethodBeat.i(122627);
    com.tencent.mm.plugin.qqmail.a.a locala = new com.tencent.mm.plugin.qqmail.a.a();
    AppMethodBeat.o(122627);
    return locala;
  }
  
  public final aw createSubCore()
  {
    AppMethodBeat.i(122628);
    ad localad = new ad();
    AppMethodBeat.o(122628);
    return localad;
  }
  
  public final c getContactWidgetFactory()
  {
    return this.uKE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.Plugin
 * JD-Core Version:    0.7.0.1
 */