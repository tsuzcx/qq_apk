package com.tencent.mm.wear.app.b;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.e.a.l;
import com.tencent.mm.e.a.m;
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
  private e aet;
  private c aeu;
  
  private boolean mC()
  {
    Object localObject1 = new com.tencent.mm.wear.app.a.g();
    ((com.tencent.mm.wear.app.a.g)localObject1).aep = 10001;
    ((com.tencent.mm.wear.app.a.g)localObject1).data = h.mA().getBytes();
    localObject1 = this.aet.a((com.tencent.mm.wear.app.a.g)localObject1);
    if ((((com.tencent.mm.wear.app.a.h)localObject1).adX != 0) || (((com.tencent.mm.wear.app.a.h)localObject1).data == null))
    {
      com.tencent.mm.wear.a.c.d.a("MicroMsg.InitCoreTask", "auth error %s", new Object[] { ((com.tencent.mm.wear.app.a.h)localObject1).toString() });
      com.tencent.mm.wear.a.b.a.amv.post(new b(this, 10001, 131072));
      return false;
    }
    byte[] arrayOfByte = com.tencent.mm.c.b.a.a.lj();
    localObject1 = ((com.tencent.mm.wear.app.a.h)localObject1).data;
    com.tencent.mm.wear.a.c.d.c("MicroMsg.InitCoreTask", "auth randomKey=%s publicKey=%s localNodeId=%s", new Object[] { com.tencent.mm.a.d.g(arrayOfByte), com.tencent.mm.a.d.g((byte[])localObject1), h.mO().mF().mA() });
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
        com.tencent.mm.wear.a.b.a.amv.post(new b(this, 10001, 65536));
        return false;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        com.tencent.mm.wear.a.c.d.a("MicroMsg.InitCoreTask", localException1);
        localObject2 = null;
      }
      Object localObject3 = new com.tencent.mm.wear.app.a.g();
      ((com.tencent.mm.wear.app.a.g)localObject3).aep = 10002;
      ((com.tencent.mm.wear.app.a.g)localObject3).data = localObject2;
      localObject3 = this.aet.a((com.tencent.mm.wear.app.a.g)localObject3);
      if ((((com.tencent.mm.wear.app.a.h)localObject3).adX != 0) || (((com.tencent.mm.wear.app.a.h)localObject3).data == null))
      {
        com.tencent.mm.wear.a.c.d.a("MicroMsg.InitCoreTask", "auth error %s", new Object[] { ((com.tencent.mm.wear.app.a.h)localObject3).toString() });
        com.tencent.mm.wear.a.b.a.amv.post(new b(this, 10002, 131072));
        return false;
      }
      localObject2 = null;
      try
      {
        arrayOfByte = com.tencent.mm.c.b.a.a.a(((com.tencent.mm.wear.app.a.h)localObject3).data, arrayOfByte);
        localObject2 = arrayOfByte;
        com.tencent.mm.wear.a.c.d.c("MicroMsg.InitCoreTask", "auth sessionKey=%s", new Object[] { com.tencent.mm.a.d.g(arrayOfByte) });
        localObject2 = arrayOfByte;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          com.tencent.mm.wear.a.c.d.a("MicroMsg.InitCoreTask", localException2);
        }
        h.mO().j(localObject2);
      }
      if (localObject2 == null)
      {
        com.tencent.mm.wear.a.b.a.amv.post(new b(this, 10002, 65536));
        return false;
      }
    }
    return true;
  }
  
  private boolean mD()
  {
    l locall = new l();
    locall.Xw = h.mA();
    locall.Xx = Build.MODEL;
    locall.Xy = Build.VERSION.RELEASE;
    locall.Xz = Build.SERIAL;
    locall.XA = Build.ID;
    locall.XC = com.tencent.mm.wear.a.a.ov();
    locall.XD = MMActivity.nN();
    locall.XE = com.tencent.mm.wear.a.a.a.ox();
    locall.XF = Build.VERSION.SDK_INT;
    Object localObject = new com.tencent.mm.wear.app.a.g();
    ((com.tencent.mm.wear.app.a.g)localObject).aep = 11002;
    try
    {
      ((com.tencent.mm.wear.app.a.g)localObject).data = h.mO().k(locall.toByteArray());
      if (((com.tencent.mm.wear.app.a.g)localObject).data == null)
      {
        com.tencent.mm.wear.a.b.a.amv.post(new b(this, 11002, 65536));
        return false;
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        com.tencent.mm.wear.a.c.d.a("MicroMsg.InitCoreTask", localIOException2);
      }
      localObject = this.aet.a((com.tencent.mm.wear.app.a.g)localObject);
      if ((((com.tencent.mm.wear.app.a.h)localObject).adX == 0) && (((com.tencent.mm.wear.app.a.h)localObject).data != null))
      {
        localObject = h.mO().l(((com.tencent.mm.wear.app.a.h)localObject).data);
        if (localObject == null)
        {
          com.tencent.mm.wear.a.c.d.a("MicroMsg.InitCoreTask", "decryptData = null", new Object[0]);
          com.tencent.mm.wear.a.b.a.amv.post(new b(this, 11002, 65536));
          return false;
        }
        m localm = new m();
        try
        {
          localm.h((byte[])localObject);
          com.tencent.mm.wear.a.c.d.c("MicroMsg.InitCoreTask", "login success %s %s", new Object[] { localm.Xh, localm.XG });
          h.mO().a(localm);
          return true;
        }
        catch (IOException localIOException1)
        {
          com.tencent.mm.wear.a.c.d.a("MicroMsg.InitCoreTask", localIOException1);
          com.tencent.mm.wear.a.b.a.amv.post(new b(this, 11002, 65536));
          return false;
        }
      }
      com.tencent.mm.wear.a.b.a.amv.post(new b(this, 11002, 131072));
    }
    return false;
  }
  
  public final void a(c paramc)
  {
    this.aeu = paramc;
  }
  
  protected final void execute()
  {
    this.aet = new e(h.mO().mF());
    boolean bool2 = mC();
    if (bool2) {}
    for (boolean bool1 = mD();; bool1 = false)
    {
      if ((bool2) && (bool1)) {
        com.tencent.mm.wear.a.b.a.amv.post(new b(this, 11000, 0));
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