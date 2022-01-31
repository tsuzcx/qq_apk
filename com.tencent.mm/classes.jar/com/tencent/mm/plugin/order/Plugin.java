package com.tencent.mm.plugin.order;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  public o createApplication()
  {
    return null;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(43722);
    com.tencent.mm.plugin.order.a.b localb = new com.tencent.mm.plugin.order.a.b();
    AppMethodBeat.o(43722);
    return localb;
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.Plugin
 * JD-Core Version:    0.7.0.1
 */