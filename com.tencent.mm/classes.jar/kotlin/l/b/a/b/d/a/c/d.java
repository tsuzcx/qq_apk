package kotlin.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumMap;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.a.a;
import kotlin.l.b.a.b.d.a.f.h;

public final class d
{
  final EnumMap<a.a, h> aaUf;
  
  public d(EnumMap<a.a, h> paramEnumMap)
  {
    AppMethodBeat.i(57746);
    this.aaUf = paramEnumMap;
    AppMethodBeat.o(57746);
  }
  
  public final kotlin.l.b.a.b.d.a.f.d b(a.a parama)
  {
    AppMethodBeat.i(57745);
    parama = (h)this.aaUf.get(parama);
    if (parama == null)
    {
      AppMethodBeat.o(57745);
      return null;
    }
    p.j(parama, "nullabilityQualifiers[ap…ilityType] ?: return null");
    parama = new kotlin.l.b.a.b.d.a.f.d(parama.aaWR, null, false, parama.aaWS);
    AppMethodBeat.o(57745);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.d
 * JD-Core Version:    0.7.0.1
 */