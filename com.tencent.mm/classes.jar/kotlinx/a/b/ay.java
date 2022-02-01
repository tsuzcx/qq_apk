package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import kotlinx.a.n;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/PrimitiveSerialDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/PrimitiveKind;", "(Ljava/lang/String;Lkotlinx/serialization/PrimitiveKind;)V", "elementsCount", "", "getElementsCount", "()I", "getKind", "()Lkotlinx/serialization/PrimitiveKind;", "getSerialName", "()Ljava/lang/String;", "error", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "", "toString", "kotlinx-serialization-runtime"})
public final class ay
  implements n
{
  private final String OiM;
  private final kotlinx.a.l OjU;
  
  public ay(String paramString, kotlinx.a.l paraml)
  {
    AppMethodBeat.i(199686);
    this.OiM = paramString;
    this.OjU = paraml;
    AppMethodBeat.o(199686);
  }
  
  private static Void gBA()
  {
    AppMethodBeat.i(199685);
    Throwable localThrowable = (Throwable)new IllegalStateException("Primitive descriptor does not have elements");
    AppMethodBeat.o(199685);
    throw localThrowable;
  }
  
  public final String amt(int paramInt)
  {
    AppMethodBeat.i(199681);
    gBA();
    AppMethodBeat.o(199681);
    throw null;
  }
  
  public final n amu(int paramInt)
  {
    AppMethodBeat.i(199683);
    gBA();
    AppMethodBeat.o(199683);
    throw null;
  }
  
  public final int beQ(String paramString)
  {
    AppMethodBeat.i(199682);
    p.h(paramString, "name");
    gBA();
    AppMethodBeat.o(199682);
    throw null;
  }
  
  public final String gBs()
  {
    return this.OiM;
  }
  
  public final boolean gBu()
  {
    return false;
  }
  
  public final int gBv()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199684);
    String str = "PrimitiveDescriptor(" + this.OiM + ')';
    AppMethodBeat.o(199684);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.ay
 * JD-Core Version:    0.7.0.1
 */