package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.n.d;

public final class l$4
  implements n.d
{
  public l$4(Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem = paramMenuItem.getTitle().toString().replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
    paramMenuItem = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramMenuItem));
    paramMenuItem.addFlags(268435456);
    if (bk.i(this.val$context, paramMenuItem)) {
      this.val$context.startActivity(paramMenuItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l.4
 * JD-Core Version:    0.7.0.1
 */