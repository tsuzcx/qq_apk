package com.tencent.mm.plugin.webview.luggage;

import android.os.Looper;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.e.c;
import com.tencent.mm.plugin.webview.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.HashMap;

public final class n
{
  private static HashMap<String, Integer> EhT;
  
  static
  {
    AppMethodBeat.i(78406);
    EhT = new HashMap();
    AppMethodBeat.o(78406);
  }
  
  public static int a(p paramp, c paramc)
  {
    AppMethodBeat.i(198077);
    int i = r.a(ak.getContext(), paramp).intValue();
    e.a(paramp.hashCode(), paramc);
    AppMethodBeat.o(198077);
    return i;
  }
  
  public static void remove(int paramInt)
  {
    AppMethodBeat.i(78405);
    p localp = r.c(Integer.valueOf(paramInt));
    if (localp != null)
    {
      e.Xx(localp.hashCode());
      if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
        try
        {
          localp.destroy();
          AppMethodBeat.o(78405);
          return;
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("MicroMsg.LuggageWebCoreStash", localException, "", new Object[0]);
          AppMethodBeat.o(78405);
          return;
        }
      }
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78403);
          try
          {
            this.uen.destroy();
            AppMethodBeat.o(78403);
            return;
          }
          catch (Exception localException)
          {
            ae.printErrStackTrace("MicroMsg.LuggageWebCoreStash", localException, "", new Object[0]);
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