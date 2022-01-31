package com.tencent.smtt.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SandboxBuildInfo
{
  private static final String TAG = "SandboxBuildInfo";
  private static String[] mSandboxBuildInfo = null;
  
  @CalledByNative
  public static String[] getAll()
  {
    AppMethodBeat.i(139021);
    if (mSandboxBuildInfo == null)
    {
      localObject = new RuntimeException("has not set SandboxBuildInfo");
      AppMethodBeat.o(139021);
      throw ((Throwable)localObject);
    }
    Object localObject = mSandboxBuildInfo;
    AppMethodBeat.o(139021);
    return localObject;
  }
  
  public static void setSandboxBuildInfo(String[] paramArrayOfString)
  {
    mSandboxBuildInfo = paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sandbox.SandboxBuildInfo
 * JD-Core Version:    0.7.0.1
 */