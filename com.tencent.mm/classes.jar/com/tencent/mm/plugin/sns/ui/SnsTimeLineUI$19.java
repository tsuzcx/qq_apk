package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsTimeLineUI$19
  implements Runnable
{
  SnsTimeLineUI$19(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(39471);
    this.rYv.setMMNormalView();
    SnsTimeLineUI.v(this.rYv);
    SnsTimeLineUI.w(this.rYv);
    this.rYv.setMMTitle(this.rYv.getString(2131304020));
    SnsTimeLineUI.x(this.rYv);
    SnsTimeLineUI.c(this.rYv, SnsTimeLineUI.l(this.rYv).list.getFirstVisiblePosition());
    AppMethodBeat.o(39471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.19
 * JD-Core Version:    0.7.0.1
 */