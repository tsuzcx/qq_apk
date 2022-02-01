package com.tencent.mm.plugin.nearby;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.nearby.a.f;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  private c smX;
  
  public Plugin()
  {
    AppMethodBeat.i(89751);
    this.smX = new c()
    {
      public final com.tencent.mm.pluginsdk.c.a ak(Context paramAnonymousContext, String paramAnonymousString)
      {
        AppMethodBeat.i(89750);
        paramAnonymousContext = new com.tencent.mm.plugin.nearby.ui.a(paramAnonymousContext);
        AppMethodBeat.o(89750);
        return paramAnonymousContext;
      }
    };
    AppMethodBeat.o(89751);
  }
  
  public n createApplication()
  {
    AppMethodBeat.i(89752);
    a locala = new a();
    AppMethodBeat.o(89752);
    return locala;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(89753);
    f localf = new f();
    AppMethodBeat.o(89753);
    return localf;
  }
  
  public c getContactWidgetFactory()
  {
    return this.smX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.Plugin
 * JD-Core Version:    0.7.0.1
 */