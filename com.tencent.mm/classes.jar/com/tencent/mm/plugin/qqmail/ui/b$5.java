package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mars.cdn.CdnLogic.C2CUploadResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.model.ai;

final class b$5
  implements Runnable
{
  b$5(b paramb, ai paramai, CdnLogic.C2CUploadResult paramC2CUploadResult) {}
  
  public final void run()
  {
    AppMethodBeat.i(266923);
    if (this.NnS != null)
    {
      if (this.NnT.errorCode == 0) {
        break label47;
      }
      this.NnS.state = 3;
    }
    for (;;)
    {
      b.b(this.NnO, this.NnS);
      AppMethodBeat.o(266923);
      return;
      label47:
      this.NnS.state = 2;
      b.e(this.NnO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.b.5
 * JD-Core Version:    0.7.0.1
 */