package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsTimeLineUI$39
  implements View.OnTouchListener
{
  SnsTimeLineUI$39(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(155751);
    if (paramMotionEvent.getAction() == 1)
    {
      this.rYv.ctC();
      if ((SnsTimeLineUI.l(this.rYv).list != null) && (SnsTimeLineUI.l(this.rYv).list.getFirstVisiblePosition() == 0)) {
        ab.d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
      }
      SnsTimeLineUI.j(this.rYv).cws();
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if (SnsTimeLineUI.l(this.rYv).list != null) {
        SnsTimeLineUI.l(this.rYv).list.getFirstVisiblePosition();
      }
      SnsTimeLineUI.i(this.rYv).ctr();
      SnsTimeLineUI.i(this.rYv).rFp.cwK();
    }
    AppMethodBeat.o(155751);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.39
 * JD-Core Version:    0.7.0.1
 */