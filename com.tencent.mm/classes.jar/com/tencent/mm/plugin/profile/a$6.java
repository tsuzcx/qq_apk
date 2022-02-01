package com.tencent.mm.plugin.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.f;

final class a$6
  implements az.b.a
{
  a$6(a parama, f paramf) {}
  
  public final void s(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(246285);
    Log.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramString, this.GWs.jaK, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      bh.beI();
      paramString = c.bbL().RG(paramString).ayr();
      a.a(this.qTL, this.GWs.tmY, this.GWs.GWp, paramString);
    }
    AppMethodBeat.o(246285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.6
 * JD-Core Version:    0.7.0.1
 */