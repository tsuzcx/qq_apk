package kotlin.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/random/FallbackThreadLocalRandom;", "Lkotlin/random/AbstractPlatformRandom;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "implStorage", "kotlin/random/FallbackThreadLocalRandom$implStorage$1", "Lkotlin/random/FallbackThreadLocalRandom$implStorage$1;", "kotlin-stdlib"})
public final class b
  extends a
{
  private final a aaBI;
  
  public b()
  {
    AppMethodBeat.i(129559);
    this.aaBI = new a();
    AppMethodBeat.o(129559);
  }
  
  public final Random iCs()
  {
    AppMethodBeat.i(129558);
    Object localObject = this.aaBI.get();
    p.j(localObject, "implStorage.get()");
    localObject = (Random)localObject;
    AppMethodBeat.o(129558);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/random/FallbackThreadLocalRandom$implStorage$1", "Ljava/lang/ThreadLocal;", "Ljava/util/Random;", "initialValue", "kotlin-stdlib"})
  public static final class a
    extends ThreadLocal<Random>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.j.b
 * JD-Core Version:    0.7.0.1
 */