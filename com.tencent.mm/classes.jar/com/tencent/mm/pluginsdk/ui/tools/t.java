package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class t
{
  private static List<t.a> wgb;
  
  static
  {
    AppMethodBeat.i(79959);
    wgb = new ArrayList();
    AppMethodBeat.o(79959);
  }
  
  public static void a(t.a parama)
  {
    AppMethodBeat.i(79957);
    if (parama != null)
    {
      ab.d("MicroMsg.WebViewPluginCenter", "add, plugin name = " + parama.getName());
      if (!wgb.contains(parama)) {
        wgb.add(parama);
      }
    }
    AppMethodBeat.o(79957);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(79958);
    ab.d("MicroMsg.WebViewPluginCenter", "clear");
    wgb.clear();
    AppMethodBeat.o(79958);
  }
  
  public static List<t.a> dpK()
  {
    return wgb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.t
 * JD-Core Version:    0.7.0.1
 */