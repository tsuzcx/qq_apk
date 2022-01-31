package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity.a;

final class c$1
  implements MMActivity.a
{
  c$1(b paramb) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 != 3456) || (paramIntent == null) || (this.rpS == null)) {
      return;
    }
    paramIntent = paramIntent.getBundleExtra("input_data");
    this.rpS.g(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.c.1
 * JD-Core Version:    0.7.0.1
 */