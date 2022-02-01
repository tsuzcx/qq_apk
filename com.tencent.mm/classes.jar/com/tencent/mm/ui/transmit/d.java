package com.tencent.mm.ui.transmit;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;

public final class d
{
  public static void a(String paramString, final a parama)
  {
    AppMethodBeat.i(234477);
    h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(234475);
        long l = s.boW(this.msL);
        if (l > 1048576L)
        {
          Log.e("MusicVideoShareUtil", "img size is too large");
          parama.be(null, false);
          AppMethodBeat.o(234475);
          return;
        }
        if ((l >= 1048576L) && (l < 1048576L))
        {
          d.b(s.k(this.msL, false), parama);
          AppMethodBeat.o(234475);
          return;
        }
        d.b(this.msL, parama);
        AppMethodBeat.o(234475);
      }
    }, "PageLongTaskReporter");
    AppMethodBeat.o(234477);
  }
  
  public static abstract interface a
  {
    public abstract void be(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.d
 * JD-Core Version:    0.7.0.1
 */