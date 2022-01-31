package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.LinkedList;
import java.util.List;

final class SayHiEditUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SayHiEditUI$1(SayHiEditUI paramSayHiEditUI, String paramString1, int paramInt, String paramString2) {}
  
  public final boolean onMenuItemClick(final MenuItem paramMenuItem)
  {
    this.vNl.XM();
    b.mGK.S(2, 1, 5);
    paramMenuItem = new LinkedList();
    paramMenuItem.add(this.egy);
    Object localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(Integer.valueOf(this.vNj));
    Object localObject2 = new LinkedList();
    if (!ah.bl(this.vNk)) {
      ((LinkedList)localObject2).add(this.vNk);
    }
    paramMenuItem = new m(2, paramMenuItem, (List)localObject1, (List)localObject2, SayHiEditUI.a(this.vNl), "", null, null, "");
    au.Dk().a(paramMenuItem, 0);
    localObject1 = this.vNl;
    localObject2 = this.vNl.mController.uMN;
    this.vNl.getString(R.l.app_tip);
    SayHiEditUI.a((SayHiEditUI)localObject1, h.b((Context)localObject2, this.vNl.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        au.Dk().c(paramMenuItem);
      }
    }));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SayHiEditUI.1
 * JD-Core Version:    0.7.0.1
 */