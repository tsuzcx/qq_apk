package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.l.c;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/descriptors/ContextDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "original", "kClass", "Lkotlin/reflect/KClass;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/reflect/KClass;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementsCount", "", "getElementsCount", "()I", "isNullable", "", "()Z", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class b
  implements e
{
  private final String ajCG;
  private final e ajCH;
  public final c<?> ajCI;
  
  public b(e parame, c<?> paramc)
  {
    AppMethodBeat.i(188429);
    this.ajCH = parame;
    this.ajCI = paramc;
    this.ajCG = (this.ajCH.kFa() + '<' + this.ajCI.klt() + '>');
    AppMethodBeat.o(188429);
  }
  
  public final e aMJ(int paramInt)
  {
    AppMethodBeat.i(188488);
    e locale = this.ajCH.aMJ(paramInt);
    AppMethodBeat.o(188488);
    return locale;
  }
  
  public final String aMK(int paramInt)
  {
    AppMethodBeat.i(188506);
    String str = this.ajCH.aMK(paramInt);
    AppMethodBeat.o(188506);
    return str;
  }
  
  public final int bJN(String paramString)
  {
    AppMethodBeat.i(188497);
    s.u(paramString, "name");
    int i = this.ajCH.bJN(paramString);
    AppMethodBeat.o(188497);
    return i;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188446);
    if (!(paramObject instanceof b)) {
      paramObject = null;
    }
    for (;;)
    {
      paramObject = (b)paramObject;
      if (paramObject == null)
      {
        AppMethodBeat.o(188446);
        return false;
      }
      if ((s.p(this.ajCH, paramObject.ajCH)) && (s.p(paramObject.ajCI, this.ajCI)))
      {
        AppMethodBeat.o(188446);
        return true;
      }
      AppMethodBeat.o(188446);
      return false;
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188454);
    int i = this.ajCI.hashCode();
    int j = this.ajCG.hashCode();
    AppMethodBeat.o(188454);
    return i * 31 + j;
  }
  
  public final String kFa()
  {
    return this.ajCG;
  }
  
  public final int kFb()
  {
    AppMethodBeat.i(188463);
    int i = this.ajCH.kFb();
    AppMethodBeat.o(188463);
    return i;
  }
  
  public final boolean kFc()
  {
    AppMethodBeat.i(188468);
    boolean bool = this.ajCH.kFc();
    AppMethodBeat.o(188468);
    return bool;
  }
  
  public final i kFd()
  {
    AppMethodBeat.i(188477);
    i locali = this.ajCH.kFd();
    AppMethodBeat.o(188477);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.b.b
 * JD-Core Version:    0.7.0.1
 */