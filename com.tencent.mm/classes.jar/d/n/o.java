package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"append", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "appendElement", "", "element", "transform", "Lkotlin/Function1;", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "appendRange", "startIndex", "", "endIndex", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "kotlin-stdlib"}, gkc=1)
public class o
{
  public static final <T> void a(Appendable paramAppendable, T paramT, b<? super T, ? extends CharSequence> paramb)
  {
    AppMethodBeat.i(188733);
    p.h(paramAppendable, "$this$appendElement");
    if (paramb != null)
    {
      paramAppendable.append((CharSequence)paramb.invoke(paramT));
      AppMethodBeat.o(188733);
      return;
    }
    if (paramT != null) {}
    for (boolean bool = paramT instanceof CharSequence; bool; bool = true)
    {
      paramAppendable.append((CharSequence)paramT);
      AppMethodBeat.o(188733);
      return;
    }
    if ((paramT instanceof Character))
    {
      paramAppendable.append(((Character)paramT).charValue());
      AppMethodBeat.o(188733);
      return;
    }
    paramAppendable.append((CharSequence)String.valueOf(paramT));
    AppMethodBeat.o(188733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.o
 * JD-Core Version:    0.7.0.1
 */