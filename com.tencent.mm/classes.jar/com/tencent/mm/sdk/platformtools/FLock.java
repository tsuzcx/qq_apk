package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.q;
import java.io.IOException;

public class FLock
{
  private static final int ERRNO_EBADF = 9;
  private static final int ERRNO_EINTR = 4;
  private static final int ERRNO_EINVAL = 22;
  private static final int ERRNO_ENOLCK = 46;
  private static final int ERRNO_EWOULDBLOCK = 11;
  private static final int ERRNO_NOERR = 0;
  private static final String TAG = "MicroMsg.FLock";
  private volatile int mFD;
  private q mFile;
  
  static
  {
    AppMethodBeat.i(125222);
    try
    {
      System.loadLibrary("wechatcommon");
      AppMethodBeat.o(125222);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.FLock", localThrowable, "fail to load so.", new Object[0]);
      AppMethodBeat.o(125222);
    }
  }
  
  public FLock(q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(249247);
    this.mFile = null;
    this.mFD = -1;
    if (!paramq.ifE()) {
      if (!paramBoolean) {}
    }
    while (paramq.ifH())
    {
      try
      {
        paramq.ifM();
        this.mFile = paramq;
        AppMethodBeat.o(249247);
        return;
      }
      catch (IOException paramq)
      {
        paramq = new IllegalStateException(paramq);
        AppMethodBeat.o(249247);
        throw paramq;
      }
      paramq = new IllegalArgumentException("target is not exists or create failed.");
      AppMethodBeat.o(249247);
      throw paramq;
    }
    paramq = new IllegalArgumentException("target is not a file.");
    AppMethodBeat.o(249247);
    throw paramq;
  }
  
  public FLock(String paramString, boolean paramBoolean)
  {
    this(new q(paramString), paramBoolean);
    AppMethodBeat.i(249245);
    AppMethodBeat.o(249245);
  }
  
