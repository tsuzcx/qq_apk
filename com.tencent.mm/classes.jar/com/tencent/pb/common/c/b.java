package com.tencent.pb.common.c;

import com.tencent.pb.talkroom.sdk.e;
import com.tencent.wecall.talkroom.model.f;

public final class b
{
  private static int InX = 2;
  private static boolean InY = false;
  public static int level = 0;
  
  private static String L(Object[] paramArrayOfObject)
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
  
  private static void U(int paramInt, String paramString1, String paramString2)
  {
    e locale = f.fqf();
    if (locale != null) {
      locale.F(paramInt, "MTSDK".concat(String.valueOf(paramString1)), paramString2);
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if ((!InY) || (InX > 1)) {}
    while (paramString == null) {
      return;
    }
    U(1, paramString, " ".concat(String.valueOf(L(paramVarArgs))));
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    if ((!InY) || (InX > 4)) {
      return;
    }
    U(4, paramString, " ".concat(String.valueOf(L(paramVarArgs))));
  }
  
  public static void flC()
  {
    InX = 0;
    InY = true;
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    if ((!InY) || (InX > 2)) {
      return;
    }
    U(2, paramString, " ".concat(String.valueOf(L(paramVarArgs))));
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    if ((!InY) || (InX > 3)) {}
    while (paramString == null) {
      return;
    }
    U(3, paramString, " ".concat(String.valueOf(L(paramVarArgs))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.common.c.b
 * JD-Core Version:    0.7.0.1
 */