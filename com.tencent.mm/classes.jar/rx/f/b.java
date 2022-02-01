package rx.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;
import rx.j;

public final class b
  implements j
{
  public volatile boolean akdH;
  private Set<j> akeR;
  
  /* Error */
  private static void R(java.util.Collection<j> paramCollection)
  {
    // Byte code:
    //   0: ldc 19
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +9 -> 15
    //   9: ldc 19
    //   11: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: return
    //   15: aconst_null
    //   16: astore_1
    //   17: aload_0
    //   18: invokeinterface 34 1 0
    //   23: astore_2
    //   24: aload_1
    //   25: astore_0
    //   26: aload_2
    //   27: invokeinterface 40 1 0
    //   32: ifeq +46 -> 78
    //   35: aload_2
    //   36: invokeinterface 44 1 0
    //   41: checkcast 6	rx/j
    //   44: astore_1
    //   45: aload_1
    //   46: invokeinterface 47 1 0
    //   51: goto -25 -> 26
    //   54: astore_1
    //   55: aload_0
    //   56: ifnonnull +32 -> 88
    //   59: new 49	java/util/ArrayList
    //   62: dup
    //   63: invokespecial 50	java/util/ArrayList:<init>	()V
    //   66: astore_0
    //   67: aload_0
    //   68: aload_1
    //   69: invokeinterface 56 2 0
    //   74: pop
    //   75: goto -49 -> 26
    //   78: aload_0
    //   79: invokestatic 62	rx/a/b:pp	(Ljava/util/List;)V
    //   82: ldc 19
    //   84: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(90435);
    if (paramj.kKi())
    {
      AppMethodBeat.o(90435);
      return;
    }
    if (!this.akdH) {}
    try
    {
      if (!this.akdH)
      {
        if (this.akeR == null) {
          this.akeR = new HashSet(4);
        }
        this.akeR.add(paramj);
        return;
      }
      paramj.kKh();
      AppMethodBeat.o(90435);
      return;
    }
    finally
    {
      AppMethodBeat.o(90435);
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(90437);
    if (!this.akdH) {}
    try
    {
      if ((this.akdH) || (this.akeR == null)) {
        return;
      }
      Set localSet = this.akeR;
      this.akeR = null;
      R(localSet);
      AppMethodBeat.o(90437);
      return;
    }
    finally
    {
      AppMethodBeat.o(90437);
    }
  }
  
  public final void e(j paramj)
  {
    AppMethodBeat.i(90436);
    if (!this.akdH) {}
    try
    {
      if ((this.akdH) || (this.akeR == null)) {
        return;
      }
      boolean bool = this.akeR.remove(paramj);
      if (bool) {
        paramj.kKh();
      }
      AppMethodBeat.o(90436);
      return;
    }
    finally
    {
      AppMethodBeat.o(90436);
    }
  }
  
  public final void kKh()
  {
    AppMethodBeat.i(90438);
    if (!this.akdH) {}
    try
    {
      if (this.akdH) {
        return;
      }
      this.akdH = true;
      Set localSet = this.akeR;
      this.akeR = null;
      R(localSet);
      AppMethodBeat.o(90438);
      return;
    }
    finally
    {
      AppMethodBeat.o(90438);
    }
  }
  
  public final boolean kKi()
  {
    return this.akdH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.f.b
 * JD-Core Version:    0.7.0.1
 */