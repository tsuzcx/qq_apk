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
  public List<j> UnA;
  public volatile boolean UnB;
  
  public i() {}
  
  public i(j paramj)
  {
    AppMethodBeat.i(90120);
    this.UnA = new LinkedList();
    this.UnA.add(paramj);
    AppMethodBeat.o(90120);
  }
  
  public i(j... paramVarArgs)
  {
    AppMethodBeat.i(90119);
    this.UnA = new LinkedList(Arrays.asList(paramVarArgs));
    AppMethodBeat.o(90119);
  }
  
  private static void C(Collection<j> paramCollection)
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
      b.kP(paramCollection);
      AppMethodBeat.o(90123);
      return;
    }
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(90121);
    if (paramj.hQB())
    {
      AppMethodBeat.o(90121);
      return;
    }
    if (!this.UnB) {}
    try
    {
      if (!this.UnB)
      {
        List localList = this.UnA;
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new LinkedList();
          this.UnA = ((List)localObject);
        }
        ((List)localObject).add(paramj);
        return;
      }
      paramj.hQA();
      AppMethodBeat.o(90121);
      return;
    }
    finally
    {
      AppMethodBeat.o(90121);
    }
  }
  
  public final void hQA()
  {
    AppMethodBeat.i(90122);
    if (!this.UnB) {}
    try
    {
      if (this.UnB) {
        return;
      }
      this.UnB = true;
      List localList = this.UnA;
      this.UnA = null;
      C(localList);
      AppMethodBeat.o(90122);
      return;
    }
    finally
    {
      AppMethodBeat.o(90122);
    }
  }
  
  public final boolean hQB()
  {
    return this.UnB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.util.i
 * JD-Core Version:    0.7.0.1
 */