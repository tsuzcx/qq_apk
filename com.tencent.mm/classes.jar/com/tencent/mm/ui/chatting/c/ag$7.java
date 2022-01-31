package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.u;
import com.tencent.mm.ui.tools.q.b;

final class ag$7
  implements q.b
{
  private int zHK = 0;
  
  ag$7(ag paramag) {}
  
  public final void apN()
  {
    AppMethodBeat.i(31650);
    new ak().post(new ag.7.1(this));
    AppMethodBeat.o(31650);
  }
  
  public final void apO() {}
  
  public final void apP() {}
  
  public final void apQ() {}
  
  public final boolean wR(String paramString)
  {
    return false;
  }
  
  public final void wS(String paramString)
  {
    AppMethodBeat.i(31649);
    if (bo.isNullOrNil(paramString))
    {
      this.zHK = 0;
      this.zHJ.PI(-1);
      AppMethodBeat.o(31649);
      return;
    }
    if (paramString.length() > this.zHK) {
      h.qsU.e(10451, new Object[] { Integer.valueOf(1) });
    }
    this.zHK = paramString.length();
    h.qsU.e(10456, new Object[] { Integer.valueOf(1) });
    ag.d(this.zHJ).wQ(paramString);
    AppMethodBeat.o(31649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ag.7
 * JD-Core Version:    0.7.0.1
 */