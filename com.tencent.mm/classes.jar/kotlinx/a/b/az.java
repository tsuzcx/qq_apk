package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.ac;
import kotlin.g.b.c;
import kotlin.g.b.d;
import kotlin.g.b.f;
import kotlin.g.b.k;
import kotlin.g.b.r;
import kotlin.l.b;
import kotlin.x;
import kotlinx.a.a.e;
import kotlinx.a.h;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"BUILTIN_SERIALIZERS", "", "Lkotlin/reflect/KClass;", "", "Lkotlinx/serialization/KSerializer;", "BUILTIN_SERIALIZERS$annotations", "()V", "message", "", "PrimitiveDescriptorSafe", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "kind", "Lkotlinx/serialization/PrimitiveKind;", "checkName", "", "builtinSerializerOrNull", "T", "kotlinx-serialization-runtime"})
public final class az
{
  private static final Map<b<? extends Object>, h<? extends Object>> TYQ;
  
  static
  {
    AppMethodBeat.i(225562);
    TYQ = kotlin.a.ae.e(new kotlin.o[] { kotlin.s.U(kotlin.g.b.aa.bp(String.class), e.a(kotlin.g.b.ae.SYK)), kotlin.s.U(kotlin.g.b.aa.bp(Character.TYPE), e.a(f.SYo)), kotlin.s.U(kotlin.g.b.aa.bp([C.class), (h)m.TYk), kotlin.s.U(kotlin.g.b.aa.bp(Double.TYPE), e.a(k.SYw)), kotlin.s.U(kotlin.g.b.aa.bp([D.class), (h)p.TYn), kotlin.s.U(kotlin.g.b.aa.bp(Float.TYPE), e.a(kotlin.g.b.l.SYx)), kotlin.s.U(kotlin.g.b.aa.bp([F.class), (h)s.TYq), kotlin.s.U(kotlin.g.b.aa.bp(Long.TYPE), e.a(r.SYz)), kotlin.s.U(kotlin.g.b.aa.bp([J.class), (h)ak.TYA), kotlin.s.U(kotlin.g.b.aa.bp(Integer.TYPE), e.a(kotlin.g.b.o.SYy)), kotlin.s.U(kotlin.g.b.aa.bp([I.class), (h)aa.TYs), kotlin.s.U(kotlin.g.b.aa.bp(Short.TYPE), e.a(ac.SYJ)), kotlin.s.U(kotlin.g.b.aa.bp([S.class), (h)bd.TYT), kotlin.s.U(kotlin.g.b.aa.bp(Byte.TYPE), e.a(d.SYj)), kotlin.s.U(kotlin.g.b.aa.bp([B.class), (h)j.TYi), kotlin.s.U(kotlin.g.b.aa.bp(Boolean.TYPE), e.a(c.SYi)), kotlin.s.U(kotlin.g.b.aa.bp([Z.class), (h)g.TYg), kotlin.s.U(kotlin.g.b.aa.bp(x.class), (h)bi.TZa) });
    AppMethodBeat.o(225562);
  }
  
  public static final kotlinx.a.n a(String paramString, kotlinx.a.l paraml)
  {
    AppMethodBeat.i(225561);
    kotlin.g.b.p.h(paramString, "serialName");
    kotlin.g.b.p.h(paraml, "kind");
    Iterator localIterator = TYQ.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = ((b)localIterator.next()).getSimpleName();
      if (str == null) {
        kotlin.g.b.p.hyc();
      }
      str = kotlin.n.n.capitalize(str);
      if ((kotlin.n.n.I(paramString, "kotlin.".concat(String.valueOf(str)), true)) || (kotlin.n.n.I(paramString, str, true)))
      {
        paramString = (Throwable)new IllegalArgumentException(kotlin.n.n.buv("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + paramString + " there already exist " + kotlin.n.n.capitalize(str) + "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
        AppMethodBeat.o(225561);
        throw paramString;
      }
    }
    paramString = (kotlinx.a.n)new ay(paramString, paraml);
    AppMethodBeat.o(225561);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.b.az
 * JD-Core Version:    0.7.0.1
 */