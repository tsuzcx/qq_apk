package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.pl;
import com.tencent.mm.sdk.platformtools.Log;

public final class al
{
  private static al aelg;
  int aelh = 0;
  private int aeli = 0;
  
  public static al jqa()
  {
    AppMethodBeat.i(34840);
    if (aelg == null) {
      aelg = new al();
    }
    al localal = aelg;
    AppMethodBeat.o(34840);
    return localal;
  }
  
  public final void aBS(int paramInt)
  {
    AppMethodBeat.i(34841);
    if (this.aelh > 0)
    {
      this.aelh -= 1;
      AppMethodBeat.o(34841);
      return;
    }
    if (paramInt != this.aeli)
    {
      Log.i("MicroMsg.OrzChattingLifecycle", "notifyChattingStatus [%d]", new Object[] { Integer.valueOf(paramInt) });
      pl localpl = new pl();
      localpl.hSH.hSI = paramInt;
      localpl.publish();
    }
    if ((paramInt == 1) || (paramInt == 4)) {
      this.aeli = paramInt;
    }
    AppMethodBeat.o(34841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al
 * JD-Core Version:    0.7.0.1
 */