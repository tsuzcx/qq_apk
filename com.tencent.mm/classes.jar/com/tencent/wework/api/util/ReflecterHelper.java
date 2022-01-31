package com.tencent.wework.api.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

public final class ReflecterHelper
{
  public static Object newInstance(String paramString)
  {
    AppMethodBeat.i(80515);
    paramString = Class.forName(paramString).getDeclaredConstructor(null);
    paramString.setAccessible(true);
    paramString = paramString.newInstance(null);
    AppMethodBeat.o(80515);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.util.ReflecterHelper
 * JD-Core Version:    0.7.0.1
 */