package kotlinx.a.b;

import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.s;
import kotlinx.a.w.c;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/MapLikeDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "keyDescriptor", "valueDescriptor", "(Ljava/lang/String;Lkotlinx/serialization/SerialDescriptor;Lkotlinx/serialization/SerialDescriptor;)V", "elementsCount", "", "getElementsCount", "()I", "getKeyDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "getSerialName", "()Ljava/lang/String;", "getValueDescriptor", "equals", "", "other", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "Lkotlinx/serialization/internal/NamedMapClassDescriptor;", "Lkotlinx/serialization/internal/LinkedHashMapClassDesc;", "Lkotlinx/serialization/internal/HashMapClassDesc;", "kotlinx-serialization-runtime"})
public abstract class an
  implements kotlinx.a.n
{
  private final String abAX;
  private final kotlinx.a.n abBT;
  private final kotlinx.a.n abBU;
  private final int abBf;
  
  private an(String paramString, kotlinx.a.n paramn1, kotlinx.a.n paramn2)
  {
    this.abAX = paramString;
    this.abBT = paramn1;
    this.abBU = paramn2;
    this.abBf = 2;
  }
  
  public final String aFX(int paramInt)
  {
    return String.valueOf(paramInt);
  }
  
  public final kotlinx.a.n aFY(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw ((Throwable)new IndexOutOfBoundsException("Map descriptor has only one child element, index: ".concat(String.valueOf(paramInt))));
    case 0: 
      return this.abBT;
    }
    return this.abBU;
  }
  
  public final int bHI(String paramString)
  {
    p.k(paramString, "name");
    Integer localInteger = kotlin.n.n.bHC(paramString);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw ((Throwable)new IllegalArgumentException(paramString + " is not a valid map index"));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((an)this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof an)) {
      return false;
    }
    if ((p.h(this.abAX, ((an)paramObject).abAX) ^ true)) {
      return false;
    }
    if ((p.h(this.abBT, ((an)paramObject).abBT) ^ true)) {
      return false;
    }
    return !(p.h(this.abBU, ((an)paramObject).abBU) ^ true);
  }
  
  public int hashCode()
  {
    return (this.abAX.hashCode() * 31 + this.abBT.hashCode()) * 31 + this.abBU.hashCode();
  }
  
  public final String iTF()
  {
    return this.abAX;
  }
  
  public final s iTG()
  {
    return (s)w.c.abBj;
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
 * Qualified Name:     kotlinx.a.b.an
 * JD-Core Version:    0.7.0.1
 */