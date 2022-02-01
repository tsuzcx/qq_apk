package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.p;
import d.q;
import d.v;
import java.lang.reflect.Constructor;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"})
public final class d$d
  extends d.g.b.l
  implements b<Throwable, Throwable>
{
  public d$d(Constructor paramConstructor)
  {
    super(1);
  }
  
  private Throwable D(Throwable paramThrowable)
  {
    AppMethodBeat.i(191215);
    Object localObject;
    try
    {
      localObject = p.KTg;
      localObject = this.LSG.newInstance(new Object[0]);
      if (localObject == null)
      {
        paramThrowable = new v("null cannot be cast to non-null type kotlin.Throwable");
        AppMethodBeat.o(191215);
        throw paramThrowable;
      }
    }
    catch (Throwable paramThrowable)
    {
      localObject = p.KTg;
      paramThrowable = p.eI(q.n(paramThrowable));
    }
    for (;;)
    {
      localObject = paramThrowable;
      if (p.eG(paramThrowable)) {
        localObject = null;
      }
      paramThrowable = (Throwable)localObject;
      AppMethodBeat.o(191215);
      return paramThrowable;
      localObject = (Throwable)localObject;
      ((Throwable)localObject).initCause(paramThrowable);
      paramThrowable = p.eI(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.d.d
 * JD-Core Version:    0.7.0.1
 */