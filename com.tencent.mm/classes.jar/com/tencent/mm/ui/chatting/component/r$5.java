package com.tencent.mm.ui.chatting.component;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.autogen.mmdata.rpt.lh;
import com.tencent.mm.plugin.messenger.a.e.d;
import com.tencent.mm.ui.chatting.d.a;
import java.util.Map;

final class r$5
  implements e.d
{
  r$5(r paramr) {}
  
  public final void a(Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(256017);
    paramMap = new lh();
    paramMap.ue(this.aeqZ.hlc.aezT);
    paramMap.uf(this.aeqZ.hlc.getTalkerUserName());
    paramMap.iZI = 1L;
    paramMap.iZJ = 1L;
    paramMap.iZN = 1L;
    paramMap.bMH();
    AppMethodBeat.o(256017);
  }
  
  public final void b(String paramString, Map<String, String> paramMap, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.r.5
 * JD-Core Version:    0.7.0.1
 */