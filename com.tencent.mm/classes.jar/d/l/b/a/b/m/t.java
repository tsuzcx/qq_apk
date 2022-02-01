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
  private final boolean LFm;
  private final at LKP;
  private final List<av> LdU;
  private final h LhO;
  
  public t(at paramat, h paramh, byte paramByte)
  {
    this(paramat, paramh);
  }
  
  public t(at paramat, h paramh, List<? extends av> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(60664);
    this.LKP = paramat;
    this.LhO = paramh;
    this.LdU = paramList;
    this.LFm = paramBoolean;
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
  
  public final h fQN()
  {
    return this.LhO;
  }
  
  public final g fQj()
  {
    AppMethodBeat.i(60655);
    Object localObject = g.LeU;
    localObject = g.a.fSm();
    AppMethodBeat.o(60655);
    return localObject;
  }
  
  public final boolean fUx()
  {
    return this.LFm;
  }
  
  public final List<av> gbw()
  {
    return this.LdU;
  }
  
  public final at gbz()
  {
    return this.LKP;
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
    StringBuilder localStringBuilder = new StringBuilder().append(this.LKP.toString());
    if (this.LdU.isEmpty()) {}
    for (String str = "";; str = j.a((Iterable)this.LdU, (CharSequence)", ", (CharSequence)"<", (CharSequence)">", -1, (CharSequence)"...", null))
    {
      str = str;
      AppMethodBeat.o(60656);
      return str;
    }
  }
  
  public aj zo(boolean paramBoolean)
  {
    AppMethodBeat.i(60659);
    aj localaj = (aj)new t(this.LKP, this.LhO, this.LdU, paramBoolean);
    AppMethodBeat.o(60659);
    return localaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.t
 * JD-Core Version:    0.7.0.1
 */