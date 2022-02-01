package kotlin.l.b.a.b.j.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.c.a.b;

public final class f
  extends i
{
  private final h ajlf;
  
  public f(h paramh)
  {
    AppMethodBeat.i(60210);
    this.ajlf = paramh;
    AppMethodBeat.o(60210);
  }
  
  public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, b paramb)
  {
    AppMethodBeat.i(60205);
    s.u(paramf, "name");
    s.u(paramb, "location");
    paramb = this.ajlf.c(paramf, paramb);
    if (paramb == null) {
      paramf = null;
    }
    for (;;)
    {
      paramf = (kotlin.l.b.a.b.b.h)paramf;
      AppMethodBeat.o(60205);
      return paramf;
      if ((paramb instanceof e))
      {
        paramf = (e)paramb;
        label59:
        if (paramf != null) {
          break label93;
        }
        if (!(paramb instanceof az)) {
          break label88;
        }
      }
      label88:
      for (paramf = (az)paramb;; paramf = null)
      {
        paramf = (kotlin.l.b.a.b.b.i)paramf;
        break;
        paramf = null;
        break label59;
      }
      label93:
      paramf = (kotlin.l.b.a.b.b.i)paramf;
    }
  }
  
  public final void d(kotlin.l.b.a.b.f.f paramf, b paramb)
  {
    AppMethodBeat.i(192227);
    s.u(paramf, "name");
    s.u(paramb, "location");
    this.ajlf.d(paramf, paramb);
    AppMethodBeat.o(192227);
  }
  
  public final Set<kotlin.l.b.a.b.f.f> kpL()
  {
    AppMethodBeat.i(60207);
    Set localSet = this.ajlf.kpL();
    AppMethodBeat.o(60207);
    return localSet;
  }
  
  public final Set<kotlin.l.b.a.b.f.f> kpM()
  {
    AppMethodBeat.i(192224);
    Set localSet = this.ajlf.kpM();
    AppMethodBeat.o(192224);
    return localSet;
  }
  
  public final Set<kotlin.l.b.a.b.f.f> kpN()
  {
    AppMethodBeat.i(60208);
    Set localSet = this.ajlf.kpN();
    AppMethodBeat.o(60208);
    return localSet;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60209);
    String str = s.X("Classes from ", this.ajlf);
    AppMethodBeat.o(60209);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.g.f
 * JD-Core Version:    0.7.0.1
 */