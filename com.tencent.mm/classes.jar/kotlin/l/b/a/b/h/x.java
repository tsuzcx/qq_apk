package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class x
  extends AbstractList<String>
  implements RandomAccess, o
{
  private final o TEm;
  
  public x(o paramo)
  {
    this.TEm = paramo;
  }
  
  public final List<?> GQ()
  {
    AppMethodBeat.i(59633);
    List localList = this.TEm.GQ();
    AppMethodBeat.o(59633);
    return localList;
  }
  
  public final d avC(int paramInt)
  {
    AppMethodBeat.i(59629);
    d locald = this.TEm.avC(paramInt);
    AppMethodBeat.o(59629);
    return locald;
  }
  
  public final void f(d paramd)
  {
    AppMethodBeat.i(59630);
    paramd = new UnsupportedOperationException();
    AppMethodBeat.o(59630);
    throw paramd;
  }
  
  public final o hJM()
  {
    return this;
  }
  
  public final Iterator<String> iterator()
  {
    AppMethodBeat.i(59632);
    Iterator local2 = new Iterator()
    {
      Iterator<String> bWx;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(59625);
        boolean bool = this.bWx.hasNext();
        AppMethodBeat.o(59625);
        return bool;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(59626);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(59626);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(59632);
    return local2;
  }
  
  public final ListIterator<String> listIterator(final int paramInt)
  {
    AppMethodBeat.i(59631);
    ListIterator local1 = new ListIterator()
    {
      ListIterator<String> cac;
      
      public final boolean hasNext()
      {
        AppMethodBeat.i(59615);
        boolean bool = this.cac.hasNext();
        AppMethodBeat.o(59615);
        return bool;
      }
      
      public final boolean hasPrevious()
      {
        AppMethodBeat.i(59616);
        boolean bool = this.cac.hasPrevious();
        AppMethodBeat.o(59616);
        return bool;
      }
      
      public final int nextIndex()
      {
        AppMethodBeat.i(59617);
        int i = this.cac.nextIndex();
        AppMethodBeat.o(59617);
        return i;
      }
      
      public final int previousIndex()
      {
        AppMethodBeat.i(59618);
        int i = this.cac.previousIndex();
        AppMethodBeat.o(59618);
        return i;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(59619);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(59619);
        throw localUnsupportedOperationException;
      }
    };
    AppMethodBeat.o(59631);
    return local1;
  }
  
  public final int size()
  {
    AppMethodBeat.i(59628);
    int i = this.TEm.size();
    AppMethodBeat.o(59628);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.h.x
 * JD-Core Version:    0.7.0.1
 */