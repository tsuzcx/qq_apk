package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.talkroom.component.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class g$2
  extends b.a
{
  g$2(g paramg) {}
  
  public final void keep_OnError(int paramInt)
  {
    AppMethodBeat.i(25806);
    ab.e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", new Object[] { Integer.valueOf(paramInt) });
    b.cHv().cHA();
    b.cHv().tcm = 1;
    g.a(this.tdh).t("component OnError ".concat(String.valueOf(paramInt)), 99, paramInt);
    new ak(Looper.getMainLooper()).post(new g.2.2(this));
    AppMethodBeat.o(25806);
  }
  
  public final void keep_OnOpenSuccess()
  {
    AppMethodBeat.i(25805);
    ab.i("MicroMsg.TalkRoomServer", "OnOpenSuccess");
    if (g.b(this.tdh) != 1)
    {
      ab.w("MicroMsg.TalkRoomServer", "has exit the talkroom state:%d", new Object[] { Integer.valueOf(g.b(this.tdh)) });
      AppMethodBeat.o(25805);
      return;
    }
    b.cHv().cHA();
    new ak(Looper.getMainLooper()).post(new g.2.1(this));
    g.d(this.tdh);
    g.a(this.tdh).akV();
    AppMethodBeat.o(25805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g.2
 * JD-Core Version:    0.7.0.1
 */