package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class MMCallBackScrollView$1
  extends ah
{
  MMCallBackScrollView$1(MMCallBackScrollView paramMMCallBackScrollView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    int i = this.nbD.getScrollY();
    if (i == MMCallBackScrollView.a(this.nbD))
    {
      MMCallBackScrollView.a(this.nbD, 0);
      return;
    }
    MMCallBackScrollView.b(this.nbD, i);
    MMCallBackScrollView.b(this.nbD).sendMessageDelayed(MMCallBackScrollView.b(this.nbD).obtainMessage(), 5L);
    MMCallBackScrollView.a(this.nbD, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView.1
 * JD-Core Version:    0.7.0.1
 */