package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
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
    AppMethodBeat.i(24893);
    paramDialogInterface = h.qsU;
    Object localObject2 = m.clp();
    Object localObject1 = new ArrayList();
    localObject2 = ((o)localObject2).clT();
    if (localObject2 != null)
    {
      while (((Cursor)localObject2).moveToNext())
      {
        n localn = new n();
        localn.convertFrom((Cursor)localObject2);
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
    paramDialogInterface.e(12662, new Object[] { Integer.valueOf(2), ((StringBuilder)localObject2).toString() });
    m.clp().db.delete("shaketvhistory", null, null);
    paramDialogInterface = new c(2, null);
    aw.Rc().a(paramDialogInterface, 0);
    ShakeTvHistoryListUI.a(this.qRH.qRG).Ku();
    this.qRH.qRG.enableOptionMenu(false);
    AppMethodBeat.o(24893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.2.1
 * JD-Core Version:    0.7.0.1
 */