package com.tencent.mm.ui.chatting.viewitems;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.o;

final class x$7$1
  implements Runnable
{
  x$7$1(x.7 param7, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(33133);
    o.ahG().a(this.lgL, this.zVy.zVw.zZE, x.f(this.zVy.zVk));
    if (TextUtils.isEmpty(this.zVx)) {}
    for (String str = this.zVy.zVs;; str = this.zVx)
    {
      this.zVy.zVw.zZF.setText(str);
      AppMethodBeat.o(33133);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.7.1
 * JD-Core Version:    0.7.0.1
 */