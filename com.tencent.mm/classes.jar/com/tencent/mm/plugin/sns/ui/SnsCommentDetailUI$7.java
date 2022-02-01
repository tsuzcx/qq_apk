package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
        paramMenuItem = ah.dXE().aBr(this.Atd.eco());
        localn = SnsCommentDetailUI.u(this.AsY);
        boolean bool = bu.lX(SnsCommentDetailUI.t(this.AsY), this.Atd.field_userName);
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        if ((bool) && (paramMenuItem != null))
        {
          if (paramMenuItem.field_localPrivate <= 0) {
            continue;
          }
          if ((!bu.isNullOrNil(ah.dXj())) && (ah.dXj().equals(paramMenuItem.field_userName)))
          {
            localArrayList1.add(localn.mContext.getString(2131763967));
            localArrayList2.add(Integer.valueOf(1));
          }
          if (localArrayList1.size() != 0)
          {
            localn.Ahc = new e(localn.mContext, 1, false);
            localn.Ahc.LfS = new n.1(localn, localArrayList1, localArrayList2);
            localn.Ahc.LfT = new n.2(localn, paramMenuItem);
            localn.Ahc.cPF();
          }
        }
      }
      catch (Exception paramMenuItem)
      {
        n localn;
        ArrayList localArrayList1;
        ArrayList localArrayList2;
        ae.printErrStackTrace("MicroMsg.SnsCommentDetailUI", paramMenuItem, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(163090);
      return true;
      localArrayList1.add(localn.mContext.getString(2131763968));
      localArrayList2.add(Integer.valueOf(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.7
 * JD-Core Version:    0.7.0.1
 */