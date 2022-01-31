package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.c.a;

final class AppBrandServiceChattingUI$a$3$1
  implements Runnable
{
  AppBrandServiceChattingUI$a$3$1(AppBrandServiceChattingUI.a.3 param3) {}
  
  public final void run()
  {
    if (AppBrandServiceChattingUI.a.e(this.vhl.vhk))
    {
      y.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.Visible", new Object[] { Boolean.valueOf(AppBrandServiceChattingUI.a.e(this.vhl.vhk)) });
      ((q)this.vhl.vhk.byx.ac(q.class)).Hb(0);
      return;
    }
    y.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.GONE", new Object[] { Boolean.valueOf(AppBrandServiceChattingUI.a.e(this.vhl.vhk)) });
    ((q)this.vhl.vhk.byx.ac(q.class)).Hb(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a.3.1
 * JD-Core Version:    0.7.0.1
 */