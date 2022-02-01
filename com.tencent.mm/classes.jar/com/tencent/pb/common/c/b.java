package com.tencent.pb.common.c;

import com.tencent.pb.talkroom.sdk.e;
import com.tencent.wecall.talkroom.model.f;

public final class b
{
  private static int RGP = 2;
  private static boolean RGQ = false;
  public static int level = 0;
  
  private static String O(Object[] paramArrayOfObject)
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
  
  private static void aa(int paramInt, String paramString1, String paramString2)
  {
    e locale = f.hrt();
    if (locale != null) {
      locale.H(paramInt, "MTSDK".concat(String.valueOf(paramString1)), paramString2);
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if ((!RGQ) || (RGP > 1)) {}
    while (paramString == null) {
      return;
    }
    aa(1, paramString, " ".concat(String.valueOf(O(paramVarArgs))));
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    if ((!RGQ) || (RGP > 4)) {
      return;
    }
    aa(4, paramString, " ".concat(String.valueOf(O(paramVarArgs))));
  }
  
  public static void hjo()
  {
    RGP = 0;
    RGQ = true;
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    if ((!RGQ) || (RGP > 2)) {
      return;
    }
    aa(2, paramString, " ".concat(String.valueOf(O(paramVarArgs))));
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    if ((!RGQ) || (RGP > 3)) {}
    while (paramString == null) {
      return;
    }
    aa(3, paramString, " ".concat(String.valueOf(O(paramVarArgs))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.c.b
 * JD-Core Version:    0.7.0.1
 */