package com.tencent.mm.ui.chatting.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.g.b.a.dq;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.ui.chatting.e.a;
import java.util.Map;

final class o$5
  implements e.c
{
  o$5(o paramo) {}
  
  public final void a(Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(187327);
    paramMap = new dq();
    paramMap.nn(this.Kdh.cXJ.Kki);
    paramMap.no(this.Kdh.cXJ.getTalkerUserName());
    paramMap.eit = 1L;
    paramMap.eiu = 1L;
    paramMap.eiy = 1L;
    paramMap.aLH();
    AppMethodBeat.o(187327);
  }
  
  public final void b(String paramString, Map<String, String> paramMap, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.o.5
 * JD-Core Version:    0.7.0.1
 */