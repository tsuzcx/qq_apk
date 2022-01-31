package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

final class z$2
  implements ab.e
{
  z$2(z paramz) {}
  
  public final void Xx(String paramString)
  {
    AppMethodBeat.i(68032);
    y localy;
    if (this.pKc.pJY != null)
    {
      localy = this.pKc.pJY;
      if (!bo.isNullOrNil(paramString)) {
        break label104;
      }
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ShareMailInfoMgr", "notify fail error, subject is null");
    }
    while (this.pKc.pJW.size() > 0)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareMailQueue", "continue to send next mail");
      paramString = (aa)this.pKc.pJW.remove(0);
      this.pKc.b(paramString);
      this.pKc.pJX.a(this.pKc.pKa, this);
      AppMethodBeat.o(68032);
      return;
      label104:
      y.Xw(paramString);
      localy.Xv(paramString);
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareMailQueue", "final job fail");
    this.pKc.pJZ = false;
    AppMethodBeat.o(68032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.z.2
 * JD-Core Version:    0.7.0.1
 */