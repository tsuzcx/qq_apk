package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.model.u;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class e
  implements com.tencent.mm.plugin.topstory.a.g
{
  public final void bh(Context paramContext, String paramString)
  {
    AppMethodBeat.i(125891);
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRT, Integer.valueOf(110));
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRU, Integer.valueOf(1));
    d.a(paramContext, 322, null, paramString);
    AppMethodBeat.o(125891);
  }
  
  public final boolean ecr()
  {
    AppMethodBeat.i(125892);
    boolean bool = b.CQ((String)com.tencent.mm.kernel.g.agR().agA().get(274436, null));
    if ((u.axB() & 0x4000000) > 0L) {}
    for (int i = 1; (!bool) && (i == 0); i = 0)
    {
      AppMethodBeat.o(125892);
      return true;
    }
    AppMethodBeat.o(125892);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.e
 * JD-Core Version:    0.7.0.1
 */