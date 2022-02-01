package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.e.a.n;
import kotlin.l.b.a.b.e.a.n.b;
import kotlin.l.b.a.b.e.a.n.b.b;
import kotlin.l.b.a.b.e.a.o;
import kotlin.u;

public final class d
  implements c
{
  private final a.o ajda;
  private final a.n ajdb;
  
  public d(a.o paramo, a.n paramn)
  {
    AppMethodBeat.i(59068);
    this.ajda = paramo;
    this.ajdb = paramn;
    AppMethodBeat.o(59068);
  }
  
  private final u<List<String>, List<String>, Boolean> aLY(int paramInt)
  {
    AppMethodBeat.i(59067);
    Object localObject = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    boolean bool = false;
    if (paramInt != -1)
    {
      a.n.b localb = this.ajdb.aLn(paramInt);
      String str = this.ajda.getString(localb.ajat);
      a.n.b.b localb1 = localb.ajau;
      s.checkNotNull(localb1);
      switch (a.$EnumSwitchMapping$0[localb1.ordinal()])
      {
      }
      for (;;)
      {
        paramInt = localb.ajas;
        break;
        localLinkedList.addFirst(str);
        continue;
        ((LinkedList)localObject).addFirst(str);
        continue;
        localLinkedList.addFirst(str);
        bool = true;
      }
    }
    localObject = new u(localObject, localLinkedList, Boolean.valueOf(bool));
    AppMethodBeat.o(59067);
    return localObject;
  }
  
  public final String aLW(int paramInt)
  {
    AppMethodBeat.i(59065);
    Object localObject2 = aLY(paramInt);
    Object localObject1 = (List)((u)localObject2).bsC;
    localObject2 = p.a((Iterable)((u)localObject2).bsD, (CharSequence)".", null, null, 0, null, null, 62);
    if (((List)localObject1).isEmpty())
    {
      AppMethodBeat.o(59065);
      return localObject2;
    }
    localObject1 = p.a((Iterable)localObject1, (CharSequence)"/", null, null, 0, null, null, 62) + '/' + (String)localObject2;
    AppMethodBeat.o(59065);
    return localObject1;
  }
  
  public final boolean aLX(int paramInt)
  {
    AppMethodBeat.i(59066);
    boolean bool = ((Boolean)aLY(paramInt).aiuN).booleanValue();
    AppMethodBeat.o(59066);
    return bool;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(59064);
    String str = this.ajda.getString(paramInt);
    s.s(str, "strings.getString(index)");
    AppMethodBeat.o(59064);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.d
 * JD-Core Version:    0.7.0.1
 */