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
  public volatile boolean OaI;
  private Set<j> ObS;
  
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
        localj.gyQ();
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
      rx.a.b.jz(paramCollection);
      AppMethodBeat.o(90439);
      return;
    }
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(90435);
    if (paramj.gyR())
    {
      AppMethodBeat.o(90435);
      return;
    }
    if (!this.OaI) {}
    try
    {
      if (!this.OaI)
      {
        if (this.ObS == null) {
          this.ObS = new HashSet(4);
        }
        this.ObS.add(paramj);
        return;
      }
      paramj.gyQ();
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
    if (!this.OaI) {}
    try
    {
      if ((this.OaI) || (this.ObS == null)) {
        return;
      }
      Set localSet = this.ObS;
      this.ObS = null;
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
    if (!this.OaI) {}
    try
    {
      if ((this.OaI) || (this.ObS == null)) {
        return;
      }
      boolean bool = this.ObS.remove(paramj);
      if (bool) {
        paramj.gyQ();
      }
      AppMethodBeat.o(90436);
      return;
    }
    finally
    {
      AppMethodBeat.o(90436);
    }
  }
  
  public final void gyQ()
  {
    AppMethodBeat.i(90438);
    if (!this.OaI) {}
    try
    {
      if (this.OaI) {
        return;
      }
      this.OaI = true;
      Set localSet = this.ObS;
      this.ObS = null;
      z(localSet);
      AppMethodBeat.o(90438);
      return;
    }
    finally
    {
      AppMethodBeat.o(90438);
    }
  }
  
  public final boolean gyR()
  {
    return this.OaI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.f.b
 * JD-Core Version:    0.7.0.1
 */