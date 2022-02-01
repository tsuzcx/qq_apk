package h.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class a
  implements b
{
  private String ajGj = null;
  
  public final void bKc(String paramString)
  {
    this.ajGj = paramString;
  }
  
  public final byte[] dL(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186276);
    if ((this.ajGj == null) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(186276);
      return null;
    }
    Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    localCipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.ajGj.getBytes("UTF-8"))), new IvParameterSpec(this.ajGj.getBytes("UTF-8")));
    paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
    AppMethodBeat.o(186276);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     h.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */