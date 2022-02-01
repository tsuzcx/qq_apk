package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.u;
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
  private byte _hellAccFlag_;
  private volatile int mFD;
  private u mFile;
  
  static
  {
    AppMethodBeat.i(125222);
    try
    {
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("wechatcommon");
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/sdk/platformtools/FLock", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/sdk/platformtools/FLock", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      AppMethodBeat.o(125222);
      return;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.FLock", localThrowable, "fail to load so.", new Object[0]);
      AppMethodBeat.o(125222);
    }
  }
  
  public FLock(u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(244013);
    this.mFile = null;
    this.mFD = -1;
    if (!paramu.jKS()) {
      if (!paramBoolean) {}
    }
    while (paramu.jKV())
    {
      try
      {
        paramu.jKZ();
        this.mFile = paramu;
        AppMethodBeat.o(244013);
        return;
      }
      catch (IOException paramu)
      {
        paramu = new IllegalStateException(paramu);
        AppMethodBeat.o(244013);
        throw paramu;
      }
      paramu = new IllegalArgumentException("target is not exists or create failed.");
      AppMethodBeat.o(244013);
      throw paramu;
    }
    paramu = new IllegalArgumentException("target is not a file.");
    AppMethodBeat.o(244013);
    throw paramu;
  }
  
  public FLock(String paramString, boolean paramBoolean)
  {
    this(new u(paramString), paramBoolean);
    AppMethodBeat.i(243999);
    AppMethodBeat.o(243999);
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
    //   2: ldc 138
    //   4: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 98	com/tencent/mm/sdk/platformtools/FLock:mFile	Lcom/tencent/mm/vfs/u;
    //   11: invokevirtual 106	com/tencent/mm/vfs/u:jKS	()Z
    //   14: istore_2
    //   15: iload_2
    //   16: ifne +16 -> 32
    //   19: aload_0
    //   20: getfield 98	com/tencent/mm/sdk/platformtools/FLock:mFile	Lcom/tencent/mm/vfs/u;
    //   23: invokevirtual 109	com/tencent/mm/vfs/u:jKZ	()Z
    //   26: pop
    //   27: aload_0
    //   28: iconst_m1
    //   29: putfield 100	com/tencent/mm/sdk/platformtools/FLock:mFD	I
    //   32: aload_0
    //   33: getfield 100	com/tencent/mm/sdk/platformtools/FLock:mFD	I
    //   36: iconst_m1
    //   37: if_icmpne +20 -> 57
    //   40: aload_0
    //   41: aload_0
    //   42: getfield 98	com/tencent/mm/sdk/platformtools/FLock:mFile	Lcom/tencent/mm/vfs/u;
    //   45: invokevirtual 142	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   48: invokestatic 148	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   51: invokestatic 152	com/tencent/mm/sdk/platformtools/FLock:nativeInit	(Ljava/lang/String;)I
    //   54: putfield 100	com/tencent/mm/sdk/platformtools/FLock:mFD	I
    //   57: aload_0
    //   58: getfield 100	com/tencent/mm/sdk/platformtools/FLock:mFD	I
    //   61: istore_1
    //   62: ldc 138
    //   64: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_0
    //   68: monitorexit
    //   69: iload_1
    //   70: ireturn
    //   71: astore_3
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_3
    //   75: athrow
    //   76: astore_3
    //   77: goto -50 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	FLock
    //   61	9	1	i	int
    //   14	2	2	bool	boolean
    //   71	4	3	localObject	Object
    //   76	1	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	15	71	finally
    //   19	27	71	finally
    //   27	32	71	finally
    //   32	57	71	finally
    //   57	67	71	finally
    //   19	27	76	java/io/IOException
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
        AppMethodBeat.i(244094);
        int i = init();
        switch (nativeLockRead(i, false))
        {
        case 9: 
          bool = true;
          AppMethodBeat.o(244094);
          return bool;
        }
      }
      finally {}
      IllegalStateException localIllegalStateException1 = new IllegalStateException("bad file descriptor.");
      AppMethodBeat.o(244094);
      throw localIllegalStateException1;
      IllegalStateException localIllegalStateException2 = new IllegalStateException("bad operation.");
      AppMethodBeat.o(244094);
      throw localIllegalStateException2;
      localIllegalStateException2 = new IllegalStateException("kernel lock spaces ran out.");
      AppMethodBeat.o(244094);
      throw localIllegalStateException2;
      try
      {
        Thread.sleep(0L);
      }
      catch (InterruptedException localInterruptedException) {}
      continue;
      AppMethodBeat.o(244094);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FLock
 * JD-Core Version:    0.7.0.1
 */