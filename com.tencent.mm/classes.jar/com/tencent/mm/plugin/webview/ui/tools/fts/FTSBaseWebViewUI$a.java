package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.fts.ui.widget.a.b;

public final class FTSBaseWebViewUI$a
  implements a.b
{
  String rtH;
  int rtI;
  String userName;
  
  public FTSBaseWebViewUI$a(FTSBaseWebViewUI paramFTSBaseWebViewUI) {}
  
  public final int compareTo(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof a))) {
      return -1;
    }
    paramObject = (a)paramObject;
    return this.rtH.compareTo(paramObject.rtH);
  }
  
  public final String getTagName()
  {
    return this.rtH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.a
 * JD-Core Version:    0.7.0.1
 */