package com.tencent.mm.splash;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class m
{
  private static boolean IFF = false;
  private static a IFG;
  private static boolean IFH = false;
  private static o.a IFI;
  private static Application IoX;
  private static String cEw;
  
  public static void a(Application paramApplication, String paramString1, String paramString2)
  {
    boolean bool1 = true;
    AppMethodBeat.i(40683);
    IoX = paramApplication;
    cEw = paramString1;
    h.a(new o()
    {
      public final void d(o.a paramAnonymousa)
      {
        AppMethodBeat.i(40682);
        ae.i("MicroMsg.SplashInit", "do one more thing");
        m.c(paramAnonymousa);
        m.GB(this.IFJ);
        m.fry();
        AppMethodBeat.o(40682);
      }
    });
    h.frq().mStartTimestamp = System.currentTimeMillis();
    if (!paramApplication.getPackageName().equals(paramString1)) {
      h.b("MicroMsg.SplashInit", "not main process(%s), no hack, do fallback.", new Object[] { paramString1 });
    }
    for (;;)
    {
      IFF = bool1;
      if (h.IEN != null) {
        h.IEN.MI();
      }
      if ((!bool1) || (a.jA(paramApplication))) {}
      try
      {
        a.jC(paramApplication);
        boolean bool2 = a.jE(paramApplication);
        h.b("MicroMsg.SplashInit", "block checking dex opt result: %s", new Object[] { Boolean.valueOf(bool2) });
        if (!bool2)
        {
          h.b("MicroMsg.SplashInit", "dexopt service return failed or timeout. kill self.", new Object[0]);
          h.dCa();
        }
        a.jB(paramApplication);
        if ((g.zz) || (bool1)) {
          aTt(paramString2);
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
      if (!h.q(paramApplication))
      {
        h.frq().idkey(675L, 5L, 1L);
        h.jG(paramApplication);
        h.b("MicroMsg.SplashInit", "hack failed, do fallback logic.", new Object[0]);
      }
      else
      {
        bool1 = false;
        h.frl();
      }
    }
  }
  
  private static void aTt(String paramString)
  {
    AppMethodBeat.i(40684);
    if (IFG != null)
    {
      AppMethodBeat.o(40684);
      return;
    }
    paramString = aTu(paramString);
    paramString.a(IoX, cEw);
    IFG = paramString;
    AppMethodBeat.o(40684);
  }
  
  private static a aTu(String paramString)
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
      ae.printErrStackTrace("MicroMsg.SplashInit", localException, "%s has problem!", new Object[] { paramString });
      paramString = new RuntimeException(localException);
      AppMethodBeat.o(40687);
      throw paramString;
    }
  }
  
  public static void fry()
  {
    AppMethodBeat.i(40685);
    if ((IFH) && (IFI != null)) {
      IFG.a(IFI);
    }
    AppMethodBeat.o(40685);
  }
  
  public static void frz()
  {
    AppMethodBeat.i(40686);
    h.b("MicroMsg.SplashInit", "applicationOnCreate", new Object[0]);
    h.frh();
    IFH = true;
    if (IFF)
    {
      IFG.MJ();
      AppMethodBeat.o(40686);
      return;
    }
    fry();
    AppMethodBeat.o(40686);
  }
  
  public static abstract interface a
  {
    public abstract void MJ();
    
    public abstract void a(Application paramApplication, String paramString);
    
    public abstract void a(o.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.m
 * JD-Core Version:    0.7.0.1
 */