package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.b.ay;
import kotlin.l.b.a.b.b.ay.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.l.m;

public final class j
  extends b
{
  private final List<ba> aiED;
  private final e aiHo;
  private final Collection<ad> aiLA;
  
  public j(e parame, List<? extends ba> paramList, Collection<ad> paramCollection, m paramm)
  {
    super(paramm);
    AppMethodBeat.i(60613);
    this.aiHo = parame;
    this.aiED = Collections.unmodifiableList(new ArrayList(paramList));
    this.aiLA = Collections.unmodifiableCollection(paramCollection);
    AppMethodBeat.o(60613);
  }
  
  public final List<ba> klq()
  {
    AppMethodBeat.i(60614);
    List localList = this.aiED;
    if (localList == null) {
      aKu(4);
    }
    AppMethodBeat.o(60614);
    return localList;
  }
  
  protected final Collection<ad> knw()
  {
    AppMethodBeat.i(60617);
    Collection localCollection = this.aiLA;
    if (localCollection == null) {
      aKu(6);
    }
    AppMethodBeat.o(60617);
    return localCollection;
  }
  
  public final boolean knx()
  {
    return true;
  }
  
  protected final ay kny()
  {
    AppMethodBeat.i(60618);
    ay.a locala = ay.a.aiHw;
    if (locala == null) {
      aKu(7);
    }
    AppMethodBeat.o(60618);
    return locala;
  }
  
  public final e knz()
  {
    AppMethodBeat.i(60616);
    e locale = this.aiHo;
    if (locale == null) {
      aKu(5);
    }
    AppMethodBeat.o(60616);
    return locale;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60615);
    String str = kotlin.l.b.a.b.j.d.n(this.aiHo).PF();
    AppMethodBeat.o(60615);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.j
 * JD-Core Version:    0.7.0.1
 */