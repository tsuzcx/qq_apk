package com.tencent.mm.plugin.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

final class a$5
  implements az.b.a
{
  a$5(a parama) {}
  
  public final void s(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(26824);
    Log.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramString, this.GWs.jaK, Boolean.valueOf(paramBoolean) });
    this.GWs.GWq.dead();
    AppMethodBeat.o(26824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.5
 * JD-Core Version:    0.7.0.1
 */