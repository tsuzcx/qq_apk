package com.tencent.mm.plugin.nearby;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.b.b;

final class Plugin$1
  implements b
{
  Plugin$1(Plugin paramPlugin) {}
  
  public final com.tencent.mm.pluginsdk.b.a ab(Context paramContext, String paramString)
  {
    AppMethodBeat.i(55348);
    paramContext = new com.tencent.mm.plugin.nearby.ui.a(paramContext);
    AppMethodBeat.o(55348);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.Plugin.1
 * JD-Core Version:    0.7.0.1
 */