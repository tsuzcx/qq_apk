package com.tencent.mm.plugin.qqmail.b;

import java.util.ArrayList;

final class z$1
  implements ab.f
{
  z$1(z paramz) {}
  
  public final void Z(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ShareMailQueue", "finished one job, queue.size = %d", new Object[] { Integer.valueOf(this.neN.neH.size()) });
      if (this.neN.neJ != null) {
        this.neN.neJ.Ll(paramString);
      }
      if (this.neN.neH.size() > 0)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ShareMailQueue", "continue to send next mail");
        paramString = (aa)this.neN.neH.remove(0);
        this.neN.b(paramString);
        this.neN.neI.a(this, this.neN.neM);
      }
    }
    else
    {
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ShareMailQueue", "finished sent all mails");
    this.neN.neK = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.z.1
 * JD-Core Version:    0.7.0.1
 */