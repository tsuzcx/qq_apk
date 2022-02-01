package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"buildString", "", "capacity", "", "builderAction", "Lkotlin/Function1;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "append", "obj", "", "value", "", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "appendLine", "", "", "", "", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/StringsKt")
public class t
  extends s
{
  public static final StringBuilder a(StringBuilder paramStringBuilder, String... paramVarArgs)
  {
    AppMethodBeat.i(129465);
    kotlin.g.b.s.u(paramStringBuilder, "$this$append");
    kotlin.g.b.s.u(paramVarArgs, "value");
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