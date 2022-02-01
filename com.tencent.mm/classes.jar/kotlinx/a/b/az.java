package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.g.b.ab;
import kotlin.g.b.ad;
import kotlin.g.b.af;
import kotlin.g.b.c;
import kotlin.g.b.d;
import kotlin.g.b.f;
import kotlin.g.b.k;
import kotlin.g.b.r;
import kotlin.l.b;
import kotlin.x;
import kotlinx.a.a.e;
import kotlinx.a.h;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"BUILTIN_SERIALIZERS", "", "Lkotlin/reflect/KClass;", "", "Lkotlinx/serialization/KSerializer;", "BUILTIN_SERIALIZERS$annotations", "()V", "message", "", "PrimitiveDescriptorSafe", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "kind", "Lkotlinx/serialization/PrimitiveKind;", "checkName", "", "builtinSerializerOrNull", "T", "kotlinx-serialization-runtime"})
public final class az
{
  private static final Map<b<? extends Object>, h<? extends Object>> abCf;
  
  static
  {
    AppMethodBeat.i(254689);
    abCf = ae.e(new kotlin.o[] { kotlin.s.M(ab.bO(String.class), e.a(af.aaBG)), kotlin.s.M(ab.bO(Character.TYPE), e.a(f.aaBa)), kotlin.s.M(ab.bO([C.class), (h)m.abBz), kotlin.s.M(ab.bO(Double.TYPE), e.a(k.aaBn)), kotlin.s.M(ab.bO([D.class), (h)p.abBC), kotlin.s.M(ab.bO(Float.TYPE), e.a(kotlin.g.b.l.aaBt)), kotlin.s.M(ab.bO([F.class), (h)s.abBF), kotlin.s.M(ab.bO(Long.TYPE), e.a(r.aaBv)), kotlin.s.M(ab.bO([J.class), (h)ak.abBP), kotlin.s.M(ab.bO(Integer.TYPE), e.a(kotlin.g.b.o.aaBu)), kotlin.s.M(ab.bO([I.class), (h)aa.abBH), kotlin.s.M(ab.bO(Short.TYPE), e.a(ad.aaBF)), kotlin.s.M(ab.bO([S.class), (h)bd.abCi), kotlin.s.M(ab.bO(Byte.TYPE), e.a(d.aaAV)), kotlin.s.M(ab.bO([B.class), (h)j.abBx), kotlin.s.M(ab.bO(Boolean.TYPE), e.a(c.aaAU)), kotlin.s.M(ab.bO([Z.class), (h)g.abBv), kotlin.s.M(ab.bO(x.class), (h)bi.abCq) });
    AppMethodBeat.o(254689);
  }
  
  public static final kotlinx.a.n a(String paramString, kotlinx.a.l paraml)
  {
    AppMethodBeat.i(254687);
    kotlin.g.b.p.k(paramString, "serialName");
    kotlin.g.b.p.k(paraml, "kind");
    Iterator localIterator = abCf.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = ((b)localIterator.next()).iCe();
      if (str == null) {
        kotlin.g.b.p.iCn();
      }
      str = kotlin.n.n.capitalize(str);
      if ((kotlin.n.n.L(paramString, "kotlin.".concat(String.valueOf(str)), true)) || (kotlin.n.n.L(paramString, str, true)))
      {
        paramString = (Throwable)new IllegalArgumentException(kotlin.n.n.bHx("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + paramString + " there already exist " + kotlin.n.n.capitalize(str) + "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
        AppMethodBeat.o(254687);
        throw paramString;
      }
    }
    paramString = (kotlinx.a.n)new ay(paramString, paraml);
    AppMethodBeat.o(254687);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.az
 * JD-Core Version:    0.7.0.1
 */