package kotlinx.a.b;

import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.s;
import kotlinx.a.w.b;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/ListLikeDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "elementDesc", "(Lkotlinx/serialization/SerialDescriptor;)V", "getElementDesc", "()Lkotlinx/serialization/SerialDescriptor;", "elementsCount", "", "getElementsCount", "()I", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "equals", "", "other", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "", "getElementName", "hashCode", "isElementOptional", "Lkotlinx/serialization/internal/PrimitiveArrayDescriptor;", "Lkotlinx/serialization/internal/ArrayClassDesc;", "Lkotlinx/serialization/internal/ArrayListClassDesc;", "Lkotlinx/serialization/internal/NamedListClassDescriptor;", "Lkotlinx/serialization/internal/LinkedHashSetClassDesc;", "Lkotlinx/serialization/internal/HashSetClassDesc;", "kotlinx-serialization-runtime"})
public abstract class ah
  implements kotlinx.a.n
{
  private final int TXQ;
  private final kotlinx.a.n TYw;
  
  private ah(kotlinx.a.n paramn)
  {
    this.TYw = paramn;
    this.TXQ = 1;
  }
  
  public final String awc(int paramInt)
  {
    return String.valueOf(paramInt);
  }
  
  public final kotlinx.a.n awd(int paramInt)
  {
    if (paramInt != 0) {
      throw ((Throwable)new IndexOutOfBoundsException("List descriptor has only one child element, index: ".concat(String.valueOf(paramInt))));
    }
    return this.TYw;
  }
  
  public final int buF(String paramString)
  {
    p.h(paramString, "name");
    Integer localInteger = kotlin.n.n.buA(paramString);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw ((Throwable)new IllegalArgumentException(paramString + " is not a valid list index"));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((ah)this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ah)) {
      return false;
    }
    return (p.j(this.TYw, ((ah)paramObject).TYw)) && (p.j(hOz(), ((ah)paramObject).hOz()));
  }
  
  public final s hOA()
  {
    return (s)w.b.TXT;
  }
  
  public final boolean hOB()
  {
    return false;
  }
  
  public final int hOC()
  {
    return this.TXQ;
  }
  
  public int hashCode()
  {
    return this.TYw.hashCode() * 31 + hOz().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.a.b.ah
 * JD-Core Version:    0.7.0.1
 */