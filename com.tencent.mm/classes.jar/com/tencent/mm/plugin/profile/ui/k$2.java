package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.model.am.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

final class k$2
  implements am.b.a
{
  k$2(k paramk) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramString, this.mXC.dpj, Boolean.valueOf(paramBoolean) });
    this.mXC.mXB.dead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.2
 * JD-Core Version:    0.7.0.1
 */