package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.a.c;
import kotlinx.a.c.a;
import kotlinx.a.c.m;
import kotlinx.a.d.b;
import kotlinx.a.h;
import kotlinx.a.z;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/internal/StreamingJsonInput;", "Lkotlinx/serialization/json/JsonInput;", "Lkotlinx/serialization/builtins/AbstractDecoder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "reader", "Lkotlinx/serialization/json/internal/JsonReader;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;Lkotlinx/serialization/json/internal/JsonReader;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "currentIndex", "", "getJson", "()Lkotlinx/serialization/json/Json;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "updateMode$annotations", "()V", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "Lkotlinx/serialization/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "decodeBoolean", "", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeElementIndex", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeInt", "decodeJson", "Lkotlinx/serialization/json/JsonElement;", "decodeListIndex", "tokenClass", "decodeLong", "", "decodeMapIndex", "decodeNotNullMark", "decodeNull", "", "decodeObjectIndex", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeShort", "", "decodeString", "", "endStructure", "", "parse", "type", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public final class l
  extends kotlinx.a.a.a
  implements m
{
  private final kotlinx.a.c.d TZf;
  private final kotlinx.a.c.a Uae;
  public final f Uaj;
  private final b Uar;
  private final r Uas;
  private int currentIndex;
  
  public l(kotlinx.a.c.a parama, r paramr, f paramf)
  {
    AppMethodBeat.i(225743);
    this.Uae = parama;
    this.Uas = paramr;
    this.Uaj = paramf;
    this.Uar = this.Uae.TZe;
    this.currentIndex = -1;
    this.TZf = this.Uae.TZf;
    AppMethodBeat.o(225743);
  }
  
  public final <T> T a(kotlinx.a.f<T> paramf)
  {
    AppMethodBeat.i(225729);
    kotlin.g.b.p.h(paramf, "deserializer");
    paramf = k.a(this, paramf);
    AppMethodBeat.o(225729);
    return paramf;
  }
  
  public final <T> T a(kotlinx.a.f<T> paramf, T paramT)
  {
    AppMethodBeat.i(225745);
    kotlin.g.b.p.h(paramf, "deserializer");
    kotlin.g.b.p.h(paramf, "deserializer");
    paramf = c.a.a((c)this, paramf, paramT);
    AppMethodBeat.o(225745);
    return paramf;
  }
  
  public final kotlinx.a.a a(kotlinx.a.n paramn, h<?>... paramVarArgs)
  {
    AppMethodBeat.i(225730);
    kotlin.g.b.p.h(paramn, "descriptor");
    kotlin.g.b.p.h(paramVarArgs, "typeParams");
    paramVarArgs = s.a(this.Uae, paramn);
    if (paramVarArgs.UaG != 0)
    {
      f localf = this.Uaj;
      int i = paramVarArgs.UaE;
      if (localf.Ual != i)
      {
        localf.ib("Expected '" + paramVarArgs.UaG + ", kind: " + paramn.hOA() + '\'', localf.Uam);
        AppMethodBeat.o(225730);
        throw null;
      }
      this.Uaj.hPc();
    }
    switch (m.$EnumSwitchMapping$0[paramVarArgs.ordinal()])
    {
    default: 
      if (this.Uas == paramVarArgs) {
        paramn = this;
      }
      break;
    }
    for (;;)
    {
      paramn = (kotlinx.a.a)paramn;
      AppMethodBeat.o(225730);
      return paramn;
      paramn = new l(this.Uae, paramVarArgs, this.Uaj);
      continue;
      paramn = new l(this.Uae, paramVarArgs, this.Uaj);
    }
  }
  
  public final void a(kotlinx.a.n paramn)
  {
    AppMethodBeat.i(225731);
    kotlin.g.b.p.h(paramn, "descriptor");
    if (this.Uas.UaH != 0)
    {
      paramn = this.Uaj;
      int i = this.Uas.UaF;
      if (paramn.Ual != i)
      {
        paramn.ib("Expected '" + this.Uas.UaH + '\'', paramn.Uam);
        AppMethodBeat.o(225731);
        throw null;
      }
      this.Uaj.hPc();
    }
    AppMethodBeat.o(225731);
  }
  
  public final int b(kotlinx.a.n paramn)
  {
    int k = 1;
    int j = 1;
    AppMethodBeat.i(225733);
    kotlin.g.b.p.h(paramn, "descriptor");
    int m = this.Uaj.Ual;
    int i;
    if (m == 4)
    {
      localObject = this.Uaj;
      if (this.currentIndex != -1) {}
      for (i = 1;; i = 0)
      {
        int n = this.Uaj.zaD;
        if (i != 0) {
          break;
        }
        ((f)localObject).ib("Unexpected leading comma", n);
        AppMethodBeat.o(225733);
        throw null;
      }
      this.Uaj.hPc();
    }
    Object localObject = this.Uas;
    switch (m.haE[localObject.ordinal()])
    {
    default: 
      if ((m == 4) && (!this.Uaj.hOY()))
      {
        f.a(this.Uaj, "Unexpected trailing comma");
        AppMethodBeat.o(225733);
        throw null;
      }
      break;
    case 1: 
      if ((m != 4) && (this.currentIndex != -1))
      {
        paramn = this.Uaj;
        if (paramn.Ual != 9)
        {
          paramn.ib("Expected end of the array or comma", paramn.Uam);
          AppMethodBeat.o(225733);
          throw null;
        }
      }
      if (!this.Uaj.hOY())
      {
        paramn = this.Uaj;
        if (m != 4) {}
        for (i = j;; i = 0)
        {
          j = paramn.zaD;
          if (i != 0) {
            break;
          }
          paramn.ib("Unexpected trailing comma", j);
          AppMethodBeat.o(225733);
          throw null;
        }
        AppMethodBeat.o(225733);
        return -1;
      }
      this.currentIndex += 1;
      i = this.currentIndex;
      AppMethodBeat.o(225733);
      return i;
    case 2: 
      if ((m != 4) && (this.currentIndex % 2 == 1))
      {
        paramn = this.Uaj;
        if (paramn.Ual != 7)
        {
          paramn.ib("Expected end of the object or comma", paramn.Uam);
          AppMethodBeat.o(225733);
          throw null;
        }
      }
      if (this.currentIndex % 2 == 0)
      {
        paramn = this.Uaj;
        if (paramn.Ual != 5)
        {
          paramn.ib("Expected ':' after the key", paramn.Uam);
          AppMethodBeat.o(225733);
          throw null;
        }
        this.Uaj.hPc();
      }
      if (!this.Uaj.hOY())
      {
        paramn = this.Uaj;
        if (m != 4) {}
        for (i = k;; i = 0)
        {
          j = paramn.zaD;
          if (i != 0) {
            break;
          }
          paramn.ib("Unexpected trailing comma", j);
          AppMethodBeat.o(225733);
          throw null;
        }
        AppMethodBeat.o(225733);
        return -1;
      }
      this.currentIndex += 1;
      i = this.currentIndex;
      AppMethodBeat.o(225733);
      return i;
    case 3: 
      this.currentIndex += 1;
      switch (this.currentIndex)
      {
      default: 
        AppMethodBeat.o(225733);
        return -1;
      case 0: 
        AppMethodBeat.o(225733);
        return 0;
      }
      AppMethodBeat.o(225733);
      return 1;
    }
    while (this.Uaj.hOY())
    {
      this.currentIndex += 1;
      localObject = hOw();
      f localf = this.Uaj;
      if (localf.Ual != 5)
      {
        localf.ib("Expected ':'", localf.Uam);
        AppMethodBeat.o(225733);
        throw null;
      }
      this.Uaj.hPc();
      i = paramn.buF((String)localObject);
      if (i != -3)
      {
        AppMethodBeat.o(225733);
        return i;
      }
      if (!this.TZf.TZr)
      {
        f.a(this.Uaj, "Encountered an unknown key '" + (String)localObject + "'. You can enable 'JsonConfiguration.ignoreUnknownKeys' property to ignore unknown keys");
        AppMethodBeat.o(225733);
        throw null;
      }
      this.Uaj.hPd();
      if (this.Uaj.Ual == 4)
      {
        this.Uaj.hPc();
        localObject = this.Uaj;
        boolean bool = this.Uaj.hOY();
        i = this.Uaj.zaD;
        if (!bool)
        {
          ((f)localObject).ib("Unexpected trailing comma", i);
          AppMethodBeat.o(225733);
          throw null;
        }
      }
    }
    AppMethodBeat.o(225733);
    return -1;
  }
  
  public final <T> T b(kotlinx.a.f<T> paramf)
  {
    AppMethodBeat.i(225744);
    kotlin.g.b.p.h(paramf, "deserializer");
    kotlin.g.b.p.h(paramf, "deserializer");
    paramf = c.a.b((c)this, paramf);
    AppMethodBeat.o(225744);
    return paramf;
  }
  
  public final <T> T b(kotlinx.a.f<T> paramf, T paramT)
  {
    AppMethodBeat.i(225746);
    kotlin.g.b.p.h(paramf, "deserializer");
    kotlin.g.b.p.h(paramf, "deserializer");
    paramf = c.a.b((c)this, paramf, paramT);
    AppMethodBeat.o(225746);
    return paramf;
  }
  
  public final kotlinx.a.c.a hOQ()
  {
    return this.Uae;
  }
  
  public final kotlinx.a.c.f hOR()
  {
    AppMethodBeat.i(225728);
    kotlinx.a.c.f localf = new d(this.Uae.TZf, this.Uaj).hOX();
    AppMethodBeat.o(225728);
    return localf;
  }
  
  public final b hOk()
  {
    return this.Uar;
  }
  
  public final z hOl()
  {
    return this.TZf.TYe;
  }
  
  public final boolean hOm()
  {
    return this.Uaj.Ual != 10;
  }
  
  public final Void hOn()
  {
    AppMethodBeat.i(225732);
    f localf = this.Uaj;
    if (localf.Ual != 10)
    {
      localf.ib("Expected 'null' literal", localf.Uam);
      AppMethodBeat.o(225732);
      throw null;
    }
    this.Uaj.hPc();
    AppMethodBeat.o(225732);
    return null;
  }
  
  public final boolean hOo()
  {
    AppMethodBeat.i(225734);
    if (this.TZf.TZs)
    {
      bool = p.buR(this.Uaj.hOZ());
      AppMethodBeat.o(225734);
      return bool;
    }
    f localf = this.Uaj;
    if (localf.Ual != 0)
    {
      localf.ib("Expected start of the unquoted boolean literal. Use 'JsonConfiguration.isLenient = true' to accept non-compliant JSON", localf.Uam);
      AppMethodBeat.o(225734);
      throw null;
    }
    boolean bool = p.buR(localf.hPb());
    AppMethodBeat.o(225734);
    return bool;
  }
  
  public final byte hOp()
  {
    AppMethodBeat.i(225735);
    String str = this.Uaj.hOZ();
    try
    {
      byte b = Byte.parseByte(str);
      AppMethodBeat.o(225735);
      return b;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.Uaj, "Failed to parse '" + "byte" + '\'');
      AppMethodBeat.o(225735);
      throw null;
    }
  }
  
  public final short hOq()
  {
    AppMethodBeat.i(225736);
    String str = this.Uaj.hOZ();
    try
    {
      short s = Short.parseShort(str);
      AppMethodBeat.o(225736);
      return s;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.Uaj, "Failed to parse '" + "short" + '\'');
      AppMethodBeat.o(225736);
      throw null;
    }
  }
  
  public final char hOr()
  {
    AppMethodBeat.i(225741);
    String str = this.Uaj.hOZ();
    try
    {
      char c = kotlin.n.n.aT((CharSequence)str);
      AppMethodBeat.o(225741);
      return c;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.Uaj, "Failed to parse '" + "char" + '\'');
      AppMethodBeat.o(225741);
      throw null;
    }
  }
  
  public final int hOs()
  {
    AppMethodBeat.i(225737);
    String str = this.Uaj.hOZ();
    try
    {
      int i = Integer.parseInt(str);
      AppMethodBeat.o(225737);
      return i;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.Uaj, "Failed to parse '" + "int" + '\'');
      AppMethodBeat.o(225737);
      throw null;
    }
  }
  
  public final long hOt()
  {
    AppMethodBeat.i(225738);
    String str = this.Uaj.hOZ();
    try
    {
      long l = Long.parseLong(str);
      AppMethodBeat.o(225738);
      return l;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.Uaj, "Failed to parse '" + "long" + '\'');
      AppMethodBeat.o(225738);
      throw null;
    }
  }
  
  public final float hOu()
  {
    AppMethodBeat.i(225739);
    String str = this.Uaj.hOZ();
    try
    {
      float f = Float.parseFloat(str);
      AppMethodBeat.o(225739);
      return f;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.Uaj, "Failed to parse '" + "float" + '\'');
      AppMethodBeat.o(225739);
      throw null;
    }
  }
  
  public final double hOv()
  {
    AppMethodBeat.i(225740);
    String str = this.Uaj.hOZ();
    try
    {
      double d = Double.parseDouble(str);
      AppMethodBeat.o(225740);
      return d;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.Uaj, "Failed to parse '" + "double" + '\'');
      AppMethodBeat.o(225740);
      throw null;
    }
  }
  
  public final String hOw()
  {
    AppMethodBeat.i(225742);
    if (this.TZf.TZs)
    {
      str = this.Uaj.hOZ();
      AppMethodBeat.o(225742);
      return str;
    }
    String str = this.Uaj.hPa();
    AppMethodBeat.o(225742);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.a.l
 * JD-Core Version:    0.7.0.1
 */