package com.tencent.mm.sdk.g.c;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.a;
import com.tencent.mm.sdk.platformtools.al;

public final class c
{
  private static a ytn;
  public static final e yto;
  
  static
  {
    AppMethodBeat.i(52692);
    yto = new e()
    {
      public final HandlerThread a(final Runnable paramAnonymousRunnable, String paramAnonymousString, final Printer paramAnonymousPrinter)
      {
        AppMethodBeat.i(52689);
        paramAnonymousRunnable = new HandlerThread("[GT]".concat(String.valueOf(paramAnonymousString)))
        {
          protected final void onLooperPrepared()
          {
            AppMethodBeat.i(52686);
            super.onLooperPrepared();
            getLooper().setMessageLogging(paramAnonymousPrinter);
            AppMethodBeat.o(52686);
          }
          
          public final void run()
          {
            AppMethodBeat.i(52685);
            super.run();
            if (paramAnonymousRunnable != null) {
              paramAnonymousRunnable.run();
            }
            AppMethodBeat.o(52685);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(52687);
            String str = String.format("[%s,%s,%s]", new Object[] { getName(), Long.valueOf(getId()), getState() });
            AppMethodBeat.o(52687);
            return str;
          }
        };
        if (c.duI() != null) {
          c.duI();
        }
        AppMethodBeat.o(52689);
        return paramAnonymousRunnable;
      }
      
      public final HandlerThread aqw(String paramAnonymousString)
      {
        AppMethodBeat.i(52688);
        paramAnonymousString = new HandlerThread("[GT]".concat(String.valueOf(paramAnonymousString)))
        {
          public final void run()
          {
            AppMethodBeat.i(52683);
            super.run();
            if (this.eEA != null) {
              this.eEA.run();
            }
            AppMethodBeat.o(52683);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(52684);
            String str = String.format("[%s,%s,%s]", new Object[] { getName(), Long.valueOf(getId()), getState() });
            AppMethodBeat.o(52684);
            return str;
          }
        };
        if (c.duI() != null) {
          c.duI();
        }
        AppMethodBeat.o(52688);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(52692);
  }
  
  public static HandlerThread aqv(String paramString)
  {
    AppMethodBeat.i(52690);
    paramString = yto.aqw(paramString);
    AppMethodBeat.o(52690);
    return paramString;
  }
  
  public static al duH()
  {
    AppMethodBeat.i(52691);
    al localal = new al("worker");
    AppMethodBeat.o(52691);
    return localal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.g.c.c
 * JD-Core Version:    0.7.0.1
 */