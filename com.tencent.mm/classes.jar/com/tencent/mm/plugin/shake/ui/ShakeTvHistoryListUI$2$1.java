package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.c;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.sdk.e.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ShakeTvHistoryListUI$2$1
  implements DialogInterface.OnClickListener
{
  ShakeTvHistoryListUI$2$1(ShakeTvHistoryListUI.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = h.nFQ;
    Object localObject2 = m.bzW();
    Object localObject1 = new ArrayList();
    localObject2 = ((o)localObject2).bAA();
    if (localObject2 != null)
    {
      while (((Cursor)localObject2).moveToNext())
      {
        n localn = new n();
        localn.d((Cursor)localObject2);
        ((List)localObject1).add(localn);
      }
      ((Cursor)localObject2).close();
    }
    localObject2 = new StringBuilder();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ((StringBuilder)localObject2).append(((n)((Iterator)localObject1).next()).field_username);
      ((StringBuilder)localObject2).append("|");
    }
    paramDialogInterface.f(12662, new Object[] { Integer.valueOf(2), ((StringBuilder)localObject2).toString() });
    m.bzW().dXw.delete("shaketvhistory", null, null);
    paramDialogInterface = new c(2, null);
    au.Dk().a(paramDialogInterface, 0);
    ShakeTvHistoryListUI.a(this.odA.odz).yc();
    this.odA.odz.enableOptionMenu(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.2.1
 * JD-Core Version:    0.7.0.1
 */