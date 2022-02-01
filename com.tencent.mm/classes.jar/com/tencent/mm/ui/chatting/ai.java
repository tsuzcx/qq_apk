package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.od;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class ai
{
  private static ai WDG;
  int WDH = 0;
  private int WDI = 0;
  
  public static ai hNu()
  {
    AppMethodBeat.i(34840);
    if (WDG == null) {
      WDG = new ai();
    }
    ai localai = WDG;
    AppMethodBeat.o(34840);
    return localai;
  }
  
  public final void avq(int paramInt)
  {
    AppMethodBeat.i(34841);
    if (this.WDH > 0)
    {
      this.WDH -= 1;
      AppMethodBeat.o(34841);
      return;
    }
    if (paramInt != this.WDI)
    {
      Log.i("MicroMsg.OrzChattingLifecycle", "notifyChattingStatus [%d]", new Object[] { Integer.valueOf(paramInt) });
      od localod = new od();
      localod.fMX.fMY = paramInt;
      EventCenter.instance.publish(localod);
    }
    if ((paramInt == 1) || (paramInt == 4)) {
      this.WDI = paramInt;
    }
    AppMethodBeat.o(34841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ai
 * JD-Core Version:    0.7.0.1
 */