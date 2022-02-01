package rx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class a
  extends RuntimeException
{
  private final List<Throwable> aKx;
  private Throwable cause;
  private final String message;
  
  @Deprecated
  private a(Collection<? extends Throwable> paramCollection)
  {
    AppMethodBeat.i(90036);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    ArrayList localArrayList = new ArrayList();
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Throwable localThrowable = (Throwable)paramCollection.next();
        if ((localThrowable instanceof a)) {
          localLinkedHashSet.addAll(((a)localThrowable).aKx);
        } else if (localThrowable != null) {
          localLinkedHashSet.add(localThrowable);
        } else {
          localLinkedHashSet.add(new NullPointerException());
        }
      }
    }
    localLinkedHashSet.add(new NullPointerException());
    localArrayList.addAll(localLinkedHashSet);
    this.aKx = Collections.unmodifiableList(localArrayList);
    this.message = (this.aKx.size() + " exceptions occurred. ");
    AppMethodBeat.o(90036);
  }
  
  public a(Collection<? extends Throwable> paramCollection, byte paramByte)
  {
    this(paramCollection);
  }
  
  private static List<Throwable> I(Throwable paramThrowable)
  {
    AppMethodBeat.i(90043);
    ArrayList localArrayList = new ArrayList();
    Throwable localThrowable2 = paramThrowable.getCause();
    Throwable localThrowable1;
    if (localThrowable2 != null)
    {
      localThrowable1 = localThrowable2;
      if (localThrowable2 != paramThrowable) {}
    }
    else
    {
      AppMethodBeat.o(90043);
      return localArrayList;
    }
    do
    {
      localThrowable1 = localThrowable1.getCause();
      localArrayList.add(localThrowable1);
      paramThrowable = localThrowable1.getCause();
    } while ((paramThrowable != null) && (paramThrowable != localThrowable1));
    AppMethodBeat.o(90043);
    return localArrayList;
  }
  
  private static Throwable J(Throwable paramThrowable)
  {
    AppMethodBeat.i(90044);
    Throwable localThrowable2 = paramThrowable.getCause();
    Throwable localThrowable1;
    if (localThrowable2 != null)
    {
      localThrowable1 = localThrowable2;
      if (localThrowable2 != paramThrowable) {}
    }
    else
    {
      AppMethodBeat.o(90044);
      return paramThrowable;
    }
    do
    {
      localThrowable1 = localThrowable1.getCause();
      paramThrowable = localThrowable1.getCause();
    } while ((paramThrowable != null) && (paramThrowable != localThrowable1));
    AppMethodBeat.o(90044);
    return localThrowable1;
  }
  
  private static void a(StringBuilder paramStringBuilder, Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(90042);
    for (;;)
    {
      paramStringBuilder.append(paramString).append(paramThrowable).append('\n');
      paramString = paramThrowable.getStackTrace();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        paramStringBuilder.append("\t\tat ").append(localObject).append('\n');
        i += 1;
      }
      if (paramThrowable.getCause() == null) {
        break;
      }
      paramStringBuilder.append("\tCaused by: ");
      paramThrowable = paramThrowable.getCause();
      paramString = "";
    }
    AppMethodBeat.o(90042);
  }
  
  private void a(b paramb)
  {
    AppMethodBeat.i(90041);
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(this).append('\n');
    ??? = getStackTrace();
    int j = ???.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = ???[i];
      localStringBuilder.append("\tat ").append(localObject2).append('\n');
      i += 1;
    }
    ??? = this.aKx.iterator();
    i = 1;
    while (((Iterator)???).hasNext())
    {
      localObject2 = (Throwable)((Iterator)???).next();
      localStringBuilder.append("  ComposedException ").append(i).append(" :\n");
      a(localStringBuilder, (Throwable)localObject2, "\t");
      i += 1;
    }
    synchronized (paramb.gyS())
    {
      paramb.println(localStringBuilder.toString());
      AppMethodBeat.o(90041);
      return;
    }
  }
  
  public final Throwable getCause()
  {
    try
    {
      AppMethodBeat.i(90037);
      a locala2;
      HashSet localHashSet;
      Iterator localIterator1;
      if (this.cause == null)
      {
        locala2 = new a();
        localHashSet = new HashSet();
        localIterator1 = this.aKx.iterator();
        a locala1 = locala2;
      }
      for (;;)
      {
        Object localObject;
        if (localIterator1.hasNext())
        {
          localObject = (Throwable)localIterator1.next();
          if (localHashSet.contains(localObject)) {
            continue;
          }
          localHashSet.add(localObject);
          Iterator localIterator2 = I((Throwable)localObject).iterator();
          while (localIterator2.hasNext())
          {
            Throwable localThrowable4 = (Throwable)localIterator2.next();
            if (localHashSet.contains(localThrowable4)) {
              localObject = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
            } else {
              localHashSet.add(localThrowable4);
            }
          }
        }
        try
        {
          localThrowable1.initCause((Throwable)localObject);
          Throwable localThrowable2 = J(localThrowable1);
          continue;
          this.cause = locala2;
          localThrowable2 = this.cause;
          AppMethodBeat.o(90037);
          return localThrowable2;
        }
        catch (Throwable localThrowable3)
        {
          break label167;
        }
      }
    }
    finally {}
  }
  
  public final String getMessage()
  {
    return this.message;
  }
  
  public final void printStackTrace()
  {
    AppMethodBeat.i(90038);
    printStackTrace(System.err);
    AppMethodBeat.o(90038);
  }
  
  public final void printStackTrace(PrintStream paramPrintStream)
  {
    AppMethodBeat.i(90039);
    a(new c(paramPrintStream));
    AppMethodBeat.o(90039);
  }
  
  public final void printStackTrace(PrintWriter paramPrintWriter)
  {
    AppMethodBeat.i(90040);
    a(new d(paramPrintWriter));
    AppMethodBeat.o(90040);
  }
  
  static final class a
    extends RuntimeException
  {
    public final String getMessage()
    {
      return "Chain of Causes for CompositeException In Order Received =>";
    }
  }
  
  static abstract class b
  {
    abstract Object gyS();
    
    abstract void println(Object paramObject);
  }
  
  static final class c
    extends a.b
  {
    private final PrintStream NXr;
    
    c(PrintStream paramPrintStream)
    {
      this.NXr = paramPrintStream;
    }
    
    final Object gyS()
    {
      return this.NXr;
    }
    
    final void println(Object paramObject)
    {
      AppMethodBeat.i(90034);
      this.NXr.println(paramObject);
      AppMethodBeat.o(90034);
    }
  }
  
  static final class d
    extends a.b
  {
    private final PrintWriter NXs;
    
    d(PrintWriter paramPrintWriter)
    {
      this.NXs = paramPrintWriter;
    }
    
    final Object gyS()
    {
      return this.NXs;
    }
    
    final void println(Object paramObject)
    {
      AppMethodBeat.i(90035);
      this.NXs.println(paramObject);
      AppMethodBeat.o(90035);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.a.a
 * JD-Core Version:    0.7.0.1
 */