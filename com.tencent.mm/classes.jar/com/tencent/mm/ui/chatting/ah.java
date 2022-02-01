package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class ah
{
  private static ah Gqn;
  int Gqo = 0;
  private int Gqp = 0;
  
  public static ah eWb()
  {
    AppMethodBeat.i(34840);
    if (Gqn == null) {
      Gqn = new ah();
    }
    ah localah = Gqn;
    AppMethodBeat.o(34840);
    return localah;
  }
  
  public final void YB(int paramInt)
  {
    AppMethodBeat.i(34841);
    if (this.Gqo > 0)
    {
      this.Gqo -= 1;
      AppMethodBeat.o(34841);
      return;
    }
    if (paramInt != this.Gqp)
    {
      ad.i("MicroMsg.OrzChattingLifecycle", "notifyChattingStatus [%d]", new Object[] { Integer.valueOf(paramInt) });
      mb localmb = new mb();
      localmb.drj.drk = paramInt;
      a.ESL.l(localmb);
    }
    if ((paramInt == 1) || (paramInt == 4)) {
      this.Gqp = paramInt;
    }
    AppMethodBeat.o(34841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ah
 * JD-Core Version:    0.7.0.1
 */