package kotlin.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.l.b.a.b.a.i;
import kotlin.l.b.a.b.f.c;

public enum e
{
  private static final Set<c> ajkl;
  private static final Map<String, e> ajkm;
  private static final Map<i, e> ajkn;
  private static final Map<String, e> ajko;
  private final i ajkp;
  private final c ajkq;
  private final String desc;
  private final String name;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(60184);
    ajkd = new e("BOOLEAN", 0, i.aiBH, "boolean", "Z", "java.lang.Boolean");
    ajke = new e("CHAR", 1, i.aiBI, "char", "C", "java.lang.Character");
    ajkf = new e("BYTE", 2, i.aiBJ, "byte", "B", "java.lang.Byte");
    ajkg = new e("SHORT", 3, i.aiBK, "short", "S", "java.lang.Short");
    ajkh = new e("INT", 4, i.aiBL, "int", "I", "java.lang.Integer");
    ajki = new e("FLOAT", 5, i.aiBM, "float", "F", "java.lang.Float");
    ajkj = new e("LONG", 6, i.aiBN, "long", "J", "java.lang.Long");
    ajkk = new e("DOUBLE", 7, i.aiBO, "double", "D", "java.lang.Double");
    ajkr = new e[] { ajkd, ajke, ajkf, ajkg, ajkh, ajki, ajkj, ajkk };
    ajkl = new HashSet();
    ajkm = new HashMap();
    ajkn = new EnumMap(i.class);
    ajko = new HashMap();
    e[] arrayOfe = values();
    int j = arrayOfe.length;
    while (i < j)
    {
      e locale = arrayOfe[i];
      ajkl.add(locale.kzu());
      ajkm.put(locale.kzt(), locale);
      ajkn.put(locale.kzs(), locale);
      ajko.put(locale.getDesc(), locale);
      i += 1;
    }
    AppMethodBeat.o(60184);
  }
  
  private e(i parami, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(60179);
    this.ajkp = parami;
    this.name = paramString1;
    this.desc = paramString2;
    this.ajkq = new c(paramString3);
    AppMethodBeat.o(60179);
  }
  
  public static e bJq(String paramString)
  {
    AppMethodBeat.i(60177);
    if (paramString == null) {
      aKu(1);
    }
    e locale = (e)ajkm.get(paramString);
    if (locale == null)
    {
      paramString = new AssertionError("Non-primitive type name passed: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(60177);
      throw paramString;
    }
    if (locale == null) {
      aKu(2);
    }
    AppMethodBeat.o(60177);
    return locale;
  }
  
  public static e e(i parami)
  {
    AppMethodBeat.i(60178);
    if (parami == null) {
      aKu(3);
    }
    parami = (e)ajkn.get(parami);
    if (parami == null) {
      aKu(4);
    }
    AppMethodBeat.o(60178);
    return parami;
  }
  
  public final String getDesc()
  {
    AppMethodBeat.i(60182);
    String str = this.desc;
    if (str == null) {
      aKu(12);
    }
    AppMethodBeat.o(60182);
    return str;
  }
  
  public final i kzs()
  {
    AppMethodBeat.i(60180);
    i locali = this.ajkp;
    if (locali == null) {
      aKu(10);
    }
    AppMethodBeat.o(60180);
    return locali;
  }
  
  public final String kzt()
  {
    AppMethodBeat.i(60181);
    String str = this.name;
    if (str == null) {
      aKu(11);
    }
    AppMethodBeat.o(60181);
    return str;
  }
  
  public final c kzu()
  {
    AppMethodBeat.i(60183);
    c localc = this.ajkq;
    if (localc == null) {
      aKu(13);
    }
    AppMethodBeat.o(60183);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.e.e
 * JD-Core Version:    0.7.0.1
 */