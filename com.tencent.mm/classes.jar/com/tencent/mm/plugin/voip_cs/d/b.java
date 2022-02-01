package com.tencent.mm.plugin.voip_cs.d;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public final class b
{
  public int[] HeN;
  public int HeO;
  public int HeP;
  public TextView Ws;
  public MTimerHandler cve;
  
  public b()
  {
    AppMethodBeat.i(125489);
    this.cve = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125488);
        int i = b.this.HeN[(b.this.HeP % b.this.HeN.length)];
        if (b.this.Ws != null)
        {
          if (-1 != i) {
            break label78;
          }
          b.this.Ws.setText(null);
        }
        for (;;)
        {
          b localb = b.this;
          localb.HeP += 1;
          AppMethodBeat.o(125488);
          return true;
          label78:
          b.this.Ws.setText(i);
        }
      }
    }, true);
    AppMethodBeat.o(125489);
  }
  
  public final void fJB()
  {
    AppMethodBeat.i(125490);
    if (this.cve != null) {
      this.cve.stopTimer();
    }
    Log.printDebugStack("MicroMsg.DynamicTextWrap", "stop textview: " + this.Ws, new Object[0]);
    this.Ws = null;
    AppMethodBeat.o(125490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.d.b
 * JD-Core Version:    0.7.0.1
 */