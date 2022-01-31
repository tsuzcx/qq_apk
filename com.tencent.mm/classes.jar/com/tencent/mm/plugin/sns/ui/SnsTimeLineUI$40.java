package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMPullDownView;

final class SnsTimeLineUI$40
  implements Runnable
{
  SnsTimeLineUI$40(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(155752);
    if (SnsTimeLineUI.i(this.rYv) == null)
    {
      AppMethodBeat.o(155752);
      return;
    }
    SnsTimeLineUI.i(this.rYv).rFp.rOD = SnsTimeLineUI.l(this.rYv).list.getBottom();
    SnsTimeLineUI.i(this.rYv).rFp.scS = SnsTimeLineUI.l(this.rYv).oCa.getTop();
    SnsTimeLineUI.j(this.rYv).rZa = SnsTimeLineUI.l(this.rYv).rmc.getTop();
    AppMethodBeat.o(155752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.40
 * JD-Core Version:    0.7.0.1
 */