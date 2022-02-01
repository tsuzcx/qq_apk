package com.tencent.mm.plugin.wallet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  public n createApplication()
  {
    return null;
  }
  
  public az createSubCore()
  {
    AppMethodBeat.i(68367);
    s locals = new s();
    AppMethodBeat.o(68367);
    return locals;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.Plugin
 * JD-Core Version:    0.7.0.1
 */