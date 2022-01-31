package com.tencent.mm.sdk.platformtools;

public class FLock
{
  private volatile int WT;
  
  private void free()
  {
    try
    {
      if (this.WT != -1)
      {
        nativeFree(this.WT);
        this.WT = -1;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static native int nativeFree(int paramInt);
  
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
        int i = this.WT;
        if (i == -1) {
          return;
        }
        try
        {
          i = nativeUnlock(this.WT);
          switch (i)
          {
          case 9: 
            throw new IllegalStateException("other err: " + i);
          }
        }
        finally
        {
          free();
        }
        throw new IllegalArgumentException(this.WT + " is not a valid fd.");
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