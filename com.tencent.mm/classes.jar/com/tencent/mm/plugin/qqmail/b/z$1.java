package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class z$1
  implements ab.f
{
  z$1(z paramz) {}
  
  public final void aq(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68031);
    if (paramInt1 == paramInt2)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareMailQueue", "finished one job, queue.size = %d", new Object[] { Integer.valueOf(this.pKc.pJW.size()) });
      if (this.pKc.pJY != null) {
        this.pKc.pJY.Xv(paramString);
      }
      if (this.pKc.pJW.size() > 0)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareMailQueue", "continue to send next mail");
        paramString = (aa)this.pKc.pJW.remove(0);
        this.pKc.b(paramString);
        this.pKc.pJX.a(this, this.pKc.pKb);
        AppMethodBeat.o(68031);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareMailQueue", "finished sent all mails");
      this.pKc.pJZ = false;
    }
    AppMethodBeat.o(68031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.z.1
 * JD-Core Version:    0.7.0.1
 */