package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"buildString", "", "capacity", "", "builderAction", "Lkotlin/Function1;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "append", "obj", "", "value", "", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "kotlin-stdlib"}, iBN=1)
public class t
  extends s
{
  public static final StringBuilder a(StringBuilder paramStringBuilder, String... paramVarArgs)
  {
    AppMethodBeat.i(129465);
    p.k(paramStringBuilder, "$this$append");
    p.k(paramVarArgs, "value");
    int i = 0;
    while (i < 3)
    {
      paramStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(129465);
    return paramStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.t
 * JD-Core Version:    0.7.0.1
 */