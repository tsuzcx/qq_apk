package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class SnsGalleryUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SnsGalleryUI$3(SnsGalleryUI paramSnsGalleryUI, boolean paramBoolean) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(38937);
    Object localObject = this.rQA.rNT.getSelectId();
    String str = this.rQA.rNT.getSelectedMediaId();
    paramMenuItem = this.rQA.rNT.getSelectItem();
    ab.d("MicroMsg.SnsGalleryUI", "click selectLocalId ".concat(String.valueOf(localObject)));
    ab.d("MicroMsg.SnsGalleryUI", "click position ".concat(String.valueOf(str)));
    localObject = ag.cpf().abv((String)localObject);
    for (;;)
    {
      try
      {
        i = this.rQA.rNT.getPosition();
        int j = ((n)localObject).csh().xTS.wOa.size();
        if ((j <= 1) || (i <= 1) || (i > j)) {
          continue;
        }
        i -= 1;
        this.rQA.rNP.a(this.rQB, (n)localObject, paramMenuItem.cIc, true, i);
      }
      catch (Exception paramMenuItem)
      {
        int i;
        ab.printErrStackTrace("MicroMsg.SnsGalleryUI", paramMenuItem, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(38937);
      return true;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsGalleryUI.3
 * JD-Core Version:    0.7.0.1
 */