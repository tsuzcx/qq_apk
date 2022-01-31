package com.tencent.mm.wear.app.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.service.StepCountService;
import com.tencent.mm.wear.app.ui.MMActivity;
import java.io.File;
import junit.framework.Assert;

public final class h
{
  public static h abb;
  private static Intent abj;
  private static boolean abk = false;
  private static boolean abl = false;
  private static boolean abm = false;
  private static boolean abn;
  private g abc = new g();
  private com.tencent.mm.wear.app.g.b abd = new com.tencent.mm.wear.app.g.b();
  private com.tencent.mm.wear.app.emoji.gif.a abe = new com.tencent.mm.wear.app.emoji.gif.a();
  private j abf = new j();
  private com.tencent.mm.wear.app.c.b abg = new com.tencent.mm.wear.app.c.b(MMApplication.getContext());
  private com.tencent.mm.wear.a.d.a abh = new com.tencent.mm.wear.a.d.a();
  private String abi;
  
  public h()
  {
    System.loadLibrary("gif");
  }
  
  public static void B(boolean paramBoolean)
  {
    if (paramBoolean) {
      abk = false;
    }
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "startLogin isLogin=%b force=%b", new Object[] { Boolean.valueOf(abk), Boolean.valueOf(paramBoolean) });
    if (abl)
    {
      com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "already running login", new Object[0]);
      return;
    }
    abl = true;
    a locala = new a();
    locala.a(new c()
    {
      public final void bH(int paramAnonymousInt)
      {
        if (paramAnonymousInt == 0) {
          h.C(true);
        }
        for (;;)
        {
          h.mt();
          com.tencent.mm.sdk.a.a.WJ.a(new com.tencent.mm.b.a.c());
          return;
          h.C(false);
        }
      }
    });
    lX().abd.a(locala);
  }
  
  public static String lN()
  {
    return lX().abi;
  }
  
  public static h lX()
  {
    Assert.assertNotNull("MMCore not initialized by MMApplication", abb);
    return abb;
  }
  
  public static void lY()
  {
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "init crash handler", new Object[0]);
    Thread.setDefaultUncaughtExceptionHandler(com.tencent.mm.wear.a.e.a.nM());
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "init MMCore", new Object[0]);
    abb = new h();
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "%s", new Object[] { com.tencent.mm.wear.a.a.nH() });
    File localFile = new File(com.tencent.mm.wear.a.c.aiQ, "so");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(com.tencent.mm.wear.a.c.aiQ, "emoji");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(com.tencent.mm.wear.a.c.aiR, "crash");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(com.tencent.mm.wear.a.c.aiR, "voice");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(com.tencent.mm.wear.a.c.aiR, "log");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(com.tencent.mm.wear.a.c.aiR, "emoji");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(com.tencent.mm.wear.a.c.aiR, "avatar");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    com.tencent.mm.wear.a.c.d.b(new com.tencent.mm.wear.a.c.c());
    MMActivity.z(MMApplication.getContext());
    MMApplication.getContext();
    MMActivity.mZ();
    lX().abf.a(new com.tencent.mm.wear.app.d.b.c());
    lX().abf.a(new com.tencent.mm.wear.app.d.b.b());
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "cpuId %s", new Object[] { com.tencent.mm.wear.a.a.a.nJ() });
    lX().abd.a(new i((byte)0));
    B(false);
    mr();
    abj = new Intent(MMApplication.getContext(), StepCountService.class);
    MMApplication.getContext().startService(abj);
  }
  
  public static void lZ()
  {
    lX();
    lX().abd.finish();
    lX().abf.finish();
    lX();
    lX().abe.stop();
    lX().abh.finish();
    MMApplication.getContext().stopService(abj);
  }
  
  public static void logout()
  {
    abk = false;
  }
  
  public static com.tencent.mm.wear.a.d.a ma()
  {
    return lX().abh;
  }
  
  public static g mb()
  {
    return lX().abc;
  }
  
  public static com.tencent.mm.wear.app.g.b mc()
  {
    return lX().abd;
  }
  
  public static j md()
  {
    return lX().abf;
  }
  
  public static com.tencent.mm.wear.app.c.b me()
  {
    return lX().abg;
  }
  
  public static com.tencent.mm.wear.app.emoji.gif.a mf()
  {
    return lX().abe;
  }
  
  public static final File mg()
  {
    return new File(com.tencent.mm.wear.a.c.aiQ, "so");
  }
  
  public static final File mh()
  {
    return new File(com.tencent.mm.wear.a.c.aiQ, "emoji");
  }
  
  public static final File mi()
  {
    return new File(com.tencent.mm.wear.a.c.aiR, "voice");
  }
  
  public static final File mj()
  {
    return new File(com.tencent.mm.wear.a.c.aiR, "crash");
  }
  
  public static final File mk()
  {
    return new File(com.tencent.mm.wear.a.c.aiR, "log");
  }
  
  public static final File ml()
  {
    return new File(com.tencent.mm.wear.a.c.aiR, "emoji");
  }
  
  public static final File mm()
  {
    return new File(com.tencent.mm.wear.a.c.aiR, "image");
  }
  
  public static final File mn()
  {
    return new File(com.tencent.mm.wear.a.c.aiR, "avatar");
  }
  
  public static boolean mo()
  {
    return abk;
  }
  
  public static boolean mp()
  {
    return abl;
  }
  
  public static boolean mq()
  {
    return abm;
  }
  
  public static void mr()
  {
    if (abn)
    {
      com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "already running resource", new Object[0]);
      return;
    }
    abn = true;
    int i;
    if (MMActivity.ne()) {
      if ((!com.tencent.mm.wear.a.f.d.T("stlport_shared")) || (!com.tencent.mm.wear.a.f.d.T("wechatvoicesilk")) || (!com.tencent.mm.wear.app.emoji.a.mx())) {
        i = 1;
      }
    }
    while (i != 0)
    {
      d locald = new d();
      locald.a(new f()
      {
        public final void af(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          if (paramAnonymousInt2 == 0) {
            switch (paramAnonymousInt1)
            {
            default: 
              if (paramAnonymousInt1 == 11001)
              {
                com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "init resource success", new Object[0]);
                h.mu();
                h.D(true);
                com.tencent.mm.sdk.a.a.WJ.a(new com.tencent.mm.b.a.a());
              }
              break;
            }
          }
          while (paramAnonymousInt1 != 11001) {
            for (;;)
            {
              return;
              com.tencent.mm.wear.a.f.d.U("stlport_shared");
              continue;
              com.tencent.mm.wear.a.f.d.U("wechatvoicesilk");
              continue;
              com.tencent.mm.wear.app.emoji.a.mx();
            }
          }
          com.tencent.mm.wear.a.c.d.c("MicroMsg.MMCore", "init resource fail", new Object[0]);
          h.mu();
          h.D(false);
          com.tencent.mm.sdk.a.a.WJ.a(new com.tencent.mm.b.a.a());
        }
      });
      lX().abd.a(locald);
      return;
      i = 0;
      continue;
      if (!com.tencent.mm.wear.app.emoji.a.mx()) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if (MMActivity.ne())
    {
      com.tencent.mm.wear.a.f.d.U("stlport_shared");
      com.tencent.mm.wear.a.f.d.U("wechatvoicesilk");
    }
    abm = true;
    abn = false;
    com.tencent.mm.sdk.a.a.WJ.a(new com.tencent.mm.b.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.b.h
 * JD-Core Version:    0.7.0.1
 */