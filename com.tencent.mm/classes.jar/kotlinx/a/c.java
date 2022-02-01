package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.m;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/Decoder;", "", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "Lkotlinx/serialization/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "decodeBoolean", "", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeEnum", "", "enumDescriptor", "decodeFloat", "", "decodeInt", "decodeLong", "", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableValue", "decodeShort", "", "decodeString", "", "decodeUnit", "", "updateNullableSerializableValue", "old", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "updateSerializableValue", "kotlinx-serialization-runtime"})
public abstract interface c
{
  public abstract <T> T a(f<T> paramf);
  
  public abstract <T> T a(f<T> paramf, T paramT);
  
  public abstract a a(n paramn, h<?>... paramVarArgs);
  
  public abstract <T> T b(f<T> paramf);
  
  public abstract z gwC();
  
  public abstract boolean gwD();
  
  public abstract Void gwE();
  
  public abstract boolean gwF();
  
  public abstract byte gwG();
  
  public abstract short gwH();
  
  public abstract char gwI();
  
  public abstract int gwJ();
  
  public abstract long gwK();
  
  public abstract float gwL();
  
  public abstract double gwM();
  
  public abstract String gwN();
  
  @l(gfx={1, 1, 16})
  public static final class a
  {
    public static <T> T a(c paramc, f<T> paramf)
    {
      AppMethodBeat.i(191015);
      p.h(paramf, "deserializer");
      paramc = paramf.a(paramc);
      AppMethodBeat.o(191015);
      return paramc;
    }
    
    public static <T> T a(c paramc, f<T> paramf, T paramT)
    {
      AppMethodBeat.i(191017);
      p.h(paramf, "deserializer");
      z localz = paramc.gwC();
      switch (d.cpQ[localz.ordinal()])
      {
      default: 
        paramc = new m();
        AppMethodBeat.o(191017);
        throw paramc;
      case 1: 
        paramc = (Throwable)new aa(paramf.eLj().gwQ());
        AppMethodBeat.o(191017);
        throw paramc;
      case 2: 
        paramc = paramc.a(paramf);
        AppMethodBeat.o(191017);
        return paramc;
      }
      paramc = paramf.a(paramc, paramT);
      AppMethodBeat.o(191017);
      return paramc;
    }
    
    public static <T> T b(c paramc, f<T> paramf)
    {
      AppMethodBeat.i(191016);
      p.h(paramf, "deserializer");
      if (paramc.gwD())
      {
        paramc = paramc.a(paramf);
        AppMethodBeat.o(191016);
        return paramc;
      }
      paramc = paramc.gwE();
      AppMethodBeat.o(191016);
      return paramc;
    }
    
    public static <T> T b(c paramc, f<T> paramf, T paramT)
    {
      AppMethodBeat.i(191018);
      p.h(paramf, "deserializer");
      if (paramc.gwC() == z.NLY)
      {
        paramc = (Throwable)new aa(paramf.eLj().gwQ());
        AppMethodBeat.o(191018);
        throw paramc;
      }
      if ((paramc.gwC() == z.NLZ) || (paramT == null))
      {
        paramc = paramc.b(paramf);
        AppMethodBeat.o(191018);
        return paramc;
      }
      if (paramc.gwD())
      {
        paramc = paramf.a(paramc, paramT);
        AppMethodBeat.o(191018);
        return paramc;
      }
      paramc.gwE();
      AppMethodBeat.o(191018);
      return paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c
 * JD-Core Version:    0.7.0.1
 */