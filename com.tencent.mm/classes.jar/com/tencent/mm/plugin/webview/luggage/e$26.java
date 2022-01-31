package com.tencent.mm.plugin.webview.luggage;

import com.tencent.mm.sdk.platformtools.bk;

final class e$26
  implements Runnable
{
  e$26(e parame, String paramString, int paramInt) {}
  
  public final void run()
  {
    if (this.rca.rbE != null)
    {
      if (!bk.bl(this.dYK)) {
        this.rca.rbE.setTitleText(this.dYK);
      }
      if (this.fyP != 0) {
        this.rca.rbE.setTitleColor(this.fyP);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.26
 * JD-Core Version:    0.7.0.1
 */