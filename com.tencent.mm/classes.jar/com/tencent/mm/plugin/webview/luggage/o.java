package com.tencent.mm.plugin.webview.luggage;

import android.os.Looper;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.e.c;
import com.tencent.mm.plugin.webview.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;

public final class o
{
  private static HashMap<String, Integer> WHv;
  
  static
  {
    AppMethodBeat.i(78406);
    WHv = new HashMap();
    AppMethodBeat.o(78406);
  }
  
  public static int a(p paramp, c paramc)
  {
    AppMethodBeat.i(295952);
    int i = r.a(MMApplicationContext.getContext(), paramp).intValue();
    e.a(paramp.hashCode(), paramc);
    AppMethodBeat.o(295952);
    return i;
  }
  
  public static void remove(int paramInt)
  {
    AppMethodBeat.i(78405);
    p localp = r.d(Integer.valueOf(paramInt));
    if (localp != null)
    {
      e.atM(localp.hashCode());
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
            o.this.destroy();
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
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.o
 * JD-Core Version:    0.7.0.1
 */