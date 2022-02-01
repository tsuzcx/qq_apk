package rx.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import rx.j;

public final class b
  implements j
{
  public volatile boolean KrX;
  private Set<j> Kth;
  
  private static void x(Collection<j> paramCollection)
  {
    AppMethodBeat.i(90439);
    if (paramCollection == null)
    {
      AppMethodBeat.o(90439);
      return;
    }
    j localj = null;
    Iterator localIterator = paramCollection.iterator();
    paramCollection = localj;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label78;
      }
      localj = (j)localIterator.next();
      try
      {
        localj.fNw();
      }
      catch (Throwable localThrowable)
      {
        if (paramCollection != null) {
          break label88;
        }
      }
    }
    paramCollection = new ArrayList();
    label78:
    label88:
    for (;;)
    {
      paramCollection.add(localThrowable);
      break;
      rx.a.b.iV(paramCollection);
      AppMethodBeat.o(90439);
      return;
    }
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(90435);
    if (paramj.fNx())
    {
      AppMethodBeat.o(90435);
      return;
    }
    if (!this.KrX) {}
    try
    {
      if (!this.KrX)
      {
        if (this.Kth == null) {
          this.Kth = new HashSet(4);
        }
        this.Kth.add(paramj);
        return;
      }
      paramj.fNw();
      AppMethodBeat.o(90435);
      return;
    }
    finally
    {
      AppMethodBeat.o(90435);
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(90437);
    if (!this.KrX) {}
    try
    {
      if ((this.KrX) || (this.Kth == null)) {
        return;
      }
      Set localSet = this.Kth;
      this.Kth = null;
      x(localSet);
      AppMethodBeat.o(90437);
      return;
    }
    finally
    {
      AppMethodBeat.o(90437);
    }
  }
  
  public final void e(j paramj)
  {
    AppMethodBeat.i(90436);
    if (!this.KrX) {}
    try
    {
      if ((this.KrX) || (this.Kth == null)) {
        return;
      }
      boolean bool = this.Kth.remove(paramj);
      if (bool) {
        paramj.fNw();
      }
      AppMethodBeat.o(90436);
      return;
    }
    finally
    {
      AppMethodBeat.o(90436);
    }
  }
  
  public final void fNw()
  {
    AppMethodBeat.i(90438);
    if (!this.KrX) {}
    try
    {
      if (this.KrX) {
        return;
      }
      this.KrX = true;
      Set localSet = this.Kth;
      this.Kth = null;
      x(localSet);
      AppMethodBeat.o(90438);
      return;
    }
    finally
    {
      AppMethodBeat.o(90438);
    }
  }
  
  public final boolean fNx()
  {
    return this.KrX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.f.b
 * JD-Core Version:    0.7.0.1
 */