package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.l;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.pluginsdk.r.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class a$3
  implements a.a
{
  a$3(a parama) {}
  
  public final void ahA(String paramString)
  {
    AppMethodBeat.i(34631);
    com.tencent.mm.pluginsdk.h.a.a.dmE();
    aw.aaz();
    c.Yz().c(new l(3, paramString));
    AppMethodBeat.o(34631);
  }
  
  public final void iA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(34630);
    com.tencent.mm.pluginsdk.h.a.a.dmE();
    aw.aaz();
    c.Yz().c(new l(2, paramString1));
    ab.d("MicroMsg.ADBanner", "jump to ".concat(String.valueOf(paramString2)));
    r.a.vJD.a((Context)this.Amg.vUD.get(), paramString2, true);
    AppMethodBeat.o(34630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.a.3
 * JD-Core Version:    0.7.0.1
 */