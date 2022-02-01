package kotlin.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;

public class c
  extends kotlin.l.b.a.b.b.c.f
  implements b
{
  private Boolean aaTr;
  private Boolean aaTs;
  
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
    this.aaTr = null;
    this.aaTs = null;
    AppMethodBeat.o(57696);
  }
  
  public static c a(e parame, g paramg, boolean paramBoolean, an paraman)
  {
    AppMethodBeat.i(57697);
    if (parame == null) {
      aDG(4);
    }
    if (paramg == null) {
      aDG(5);
    }
    if (paraman == null) {
      aDG(6);
    }
    parame = new c(parame, null, paramg, paramBoolean, b.a.aaJQ, paraman);
    AppMethodBeat.o(57697);
    return parame;
  }
  
  private c c(l paraml, t paramt, b.a parama, kotlin.l.b.a.b.f.f paramf, g paramg, an paraman)
  {
    AppMethodBeat.i(57702);
    if (paraml == null) {
      aDG(7);
    }
    if (parama == null) {
      aDG(8);
    }
    if (paramg == null) {
      aDG(9);
    }
    if (paraman == null) {
      aDG(10);
    }
    if ((parama != b.a.aaJQ) && (parama != b.a.aaJT))
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
      aDG(12);
    }
    if (parama == null) {
      aDG(13);
    }
    if (paraman == null) {
      aDG(14);
    }
    if (paramg == null) {
      aDG(15);
    }
    paraml = new c(paraml, paramt, paramg, this.oJH, parama, paraman);
    paraml.Ji(iGr());
    paraml.Jj(iEK());
    AppMethodBeat.o(57702);
    return paraml;
  }
  
  public final void Ji(boolean paramBoolean)
  {
    AppMethodBeat.i(57699);
    this.aaTr = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(57699);
  }
  
  public final void Jj(boolean paramBoolean)
  {
    AppMethodBeat.i(57701);
    this.aaTs = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(57701);
  }
  
  public final boolean iEK()
  {
    AppMethodBeat.i(57700);
    if ((!$assertionsDisabled) && (this.aaTs == null))
    {
      AssertionError localAssertionError = new AssertionError("hasSynthesizedParameterNames was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57700);
      throw localAssertionError;
    }
    boolean bool = this.aaTs.booleanValue();
    AppMethodBeat.o(57700);
    return bool;
  }
  
  public final boolean iGr()
  {
    AppMethodBeat.i(57698);
    if ((!$assertionsDisabled) && (this.aaTr == null))
    {
      AssertionError localAssertionError = new AssertionError("hasStableParameterNames was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(57698);
      throw localAssertionError;
    }
    boolean bool = this.aaTr.booleanValue();
    AppMethodBeat.o(57698);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.b.c
 * JD-Core Version:    0.7.0.1
 */