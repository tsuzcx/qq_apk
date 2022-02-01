package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.g.a.b;

@Metadata(d1={"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k=4, mv={1, 5, 1}, xi=48)
public final class cf
{
  public static final bi a(cb paramcb, bi parambi)
  {
    AppMethodBeat.i(188780);
    paramcb = paramcb.bh((b)new bk(parambi));
    AppMethodBeat.o(188780);
    return paramcb;
  }
  
  public static final void a(f paramf, CancellationException paramCancellationException)
  {
    AppMethodBeat.i(369481);
    cg.a(paramf, paramCancellationException);
    AppMethodBeat.o(369481);
  }
  
  public static final void d(cb paramcb)
  {
    AppMethodBeat.i(188795);
    if (!paramcb.isActive())
    {
      paramcb = paramcb.kCu();
      AppMethodBeat.o(188795);
      throw paramcb;
    }
    AppMethodBeat.o(188795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.cf
 * JD-Core Version:    0.7.0.1
 */