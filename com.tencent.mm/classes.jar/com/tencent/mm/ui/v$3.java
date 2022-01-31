package com.tencent.mm.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.pluginsdk.model.app.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class v$3
  implements Runnable
{
  v$3(int paramInt, String paramString, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(29597);
    if ((this.zbU == 4) && (a.dlr() == null))
    {
      ab.w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
      AppMethodBeat.o(29597);
      return;
    }
    if ((d.bSu() != null) && (d.bSu().Uc(this.iiy) != null)) {
      al.d(new v.3.1(this));
    }
    AppMethodBeat.o(29597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.v.3
 * JD-Core Version:    0.7.0.1
 */