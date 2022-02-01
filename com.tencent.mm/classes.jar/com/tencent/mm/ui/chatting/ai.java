package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class ai
{
  private static ai PjY;
  int PjZ = 0;
  private int Pka = 0;
  
  public static ai gOk()
  {
    AppMethodBeat.i(34840);
    if (PjY == null) {
      PjY = new ai();
    }
    ai localai = PjY;
    AppMethodBeat.o(34840);
    return localai;
  }
  
  public final void amq(int paramInt)
  {
    AppMethodBeat.i(34841);
    if (this.PjZ > 0)
    {
      this.PjZ -= 1;
      AppMethodBeat.o(34841);
      return;
    }
    if (paramInt != this.Pka)
    {
      Log.i("MicroMsg.OrzChattingLifecycle", "notifyChattingStatus [%d]", new Object[] { Integer.valueOf(paramInt) });
      nl localnl = new nl();
      localnl.dTC.dTD = paramInt;
      EventCenter.instance.publish(localnl);
    }
    if ((paramInt == 1) || (paramInt == 4)) {
      this.Pka = paramInt;
    }
    AppMethodBeat.o(34841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ai
 * JD-Core Version:    0.7.0.1
 */