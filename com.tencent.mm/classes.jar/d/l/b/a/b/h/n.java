package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class n
  extends AbstractList<String>
  implements o, RandomAccess
{
  public static final o JNg;
  private final List<Object> list;
  
  static
  {
    AppMethodBeat.i(59516);
    JNg = new n().fHX();
    AppMethodBeat.o(59516);
  }
  
  public n()
  {
    AppMethodBeat.i(59501);
    this.list = new ArrayList();
    AppMethodBeat.o(59501);
  }
  
  public n(o paramo)
  {
    AppMethodBeat.i(59502);
    this.list = new ArrayList(paramo.size());
    addAll(paramo);
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
      paramObject = ((d)paramObject).eBA();
      AppMethodBeat.o(59509);
      return paramObject;
    }
    paramObject = j.cX((byte[])paramObject);
    AppMethodBeat.o(59509);
    return paramObject;
  }
  
  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    AppMethodBeat.i(59505);
    Object localObject = paramCollection;
    if ((paramCollection instanceof o)) {
      localObject = ((o)paramCollection).fHW();
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
  
  public final d afJ(int paramInt)
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
        locald = d.aQH((String)localObject);
      } else {
        locald = d.cT((byte[])localObject);
      }
    }
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
  
  public final List<?> fHW()
  {
    AppMethodBeat.i(59510);
    List localList = Collections.unmodifiableList(this.list);
    AppMethodBeat.o(59510);
    return localList;
  }
  
  public final o fHX()
  {
    AppMethodBeat.i(59511);
    x localx = new x(this);
    AppMethodBeat.o(59511);
    return localx;
  }
  
  public final int size()
  {
    AppMethodBeat.i(59503);
    int i = this.list.size();
    AppMethodBeat.o(59503);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.h.n
 * JD-Core Version:    0.7.0.1
 */