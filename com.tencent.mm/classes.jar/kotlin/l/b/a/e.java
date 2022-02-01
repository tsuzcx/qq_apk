package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.e.b.b;
import kotlin.l.b.a.b.d.a.v;
import kotlin.l.b.a.b.d.b.i;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.c.a;
import kotlin.l.b.a.b.e.c.a.b;
import kotlin.l.b.a.b.e.c.a.c;
import kotlin.l.b.a.b.e.c.a.d.a;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.k.a.b.k;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "()V", "asString", "", "JavaField", "JavaMethodProperty", "KotlinProperty", "MappedKotlinProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public abstract class e
{
  public abstract String PF();
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "getField", "()Ljava/lang/reflect/Field;", "asString", "", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class a
    extends e
  {
    final Field dEn;
    
    public a(Field paramField)
    {
      super();
      AppMethodBeat.i(56292);
      this.dEn = paramField;
      AppMethodBeat.o(56292);
    }
    
    public final String PF()
    {
      AppMethodBeat.i(56291);
      Object localObject1 = new StringBuilder();
      Object localObject2 = this.dEn.getName();
      kotlin.g.b.s.s(localObject2, "field.name");
      localObject1 = ((StringBuilder)localObject1).append(v.bIO((String)localObject2)).append("()");
      localObject2 = this.dEn.getType();
      kotlin.g.b.s.s(localObject2, "field.type");
      localObject1 = b.cN((Class)localObject2);
      AppMethodBeat.o(56291);
      return localObject1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterMethod", "Ljava/lang/reflect/Method;", "setterMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getSetterMethod", "asString", "", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class b
    extends e
  {
    final Method aiyf;
    final Method aiyg;
    
    public b(Method paramMethod1, Method paramMethod2)
    {
      super();
      AppMethodBeat.i(56294);
      this.aiyf = paramMethod1;
      this.aiyg = paramMethod2;
      AppMethodBeat.o(56294);
    }
    
    public final String PF()
    {
      AppMethodBeat.i(56293);
      String str = ah.g(this.aiyf);
      AppMethodBeat.o(56293);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "string", "", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "asString", "getManglingSuffix", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class c
    extends e
  {
    final ap aiyh;
    final a.m aiyi;
    final a.c aiyj;
    final c aiyk;
    final kotlin.l.b.a.b.e.b.g aiyl;
    private final String cBR;
    
    public c(ap paramap, a.m paramm, a.c paramc, c paramc1, kotlin.l.b.a.b.e.b.g paramg)
    {
      super();
      AppMethodBeat.i(56295);
      this.aiyh = paramap;
      this.aiyi = paramm;
      this.aiyj = paramc;
      this.aiyk = paramc1;
      this.aiyl = paramg;
      if (this.aiyj.kxn())
      {
        paramap = new StringBuilder();
        paramm = this.aiyk;
        paramc = this.aiyj.ajdD;
        kotlin.g.b.s.s(paramc, "signature.getter");
        paramap = paramap.append(paramm.getString(paramc.aiZC));
        paramm = this.aiyk;
        paramc = this.aiyj.ajdD;
        kotlin.g.b.s.s(paramc, "signature.getter");
        paramap = paramm.getString(paramc.ajdy);
        this.cBR = paramap;
        AppMethodBeat.o(56295);
        return;
      }
      paramap = kotlin.l.b.a.b.e.c.a.g.ajem;
      paramm = kotlin.l.b.a.b.e.c.a.g.a(this.aiyi, this.aiyk, this.aiyl);
      if (paramm == null)
      {
        paramap = (Throwable)new aa("No field signature for property: " + this.aiyh);
        AppMethodBeat.o(56295);
        throw paramap;
      }
      paramap = paramm.name;
      paramc = paramm.desc;
      paramc1 = new StringBuilder().append(v.bIO(paramap));
      paramap = this.aiyh.knp();
      kotlin.g.b.s.s(paramap, "descriptor.containingDeclaration");
      if ((kotlin.g.b.s.p(this.aiyh.knc(), kotlin.l.b.a.b.b.s.aiGF)) && ((paramap instanceof kotlin.l.b.a.b.k.a.b.e)))
      {
        paramap = (i.c)((kotlin.l.b.a.b.k.a.b.e)paramap).ajlM;
        paramm = a.ajdr;
        kotlin.g.b.s.s(paramm, "JvmProtoBuf.classModuleName");
        paramap = (Integer)kotlin.l.b.a.b.e.b.e.a(paramap, paramm);
        if (paramap != null)
        {
          paramm = this.aiyk.getString(((Number)paramap).intValue());
          paramap = paramm;
          if (paramm != null) {}
        }
        else
        {
          paramap = "main";
        }
        paramap = "$" + kotlin.l.b.a.b.f.g.bJi(paramap);
      }
      for (;;)
      {
        paramap = paramap + "()" + paramc;
        break;
        if ((kotlin.g.b.s.p(this.aiyh.knc(), kotlin.l.b.a.b.b.s.aiGC)) && ((paramap instanceof kotlin.l.b.a.b.b.ah)))
        {
          paramap = this.aiyh;
          if (paramap == null)
          {
            paramap = new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
            AppMethodBeat.o(56295);
            throw paramap;
          }
          paramap = ((k)paramap).ajmm;
          if (((paramap instanceof i)) && (((i)paramap).aiWH != null))
          {
            paramap = "$" + ((i)paramap).ksN().PF();
            continue;
          }
        }
        paramap = "";
      }
    }
    
    public final String PF()
    {
      return this.cBR;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "setterSignature", "(Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;)V", "getGetterSignature", "()Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "getSetterSignature", "asString", "", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class d
    extends e
  {
    final d.e aiym;
    final d.e aiyn;
    
    public d(d.e parame1, d.e parame2)
    {
      super();
      AppMethodBeat.i(56296);
      this.aiym = parame1;
      this.aiyn = parame2;
      AppMethodBeat.o(56296);
    }
    
    public final String PF()
    {
      return this.aiym.aiyd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.e
 * JD-Core Version:    0.7.0.1
 */