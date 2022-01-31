package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class k$3
  implements am.b.a
{
  k$3(k paramk) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramString, this.mXC.dpj, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      au.Hx();
      paramString = c.Fw().abl(paramString).Bp();
      this.mXC.eo(this.mXC.bGR, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.3
 * JD-Core Version:    0.7.0.1
 */