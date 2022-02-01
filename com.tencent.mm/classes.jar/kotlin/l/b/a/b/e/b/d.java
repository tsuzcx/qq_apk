package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.a.n;
import kotlin.l.b.a.b.e.a.n.b;
import kotlin.l.b.a.b.e.a.n.b.b;
import kotlin.l.b.a.b.e.a.o;
import kotlin.r;

public final class d
  implements c
{
  private final a.o TBH;
  private final a.n TBI;
  
  public d(a.o paramo, a.n paramn)
  {
    AppMethodBeat.i(59068);
    this.TBH = paramo;
    this.TBI = paramn;
    AppMethodBeat.o(59068);
  }
  
  private final r<List<String>, List<String>, Boolean> avn(int paramInt)
  {
    AppMethodBeat.i(59067);
    Object localObject1 = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    boolean bool = false;
    if (paramInt != -1)
    {
      a.n.b localb = this.TBI.auC(paramInt);
      Object localObject2 = this.TBH;
      p.g(localb, "proto");
      localObject2 = ((a.o)localObject2).getString(localb.Tzb);
      a.n.b.b localb1 = localb.Tzc;
      if (localb1 == null) {
        p.hyc();
      }
      switch (e.$EnumSwitchMapping$0[localb1.ordinal()])
      {
      }
      for (;;)
      {
        paramInt = localb.Tza;
        break;
        localLinkedList.addFirst(localObject2);
        continue;
        ((LinkedList)localObject1).addFirst(localObject2);
        continue;
        localLinkedList.addFirst(localObject2);
        bool = true;
      }
    }
    localObject1 = new r(localObject1, localLinkedList, Boolean.valueOf(bool));
    AppMethodBeat.o(59067);
    return localObject1;
  }
  
  public final String avl(int paramInt)
  {
    AppMethodBeat.i(59065);
    Object localObject2 = avn(paramInt);
    Object localObject1 = (List)((r)localObject2).first;
    localObject2 = j.a((Iterable)((r)localObject2).second, (CharSequence)".", null, null, 0, null, null, 62);
    if (((List)localObject1).isEmpty())
    {
      AppMethodBeat.o(59065);
      return localObject2;
    }
    localObject1 = j.a((Iterable)localObject1, (CharSequence)"/", null, null, 0, null, null, 62) + '/' + (String)localObject2;
    AppMethodBeat.o(59065);
    return localObject1;
  }
  
  public final boolean avm(int paramInt)
  {
    AppMethodBeat.i(59066);
    boolean bool = ((Boolean)avn(paramInt).SWY).booleanValue();
    AppMethodBeat.o(59066);
    return bool;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(59064);
    String str = this.TBH.getString(paramInt);
    p.g(str, "strings.getString(index)");
    AppMethodBeat.o(59064);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.d
 * JD-Core Version:    0.7.0.1
 */