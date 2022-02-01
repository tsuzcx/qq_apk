package com.tencent.mm.xeffect;

import android.opengl.EGL14;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GlobalContextCreator
{
  public static boolean bpC(String paramString)
  {
    AppMethodBeat.i(236739);
    if (EGL14.eglGetCurrentContext() == EGL14.EGL_NO_CONTEXT)
    {
      XEffectLog.e("GlobalContextCreator", "checkCreateGlobalContext, current thread does not have gl context!", new Object[0]);
      AppMethodBeat.o(236739);
      return false;
    }
    boolean bool = nCheckCreateGlobalContext(paramString);
    AppMethodBeat.o(236739);
    return bool;
  }
  
  public static void hir()
  {
    AppMethodBeat.i(236740);
    nDestroyGlobalContext();
    AppMethodBeat.o(236740);
  }
  
  private static native boolean nCheckCreateGlobalContext(String paramString);
  
  private static native void nDestroyGlobalContext();
  
  private static native boolean nIsContextReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.GlobalContextCreator
 * JD-Core Version:    0.7.0.1
 */