package com.tencent.mm.ui.chatting.viewitems;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.o;

final class u$7$1
  implements Runnable
{
  u$7$1(u.7 param7, String paramString1, String paramString2) {}
  
  public final void run()
  {
    o.ON().a(this.iXy, this.vEn.vEl.vIj, u.f(this.vEn.vDZ));
    if (TextUtils.isEmpty(this.vEm)) {}
    for (String str = this.vEn.vEh;; str = this.vEm)
    {
      this.vEn.vEl.vIk.setText(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.7.1
 * JD-Core Version:    0.7.0.1
 */