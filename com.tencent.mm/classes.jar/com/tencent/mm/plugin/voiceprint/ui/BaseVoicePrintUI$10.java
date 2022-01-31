package com.tencent.mm.plugin.voiceprint.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

final class BaseVoicePrintUI$10
  implements View.OnTouchListener
{
  private long oeC = 0L;
  private boolean trZ = false;
  
  BaseVoicePrintUI$10(BaseVoicePrintUI paramBaseVoicePrintUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(26140);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26140);
      return false;
      BaseVoicePrintUI.a(this.trX, false);
      if (!bo.isNullOrNil(this.trX.tru))
      {
        this.oeC = System.currentTimeMillis();
        BaseVoicePrintUI.f(this.trX).setPressed(true);
        BaseVoicePrintUI.l(this.trX);
        this.trX.cLl();
        BaseVoicePrintUI.m(this.trX).sendEmptyMessageDelayed(1, 300L);
        ab.i("MicroMsg.BaseVoicePrintUI", "mic press down");
        continue;
        BaseVoicePrintUI.f(this.trX).setPressed(false);
        BaseVoicePrintUI.m(this.trX).removeMessages(1);
        if (System.currentTimeMillis() - this.oeC < 300L)
        {
          ab.d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
          BaseVoicePrintUI.a(this.trX, false);
        }
        for (;;)
        {
          ab.i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(BaseVoicePrintUI.n(this.trX)) });
          BaseVoicePrintUI.g(this.trX).stop();
          BaseVoicePrintUI.e(this.trX).stopTimer();
          BaseVoicePrintUI.a(this.trX).Ez();
          if (BaseVoicePrintUI.n(this.trX)) {
            break label293;
          }
          BaseVoicePrintUI.c(this.trX).setErr(2131304563);
          BaseVoicePrintUI.c(this.trX).cLz();
          break;
          BaseVoicePrintUI.a(this.trX, true);
        }
        label293:
        paramView = this.trX;
        ab.d("MicroMsg.BaseVoicePrintUI", "releaseMic");
        if (!paramView.trP.trF)
        {
          paramView.trV.stopTimer();
          paramView.trO.setErr(2131304563);
          paramView.trO.cLz();
          paramView.trQ = null;
        }
        paramView.trM.setVisibility(8);
        paramView.trO.cLx();
        paramView.trO.setTipText(paramView.tru);
        ab.d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", new Object[] { BaseVoicePrintUI.d(this.trX) });
        if (!bo.isNullOrNil(BaseVoicePrintUI.d(this.trX))) {
          this.trX.cLn();
        }
        this.oeC = 0L;
        this.trZ = false;
        BaseVoicePrintUI.a(this.trX, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.10
 * JD-Core Version:    0.7.0.1
 */