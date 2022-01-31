package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class r
{
  private static List<a> snG = new ArrayList();
  
  public static void a(a parama)
  {
    if (parama != null)
    {
      y.d("MicroMsg.WebViewPluginCenter", "add, plugin name = " + parama.getName());
      if (!snG.contains(parama)) {
        snG.add(parama);
      }
    }
  }
  
  public static void clear()
  {
    y.d("MicroMsg.WebViewPluginCenter", "clear");
    snG.clear();
  }
  
  public static List<a> cot()
  {
    return snG;
  }
  
  public static abstract interface a
  {
    public abstract void cfi();
    
    public abstract void cfj();
    
    public abstract void eA(Context paramContext);
    
    public abstract String getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.r
 * JD-Core Version:    0.7.0.1
 */