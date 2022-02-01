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
  private static final Set<b> ablG;
  private static final Map<String, d> ablH;
  private static final Map<h, d> ablI;
  private static final Map<String, d> ablJ;
  private final h ablK;
  private final b ablL;
  private final String desc;
  private final String name;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(60184);
    ably = new d("BOOLEAN", 0, h.aaHo, "boolean", "Z", "java.lang.Boolean");
    ablz = new d("CHAR", 1, h.aaHp, "char", "C", "java.lang.Character");
    ablA = new d("BYTE", 2, h.aaHq, "byte", "B", "java.lang.Byte");
    ablB = new d("SHORT", 3, h.aaHr, "short", "S", "java.lang.Short");
    ablC = new d("INT", 4, h.aaHs, "int", "I", "java.lang.Integer");
    ablD = new d("FLOAT", 5, h.aaHt, "float", "F", "java.lang.Float");
    ablE = new d("LONG", 6, h.aaHu, "long", "J", "java.lang.Long");
    ablF = new d("DOUBLE", 7, h.aaHv, "double", "D", "java.lang.Double");
    ablM = new d[] { ably, ablz, ablA, ablB, ablC, ablD, ablE, ablF };
    ablG = new HashSet();
    ablH = new HashMap();
    ablI = new EnumMap(h.class);
    ablJ = new HashMap();
    d[] arrayOfd = values();
    int j = arrayOfd.length;
    while (i < j)
    {
      d locald = arrayOfd[i];
      ablG.add(locald.iPb());
      ablH.put(locald.iPa(), locald);
      ablI.put(locald.iOZ(), locald);
      ablJ.put(locald.getDesc(), locald);
      i += 1;
    }
    AppMethodBeat.o(60184);
  }
  
  private d(h paramh, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(60179);
    this.ablK = paramh;
    this.name = paramString1;
    this.desc = paramString2;
    this.ablL = new b(paramString3);
    AppMethodBeat.o(60179);
  }
  
  public static d bHm(String paramString)
  {
    AppMethodBeat.i(60177);
    if (paramString == null) {
      aDG(1);
    }
    d locald = (d)ablH.get(paramString);
    if (locald == null)
    {
      paramString = new AssertionError("Non-primitive type name passed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(60177);
      throw paramString;
    }
    if (locald == null) {
      aDG(2);
    }
    AppMethodBeat.o(60177);
    return locald;
  }
  
  public static d d(h paramh)
  {
    AppMethodBeat.i(60178);
    if (paramh == null) {
      aDG(3);
    }
    paramh = (d)ablI.get(paramh);
    if (paramh == null) {
      aDG(4);
    }
    AppMethodBeat.o(60178);
    return paramh;
  }
  
  public final String getDesc()
  {
    AppMethodBeat.i(60182);
    String str = this.desc;
    if (str == null) {
      aDG(12);
    }
    AppMethodBeat.o(60182);
    return str;
  }
  
  public final h iOZ()
  {
    AppMethodBeat.i(60180);
    h localh = this.ablK;
    if (localh == null) {
      aDG(10);
    }
    AppMethodBeat.o(60180);
    return localh;
  }
  
  public final String iPa()
  {
    AppMethodBeat.i(60181);
    String str = this.name;
    if (str == null) {
      aDG(11);
    }
    AppMethodBeat.o(60181);
    return str;
  }
  
  public final b iPb()
  {
    AppMethodBeat.i(60183);
    b localb = this.ablL;
    if (localb == null) {
      aDG(13);
    }
    AppMethodBeat.o(60183);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.e.d
 * JD-Core Version:    0.7.0.1
 */