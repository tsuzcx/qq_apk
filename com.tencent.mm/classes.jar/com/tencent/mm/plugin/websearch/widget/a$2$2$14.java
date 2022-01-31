package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.ah;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2$2$14
  extends ah
{
  a$2$2$14(a.2.2 param2) {}
  
  public final void qu(String paramString)
  {
    AppMethodBeat.i(91390);
    ab.v("FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onOpenApp" });
    a.a(this.uLV.uLU.uLR, paramString, this.uLV.uLU.uLT);
    AppMethodBeat.o(91390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.2.2.14
 * JD-Core Version:    0.7.0.1
 */