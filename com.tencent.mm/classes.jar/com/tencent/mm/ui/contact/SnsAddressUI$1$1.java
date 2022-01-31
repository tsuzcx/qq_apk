package com.tencent.mm.ui.contact;

import android.content.Intent;

final class SnsAddressUI$1$1
  implements Runnable
{
  SnsAddressUI$1$1(SnsAddressUI.1 param1) {}
  
  public final void run()
  {
    if (!this.vNO.vNN.getIntent().getBooleanExtra("stay_in_wechat", true)) {
      this.vNO.vNN.moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsAddressUI.1.1
 * JD-Core Version:    0.7.0.1
 */