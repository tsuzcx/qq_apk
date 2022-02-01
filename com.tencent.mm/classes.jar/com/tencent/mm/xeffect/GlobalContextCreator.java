package com.tencent.mm.xeffect;

import android.opengl.EGL14;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GlobalContextCreator
{
  public static boolean bCz(String paramString)
  {
    AppMethodBeat.i(194527);
    if (EGL14.eglGetCurrentContext() == EGL14.EGL_NO_CONTEXT)
    {
      XEffectLog.e("GlobalContextCreator", "checkCreateGlobalContext, current thread does not have gl context!", new Object[0]);
      AppMethodBeat.o(194527);
      return false;
    }
    boolean bool = nCheckCreateGlobalContext(paramString);
    AppMethodBeat.o(194527);
    return bool;
  }
  
  public static void ijW()
  {
    AppMethodBeat.i(194528);
    nDestroyGlobalContext();
    AppMethodBeat.o(194528);
  }
  
  private static native boolean nCheckCreateGlobalContext(String paramString);
  
  private static native void nDestroyGlobalContext();
  
  private static native boolean nIsContextReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.GlobalContextCreator
 * JD-Core Version:    0.7.0.1
 */