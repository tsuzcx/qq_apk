package com.tencent.mm.plugin.voip_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    return null;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(125335);
    com.tencent.mm.plugin.voip_cs.c.c localc = new com.tencent.mm.plugin.voip_cs.c.c();
    AppMethodBeat.o(125335);
    return localc;
  }
  
  public com.tencent.mm.pluginsdk.c.c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.Plugin
 * JD-Core Version:    0.7.0.1
 */