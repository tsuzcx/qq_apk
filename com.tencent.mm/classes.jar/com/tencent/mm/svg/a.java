package com.tencent.mm.svg;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

final class a<T>
{
  private HashMap<Looper, LinkedList<T>> VKg;
  private Queue<T> VKh;
  
  a()
  {
    AppMethodBeat.i(148680);
    this.VKg = new HashMap();
    this.VKh = new ArrayDeque();
    AppMethodBeat.o(148680);
  }
  
  /* Error */
  protected final void a(Looper paramLooper, T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 39
    //   4: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 27	com/tencent/mm/svg/a:VKg	Ljava/util/HashMap;
    //   11: aload_1
    //   12: invokevirtual 43	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   15: ifne +46 -> 61
    //   18: new 45	java/util/LinkedList
    //   21: dup
    //   22: invokespecial 46	java/util/LinkedList:<init>	()V
    //   25: astore_3
    //   26: aload_0
    //   27: getfield 27	com/tencent/mm/svg/a:VKg	Ljava/util/HashMap;
    //   30: aload_1
    //   31: aload_3
    //   32: invokevirtual 50	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: aload_3
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 54	java/util/LinkedList:size	()I
    //   42: bipush 20
    //   44: if_icmpge +9 -> 53
    //   47: aload_1
    //   48: aload_2
    //   49: invokevirtual 57	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   52: pop
    //   53: ldc 39
    //   55: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: aload_0
    //   62: getfield 27	com/tencent/mm/svg/a:VKg	Ljava/util/HashMap;
    //   65: aload_1
    //   66: invokevirtual 61	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   69: checkcast 45	java/util/LinkedList
    //   72: astore_1
    //   73: goto -35 -> 38
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	a
    //   0	81	1	paramLooper	Looper
    //   0	81	2	paramT	T
    //   25	12	3	localLinkedList	LinkedList
    // Exception table:
    //   from	to	target	type
    //   2	36	76	finally
    //   38	53	76	finally
    //   53	58	76	finally
    //   61	73	76	finally
  }
  
  protected final T hCd()
  {
    try
    {
      AppMethodBeat.i(148681);
      Object localObject1 = null;
      if (this.VKh.size() != 0) {
        localObject1 = this.VKh.poll();
      }
      AppMethodBeat.o(148681);
      return localObject1;
    }
    finally {}
  }
  
  protected final void i(Looper paramLooper)
  {
    try
    {
      AppMethodBeat.i(148683);
      if (this.VKg.containsKey(paramLooper))
      {
        paramLooper = (LinkedList)this.VKg.remove(paramLooper);
        if (this.VKh.size() < 40) {
          this.VKh.addAll(paramLooper);
        }
      }
      AppMethodBeat.o(148683);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.svg.a
 * JD-Core Version:    0.7.0.1
 */