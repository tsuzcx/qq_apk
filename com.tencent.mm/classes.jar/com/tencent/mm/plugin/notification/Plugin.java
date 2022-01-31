package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin
  implements c
{
  a piz;
  
  public Plugin()
  {
    AppMethodBeat.i(23097);
    this.piz = new a();
    AppMethodBeat.o(23097);
  }
  
  public o createApplication()
  {
    return this.piz;
  }
  
  public at createSubCore()
  {
    AppMethodBeat.i(23098);
    f localf = f.bYn();
    AppMethodBeat.o(23098);
    return localf;
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.Plugin
 * JD-Core Version:    0.7.0.1
 */