package com.tencent.mm.sdk.platformtools;

import java.io.File;
import java.io.IOException;

public class FLock
{
  private File fDw = null;
  private volatile int uep = -1;
  
  public FLock(File paramFile)
  {
    if (!paramFile.exists()) {}
    while (paramFile.isFile()) {
      try
      {
        paramFile.createNewFile();
        this.fDw = paramFile;
        return;
      }
      catch (IOException paramFile)
      {
        throw new IllegalStateException(paramFile);
      }
    }
    throw new IllegalArgumentException("target is not a file.");
  }
  
  public FLock(String paramString)
  {
    this(new File(paramString));
  }
  
  private void free()
  {
    try
    {
      if (this.uep != -1)
      {
        nativeFree(this.uep);
        this.uep = -1;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private int init()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	com/tencent/mm/sdk/platformtools/FLock:fDw	Ljava/io/File;
    //   6: invokevirtual 25	java/io/File:exists	()Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifne +16 -> 27
    //   14: aload_0
    //   15: getfield 17	com/tencent/mm/sdk/platformtools/FLock:fDw	Ljava/io/File;
    //   18: invokevirtual 28	java/io/File:createNewFile	()Z
    //   21: pop
    //   22: aload_0
    //   23: iconst_m1
    //   24: putfield 19	com/tencent/mm/sdk/platformtools/FLock:uep	I
    //   27: aload_0
    //   28: getfield 19	com/tencent/mm/sdk/platformtools/FLock:uep	I
    //   31: iconst_m1
    //   32: if_icmpne +17 -> 49
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 17	com/tencent/mm/sdk/platformtools/FLock:fDw	Ljava/io/File;
    //   40: invokevirtual 58	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   43: invokestatic 62	com/tencent/mm/sdk/platformtools/FLock:nativeInit	(Ljava/lang/String;)I
    //   46: putfield 19	com/tencent/mm/sdk/platformtools/FLock:uep	I
    //   49: aload_0
    //   50: getfield 19	com/tencent/mm/sdk/platformtools/FLock:uep	I
    //   53: istore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: iload_1
    //   57: ireturn
    //   58: astore_3
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_3
    //   62: athrow
    //   63: astore_3
    //   64: goto -42 -> 22
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	FLock
    //   53	4	1	i	int
    //   9	2	2	bool	boolean
    //   58	4	3	localObject	Object
    //   63	1	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	10	58	finally
    //   14	22	58	finally
    //   22	27	58	finally
    //   27	49	58	finally
    //   49	54	58	finally
    //   14	22	63	java/io/IOException
  }
  
  private static native int nativeFree(int paramInt);
  
  private static native int nativeInit(String paramString);
  
  private static native int nativeLockRead(int paramInt, boolean paramBoolean);
  
  private static native int nativeLockWrite(int paramInt, boolean paramBoolean);
  
  private static native int nativeUnlock(int paramInt);
  
  public final boolean cqt()
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        int i = init();
        int j = nativeLockWrite(i, false);
        boolean bool1 = bool2;
        switch (j)
        {
        default: 
          bool1 = true;
        case 11: 
          return bool1;
        }
      }
      finally {}
      throw new IllegalStateException("bad file descriptor.");
      throw new IllegalStateException("bad operation.");
      throw new IllegalStateException("kernel lock spaces ran out.");
      try
      {
        Thread.sleep(0L);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public final void cqu()
  {
    for (;;)
    {
      try
      {
        int i = init();
        int j = nativeLockWrite(i, true);
        switch (j)
        {
        default: 
          return;
        }
      }
      finally {}
      throw new IllegalStateException("bad file descriptor.");
      throw new IllegalStateException("bad operation.");
      throw new IllegalStateException("kernel lock spaces ran out.");
      try
      {
        Thread.sleep(0L);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    unlock();
  }
  
  public final void lockRead()
  {
    for (;;)
    {
      try
      {
        int i = init();
        int j = nativeLockRead(i, true);
        switch (j)
        {
        default: 
          return;
        }
      }
      finally {}
      throw new IllegalStateException("bad file descriptor.");
      throw new IllegalStateException("bad operation.");
      throw new IllegalStateException("kernel lock spaces ran out.");
      try
      {
        Thread.sleep(0L);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public final void unlock()
  {
    for (;;)
    {
      try
      {
        int i = this.uep;
        if (i == -1) {
          return;
        }
        try
        {
          i = nativeUnlock(this.uep);
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
        throw new IllegalArgumentException(this.uep + " is not a valid fd.");
      }
      finally {}
      throw new IllegalStateException("bad operation.");
      free();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FLock
 * JD-Core Version:    0.7.0.1
 */