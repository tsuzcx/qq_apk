package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class k$4$1$1
  implements am.b.a
{
  k$4$1$1(k.4.1 param1, String paramString) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramString, this.mXG.mXE.mXC.dpj, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      au.Hx();
      paramString = c.Fw().abl(paramString).Bp();
      this.mXG.mXE.mXC.eo(this.mXF, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.4.1.1
 * JD-Core Version:    0.7.0.1
 */