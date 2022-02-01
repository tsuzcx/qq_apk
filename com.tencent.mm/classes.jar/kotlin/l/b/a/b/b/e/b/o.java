package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.d.a.e.m;
import kotlin.l.b.a.b.f.f;

public final class o
  extends d
  implements m
{
  private final Enum<?> aiNj;
  
  public o(f paramf, Enum<?> paramEnum)
  {
    super(paramf, (byte)0);
    AppMethodBeat.i(57481);
    this.aiNj = paramEnum;
    AppMethodBeat.o(57481);
  }
  
  public final kotlin.l.b.a.b.f.b kqZ()
  {
    AppMethodBeat.i(57479);
    Object localObject = this.aiNj.getClass();
    if (((Class)localObject).isEnum()) {}
    for (;;)
    {
      s.s(localObject, "enumClass");
      localObject = b.cM((Class)localObject);
      AppMethodBeat.o(57479);
      return localObject;
      localObject = ((Class)localObject).getEnclosingClass();
    }
  }
  
  public final f kra()
  {
    AppMethodBeat.i(57480);
    f localf = f.bJe(this.aiNj.name());
    AppMethodBeat.o(57480);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.o
 * JD-Core Version:    0.7.0.1
 */