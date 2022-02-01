package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.d.a.e.q;
import kotlin.l.b.a.b.m.ab;

public abstract interface k
{
  public static final k Tqq = new k()
  {
    public final k.a a(q paramAnonymousq, e paramAnonymouse, ab paramAnonymousab, List<av> paramAnonymousList, List<as> paramAnonymousList1)
    {
      AppMethodBeat.i(57688);
      if (paramAnonymousq == null) {
        atM(0);
      }
      if (paramAnonymouse == null) {
        atM(1);
      }
      if (paramAnonymousab == null) {
        atM(2);
      }
      if (paramAnonymousList == null) {
        atM(3);
      }
      if (paramAnonymousList1 == null) {
        atM(4);
      }
      paramAnonymousq = new k.a(paramAnonymousab, paramAnonymousList, paramAnonymousList1, Collections.emptyList());
      AppMethodBeat.o(57688);
      return paramAnonymousq;
    }
    
    public final void a(b paramAnonymousb, List<String> paramAnonymousList)
    {
      AppMethodBeat.i(57689);
      if (paramAnonymousb == null) {
        atM(5);
      }
      if (paramAnonymousList == null) {
        atM(6);
      }
      paramAnonymousb = new UnsupportedOperationException("Should not be called");
      AppMethodBeat.o(57689);
      throw paramAnonymousb;
    }
  };
  
  public abstract a a(q paramq, e parame, ab paramab, List<av> paramList, List<as> paramList1);
  
  public abstract void a(b paramb, List<String> paramList);
  
  public static final class a
  {
    public final List<as> Thx;
    public final boolean TkV;
    public final ab Tmg;
    public final ab Tqr;
    public final List<av> Tqs;
    public final List<String> Tqt;
    
    public a(ab paramab, List<av> paramList, List<as> paramList1, List<String> paramList2)
    {
      AppMethodBeat.i(57691);
      this.Tmg = paramab;
      this.Tqr = null;
      this.Tqs = paramList;
      this.Thx = paramList1;
      this.Tqt = paramList2;
      this.TkV = false;
      AppMethodBeat.o(57691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.a.k
 * JD-Core Version:    0.7.0.1
 */