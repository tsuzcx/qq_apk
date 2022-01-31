package com.tencent.mm.plugin.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public o createApplication()
  {
    AppMethodBeat.i(24379);
    a locala = new a();
    AppMethodBeat.o(24379);
    return locala;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(24380);
    SubCoreSandBox localSubCoreSandBox = new SubCoreSandBox();
    AppMethodBeat.o(24380);
    return localSubCoreSandBox;
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sandbox.Plugin
 * JD-Core Version:    0.7.0.1
 */