package com.tencent.mm.ui.widget.cedit.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.HashMap;
import java.util.Map;

final class MMCustomEditText$2
  implements a
{
  MMCustomEditText$2(MMCustomEditText paramMMCustomEditText) {}
  
  public final void a(Throwable paramThrowable, String paramString1, String paramString2)
  {
    AppMethodBeat.i(252192);
    HashMap localHashMap = new HashMap();
    localHashMap.put("Content", paramString1);
    localHashMap.put("Exception", paramThrowable.toString());
    localHashMap.put("Stack", paramThrowable.getStackTrace());
    h.OAn.e("CustomEditView", paramString2, localHashMap);
    AppMethodBeat.o(252192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.api.MMCustomEditText.2
 * JD-Core Version:    0.7.0.1
 */