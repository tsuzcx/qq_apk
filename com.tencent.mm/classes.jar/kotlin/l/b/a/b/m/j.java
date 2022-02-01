package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.aq.a;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;

public final class j
  extends b
  implements at
{
  private final e ThF;
  private final Collection<ab> TlT;
  private final List<as> parameters;
  
  public j(e parame, List<? extends as> paramList, Collection<ab> paramCollection, kotlin.l.b.a.b.l.j paramj)
  {
    super(paramj);
    AppMethodBeat.i(60613);
    this.ThF = parame;
    this.parameters = Collections.unmodifiableList(new ArrayList(paramList));
    this.TlT = Collections.unmodifiableCollection(paramCollection);
    AppMethodBeat.o(60613);
  }
  
  public final List<as> getParameters()
  {
    AppMethodBeat.i(60614);
    List localList = this.parameters;
    if (localList == null) {
      atM(4);
    }
    AppMethodBeat.o(60614);
    return localList;
  }
  
  protected final Collection<ab> hzR()
  {
    AppMethodBeat.i(60617);
    Collection localCollection = this.TlT;
    if (localCollection == null) {
      atM(6);
    }
    AppMethodBeat.o(60617);
    return localCollection;
  }
  
  public final e hzT()
  {
    AppMethodBeat.i(60616);
    e locale = this.ThF;
    if (locale == null) {
      atM(5);
    }
    AppMethodBeat.o(60616);
    return locale;
  }
  
  public final boolean hzU()
  {
    return true;
  }
  
  protected final aq hzV()
  {
    AppMethodBeat.i(60618);
    aq.a locala = aq.a.ThM;
    if (locala == null) {
      atM(7);
    }
    AppMethodBeat.o(60618);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60615);
    String str = kotlin.l.b.a.b.j.c.n(this.ThF).sG();
    AppMethodBeat.o(60615);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.j
 * JD-Core Version:    0.7.0.1
 */