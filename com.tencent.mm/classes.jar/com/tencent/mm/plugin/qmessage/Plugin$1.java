package com.tencent.mm.plugin.qmessage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class Plugin$1
  implements com.tencent.mm.pluginsdk.b.b
{
  Plugin$1(Plugin paramPlugin) {}
  
  public final com.tencent.mm.pluginsdk.b.a ab(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24063);
    if ("widget_type_contact".equals(paramString))
    {
      paramContext = new com.tencent.mm.plugin.qmessage.ui.a(paramContext);
      AppMethodBeat.o(24063);
      return paramContext;
    }
    paramContext = new com.tencent.mm.plugin.qmessage.ui.b(paramContext);
    AppMethodBeat.o(24063);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.Plugin.1
 * JD-Core Version:    0.7.0.1
 */