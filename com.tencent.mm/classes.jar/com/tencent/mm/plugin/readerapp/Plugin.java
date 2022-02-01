package com.tencent.mm.plugin.readerapp;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.readerapp.ui.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ae;

public final class Plugin
  implements d
{
  private c nZR;
  
  public Plugin()
  {
    AppMethodBeat.i(102644);
    this.nZR = new c()
    {
      public final com.tencent.mm.pluginsdk.b.a ac(Context paramAnonymousContext, String paramAnonymousString)
      {
        AppMethodBeat.i(102643);
        ae.i("MicroMsg.ReaderApp.Plugin", "create contact widget type[%s]", new Object[] { paramAnonymousString });
        if ("widget_type_news".equals(paramAnonymousString))
        {
          paramAnonymousContext = new b(paramAnonymousContext);
          AppMethodBeat.o(102643);
          return paramAnonymousContext;
        }
        AppMethodBeat.o(102643);
        return null;
      }
    };
    AppMethodBeat.o(102644);
  }
  
  public final n createApplication()
  {
    AppMethodBeat.i(102645);
    com.tencent.mm.plugin.readerapp.b.a locala = new com.tencent.mm.plugin.readerapp.b.a();
    AppMethodBeat.o(102645);
    return locala;
  }
  
  public final az createSubCore()
  {
    return null;
  }
  
  public final c getContactWidgetFactory()
  {
    return this.nZR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.Plugin
 * JD-Core Version:    0.7.0.1
 */