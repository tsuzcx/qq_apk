package com.tencent.mm.splash;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
{
  private static boolean Vah = false;
  private static a Vai;
  private static boolean Vaj = false;
  private static p.a Vak;
  private static String cQP;
  private static Application jxU;
  
  public static void a(Application paramApplication, String paramString1, String paramString2)
  {
    boolean bool = true;
    AppMethodBeat.i(40683);
    jxU = paramApplication;
    cQP = paramString1;
    i.a(new p()
    {
      public final void d(p.a paramAnonymousa)
      {
        AppMethodBeat.i(40682);
        Log.i("MicroMsg.SplashInit", "do one more thing");
        n.c(paramAnonymousa);
        n.WK(this.Val);
        n.huy();
        AppMethodBeat.o(40682);
      }
    });
    i.huq().mStartTimestamp = System.currentTimeMillis();
    if (!paramApplication.getPackageName().equals(paramString1)) {
      i.g("MicroMsg.SplashInit", "not main process(%s), no hack, do fallback.", new Object[] { paramString1 });
    }
    for (;;)
    {
      Vah = bool;
      if (i.UZq != null) {
        i.UZq.aby();
      }
      if (bool)
      {
        a.hub();
        a.huc();
      }
      if ((g.acB) || (bool)) {
        buE(paramString2);
      }
      AppMethodBeat.o(40683);
      return;
      if (!i.r(paramApplication))
      {
        i.huq().idkey(675L, 5L, 1L);
        i.kB(paramApplication);
        i.g("MicroMsg.SplashInit", "hack failed, do fallback logic.", new Object[0]);
      }
      else
      {
        bool = false;
        i.hul();
      }
    }
  }
  
  private static void buE(String paramString)
  {
    AppMethodBeat.i(40684);
    if (Vai != null)
    {
      AppMethodBeat.o(40684);
      return;
    }
    paramString = buF(paramString);
    paramString.a(jxU, cQP);
    Vai = paramString;
    AppMethodBeat.o(40684);
  }
  
  private static a buF(String paramString)
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
  
  public static void huy()
  {
    AppMethodBeat.i(40685);
    if ((Vaj) && (Vak != null)) {
      Vai.a(Vak);
    }
    AppMethodBeat.o(40685);
  }
  
  public static void huz()
  {
    AppMethodBeat.i(40686);
    i.g("MicroMsg.SplashInit", "applicationOnCreate", new Object[0]);
    i.huh();
    Vaj = true;
    if (Vah)
    {
      Vai.abz();
      AppMethodBeat.o(40686);
      return;
    }
    huy();
    AppMethodBeat.o(40686);
  }
  
  public static abstract interface a
  {
    public abstract void a(Application paramApplication, String paramString);
    
    public abstract void a(p.a parama);
    
    public abstract void abz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.splash.n
 * JD-Core Version:    0.7.0.1
 */