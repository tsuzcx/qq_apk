package com.tencent.mm.splash;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
{
  private static Application HUP;
  private static boolean Ilu = false;
  private static a Ilv;
  private static boolean Ilw = false;
  private static o.a Ilx;
  private static String cDP;
  
  public static void a(Application paramApplication, String paramString1, String paramString2)
  {
    boolean bool1 = true;
    AppMethodBeat.i(40683);
    HUP = paramApplication;
    cDP = paramString1;
    h.a(new o()
    {
      public final void d(o.a paramAnonymousa)
      {
        AppMethodBeat.i(40682);
        ad.i("MicroMsg.SplashInit", "do one more thing");
        m.c(paramAnonymousa);
        m.FZ(this.Ily);
        m.fnF();
        AppMethodBeat.o(40682);
      }
    });
    h.fnx().mStartTimestamp = System.currentTimeMillis();
    if (!paramApplication.getPackageName().equals(paramString1)) {
      h.b("MicroMsg.SplashInit", "not main process(%s), no hack, do fallback.", new Object[] { paramString1 });
    }
    for (;;)
    {
      Ilu = bool1;
      if (h.IkC != null) {
        h.IkC.MN();
      }
      if ((!bool1) || (a.ju(paramApplication))) {}
      try
      {
        a.jw(paramApplication);
        boolean bool2 = a.jy(paramApplication);
        h.b("MicroMsg.SplashInit", "block checking dex opt result: %s", new Object[] { Boolean.valueOf(bool2) });
        if (!bool2)
        {
          h.b("MicroMsg.SplashInit", "dexopt service return failed or timeout. kill self.", new Object[0]);
          h.dyJ();
        }
        a.jv(paramApplication);
        if ((g.zz) || (bool1)) {
          aRW(paramString2);
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
        h.fnx().idkey(675L, 5L, 1L);
        h.jz(paramApplication);
        h.b("MicroMsg.SplashInit", "hack failed, do fallback logic.", new Object[0]);
      }
      else
      {
        bool1 = false;
        h.fns();
      }
    }
  }
  
  private static void aRW(String paramString)
  {
    AppMethodBeat.i(40684);
    if (Ilv != null)
    {
      AppMethodBeat.o(40684);
      return;
    }
    paramString = aRX(paramString);
    paramString.b(HUP, cDP);
    Ilv = paramString;
    AppMethodBeat.o(40684);
  }
  
  private static a aRX(String paramString)
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
  
  public static void fnF()
  {
    AppMethodBeat.i(40685);
    if ((Ilw) && (Ilx != null)) {
      Ilv.a(Ilx);
    }
    AppMethodBeat.o(40685);
  }
  
  public static void fnG()
  {
    AppMethodBeat.i(40686);
    h.b("MicroMsg.SplashInit", "applicationOnCreate", new Object[0]);
    h.fno();
    Ilw = true;
    if (Ilu)
    {
      Ilv.MO();
      AppMethodBeat.o(40686);
      return;
    }
    fnF();
    AppMethodBeat.o(40686);
  }
  
  public static abstract interface a
  {
    public abstract void MO();
    
    public abstract void a(o.a parama);
    
    public abstract void b(Application paramApplication, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.m
 * JD-Core Version:    0.7.0.1
 */