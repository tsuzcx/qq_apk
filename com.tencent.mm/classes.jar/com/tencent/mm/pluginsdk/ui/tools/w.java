package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public final class w
{
  private static List<a> Flp;
  
  static
  {
    AppMethodBeat.i(152428);
    Flp = new ArrayList();
    AppMethodBeat.o(152428);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(152426);
    if (parama != null)
    {
      ad.d("MicroMsg.WebViewPluginCenter", "add, plugin name = " + parama.getName());
      if (!Flp.contains(parama)) {
        Flp.add(parama);
      }
    }
    AppMethodBeat.o(152426);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(152427);
    ad.d("MicroMsg.WebViewPluginCenter", "clear");
    Flp.clear();
    AppMethodBeat.o(152427);
  }
  
  public static List<a> fft()
  {
    return Flp;
  }
  
  public static abstract interface a
  {
    public abstract void eOW();
    
    public abstract void eOX();
    
    public abstract void gT(Context paramContext);
    
    public abstract String getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.w
 * JD-Core Version:    0.7.0.1
 */