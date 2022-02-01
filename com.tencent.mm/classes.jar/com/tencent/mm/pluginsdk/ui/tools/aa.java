package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class aa
{
  private static List<a> Ryi;
  
  static
  {
    AppMethodBeat.i(152428);
    Ryi = new ArrayList();
    AppMethodBeat.o(152428);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(152426);
    if (parama != null)
    {
      Log.d("MicroMsg.WebViewPluginCenter", "add, plugin name = " + parama.getName());
      if (!Ryi.contains(parama)) {
        Ryi.add(parama);
      }
    }
    AppMethodBeat.o(152426);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(152427);
    Log.d("MicroMsg.WebViewPluginCenter", "clear");
    Ryi.clear();
    AppMethodBeat.o(152427);
  }
  
  public static List<a> hnR()
  {
    return Ryi;
  }
  
  public static abstract interface a
  {
    public abstract void gUn();
    
    public abstract void gUo();
    
    public abstract String getName();
    
    public abstract void iZ(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.aa
 * JD-Core Version:    0.7.0.1
 */