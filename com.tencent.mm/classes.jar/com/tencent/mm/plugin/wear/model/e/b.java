package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.Cipher;

public final class b
  extends a
{
  private byte[] aYR;
  private byte[] qSy;
  private byte[] qSz;
  
  private void bZa()
  {
    File localFile3 = new File(com.tencent.mm.compatible.util.e.dOQ, "wear/key");
    if (!localFile3.exists()) {
      localFile3.mkdirs();
    }
    File localFile1 = new File(localFile3, "private.key");
    File localFile2 = new File(localFile3, "public.key");
    localFile3 = new File(localFile3, "session.key");
    if ((!localFile1.exists()) || (!localFile2.exists()) || (!localFile3.exists()))
    {
      y.i("MicroMsg.Wear.HttpAuthServer", "recreate keys");
      localFile1.delete();
      localFile2.delete();
      localFile3.delete();
      Object localObject1 = KeyPairGenerator.getInstance("RSA");
      ((KeyPairGenerator)localObject1).initialize(1024);
      Object localObject2 = ((KeyPairGenerator)localObject1).generateKeyPair();
      localObject1 = (RSAPublicKey)((KeyPair)localObject2).getPublic();
      RSAPrivateKey localRSAPrivateKey = (RSAPrivateKey)((KeyPair)localObject2).getPrivate();
      localObject2 = new HashMap(2);
      ((HashMap)localObject2).put("RSAPublicKey", localObject1);
      ((HashMap)localObject2).put("RSAPrivateKey", localRSAPrivateKey);
      localObject1 = (RSAPrivateKey)((HashMap)localObject2).get("RSAPrivateKey");
      this.qSz = ((RSAPublicKey)((HashMap)localObject2).get("RSAPublicKey")).getEncoded();
      this.qSy = ((RSAPrivateKey)localObject1).getEncoded();
      this.aYR = com.tencent.mm.plugin.wear.a.a.bZc();
      com.tencent.mm.a.e.b(localFile1.getAbsolutePath(), this.qSy, this.qSy.length);
      com.tencent.mm.a.e.b(localFile2.getAbsolutePath(), this.qSz, this.qSz.length);
      com.tencent.mm.a.e.b(localFile3.getAbsolutePath(), this.aYR, this.aYR.length);
    }
    for (;;)
    {
      y.i("MicroMsg.Wear.HttpAuthServer", "publicKey=%s privateKey=%s sessionKey=%s", new Object[] { ad.n(this.qSz), ad.n(this.qSy), ad.n(this.aYR) });
      return;
      y.i("MicroMsg.Wear.HttpAuthServer", "use old keys");
      this.qSz = com.tencent.mm.a.e.d(localFile2.getAbsolutePath(), 0, 2147483647);
      this.qSy = com.tencent.mm.a.e.d(localFile1.getAbsolutePath(), 0, 2147483647);
      this.aYR = com.tencent.mm.a.e.d(localFile3.getAbsolutePath(), 0, 2147483647);
    }
  }
  
  public final byte[] Dj()
  {
    boolean bool3 = true;
    if ((this.qSz == null) || (this.qSy == null) || (this.aYR == null)) {
      y.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
    }
    try
    {
      bZa();
      if (this.qSz != null)
      {
        bool1 = true;
        if (this.qSy == null) {
          break label119;
        }
        bool2 = true;
        if (this.aYR == null) {
          break label124;
        }
        y.i("MicroMsg.Wear.HttpAuthServer", "publicKey %s privateKey %s sessionKey %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        return this.aYR;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", localException, "loadAllKey", new Object[0]);
        continue;
        boolean bool1 = false;
        continue;
        label119:
        boolean bool2 = false;
        continue;
        label124:
        bool3 = false;
      }
    }
  }
  
  public final List<Integer> bYY()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(10001));
    localArrayList.add(Integer.valueOf(10002));
    return localArrayList;
  }
  
  protected final byte[] p(int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool3 = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return null;
      y.i("MicroMsg.Wear.HttpAuthServer", "request public key");
      if ((this.qSz == null) || (this.qSy == null) || (this.aYR == null)) {
        y.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
      }
      try
      {
        bZa();
        if (this.qSz != null)
        {
          bool1 = true;
          if (this.qSy == null) {
            break label155;
          }
          bool2 = true;
          if (this.aYR == null) {
            break label161;
          }
          y.i("MicroMsg.Wear.HttpAuthServer", "publicKey %s privateKey %s sessionKey %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          return this.qSz;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", paramArrayOfByte, "loadAllKey", new Object[0]);
          continue;
          boolean bool1 = false;
          continue;
          label155:
          boolean bool2 = false;
          continue;
          label161:
          bool3 = false;
        }
      }
      try
      {
        Object localObject2 = new PKCS8EncodedKeySpec(this.qSy);
        Object localObject1 = KeyFactory.getInstance("RSA");
        localObject2 = ((KeyFactory)localObject1).generatePrivate((KeySpec)localObject2);
        localObject1 = Cipher.getInstance(((KeyFactory)localObject1).getAlgorithm());
        ((Cipher)localObject1).init(2, (Key)localObject2);
        paramArrayOfByte = ((Cipher)localObject1).doFinal(paramArrayOfByte);
        localObject1 = com.tencent.mm.plugin.wear.a.a.f(this.aYR, paramArrayOfByte);
        y.i("MicroMsg.Wear.HttpAuthServer", "funid %d, randomKey=%s", new Object[] { Integer.valueOf(paramInt), ad.n(paramArrayOfByte) });
        return localObject1;
      }
      catch (Exception paramArrayOfByte)
      {
        y.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", paramArrayOfByte, "sessionKey resp error", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.b
 * JD-Core Version:    0.7.0.1
 */