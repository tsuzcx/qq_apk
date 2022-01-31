package com.tencent.mm.plugin.multitalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.pluginsdk.b.b;
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
    AppMethodBeat.i(53878);
    p localp = new p();
    AppMethodBeat.o(53878);
    return localp;
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.Plugin
 * JD-Core Version:    0.7.0.1
 */