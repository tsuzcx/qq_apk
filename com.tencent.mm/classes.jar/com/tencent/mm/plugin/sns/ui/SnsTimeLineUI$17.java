package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.sdk.platformtools.y;

final class SnsTimeLineUI$17
  implements Runnable
{
  SnsTimeLineUI$17(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void run()
  {
    if (SnsTimeLineUI.a(this.pfC) == null) {}
    while (SnsTimeLineUI.n(this.pfC)) {
      return;
    }
    y.v("MicroMsg.SnsTimeLineUI", "zeustest update onFling notify resume %s", new Object[] { Integer.valueOf(SnsTimeLineUI.h(this.pfC).lwE.getFirstVisiblePosition() - SnsTimeLineUI.h(this.pfC).lwE.getHeaderViewsCount()) });
    af.bDC().start();
    SnsTimeLineUI.a(this.pfC).pgw.bJu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.17
 * JD-Core Version:    0.7.0.1
 */