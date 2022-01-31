package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

class jw$a$1
  extends Handler
{
  jw$a$1(jw.a parama) {}
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(148837);
    jw.a.a(this.a, jw.a.a(this.a) + jw.a.b(this.a));
    jw.a(this.a.a, jw.a.c(this.a), jw.a.d(this.a), jw.a.e(this.a), jw.a.a(this.a));
    if (jw.a.f(this.a) < jw.a.g(this.a) - 1)
    {
      jw.a.i(this.a).sendEmptyMessageDelayed(0, jw.a.h(this.a));
      AppMethodBeat.o(148837);
      return;
    }
    if (jw.a.j(this.a))
    {
      jw.a(this.a.a);
      jw.a.k(this.a);
      AppMethodBeat.o(148837);
      return;
    }
    jw.a(this.a.a, jw.a.c(this.a), jw.a.d(this.a), jw.a.e(this.a), jw.a.l(this.a));
    AppMethodBeat.o(148837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jw.a.1
 * JD-Core Version:    0.7.0.1
 */