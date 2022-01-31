package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.ui.widget.MMNeat7extView.b;
import java.util.HashMap;
import java.util.Map;

final class am$c
  implements MMNeat7extView.b
{
  public final void a(Exception paramException, String paramString1, String paramString2)
  {
    AppMethodBeat.i(33318);
    if (!d.whI)
    {
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("Content", paramString1);
      localHashMap.put("Exception", paramException.toString());
      localHashMap.put("Stack", paramException.getStackTrace());
      h.qsU.g("NeatTextView", paramString2, localHashMap);
    }
    AppMethodBeat.o(33318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.c
 * JD-Core Version:    0.7.0.1
 */