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
  private final boolean TIm;
  private final at TNJ;
  private final String TNK;
  private final List<av> ThC;
  private final h Tly;
  
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
    AppMethodBeat.i(186269);
    this.TNJ = paramat;
    this.Tly = paramh;
    this.ThC = paramList;
    this.TIm = paramBoolean;
    this.TNK = paramString;
    AppMethodBeat.o(186269);
  }
  
  public aj EG(boolean paramBoolean)
  {
    AppMethodBeat.i(60659);
    aj localaj = (aj)new t(this.TNJ, this.Tly, this.ThC, paramBoolean, null, 16);
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
  
  public final h hAp()
  {
    return this.Tly;
  }
  
  public final boolean hEa()
  {
    return this.TIm;
  }
  
  public final List<av> hKB()
  {
    return this.ThC;
  }
  
  public final at hKE()
  {
    return this.TNJ;
  }
  
  public String hLz()
  {
    return this.TNK;
  }
  
  public final g hzL()
  {
    AppMethodBeat.i(60655);
    Object localObject = g.TiC;
    localObject = g.a.hBP();
    AppMethodBeat.o(60655);
    return localObject;
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
    StringBuilder localStringBuilder = new StringBuilder().append(this.TNJ.toString());
    if (this.ThC.isEmpty()) {}
    for (String str = "";; str = j.a((Iterable)this.ThC, (CharSequence)", ", (CharSequence)"<", (CharSequence)">", -1, (CharSequence)"...", null))
    {
      str = str;
      AppMethodBeat.o(60656);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.t
 * JD-Core Version:    0.7.0.1
 */