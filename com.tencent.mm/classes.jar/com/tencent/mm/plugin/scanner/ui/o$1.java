package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ah;

final class o$1
  extends ah
{
  o$1(o paramo) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.nMj.nLQ >= this.nMj.nLR)
    {
      if (this.nMj.nMc != null) {
        au.Dk().c(this.nMj.nMc);
      }
      paramMessage = this.nMj;
      paramMessage.nLQ -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.o.1
 * JD-Core Version:    0.7.0.1
 */