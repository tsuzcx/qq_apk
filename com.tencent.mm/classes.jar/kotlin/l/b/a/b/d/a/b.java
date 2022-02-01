package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.d.a.f.h;
import kotlin.l.b.a.b.d.a.f.i;
import kotlin.l.b.a.b.f.c;
import kotlin.r;
import kotlin.v;

public final class b
{
  private static final c aiOg;
  private static final c aiOh;
  private static final c aiOi;
  private static final c aiOj;
  private static final List<a> aiOk;
  private static final Map<c, n> aiOl;
  private static final Map<c, n> aiOm;
  private static final Set<c> aiOn;
  
  static
  {
    AppMethodBeat.i(192123);
    aiOg = new c("javax.annotation.meta.TypeQualifierNickname");
    aiOh = new c("javax.annotation.meta.TypeQualifier");
    aiOi = new c("javax.annotation.meta.TypeQualifierDefault");
    aiOj = new c("kotlin.annotations.jvm.UnderMigration");
    aiOk = p.listOf(new a[] { a.aiOb, a.aiNZ, a.aiOa, a.aiOd, a.aiOc });
    aiOl = ak.l(v.Y(x.krI(), new n(new i(h.aiUX), (Collection)aiOk, false, false)));
    Object localObject = ak.e(new r[] { v.Y(new c("javax.annotation.ParametersAreNullableByDefault"), new n(new i(h.aiUW), (Collection)p.listOf(a.aiOa))), v.Y(new c("javax.annotation.ParametersAreNonnullByDefault"), new n(new i(h.aiUX), (Collection)p.listOf(a.aiOa))) });
    Map localMap = aiOl;
    s.u(localObject, "$this$plus");
    s.u(localMap, "map");
    localObject = new LinkedHashMap((Map)localObject);
    ((LinkedHashMap)localObject).putAll(localMap);
    aiOm = (Map)localObject;
    aiOn = ar.setOf(new c[] { x.krK(), x.krL() });
    AppMethodBeat.o(192123);
  }
  
  public static final c krr()
  {
    return aiOg;
  }
  
  public static final c krs()
  {
    return aiOh;
  }
  
  public static final c krt()
  {
    return aiOi;
  }
  
  public static final c kru()
  {
    return aiOj;
  }
  
  public static final Map<c, n> krv()
  {
    return aiOl;
  }
  
  public static final Map<c, n> krw()
  {
    return aiOm;
  }
  
  public static final Set<c> krx()
  {
    return aiOn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.b
 * JD-Core Version:    0.7.0.1
 */