package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.a.c;
import kotlinx.a.c.a;
import kotlinx.a.c.m;
import kotlinx.a.d.b;
import kotlinx.a.h;
import kotlinx.a.z;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/internal/StreamingJsonInput;", "Lkotlinx/serialization/json/JsonInput;", "Lkotlinx/serialization/builtins/AbstractDecoder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "reader", "Lkotlinx/serialization/json/internal/JsonReader;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;Lkotlinx/serialization/json/internal/JsonReader;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "currentIndex", "", "getJson", "()Lkotlinx/serialization/json/Json;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "updateMode$annotations", "()V", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "Lkotlinx/serialization/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "decodeBoolean", "", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeElementIndex", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeInt", "decodeJson", "Lkotlinx/serialization/json/JsonElement;", "decodeListIndex", "tokenClass", "decodeLong", "", "decodeMapIndex", "decodeNotNullMark", "decodeNull", "", "decodeObjectIndex", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeShort", "", "decodeString", "", "endStructure", "", "parse", "type", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public final class l
  extends kotlinx.a.a.a
  implements m
{
  private final kotlinx.a.c.d abCv;
  private final b abDF;
  private final r abDG;
  private final kotlinx.a.c.a abDs;
  public final f abDx;
  private int currentIndex;
  
  public l(kotlinx.a.c.a parama, r paramr, f paramf)
  {
    AppMethodBeat.i(256392);
    this.abDs = parama;
    this.abDG = paramr;
    this.abDx = paramf;
    this.abDF = this.abDs.abCu;
    this.currentIndex = -1;
    this.abCv = this.abDs.abCv;
    AppMethodBeat.o(256392);
  }
  
  public final <T> T a(kotlinx.a.f<T> paramf)
  {
    AppMethodBeat.i(256377);
    kotlin.g.b.p.k(paramf, "deserializer");
    paramf = k.a(this, paramf);
    AppMethodBeat.o(256377);
    return paramf;
  }
  
  public final <T> T a(kotlinx.a.f<T> paramf, T paramT)
  {
    AppMethodBeat.i(256394);
    kotlin.g.b.p.k(paramf, "deserializer");
    kotlin.g.b.p.k(paramf, "deserializer");
    paramf = c.a.a((c)this, paramf, paramT);
    AppMethodBeat.o(256394);
    return paramf;
  }
  
  public final kotlinx.a.a a(kotlinx.a.n paramn, h<?>... paramVarArgs)
  {
    AppMethodBeat.i(256379);
    kotlin.g.b.p.k(paramn, "descriptor");
    kotlin.g.b.p.k(paramVarArgs, "typeParams");
    paramVarArgs = s.a(this.abDs, paramn);
    if (paramVarArgs.abDU != 0)
    {
      f localf = this.abDx;
      int i = paramVarArgs.abDS;
      if (localf.abDz != i)
      {
        localf.iK("Expected '" + paramVarArgs.abDU + ", kind: " + paramn.iTG() + '\'', localf.abDA);
        AppMethodBeat.o(256379);
        throw null;
      }
      this.abDx.iUj();
    }
    switch (m.$EnumSwitchMapping$0[paramVarArgs.ordinal()])
    {
    default: 
      if (this.abDG == paramVarArgs) {
        paramn = this;
      }
      break;
    }
    for (;;)
    {
      paramn = (kotlinx.a.a)paramn;
      AppMethodBeat.o(256379);
      return paramn;
      paramn = new l(this.abDs, paramVarArgs, this.abDx);
      continue;
      paramn = new l(this.abDs, paramVarArgs, this.abDx);
    }
  }
  
  public final void a(kotlinx.a.n paramn)
  {
    AppMethodBeat.i(256380);
    kotlin.g.b.p.k(paramn, "descriptor");
    if (this.abDG.abDV != 0)
    {
      paramn = this.abDx;
      int i = this.abDG.abDT;
      if (paramn.abDz != i)
      {
        paramn.iK("Expected '" + this.abDG.abDV + '\'', paramn.abDA);
        AppMethodBeat.o(256380);
        throw null;
      }
      this.abDx.iUj();
    }
    AppMethodBeat.o(256380);
  }
  
  public final int b(kotlinx.a.n paramn)
  {
    int k = 1;
    int j = 1;
    AppMethodBeat.i(256382);
    kotlin.g.b.p.k(paramn, "descriptor");
    int m = this.abDx.abDz;
    int i;
    if (m == 4)
    {
      localObject = this.abDx;
      if (this.currentIndex != -1) {}
      for (i = 1;; i = 0)
      {
        int n = this.abDx.zrB;
        if (i != 0) {
          break;
        }
        ((f)localObject).iK("Unexpected leading comma", n);
        AppMethodBeat.o(256382);
        throw null;
      }
      this.abDx.iUj();
    }
    Object localObject = this.abDG;
    switch (m.jLJ[localObject.ordinal()])
    {
    default: 
      if ((m == 4) && (!this.abDx.iUf()))
      {
        f.a(this.abDx, "Unexpected trailing comma");
        AppMethodBeat.o(256382);
        throw null;
      }
      break;
    case 1: 
      if ((m != 4) && (this.currentIndex != -1))
      {
        paramn = this.abDx;
        if (paramn.abDz != 9)
        {
          paramn.iK("Expected end of the array or comma", paramn.abDA);
          AppMethodBeat.o(256382);
          throw null;
        }
      }
      if (!this.abDx.iUf())
      {
        paramn = this.abDx;
        if (m != 4) {}
        for (i = j;; i = 0)
        {
          j = paramn.zrB;
          if (i != 0) {
            break;
          }
          paramn.iK("Unexpected trailing comma", j);
          AppMethodBeat.o(256382);
          throw null;
        }
        AppMethodBeat.o(256382);
        return -1;
      }
      this.currentIndex += 1;
      i = this.currentIndex;
      AppMethodBeat.o(256382);
      return i;
    case 2: 
      if ((m != 4) && (this.currentIndex % 2 == 1))
      {
        paramn = this.abDx;
        if (paramn.abDz != 7)
        {
          paramn.iK("Expected end of the object or comma", paramn.abDA);
          AppMethodBeat.o(256382);
          throw null;
        }
      }
      if (this.currentIndex % 2 == 0)
      {
        paramn = this.abDx;
        if (paramn.abDz != 5)
        {
          paramn.iK("Expected ':' after the key", paramn.abDA);
          AppMethodBeat.o(256382);
          throw null;
        }
        this.abDx.iUj();
      }
      if (!this.abDx.iUf())
      {
        paramn = this.abDx;
        if (m != 4) {}
        for (i = k;; i = 0)
        {
          j = paramn.zrB;
          if (i != 0) {
            break;
          }
          paramn.iK("Unexpected trailing comma", j);
          AppMethodBeat.o(256382);
          throw null;
        }
        AppMethodBeat.o(256382);
        return -1;
      }
      this.currentIndex += 1;
      i = this.currentIndex;
      AppMethodBeat.o(256382);
      return i;
    case 3: 
      this.currentIndex += 1;
      switch (this.currentIndex)
      {
      default: 
        AppMethodBeat.o(256382);
        return -1;
      case 0: 
        AppMethodBeat.o(256382);
        return 0;
      }
      AppMethodBeat.o(256382);
      return 1;
    }
    while (this.abDx.iUf())
    {
      this.currentIndex += 1;
      localObject = iTC();
      f localf = this.abDx;
      if (localf.abDz != 5)
      {
        localf.iK("Expected ':'", localf.abDA);
        AppMethodBeat.o(256382);
        throw null;
      }
      this.abDx.iUj();
      i = paramn.bHI((String)localObject);
      if (i != -3)
      {
        AppMethodBeat.o(256382);
        return i;
      }
      if (!this.abCv.abCH)
      {
        f.a(this.abDx, "Encountered an unknown key '" + (String)localObject + "'. You can enable 'JsonConfiguration.ignoreUnknownKeys' property to ignore unknown keys");
        AppMethodBeat.o(256382);
        throw null;
      }
      this.abDx.iUk();
      if (this.abDx.abDz == 4)
      {
        this.abDx.iUj();
        localObject = this.abDx;
        boolean bool = this.abDx.iUf();
        i = this.abDx.zrB;
        if (!bool)
        {
          ((f)localObject).iK("Unexpected trailing comma", i);
          AppMethodBeat.o(256382);
          throw null;
        }
      }
    }
    AppMethodBeat.o(256382);
    return -1;
  }
  
  public final <T> T b(kotlinx.a.f<T> paramf)
  {
    AppMethodBeat.i(256393);
    kotlin.g.b.p.k(paramf, "deserializer");
    kotlin.g.b.p.k(paramf, "deserializer");
    paramf = c.a.b((c)this, paramf);
    AppMethodBeat.o(256393);
    return paramf;
  }
  
  public final <T> T b(kotlinx.a.f<T> paramf, T paramT)
  {
    AppMethodBeat.i(256395);
    kotlin.g.b.p.k(paramf, "deserializer");
    kotlin.g.b.p.k(paramf, "deserializer");
    paramf = c.a.b((c)this, paramf, paramT);
    AppMethodBeat.o(256395);
    return paramf;
  }
  
  public final float iTA()
  {
    AppMethodBeat.i(256388);
    String str = this.abDx.iUg();
    try
    {
      float f = Float.parseFloat(str);
      AppMethodBeat.o(256388);
      return f;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.abDx, "Failed to parse '" + "float" + '\'');
      AppMethodBeat.o(256388);
      throw null;
    }
  }
  
  public final double iTB()
  {
    AppMethodBeat.i(256389);
    String str = this.abDx.iUg();
    try
    {
      double d = Double.parseDouble(str);
      AppMethodBeat.o(256389);
      return d;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.abDx, "Failed to parse '" + "double" + '\'');
      AppMethodBeat.o(256389);
      throw null;
    }
  }
  
  public final String iTC()
  {
    AppMethodBeat.i(256391);
    if (this.abCv.abCI)
    {
      str = this.abDx.iUg();
      AppMethodBeat.o(256391);
      return str;
    }
    String str = this.abDx.iUh();
    AppMethodBeat.o(256391);
    return str;
  }
  
  public final kotlinx.a.c.a iTX()
  {
    return this.abDs;
  }
  
  public final kotlinx.a.c.f iTY()
  {
    AppMethodBeat.i(256376);
    kotlinx.a.c.f localf = new d(this.abDs.abCv, this.abDx).iUe();
    AppMethodBeat.o(256376);
    return localf;
  }
  
  public final b iTq()
  {
    return this.abDF;
  }
  
  public final z iTr()
  {
    return this.abCv.abBt;
  }
  
  public final boolean iTs()
  {
    return this.abDx.abDz != 10;
  }
  
  public final Void iTt()
  {
    AppMethodBeat.i(256381);
    f localf = this.abDx;
    if (localf.abDz != 10)
    {
      localf.iK("Expected 'null' literal", localf.abDA);
      AppMethodBeat.o(256381);
      throw null;
    }
    this.abDx.iUj();
    AppMethodBeat.o(256381);
    return null;
  }
  
  public final boolean iTu()
  {
    AppMethodBeat.i(256383);
    if (this.abCv.abCI)
    {
      bool = p.bHU(this.abDx.iUg());
      AppMethodBeat.o(256383);
      return bool;
    }
    f localf = this.abDx;
    if (localf.abDz != 0)
    {
      localf.iK("Expected start of the unquoted boolean literal. Use 'JsonConfiguration.isLenient = true' to accept non-compliant JSON", localf.abDA);
      AppMethodBeat.o(256383);
      throw null;
    }
    boolean bool = p.bHU(localf.iUi());
    AppMethodBeat.o(256383);
    return bool;
  }
  
  public final byte iTv()
  {
    AppMethodBeat.i(256384);
    String str = this.abDx.iUg();
    try
    {
      byte b = Byte.parseByte(str);
      AppMethodBeat.o(256384);
      return b;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.abDx, "Failed to parse '" + "byte" + '\'');
      AppMethodBeat.o(256384);
      throw null;
    }
  }
  
  public final short iTw()
  {
    AppMethodBeat.i(256385);
    String str = this.abDx.iUg();
    try
    {
      short s = Short.parseShort(str);
      AppMethodBeat.o(256385);
      return s;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.abDx, "Failed to parse '" + "short" + '\'');
      AppMethodBeat.o(256385);
      throw null;
    }
  }
  
  public final char iTx()
  {
    AppMethodBeat.i(256390);
    String str = this.abDx.iUg();
    try
    {
      char c = kotlin.n.n.bj((CharSequence)str);
      AppMethodBeat.o(256390);
      return c;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.abDx, "Failed to parse '" + "char" + '\'');
      AppMethodBeat.o(256390);
      throw null;
    }
  }
  
  public final int iTy()
  {
    AppMethodBeat.i(256386);
    String str = this.abDx.iUg();
    try
    {
      int i = Integer.parseInt(str);
      AppMethodBeat.o(256386);
      return i;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.abDx, "Failed to parse '" + "int" + '\'');
      AppMethodBeat.o(256386);
      throw null;
    }
  }
  
  public final long iTz()
  {
    AppMethodBeat.i(256387);
    String str = this.abDx.iUg();
    try
    {
      long l = Long.parseLong(str);
      AppMethodBeat.o(256387);
      return l;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.abDx, "Failed to parse '" + "long" + '\'');
      AppMethodBeat.o(256387);
      throw null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.a.l
 * JD-Core Version:    0.7.0.1
 */