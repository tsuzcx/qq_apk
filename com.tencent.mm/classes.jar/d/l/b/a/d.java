package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
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

@l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "()V", "asString", "", "JavaField", "JavaMethodProperty", "KotlinProperty", "MappedKotlinProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "kotlin-reflection"})
public abstract class d
{
  public abstract String rf();
  
  @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "getField", "()Ljava/lang/reflect/Field;", "asString", "", "kotlin-reflection"})
  public static final class a
    extends d
  {
    final Field bCy;
    
    public a(Field paramField)
    {
      super();
      AppMethodBeat.i(56292);
      this.bCy = paramField;
      AppMethodBeat.o(56292);
    }
    
    public final String rf()
    {
      AppMethodBeat.i(56291);
      Object localObject = new StringBuilder().append(o.aWm(this.bCy.getName())).append("()");
      Class localClass = this.bCy.getType();
      k.g(localClass, "field.type");
      localObject = b.bA(localClass);
      AppMethodBeat.o(56291);
      return localObject;
    }
  }
  
  @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterMethod", "Ljava/lang/reflect/Method;", "setterMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getSetterMethod", "asString", "", "kotlin-reflection"})
  public static final class b
    extends d
  {
    final Method KVJ;
    final Method KVK;
    
    public b(Method paramMethod1, Method paramMethod2)
    {
      super();
      AppMethodBeat.i(56294);
      this.KVJ = paramMethod1;
      this.KVK = paramMethod2;
      AppMethodBeat.o(56294);
    }
    
    public final String rf()
    {
      AppMethodBeat.i(56293);
      String str = ae.c(this.KVJ);
      AppMethodBeat.o(56293);
      return str;
    }
  }
  
  @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "string", "", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "asString", "getManglingSuffix", "kotlin-reflection"})
  public static final class c
    extends d
  {
    final ah KVL;
    final a.m KVM;
    final a.c KVN;
    final c KVO;
    final h KVP;
    private final String string;
    
    public c(ah paramah, a.m paramm, a.c paramc, c paramc1, h paramh)
    {
      super();
      AppMethodBeat.i(56295);
      this.KVL = paramah;
      this.KVM = paramm;
      this.KVN = paramc;
      this.KVO = paramc1;
      this.KVP = paramh;
      if (this.KVN.fZc())
      {
        paramah = new StringBuilder();
        paramm = this.KVO;
        paramc = this.KVN.Lyv;
        k.g(paramc, "signature.getter");
        paramah = paramah.append(paramm.getString(paramc.LuF));
        paramm = this.KVO;
        paramc = this.KVN.Lyv;
        k.g(paramc, "signature.getter");
        paramah = paramm.getString(paramc.Lyq);
        this.string = paramah;
        AppMethodBeat.o(56295);
        return;
      }
      paramah = i.Lzg;
      paramm = i.a(this.KVM, this.KVO, this.KVP);
      if (paramm == null)
      {
        paramah = (Throwable)new x("No field signature for property: " + this.KVL);
        AppMethodBeat.o(56295);
        throw paramah;
      }
      paramah = paramm.name;
      paramc = paramm.desc;
      paramc1 = new StringBuilder().append(o.aWm(paramah));
      paramah = this.KVL.fPU();
      k.g(paramah, "descriptor.containingDeclaration");
      if ((k.g(this.KVL.fQb(), az.Lel)) && ((paramah instanceof e)))
      {
        paramah = (i.c)((e)paramah).LHz;
        paramm = a.Lyk;
        k.g(paramm, "JvmProtoBuf.classModuleName");
        paramah = (Integer)d.l.b.a.b.e.b.f.a(paramah, paramm);
        if (paramah != null)
        {
          paramm = this.KVO.getString(((Number)paramah).intValue());
          paramah = paramm;
          if (paramm != null) {}
        }
        else
        {
          paramah = "main";
        }
        paramah = "$" + g.aWF(paramah);
      }
      for (;;)
      {
        paramah = paramah + "()" + paramc;
        break;
        if ((k.g(this.KVL.fQb(), az.Lei)) && ((paramah instanceof ab)))
        {
          paramah = this.KVL;
          if (paramah == null)
          {
            paramah = new v("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
            AppMethodBeat.o(56295);
            throw paramah;
          }
          paramah = ((d.l.b.a.b.k.a.b.j)paramah).LIa;
          if (((paramah instanceof d.l.b.a.b.d.b.j)) && (((d.l.b.a.b.d.b.j)paramah).LrX != null))
          {
            paramah = "$" + ((d.l.b.a.b.d.b.j)paramah).fUJ().rf();
            continue;
          }
        }
        paramah = "";
      }
    }
    
    public final String rf()
    {
      return this.string;
    }
  }
  
  @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "setterSignature", "(Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;)V", "getGetterSignature", "()Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "getSetterSignature", "asString", "", "kotlin-reflection"})
  public static final class d
    extends d
  {
    final c.e KVQ;
    final c.e KVR;
    
    public d(c.e parame1, c.e parame2)
    {
      super();
      AppMethodBeat.i(56296);
      this.KVQ = parame1;
      this.KVR = parame2;
      AppMethodBeat.o(56296);
    }
    
    public final String rf()
    {
      return this.KVQ.KVH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.d
 * JD-Core Version:    0.7.0.1
 */