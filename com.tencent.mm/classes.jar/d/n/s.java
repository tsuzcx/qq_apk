package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"appendRange", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "", "startIndex", "", "endIndex", "", "appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "", "Ljava/lang/StringBuffer;", "", "", "", "", "", "", "", "", "clear", "deleteAt", "index", "deleteRange", "insertRange", "set", "", "setRange", "toCharArray", "destination", "destinationOffset", "kotlin-stdlib"}, fOb=1)
public class s
  extends r
{
  public static final StringBuilder h(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(129419);
    k.h(paramStringBuilder, "$this$clear");
    paramStringBuilder.setLength(0);
    AppMethodBeat.o(129419);
    return paramStringBuilder;
  }
  
  public static final StringBuilder i(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(129420);
    k.h(paramStringBuilder, "$this$appendln");
    paramStringBuilder = paramStringBuilder.append(aa.LQw);
    k.g(paramStringBuilder, "append(SystemProperties.LINE_SEPARATOR)");
    AppMethodBeat.o(129420);
    return paramStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.s
 * JD-Core Version:    0.7.0.1
 */