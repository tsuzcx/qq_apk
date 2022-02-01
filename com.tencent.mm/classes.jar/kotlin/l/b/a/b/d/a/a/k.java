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
  public static final k aaTk = new k()
  {
    public final k.a a(q paramAnonymousq, e paramAnonymouse, ab paramAnonymousab, List<av> paramAnonymousList, List<as> paramAnonymousList1)
    {
      AppMethodBeat.i(57688);
      if (paramAnonymousq == null) {
        aDG(0);
      }
      if (paramAnonymouse == null) {
        aDG(1);
      }
      if (paramAnonymousab == null) {
        aDG(2);
      }
      if (paramAnonymousList == null) {
        aDG(3);
      }
      if (paramAnonymousList1 == null) {
        aDG(4);
      }
      paramAnonymousq = new k.a(paramAnonymousab, paramAnonymousList, paramAnonymousList1, Collections.emptyList());
      AppMethodBeat.o(57688);
      return paramAnonymousq;
    }
    
    public final void a(b paramAnonymousb, List<String> paramAnonymousList)
    {
      AppMethodBeat.i(57689);
      if (paramAnonymousb == null) {
        aDG(5);
      }
      if (paramAnonymousList == null) {
        aDG(6);
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
    public final List<as> aaKr;
    public final boolean aaNP;
    public final ab aaPa;
    public final ab aaTl;
    public final List<av> aaTm;
    public final List<String> aaTn;
    
    public a(ab paramab, List<av> paramList, List<as> paramList1, List<String> paramList2)
    {
      AppMethodBeat.i(57691);
      this.aaPa = paramab;
      this.aaTl = null;
      this.aaTm = paramList;
      this.aaKr = paramList1;
      this.aaTn = paramList2;
      this.aaNP = false;
      AppMethodBeat.o(57691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.a.k
 * JD-Core Version:    0.7.0.1
 */