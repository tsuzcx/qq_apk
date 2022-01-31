package com.tencent.mm.plugin.voiceprint.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class BaseVoicePrintUI$10
  implements View.OnTouchListener
{
  private long lHp = 0L;
  private boolean pMd = false;
  
  BaseVoicePrintUI$10(BaseVoicePrintUI paramBaseVoicePrintUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
    case 0: 
      do
      {
        return false;
        BaseVoicePrintUI.a(this.pMb, false);
      } while (bk.bl(this.pMb.pLy));
      this.lHp = System.currentTimeMillis();
      BaseVoicePrintUI.f(this.pMb).setPressed(true);
      BaseVoicePrintUI.l(this.pMb);
      this.pMb.bPf();
      BaseVoicePrintUI.m(this.pMb).sendEmptyMessageDelayed(1, 300L);
      y.i("MicroMsg.BaseVoicePrintUI", "mic press down");
      return false;
    }
    BaseVoicePrintUI.f(this.pMb).setPressed(false);
    BaseVoicePrintUI.m(this.pMb).removeMessages(1);
    if (System.currentTimeMillis() - this.lHp < 300L)
    {
      y.d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
      BaseVoicePrintUI.a(this.pMb, false);
    }
    for (;;)
    {
      y.i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(BaseVoicePrintUI.n(this.pMb)) });
      BaseVoicePrintUI.g(this.pMb).stop();
      BaseVoicePrintUI.e(this.pMb).stopTimer();
      BaseVoicePrintUI.a(this.pMb).un();
      if (BaseVoicePrintUI.n(this.pMb)) {
        break;
      }
      BaseVoicePrintUI.c(this.pMb).setErr(R.l.voice_print_err_time);
      BaseVoicePrintUI.c(this.pMb).bPu();
      return false;
      BaseVoicePrintUI.a(this.pMb, true);
    }
    paramView = this.pMb;
    y.d("MicroMsg.BaseVoicePrintUI", "releaseMic");
    if (!paramView.pLT.pLJ)
    {
      paramView.pLZ.stopTimer();
      paramView.pLS.setErr(R.l.voice_print_err_time);
      paramView.pLS.bPu();
      paramView.pLU = null;
    }
    paramView.pLQ.setVisibility(8);
    paramView.pLS.bPs();
    paramView.pLS.setTipText(paramView.pLy);
    y.d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", new Object[] { BaseVoicePrintUI.d(this.pMb) });
    if (!bk.bl(BaseVoicePrintUI.d(this.pMb))) {
      this.pMb.bPh();
    }
    this.lHp = 0L;
    this.pMd = false;
    BaseVoicePrintUI.a(this.pMb, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.10
 * JD-Core Version:    0.7.0.1
 */