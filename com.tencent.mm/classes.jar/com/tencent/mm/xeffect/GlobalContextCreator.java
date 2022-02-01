package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class GlobalContextCreator
{
  public static void jQe()
  {
    AppMethodBeat.i(234484);
    nDestroyGlobalContext();
    AppMethodBeat.o(234484);
  }
  
  private static native boolean nCheckCreateGlobalContext(String paramString);
  
  private static native void nDestroyGlobalContext();
  
  private static native boolean nIsContextReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.xeffect.GlobalContextCreator
 * JD-Core Version:    0.7.0.1
 */