package com.tencent.mm.plugin.voip_cs.c;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public final class b
{
  public ap bAz;
  public TextView md;
  public int[] tCH;
  public int tCI;
  public int tCJ;
  
  public b()
  {
    AppMethodBeat.i(135438);
    this.bAz = new ap(new b.1(this), true);
    AppMethodBeat.o(135438);
  }
  
  public final void cOZ()
  {
    AppMethodBeat.i(135439);
    if (this.bAz != null) {
      this.bAz.stopTimer();
    }
    ab.a("MicroMsg.DynamicTextWrap", "stop textview: " + this.md, new Object[0]);
    this.md = null;
    AppMethodBeat.o(135439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.b
 * JD-Core Version:    0.7.0.1
 */