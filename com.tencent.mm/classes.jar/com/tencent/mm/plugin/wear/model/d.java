package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.wear.model.a.b.a;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.plugin.wear.model.e.j;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.security.Key;
import java.util.HashSet;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class d
{
  com.tencent.mm.plugin.wear.model.a.b uGR;
  com.tencent.mm.plugin.wear.model.e.b uGS;
  public i uGT;
  j uGU;
  p uGV;
  
  public d()
  {
    AppMethodBeat.i(26289);
    this.uGR = new com.tencent.mm.plugin.wear.model.a.a();
    this.uGS = new com.tencent.mm.plugin.wear.model.e.b();
    this.uGT = new i();
    this.uGU = new j();
    this.uGV = new p();
    AppMethodBeat.o(26289);
  }
  
  public final boolean bD(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26292);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(26292);
      return false;
    }
    if (!cYD())
    {
      AppMethodBeat.o(26292);
      return false;
    }
    ah.getContext();
    String str = String.format("/wechat/%s/%d", new Object[] { "phone", Long.valueOf(System.currentTimeMillis()) });
    com.tencent.mm.plugin.wear.model.a.b localb = cYE();
    if (localb == null)
    {
      AppMethodBeat.o(26292);
      return false;
    }
    if (paramArrayOfByte.length > 92160) {}
    for (paramArrayOfByte = localb.C(str, paramArrayOfByte); paramArrayOfByte.code == 0; paramArrayOfByte = localb.B(str, paramArrayOfByte))
    {
      AppMethodBeat.o(26292);
      return true;
    }
    AppMethodBeat.o(26292);
    return false;
  }
  
  public final byte[] bE(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26293);
    Object localObject = this.uGS.getSessionKey();
    if ((paramArrayOfByte != null) && (localObject != null)) {
      try
      {
        ab.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", new Object[] { g.w((byte[])localObject) });
        localObject = new SecretKeySpec((byte[])localObject, "AES");
        Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        localCipher.init(2, (Key)localObject);
        paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
        AppMethodBeat.o(26293);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        ab.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(26293);
        return null;
      }
    }
    AppMethodBeat.o(26293);
    return null;
  }
  
  public final byte[] bF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26294);
    byte[] arrayOfByte = this.uGS.getSessionKey();
    if ((paramArrayOfByte != null) && (arrayOfByte != null)) {
      try
      {
        ab.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", new Object[] { g.w(arrayOfByte) });
        paramArrayOfByte = com.tencent.mm.plugin.wear.a.a.i(paramArrayOfByte, arrayOfByte);
        AppMethodBeat.o(26294);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        ab.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(26294);
        return null;
      }
    }
    AppMethodBeat.o(26294);
    return null;
  }
  
  public final boolean cYD()
  {
    AppMethodBeat.i(26290);
    if ((cYE() != null) && (cYE().cYI().size() > 0))
    {
      AppMethodBeat.o(26290);
      return true;
    }
    AppMethodBeat.o(26290);
    return false;
  }
  
  public final com.tencent.mm.plugin.wear.model.a.b cYE()
  {
    AppMethodBeat.i(26291);
    if ((this.uGR.isAvailable()) && (this.uGR.cYJ()))
    {
      com.tencent.mm.plugin.wear.model.a.b localb = this.uGR;
      AppMethodBeat.o(26291);
      return localb;
    }
    AppMethodBeat.o(26291);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d
 * JD-Core Version:    0.7.0.1
 */