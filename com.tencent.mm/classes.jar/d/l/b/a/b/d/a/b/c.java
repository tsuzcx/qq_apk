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
  private Boolean NAP;
  private Boolean NAQ;
  
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
    this.NAP = null;
    this.NAQ = null;
    AppMethodBeat.o(57696);
  }
  
  public static c a(e parame, g paramg, boolean paramBoolean, an paraman)
  {
    AppMethodBeat.i(57697);
    if (parame == null) {
      ajW(4);
    }
    if (paramg == null) {
      ajW(5);
    }
    if (paraman == null) {
      ajW(6);
    }
    parame = new c(parame, null, paramg, paramBoolean, b.a.Nro, paraman);
    AppMethodBeat.o(57697);
    return parame;
  }
  
  private c c(l paraml, t paramt, b.a parama, d.l.b.a.b.f.f paramf, g paramg, an paraman)
  {
    AppMethodBeat.i(57702);
    if (paraml == null) {
      ajW(7);
    }
    if (parama == null) {
      ajW(8);
    }
    if (paramg == null) {
      ajW(9);
    }
    if (paraman == null) {
      ajW(10);
    }
    if ((parama != b.a.Nro) && (parama != b.a.Nrr))
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
      ajW(12);
    }
    if (parama == null) {
      ajW(13);
    }
    if (paraman == null) {
      ajW(14);
    }
    if (paramg == null) {
      ajW(15);
    }
    paraml = new c(paraml, paramt, paramg, this.kIO, parama, paraman);
    paraml.Al(goA());
    paraml.Am(gmV());
    AppMethodBeat.o(57702);
    return paraml;
  }
  
  public final void Al(boolean paramBoolean)
  {
    AppMethodBeat.i(57699);
    this.NAP = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(57699);
  }
  
  public final void Am(boolean paramBoolean)
  {
    AppMethodBeat.i(57701);
    this.NAQ = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(57701);
  }
  
  public final boolean gmV()
  {
    AppMethodBeat.i(57700);
    if ((!$assertionsDisabled) && (this.NAQ == null))
    {
      AssertionError localAssertionError = new AssertionError("hasSynthesizedParameterNames was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57700);
      throw localAssertionError;
    }
    boolean bool = this.NAQ.booleanValue();
    AppMethodBeat.o(57700);
    return bool;
  }
  
  public final boolean goA()
  {
    AppMethodBeat.i(57698);
    if ((!$assertionsDisabled) && (this.NAP == null))
    {
      AssertionError localAssertionError = new AssertionError("hasStableParameterNames was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57698);
      throw localAssertionError;
    }
    boolean bool = this.NAP.booleanValue();
    AppMethodBeat.o(57698);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.b.c
 * JD-Core Version:    0.7.0.1
 */