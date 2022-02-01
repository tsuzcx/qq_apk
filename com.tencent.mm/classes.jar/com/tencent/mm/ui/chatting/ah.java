package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class ah
{
  private static ah JDU;
  int JDV = 0;
  private int JDW = 0;
  
  public static ah fCe()
  {
    AppMethodBeat.i(34840);
    if (JDU == null) {
      JDU = new ah();
    }
    ah localah = JDU;
    AppMethodBeat.o(34840);
    return localah;
  }
  
  public final void acX(int paramInt)
  {
    AppMethodBeat.i(34841);
    if (this.JDV > 0)
    {
      this.JDV -= 1;
      AppMethodBeat.o(34841);
      return;
    }
    if (paramInt != this.JDW)
    {
      ad.i("MicroMsg.OrzChattingLifecycle", "notifyChattingStatus [%d]", new Object[] { Integer.valueOf(paramInt) });
      mt localmt = new mt();
      localmt.dAI.dAJ = paramInt;
      a.IbL.l(localmt);
    }
    if ((paramInt == 1) || (paramInt == 4)) {
      this.JDW = paramInt;
    }
    AppMethodBeat.o(34841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ah
 * JD-Core Version:    0.7.0.1
 */