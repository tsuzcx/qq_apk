package com.tencent.mm.plugin.shake;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.shake.model.m;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  private c PyK;
  
  public Plugin()
  {
    AppMethodBeat.i(28083);
    this.PyK = new c()
    {
      public final com.tencent.mm.pluginsdk.c.a al(Context paramAnonymousContext, String paramAnonymousString)
      {
        AppMethodBeat.i(28082);
        paramAnonymousContext = new com.tencent.mm.plugin.shake.ui.a(paramAnonymousContext);
        AppMethodBeat.o(28082);
        return paramAnonymousContext;
      }
    };
    AppMethodBeat.o(28083);
  }
  
  public n createApplication()
  {
    AppMethodBeat.i(28084);
    b localb = new b();
    AppMethodBeat.o(28084);
    return localb;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(28085);
    m localm = new m();
    AppMethodBeat.o(28085);
    return localm;
  }
  
  public c getContactWidgetFactory()
  {
    return this.PyK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.Plugin
 * JD-Core Version:    0.7.0.1
 */