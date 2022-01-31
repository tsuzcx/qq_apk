package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class SnsGalleryUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SnsGalleryUI$3(SnsGalleryUI paramSnsGalleryUI, boolean paramBoolean) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    Object localObject = this.oYh.oVy.getSelectId();
    String str = this.oYh.oVy.getSelectedMediaId();
    paramMenuItem = this.oYh.oVy.getSelectItem();
    y.d("MicroMsg.SnsGalleryUI", "click selectLocalId " + (String)localObject);
    y.d("MicroMsg.SnsGalleryUI", "click position " + str);
    localObject = af.bDF().OB((String)localObject);
    try
    {
      int i = this.oYh.oVy.getPosition();
      int j = ((n)localObject).bGe().tNr.sPJ.size();
      if ((j > 1) && (i > 1) && (i <= j)) {
        i -= 1;
      }
      for (;;)
      {
        this.oYh.oVv.a(this.oYi, (n)localObject, paramMenuItem.bZK, true, i);
        return true;
        i = 0;
      }
      return true;
    }
    catch (Exception paramMenuItem)
    {
      y.printErrStackTrace("MicroMsg.SnsGalleryUI", paramMenuItem, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsGalleryUI.3
 * JD-Core Version:    0.7.0.1
 */