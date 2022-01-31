package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ah;

final class i$1
  extends ah
{
  i$1(i parami) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 1) && (this.nLF.gSy != null)) {
      this.nLF.gSy.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.i.1
 * JD-Core Version:    0.7.0.1
 */