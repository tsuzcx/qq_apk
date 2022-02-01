package com.tencent.mm.plugin.webview.luggage;

import android.os.Looper;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.f.c;
import com.tencent.mm.plugin.webview.f.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;

public final class n
{
  private static HashMap<String, Integer> IUH;
  
  static
  {
    AppMethodBeat.i(78406);
    IUH = new HashMap();
    AppMethodBeat.o(78406);
  }
  
  public static int a(p paramp, c paramc)
  {
    AppMethodBeat.i(210934);
    int i = r.a(MMApplicationContext.getContext(), paramp).intValue();
    e.a(paramp.hashCode(), paramc);
    AppMethodBeat.o(210934);
    return i;
  }
  
  public static void remove(int paramInt)
  {
    AppMethodBeat.i(78405);
    p localp = r.c(Integer.valueOf(paramInt));
    if (localp != null)
    {
      e.agf(localp.hashCode());
      if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
        try
        {
          localp.destroy();
          AppMethodBeat.o(78405);
          return;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.LuggageWebCoreStash", localException, "", new Object[0]);
          AppMethodBeat.o(78405);
          return;
        }
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78403);
          try
          {
            this.xwm.destroy();
            AppMethodBeat.o(78403);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.LuggageWebCoreStash", localException, "", new Object[0]);
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