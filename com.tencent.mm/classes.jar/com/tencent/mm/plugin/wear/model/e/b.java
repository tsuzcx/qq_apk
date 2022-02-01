package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.y;
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
  private byte[] Wji;
  private byte[] Wjj;
  private byte[] sessionKey;
  
  private void iod()
  {
    AppMethodBeat.i(30068);
    File localFile3 = new File(com.tencent.mm.loader.i.b.bms(), "wear/key");
    if (!localFile3.exists()) {
      localFile3.mkdirs();
    }
    File localFile1 = new File(localFile3, "private.key");
    File localFile2 = new File(localFile3, "public.key");
    localFile3 = new File(localFile3, "session.key");
    if ((!localFile1.exists()) || (!localFile2.exists()) || (!localFile3.exists()))
    {
      Log.i("MicroMsg.Wear.HttpAuthServer", "recreate keys");
      localFile1.delete();
      localFile2.delete();
      localFile3.delete();
      HashMap localHashMap = com.tencent.mm.plugin.wear.a.a.iof();
      RSAPrivateKey localRSAPrivateKey = (RSAPrivateKey)localHashMap.get("RSAPrivateKey");
      this.Wjj = ((RSAPublicKey)localHashMap.get("RSAPublicKey")).getEncoded();
      this.Wji = localRSAPrivateKey.getEncoded();
      this.sessionKey = com.tencent.mm.plugin.wear.a.a.iog();
      y.f(localFile1.getAbsolutePath(), this.Wji, this.Wji.length);
      y.f(localFile2.getAbsolutePath(), this.Wjj, this.Wjj.length);
      y.f(localFile3.getAbsolutePath(), this.sessionKey, this.sessionKey.length);
    }
    for (;;)
    {
      Log.i("MicroMsg.Wear.HttpAuthServer", "publicKey=%s privateKey=%s sessionKey=%s", new Object[] { MD5Util.getMD5String(this.Wjj), MD5Util.getMD5String(this.Wji), MD5Util.getMD5String(this.sessionKey) });
      AppMethodBeat.o(30068);
      return;
      Log.i("MicroMsg.Wear.HttpAuthServer", "use old keys");
      this.Wjj = y.bi(localFile2.getAbsolutePath(), 0, 2147483647);
      this.Wji = y.bi(localFile1.getAbsolutePath(), 0, 2147483647);
      this.sessionKey = y.bi(localFile3.getAbsolutePath(), 0, 2147483647);
    }
  }
  
  public final byte[] getSessionKey()
  {
    boolean bool3 = true;
    AppMethodBeat.i(30067);
    if ((this.Wjj == null) || (this.Wji == null) || (this.sessionKey == null)) {
      Log.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
    }
    try
    {
      iod();
      if (this.Wjj != null)
      {
        bool1 = true;
        if (this.Wji == null) {
          break label135;
        }
        bool2 = true;
        if (this.sessionKey == null) {
          break label140;
        }
        Log.i("MicroMsg.Wear.HttpAuthServer", "publicKey %s privateKey %s sessionKey %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        byte[] arrayOfByte = this.sessionKey;
        AppMethodBeat.o(30067);
        return arrayOfByte;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", localException, "loadAllKey", new Object[0]);
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
  
  public final List<Integer> iob()
  {
    AppMethodBeat.i(30069);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(10001));
    localArrayList.add(Integer.valueOf(10002));
    AppMethodBeat.o(30069);
    return localArrayList;
  }
  
  protected final byte[] u(int paramInt, byte[] paramArrayOfByte)
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
      Log.i("MicroMsg.Wear.HttpAuthServer", "request public key");
      if ((this.Wjj == null) || (this.Wji == null) || (this.sessionKey == null)) {
        Log.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
      }
      try
      {
        iod();
        if (this.Wjj != null)
        {
          bool1 = true;
          if (this.Wji == null) {
            break label173;
          }
          bool2 = true;
          if (this.sessionKey == null) {
            break label179;
          }
          Log.i("MicroMsg.Wear.HttpAuthServer", "publicKey %s privateKey %s sessionKey %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          paramArrayOfByte = this.Wjj;
          AppMethodBeat.o(30070);
          return paramArrayOfByte;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", paramArrayOfByte, "loadAllKey", new Object[0]);
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
        Object localObject2 = new PKCS8EncodedKeySpec(this.Wji);
        Object localObject1 = KeyFactory.getInstance("RSA");
        localObject2 = ((KeyFactory)localObject1).generatePrivate((KeySpec)localObject2);
        localObject1 = Cipher.getInstance(((KeyFactory)localObject1).getAlgorithm());
        ((Cipher)localObject1).init(2, (Key)localObject2);
        paramArrayOfByte = ((Cipher)localObject1).doFinal(paramArrayOfByte);
        localObject1 = com.tencent.mm.plugin.wear.a.a.n(this.sessionKey, paramArrayOfByte);
        Log.i("MicroMsg.Wear.HttpAuthServer", "funid %d, randomKey=%s", new Object[] { Integer.valueOf(paramInt), MD5Util.getMD5String(paramArrayOfByte) });
        AppMethodBeat.o(30070);
        return localObject1;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.printErrStackTrace("MicroMsg.Wear.HttpAuthServer", paramArrayOfByte, "sessionKey resp error", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.b
 * JD-Core Version:    0.7.0.1
 */