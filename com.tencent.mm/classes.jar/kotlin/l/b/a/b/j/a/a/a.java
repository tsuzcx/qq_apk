package kotlin.l.b.a.b.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.ab;
import kotlin.g.b.s;
import kotlin.l.b.a.b.j.g.h;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.c.d;
import kotlin.l.b.a.b.m.v;

public final class a
  extends al
  implements d
{
  private final kotlin.l.b.a.b.b.a.g aiHM;
  private final az ajju;
  private final b ajjv;
  private final boolean ajjw;
  
  private a(az paramaz, b paramb, boolean paramBoolean, kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60026);
    this.ajju = paramaz;
    this.ajjv = paramb;
    this.ajjw = paramBoolean;
    this.aiHM = paramg;
    AppMethodBeat.o(60026);
  }
  
  private a PB(boolean paramBoolean)
  {
    AppMethodBeat.i(60017);
    if (paramBoolean == this.ajjw)
    {
      AppMethodBeat.o(60017);
      return this;
    }
    a locala = new a(this.ajju, this.ajjv, paramBoolean, this.aiHM);
    AppMethodBeat.o(60017);
    return locala;
  }
  
  private a e(kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60020);
    s.u(paramg, "newAnnotations");
    paramg = new a(this.ajju, this.ajjv, this.ajjw, paramg);
    AppMethodBeat.o(60020);
    return paramg;
  }
  
  private a h(kotlin.l.b.a.b.m.a.g paramg)
  {
    AppMethodBeat.i(60023);
    s.u(paramg, "kotlinTypeRefiner");
    paramg = this.ajju.o(paramg);
    s.s(paramg, "typeProjection.refine(kotlinTypeRefiner)");
    paramg = new a(paramg, this.ajjv, this.ajjw, this.aiHM);
    AppMethodBeat.o(60023);
    return paramg;
  }
  
  public final List<az> klR()
  {
    return (List)ab.aivy;
  }
  
  public final h knP()
  {
    AppMethodBeat.i(60011);
    h localh = v.eW("No member resolution should be done on captured type, it used only during constraint system resolution", true);
    s.s(localh, "createErrorScope(\n      …solution\", true\n        )");
    AppMethodBeat.o(60011);
    return localh;
  }
  
  public final kotlin.l.b.a.b.b.a.g knl()
  {
    return this.aiHM;
  }
  
  public final boolean ksB()
  {
    return this.ajjw;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60016);
    StringBuilder localStringBuilder = new StringBuilder("Captured(").append(this.ajju).append(')');
    if (this.ajjw) {}
    for (String str = "?";; str = "")
    {
      str = str;
      AppMethodBeat.o(60016);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.a.a.a
 * JD-Core Version:    0.7.0.1
 */