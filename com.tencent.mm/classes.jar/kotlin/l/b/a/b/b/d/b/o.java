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
  private final Enum<?> aaQk;
  
  public o(f paramf, Enum<?> paramEnum)
  {
    super(paramf);
    AppMethodBeat.i(57481);
    this.aaQk = paramEnum;
    AppMethodBeat.o(57481);
  }
  
  public final a iHs()
  {
    AppMethodBeat.i(57479);
    Object localObject = this.aaQk.getClass();
    if (((Class)localObject).isEnum()) {}
    for (;;)
    {
      p.j(localObject, "enumClass");
      localObject = b.ca((Class)localObject);
      AppMethodBeat.o(57479);
      return localObject;
      localObject = ((Class)localObject).getEnclosingClass();
    }
  }
  
  public final f iHt()
  {
    AppMethodBeat.i(57480);
    f localf = f.bHb(this.aaQk.name());
    AppMethodBeat.o(57480);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.o
 * JD-Core Version:    0.7.0.1
 */