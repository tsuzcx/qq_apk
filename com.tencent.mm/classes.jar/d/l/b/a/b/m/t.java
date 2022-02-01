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
  private final boolean NTq;
  private final at NYQ;
  private final String NYR;
  private final List<av> NrU;
  private final h NvQ;
  
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
    AppMethodBeat.i(193316);
    this.NYQ = paramat;
    this.NvQ = paramh;
    this.NrU = paramList;
    this.NTq = paramBoolean;
    this.NYR = paramString;
    AppMethodBeat.o(193316);
  }
  
  public aj Ap(boolean paramBoolean)
  {
    AppMethodBeat.i(60659);
    aj localaj = (aj)new t(this.NYQ, this.NvQ, this.NrU, paramBoolean, null, 16);
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
  
  public final h gmN()
  {
    return this.NvQ;
  }
  
  public final g gmj()
  {
    AppMethodBeat.i(60655);
    Object localObject = g.NsU;
    localObject = g.a.gon();
    AppMethodBeat.o(60655);
    return localObject;
  }
  
  public final boolean gqy()
  {
    return this.NTq;
  }
  
  public final at gxB()
  {
    return this.NYQ;
  }
  
  public final List<av> gxy()
  {
    return this.NrU;
  }
  
  public String gyw()
  {
    return this.NYR;
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
    StringBuilder localStringBuilder = new StringBuilder().append(this.NYQ.toString());
    if (this.NrU.isEmpty()) {}
    for (String str = "";; str = j.a((Iterable)this.NrU, (CharSequence)", ", (CharSequence)"<", (CharSequence)">", -1, (CharSequence)"...", null))
    {
      str = str;
      AppMethodBeat.o(60656);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.t
 * JD-Core Version:    0.7.0.1
 */