package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.List;

final class SnsCommentDetailUI$7
  implements MenuItem.OnMenuItemClickListener
{
  SnsCommentDetailUI$7(SnsCommentDetailUI paramSnsCommentDetailUI, SnsInfo paramSnsInfo) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(163090);
    for (;;)
    {
      try
      {
        paramMenuItem = aj.faO().aQm(this.ECi.getLocalid());
        localn = SnsCommentDetailUI.t(this.ECd);
        boolean bool = Util.isEqual(SnsCommentDetailUI.s(this.ECd), this.ECi.getUserName());
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        if ((bool) && (paramMenuItem != null))
        {
          if (paramMenuItem.getLocalPrivate() <= 0) {
            continue;
          }
          if ((!Util.isNullOrNil(aj.fau())) && (aj.fau().equals(paramMenuItem.getUserName())))
          {
            localArrayList1.add(localn.mContext.getString(2131766201));
            localArrayList2.add(Integer.valueOf(1));
          }
          if (localArrayList1.size() != 0)
          {
            localn.Epy = new e(localn.mContext, 1, false);
            localn.Epy.HLX = new n.1(localn, localArrayList1, localArrayList2);
            localn.Epy.HLY = new n.2(localn, paramMenuItem);
            localn.Epy.dGm();
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
      AppMethodBeat.o(163090);
      return true;
      localArrayList1.add(localn.mContext.getString(2131766202));
      localArrayList2.add(Integer.valueOf(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.7
 * JD-Core Version:    0.7.0.1
 */