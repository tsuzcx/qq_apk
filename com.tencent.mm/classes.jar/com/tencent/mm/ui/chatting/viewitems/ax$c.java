package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.ui.widget.MMNeat7extView.b;
import java.util.HashMap;
import java.util.Map;

final class ax$c
  implements MMNeat7extView.b
{
  public final void a(Exception paramException, String paramString1, String paramString2)
  {
    AppMethodBeat.i(37417);
    if (!d.FFI)
    {
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("Content", paramString1);
      localHashMap.put("Exception", paramException.toString());
      localHashMap.put("Stack", paramException.getStackTrace());
      g.yxI.g("NeatTextView", paramString2, localHashMap);
    }
    AppMethodBeat.o(37417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax.c
 * JD-Core Version:    0.7.0.1
 */