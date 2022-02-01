package com.tencent.mm.plugin.shake;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;

public class Plugin
  implements d
{
  private c xwD;
  
  public Plugin()
  {
    AppMethodBeat.i(28083);
    this.xwD = new c()
    {
      public final com.tencent.mm.pluginsdk.b.a ab(Context paramAnonymousContext, String paramAnonymousString)
      {
        AppMethodBeat.i(28082);
        paramAnonymousContext = new com.tencent.mm.plugin.shake.ui.a(paramAnonymousContext);
        AppMethodBeat.o(28082);
        return paramAnonymousContext;
      }
    };
    AppMethodBeat.o(28083);
  }
  
  public com.tencent.mm.pluginsdk.m createApplication()
  {
    AppMethodBeat.i(28084);
    a locala = new a();
    AppMethodBeat.o(28084);
    return locala;
  }
  
  public aw createSubCore()
  {
    AppMethodBeat.i(28085);
    com.tencent.mm.plugin.shake.b.m localm = new com.tencent.mm.plugin.shake.b.m();
    AppMethodBeat.o(28085);
    return localm;
  }
  
  public c getContactWidgetFactory()
  {
    return this.xwD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.Plugin
 * JD-Core Version:    0.7.0.1
 */