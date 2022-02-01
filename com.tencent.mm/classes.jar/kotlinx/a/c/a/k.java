package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.aa;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlinx.a.b.b;
import kotlinx.a.c;
import kotlinx.a.c.d;
import kotlinx.a.c.i;
import kotlinx.a.c.m;
import kotlinx.a.c.s;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"checkKind", "", "kind", "Lkotlinx/serialization/SerialKind;", "validateIfSealed", "serializer", "Lkotlinx/serialization/KSerializer;", "actualSerializer", "", "classDiscriminator", "", "decodeSerializableValuePolymorphic", "T", "Lkotlinx/serialization/json/JsonInput;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/json/JsonInput;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "encodePolymorphically", "Lkotlinx/serialization/json/JsonOutput;", "Lkotlinx/serialization/SerializationStrategy;", "value", "ifPolymorphic", "Lkotlin/Function0;", "(Lkotlinx/serialization/json/JsonOutput;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "kotlinx-serialization-runtime"})
public final class k
{
  public static final <T> T a(m paramm, kotlinx.a.f<T> paramf)
  {
    AppMethodBeat.i(225678);
    p.h(paramm, "$this$decodeSerializableValuePolymorphic");
    p.h(paramf, "deserializer");
    if ((!(paramf instanceof b)) || (paramm.hOQ().TZf.TZy))
    {
      paramm = paramf.a((c)paramm);
      AppMethodBeat.o(225678);
      return paramm;
    }
    Object localObject = paramm.hOR();
    if (!(localObject instanceof s))
    {
      paramm = (Throwable)new IllegalStateException(("Expected " + aa.bp(s.class) + " but found " + aa.bp(localObject.getClass())).toString());
      AppMethodBeat.o(225678);
      throw paramm;
    }
    localObject = (s)localObject;
    String str = i.a((kotlinx.a.c.f)ae.e((Map)localObject, paramm.hOQ().TZf.TZz));
    Map localMap = ((s)localObject).TZX;
    if (localMap == null)
    {
      paramm = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlinx.serialization.json.JsonElement>");
      AppMethodBeat.o(225678);
      throw paramm;
    }
    af.fd(localMap).remove(paramm.hOQ().TZf.TZz);
    paramf = ((b)paramf).a((kotlinx.a.a)paramm, str);
    if (paramf == null)
    {
      paramm = new t("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
      AppMethodBeat.o(225678);
      throw paramm;
    }
    paramm = q.a(paramm.hOQ(), (kotlinx.a.c.f)localObject, (kotlinx.a.f)paramf);
    AppMethodBeat.o(225678);
    return paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.a.k
 * JD-Core Version:    0.7.0.1
 */