package com.tencent.mm.plugin.readerapp;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class Plugin$1
  implements com.tencent.mm.pluginsdk.b.b
{
  Plugin$1(Plugin paramPlugin) {}
  
  public final a ab(Context paramContext, String paramString)
  {
    AppMethodBeat.i(76736);
    ab.i("MicroMsg.ReaderApp.Plugin", "create contact widget type[%s]", new Object[] { paramString });
    if ("widget_type_news".equals(paramString))
    {
      paramContext = new com.tencent.mm.plugin.readerapp.ui.b(paramContext);
      AppMethodBeat.o(76736);
      return paramContext;
    }
    AppMethodBeat.o(76736);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.Plugin.1
 * JD-Core Version:    0.7.0.1
 */