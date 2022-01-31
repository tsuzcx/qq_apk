package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSSOSHomeWebViewUI$c
{
  String content;
  int icon;
  int position;
  int type;
  int vlh;
  
  private FTSSOSHomeWebViewUI$c(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(8474);
    paramObject = (c)paramObject;
    boolean bool = this.content.equals(paramObject.content);
    AppMethodBeat.o(8474);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.c
 * JD-Core Version:    0.7.0.1
 */