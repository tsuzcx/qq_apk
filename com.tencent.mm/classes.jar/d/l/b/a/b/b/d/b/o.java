package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.d.a.e.m;
import d.l.b.a.b.f.a;
import d.l.b.a.b.f.f;

public final class o
  extends d
  implements m
{
  private final Enum<?> Jwn;
  
  public o(f paramf, Enum<?> paramEnum)
  {
    super(paramf);
    AppMethodBeat.i(57481);
    this.Jwn = paramEnum;
    AppMethodBeat.o(57481);
  }
  
  public final a fAR()
  {
    AppMethodBeat.i(57479);
    Object localObject = this.Jwn.getClass();
    if (((Class)localObject).isEnum()) {}
    for (;;)
    {
      k.g(localObject, "enumClass");
      localObject = b.bw((Class)localObject);
      AppMethodBeat.o(57479);
      return localObject;
      localObject = ((Class)localObject).getEnclosingClass();
    }
  }
  
  public final f fAS()
  {
    AppMethodBeat.i(57480);
    f localf = f.aQC(this.Jwn.name());
    AppMethodBeat.o(57480);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.o
 * JD-Core Version:    0.7.0.1
 */