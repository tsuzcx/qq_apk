package com.tencent.mm.plugin.websearch.widget.view;

import android.view.MenuItem;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import java.util.Map;

public final class a$3
  implements n.d
{
  public a$3(a parama, x paramx, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    y.v("FTSSearchActionSheetMgr", "selected pos %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.qXx != null) {
      this.qXx.eA(paramInt, this.val$id);
    }
    a.b(this.qXw).remove(Integer.valueOf(this.val$id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.a.3
 * JD-Core Version:    0.7.0.1
 */