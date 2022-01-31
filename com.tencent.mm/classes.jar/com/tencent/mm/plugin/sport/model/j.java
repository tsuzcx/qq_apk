package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.y;

public final class j
  extends y
{
  public j(String paramString)
  {
    super(paramString);
  }
  
  public final long getLong(int paramInt, long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(93685);
        Object localObject1 = get(paramInt);
        if ((localObject1 instanceof Long))
        {
          paramLong = ((Long)localObject1).longValue();
          AppMethodBeat.o(93685);
          return paramLong;
        }
        if ((localObject1 instanceof Integer))
        {
          paramLong = ((Integer)localObject1).longValue();
          AppMethodBeat.o(93685);
        }
        else
        {
          AppMethodBeat.o(93685);
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public final String getString(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 37
    //   4: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: iload_1
    //   9: invokevirtual 22	com/tencent/mm/plugin/sport/model/j:get	(I)Ljava/lang/Object;
    //   12: astore_3
    //   13: aload_3
    //   14: instanceof 39
    //   17: ifeq +17 -> 34
    //   20: aload_3
    //   21: checkcast 39	java/lang/String
    //   24: astore_2
    //   25: ldc 37
    //   27: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: areturn
    //   34: ldc 37
    //   36: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: goto -9 -> 30
    //   42: astore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_2
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	j
    //   0	47	1	paramInt	int
    //   0	47	2	paramString	String
    //   12	9	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	30	42	finally
    //   34	39	42	finally
  }
  
  public final void setString(int paramInt, String paramString)
  {
    try
    {
      AppMethodBeat.i(93686);
      set(paramInt, paramString);
      AppMethodBeat.o(93686);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.j
 * JD-Core Version:    0.7.0.1
 */