package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Intent;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

final class ar$1
  implements MMActivity.a
{
  ar$1(ar paramar, a.a parama, MMActivity paramMMActivity) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == (this.rdT.hashCode() & 0xFFFF))
    {
      if (paramInt2 != -1) {
        break label38;
      }
      this.kNj.a("", null);
    }
    for (;;)
    {
      this.gGJ.gJb = null;
      return;
      label38:
      this.kNj.a("cancel", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ar.1
 * JD-Core Version:    0.7.0.1
 */