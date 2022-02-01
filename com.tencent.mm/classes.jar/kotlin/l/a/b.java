package kotlin.l.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/full/IllegalPropertyDelegateAccessException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cause", "Ljava/lang/IllegalAccessException;", "(Ljava/lang/IllegalAccessException;)V", "kotlin-reflection"})
public final class b
  extends Exception
{
  public b(IllegalAccessException paramIllegalAccessException)
  {
    super("Cannot obtain the delegate of a non-accessible property. Use \"isAccessible = true\" to make the property accessible", (Throwable)paramIllegalAccessException);
    AppMethodBeat.i(56265);
    AppMethodBeat.o(56265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlin.l.a.b
 * JD-Core Version:    0.7.0.1
 */