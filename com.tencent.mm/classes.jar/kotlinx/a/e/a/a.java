package kotlinx.a.e.a;

import kotlin.Metadata;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlinx.a.b.i.b;
import kotlinx.a.b.j.b;
import kotlinx.a.b.j.c;
import kotlinx.a.d.ab;
import kotlinx.a.e.f;
import kotlinx.a.e.m;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;)V", "configuration", "Lkotlinx/serialization/json/internal/JsonConf;", "getJson", "()Lkotlinx/serialization/json/Json;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode$annotations", "()V", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "composeName", "", "parentName", "childName", "currentElement", "tag", "currentObject", "decodeJsonElement", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeTaggedBoolean", "", "decodeTaggedByte", "", "decodeTaggedChar", "", "decodeTaggedDouble", "", "decodeTaggedEnum", "", "enumDescription", "decodeTaggedFloat", "", "decodeTaggedInt", "decodeTaggedLong", "", "decodeTaggedNotNullMark", "decodeTaggedNull", "", "decodeTaggedShort", "", "decodeTaggedString", "endStructure", "", "Lkotlinx/serialization/json/JsonPrimitive;", "primitive", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/json/JsonPrimitive;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/serialization/json/internal/JsonPrimitiveDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeListDecoder;", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
abstract class a
  extends ab
  implements kotlinx.a.e.c
{
  protected final c ajEb;
  private final kotlinx.a.e.a ajEm;
  private final kotlinx.a.e.e ajEn;
  
  private a(kotlinx.a.e.a parama, kotlinx.a.e.e parame)
  {
    this.ajEm = parama;
    this.ajEn = parame;
    this.ajEb = this.ajEm.ajEb;
  }
  
  private kotlinx.a.e.n bJP(String paramString)
  {
    s.u(paramString, "tag");
    kotlinx.a.e.e locale = bJQ(paramString);
    if (!(locale instanceof kotlinx.a.e.n)) {}
    for (Object localObject = null;; localObject = locale)
    {
      localObject = (kotlinx.a.e.n)localObject;
      if (localObject == null) {
        throw ((Throwable)kotlinx.a.e.j.am(-1, "Expected JsonPrimitive at " + paramString + ", found " + locale, kFC().toString()));
      }
      return localObject;
    }
  }
  
  private byte bJR(String paramString)
  {
    s.u(paramString, "tag");
    paramString = bJP(paramString);
    try
    {
      int i = f.a(paramString);
      return (byte)i;
    }
    finally {}
  }
  
  private short bJS(String paramString)
  {
    s.u(paramString, "tag");
    paramString = bJP(paramString);
    try
    {
      int i = f.a(paramString);
      return (short)i;
    }
    finally {}
  }
  
  private int bJT(String paramString)
  {
    s.u(paramString, "tag");
    paramString = bJP(paramString);
    try
    {
      int i = f.a(paramString);
      return i;
    }
    finally {}
  }
  
  private long bJU(String paramString)
  {
    s.u(paramString, "tag");
    paramString = bJP(paramString);
    try
    {
      s.u(paramString, "$this$long");
      long l = Long.parseLong(paramString.getContent());
      return l;
    }
    finally {}
  }
  
  private float bJV(String paramString)
  {
    s.u(paramString, "tag");
    paramString = bJP(paramString);
    try
    {
      s.u(paramString, "$this$float");
      float f = Float.parseFloat(paramString.getContent());
      return f;
    }
    finally {}
  }
  
  private double bJW(String paramString)
  {
    s.u(paramString, "tag");
    paramString = bJP(paramString);
    try
    {
      s.u(paramString, "$this$double");
      double d = Double.parseDouble(paramString.getContent());
      return d;
    }
    finally {}
  }
  
  private char bJX(String paramString)
  {
    s.u(paramString, "tag");
    paramString = bJP(paramString);
    try
    {
      char c = kotlin.n.n.bA((CharSequence)paramString.getContent());
      return c;
    }
    finally {}
  }
  
  private final kotlinx.a.e.e kFC()
  {
    Object localObject = (String)kFy();
    if (localObject != null)
    {
      kotlinx.a.e.e locale = bJQ((String)localObject);
      localObject = locale;
      if (locale != null) {}
    }
    else
    {
      localObject = kFD();
    }
    return localObject;
  }
  
  public final <T> T b(kotlinx.a.a<T> parama)
  {
    s.u(parama, "deserializer");
    return j.a(this, parama);
  }
  
  public void b(kotlinx.a.b.e parame)
  {
    s.u(parame, "descriptor");
  }
  
  protected abstract kotlinx.a.e.e bJQ(String paramString);
  
  public kotlinx.a.c.c c(kotlinx.a.b.e parame)
  {
    s.u(parame, "descriptor");
    kotlinx.a.e.e locale = kFC();
    Object localObject = parame.kFd();
    if ((s.p(localObject, j.b.ajDk)) || ((localObject instanceof kotlinx.a.b.c)))
    {
      localObject = this.ajEm;
      if (!(locale instanceof kotlinx.a.e.b)) {
        throw ((Throwable)new kotlinx.a.e.d(-1, "Expected " + ai.cz(kotlinx.a.e.b.class) + " as the serialized body of " + parame.kFa() + ", but had " + ai.cz(locale.getClass())));
      }
      return (kotlinx.a.c.c)new h((kotlinx.a.e.a)localObject, (kotlinx.a.e.b)locale);
    }
    if (s.p(localObject, j.c.ajDl))
    {
      localObject = this.ajEm;
      kotlinx.a.b.e locale1 = parame.aMJ(0);
      kotlinx.a.b.i locali = locale1.kFd();
      if (((locali instanceof kotlinx.a.b.d)) || (s.p(locali, i.b.ajDi)))
      {
        localObject = this.ajEm;
        if (!(locale instanceof m)) {
          throw ((Throwable)new kotlinx.a.e.d(-1, "Expected " + ai.cz(m.class) + " as the serialized body of " + parame.kFa() + ", but had " + ai.cz(locale.getClass())));
        }
      }
      for (parame = new i((kotlinx.a.e.a)localObject, (m)locale);; parame = new h((kotlinx.a.e.a)localObject, (kotlinx.a.e.b)locale))
      {
        return (kotlinx.a.c.c)parame;
        if (!((kotlinx.a.e.a)localObject).ajEb.ajEt) {
          break;
        }
        localObject = this.ajEm;
        if (!(locale instanceof kotlinx.a.e.b)) {
          throw ((Throwable)new kotlinx.a.e.d(-1, "Expected " + ai.cz(kotlinx.a.e.b.class) + " as the serialized body of " + parame.kFa() + ", but had " + ai.cz(locale.getClass())));
        }
      }
      throw ((Throwable)kotlinx.a.e.j.i(locale1));
    }
    localObject = this.ajEm;
    if (!(locale instanceof m)) {
      throw ((Throwable)new kotlinx.a.e.d(-1, "Expected " + ai.cz(m.class) + " as the serialized body of " + parame.kFa() + ", but had " + ai.cz(locale.getClass())));
    }
    return (kotlinx.a.c.c)new g((kotlinx.a.e.a)localObject, (m)locale);
  }
  
  public final kotlinx.a.e.a kFA()
  {
    return this.ajEm;
  }
  
  public final kotlinx.a.e.e kFB()
  {
    return kFC();
  }
  
  public kotlinx.a.e.e kFD()
  {
    return this.ajEn;
  }
  
  public final kotlinx.a.f.b kFe()
  {
    return this.ajEm.ajEb.ajEA;
  }
  
  public final String rx(String paramString1, String paramString2)
  {
    s.u(paramString1, "parentName");
    s.u(paramString2, "childName");
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.e.a.a
 * JD-Core Version:    0.7.0.1
 */