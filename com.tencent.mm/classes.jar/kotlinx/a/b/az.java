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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"BUILTIN_SERIALIZERS", "", "Lkotlin/reflect/KClass;", "", "Lkotlinx/serialization/KSerializer;", "BUILTIN_SERIALIZERS$annotations", "()V", "message", "", "PrimitiveDescriptorSafe", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "kind", "Lkotlinx/serialization/PrimitiveKind;", "checkName", "", "builtinSerializerOrNull", "T", "kotlinx-serialization-runtime"})
public final class az
{
  private static final Map<b<? extends Object>, h<? extends Object>> OjV;
  
  static
  {
    AppMethodBeat.i(199790);
    OjV = ae.a(new d.o[] { u.R(d.g.b.z.bp(String.class), e.a(ad.Njc)), u.R(d.g.b.z.bp(Character.TYPE), e.a(f.NiG)), u.R(d.g.b.z.bp([C.class), (h)m.Ojo), u.R(d.g.b.z.bp(Double.TYPE), e.a(k.NiO)), u.R(d.g.b.z.bp([D.class), (h)p.Ojr), u.R(d.g.b.z.bp(Float.TYPE), e.a(d.g.b.l.NiP)), u.R(d.g.b.z.bp([F.class), (h)s.Oju), u.R(d.g.b.z.bp(Long.TYPE), e.a(r.NiR)), u.R(d.g.b.z.bp([J.class), (h)ak.OjF), u.R(d.g.b.z.bp(Integer.TYPE), e.a(d.g.b.o.NiQ)), u.R(d.g.b.z.bp([I.class), (h)aa.Ojx), u.R(d.g.b.z.bp(Short.TYPE), e.a(ab.Njb)), u.R(d.g.b.z.bp([S.class), (h)bd.OjY), u.R(d.g.b.z.bp(Byte.TYPE), e.a(d.NiB)), u.R(d.g.b.z.bp([B.class), (h)j.Ojm), u.R(d.g.b.z.bp(Boolean.TYPE), e.a(c.NiA)), u.R(d.g.b.z.bp([Z.class), (h)g.Ojk), u.R(d.g.b.z.bp(d.z.class), (h)bi.Okf) });
    AppMethodBeat.o(199790);
  }
  
  public static final kotlinx.a.n a(String paramString, kotlinx.a.l paraml)
  {
    AppMethodBeat.i(199789);
    d.g.b.p.h(paramString, "serialName");
    d.g.b.p.h(paraml, "kind");
    Iterator localIterator = OjV.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = ((b)localIterator.next()).getSimpleName();
      if (str == null) {
        d.g.b.p.gkB();
      }
      str = d.n.n.capitalize(str);
      if ((d.n.n.H(paramString, "kotlin.".concat(String.valueOf(str)), true)) || (d.n.n.H(paramString, str, true)))
      {
        paramString = (Throwable)new IllegalArgumentException(d.n.n.beG("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + paramString + " there already exist " + d.n.n.capitalize(str) + "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
        AppMethodBeat.o(199789);
        throw paramString;
      }
    }
    paramString = (kotlinx.a.n)new ay(paramString, paraml);
    AppMethodBeat.o(199789);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.az
 * JD-Core Version:    0.7.0.1
 */