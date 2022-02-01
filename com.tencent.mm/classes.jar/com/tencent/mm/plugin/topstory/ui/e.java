package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class e
  implements com.tencent.mm.plugin.topstory.a.f
{
  public final void a(Context paramContext, int paramInt, String paramString, p paramp)
  {
    AppMethodBeat.i(271682);
    h.baE().ban().set(at.a.acXu, Integer.valueOf(110));
    h.baE().ban().set(at.a.acXv, Integer.valueOf(1));
    d.a(paramContext, paramInt, null, paramString, paramp);
    AppMethodBeat.o(271682);
  }
  
  public final void bi(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(271684);
    d.bi(paramString1, paramString2, paramString3);
    AppMethodBeat.o(271684);
  }
  
  public final boolean hMG()
  {
    AppMethodBeat.i(125892);
    boolean bool = b.OE((String)h.baE().ban().d(274436, null));
    if ((z.bAR() & 0x4000000) > 0L) {}
    for (int i = 1; (!bool) && (i == 0); i = 0)
    {
      AppMethodBeat.o(125892);
      return true;
    }
    AppMethodBeat.o(125892);
    return false;
  }
  
  public final void kt(Context paramContext)
  {
    AppMethodBeat.i(271686);
    d.ku(paramContext);
    AppMethodBeat.o(271686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.e
 * JD-Core Version:    0.7.0.1
 */