package org.apache.commons.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.c.j;

public final class a
{
  private static String[] ajXA = { "getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable" };
  private static final Method ajXB;
  private static final Method ajXC;
  static Class ajXD;
  private static final Object ajXz;
  
  static
  {
    localObject3 = null;
    AppMethodBeat.i(40719);
    ajXz = new Object();
    for (;;)
    {
      try
      {
        if (ajXD != null) {
          continue;
        }
        localObject1 = bLa("java.lang.Throwable");
        ajXD = (Class)localObject1;
        localObject1 = ((Class)localObject1).getMethod("getCause", null);
      }
      catch (Exception localException1)
      {
        Object localObject1;
        localClass1 = null;
        continue;
        localClass1 = ajXD;
        continue;
        localClass2 = ajXD;
        continue;
      }
      ajXB = (Method)localObject1;
      try
      {
        if (ajXD != null) {
          continue;
        }
        localObject1 = bLa("java.lang.Throwable");
        ajXD = (Class)localObject1;
        if (ajXD != null) {
          continue;
        }
        localClass2 = bLa("java.lang.Throwable");
        ajXD = localClass2;
        localObject1 = ((Class)localObject1).getMethod("initCause", new Class[] { localClass2 });
      }
      catch (Exception localException2)
      {
        Class localClass2;
        Class localClass1;
        Object localObject2 = localObject3;
        continue;
      }
      ajXC = (Method)localObject1;
      AppMethodBeat.o(40719);
      return;
      localObject1 = ajXD;
    }
  }
  
  private static Throwable a(Throwable paramThrowable, String[] arg1)
  {
    Object localObject1 = null;
    AppMethodBeat.i(40713);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(40713);
      return null;
    }
    if ((paramThrowable instanceof b)) {
      localObject1 = ((b)paramThrowable).getCause();
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      localObject2 = ???;
      if (??? == null) {}
      synchronized (ajXz)
      {
        localObject2 = ajXA;
        int i = 0;
        for (;;)
        {
          ??? = (String[])localObject1;
          if (i >= localObject2.length) {
            break;
          }
          ??? = localObject2[i];
          if (??? != null)
          {
            localObject1 = f(paramThrowable, ???);
            ??? = (String[])localObject1;
            if (localObject1 != null) {
              break;
            }
          }
          i += 1;
        }
        if ((paramThrowable instanceof SQLException)) {
          localObject1 = ((SQLException)paramThrowable).getNextException();
        } else if ((paramThrowable instanceof InvocationTargetException)) {
          localObject1 = ((InvocationTargetException)paramThrowable).getTargetException();
        }
      }
    }
    Object localObject2 = g(paramThrowable, "detail");
    AppMethodBeat.o(40713);
    return localObject2;
  }
  
  public static void ad(List paramList1, List paramList2)
  {
    AppMethodBeat.i(40716);
    int i = paramList1.size();
    int j = paramList2.size() - 1;
    i -= 1;
    while ((i >= 0) && (j >= 0))
    {
      if (((String)paramList1.get(i)).equals((String)paramList2.get(j))) {
        paramList1.remove(i);
      }
      j -= 1;
      i -= 1;
    }
    AppMethodBeat.o(40716);
  }
  
  public static Throwable ae(Throwable paramThrowable)
  {
    AppMethodBeat.i(40712);
    synchronized (ajXz)
    {
      paramThrowable = a(paramThrowable, ajXA);
      AppMethodBeat.o(40712);
      return paramThrowable;
    }
  }
  
  private static Class bLa(String paramString)
  {
    AppMethodBeat.i(40718);
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(40718);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      paramString = new NoClassDefFoundError(paramString.getMessage());
      AppMethodBeat.o(40718);
      throw paramString;
    }
  }
  
  static String[] bLn(String paramString)
  {
    AppMethodBeat.i(40717);
    paramString = new StringTokenizer(paramString, j.ajUO);
    ArrayList localArrayList = new ArrayList();
    while (paramString.hasMoreTokens()) {
      localArrayList.add(paramString.nextToken());
    }
    paramString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    AppMethodBeat.o(40717);
    return paramString;
  }
  
  private static Throwable f(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(40714);
    try
    {
      paramString = paramThrowable.getClass().getMethod(paramString, null);
      if (paramString != null) {
        if (ajXD == null)
        {
          localClass = bLa("java.lang.Throwable");
          ajXD = localClass;
          if (!localClass.isAssignableFrom(paramString.getReturnType())) {
            break label85;
          }
        }
      }
    }
    catch (NoSuchMethodException paramString)
    {
      for (;;)
      {
        try
        {
          paramThrowable = (Throwable)paramString.invoke(paramThrowable, org.apache.commons.c.a.ajUT);
          AppMethodBeat.o(40714);
          return paramThrowable;
        }
        catch (InvocationTargetException paramThrowable)
        {
          Class localClass;
          AppMethodBeat.o(40714);
          return null;
        }
        catch (IllegalArgumentException paramThrowable)
        {
          continue;
        }
        catch (IllegalAccessException paramThrowable)
        {
          continue;
        }
        paramString = paramString;
        paramString = null;
      }
    }
    catch (SecurityException paramString)
    {
      for (;;)
      {
        paramString = null;
        continue;
        localClass = ajXD;
      }
    }
  }
  
  private static Throwable g(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(40715);
    try
    {
      paramString = paramThrowable.getClass().getField(paramString);
      if (paramString != null) {
        if (ajXD == null)
        {
          localClass = bLa("java.lang.Throwable");
          ajXD = localClass;
          if (!localClass.isAssignableFrom(paramString.getType())) {
            break label81;
          }
        }
      }
    }
    catch (NoSuchFieldException paramString)
    {
      for (;;)
      {
        try
        {
          paramThrowable = (Throwable)paramString.get(paramThrowable);
          AppMethodBeat.o(40715);
          return paramThrowable;
        }
        catch (IllegalArgumentException paramThrowable)
        {
          Class localClass;
          AppMethodBeat.o(40715);
          return null;
        }
        catch (IllegalAccessException paramThrowable)
        {
          continue;
        }
        paramString = paramString;
        paramString = null;
      }
    }
    catch (SecurityException paramString)
    {
      for (;;)
      {
        paramString = null;
        continue;
        localClass = ajXD;
      }
    }
  }
  
  public static boolean kJv()
  {
    return ajXB != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.apache.commons.c.b.a
 * JD-Core Version:    0.7.0.1
 */