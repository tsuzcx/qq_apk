package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.List;

final class SnsCommentDetailUI$13
  implements MenuItem.OnMenuItemClickListener
{
  SnsCommentDetailUI$13(SnsCommentDetailUI paramSnsCommentDetailUI, SnsInfo paramSnsInfo) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(308237);
    for (;;)
    {
      try
      {
        paramMenuItem = al.hgB().aZL(this.RdZ.getLocalid());
        localn = SnsCommentDetailUI.x(this.RpH);
        boolean bool = Util.isEqual(SnsCommentDetailUI.w(this.RpH), this.RdZ.getUserName());
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        if ((bool) && (paramMenuItem != null))
        {
          if (paramMenuItem.getLocalPrivate() <= 0) {
            continue;
          }
          if ((!Util.isNullOrNil(al.hgg())) && (al.hgg().equals(paramMenuItem.getUserName())))
          {
            localArrayList1.add(localn.mContext.getString(b.j.sns_set_open));
            localArrayList2.add(Integer.valueOf(1));
          }
          if (localArrayList1.size() != 0)
          {
            localn.Rcq = new f(localn.mContext, 1, false);
            localn.Rcq.Vtg = new n.1(localn, localArrayList1, localArrayList2);
            localn.Rcq.GAC = new n.2(localn, paramMenuItem);
            localn.Rcq.dDn();
          }
        }
      }
      catch (Exception paramMenuItem)
      {
        n localn;
        ArrayList localArrayList1;
        ArrayList localArrayList2;
        Log.printErrStackTrace("MicroMsg.SnsCommentDetailUI", paramMenuItem, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(308237);
      return true;
      localArrayList1.add(localn.mContext.getString(b.j.sns_set_private));
      localArrayList2.add(Integer.valueOf(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.13
 * JD-Core Version:    0.7.0.1
 */