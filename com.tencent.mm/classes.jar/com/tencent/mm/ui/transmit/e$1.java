package com.tencent.mm.ui.transmit;

import com.tencent.mm.ui.base.p;

final class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public final void run()
  {
    if (this.wif.tipDialog != null) {
      this.wif.tipDialog.dismiss();
    }
    this.wif.cJI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.e.1
 * JD-Core Version:    0.7.0.1
 */