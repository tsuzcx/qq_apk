package com.tencent.mm.pluginsdk.ui.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class m$a
  implements Runnable
{
  m$a(m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(79868);
    if ((m.a(this.wcJ) != null) && (m.a(this.wcJ).isPressed()))
    {
      ab.d("MicroMsg.PressSpanTouchListener", "long pressed timeout");
      m.b(this.wcJ);
      this.wcJ.aEa();
    }
    AppMethodBeat.o(79868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.m.a
 * JD-Core Version:    0.7.0.1
 */