package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.pluginsdk.ui.applet.s;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

final class SayHiEditUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SayHiEditUI$1(SayHiEditUI paramSayHiEditUI, String paramString1, int paramInt, String paramString2) {}
  
  public final boolean onMenuItemClick(final MenuItem paramMenuItem)
  {
    AppMethodBeat.i(33841);
    this.AeO.hideVKB();
    b.pgQ.ad(2, 1, 5);
    Object localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(this.fwC);
    Object localObject2 = new LinkedList();
    ((LinkedList)localObject2).add(Integer.valueOf(this.AeM));
    paramMenuItem = new LinkedList();
    if (!ah.isNullOrNil(this.AeN)) {
      paramMenuItem.add(this.AeN);
    }
    String str = SayHiEditUI.a(this.AeO);
    paramMenuItem = new s(this.AeO.getContext(), null);
    paramMenuItem.content = str;
    paramMenuItem.r((List)localObject1, (List)localObject2);
    localObject1 = this.AeO;
    localObject2 = this.AeO.getContext();
    this.AeO.getString(2131297087);
    SayHiEditUI.a((SayHiEditUI)localObject1, h.b((Context)localObject2, this.AeO.getString(2131303128), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(33840);
        paramMenuItem.dnJ();
        AppMethodBeat.o(33840);
      }
    }));
    AppMethodBeat.o(33841);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SayHiEditUI.1
 * JD-Core Version:    0.7.0.1
 */