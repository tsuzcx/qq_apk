package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.aq;
import d.l.b.a.b.b.aq.a;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class j
  extends b
  implements at
{
  private final e NrX;
  private final Collection<ab> Nwl;
  private final List<as> parameters;
  
  public j(e parame, List<? extends as> paramList, Collection<ab> paramCollection, d.l.b.a.b.l.j paramj)
  {
    super(paramj);
    AppMethodBeat.i(60613);
    this.NrX = parame;
    this.parameters = Collections.unmodifiableList(new ArrayList(paramList));
    this.Nwl = Collections.unmodifiableCollection(paramCollection);
    AppMethodBeat.o(60613);
  }
  
  public final List<as> getParameters()
  {
    AppMethodBeat.i(60614);
    List localList = this.parameters;
    if (localList == null) {
      ajW(4);
    }
    AppMethodBeat.o(60614);
    return localList;
  }
  
  protected final Collection<ab> gmp()
  {
    AppMethodBeat.i(60617);
    Collection localCollection = this.Nwl;
    if (localCollection == null) {
      ajW(6);
    }
    AppMethodBeat.o(60617);
    return localCollection;
  }
  
  public final e gmr()
  {
    AppMethodBeat.i(60616);
    e locale = this.NrX;
    if (locale == null) {
      ajW(5);
    }
    AppMethodBeat.o(60616);
    return locale;
  }
  
  public final boolean gms()
  {
    return true;
  }
  
  protected final aq gmt()
  {
    AppMethodBeat.i(60618);
    aq.a locala = aq.a.Nse;
    if (locala == null) {
      ajW(7);
    }
    AppMethodBeat.o(60618);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60615);
    String str = d.l.b.a.b.j.c.n(this.NrX).sD();
    AppMethodBeat.o(60615);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.j
 * JD-Core Version:    0.7.0.1
 */