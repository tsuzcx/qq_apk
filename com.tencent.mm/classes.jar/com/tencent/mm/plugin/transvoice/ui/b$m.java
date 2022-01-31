package com.tencent.mm.plugin.transvoice.ui;

import a.l;
import android.os.Message;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
final class b$m
  implements ak.a
{
  b$m(b paramb) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(156324);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(156324);
      return true;
      b.p(this.tqJ).tpu = 1;
      b.p(this.tqJ).tpv = System.currentTimeMillis();
      b.p(this.tqJ).tpz = 0;
      paramMessage = b.w(this.tqJ);
      if (paramMessage != null) {
        paramMessage.stopTimer();
      }
      paramMessage = b.t(this.tqJ);
      if (paramMessage != null) {
        paramMessage.cancel(false);
      }
      if (!bo.isNullOrNil(this.tqJ.tqy))
      {
        paramMessage = b.e(this.tqJ);
        if (paramMessage != null) {
          paramMessage.setFocusable(true);
        }
        paramMessage = b.e(this.tqJ);
        if (paramMessage != null) {
          paramMessage.setFocusableInTouchMode(true);
        }
      }
      paramMessage = b.e(this.tqJ);
      if (paramMessage != null) {
        paramMessage.setText((CharSequence)this.tqJ.tqy);
      }
      paramMessage = b.u(this.tqJ);
      if (paramMessage != null) {
        paramMessage.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b.m
 * JD-Core Version:    0.7.0.1
 */