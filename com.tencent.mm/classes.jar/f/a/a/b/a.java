package f.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class a
  implements b
{
  private String UbR = null;
  
  public final void buV(String paramString)
  {
    this.UbR = paramString;
  }
  
  public final byte[] encode(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214851);
    if ((this.UbR == null) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(214851);
      return null;
    }
    Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    localCipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.UbR.getBytes("UTF-8"))), new IvParameterSpec(this.UbR.getBytes("UTF-8")));
    paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
    AppMethodBeat.o(214851);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     f.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */