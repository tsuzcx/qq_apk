package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.f.a;

final class ah$c$3$1
  implements Runnable
{
  ah$c$3$1(ah.c.3 param3, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(6662);
    if (this.qac == 1)
    {
      this.uVU.uVR.goBack();
      locala = a.vtM;
      if (this.uVU.uVS == null) {}
      for (str = "";; str = this.uVU.uVS)
      {
        locala.a(str, ah.c.awG(), 0, 1, 0, 0, this.uVU.val$errCode);
        a.vtM.ap(1, (int)(System.currentTimeMillis() - ah.c.awG()), this.uVU.val$errCode);
        AppMethodBeat.o(6662);
        return;
      }
    }
    this.uVU.uVR.aha(this.uVU.uVT);
    a locala = a.vtM;
    if (this.uVU.uVS == null) {}
    for (String str = "";; str = this.uVU.uVS)
    {
      locala.a(str, ah.c.awG(), 1, 1, 0, 0, this.uVU.val$errCode);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ah.c.3.1
 * JD-Core Version:    0.7.0.1
 */