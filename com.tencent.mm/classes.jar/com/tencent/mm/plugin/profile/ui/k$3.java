package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class k$3
  implements ao.b.a
{
  k$3(k paramk) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23568);
    ab.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramString, this.pAx.egF, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      aw.aaz();
      paramString = c.YA().arw(paramString).Oe();
      this.pAx.fM(this.pAx.cog, paramString);
    }
    AppMethodBeat.o(23568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.3
 * JD-Core Version:    0.7.0.1
 */