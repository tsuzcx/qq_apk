package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.f;
import kotlin.g.b.s;
import kotlinx.a.b.d;
import kotlinx.a.b.e;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/PrimitiveSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/PrimitiveKind;)V", "elementsCount", "", "getElementsCount", "()I", "getKind", "()Lkotlinx/serialization/descriptors/PrimitiveKind;", "getSerialName", "()Ljava/lang/String;", "error", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "", "toString", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class ai
  implements e
{
  private final String ajCG;
  private final d ajDS;
  
  public ai(String paramString, d paramd)
  {
    AppMethodBeat.i(188670);
    this.ajCG = paramString;
    this.ajDS = paramd;
    AppMethodBeat.o(188670);
  }
  
  private static Void kFw()
  {
    AppMethodBeat.i(188657);
    Throwable localThrowable = (Throwable)new IllegalStateException("Primitive descriptor does not have elements");
    AppMethodBeat.o(188657);
    throw localThrowable;
  }
  
  public final e aMJ(int paramInt)
  {
    AppMethodBeat.i(188714);
    kFw();
    f localf = new f();
    AppMethodBeat.o(188714);
    throw localf;
  }
  
  public final String aMK(int paramInt)
  {
    AppMethodBeat.i(188690);
    kFw();
    f localf = new f();
    AppMethodBeat.o(188690);
    throw localf;
  }
  
  public final int bJN(String paramString)
  {
    AppMethodBeat.i(188703);
    s.u(paramString, "name");
    kFw();
    paramString = new f();
    AppMethodBeat.o(188703);
    throw paramString;
  }
  
  public final String kFa()
  {
    return this.ajCG;
  }
  
  public final int kFb()
  {
    return 0;
  }
  
  public final boolean kFc()
  {
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188725);
    String str = "PrimitiveDescriptor(" + this.ajCG + ')';
    AppMethodBeat.o(188725);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.ai
 * JD-Core Version:    0.7.0.1
 */