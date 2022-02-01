package kotlinx.a.c.a;

import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlinx.a.b.ar;
import kotlinx.a.c.d;
import kotlinx.a.c.m;
import kotlinx.a.c.v;
import kotlinx.a.w.b;
import kotlinx.a.w.c;
import kotlinx.a.x.c;
import kotlinx.a.z;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/internal/AbstractJsonTreeInput;", "Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/json/JsonInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "getJson", "()Lkotlinx/serialization/json/Json;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "updateMode$annotations", "()V", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "beginStructure", "Lkotlinx/serialization/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "composeName", "", "parentName", "childName", "currentElement", "tag", "currentObject", "decodeJson", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeTaggedBoolean", "", "decodeTaggedByte", "", "decodeTaggedChar", "", "decodeTaggedDouble", "", "decodeTaggedEnum", "", "enumDescription", "decodeTaggedFloat", "", "decodeTaggedInt", "decodeTaggedLong", "", "decodeTaggedNotNullMark", "decodeTaggedNull", "", "decodeTaggedShort", "", "decodeTaggedString", "decodeTaggedUnit", "", "endStructure", "Lkotlinx/serialization/json/JsonPrimitive;", "primitive", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/json/JsonPrimitive;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/serialization/json/internal/JsonPrimitiveInput;", "Lkotlinx/serialization/json/internal/JsonTreeInput;", "Lkotlinx/serialization/json/internal/JsonTreeListInput;", "kotlinx-serialization-runtime"})
abstract class a
  extends ar
  implements m
{
  protected final d TZf;
  private final kotlinx.a.c.a Uae;
  private final kotlinx.a.c.f Uaf;
  
  private a(kotlinx.a.c.a parama, kotlinx.a.c.f paramf)
  {
    this.Uae = parama;
    this.Uaf = paramf;
    this.TZf = this.Uae.TZf;
  }
  
  private v buG(String paramString)
  {
    p.h(paramString, "tag");
    kotlinx.a.c.f localf = buH(paramString);
    if (!(localf instanceof v)) {}
    for (Object localObject = null;; localObject = localf)
    {
      localObject = (v)localObject;
      if (localObject == null) {
        throw ((Throwable)kotlinx.a.c.l.af(-1, "Expected JsonPrimitive at " + paramString + ", found " + localf, hOT().toString()));
      }
      return localObject;
    }
  }
  
  private byte buI(String paramString)
  {
    p.h(paramString, "tag");
    paramString = buG(paramString);
    try
    {
      int i = Integer.parseInt(paramString.getContent());
      return (byte)i;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.af(-1, "Failed to parse '" + "byte" + '\'', hOT().toString()));
    }
  }
  
  private short buJ(String paramString)
  {
    p.h(paramString, "tag");
    paramString = buG(paramString);
    try
    {
      int i = Integer.parseInt(paramString.getContent());
      return (short)i;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.af(-1, "Failed to parse '" + "short" + '\'', hOT().toString()));
    }
  }
  
  private int buK(String paramString)
  {
    p.h(paramString, "tag");
    paramString = buG(paramString);
    try
    {
      int i = Integer.parseInt(paramString.getContent());
      return i;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.af(-1, "Failed to parse '" + "int" + '\'', hOT().toString()));
    }
  }
  
  private long buL(String paramString)
  {
    p.h(paramString, "tag");
    paramString = buG(paramString);
    try
    {
      long l = Long.parseLong(paramString.getContent());
      return l;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.af(-1, "Failed to parse '" + "long" + '\'', hOT().toString()));
    }
  }
  
  private float buM(String paramString)
  {
    p.h(paramString, "tag");
    paramString = buG(paramString);
    try
    {
      float f = Float.parseFloat(paramString.getContent());
      return f;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.af(-1, "Failed to parse '" + "float" + '\'', hOT().toString()));
    }
  }
  
  private double buN(String paramString)
  {
    p.h(paramString, "tag");
    paramString = buG(paramString);
    try
    {
      double d = Double.parseDouble(paramString.getContent());
      return d;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.af(-1, "Failed to parse '" + "double" + '\'', hOT().toString()));
    }
  }
  
  private char buO(String paramString)
  {
    p.h(paramString, "tag");
    paramString = buG(paramString);
    try
    {
      char c = kotlin.n.n.aT((CharSequence)paramString.getContent());
      return c;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.af(-1, "Failed to parse '" + "char" + '\'', hOT().toString()));
    }
  }
  
  private final kotlinx.a.c.f hOT()
  {
    Object localObject = (String)hOJ();
    if (localObject != null)
    {
      kotlinx.a.c.f localf = buH((String)localObject);
      localObject = localf;
      if (localf != null) {}
    }
    else
    {
      localObject = hOU();
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
    paramVarArgs = hOT();
    Object localObject = paramn.hOA();
    if ((p.j(localObject, w.b.TXT)) || ((localObject instanceof kotlinx.a.j)))
    {
      paramn = this.Uae;
      if (!(paramVarArgs instanceof kotlinx.a.c.b)) {
        throw ((Throwable)new IllegalStateException(("Expected " + aa.bp(kotlinx.a.c.b.class) + " but found " + aa.bp(paramVarArgs.getClass())).toString()));
      }
      return (kotlinx.a.a)new i(paramn, (kotlinx.a.c.b)paramVarArgs);
    }
    if (p.j(localObject, w.c.TXU))
    {
      localObject = this.Uae;
      paramn = paramn.awd(0);
      kotlinx.a.s locals = paramn.hOA();
      if (((locals instanceof kotlinx.a.l)) || (p.j(locals, x.c.TXZ)))
      {
        paramn = this.Uae;
        if (!(paramVarArgs instanceof kotlinx.a.c.s)) {
          throw ((Throwable)new IllegalStateException(("Expected " + aa.bp(kotlinx.a.c.s.class) + " but found " + aa.bp(paramVarArgs.getClass())).toString()));
        }
      }
      for (paramn = new j(paramn, (kotlinx.a.c.s)paramVarArgs);; paramn = new i(paramn, (kotlinx.a.c.b)paramVarArgs))
      {
        return (kotlinx.a.a)paramn;
        if (!((kotlinx.a.c.a)localObject).TZf.TZu) {
          break;
        }
        paramn = this.Uae;
        if (!(paramVarArgs instanceof kotlinx.a.c.b)) {
          throw ((Throwable)new IllegalStateException(("Expected " + aa.bp(kotlinx.a.c.b.class) + " but found " + aa.bp(paramVarArgs.getClass())).toString()));
        }
      }
      throw ((Throwable)kotlinx.a.c.l.f(paramn));
    }
    paramn = this.Uae;
    if (!(paramVarArgs instanceof kotlinx.a.c.s)) {
      throw ((Throwable)new IllegalStateException(("Expected " + aa.bp(kotlinx.a.c.s.class) + " but found " + aa.bp(paramVarArgs.getClass())).toString()));
    }
    return (kotlinx.a.a)new h(paramn, (kotlinx.a.c.s)paramVarArgs);
  }
  
  public void a(kotlinx.a.n paramn)
  {
    p.h(paramn, "descriptor");
  }
  
  protected abstract kotlinx.a.c.f buH(String paramString);
  
  public final kotlinx.a.c.a hOQ()
  {
    return this.Uae;
  }
  
  public final kotlinx.a.c.f hOR()
  {
    return hOT();
  }
  
  public kotlinx.a.c.f hOU()
  {
    return this.Uaf;
  }
  
  public final kotlinx.a.d.b hOk()
  {
    return this.Uae.TZe;
  }
  
  public final z hOl()
  {
    return this.TZf.TYe;
  }
  
  public final String oE(String paramString1, String paramString2)
  {
    p.h(paramString1, "parentName");
    p.h(paramString2, "childName");
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */