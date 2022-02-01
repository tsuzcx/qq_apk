package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.m.a.i;
import java.util.List;

public class t
  extends aj
{
  private final List<av> MUP;
  private final h MYK;
  private final at NBJ;
  private final String NBK;
  private final boolean Nwk;
  
  public t(at paramat, h paramh)
  {
    this(paramat, paramh, null, false, null, 28);
    AppMethodBeat.i(60665);
    AppMethodBeat.o(60665);
  }
  
  public t(at paramat, h paramh, List<? extends av> paramList)
  {
    this(paramat, paramh, paramList, false, null, 16);
  }
  
  private t(at paramat, h paramh, List<? extends av> paramList, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(187792);
    this.NBJ = paramat;
    this.MYK = paramh;
    this.MUP = paramList;
    this.Nwk = paramBoolean;
    this.NBK = paramString;
    AppMethodBeat.o(187792);
  }
  
  public aj Ac(boolean paramBoolean)
  {
    AppMethodBeat.i(60659);
    aj localaj = (aj)new t(this.NBJ, this.MYK, this.MUP, paramBoolean, null, 16);
    AppMethodBeat.o(60659);
    return localaj;
  }
  
  public final aj d(g paramg)
  {
    AppMethodBeat.i(60657);
    p.h(paramg, "newAnnotations");
    paramg = (aj)this;
    AppMethodBeat.o(60657);
    return paramg;
  }
  
  public final g ghH()
  {
    AppMethodBeat.i(60655);
    Object localObject = g.MVP;
    localObject = g.a.gjL();
    AppMethodBeat.o(60655);
    return localObject;
  }
  
  public final h gil()
  {
    return this.MYK;
  }
  
  public final boolean glW()
  {
    return this.Nwk;
  }
  
  public final List<av> gsW()
  {
    return this.MUP;
  }
  
  public final at gsZ()
  {
    return this.NBJ;
  }
  
  public String gtU()
  {
    return this.NBK;
  }
  
  public t j(i parami)
  {
    AppMethodBeat.i(60661);
    p.h(parami, "kotlinTypeRefiner");
    AppMethodBeat.o(60661);
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(60656);
    StringBuilder localStringBuilder = new StringBuilder().append(this.NBJ.toString());
    if (this.MUP.isEmpty()) {}
    for (String str = "";; str = j.a((Iterable)this.MUP, (CharSequence)", ", (CharSequence)"<", (CharSequence)">", -1, (CharSequence)"...", null))
    {
      str = str;
      AppMethodBeat.o(60656);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.t
 * JD-Core Version:    0.7.0.1
 */