package com.tencent.pb.common.c;

import com.tencent.pb.talkroom.sdk.e;
import com.tencent.wecall.talkroom.model.f;

public final class c
{
  private static int Bhc = 2;
  private static boolean Bhd = false;
  public static int level = 0;
  
  private static String K(Object[] paramArrayOfObject)
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
  
  private static void L(int paramInt, String paramString1, String paramString2)
  {
    e locale = f.dXO();
    if (locale != null) {
      locale.y(paramInt, "MTSDK".concat(String.valueOf(paramString1)), paramString2);
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if ((!Bhd) || (Bhc > 1)) {}
    while (paramString == null) {
      return;
    }
    L(1, paramString, " ".concat(String.valueOf(K(paramVarArgs))));
  }
  
  public static void dTU()
  {
    Bhc = 0;
    Bhd = true;
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    if ((!Bhd) || (Bhc > 4)) {
      return;
    }
    L(4, paramString, " ".concat(String.valueOf(K(paramVarArgs))));
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    if ((!Bhd) || (Bhc > 2)) {
      return;
    }
    L(2, paramString, " ".concat(String.valueOf(K(paramVarArgs))));
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    if ((!Bhd) || (Bhc > 3)) {}
    while (paramString == null) {
      return;
    }
    L(3, paramString, " ".concat(String.valueOf(K(paramVarArgs))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.c.c
 * JD-Core Version:    0.7.0.1
 */