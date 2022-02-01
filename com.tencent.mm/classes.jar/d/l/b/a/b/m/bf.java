package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.j.f.h;
import java.util.List;

public final class bf
  extends t
{
  public final String NBK;
  
  private bf(String paramString, at paramat, h paramh, List<? extends av> paramList, boolean paramBoolean)
  {
    super(paramat, paramh, paramList, paramBoolean, null, 16);
    AppMethodBeat.i(60911);
    this.NBK = paramString;
    AppMethodBeat.o(60911);
  }
  
  public final aj Ac(boolean paramBoolean)
  {
    AppMethodBeat.i(60906);
    aj localaj = (aj)new bf(this.NBK, gsZ(), gil(), gsW(), paramBoolean);
    AppMethodBeat.o(60906);
    return localaj;
  }
  
  public final String gtU()
  {
    return this.NBK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.bf
 * JD-Core Version:    0.7.0.1
 */