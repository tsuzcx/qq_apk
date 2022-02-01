package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlinx.a.n;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/PrimitiveSerialDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/PrimitiveKind;", "(Ljava/lang/String;Lkotlinx/serialization/PrimitiveKind;)V", "elementsCount", "", "getElementsCount", "()I", "getKind", "()Lkotlinx/serialization/PrimitiveKind;", "getSerialName", "()Ljava/lang/String;", "error", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "", "toString", "kotlinx-serialization-runtime"})
public final class ay
  implements n
{
  private final String abAX;
  private final kotlinx.a.l abCe;
  
  public ay(String paramString, kotlinx.a.l paraml)
  {
    AppMethodBeat.i(254393);
    this.abAX = paramString;
    this.abCe = paraml;
    AppMethodBeat.o(254393);
  }
  
  private static Void iTO()
  {
    AppMethodBeat.i(254392);
    Throwable localThrowable = (Throwable)new IllegalStateException("Primitive descriptor does not have elements");
    AppMethodBeat.o(254392);
    throw localThrowable;
  }
  
  public final String aFX(int paramInt)
  {
    AppMethodBeat.i(254388);
    iTO();
    AppMethodBeat.o(254388);
    throw null;
  }
  
  public final n aFY(int paramInt)
  {
    AppMethodBeat.i(254390);
    iTO();
    AppMethodBeat.o(254390);
    throw null;
  }
  
  public final int bHI(String paramString)
  {
    AppMethodBeat.i(254389);
    p.k(paramString, "name");
    iTO();
    AppMethodBeat.o(254389);
    throw null;
  }
  
  public final String iTF()
  {
    return this.abAX;
  }
  
  public final boolean iTH()
  {
    return false;
  }
  
  public final int iTI()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(254391);
    String str = "PrimitiveDescriptor(" + this.abAX + ')';
    AppMethodBeat.o(254391);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.ay
 * JD-Core Version:    0.7.0.1
 */