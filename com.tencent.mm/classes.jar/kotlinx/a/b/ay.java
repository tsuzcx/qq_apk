package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import kotlinx.a.n;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/PrimitiveSerialDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/PrimitiveKind;", "(Ljava/lang/String;Lkotlinx/serialization/PrimitiveKind;)V", "elementsCount", "", "getElementsCount", "()I", "getKind", "()Lkotlinx/serialization/PrimitiveKind;", "getSerialName", "()Ljava/lang/String;", "error", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "", "toString", "kotlinx-serialization-runtime"})
public final class ay
  implements n
{
  private final String NLG;
  private final kotlinx.a.l NMO;
  
  public ay(String paramString, kotlinx.a.l paraml)
  {
    AppMethodBeat.i(191098);
    this.NLG = paramString;
    this.NMO = paraml;
    AppMethodBeat.o(191098);
  }
  
  private static Void gwY()
  {
    AppMethodBeat.i(191097);
    Throwable localThrowable = (Throwable)new IllegalStateException("Primitive descriptor does not have elements");
    AppMethodBeat.o(191097);
    throw localThrowable;
  }
  
  public final String alJ(int paramInt)
  {
    AppMethodBeat.i(191093);
    gwY();
    AppMethodBeat.o(191093);
    throw null;
  }
  
  public final n alK(int paramInt)
  {
    AppMethodBeat.i(191095);
    gwY();
    AppMethodBeat.o(191095);
    throw null;
  }
  
  public final int bdm(String paramString)
  {
    AppMethodBeat.i(191094);
    p.h(paramString, "name");
    gwY();
    AppMethodBeat.o(191094);
    throw null;
  }
  
  public final String gwQ()
  {
    return this.NLG;
  }
  
  public final boolean gwS()
  {
    return false;
  }
  
  public final int gwT()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191096);
    String str = "PrimitiveDescriptor(" + this.NLG + ')';
    AppMethodBeat.o(191096);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.ay
 * JD-Core Version:    0.7.0.1
 */