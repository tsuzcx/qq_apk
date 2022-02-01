package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.wear.model.a.b.a;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.plugin.wear.model.e.j;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.security.Key;
import java.util.HashSet;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class d
{
  com.tencent.mm.plugin.wear.model.a.b IxF;
  com.tencent.mm.plugin.wear.model.e.b IxG;
  public i IxH;
  j IxI;
  p IxJ;
  
  public d()
  {
    AppMethodBeat.i(29980);
    this.IxF = new com.tencent.mm.plugin.wear.model.a.a();
    this.IxG = new com.tencent.mm.plugin.wear.model.e.b();
    this.IxH = new i();
    this.IxI = new j();
    this.IxJ = new p();
    AppMethodBeat.o(29980);
  }
  
  public final boolean cv(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29983);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(29983);
      return false;
    }
    if (!fVW())
    {
      AppMethodBeat.o(29983);
      return false;
    }
    MMApplicationContext.getContext();
    String str = String.format("/wechat/%s/%d", new Object[] { "phone", Long.valueOf(System.currentTimeMillis()) });
    com.tencent.mm.plugin.wear.model.a.b localb = fVX();
    if (localb == null)
    {
      AppMethodBeat.o(29983);
      return false;
    }
    if (paramArrayOfByte.length > 92160) {}
    for (paramArrayOfByte = localb.x(str, paramArrayOfByte); paramArrayOfByte.code == 0; paramArrayOfByte = localb.w(str, paramArrayOfByte))
    {
      AppMethodBeat.o(29983);
      return true;
    }
    AppMethodBeat.o(29983);
    return false;
  }
  
  public final byte[] cw(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29984);
    Object localObject = this.IxG.getSessionKey();
    if ((paramArrayOfByte != null) && (localObject != null)) {
      try
      {
        Log.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", new Object[] { g.getMessageDigest((byte[])localObject) });
        localObject = new SecretKeySpec((byte[])localObject, "AES");
        Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        localCipher.init(2, (Key)localObject);
        paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
        AppMethodBeat.o(29984);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(29984);
        return null;
      }
    }
    AppMethodBeat.o(29984);
    return null;
  }
  
  public final byte[] cx(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29985);
    byte[] arrayOfByte = this.IxG.getSessionKey();
    if ((paramArrayOfByte != null) && (arrayOfByte != null)) {
      try
      {
        Log.d("MicroMsg.Wear.WearConnectLogic", "sessionKey is not null %s", new Object[] { g.getMessageDigest(arrayOfByte) });
        paramArrayOfByte = com.tencent.mm.plugin.wear.a.a.j(paramArrayOfByte, arrayOfByte);
        AppMethodBeat.o(29985);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.printErrStackTrace("MicroMsg.Wear.WearConnectLogic", paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(29985);
        return null;
      }
    }
    AppMethodBeat.o(29985);
    return null;
  }
  
  public final boolean fVW()
  {
    AppMethodBeat.i(29981);
    if ((fVX() != null) && (fVX().fWb().size() > 0))
    {
      AppMethodBeat.o(29981);
      return true;
    }
    AppMethodBeat.o(29981);
    return false;
  }
  
  public final com.tencent.mm.plugin.wear.model.a.b fVX()
  {
    AppMethodBeat.i(29982);
    if ((this.IxF.isAvailable()) && (this.IxF.fWc()))
    {
      com.tencent.mm.plugin.wear.model.a.b localb = this.IxF;
      AppMethodBeat.o(29982);
      return localb;
    }
    AppMethodBeat.o(29982);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d
 * JD-Core Version:    0.7.0.1
 */