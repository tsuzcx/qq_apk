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
  private static final Object CRl = new Object();
  private static String[] CRm = { "getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable" };
  private static final Method CRn;
  private static final Method CRo;
  static Class CRp;
  
  static
  {
    localObject3 = null;
    AppMethodBeat.i(116943);
    for (;;)
    {
      try
      {
        if (CRp != null) {
          continue;
        }
        localObject1 = azH("java.lang.Throwable");
        CRp = (Class)localObject1;
        localObject1 = ((Class)localObject1).getMethod("getCause", null);
      }
      catch (Exception localException1)
      {
        Object localObject1;
        localClass1 = null;
        continue;
        localClass1 = CRp;
        continue;
        localClass2 = CRp;
        continue;
      }
      CRn = (Method)localObject1;
      try
      {
        if (CRp != null) {
          continue;
        }
        localObject1 = azH("java.lang.Throwable");
        CRp = (Class)localObject1;
        if (CRp != null) {
          continue;
        }
        localClass2 = azH("java.lang.Throwable");
        CRp = localClass2;
        localObject1 = ((Class)localObject1).getMethod("initCause", new Class[] { localClass2 });
      }
      catch (Exception localException2)
      {
        Class localClass2;
        Class localClass1;
        Object localObject2 = localObject3;
        continue;
      }
      CRo = (Method)localObject1;
      AppMethodBeat.o(116943);
      return;
      localObject1 = CRp;
    }
  }
  
  public static Throwable C(Throwable paramThrowable)
  {
    AppMethodBeat.i(116936);
    synchronized (CRl)
    {
      paramThrowable = a(paramThrowable, CRm);
      AppMethodBeat.o(116936);
      return paramThrowable;
    }
  }
  
  private static Throwable a(Throwable paramThrowable, String[] arg1)
  {
    Object localObject1 = null;
    AppMethodBeat.i(116937);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(116937);
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
      synchronized (CRl)
      {
        localObject2 = CRm;
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
    AppMethodBeat.o(116937);
    return localObject2;
  }
  
  private static Class azH(String paramString)
  {
    AppMethodBeat.i(116942);
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(116942);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      paramString = new NoClassDefFoundError(paramString.getMessage());
      AppMethodBeat.o(116942);
      throw paramString;
    }
  }
  
  static String[] azO(String paramString)
  {
    AppMethodBeat.i(116941);
    paramString = new StringTokenizer(paramString, h.LINE_SEPARATOR);
    ArrayList localArrayList = new ArrayList();
    while (paramString.hasMoreTokens()) {
      localArrayList.add(paramString.nextToken());
    }
    paramString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    AppMethodBeat.o(116941);
    return paramString;
  }
  
  private static Throwable d(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(116938);
    try
    {
      paramString = paramThrowable.getClass().getMethod(paramString, null);
      if (paramString != null) {
        if (CRp == null)
        {
          localClass = azH("java.lang.Throwable");
          CRp = localClass;
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
          paramThrowable = (Throwable)paramString.invoke(paramThrowable, org.apache.commons.b.a.COH);
          AppMethodBeat.o(116938);
          return paramThrowable;
        }
        catch (InvocationTargetException paramThrowable)
        {
          Class localClass;
          AppMethodBeat.o(116938);
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
        localClass = CRp;
      }
    }
  }
  
  private static Throwable e(Throwable paramThrowable, String paramString)
  {
    AppMethodBeat.i(116939);
    try
    {
      paramString = paramThrowable.getClass().getField(paramString);
      if (paramString != null) {
        if (CRp == null)
        {
          localClass = azH("java.lang.Throwable");
          CRp = localClass;
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
          AppMethodBeat.o(116939);
          return paramThrowable;
        }
        catch (IllegalArgumentException paramThrowable)
        {
          Class localClass;
          AppMethodBeat.o(116939);
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
        localClass = CRp;
      }
    }
  }
  
  public static boolean ers()
  {
    return CRn != null;
  }
  
  public static void z(List paramList1, List paramList2)
  {
    AppMethodBeat.i(116940);
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
    AppMethodBeat.o(116940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.apache.commons.b.b.a
 * JD-Core Version:    0.7.0.1
 */