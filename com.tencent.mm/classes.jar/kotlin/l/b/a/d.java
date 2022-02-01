package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.d.b.b;
import kotlin.l.b.a.b.d.a.o;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.c.a;
import kotlin.l.b.a.b.e.c.a.b;
import kotlin.l.b.a.b.e.c.a.c;
import kotlin.l.b.a.b.e.c.a.e.a;
import kotlin.l.b.a.b.e.c.a.i;
import kotlin.l.b.a.b.f.g;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.k.a.b.e;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "()V", "asString", "", "JavaField", "JavaMethodProperty", "KotlinProperty", "MappedKotlinProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "kotlin-reflection"})
public abstract class d
{
  public abstract String sG();
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "getField", "()Ljava/lang/reflect/Field;", "asString", "", "kotlin-reflection"})
  public static final class a
    extends d
  {
    final Field bUo;
    
    public a(Field paramField)
    {
      super();
      AppMethodBeat.i(56292);
      this.bUo = paramField;
      AppMethodBeat.o(56292);
    }
    
    public final String sG()
    {
      AppMethodBeat.i(56291);
      Object localObject = new StringBuilder().append(o.btJ(this.bUo.getName())).append("()");
      Class localClass = this.bUo.getType();
      p.g(localClass, "field.type");
      localObject = b.bC(localClass);
      AppMethodBeat.o(56291);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterMethod", "Ljava/lang/reflect/Method;", "setterMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getSetterMethod", "asString", "", "kotlin-reflection"})
  public static final class b
    extends d
  {
    final Method SZC;
    final Method SZD;
    
    public b(Method paramMethod1, Method paramMethod2)
    {
      super();
      AppMethodBeat.i(56294);
      this.SZC = paramMethod1;
      this.SZD = paramMethod2;
      AppMethodBeat.o(56294);
    }
    
    public final String sG()
    {
      AppMethodBeat.i(56293);
      String str = ad.c(this.SZC);
      AppMethodBeat.o(56293);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "string", "", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "asString", "getManglingSuffix", "kotlin-reflection"})
  public static final class c
    extends d
  {
    final ah SZE;
    final a.m SZF;
    final a.c SZG;
    final c SZH;
    final h SZI;
    private final String string;
    
    public c(ah paramah, a.m paramm, a.c paramc, c paramc1, h paramh)
    {
      super();
      AppMethodBeat.i(56295);
      this.SZE = paramah;
      this.SZF = paramm;
      this.SZG = paramc;
      this.SZH = paramc1;
      this.SZI = paramh;
      if (this.SZG.hIA())
      {
        paramah = new StringBuilder();
        paramm = this.SZH;
        paramc = this.SZG.TCc;
        p.g(paramc, "signature.getter");
        paramah = paramah.append(paramm.getString(paramc.Tyk));
        paramm = this.SZH;
        paramc = this.SZG.TCc;
        p.g(paramc, "signature.getter");
        paramah = paramm.getString(paramc.TBX);
        this.string = paramah;
        AppMethodBeat.o(56295);
        return;
      }
      paramah = i.TCN;
      paramm = i.a(this.SZF, this.SZH, this.SZI);
      if (paramm == null)
      {
        paramah = (Throwable)new w("No field signature for property: " + this.SZE);
        AppMethodBeat.o(56295);
        throw paramah;
      }
      paramah = paramm.name;
      paramc = paramm.desc;
      paramc1 = new StringBuilder().append(o.btJ(paramah));
      paramah = this.SZE.hzx();
      p.g(paramah, "descriptor.containingDeclaration");
      if ((p.j(this.SZE.hzE(), az.ThT)) && ((paramah instanceof e)))
      {
        paramah = (i.c)((e)paramah).TKA;
        paramm = a.TBR;
        p.g(paramm, "JvmProtoBuf.classModuleName");
        paramah = (Integer)kotlin.l.b.a.b.e.b.f.a(paramah, paramm);
        if (paramah != null)
        {
          paramm = this.SZH.getString(((Number)paramah).intValue());
          paramah = paramm;
          if (paramm != null) {}
        }
        else
        {
          paramah = "main";
        }
        paramah = "$" + g.buc(paramah);
      }
      for (;;)
      {
        paramah = paramah + "()" + paramc;
        break;
        if ((p.j(this.SZE.hzE(), az.ThQ)) && ((paramah instanceof ab)))
        {
          paramah = this.SZE;
          if (paramah == null)
          {
            paramah = new t("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
            AppMethodBeat.o(56295);
            throw paramah;
          }
          paramah = ((kotlin.l.b.a.b.k.a.b.j)paramah).TLb;
          if (((paramah instanceof kotlin.l.b.a.b.d.b.j)) && (((kotlin.l.b.a.b.d.b.j)paramah).TvG != null))
          {
            paramah = "$" + ((kotlin.l.b.a.b.d.b.j)paramah).hEm().sG();
            continue;
          }
        }
        paramah = "";
      }
    }
    
    public final String sG()
    {
      return this.string;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "setterSignature", "(Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;)V", "getGetterSignature", "()Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "getSetterSignature", "asString", "", "kotlin-reflection"})
  public static final class d
    extends d
  {
    final c.e SZJ;
    final c.e SZK;
    
    public d(c.e parame1, c.e parame2)
    {
      super();
      AppMethodBeat.i(56296);
      this.SZJ = parame1;
      this.SZK = parame2;
      AppMethodBeat.o(56296);
    }
    
    public final String sG()
    {
      return this.SZJ.SZA;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.d
 * JD-Core Version:    0.7.0.1
 */