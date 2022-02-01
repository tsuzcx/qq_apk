package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.List;

public final class w
{
  private static List<a> DGk;
  
  static
  {
    AppMethodBeat.i(152428);
    DGk = new ArrayList();
    AppMethodBeat.o(152428);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(152426);
    if (parama != null)
    {
      ac.d("MicroMsg.WebViewPluginCenter", "add, plugin name = " + parama.getName());
      if (!DGk.contains(parama)) {
        DGk.add(parama);
      }
    }
    AppMethodBeat.o(152426);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(152427);
    ac.d("MicroMsg.WebViewPluginCenter", "clear");
    DGk.clear();
    AppMethodBeat.o(152427);
  }
  
  public static List<a> eQr()
  {
    return DGk;
  }
  
  public static abstract interface a
  {
    public abstract void eAi();
    
    public abstract void eAj();
    
    public abstract void gO(Context paramContext);
    
    public abstract String getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.w
 * JD-Core Version:    0.7.0.1
 */