package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;

final class z$2
  implements ab.e
{
  z$2(z paramz) {}
  
  public final void Ln(String paramString)
  {
    y localy;
    if (this.neN.neJ != null)
    {
      localy = this.neN.neJ;
      if (!bk.bl(paramString)) {
        break label94;
      }
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ShareMailInfoMgr", "notify fail error, subject is null");
    }
    while (this.neN.neH.size() > 0)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ShareMailQueue", "continue to send next mail");
      paramString = (aa)this.neN.neH.remove(0);
      this.neN.b(paramString);
      this.neN.neI.a(this.neN.neL, this);
      return;
      label94:
      y.Lm(paramString);
      localy.Ll(paramString);
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ShareMailQueue", "final job fail");
    this.neN.neK = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.z.2
 * JD-Core Version:    0.7.0.1
 */