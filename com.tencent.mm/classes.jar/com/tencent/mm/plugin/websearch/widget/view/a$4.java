package com.tencent.mm.plugin.websearch.widget.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.d.a;
import java.util.Map;

public final class a$4
  implements d.a
{
  public a$4(a parama, x paramx, int paramInt) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(91476);
    ab.v("FTSSearchActionSheetMgr", "selected pos %d", new Object[] { Integer.valueOf(-1) });
    if (this.uMM != null) {
      this.uMM.gE(-1, this.val$id);
    }
    a.b(this.uML).remove(Integer.valueOf(this.val$id));
    AppMethodBeat.o(91476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.a.4
 * JD-Core Version:    0.7.0.1
 */