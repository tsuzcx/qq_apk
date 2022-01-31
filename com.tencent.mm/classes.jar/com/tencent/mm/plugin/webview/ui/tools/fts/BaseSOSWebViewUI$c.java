package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.fts.ui.widget.a.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class BaseSOSWebViewUI$c
{
  List<a.b> iSZ;
  String rtJ = "";
  String rtK = "";
  Map<String, Object> rtL = new HashMap();
  int type;
  
  protected BaseSOSWebViewUI$c(BaseSOSWebViewUI paramBaseSOSWebViewUI) {}
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof c)) {
        break;
      }
      paramObject = (c)paramObject;
    } while ((paramObject.type == this.type) && (paramObject.rtK.equals(this.rtK)));
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.c
 * JD-Core Version:    0.7.0.1
 */