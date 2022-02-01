package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.d.a.e.q;
import kotlin.l.b.a.b.m.ad;

public abstract interface j
{
  public static final j aiRk = new j()
  {
    public final j.a a(q paramAnonymousq, e paramAnonymouse, ad paramAnonymousad, List<bd> paramAnonymousList, List<ba> paramAnonymousList1)
    {
      AppMethodBeat.i(57688);
      if (paramAnonymousq == null) {
        aKu(0);
      }
      if (paramAnonymouse == null) {
        aKu(1);
      }
      if (paramAnonymousad == null) {
        aKu(2);
      }
      if (paramAnonymousList == null) {
        aKu(3);
      }
      if (paramAnonymousList1 == null) {
        aKu(4);
      }
      paramAnonymousq = new j.a(paramAnonymousad, paramAnonymousList, paramAnonymousList1, Collections.emptyList());
      AppMethodBeat.o(57688);
      return paramAnonymousq;
    }
    
    public final void a(b paramAnonymousb, List<String> paramAnonymousList)
    {
      AppMethodBeat.i(57689);
      if (paramAnonymousb == null) {
        aKu(5);
      }
      if (paramAnonymousList == null) {
        aKu(6);
      }
      paramAnonymousb = new UnsupportedOperationException("Should not be called");
      AppMethodBeat.o(57689);
      throw paramAnonymousb;
    }
  };
  
  public abstract a a(q paramq, e parame, ad paramad, List<bd> paramList, List<ba> paramList1);
  
  public abstract void a(b paramb, List<String> paramList);
  
  public static final class a
  {
    public final boolean aiKA;
    public final List<ba> aiKl;
    public final ad aiLR;
    public final ad aiRl;
    public final List<bd> aiRm;
    public final List<String> aiRn;
    
    public a(ad paramad, List<bd> paramList, List<ba> paramList1, List<String> paramList2)
    {
      AppMethodBeat.i(57691);
      this.aiLR = paramad;
      this.aiRl = null;
      this.aiRm = paramList;
      this.aiKl = paramList1;
      this.aiRn = paramList2;
      this.aiKA = false;
      AppMethodBeat.o(57691);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.a.j
 * JD-Core Version:    0.7.0.1
 */