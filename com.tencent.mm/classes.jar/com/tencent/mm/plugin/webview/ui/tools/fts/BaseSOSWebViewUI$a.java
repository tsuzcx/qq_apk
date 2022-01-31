package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.fts.ui.widget.a.b;

public final class BaseSOSWebViewUI$a
  implements a.b
{
  String rtH;
  int rtI;
  String userName;
  
  public BaseSOSWebViewUI$a(BaseSOSWebViewUI paramBaseSOSWebViewUI) {}
  
  public final int compareTo(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof FTSBaseWebViewUI.a))) {
      return -1;
    }
    paramObject = (FTSBaseWebViewUI.a)paramObject;
    return this.rtH.compareTo(paramObject.rtH);
  }
  
  public final String getTagName()
  {
    return this.rtH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.a
 * JD-Core Version:    0.7.0.1
 */