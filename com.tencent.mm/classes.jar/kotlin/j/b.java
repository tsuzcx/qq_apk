package kotlin.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/random/FallbackThreadLocalRandom;", "Lkotlin/random/AbstractPlatformRandom;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "implStorage", "kotlin/random/FallbackThreadLocalRandom$implStorage$1", "Lkotlin/random/FallbackThreadLocalRandom$implStorage$1;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class b
  extends a
{
  private final a aixj;
  
  public b()
  {
    AppMethodBeat.i(129559);
    this.aixj = new a();
    AppMethodBeat.o(129559);
  }
  
  public final Random klH()
  {
    AppMethodBeat.i(129558);
    Object localObject = this.aixj.get();
    s.s(localObject, "implStorage.get()");
    localObject = (Random)localObject;
    AppMethodBeat.o(129558);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"kotlin/random/FallbackThreadLocalRandom$implStorage$1", "Ljava/lang/ThreadLocal;", "Ljava/util/Random;", "initialValue", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    extends ThreadLocal<Random>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.j.b
 * JD-Core Version:    0.7.0.1
 */