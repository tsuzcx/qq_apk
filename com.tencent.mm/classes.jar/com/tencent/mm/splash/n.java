package com.tencent.mm.splash;

import android.app.Application;
import com.tencent.mm.sdk.platformtools.y;

public final class n
{
  private static String bnX;
  private static Application ulG;
  private static boolean umC = false;
  private static a umD;
  private static boolean umE = false;
  private static p.a umF;
  
  public static void a(Application paramApplication, String paramString1, String paramString2)
  {
    boolean bool1 = true;
    ulG = paramApplication;
    bnX = paramString1;
    i.a(new p()
    {
      public final void d(p.a paramAnonymousa)
      {
        y.i("MicroMsg.SplashInit", "do one more thing");
        n.c(paramAnonymousa);
        n.mG(this.umG);
        n.tf();
      }
    });
    i.cte().mStartTimestamp = System.currentTimeMillis();
    if (!paramApplication.getPackageName().equals(paramString1)) {
      i.c("MicroMsg.SplashInit", "not main process(%s), no hack, do fallback.", new Object[] { paramString1 });
    }
    for (;;)
    {
      umC = bool1;
      if (i.ulK != null) {
        i.ulK.th();
      }
      if ((!bool1) || (a.gc(paramApplication))) {}
      try
      {
        a.ge(paramApplication);
        boolean bool2 = a.gg(paramApplication);
        i.c("MicroMsg.SplashInit", "block checking dex opt result: %s", new Object[] { Boolean.valueOf(bool2) });
        if (!bool2)
        {
          i.c("MicroMsg.SplashInit", "dexopt service return failed or timeout. kill self.", new Object[0]);
          i.csY();
        }
        a.gd(paramApplication);
        if ((g.pg) || (bool1)) {
          aaz(paramString2);
        }
        return;
      }
      catch (InterruptedException paramApplication)
      {
        throw new RuntimeException(paramApplication);
      }
      if (!i.f(paramApplication))
      {
        i.cte().j(675L, 5L, 1L);
        i.gi(paramApplication);
        i.c("MicroMsg.SplashInit", "hack failed, do fallback logic.", new Object[0]);
      }
      else
      {
        bool1 = false;
        i.csZ();
      }
    }
  }
  
  private static a aaA(String paramString)
  {
    try
    {
      a locala = (a)Class.forName(paramString).newInstance();
      return locala;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.SplashInit", localException, "%s has problem!", new Object[] { paramString });
      throw new RuntimeException(localException);
    }
  }
  
  private static void aaz(String paramString)
  {
    if (umD != null) {
      return;
    }
    paramString = aaA(paramString);
    paramString.b(ulG, bnX);
    umD = paramString;
  }
  
  private static void ctn()
  {
    if ((umE) && (umF != null)) {
      umD.a(umF);
    }
  }
  
  public static void cto()
  {
    i.c("MicroMsg.SplashInit", "applicationOnCreate", new Object[0]);
    i.csU();
    umE = true;
    if (umC)
    {
      umD.ti();
      return;
    }
    ctn();
  }
  
  public static abstract interface a
  {
    public abstract void a(p.a parama);
    
    public abstract void b(Application paramApplication, String paramString);
    
    public abstract void ti();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.n
 * JD-Core Version:    0.7.0.1
 */