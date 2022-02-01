package kotlinx.a.b;

import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.s;
import kotlinx.a.w.c;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/MapLikeDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "keyDescriptor", "valueDescriptor", "(Ljava/lang/String;Lkotlinx/serialization/SerialDescriptor;Lkotlinx/serialization/SerialDescriptor;)V", "elementsCount", "", "getElementsCount", "()I", "getKeyDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "getSerialName", "()Ljava/lang/String;", "getValueDescriptor", "equals", "", "other", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "Lkotlinx/serialization/internal/NamedMapClassDescriptor;", "Lkotlinx/serialization/internal/LinkedHashMapClassDesc;", "Lkotlinx/serialization/internal/HashMapClassDesc;", "kotlinx-serialization-runtime"})
public abstract class an
  implements kotlinx.a.n
{
  private final String TXI;
  private final int TXQ;
  private final kotlinx.a.n TYE;
  private final kotlinx.a.n TYF;
  
  private an(String paramString, kotlinx.a.n paramn1, kotlinx.a.n paramn2)
  {
    this.TXI = paramString;
    this.TYE = paramn1;
    this.TYF = paramn2;
    this.TXQ = 2;
  }
  
  public final String awc(int paramInt)
  {
    return String.valueOf(paramInt);
  }
  
  public final kotlinx.a.n awd(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw ((Throwable)new IndexOutOfBoundsException("Map descriptor has only one child element, index: ".concat(String.valueOf(paramInt))));
    case 0: 
      return this.TYE;
    }
    return this.TYF;
  }
  
  public final int buF(String paramString)
  {
    p.h(paramString, "name");
    Integer localInteger = kotlin.n.n.buA(paramString);
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
    if ((p.j(this.TXI, ((an)paramObject).TXI) ^ true)) {
      return false;
    }
    if ((p.j(this.TYE, ((an)paramObject).TYE) ^ true)) {
      return false;
    }
    return !(p.j(this.TYF, ((an)paramObject).TYF) ^ true);
  }
  
  public final s hOA()
  {
    return (s)w.c.TXU;
  }
  
  public final boolean hOB()
  {
    return false;
  }
  
  public final int hOC()
  {
    return this.TXQ;
  }
  
  public final String hOz()
  {
    return this.TXI;
  }
  
  public int hashCode()
  {
    return (this.TXI.hashCode() * 31 + this.TYE.hashCode()) * 31 + this.TYF.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.a.b.an
 * JD-Core Version:    0.7.0.1
 */