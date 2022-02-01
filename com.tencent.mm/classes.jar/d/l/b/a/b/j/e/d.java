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
  private static final Set<b> LGd;
  private static final Map<String, d> LGe;
  private static final Map<h, d> LGf;
  private static final Map<String, d> LGg;
  private final h LGh;
  private final b LGi;
  private final String desc;
  private final String name;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(60184);
    LFV = new d("BOOLEAN", 0, h.LaM, "boolean", "Z", "java.lang.Boolean");
    LFW = new d("CHAR", 1, h.LaN, "char", "C", "java.lang.Character");
    LFX = new d("BYTE", 2, h.LaO, "byte", "B", "java.lang.Byte");
    LFY = new d("SHORT", 3, h.LaP, "short", "S", "java.lang.Short");
    LFZ = new d("INT", 4, h.LaQ, "int", "I", "java.lang.Integer");
    LGa = new d("FLOAT", 5, h.LaR, "float", "F", "java.lang.Float");
    LGb = new d("LONG", 6, h.LaS, "long", "J", "java.lang.Long");
    LGc = new d("DOUBLE", 7, h.LaT, "double", "D", "java.lang.Double");
    LGj = new d[] { LFV, LFW, LFX, LFY, LFZ, LGa, LGb, LGc };
    LGd = new HashSet();
    LGe = new HashMap();
    LGf = new EnumMap(h.class);
    LGg = new HashMap();
    d[] arrayOfd = values();
    int j = arrayOfd.length;
    while (i < j)
    {
      d locald = arrayOfd[i];
      LGd.add(locald.gbH());
      LGe.put(locald.gbG(), locald);
      LGf.put(locald.gbF(), locald);
      LGg.put(locald.getDesc(), locald);
      i += 1;
    }
    AppMethodBeat.o(60184);
  }
  
  private d(h paramh, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(60179);
    this.LGh = paramh;
    this.name = paramString1;
    this.desc = paramString2;
    this.LGi = new b(paramString3);
    AppMethodBeat.o(60179);
  }
  
  public static d aWO(String paramString)
  {
    AppMethodBeat.i(60177);
    if (paramString == null) {
      agL(1);
    }
    d locald = (d)LGe.get(paramString);
    if (locald == null)
    {
      paramString = new AssertionError("Non-primitive type name passed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(60177);
      throw paramString;
    }
    if (locald == null) {
      agL(2);
    }
    AppMethodBeat.o(60177);
    return locald;
  }
  
  public static d d(h paramh)
  {
    AppMethodBeat.i(60178);
    if (paramh == null) {
      agL(3);
    }
    paramh = (d)LGf.get(paramh);
    if (paramh == null) {
      agL(4);
    }
    AppMethodBeat.o(60178);
    return paramh;
  }
  
  public final h gbF()
  {
    AppMethodBeat.i(60180);
    h localh = this.LGh;
    if (localh == null) {
      agL(10);
    }
    AppMethodBeat.o(60180);
    return localh;
  }
  
  public final String gbG()
  {
    AppMethodBeat.i(60181);
    String str = this.name;
    if (str == null) {
      agL(11);
    }
    AppMethodBeat.o(60181);
    return str;
  }
  
  public final b gbH()
  {
    AppMethodBeat.i(60183);
    b localb = this.LGi;
    if (localb == null) {
      agL(13);
    }
    AppMethodBeat.o(60183);
    return localb;
  }
  
  public final String getDesc()
  {
    AppMethodBeat.i(60182);
    String str = this.desc;
    if (str == null) {
      agL(12);
    }
    AppMethodBeat.o(60182);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.e.d
 * JD-Core Version:    0.7.0.1
 */