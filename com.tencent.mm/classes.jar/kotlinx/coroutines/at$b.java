package kotlinx.coroutines;

import a.f.b.j;
import a.l;
import java.util.Arrays;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.a.r;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/EventLoopBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "timeMillis", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "nanoTime", "compareTo", "other", "dispose", "", "rescheduleOnShutdown", "schedule", "delayed", "eventLoop", "Lkotlinx/coroutines/EventLoopBase;", "timeToExecute", "", "now", "toString", "", "kotlinx-coroutines-core"})
public abstract class at$b
  implements Comparable<b>, Runnable, r, ap
{
  private Object CIc;
  private int index = -1;
  public final long nanoTime = bs.eqa().nanoTime() + au.pv(1000L);
  
  public final int a(q<b> paramq, at paramat)
  {
    int i;
    r localr;
    for (;;)
    {
      try
      {
        j.q(paramq, "delayed");
        j.q(paramat, "eventLoop");
        paramat = this.CIc;
        localObject = au.epO();
        if (paramat == localObject)
        {
          i = 2;
          return i;
        }
        localr = (r)this;
        try
        {
          j.q(localr, "node");
          if (localr.epN() == null)
          {
            i = 1;
            if (i != 0) {
              break;
            }
            throw ((Throwable)new IllegalStateException("Check failed.".toString()));
          }
        }
        finally {}
        i = 0;
      }
      finally {}
    }
    localr.a((q)paramq);
    Object localObject = paramq.CJF;
    if (localObject == null)
    {
      paramat = new r[4];
      paramq.CJF = paramat;
    }
    for (;;)
    {
      i = paramq.size;
      paramq.size = (i + 1);
      paramat[i] = localr;
      localr.setIndex(i);
      paramq.Wj(i);
      i = 0;
      break;
      paramat = (at)localObject;
      if (paramq.size >= localObject.length)
      {
        paramat = Arrays.copyOf((Object[])localObject, paramq.size * 2);
        j.p(paramat, "java.util.Arrays.copyOf(this, newSize)");
        paramq.CJF = ((r[])paramat);
        paramat = (r[])paramat;
      }
    }
  }
  
  public final void a(q<?> paramq)
  {
    if (this.CIc != au.epO()) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
    }
    this.CIc = paramq;
  }
  
  /* Error */
  public final void dispose()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 101	kotlinx/coroutines/at$b:CIc	Ljava/lang/Object;
    //   6: astore_2
    //   7: invokestatic 105	kotlinx/coroutines/au:epO	()Lkotlinx/coroutines/a/m;
    //   10: astore_1
    //   11: aload_2
    //   12: aload_1
    //   13: if_acmpne +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: instanceof 125
    //   25: ifne +5 -> 30
    //   28: aconst_null
    //   29: astore_1
    //   30: aload_1
    //   31: checkcast 125	kotlinx/coroutines/a/q
    //   34: astore_1
    //   35: aload_1
    //   36: ifnull +12 -> 48
    //   39: aload_1
    //   40: aload_0
    //   41: checkcast 11	kotlinx/coroutines/a/r
    //   44: invokevirtual 165	kotlinx/coroutines/a/q:a	(Lkotlinx/coroutines/a/r;)Z
    //   47: pop
    //   48: aload_0
    //   49: invokestatic 105	kotlinx/coroutines/au:epO	()Lkotlinx/coroutines/a/m;
    //   52: putfield 101	kotlinx/coroutines/at$b:CIc	Ljava/lang/Object;
    //   55: goto -39 -> 16
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	b
    //   10	30	1	localObject1	Object
    //   58	4	1	localObject2	Object
    //   6	16	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	58	finally
    //   21	28	58	finally
    //   30	35	58	finally
    //   39	48	58	finally
    //   48	55	58	finally
  }
  
  public final q<?> epN()
  {
    Object localObject2 = this.CIc;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof q)) {
      localObject1 = null;
    }
    return (q)localObject1;
  }
  
  public final int getIndex()
  {
    return this.index;
  }
  
  public final void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public String toString()
  {
    return "Delayed[nanos=" + this.nanoTime + ']';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.coroutines.at.b
 * JD-Core Version:    0.7.0.1
 */