package com.tencent.mm.splash;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
{
  private static Application ELQ;
  private static boolean Fci = false;
  private static a Fcj;
  private static boolean Fck = false;
  private static o.a Fcl;
  private static String cvL;
  
  public static void a(Application paramApplication, String paramString1, String paramString2)
  {
    boolean bool1 = true;
    AppMethodBeat.i(40683);
    ELQ = paramApplication;
    cvL = paramString1;
    h.a(new o()
    {
      public final void d(o.a paramAnonymousa)
      {
        AppMethodBeat.i(40682);
        ad.i("MicroMsg.SplashInit", "do one more thing");
        m.c(paramAnonymousa);
        m.yP(this.Fcm);
        m.eIz();
        AppMethodBeat.o(40682);
      }
    });
    h.eIr().mStartTimestamp = System.currentTimeMillis();
    if (!paramApplication.getPackageName().equals(paramString1)) {
      h.b("MicroMsg.SplashInit", "not main process(%s), no hack, do fallback.", new Object[] { paramString1 });
    }
    for (;;)
    {
      Fci = bool1;
      if (h.Fbr != null) {
        h.Fbr.Lh();
      }
      if ((!bool1) || (a.ja(paramApplication))) {}
      try
      {
        a.jc(paramApplication);
        boolean bool2 = a.je(paramApplication);
        h.b("MicroMsg.SplashInit", "block checking dex opt result: %s", new Object[] { Boolean.valueOf(bool2) });
        if (!bool2)
        {
          h.b("MicroMsg.SplashInit", "dexopt service return failed or timeout. kill self.", new Object[0]);
          h.daD();
        }
        a.jb(paramApplication);
        if ((g.wH) || (bool1)) {
          aGW(paramString2);
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
        h.eIr().idkey(675L, 5L, 1L);
        h.jf(paramApplication);
        h.b("MicroMsg.SplashInit", "hack failed, do fallback logic.", new Object[0]);
      }
      else
      {
        bool1 = false;
        h.eIm();
      }
    }
  }
  
  private static void aGW(String paramString)
  {
    AppMethodBeat.i(40684);
    if (Fcj != null)
    {
      AppMethodBeat.o(40684);
      return;
    }
    paramString = aGX(paramString);
    paramString.b(ELQ, cvL);
    Fcj = paramString;
    AppMethodBeat.o(40684);
  }
  
  private static a aGX(String paramString)
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
      ad.printErrStackTrace("MicroMsg.SplashInit", localException, "%s has problem!", new Object[] { paramString });
      paramString = new RuntimeException(localException);
      AppMethodBeat.o(40687);
      throw paramString;
    }
  }
  
  public static void eIA()
  {
    AppMethodBeat.i(40686);
    h.b("MicroMsg.SplashInit", "applicationOnCreate", new Object[0]);
    h.eIi();
    Fck = true;
    if (Fci)
    {
      Fcj.Li();
      AppMethodBeat.o(40686);
      return;
    }
    eIz();
    AppMethodBeat.o(40686);
  }
  
  public static void eIz()
  {
    AppMethodBeat.i(40685);
    if ((Fck) && (Fcl != null)) {
      Fcj.a(Fcl);
    }
    AppMethodBeat.o(40685);
  }
  
  public static abstract interface a
  {
    public abstract void Li();
    
    public abstract void a(o.a parama);
    
    public abstract void b(Application paramApplication, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.m
 * JD-Core Version:    0.7.0.1
 */