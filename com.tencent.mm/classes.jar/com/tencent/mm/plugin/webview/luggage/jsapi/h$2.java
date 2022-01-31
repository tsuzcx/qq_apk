package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

final class h$2
  implements n.d
{
  h$2(h paramh, String paramString, Intent paramIntent) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      h.a(this.rdz, this.rdA, this.val$intent);
      return;
    }
    h.a(this.rdz, this.val$intent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.h.2
 * JD-Core Version:    0.7.0.1
 */