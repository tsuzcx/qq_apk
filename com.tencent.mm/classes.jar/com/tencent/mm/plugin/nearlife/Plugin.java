package com.tencent.mm.plugin.nearlife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.nearlife.a.a;
import com.tencent.mm.plugin.nearlife.b.e;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(26545);
    a locala = new a();
    AppMethodBeat.o(26545);
    return locala;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(26546);
    e locale = new e();
    AppMethodBeat.o(26546);
    return locale;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.Plugin
 * JD-Core Version:    0.7.0.1
 */