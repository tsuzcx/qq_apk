package com.tencent.mm.plugin.webview.luggage;

import android.os.Looper;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.e.c;
import com.tencent.mm.plugin.webview.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;

public final class n
{
  private static HashMap<String, Integer> DPT;
  
  static
  {
    AppMethodBeat.i(78406);
    DPT = new HashMap();
    AppMethodBeat.o(78406);
  }
  
  public static int a(p paramp, c paramc)
  {
    AppMethodBeat.i(207897);
    int i = r.a(aj.getContext(), paramp).intValue();
    e.a(paramp.hashCode(), paramc);
    AppMethodBeat.o(207897);
    return i;
  }
  
  public static void remove(int paramInt)
  {
    AppMethodBeat.i(78405);
    p localp = r.b(Integer.valueOf(paramInt));
    if (localp != null)
    {
      e.WR(localp.hashCode());
      if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
        try
        {
          localp.destroy();
          AppMethodBeat.o(78405);
          return;
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.LuggageWebCoreStash", localException, "", new Object[0]);
          AppMethodBeat.o(78405);
          return;
        }
      }
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78403);
          try
          {
            this.tTv.destroy();
            AppMethodBeat.o(78403);
            return;
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MicroMsg.LuggageWebCoreStash", localException, "", new Object[0]);
            AppMethodBeat.o(78403);
          }
        }
      });
    }
    AppMethodBeat.o(78405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.n
 * JD-Core Version:    0.7.0.1
 */