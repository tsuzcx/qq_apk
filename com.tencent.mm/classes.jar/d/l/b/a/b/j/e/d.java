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
  private static final Set<b> NUh;
  private static final Map<String, d> NUi;
  private static final Map<h, d> NUj;
  private static final Map<String, d> NUk;
  private final h NUl;
  private final b NUm;
  private final String desc;
  private final String name;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(60184);
    NTZ = new d("BOOLEAN", 0, h.NoM, "boolean", "Z", "java.lang.Boolean");
    NUa = new d("CHAR", 1, h.NoN, "char", "C", "java.lang.Character");
    NUb = new d("BYTE", 2, h.NoO, "byte", "B", "java.lang.Byte");
    NUc = new d("SHORT", 3, h.NoP, "short", "S", "java.lang.Short");
    NUd = new d("INT", 4, h.NoQ, "int", "I", "java.lang.Integer");
    NUe = new d("FLOAT", 5, h.NoR, "float", "F", "java.lang.Float");
    NUf = new d("LONG", 6, h.NoS, "long", "J", "java.lang.Long");
    NUg = new d("DOUBLE", 7, h.NoT, "double", "D", "java.lang.Double");
    NUn = new d[] { NTZ, NUa, NUb, NUc, NUd, NUe, NUf, NUg };
    NUh = new HashSet();
    NUi = new HashMap();
    NUj = new EnumMap(h.class);
    NUk = new HashMap();
    d[] arrayOfd = values();
    int j = arrayOfd.length;
    while (i < j)
    {
      d locald = arrayOfd[i];
      NUh.add(locald.gxI());
      NUi.put(locald.gxH(), locald);
      NUj.put(locald.gxG(), locald);
      NUk.put(locald.getDesc(), locald);
      i += 1;
    }
    AppMethodBeat.o(60184);
  }
  
  private d(h paramh, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(60179);
    this.NUl = paramh;
    this.name = paramString1;
    this.desc = paramString2;
    this.NUm = new b(paramString3);
    AppMethodBeat.o(60179);
  }
  
  public static d bev(String paramString)
  {
    AppMethodBeat.i(60177);
    if (paramString == null) {
      ajW(1);
    }
    d locald = (d)NUi.get(paramString);
    if (locald == null)
    {
      paramString = new AssertionError("Non-primitive type name passed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(60177);
      throw paramString;
    }
    if (locald == null) {
      ajW(2);
    }
    AppMethodBeat.o(60177);
    return locald;
  }
  
  public static d d(h paramh)
  {
    AppMethodBeat.i(60178);
    if (paramh == null) {
      ajW(3);
    }
    paramh = (d)NUj.get(paramh);
    if (paramh == null) {
      ajW(4);
    }
    AppMethodBeat.o(60178);
    return paramh;
  }
  
  public final String getDesc()
  {
    AppMethodBeat.i(60182);
    String str = this.desc;
    if (str == null) {
      ajW(12);
    }
    AppMethodBeat.o(60182);
    return str;
  }
  
  public final h gxG()
  {
    AppMethodBeat.i(60180);
    h localh = this.NUl;
    if (localh == null) {
      ajW(10);
    }
    AppMethodBeat.o(60180);
    return localh;
  }
  
  public final String gxH()
  {
    AppMethodBeat.i(60181);
    String str = this.name;
    if (str == null) {
      ajW(11);
    }
    AppMethodBeat.o(60181);
    return str;
  }
  
  public final b gxI()
  {
    AppMethodBeat.i(60183);
    b localb = this.NUm;
    if (localb == null) {
      ajW(13);
    }
    AppMethodBeat.o(60183);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.e.d
 * JD-Core Version:    0.7.0.1
 */