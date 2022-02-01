package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.a.c;
import kotlinx.a.c.a;
import kotlinx.a.c.m;
import kotlinx.a.d.b;
import kotlinx.a.h;
import kotlinx.a.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/internal/StreamingJsonInput;", "Lkotlinx/serialization/json/JsonInput;", "Lkotlinx/serialization/builtins/AbstractDecoder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "reader", "Lkotlinx/serialization/json/internal/JsonReader;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;Lkotlinx/serialization/json/internal/JsonReader;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "currentIndex", "", "getJson", "()Lkotlinx/serialization/json/Json;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "updateMode$annotations", "()V", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "Lkotlinx/serialization/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "decodeBoolean", "", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeElementIndex", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeInt", "decodeJson", "Lkotlinx/serialization/json/JsonElement;", "decodeListIndex", "tokenClass", "decodeLong", "", "decodeMapIndex", "decodeNotNullMark", "decodeNull", "", "decodeObjectIndex", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeShort", "", "decodeString", "", "endStructure", "", "parse", "type", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public final class l
  extends kotlinx.a.a.a
  implements m
{
  private final kotlinx.a.c.d Okk;
  private final kotlinx.a.c.a Olh;
  public final f Olm;
  private final b Olu;
  private final r Olv;
  private int currentIndex;
  
  public l(kotlinx.a.c.a parama, r paramr, f paramf)
  {
    AppMethodBeat.i(199971);
    this.Olh = parama;
    this.Olv = paramr;
    this.Olm = paramf;
    this.Olu = this.Olh.Okj;
    this.currentIndex = -1;
    this.Okk = this.Olh.Okk;
    AppMethodBeat.o(199971);
  }
  
  public final <T> T a(kotlinx.a.f<T> paramf)
  {
    AppMethodBeat.i(199957);
    d.g.b.p.h(paramf, "deserializer");
    paramf = k.a(this, paramf);
    AppMethodBeat.o(199957);
    return paramf;
  }
  
  public final <T> T a(kotlinx.a.f<T> paramf, T paramT)
  {
    AppMethodBeat.i(199973);
    d.g.b.p.h(paramf, "deserializer");
    d.g.b.p.h(paramf, "deserializer");
    paramf = c.a.a((c)this, paramf, paramT);
    AppMethodBeat.o(199973);
    return paramf;
  }
  
  public final kotlinx.a.a a(kotlinx.a.n paramn, h<?>... paramVarArgs)
  {
    AppMethodBeat.i(199958);
    d.g.b.p.h(paramn, "descriptor");
    d.g.b.p.h(paramVarArgs, "typeParams");
    paramVarArgs = s.a(this.Olh, paramn);
    if (paramVarArgs.OlJ != 0)
    {
      f localf = this.Olm;
      int i = paramVarArgs.OlH;
      if (localf.Olo != i)
      {
        localf.hF("Expected '" + paramVarArgs.OlJ + ", kind: " + paramn.gBt() + '\'', localf.Olp);
        AppMethodBeat.o(199958);
        throw null;
      }
      this.Olm.gBV();
    }
    switch (m.cqt[paramVarArgs.ordinal()])
    {
    default: 
      if (this.Olv == paramVarArgs) {
        paramn = this;
      }
      break;
    }
    for (;;)
    {
      paramn = (kotlinx.a.a)paramn;
      AppMethodBeat.o(199958);
      return paramn;
      paramn = new l(this.Olh, paramVarArgs, this.Olm);
      continue;
      paramn = new l(this.Olh, paramVarArgs, this.Olm);
    }
  }
  
  public final void a(kotlinx.a.n paramn)
  {
    AppMethodBeat.i(199959);
    d.g.b.p.h(paramn, "descriptor");
    if (this.Olv.OlK != 0)
    {
      paramn = this.Olm;
      int i = this.Olv.OlI;
      if (paramn.Olo != i)
      {
        paramn.hF("Expected '" + this.Olv.OlK + '\'', paramn.Olp);
        AppMethodBeat.o(199959);
        throw null;
      }
      this.Olm.gBV();
    }
    AppMethodBeat.o(199959);
  }
  
  public final int b(kotlinx.a.n paramn)
  {
    int k = 1;
    int j = 1;
    AppMethodBeat.i(199961);
    d.g.b.p.h(paramn, "descriptor");
    int m = this.Olm.Olo;
    int i;
    if (m == 4)
    {
      localObject = this.Olm;
      if (this.currentIndex != -1) {}
      for (i = 1;; i = 0)
      {
        int n = this.Olm.vFD;
        if (i != 0) {
          break;
        }
        ((f)localObject).hF("Unexpected leading comma", n);
        AppMethodBeat.o(199961);
        throw null;
      }
      this.Olm.gBV();
    }
    Object localObject = this.Olv;
    switch (m.gpL[localObject.ordinal()])
    {
    default: 
      if ((m == 4) && (!this.Olm.gBR()))
      {
        f.a(this.Olm, "Unexpected trailing comma");
        AppMethodBeat.o(199961);
        throw null;
      }
      break;
    case 1: 
      if ((m != 4) && (this.currentIndex != -1))
      {
        paramn = this.Olm;
        if (paramn.Olo != 9)
        {
          paramn.hF("Expected end of the array or comma", paramn.Olp);
          AppMethodBeat.o(199961);
          throw null;
        }
      }
      if (!this.Olm.gBR())
      {
        paramn = this.Olm;
        if (m != 4) {}
        for (i = j;; i = 0)
        {
          j = paramn.vFD;
          if (i != 0) {
            break;
          }
          paramn.hF("Unexpected trailing comma", j);
          AppMethodBeat.o(199961);
          throw null;
        }
        AppMethodBeat.o(199961);
        return -1;
      }
      this.currentIndex += 1;
      i = this.currentIndex;
      AppMethodBeat.o(199961);
      return i;
    case 2: 
      if ((m != 4) && (this.currentIndex % 2 == 1))
      {
        paramn = this.Olm;
        if (paramn.Olo != 7)
        {
          paramn.hF("Expected end of the object or comma", paramn.Olp);
          AppMethodBeat.o(199961);
          throw null;
        }
      }
      if (this.currentIndex % 2 == 0)
      {
        paramn = this.Olm;
        if (paramn.Olo != 5)
        {
          paramn.hF("Expected ':' after the key", paramn.Olp);
          AppMethodBeat.o(199961);
          throw null;
        }
        this.Olm.gBV();
      }
      if (!this.Olm.gBR())
      {
        paramn = this.Olm;
        if (m != 4) {}
        for (i = k;; i = 0)
        {
          j = paramn.vFD;
          if (i != 0) {
            break;
          }
          paramn.hF("Unexpected trailing comma", j);
          AppMethodBeat.o(199961);
          throw null;
        }
        AppMethodBeat.o(199961);
        return -1;
      }
      this.currentIndex += 1;
      i = this.currentIndex;
      AppMethodBeat.o(199961);
      return i;
    case 3: 
      this.currentIndex += 1;
      switch (this.currentIndex)
      {
      default: 
        AppMethodBeat.o(199961);
        return -1;
      case 0: 
        AppMethodBeat.o(199961);
        return 0;
      }
      AppMethodBeat.o(199961);
      return 1;
    }
    while (this.Olm.gBR())
    {
      this.currentIndex += 1;
      localObject = gBp();
      f localf = this.Olm;
      if (localf.Olo != 5)
      {
        localf.hF("Expected ':'", localf.Olp);
        AppMethodBeat.o(199961);
        throw null;
      }
      this.Olm.gBV();
      i = paramn.beQ((String)localObject);
      if (i != -3)
      {
        AppMethodBeat.o(199961);
        return i;
      }
      if (!this.Okk.Okw)
      {
        f.a(this.Olm, "Encountered an unknown key '" + (String)localObject + "'. You can enable 'JsonConfiguration.ignoreUnknownKeys' property to ignore unknown keys");
        AppMethodBeat.o(199961);
        throw null;
      }
      this.Olm.gBW();
      if (this.Olm.Olo == 4)
      {
        this.Olm.gBV();
        localObject = this.Olm;
        boolean bool = this.Olm.gBR();
        i = this.Olm.vFD;
        if (!bool)
        {
          ((f)localObject).hF("Unexpected trailing comma", i);
          AppMethodBeat.o(199961);
          throw null;
        }
      }
    }
    AppMethodBeat.o(199961);
    return -1;
  }
  
  public final <T> T b(kotlinx.a.f<T> paramf)
  {
    AppMethodBeat.i(199972);
    d.g.b.p.h(paramf, "deserializer");
    d.g.b.p.h(paramf, "deserializer");
    paramf = c.a.b((c)this, paramf);
    AppMethodBeat.o(199972);
    return paramf;
  }
  
  public final <T> T b(kotlinx.a.f<T> paramf, T paramT)
  {
    AppMethodBeat.i(199974);
    d.g.b.p.h(paramf, "deserializer");
    d.g.b.p.h(paramf, "deserializer");
    paramf = c.a.b((c)this, paramf, paramT);
    AppMethodBeat.o(199974);
    return paramf;
  }
  
  public final kotlinx.a.c.a gBJ()
  {
    return this.Olh;
  }
  
  public final kotlinx.a.c.f gBK()
  {
    AppMethodBeat.i(199956);
    kotlinx.a.c.f localf = new d(this.Olh.Okk, this.Olm).gBQ();
    AppMethodBeat.o(199956);
    return localf;
  }
  
  public final b gBd()
  {
    return this.Olu;
  }
  
  public final z gBe()
  {
    return this.Okk.Oji;
  }
  
  public final boolean gBf()
  {
    return this.Olm.Olo != 10;
  }
  
  public final Void gBg()
  {
    AppMethodBeat.i(199960);
    f localf = this.Olm;
    if (localf.Olo != 10)
    {
      localf.hF("Expected 'null' literal", localf.Olp);
      AppMethodBeat.o(199960);
      throw null;
    }
    this.Olm.gBV();
    AppMethodBeat.o(199960);
    return null;
  }
  
  public final boolean gBh()
  {
    AppMethodBeat.i(199962);
    if (this.Okk.Okx)
    {
      bool = p.bfc(this.Olm.gBS());
      AppMethodBeat.o(199962);
      return bool;
    }
    f localf = this.Olm;
    if (localf.Olo != 0)
    {
      localf.hF("Expected start of the unquoted boolean literal. Use 'JsonConfiguration.isLenient = true' to accept non-compliant JSON", localf.Olp);
      AppMethodBeat.o(199962);
      throw null;
    }
    boolean bool = p.bfc(localf.gBU());
    AppMethodBeat.o(199962);
    return bool;
  }
  
  public final byte gBi()
  {
    AppMethodBeat.i(199963);
    String str = this.Olm.gBS();
    try
    {
      byte b = Byte.parseByte(str);
      AppMethodBeat.o(199963);
      return b;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.Olm, "Failed to parse '" + "byte" + '\'');
      AppMethodBeat.o(199963);
      throw null;
    }
  }
  
  public final short gBj()
  {
    AppMethodBeat.i(199964);
    String str = this.Olm.gBS();
    try
    {
      short s = Short.parseShort(str);
      AppMethodBeat.o(199964);
      return s;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.Olm, "Failed to parse '" + "short" + '\'');
      AppMethodBeat.o(199964);
      throw null;
    }
  }
  
  public final char gBk()
  {
    AppMethodBeat.i(199969);
    String str = this.Olm.gBS();
    try
    {
      char c = d.n.n.aL((CharSequence)str);
      AppMethodBeat.o(199969);
      return c;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.Olm, "Failed to parse '" + "char" + '\'');
      AppMethodBeat.o(199969);
      throw null;
    }
  }
  
  public final int gBl()
  {
    AppMethodBeat.i(199965);
    String str = this.Olm.gBS();
    try
    {
      int i = Integer.parseInt(str);
      AppMethodBeat.o(199965);
      return i;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.Olm, "Failed to parse '" + "int" + '\'');
      AppMethodBeat.o(199965);
      throw null;
    }
  }
  
  public final long gBm()
  {
    AppMethodBeat.i(199966);
    String str = this.Olm.gBS();
    try
    {
      long l = Long.parseLong(str);
      AppMethodBeat.o(199966);
      return l;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.Olm, "Failed to parse '" + "long" + '\'');
      AppMethodBeat.o(199966);
      throw null;
    }
  }
  
  public final float gBn()
  {
    AppMethodBeat.i(199967);
    String str = this.Olm.gBS();
    try
    {
      float f = Float.parseFloat(str);
      AppMethodBeat.o(199967);
      return f;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.Olm, "Failed to parse '" + "float" + '\'');
      AppMethodBeat.o(199967);
      throw null;
    }
  }
  
  public final double gBo()
  {
    AppMethodBeat.i(199968);
    String str = this.Olm.gBS();
    try
    {
      double d = Double.parseDouble(str);
      AppMethodBeat.o(199968);
      return d;
    }
    catch (Throwable localThrowable)
    {
      f.a(this.Olm, "Failed to parse '" + "double" + '\'');
      AppMethodBeat.o(199968);
      throw null;
    }
  }
  
  public final String gBp()
  {
    AppMethodBeat.i(199970);
    if (this.Okk.Okx)
    {
      str = this.Olm.gBS();
      AppMethodBeat.o(199970);
      return str;
    }
    String str = this.Olm.gBT();
    AppMethodBeat.o(199970);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.l
 * JD-Core Version:    0.7.0.1
 */