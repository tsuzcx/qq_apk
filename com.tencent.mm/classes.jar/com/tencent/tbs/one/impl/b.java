package com.tencent.tbs.one.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;

public final class b<T>
  extends TBSOneCallback<T>
{
  T a;
  int b = 0;
  String c;
  private boolean d;
  
  private void b()
  {
    try
    {
      AppMethodBeat.i(174155);
      this.d = true;
      notify();
      AppMethodBeat.o(174155);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 41
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 30	com/tencent/tbs/one/impl/b:d	Z
    //   11: istore_1
    //   12: iload_1
    //   13: ifne +28 -> 41
    //   16: aload_0
    //   17: invokevirtual 44	java/lang/Object:wait	()V
    //   20: ldc 41
    //   22: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: astore_2
    //   29: aload_0
    //   30: bipush 103
    //   32: putfield 20	com/tencent/tbs/one/impl/b:b	I
    //   35: aload_0
    //   36: ldc 46
    //   38: putfield 48	com/tencent/tbs/one/impl/b:c	Ljava/lang/String;
    //   41: ldc 41
    //   43: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: goto -21 -> 25
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	b
    //   11	2	1	bool	boolean
    //   28	1	2	localInterruptedException	java.lang.InterruptedException
    //   49	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	20	28	java/lang/InterruptedException
    //   2	12	49	finally
    //   16	20	49	finally
    //   20	25	49	finally
    //   29	41	49	finally
    //   41	46	49	finally
  }
  
  public final void onCompleted(T paramT)
  {
    AppMethodBeat.i(174153);
    this.a = paramT;
    b();
    AppMethodBeat.o(174153);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(174154);
    this.b = paramInt;
    this.c = paramString;
    b();
    AppMethodBeat.o(174154);
  }
  
  public final void onProgressChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tbs.one.impl.b
 * JD-Core Version:    0.7.0.1
 */