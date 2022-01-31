package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.sdk.platformtools.bk;

public final class a
{
  public static boolean QU(String paramString)
  {
    if (bk.bl(paramString)) {}
    int i;
    do
    {
      return false;
      Object localObject = null;
      String[] arrayOfString = paramString.split("&");
      int j = arrayOfString.length;
      i = 0;
      paramString = localObject;
      if (i < j)
      {
        paramString = arrayOfString[i].split("=");
        if ((paramString.length <= 1) || (!paramString[0].equals("prepay_id"))) {
          break;
        }
        paramString = paramString[1];
      }
    } while (bk.bl(paramString));
    if (paramString.startsWith("up_")) {}
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.a
 * JD-Core Version:    0.7.0.1
 */