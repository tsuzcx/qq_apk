package com.tencent.mm.plugin.voip_cs.d;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;

public final class b
{
  public int[] CAU;
  public int CAV;
  public int CAW;
  public TextView Wf;
  public aw cji;
  
  public b()
  {
    AppMethodBeat.i(125489);
    this.cji = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125488);
        int i = b.this.CAU[(b.this.CAW % b.this.CAU.length)];
        if (b.this.Wf != null)
        {
          if (-1 != i) {
            break label78;
          }
          b.this.Wf.setText(null);
        }
        for (;;)
        {
          b localb = b.this;
          localb.CAW += 1;
          AppMethodBeat.o(125488);
          return true;
          label78:
          b.this.Wf.setText(i);
        }
      }
    }, true);
    AppMethodBeat.o(125489);
  }
  
  public final void eCG()
  {
    AppMethodBeat.i(125490);
    if (this.cji != null) {
      this.cji.stopTimer();
    }
    ae.l("MicroMsg.DynamicTextWrap", "stop textview: " + this.Wf, new Object[0]);
    this.Wf = null;
    AppMethodBeat.o(125490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.d.b
 * JD-Core Version:    0.7.0.1
 */