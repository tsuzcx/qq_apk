package com.tencent.mm.sdk.platformtools;

public class FLock
{
  private volatile int YV;
  
  static
  {
    try
    {
      System.loadLibrary("wechatcommon");
      return;
    }
    catch (Throwable localThrowable)
    {
      f.a("MicroMsg.FLock", localThrowable, "fail to load so.", new Object[0]);
    }
  }
  
  private void free()
  {
    try
    {
      if (this.YV != -1)
      {
        nativeFree(this.YV);
        this.YV = -1;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static native void nativeFree(int paramInt);
  
  private static native int nativeInit(String paramString);
  
  private static native int nativeLockRead(int paramInt, boolean paramBoolean);
  
  private static native int nativeLockWrite(int paramInt, boolean paramBoolean);
  
  private static native int nativeUnlock(int paramInt);
  
  private void unlock()
  {
    for (;;)
    {
      try
      {
        int i = this.YV;
        if (i == -1) {
          return;
        }
        try
        {
          i = nativeUnlock(this.YV);
          switch (i)
          {
          case 9: 
            throw new IllegalStateException("other err: ".concat(String.valueOf(i)));
          }
        }
        finally
        {
          free();
        }
        throw new IllegalArgumentException(this.YV + " is not a valid fd.");
      }
      finally {}
      throw new IllegalStateException("bad operation.");
      free();
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FLock
 * JD-Core Version:    0.7.0.1
 */