package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class ah
{
  private static ah HQf;
  int HQg = 0;
  private int HQh = 0;
  
  public static ah flN()
  {
    AppMethodBeat.i(34840);
    if (HQf == null) {
      HQf = new ah();
    }
    ah localah = HQf;
    AppMethodBeat.o(34840);
    return localah;
  }
  
  public final void aaM(int paramInt)
  {
    AppMethodBeat.i(34841);
    if (this.HQg > 0)
    {
      this.HQg -= 1;
      AppMethodBeat.o(34841);
      return;
    }
    if (paramInt != this.HQh)
    {
      ac.i("MicroMsg.OrzChattingLifecycle", "notifyChattingStatus [%d]", new Object[] { Integer.valueOf(paramInt) });
      mk localmk = new mk();
      localmk.doU.doV = paramInt;
      a.GpY.l(localmk);
    }
    if ((paramInt == 1) || (paramInt == 4)) {
      this.HQh = paramInt;
    }
    AppMethodBeat.o(34841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ah
 * JD-Core Version:    0.7.0.1
 */