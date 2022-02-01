package com.tencent.mm.plugin.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(28046);
    a locala = new a();
    AppMethodBeat.o(28046);
    return locala;
  }
  
  public be createSubCore()
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