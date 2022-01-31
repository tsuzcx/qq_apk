package com.tencent.mm.plugin.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

final class a$4
  implements ao.b.a
{
  a$4(a parama) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23206);
    ab.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramString, this.pxs.egF, Boolean.valueOf(paramBoolean) });
    this.pxs.pxr.dead();
    AppMethodBeat.o(23206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.4
 * JD-Core Version:    0.7.0.1
 */