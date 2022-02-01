package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.m.ab;

public final class d
  implements c
{
  private final ab Tii;
  private final Map<f, g<?>> Tij;
  private final an Tik;
  
  public d(ab paramab, Map<f, g<?>> paramMap, an paraman)
  {
    AppMethodBeat.i(56928);
    this.Tii = paramab;
    this.Tij = paramMap;
    this.Tik = paraman;
    AppMethodBeat.o(56928);
  }
  
  public final Map<f, g<?>> hBO()
  {
    AppMethodBeat.i(56931);
    Map localMap = this.Tij;
    if (localMap == null) {
      atM(4);
    }
    AppMethodBeat.o(56931);
    return localMap;
  }
  
  public final b hBk()
  {
    AppMethodBeat.i(56930);
    b localb = c.a.b(this);
    AppMethodBeat.o(56930);
    return localb;
  }
  
  public final ab hBy()
  {
    AppMethodBeat.i(56929);
    ab localab = this.Tii;
    if (localab == null) {
      atM(3);
    }
    AppMethodBeat.o(56929);
    return localab;
  }
  
  public final an hzM()
  {
    AppMethodBeat.i(56932);
    an localan = this.Tik;
    if (localan == null) {
      atM(5);
    }
    AppMethodBeat.o(56932);
    return localan;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56933);
    String str = kotlin.l.b.a.b.i.c.TFg.a(this, null);
    AppMethodBeat.o(56933);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.a.d
 * JD-Core Version:    0.7.0.1
 */