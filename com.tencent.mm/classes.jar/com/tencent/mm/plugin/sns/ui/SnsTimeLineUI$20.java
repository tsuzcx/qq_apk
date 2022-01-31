package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsTimeLineUI$20
  implements Runnable
{
  SnsTimeLineUI$20(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(145570);
    int i = SnsTimeLineUI.l(this.rYv).list.getFirstVisiblePosition();
    int j = SnsTimeLineUI.l(this.rYv).list.getLastVisiblePosition();
    ab.d("MicroMsg.SnsTimeLineUI", "notifyList from:%s to:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    SnsTimeLineUI.a(this.rYv, i, j);
    AppMethodBeat.o(145570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.20
 * JD-Core Version:    0.7.0.1
 */