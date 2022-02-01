package rx.internal.util.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class c<E>
  extends a<E>
{
  private static final Integer MAX_LOOK_AHEAD_STEP;
  final AtomicLong MfJ;
  final AtomicLong MfK;
  final int lookAheadStep;
  long producerLookAhead;
  
  static
  {
    AppMethodBeat.i(90193);
    MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    AppMethodBeat.o(90193);
  }
  
  public c(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(90185);
    this.MfJ = new AtomicLong();
    this.MfK = new AtomicLong();
    this.lookAheadStep = Math.min(paramInt / 4, MAX_LOOK_AHEAD_STEP.intValue());
    AppMethodBeat.o(90185);
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(90190);
    if (this.MfJ.get() == this.MfK.get())
    {
      AppMethodBeat.o(90190);
      return true;
    }
    AppMethodBeat.o(90190);
    return false;
  }
  
  public final boolean offer(E paramE)
  {
    AppMethodBeat.i(90186);
    if (paramE == null)
    {
      paramE = new NullPointerException("Null is not a valid element");
      AppMethodBeat.o(90186);
      throw paramE;
    }
    AtomicReferenceArray localAtomicReferenceArray = this.LUi;
    int i = this.mask;
    long l = this.MfJ.get();
    int j = (int)l & i;
    if (l >= this.producerLookAhead)
    {
      int k = this.lookAheadStep;
      if (localAtomicReferenceArray.get(i & (int)(k + l)) != null) {
        break label120;
      }
      this.producerLookAhead = (k + l);
    }
    label120:
    while (localAtomicReferenceArray.get(j) == null)
    {
      localAtomicReferenceArray.lazySet(j, paramE);
      this.MfJ.lazySet(1L + l);
      AppMethodBeat.o(90186);
      return true;
    }
    AppMethodBeat.o(90186);
    return false;
  }
  
  public final E peek()
  {
    AppMethodBeat.i(90188);
    Object localObject = ajp(CJ(this.MfK.get()));
    AppMethodBeat.o(90188);
    return localObject;
  }
  
  public final E poll()
  {
    AppMethodBeat.i(90187);
    long l = this.MfK.get();
    int i = CJ(l);
    AtomicReferenceArray localAtomicReferenceArray = this.LUi;
    Object localObject = localAtomicReferenceArray.get(i);
    if (localObject == null)
    {
      AppMethodBeat.o(90187);
      return null;
    }
    localAtomicReferenceArray.lazySet(i, null);
    this.MfK.lazySet(l + 1L);
    AppMethodBeat.o(90187);
    return localObject;
  }
  
  public final int size()
  {
    AppMethodBeat.i(90189);
    long l2;
    for (long l1 = this.MfK.get();; l1 = l2)
    {
      long l3 = this.MfJ.get();
      l2 = this.MfK.get();
      if (l1 == l2)
      {
        int i = (int)(l3 - l2);
        AppMethodBeat.o(90189);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     rx.internal.util.a.c
 * JD-Core Version:    0.7.0.1
 */