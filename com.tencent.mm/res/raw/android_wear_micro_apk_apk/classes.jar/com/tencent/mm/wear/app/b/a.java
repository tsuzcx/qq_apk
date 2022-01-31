package com.tencent.mm.wear.app.b;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.e.a.l;
import com.tencent.mm.e.a.m;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.a.e;
import com.tencent.mm.wear.app.ui.MMActivity;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class a
  extends com.tencent.mm.wear.app.g.a
{
  private e aaS;
  private c aaT;
  
  private boolean lP()
  {
    Object localObject1 = new com.tencent.mm.wear.app.a.g();
    ((com.tencent.mm.wear.app.a.g)localObject1).aaO = 10001;
    ((com.tencent.mm.wear.app.a.g)localObject1).data = h.lN().getBytes();
    localObject1 = this.aaS.a((com.tencent.mm.wear.app.a.g)localObject1);
    if ((((com.tencent.mm.wear.app.a.h)localObject1).aaw != 0) || (((com.tencent.mm.wear.app.a.h)localObject1).data == null))
    {
      d.a("MicroMsg.InitCoreTask", "auth error %s", new Object[] { ((com.tencent.mm.wear.app.a.h)localObject1).toString() });
      com.tencent.mm.wear.a.b.a.aiT.post(new b(this, 10001, 131072));
      return false;
    }
    byte[] arrayOfByte = com.tencent.mm.c.a.a.a.kZ();
    localObject1 = ((com.tencent.mm.wear.app.a.h)localObject1).data;
    d.c("MicroMsg.InitCoreTask", "auth randomKey=%s publicKey=%s localNodeId=%s", new Object[] { com.tencent.mm.a.c.g(arrayOfByte), com.tencent.mm.a.c.g((byte[])localObject1), h.mb().lS().lN() });
    Object localObject2;
    try
    {
      localObject3 = new X509EncodedKeySpec((byte[])localObject1);
      localObject1 = KeyFactory.getInstance("RSA");
      localObject3 = ((KeyFactory)localObject1).generatePublic((KeySpec)localObject3);
      localObject1 = Cipher.getInstance(((KeyFactory)localObject1).getAlgorithm());
      ((Cipher)localObject1).init(1, (Key)localObject3);
      localObject1 = ((Cipher)localObject1).doFinal(arrayOfByte);
      if (localObject1 == null)
      {
        com.tencent.mm.wear.a.b.a.aiT.post(new b(this, 10001, 65536));
        return false;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        d.a("MicroMsg.InitCoreTask", localException1);
        localObject2 = null;
      }
      Object localObject3 = new com.tencent.mm.wear.app.a.g();
      ((com.tencent.mm.wear.app.a.g)localObject3).aaO = 10002;
      ((com.tencent.mm.wear.app.a.g)localObject3).data = localObject2;
      localObject3 = this.aaS.a((com.tencent.mm.wear.app.a.g)localObject3);
      if ((((com.tencent.mm.wear.app.a.h)localObject3).aaw != 0) || (((com.tencent.mm.wear.app.a.h)localObject3).data == null))
      {
        d.a("MicroMsg.InitCoreTask", "auth error %s", new Object[] { ((com.tencent.mm.wear.app.a.h)localObject3).toString() });
        com.tencent.mm.wear.a.b.a.aiT.post(new b(this, 10002, 131072));
        return false;
      }
      localObject2 = null;
      try
      {
        arrayOfByte = com.tencent.mm.c.a.a.a.a(((com.tencent.mm.wear.app.a.h)localObject3).data, arrayOfByte);
        localObject2 = arrayOfByte;
        d.c("MicroMsg.InitCoreTask", "auth sessionKey=%s", new Object[] { com.tencent.mm.a.c.g(arrayOfByte) });
        localObject2 = arrayOfByte;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          d.a("MicroMsg.InitCoreTask", localException2);
        }
        h.mb().j(localObject2);
      }
      if (localObject2 == null)
      {
        com.tencent.mm.wear.a.b.a.aiT.post(new b(this, 10002, 65536));
        return false;
      }
    }
    return true;
  }
  
  private boolean lQ()
  {
    l locall = new l();
    locall.VB = h.lN();
    locall.VC = Build.MODEL;
    locall.VD = Build.VERSION.RELEASE;
    locall.VE = Build.SERIAL;
    locall.VF = Build.ID;
    locall.VH = com.tencent.mm.wear.a.a.nH();
    locall.VI = MMActivity.na();
    locall.VJ = com.tencent.mm.wear.a.a.a.nJ();
    locall.VK = Build.VERSION.SDK_INT;
    Object localObject = new com.tencent.mm.wear.app.a.g();
    ((com.tencent.mm.wear.app.a.g)localObject).aaO = 11002;
    try
    {
      ((com.tencent.mm.wear.app.a.g)localObject).data = h.mb().k(locall.toByteArray());
      if (((com.tencent.mm.wear.app.a.g)localObject).data == null)
      {
        com.tencent.mm.wear.a.b.a.aiT.post(new b(this, 11002, 65536));
        return false;
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        d.a("MicroMsg.InitCoreTask", localIOException2);
      }
      localObject = this.aaS.a((com.tencent.mm.wear.app.a.g)localObject);
      if ((((com.tencent.mm.wear.app.a.h)localObject).aaw == 0) && (((com.tencent.mm.wear.app.a.h)localObject).data != null))
      {
        localObject = h.mb().l(((com.tencent.mm.wear.app.a.h)localObject).data);
        if (localObject == null)
        {
          d.a("MicroMsg.InitCoreTask", "decryptData = null", new Object[0]);
          com.tencent.mm.wear.a.b.a.aiT.post(new b(this, 11002, 65536));
          return false;
        }
        m localm = new m();
        try
        {
          localm.h((byte[])localObject);
          d.c("MicroMsg.InitCoreTask", "login success %s %s", new Object[] { localm.Vm, localm.VL });
          h.mb().a(localm);
          return true;
        }
        catch (IOException localIOException1)
        {
          d.a("MicroMsg.InitCoreTask", localIOException1);
          com.tencent.mm.wear.a.b.a.aiT.post(new b(this, 11002, 65536));
          return false;
        }
      }
      com.tencent.mm.wear.a.b.a.aiT.post(new b(this, 11002, 131072));
    }
    return false;
  }
  
  public final void a(c paramc)
  {
    this.aaT = paramc;
  }
  
  protected final void execute()
  {
    this.aaS = new e(h.mb().lS());
    boolean bool2 = lP();
    if (bool2) {}
    for (boolean bool1 = lQ();; bool1 = false)
    {
      if ((bool2) && (bool1)) {
        com.tencent.mm.wear.a.b.a.aiT.post(new b(this, 11000, 0));
      }
      return;
    }
  }
  
  protected final String getName()
  {
    return "InitCoreTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.b.a
 * JD-Core Version:    0.7.0.1
 */