package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import rx.j;

public final class i
  implements j
{
  public List<j> akdG;
  public volatile boolean akdH;
  
  public i() {}
  
  public i(j paramj)
  {
    AppMethodBeat.i(90120);
    this.akdG = new LinkedList();
    this.akdG.add(paramj);
    AppMethodBeat.o(90120);
  }
  
  public i(j... paramVarArgs)
  {
    AppMethodBeat.i(90119);
    this.akdG = new LinkedList(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(90119);
  }
  
  /* Error */
  private static void R(java.util.Collection<j> paramCollection)
  {
    // Byte code:
    //   0: ldc 51
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +9 -> 15
    //   9: ldc 51
    //   11: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: return
    //   15: aconst_null
    //   16: astore_1
    //   17: aload_0
    //   18: invokeinterface 57 1 0
    //   23: astore_2
    //   24: aload_1
    //   25: astore_0
    //   26: aload_2
    //   27: invokeinterface 63 1 0
    //   32: ifeq +46 -> 78
    //   35: aload_2
    //   36: invokeinterface 67 1 0
    //   41: checkcast 6	rx/j
    //   44: astore_1
    //   45: aload_1
    //   46: invokeinterface 70 1 0
    //   51: goto -25 -> 26
    //   54: astore_1
    //   55: aload_0
    //   56: ifnonnull +32 -> 88
    //   59: new 72	java/util/ArrayList
    //   62: dup
    //   63: invokespecial 73	java/util/ArrayList:<init>	()V
    //   66: astore_0
    //   67: aload_0
    //   68: aload_1
    //   69: invokeinterface 35 2 0
    //   74: pop
    //   75: goto -49 -> 26
    //   78: aload_0
    //   79: invokestatic 79	rx/a/b:pp	(Ljava/util/List;)V
    //   82: ldc 51
    //   84: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: return
    //   88: goto -21 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramCollection	java.util.Collection<j>
    //   16	30	1	localj	j
    //   54	15	1	localObject	Object
    //   23	13	2	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   45	51	54	finally
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(90121);
    if (paramj.kKi())
    {
      AppMethodBeat.o(90121);
      return;
    }
    if (!this.akdH) {}
    try
    {
      if (!this.akdH)
      {
        List localList = this.akdG;
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new LinkedList();
          this.akdG = ((List)localObject);
        }
        ((List)localObject).add(paramj);
        return;
      }
      paramj.kKh();
      AppMethodBeat.o(90121);
      return;
    }
    finally
    {
      AppMethodBeat.o(90121);
    }
  }
  
  public final void kKh()
  {
    AppMethodBeat.i(90122);
    if (!this.akdH) {}
    try
    {
      if (this.akdH) {
        return;
      }
      this.akdH = true;
      List localList = this.akdG;
      this.akdG = null;
      R(localList);
      AppMethodBeat.o(90122);
      return;
    }
    finally
    {
      AppMethodBeat.o(90122);
    }
  }
  
  public final boolean kKi()
  {
    return this.akdH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.util.i
 * JD-Core Version:    0.7.0.1
 */