  private void free()
  {
    try
    {
      AppMethodBeat.i(125217);
      if (this.mFD != -1)
      {
        nativeFree(this.mFD);
        this.mFD = -1;
      }
      AppMethodBeat.o(125217);
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
    //   2: ldc 104
    //   4: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 64	com/tencent/mm/sdk/platformtools/FLock:mFile	Lcom/tencent/mm/vfs/q;
    //   11: invokevirtual 72	com/tencent/mm/vfs/q:ifE	()Z
    //   14: istore_2
    //   15: iload_2
    //   16: ifne +16 -> 32
    //   19: aload_0
    //   20: getfield 64	com/tencent/mm/sdk/platformtools/FLock:mFile	Lcom/tencent/mm/vfs/q;
    //   23: invokevirtual 75	com/tencent/mm/vfs/q:ifM	()Z
    //   26: pop
    //   27: aload_0
    //   28: iconst_m1
    //   29: putfield 66	com/tencent/mm/sdk/platformtools/FLock:mFD	I
    //   32: aload_0
    //   33: getfield 66	com/tencent/mm/sdk/platformtools/FLock:mFD	I
    //   36: iconst_m1
    //   37: if_icmpne +17 -> 54
    //   40: aload_0
    //   41: aload_0
    //   42: getfield 64	com/tencent/mm/sdk/platformtools/FLock:mFile	Lcom/tencent/mm/vfs/q;
    //   45: invokevirtual 108	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   48: invokestatic 112	com/tencent/mm/sdk/platformtools/FLock:nativeInit	(Ljava/lang/String;)I
    //   51: putfield 66	com/tencent/mm/sdk/platformtools/FLock:mFD	I
    //   54: aload_0
    //   55: getfield 66	com/tencent/mm/sdk/platformtools/FLock:mFD	I
    //   58: istore_1
    //   59: ldc 104
    //   61: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  protected void finalize()
  {
    AppMethodBeat.i(125215);
    super.finalize();
    unlock();
    AppMethodBeat.o(125215);
  }
  
  public void lockRead()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(125218);
        int i = init();
        switch (nativeLockRead(i, true))
        {
        case 9: 
          AppMethodBeat.o(125218);
          return;
        }
      }
      finally {}
      IllegalStateException localIllegalStateException1 = new IllegalStateException("bad file descriptor.");
      AppMethodBeat.o(125218);
      throw localIllegalStateException1;
      IllegalStateException localIllegalStateException2 = new IllegalStateException("bad operation.");
      AppMethodBeat.o(125218);
      throw localIllegalStateException2;
      localIllegalStateException2 = new IllegalStateException("kernel lock spaces ran out.");
      AppMethodBeat.o(125218);
      throw localIllegalStateException2;
      try
      {
        Thread.sleep(0L);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public void lockWrite()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(125220);
        int i = init();
        switch (nativeLockWrite(i, true))
        {
        case 9: 
          AppMethodBeat.o(125220);
          return;
        }
      }
      finally {}
      IllegalStateException localIllegalStateException1 = new IllegalStateException("bad file descriptor.");
      AppMethodBeat.o(125220);
      throw localIllegalStateException1;
      IllegalStateException localIllegalStateException2 = new IllegalStateException("bad operation.");
      AppMethodBeat.o(125220);
      throw localIllegalStateException2;
      localIllegalStateException2 = new IllegalStateException("kernel lock spaces ran out.");
      AppMethodBeat.o(125220);
      throw localIllegalStateException2;
      try
      {
        Thread.sleep(0L);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public boolean tryLockRead()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(249249);
        int i = init();
        switch (nativeLockRead(i, false))
        {
        case 9: 
          bool = true;
          AppMethodBeat.o(249249);
          return bool;
        }
      }
      finally {}
      IllegalStateException localIllegalStateException1 = new IllegalStateException("bad file descriptor.");
      AppMethodBeat.o(249249);
      throw localIllegalStateException1;
      IllegalStateException localIllegalStateException2 = new IllegalStateException("bad operation.");
      AppMethodBeat.o(249249);
      throw localIllegalStateException2;
      localIllegalStateException2 = new IllegalStateException("kernel lock spaces ran out.");
      AppMethodBeat.o(249249);
      throw localIllegalStateException2;
      try
      {
        Thread.sleep(0L);
      }
      catch (InterruptedException localInterruptedException) {}
      continue;
      AppMethodBeat.o(249249);
    }
  }
  
  public boolean tryLockWrite()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(125219);
        int i = init();
        switch (nativeLockWrite(i, false))
        {
        case 9: 
          bool = true;
          AppMethodBeat.o(125219);
          return bool;
        }
      }
      finally {}
      IllegalStateException localIllegalStateException1 = new IllegalStateException("bad file descriptor.");
      AppMethodBeat.o(125219);
      throw localIllegalStateException1;
      IllegalStateException localIllegalStateException2 = new IllegalStateException("bad operation.");
      AppMethodBeat.o(125219);
      throw localIllegalStateException2;
      localIllegalStateException2 = new IllegalStateException("kernel lock spaces ran out.");
      AppMethodBeat.o(125219);
      throw localIllegalStateException2;
      try
      {
        Thread.sleep(0L);
      }
      catch (InterruptedException localInterruptedException) {}
      continue;
      AppMethodBeat.o(125219);
    }
  }
  
  public void unlock()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(125221);
        if (this.mFD == -1)
        {
          AppMethodBeat.o(125221);
          return;
        }
        try
        {
          int i = nativeUnlock(this.mFD);
          switch (i)
          {
          case 9: 
            IllegalStateException localIllegalStateException = new IllegalStateException("other err: ".concat(String.valueOf(i)));
            AppMethodBeat.o(125221);
            throw localIllegalStateException;
          }
        }
        finally
        {
          free();
          AppMethodBeat.o(125221);
        }
        localObject3 = new IllegalArgumentException(this.mFD + " is not a valid fd.");
      }
      finally {}
      AppMethodBeat.o(125221);
      throw ((Throwable)localObject3);
      Object localObject3 = new IllegalStateException("bad operation.");
      AppMethodBeat.o(125221);
      throw ((Throwable)localObject3);
      free();
      AppMethodBeat.o(125221);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FLock
 * JD-Core Version:    0.7.0.1
 */