package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.m;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/Decoder;", "", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "Lkotlinx/serialization/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "decodeBoolean", "", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeEnum", "", "enumDescriptor", "decodeFloat", "", "decodeInt", "decodeLong", "", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableValue", "decodeShort", "", "decodeString", "", "decodeUnit", "", "updateNullableSerializableValue", "old", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "updateSerializableValue", "kotlinx-serialization-runtime"})
public abstract interface c
{
  public abstract <T> T a(f<T> paramf);
  
  public abstract <T> T a(f<T> paramf, T paramT);
  
  public abstract a a(n paramn, h<?>... paramVarArgs);
  
  public abstract <T> T b(f<T> paramf);
  
  public abstract z gBe();
  
  public abstract boolean gBf();
  
  public abstract Void gBg();
  
  public abstract boolean gBh();
  
  public abstract byte gBi();
  
  public abstract short gBj();
  
  public abstract char gBk();
  
  public abstract int gBl();
  
  public abstract long gBm();
  
  public abstract float gBn();
  
  public abstract double gBo();
  
  public abstract String gBp();
  
  @l(gjZ={1, 1, 16})
  public static final class a
  {
    public static <T> T a(c paramc, f<T> paramf)
    {
      AppMethodBeat.i(199603);
      p.h(paramf, "deserializer");
      paramc = paramf.a(paramc);
      AppMethodBeat.o(199603);
      return paramc;
    }
    
    public static <T> T a(c paramc, f<T> paramf, T paramT)
    {
      AppMethodBeat.i(199605);
      p.h(paramf, "deserializer");
      z localz = paramc.gBe();
      switch (d.cqt[localz.ordinal()])
      {
      default: 
        paramc = new m();
        AppMethodBeat.o(199605);
        throw paramc;
      case 1: 
        paramc = (Throwable)new aa(paramf.eOR().gBs());
        AppMethodBeat.o(199605);
        throw paramc;
      case 2: 
        paramc = paramc.a(paramf);
        AppMethodBeat.o(199605);
        return paramc;
      }
      paramc = paramf.a(paramc, paramT);
      AppMethodBeat.o(199605);
      return paramc;
    }
    
    public static <T> T b(c paramc, f<T> paramf)
    {
      AppMethodBeat.i(199604);
      p.h(paramf, "deserializer");
      if (paramc.gBf())
      {
        paramc = paramc.a(paramf);
        AppMethodBeat.o(199604);
        return paramc;
      }
      paramc = paramc.gBg();
      AppMethodBeat.o(199604);
      return paramc;
    }
    
    public static <T> T b(c paramc, f<T> paramf, T paramT)
    {
      AppMethodBeat.i(199606);
      p.h(paramf, "deserializer");
      if (paramc.gBe() == z.Oje)
      {
        paramc = (Throwable)new aa(paramf.eOR().gBs());
        AppMethodBeat.o(199606);
        throw paramc;
      }
      if ((paramc.gBe() == z.Ojf) || (paramT == null))
      {
        paramc = paramc.b(paramf);
        AppMethodBeat.o(199606);
        return paramc;
      }
      if (paramc.gBf())
      {
        paramc = paramf.a(paramc, paramT);
        AppMethodBeat.o(199606);
        return paramc;
      }
      paramc.gBg();
      AppMethodBeat.o(199606);
      return paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c
 * JD-Core Version:    0.7.0.1
 */