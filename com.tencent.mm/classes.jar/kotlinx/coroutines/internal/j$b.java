package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "e", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"}, k=3, mv={1, 5, 1}, xi=48)
public final class j$b
  extends u
  implements b<Throwable, Throwable>
{
  public j$b(Constructor paramConstructor)
  {
    super(1);
  }
  
  private Throwable aa(Throwable paramThrowable)
  {
    AppMethodBeat.i(189415);
    Object localObject;
    try
    {
      localObject = Result.Companion;
      paramThrowable = this.ajAr.newInstance(new Object[] { paramThrowable });
      if (paramThrowable == null)
      {
        paramThrowable = new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        AppMethodBeat.o(189415);
        throw paramThrowable;
      }
    }
    finally
    {
      localObject = Result.Companion;
      paramThrowable = Result.constructor-impl(ResultKt.createFailure(paramThrowable));
    }
    for (;;)
    {
      localObject = paramThrowable;
      if (Result.isFailure-impl(paramThrowable)) {
        localObject = null;
      }
      paramThrowable = (Throwable)localObject;
      AppMethodBeat.o(189415);
      return paramThrowable;
      paramThrowable = Result.constructor-impl((Throwable)paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.j.b
 * JD-Core Version:    0.7.0.1
 */