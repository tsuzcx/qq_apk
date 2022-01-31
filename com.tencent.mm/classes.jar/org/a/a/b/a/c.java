package org.a.a.b.a;

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
  public static boolean xui = true;
  public static boolean xuj = true;
  public static boolean xuk = true;
  private Throwable xuh = null;
  
  public c(b paramb)
  {
    if ((paramb instanceof Throwable))
    {
      this.xuh = ((Throwable)paramb);
      return;
    }
    throw new IllegalArgumentException("The Nestable implementation passed to the NestableDelegate(Nestable) constructor must extend java.lang.Throwable");
  }
  
  private static void eF(List paramList)
  {
    int i = paramList.size() - 1;
    while (i > 0)
    {
      String[] arrayOfString1 = (String[])paramList.get(i);
      String[] arrayOfString2 = (String[])paramList.get(i - 1);
      ArrayList localArrayList = new ArrayList(Arrays.asList(arrayOfString1));
      a.o(localArrayList, new ArrayList(Arrays.asList(arrayOfString2)));
      int j = arrayOfString1.length - localArrayList.size();
      if (j > 0)
      {
        localArrayList.add("\t... " + j + " more");
        paramList.set(i, localArrayList.toArray(new String[localArrayList.size()]));
      }
      i -= 1;
    }
  }
  
  public final void printStackTrace(PrintStream paramPrintStream)
  {
    try
    {
      PrintWriter localPrintWriter = new PrintWriter(paramPrintStream, false);
      printStackTrace(localPrintWriter);
      localPrintWriter.flush();
      return;
    }
    finally {}
  }
  
  public final void printStackTrace(PrintWriter paramPrintWriter)
  {
    Object localObject1 = this.xuh;
    if (a.cUR())
    {
      if ((localObject1 instanceof b))
      {
        ((b)localObject1).a(paramPrintWriter);
        return;
      }
      ((Throwable)localObject1).printStackTrace(paramPrintWriter);
      return;
    }
    Object localObject3 = new ArrayList();
    Object localObject4;
    if (localObject1 != null)
    {
      localObject4 = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter((Writer)localObject4, true);
      if ((localObject1 instanceof b)) {
        ((b)localObject1).a(localPrintWriter);
      }
      for (;;)
      {
        ((List)localObject3).add(a.ahv(((StringWriter)localObject4).getBuffer().toString()));
        localObject1 = a.getCause((Throwable)localObject1);
        break;
        ((Throwable)localObject1).printStackTrace(localPrintWriter);
      }
    }
    localObject1 = "Caused by: ";
    if (!xui)
    {
      localObject1 = "Rethrown as: ";
      Collections.reverse((List)localObject3);
    }
    if (xuj) {
      eF((List)localObject3);
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
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.a.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */