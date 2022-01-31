package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.wear.model.a.b.a;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.plugin.wear.model.e.j;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.sdk.platformtools.y;
import java.security.Key;
import java.util.HashSet;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class d
{
  com.tencent.mm.plugin.wear.model.a.b qRJ = new com.tencent.mm.plugin.wear.model.a.a();
  com.tencent.mm.plugin.wear.model.e.b qRK = new com.tencent.mm.plugin.wear.model.e.b();
  public i qRL = new i();
  j qRM = new j();
  p qRN = new p();
  
  public final boolean bYQ()
  {
    return (bYR() != null) && (bYR().bYV().size() > 0);
  }
  
  public final com.tencent.mm.plugin.wear.model.a.b bYR()
  {
    if ((this.qRJ.isAvailable()) && (this.qRJ.bYW())) {
      return this.qRJ;
    }
    return null;
  }
  
  public final boolean bc(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    if (!bYQ()) {
      return false;
    }
    String str = String.format("/wechat/%s/%d", new Object[] { "phone", Long.valueOf(System.currentTimeMillis()) });
    com.tencent.mm.plugin.wear.model.a.b localb = bYR();
    if (localb == null) {
      return false;
    }
    if (paramArrayOfByte.length > 92160) {}
    for (paramArrayOfByte = localb.u(str, paramArrayOfByte); paramArrayOfByte.code == 0; paramArrayOfByte = localb.t(str, paramArrayOfByte)) {
      return true;
    }
    return false;
  }
  
  public final byte[] bd(byte[] paramArrayOfByte)
  {
    Cipher localCipher = null;
    byte[] arrayOfByte = this.qRK.Dj();
    Object localObject = localCipher;
    if (paramArrayOfByte != null)
    {
      localObject = localCipher;
      if (arrayOfByte == null) {}
    }
    try
    {
      y.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", new Object[] { g.o(arrayOfByte) });
      localObject = new SecretKeySpec(arrayOfByte, "AES");
      localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      localCipher.init(2, (Key)localObject);
      localObject = localCipher.doFinal(paramArrayOfByte);
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      y.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", paramArrayOfByte, "", new Object[0]);
    }
    return null;
  }
  
  public final byte[] be(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    byte[] arrayOfByte = this.qRK.Dj();
    Object localObject1 = localObject2;
    if (paramArrayOfByte != null)
    {
      localObject1 = localObject2;
      if (arrayOfByte == null) {}
    }
    try
    {
      y.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", new Object[] { g.o(arrayOfByte) });
      localObject1 = com.tencent.mm.plugin.wear.a.a.f(paramArrayOfByte, arrayOfByte);
      return localObject1;
    }
    catch (Exception paramArrayOfByte)
    {
      y.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", paramArrayOfByte, "", new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d
 * JD-Core Version:    0.7.0.1
 */