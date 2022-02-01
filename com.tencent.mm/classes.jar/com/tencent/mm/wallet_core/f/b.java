package com.tencent.mm.wallet_core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b
{
  public static boolean fRO()
  {
    AppMethodBeat.i(72882);
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
        String str1;
        String str2 = localStringBuilder.toString();
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append((b.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        if (localStringBuilder.toString().equals(ip(str2, localStringBuilder.toString()))) {
          break label175;
        }
        AppMethodBeat.o(72882);
        return true;
        AppMethodBeat.o(72882);
      }
    }
    str1 = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    localStringBuilder.append((b.class.hashCode() >>> 31 | 0x1) ^ 0x1);
    if (!localStringBuilder.toString().equals(ip(str1, localStringBuilder.toString())))
    {
      AppMethodBeat.o(72882);
      return true;
    }
    AppMethodBeat.o(72882);
    return false;
    label175:
    return false;
  }
  
  public static boolean fRP()
  {
    AppMethodBeat.i(72883);
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
        String str1;
        String str2 = localStringBuilder.toString();
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append((b.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        if (localStringBuilder.toString().equals(ip(str2, localStringBuilder.toString()))) {
          break label175;
        }
        AppMethodBeat.o(72883);
        return true;
        AppMethodBeat.o(72883);
      }
    }
    str1 = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    localStringBuilder.append((b.class.hashCode() >>> 31 | 0x1) ^ 0x1);
    if (!localStringBuilder.toString().equals(ip(str1, localStringBuilder.toString())))
    {
      AppMethodBeat.o(72883);
      return true;
    }
    AppMethodBeat.o(72883);
    return false;
    label175:
    return false;
  }
  
  public static boolean fRQ()
  {
    AppMethodBeat.i(72884);
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
        String str1;
        String str2 = localStringBuilder.toString();
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append((b.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        if (localStringBuilder.toString().equals(ip(str2, localStringBuilder.toString()))) {
          break label175;
        }
        AppMethodBeat.o(72884);
        return true;
        AppMethodBeat.o(72884);
      }
    }
    str1 = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    localStringBuilder.append((b.class.hashCode() >>> 31 | 0x1) ^ 0x1);
    if (!localStringBuilder.toString().equals(ip(str1, localStringBuilder.toString())))
    {
      AppMethodBeat.o(72884);
      return true;
    }
    AppMethodBeat.o(72884);
    return false;
    label175:
    return false;
  }
  
  private static String ip(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72885);
    Object localObject = com.tencent.mm.model.c.d.aDs().wz("100327");
    if (!((c)localObject).isValid())
    {
      ad.w("MicroMsg.WalletPayHelper", "check point 1, explained by src code.");
      AppMethodBeat.o(72885);
      return paramString2;
    }
    localObject = ((c)localObject).foF();
    if (localObject == null)
    {
      ad.w("MicroMsg.WalletPayHelper", "check point 2, explained by src code.");
      AppMethodBeat.o(72885);
      return paramString2;
    }
    paramString1 = (String)((Map)localObject).get(paramString1);
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      AppMethodBeat.o(72885);
      return paramString1;
    }
    AppMethodBeat.o(72885);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.f.b
 * JD-Core Version:    0.7.0.1
 */