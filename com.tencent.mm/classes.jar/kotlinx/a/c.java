package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/Decoder;", "", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "Lkotlinx/serialization/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "decodeBoolean", "", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeEnum", "", "enumDescriptor", "decodeFloat", "", "decodeInt", "decodeLong", "", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableValue", "decodeShort", "", "decodeString", "", "decodeUnit", "", "updateNullableSerializableValue", "old", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "updateSerializableValue", "kotlinx-serialization-runtime"})
public abstract interface c
{
  public abstract <T> T a(f<T> paramf);
  
  public abstract <T> T a(f<T> paramf, T paramT);
  
  public abstract a a(n paramn, h<?>... paramVarArgs);
  
  public abstract <T> T b(f<T> paramf);
  
  public abstract float iTA();
  
  public abstract double iTB();
  
  public abstract String iTC();
  
  public abstract z iTr();
  
  public abstract boolean iTs();
  
  public abstract Void iTt();
  
  public abstract boolean iTu();
  
  public abstract byte iTv();
  
  public abstract short iTw();
  
  public abstract char iTx();
  
  public abstract int iTy();
  
  public abstract long iTz();
  
  @l(iBK={1, 1, 16})
  public static final class a
  {
    public static <T> T a(c paramc, f<T> paramf)
    {
      AppMethodBeat.i(254192);
      p.k(paramf, "deserializer");
      paramc = paramf.a(paramc);
      AppMethodBeat.o(254192);
      return paramc;
    }
    
    public static <T> T a(c paramc, f<T> paramf, T paramT)
    {
      AppMethodBeat.i(254196);
      p.k(paramf, "deserializer");
      z localz = paramc.iTr();
      switch (d.$EnumSwitchMapping$0[localz.ordinal()])
      {
      default: 
        paramc = new m();
        AppMethodBeat.o(254196);
        throw paramc;
      case 1: 
        paramc = (Throwable)new aa(paramf.gPe().iTF());
        AppMethodBeat.o(254196);
        throw paramc;
      case 2: 
        paramc = paramc.a(paramf);
        AppMethodBeat.o(254196);
        return paramc;
      }
      paramc = paramf.a(paramc, paramT);
      AppMethodBeat.o(254196);
      return paramc;
    }
    
    public static <T> T b(c paramc, f<T> paramf)
    {
      AppMethodBeat.i(254194);
      p.k(paramf, "deserializer");
      if (paramc.iTs())
      {
        paramc = paramc.a(paramf);
        AppMethodBeat.o(254194);
        return paramc;
      }
      paramc = paramc.iTt();
      AppMethodBeat.o(254194);
      return paramc;
    }
    
    public static <T> T b(c paramc, f<T> paramf, T paramT)
    {
      AppMethodBeat.i(254197);
      p.k(paramf, "deserializer");
      if (paramc.iTr() == z.abBp)
      {
        paramc = (Throwable)new aa(paramf.gPe().iTF());
        AppMethodBeat.o(254197);
        throw paramc;
      }
      if ((paramc.iTr() == z.abBq) || (paramT == null))
      {
        paramc = paramc.b(paramf);
        AppMethodBeat.o(254197);
        return paramc;
      }
      if (paramc.iTs())
      {
        paramc = paramf.a(paramc, paramT);
        AppMethodBeat.o(254197);
        return paramc;
      }
      paramc.iTt();
      AppMethodBeat.o(254197);
      return paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c
 * JD-Core Version:    0.7.0.1
 */