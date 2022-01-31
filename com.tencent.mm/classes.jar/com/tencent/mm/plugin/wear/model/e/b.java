package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import java.io.File;
import java.security.Key;
import java.security.KeyFactory;
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
  private byte[] sessionKey;
  private byte[] uHF;
  private byte[] uHG;
  
  private void cYN()
  {
    AppMethodBeat.i(26386);
    File localFile3 = new File(com.tencent.mm.compatible.util.e.eQw, "wear/key");
    if (!localFile3.exists()) {
      localFile3.mkdirs();
    }
    File localFile1 = new File(localFile3, "private.key");
    File localFile2 = new File(localFile3, "public.key");
    localFile3 = new File(localFile3, "session.key");
    if ((!localFile1.exists()) || (!localFile2.exists()) || (!localFile3.exists()))
    {
      ab.i("MicroMsg.Wear.HttpAuthServer", "recreate keys");
      localFile1.delete();
      localFile2.delete();
      localFile3.delete();
      HashMap localHashMap = com.tencent.mm.plugin.wear.a.a.cYP();
      RSAPrivateKey localRSAPrivateKey = (RSAPrivateKey)localHashMap.get("RSAPrivateKey");
      this.uHG = ((RSAPublicKey)localHashMap.get("RSAPublicKey")).getEncoded();
      this.uHF = localRSAPrivateKey.getEncoded();
      this.sessionKey = com.tencent.mm.plugin.wear.a.a.cYQ();
      com.tencent.mm.a.e.b(localFile1.getAbsolutePath(), this.uHF, this.uHF.length);
      com.tencent.mm.a.e.b(localFile2.getAbsolutePath(), this.uHG, this.uHG.length);
      com.tencent.mm.a.e.b(localFile3.getAbsolutePath(), this.sessionKey, this.sessionKey.length);
    }
    for (;;)
    {
      ab.i("MicroMsg.Wear.HttpAuthServer", "publicKey=%s privateKey=%s sessionKey=%s", new Object[] { ag.v(this.uHG), ag.v(this.uHF), ag.v(this.sessionKey) });
      AppMethodBeat.o(26386);
      return;
      ab.i("MicroMsg.Wear.HttpAuthServer", "use old keys");
      this.uHG = com.tencent.mm.a.e.j(localFile2.getAbsolutePath(), 0, 2147483647);
      this.uHF = com.tencent.mm.a.e.j(localFile1.getAbsolutePath(), 0, 2147483647);
      this.sessionKey = com.tencent.mm.a.e.j(localFile3.getAbsolutePath(), 0, 2147483647);
    }
  }
  
  public final List<Integer> cYL()
  {
    AppMethodBeat.i(26387);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(10001));
    localArrayList.add(Integer.valueOf(10002));
    AppMethodBeat.o(26387);
    return localArrayList;
  }
  
  public final byte[] getSessionKey()
  {
    boolean bool3 = true;
    AppMethodBeat.i(26385);
    if ((this.uHG == null) || (this.uHF == null) || (this.sessionKey == null)) {
      ab.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
    }
    try
    {
      cYN();
      if (this.uHG != null)
      {
        bool1 = true;
        if (this.uHF == null) {
          break label135;
        }
        bool2 = true;
        if (this.sessionKey == null) {
          break label140;
        }
        ab.i("MicroMsg.Wear.HttpAuthServer", "publicKey %s privateKey %s sessionKey %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        byte[] arrayOfByte = this.sessionKey;
        AppMethodBeat.o(26385);
        return arrayOfByte;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", localException, "loadAllKey", new Object[0]);
        continue;
        boolean bool1 = false;
        continue;
        label135:
        boolean bool2 = false;
        continue;
        label140:
        bool3 = false;
      }
    }
  }
  
  protected final byte[] q(int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool3 = true;
    AppMethodBeat.i(26388);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(26388);
      return null;
      ab.i("MicroMsg.Wear.HttpAuthServer", "request public key");
      if ((this.uHG == null) || (this.uHF == null) || (this.sessionKey == null)) {
        ab.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
      }
      try
      {
        cYN();
        if (this.uHG != null)
        {
          bool1 = true;
          if (this.uHF == null) {
            break label173;
          }
          bool2 = true;
          if (this.sessionKey == null) {
            break label179;
          }
          ab.i("MicroMsg.Wear.HttpAuthServer", "publicKey %s privateKey %s sessionKey %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          paramArrayOfByte = this.uHG;
          AppMethodBeat.o(26388);
          return paramArrayOfByte;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", paramArrayOfByte, "loadAllKey", new Object[0]);
          continue;
          boolean bool1 = false;
          continue;
          label173:
          boolean bool2 = false;
          continue;
          label179:
          bool3 = false;
        }
      }
      try
      {
        Object localObject2 = new PKCS8EncodedKeySpec(this.uHF);
        Object localObject1 = KeyFactory.getInstance("RSA");
        localObject2 = ((KeyFactory)localObject1).generatePrivate((KeySpec)localObject2);
        localObject1 = Cipher.getInstance(((KeyFactory)localObject1).getAlgorithm());
        ((Cipher)localObject1).init(2, (Key)localObject2);
        paramArrayOfByte = ((Cipher)localObject1).doFinal(paramArrayOfByte);
        localObject1 = com.tencent.mm.plugin.wear.a.a.i(this.sessionKey, paramArrayOfByte);
        ab.i("MicroMsg.Wear.HttpAuthServer", "funid %d, randomKey=%s", new Object[] { Integer.valueOf(paramInt), ag.v(paramArrayOfByte) });
        AppMethodBeat.o(26388);
        return localObject1;
      }
      catch (Exception paramArrayOfByte)
      {
        ab.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", paramArrayOfByte, "sessionKey resp error", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.b
 * JD-Core Version:    0.7.0.1
 */