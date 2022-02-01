package kotlin.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.k.c;
import kotlin.k.i;
import kotlin.n.n;

public final class b
{
  public static final b abfk;
  private static final Map<String, String> map;
  
  static
  {
    AppMethodBeat.i(59229);
    abfk = new b();
    Map localMap = (Map)new LinkedHashMap();
    Object localObject1 = j.listOf(new String[] { "Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D" });
    Object localObject2 = i.a((c)j.p((Collection)localObject1), 2);
    int i = ((c)localObject2).dHa;
    int j = ((c)localObject2).aaBQ;
    int k = ((c)localObject2).oxQ;
    if (k >= 0)
    {
      if (i > j) {}
    }
    else {
      while (i >= j) {
        for (;;)
        {
          localMap.put("kotlin/" + (String)((List)localObject1).get(i), ((List)localObject1).get(i + 1));
          localMap.put("kotlin/" + (String)((List)localObject1).get(i) + "Array", "[" + (String)((List)localObject1).get(i + 1));
          if (i == j) {
            break;
          }
          i += k;
        }
      }
    }
    localMap.put("kotlin/Unit", "V");
    localObject1 = new b.a(localMap);
    ((b.a)localObject1).pr("Any", "java/lang/Object");
    ((b.a)localObject1).pr("Nothing", "java/lang/Void");
    ((b.a)localObject1).pr("Annotation", "java/lang/annotation/Annotation");
    localObject2 = j.listOf(new String[] { "String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum" }).iterator();
    String str;
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      ((b.a)localObject1).pr(str, "java/lang/".concat(String.valueOf(str)));
    }
    localObject2 = j.listOf(new String[] { "Iterator", "Collection", "List", "Set", "Map", "ListIterator" }).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      ((b.a)localObject1).pr("collections/".concat(String.valueOf(str)), "java/util/".concat(String.valueOf(str)));
      ((b.a)localObject1).pr("collections/Mutable".concat(String.valueOf(str)), "java/util/".concat(String.valueOf(str)));
    }
    ((b.a)localObject1).pr("collections/Iterable", "java/lang/Iterable");
    ((b.a)localObject1).pr("collections/MutableIterable", "java/lang/Iterable");
    ((b.a)localObject1).pr("collections/Map.Entry", "java/util/Map$Entry");
    ((b.a)localObject1).pr("collections/MutableMap.MutableEntry", "java/util/Map$Entry");
    i = 0;
    while (i <= 22)
    {
      ((b.a)localObject1).pr("Function".concat(String.valueOf(i)), "kotlin/jvm/functions/Function".concat(String.valueOf(i)));
      ((b.a)localObject1).pr("reflect/KFunction".concat(String.valueOf(i)), "kotlin/reflect/KFunction");
      i += 1;
    }
    localObject2 = j.listOf(new String[] { "Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum" }).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      ((b.a)localObject1).pr(str + ".Companion", "kotlin/jvm/internal/" + str + "CompanionObject");
    }
    map = localMap;
    AppMethodBeat.o(59229);
  }
  
  public static final String bGZ(String paramString)
  {
    AppMethodBeat.i(59228);
    p.k(paramString, "classId");
    String str2 = (String)map.get(paramString);
    String str1 = str2;
    if (str2 == null) {
      str1 = "L" + n.a(paramString, '.', '$') + ';';
    }
    AppMethodBeat.o(59228);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.e.c.a.b
 * JD-Core Version:    0.7.0.1
 */