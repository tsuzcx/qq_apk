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
  public static final k NAI = new k()
  {
    public final k.a a(q paramAnonymousq, e paramAnonymouse, ab paramAnonymousab, List<av> paramAnonymousList, List<as> paramAnonymousList1)
    {
      AppMethodBeat.i(57688);
      if (paramAnonymousq == null) {
        ajW(0);
      }
      if (paramAnonymouse == null) {
        ajW(1);
      }
      if (paramAnonymousab == null) {
        ajW(2);
      }
      if (paramAnonymousList == null) {
        ajW(3);
      }
      if (paramAnonymousList1 == null) {
        ajW(4);
      }
      paramAnonymousq = new k.a(paramAnonymousab, paramAnonymousList, paramAnonymousList1, Collections.emptyList());
      AppMethodBeat.o(57688);
      return paramAnonymousq;
    }
    
    public final void a(b paramAnonymousb, List<String> paramAnonymousList)
    {
      AppMethodBeat.i(57689);
      if (paramAnonymousb == null) {
        ajW(5);
      }
      if (paramAnonymousList == null) {
        ajW(6);
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
    public final ab NAJ;
    public final List<av> NAK;
    public final List<String> NAL;
    public final List<as> NrP;
    public final boolean Nvn;
    public final ab Nwy;
    
    public a(ab paramab, List<av> paramList, List<as> paramList1, List<String> paramList2)
    {
      AppMethodBeat.i(57691);
      this.Nwy = paramab;
      this.NAJ = null;
      this.NAK = paramList;
      this.NrP = paramList1;
      this.NAL = paramList2;
      this.Nvn = false;
      AppMethodBeat.o(57691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.a.k
 * JD-Core Version:    0.7.0.1
 */