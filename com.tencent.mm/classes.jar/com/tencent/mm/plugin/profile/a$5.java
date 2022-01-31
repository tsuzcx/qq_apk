package com.tencent.mm.plugin.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.preference.f;

final class a$5
  implements ao.b.a
{
  a$5(a parama, f paramf) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23207);
    ab.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramString, this.pxs.egF, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      aw.aaz();
      paramString = c.YA().arw(paramString).Oe();
      a.a(this.iLO, this.pxs.jpX, this.pxs.pxq, paramString);
    }
    AppMethodBeat.o(23207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.5
 * JD-Core Version:    0.7.0.1
 */