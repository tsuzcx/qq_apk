package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/Decoder;", "", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "Lkotlinx/serialization/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "decodeBoolean", "", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeEnum", "", "enumDescriptor", "decodeFloat", "", "decodeInt", "decodeLong", "", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableValue", "decodeShort", "", "decodeString", "", "decodeUnit", "", "updateNullableSerializableValue", "old", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "updateSerializableValue", "kotlinx-serialization-runtime"})
public abstract interface c
{
  public abstract <T> T a(f<T> paramf);
  
  public abstract <T> T a(f<T> paramf, T paramT);
  
  public abstract a a(n paramn, h<?>... paramVarArgs);
  
  public abstract <T> T b(f<T> paramf);
  
  public abstract z hOl();
  
  public abstract boolean hOm();
  
  public abstract Void hOn();
  
  public abstract boolean hOo();
  
  public abstract byte hOp();
  
  public abstract short hOq();
  
  public abstract char hOr();
  
  public abstract int hOs();
  
  public abstract long hOt();
  
  public abstract float hOu();
  
  public abstract double hOv();
  
  public abstract String hOw();
  
  @l(hxD={1, 1, 16})
  public static final class a
  {
    public static <T> T a(c paramc, f<T> paramf)
    {
      AppMethodBeat.i(225375);
      p.h(paramf, "deserializer");
      paramc = paramf.a(paramc);
      AppMethodBeat.o(225375);
      return paramc;
    }
    
    public static <T> T a(c paramc, f<T> paramf, T paramT)
    {
      AppMethodBeat.i(225377);
      p.h(paramf, "deserializer");
      z localz = paramc.hOl();
      switch (d.$EnumSwitchMapping$0[localz.ordinal()])
      {
      default: 
        paramc = new m();
        AppMethodBeat.o(225377);
        throw paramc;
      case 1: 
        paramc = (Throwable)new aa(paramf.fWv().hOz());
        AppMethodBeat.o(225377);
        throw paramc;
      case 2: 
        paramc = paramc.a(paramf);
        AppMethodBeat.o(225377);
        return paramc;
      }
      paramc = paramf.a(paramc, paramT);
      AppMethodBeat.o(225377);
      return paramc;
    }
    
    public static <T> T b(c paramc, f<T> paramf)
    {
      AppMethodBeat.i(225376);
      p.h(paramf, "deserializer");
      if (paramc.hOm())
      {
        paramc = paramc.a(paramf);
        AppMethodBeat.o(225376);
        return paramc;
      }
      paramc = paramc.hOn();
      AppMethodBeat.o(225376);
      return paramc;
    }
    
    public static <T> T b(c paramc, f<T> paramf, T paramT)
    {
      AppMethodBeat.i(225378);
      p.h(paramf, "deserializer");
      if (paramc.hOl() == z.TYa)
      {
        paramc = (Throwable)new aa(paramf.fWv().hOz());
        AppMethodBeat.o(225378);
        throw paramc;
      }
      if ((paramc.hOl() == z.TYb) || (paramT == null))
      {
        paramc = paramc.b(paramf);
        AppMethodBeat.o(225378);
        return paramc;
      }
      if (paramc.hOm())
      {
        paramc = paramf.a(paramc, paramT);
        AppMethodBeat.o(225378);
        return paramc;
      }
      paramc.hOn();
      AppMethodBeat.o(225378);
      return paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c
 * JD-Core Version:    0.7.0.1
 */