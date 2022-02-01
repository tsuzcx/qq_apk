package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  b AGF;
  
  public Plugin()
  {
    AppMethodBeat.i(26723);
    this.AGF = new b();
    AppMethodBeat.o(26723);
  }
  
  public n createApplication()
  {
    return this.AGF;
  }
  
  public bd createSubCore()
  {
    AppMethodBeat.i(26724);
    f localf = f.eyV();
    AppMethodBeat.o(26724);
    return localf;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.Plugin
 * JD-Core Version:    0.7.0.1
 */