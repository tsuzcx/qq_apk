package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public class FLock
{
  private File gVL;
  private volatile int ymQ;
  
  static
  {
    AppMethodBeat.i(115187);
    try
    {
      System.loadLibrary("wechatcommon");
      AppMethodBeat.o(115187);
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.FLock", localThrowable, "fail to load so.", new Object[0]);
      AppMethodBeat.o(115187);
    }
  }
  
  public FLock(File paramFile)
  {
    AppMethodBeat.i(115179);
    this.gVL = null;
    this.ymQ = -1;
    if (!paramFile.exists()) {}
    while (paramFile.isFile()) {
      try
      {
        paramFile.createNewFile();
        this.gVL = paramFile;
        AppMethodBeat.o(115179);
        return;
      }
      catch (IOException paramFile)
      {
        paramFile = new IllegalStateException(paramFile);
        AppMethodBeat.o(115179);
        throw paramFile;
      }
    }
    paramFile = new IllegalArgumentException("target is not a file.");
    AppMethodBeat.o(115179);
    throw paramFile;
  }
  
  public FLock(String paramString)
  {
    this(new File(paramString));
    AppMethodBeat.i(115178);
    AppMethodBeat.o(115178);
  }
  
  private void free()
  {
    try
    {
      AppMethodBeat.i(115182);
      if (this.ymQ != -1)
      {
        nativeFree(this.ymQ);
        this.ymQ = -1;
      }
      AppMethodBeat.o(115182);
      return;
    }
    finally {}
  }
  
  /* Error */
  private int init()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 87
    //   4: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 50	com/tencent/mm/sdk/platformtools/FLock:gVL	Ljava/io/File;
    //   11: invokevirtual 58	java/io/File:exists	()Z
    //   14: istore_2
    //   15: iload_2
    //   16: ifne +16 -> 32
    //   19: aload_0
    //   20: getfield 50	com/tencent/mm/sdk/platformtools/FLock:gVL	Ljava/io/File;
    //   23: invokevirtual 61	java/io/File:createNewFile	()Z
    //   26: pop
    //   27: aload_0
    //   28: iconst_m1
    //   29: putfield 52	com/tencent/mm/sdk/platformtools/FLock:ymQ	I
    //   32: aload_0
    //   33: getfield 52	com/tencent/mm/sdk/platformtools/FLock:ymQ	I
    //   36: iconst_m1
    //   37: if_icmpne +17 -> 54
    //   40: aload_0
    //   41: aload_0
    //   42: getfield 50	com/tencent/mm/sdk/platformtools/FLock:gVL	Ljava/io/File;
    //   45: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   48: invokestatic 95	com/tencent/mm/sdk/platformtools/FLock:nativeInit	(Ljava/lang/String;)I
    //   51: putfield 52	com/tencent/mm/sdk/platformtools/FLock:ymQ	I
    //   54: aload_0
    //   55: getfield 52	com/tencent/mm/sdk/platformtools/FLock:ymQ	I
    //   58: istore_1
    //   59: ldc 87
    //   61: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: monitorexit
    //   66: iload_1
    //   67: ireturn
    //   68: astore_3
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_3
    //   72: athrow
    //   73: astore_3
    //   74: goto -47 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	FLock
    //   58	9	1	i	int
    //   14	2	2	bool	boolean
    //   68	4	3	localObject	Object
    //   73	1	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	15	68	finally
    //   19	27	68	finally
    //   27	32	68	finally
    //   32	54	68	finally
    //   54	64	68	finally
    //   19	27	73	java/io/IOException
  }
  
  private static native void nativeFree(int paramInt);
  
  private static native int nativeInit(String paramString);
  
  private static native int nativeLockRead(int paramInt, boolean paramBoolean);
  
  private static native int nativeLockWrite(int paramInt, boolean paramBoolean);
  
  private static native int nativeUnlock(int paramInt);
  
  public final boolean dsq()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(115184);
        int i = init();
        switch (nativeLockWrite(i, false))
        {
        case 9: 
          bool = true;
          AppMethodBeat.o(115184);
          return bool;
        }
      }
      finally {}
      IllegalStateException localIllegalStateException1 = new IllegalStateException("bad file descriptor.");
      AppMethodBeat.o(115184);
      throw localIllegalStateException1;
      IllegalStateException localIllegalStateException2 = new IllegalStateException("bad operation.");
      AppMethodBeat.o(115184);
      throw localIllegalStateException2;
      localIllegalStateException2 = new IllegalStateException("kernel lock spaces ran out.");
      AppMethodBeat.o(115184);
      throw localIllegalStateException2;
      try
      {
        Thread.sleep(0L);
      }
      catch (InterruptedException localInterruptedException) {}
      continue;
      AppMethodBeat.o(115184);
    }
  }
  
  public final void dsr()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(115185);
        int i = init();
        switch (nativeLockWrite(i, true))
        {
        case 9: 
          AppMethodBeat.o(115185);
          return;
        }
      }
      finally {}
      IllegalStateException localIllegalStateException1 = new IllegalStateException("bad file descriptor.");
      AppMethodBeat.o(115185);
      throw localIllegalStateException1;
      IllegalStateException localIllegalStateException2 = new IllegalStateException("bad operation.");
      AppMethodBeat.o(115185);
      throw localIllegalStateException2;
      localIllegalStateException2 = new IllegalStateException("kernel lock spaces ran out.");
      AppMethodBeat.o(115185);
      throw localIllegalStateException2;
      try
      {
        Thread.sleep(0L);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(115180);
    super.finalize();
    unlock();
    AppMethodBeat.o(115180);
  }
  
  public final void lockRead()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(115183);
        int i = init();
        switch (nativeLockRead(i, true))
        {
        case 9: 
          AppMethodBeat.o(115183);
          return;
        }
      }
      finally {}
      IllegalStateException localIllegalStateException1 = new IllegalStateException("bad file descriptor.");
      AppMethodBeat.o(115183);
      throw localIllegalStateException1;
      IllegalStateException localIllegalStateException2 = new IllegalStateException("bad operation.");
      AppMethodBeat.o(115183);
      throw localIllegalStateException2;
      localIllegalStateException2 = new IllegalStateException("kernel lock spaces ran out.");
      AppMethodBeat.o(115183);
      throw localIllegalStateException2;
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
        AppMethodBeat.i(115186);
        if (this.ymQ == -1)
        {
          AppMethodBeat.o(115186);
          return;
        }
        try
        {
          int i = nativeUnlock(this.ymQ);
          switch (i)
          {
          case 9: 
            IllegalStateException localIllegalStateException = new IllegalStateException("other err: ".concat(String.valueOf(i)));
            AppMethodBeat.o(115186);
            throw localIllegalStateException;
          }
        }
        finally
        {
          free();
          AppMethodBeat.o(115186);
        }
        localObject3 = new IllegalArgumentException(this.ymQ + " is not a valid fd.");
      }
      finally {}
      AppMethodBeat.o(115186);
      throw ((Throwable)localObject3);
      Object localObject3 = new IllegalStateException("bad operation.");
      AppMethodBeat.o(115186);
      throw ((Throwable)localObject3);
      free();
      AppMethodBeat.o(115186);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FLock
 * JD-Core Version:    0.7.0.1
 */