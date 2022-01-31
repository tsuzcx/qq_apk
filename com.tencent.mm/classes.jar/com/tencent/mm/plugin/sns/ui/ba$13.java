package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMPullDownView.e;

final class ba$13
  implements MMPullDownView.e
{
  ba$13(ba paramba) {}
  
  public final boolean aEU()
  {
    y.e("MicroMsg.SnsActivity", "bottomLoad  isAll:" + this.piF.pio);
    if (!this.piF.pio) {
      ba.g(this.piF);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ba.13
 * JD-Core Version:    0.7.0.1
 */