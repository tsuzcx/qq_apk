package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "()V", "PREFIX", "", "createInstanceOf", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "Ljava/lang/Class;", "serviceClass", "getProviderInstance", "S", "name", "loader", "Ljava/lang/ClassLoader;", "service", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "load", "", "loadMainDispatcherFactory", "loadMainDispatcherFactory$kotlinx_coroutines_core", "loadProviders", "loadProviders$kotlinx_coroutines_core", "parse", "url", "Ljava/net/URL;", "parseFile", "r", "Ljava/io/BufferedReader;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class f
{
  public static final f OgM;
  
  static
  {
    AppMethodBeat.i(209298);
    OgM = new f();
    AppMethodBeat.o(209298);
  }
  
  private static <S> List<S> a(Class<S> paramClass, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(209295);
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
      AppMethodBeat.o(209295);
    }
    catch (Throwable localThrowable)
    {
      paramClass = j.l((Iterable)ServiceLoader.load(paramClass, paramClassLoader));
    }
    return paramClass;
    Object localObject2 = j.n((Iterable)localThrowable);
    if (!((Collection)localObject2).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject2 = (Throwable)new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        AppMethodBeat.o(209295);
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
          AppMethodBeat.o(209295);
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
    AppMethodBeat.i(209297);
    Set localSet = (Set)new LinkedHashSet();
    label132:
    label179:
    label191:
    label226:
    for (;;)
    {
      String str = paramBufferedReader.readLine();
      if (str == null)
      {
        paramBufferedReader = j.l((Iterable)localSet);
        AppMethodBeat.o(209297);
        return paramBufferedReader;
      }
      str = n.nH(str, "#");
      if (str == null)
      {
        paramBufferedReader = new v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(209297);
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
            break label179;
          }
        }
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label191;
        }
        paramBufferedReader = (Throwable)new IllegalArgumentException("Illegal service provider class name: ".concat(String.valueOf(str)).toString());
        AppMethodBeat.o(209297);
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
          break label226;
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
    //   4: ldc_w 267
    //   7: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokevirtual 268	java/net/URL:toString	()Ljava/lang/String;
    //   14: astore_3
    //   15: aload_3
    //   16: ldc_w 270
    //   19: invokestatic 274	d/n/n:nF	(Ljava/lang/String;Ljava/lang/String;)Z
    //   22: ifeq +179 -> 201
    //   25: aload_3
    //   26: ldc_w 276
    //   29: invokestatic 279	d/n/n:nJ	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   32: bipush 33
    //   34: invokestatic 282	d/n/n:a	(Ljava/lang/String;C)Ljava/lang/String;
    //   37: astore_0
    //   38: aload_3
    //   39: ldc_w 284
    //   42: invokestatic 279	d/n/n:nJ	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_1
    //   46: new 286	java/util/jar/JarFile
    //   49: dup
    //   50: aload_0
    //   51: iconst_0
    //   52: invokespecial 289	java/util/jar/JarFile:<init>	(Ljava/lang/String;Z)V
    //   55: astore_3
    //   56: new 218	java/io/BufferedReader
    //   59: dup
    //   60: new 291	java/io/InputStreamReader
    //   63: dup
    //   64: aload_3
    //   65: new 293	java/util/zip/ZipEntry
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 294	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   73: invokevirtual 298	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   76: ldc_w 300
    //   79: invokespecial 303	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   82: checkcast 305	java/io/Reader
    //   85: invokespecial 308	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   88: checkcast 310	java/io/Closeable
    //   91: astore 4
    //   93: aload 4
    //   95: checkcast 218	java/io/BufferedReader
    //   98: invokestatic 312	kotlinx/coroutines/internal/f:b	(Ljava/io/BufferedReader;)Ljava/util/List;
    //   101: astore_0
    //   102: aload 4
    //   104: aconst_null
    //   105: invokestatic 317	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   108: aload_3
    //   109: invokevirtual 320	java/util/jar/JarFile:close	()V
    //   112: ldc_w 267
    //   115: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_0
    //   119: areturn
    //   120: astore_0
    //   121: ldc_w 267
    //   124: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aload_0
    //   128: athrow
    //   129: astore_1
    //   130: ldc_w 267
    //   133: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_1
    //   137: athrow
    //   138: astore_0
    //   139: aload 4
    //   141: aload_1
    //   142: invokestatic 317	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   145: ldc_w 267
    //   148: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_0
    //   152: athrow
    //   153: astore_0
    //   154: ldc_w 267
    //   157: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_0
    //   161: athrow
    //   162: astore_1
    //   163: aload_3
    //   164: invokevirtual 320	java/util/jar/JarFile:close	()V
    //   167: ldc_w 267
    //   170: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: aload_1
    //   174: athrow
    //   175: astore_1
    //   176: aload_0
    //   177: ifnonnull +11 -> 188
    //   180: ldc_w 267
    //   183: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_1
    //   187: athrow
    //   188: aload_0
    //   189: aload_1
    //   190: invokestatic 325	d/a:a	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   193: ldc_w 267
    //   196: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload_0
    //   200: athrow
    //   201: new 218	java/io/BufferedReader
    //   204: dup
    //   205: new 291	java/io/InputStreamReader
    //   208: dup
    //   209: aload_0
    //   210: invokevirtual 329	java/net/URL:openStream	()Ljava/io/InputStream;
    //   213: invokespecial 332	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   216: checkcast 305	java/io/Reader
    //   219: invokespecial 308	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   222: checkcast 310	java/io/Closeable
    //   225: astore_2
    //   226: aload_2
    //   227: checkcast 218	java/io/BufferedReader
    //   230: invokestatic 312	kotlinx/coroutines/internal/f:b	(Ljava/io/BufferedReader;)Ljava/util/List;
    //   233: astore_0
    //   234: aload_2
    //   235: aconst_null
    //   236: invokestatic 317	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   239: ldc_w 267
    //   242: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aload_0
    //   246: areturn
    //   247: astore_1
    //   248: ldc_w 267
    //   251: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: aload_1
    //   255: athrow
    //   256: astore_0
    //   257: aload_2
    //   258: aload_1
    //   259: invokestatic 317	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   262: ldc_w 267
    //   265: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: aload_0
    //   269: athrow
    //   270: astore_0
    //   271: goto -14 -> 257
    //   274: astore_1
    //   275: aload_2
    //   276: astore_0
    //   277: goto -114 -> 163
    //   280: astore_0
    //   281: aconst_null
    //   282: astore_1
    //   283: goto -144 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramURL	URL
    //   1	69	1	str	String
    //   129	13	1	localThrowable1	Throwable
    //   162	12	1	localObject1	Object
    //   175	15	1	localThrowable2	Throwable
    //   247	12	1	localThrowable3	Throwable
    //   274	1	1	localObject2	Object
    //   282	1	1	localObject3	Object
    //   3	273	2	localCloseable1	java.io.Closeable
    //   14	150	3	localObject4	Object
    //   91	49	4	localCloseable2	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   108	112	120	java/lang/Throwable
    //   93	102	129	java/lang/Throwable
    //   130	138	138	finally
    //   56	93	153	java/lang/Throwable
    //   102	108	153	java/lang/Throwable
    //   139	153	153	java/lang/Throwable
    //   154	162	162	finally
    //   163	167	175	java/lang/Throwable
    //   226	234	247	java/lang/Throwable
    //   248	256	256	finally
    //   226	234	270	finally
    //   56	93	274	finally
    //   102	108	274	finally
    //   139	153	274	finally
    //   93	102	280	finally
  }
  
  public static List<MainDispatcherFactory> gAy()
  {
    AppMethodBeat.i(209294);
    Object localObject1;
    if (!g.gAz())
    {
      localObject1 = a(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
      AppMethodBeat.o(209294);
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
          AppMethodBeat.o(209294);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.internal.f
 * JD-Core Version:    0.7.0.1
 */