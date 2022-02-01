package com.tencent.mm.splash;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
{
  private static boolean acBB = false;
  private static a acBC;
  private static boolean acBD = false;
  private static p.a acBE;
  private static String eMg;
  private static Application fgz;
  
  public static void a(Application paramApplication, String paramString1, String paramString2)
  {
    boolean bool1 = true;
    AppMethodBeat.i(40683);
    fgz = paramApplication;
    eMg = paramString1;
    i.a(new p()
    {
      public final void d(p.a paramAnonymousa)
      {
        AppMethodBeat.i(40682);
        Log.i("MicroMsg.SplashInit", "do one more thing");
        n.c(paramAnonymousa);
        n.OJ(n.this);
        n.iWa();
        AppMethodBeat.o(40682);
      }
    });
    i.iVT().mStartTimestamp = System.currentTimeMillis();
    if (!paramApplication.getPackageName().equals(paramString1)) {
      i.g("MicroMsg.SplashInit", "not main process(%s), no hack, do fallback.", new Object[] { paramString1 });
    }
    for (;;)
    {
      acBB = bool1;
      if (i.acAI != null) {
        i.acAI.aDt();
      }
      if ((!bool1) || (a.iVC())) {}
      try
      {
        a.mA(paramApplication);
        boolean bool2 = a.mC(paramApplication);
        i.g("MicroMsg.SplashInit", "block checking dex opt result: %s", new Object[] { Boolean.valueOf(bool2) });
        if (!bool2)
        {
          i.g("MicroMsg.SplashInit", "dexopt service return failed or timeout. kill self.", new Object[0]);
          i.gyU();
        }
        a.iVD();
        if ((g.bKk) || (bool1)) {
          buK(paramString2);
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
      if (!i.q(paramApplication))
      {
        i.iVT().idkey(675L, 5L, 1L);
        i.mE(paramApplication);
        i.g("MicroMsg.SplashInit", "hack failed, do fallback logic.", new Object[0]);
      }
      else
      {
        bool1 = false;
        i.iVO();
      }
    }
  }
  
  private static void buK(String paramString)
  {
    AppMethodBeat.i(40684);
    if (acBC != null)
    {
      AppMethodBeat.o(40684);
      return;
    }
    paramString = buL(paramString);
    paramString.a(fgz, eMg);
    acBC = paramString;
    AppMethodBeat.o(40684);
  }
  
  private static a buL(String paramString)
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
  
  public static void iWa()
  {
    AppMethodBeat.i(40685);
    if ((acBD) && (acBE != null)) {
      acBC.a(acBE);
    }
    AppMethodBeat.o(40685);
  }
  
  public static void iWb()
  {
    AppMethodBeat.i(40686);
    i.g("MicroMsg.SplashInit", "applicationOnCreate", new Object[0]);
    i.iVK();
    acBD = true;
    if (acBB)
    {
      acBC.aDu();
      AppMethodBeat.o(40686);
      return;
    }
    iWa();
    AppMethodBeat.o(40686);
  }
  
  public static abstract interface a
  {
    public abstract void a(Application paramApplication, String paramString);
    
    public abstract void a(p.a parama);
    
    public abstract void aDu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.splash.n
 * JD-Core Version:    0.7.0.1
 */