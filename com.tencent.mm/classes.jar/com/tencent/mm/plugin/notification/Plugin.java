package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;

public class Plugin
  implements d
{
  a uhc;
  
  public Plugin()
  {
    AppMethodBeat.i(26723);
    this.uhc = new a();
    AppMethodBeat.o(26723);
  }
  
  public m createApplication()
  {
    return this.uhc;
  }
  
  public aw createSubCore()
  {
    AppMethodBeat.i(26724);
    f localf = f.cXZ();
    AppMethodBeat.o(26724);
    return localf;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.Plugin
 * JD-Core Version:    0.7.0.1
 */