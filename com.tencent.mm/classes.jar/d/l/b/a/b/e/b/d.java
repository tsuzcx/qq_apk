package d.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l.b.a.b.e.a.n;
import d.l.b.a.b.e.a.n.b;
import d.l.b.a.b.e.a.n.b.b;
import d.l.b.a.b.e.a.o;
import d.t;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements c
{
  private final a.o NoX;
  private final a.n NoY;
  
  public d(a.o paramo, a.n paramn)
  {
    AppMethodBeat.i(59068);
    this.NoX = paramo;
    this.NoY = paramn;
    AppMethodBeat.o(59068);
  }
  
  private final t<List<String>, List<String>, Boolean> akN(int paramInt)
  {
    AppMethodBeat.i(59067);
    Object localObject1 = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    boolean bool = false;
    if (paramInt != -1)
    {
      a.n.b localb = this.NoY.akc(paramInt);
      Object localObject2 = this.NoX;
      p.g(localb, "proto");
      localObject2 = ((a.o)localObject2).getString(localb.Nmt);
      a.n.b.b localb1 = localb.Nmu;
      if (localb1 == null) {
        p.gfZ();
      }
      switch (e.cpQ[localb1.ordinal()])
      {
      }
      for (;;)
      {
        paramInt = localb.Nms;
        break;
        localLinkedList.addFirst(localObject2);
        continue;
        ((LinkedList)localObject1).addFirst(localObject2);
        continue;
        localLinkedList.addFirst(localObject2);
        bool = true;
      }
    }
    localObject1 = new t(localObject1, localLinkedList, Boolean.valueOf(bool));
    AppMethodBeat.o(59067);
    return localObject1;
  }
  
  public final String akL(int paramInt)
  {
    AppMethodBeat.i(59065);
    Object localObject2 = akN(paramInt);
    Object localObject1 = (List)((t)localObject2).first;
    localObject2 = j.a((Iterable)((t)localObject2).second, (CharSequence)".", null, null, 0, null, null, 62);
    if (((List)localObject1).isEmpty())
    {
      AppMethodBeat.o(59065);
      return localObject2;
    }
    localObject1 = j.a((Iterable)localObject1, (CharSequence)"/", null, null, 0, null, null, 62) + '/' + (String)localObject2;
    AppMethodBeat.o(59065);
    return localObject1;
  }
  
  public final boolean akM(int paramInt)
  {
    AppMethodBeat.i(59066);
    boolean bool = ((Boolean)akN(paramInt).MKl).booleanValue();
    AppMethodBeat.o(59066);
    return bool;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(59064);
    String str = this.NoX.getString(paramInt);
    p.g(str, "strings.getString(index)");
    AppMethodBeat.o(59064);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.b.d
 * JD-Core Version:    0.7.0.1
 */