package com.tencent.soter.core.b;

import android.os.Build.VERSION;
import com.tencent.soter.core.c.d;
import java.security.spec.AlgorithmParameterSpec;

public abstract class a
{
  public static String[] P(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      return (String[])paramArrayOfString.clone();
    }
    return paramArrayOfString;
  }
  
  public static a dU(String paramString, int paramInt)
  {
    if (com.tencent.soter.core.a.cPh())
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return new a.b(paramString, paramInt);
      }
      return new a.c(paramString, paramInt);
    }
    d.e("Soter.KeyGenParameterSpecCompatBuilder", "soter: not support soter. return dummy", new Object[0]);
    return new a.a();
  }
  
  public abstract a N(String... paramVarArgs);
  
  public abstract a O(String... paramVarArgs);
  
  public abstract AlgorithmParameterSpec cPo();
  
  public abstract a cPp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.core.b.a
 * JD-Core Version:    0.7.0.1
 */