package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlinx.a.n;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/PrimitiveSerialDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/PrimitiveKind;", "(Ljava/lang/String;Lkotlinx/serialization/PrimitiveKind;)V", "elementsCount", "", "getElementsCount", "()I", "getKind", "()Lkotlinx/serialization/PrimitiveKind;", "getSerialName", "()Ljava/lang/String;", "error", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "", "toString", "kotlinx-serialization-runtime"})
public final class ay
  implements n
{
  private final String TXI;
  private final kotlinx.a.l TYP;
  
  public ay(String paramString, kotlinx.a.l paraml)
  {
    AppMethodBeat.i(225458);
    this.TXI = paramString;
    this.TYP = paraml;
    AppMethodBeat.o(225458);
  }
  
  private static Void hOH()
  {
    AppMethodBeat.i(225457);
    Throwable localThrowable = (Throwable)new IllegalStateException("Primitive descriptor does not have elements");
    AppMethodBeat.o(225457);
    throw localThrowable;
  }
  
  public final String awc(int paramInt)
  {
    AppMethodBeat.i(225453);
    hOH();
    AppMethodBeat.o(225453);
    throw null;
  }
  
  public final n awd(int paramInt)
  {
    AppMethodBeat.i(225455);
    hOH();
    AppMethodBeat.o(225455);
    throw null;
  }
  
  public final int buF(String paramString)
  {
    AppMethodBeat.i(225454);
    p.h(paramString, "name");
    hOH();
    AppMethodBeat.o(225454);
    throw null;
  }
  
  public final boolean hOB()
  {
    return false;
  }
  
  public final int hOC()
  {
    return 0;
  }
  
  public final String hOz()
  {
    return this.TXI;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(225456);
    String str = "PrimitiveDescriptor(" + this.TXI + ')';
    AppMethodBeat.o(225456);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.b.ay
 * JD-Core Version:    0.7.0.1
 */