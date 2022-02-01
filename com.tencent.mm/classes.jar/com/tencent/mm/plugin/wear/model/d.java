package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.wear.model.a.b.a;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.plugin.wear.model.e.j;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.security.Key;
import java.util.HashSet;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class d
{
  com.tencent.mm.plugin.wear.model.a.b ADX;
  com.tencent.mm.plugin.wear.model.e.b ADY;
  public i ADZ;
  j AEa;
  p AEb;
  
  public d()
  {
    AppMethodBeat.i(29980);
    this.ADX = new com.tencent.mm.plugin.wear.model.a.a();
    this.ADY = new com.tencent.mm.plugin.wear.model.e.b();
    this.ADZ = new i();
    this.AEa = new j();
    this.AEb = new p();
    AppMethodBeat.o(29980);
  }
  
  public final boolean bV(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29983);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(29983);
      return false;
    }
    if (!ehf())
    {
      AppMethodBeat.o(29983);
      return false;
    }
    aj.getContext();
    String str = String.format("/wechat/%s/%d", new Object[] { "phone", Long.valueOf(System.currentTimeMillis()) });
    com.tencent.mm.plugin.wear.model.a.b localb = ehg();
    if (localb == null)
    {
      AppMethodBeat.o(29983);
      return false;
    }
    if (paramArrayOfByte.length > 92160) {}
    for (paramArrayOfByte = localb.w(str, paramArrayOfByte); paramArrayOfByte.code == 0; paramArrayOfByte = localb.v(str, paramArrayOfByte))
    {
      AppMethodBeat.o(29983);
      return true;
    }
    AppMethodBeat.o(29983);
    return false;
  }
  
  public final byte[] bW(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29984);
    Object localObject = this.ADY.getSessionKey();
    if ((paramArrayOfByte != null) && (localObject != null)) {
      try
      {
        ad.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", new Object[] { g.getMessageDigest((byte[])localObject) });
        localObject = new SecretKeySpec((byte[])localObject, "AES");
        Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        localCipher.init(2, (Key)localObject);
        paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
        AppMethodBeat.o(29984);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        ad.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(29984);
        return null;
      }
    }
    AppMethodBeat.o(29984);
    return null;
  }
  
  public final byte[] bX(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29985);
    byte[] arrayOfByte = this.ADY.getSessionKey();
    if ((paramArrayOfByte != null) && (arrayOfByte != null)) {
      try
      {
        ad.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", new Object[] { g.getMessageDigest(arrayOfByte) });
        paramArrayOfByte = com.tencent.mm.plugin.wear.a.a.j(paramArrayOfByte, arrayOfByte);
        AppMethodBeat.o(29985);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        ad.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(29985);
        return null;
      }
    }
    AppMethodBeat.o(29985);
    return null;
  }
  
  public final boolean ehf()
  {
    AppMethodBeat.i(29981);
    if ((ehg() != null) && (ehg().ehk().size() > 0))
    {
      AppMethodBeat.o(29981);
      return true;
    }
    AppMethodBeat.o(29981);
    return false;
  }
  
  public final com.tencent.mm.plugin.wear.model.a.b ehg()
  {
    AppMethodBeat.i(29982);
    if ((this.ADX.isAvailable()) && (this.ADX.ehl()))
    {
      com.tencent.mm.plugin.wear.model.a.b localb = this.ADX;
      AppMethodBeat.o(29982);
      return localb;
    }
    AppMethodBeat.o(29982);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d
 * JD-Core Version:    0.7.0.1
 */