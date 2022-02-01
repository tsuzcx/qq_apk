package kotlin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"maxOf", "T", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", "", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/comparisons/ComparisonsKt")
public class c
  extends b
{
  public static final float b(float paramFloat, float... paramVarArgs)
  {
    AppMethodBeat.i(190792);
    s.u(paramVarArgs, "other");
    int i = 0;
    while (i < 3)
    {
      paramFloat = Math.max(paramFloat, paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(190792);
    return paramFloat;
  }
  
  public static final float c(float paramFloat, float... paramVarArgs)
  {
    AppMethodBeat.i(190800);
    s.u(paramVarArgs, "other");
    int i = 0;
    while (i < 3)
    {
      paramFloat = Math.min(paramFloat, paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(190800);
    return paramFloat;
  }
  
  public static final <T extends Comparable<? super T>> T c(T paramT1, T paramT2)
  {
    AppMethodBeat.i(190787);
    s.u(paramT1, "a");
    s.u(paramT2, "b");
    if (paramT1.compareTo(paramT2) >= 0)
    {
      AppMethodBeat.o(190787);
      return paramT1;
    }
    AppMethodBeat.o(190787);
    return paramT2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.b.c
 * JD-Core Version:    0.7.0.1
 */