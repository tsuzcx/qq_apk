package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class ai
{
  private static ai JYL;
  int JYM = 0;
  private int JYN = 0;
  
  public static ai fGg()
  {
    AppMethodBeat.i(34840);
    if (JYL == null) {
      JYL = new ai();
    }
    ai localai = JYL;
    AppMethodBeat.o(34840);
    return localai;
  }
  
  public final void adF(int paramInt)
  {
    AppMethodBeat.i(34841);
    if (this.JYM > 0)
    {
      this.JYM -= 1;
      AppMethodBeat.o(34841);
      return;
    }
    if (paramInt != this.JYN)
    {
      ae.i("MicroMsg.OrzChattingLifecycle", "notifyChattingStatus [%d]", new Object[] { Integer.valueOf(paramInt) });
      mu localmu = new mu();
      localmu.dBN.dBO = paramInt;
      a.IvT.l(localmu);
    }
    if ((paramInt == 1) || (paramInt == 4)) {
      this.JYN = paramInt;
    }
    AppMethodBeat.o(34841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ai
 * JD-Core Version:    0.7.0.1
 */