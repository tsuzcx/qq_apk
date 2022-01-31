package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SnsTimeLineUI$18
  implements Runnable
{
  SnsTimeLineUI$18(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void run()
  {
    s locals = this.pfC.mController;
    if (locals.mContext != null) {
      locals.X(locals.uMN);
    }
    SnsTimeLineUI.o(this.pfC);
    SnsTimeLineUI.p(this.pfC);
    this.pfC.setMMTitle(this.pfC.getString(i.j.sns_timeline_ui_title));
    SnsTimeLineUI.q(this.pfC);
    SnsTimeLineUI.b(this.pfC, SnsTimeLineUI.h(this.pfC).lwE.getFirstVisiblePosition());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.18
 * JD-Core Version:    0.7.0.1
 */