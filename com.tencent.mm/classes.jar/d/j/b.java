package d.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Random;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/random/FallbackThreadLocalRandom;", "Lkotlin/random/AbstractPlatformRandom;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "implStorage", "kotlin/random/FallbackThreadLocalRandom$implStorage$1", "Lkotlin/random/FallbackThreadLocalRandom$implStorage$1;", "kotlin-stdlib"})
public final class b
  extends a
{
  private final a MMb;
  
  public b()
  {
    AppMethodBeat.i(129559);
    this.MMb = new a();
    AppMethodBeat.o(129559);
  }
  
  public final Random ggd()
  {
    AppMethodBeat.i(129558);
    Object localObject = this.MMb.get();
    p.g(localObject, "implStorage.get()");
    localObject = (Random)localObject;
    AppMethodBeat.o(129558);
    return localObject;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/random/FallbackThreadLocalRandom$implStorage$1", "Ljava/lang/ThreadLocal;", "Ljava/util/Random;", "initialValue", "kotlin-stdlib"})
  public static final class a
    extends ThreadLocal<Random>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.j.b
 * JD-Core Version:    0.7.0.1
 */