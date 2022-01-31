package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.f.a;

final class ah$c$4$1$1
  implements Runnable
{
  ah$c$4$1$1(ah.c.4.1 param1, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(6664);
    if (this.qac == 1)
    {
      this.uVZ.uVY.uVR.goBack();
      locala = a.vtM;
      if (this.uVZ.uVY.uVS == null) {}
      for (str = "";; str = this.uVZ.uVY.uVS)
      {
        locala.a(str, ah.c.awG(), 0, 1, 0, 1, this.uVZ.uVY.val$errCode);
        a.vtM.ap(2, (int)(System.currentTimeMillis() - ah.c.access$200()), this.uVZ.uVY.val$errCode);
        AppMethodBeat.o(6664);
        return;
      }
    }
    a locala = a.vtM;
    if (this.uVZ.uVY.uVS == null) {}
    for (String str = "";; str = this.uVZ.uVY.uVS)
    {
      locala.a(str, ah.c.awG(), 1, 1, 0, 1, this.uVZ.uVY.val$errCode);
      ah.c.a(this.uVZ.uVY.uVV, this.uVZ.uVX, this.uVZ.uVY.uVR, this.uVZ.uVY.uVj, this.uVZ.uVY.uVQ, this.uVZ.uVY.uVW);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ah.c.4.1.1
 * JD-Core Version:    0.7.0.1
 */