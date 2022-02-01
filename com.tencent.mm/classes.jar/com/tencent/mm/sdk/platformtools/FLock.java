package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import java.io.IOException;

public class FLock
{
  private volatile int ETB;
  private e fGL;
  
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
      ad.printErrStackTrace("MicroMsg.FLock", localThrowable, "fail to load so.", new Object[0]);
      AppMethodBeat.o(125222);
    }
  }
  
  private FLock(e parame)
  {
    AppMethodBeat.i(175410);
    this.fGL = null;
    this.ETB = -1;
    if (!parame.exists()) {}
    while (parame.isFile()) {
      try
      {
        parame.createNewFile();
        this.fGL = parame;
        AppMethodBeat.o(175410);
        return;
      }
      catch (IOException parame)
      {
        parame = new IllegalStateException(parame);
        AppMethodBeat.o(175410);
        throw parame;
      }
    }
    parame = new IllegalArgumentException("target is not a file.");
    AppMethodBeat.o(175410);
    throw parame;
  }
  
  public FLock(String paramString)
  {
    this(new e(paramString));
    AppMethodBeat.i(125213);
    AppMethodBeat.o(125213);
  }
  
  private void free()
  {
    try
    {
      AppMethodBeat.i(125217);
      if (this.ETB != -1)
      {
        nativeFree(this.ETB);
        this.ETB = -1;
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
    //   2: ldc 87
    //   4: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 50	com/tencent/mm/sdk/platformtools/FLock:fGL	Lcom/tencent/mm/vfs/e;
    //   11: invokevirtual 58	com/tencent/mm/vfs/e:exists	()Z
    //   14: istore_2
    //   15: iload_2
    //   16: ifne +16 -> 32
    //   19: aload_0
    //   20: getfield 50	com/tencent/mm/sdk/platformtools/FLock:fGL	Lcom/tencent/mm/vfs/e;
    //   23: invokevirtual 61	com/tencent/mm/vfs/e:createNewFile	()Z
    //   26: pop
    //   27: aload_0
    //   28: iconst_m1
    //   29: putfield 52	com/tencent/mm/sdk/platformtools/FLock:ETB	I
    //   32: aload_0
    //   33: getfield 52	com/tencent/mm/sdk/platformtools/FLock:ETB	I
    //   36: iconst_m1
    //   37: if_icmpne +20 -> 57
    //   40: aload_0
    //   41: aload_0
    //   42: getfield 50	com/tencent/mm/sdk/platformtools/FLock:fGL	Lcom/tencent/mm/vfs/e;
    //   45: invokevirtual 91	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   48: invokestatic 97	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   51: invokestatic 101	com/tencent/mm/sdk/platformtools/FLock:nativeInit	(Ljava/lang/String;)I
    //   54: putfield 52	com/tencent/mm/sdk/platformtools/FLock:ETB	I
    //   57: aload_0
    //   58: getfield 52	com/tencent/mm/sdk/platformtools/FLock:ETB	I
    //   61: istore_1
    //   62: ldc 87
    //   64: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final boolean eFe()
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
  
  public final void eFf()
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
  
  protected void finalize()
  {
    AppMethodBeat.i(125215);
    super.finalize();
    unlock();
    AppMethodBeat.o(125215);
  }
  
  public final void lockRead()
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
  
  public final void unlock()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(125221);
        if (this.ETB == -1)
        {
          AppMethodBeat.o(125221);
          return;
        }
        try
        {
          int i = nativeUnlock(this.ETB);
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
        localObject3 = new IllegalArgumentException(this.ETB + " is not a valid fd.");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.FLock
 * JD-Core Version:    0.7.0.1
 */