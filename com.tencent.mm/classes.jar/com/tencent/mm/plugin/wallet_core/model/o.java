package com.tencent.mm.plugin.wallet_core.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.security.PublicKey;

public final class o
{
  private static o DoO;
  private PublicKey DoP = null;
  
  public static o eIX()
  {
    AppMethodBeat.i(70303);
    if (DoO == null) {
      DoO = new o();
    }
    o localo = DoO;
    AppMethodBeat.o(70303);
    return localo;
  }
  
  public final String ca(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(70304);
    try
    {
      this.DoP = m.o(ak.getContext(), "lbs_rsa_public_key.pem");
      ae.i("MicroMsg.LocationEncrypt", "getPemPublickKeyFromAsset23 done2");
      paramArrayOfByte = new String(Base64.encode(m.a(paramArrayOfByte, this.DoP, "RSA/ECB/PKCS1Padding"), 0));
      AppMethodBeat.o(70304);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      ae.e("MicroMsg.LocationEncrypt", "encry publicKey error %s", new Object[] { paramArrayOfByte.getMessage() });
      AppMethodBeat.o(70304);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.o
 * JD-Core Version:    0.7.0.1
 */