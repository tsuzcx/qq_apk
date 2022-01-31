package com.tencent.mm.plugin.nearby.ui;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class NearbySayHiListUI$9
  implements MMSlideDelView.f
{
  NearbySayHiListUI$9(NearbySayHiListUI paramNearbySayHiListUI) {}
  
  public final void bg(Object paramObject)
  {
    if (paramObject == null)
    {
      y.e("MicroMsg.SayHiListUI", "onItemDel object null");
      return;
    }
    g.DN().CX();
    ((j)g.r(j.class)).bhL().Hs(paramObject.toString());
    NearbySayHiListUI.b(this.mDP).a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.9
 * JD-Core Version:    0.7.0.1
 */