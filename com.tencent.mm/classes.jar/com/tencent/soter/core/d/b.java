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
  protected static i dy(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    if (paramArrayOfByte == null) {
      d.e("Soter.SoterCoreBase", "soter: raw data is null", new Object[0]);
    }
    int j;
    int i;
    i locali;
    do
    {
      return localObject;
      if (paramArrayOfByte.length < 4) {
        d.e("Soter.SoterCoreBase", "soter: raw data length smaller than RAW_LENGTH_PREFIX", new Object[0]);
      }
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, 4);
      j = 0;
      i = 0;
      while (j < 4)
      {
        i += ((localObject[j] & 0xFF) << j * 8);
        j += 1;
      }
      d.d("Soter.SoterCoreBase", "soter: parsed raw length: ".concat(String.valueOf(i)), new Object[0]);
      if (i > 1048576)
      {
        d.e("Soter.SoterCoreBase", "soter: too large json result!", new Object[0]);
        return null;
      }
      localObject = new byte[i];
      if (paramArrayOfByte.length < i + 4)
      {
        d.e("Soter.SoterCoreBase", "length not correct 2", new Object[0]);
        return null;
      }
      System.arraycopy(paramArrayOfByte, 4, localObject, 0, i);
      localObject = new String((byte[])localObject);
      d.d("Soter.SoterCoreBase", "soter: to convert json: ".concat(String.valueOf(localObject)), new Object[0]);
      locali = new i((String)localObject, "");
      j = paramArrayOfByte.length - (i + 4);
      d.d("Soter.SoterCoreBase", "soter: signature length: ".concat(String.valueOf(j)), new Object[0]);
      localObject = locali;
    } while (j == 0);
    localObject = new byte[j];
    System.arraycopy(paramArrayOfByte, i + 4, localObject, 0, j);
    locali.signature = Base64.encodeToString((byte[])localObject, 2);
    return locali;
  }
  
  public abstract byte[] Bc(long paramLong);
  
  public void a(e parame) {}
  
  public abstract f bFE(String paramString);
  
  public abstract boolean bFF(String paramString);
  
  public abstract boolean bFG(String paramString);
  
  public abstract i bFH(String paramString);
  
  public abstract Signature bFI(String paramString);
  
  public abstract f eF(String paramString, boolean paramBoolean);
  
  public boolean jXT()
  {
    return true;
  }
  
  public void jXU() {}
  
  public abstract boolean jXV();
  
  public abstract f jXW();
  
  public abstract f jXX();
  
  public abstract boolean jXY();
  
  public abstract boolean jXZ();
  
  public abstract i jYa();
  
  public abstract boolean or(Context paramContext);
  
  public abstract SoterSessionResult qC(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.soter.core.d.b
 * JD-Core Version:    0.7.0.1
 */