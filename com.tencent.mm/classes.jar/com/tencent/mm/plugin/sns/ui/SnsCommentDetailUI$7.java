package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.List;

final class SnsCommentDetailUI$7
  implements MenuItem.OnMenuItemClickListener
{
  SnsCommentDetailUI$7(SnsCommentDetailUI paramSnsCommentDetailUI, p paramp) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(163090);
    for (;;)
    {
      try
      {
        paramMenuItem = af.dtu().apK(this.xxF.dxX());
        localn = SnsCommentDetailUI.u(this.xxA);
        boolean bool = bt.kU(SnsCommentDetailUI.t(this.xxA), this.xxF.field_userName);
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        if ((bool) && (paramMenuItem != null))
        {
          if (paramMenuItem.field_localPrivate <= 0) {
            continue;
          }
          if ((!bt.isNullOrNil(af.dta())) && (af.dta().equals(paramMenuItem.field_userName)))
          {
            localArrayList1.add(localn.mContext.getString(2131763967));
            localArrayList2.add(Integer.valueOf(1));
          }
          if (localArrayList1.size() != 0)
          {
            localn.xlR = new e(localn.mContext, 1, false);
            localn.xlR.HrX = new n.1(localn, localArrayList1, localArrayList2);
            localn.xlR.HrY = new n.2(localn, paramMenuItem);
            localn.xlR.csG();
          }
        }
      }
      catch (Exception paramMenuItem)
      {
        n localn;
        ArrayList localArrayList1;
        ArrayList localArrayList2;
        ad.printErrStackTrace("MicroMsg.SnsCommentDetailUI", paramMenuItem, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(163090);
      return true;
      localArrayList1.add(localn.mContext.getString(2131763968));
      localArrayList2.add(Integer.valueOf(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.7
 * JD-Core Version:    0.7.0.1
 */