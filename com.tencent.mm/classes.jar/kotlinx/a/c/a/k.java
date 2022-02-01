package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.z;
import d.l;
import d.v;
import java.util.Map;
import kotlinx.a.b.b;
import kotlinx.a.c;
import kotlinx.a.c.d;
import kotlinx.a.c.i;
import kotlinx.a.c.m;
import kotlinx.a.c.s;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"checkKind", "", "kind", "Lkotlinx/serialization/SerialKind;", "validateIfSealed", "serializer", "Lkotlinx/serialization/KSerializer;", "actualSerializer", "", "classDiscriminator", "", "decodeSerializableValuePolymorphic", "T", "Lkotlinx/serialization/json/JsonInput;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/json/JsonInput;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "encodePolymorphically", "Lkotlinx/serialization/json/JsonOutput;", "Lkotlinx/serialization/SerializationStrategy;", "value", "ifPolymorphic", "Lkotlin/Function0;", "(Lkotlinx/serialization/json/JsonOutput;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "kotlinx-serialization-runtime"})
public final class k
{
  public static final <T> T a(m paramm, kotlinx.a.f<T> paramf)
  {
    AppMethodBeat.i(191318);
    p.h(paramm, "$this$decodeSerializableValuePolymorphic");
    p.h(paramf, "deserializer");
    if ((!(paramf instanceof b)) || (paramm.gxh().NNe.NNv))
    {
      paramm = paramf.a((c)paramm);
      AppMethodBeat.o(191318);
      return paramm;
    }
    Object localObject = paramm.gxi();
    if (!(localObject instanceof s))
    {
      paramm = (Throwable)new IllegalStateException(("Expected " + z.bp(s.class) + " but found " + z.bp(localObject.getClass())).toString());
      AppMethodBeat.o(191318);
      throw paramm;
    }
    localObject = (s)localObject;
    String str = i.a((kotlinx.a.c.f)d.a.ae.e((Map)localObject, paramm.gxh().NNe.NNw));
    Map localMap = ((s)localObject).NNU;
    if (localMap == null)
    {
      paramm = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlinx.serialization.json.JsonElement>");
      AppMethodBeat.o(191318);
      throw paramm;
    }
    d.g.b.ae.eV(localMap).remove(paramm.gxh().NNe.NNw);
    paramf = ((b)paramf).a((kotlinx.a.a)paramm, str);
    if (paramf == null)
    {
      paramm = new v("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
      AppMethodBeat.o(191318);
      throw paramm;
    }
    paramm = q.a(paramm.gxh(), (kotlinx.a.c.f)localObject, (kotlinx.a.f)paramf);
    AppMethodBeat.o(191318);
    return paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.k
 * JD-Core Version:    0.7.0.1
 */