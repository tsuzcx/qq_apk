package com.tencent.tencentmap.mapsdk.maps.a;

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

public final class nz
  extends RuntimeException
{
  private final List<Throwable> a;
  private final String b;
  private Throwable c;
  
  public nz(String paramString, Collection<? extends Throwable> paramCollection)
  {
    AppMethodBeat.i(149585);
    this.c = null;
    paramString = new LinkedHashSet();
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Throwable localThrowable = (Throwable)paramCollection.next();
      if ((localThrowable instanceof nz)) {
        paramString.addAll(((nz)localThrowable).a());
      } else {
        paramString.add(localThrowable);
      }
    }
    localArrayList.addAll(paramString);
    this.a = Collections.unmodifiableList(localArrayList);
    this.b = (this.a.size() + " exceptions occurred. ");
    AppMethodBeat.o(149585);
  }
  
  public nz(Collection<? extends Throwable> paramCollection)
  {
    this(null, paramCollection);
  }
  
  private final List<Throwable> a(Throwable paramThrowable)
  {
    AppMethodBeat.i(149592);
    ArrayList localArrayList = new ArrayList();
    Throwable localThrowable = paramThrowable.getCause();
    paramThrowable = localThrowable;
    if (localThrowable == null)
    {
      AppMethodBeat.o(149592);
      return localArrayList;
    }
    do
    {
      paramThrowable = paramThrowable.getCause();
      localArrayList.add(paramThrowable);
    } while (paramThrowable.getCause() != null);
    AppMethodBeat.o(149592);
    return localArrayList;
  }
  
  private void a(nz.b paramb)
  {
    AppMethodBeat.i(149590);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this).append("\n");
    ??? = getStackTrace();
    int j = ???.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = ???[i];
      localStringBuilder.append("\tat ").append(localObject2).append("\n");
      i += 1;
    }
    ??? = this.a.iterator();
    i = 1;
    while (((Iterator)???).hasNext())
    {
      localObject2 = (Throwable)((Iterator)???).next();
      localStringBuilder.append("  ComposedException ").append(i).append(" :\n");
      a(localStringBuilder, (Throwable)localObject2, "\t");
      i += 1;
    }
    synchronized (paramb.a())
    {
      paramb.a(localStringBuilder.toString());
      AppMethodBeat.o(149590);
      return;
    }
  }
  
  private void a(StringBuilder paramStringBuilder, Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(149591);
    for (;;)
    {
      paramStringBuilder.append(paramString).append(paramThrowable).append("\n");
      paramString = paramThrowable.getStackTrace();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        paramStringBuilder.append("\t\tat ").append(localObject).append("\n");
        i += 1;
      }
      if (paramThrowable.getCause() == null) {
        break;
      }
      paramStringBuilder.append("\tCaused by: ");
      paramThrowable = paramThrowable.getCause();
      paramString = "";
    }
    AppMethodBeat.o(149591);
  }
  
  public final List<Throwable> a()
  {
    return this.a;
  }
  
  public final Throwable getCause()
  {
    try
    {
      AppMethodBeat.i(149586);
      nz.a locala2;
      HashSet localHashSet;
      Iterator localIterator1;
      if (this.c == null)
      {
        locala2 = new nz.a();
        localHashSet = new HashSet();
        localIterator1 = this.a.iterator();
        nz.a locala1 = locala2;
      }
      for (;;)
      {
        Object localObject2;
        if (localIterator1.hasNext())
        {
          localObject2 = (Throwable)localIterator1.next();
          if (localHashSet.contains(localObject2)) {
            continue;
          }
          localHashSet.add(localObject2);
          Iterator localIterator2 = a((Throwable)localObject2).iterator();
          while (localIterator2.hasNext())
          {
            Throwable localThrowable3 = (Throwable)localIterator2.next();
            if (localHashSet.contains(localThrowable3)) {
              localObject2 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
            } else {
              localHashSet.add(localThrowable3);
            }
          }
        }
        try
        {
          localObject1.initCause((Throwable)localObject2);
          Throwable localThrowable1 = localObject1.getCause();
          continue;
          this.c = locala2;
          localThrowable1 = this.c;
          AppMethodBeat.o(149586);
          return localThrowable1;
        }
        catch (Throwable localThrowable2)
        {
          break label168;
        }
      }
    }
    finally {}
  }
  
  public final String getMessage()
  {
    return this.b;
  }
  
  public final void printStackTrace()
  {
    AppMethodBeat.i(149587);
    printStackTrace(System.err);
    AppMethodBeat.o(149587);
  }
  
  public final void printStackTrace(PrintStream paramPrintStream)
  {
    AppMethodBeat.i(149588);
    a(new nz.c(paramPrintStream));
    AppMethodBeat.o(149588);
  }
  
  public final void printStackTrace(PrintWriter paramPrintWriter)
  {
    AppMethodBeat.i(149589);
    a(new nz.d(paramPrintWriter));
    AppMethodBeat.o(149589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nz
 * JD-Core Version:    0.7.0.1
 */