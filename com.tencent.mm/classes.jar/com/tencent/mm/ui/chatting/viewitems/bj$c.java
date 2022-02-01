package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.ui.widget.MMNeat7extView.b;
import java.util.HashMap;
import java.util.Map;

final class bj$c
  implements MMNeat7extView.b
{
  public final void a(Exception paramException, String paramString1, String paramString2)
  {
    AppMethodBeat.i(37417);
    if (!d.Yxi)
    {
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("Content", paramString1);
      localHashMap.put("Exception", paramException.toString());
      localHashMap.put("Stack", paramException.getStackTrace());
      h.OAn.e("NeatTextView", paramString2, localHashMap);
    }
    AppMethodBeat.o(37417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj.c
 * JD-Core Version:    0.7.0.1
 */