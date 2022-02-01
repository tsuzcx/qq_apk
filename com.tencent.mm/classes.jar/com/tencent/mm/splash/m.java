package com.tencent.mm.splash;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
{
  private static o.a NMA;
  private static boolean NMx = false;
  private static a NMy;
  private static boolean NMz = false;
  private static String cQi;
  private static Application gNz;
  
  public static void a(Application paramApplication, String paramString1, String paramString2)
  {
    boolean bool1 = true;
    AppMethodBeat.i(40683);
    gNz = paramApplication;
    cQi = paramString1;
    h.a(new o()
    {
      public final void d(o.a paramAnonymousa)
      {
        AppMethodBeat.i(40682);
        Log.i("MicroMsg.SplashInit", "do one more thing");
        m.c(paramAnonymousa);
        m.Pn(this.NMB);
        m.gyy();
        AppMethodBeat.o(40682);
      }
    });
    h.gyq().mStartTimestamp = System.currentTimeMillis();
    if (!paramApplication.getPackageName().equals(paramString1)) {
      h.c("MicroMsg.SplashInit", "not main process(%s), no hack, do fallback.", new Object[] { paramString1 });
    }
    for (;;)
    {
      NMx = bool1;
      if (h.NLG != null) {
        h.NLG.WV();
      }
      if ((!bool1) || (a.jw(paramApplication))) {}
      try
      {
        a.jy(paramApplication);
        boolean bool2 = a.jA(paramApplication);
        h.c("MicroMsg.SplashInit", "block checking dex opt result: %s", new Object[] { Boolean.valueOf(bool2) });
        if (!bool2)
        {
          h.c("MicroMsg.SplashInit", "dexopt service return failed or timeout. kill self.", new Object[0]);
          h.eCp();
        }
        a.jx(paramApplication);
        if ((g.zF) || (bool1)) {
          bin(paramString2);
        }
        AppMethodBeat.o(40683);
        return;
      }
      catch (InterruptedException paramApplication)
      {
        paramApplication = new RuntimeException(paramApplication);
        AppMethodBeat.o(40683);
        throw paramApplication;
      }
      if (!h.o(paramApplication))
      {
        h.gyq().idkey(675L, 5L, 1L);
        h.jC(paramApplication);
        h.c("MicroMsg.SplashInit", "hack failed, do fallback logic.", new Object[0]);
      }
      else
      {
        bool1 = false;
        h.gyl();
      }
    }
  }
  
  private static void bin(String paramString)
  {
    AppMethodBeat.i(40684);
    if (NMy != null)
    {
      AppMethodBeat.o(40684);
      return;
    }
    paramString = bio(paramString);
    paramString.a(gNz, cQi);
    NMy = paramString;
    AppMethodBeat.o(40684);
  }
  
  private static a bio(String paramString)
  {
    AppMethodBeat.i(40687);
    try
    {
      a locala = (a)Class.forName(paramString).newInstance();
      AppMethodBeat.o(40687);
      return locala;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SplashInit", localException, "%s has problem!", new Object[] { paramString });
      paramString = new RuntimeException(localException);
      AppMethodBeat.o(40687);
      throw paramString;
    }
  }
  
  public static void gyy()
  {
    AppMethodBeat.i(40685);
    if ((NMz) && (NMA != null)) {
      NMy.a(NMA);
    }
    AppMethodBeat.o(40685);
  }
  
  public static void gyz()
  {
    AppMethodBeat.i(40686);
    h.c("MicroMsg.SplashInit", "applicationOnCreate", new Object[0]);
    h.gyh();
    NMz = true;
    if (NMx)
    {
      NMy.WW();
      AppMethodBeat.o(40686);
      return;
    }
    gyy();
    AppMethodBeat.o(40686);
  }
  
  public static abstract interface a
  {
    public abstract void WW();
    
    public abstract void a(Application paramApplication, String paramString);
    
    public abstract void a(o.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.m
 * JD-Core Version:    0.7.0.1
 */