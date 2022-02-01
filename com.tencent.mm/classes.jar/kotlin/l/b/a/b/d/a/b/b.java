package kotlin.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.x;

public class b
  extends kotlin.l.b.a.b.b.c.f
  implements a
{
  private Boolean aiRr;
  private Boolean aiRs;
  
  static
  {
    AppMethodBeat.i(57706);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(57706);
      return;
    }
  }
  
  private b(e parame, b paramb, g paramg, boolean paramBoolean, b.a parama, av paramav)
  {
    super(parame, paramb, paramg, paramBoolean, parama, paramav);
    AppMethodBeat.i(57696);
    this.aiRr = null;
    this.aiRs = null;
    AppMethodBeat.o(57696);
  }
  
  public static b a(e parame, g paramg, boolean paramBoolean, av paramav)
  {
    AppMethodBeat.i(57697);
    if (parame == null) {
      aKu(4);
    }
    if (paramg == null) {
      aKu(5);
    }
    if (paramav == null) {
      aKu(6);
    }
    parame = new b(parame, null, paramg, paramBoolean, b.a.aiGl, paramav);
    AppMethodBeat.o(57697);
    return parame;
  }
  
  private b c(l paraml, x paramx, b.a parama, kotlin.l.b.a.b.f.f paramf, g paramg, av paramav)
  {
    AppMethodBeat.i(57702);
    if (paraml == null) {
      aKu(7);
    }
    if (parama == null) {
      aKu(8);
    }
    if (paramg == null) {
      aKu(9);
    }
    if (paramav == null) {
      aKu(10);
    }
    if ((parama != b.a.aiGl) && (parama != b.a.aiGo))
    {
      paraml = new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + paraml + "\nkind: " + parama);
      AppMethodBeat.o(57702);
      throw paraml;
    }
    if ((!$assertionsDisabled) && (paramf != null))
    {
      paraml = new AssertionError("Attempt to rename constructor: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57702);
      throw paraml;
    }
    paraml = (e)paraml;
    paramx = (b)paramx;
    if (paraml == null) {
      aKu(12);
    }
    if (parama == null) {
      aKu(13);
    }
    if (paramav == null) {
      aKu(14);
    }
    if (paramg == null) {
      aKu(15);
    }
    paraml = new b(paraml, paramx, paramg, this.rNy, parama, paramav);
    paraml.Pl(kpO());
    paraml.Pm(koe());
    AppMethodBeat.o(57702);
    return paraml;
  }
  
  public final void Pl(boolean paramBoolean)
  {
    AppMethodBeat.i(57699);
    this.aiRr = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(57699);
  }
  
  public final void Pm(boolean paramBoolean)
  {
    AppMethodBeat.i(57701);
    this.aiRs = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(57701);
  }
  
  public final boolean koe()
  {
    AppMethodBeat.i(57700);
    if ((!$assertionsDisabled) && (this.aiRs == null))
    {
      AssertionError localAssertionError = new AssertionError("hasSynthesizedParameterNames was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57700);
      throw localAssertionError;
    }
    boolean bool = this.aiRs.booleanValue();
    AppMethodBeat.o(57700);
    return bool;
  }
  
  public final boolean kpO()
  {
    AppMethodBeat.i(57698);
    if ((!$assertionsDisabled) && (this.aiRr == null))
    {
      AssertionError localAssertionError = new AssertionError("hasStableParameterNames was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57698);
      throw localAssertionError;
    }
    boolean bool = this.aiRr.booleanValue();
    AppMethodBeat.o(57698);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.b.b
 * JD-Core Version:    0.7.0.1
 */