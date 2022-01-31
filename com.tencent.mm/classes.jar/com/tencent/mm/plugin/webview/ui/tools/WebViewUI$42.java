package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.ah.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class WebViewUI$42
  implements ah.b
{
  private Map<Integer, Integer> vgF;
  
  WebViewUI$42(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(153253);
    this.vgF = new HashMap();
    AppMethodBeat.o(153253);
  }
  
  public final void add(int paramInt)
  {
    AppMethodBeat.i(153254);
    WebViewUI.d(this.vgz, paramInt);
    if (this.vgF.containsKey(Integer.valueOf(paramInt)))
    {
      int i = ((Integer)this.vgF.get(Integer.valueOf(paramInt))).intValue();
      this.vgF.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
      AppMethodBeat.o(153254);
      return;
    }
    this.vgF.put(Integer.valueOf(paramInt), Integer.valueOf(1));
    AppMethodBeat.o(153254);
  }
  
  public final boolean dbU()
  {
    AppMethodBeat.i(153256);
    Iterator localIterator = this.vgF.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((Integer)((Map.Entry)localIterator.next()).getValue()).intValue() > 0)
      {
        AppMethodBeat.o(153256);
        return true;
      }
    }
    AppMethodBeat.o(153256);
    return false;
  }
  
  public final void remove(int paramInt)
  {
    AppMethodBeat.i(153255);
    WebViewUI.e(this.vgz, paramInt);
    if (this.vgF.containsKey(Integer.valueOf(paramInt)))
    {
      int i = ((Integer)this.vgF.get(Integer.valueOf(paramInt))).intValue();
      this.vgF.put(Integer.valueOf(paramInt), Integer.valueOf(i - 1));
      AppMethodBeat.o(153255);
      return;
    }
    this.vgF.put(Integer.valueOf(paramInt), Integer.valueOf(0));
    AppMethodBeat.o(153255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.42
 * JD-Core Version:    0.7.0.1
 */