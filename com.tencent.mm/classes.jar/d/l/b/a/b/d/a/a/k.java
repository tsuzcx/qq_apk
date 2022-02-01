package d.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.b;
import d.l.b.a.b.b.e;
import d.l.b.a.b.d.a.e.q;
import d.l.b.a.b.m.ab;
import java.util.Collections;
import java.util.List;

public abstract interface k
{
  public static final k NdD = new k()
  {
    public final k.a a(q paramAnonymousq, e paramAnonymouse, ab paramAnonymousab, List<av> paramAnonymousList, List<as> paramAnonymousList1)
    {
      AppMethodBeat.i(57688);
      if (paramAnonymousq == null) {
        ajm(0);
      }
      if (paramAnonymouse == null) {
        ajm(1);
      }
      if (paramAnonymousab == null) {
        ajm(2);
      }
      if (paramAnonymousList == null) {
        ajm(3);
      }
      if (paramAnonymousList1 == null) {
        ajm(4);
      }
      paramAnonymousq = new k.a(paramAnonymousab, paramAnonymousList, paramAnonymousList1, Collections.emptyList());
      AppMethodBeat.o(57688);
      return paramAnonymousq;
    }
    
    public final void a(b paramAnonymousb, List<String> paramAnonymousList)
    {
      AppMethodBeat.i(57689);
      if (paramAnonymousb == null) {
        ajm(5);
      }
      if (paramAnonymousList == null) {
        ajm(6);
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
    public final List<as> MUK;
    public final boolean MYh;
    public final ab MZs;
    public final ab NdE;
    public final List<av> NdF;
    public final List<String> NdG;
    
    public a(ab paramab, List<av> paramList, List<as> paramList1, List<String> paramList2)
    {
      AppMethodBeat.i(57691);
      this.MZs = paramab;
      this.NdE = null;
      this.NdF = paramList;
      this.MUK = paramList1;
      this.NdG = paramList2;
      this.MYh = false;
      AppMethodBeat.o(57691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.a.k
 * JD-Core Version:    0.7.0.1
 */