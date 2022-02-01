package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.aq;
import d.l.b.a.b.b.aq.a;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.e;
import d.l.b.a.b.l.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class j
  extends b
  implements at
{
  private final e JqE;
  private final Collection<ab> JuQ;
  private final List<as> parameters;
  
  public j(e parame, List<? extends as> paramList, Collection<ab> paramCollection, i parami)
  {
    super(parami);
    AppMethodBeat.i(60613);
    this.JqE = parame;
    this.parameters = Collections.unmodifiableList(new ArrayList(paramList));
    this.JuQ = Collections.unmodifiableCollection(paramCollection);
    AppMethodBeat.o(60613);
  }
  
  protected final Collection<ab> fxL()
  {
    AppMethodBeat.i(60617);
    Collection localCollection = this.JuQ;
    if (localCollection == null) {
      adP(6);
    }
    AppMethodBeat.o(60617);
    return localCollection;
  }
  
  public final e fxN()
  {
    AppMethodBeat.i(60616);
    e locale = this.JqE;
    if (locale == null) {
      adP(5);
    }
    AppMethodBeat.o(60616);
    return locale;
  }
  
  public final boolean fxO()
  {
    return true;
  }
  
  protected final aq fxP()
  {
    AppMethodBeat.i(60618);
    aq.a locala = aq.a.JqL;
    if (locala == null) {
      adP(7);
    }
    AppMethodBeat.o(60618);
    return locala;
  }
  
  public final List<as> getParameters()
  {
    AppMethodBeat.i(60614);
    List localList = this.parameters;
    if (localList == null) {
      adP(4);
    }
    AppMethodBeat.o(60614);
    return localList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60615);
    String str = d.l.b.a.b.j.c.n(this.JqE).qV();
    AppMethodBeat.o(60615);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.j
 * JD-Core Version:    0.7.0.1
 */