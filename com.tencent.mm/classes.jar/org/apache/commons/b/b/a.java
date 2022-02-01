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
  private static final Object NVm = new Object();
  private static String[] NVn = { "getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable" };
  private static final Method NVo;
  private static final Method NVp;
  static Class NVq;
  
  static
  {
    localObject3 = null;
    AppMethodBeat.i(40719);
    for (;;)
    {
      try
      {
        if (NVq != null) {
          continue;
        }
        localObject1 = bdI("java.lang.Throwable");
        NVq = (Class)localObject1;
        localObject1 = ((Class)localObject1).getMethod("getCause", null);
      }
      catch (Exception localException1)
      {
        Object localObject1;
        localClass1 = null;
        continue;
        localClass1 = NVq;
        continue;
        localClass2 = NVq;
        continue;
      }
      NVo = (Method)localObject1;
      try
      {
        if (NVq != null) {
          continue;
        }
        localObject1 = bdI("java.lang.Throwable");
        NVq = (Class)localObject1;
        if (NVq != null) {
          continue;
        }
        localClass2 = bdI("java.lang.Throwable");
        NVq = localClass2;
        localObject1 = ((Class)localObject1).getMethod("initCause", new Class[] { localClass2 });
      }
      catch (Exception localException2)
      {
        Class localClass2;
        Class localClass1;
        Object localObject2 = localObject3;
        continue;
      }
      NVp = (Method)localObject1;
      AppMethodBeat.o(40719);
      return;
      localObject1 = NVq;
    }
  }
  
  public static Throwable G(Throwable paramThrowable)
  {
    AppMethodBeat.i(40712);
    synchronized (NVm)
    {
      paramThrowable = a(paramThrowable, NVn);
      AppMethodBeat.o(40712);
      return paramThrowable;
    }
  }
  
  public static void O(List paramList1, List paramList2)
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
      synchronized (NVm)
      {
        localObject2 = NVn;
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
            localObject1 = e(paramThrowable, ???);
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
      localObject2 = f(paramThrowable, "detail");
    }
    label162:
    AppMethodBeat.o(40713);
    return localObject2;
  }
  
  private static Class bdI(String paramString)
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
  
  static String[] bdT(String paramString)
  {
    AppMethodBeat.i(40717);
    paramString = new StringTokenizer(paramString, h.NHr);
    ArrayList localArrayList = new ArrayList();
    while (paramString.hasMoreTokens()) {
      localArrayList.add(paramString.nextToken());
    }
    paramString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    AppMethodBeat.o(40717);
    return paramString;
  }
  
  private static Throwable e(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(40714);
    try
    {
      paramString = paramThrowable.getClass().getMethod(paramString, null);
      if (paramString != null) {
        if (NVq == null)
        {
          localClass = bdI("java.lang.Throwable");
          NVq = localClass;
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
          paramThrowable = (Throwable)paramString.invoke(paramThrowable, org.apache.commons.b.a.NSG);
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
        localClass = NVq;
      }
    }
  }
  
  private static Throwable f(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(40715);
    try
    {
      paramString = paramThrowable.getClass().getField(paramString);
      if (paramString != null) {
        if (NVq == null)
        {
          localClass = bdI("java.lang.Throwable");
          NVq = localClass;
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
        localClass = NVq;
      }
    }
  }
  
  public static boolean gyi()
  {
    return NVo != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.b.a
 * JD-Core Version:    0.7.0.1
 */