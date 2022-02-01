package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class e
  implements g
{
  public final void a(Context paramContext, int paramInt, String paramString, n paramn)
  {
    AppMethodBeat.i(204736);
    h.aHG().aHp().set(ar.a.VvK, Integer.valueOf(110));
    h.aHG().aHp().set(ar.a.VvL, Integer.valueOf(1));
    d.a(paramContext, paramInt, null, paramString, paramn);
    AppMethodBeat.o(204736);
  }
  
  public final void aQ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(204739);
    d.aQ(paramString1, paramString2, paramString3);
    AppMethodBeat.o(204739);
  }
  
  public final boolean gpK()
  {
    AppMethodBeat.i(125892);
    boolean bool = b.WF((String)h.aHG().aHp().b(274436, null));
    if ((z.bde() & 0x4000000) > 0L) {}
    for (int i = 1; (!bool) && (i == 0); i = 0)
    {
      AppMethodBeat.o(125892);
      return true;
    }
    AppMethodBeat.o(125892);
    return false;
  }
  
  public final void iB(Context paramContext)
  {
    AppMethodBeat.i(204740);
    d.iC(paramContext);
    AppMethodBeat.o(204740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.e
 * JD-Core Version:    0.7.0.1
 */