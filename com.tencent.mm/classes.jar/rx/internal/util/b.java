package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;
import rx.f;

public final class b
  extends AtomicLong
  implements f
{
  boolean Ukt;
  final a UmX;
  Throwable exception;
  public volatile boolean terminated;
  
  public b(a parama)
  {
    this.UmX = parama;
  }
  
  public final void Pw(long paramLong)
  {
    AppMethodBeat.i(90200);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(90200);
      return;
    }
    label91:
    label117:
    for (;;)
    {
      long l2 = get();
      int i;
      int j;
      long l1;
      if (l2 == 0L)
      {
        i = 1;
        j = i;
        if (l2 != 9223372036854775807L)
        {
          if (paramLong != 9223372036854775807L) {
            break label91;
          }
          l1 = paramLong;
          i = 1;
        }
      }
      for (;;)
      {
        if (!compareAndSet(l2, l1)) {
          break label117;
        }
        j = i;
        if (j != 0) {
          drain();
        }
        AppMethodBeat.o(90200);
        return;
        i = 0;
        break;
        if (l2 > 9223372036854775807L - paramLong) {
          l1 = 9223372036854775807L;
        } else {
          l1 = l2 + paramLong;
        }
      }
    }
  }
  
  public final void S(Throwable paramThrowable)
  {
    AppMethodBeat.i(90199);
    if (!this.terminated)
    {
      this.exception = paramThrowable;
      this.terminated = true;
      drain();
    }
    AppMethodBeat.o(90199);
  }
  
  public final void drain()
  {
    AppMethodBeat.i(90201);
    int k;
    try
    {
      if (this.Ukt) {
        return;
      }
      this.Ukt = true;
      bool1 = this.terminated;
      l1 = get();
      k = 0;
      i = k;
    }
    finally
    {
      a locala;
      label54:
      AppMethodBeat.o(90201);
    }
    try
    {
      locala = this.UmX;
    }
    finally
    {
      do
      {
        Object localObject7;
        boolean bool2;
        break label262;
        int j = 0;
        if (l1 > 0L) {
          break;
        }
      } while (!bool1);
      break label54;
    }
    if (bool1)
    {
      i = k;
      if (locala.peek() == null)
      {
        i = 1;
        locala.Q(this.exception);
        AppMethodBeat.o(90201);
        return;
      }
      if (l1 == 0L) {}
    }
    else
    {
      i = k;
      localObject7 = localObject1.poll();
      if (localObject7 != null)
      {
        i = k;
        bool2 = localObject1.accept(localObject7);
        if (bool2)
        {
          AppMethodBeat.o(90201);
          return;
        }
        l1 -= 1L;
        j += 1;
        break label369;
      }
    }
    i = k;
    for (;;)
    {
      try
      {
        bool1 = this.terminated;
        if (localObject1.peek() != null)
        {
          i = 1;
          l1 = get();
          if (l1 != 9223372036854775807L) {
            break label283;
          }
          if ((i != 0) || (bool1)) {
            continue;
          }
          j = 1;
          i = j;
        }
      }
      finally
      {
        j = 0;
      }
      try
      {
        this.Ukt = false;
        i = j;
        AppMethodBeat.o(90201);
        return;
      }
      finally
      {
        for (;;)
        {
          j = i;
        }
      }
      i = 0;
      continue;
      l1 = 9223372036854775807L;
    }
    label262:
    label283:
    do
    {
      do
      {
        break label367;
        i = j;
        try
        {
          AppMethodBeat.o(90201);
          throw localObject2;
        }
        finally {}
        if (i == 0) {}
        try
        {
          this.Ukt = false;
          throw localObject3;
        }
        finally
        {
          long l2;
          AppMethodBeat.o(90201);
        }
        l1 = -j;
        l2 = addAndGet(l1);
        if (l2 == 0L) {
          break;
        }
        l1 = l2;
      } while (i != 0);
      if (!bool1) {
        break;
      }
      l1 = l2;
    } while (i == 0);
    j = 1;
    i = j;
    this.Ukt = false;
    i = j;
    AppMethodBeat.o(90201);
  }
  
  public static abstract interface a
  {
    public abstract void Q(Throwable paramThrowable);
    
    public abstract boolean accept(Object paramObject);
    
    public abstract Object peek();
    
    public abstract Object poll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.util.b
 * JD-Core Version:    0.7.0.1
 */