package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "()V", "PREFIX", "", "createInstanceOf", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "Ljava/lang/Class;", "serviceClass", "getProviderInstance", "S", "name", "loader", "Ljava/lang/ClassLoader;", "service", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "load", "", "loadMainDispatcherFactory", "loadMainDispatcherFactory$kotlinx_coroutines_core", "loadProviders", "loadProviders$kotlinx_coroutines_core", "parse", "url", "Ljava/net/URL;", "parseFile", "r", "Ljava/io/BufferedReader;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class g
{
  public static final g TVK;
  
  static
  {
    AppMethodBeat.i(192440);
    TVK = new g();
    AppMethodBeat.o(192440);
  }
  
  private static <S> List<S> a(Class<S> paramClass, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(192437);
    Object localObject3;
    try
    {
      Object localObject1 = Collections.list(paramClassLoader.getResources("META-INF/services/" + paramClass.getName()));
      p.g(localObject1, "java.util.Collections.list(this)");
      localObject3 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        j.a((Collection)localObject1, (Iterable)f((URL)((Iterator)localObject3).next()));
      }
      AppMethodBeat.o(192437);
    }
    catch (Throwable localThrowable)
    {
      paramClass = j.p((Iterable)ServiceLoader.load(paramClass, paramClassLoader));
    }
    return paramClass;
    Object localObject2 = j.r((Iterable)localThrowable);
    if (!((Collection)localObject2).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject2 = (Throwable)new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        AppMethodBeat.o(192437);
        throw ((Throwable)localObject2);
      }
      localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Class localClass = Class.forName((String)((Iterator)localObject3).next(), false, paramClassLoader);
        if (!paramClass.isAssignableFrom(localClass))
        {
          localObject2 = (Throwable)new IllegalArgumentException(("Expected service of class " + paramClass + ", but found " + localClass).toString());
          AppMethodBeat.o(192437);
          throw ((Throwable)localObject2);
        }
        ((Collection)localObject2).add(paramClass.cast(localClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])));
      }
      localObject2 = (List)localObject2;
      paramClass = (Class<S>)localObject2;
      break;
    }
  }
  
  private static List<String> b(BufferedReader paramBufferedReader)
  {
    AppMethodBeat.i(192439);
    Set localSet = (Set)new LinkedHashSet();
    label132:
    label178:
    label190:
    label225:
    for (;;)
    {
      String str = paramBufferedReader.readLine();
      if (str == null)
      {
        paramBufferedReader = j.p((Iterable)localSet);
        AppMethodBeat.o(192439);
        return paramBufferedReader;
      }
      str = n.oz(str, "#");
      if (str == null)
      {
        paramBufferedReader = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(192439);
        throw paramBufferedReader;
      }
      str = n.trim((CharSequence)str).toString();
      CharSequence localCharSequence = (CharSequence)str;
      int i = 0;
      int j;
      if (i < localCharSequence.length())
      {
        char c = localCharSequence.charAt(i);
        if ((c == '.') || (Character.isJavaIdentifierPart(c)))
        {
          j = 1;
          if (j != 0) {
            break label178;
          }
        }
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label190;
        }
        paramBufferedReader = (Throwable)new IllegalArgumentException("Illegal service provider class name: ".concat(String.valueOf(str)).toString());
        AppMethodBeat.o(192439);
        throw paramBufferedReader;
        j = 0;
        break label132;
        i += 1;
        break;
      }
      if (((CharSequence)str).length() > 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label225;
        }
        localSet.add(str);
        break;
      }
    }
  }
  
  /* Error */
  private static List<String> f(URL paramURL)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: ldc_w 266
    //   7: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokevirtual 267	java/net/URL:toString	()Ljava/lang/String;
    //   14: astore_3
    //   15: aload_3
    //   16: ldc_w 269
    //   19: iconst_0
    //   20: invokestatic 273	kotlin/n/n:J	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   23: ifeq +179 -> 202
    //   26: aload_3
    //   27: ldc_w 275
    //   30: invokestatic 278	kotlin/n/n:oB	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: bipush 33
    //   35: invokestatic 281	kotlin/n/n:a	(Ljava/lang/String;C)Ljava/lang/String;
    //   38: astore_0
    //   39: aload_3
    //   40: ldc_w 283
    //   43: invokestatic 278	kotlin/n/n:oB	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   46: astore_1
    //   47: new 285	java/util/jar/JarFile
    //   50: dup
    //   51: aload_0
    //   52: iconst_0
    //   53: invokespecial 288	java/util/jar/JarFile:<init>	(Ljava/lang/String;Z)V
    //   56: astore_3
    //   57: new 217	java/io/BufferedReader
    //   60: dup
    //   61: new 290	java/io/InputStreamReader
    //   64: dup
    //   65: aload_3
    //   66: new 292	java/util/zip/ZipEntry
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 293	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   74: invokevirtual 297	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   77: ldc_w 299
    //   80: invokespecial 302	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   83: checkcast 304	java/io/Reader
    //   86: invokespecial 307	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   89: checkcast 309	java/io/Closeable
    //   92: astore 4
    //   94: aload 4
    //   96: checkcast 217	java/io/BufferedReader
    //   99: invokestatic 311	kotlinx/coroutines/internal/g:b	(Ljava/io/BufferedReader;)Ljava/util/List;
    //   102: astore_0
    //   103: aload 4
    //   105: aconst_null
    //   106: invokestatic 316	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   109: aload_3
    //   110: invokevirtual 319	java/util/jar/JarFile:close	()V
    //   113: ldc_w 266
    //   116: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aload_0
    //   120: areturn
    //   121: astore_0
    //   122: ldc_w 266
    //   125: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_0
    //   129: athrow
    //   130: astore_1
    //   131: ldc_w 266
    //   134: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload_1
    //   138: athrow
    //   139: astore_0
    //   140: aload 4
    //   142: aload_1
    //   143: invokestatic 316	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   146: ldc_w 266
    //   149: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_0
    //   153: athrow
    //   154: astore_0
    //   155: ldc_w 266
    //   158: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_0
    //   162: athrow
    //   163: astore_1
    //   164: aload_3
    //   165: invokevirtual 319	java/util/jar/JarFile:close	()V
    //   168: ldc_w 266
    //   171: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_1
    //   175: athrow
    //   176: astore_1
    //   177: aload_0
    //   178: ifnonnull +11 -> 189
    //   181: ldc_w 266
    //   184: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_1
    //   188: athrow
    //   189: aload_0
    //   190: aload_1
    //   191: invokestatic 324	kotlin/a:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   194: ldc_w 266
    //   197: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload_0
    //   201: athrow
    //   202: new 217	java/io/BufferedReader
    //   205: dup
    //   206: new 290	java/io/InputStreamReader
    //   209: dup
    //   210: aload_0
    //   211: invokevirtual 328	java/net/URL:openStream	()Ljava/io/InputStream;
    //   214: invokespecial 331	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   217: checkcast 304	java/io/Reader
    //   220: invokespecial 307	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   223: checkcast 309	java/io/Closeable
    //   226: astore_2
    //   227: aload_2
    //   228: checkcast 217	java/io/BufferedReader
    //   231: invokestatic 311	kotlinx/coroutines/internal/g:b	(Ljava/io/BufferedReader;)Ljava/util/List;
    //   234: astore_0
    //   235: aload_2
    //   236: aconst_null
    //   237: invokestatic 316	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   240: ldc_w 266
    //   243: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_0
    //   247: areturn
    //   248: astore_1
    //   249: ldc_w 266
    //   252: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: aload_1
    //   256: athrow
    //   257: astore_0
    //   258: aload_2
    //   259: aload_1
    //   260: invokestatic 316	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   263: ldc_w 266
    //   266: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload_0
    //   270: athrow
    //   271: astore_0
    //   272: goto -14 -> 258
    //   275: astore_1
    //   276: aload_2
    //   277: astore_0
    //   278: goto -114 -> 164
    //   281: astore_0
    //   282: aconst_null
    //   283: astore_1
    //   284: goto -144 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramURL	URL
    //   1	70	1	str	String
    //   130	13	1	localThrowable1	Throwable
    //   163	12	1	localObject1	Object
    //   176	15	1	localThrowable2	Throwable
    //   248	12	1	localThrowable3	Throwable
    //   275	1	1	localObject2	Object
    //   283	1	1	localObject3	Object
    //   3	274	2	localCloseable1	java.io.Closeable
    //   14	151	3	localObject4	Object
    //   92	49	4	localCloseable2	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   109	113	121	java/lang/Throwable
    //   94	103	130	java/lang/Throwable
    //   131	139	139	finally
    //   57	94	154	java/lang/Throwable
    //   103	109	154	java/lang/Throwable
    //   140	154	154	java/lang/Throwable
    //   155	163	163	finally
    //   164	168	176	java/lang/Throwable
    //   227	235	248	java/lang/Throwable
    //   249	257	257	finally
    //   227	235	271	finally
    //   57	94	275	finally
    //   103	109	275	finally
    //   140	154	275	finally
    //   94	103	281	finally
  }
  
  public static List<MainDispatcherFactory> hNF()
  {
    AppMethodBeat.i(192436);
    Object localObject1;
    if (!h.hNG())
    {
      localObject1 = a(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
      AppMethodBeat.o(192436);
      return localObject1;
    }
    for (;;)
    {
      try
      {
        localArrayList = new ArrayList(2);
      }
      catch (Throwable localThrowable)
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
          AppMethodBeat.o(192436);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.g
 * JD-Core Version:    0.7.0.1
 */