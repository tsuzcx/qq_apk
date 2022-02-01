package com.tencent.xweb.pinus.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class JNIUtils
{
  private static Object sClassLoader;
  
  static
  {
    AppMethodBeat.i(213474);
    if (!JNIUtils.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(213474);
      return;
    }
  }
  
  public static Object getClassLoader()
  {
    return sClassLoader;
  }
  
  public static void setClassLoader(Object paramObject)
  {
    AppMethodBeat.i(213467);
    if ((!$assertionsDisabled) && (sClassLoader != null))
    {
      paramObject = new AssertionError();
      AppMethodBeat.o(213467);
      throw paramObject;
    }
    sClassLoader = paramObject;
    AppMethodBeat.o(213467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.JNIUtils
 * JD-Core Version:    0.7.0.1
 */