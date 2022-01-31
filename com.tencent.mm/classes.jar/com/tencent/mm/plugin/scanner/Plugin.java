package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements com.tencent.mm.pluginsdk.b.c
{
  public o createApplication()
  {
    AppMethodBeat.i(80772);
    c localc = new c();
    AppMethodBeat.o(80772);
    return localc;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(80773);
    e locale = new e();
    AppMethodBeat.o(80773);
    return locale;
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.Plugin
 * JD-Core Version:    0.7.0.1
 */