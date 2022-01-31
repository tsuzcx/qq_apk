package com.tencent.mm.plugin.wallet_core.model;

import android.util.Base64;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.security.PublicKey;
import javax.crypto.Cipher;

public final class l
{
  static l qvW;
  private PublicKey qvX = null;
  
  public final String aY(byte[] paramArrayOfByte)
  {
    try
    {
      this.qvX = com.tencent.mm.a.l.m(ae.getContext(), "lbs_rsa_public_key.pem");
      y.i("MicroMsg.LocationEncrypt", "getPemPublickKeyFromAsset23 done2");
      PublicKey localPublicKey = this.qvX;
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(1, localPublicKey);
      paramArrayOfByte = new String(Base64.encode(localCipher.doFinal(paramArrayOfByte), 0));
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("MicroMsg.LocationEncrypt", "encry publicKey error %s", new Object[] { paramArrayOfByte.getMessage() });
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.l
 * JD-Core Version:    0.7.0.1
 */