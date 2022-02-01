package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.n.d;

public final class m$4
  implements n.d
{
  public m$4(Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(31924);
    Object localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramMenuItem.getTitle().toString().replace(" ", "").replace("(", "").replace(")", "").replace("-", "")))));
    ((Intent)localObject).addFlags(268435456);
    if (bs.ah(this.val$context, (Intent)localObject))
    {
      paramMenuItem = this.val$context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, "com/tencent/mm/pluginsdk/ui/span/MailPhoneMenuHelper$4", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(31924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.m.4
 * JD-Core Version:    0.7.0.1
 */