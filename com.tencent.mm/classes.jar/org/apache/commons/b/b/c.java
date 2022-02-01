package org.apache.commons.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class c
  implements Serializable
{
  public static boolean Knj = true;
  public static boolean Knk = true;
  public static boolean Knl = true;
  private Throwable Kni;
  
  public c(b paramb)
  {
    AppMethodBeat.i(40720);
    this.Kni = null;
    this.Kni = ((Throwable)paramb);
    AppMethodBeat.o(40720);
  }
  
  private static void iU(List paramList)
  {
    AppMethodBeat.i(40723);
    int i = paramList.size() - 1;
    while (i > 0)
    {
      String[] arrayOfString1 = (String[])paramList.get(i);
      String[] arrayOfString2 = (String[])paramList.get(i - 1);
      ArrayList localArrayList = new ArrayList(Arrays.asList(arrayOfString1));
      a.M(localArrayList, new ArrayList(Arrays.asList(arrayOfString2)));
      int j = arrayOfString1.length - localArrayList.size();
      if (j > 0)
      {
        localArrayList.add("\t... " + j + " more");
        paramList.set(i, localArrayList.toArray(new String[localArrayList.size()]));
      }
      i -= 1;
    }
    AppMethodBeat.o(40723);
  }
  
  public final void printStackTrace(PrintStream paramPrintStream)
  {
    AppMethodBeat.i(40721);
    try
    {
      PrintWriter localPrintWriter = new PrintWriter(paramPrintStream, false);
      printStackTrace(localPrintWriter);
      localPrintWriter.flush();
      return;
    }
    finally
    {
      AppMethodBeat.o(40721);
    }
  }
  
  public final void printStackTrace(PrintWriter paramPrintWriter)
  {
    AppMethodBeat.i(40722);
    Object localObject1 = this.Kni;
    if (a.fMU())
    {
      if ((localObject1 instanceof b))
      {
        ((b)localObject1).b(paramPrintWriter);
        AppMethodBeat.o(40722);
        return;
      }
      ((Throwable)localObject1).printStackTrace(paramPrintWriter);
      AppMethodBeat.o(40722);
      return;
    }
    Object localObject3 = new ArrayList();
    Object localObject4;
    if (localObject1 != null)
    {
      localObject4 = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter((Writer)localObject4, true);
      if ((localObject1 instanceof b)) {
        ((b)localObject1).b(localPrintWriter);
      }
      for (;;)
      {
        ((List)localObject3).add(a.aRz(((StringWriter)localObject4).getBuffer().toString()));
        localObject1 = a.E((Throwable)localObject1);
        break;
        ((Throwable)localObject1).printStackTrace(localPrintWriter);
      }
    }
    localObject1 = "Caused by: ";
    if (!Knj)
    {
      localObject1 = "Rethrown as: ";
      Collections.reverse((List)localObject3);
    }
    if (Knk) {
      iU((List)localObject3);
    }
    try
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String[])((Iterator)localObject3).next();
        int i = 0;
        int j = localObject4.length;
        while (i < j)
        {
          paramPrintWriter.println(localObject4[i]);
          i += 1;
        }
        if (((Iterator)localObject3).hasNext()) {
          paramPrintWriter.print((String)localObject1);
        }
      }
    }
    finally
    {
      AppMethodBeat.o(40722);
    }
    AppMethodBeat.o(40722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.b.c
 * JD-Core Version:    0.7.0.1
 */