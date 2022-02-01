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
  public List<j> MfF;
  public volatile boolean MfG;
  
  public i() {}
  
  public i(j paramj)
  {
    AppMethodBeat.i(90120);
    this.MfF = new LinkedList();
    this.MfF.add(paramj);
    AppMethodBeat.o(90120);
  }
  
  public i(j... paramVarArgs)
  {
    AppMethodBeat.i(90119);
    this.MfF = new LinkedList(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(90119);
  }
  
  private static void y(Collection<j> paramCollection)
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
        localj.ggm();
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
      b.jl(paramCollection);
      AppMethodBeat.o(90123);
      return;
    }
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(90121);
    if (paramj.ggn())
    {
      AppMethodBeat.o(90121);
      return;
    }
    if (!this.MfG) {}
    try
    {
      if (!this.MfG)
      {
        List localList = this.MfF;
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new LinkedList();
          this.MfF = ((List)localObject);
        }
        ((List)localObject).add(paramj);
        return;
      }
      paramj.ggm();
      AppMethodBeat.o(90121);
      return;
    }
    finally
    {
      AppMethodBeat.o(90121);
    }
  }
  
  public final void ggm()
  {
    AppMethodBeat.i(90122);
    if (!this.MfG) {}
    try
    {
      if (this.MfG) {
        return;
      }
      this.MfG = true;
      List localList = this.MfF;
      this.MfF = null;
      y(localList);
      AppMethodBeat.o(90122);
      return;
    }
    finally
    {
      AppMethodBeat.o(90122);
    }
  }
  
  public final boolean ggn()
  {
    return this.MfG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.util.i
 * JD-Core Version:    0.7.0.1
 */