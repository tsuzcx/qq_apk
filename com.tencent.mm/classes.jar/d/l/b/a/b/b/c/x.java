package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.d;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.w;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.j.f.h.b;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.at;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class x
  extends g
{
  private final d.l.b.a.b.l.i JlL;
  private List<as> Jqw;
  private final boolean Jqy;
  private ba JtI;
  private w Jtn;
  private final d.l.b.a.b.b.f Jto;
  private at Jtp;
  private final Collection<ab> JuQ;
  
  static
  {
    AppMethodBeat.i(57210);
    if (!x.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(57210);
      return;
    }
  }
  
  public x(l paraml, d.l.b.a.b.b.f paramf, d.l.b.a.b.f.f paramf1, an paraman, d.l.b.a.b.l.i parami)
  {
    super(parami, paraml, paramf1, paraman);
    AppMethodBeat.i(57193);
    this.JuQ = new ArrayList();
    this.JlL = parami;
    if ((!$assertionsDisabled) && (paramf == d.l.b.a.b.b.f.Jqi))
    {
      paraml = new AssertionError("Fix isCompanionObject()");
      AppMethodBeat.o(57193);
      throw paraml;
    }
    this.Jto = paramf;
    this.Jqy = false;
    AppMethodBeat.o(57193);
  }
  
  private static Set<d> fAf()
  {
    AppMethodBeat.i(57201);
    Set localSet = Collections.emptySet();
    if (localSet == null) {
      adP(13);
    }
    AppMethodBeat.o(57201);
    return localSet;
  }
  
  public final h a(d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(57205);
    if (parami == null) {
      adP(16);
    }
    parami = h.b.JTG;
    if (parami == null) {
      adP(17);
    }
    AppMethodBeat.o(57205);
    return parami;
  }
  
  public final void b(w paramw)
  {
    AppMethodBeat.i(57195);
    if (paramw == null) {
      adP(6);
    }
    if ((!$assertionsDisabled) && (paramw == w.Jqo))
    {
      paramw = new AssertionError("Implement getSealedSubclasses() for this class: " + getClass());
      AppMethodBeat.o(57195);
      throw paramw;
    }
    this.Jtn = paramw;
    AppMethodBeat.o(57195);
  }
  
  public final void d(ba paramba)
  {
    AppMethodBeat.i(57198);
    if (paramba == null) {
      adP(9);
    }
    this.JtI = paramba;
    AppMethodBeat.o(57198);
  }
  
  public final void fAg()
  {
    AppMethodBeat.i(57204);
    if ((!$assertionsDisabled) && (this.Jtp != null))
    {
      localObject = new AssertionError(this.Jtp);
      AppMethodBeat.o(57204);
      throw ((Throwable)localObject);
    }
    this.Jtp = new d.l.b.a.b.m.j(this, this.Jqw, this.JuQ, this.JlL);
    Object localObject = fAf().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((f)((Iterator)localObject).next()).J(fyA());
    }
    AppMethodBeat.o(57204);
  }
  
  public final boolean fxA()
  {
    return false;
  }
  
  public final boolean fxB()
  {
    return false;
  }
  
  public final boolean fxC()
  {
    return false;
  }
  
  public final boolean fxD()
  {
    return false;
  }
  
  public final d.l.b.a.b.b.a.g fxF()
  {
    AppMethodBeat.i(57194);
    Object localObject = d.l.b.a.b.b.a.g.JrB;
    localObject = g.a.fzI();
    if (localObject == null) {
      adP(5);
    }
    AppMethodBeat.o(57194);
    return localObject;
  }
  
  public final Collection<e> fxH()
  {
    AppMethodBeat.i(57207);
    List localList = Collections.emptyList();
    if (localList == null) {
      adP(19);
    }
    AppMethodBeat.o(57207);
    return localList;
  }
  
  public final List<as> fxI()
  {
    AppMethodBeat.i(57203);
    List localList = this.Jqw;
    if (localList == null) {
      adP(15);
    }
    AppMethodBeat.o(57203);
    return localList;
  }
  
  public final h fxr()
  {
    AppMethodBeat.i(57206);
    h.b localb = h.b.JTG;
    if (localb == null) {
      adP(18);
    }
    AppMethodBeat.o(57206);
    return localb;
  }
  
  public final at fxs()
  {
    AppMethodBeat.i(57200);
    at localat = this.Jtp;
    if (localat == null) {
      adP(11);
    }
    AppMethodBeat.o(57200);
    return localat;
  }
  
  public final e fxt()
  {
    return null;
  }
  
  public final d.l.b.a.b.b.f fxu()
  {
    AppMethodBeat.i(57197);
    d.l.b.a.b.b.f localf = this.Jto;
    if (localf == null) {
      adP(8);
    }
    AppMethodBeat.o(57197);
    return localf;
  }
  
  public final w fxv()
  {
    AppMethodBeat.i(57196);
    w localw = this.Jtn;
    if (localw == null) {
      adP(7);
    }
    AppMethodBeat.o(57196);
    return localw;
  }
  
  public final d fxw()
  {
    return null;
  }
  
  public final ba fxx()
  {
    AppMethodBeat.i(57199);
    ba localba = this.JtI;
    if (localba == null) {
      adP(10);
    }
    AppMethodBeat.o(57199);
    return localba;
  }
  
  public final boolean fxy()
  {
    return false;
  }
  
  public final boolean fxz()
  {
    return this.Jqy;
  }
  
  public final void iK(List<as> paramList)
  {
    AppMethodBeat.i(57202);
    if (paramList == null) {
      adP(14);
    }
    if (this.Jqw != null)
    {
      paramList = new IllegalStateException("Type parameters are already set for " + fyB());
      AppMethodBeat.o(57202);
      throw paramList;
    }
    this.Jqw = new ArrayList(paramList);
    AppMethodBeat.o(57202);
  }
  
  public String toString()
  {
    AppMethodBeat.i(57208);
    String str = j.i(this);
    AppMethodBeat.o(57208);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.x
 * JD-Core Version:    0.7.0.1
 */