package f.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class a
  implements b
{
  private String abFg = null;
  
  public final void bHY(String paramString)
  {
    this.abFg = paramString;
  }
  
  public final byte[] dI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207933);
    if ((this.abFg == null) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(207933);
      return null;
    }
    Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    localCipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.abFg.getBytes("UTF-8"))), new IvParameterSpec(this.abFg.getBytes("UTF-8")));
    paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
    AppMethodBeat.o(207933);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     f.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */