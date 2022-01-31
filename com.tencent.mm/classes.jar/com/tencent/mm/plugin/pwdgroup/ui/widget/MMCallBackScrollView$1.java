package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class MMCallBackScrollView$1
  extends ak
{
  MMCallBackScrollView$1(MMCallBackScrollView paramMMCallBackScrollView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(24039);
    int i = this.pGV.getScrollY();
    if (i == MMCallBackScrollView.a(this.pGV))
    {
      MMCallBackScrollView.a(this.pGV, 0);
      AppMethodBeat.o(24039);
      return;
    }
    MMCallBackScrollView.b(this.pGV, i);
    MMCallBackScrollView.b(this.pGV).sendMessageDelayed(MMCallBackScrollView.b(this.pGV).obtainMessage(), 5L);
    MMCallBackScrollView.a(this.pGV, 1);
    AppMethodBeat.o(24039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView.1
 * JD-Core Version:    0.7.0.1
 */