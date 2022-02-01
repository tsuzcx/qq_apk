package kotlinx.a.b;

import d.g.b.p;
import d.l;
import kotlinx.a.s;
import kotlinx.a.w.c;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/MapLikeDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "keyDescriptor", "valueDescriptor", "(Ljava/lang/String;Lkotlinx/serialization/SerialDescriptor;Lkotlinx/serialization/SerialDescriptor;)V", "elementsCount", "", "getElementsCount", "()I", "getKeyDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "getSerialName", "()Ljava/lang/String;", "getValueDescriptor", "equals", "", "other", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "Lkotlinx/serialization/internal/NamedMapClassDescriptor;", "Lkotlinx/serialization/internal/LinkedHashMapClassDesc;", "Lkotlinx/serialization/internal/HashMapClassDesc;", "kotlinx-serialization-runtime"})
public abstract class an
  implements kotlinx.a.n
{
  private final String NLG;
  private final int NLO;
  private final kotlinx.a.n NMD;
  private final kotlinx.a.n NME;
  
  private an(String paramString, kotlinx.a.n paramn1, kotlinx.a.n paramn2)
  {
    this.NLG = paramString;
    this.NMD = paramn1;
    this.NME = paramn2;
    this.NLO = 2;
  }
  
  public final String alJ(int paramInt)
  {
    return String.valueOf(paramInt);
  }
  
  public final kotlinx.a.n alK(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw ((Throwable)new IndexOutOfBoundsException("Map descriptor has only one child element, index: ".concat(String.valueOf(paramInt))));
    case 0: 
      return this.NMD;
    }
    return this.NME;
  }
  
  public final int bdm(String paramString)
  {
    p.h(paramString, "name");
    Integer localInteger = d.n.n.bdh(paramString);
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
    if ((p.i(this.NLG, ((an)paramObject).NLG) ^ true)) {
      return false;
    }
    if ((p.i(this.NMD, ((an)paramObject).NMD) ^ true)) {
      return false;
    }
    return !(p.i(this.NME, ((an)paramObject).NME) ^ true);
  }
  
  public final String gwQ()
  {
    return this.NLG;
  }
  
  public final s gwR()
  {
    return (s)w.c.NLS;
  }
  
  public final boolean gwS()
  {
    return false;
  }
  
  public final int gwT()
  {
    return this.NLO;
  }
  
  public int hashCode()
  {
    return (this.NLG.hashCode() * 31 + this.NMD.hashCode()) * 31 + this.NME.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.an
 * JD-Core Version:    0.7.0.1
 */