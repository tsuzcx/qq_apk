package com.tencent.mm.plugin.shake.ui;

import com.tencent.mm.bh.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class ShakeSayHiListUI$6
  implements MMSlideDelView.f
{
  ShakeSayHiListUI$6(ShakeSayHiListUI paramShakeSayHiListUI) {}
  
  public final void bg(Object paramObject)
  {
    if (paramObject == null)
    {
      y.e("MicroMsg.SayHiListUI", "onItemDel object null");
      return;
    }
    d.Sa().Hs(paramObject.toString());
    ShakeSayHiListUI.b(this.odv).a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.6
 * JD-Core Version:    0.7.0.1
 */