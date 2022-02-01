package com.tencent.mm.plugin.qmessage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.plugin.qmessage.ui.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  private c nUl;
  
  public Plugin()
  {
    AppMethodBeat.i(27706);
    this.nUl = new c()
    {
      public final com.tencent.mm.pluginsdk.b.a aa(Context paramAnonymousContext, String paramAnonymousString)
      {
        AppMethodBeat.i(27705);
        if ("widget_type_contact".equals(paramAnonymousString))
        {
          paramAnonymousContext = new com.tencent.mm.plugin.qmessage.ui.a(paramAnonymousContext);
          AppMethodBeat.o(27705);
          return paramAnonymousContext;
        }
        paramAnonymousContext = new b(paramAnonymousContext);
        AppMethodBeat.o(27705);
        return paramAnonymousContext;
      }
    };
    AppMethodBeat.o(27706);
  }
  
  public n createApplication()
  {
    AppMethodBeat.i(27707);
    a locala = new a();
    AppMethodBeat.o(27707);
    return locala;
  }
  
  public ax createSubCore()
  {
    AppMethodBeat.i(27708);
    g localg = new g();
    AppMethodBeat.o(27708);
    return localg;
  }
  
  public c getContactWidgetFactory()
  {
    return this.nUl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.Plugin
 * JD-Core Version:    0.7.0.1
 */