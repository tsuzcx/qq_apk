package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.ab;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlinx.a.b.b;
import kotlinx.a.c;
import kotlinx.a.c.d;
import kotlinx.a.c.i;
import kotlinx.a.c.m;
import kotlinx.a.c.s;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"checkKind", "", "kind", "Lkotlinx/serialization/SerialKind;", "validateIfSealed", "serializer", "Lkotlinx/serialization/KSerializer;", "actualSerializer", "", "classDiscriminator", "", "decodeSerializableValuePolymorphic", "T", "Lkotlinx/serialization/json/JsonInput;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/json/JsonInput;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "encodePolymorphically", "Lkotlinx/serialization/json/JsonOutput;", "Lkotlinx/serialization/SerializationStrategy;", "value", "ifPolymorphic", "Lkotlin/Function0;", "(Lkotlinx/serialization/json/JsonOutput;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "kotlinx-serialization-runtime"})
public final class k
{
  public static final <T> T a(m paramm, kotlinx.a.f<T> paramf)
  {
    AppMethodBeat.i(255939);
    p.k(paramm, "$this$decodeSerializableValuePolymorphic");
    p.k(paramf, "deserializer");
    if ((!(paramf instanceof b)) || (paramm.iTX().abCv.abCM))
    {
      paramm = paramf.a((c)paramm);
      AppMethodBeat.o(255939);
      return paramm;
    }
    Object localObject = paramm.iTY();
    if (!(localObject instanceof s))
    {
      paramm = (Throwable)new IllegalStateException(("Expected " + ab.bO(s.class) + " but found " + ab.bO(localObject.getClass())).toString());
      AppMethodBeat.o(255939);
      throw paramm;
    }
    localObject = (s)localObject;
    String str = i.a((kotlinx.a.c.f)ae.e((Map)localObject, paramm.iTX().abCv.abCN));
    Map localMap = ((s)localObject).abDl;
    if (localMap == null)
    {
      paramm = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlinx.serialization.json.JsonElement>");
      AppMethodBeat.o(255939);
      throw paramm;
    }
    ag.fk(localMap).remove(paramm.iTX().abCv.abCN);
    paramf = ((b)paramf).a((kotlinx.a.a)paramm, str);
    if (paramf == null)
    {
      paramm = new t("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
      AppMethodBeat.o(255939);
      throw paramm;
    }
    paramm = q.a(paramm.iTX(), (kotlinx.a.c.f)localObject, (kotlinx.a.f)paramf);
    AppMethodBeat.o(255939);
    return paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.a.k
 * JD-Core Version:    0.7.0.1
 */