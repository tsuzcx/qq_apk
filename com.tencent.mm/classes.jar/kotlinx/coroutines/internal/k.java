package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.f.b;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "()V", "PREFIX", "", "createInstanceOf", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "Ljava/lang/Class;", "serviceClass", "getProviderInstance", "S", "name", "loader", "Ljava/lang/ClassLoader;", "service", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "load", "", "loadMainDispatcherFactory", "loadMainDispatcherFactory$kotlinx_coroutines_core", "loadProviders", "loadProviders$kotlinx_coroutines_core", "parse", "url", "Ljava/net/URL;", "parseFile", "r", "Ljava/io/BufferedReader;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k ajAu;
  
  static
  {
    AppMethodBeat.i(189454);
    ajAu = new k();
    AppMethodBeat.o(189454);
  }
  
  private static <S> List<S> a(Class<S> paramClass, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(189435);
    Object localObject4;
    try
    {
      Object localObject1 = Collections.list(paramClassLoader.getResources(s.X("META-INF/services/", paramClass.getName())));
      s.s(localObject1, "java.util.Collections.list(this)");
      localObject4 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        p.a((Collection)localObject1, (Iterable)f((URL)((Iterator)localObject4).next()));
      }
      AppMethodBeat.o(189435);
    }
    finally
    {
      paramClass = p.p((Iterable)ServiceLoader.load(paramClass, paramClassLoader));
    }
    return paramClass;
    Object localObject3 = p.r((Iterable)localObject2);
    if (!((Collection)localObject3).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject3 = (Throwable)new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        AppMethodBeat.o(189435);
        throw ((Throwable)localObject3);
      }
      localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Class localClass = Class.forName((String)((Iterator)localObject4).next(), false, paramClassLoader);
        if (!paramClass.isAssignableFrom(localClass))
        {
          localObject3 = (Throwable)new IllegalArgumentException(("Expected service of class " + paramClass + ", but found " + localClass).toString());
          AppMethodBeat.o(189435);
          throw ((Throwable)localObject3);
        }
        ((Collection)localObject3).add(paramClass.cast(localClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])));
      }
      localObject3 = (List)localObject3;
      paramClass = (Class<S>)localObject3;
      break;
    }
  }
  
  private static List<String> b(BufferedReader paramBufferedReader)
  {
    AppMethodBeat.i(189451);
    Set localSet = (Set)new LinkedHashSet();
    label160:
    label172:
    label207:
    for (;;)
    {
      String str = paramBufferedReader.readLine();
      if (str == null) {
        break;
      }
      str = n.rt(str, "#");
      if (str == null)
      {
        paramBufferedReader = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(189451);
        throw paramBufferedReader;
      }
      str = n.bq((CharSequence)str).toString();
      CharSequence localCharSequence = (CharSequence)str;
      int i = 0;
      int j;
      if (i < localCharSequence.length())
      {
        char c = localCharSequence.charAt(i);
        if ((c == '.') || (Character.isJavaIdentifierPart(c)))
        {
          j = 1;
          label116:
          if (j != 0) {
            break label160;
          }
        }
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label172;
        }
        paramBufferedReader = (Throwable)new IllegalArgumentException(s.X("Illegal service provider class name: ", str).toString());
        AppMethodBeat.o(189451);
        throw paramBufferedReader;
        j = 0;
        break label116;
        i += 1;
        break;
      }
      if (((CharSequence)str).length() > 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label207;
        }
        localSet.add(str);
        break;
      }
    }
    paramBufferedReader = p.p((Iterable)localSet);
    AppMethodBeat.o(189451);
    return paramBufferedReader;
  }
  
  private static List<String> f(URL paramURL)
  {
    AppMethodBeat.i(189443);
    Object localObject1 = paramURL.toString();
    if (n.U((String)localObject1, "jar", false))
    {
      paramURL = n.a(n.rv((String)localObject1, "jar:file:"), '!');
      localObject1 = n.rv((String)localObject1, "!/");
      paramURL = new JarFile(paramURL, false);
      try
      {
        localObject1 = (Closeable)new BufferedReader((Reader)new InputStreamReader(paramURL.getInputStream(new ZipEntry((String)localObject1)), "UTF-8"));
        try
        {
          List localList2 = b((BufferedReader)localObject1);
          b.a((Closeable)localObject1, null);
          try
          {
            paramURL.close();
            return localList2;
          }
          finally
          {
            AppMethodBeat.o(189443);
          }
          localThrowable1 = finally;
        }
        finally {}
        paramURL = (Closeable)new BufferedReader((Reader)new InputStreamReader(paramURL.openStream()));
      }
      finally
      {
        try
        {
          AppMethodBeat.o(189443);
          throw localThrowable1;
        }
        finally {}
      }
    }
    try
    {
      List localList1 = b((BufferedReader)paramURL);
      b.a(paramURL, null);
      AppMethodBeat.o(189443);
      return localList1;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(189443);
        throw localThrowable2;
      }
      finally
      {
        b.a(paramURL, localThrowable2);
        AppMethodBeat.o(189443);
      }
    }
  }
  
  public static List<MainDispatcherFactory> kDW()
  {
    AppMethodBeat.i(189426);
    Object localObject1;
    if (!l.ajAv)
    {
      localObject1 = a(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
      AppMethodBeat.o(189426);
      return localObject1;
    }
    for (;;)
    {
      try
      {
        localArrayList = new ArrayList(2);
      }
      finally
      {
        ArrayList localArrayList;
        Object localObject2;
        Object localObject3;
        List localList = a(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        continue;
      }
      try
      {
        localObject1 = (MainDispatcherFactory)MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        try
        {
          localObject1 = (MainDispatcherFactory)MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
          if (localObject1 != null) {
            localArrayList.add(localObject1);
          }
          localObject1 = (List)localArrayList;
          AppMethodBeat.o(189426);
          return localObject1;
          localClassNotFoundException1 = localClassNotFoundException1;
          localObject2 = null;
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          localObject3 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.k
 * JD-Core Version:    0.7.0.1
 */