package kotlin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class b
{
  public static final a aiwB;
  
  static
  {
    AppMethodBeat.i(128992);
    int i = kll();
    Object localObject;
    if (i >= 65544) {
      try
      {
        localObject = Class.forName("kotlin.e.b.a").newInstance();
        s.s(localObject, "Class.forName(\"kotlin.in…entations\").newInstance()");
        if (localObject == null)
        {
          ClassLoader localClassLoader;
          try
          {
            NullPointerException localNullPointerException1 = new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            AppMethodBeat.o(128992);
            throw localNullPointerException1;
          }
          catch (ClassCastException localClassCastException1)
          {
            localObject = localObject.getClass().getClassLoader();
            localClassLoader = a.class.getClassLoader();
            Throwable localThrowable1 = new ClassCastException("Instance classloader: " + localObject + ", base type classloader: " + localClassLoader).initCause((Throwable)localClassCastException1);
            s.s(localThrowable1, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
            AppMethodBeat.o(128992);
            throw localThrowable1;
          }
          try
          {
            NullPointerException localNullPointerException2;
            Throwable localThrowable2;
            localObject = Class.forName("kotlin.e.a.a").newInstance();
            s.s(localObject, "Class.forName(\"kotlin.in…entations\").newInstance()");
            if (localObject == null)
            {
              try
              {
                localNullPointerException3 = new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                AppMethodBeat.o(128992);
                throw localNullPointerException3;
              }
              catch (ClassCastException localClassCastException3)
              {
                localObject = localObject.getClass().getClassLoader();
                localClassLoader = a.class.getClassLoader();
                localThrowable3 = new ClassCastException("Instance classloader: " + localObject + ", base type classloader: " + localClassLoader).initCause((Throwable)localClassCastException3);
                s.s(localThrowable3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                AppMethodBeat.o(128992);
                throw localThrowable3;
              }
              aiwB = locala;
            }
          }
          catch (ClassNotFoundException localClassNotFoundException3)
          {
            try
            {
              localObject = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
              s.s(localObject, "Class.forName(\"kotlin.in…entations\").newInstance()");
              if (localObject == null)
              {
                try
                {
                  localNullPointerException4 = new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                  AppMethodBeat.o(128992);
                  throw localNullPointerException4;
                }
                catch (ClassCastException localClassCastException4)
                {
                  localObject = localObject.getClass().getClassLoader();
                  localClassLoader = a.class.getClassLoader();
                  localThrowable4 = new ClassCastException("Instance classloader: " + localObject + ", base type classloader: " + localClassLoader).initCause((Throwable)localClassCastException4);
                  s.s(localThrowable4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
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
          s.s(localObject, "Class.forName(\"kotlin.in…entations\").newInstance()");
          if (localObject == null)
          {
            try
            {
              localNullPointerException2 = new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
              AppMethodBeat.o(128992);
              throw localNullPointerException2;
            }
            catch (ClassCastException localClassCastException2)
            {
              localObject = localObject.getClass().getClassLoader();
              localClassLoader = a.class.getClassLoader();
              localThrowable2 = new ClassCastException("Instance classloader: " + localObject + ", base type classloader: " + localClassLoader).initCause((Throwable)localClassCastException2);
              s.s(localThrowable2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
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
      NullPointerException localNullPointerException3;
      Throwable localThrowable3;
      NullPointerException localNullPointerException4;
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
  
  private static final int kll()
  {
    j = 65542;
    AppMethodBeat.i(128991);
    String str = System.getProperty("java.specification.version");
    if (str == null)
    {
      AppMethodBeat.o(128991);
      return 65542;
    }
    int m = n.a((CharSequence)str, '.', 0, false, 6);
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
    int k = n.a((CharSequence)str, '.', m + 1, false, 4);
    i = k;
    if (k < 0) {
      i = str.length();
    }
    if (str == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(128991);
      throw ((Throwable)localObject);
    }
    Object localObject = str.substring(0, m);
    s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    if (str == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(128991);
      throw ((Throwable)localObject);
    }
    str = str.substring(m + 1, i);
    s.s(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.e.b
 * JD-Core Version:    0.7.0.1
 */