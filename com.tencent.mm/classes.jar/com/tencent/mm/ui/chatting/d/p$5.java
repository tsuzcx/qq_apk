package com.tencent.mm.ui.chatting.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.f.b.a.ix;
import com.tencent.mm.plugin.messenger.a.e.d;
import com.tencent.mm.ui.chatting.e.a;
import java.util.Map;

final class p$5
  implements e.d
{
  p$5(p paramp) {}
  
  public final void a(Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(286533);
    paramMap = new ix();
    paramMap.zT(this.WIT.fgR.WQA);
    paramMap.zU(this.WIT.fgR.getTalkerUserName());
    paramMap.gKs = 1L;
    paramMap.gKt = 1L;
    paramMap.gKx = 1L;
    paramMap.bpa();
    AppMethodBeat.o(286533);
  }
  
  public final void b(String paramString, Map<String, String> paramMap, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.p.5
 * JD-Core Version:    0.7.0.1
 */