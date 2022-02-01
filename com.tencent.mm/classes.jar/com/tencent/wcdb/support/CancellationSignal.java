package com.tencent.wcdb.support;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CancellationSignal
{
  private boolean mCancelInProgress;
  private boolean mIsCanceled;
  private OnCancelListener mOnCancelListener;
  private ICancellationSignal mRemote;
  
  public static ICancellationSignal createTransport()
  {
    AppMethodBeat.i(3382);
    Transport localTransport = new Transport(null);
    AppMethodBeat.o(3382);
    return localTransport;
  }
  
  public static CancellationSignal fromTransport(ICancellationSignal paramICancellationSignal)
  {
    if ((paramICancellationSignal instanceof Transport)) {
      return ((Transport)paramICancellationSignal).mCancellationSignal;
    }
    return null;
  }
  
  private void waitForCancelFinishedLocked()
  {
    AppMethodBeat.i(3381);
    while (this.mCancelInProgress) {
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException) {}
    }
    AppMethodBeat.o(3381);
  }
  
  /* Error */
  public final void cancel()
  {
    // Byte code:
    //   0: sipush 3378
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 57	com/tencent/wcdb/support/CancellationSignal:mIsCanceled	Z
    //   12: ifeq +12 -> 24
    //   15: aload_0
    //   16: monitorexit
    //   17: sipush 3378
    //   20: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 57	com/tencent/wcdb/support/CancellationSignal:mIsCanceled	Z
    //   29: aload_0
    //   30: iconst_1
    //   31: putfield 49	com/tencent/wcdb/support/CancellationSignal:mCancelInProgress	Z
    //   34: aload_0
    //   35: getfield 59	com/tencent/wcdb/support/CancellationSignal:mOnCancelListener	Lcom/tencent/wcdb/support/CancellationSignal$OnCancelListener;
    //   38: astore_1
    //   39: aload_0
    //   40: getfield 61	com/tencent/wcdb/support/CancellationSignal:mRemote	Lcom/tencent/wcdb/support/ICancellationSignal;
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_1
    //   51: invokeinterface 64 1 0
    //   56: aload_2
    //   57: ifnull +9 -> 66
    //   60: aload_2
    //   61: invokeinterface 68 1 0
    //   66: aload_0
    //   67: monitorenter
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield 49	com/tencent/wcdb/support/CancellationSignal:mCancelInProgress	Z
    //   73: aload_0
    //   74: invokevirtual 71	java/lang/Object:notifyAll	()V
    //   77: aload_0
    //   78: monitorexit
    //   79: sipush 3378
    //   82: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: return
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: sipush 3378
    //   92: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_1
    //   96: athrow
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: sipush 3378
    //   103: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aload_0
    //   110: monitorenter
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 49	com/tencent/wcdb/support/CancellationSignal:mCancelInProgress	Z
    //   116: aload_0
    //   117: invokevirtual 71	java/lang/Object:notifyAll	()V
    //   120: aload_0
    //   121: monitorexit
    //   122: sipush 3378
    //   125: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: sipush 3378
    //   136: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_1
    //   140: athrow
    //   141: astore_1
    //   142: goto -76 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	CancellationSignal
    //   38	13	1	localOnCancelListener	OnCancelListener
    //   86	10	1	localObject1	Object
    //   97	10	1	localObject2	Object
    //   108	21	1	localObject3	Object
    //   130	10	1	localObject4	Object
    //   141	1	1	localRemoteException	android.os.RemoteException
    //   43	18	2	localICancellationSignal	ICancellationSignal
    // Exception table:
    //   from	to	target	type
    //   8	17	86	finally
    //   24	46	86	finally
    //   87	89	86	finally
    //   68	79	97	finally
    //   98	100	97	finally
    //   50	56	108	finally
    //   60	66	108	finally
    //   111	122	130	finally
    //   131	133	130	finally
    //   60	66	141	android/os/RemoteException
  }
  
  public final boolean isCanceled()
  {
    try
    {
      boolean bool = this.mIsCanceled;
      return bool;
    }
    finally {}
  }
  
  public final void setOnCancelListener(OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(3379);
    try
    {
      waitForCancelFinishedLocked();
      if (this.mOnCancelListener == paramOnCancelListener) {
        return;
      }
      this.mOnCancelListener = paramOnCancelListener;
      if ((!this.mIsCanceled) || (paramOnCancelListener == null)) {
        return;
      }
      paramOnCancelListener.onCancel();
      AppMethodBeat.o(3379);
      return;
    }
    finally
    {
      AppMethodBeat.o(3379);
    }
  }
  
  /* Error */
  public final void setRemote(ICancellationSignal paramICancellationSignal)
  {
    // Byte code:
    //   0: sipush 3380
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: invokespecial 77	com/tencent/wcdb/support/CancellationSignal:waitForCancelFinishedLocked	()V
    //   12: aload_0
    //   13: getfield 61	com/tencent/wcdb/support/CancellationSignal:mRemote	Lcom/tencent/wcdb/support/ICancellationSignal;
    //   16: aload_1
    //   17: if_acmpne +12 -> 29
    //   20: aload_0
    //   21: monitorexit
    //   22: sipush 3380
    //   25: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: return
    //   29: aload_0
    //   30: aload_1
    //   31: putfield 61	com/tencent/wcdb/support/CancellationSignal:mRemote	Lcom/tencent/wcdb/support/ICancellationSignal;
    //   34: aload_0
    //   35: getfield 57	com/tencent/wcdb/support/CancellationSignal:mIsCanceled	Z
    //   38: ifeq +7 -> 45
    //   41: aload_1
    //   42: ifnonnull +12 -> 54
    //   45: aload_0
    //   46: monitorexit
    //   47: sipush 3380
    //   50: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: return
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: invokeinterface 68 1 0
    //   62: sipush 3380
    //   65: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: return
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: sipush 3380
    //   75: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_1
    //   79: athrow
    //   80: astore_1
    //   81: sipush 3380
    //   84: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	CancellationSignal
    //   0	88	1	paramICancellationSignal	ICancellationSignal
    // Exception table:
    //   from	to	target	type
    //   8	22	69	finally
    //   29	41	69	finally
    //   45	47	69	finally
    //   54	56	69	finally
    //   70	72	69	finally
    //   56	62	80	android/os/RemoteException
  }
  
  public final void throwIfCanceled()
  {
    AppMethodBeat.i(3377);
    if (isCanceled())
    {
      OperationCanceledException localOperationCanceledException = new OperationCanceledException();
      AppMethodBeat.o(3377);
      throw localOperationCanceledException;
    }
    AppMethodBeat.o(3377);
  }
  
  public static abstract interface OnCancelListener
  {
    public abstract void onCancel();
  }
  
  static final class Transport
    extends ICancellationSignal.Stub
  {
    final CancellationSignal mCancellationSignal;
    
    private Transport()
    {
      AppMethodBeat.i(3375);
      this.mCancellationSignal = new CancellationSignal();
      AppMethodBeat.o(3375);
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(3376);
      this.mCancellationSignal.cancel();
      AppMethodBeat.o(3376);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.support.CancellationSignal
 * JD-Core Version:    0.7.0.1
 */