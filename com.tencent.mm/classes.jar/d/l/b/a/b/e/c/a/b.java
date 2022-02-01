package d.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.d;
import d.n.n;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  public static final b NMS;
  private static final Map<String, String> map;
  
  static
  {
    AppMethodBeat.i(59229);
    NMS = new b();
    Map localMap = (Map)new LinkedHashMap();
    Object localObject1 = d.a.j.listOf(new String[] { "Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D" });
    Object localObject2 = d.k.j.a((d)d.a.j.o((Collection)localObject1), 2);
    int i = ((d)localObject2).Njm;
    int j = ((d)localObject2).Njn;
    int k = ((d)localObject2).kyd;
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
    ((b.a)localObject1).nC("Any", "java/lang/Object");
    ((b.a)localObject1).nC("Nothing", "java/lang/Void");
    ((b.a)localObject1).nC("Annotation", "java/lang/annotation/Annotation");
    localObject2 = d.a.j.listOf(new String[] { "String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum" }).iterator();
    String str;
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      ((b.a)localObject1).nC(str, "java/lang/".concat(String.valueOf(str)));
    }
    localObject2 = d.a.j.listOf(new String[] { "Iterator", "Collection", "List", "Set", "Map", "ListIterator" }).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      ((b.a)localObject1).nC("collections/".concat(String.valueOf(str)), "java/util/".concat(String.valueOf(str)));
      ((b.a)localObject1).nC("collections/Mutable".concat(String.valueOf(str)), "java/util/".concat(String.valueOf(str)));
    }
    ((b.a)localObject1).nC("collections/Iterable", "java/lang/Iterable");
    ((b.a)localObject1).nC("collections/MutableIterable", "java/lang/Iterable");
    ((b.a)localObject1).nC("collections/Map.Entry", "java/util/Map$Entry");
    ((b.a)localObject1).nC("collections/MutableMap.MutableEntry", "java/util/Map$Entry");
    i = 0;
    while (i <= 22)
    {
      ((b.a)localObject1).nC("Function".concat(String.valueOf(i)), "kotlin/jvm/functions/Function".concat(String.valueOf(i)));
      ((b.a)localObject1).nC("reflect/KFunction".concat(String.valueOf(i)), "kotlin/reflect/KFunction");
      i += 1;
    }
    localObject2 = d.a.j.listOf(new String[] { "Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum" }).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      ((b.a)localObject1).nC(str + ".Companion", "kotlin/jvm/internal/" + str + "CompanionObject");
    }
    map = localMap;
    AppMethodBeat.o(59229);
  }
  
  public static final String beg(String paramString)
  {
    AppMethodBeat.i(59228);
    p.h(paramString, "classId");
    String str2 = (String)map.get(paramString);
    String str1 = str2;
    if (str2 == null) {
      str1 = "L" + n.a(paramString, '.', '$') + ';';
    }
    AppMethodBeat.o(59228);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.e.c.a.b
 * JD-Core Version:    0.7.0.1
 */