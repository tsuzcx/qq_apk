package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/SegmentOrClosed;", "S", "Lkotlinx/coroutines/internal/Segment;", "", "value", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isClosed", "", "isClosed-impl", "(Ljava/lang/Object;)Z", "segment", "getSegment$annotations", "()V", "getSegment-impl", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/Segment;", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa<S extends z<S>>
{
  public static final boolean iW(Object paramObject)
  {
    AppMethodBeat.i(189438);
    if (paramObject == e.kDP())
    {
      AppMethodBeat.o(189438);
      return true;
    }
    AppMethodBeat.o(189438);
    return false;
  }
  
  public static final S jn(Object paramObject)
  {
    AppMethodBeat.i(189444);
    if (paramObject == e.kDP())
    {
      paramObject = (Throwable)new IllegalStateException("Does not contain segment".toString());
      AppMethodBeat.o(189444);
      throw paramObject;
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
      AppMethodBeat.o(189444);
      throw paramObject;
    }
    paramObject = (z)paramObject;
    AppMethodBeat.o(189444);
    return paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    throw null;
  }
  
  public final int hashCode()
  {
    throw null;
  }
  
  public final String toString()
  {
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.aa
 * JD-Core Version:    0.7.0.1
 */