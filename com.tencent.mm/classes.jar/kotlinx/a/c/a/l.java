package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.a.c;
import kotlinx.a.c.a;
import kotlinx.a.c.m;
import kotlinx.a.d.b;
import kotlinx.a.h;
import kotlinx.a.z;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/internal/StreamingJsonInput;", "Lkotlinx/serialization/json/JsonInput;", "Lkotlinx/serialization/builtins/AbstractDecoder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "reader", "Lkotlinx/serialization/json/internal/JsonReader;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;Lkotlinx/serialization/json/internal/JsonReader;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "currentIndex", "", "getJson", "()Lkotlinx/serialization/json/Json;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "updateMode$annotations", "()V", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "Lkotlinx/serialization/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "decodeBoolean", "", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeElementIndex", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeInt", "decodeJson", "Lkotlinx/serialization/json/JsonElement;", "decodeListIndex", "tokenClass", "decodeLong", "", "decodeMapIndex", "decodeNotNullMark", "decodeNull", "", "decodeObjectIndex", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeShort", "", "decodeString", "", "endStructure", "", "parse", "type", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public final class l
  extends kotlinx.a.a.a
  implements m
{
  private final kotlinx.a.c.d NNe;
  private final kotlinx.a.c.a NOb;
  public final f NOg;
  private final b NOo;
  private final r NOp;
  private int currentIndex;
  
  public l(kotlinx.a.c.a parama, r paramr, f paramf)
  {
    AppMethodBeat.i(191383);
    this.NOb = parama;
    this.NOp = paramr;
    this.NOg = paramf;
    this.NOo = this.NOb.NNd;
    this.currentIndex = -1;
    this.NNe = this.NOb.NNe;
    AppMethodBeat.o(191383);
  }
  
  public final <T> T a(kotlinx.a.f<T> paramf)
  {
    AppMethodBeat.i(191369);
    d.g.b.p.h(paramf, "deserializer");
    paramf = k.a(this, paramf);
    AppMethodBeat.o(191369);
    return paramf;
  }
  
  public final <T> T a(kotlinx.a.f<T> paramf, T paramT)
  {
    AppMethodBeat.i(191385);
    d.g.b.p.h(paramf, "deserializer");
    d.g.b.p.h(paramf, "deserializer");
    paramf = c.a.a((c)this, paramf, paramT);
    AppMethodBeat.o(191385);
    return paramf;
  }
  
  public final kotlinx.a.a a(kotlinx.a.n paramn, h<?>... paramVarArgs)
  {
    AppMethodBeat.i(191370);
    d.g.b.p.h(paramn, "descriptor");
    d.g.b.p.h(paramVarArgs, "typeParams");
    paramVarArgs = s.a(this.NOb, paramn);
    if (paramVarArgs.NOD != 0)
    {
      f localf = this.NOg;
      int i = paramVarArgs.NOB;
      if (localf.NOi != i)
      {
        localf.hw("Expected '" + paramVarArgs.NOD + ", kind: " + paramn.gwR() + '\'', localf.NOj);
        AppMethodBeat.o(191370);
        throw null;
      }
      this.NOg.gxt();
    }
    switch (m.cpQ[paramVarArgs.ordinal()])
    {
    default: 
      if (this.NOp == paramVarArgs) {
        paramn = this;
      }
      break;
    }
    for (;;)
    {
      paramn = (kotlinx.a.a)paramn;
      AppMethodBeat.o(191370);
      return paramn;
      paramn = new l(this.NOb, paramVarArgs, this.NOg);
      continue;
      paramn = new l(this.NOb, paramVarArgs, this.NOg);
    }
  }
  
  public final void a(kotlinx.a.n paramn)
  {
    AppMethodBeat.i(191371);
    d.g.b.p.h(paramn, "descriptor");
    if (this.NOp.NOE != 0)
    {
      paramn = this.NOg;
      int i = this.NOp.NOC;
      if (paramn.NOi != i)
      {
        paramn.hw("Expected '" + this.NOp.NOE + '\'', paramn.NOj);
        AppMethodBeat.o(191371);
        throw null;
      }
      this.NOg.gxt();
    }
    AppMethodBeat.o(191371);
  }
  
  public final int b(kotlinx.a.n paramn)
  {
    int k = 1;
    int j = 1;
    AppMethodBeat.i(191373);
    d.g.b.p.h(paramn, "descriptor");
    int m = this.NOg.NOi;
    int i;
    if (m == 4)
    {
      localObject = this.NOg;
      if (this.currentIndex != -1) {}
      for (i = 1;; i = 0)
      {
        int n = this.NOg.vty;
        if (i != 0) {
          break;
        }
        ((f)localObject).hw("Unexpected leading comma", n);
        AppMethodBeat.o(191373);
        throw null;
      }
      this.NOg.gxt();
    }
    Object localObject = this.NOp;
    switch (m.gnp[localObject.ordinal()])
    {
    default: 
      if ((m == 4) && (!this.NOg.gxp()))
      {
        f.a(this.NOg, "Unexpected trailing comma");
        AppMethodBeat.o(191373);
        throw null;
      }
      break;
    case 1: 
      if ((m != 4) && (this.currentIndex != -1))
      {
        paramn = this.NOg;
        if (paramn.NOi != 9)
        {
          paramn.hw("Expected end of the array or comma", paramn.NOj);
          AppMethodBeat.o(191373);
          throw null;
        }
      }
      if (!this.NOg.gxp())
      {
        paramn = this.NOg;
        if (m != 4) {}
        for (i = j;; i = 0)
        {
          j = paramn.vty;
          if (i != 0) {
            break;
          }
          paramn.hw("Unexpected trailing comma", j);
          AppMethodBeat.o(191373);
          throw null;
        }
        AppMethodBeat.o(191373);
        return -1;
      }
      this.currentIndex += 1;
      i = this.currentIndex;
      AppMethodBeat.o(191373);
      return i;
    case 2: 
      if ((m != 4) && (this.currentIndex % 2 == 1))
      {
        paramn = this.NOg;
        if (paramn.NOi != 7)
        {
          paramn.hw("Expected end of the object or comma", paramn.NOj);
          AppMethodBeat.o(191373);
          throw null;
        }
      }
      if (this.currentIndex % 2 == 0)
      {
        paramn = this.NOg;
        if (paramn.NOi != 5)
        {
          paramn.hw("Expected ':' after the key", paramn.NOj);
          AppMethodBeat.o(191373);
          throw null;
        }
        this.NOg.gxt();
      }
      if (!this.NOg.gxp())
      {
        paramn = this.NOg;
        if (m != 4) {}
        for (i = k;; i = 0)
        {
          j = paramn.vty;
          if (i != 0) {
            break;
          }
          paramn.hw("Unexpected trailing comma", j);
          AppMethodBeat.o(191373);
          throw null;
        }
        AppMethodBeat.o(191373);
        return -1;
      }
      this.currentIndex += 1;
      i = this.currentIndex;
      AppMethodBeat.o(191373);
      return i;
    case 3: 
      this.currentIndex += 1;
      switch (this.currentIndex)
      {
      default: 
        AppMethodBeat.o(191373);
        return -1;
      case 0: 
        AppMethodBeat.o(191373);
        return 0;
      }
      AppMethodBeat.o(191373);
      return 1;
    }
    while (this.NOg.gxp())
    {
      this.currentIndex += 1;
      localObject = gwN();
      f localf = this.NOg;
      if (localf.NOi != 5)
      {
        localf.hw("Expected ':'", localf.NOj);
        AppMethodBeat.o(191373);
        throw null;
      }
      this.NOg.gxt();
      i = paramn.bdm((String)localObject);
      if (i != -3)
      {
        AppMethodBeat.o(191373);
        return i;
      }
      if (!this.NNe.NNq)
      {
        f.a(this.NOg, "Encountered an unknown key '" + (String)localObject + "'. You can enable 'JsonConfiguration.ignoreUnknownKeys' property to ignore unknown keys");
        AppMethodBeat.o(191373);
        throw null;
      }
      this.NOg.gxu();
      if (this.NOg.NOi == 4)
      {
        this.NOg.gxt();
        localObject = this.NOg;
        boolean bool = this.NOg.gxp();
        i = this.NOg.vty;
        if (!bool)
        {
          ((f)localObject).hw("Unexpected trailing comma", i);
          AppMethodBeat.o(191373);
          throw null;
        }
      }
    }
    AppMethodBeat.o(191373);
    return -1;
  }
  
  public final <T> T b(kotlinx.a.f<T> paramf)
  {
    AppMethodBeat.i(191384);
    d.g.b.p.h(paramf, "deserializer");
    d.g.b.p.h(paramf, "deserializer");
    paramf = c.a.b((c)this, paramf);
    AppMethodBeat.o(191384);
    return paramf;
  }
  
  public final <T> T b(kotlinx.a.f<T> paramf, T paramT)
  {
    AppMethodBeat.i(191386);
    d.g.b.p.h(paramf, "deserializer");
    d.g.b.p.h(paramf, "deserializer");
    paramf = c.a.b((c)this, paramf, paramT);
    AppMethodBeat.o(191386);
    return paramf;
  }
  
  public final b gwB()
  {
    return this.NOo;
  }
  
  public final z gwC()
  {
    return this.NNe.NMc;
  }
  
  public final boolean gwD()
  {
    return this.NOg.NOi != 10;
  }
  
  public final Void gwE()
  {
    AppMethodBeat.i(191372);
    f localf = this.NOg;
    if (localf.NOi != 10)
    {
      localf.hw("Expected 'null' literal", localf.NOj);
      AppMethodBeat.o(191372);
      throw null;
    }
    this.NOg.gxt();
    AppMethodBeat.o(191372);
    return null;
  }
  
  public final boolean gwF()
  {
    AppMethodBeat.i(191374);
    if (this.NNe.NNr)
    {
      bool = p.bdy(this.NOg.gxq());
      AppMethodBeat.o(191374);
      return bool;
    }
    f localf = this.NOg;
    if (localf.NOi != 0)
    {
      localf.hw("Expected start of the unquoted boolean literal. Use 'JsonConfiguration.isLenient = true' to accept non-compliant JSON", localf.NOj);
      AppMethodBeat.o(191374);
      throw null;
    }
    boolean bool = p.bdy(localf.gxs());
    AppMethodBeat.o(191374);
    return bool;
  }
  
  public final byte gwG()
  {
    AppMethodBeat.i(191375);
    String str = this.NOg.gxq();
    try
    {
      byte b = Byte.parseByte(str);
      AppMethodBeat.o(191375);
      return b;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.NOg, "Failed to parse '" + "byte" + '\'');
      AppMethodBeat.o(191375);
      throw null;
    }
  }
  
  public final short gwH()
  {
    AppMethodBeat.i(191376);
    String str = this.NOg.gxq();
    try
    {
      short s = Short.parseShort(str);
      AppMethodBeat.o(191376);
      return s;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.NOg, "Failed to parse '" + "short" + '\'');
      AppMethodBeat.o(191376);
      throw null;
    }
  }
  
  public final char gwI()
  {
    AppMethodBeat.i(191381);
    String str = this.NOg.gxq();
    try
    {
      char c = d.n.n.aM((CharSequence)str);
      AppMethodBeat.o(191381);
      return c;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.NOg, "Failed to parse '" + "char" + '\'');
      AppMethodBeat.o(191381);
      throw null;
    }
  }
  
  public final int gwJ()
  {
    AppMethodBeat.i(191377);
    String str = this.NOg.gxq();
    try
    {
      int i = Integer.parseInt(str);
      AppMethodBeat.o(191377);
      return i;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.NOg, "Failed to parse '" + "int" + '\'');
      AppMethodBeat.o(191377);
      throw null;
    }
  }
  
  public final long gwK()
  {
    AppMethodBeat.i(191378);
    String str = this.NOg.gxq();
    try
    {
      long l = Long.parseLong(str);
      AppMethodBeat.o(191378);
      return l;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.NOg, "Failed to parse '" + "long" + '\'');
      AppMethodBeat.o(191378);
      throw null;
    }
  }
  
  public final float gwL()
  {
    AppMethodBeat.i(191379);
    String str = this.NOg.gxq();
    try
    {
      float f = Float.parseFloat(str);
      AppMethodBeat.o(191379);
      return f;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.NOg, "Failed to parse '" + "float" + '\'');
      AppMethodBeat.o(191379);
      throw null;
    }
  }
  
  public final double gwM()
  {
    AppMethodBeat.i(191380);
    String str = this.NOg.gxq();
    try
    {
      double d = Double.parseDouble(str);
      AppMethodBeat.o(191380);
      return d;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.NOg, "Failed to parse '" + "double" + '\'');
      AppMethodBeat.o(191380);
      throw null;
    }
  }
  
  public final String gwN()
  {
    AppMethodBeat.i(191382);
    if (this.NNe.NNr)
    {
      str = this.NOg.gxq();
      AppMethodBeat.o(191382);
      return str;
    }
    String str = this.NOg.gxr();
    AppMethodBeat.o(191382);
    return str;
  }
  
  public final kotlinx.a.c.a gxh()
  {
    return this.NOb;
  }
  
  public final kotlinx.a.c.f gxi()
  {
    AppMethodBeat.i(191368);
    kotlinx.a.c.f localf = new d(this.NOb.NNe, this.NOg).gxo();
    AppMethodBeat.o(191368);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.l
 * JD-Core Version:    0.7.0.1
 */