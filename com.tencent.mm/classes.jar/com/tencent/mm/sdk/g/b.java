package com.tencent.mm.sdk.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class b<R>
{
  private HashMap<String, LinkedList<R>> dw;
  
  static
  {
    AppMethodBeat.i(52529);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(52529);
      return;
    }
  }
  
  public b()
  {
    AppMethodBeat.i(52523);
    this.dw = new HashMap();
    AppMethodBeat.o(52523);
  }
  
  /* Error */
  private boolean j(R paramR, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 43
    //   4: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnonnull +14 -> 22
    //   11: ldc 43
    //   13: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_0
    //   17: istore_3
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_3
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 40	com/tencent/mm/sdk/g/b:dw	Ljava/util/HashMap;
    //   26: aload_2
    //   27: invokevirtual 47	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 49	java/util/LinkedList
    //   33: astore 4
    //   35: aload 4
    //   37: ifnull +39 -> 76
    //   40: aload 4
    //   42: aload_1
    //   43: invokevirtual 53	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   46: istore_3
    //   47: iload_3
    //   48: ifeq +20 -> 68
    //   51: aload 4
    //   53: invokevirtual 57	java/util/LinkedList:size	()I
    //   56: ifne +12 -> 68
    //   59: aload_0
    //   60: getfield 40	com/tencent/mm/sdk/g/b:dw	Ljava/util/HashMap;
    //   63: aload_2
    //   64: invokevirtual 59	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: pop
    //   68: ldc 43
    //   70: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: goto -55 -> 18
    //   76: ldc 43
    //   78: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: iconst_0
    //   82: istore_3
    //   83: goto -65 -> 18
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	b
    //   0	91	1	paramR	R
    //   0	91	2	paramString	String
    //   17	66	3	bool	boolean
    //   33	19	4	localLinkedList	LinkedList
    // Exception table:
    //   from	to	target	type
    //   2	7	86	finally
    //   11	16	86	finally
    //   22	35	86	finally
    //   40	47	86	finally
    //   51	68	86	finally
    //   68	73	86	finally
    //   76	81	86	finally
  }
  
  /* Error */
  public final LinkedList<R> aqs(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 64
    //   4: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnull +23 -> 31
    //   11: ldc 66
    //   13: aload_1
    //   14: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifne +14 -> 31
    //   20: aload_0
    //   21: getfield 40	com/tencent/mm/sdk/g/b:dw	Ljava/util/HashMap;
    //   24: aload_1
    //   25: invokevirtual 74	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   28: ifne +20 -> 48
    //   31: new 49	java/util/LinkedList
    //   34: dup
    //   35: invokespecial 75	java/util/LinkedList:<init>	()V
    //   38: astore_1
    //   39: ldc 64
    //   41: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: areturn
    //   48: aload_0
    //   49: getfield 40	com/tencent/mm/sdk/g/b:dw	Ljava/util/HashMap;
    //   52: aload_1
    //   53: invokevirtual 59	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   56: checkcast 49	java/util/LinkedList
    //   59: astore_1
    //   60: ldc 64
    //   62: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -21 -> 44
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	b
    //   0	73	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	7	68	finally
    //   11	31	68	finally
    //   31	44	68	finally
    //   48	65	68	finally
  }
  
  /* Error */
  public final R h(R paramR, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 79
    //   4: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: aload_2
    //   10: invokespecial 81	com/tencent/mm/sdk/g/b:j	(Ljava/lang/Object;Ljava/lang/String;)Z
    //   13: pop
    //   14: aload_0
    //   15: getfield 40	com/tencent/mm/sdk/g/b:dw	Ljava/util/HashMap;
    //   18: aload_2
    //   19: invokevirtual 47	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 49	java/util/LinkedList
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +10 -> 37
    //   30: aload_1
    //   31: invokevirtual 57	java/util/LinkedList:size	()I
    //   34: ifgt +14 -> 48
    //   37: aconst_null
    //   38: astore_1
    //   39: ldc 79
    //   41: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: areturn
    //   48: aload_1
    //   49: invokevirtual 85	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   52: astore_1
    //   53: ldc 79
    //   55: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: goto -14 -> 44
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	b
    //   0	66	1	paramR	R
    //   0	66	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	26	61	finally
    //   30	37	61	finally
    //   39	44	61	finally
    //   48	58	61	finally
  }
  
  public final boolean i(R paramR, String paramString)
  {
    try
    {
      AppMethodBeat.i(52525);
      if ((!$assertionsDisabled) && (paramR == null))
      {
        paramR = new AssertionError();
        AppMethodBeat.o(52525);
        throw paramR;
      }
    }
    finally {}
    if ((!$assertionsDisabled) && (TextUtils.isEmpty(paramString)))
    {
      paramR = new AssertionError();
      AppMethodBeat.o(52525);
      throw paramR;
    }
    LinkedList localLinkedList = (LinkedList)this.dw.get(paramString);
    if (localLinkedList == null)
    {
      HashMap localHashMap = this.dw;
      localLinkedList = new LinkedList();
      localHashMap.put(paramString, localLinkedList);
    }
    for (paramString = localLinkedList;; paramString = localLinkedList)
    {
      if (paramString.size() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramString.add(paramR);
        AppMethodBeat.o(52525);
        return bool;
      }
    }
  }
  
  public final boolean remove(R paramR)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(52527);
        if (paramR == null)
        {
          AppMethodBeat.o(52527);
          bool1 = false;
          return bool1;
        }
        Iterator localIterator1 = this.dw.values().iterator();
        boolean bool1 = false;
        if (localIterator1.hasNext())
        {
          Iterator localIterator2 = ((LinkedList)localIterator1.next()).iterator();
          i = 1;
          boolean bool2 = bool1;
          if (localIterator2.hasNext())
          {
            if (paramR != localIterator2.next()) {
              break label135;
            }
            localIterator2.remove();
            bool2 = true;
            continue;
          }
          bool1 = bool2;
          if (i == 0) {
            continue;
          }
          localIterator1.remove();
          bool1 = bool2;
          continue;
        }
        AppMethodBeat.o(52527);
      }
      finally {}
      continue;
      label135:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.g.b
 * JD-Core Version:    0.7.0.1
 */