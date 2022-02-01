package com.tencent.xweb.pinus.sdk.process;

import android.os.ParcelFileDescriptor;

public class SandBoxHelper
{
  public static SandboxListener listener;
  
  public static void setSandboxListener(SandboxListener paramSandboxListener)
  {
    listener = paramSandboxListener;
  }
  
  public static abstract interface SandboxListener
  {
    public abstract void setCrashRecordFileDescriptor(ParcelFileDescriptor paramParcelFileDescriptor1, ParcelFileDescriptor paramParcelFileDescriptor2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.process.SandBoxHelper
 * JD-Core Version:    0.7.0.1
 */