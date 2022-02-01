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
  private static final Set<b> Nxb;
  private static final Map<String, d> Nxc;
  private static final Map<h, d> Nxd;
  private static final Map<String, d> Nxe;
  private final h Nxf;
  private final b Nxg;
  private final String desc;
  private final String name;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(60184);
    NwT = new d("BOOLEAN", 0, h.MRH, "boolean", "Z", "java.lang.Boolean");
    NwU = new d("CHAR", 1, h.MRI, "char", "C", "java.lang.Character");
    NwV = new d("BYTE", 2, h.MRJ, "byte", "B", "java.lang.Byte");
    NwW = new d("SHORT", 3, h.MRK, "short", "S", "java.lang.Short");
    NwX = new d("INT", 4, h.MRL, "int", "I", "java.lang.Integer");
    NwY = new d("FLOAT", 5, h.MRM, "float", "F", "java.lang.Float");
    NwZ = new d("LONG", 6, h.MRN, "long", "J", "java.lang.Long");
    Nxa = new d("DOUBLE", 7, h.MRO, "double", "D", "java.lang.Double");
    Nxh = new d[] { NwT, NwU, NwV, NwW, NwX, NwY, NwZ, Nxa };
    Nxb = new HashSet();
    Nxc = new HashMap();
    Nxd = new EnumMap(h.class);
    Nxe = new HashMap();
    d[] arrayOfd = values();
    int j = arrayOfd.length;
    while (i < j)
    {
      d locald = arrayOfd[i];
      Nxb.add(locald.gtg());
      Nxc.put(locald.gtf(), locald);
      Nxd.put(locald.gte(), locald);
      Nxe.put(locald.getDesc(), locald);
      i += 1;
    }
    AppMethodBeat.o(60184);
  }
  
  private d(h paramh, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(60179);
    this.Nxf = paramh;
    this.name = paramString1;
    this.desc = paramString2;
    this.Nxg = new b(paramString3);
    AppMethodBeat.o(60179);
  }
  
  public static d bcR(String paramString)
  {
    AppMethodBeat.i(60177);
    if (paramString == null) {
      ajm(1);
    }
    d locald = (d)Nxc.get(paramString);
    if (locald == null)
    {
      paramString = new AssertionError("Non-primitive type name passed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(60177);
      throw paramString;
    }
    if (locald == null) {
      ajm(2);
    }
    AppMethodBeat.o(60177);
    return locald;
  }
  
  public static d d(h paramh)
  {
    AppMethodBeat.i(60178);
    if (paramh == null) {
      ajm(3);
    }
    paramh = (d)Nxd.get(paramh);
    if (paramh == null) {
      ajm(4);
    }
    AppMethodBeat.o(60178);
    return paramh;
  }
  
  public final String getDesc()
  {
    AppMethodBeat.i(60182);
    String str = this.desc;
    if (str == null) {
      ajm(12);
    }
    AppMethodBeat.o(60182);
    return str;
  }
  
  public final h gte()
  {
    AppMethodBeat.i(60180);
    h localh = this.Nxf;
    if (localh == null) {
      ajm(10);
    }
    AppMethodBeat.o(60180);
    return localh;
  }
  
  public final String gtf()
  {
    AppMethodBeat.i(60181);
    String str = this.name;
    if (str == null) {
      ajm(11);
    }
    AppMethodBeat.o(60181);
    return str;
  }
  
  public final b gtg()
  {
    AppMethodBeat.i(60183);
    b localb = this.Nxg;
    if (localb == null) {
      ajm(13);
    }
    AppMethodBeat.o(60183);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.e.d
 * JD-Core Version:    0.7.0.1
 */