package com.tencent.pb.common.c;

import com.tencent.pb.talkroom.sdk.e;
import com.tencent.wecall.talkroom.model.f;

public final class c
{
  public static int level = 0;
  private static int wJC = 2;
  private static boolean wJD = false;
  
  private static String D(Object[] paramArrayOfObject)
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
  
  private static void D(int paramInt, String paramString1, String paramString2)
  {
    e locale = f.cRT();
    if (locale != null) {
      locale.o(paramInt, "MTSDK" + paramString1, paramString2);
    }
  }
  
  public static void cOi()
  {
    wJC = 0;
    wJD = true;
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if ((!wJD) || (wJC > 1)) {}
    while (paramString == null) {
      return;
    }
    paramVarArgs = D(paramVarArgs);
    D(1, paramString, " " + paramVarArgs);
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    if ((!wJD) || (wJC > 4)) {
      return;
    }
    paramVarArgs = D(paramVarArgs);
    D(4, paramString, " " + paramVarArgs);
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    if ((!wJD) || (wJC > 2)) {
      return;
    }
    paramVarArgs = D(paramVarArgs);
    D(2, paramString, " " + paramVarArgs);
  }
  
  public static void x(String paramString, Object... paramVarArgs)
  {
    if ((!wJD) || (wJC > 3)) {}
    while (paramString == null) {
      return;
    }
    paramVarArgs = D(paramVarArgs);
    D(3, paramString, " " + paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.c.c
 * JD-Core Version:    0.7.0.1
 */