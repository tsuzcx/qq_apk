package com.tencent.mm.plugin.readerapp;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.readerapp.ui.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;

public final class Plugin
  implements d
{
  private c mQZ;
  
  public Plugin()
  {
    AppMethodBeat.i(102644);
    this.mQZ = new c()
    {
      public final com.tencent.mm.pluginsdk.b.a aa(Context paramAnonymousContext, String paramAnonymousString)
      {
        AppMethodBeat.i(102643);
        ad.i("MicroMsg.ReaderApp.Plugin", "create contact widget type[%s]", new Object[] { paramAnonymousString });
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
  
  public final m createApplication()
  {
    AppMethodBeat.i(102645);
    com.tencent.mm.plugin.readerapp.b.a locala = new com.tencent.mm.plugin.readerapp.b.a();
    AppMethodBeat.o(102645);
    return locala;
  }
  
  public final aw createSubCore()
  {
    return null;
  }
  
  public final c getContactWidgetFactory()
  {
    return this.mQZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.Plugin
 * JD-Core Version:    0.7.0.1
 */