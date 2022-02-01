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
  private static final Object Uhp = new Object();
  private static String[] Uhq = { "getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable" };
  private static final Method Uhr;
  private static final Method Uhs;
  static Class Uht;
  
  static
  {
    localObject3 = null;
    AppMethodBeat.i(40719);
    for (;;)
    {
      try
      {
        if (Uht != null) {
          continue;
        }
        localObject1 = bvc("java.lang.Throwable");
        Uht = (Class)localObject1;
        localObject1 = ((Class)localObject1).getMethod("getCause", null);
      }
      catch (Exception localException1)
      {
        Object localObject1;
        localClass1 = null;
        continue;
        localClass1 = Uht;
        continue;
        localClass2 = Uht;
        continue;
      }
      Uhr = (Method)localObject1;
      try
      {
        if (Uht != null) {
          continue;
        }
        localObject1 = bvc("java.lang.Throwable");
        Uht = (Class)localObject1;
        if (Uht != null) {
          continue;
        }
        localClass2 = bvc("java.lang.Throwable");
        Uht = localClass2;
        localObject1 = ((Class)localObject1).getMethod("initCause", new Class[] { localClass2 });
      }
      catch (Exception localException2)
      {
        Class localClass2;
        Class localClass1;
        Object localObject2 = localObject3;
        continue;
      }
      Uhs = (Method)localObject1;
      AppMethodBeat.o(40719);
      return;
      localObject1 = Uht;
    }
  }
  
  public static Throwable J(Throwable paramThrowable)
  {
    AppMethodBeat.i(40712);
    synchronized (Uhp)
    {
      paramThrowable = a(paramThrowable, Uhq);
      AppMethodBeat.o(40712);
      return paramThrowable;
    }
  }
  
  public static void J(List paramList1, List paramList2)
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
      synchronized (Uhp)
      {
        localObject2 = Uhq;
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
    Object localObject2 = ???;
    if (??? == null) {
      localObject2 = g(paramThrowable, "detail");
    }
    label162:
    AppMethodBeat.o(40713);
    return localObject2;
  }
  
  private static Class bvc(String paramString)
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
  
  static String[] bvn(String paramString)
  {
    AppMethodBeat.i(40717);
    paramString = new StringTokenizer(paramString, h.TTr);
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
        if (Uht == null)
        {
          localClass = bvc("java.lang.Throwable");
          Uht = localClass;
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
          paramThrowable = (Throwable)paramString.invoke(paramThrowable, org.apache.commons.b.a.UeK);
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
        localClass = Uht;
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
        if (Uht == null)
        {
          localClass = bvc("java.lang.Throwable");
          Uht = localClass;
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
        localClass = Uht;
      }
    }
  }
  
  public static boolean hPO()
  {
    return Uhr != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.apache.commons.b.b.a
 * JD-Core Version:    0.7.0.1
 */