package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.d.a.e.m;
import d.l.b.a.b.f.a;
import d.l.b.a.b.f.f;

public final class o
  extends d
  implements m
{
  private final Enum<?> NaC;
  
  public o(f paramf, Enum<?> paramEnum)
  {
    super(paramf);
    AppMethodBeat.i(57481);
    this.NaC = paramEnum;
    AppMethodBeat.o(57481);
  }
  
  public final a gkU()
  {
    AppMethodBeat.i(57479);
    Object localObject = this.NaC.getClass();
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
  
  public final f gkV()
  {
    AppMethodBeat.i(57480);
    f localf = f.bcE(this.NaC.name());
    AppMethodBeat.o(57480);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.o
 * JD-Core Version:    0.7.0.1
 */