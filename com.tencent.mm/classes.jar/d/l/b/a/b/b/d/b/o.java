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
  private final Enum<?> LjG;
  
  public o(f paramf, Enum<?> paramEnum)
  {
    super(paramf);
    AppMethodBeat.i(57481);
    this.LjG = paramEnum;
    AppMethodBeat.o(57481);
  }
  
  public final a fTv()
  {
    AppMethodBeat.i(57479);
    Object localObject = this.LjG.getClass();
    if (((Class)localObject).isEnum()) {}
    for (;;)
    {
      k.g(localObject, "enumClass");
      localObject = b.bz((Class)localObject);
      AppMethodBeat.o(57479);
      return localObject;
      localObject = ((Class)localObject).getEnclosingClass();
    }
  }
  
  public final f fTw()
  {
    AppMethodBeat.i(57480);
    f localf = f.aWB(this.LjG.name());
    AppMethodBeat.o(57480);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.o
 * JD-Core Version:    0.7.0.1
 */