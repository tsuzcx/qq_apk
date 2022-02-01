package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.m;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.f;

public final class o
  extends d
  implements m
{
  private final Enum<?> Tnq;
  
  public o(f paramf, Enum<?> paramEnum)
  {
    super(paramf);
    AppMethodBeat.i(57481);
    this.Tnq = paramEnum;
    AppMethodBeat.o(57481);
  }
  
  public final a hCY()
  {
    AppMethodBeat.i(57479);
    Object localObject = this.Tnq.getClass();
    if (((Class)localObject).isEnum()) {}
    for (;;)
    {
      p.g(localObject, "enumClass");
      localObject = b.bB((Class)localObject);
      AppMethodBeat.o(57479);
      return localObject;
      localObject = ((Class)localObject).getEnclosingClass();
    }
  }
  
  public final f hCZ()
  {
    AppMethodBeat.i(57480);
    f localf = f.btY(this.Tnq.name());
    AppMethodBeat.o(57480);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.o
 * JD-Core Version:    0.7.0.1
 */