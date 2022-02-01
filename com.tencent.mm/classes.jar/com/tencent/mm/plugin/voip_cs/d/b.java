package com.tencent.mm.plugin.voip_cs.d;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;

public final class b
{
  public int[] AKo;
  public int AKp;
  public int AKq;
  public TextView Up;
  public au bYO;
  
  public b()
  {
    AppMethodBeat.i(125489);
    this.bYO = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125488);
        int i = b.this.AKo[(b.this.AKq % b.this.AKo.length)];
        if (b.this.Up != null)
        {
          if (-1 != i) {
            break label78;
          }
          b.this.Up.setText(null);
        }
        for (;;)
        {
          b localb = b.this;
          localb.AKq += 1;
          AppMethodBeat.o(125488);
          return true;
          label78:
          b.this.Up.setText(i);
        }
      }
    }, true);
    AppMethodBeat.o(125489);
  }
  
  public final void elo()
  {
    AppMethodBeat.i(125490);
    if (this.bYO != null) {
      this.bYO.stopTimer();
    }
    ac.l("MicroMsg.DynamicTextWrap", "stop textview: " + this.Up, new Object[0]);
    this.Up = null;
    AppMethodBeat.o(125490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.d.b
 * JD-Core Version:    0.7.0.1
 */