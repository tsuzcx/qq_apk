package com.tencent.thumbplayer.g.a.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.e.a;
import com.tencent.thumbplayer.utils.g;

final class c$2
  implements e.a
{
  c$2(c paramc) {}
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(221583);
    g.i("TPReportManager", "OnGlobalEventChangeListener eventId: ".concat(String.valueOf(paramInt1)));
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(221583);
      return;
    }
    for (paramInt1 = 2100;; paramInt1 = 2101)
    {
      c.g(this.ZFd).obtainMessage(paramInt1, null).sendToTarget();
      AppMethodBeat.o(221583);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.g.a.a.c.2
 * JD-Core Version:    0.7.0.1
 */