package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.k;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.d.b.v;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.d;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.e.e;

public final class i
{
  public static final i aiGe;
  private static final Set<String> aiGf;
  private static final Set<String> aiGg;
  private static final Set<String> aiGh;
  private static final Set<String> aiGi;
  private static final Set<String> aiGj;
  private static final Set<String> aiGk;
  
  static
  {
    AppMethodBeat.i(191501);
    aiGe = new i();
    Object localObject1 = v.aiXe;
    aiGf = ar.c(v.t("Collection", new String[] { "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;" }), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
    localObject1 = v.aiXe;
    localObject1 = v.aiXe;
    Object localObject2 = (Iterable)p.listOf(new e[] { e.ajkd, e.ajke });
    localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      e locale = (e)((Iterator)localObject2).next();
      String str = locale.kzu().kxT().PF();
      s.s(str, "it.wrapperFqName.shortName().asString()");
      p.a((Collection)localObject1, (Iterable)v.s(str, new String[] { locale.kzt() + "Value()" + locale.getDesc() }));
    }
    aiGg = ar.b(ar.b(ar.b(ar.b(ar.b(ar.b((Set)localObject1, (Iterable)v.t("List", new String[] { "sort(Ljava/util/Comparator;)V" })), (Iterable)v.s("String", new String[] { "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;" })), (Iterable)v.s("Double", new String[] { "isInfinite()Z", "isNaN()Z" })), (Iterable)v.s("Float", new String[] { "isInfinite()Z", "isNaN()Z" })), (Iterable)v.s("Enum", new String[] { "getDeclaringClass()Ljava/lang/Class;", "finalize()V" })), (Iterable)v.s("CharSequence", new String[] { "isEmpty()Z" }));
    localObject1 = v.aiXe;
    aiGh = ar.b(ar.b(ar.b(ar.b(ar.b(ar.b(v.s("CharSequence", new String[] { "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;" }), (Iterable)v.t("Iterator", new String[] { "forEachRemaining(Ljava/util/function/Consumer;)V" })), (Iterable)v.s("Iterable", new String[] { "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;" })), (Iterable)v.s("Throwable", new String[] { "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V" })), (Iterable)v.t("Collection", new String[] { "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z" })), (Iterable)v.t("List", new String[] { "replaceAll(Ljava/util/function/UnaryOperator;)V" })), (Iterable)v.t("Map", new String[] { "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;" }));
    localObject1 = v.aiXe;
    aiGi = ar.b(ar.b(v.t("Collection", new String[] { "removeIf(Ljava/util/function/Predicate;)Z" }), (Iterable)v.t("List", new String[] { "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V" })), (Iterable)v.t("Map", new String[] { "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z" }));
    localObject1 = v.aiXe;
    localObject1 = knX();
    localObject2 = v.al(new String[] { "D" });
    localObject1 = ar.b((Set)localObject1, (Iterable)v.s("Float", (String[])Arrays.copyOf((Object[])localObject2, localObject2.length)));
    localObject2 = v.al(new String[] { "[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;" });
    aiGj = ar.b((Set)localObject1, (Iterable)v.s("String", (String[])Arrays.copyOf((Object[])localObject2, localObject2.length)));
    localObject1 = v.aiXe;
    localObject1 = v.al(new String[] { "Ljava/lang/String;Ljava/lang/Throwable;ZZ" });
    aiGk = v.s("Throwable", (String[])Arrays.copyOf((Object[])localObject1, localObject1.length));
    AppMethodBeat.o(191501);
  }
  
  public static boolean h(d paramd)
  {
    AppMethodBeat.i(191494);
    s.u(paramd, "fqName");
    if (i(paramd))
    {
      AppMethodBeat.o(191494);
      return true;
    }
    c localc = c.aiEX;
    paramd = c.c(paramd);
    if (paramd == null)
    {
      AppMethodBeat.o(191494);
      return false;
    }
    try
    {
      paramd = Class.forName(paramd.kxQ().PF());
      boolean bool = Serializable.class.isAssignableFrom(paramd);
      AppMethodBeat.o(191494);
      return bool;
    }
    catch (ClassNotFoundException paramd)
    {
      AppMethodBeat.o(191494);
    }
    return false;
  }
  
  public static boolean i(d paramd)
  {
    AppMethodBeat.i(191496);
    s.u(paramd, "fqName");
    if ((s.p(paramd, k.a.aiCF)) || (k.b(paramd)))
    {
      AppMethodBeat.o(191496);
      return true;
    }
    AppMethodBeat.o(191496);
    return false;
  }
  
  public static Set<String> knR()
  {
    return aiGf;
  }
  
  public static Set<String> knS()
  {
    return aiGg;
  }
  
  public static Set<String> knT()
  {
    return aiGh;
  }
  
  public static Set<String> knU()
  {
    return aiGi;
  }
  
  public static Set<String> knV()
  {
    return aiGj;
  }
  
  public static Set<String> knW()
  {
    return aiGk;
  }
  
  private static Set<String> knX()
  {
    AppMethodBeat.i(191490);
    Object localObject1 = v.aiXe;
    Object localObject2 = (Iterable)p.listOf(new e[] { e.ajkd, e.ajkf, e.ajkk, e.ajki, e.ajkf, e.ajkh, e.ajkj, e.ajkg });
    localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = ((e)((Iterator)localObject2).next()).kzu().kxT().PF();
      s.s(str, "it.wrapperFqName.shortName().asString()");
      String[] arrayOfString = v.al(new String[] { "Ljava/lang/String;" });
      p.a((Collection)localObject1, (Iterable)v.s(str, (String[])Arrays.copyOf(arrayOfString, arrayOfString.length)));
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(191490);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.i
 * JD-Core Version:    0.7.0.1
 */