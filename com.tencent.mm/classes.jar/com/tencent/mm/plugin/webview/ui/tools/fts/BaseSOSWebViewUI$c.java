package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.a.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class BaseSOSWebViewUI$c
{
  List<a.c> lbK;
  int type;
  String vjO;
  String vjP;
  Map<String, Object> vjQ;
  
  protected BaseSOSWebViewUI$c(BaseSOSWebViewUI paramBaseSOSWebViewUI)
  {
    AppMethodBeat.i(8357);
    this.vjO = "";
    this.vjP = "";
    this.vjQ = new HashMap();
    AppMethodBeat.o(8357);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(8358);
    if (this == paramObject)
    {
      AppMethodBeat.o(8358);
      return true;
    }
    if ((paramObject instanceof c))
    {
      paramObject = (c)paramObject;
      if ((paramObject.type == this.type) && (paramObject.vjP.equals(this.vjP)))
      {
        AppMethodBeat.o(8358);
        return true;
      }
      AppMethodBeat.o(8358);
      return false;
    }
    AppMethodBeat.o(8358);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.c
 * JD-Core Version:    0.7.0.1
 */