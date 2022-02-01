package com.tencent.mm.plugin.webview.luggage;

import android.os.Looper;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.e.c;
import com.tencent.mm.plugin.webview.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;

public final class m
{
  private static HashMap<String, Integer> Cmy;
  
  static
  {
    AppMethodBeat.i(78406);
    Cmy = new HashMap();
    AppMethodBeat.o(78406);
  }
  
  public static int a(k paramk, c paramc)
  {
    AppMethodBeat.i(188292);
    int i = com.tencent.luggage.d.m.a(ai.getContext(), paramk).intValue();
    e.a(paramk.hashCode(), paramc);
    AppMethodBeat.o(188292);
    return i;
  }
  
  public static void remove(int paramInt)
  {
    AppMethodBeat.i(78405);
    k localk = com.tencent.luggage.d.m.b(Integer.valueOf(paramInt));
    if (localk != null)
    {
      e.Vb(localk.hashCode());
      if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
        try
        {
          localk.destroy();
          AppMethodBeat.o(78405);
          return;
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.LuggageWebCoreStash", localException, "", new Object[0]);
          AppMethodBeat.o(78405);
          return;
        }
      }
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78403);
          try
          {
            this.sWM.destroy();
            AppMethodBeat.o(78403);
            return;
          }
          catch (Exception localException)
          {
            ac.printErrStackTrace("MicroMsg.LuggageWebCoreStash", localException, "", new Object[0]);
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