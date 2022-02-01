package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.d.b.b;
import d.l.b.a.b.d.a.o;
import d.l.b.a.b.e.a.m;
import d.l.b.a.b.e.b.c;
import d.l.b.a.b.e.b.h;
import d.l.b.a.b.e.c.a;
import d.l.b.a.b.e.c.a.b;
import d.l.b.a.b.e.c.a.c;
import d.l.b.a.b.e.c.a.e.a;
import d.l.b.a.b.e.c.a.i;
import d.l.b.a.b.f.g;
import d.l.b.a.b.h.i.c;
import d.l.b.a.b.k.a.b.e;
import d.v;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "()V", "asString", "", "JavaField", "JavaMethodProperty", "KotlinProperty", "MappedKotlinProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "kotlin-reflection"})
public abstract class d
{
  public abstract String sD();
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "getField", "()Ljava/lang/reflect/Field;", "asString", "", "kotlin-reflection"})
  public static final class a
    extends d
  {
    final Field bMM;
    
    public a(Field paramField)
    {
      super();
      AppMethodBeat.i(56292);
      this.bMM = paramField;
      AppMethodBeat.o(56292);
    }
    
    public final String sD()
    {
      AppMethodBeat.i(56291);
      Object localObject = new StringBuilder().append(o.bcp(this.bMM.getName())).append("()");
      Class localClass = this.bMM.getType();
      p.g(localClass, "field.type");
      localObject = b.bC(localClass);
      AppMethodBeat.o(56291);
      return localObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterMethod", "Ljava/lang/reflect/Method;", "setterMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getSetterMethod", "asString", "", "kotlin-reflection"})
  public static final class b
    extends d
  {
    final Method MMP;
    final Method MMQ;
    
    public b(Method paramMethod1, Method paramMethod2)
    {
      super();
      AppMethodBeat.i(56294);
      this.MMP = paramMethod1;
      this.MMQ = paramMethod2;
      AppMethodBeat.o(56294);
    }
    
    public final String sD()
    {
      AppMethodBeat.i(56293);
      String str = ad.c(this.MMP);
      AppMethodBeat.o(56293);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "string", "", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "asString", "getManglingSuffix", "kotlin-reflection"})
  public static final class c
    extends d
  {
    final ah MMR;
    final a.m MMS;
    final a.c MMT;
    final c MMU;
    final h MMV;
    private final String string;
    
    public c(ah paramah, a.m paramm, a.c paramc, c paramc1, h paramh)
    {
      super();
      AppMethodBeat.i(56295);
      this.MMR = paramah;
      this.MMS = paramm;
      this.MMT = paramc;
      this.MMU = paramc1;
      this.MMV = paramh;
      if (this.MMT.gqB())
      {
        paramah = new StringBuilder();
        paramm = this.MMU;
        paramc = this.MMT.Nps;
        p.g(paramc, "signature.getter");
        paramah = paramah.append(paramm.getString(paramc.NlC));
        paramm = this.MMU;
        paramc = this.MMT.Nps;
        p.g(paramc, "signature.getter");
        paramah = paramm.getString(paramc.Npn);
        this.string = paramah;
        AppMethodBeat.o(56295);
        return;
      }
      paramah = i.Nqd;
      paramm = i.a(this.MMS, this.MMU, this.MMV);
      if (paramm == null)
      {
        paramah = (Throwable)new w("No field signature for property: " + this.MMR);
        AppMethodBeat.o(56295);
        throw paramah;
      }
      paramah = paramm.name;
      paramc = paramm.desc;
      paramc1 = new StringBuilder().append(o.bcp(paramah));
      paramah = this.MMR.ghs();
      p.g(paramah, "descriptor.containingDeclaration");
      if ((p.i(this.MMR.ghz(), az.MVg)) && ((paramah instanceof e)))
      {
        paramah = (i.c)((e)paramah).Nyx;
        paramm = a.Nph;
        p.g(paramm, "JvmProtoBuf.classModuleName");
        paramah = (Integer)d.l.b.a.b.e.b.f.a(paramah, paramm);
        if (paramah != null)
        {
          paramm = this.MMU.getString(((Number)paramah).intValue());
          paramah = paramm;
          if (paramm != null) {}
        }
        else
        {
          paramah = "main";
        }
        paramah = "$" + g.bcI(paramah);
      }
      for (;;)
      {
        paramah = paramah + "()" + paramc;
        break;
        if ((p.i(this.MMR.ghz(), az.MVd)) && ((paramah instanceof ab)))
        {
          paramah = this.MMR;
          if (paramah == null)
          {
            paramah = new v("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
            AppMethodBeat.o(56295);
            throw paramah;
          }
          paramah = ((d.l.b.a.b.k.a.b.j)paramah).NyY;
          if (((paramah instanceof d.l.b.a.b.d.b.j)) && (((d.l.b.a.b.d.b.j)paramah).NiU != null))
          {
            paramah = "$" + ((d.l.b.a.b.d.b.j)paramah).gmi().sD();
            continue;
          }
        }
        paramah = "";
      }
    }
    
    public final String sD()
    {
      return this.string;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "setterSignature", "(Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;)V", "getGetterSignature", "()Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "getSetterSignature", "asString", "", "kotlin-reflection"})
  public static final class d
    extends d
  {
    final c.e MMW;
    final c.e MMX;
    
    public d(c.e parame1, c.e parame2)
    {
      super();
      AppMethodBeat.i(56296);
      this.MMW = parame1;
      this.MMX = parame2;
      AppMethodBeat.o(56296);
    }
    
    public final String sD()
    {
      return this.MMW.MMN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.d
 * JD-Core Version:    0.7.0.1
 */