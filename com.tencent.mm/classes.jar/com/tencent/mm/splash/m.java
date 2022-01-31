package com.tencent.mm.splash;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class m
{
  private static String bNv;
  private static Application yvl;
  private static boolean ywi = false;
  private static a ywj;
  private static boolean ywk = false;
  private static o.a ywl;
  
  public static void a(Application paramApplication, String paramString1, String paramString2)
  {
    boolean bool1 = true;
    AppMethodBeat.i(114889);
    yvl = paramApplication;
    bNv = paramString1;
    h.a(new o()
    {
      public final void d(o.a paramAnonymousa)
      {
        AppMethodBeat.i(114888);
        ab.i("MicroMsg.SplashInit", "do one more thing");
        m.c(paramAnonymousa);
        m.tQ(this.ywm);
        m.access$200();
        AppMethodBeat.o(114888);
      }
    });
    h.dvB().mStartTimestamp = System.currentTimeMillis();
    if (!paramApplication.getPackageName().equals(paramString1)) {
      h.c("MicroMsg.SplashInit", "not main process(%s), no hack, do fallback.", new Object[] { paramString1 });
    }
    for (;;)
    {
      ywi = bool1;
      if (h.yvp != null) {
        h.yvp.BL();
      }
      if ((!bool1) || (a.hv(paramApplication))) {}
      try
      {
        a.hx(paramApplication);
        boolean bool2 = a.hz(paramApplication);
        h.c("MicroMsg.SplashInit", "block checking dex opt result: %s", new Object[] { Boolean.valueOf(bool2) });
        if (!bool2)
        {
          h.c("MicroMsg.SplashInit", "dexopt service return failed or timeout. kill self.", new Object[0]);
          h.caC();
        }
        a.hw(paramApplication);
        if ((g.qd) || (bool1)) {
          aqK(paramString2);
        }
        AppMethodBeat.o(114889);
        return;
      }
      catch (InterruptedException paramApplication)
      {
        paramApplication = new RuntimeException(paramApplication);
        AppMethodBeat.o(114889);
        throw paramApplication;
      }
      if (!h.j(paramApplication))
      {
        h.dvB().l(675L, 5L, 1L);
        h.hA(paramApplication);
        h.c("MicroMsg.SplashInit", "hack failed, do fallback logic.", new Object[0]);
      }
      else
      {
        bool1 = false;
        h.dvw();
      }
    }
  }
  
  private static void aqK(String paramString)
  {
    AppMethodBeat.i(114890);
    if (ywj != null)
    {
      AppMethodBeat.o(114890);
      return;
    }
    paramString = aqL(paramString);
    paramString.b(yvl, bNv);
    ywj = paramString;
    AppMethodBeat.o(114890);
  }
  
  private static a aqL(String paramString)
  {
    AppMethodBeat.i(114893);
    try
    {
      a locala = (a)Class.forName(paramString).newInstance();
      AppMethodBeat.o(114893);
      return locala;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SplashInit", localException, "%s has problem!", new Object[] { paramString });
      paramString = new RuntimeException(localException);
      AppMethodBeat.o(114893);
      throw paramString;
    }
  }
  
  private static void dvJ()
  {
    AppMethodBeat.i(114891);
    if ((ywk) && (ywl != null)) {
      ywj.a(ywl);
    }
    AppMethodBeat.o(114891);
  }
  
  public static void dvK()
  {
    AppMethodBeat.i(114892);
    h.c("MicroMsg.SplashInit", "applicationOnCreate", new Object[0]);
    h.dvs();
    ywk = true;
    if (ywi)
    {
      ywj.BM();
      AppMethodBeat.o(114892);
      return;
    }
    dvJ();
    AppMethodBeat.o(114892);
  }
  
  public static abstract interface a
  {
    public abstract void BM();
    
    public abstract void a(o.a parama);
    
    public abstract void b(Application paramApplication, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.m
 * JD-Core Version:    0.7.0.1
 */