package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.a.b.e;
import kotlinx.a.b.i;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/SerialDescriptorForNullable;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "original", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementsCount", "", "getElementsCount", "()I", "isNullable", "", "()Z", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "getOriginal$kotlinx_serialization_runtime", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class aj
  implements e
{
  private final String ajCG;
  private final e ajCH;
  
  public aj(e parame)
  {
    AppMethodBeat.i(188683);
    this.ajCH = parame;
    this.ajCG = (this.ajCH.kFa() + "?");
    AppMethodBeat.o(188683);
  }
  
  public final e aMJ(int paramInt)
  {
    AppMethodBeat.i(188753);
    e locale = this.ajCH.aMJ(paramInt);
    AppMethodBeat.o(188753);
    return locale;
  }
  
  public final String aMK(int paramInt)
  {
    AppMethodBeat.i(188771);
    String str = this.ajCH.aMK(paramInt);
    AppMethodBeat.o(188771);
    return str;
  }
  
  public final int bJN(String paramString)
  {
    AppMethodBeat.i(188760);
    s.u(paramString, "name");
    int i = this.ajCH.bJN(paramString);
    AppMethodBeat.o(188760);
    return i;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188712);
    if ((aj)this == paramObject)
    {
      AppMethodBeat.o(188712);
      return true;
    }
    if (!(paramObject instanceof aj))
    {
      AppMethodBeat.o(188712);
      return false;
    }
    if ((s.p(this.ajCH, ((aj)paramObject).ajCH) ^ true))
    {
      AppMethodBeat.o(188712);
      return false;
    }
    AppMethodBeat.o(188712);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188729);
    int i = this.ajCH.hashCode();
    AppMethodBeat.o(188729);
    return i * 31;
  }
  
  public final String kFa()
  {
    return this.ajCG;
  }
  
  public final int kFb()
  {
    AppMethodBeat.i(188737);
    int i = this.ajCH.kFb();
    AppMethodBeat.o(188737);
    return i;
  }
  
  public final boolean kFc()
  {
    return true;
  }
  
  public final i kFd()
  {
    AppMethodBeat.i(188747);
    i locali = this.ajCH.kFd();
    AppMethodBeat.o(188747);
    return locali;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188721);
    String str = this.ajCH + '?';
    AppMethodBeat.o(188721);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.aj
 * JD-Core Version:    0.7.0.1
 */