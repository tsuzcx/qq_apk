package com.tencent.wecall.talkroom.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

final class f$9
  implements Runnable
{
  f$9(f paramf) {}
  
  public final void run()
  {
    Object localObject2 = null;
    AppMethodBeat.i(127878);
    int i = f.a(this.BBh);
    if (f.t(this.BBh) == null) {}
    for (Object localObject1 = null;; localObject1 = Integer.valueOf(f.t(this.BBh).getType()))
    {
      c.d("TalkRoomService", new Object[] { "beginSenceCircle state: ", Integer.valueOf(i), " mCircleScene: ", localObject1, " mIsAck: ", Boolean.valueOf(f.u(this.BBh)) });
      if (f.t(this.BBh) != null) {
        break;
      }
      f.w(this.BBh).removeCallbacks(f.v(this.BBh));
      c.w("TalkRoomService", new Object[] { "beginSenceCircle removeCallbacks" });
      AppMethodBeat.o(127878);
      return;
    }
    if (!this.BBh.cMa())
    {
      f.w(this.BBh).removeCallbacks(f.v(this.BBh));
      c.w("TalkRoomService", new Object[] { "beginSenceCircle removeCallbacks" });
      AppMethodBeat.o(127878);
      return;
    }
    localObject1 = localObject2;
    if (f.t(this.BBh) != null)
    {
      localObject1 = localObject2;
      if (f.t(this.BBh).getType() == 202)
      {
        localObject1 = localObject2;
        if (f.a(this.BBh) == 3)
        {
          com.tencent.wecall.talkroom.a.e locale = (com.tencent.wecall.talkroom.a.e)f.t(this.BBh);
          localObject1 = localObject2;
          if (f.a(this.BBh, locale.nuW, locale.nTj, locale.tFh, f.Ts(locale.BCw)))
          {
            localObject1 = new com.tencent.wecall.talkroom.a.e(locale);
            c.w("TalkRoomService", new Object[] { "beginSenceCircle enter" });
          }
        }
      }
    }
    if (localObject1 != null)
    {
      com.tencent.pb.common.b.e.dTE().a((d)localObject1);
      AppMethodBeat.o(127878);
      return;
    }
    f.w(this.BBh).removeCallbacks(f.v(this.BBh));
    c.w("TalkRoomService", new Object[] { "beginSenceCircle removeCallbacks" });
    AppMethodBeat.o(127878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.f.9
 * JD-Core Version:    0.7.0.1
 */