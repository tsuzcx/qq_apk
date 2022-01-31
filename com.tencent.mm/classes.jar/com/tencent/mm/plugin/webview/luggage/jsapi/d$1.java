package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity.a;

final class d$1
  implements MMActivity.a
{
  d$1(d paramd, aw.a parama) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == (this.rdw.hashCode() & 0xFFFF))
    {
      if (paramInt2 == -1) {
        this.iRN.e(null, null);
      }
    }
    else {
      return;
    }
    this.iRN.e("fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.d.1
 * JD-Core Version:    0.7.0.1
 */