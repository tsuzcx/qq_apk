package kotlin.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.p;
import kotlin.e.c;
import kotlin.g.b.s;
import kotlin.n.n;

public final class b
{
  public static final b ajdX;
  private static final String ajdY;
  private static final Map<String, String> map;
  
  static
  {
    AppMethodBeat.i(59229);
    ajdX = new b();
    ajdY = p.a((Iterable)p.listOf(new Character[] { Character.valueOf('k'), Character.valueOf('o'), Character.valueOf('t'), Character.valueOf('l'), Character.valueOf('i'), Character.valueOf('n') }), (CharSequence)"", null, null, 0, null, null, 62);
    Map localMap = (Map)new LinkedHashMap();
    Object localObject = p.listOf(new String[] { "Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D" });
    int j = c.bO(0, ((List)localObject).size() - 1, 2);
    int i;
    if (j >= 0) {
      i = 0;
    }
    for (;;)
    {
      localMap.put(ajdY + '/' + (String)((List)localObject).get(i), ((List)localObject).get(i + 1));
      localMap.put(ajdY + '/' + (String)((List)localObject).get(i) + "Array", s.X("[", ((List)localObject).get(i + 1)));
      if (i == j)
      {
        localMap.put(s.X(ajdY, "/Unit"), "V");
        g(localMap, "Any", "java/lang/Object");
        g(localMap, "Nothing", "java/lang/Void");
        g(localMap, "Annotation", "java/lang/annotation/Annotation");
        localObject = p.listOf(new String[] { "String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum" }).iterator();
        String str;
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          g(localMap, str, s.X("java/lang/", str));
        }
        localObject = p.listOf(new String[] { "Iterator", "Collection", "List", "Set", "Map", "ListIterator" }).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          g(localMap, s.X("collections/", str), s.X("java/util/", str));
          g(localMap, s.X("collections/Mutable", str), s.X("java/util/", str));
        }
        g(localMap, "collections/Iterable", "java/lang/Iterable");
        g(localMap, "collections/MutableIterable", "java/lang/Iterable");
        g(localMap, "collections/Map.Entry", "java/util/Map$Entry");
        g(localMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (i = 0;; i = j)
        {
          j = i + 1;
          g(localMap, s.X("Function", Integer.valueOf(i)), ajdY + "/jvm/functions/Function" + i);
          g(localMap, s.X("reflect/KFunction", Integer.valueOf(i)), s.X(ajdY, "/reflect/KFunction"));
          if (j > 22)
          {
            localObject = p.listOf(new String[] { "Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum" }).iterator();
            while (((Iterator)localObject).hasNext())
            {
              str = (String)((Iterator)localObject).next();
              g(localMap, s.X(str, ".Companion"), ajdY + "/jvm/internal/" + str + "CompanionObject");
            }
            map = localMap;
            AppMethodBeat.o(59229);
            return;
          }
        }
      }
      i += 2;
    }
  }
  
  public static final String bJc(String paramString)
  {
    AppMethodBeat.i(59228);
    s.u(paramString, "classId");
    String str = (String)map.get(paramString);
    if (str == null)
    {
      paramString = "L" + n.a(paramString, '.', '$') + ';';
      AppMethodBeat.o(59228);
      return paramString;
    }
    AppMethodBeat.o(59228);
    return str;
  }
  
  private static final void g(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(191552);
    paramMap.put(ajdY + '/' + paramString1, "L" + paramString2 + ';');
    AppMethodBeat.o(191552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.c.a.b
 * JD-Core Version:    0.7.0.1
 */