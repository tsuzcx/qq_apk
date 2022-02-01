package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class o
  extends AbstractList<String>
  implements RandomAccess, p
{
  public static final p abgz;
  private final List<Object> list;
  
  static
  {
    AppMethodBeat.i(59516);
    abgz = new o().iOd();
    AppMethodBeat.o(59516);
  }
  
  public o()
  {
    AppMethodBeat.i(59501);
    this.list = new ArrayList();
    AppMethodBeat.o(59501);
  }
  
  public o(p paramp)
  {
    AppMethodBeat.i(59502);
    this.list = new ArrayList(paramp.size());
    addAll(paramp);
    AppMethodBeat.o(59502);
  }
  
  private static String ap(Object paramObject)
  {
    AppMethodBeat.i(59509);
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      AppMethodBeat.o(59509);
      return paramObject;
    }
    if ((paramObject instanceof d))
    {
      paramObject = ((d)paramObject).Ap();
      AppMethodBeat.o(59509);
      return paramObject;
    }
    paramObject = k.E((byte[])paramObject);
    AppMethodBeat.o(59509);
    return paramObject;
  }
  
  public final List<?> Iw()
  {
    AppMethodBeat.i(59510);
    List localList = Collections.unmodifiableList(this.list);
    AppMethodBeat.o(59510);
    return localList;
  }
  
  public final d aFw(int paramInt)
  {
    AppMethodBeat.i(59508);
    Object localObject = this.list.get(paramInt);
    d locald;
    if ((localObject instanceof d)) {
      locald = (d)localObject;
    }
    for (;;)
    {
      if (locald != localObject) {
        this.list.set(paramInt, locald);
      }
      AppMethodBeat.o(59508);
      return locald;
      if ((localObject instanceof String)) {
        locald = d.bHg((String)localObject);
      } else {
        locald = d.dG((byte[])localObject);
      }
    }
  }
  
  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    AppMethodBeat.i(59505);
    Object localObject = paramCollection;
    if ((paramCollection instanceof p)) {
      localObject = ((p)paramCollection).Iw();
    }
    boolean bool = this.list.addAll(paramInt, (Collection)localObject);
    this.modCount += 1;
    AppMethodBeat.o(59505);
    return bool;
  }
  
  public final boolean addAll(Collection<? extends String> paramCollection)
  {
    AppMethodBeat.i(59504);
    boolean bool = addAll(size(), paramCollection);
    AppMethodBeat.o(59504);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(59506);
    this.list.clear();
    this.modCount += 1;
    AppMethodBeat.o(59506);
  }
  
  public final void f(d paramd)
  {
    AppMethodBeat.i(59507);
    this.list.add(paramd);
    this.modCount += 1;
    AppMethodBeat.o(59507);
  }
  
  public final p iOd()
  {
    AppMethodBeat.i(59511);
    y localy = new y(this);
    AppMethodBeat.o(59511);
    return localy;
  }
  
  public final int size()
  {
    AppMethodBeat.i(59503);
    int i = this.list.size();
    AppMethodBeat.o(59503);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.h.o
 * JD-Core Version:    0.7.0.1
 */