package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.m.a.i;
import java.util.List;

public class t
  extends aj
{
  private final boolean JRT;
  private final at JXw;
  private final List<av> JqB;
  private final h Juv;
  
  public t(at paramat, h paramh, byte paramByte)
  {
    this(paramat, paramh);
  }
  
  public t(at paramat, h paramh, List<? extends av> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(60664);
    this.JXw = paramat;
    this.Juv = paramh;
    this.JqB = paramList;
    this.JRT = paramBoolean;
    AppMethodBeat.o(60664);
  }
  
  public final aj d(g paramg)
  {
    AppMethodBeat.i(60657);
    k.h(paramg, "newAnnotations");
    paramg = (aj)this;
    AppMethodBeat.o(60657);
    return paramg;
  }
  
  public final boolean fBT()
  {
    return this.JRT;
  }
  
  public final List<av> fIT()
  {
    return this.JqB;
  }
  
  public final at fIW()
  {
    return this.JXw;
  }
  
  public final g fxF()
  {
    AppMethodBeat.i(60655);
    Object localObject = g.JrB;
    localObject = g.a.fzI();
    AppMethodBeat.o(60655);
    return localObject;
  }
  
  public final h fyj()
  {
    return this.Juv;
  }
  
  public t j(i parami)
  {
    AppMethodBeat.i(60661);
    k.h(parami, "kotlinTypeRefiner");
    AppMethodBeat.o(60661);
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(60656);
    StringBuilder localStringBuilder = new StringBuilder().append(this.JXw.toString());
    if (this.JqB.isEmpty()) {}
    for (String str = "";; str = j.a((Iterable)this.JqB, (CharSequence)", ", (CharSequence)"<", (CharSequence)">", -1, (CharSequence)"...", null))
    {
      str = str;
      AppMethodBeat.o(60656);
      return str;
    }
  }
  
  public aj xW(boolean paramBoolean)
  {
    AppMethodBeat.i(60659);
    aj localaj = (aj)new t(this.JXw, this.Juv, this.JqB, paramBoolean);
    AppMethodBeat.o(60659);
    return localaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.t
 * JD-Core Version:    0.7.0.1
 */