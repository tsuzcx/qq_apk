package kotlin.j.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/random/jdk8/PlatformThreadLocalRandom;", "Lkotlin/random/AbstractPlatformRandom;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextDouble", "", "until", "nextInt", "", "from", "nextLong", "", "kotlin-stdlib-jdk8"}, k=1, mv={1, 5, 1})
public final class a
  extends kotlin.j.a
{
  public final Random klH()
  {
    AppMethodBeat.i(190895);
    Object localObject = ThreadLocalRandom.current();
    s.s(localObject, "ThreadLocalRandom.current()");
    localObject = (Random)localObject;
    AppMethodBeat.o(190895);
    return localObject;
  }
  
  public final int qq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190898);
    paramInt1 = ThreadLocalRandom.current().nextInt(paramInt1, paramInt2);
    AppMethodBeat.o(190898);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.j.a.a
 * JD-Core Version:    0.7.0.1
 */