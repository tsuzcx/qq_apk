package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l.b.a.b.j.f.h;

public final class bf
  extends t
{
  public final String TNK;
  
  private bf(String paramString, at paramat, h paramh, List<? extends av> paramList, boolean paramBoolean)
  {
    super(paramat, paramh, paramList, paramBoolean, null, 16);
    AppMethodBeat.i(60911);
    this.TNK = paramString;
    AppMethodBeat.o(60911);
  }
  
  public final aj EG(boolean paramBoolean)
  {
    AppMethodBeat.i(60906);
    aj localaj = (aj)new bf(this.TNK, hKE(), hAp(), hKB(), paramBoolean);
    AppMethodBeat.o(60906);
    return localaj;
  }
  
  public final String hLz()
  {
    return this.TNK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.bf
 * JD-Core Version:    0.7.0.1
 */