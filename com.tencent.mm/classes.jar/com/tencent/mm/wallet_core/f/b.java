package com.tencent.mm.wallet_core.f;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.util.Map;

public final class b
{
  public static boolean cMT()
  {
    StringBuilder localStringBuilder = new StringBuilder(8);
    int i = 0;
    for (;;)
    {
      char c;
      if (i < 6) {
        c = (char)(int)(57497235128533601L >> (5 - i) * 8 & 0xFF);
      }
      try
      {
        localStringBuilder.append(c);
        i += 1;
      }
      finally
      {
        String str2;
        do
        {
          String str1;
          str2 = localStringBuilder.toString();
          localStringBuilder.delete(0, localStringBuilder.length());
          localStringBuilder.append((b.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        } while (!localStringBuilder.toString().equals(ej(str2, localStringBuilder.toString())));
      }
    }
    str1 = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    localStringBuilder.append((b.class.hashCode() >>> 31 | 0x1) ^ 0x1);
    return !localStringBuilder.toString().equals(ej(str1, localStringBuilder.toString()));
    return false;
  }
  
  public static boolean cMU()
  {
    StringBuilder localStringBuilder = new StringBuilder(8);
    int i = 0;
    for (;;)
    {
      char c;
      if (i < 6) {
        c = (char)(int)(57778710156427883L >> (5 - i) * 8 & 0xFF);
      }
      try
      {
        localStringBuilder.append(c);
        i += 1;
      }
      finally
      {
        String str2;
        do
        {
          String str1;
          str2 = localStringBuilder.toString();
          localStringBuilder.delete(0, localStringBuilder.length());
          localStringBuilder.append((b.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        } while (!localStringBuilder.toString().equals(ej(str2, localStringBuilder.toString())));
      }
    }
    str1 = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    localStringBuilder.append((b.class.hashCode() >>> 31 | 0x1) ^ 0x1);
    return !localStringBuilder.toString().equals(ej(str1, localStringBuilder.toString()));
    return false;
  }
  
  public static boolean cMV()
  {
    StringBuilder localStringBuilder = new StringBuilder(8);
    int i = 0;
    for (;;)
    {
      char c;
      if (i < 6) {
        c = (char)(int)(65941484396629365L >> (5 - i) * 8 & 0xFF);
      }
      try
      {
        localStringBuilder.append(c);
        i += 1;
      }
      finally
      {
        String str2;
        do
        {
          String str1;
          str2 = localStringBuilder.toString();
          localStringBuilder.delete(0, localStringBuilder.length());
          localStringBuilder.append((b.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        } while (!localStringBuilder.toString().equals(ej(str2, localStringBuilder.toString())));
      }
    }
    str1 = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    localStringBuilder.append((b.class.hashCode() >>> 31 | 0x1) ^ 0x1);
    return !localStringBuilder.toString().equals(ej(str1, localStringBuilder.toString()));
    return false;
  }
  
  private static String ej(String paramString1, String paramString2)
  {
    Object localObject = com.tencent.mm.model.c.c.IX().fJ("100327");
    if (!((com.tencent.mm.storage.c)localObject).isValid()) {
      y.w("MicroMsg.WalletPayHelper", "check point 1, explained by src code.");
    }
    do
    {
      return paramString2;
      localObject = ((com.tencent.mm.storage.c)localObject).ctr();
      if (localObject == null)
      {
        y.w("MicroMsg.WalletPayHelper", "check point 2, explained by src code.");
        return paramString2;
      }
      paramString1 = (String)((Map)localObject).get(paramString1);
    } while ((paramString1 == null) || (paramString1.length() <= 0));
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.f.b
 * JD-Core Version:    0.7.0.1
 */