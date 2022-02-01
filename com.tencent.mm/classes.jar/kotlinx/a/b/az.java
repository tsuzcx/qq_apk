package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.g.b.ab;
import d.g.b.ad;
import d.g.b.c;
import d.g.b.d;
import d.g.b.f;
import d.g.b.k;
import d.g.b.r;
import d.l.b;
import d.u;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.a.a.e;
import kotlinx.a.h;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"BUILTIN_SERIALIZERS", "", "Lkotlin/reflect/KClass;", "", "Lkotlinx/serialization/KSerializer;", "BUILTIN_SERIALIZERS$annotations", "()V", "message", "", "PrimitiveDescriptorSafe", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "kind", "Lkotlinx/serialization/PrimitiveKind;", "checkName", "", "builtinSerializerOrNull", "T", "kotlinx-serialization-runtime"})
public final class az
{
  private static final Map<b<? extends Object>, h<? extends Object>> NMP;
  
  static
  {
    AppMethodBeat.i(191202);
    NMP = ae.a(new d.o[] { u.S(d.g.b.z.bp(String.class), e.a(ad.MLZ)), u.S(d.g.b.z.bp(Character.TYPE), e.a(f.MLD)), u.S(d.g.b.z.bp([C.class), (h)m.NMi), u.S(d.g.b.z.bp(Double.TYPE), e.a(k.MLL)), u.S(d.g.b.z.bp([D.class), (h)p.NMl), u.S(d.g.b.z.bp(Float.TYPE), e.a(d.g.b.l.MLM)), u.S(d.g.b.z.bp([F.class), (h)s.NMo), u.S(d.g.b.z.bp(Long.TYPE), e.a(r.MLO)), u.S(d.g.b.z.bp([J.class), (h)ak.NMz), u.S(d.g.b.z.bp(Integer.TYPE), e.a(d.g.b.o.MLN)), u.S(d.g.b.z.bp([I.class), (h)aa.NMr), u.S(d.g.b.z.bp(Short.TYPE), e.a(ab.MLY)), u.S(d.g.b.z.bp([S.class), (h)bd.NMS), u.S(d.g.b.z.bp(Byte.TYPE), e.a(d.MLy)), u.S(d.g.b.z.bp([B.class), (h)j.NMg), u.S(d.g.b.z.bp(Boolean.TYPE), e.a(c.MLx)), u.S(d.g.b.z.bp([Z.class), (h)g.NMe), u.S(d.g.b.z.bp(d.z.class), (h)bi.NMZ) });
    AppMethodBeat.o(191202);
  }
  
  public static final kotlinx.a.n a(String paramString, kotlinx.a.l paraml)
  {
    AppMethodBeat.i(191201);
    d.g.b.p.h(paramString, "serialName");
    d.g.b.p.h(paraml, "kind");
    Iterator localIterator = NMP.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = ((b)localIterator.next()).getSimpleName();
      if (str == null) {
        d.g.b.p.gfZ();
      }
      str = d.n.n.capitalize(str);
      if ((d.n.n.H(paramString, "kotlin.".concat(String.valueOf(str)), true)) || (d.n.n.H(paramString, str, true)))
      {
        paramString = (Throwable)new IllegalArgumentException(d.n.n.bdc("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + paramString + " there already exist " + d.n.n.capitalize(str) + "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
        AppMethodBeat.o(191201);
        throw paramString;
      }
    }
    paramString = (kotlinx.a.n)new ay(paramString, paraml);
    AppMethodBeat.o(191201);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.az
 * JD-Core Version:    0.7.0.1
 */