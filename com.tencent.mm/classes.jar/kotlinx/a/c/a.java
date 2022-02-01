package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlinx.a.c.a.r;
import kotlinx.a.d.e.a;
import kotlinx.a.e;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/StringFormat;", "block", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "()V", "builder", "(Lkotlinx/serialization/json/JsonBuilder;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "context", "Lkotlinx/serialization/modules/SerialModule;", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/modules/SerialModule;)V", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "context$1", "fromJson", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "json", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/DeserializationStrategy;Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "", "tree", "(Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "parse", "string", "", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "parseJson", "stringify", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "toJson", "(Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "validateConfiguration", "Default", "kotlinx-serialization-runtime"})
public final class a
{
  private static final a abCA;
  public static final a.a abCB;
  private static final a abCw;
  private static final a abCx;
  private static final a abCy;
  private static final a abCz;
  public final kotlinx.a.d.b abCu;
  public final d abCv;
  
  static
  {
    AppMethodBeat.i(256474);
    abCB = new a.a((byte)0);
    abCw = new a(new d(false, false, false, false, false, false, false, null, true, null, null, 1791));
    abCx = new a(new d(false, true, true, true, false, false, true, null, true, null, null, 1713));
    abCy = new a(new d(false, false, false, false, false, true, false, null, true, null, null, 1759));
    abCz = new a(new d(false, true, true, true, false, false, false, null, true, null, null, 1777));
    d.a locala = d.abCS;
    abCA = new a(d.iTV());
    AppMethodBeat.o(256474);
  }
  
  public a()
  {
    this(new d(false, false, false, false, false, false, false, null, true, null, null, 1791));
    AppMethodBeat.i(256472);
    AppMethodBeat.o(256472);
  }
  
  private a(d paramd, kotlinx.a.d.b paramb)
  {
    AppMethodBeat.i(256468);
    this.abCv = paramd;
    paramd = n.iTZ();
    p.k(paramb, "$this$plus");
    p.k(paramd, "other");
    this.abCu = kotlinx.a.d.c.ao((kotlin.g.a.b)new e.a(paramb, paramd));
    if (!this.abCv.abCM)
    {
      paramd = new kotlinx.a.c.a.b(this.abCv.abCN);
      this.abCu.a((kotlinx.a.d.d)paramd);
    }
    AppMethodBeat.o(256468);
  }
  
  public final <T> T a(kotlinx.a.f<T> paramf, String paramString)
  {
    AppMethodBeat.i(256466);
    p.k(paramf, "deserializer");
    p.k(paramString, "string");
    paramString = new kotlinx.a.c.a.f(paramString);
    paramf = e.c((kotlinx.a.c)new kotlinx.a.c.a.l(this, r.abDN, paramString), paramf);
    if (paramString.abDz == 12) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramf = (Throwable)new IllegalStateException("Reader has not consumed the whole input: ".concat(String.valueOf(paramString)).toString());
      AppMethodBeat.o(256466);
      throw paramf;
    }
    AppMethodBeat.o(256466);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.a
 * JD-Core Version:    0.7.0.1
 */