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
  public volatile boolean OxN;
  private Set<j> OyX;
  
  private static void z(Collection<j> paramCollection)
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
        localj.gDs();
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
      rx.a.b.jI(paramCollection);
      AppMethodBeat.o(90439);
      return;
    }
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(90435);
    if (paramj.gDt())
    {
      AppMethodBeat.o(90435);
      return;
    }
    if (!this.OxN) {}
    try
    {
      if (!this.OxN)
      {
        if (this.OyX == null) {
          this.OyX = new HashSet(4);
        }
        this.OyX.add(paramj);
        return;
      }
      paramj.gDs();
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
    if (!this.OxN) {}
    try
    {
      if ((this.OxN) || (this.OyX == null)) {
        return;
      }
      Set localSet = this.OyX;
      this.OyX = null;
      z(localSet);
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
    if (!this.OxN) {}
    try
    {
      if ((this.OxN) || (this.OyX == null)) {
        return;
      }
      boolean bool = this.OyX.remove(paramj);
      if (bool) {
        paramj.gDs();
      }
      AppMethodBeat.o(90436);
      return;
    }
    finally
    {
      AppMethodBeat.o(90436);
    }
  }
  
  public final void gDs()
  {
    AppMethodBeat.i(90438);
    if (!this.OxN) {}
    try
    {
      if (this.OxN) {
        return;
      }
      this.OxN = true;
      Set localSet = this.OyX;
      this.OyX = null;
      z(localSet);
      AppMethodBeat.o(90438);
      return;
    }
    finally
    {
      AppMethodBeat.o(90438);
    }
  }
  
  public final boolean gDt()
  {
    return this.OxN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.f.b
 * JD-Core Version:    0.7.0.1
 */