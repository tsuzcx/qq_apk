package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

final class g$68
  implements n.d
{
  g$68(g paramg, String paramString, Intent paramIntent) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      g.a(this.rzi, this.rdA, this.val$intent);
      return;
    }
    g.b(this.rzi, this.val$intent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.68
 * JD-Core Version:    0.7.0.1
 */