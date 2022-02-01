package com.tencent.mm.plugin.voip_cs.b;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public final class b
{
  public int[] UKv;
  public int Uvy;
  public int Uvz;
  public MTimerHandler eln;
  public TextView sQ;
  
  public b()
  {
    AppMethodBeat.i(125489);
    this.eln = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125488);
        int i = b.this.UKv[(b.this.Uvz % b.this.UKv.length)];
        if (b.this.sQ != null)
        {
          if (-1 != i) {
            break label78;
          }
          b.this.sQ.setText(null);
        }
        for (;;)
        {
          b localb = b.this;
          localb.Uvz += 1;
          AppMethodBeat.o(125488);
          return true;
          label78:
          b.this.sQ.setText(i);
        }
      }
    }, true);
    AppMethodBeat.o(125489);
  }
  
  public final void hVz()
  {
    AppMethodBeat.i(125490);
    if (this.eln != null) {
      this.eln.stopTimer();
    }
    Log.printDebugStack("MicroMsg.DynamicTextWrap", "stop textview: " + this.sQ, new Object[0]);
    this.sQ = null;
    AppMethodBeat.o(125490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.b
 * JD-Core Version:    0.7.0.1
 */