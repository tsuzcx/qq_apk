package com.tencent.mm.ui.chatting.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.g.b.a.gs;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.ui.chatting.e.a;
import java.util.Map;

final class o$5
  implements e.c
{
  o$5(o paramo) {}
  
  public final void a(Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(233087);
    paramMap = new gs();
    paramMap.uu(this.PoG.dom.Pwh);
    paramMap.uv(this.PoG.dom.getTalkerUserName());
    paramMap.eKO = 1L;
    paramMap.eKP = 1L;
    paramMap.eKT = 1L;
    paramMap.bfK();
    AppMethodBeat.o(233087);
  }
  
  public final void b(String paramString, Map<String, String> paramMap, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.o.5
 * JD-Core Version:    0.7.0.1
 */