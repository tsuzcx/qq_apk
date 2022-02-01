package kotlinx.a.c.a;

import d.g.b.p;
import kotlinx.a.b.ar;
import kotlinx.a.c.d;
import kotlinx.a.c.m;
import kotlinx.a.c.v;
import kotlinx.a.w.b;
import kotlinx.a.w.c;
import kotlinx.a.x.c;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/internal/AbstractJsonTreeInput;", "Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/json/JsonInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "getJson", "()Lkotlinx/serialization/json/Json;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "updateMode$annotations", "()V", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "beginStructure", "Lkotlinx/serialization/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "composeName", "", "parentName", "childName", "currentElement", "tag", "currentObject", "decodeJson", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeTaggedBoolean", "", "decodeTaggedByte", "", "decodeTaggedChar", "", "decodeTaggedDouble", "", "decodeTaggedEnum", "", "enumDescription", "decodeTaggedFloat", "", "decodeTaggedInt", "decodeTaggedLong", "", "decodeTaggedNotNullMark", "decodeTaggedNull", "", "decodeTaggedShort", "", "decodeTaggedString", "decodeTaggedUnit", "", "endStructure", "Lkotlinx/serialization/json/JsonPrimitive;", "primitive", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/json/JsonPrimitive;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/serialization/json/internal/JsonPrimitiveInput;", "Lkotlinx/serialization/json/internal/JsonTreeInput;", "Lkotlinx/serialization/json/internal/JsonTreeListInput;", "kotlinx-serialization-runtime"})
abstract class a
  extends ar
  implements m
{
  protected final d Okk;
  private final kotlinx.a.c.a Olh;
  private final kotlinx.a.c.f Oli;
  
  private a(kotlinx.a.c.a parama, kotlinx.a.c.f paramf)
  {
    this.Olh = parama;
    this.Oli = paramf;
    this.Okk = this.Olh.Okk;
  }
  
  private v beR(String paramString)
  {
    p.h(paramString, "tag");
    kotlinx.a.c.f localf = beS(paramString);
    if (!(localf instanceof v)) {}
    for (Object localObject = null;; localObject = localf)
    {
      localObject = (v)localObject;
      if (localObject == null) {
        throw ((Throwable)kotlinx.a.c.l.ac(-1, "Expected JsonPrimitive at " + paramString + ", found " + localf, gBM().toString()));
      }
      return localObject;
    }
  }
  
  private byte beT(String paramString)
  {
    p.h(paramString, "tag");
    paramString = beR(paramString);
    try
    {
      int i = Integer.parseInt(paramString.getContent());
      return (byte)i;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ac(-1, "Failed to parse '" + "byte" + '\'', gBM().toString()));
    }
  }
  
  private short beU(String paramString)
  {
    p.h(paramString, "tag");
    paramString = beR(paramString);
    try
    {
      int i = Integer.parseInt(paramString.getContent());
      return (short)i;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ac(-1, "Failed to parse '" + "short" + '\'', gBM().toString()));
    }
  }
  
  private int beV(String paramString)
  {
    p.h(paramString, "tag");
    paramString = beR(paramString);
    try
    {
      int i = Integer.parseInt(paramString.getContent());
      return i;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ac(-1, "Failed to parse '" + "int" + '\'', gBM().toString()));
    }
  }
  
  private long beW(String paramString)
  {
    p.h(paramString, "tag");
    paramString = beR(paramString);
    try
    {
      long l = Long.parseLong(paramString.getContent());
      return l;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ac(-1, "Failed to parse '" + "long" + '\'', gBM().toString()));
    }
  }
  
  private float beX(String paramString)
  {
    p.h(paramString, "tag");
    paramString = beR(paramString);
    try
    {
      float f = Float.parseFloat(paramString.getContent());
      return f;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ac(-1, "Failed to parse '" + "float" + '\'', gBM().toString()));
    }
  }
  
  private double beY(String paramString)
  {
    p.h(paramString, "tag");
    paramString = beR(paramString);
    try
    {
      double d = Double.parseDouble(paramString.getContent());
      return d;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ac(-1, "Failed to parse '" + "double" + '\'', gBM().toString()));
    }
  }
  
  private char beZ(String paramString)
  {
    p.h(paramString, "tag");
    paramString = beR(paramString);
    try
    {
      char c = d.n.n.aL((CharSequence)paramString.getContent());
      return c;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ac(-1, "Failed to parse '" + "char" + '\'', gBM().toString()));
    }
  }
  
  private final kotlinx.a.c.f gBM()
  {
    Object localObject = (String)gBC();
    if (localObject != null)
    {
      kotlinx.a.c.f localf = beS((String)localObject);
      localObject = localf;
      if (localf != null) {}
    }
    else
    {
      localObject = gBN();
    }
    return localObject;
  }
  
  public final <T> T a(kotlinx.a.f<T> paramf)
  {
    p.h(paramf, "deserializer");
    return k.a(this, paramf);
  }
  
  public final kotlinx.a.a a(kotlinx.a.n paramn, kotlinx.a.h<?>... paramVarArgs)
  {
    p.h(paramn, "descriptor");
    p.h(paramVarArgs, "typeParams");
    paramVarArgs = gBM();
    Object localObject = paramn.gBt();
    if ((p.i(localObject, w.b.OiX)) || ((localObject instanceof kotlinx.a.j)))
    {
      paramn = this.Olh;
      if (!(paramVarArgs instanceof kotlinx.a.c.b)) {
        throw ((Throwable)new IllegalStateException(("Expected " + d.g.b.z.bp(kotlinx.a.c.b.class) + " but found " + d.g.b.z.bp(paramVarArgs.getClass())).toString()));
      }
      return (kotlinx.a.a)new i(paramn, (kotlinx.a.c.b)paramVarArgs);
    }
    if (p.i(localObject, w.c.OiY))
    {
      localObject = this.Olh;
      paramn = paramn.amu(0);
      kotlinx.a.s locals = paramn.gBt();
      if (((locals instanceof kotlinx.a.l)) || (p.i(locals, x.c.Ojd)))
      {
        paramn = this.Olh;
        if (!(paramVarArgs instanceof kotlinx.a.c.s)) {
          throw ((Throwable)new IllegalStateException(("Expected " + d.g.b.z.bp(kotlinx.a.c.s.class) + " but found " + d.g.b.z.bp(paramVarArgs.getClass())).toString()));
        }
      }
      for (paramn = new j(paramn, (kotlinx.a.c.s)paramVarArgs);; paramn = new i(paramn, (kotlinx.a.c.b)paramVarArgs))
      {
        return (kotlinx.a.a)paramn;
        if (!((kotlinx.a.c.a)localObject).Okk.Oky) {
          break;
        }
        paramn = this.Olh;
        if (!(paramVarArgs instanceof kotlinx.a.c.b)) {
          throw ((Throwable)new IllegalStateException(("Expected " + d.g.b.z.bp(kotlinx.a.c.b.class) + " but found " + d.g.b.z.bp(paramVarArgs.getClass())).toString()));
        }
      }
      throw ((Throwable)kotlinx.a.c.l.f(paramn));
    }
    paramn = this.Olh;
    if (!(paramVarArgs instanceof kotlinx.a.c.s)) {
      throw ((Throwable)new IllegalStateException(("Expected " + d.g.b.z.bp(kotlinx.a.c.s.class) + " but found " + d.g.b.z.bp(paramVarArgs.getClass())).toString()));
    }
    return (kotlinx.a.a)new h(paramn, (kotlinx.a.c.s)paramVarArgs);
  }
  
  public void a(kotlinx.a.n paramn)
  {
    p.h(paramn, "descriptor");
  }
  
  protected abstract kotlinx.a.c.f beS(String paramString);
  
  public final kotlinx.a.c.a gBJ()
  {
    return this.Olh;
  }
  
  public final kotlinx.a.c.f gBK()
  {
    return gBM();
  }
  
  public kotlinx.a.c.f gBN()
  {
    return this.Oli;
  }
  
  public final kotlinx.a.d.b gBd()
  {
    return this.Olh.Okj;
  }
  
  public final kotlinx.a.z gBe()
  {
    return this.Okk.Oji;
  }
  
  public final String nM(String paramString1, String paramString2)
  {
    p.h(paramString1, "parentName");
    p.h(paramString2, "childName");
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */