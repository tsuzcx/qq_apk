package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ax.b;
import com.tencent.mm.model.u;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class e
  implements com.tencent.mm.plugin.topstory.a.g
{
  public final void bk(Context paramContext, String paramString)
  {
    AppMethodBeat.i(125891);
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEx, Integer.valueOf(110));
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEy, Integer.valueOf(1));
    d.a(paramContext, 322, null, paramString);
    AppMethodBeat.o(125891);
  }
  
  public final boolean eoI()
  {
    AppMethodBeat.i(125892);
    boolean bool = b.FU((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null));
    if ((u.aAr() & 0x4000000) > 0L) {}
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