package com.tencent.mm.splash;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class m
{
  private static Application Gjc;
  private static boolean GzA = false;
  private static a GzB;
  private static boolean GzC = false;
  private static o.a GzD;
  private static String csT;
  
  public static void a(Application paramApplication, String paramString1, String paramString2)
  {
    boolean bool1 = true;
    AppMethodBeat.i(40683);
    Gjc = paramApplication;
    csT = paramString1;
    h.a(new o()
    {
      public final void d(o.a paramAnonymousa)
      {
        AppMethodBeat.i(40682);
        ac.i("MicroMsg.SplashInit", "do one more thing");
        m.c(paramAnonymousa);
        m.CU(this.GzE);
        m.eXV();
        AppMethodBeat.o(40682);
      }
    });
    h.eXN().mStartTimestamp = System.currentTimeMillis();
    if (!paramApplication.getPackageName().equals(paramString1)) {
      h.b("MicroMsg.SplashInit", "not main process(%s), no hack, do fallback.", new Object[] { paramString1 });
    }
    for (;;)
    {
      GzA = bool1;
      if (h.GyI != null) {
        h.GyI.Lf();
      }
      if ((!bool1) || (a.jl(paramApplication))) {}
      try
      {
        a.jn(paramApplication);
        boolean bool2 = a.jp(paramApplication);
        h.b("MicroMsg.SplashInit", "block checking dex opt result: %s", new Object[] { Boolean.valueOf(bool2) });
        if (!bool2)
        {
          h.b("MicroMsg.SplashInit", "dexopt service return failed or timeout. kill self.", new Object[0]);
          h.dol();
        }
        a.jm(paramApplication);
        if ((g.xF) || (bool1)) {
          aMp(paramString2);
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
      if (!h.m(paramApplication))
      {
        h.eXN().idkey(675L, 5L, 1L);
        h.jq(paramApplication);
        h.b("MicroMsg.SplashInit", "hack failed, do fallback logic.", new Object[0]);
      }
      else
      {
        bool1 = false;
        h.eXI();
      }
    }
  }
  
  private static void aMp(String paramString)
  {
    AppMethodBeat.i(40684);
    if (GzB != null)
    {
      AppMethodBeat.o(40684);
      return;
    }
    paramString = aMq(paramString);
    paramString.b(Gjc, csT);
    GzB = paramString;
    AppMethodBeat.o(40684);
  }
  
  private static a aMq(String paramString)
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
      ac.printErrStackTrace("MicroMsg.SplashInit", localException, "%s has problem!", new Object[] { paramString });
      paramString = new RuntimeException(localException);
      AppMethodBeat.o(40687);
      throw paramString;
    }
  }
  
  public static void eXV()
  {
    AppMethodBeat.i(40685);
    if ((GzC) && (GzD != null)) {
      GzB.a(GzD);
    }
    AppMethodBeat.o(40685);
  }
  
  public static void eXW()
  {
    AppMethodBeat.i(40686);
    h.b("MicroMsg.SplashInit", "applicationOnCreate", new Object[0]);
    h.eXE();
    GzC = true;
    if (GzA)
    {
      GzB.Lg();
      AppMethodBeat.o(40686);
      return;
    }
    eXV();
    AppMethodBeat.o(40686);
  }
  
  public static abstract interface a
  {
    public abstract void Lg();
    
    public abstract void a(o.a parama);
    
    public abstract void b(Application paramApplication, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.m
 * JD-Core Version:    0.7.0.1
 */