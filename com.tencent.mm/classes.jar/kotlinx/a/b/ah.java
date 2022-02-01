package kotlinx.a.b;

import d.g.b.p;
import d.l;
import kotlinx.a.s;
import kotlinx.a.w.b;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/ListLikeDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "elementDesc", "(Lkotlinx/serialization/SerialDescriptor;)V", "getElementDesc", "()Lkotlinx/serialization/SerialDescriptor;", "elementsCount", "", "getElementsCount", "()I", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "equals", "", "other", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "", "getElementName", "hashCode", "isElementOptional", "Lkotlinx/serialization/internal/PrimitiveArrayDescriptor;", "Lkotlinx/serialization/internal/ArrayClassDesc;", "Lkotlinx/serialization/internal/ArrayListClassDesc;", "Lkotlinx/serialization/internal/NamedListClassDescriptor;", "Lkotlinx/serialization/internal/LinkedHashSetClassDesc;", "Lkotlinx/serialization/internal/HashSetClassDesc;", "kotlinx-serialization-runtime"})
public abstract class ah
  implements kotlinx.a.n
{
  private final int OiU;
  private final kotlinx.a.n OjB;
  
  private ah(kotlinx.a.n paramn)
  {
    this.OjB = paramn;
    this.OiU = 1;
  }
  
  public final String amt(int paramInt)
  {
    return String.valueOf(paramInt);
  }
  
  public final kotlinx.a.n amu(int paramInt)
  {
    if (paramInt != 0) {
      throw ((Throwable)new IndexOutOfBoundsException("List descriptor has only one child element, index: ".concat(String.valueOf(paramInt))));
    }
    return this.OjB;
  }
  
  public final int beQ(String paramString)
  {
    p.h(paramString, "name");
    Integer localInteger = d.n.n.beL(paramString);
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
    return (p.i(this.OjB, ((ah)paramObject).OjB)) && (p.i(gBs(), ((ah)paramObject).gBs()));
  }
  
  public final s gBt()
  {
    return (s)w.b.OiX;
  }
  
  public final boolean gBu()
  {
    return false;
  }
  
  public final int gBv()
  {
    return this.OiU;
  }
  
  public int hashCode()
  {
    return this.OjB.hashCode() * 31 + gBs().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.ah
 * JD-Core Version:    0.7.0.1
 */