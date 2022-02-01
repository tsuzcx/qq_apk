package d.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.a.h;
import d.l.b.a.b.f.b;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum d
{
  private static final Set<b> JSK;
  private static final Map<String, d> JSL;
  private static final Map<h, d> JSM;
  private static final Map<String, d> JSN;
  private final h JSO;
  private final b JSP;
  private final String desc;
  private final String name;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(60184);
    JSC = new d("BOOLEAN", 0, h.Jns, "boolean", "Z", "java.lang.Boolean");
    JSD = new d("CHAR", 1, h.Jnt, "char", "C", "java.lang.Character");
    JSE = new d("BYTE", 2, h.Jnu, "byte", "B", "java.lang.Byte");
    JSF = new d("SHORT", 3, h.Jnv, "short", "S", "java.lang.Short");
    JSG = new d("INT", 4, h.Jnw, "int", "I", "java.lang.Integer");
    JSH = new d("FLOAT", 5, h.Jnx, "float", "F", "java.lang.Float");
    JSI = new d("LONG", 6, h.Jny, "long", "J", "java.lang.Long");
    JSJ = new d("DOUBLE", 7, h.Jnz, "double", "D", "java.lang.Double");
    JSQ = new d[] { JSC, JSD, JSE, JSF, JSG, JSH, JSI, JSJ };
    JSK = new HashSet();
    JSL = new HashMap();
    JSM = new EnumMap(h.class);
    JSN = new HashMap();
    d[] arrayOfd = values();
    int j = arrayOfd.length;
    while (i < j)
    {
      d locald = arrayOfd[i];
      JSK.add(locald.fJe());
      JSL.put(locald.fJd(), locald);
      JSM.put(locald.fJc(), locald);
      JSN.put(locald.getDesc(), locald);
      i += 1;
    }
    AppMethodBeat.o(60184);
  }
  
  private d(h paramh, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(60179);
    this.JSO = paramh;
    this.name = paramString1;
    this.desc = paramString2;
    this.JSP = new b(paramString3);
    AppMethodBeat.o(60179);
  }
  
  public static d aQP(String paramString)
  {
    AppMethodBeat.i(60177);
    if (paramString == null) {
      adP(1);
    }
    d locald = (d)JSL.get(paramString);
    if (locald == null)
    {
      paramString = new AssertionError("Non-primitive type name passed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(60177);
      throw paramString;
    }
    if (locald == null) {
      adP(2);
    }
    AppMethodBeat.o(60177);
    return locald;
  }
  
  public static d d(h paramh)
  {
    AppMethodBeat.i(60178);
    if (paramh == null) {
      adP(3);
    }
    paramh = (d)JSM.get(paramh);
    if (paramh == null) {
      adP(4);
    }
    AppMethodBeat.o(60178);
    return paramh;
  }
  
  public final h fJc()
  {
    AppMethodBeat.i(60180);
    h localh = this.JSO;
    if (localh == null) {
      adP(10);
    }
    AppMethodBeat.o(60180);
    return localh;
  }
  
  public final String fJd()
  {
    AppMethodBeat.i(60181);
    String str = this.name;
    if (str == null) {
      adP(11);
    }
    AppMethodBeat.o(60181);
    return str;
  }
  
  public final b fJe()
  {
    AppMethodBeat.i(60183);
    b localb = this.JSP;
    if (localb == null) {
      adP(13);
    }
    AppMethodBeat.o(60183);
    return localb;
  }
  
  public final String getDesc()
  {
    AppMethodBeat.i(60182);
    String str = this.desc;
    if (str == null) {
      adP(12);
    }
    AppMethodBeat.o(60182);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.e.d
 * JD-Core Version:    0.7.0.1
 */