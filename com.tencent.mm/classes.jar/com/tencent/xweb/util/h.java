package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;

public final class h
{
  private static ClassLoader a(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(183533);
    paramString1 = new DexClassLoader(paramString1, paramString2, paramString3, paramClassLoader);
    AppMethodBeat.o(183533);
    return paramString1;
  }
  
  public static ClassLoader bf(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(183532);
    paramString1 = a(paramString1, paramString2, paramString3, ClassLoader.getSystemClassLoader());
    AppMethodBeat.o(183532);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.util.h
 * JD-Core Version:    0.7.0.1
 */