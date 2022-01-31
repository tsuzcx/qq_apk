package com.tencent.soter.core.b;

import android.os.Build.VERSION;
import com.tencent.soter.core.c.d;
import java.security.spec.AlgorithmParameterSpec;

public abstract class a
{
  public static String[] Y(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      return (String[])paramArrayOfString.clone();
    }
    return paramArrayOfString;
  }
  
  public static a fe(String paramString, int paramInt)
  {
    if (com.tencent.soter.core.a.dVc())
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return new a.b(paramString, paramInt);
      }
      return new a.c(paramString, paramInt);
    }
    d.e("Soter.KeyGenParameterSpecCompatBuilder", "soter: not support soter. return dummy", new Object[0]);
    return new a.a();
  }
  
  public abstract a W(String... paramVarArgs);
  
  public abstract a X(String... paramVarArgs);
  
  public abstract AlgorithmParameterSpec dVj();
  
  public abstract a dVk();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.soter.core.b.a
 * JD-Core Version:    0.7.0.1
 */