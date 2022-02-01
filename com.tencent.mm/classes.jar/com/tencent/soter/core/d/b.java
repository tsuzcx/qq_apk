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
  protected static i cM(byte[] paramArrayOfByte)
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
  
  public void a(e parame) {}
  
  public abstract f aNO(String paramString);
  
  public abstract boolean aNP(String paramString);
  
  public abstract boolean aNQ(String paramString);
  
  public abstract i aNR(String paramString);
  
  public abstract Signature aNS(String paramString);
  
  public abstract f cU(String paramString, boolean paramBoolean);
  
  public boolean fmP()
  {
    return true;
  }
  
  public void fmQ() {}
  
  public abstract boolean fmR();
  
  public abstract f fmS();
  
  public abstract f fmT();
  
  public abstract boolean fmU();
  
  public abstract boolean fmV();
  
  public abstract i fmW();
  
  public abstract boolean kG(Context paramContext);
  
  public abstract SoterSessionResult lQ(String paramString1, String paramString2);
  
  public abstract byte[] xi(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.d.b
 * JD-Core Version:    0.7.0.1
 */