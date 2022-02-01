package com.tencent.mm.plugin.wallet_core.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.security.PublicKey;

public final class o
{
  private static o Aez;
  private PublicKey AeA = null;
  
  public static o ebU()
  {
    AppMethodBeat.i(70303);
    if (Aez == null) {
      Aez = new o();
    }
    o localo = Aez;
    AppMethodBeat.o(70303);
    return localo;
  }
  
  public final String bR(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(70304);
    try
    {
      this.AeA = m.q(aj.getContext(), "lbs_rsa_public_key.pem");
      ad.i("MicroMsg.LocationEncrypt", "getPemPublickKeyFromAsset23 done2");
      paramArrayOfByte = new String(Base64.encode(m.a(paramArrayOfByte, this.AeA, "RSA/ECB/PKCS1Padding"), 0));
      AppMethodBeat.o(70304);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("MicroMsg.LocationEncrypt", "encry publicKey error %s", new Object[] { paramArrayOfByte.getMessage() });
      AppMethodBeat.o(70304);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.o
 * JD-Core Version:    0.7.0.1
 */