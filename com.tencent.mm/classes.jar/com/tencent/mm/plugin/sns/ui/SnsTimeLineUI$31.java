package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.QFadeImageView;

final class SnsTimeLineUI$31
  implements View.OnTouchListener
{
  SnsTimeLineUI$31(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.pfC.bHw();
      if ((SnsTimeLineUI.h(this.pfC).lwE != null) && (SnsTimeLineUI.h(this.pfC).lwE.getFirstVisiblePosition() == 0))
      {
        y.d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
        SnsTimeLineUI.m(this.pfC).setVisibility(0);
      }
      SnsTimeLineUI.E(this.pfC).bJM();
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if ((SnsTimeLineUI.h(this.pfC).lwE != null) && (SnsTimeLineUI.h(this.pfC).lwE.getFirstVisiblePosition() == 0)) {
        SnsTimeLineUI.m(this.pfC).setVisibility(0);
      }
      SnsTimeLineUI.g(this.pfC).bHn();
      SnsTimeLineUI.g(this.pfC).oNG.bKi();
    }
    if (this.pfC.oWw != null) {
      this.pfC.oWw.bCe();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.31
 * JD-Core Version:    0.7.0.1
 */