package com.tencent.mm.plugin.wallet_core.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.security.PublicKey;
import javax.crypto.Cipher;

public final class q
{
  private static q uiv;
  private PublicKey uiw = null;
  
  public static q cTG()
  {
    AppMethodBeat.i(142485);
    if (uiv == null) {
      uiv = new q();
    }
    q localq = uiv;
    AppMethodBeat.o(142485);
    return localq;
  }
  
  public final String bz(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(46785);
    try
    {
      this.uiw = m.r(ah.getContext(), "lbs_rsa_public_key.pem");
      ab.i("MicroMsg.LocationEncrypt", "getPemPublickKeyFromAsset23 done2");
      PublicKey localPublicKey = this.uiw;
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(1, localPublicKey);
      paramArrayOfByte = new String(Base64.encode(localCipher.doFinal(paramArrayOfByte), 0));
      AppMethodBeat.o(46785);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.e("MicroMsg.LocationEncrypt", "encry publicKey error %s", new Object[] { paramArrayOfByte.getMessage() });
      AppMethodBeat.o(46785);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.q
 * JD-Core Version:    0.7.0.1
 */