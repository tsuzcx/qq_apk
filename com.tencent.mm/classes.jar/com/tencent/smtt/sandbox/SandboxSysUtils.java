package com.tencent.smtt.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SandboxSysUtils
{
  private static final String TAG = "SandboxSysUtils";
  private static Boolean sLowEndDevice = null;
  
  @CalledByNative
  public static boolean isLowEndDevice()
  {
    try
    {
      AppMethodBeat.i(53765);
      if (sLowEndDevice == null)
      {
        RuntimeException localRuntimeException = new RuntimeException("has not set SandboxBuildInfo");
        AppMethodBeat.o(53765);
        throw localRuntimeException;
      }
    }
    finally {}
    boolean bool = sLowEndDevice.booleanValue();
    AppMethodBeat.o(53765);
    return bool;
  }
  
  public static void setIsLowEndDevice(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(53766);
      sLowEndDevice = Boolean.valueOf(paramBoolean);
      AppMethodBeat.o(53766);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sandbox.SandboxSysUtils
 * JD-Core Version:    0.7.0.1
 */