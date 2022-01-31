package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Arrays;

final class a$1
  implements Runnable
{
  a$1(a parama, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(8561);
    this.vlQ.vlI[0][0] = this.vlP.getY();
    this.vlQ.vlI[0][1] = 0;
    this.vlQ.vlI[1][0] = this.vlP.getX();
    this.vlQ.vlI[1][1] = 0;
    this.vlQ.vlI[2][0] = this.vlP.getMeasuredWidth();
    this.vlQ.vlI[2][1] = (this.vlP.getMeasuredWidth() + this.vlQ.vlv * 2);
    ab.i("MicroMsg.WebSearch.SosAnimatorBaseController", "searchBarData %s", new Object[] { Arrays.toString(this.vlQ.vlI) });
    AppMethodBeat.o(8561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a.1
 * JD-Core Version:    0.7.0.1
 */