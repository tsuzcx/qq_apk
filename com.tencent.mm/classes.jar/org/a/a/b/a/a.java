package org.a.a.b.a;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.a.a.b.e;

public final class a
{
  private static final Object xuc = new Object();
  private static String[] xud = { "getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable" };
  private static final Method xue;
  private static final Method xuf;
  static Class xug;
  
  static
  {
    localObject3 = null;
    for (;;)
    {
      try
      {
        if (xug != null) {
          continue;
        }
        localObject1 = ahw("java.lang.Throwable");
        xug = (Class)localObject1;
        localObject1 = ((Class)localObject1).getMethod("getCause", null);
      }
      catch (Exception localException1)
      {
        Object localObject1;
        localClass1 = null;
        continue;
        localClass1 = xug;
        continue;
        localClass2 = xug;
        continue;
      }
      xue = (Method)localObject1;
      try
      {
        if (xug != null) {
          continue;
        }
        localObject1 = ahw("java.lang.Throwable");
        xug = (Class)localObject1;
        if (xug != null) {
          continue;
        }
        localClass2 = ahw("java.lang.Throwable");
        xug = localClass2;
        localObject1 = ((Class)localObject1).getMethod("initCause", new Class[] { localClass2 });
      }
      catch (Exception localException2)
      {
        Class localClass2;
        Class localClass1;
        Object localObject2 = localObject3;
        continue;
      }
      xuf = (Method)localObject1;
      return;
      localObject1 = xug;
    }
  }
  
  private static Throwable a(Throwable paramThrowable, String[] arg1)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramThrowable == null) {}
    do
    {
      return localObject2;
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
        synchronized (xuc)
        {
          localObject2 = xud;
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
              localObject1 = c(paramThrowable, ???);
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
      localObject2 = ???;
    } while (??? != null);
    return d(paramThrowable, "detail");
  }
  
  static String[] ahv(String paramString)
  {
    paramString = new StringTokenizer(paramString, e.LINE_SEPARATOR);
    ArrayList localArrayList = new ArrayList();
    while (paramString.hasMoreTokens()) {
      localArrayList.add(paramString.nextToken());
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  private static Class ahw(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new NoClassDefFoundError(paramString.getMessage());
    }
  }
  
  private static Throwable c(Throwable paramThrowable, String paramString)
  {
    try
    {
      paramString = paramThrowable.getClass().getMethod(paramString, null);
      if (paramString != null) {
        if (xug == null)
        {
          localClass = ahw("java.lang.Throwable");
          xug = localClass;
          if (!localClass.isAssignableFrom(paramString.getReturnType())) {
            break label75;
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
          paramThrowable = (Throwable)paramString.invoke(paramThrowable, org.a.a.b.a.xos);
          return paramThrowable;
        }
        catch (InvocationTargetException paramThrowable)
        {
          Class localClass;
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
        localClass = xug;
      }
    }
  }
  
  public static boolean cUR()
  {
    return xue != null;
  }
  
  private static Throwable d(Throwable paramThrowable, String paramString)
  {
    try
    {
      paramString = paramThrowable.getClass().getField(paramString);
      if (paramString != null) {
        if (xug == null)
        {
          localClass = ahw("java.lang.Throwable");
          xug = localClass;
          if (!localClass.isAssignableFrom(paramString.getType())) {
            break label71;
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
          return paramThrowable;
        }
        catch (IllegalArgumentException paramThrowable)
        {
          Class localClass;
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
        localClass = xug;
      }
    }
  }
  
  public static Throwable getCause(Throwable paramThrowable)
  {
    synchronized (xuc)
    {
      paramThrowable = a(paramThrowable, xud);
      return paramThrowable;
    }
  }
  
  public static void o(List paramList1, List paramList2)
  {
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.a.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */