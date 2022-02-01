package com.tencent.smtt.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SandboxBuildInfo
{
  private static final String TAG = "SandboxBuildInfo";
  private static String[] mSandboxBuildInfo = null;
  
  @CalledByNative
  public static String[] getAll()
  {
    AppMethodBeat.i(53816);
    if (mSandboxBuildInfo == null)
    {
      localObject = new RuntimeException("has not set SandboxBuildInfo");
      AppMethodBeat.o(53816);
      throw ((Throwable)localObject);
    }
    Object localObject = mSandboxBuildInfo;
    AppMethodBeat.o(53816);
    return localObject;
  }
  
  public static void setSandboxBuildInfo(String[] paramArrayOfString)
  {
    mSandboxBuildInfo = paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sandbox.SandboxBuildInfo
 * JD-Core Version:    0.7.0.1
 */