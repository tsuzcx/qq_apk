package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.a.b;
import rx.j;

public final class i
  implements j
{
  public List<j> KrW;
  public volatile boolean KrX;
  
  public i() {}
  
  public i(j paramj)
  {
    AppMethodBeat.i(90120);
    this.KrW = new LinkedList();
    this.KrW.add(paramj);
    AppMethodBeat.o(90120);
  }
  
  public i(j... paramVarArgs)
  {
    AppMethodBeat.i(90119);
    this.KrW = new LinkedList(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(90119);
  }
  
  private static void x(Collection<j> paramCollection)
  {
    AppMethodBeat.i(90123);
    if (paramCollection == null)
    {
      AppMethodBeat.o(90123);
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
      b.iV(paramCollection);
      AppMethodBeat.o(90123);
      return;
    }
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(90121);
    if (paramj.fNx())
    {
      AppMethodBeat.o(90121);
      return;
    }
    if (!this.KrX) {}
    try
    {
      if (!this.KrX)
      {
        List localList = this.KrW;
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new LinkedList();
          this.KrW = ((List)localObject);
        }
        ((List)localObject).add(paramj);
        return;
      }
      paramj.fNw();
      AppMethodBeat.o(90121);
      return;
    }
    finally
    {
      AppMethodBeat.o(90121);
    }
  }
  
  public final void fNw()
  {
    AppMethodBeat.i(90122);
    if (!this.KrX) {}
    try
    {
      if (this.KrX) {
        return;
      }
      this.KrX = true;
      List localList = this.KrW;
      this.KrW = null;
      x(localList);
      AppMethodBeat.o(90122);
      return;
    }
    finally
    {
      AppMethodBeat.o(90122);
    }
  }
  
  public final boolean fNx()
  {
    return this.KrX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.util.i
 * JD-Core Version:    0.7.0.1
 */