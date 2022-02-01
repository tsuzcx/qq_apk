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
  public volatile boolean UnB;
  private Set<j> UoK;
  
  private static void C(Collection<j> paramCollection)
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
        localj.hQA();
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
      rx.a.b.kP(paramCollection);
      AppMethodBeat.o(90439);
      return;
    }
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(90435);
    if (paramj.hQB())
    {
      AppMethodBeat.o(90435);
      return;
    }
    if (!this.UnB) {}
    try
    {
      if (!this.UnB)
      {
        if (this.UoK == null) {
          this.UoK = new HashSet(4);
        }
        this.UoK.add(paramj);
        return;
      }
      paramj.hQA();
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
    if (!this.UnB) {}
    try
    {
      if ((this.UnB) || (this.UoK == null)) {
        return;
      }
      Set localSet = this.UoK;
      this.UoK = null;
      C(localSet);
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
    if (!this.UnB) {}
    try
    {
      if ((this.UnB) || (this.UoK == null)) {
        return;
      }
      boolean bool = this.UoK.remove(paramj);
      if (bool) {
        paramj.hQA();
      }
      AppMethodBeat.o(90436);
      return;
    }
    finally
    {
      AppMethodBeat.o(90436);
    }
  }
  
  public final void hQA()
  {
    AppMethodBeat.i(90438);
    if (!this.UnB) {}
    try
    {
      if (this.UnB) {
        return;
      }
      this.UnB = true;
      Set localSet = this.UoK;
      this.UoK = null;
      C(localSet);
      AppMethodBeat.o(90438);
      return;
    }
    finally
    {
      AppMethodBeat.o(90438);
    }
  }
  
  public final boolean hQB()
  {
    return this.UnB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.f.b
 * JD-Core Version:    0.7.0.1
 */