package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.a.c;

public final class BaseSOSWebViewUI$a
  implements a.c
{
  int aBY;
  String smP;
  String userName;
  
  public BaseSOSWebViewUI$a(BaseSOSWebViewUI paramBaseSOSWebViewUI) {}
  
  public final int compareTo(Object paramObject)
  {
    AppMethodBeat.i(8350);
    if ((paramObject == null) || (!(paramObject instanceof FTSBaseWebViewUI.a)))
    {
      AppMethodBeat.o(8350);
      return -1;
    }
    paramObject = (FTSBaseWebViewUI.a)paramObject;
    int i = this.smP.compareTo(paramObject.smP);
    AppMethodBeat.o(8350);
    return i;
  }
  
  public final String getTagName()
  {
    return this.smP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.a
 * JD-Core Version:    0.7.0.1
 */