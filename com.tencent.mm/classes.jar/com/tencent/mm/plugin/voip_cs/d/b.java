package com.tencent.mm.plugin.voip_cs.d;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public final class b
{
  public TextView Tu;
  public av cbR;
  public int[] zrD;
  public int zrE;
  public int zrF;
  
  public b()
  {
    AppMethodBeat.i(125489);
    this.cbR = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125488);
        int i = b.this.zrD[(b.this.zrF % b.this.zrD.length)];
        if (b.this.Tu != null)
        {
          if (-1 != i) {
            break label78;
          }
          b.this.Tu.setText(null);
        }
        for (;;)
        {
          b localb = b.this;
          localb.zrF += 1;
          AppMethodBeat.o(125488);
          return true;
          label78:
          b.this.Tu.setText(i);
        }
      }
    }, true);
    AppMethodBeat.o(125489);
  }
  
  public final void dWc()
  {
    AppMethodBeat.i(125490);
    if (this.cbR != null) {
      this.cbR.stopTimer();
    }
    ad.l("MicroMsg.DynamicTextWrap", "stop textview: " + this.Tu, new Object[0]);
    this.Tu = null;
    AppMethodBeat.o(125490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.d.b
 * JD-Core Version:    0.7.0.1
 */