package com.unionpay.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class d
{
  static byte[] d(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(207315);
    if ((paramArrayOfByte1 == null) || ((paramArrayOfByte1.length != 8) && (paramArrayOfByte1.length != 16) && (paramArrayOfByte1.length != 24)))
    {
      paramArrayOfByte1 = new IllegalArgumentException();
      AppMethodBeat.o(207315);
      throw paramArrayOfByte1;
    }
    if (paramArrayOfByte2 == null)
    {
      paramArrayOfByte1 = new IllegalArgumentException();
      AppMethodBeat.o(207315);
      throw paramArrayOfByte1;
    }
    Cipher localCipher = Cipher.getInstance("DESede/ECB/NoPadding");
    byte[] arrayOfByte = new byte[24];
    if (paramArrayOfByte1.length == 8)
    {
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, 8);
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 8, 8);
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 16, 8);
      paramArrayOfByte1 = paramArrayOfByte2;
      if (paramArrayOfByte2.length % 8 != 0)
      {
        paramArrayOfByte1 = new byte[(paramArrayOfByte2.length / 8 + 1) * 8];
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 0, paramArrayOfByte2.length);
        Arrays.fill(paramArrayOfByte1, paramArrayOfByte2.length, paramArrayOfByte1.length, (byte)0);
      }
      if (paramInt == 0) {
        break label235;
      }
    }
    label235:
    for (paramInt = 1;; paramInt = 2)
    {
      localCipher.init(paramInt, new SecretKeySpec(arrayOfByte, "DESede"));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      AppMethodBeat.o(207315);
      return paramArrayOfByte1;
      if (paramArrayOfByte1.length == 16)
      {
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, 16);
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 16, 8);
        break;
      }
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, 24);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.utils.d
 * JD-Core Version:    0.7.0.1
 */