package kotlinx.a.b;

import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.s;
import kotlinx.a.w.b;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/ListLikeDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "elementDesc", "(Lkotlinx/serialization/SerialDescriptor;)V", "getElementDesc", "()Lkotlinx/serialization/SerialDescriptor;", "elementsCount", "", "getElementsCount", "()I", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "equals", "", "other", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "", "getElementName", "hashCode", "isElementOptional", "Lkotlinx/serialization/internal/PrimitiveArrayDescriptor;", "Lkotlinx/serialization/internal/ArrayClassDesc;", "Lkotlinx/serialization/internal/ArrayListClassDesc;", "Lkotlinx/serialization/internal/NamedListClassDescriptor;", "Lkotlinx/serialization/internal/LinkedHashSetClassDesc;", "Lkotlinx/serialization/internal/HashSetClassDesc;", "kotlinx-serialization-runtime"})
public abstract class ah
  implements kotlinx.a.n
{
  private final kotlinx.a.n abBL;
  private final int abBf;
  
  private ah(kotlinx.a.n paramn)
  {
    this.abBL = paramn;
    this.abBf = 1;
  }
  
  public final String aFX(int paramInt)
  {
    return String.valueOf(paramInt);
  }
  
  public final kotlinx.a.n aFY(int paramInt)
  {
    if (paramInt != 0) {
      throw ((Throwable)new IndexOutOfBoundsException("List descriptor has only one child element, index: ".concat(String.valueOf(paramInt))));
    }
    return this.abBL;
  }
  
  public final int bHI(String paramString)
  {
    p.k(paramString, "name");
    Integer localInteger = kotlin.n.n.bHC(paramString);
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
    return (p.h(this.abBL, ((ah)paramObject).abBL)) && (p.h(iTF(), ((ah)paramObject).iTF()));
  }
  
  public int hashCode()
  {
    return this.abBL.hashCode() * 31 + iTF().hashCode();
  }
  
  public final s iTG()
  {
    return (s)w.b.abBi;
  }
  
  public final boolean iTH()
  {
    return false;
  }
  
  public final int iTI()
  {
    return this.abBf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.ah
 * JD-Core Version:    0.7.0.1
 */