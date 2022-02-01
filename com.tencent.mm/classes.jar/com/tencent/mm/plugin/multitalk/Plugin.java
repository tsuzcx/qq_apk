package com.tencent.mm.plugin.multitalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public class Plugin
  implements d
{
  public m createApplication()
  {
    return null;
  }
  
  public aw createSubCore()
  {
    AppMethodBeat.i(114407);
    p localp = new p();
    AppMethodBeat.o(114407);
    return localp;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.Plugin
 * JD-Core Version:    0.7.0.1
 */