package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"appendRange", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "", "startIndex", "", "endIndex", "", "appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "", "Ljava/lang/StringBuffer;", "", "", "", "", "", "", "", "", "clear", "deleteAt", "index", "deleteRange", "insertRange", "set", "", "setRange", "toCharArray", "destination", "destinationOffset", "kotlin-stdlib"}, hxG=1)
public class s
  extends r
{
  public static final StringBuilder h(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(129419);
    p.h(paramStringBuilder, "$this$clear");
    paramStringBuilder.setLength(0);
    AppMethodBeat.o(129419);
    return paramStringBuilder;
  }
  
  public static final StringBuilder i(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(129420);
    p.h(paramStringBuilder, "$this$appendln");
    paramStringBuilder = paramStringBuilder.append(aa.TTr);
    p.g(paramStringBuilder, "append(SystemProperties.LINE_SEPARATOR)");
    AppMethodBeat.o(129420);
    return paramStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.s
 * JD-Core Version:    0.7.0.1
 */