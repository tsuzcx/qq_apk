package com.tencent.mm.wear.app.ui.emoji;

import com.tencent.mm.g.b;
import com.tencent.mm.sdk.platformtools.q;

public final class a
{
  public static String O(String paramString)
  {
    if (com.tencent.mm.wear.app.emoji.a.mw() == null) {
      return paramString;
    }
    if (q.D(paramString.toString())) {
      return "";
    }
    try
    {
      Object localObject1 = paramString.toCharArray();
      StringBuffer localStringBuffer1 = new StringBuffer();
      int i = 0;
      for (;;)
      {
        if (i < localObject1.length)
        {
          Object localObject2 = com.tencent.mm.wear.app.emoji.a.mw().bI(localObject1[i]);
          if (localObject2 != null)
          {
            char[] arrayOfChar = Character.toChars(((b)localObject2).Ys);
            StringBuffer localStringBuffer2 = new StringBuffer();
            localStringBuffer2.append(new String(arrayOfChar));
            if (((b)localObject2).Yt != 0) {
              localStringBuffer2.append(new String(Character.toChars(((b)localObject2).Yt)));
            }
            localObject2 = localStringBuffer2.toString();
            if (!q.D((String)localObject2)) {
              localStringBuffer1.append((String)localObject2);
            } else {
              localStringBuffer1.append(localObject1[i]);
            }
          }
          else
          {
            localStringBuffer1.append(localObject1[i]);
          }
        }
        else
        {
          localObject1 = localStringBuffer1.toString();
          return localObject1;
        }
        i += 1;
      }
      return paramString;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.emoji.a
 * JD-Core Version:    0.7.0.1
 */