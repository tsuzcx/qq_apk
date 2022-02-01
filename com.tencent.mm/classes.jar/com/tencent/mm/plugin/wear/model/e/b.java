package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.o;
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
  private byte[] DPc;
  private byte[] DPd;
  private byte[] sessionKey;
  
  private void eOx()
  {
    AppMethodBeat.i(30068);
    File localFile3 = new File(com.tencent.mm.loader.j.b.asc(), "wear/key");
    if (!localFile3.exists()) {
      localFile3.mkdirs();
    }
    File localFile1 = new File(localFile3, "private.key");
    File localFile2 = new File(localFile3, "public.key");
    localFile3 = new File(localFile3, "session.key");
    if ((!localFile1.exists()) || (!localFile2.exists()) || (!localFile3.exists()))
    {
      ae.i("MicroMsg.Wear.HttpAuthServer", "recreate keys");
      localFile1.delete();
      localFile2.delete();
      localFile3.delete();
      HashMap localHashMap = com.tencent.mm.plugin.wear.a.a.eOz();
      RSAPrivateKey localRSAPrivateKey = (RSAPrivateKey)localHashMap.get("RSAPrivateKey");
      this.DPd = ((RSAPublicKey)localHashMap.get("RSAPublicKey")).getEncoded();
      this.DPc = localRSAPrivateKey.getEncoded();
      this.sessionKey = com.tencent.mm.plugin.wear.a.a.eOA();
      o.f(localFile1.getAbsolutePath(), this.DPc, this.DPc.length);
      o.f(localFile2.getAbsolutePath(), this.DPd, this.DPd.length);
      o.f(localFile3.getAbsolutePath(), this.sessionKey, this.sessionKey.length);
    }
    for (;;)
    {
      ae.i("MicroMsg.Wear.HttpAuthServer", "publicKey=%s privateKey=%s sessionKey=%s", new Object[] { aj.B(this.DPd), aj.B(this.DPc), aj.B(this.sessionKey) });
      AppMethodBeat.o(30068);
      return;
      ae.i("MicroMsg.Wear.HttpAuthServer", "use old keys");
      this.DPd = o.bb(localFile2.getAbsolutePath(), 0, 2147483647);
      this.DPc = o.bb(localFile1.getAbsolutePath(), 0, 2147483647);
      this.sessionKey = o.bb(localFile3.getAbsolutePath(), 0, 2147483647);
    }
  }
  
  public final List<Integer> eOv()
  {
    AppMethodBeat.i(30069);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(10001));
    localArrayList.add(Integer.valueOf(10002));
    AppMethodBeat.o(30069);
    return localArrayList;
  }
  
  public final byte[] getSessionKey()
  {
    boolean bool3 = true;
    AppMethodBeat.i(30067);
    if ((this.DPd == null) || (this.DPc == null) || (this.sessionKey == null)) {
      ae.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
    }
    try
    {
      eOx();
      if (this.DPd != null)
      {
        bool1 = true;
        if (this.DPc == null) {
          break label135;
        }
        bool2 = true;
        if (this.sessionKey == null) {
          break label140;
        }
        ae.i("MicroMsg.Wear.HttpAuthServer", "publicKey %s privateKey %s sessionKey %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        byte[] arrayOfByte = this.sessionKey;
        AppMethodBeat.o(30067);
        return arrayOfByte;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", localException, "loadAllKey", new Object[0]);
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
  
  protected final byte[] s(int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool3 = true;
    AppMethodBeat.i(30070);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30070);
      return null;
      ae.i("MicroMsg.Wear.HttpAuthServer", "request public key");
      if ((this.DPd == null) || (this.DPc == null) || (this.sessionKey == null)) {
        ae.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
      }
      try
      {
        eOx();
        if (this.DPd != null)
        {
          bool1 = true;
          if (this.DPc == null) {
            break label173;
          }
          bool2 = true;
          if (this.sessionKey == null) {
            break label179;
          }
          ae.i("MicroMsg.Wear.HttpAuthServer", "publicKey %s privateKey %s sessionKey %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          paramArrayOfByte = this.DPd;
          AppMethodBeat.o(30070);
          return paramArrayOfByte;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", paramArrayOfByte, "loadAllKey", new Object[0]);
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
        Object localObject2 = new PKCS8EncodedKeySpec(this.DPc);
        Object localObject1 = KeyFactory.getInstance("RSA");
        localObject2 = ((KeyFactory)localObject1).generatePrivate((KeySpec)localObject2);
        localObject1 = Cipher.getInstance(((KeyFactory)localObject1).getAlgorithm());
        ((Cipher)localObject1).init(2, (Key)localObject2);
        paramArrayOfByte = ((Cipher)localObject1).doFinal(paramArrayOfByte);
        localObject1 = com.tencent.mm.plugin.wear.a.a.j(this.sessionKey, paramArrayOfByte);
        ae.i("MicroMsg.Wear.HttpAuthServer", "funid %d, randomKey=%s", new Object[] { Integer.valueOf(paramInt), aj.B(paramArrayOfByte) });
        AppMethodBeat.o(30070);
        return localObject1;
      }
      catch (Exception paramArrayOfByte)
      {
        ae.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", paramArrayOfByte, "sessionKey resp error", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.b
 * JD-Core Version:    0.7.0.1
 */