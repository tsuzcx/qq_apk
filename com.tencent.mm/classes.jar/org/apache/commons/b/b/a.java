package org.apache.commons.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.b.h;

public final class a
{
  private static final Object Knd = new Object();
  private static String[] Kne = { "getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable" };
  private static final Method Knf;
  private static final Method Kng;
  static Class Knh;
  
  static
  {
    localObject3 = null;
    AppMethodBeat.i(40719);
    for (;;)
    {
      try
      {
        if (Knh != null) {
          continue;
        }
        localObject1 = aRo("java.lang.Throwable");
        Knh = (Class)localObject1;
        localObject1 = ((Class)localObject1).getMethod("getCause", null);
      }
      catch (Exception localException1)
      {
        Object localObject1;
        localClass1 = null;
        continue;
        localClass1 = Knh;
        continue;
        localClass2 = Knh;
        continue;
      }
      Knf = (Method)localObject1;
      try
      {
        if (Knh != null) {
          continue;
        }
        localObject1 = aRo("java.lang.Throwable");
        Knh = (Class)localObject1;
        if (Knh != null) {
          continue;
        }
        localClass2 = aRo("java.lang.Throwable");
        Knh = localClass2;
        localObject1 = ((Class)localObject1).getMethod("initCause", new Class[] { localClass2 });
      }
      catch (Exception localException2)
      {
        Class localClass2;
        Class localClass1;
        Object localObject2 = localObject3;
        continue;
      }
      Kng = (Method)localObject1;
      AppMethodBeat.o(40719);
      return;
      localObject1 = Knh;
    }
  }
  
  public static Throwable E(Throwable paramThrowable)
  {
    AppMethodBeat.i(40712);
    synchronized (Knd)
    {
      paramThrowable = a(paramThrowable, Kne);
      AppMethodBeat.o(40712);
      return paramThrowable;
    }
  }
  
  public static void M(List paramList1, List paramList2)
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
        break label162;
      }
      localObject2 = ???;
      if (??? == null) {}
      synchronized (Knd)
      {
        localObject2 = Kne;
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
            localObject1 = d(paramThrowable, ???);
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
    Object localObject2 = ???;
    if (??? == null) {
      localObject2 = e(paramThrowable, "detail");
    }
    label162:
    AppMethodBeat.o(40713);
    return localObject2;
  }
  
  private static Class aRo(String paramString)
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
  
  static String[] aRz(String paramString)
  {
    AppMethodBeat.i(40717);
    paramString = new StringTokenizer(paramString, h.Kdb);
    ArrayList localArrayList = new ArrayList();
    while (paramString.hasMoreTokens()) {
      localArrayList.add(paramString.nextToken());
    }
    paramString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    AppMethodBeat.o(40717);
    return paramString;
  }
  
  private static Throwable d(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(40714);
    try
    {
      paramString = paramThrowable.getClass().getMethod(paramString, null);
      if (paramString != null) {
        if (Knh == null)
        {
          localClass = aRo("java.lang.Throwable");
          Knh = localClass;
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
          paramThrowable = (Throwable)paramString.invoke(paramThrowable, org.apache.commons.b.a.Kky);
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
        localClass = Knh;
      }
    }
  }
  
  private static Throwable e(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(40715);
    try
    {
      paramString = paramThrowable.getClass().getField(paramString);
      if (paramString != null) {
        if (Knh == null)
        {
          localClass = aRo("java.lang.Throwable");
          Knh = localClass;
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
        localClass = Knh;
      }
    }
  }
  
  public static boolean fMU()
  {
    return Knf != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.b.a
 * JD-Core Version:    0.7.0.1
 */