package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.a.c;

public final class FTSBaseWebViewUI$a
  implements a.c
{
  int aBY;
  String smP;
  String userName;
  
  public FTSBaseWebViewUI$a(FTSBaseWebViewUI paramFTSBaseWebViewUI) {}
  
  public final int compareTo(Object paramObject)
  {
    AppMethodBeat.i(8397);
    if ((paramObject == null) || (!(paramObject instanceof a)))
    {
      AppMethodBeat.o(8397);
      return -1;
    }
    paramObject = (a)paramObject;
    int i = this.smP.compareTo(paramObject.smP);
    AppMethodBeat.o(8397);
    return i;
  }
  
  public final String getTagName()
  {
    return this.smP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.a
 * JD-Core Version:    0.7.0.1
 */