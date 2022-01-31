package com.tencent.mm.plugin.voip_cs.b.a;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class b$7$1
  implements Runnable
{
  b$7$1(b.7 param7) {}
  
  public final void run()
  {
    AppMethodBeat.i(135324);
    String str = b.ha(bo.gz(this.tLw.tLv.tLg));
    b.l(this.tLw.tLv).setText(str);
    AppMethodBeat.o(135324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.7.1
 * JD-Core Version:    0.7.0.1
 */