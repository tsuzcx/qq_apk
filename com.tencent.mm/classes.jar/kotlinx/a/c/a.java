package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlinx.a.c.a.r;
import kotlinx.a.d.e.a;
import kotlinx.a.e;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/StringFormat;", "block", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "()V", "builder", "(Lkotlinx/serialization/json/JsonBuilder;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "context", "Lkotlinx/serialization/modules/SerialModule;", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/modules/SerialModule;)V", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "context$1", "fromJson", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "json", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/DeserializationStrategy;Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "", "tree", "(Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "parse", "string", "", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "parseJson", "stringify", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "toJson", "(Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "validateConfiguration", "Default", "kotlinx-serialization-runtime"})
public final class a
{
  private static final a TZg;
  private static final a TZh;
  private static final a TZi;
  private static final a TZj;
  private static final a TZk;
  public static final a.a TZl;
  public final kotlinx.a.d.b TZe;
  public final d TZf;
  
  static
  {
    AppMethodBeat.i(225755);
    TZl = new a.a((byte)0);
    TZg = new a(new d(false, false, false, false, false, false, false, null, true, null, null, 1791));
    TZh = new a(new d(false, true, true, true, false, false, true, null, true, null, null, 1713));
    TZi = new a(new d(false, false, false, false, false, true, false, null, true, null, null, 1759));
    TZj = new a(new d(false, true, true, true, false, false, false, null, true, null, null, 1777));
    d.a locala = d.TZE;
    TZk = new a(d.hOO());
    AppMethodBeat.o(225755);
  }
  
  public a()
  {
    this(new d(false, false, false, false, false, false, false, null, true, null, null, 1791));
    AppMethodBeat.i(225754);
    AppMethodBeat.o(225754);
  }
  
  private a(d paramd, kotlinx.a.d.b paramb)
  {
    AppMethodBeat.i(225752);
    this.TZf = paramd;
    paramd = n.hOS();
    p.h(paramb, "$this$plus");
    p.h(paramd, "other");
    this.TZe = kotlinx.a.d.c.Y((kotlin.g.a.b)new e.a(paramb, paramd));
    if (!this.TZf.TZy)
    {
      paramd = new kotlinx.a.c.a.b(this.TZf.TZz);
      this.TZe.a((kotlinx.a.d.d)paramd);
    }
    AppMethodBeat.o(225752);
  }
  
  public final <T> T a(kotlinx.a.f<T> paramf, String paramString)
  {
    AppMethodBeat.i(225751);
    p.h(paramf, "deserializer");
    p.h(paramString, "string");
    paramString = new kotlinx.a.c.a.f(paramString);
    paramf = e.c((kotlinx.a.c)new kotlinx.a.c.a.l(this, r.Uaz, paramString), paramf);
    if (paramString.Ual == 12) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramf = (Throwable)new IllegalStateException("Reader has not consumed the whole input: ".concat(String.valueOf(paramString)).toString());
      AppMethodBeat.o(225751);
      throw paramf;
    }
    AppMethodBeat.o(225751);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.a
 * JD-Core Version:    0.7.0.1
 */