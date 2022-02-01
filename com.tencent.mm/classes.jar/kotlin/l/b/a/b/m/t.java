package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.i;

public class t
  extends aj
{
  private final List<av> aaKw;
  private final h aaOs;
  private final boolean abkQ;
  private final at abql;
  private final String abqm;
  
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
    AppMethodBeat.i(269841);
    this.abql = paramat;
    this.aaOs = paramh;
    this.aaKw = paramList;
    this.abkQ = paramBoolean;
    this.abqm = paramString;
    AppMethodBeat.o(269841);
  }
  
  public aj Jn(boolean paramBoolean)
  {
    AppMethodBeat.i(60659);
    aj localaj = (aj)new t(this.abql, this.aaOs, this.aaKw, paramBoolean, null, 16);
    AppMethodBeat.o(60659);
    return localaj;
  }
  
  public final aj d(g paramg)
  {
    AppMethodBeat.i(60657);
    p.k(paramg, "newAnnotations");
    paramg = (aj)this;
    AppMethodBeat.o(60657);
    return paramg;
  }
  
  public final g iDY()
  {
    AppMethodBeat.i(60655);
    Object localObject = g.aaLw;
    localObject = g.a.iGe();
    AppMethodBeat.o(60655);
    return localObject;
  }
  
  public final h iEC()
  {
    return this.aaOs;
  }
  
  public final boolean iIu()
  {
    return this.abkQ;
  }
  
  public final List<av> iOR()
  {
    return this.aaKw;
  }
  
  public final at iOU()
  {
    return this.abql;
  }
  
  public String iPS()
  {
    return this.abqm;
  }
  
  public t j(i parami)
  {
    AppMethodBeat.i(60661);
    p.k(parami, "kotlinTypeRefiner");
    AppMethodBeat.o(60661);
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(60656);
    StringBuilder localStringBuilder = new StringBuilder().append(this.abql.toString());
    if (this.aaKw.isEmpty()) {}
    for (String str = "";; str = j.a((Iterable)this.aaKw, (CharSequence)", ", (CharSequence)"<", (CharSequence)">", -1, (CharSequence)"...", null))
    {
      str = str;
      AppMethodBeat.o(60656);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.t
 * JD-Core Version:    0.7.0.1
 */