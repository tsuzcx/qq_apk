package com.tencent.mm.plugin.shake;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  private c Dgq;
  
  public Plugin()
  {
    AppMethodBeat.i(28083);
    this.Dgq = new c()
    {
      public final com.tencent.mm.pluginsdk.b.a ak(Context paramAnonymousContext, String paramAnonymousString)
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
    a locala = new a();
    AppMethodBeat.o(28084);
    return locala;
  }
  
  public bd createSubCore()
  {
    AppMethodBeat.i(28085);
    m localm = new m();
    AppMethodBeat.o(28085);
    return localm;
  }
  
  public c getContactWidgetFactory()
  {
    return this.Dgq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.Plugin
 * JD-Core Version:    0.7.0.1
 */