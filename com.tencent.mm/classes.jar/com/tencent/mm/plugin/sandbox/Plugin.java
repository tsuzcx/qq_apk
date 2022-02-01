package com.tencent.mm.plugin.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public class Plugin
  implements d
{
  public m createApplication()
  {
    AppMethodBeat.i(28046);
    a locala = new a();
    AppMethodBeat.o(28046);
    return locala;
  }
  
  public aw createSubCore()
  {
    AppMethodBeat.i(28047);
    SubCoreSandBox localSubCoreSandBox = new SubCoreSandBox();
    AppMethodBeat.o(28047);
    return localSubCoreSandBox;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sandbox.Plugin
 * JD-Core Version:    0.7.0.1
 */