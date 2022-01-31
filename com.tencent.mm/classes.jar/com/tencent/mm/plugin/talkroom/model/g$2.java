package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.plugin.talkroom.component.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class g$2
  extends b.a
{
  g$2(g paramg) {}
  
  public final void keep_OnError(int paramInt)
  {
    y.e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", new Object[] { Integer.valueOf(paramInt) });
    b.bMx().bMB();
    b.bMx().pAC = 1;
    g.a(this.pBx).i("component OnError " + paramInt, 99, paramInt);
    new ah(Looper.getMainLooper()).post(new g.2.2(this));
  }
  
  public final void keep_OnOpenSuccess()
  {
    y.i("MicroMsg.TalkRoomServer", "OnOpenSuccess");
    if (g.b(this.pBx) != 1)
    {
      y.w("MicroMsg.TalkRoomServer", "has exit the talkroom state:%d", new Object[] { Integer.valueOf(g.b(this.pBx)) });
      return;
    }
    b.bMx().bMB();
    new ah(Looper.getMainLooper()).post(new g.2.1(this));
    g.d(this.pBx);
    g.a(this.pBx).RM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.g.2
 * JD-Core Version:    0.7.0.1
 */