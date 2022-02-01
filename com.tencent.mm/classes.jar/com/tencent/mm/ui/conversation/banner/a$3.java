package com.tencent.mm.ui.conversation.banner;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.m;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.pluginsdk.r.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class a$3
  implements a.a
{
  a$3(a parama) {}
  
  public final void bkM(String paramString)
  {
    AppMethodBeat.i(38758);
    com.tencent.mm.pluginsdk.k.a.a.iJP();
    bh.bCz();
    c.bzz().d(new m(3, paramString));
    AppMethodBeat.o(38758);
  }
  
  public final void qc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(38757);
    com.tencent.mm.pluginsdk.k.a.a.iJP();
    bh.bCz();
    c.bzz().d(new m(2, paramString1));
    Log.d("MicroMsg.ADBanner", "jump to ".concat(String.valueOf(paramString2)));
    r.a.XNV.b((Context)this.afsH.Ydi.get(), paramString2, true);
    AppMethodBeat.o(38757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.a.3
 * JD-Core Version:    0.7.0.1
 */