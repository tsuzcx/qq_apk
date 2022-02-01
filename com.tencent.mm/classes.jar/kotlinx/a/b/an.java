package kotlinx.a.b;

import d.g.b.p;
import d.l;
import kotlinx.a.s;
import kotlinx.a.w.c;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/MapLikeDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "keyDescriptor", "valueDescriptor", "(Ljava/lang/String;Lkotlinx/serialization/SerialDescriptor;Lkotlinx/serialization/SerialDescriptor;)V", "elementsCount", "", "getElementsCount", "()I", "getKeyDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "getSerialName", "()Ljava/lang/String;", "getValueDescriptor", "equals", "", "other", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "Lkotlinx/serialization/internal/NamedMapClassDescriptor;", "Lkotlinx/serialization/internal/LinkedHashMapClassDesc;", "Lkotlinx/serialization/internal/HashMapClassDesc;", "kotlinx-serialization-runtime"})
public abstract class an
  implements kotlinx.a.n
{
  private final String OiM;
  private final int OiU;
  private final kotlinx.a.n OjJ;
  private final kotlinx.a.n OjK;
  
  private an(String paramString, kotlinx.a.n paramn1, kotlinx.a.n paramn2)
  {
    this.OiM = paramString;
    this.OjJ = paramn1;
    this.OjK = paramn2;
    this.OiU = 2;
  }
  
  public final String amt(int paramInt)
  {
    return String.valueOf(paramInt);
  }
  
  public final kotlinx.a.n amu(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw ((Throwable)new IndexOutOfBoundsException("Map descriptor has only one child element, index: ".concat(String.valueOf(paramInt))));
    case 0: 
      return this.OjJ;
    }
    return this.OjK;
  }
  
  public final int beQ(String paramString)
  {
    p.h(paramString, "name");
    Integer localInteger = d.n.n.beL(paramString);
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
    if ((p.i(this.OiM, ((an)paramObject).OiM) ^ true)) {
      return false;
    }
    if ((p.i(this.OjJ, ((an)paramObject).OjJ) ^ true)) {
      return false;
    }
    return !(p.i(this.OjK, ((an)paramObject).OjK) ^ true);
  }
  
  public final String gBs()
  {
    return this.OiM;
  }
  
  public final s gBt()
  {
    return (s)w.c.OiY;
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
    return (this.OiM.hashCode() * 31 + this.OjJ.hashCode()) * 31 + this.OjK.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.an
 * JD-Core Version:    0.7.0.1
 */