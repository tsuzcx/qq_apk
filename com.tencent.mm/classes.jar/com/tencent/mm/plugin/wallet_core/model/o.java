package com.tencent.mm.plugin.wallet_core.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.security.PublicKey;

public final class o
{
  private static o VFW;
  private PublicKey VFX = null;
  
  public static o iiu()
  {
    AppMethodBeat.i(70303);
    if (VFW == null) {
      VFW = new o();
    }
    o localo = VFW;
    AppMethodBeat.o(70303);
    return localo;
  }
  
  public final String cL(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(70304);
    try
    {
      this.VFX = m.u(MMApplicationContext.getContext(), "lbs_rsa_public_key.pem");
      Log.i("MicroMsg.LocationEncrypt", "getPemPublickKeyFromAsset23 done2");
      paramArrayOfByte = new String(Base64.encode(m.a(paramArrayOfByte, this.VFX, "RSA/ECB/PKCS1Padding"), 0));
      AppMethodBeat.o(70304);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.LocationEncrypt", "encry publicKey error %s", new Object[] { paramArrayOfByte.getMessage() });
      AppMethodBeat.o(70304);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.o
 * JD-Core Version:    0.7.0.1
 */