package kotlinx.a.c.a;

import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlinx.a.b.ar;
import kotlinx.a.c.d;
import kotlinx.a.c.m;
import kotlinx.a.c.v;
import kotlinx.a.w.b;
import kotlinx.a.w.c;
import kotlinx.a.x.c;
import kotlinx.a.z;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/internal/AbstractJsonTreeInput;", "Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/json/JsonInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "getJson", "()Lkotlinx/serialization/json/Json;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "updateMode$annotations", "()V", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "beginStructure", "Lkotlinx/serialization/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "composeName", "", "parentName", "childName", "currentElement", "tag", "currentObject", "decodeJson", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeTaggedBoolean", "", "decodeTaggedByte", "", "decodeTaggedChar", "", "decodeTaggedDouble", "", "decodeTaggedEnum", "", "enumDescription", "decodeTaggedFloat", "", "decodeTaggedInt", "decodeTaggedLong", "", "decodeTaggedNotNullMark", "decodeTaggedNull", "", "decodeTaggedShort", "", "decodeTaggedString", "decodeTaggedUnit", "", "endStructure", "Lkotlinx/serialization/json/JsonPrimitive;", "primitive", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/json/JsonPrimitive;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/serialization/json/internal/JsonPrimitiveInput;", "Lkotlinx/serialization/json/internal/JsonTreeInput;", "Lkotlinx/serialization/json/internal/JsonTreeListInput;", "kotlinx-serialization-runtime"})
abstract class a
  extends ar
  implements m
{
  protected final d abCv;
  private final kotlinx.a.c.a abDs;
  private final kotlinx.a.c.f abDt;
  
  private a(kotlinx.a.c.a parama, kotlinx.a.c.f paramf)
  {
    this.abDs = parama;
    this.abDt = paramf;
    this.abCv = this.abDs.abCv;
  }
  
  private v bHJ(String paramString)
  {
    p.k(paramString, "tag");
    kotlinx.a.c.f localf = bHK(paramString);
    if (!(localf instanceof v)) {}
    for (Object localObject = null;; localObject = localf)
    {
      localObject = (v)localObject;
      if (localObject == null) {
        throw ((Throwable)kotlinx.a.c.l.ak(-1, "Expected JsonPrimitive at " + paramString + ", found " + localf, iUa().toString()));
      }
      return localObject;
    }
  }
  
  private byte bHL(String paramString)
  {
    p.k(paramString, "tag");
    paramString = bHJ(paramString);
    try
    {
      int i = Integer.parseInt(paramString.getContent());
      return (byte)i;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ak(-1, "Failed to parse '" + "byte" + '\'', iUa().toString()));
    }
  }
  
  private short bHM(String paramString)
  {
    p.k(paramString, "tag");
    paramString = bHJ(paramString);
    try
    {
      int i = Integer.parseInt(paramString.getContent());
      return (short)i;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ak(-1, "Failed to parse '" + "short" + '\'', iUa().toString()));
    }
  }
  
  private int bHN(String paramString)
  {
    p.k(paramString, "tag");
    paramString = bHJ(paramString);
    try
    {
      int i = Integer.parseInt(paramString.getContent());
      return i;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ak(-1, "Failed to parse '" + "int" + '\'', iUa().toString()));
    }
  }
  
  private long bHO(String paramString)
  {
    p.k(paramString, "tag");
    paramString = bHJ(paramString);
    try
    {
      long l = Long.parseLong(paramString.getContent());
      return l;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ak(-1, "Failed to parse '" + "long" + '\'', iUa().toString()));
    }
  }
  
  private float bHP(String paramString)
  {
    p.k(paramString, "tag");
    paramString = bHJ(paramString);
    try
    {
      float f = Float.parseFloat(paramString.getContent());
      return f;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ak(-1, "Failed to parse '" + "float" + '\'', iUa().toString()));
    }
  }
  
  private double bHQ(String paramString)
  {
    p.k(paramString, "tag");
    paramString = bHJ(paramString);
    try
    {
      double d = Double.parseDouble(paramString.getContent());
      return d;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ak(-1, "Failed to parse '" + "double" + '\'', iUa().toString()));
    }
  }
  
  private char bHR(String paramString)
  {
    p.k(paramString, "tag");
    paramString = bHJ(paramString);
    try
    {
      char c = kotlin.n.n.bj((CharSequence)paramString.getContent());
      return c;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ak(-1, "Failed to parse '" + "char" + '\'', iUa().toString()));
    }
  }
  
  private final kotlinx.a.c.f iUa()
  {
    Object localObject = (String)iTQ();
    if (localObject != null)
    {
      kotlinx.a.c.f localf = bHK((String)localObject);
      localObject = localf;
      if (localf != null) {}
    }
    else
    {
      localObject = iUb();
    }
    return localObject;
  }
  
  public final <T> T a(kotlinx.a.f<T> paramf)
  {
    p.k(paramf, "deserializer");
    return k.a(this, paramf);
  }
  
  public final kotlinx.a.a a(kotlinx.a.n paramn, kotlinx.a.h<?>... paramVarArgs)
  {
    p.k(paramn, "descriptor");
    p.k(paramVarArgs, "typeParams");
    paramVarArgs = iUa();
    Object localObject = paramn.iTG();
    if ((p.h(localObject, w.b.abBi)) || ((localObject instanceof kotlinx.a.j)))
    {
      paramn = this.abDs;
      if (!(paramVarArgs instanceof kotlinx.a.c.b)) {
        throw ((Throwable)new IllegalStateException(("Expected " + ab.bO(kotlinx.a.c.b.class) + " but found " + ab.bO(paramVarArgs.getClass())).toString()));
      }
      return (kotlinx.a.a)new i(paramn, (kotlinx.a.c.b)paramVarArgs);
    }
    if (p.h(localObject, w.c.abBj))
    {
      localObject = this.abDs;
      paramn = paramn.aFY(0);
      kotlinx.a.s locals = paramn.iTG();
      if (((locals instanceof kotlinx.a.l)) || (p.h(locals, x.c.abBo)))
      {
        paramn = this.abDs;
        if (!(paramVarArgs instanceof kotlinx.a.c.s)) {
          throw ((Throwable)new IllegalStateException(("Expected " + ab.bO(kotlinx.a.c.s.class) + " but found " + ab.bO(paramVarArgs.getClass())).toString()));
        }
      }
      for (paramn = new j(paramn, (kotlinx.a.c.s)paramVarArgs);; paramn = new i(paramn, (kotlinx.a.c.b)paramVarArgs))
      {
        return (kotlinx.a.a)paramn;
        if (!((kotlinx.a.c.a)localObject).abCv.abCJ) {
          break;
        }
        paramn = this.abDs;
        if (!(paramVarArgs instanceof kotlinx.a.c.b)) {
          throw ((Throwable)new IllegalStateException(("Expected " + ab.bO(kotlinx.a.c.b.class) + " but found " + ab.bO(paramVarArgs.getClass())).toString()));
        }
      }
      throw ((Throwable)kotlinx.a.c.l.f(paramn));
    }
    paramn = this.abDs;
    if (!(paramVarArgs instanceof kotlinx.a.c.s)) {
      throw ((Throwable)new IllegalStateException(("Expected " + ab.bO(kotlinx.a.c.s.class) + " but found " + ab.bO(paramVarArgs.getClass())).toString()));
    }
    return (kotlinx.a.a)new h(paramn, (kotlinx.a.c.s)paramVarArgs);
  }
  
  public void a(kotlinx.a.n paramn)
  {
    p.k(paramn, "descriptor");
  }
  
  protected abstract kotlinx.a.c.f bHK(String paramString);
  
  public final kotlinx.a.c.a iTX()
  {
    return this.abDs;
  }
  
  public final kotlinx.a.c.f iTY()
  {
    return iUa();
  }
  
  public final kotlinx.a.d.b iTq()
  {
    return this.abDs.abCu;
  }
  
  public final z iTr()
  {
    return this.abCv.abBt;
  }
  
  public kotlinx.a.c.f iUb()
  {
    return this.abDt;
  }
  
  public final String pA(String paramString1, String paramString2)
  {
    p.k(paramString1, "parentName");
    p.k(paramString2, "childName");
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */