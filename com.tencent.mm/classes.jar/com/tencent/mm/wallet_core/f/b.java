package com.tencent.mm.wallet_core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.d;
import java.util.Map;

public final class b
{
  public static boolean dSH()
  {
    AppMethodBeat.i(49164);
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
        if (localStringBuilder.toString().equals(fE(str2, localStringBuilder.toString()))) {
          break label175;
        }
        AppMethodBeat.o(49164);
        return true;
        AppMethodBeat.o(49164);
      }
    }
    str1 = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    localStringBuilder.append((b.class.hashCode() >>> 31 | 0x1) ^ 0x1);
    if (!localStringBuilder.toString().equals(fE(str1, localStringBuilder.toString())))
    {
      AppMethodBeat.o(49164);
      return true;
    }
    AppMethodBeat.o(49164);
    return false;
    label175:
    return false;
  }
  
  public static boolean dSI()
  {
    AppMethodBeat.i(49165);
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
        if (localStringBuilder.toString().equals(fE(str2, localStringBuilder.toString()))) {
          break label175;
        }
        AppMethodBeat.o(49165);
        return true;
        AppMethodBeat.o(49165);
      }
    }
    str1 = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    localStringBuilder.append((b.class.hashCode() >>> 31 | 0x1) ^ 0x1);
    if (!localStringBuilder.toString().equals(fE(str1, localStringBuilder.toString())))
    {
      AppMethodBeat.o(49165);
      return true;
    }
    AppMethodBeat.o(49165);
    return false;
    label175:
    return false;
  }
  
  public static boolean dSJ()
  {
    AppMethodBeat.i(49166);
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
        if (localStringBuilder.toString().equals(fE(str2, localStringBuilder.toString()))) {
          break label175;
        }
        AppMethodBeat.o(49166);
        return true;
        AppMethodBeat.o(49166);
      }
    }
    str1 = localStringBuilder.toString();
    localStringBuilder.delete(0, localStringBuilder.length());
    localStringBuilder.append((b.class.hashCode() >>> 31 | 0x1) ^ 0x1);
    if (!localStringBuilder.toString().equals(fE(str1, localStringBuilder.toString())))
    {
      AppMethodBeat.o(49166);
      return true;
    }
    AppMethodBeat.o(49166);
    return false;
    label175:
    return false;
  }
  
  private static String fE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49167);
    Object localObject = com.tencent.mm.model.c.c.abU().me("100327");
    if (!((com.tencent.mm.storage.c)localObject).isValid())
    {
      ab.w("MicroMsg.WalletPayHelper", "check point 1, explained by src code.");
      AppMethodBeat.o(49167);
      return paramString2;
    }
    localObject = ((com.tencent.mm.storage.c)localObject).dvN();
    if (localObject == null)
    {
      ab.w("MicroMsg.WalletPayHelper", "check point 2, explained by src code.");
      AppMethodBeat.o(49167);
      return paramString2;
    }
    paramString1 = (String)((Map)localObject).get(paramString1);
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      AppMethodBeat.o(49167);
      return paramString1;
    }
    AppMethodBeat.o(49167);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.f.b
 * JD-Core Version:    0.7.0.1
 */