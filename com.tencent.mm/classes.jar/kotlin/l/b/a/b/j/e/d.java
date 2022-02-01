package kotlin.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.f.b;

public enum d
{
  private static final Set<b> TJe;
  private static final Map<String, d> TJf;
  private static final Map<h, d> TJg;
  private static final Map<String, d> TJh;
  private final h TJi;
  private final b TJj;
  private final String desc;
  private final String name;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(60184);
    TIW = new d("BOOLEAN", 0, h.Teu, "boolean", "Z", "java.lang.Boolean");
    TIX = new d("CHAR", 1, h.Tev, "char", "C", "java.lang.Character");
    TIY = new d("BYTE", 2, h.Tew, "byte", "B", "java.lang.Byte");
    TIZ = new d("SHORT", 3, h.Tex, "short", "S", "java.lang.Short");
    TJa = new d("INT", 4, h.Tey, "int", "I", "java.lang.Integer");
    TJb = new d("FLOAT", 5, h.Tez, "float", "F", "java.lang.Float");
    TJc = new d("LONG", 6, h.TeA, "long", "J", "java.lang.Long");
    TJd = new d("DOUBLE", 7, h.TeB, "double", "D", "java.lang.Double");
    TJk = new d[] { TIW, TIX, TIY, TIZ, TJa, TJb, TJc, TJd };
    TJe = new HashSet();
    TJf = new HashMap();
    TJg = new EnumMap(h.class);
    TJh = new HashMap();
    d[] arrayOfd = values();
    int j = arrayOfd.length;
    while (i < j)
    {
      d locald = arrayOfd[i];
      TJe.add(locald.hKL());
      TJf.put(locald.hKK(), locald);
      TJg.put(locald.hKJ(), locald);
      TJh.put(locald.getDesc(), locald);
      i += 1;
    }
    AppMethodBeat.o(60184);
  }
  
  private d(h paramh, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(60179);
    this.TJi = paramh;
    this.name = paramString1;
    this.desc = paramString2;
    this.TJj = new b(paramString3);
    AppMethodBeat.o(60179);
  }
  
  public static d buk(String paramString)
  {
    AppMethodBeat.i(60177);
    if (paramString == null) {
      atM(1);
    }
    d locald = (d)TJf.get(paramString);
    if (locald == null)
    {
      paramString = new AssertionError("Non-primitive type name passed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(60177);
      throw paramString;
    }
    if (locald == null) {
      atM(2);
    }
    AppMethodBeat.o(60177);
    return locald;
  }
  
  public static d d(h paramh)
  {
    AppMethodBeat.i(60178);
    if (paramh == null) {
      atM(3);
    }
    paramh = (d)TJg.get(paramh);
    if (paramh == null) {
      atM(4);
    }
    AppMethodBeat.o(60178);
    return paramh;
  }
  
  public final String getDesc()
  {
    AppMethodBeat.i(60182);
    String str = this.desc;
    if (str == null) {
      atM(12);
    }
    AppMethodBeat.o(60182);
    return str;
  }
  
  public final h hKJ()
  {
    AppMethodBeat.i(60180);
    h localh = this.TJi;
    if (localh == null) {
      atM(10);
    }
    AppMethodBeat.o(60180);
    return localh;
  }
  
  public final String hKK()
  {
    AppMethodBeat.i(60181);
    String str = this.name;
    if (str == null) {
      atM(11);
    }
    AppMethodBeat.o(60181);
    return str;
  }
  
  public final b hKL()
  {
    AppMethodBeat.i(60183);
    b localb = this.TJj;
    if (localb == null) {
      atM(13);
    }
    AppMethodBeat.o(60183);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.e.d
 * JD-Core Version:    0.7.0.1
 */