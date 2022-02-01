package d.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.d.a.a.a;
import d.l.b.a.b.d.a.f.h;
import java.util.EnumMap;

public final class d
{
  final EnumMap<a.a, h> JAi;
  
  public d(EnumMap<a.a, h> paramEnumMap)
  {
    AppMethodBeat.i(57746);
    this.JAi = paramEnumMap;
    AppMethodBeat.o(57746);
  }
  
  public final d.l.b.a.b.d.a.f.d b(a.a parama)
  {
    AppMethodBeat.i(57745);
    parama = (h)this.JAi.get(parama);
    if (parama == null)
    {
      AppMethodBeat.o(57745);
      return null;
    }
    k.g(parama, "nullabilityQualifiers[ap…ilityType] ?: return null");
    parama = new d.l.b.a.b.d.a.f.d(parama.JCV, null, false, parama.JCW);
    AppMethodBeat.o(57745);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.d
 * JD-Core Version:    0.7.0.1
 */