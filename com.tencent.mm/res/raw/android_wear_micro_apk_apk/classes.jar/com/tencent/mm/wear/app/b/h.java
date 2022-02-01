package com.tencent.mm.wear.app.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.service.StepCountService;
import com.tencent.mm.wear.app.ui.MMActivity;
import java.io.File;

public final class h
{
  public static h aeC;
  private static Intent aeK;
  private static boolean aeL = false;
  private static boolean aeM = false;
  private static boolean aeN = false;
  private static boolean aeO;
  private g aeD = new g();
  private com.tencent.mm.wear.app.g.b aeE = new com.tencent.mm.wear.app.g.b();
  private com.tencent.mm.wear.app.emoji.gif.a aeF = new com.tencent.mm.wear.app.emoji.gif.a();
  private j aeG = new j();
  private com.tencent.mm.wear.app.c.b aeH = new com.tencent.mm.wear.app.c.b(MMApplication.getContext());
  private com.tencent.mm.wear.a.d.a aeI = new com.tencent.mm.wear.a.d.a();
  private String aeJ;
  
  public h()
  {
    System.loadLibrary("gif");
  }
  
  public static void E(boolean paramBoolean)
  {
    if (paramBoolean) {
      aeL = false;
    }
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "startLogin isLogin=%b force=%b", new Object[] { Boolean.valueOf(aeL), Boolean.valueOf(paramBoolean) });
    if (aeM)
    {
      com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "already running login", new Object[0]);
      return;
    }
    aeM = true;
    a locala = new a();
    locala.a(new c()
    {
      public final void cd(int paramAnonymousInt)
      {
        if (paramAnonymousInt == 0) {
          h.F(true);
        }
        for (;;)
        {
          h.nf();
          com.tencent.mm.sdk.a.a.YM.a(new com.tencent.mm.b.a.c());
          return;
          h.F(false);
        }
      }
    });
    aeC.aeE.a(locala);
  }
  
  public static void logout()
  {
    aeL = false;
  }
  
  public static String mA()
  {
    return aeC.aeJ;
  }
  
  public static h mK()
  {
    return aeC;
  }
  
  public static void mL()
  {
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "init crash handler", new Object[0]);
    Thread.setDefaultUncaughtExceptionHandler(com.tencent.mm.wear.a.e.a.oA());
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "init MMCore", new Object[0]);
    aeC = new h();
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "%s", new Object[] { com.tencent.mm.wear.a.a.ov() });
    File localFile = new File(com.tencent.mm.wear.a.c.ams, "so");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(com.tencent.mm.wear.a.c.ams, "emoji");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(com.tencent.mm.wear.a.c.amt, "crash");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(com.tencent.mm.wear.a.c.amt, "voice");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(com.tencent.mm.wear.a.c.amt, "log");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(com.tencent.mm.wear.a.c.amt, "emoji");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(com.tencent.mm.wear.a.c.amt, "avatar");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    com.tencent.mm.wear.a.c.d.b(new com.tencent.mm.wear.a.c.c());
    MMActivity.A(MMApplication.getContext());
    MMApplication.getContext();
    MMActivity.nM();
    aeC.aeG.a(new com.tencent.mm.wear.app.d.b.c());
    aeC.aeG.a(new com.tencent.mm.wear.app.d.b.b());
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "cpuId %s", new Object[] { com.tencent.mm.wear.a.a.a.ox() });
    aeC.aeE.a(new i((byte)0));
    E(false);
    nd();
    aeK = new Intent(MMApplication.getContext(), StepCountService.class);
    MMApplication.getContext().startService(aeK);
  }
  
  public static void mM()
  {
    aeC.aeE.finish();
    aeC.aeG.finish();
    aeC.aeF.stop();
    aeC.aeI.finish();
    MMApplication.getContext().stopService(aeK);
  }
  
  public static com.tencent.mm.wear.a.d.a mN()
  {
    return aeC.aeI;
  }
  
  public static g mO()
  {
    return aeC.aeD;
  }
  
  public static com.tencent.mm.wear.app.g.b mP()
  {
    return aeC.aeE;
  }
  
  public static j mQ()
  {
    return aeC.aeG;
  }
  
  public static com.tencent.mm.wear.app.c.b mR()
  {
    return aeC.aeH;
  }
  
  public static com.tencent.mm.wear.app.emoji.gif.a mS()
  {
    return aeC.aeF;
  }
  
  public static final File mT()
  {
    return new File(com.tencent.mm.wear.a.c.ams, "emoji");
  }
  
  public static final File mU()
  {
    return new File(com.tencent.mm.wear.a.c.amt, "voice");
  }
  
  public static final File mV()
  {
    return new File(com.tencent.mm.wear.a.c.amt, "crash");
  }
  
  public static final File mW()
  {
    return new File(com.tencent.mm.wear.a.c.amt, "log");
  }
  
  public static final File mX()
  {
    return new File(com.tencent.mm.wear.a.c.amt, "emoji");
  }
  
  public static final File mY()
  {
    return new File(com.tencent.mm.wear.a.c.amt, "image");
  }
  
  public static final File mZ()
  {
    return new File(com.tencent.mm.wear.a.c.amt, "avatar");
  }
  
  public static boolean na()
  {
    return aeL;
  }
  
  public static boolean nb()
  {
    return aeM;
  }
  
  public static boolean nc()
  {
    return aeN;
  }
  
  public static void nd()
  {
    if (aeO)
    {
      com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "already running resource", new Object[0]);
      return;
    }
    aeO = true;
    if (MMActivity.nR())
    {
      System.loadLibrary("stlport_shared");
      System.loadLibrary("wechatvoicesilk");
    }
    if (!com.tencent.mm.wear.app.emoji.a.nj()) {}
    for (int i = 1; i != 0; i = 0)
    {
      d locald = new d();
      locald.a(new f()
      {
        public final void ai(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          if (paramAnonymousInt2 == 0) {
            if (paramAnonymousInt1 == 11001)
            {
              com.tencent.mm.wear.app.emoji.a.nj();
              com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "init resource success", new Object[0]);
              h.ng();
              h.G(true);
              com.tencent.mm.sdk.a.a.YM.a(new com.tencent.mm.b.a.a());
            }
          }
          while (paramAnonymousInt1 != 11001) {
            return;
          }
          com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "init resource fail", new Object[0]);
          h.ng();
          h.G(false);
          com.tencent.mm.sdk.a.a.YM.a(new com.tencent.mm.b.a.a());
        }
      });
      aeC.aeE.a(locald);
      return;
    }
    aeN = true;
    aeO = false;
    com.tencent.mm.sdk.a.a.YM.a(new com.tencent.mm.b.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.b.h
 * JD-Core Version:    0.7.0.1
 */