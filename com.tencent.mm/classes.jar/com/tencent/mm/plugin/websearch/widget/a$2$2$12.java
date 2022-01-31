package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.af;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2$2$12
  extends af
{
  a$2$2$12(a.2.2 param2) {}
  
  public final void b(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(91388);
    ab.v("FTSSearchWidgetMgr", "on widget call %s ", new Object[] { "onSearchWAWidgetOnTapCallback" });
    ab.i("FTSSearchWidgetMgr", "on widget call %s , hasHandler %s, eventId %s,res %s", new Object[] { "onSearchWAWidgetOnTapCallback", Boolean.valueOf(paramBoolean1), paramString, Boolean.valueOf(paramBoolean2) });
    r localr;
    if (paramString.equals(a.m(this.uLV.uLU.uLR)))
    {
      a.b(this.uLV.uLU.uLR, null);
      localr = a.c(this.uLV.uLU.uLR);
      if (!paramBoolean1) {
        break label134;
      }
    }
    for (;;)
    {
      localr.g(paramString, paramBoolean2, this.uLV.uLU.uLT);
      AppMethodBeat.o(91388);
      return;
      label134:
      paramBoolean2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.2.2.12
 * JD-Core Version:    0.7.0.1
 */