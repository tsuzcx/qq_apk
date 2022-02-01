package kotlinx.a.c.a;

import d.g.b.p;
import kotlinx.a.b.ar;
import kotlinx.a.c.d;
import kotlinx.a.c.m;
import kotlinx.a.c.v;
import kotlinx.a.w.b;
import kotlinx.a.w.c;
import kotlinx.a.x.c;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/internal/AbstractJsonTreeInput;", "Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/json/JsonInput;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "getJson", "()Lkotlinx/serialization/json/Json;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "updateMode$annotations", "()V", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "beginStructure", "Lkotlinx/serialization/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "composeName", "", "parentName", "childName", "currentElement", "tag", "currentObject", "decodeJson", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeTaggedBoolean", "", "decodeTaggedByte", "", "decodeTaggedChar", "", "decodeTaggedDouble", "", "decodeTaggedEnum", "", "enumDescription", "decodeTaggedFloat", "", "decodeTaggedInt", "decodeTaggedLong", "", "decodeTaggedNotNullMark", "decodeTaggedNull", "", "decodeTaggedShort", "", "decodeTaggedString", "decodeTaggedUnit", "", "endStructure", "Lkotlinx/serialization/json/JsonPrimitive;", "primitive", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/json/JsonPrimitive;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/serialization/json/internal/JsonPrimitiveInput;", "Lkotlinx/serialization/json/internal/JsonTreeInput;", "Lkotlinx/serialization/json/internal/JsonTreeListInput;", "kotlinx-serialization-runtime"})
abstract class a
  extends ar
  implements m
{
  protected final d NNe;
  private final kotlinx.a.c.a NOb;
  private final kotlinx.a.c.f NOc;
  
  private a(kotlinx.a.c.a parama, kotlinx.a.c.f paramf)
  {
    this.NOb = parama;
    this.NOc = paramf;
    this.NNe = this.NOb.NNe;
  }
  
  private v bdn(String paramString)
  {
    p.h(paramString, "tag");
    kotlinx.a.c.f localf = bdo(paramString);
    if (!(localf instanceof v)) {}
    for (Object localObject = null;; localObject = localf)
    {
      localObject = (v)localObject;
      if (localObject == null) {
        throw ((Throwable)kotlinx.a.c.l.ac(-1, "Expected JsonPrimitive at " + paramString + ", found " + localf, gxk().toString()));
      }
      return localObject;
    }
  }
  
  private byte bdp(String paramString)
  {
    p.h(paramString, "tag");
    paramString = bdn(paramString);
    try
    {
      int i = Integer.parseInt(paramString.getContent());
      return (byte)i;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ac(-1, "Failed to parse '" + "byte" + '\'', gxk().toString()));
    }
  }
  
  private short bdq(String paramString)
  {
    p.h(paramString, "tag");
    paramString = bdn(paramString);
    try
    {
      int i = Integer.parseInt(paramString.getContent());
      return (short)i;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ac(-1, "Failed to parse '" + "short" + '\'', gxk().toString()));
    }
  }
  
  private int bdr(String paramString)
  {
    p.h(paramString, "tag");
    paramString = bdn(paramString);
    try
    {
      int i = Integer.parseInt(paramString.getContent());
      return i;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ac(-1, "Failed to parse '" + "int" + '\'', gxk().toString()));
    }
  }
  
  private long bds(String paramString)
  {
    p.h(paramString, "tag");
    paramString = bdn(paramString);
    try
    {
      long l = Long.parseLong(paramString.getContent());
      return l;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ac(-1, "Failed to parse '" + "long" + '\'', gxk().toString()));
    }
  }
  
  private float bdt(String paramString)
  {
    p.h(paramString, "tag");
    paramString = bdn(paramString);
    try
    {
      float f = Float.parseFloat(paramString.getContent());
      return f;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ac(-1, "Failed to parse '" + "float" + '\'', gxk().toString()));
    }
  }
  
  private double bdu(String paramString)
  {
    p.h(paramString, "tag");
    paramString = bdn(paramString);
    try
    {
      double d = Double.parseDouble(paramString.getContent());
      return d;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ac(-1, "Failed to parse '" + "double" + '\'', gxk().toString()));
    }
  }
  
  private char bdv(String paramString)
  {
    p.h(paramString, "tag");
    paramString = bdn(paramString);
    try
    {
      char c = d.n.n.aM((CharSequence)paramString.getContent());
      return c;
    }
    catch (Throwable paramString)
    {
      throw ((Throwable)kotlinx.a.c.l.ac(-1, "Failed to parse '" + "char" + '\'', gxk().toString()));
    }
  }
  
  private final kotlinx.a.c.f gxk()
  {
    Object localObject = (String)gxa();
    if (localObject != null)
    {
      kotlinx.a.c.f localf = bdo((String)localObject);
      localObject = localf;
      if (localf != null) {}
    }
    else
    {
      localObject = gxl();
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
    paramVarArgs = gxk();
    Object localObject = paramn.gwR();
    if ((p.i(localObject, w.b.NLR)) || ((localObject instanceof kotlinx.a.j)))
    {
      paramn = this.NOb;
      if (!(paramVarArgs instanceof kotlinx.a.c.b)) {
        throw ((Throwable)new IllegalStateException(("Expected " + d.g.b.z.bp(kotlinx.a.c.b.class) + " but found " + d.g.b.z.bp(paramVarArgs.getClass())).toString()));
      }
      return (kotlinx.a.a)new i(paramn, (kotlinx.a.c.b)paramVarArgs);
    }
    if (p.i(localObject, w.c.NLS))
    {
      localObject = this.NOb;
      paramn = paramn.alK(0);
      kotlinx.a.s locals = paramn.gwR();
      if (((locals instanceof kotlinx.a.l)) || (p.i(locals, x.c.NLX)))
      {
        paramn = this.NOb;
        if (!(paramVarArgs instanceof kotlinx.a.c.s)) {
          throw ((Throwable)new IllegalStateException(("Expected " + d.g.b.z.bp(kotlinx.a.c.s.class) + " but found " + d.g.b.z.bp(paramVarArgs.getClass())).toString()));
        }
      }
      for (paramn = new j(paramn, (kotlinx.a.c.s)paramVarArgs);; paramn = new i(paramn, (kotlinx.a.c.b)paramVarArgs))
      {
        return (kotlinx.a.a)paramn;
        if (!((kotlinx.a.c.a)localObject).NNe.NNs) {
          break;
        }
        paramn = this.NOb;
        if (!(paramVarArgs instanceof kotlinx.a.c.b)) {
          throw ((Throwable)new IllegalStateException(("Expected " + d.g.b.z.bp(kotlinx.a.c.b.class) + " but found " + d.g.b.z.bp(paramVarArgs.getClass())).toString()));
        }
      }
      throw ((Throwable)kotlinx.a.c.l.f(paramn));
    }
    paramn = this.NOb;
    if (!(paramVarArgs instanceof kotlinx.a.c.s)) {
      throw ((Throwable)new IllegalStateException(("Expected " + d.g.b.z.bp(kotlinx.a.c.s.class) + " but found " + d.g.b.z.bp(paramVarArgs.getClass())).toString()));
    }
    return (kotlinx.a.a)new h(paramn, (kotlinx.a.c.s)paramVarArgs);
  }
  
  public void a(kotlinx.a.n paramn)
  {
    p.h(paramn, "descriptor");
  }
  
  protected abstract kotlinx.a.c.f bdo(String paramString);
  
  public final kotlinx.a.d.b gwB()
  {
    return this.NOb.NNd;
  }
  
  public final kotlinx.a.z gwC()
  {
    return this.NNe.NMc;
  }
  
  public final kotlinx.a.c.a gxh()
  {
    return this.NOb;
  }
  
  public final kotlinx.a.c.f gxi()
  {
    return gxk();
  }
  
  public kotlinx.a.c.f gxl()
  {
    return this.NOc;
  }
  
  public final String nG(String paramString1, String paramString2)
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