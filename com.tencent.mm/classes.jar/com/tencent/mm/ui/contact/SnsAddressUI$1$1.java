package com.tencent.mm.ui.contact;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsAddressUI$1$1
  implements Runnable
{
  SnsAddressUI$1$1(SnsAddressUI.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(33922);
    if (!this.Afw.Afv.getIntent().getBooleanExtra("stay_in_wechat", true)) {
      this.Afw.Afv.moveTaskToBack(true);
    }
    AppMethodBeat.o(33922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsAddressUI.1.1
 * JD-Core Version:    0.7.0.1
 */