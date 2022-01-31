package com.tencent.mm.plugin.websearch.widget.view;

import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.Map;

public final class a$4
  implements d.a
{
  public a$4(a parama, x paramx, int paramInt) {}
  
  public final void onDismiss()
  {
    y.v("FTSSearchActionSheetMgr", "selected pos %d", new Object[] { Integer.valueOf(-1) });
    if (this.qXx != null) {
      this.qXx.eA(-1, this.val$id);
    }
    a.b(this.qXw).remove(Integer.valueOf(this.val$id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.a.4
 * JD-Core Version:    0.7.0.1
 */