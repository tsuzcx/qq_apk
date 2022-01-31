package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.model.ac.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class WebViewUI$61
  implements ac.b
{
  private Map<Integer, Integer> rqm = new HashMap();
  
  WebViewUI$61(WebViewUI paramWebViewUI) {}
  
  public final void add(int paramInt)
  {
    WebViewUI.g(this.rpH, paramInt);
    if (this.rqm.containsKey(Integer.valueOf(paramInt)))
    {
      int i = ((Integer)this.rqm.get(Integer.valueOf(paramInt))).intValue();
      this.rqm.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
      return;
    }
    this.rqm.put(Integer.valueOf(paramInt), Integer.valueOf(1));
  }
  
  public final boolean cbR()
  {
    Iterator localIterator = this.rqm.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((Integer)((Map.Entry)localIterator.next()).getValue()).intValue() > 0) {
        return true;
      }
    }
    return false;
  }
  
  public final void remove(int paramInt)
  {
    WebViewUI.h(this.rpH, paramInt);
    if (this.rqm.containsKey(Integer.valueOf(paramInt)))
    {
      int i = ((Integer)this.rqm.get(Integer.valueOf(paramInt))).intValue();
      this.rqm.put(Integer.valueOf(paramInt), Integer.valueOf(i - 1));
      return;
    }
    this.rqm.put(Integer.valueOf(paramInt), Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.61
 * JD-Core Version:    0.7.0.1
 */