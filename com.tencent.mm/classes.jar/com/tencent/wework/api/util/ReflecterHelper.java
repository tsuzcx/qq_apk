package com.tencent.wework.api.util;

import java.lang.reflect.Constructor;

public final class ReflecterHelper
{
  public static Object newInstance(String paramString)
  {
    paramString = Class.forName(paramString).getDeclaredConstructor(null);
    paramString.setAccessible(true);
    return paramString.newInstance(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.wework.api.util.ReflecterHelper
 * JD-Core Version:    0.7.0.1
 */