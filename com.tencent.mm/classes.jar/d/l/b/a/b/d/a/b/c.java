package d.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.b.a;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.t;

public class c
  extends d.l.b.a.b.b.c.f
  implements b
{
  private Boolean NdK;
  private Boolean NdL;
  
  static
  {
    AppMethodBeat.i(57706);
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(57706);
      return;
    }
  }
  
  private c(e parame, c paramc, g paramg, boolean paramBoolean, b.a parama, an paraman)
  {
    super(parame, paramc, paramg, paramBoolean, parama, paraman);
    AppMethodBeat.i(57696);
    this.NdK = null;
    this.NdL = null;
    AppMethodBeat.o(57696);
  }
  
  public static c a(e parame, g paramg, boolean paramBoolean, an paraman)
  {
    AppMethodBeat.i(57697);
    if (parame == null) {
      ajm(4);
    }
    if (paramg == null) {
      ajm(5);
    }
    if (paraman == null) {
      ajm(6);
    }
    parame = new c(parame, null, paramg, paramBoolean, b.a.MUj, paraman);
    AppMethodBeat.o(57697);
    return parame;
  }
  
  private c c(l paraml, t paramt, b.a parama, d.l.b.a.b.f.f paramf, g paramg, an paraman)
  {
    AppMethodBeat.i(57702);
    if (paraml == null) {
      ajm(7);
    }
    if (parama == null) {
      ajm(8);
    }
    if (paramg == null) {
      ajm(9);
    }
    if (paraman == null) {
      ajm(10);
    }
    if ((parama != b.a.MUj) && (parama != b.a.MUm))
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
    paramt = (c)paramt;
    if (paraml == null) {
      ajm(12);
    }
    if (parama == null) {
      ajm(13);
    }
    if (paraman == null) {
      ajm(14);
    }
    if (paramg == null) {
      ajm(15);
    }
    paraml = new c(paraml, paramt, paramg, this.kFz, parama, paraman);
    paraml.zY(gjY());
    paraml.zZ(git());
    AppMethodBeat.o(57702);
    return paraml;
  }
  
  public final boolean git()
  {
    AppMethodBeat.i(57700);
    if ((!$assertionsDisabled) && (this.NdL == null))
    {
      AssertionError localAssertionError = new AssertionError("hasSynthesizedParameterNames was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57700);
      throw localAssertionError;
    }
    boolean bool = this.NdL.booleanValue();
    AppMethodBeat.o(57700);
    return bool;
  }
  
  public final boolean gjY()
  {
    AppMethodBeat.i(57698);
    if ((!$assertionsDisabled) && (this.NdK == null))
    {
      AssertionError localAssertionError = new AssertionError("hasStableParameterNames was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57698);
      throw localAssertionError;
    }
    boolean bool = this.NdK.booleanValue();
    AppMethodBeat.o(57698);
    return bool;
  }
  
  public final void zY(boolean paramBoolean)
  {
    AppMethodBeat.i(57699);
    this.NdK = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(57699);
  }
  
  public final void zZ(boolean paramBoolean)
  {
    AppMethodBeat.i(57701);
    this.NdL = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(57701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.b.c
 * JD-Core Version:    0.7.0.1
 */