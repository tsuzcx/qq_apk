package com.tencent.mm.plugin.webview.luggage;

import android.os.Looper;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.e.c;
import com.tencent.mm.plugin.webview.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;

public final class m
{
  private static HashMap<String, Integer> AUl;
  
  static
  {
    AppMethodBeat.i(78406);
    AUl = new HashMap();
    AppMethodBeat.o(78406);
  }
  
  public static int a(k paramk, c paramc)
  {
    AppMethodBeat.i(187866);
    int i = com.tencent.luggage.d.m.a(aj.getContext(), paramk).intValue();
    e.a(paramk.hashCode(), paramc);
    AppMethodBeat.o(187866);
    return i;
  }
  
  public static void remove(int paramInt)
  {
    AppMethodBeat.i(78405);
    k localk = com.tencent.luggage.d.m.b(Integer.valueOf(paramInt));
    if (localk != null)
    {
      e.ST(localk.hashCode());
      if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
        try
        {
          localk.destroy();
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
            this.rOW.destroy();
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
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.m
 * JD-Core Version:    0.7.0.1
 */