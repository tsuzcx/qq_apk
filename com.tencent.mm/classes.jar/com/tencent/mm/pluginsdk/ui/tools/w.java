package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.List;

public final class w
{
  private static List<a> FDN;
  
  static
  {
    AppMethodBeat.i(152428);
    FDN = new ArrayList();
    AppMethodBeat.o(152428);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(152426);
    if (parama != null)
    {
      ae.d("MicroMsg.WebViewPluginCenter", "add, plugin name = " + parama.getName());
      if (!FDN.contains(parama)) {
        FDN.add(parama);
      }
    }
    AppMethodBeat.o(152426);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(152427);
    ae.d("MicroMsg.WebViewPluginCenter", "clear");
    FDN.clear();
    AppMethodBeat.o(152427);
  }
  
  public static List<a> fjj()
  {
    return FDN;
  }
  
  public static abstract interface a
  {
    public abstract void eSH();
    
    public abstract void eSI();
    
    public abstract void gZ(Context paramContext);
    
    public abstract String getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.w
 * JD-Core Version:    0.7.0.1
 */