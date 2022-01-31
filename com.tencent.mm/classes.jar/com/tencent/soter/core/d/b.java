package com.tencent.soter.core.d;

import android.content.Context;
import android.util.Base64;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.i;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.security.Signature;

public abstract class b
{
  protected static i bS(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      d.e("Soter.SoterCoreBase", "soter: raw data is null", new Object[0]);
      return null;
    }
    if (paramArrayOfByte.length < 4) {
      d.e("Soter.SoterCoreBase", "soter: raw data length smaller than RAW_LENGTH_PREFIX", new Object[0]);
    }
    Object localObject = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, localObject, 0, 4);
    int j = 0;
    int i = 0;
    while (j < 4)
    {
      i += ((localObject[j] & 0xFF) << j * 8);
      j += 1;
    }
    d.d("Soter.SoterCoreBase", "soter: parsed raw length: " + i, new Object[0]);
    if (i > 1048576)
    {
      d.e("Soter.SoterCoreBase", "soter: too large json result!", new Object[0]);
      return null;
    }
    localObject = new byte[i];
    if (paramArrayOfByte.length <= i + 4)
    {
      d.e("Soter.SoterCoreBase", "length not correct 2", new Object[0]);
      return null;
    }
    System.arraycopy(paramArrayOfByte, 4, localObject, 0, i);
    localObject = new String((byte[])localObject);
    d.d("Soter.SoterCoreBase", "soter: to convert json: " + (String)localObject, new Object[0]);
    localObject = new i((String)localObject, "");
    j = paramArrayOfByte.length - (i + 4);
    d.d("Soter.SoterCoreBase", "soter: signature length: " + j, new Object[0]);
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, i + 4, arrayOfByte, 0, j);
    ((i)localObject).signature = Base64.encodeToString(arrayOfByte, 2);
    return localObject;
  }
  
  public abstract f afO(String paramString);
  
  public abstract boolean afP(String paramString);
  
  public abstract boolean afQ(String paramString);
  
  public abstract i afR(String paramString);
  
  public abstract Signature afS(String paramString);
  
  public abstract f bR(String paramString, boolean paramBoolean);
  
  public abstract boolean cPh();
  
  public abstract f cPi();
  
  public abstract f cPj();
  
  public abstract boolean cPk();
  
  public abstract boolean cPl();
  
  public abstract i cPm();
  
  public abstract SoterSessionResult gM(String paramString1, String paramString2);
  
  public abstract boolean hL(Context paramContext);
  
  public abstract byte[] im(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.core.d.b
 * JD-Core Version:    0.7.0.1
 */