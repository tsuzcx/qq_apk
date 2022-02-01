package com.tencent.mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements d
{
  public final n createApplication()
  {
    AppMethodBeat.i(114797);
    c localc = new c();
    AppMethodBeat.o(114797);
    return localc;
  }
  
  public final be createSubCore()
  {
    AppMethodBeat.i(114798);
    SubCoreVoip localSubCoreVoip = new SubCoreVoip();
    AppMethodBeat.o(114798);
    return localSubCoreVoip;
  }
  
  public final com.tencent.mm.pluginsdk.c.c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.Plugin
 * JD-Core Version:    0.7.0.1
 */