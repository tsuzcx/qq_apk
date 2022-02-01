package com.tencent.mm.plugin.voip_cs.d;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public final class b
{
  public int[] NVF;
  public int NVG;
  public int NVH;
  public MTimerHandler cts;
  public TextView rR;
  
  public b()
  {
    AppMethodBeat.i(125489);
    this.cts = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125488);
        int i = b.this.NVF[(b.this.NVH % b.this.NVF.length)];
        if (b.this.rR != null)
        {
          if (-1 != i) {
            break label78;
          }
          b.this.rR.setText(null);
        }
        for (;;)
        {
          b localb = b.this;
          localb.NVH += 1;
          AppMethodBeat.o(125488);
          return true;
          label78:
          b.this.rR.setText(i);
        }
      }
    }, true);
    AppMethodBeat.o(125489);
  }
  
  public final void gBX()
  {
    AppMethodBeat.i(125490);
    if (this.cts != null) {
      this.cts.stopTimer();
    }
    Log.printDebugStack("MicroMsg.DynamicTextWrap", "stop textview: " + this.rR, new Object[0]);
    this.rR = null;
    AppMethodBeat.o(125490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.d.b
 * JD-Core Version:    0.7.0.1
 */