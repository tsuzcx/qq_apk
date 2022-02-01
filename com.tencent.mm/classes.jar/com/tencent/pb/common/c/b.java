package com.tencent.pb.common.c;

import com.tencent.pb.talkroom.sdk.e;
import com.tencent.wecall.talkroom.model.f;

public final class b
{
  private static int ahgW = 2;
  private static boolean ahgX = false;
  public static int level = 0;
  
  private static String T(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
      return "";
    }
    int j = paramArrayOfObject.length;
    StringBuffer localStringBuffer = new StringBuffer(250);
    int i = 0;
    if (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      if (localObject != null)
      {
        localStringBuffer.append("|");
        if (!(localObject instanceof Throwable)) {
          break label78;
        }
        localStringBuffer.append(((Throwable)localObject).getMessage());
      }
      for (;;)
      {
        i += 1;
        break;
        label78:
        localStringBuffer.append(localObject.toString());
      }
    }
    return localStringBuffer.toString();
  }
  
  private static void ah(int paramInt, String paramString1, String paramString2)
  {
    e locale = f.kex();
    if (locale != null) {
      locale.O(paramInt, "MTSDK".concat(String.valueOf(paramString1)), paramString2);
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if ((!ahgX) || (ahgW > 1)) {}
    while (paramString == null) {
      return;
    }
    ah(1, paramString, " ".concat(String.valueOf(T(paramVarArgs))));
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    if ((!ahgX) || (ahgW > 4)) {
      return;
    }
    ah(4, paramString, " ".concat(String.valueOf(T(paramVarArgs))));
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    if ((!ahgX) || (ahgW > 2)) {
      return;
    }
    ah(2, paramString, " ".concat(String.valueOf(T(paramVarArgs))));
  }
  
  public static void jRp()
  {
    ahgW = 0;
    ahgX = true;
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    if ((!ahgX) || (ahgW > 3)) {}
    while (paramString == null) {
      return;
    }
    ah(3, paramString, " ".concat(String.valueOf(T(paramVarArgs))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.pb.common.c.b
 * JD-Core Version:    0.7.0.1
 */