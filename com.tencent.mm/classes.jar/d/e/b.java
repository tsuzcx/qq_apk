package d.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"})
public final class b
{
  public static final a Jhd;
  
  static
  {
    AppMethodBeat.i(128992);
    int i = fvJ();
    Object localObject;
    if (i >= 65544) {
      try
      {
        localObject = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
        k.g(localObject, "Class.forName(\"kotlin.in…entations\").newInstance()");
        if (localObject == null)
        {
          ClassLoader localClassLoader;
          try
          {
            v localv1 = new v("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            AppMethodBeat.o(128992);
            throw localv1;
          }
          catch (ClassCastException localClassCastException1)
          {
            localObject = localObject.getClass().getClassLoader();
            localClassLoader = a.class.getClassLoader();
            Throwable localThrowable1 = new ClassCastException("Instance classloader: " + localObject + ", base type classloader: " + localClassLoader).initCause((Throwable)localClassCastException1);
            k.g(localThrowable1, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
            AppMethodBeat.o(128992);
            throw localThrowable1;
          }
          try
          {
            v localv2;
            Throwable localThrowable2;
            localObject = Class.forName("d.e.a.a").newInstance();
            k.g(localObject, "Class.forName(\"kotlin.in…entations\").newInstance()");
            if (localObject == null)
            {
              try
              {
                localv3 = new v("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                AppMethodBeat.o(128992);
                throw localv3;
              }
              catch (ClassCastException localClassCastException3)
              {
                localObject = localObject.getClass().getClassLoader();
                localClassLoader = a.class.getClassLoader();
                localThrowable3 = new ClassCastException("Instance classloader: " + localObject + ", base type classloader: " + localClassLoader).initCause((Throwable)localClassCastException3);
                k.g(localThrowable3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                AppMethodBeat.o(128992);
                throw localThrowable3;
              }
              Jhd = locala;
            }
          }
          catch (ClassNotFoundException localClassNotFoundException3)
          {
            try
            {
              localObject = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
              k.g(localObject, "Class.forName(\"kotlin.in…entations\").newInstance()");
              if (localObject == null)
              {
                try
                {
                  localv4 = new v("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                  AppMethodBeat.o(128992);
                  throw localv4;
                }
                catch (ClassCastException localClassCastException4)
                {
                  localObject = localObject.getClass().getClassLoader();
                  localClassLoader = a.class.getClassLoader();
                  localThrowable4 = new ClassCastException("Instance classloader: " + localObject + ", base type classloader: " + localClassLoader).initCause((Throwable)localClassCastException4);
                  k.g(localThrowable4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                  AppMethodBeat.o(128992);
                  throw localThrowable4;
                }
                locala = new a();
              }
            }
            catch (ClassNotFoundException localClassNotFoundException4) {}
          }
        }
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        try
        {
          localObject = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
          k.g(localObject, "Class.forName(\"kotlin.in…entations\").newInstance()");
          if (localObject == null)
          {
            try
            {
              localv2 = new v("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
              AppMethodBeat.o(128992);
              throw localv2;
            }
            catch (ClassCastException localClassCastException2)
            {
              localObject = localObject.getClass().getClassLoader();
              localClassLoader = a.class.getClassLoader();
              localThrowable2 = new ClassCastException("Instance classloader: " + localObject + ", base type classloader: " + localClassLoader).initCause((Throwable)localClassCastException2);
              k.g(localThrowable2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
              AppMethodBeat.o(128992);
              throw localThrowable2;
            }
            if (i < 65543) {}
          }
        }
        catch (ClassNotFoundException localClassNotFoundException2) {}
      }
    }
    for (;;)
    {
      v localv3;
      Throwable localThrowable3;
      v localv4;
      Throwable localThrowable4;
      AppMethodBeat.o(128992);
      return;
      a locala = (a)localObject;
      continue;
      locala = (a)localObject;
      continue;
      locala = (a)localObject;
      continue;
      locala = (a)localObject;
    }
  }
  
  private static final int fvJ()
  {
    j = 65542;
    AppMethodBeat.i(128991);
    String str = System.getProperty("java.specification.version");
    if (str == null)
    {
      AppMethodBeat.o(128991);
      return 65542;
    }
    int m = n.a((CharSequence)str, '.', 0, 6);
    if (m < 0)
    {
      try
      {
        i = Integer.parseInt(str);
        i *= 65536;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        for (;;)
        {
          i = 65542;
        }
      }
      AppMethodBeat.o(128991);
      return i;
    }
    int k = n.a((CharSequence)str, '.', m + 1, 4);
    i = k;
    if (k < 0) {
      i = str.length();
    }
    if (str == null)
    {
      localObject = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(128991);
      throw ((Throwable)localObject);
    }
    Object localObject = str.substring(0, m);
    k.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    if (str == null)
    {
      localObject = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(128991);
      throw ((Throwable)localObject);
    }
    str = str.substring(m + 1, i);
    k.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    try
    {
      i = Integer.parseInt((String)localObject);
      k = Integer.parseInt(str);
      i = i * 65536 + k;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      for (;;)
      {
        i = j;
      }
    }
    AppMethodBeat.o(128991);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.e.b
 * JD-Core Version:    0.7.0.1
 */