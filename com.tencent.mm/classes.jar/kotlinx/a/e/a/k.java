package kotlinx.a.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.f;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.a.b.i.b;
import kotlinx.a.f.b;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/internal/StreamingJsonDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "reader", "Lkotlinx/serialization/json/internal/JsonReader;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;Lkotlinx/serialization/json/internal/JsonReader;)V", "configuration", "Lkotlinx/serialization/json/internal/JsonConf;", "currentIndex", "", "getJson", "()Lkotlinx/serialization/json/Json;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode$annotations", "()V", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "coerceInputValue", "", "index", "decodeBoolean", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeElementIndex", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeInt", "decodeJsonElement", "Lkotlinx/serialization/json/JsonElement;", "decodeListIndex", "tokenClass", "decodeLong", "", "decodeMapIndex", "decodeNotNullMark", "decodeNull", "", "decodeObjectIndex", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeShort", "", "decodeString", "", "endStructure", "", "parse", "type", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class k
  extends kotlinx.a.c.a
  implements kotlinx.a.e.c
{
  private final b ajEA;
  public final e ajEB;
  private final q ajEK;
  private final c ajEb;
  private final kotlinx.a.e.a ajEm;
  private int currentIndex;
  
  public k(kotlinx.a.e.a parama, q paramq, e parame)
  {
    AppMethodBeat.i(188531);
    this.ajEm = parama;
    this.ajEK = paramq;
    this.ajEB = parame;
    this.ajEA = this.ajEm.ajEb.ajEA;
    this.currentIndex = -1;
    this.ajEb = this.ajEm.ajEb;
    AppMethodBeat.o(188531);
  }
  
  public final <T> T b(kotlinx.a.a<T> parama)
  {
    AppMethodBeat.i(188562);
    s.u(parama, "deserializer");
    parama = j.a(this, parama);
    AppMethodBeat.o(188562);
    return parama;
  }
  
  public final void b(kotlinx.a.b.e parame)
  {
    AppMethodBeat.i(188582);
    s.u(parame, "descriptor");
    if (this.ajEK.ajEZ != 0)
    {
      parame = this.ajEB;
      int i = this.ajEK.ajEX;
      if (parame.ajEC != i)
      {
        parame.jV("Expected '" + this.ajEK.ajEZ + '\'', parame.ajED);
        parame = new f();
        AppMethodBeat.o(188582);
        throw parame;
      }
      this.ajEB.kFK();
    }
    AppMethodBeat.o(188582);
  }
  
  public final kotlinx.a.c.c c(kotlinx.a.b.e parame)
  {
    AppMethodBeat.i(188572);
    s.u(parame, "descriptor");
    q localq = r.a(this.ajEm, parame);
    if (localq.ajEY != 0)
    {
      e locale = this.ajEB;
      int i = localq.ajEW;
      if (locale.ajEC != i)
      {
        locale.jV("Expected '" + localq.ajEY + ", kind: " + parame.kFd() + '\'', locale.ajED);
        parame = new f();
        AppMethodBeat.o(188572);
        throw parame;
      }
      this.ajEB.kFK();
    }
    switch (l.$EnumSwitchMapping$0[localq.ordinal()])
    {
    default: 
      if (this.ajEK == localq) {
        parame = this;
      }
      break;
    }
    for (;;)
    {
      parame = (kotlinx.a.c.c)parame;
      AppMethodBeat.o(188572);
      return parame;
      parame = new k(this.ajEm, localq, this.ajEB);
      continue;
      parame = new k(this.ajEm, localq, this.ajEB);
    }
  }
  
  public final int d(kotlinx.a.b.e parame)
  {
    AppMethodBeat.i(188739);
    s.u(parame, "descriptor");
    s.u(parame, "descriptor");
    s.u(parame, "descriptor");
    AppMethodBeat.o(188739);
    return -1;
  }
  
  public final int g(kotlinx.a.b.e parame)
  {
    int k = 1;
    int j = 1;
    AppMethodBeat.i(188615);
    s.u(parame, "descriptor");
    int m = this.ajEB.ajEC;
    int i;
    if (m == 4)
    {
      localObject = this.ajEB;
      if (this.currentIndex != -1) {}
      for (i = 1;; i = 0)
      {
        int n = this.ajEB.EuH;
        if (i != 0) {
          break;
        }
        ((e)localObject).jV("Unexpected leading comma", n);
        parame = new f();
        AppMethodBeat.o(188615);
        throw parame;
      }
      this.ajEB.kFK();
    }
    Object localObject = this.ajEK;
    switch (l.avl[localObject.ordinal()])
    {
    default: 
      if ((m == 4) && (!this.ajEB.kFH()))
      {
        e.a(this.ajEB, "Unexpected trailing comma");
        parame = new f();
        AppMethodBeat.o(188615);
        throw parame;
      }
      break;
    case 1: 
      if ((m != 4) && (this.currentIndex != -1))
      {
        parame = this.ajEB;
        if (parame.ajEC != 9)
        {
          parame.jV("Expected end of the array or comma", parame.ajED);
          parame = new f();
          AppMethodBeat.o(188615);
          throw parame;
        }
      }
      if (!this.ajEB.kFH())
      {
        parame = this.ajEB;
        if (m != 4) {}
        for (i = j;; i = 0)
        {
          j = parame.EuH;
          if (i != 0) {
            break;
          }
          parame.jV("Unexpected trailing comma", j);
          parame = new f();
          AppMethodBeat.o(188615);
          throw parame;
        }
        AppMethodBeat.o(188615);
        return -1;
      }
      this.currentIndex += 1;
      i = this.currentIndex;
      AppMethodBeat.o(188615);
      return i;
    case 2: 
      if ((m != 4) && (this.currentIndex % 2 == 1))
      {
        parame = this.ajEB;
        if (parame.ajEC != 7)
        {
          parame.jV("Expected end of the object or comma", parame.ajED);
          parame = new f();
          AppMethodBeat.o(188615);
          throw parame;
        }
      }
      if (this.currentIndex % 2 == 0)
      {
        parame = this.ajEB;
        if (parame.ajEC != 5)
        {
          parame.jV("Expected ':' after the key", parame.ajED);
          parame = new f();
          AppMethodBeat.o(188615);
          throw parame;
        }
        this.ajEB.kFK();
      }
      if (!this.ajEB.kFH())
      {
        parame = this.ajEB;
        if (m != 4) {}
        for (i = k;; i = 0)
        {
          j = parame.EuH;
          if (i != 0) {
            break;
          }
          parame.jV("Unexpected trailing comma", j);
          parame = new f();
          AppMethodBeat.o(188615);
          throw parame;
        }
        AppMethodBeat.o(188615);
        return -1;
      }
      this.currentIndex += 1;
      i = this.currentIndex;
      AppMethodBeat.o(188615);
      return i;
    case 3: 
      this.currentIndex += 1;
      switch (this.currentIndex)
      {
      default: 
        AppMethodBeat.o(188615);
        return -1;
      case 0: 
        AppMethodBeat.o(188615);
        return 0;
      }
      AppMethodBeat.o(188615);
      return 1;
    }
    while (this.ajEB.kFH())
    {
      this.currentIndex += 1;
      String str = kFq();
      localObject = this.ajEB;
      if (((e)localObject).ajEC != 5)
      {
        ((e)localObject).jV("Expected ':'", ((e)localObject).ajED);
        parame = new f();
        AppMethodBeat.o(188615);
        throw parame;
      }
      this.ajEB.kFK();
      j = parame.bJN(str);
      kotlinx.a.b.e locale;
      if (j != -3) {
        if (this.ajEb.ajEw)
        {
          locale = parame.aMJ(j);
          if ((this.ajEB.ajEC == 10) && (!locale.kFc()))
          {
            i = 1;
            if (i == 0) {
              break label883;
            }
          }
        }
      }
      boolean bool;
      for (i = 0;; i = 1)
      {
        if ((i == 0) || (this.ajEb.ajEr)) {
          break label895;
        }
        e.a(this.ajEB, "Encountered an unknown key '" + str + "'. You can enable 'JsonBuilder.ignoreUnknownKeys' property to ignore unknown keys");
        parame = new f();
        AppMethodBeat.o(188615);
        throw parame;
        if (s.p(locale.kFd(), i.b.ajDi))
        {
          localObject = this.ajEB;
          bool = this.ajEb.ajEs;
          if ((((e)localObject).ajEC == 1) || ((bool) && (((e)localObject).ajEC == 0))) {
            break label853;
          }
          localObject = null;
          label843:
          if (localObject != null) {
            break label864;
          }
        }
        label853:
        label864:
        while (locale.bJN((String)localObject) != -3)
        {
          i = 0;
          break;
          localObject = ((e)localObject).PQ(false);
          break label843;
        }
        i = 1;
        break;
        label883:
        AppMethodBeat.o(188615);
        return j;
      }
      label895:
      this.ajEB.kFL();
      if (this.ajEB.ajEC == 4)
      {
        this.ajEB.kFK();
        localObject = this.ajEB;
        bool = this.ajEB.kFH();
        i = this.ajEB.EuH;
        if (!bool)
        {
          ((e)localObject).jV("Unexpected trailing comma", i);
          parame = new f();
          AppMethodBeat.o(188615);
          throw parame;
        }
      }
    }
    AppMethodBeat.o(188615);
    return -1;
  }
  
  public final kotlinx.a.e.a kFA()
  {
    return this.ajEm;
  }
  
  public final kotlinx.a.e.e kFB()
  {
    AppMethodBeat.i(188550);
    kotlinx.a.e.e locale = new d(this.ajEm.ajEb, this.ajEB).kFG();
    AppMethodBeat.o(188550);
    return locale;
  }
  
  public final b kFe()
  {
    return this.ajEA;
  }
  
  public final boolean kFg()
  {
    return this.ajEB.ajEC != 10;
  }
  
  public final Void kFh()
  {
    AppMethodBeat.i(188603);
    Object localObject = this.ajEB;
    if (((e)localObject).ajEC != 10)
    {
      ((e)localObject).jV("Expected 'null' literal", ((e)localObject).ajED);
      localObject = new f();
      AppMethodBeat.o(188603);
      throw ((Throwable)localObject);
    }
    this.ajEB.kFK();
    AppMethodBeat.o(188603);
    return null;
  }
  
  public final boolean kFi()
  {
    AppMethodBeat.i(188627);
    if (this.ajEb.ajEs)
    {
      bool = o.bKa(this.ajEB.kFI());
      AppMethodBeat.o(188627);
      return bool;
    }
    Object localObject = this.ajEB;
    if (((e)localObject).ajEC != 0)
    {
      ((e)localObject).jV("Expected start of the unquoted boolean literal. Use 'JsonBuilder.isLenient = true' to accept non-compliant JSON", ((e)localObject).ajED);
      localObject = new f();
      AppMethodBeat.o(188627);
      throw ((Throwable)localObject);
    }
    boolean bool = o.bKa(((e)localObject).PQ(true));
    AppMethodBeat.o(188627);
    return bool;
  }
  
  public final byte kFj()
  {
    AppMethodBeat.i(188637);
    String str = this.ajEB.kFI();
    f localf;
    try
    {
      byte b = Byte.parseByte(str);
      AppMethodBeat.o(188637);
      return b;
    }
    finally
    {
      e.a(this.ajEB, "Failed to parse '" + "byte" + '\'');
      localf = new f();
      AppMethodBeat.o(188637);
    }
  }
  
  public final short kFk()
  {
    AppMethodBeat.i(188650);
    String str = this.ajEB.kFI();
    f localf;
    try
    {
      short s = Short.parseShort(str);
      AppMethodBeat.o(188650);
      return s;
    }
    finally
    {
      e.a(this.ajEB, "Failed to parse '" + "short" + '\'');
      localf = new f();
      AppMethodBeat.o(188650);
    }
  }
  
  public final int kFl()
  {
    AppMethodBeat.i(188660);
    String str = this.ajEB.kFI();
    f localf;
    try
    {
      int i = Integer.parseInt(str);
      AppMethodBeat.o(188660);
      return i;
    }
    finally
    {
      e.a(this.ajEB, "Failed to parse '" + "int" + '\'');
      localf = new f();
      AppMethodBeat.o(188660);
    }
  }
  
  public final long kFm()
  {
    AppMethodBeat.i(188675);
    String str = this.ajEB.kFI();
    f localf;
    try
    {
      long l = Long.parseLong(str);
      AppMethodBeat.o(188675);
      return l;
    }
    finally
    {
      e.a(this.ajEB, "Failed to parse '" + "long" + '\'');
      localf = new f();
      AppMethodBeat.o(188675);
    }
  }
  
  public final float kFn()
  {
    AppMethodBeat.i(188685);
    String str = this.ajEB.kFI();
    f localf;
    try
    {
      float f = Float.parseFloat(str);
      AppMethodBeat.o(188685);
      return f;
    }
    finally
    {
      e.a(this.ajEB, "Failed to parse '" + "float" + '\'');
      localf = new f();
      AppMethodBeat.o(188685);
    }
  }
  
  public final double kFo()
  {
    AppMethodBeat.i(188695);
    String str = this.ajEB.kFI();
    f localf;
    try
    {
      double d = Double.parseDouble(str);
      AppMethodBeat.o(188695);
      return d;
    }
    finally
    {
      e.a(this.ajEB, "Failed to parse '" + "double" + '\'');
      localf = new f();
      AppMethodBeat.o(188695);
    }
  }
  
  public final char kFp()
  {
    AppMethodBeat.i(188706);
    String str = this.ajEB.kFI();
    f localf;
    try
    {
      char c = n.bA((CharSequence)str);
      AppMethodBeat.o(188706);
      return c;
    }
    finally
    {
      e.a(this.ajEB, "Failed to parse '" + "char" + '\'');
      localf = new f();
      AppMethodBeat.o(188706);
    }
  }
  
  public final String kFq()
  {
    AppMethodBeat.i(188715);
    if (this.ajEb.ajEs)
    {
      str = this.ajEB.kFI();
      AppMethodBeat.o(188715);
      return str;
    }
    String str = this.ajEB.kFJ();
    AppMethodBeat.o(188715);
    return str;
  }
  
  public final boolean kFr()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.e.a.k
 * JD-Core Version:    0.7.0.1
 */