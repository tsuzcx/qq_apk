package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class d
  implements com.tencent.mm.plugin.topstory.a.g
{
  public final void aW(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(236381);
    c.aW(paramString1, paramString2, paramString3);
    AppMethodBeat.o(236381);
  }
  
  public final void bF(Context paramContext, String paramString)
  {
    AppMethodBeat.i(125891);
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ohu, Integer.valueOf(110));
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ohv, Integer.valueOf(1));
    c.a(paramContext, 322, null, paramString);
    AppMethodBeat.o(125891);
  }
  
  public final boolean fxP()
  {
    AppMethodBeat.i(125892);
    boolean bool = b.Pi((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null));
    if ((z.aUd() & 0x4000000) > 0L) {}
    for (int i = 1; (!bool) && (i == 0); i = 0)
    {
      AppMethodBeat.o(125892);
      return true;
    }
    AppMethodBeat.o(125892);
    return false;
  }
  
  public final void hv(Context paramContext)
  {
    AppMethodBeat.i(236382);
    c.hw(paramContext);
    AppMethodBeat.o(236382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.d
 * JD-Core Version:    0.7.0.1
 */