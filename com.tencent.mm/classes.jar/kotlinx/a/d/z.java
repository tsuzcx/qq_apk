package kotlinx.a.d;

import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.a.b.e;
import kotlinx.a.b.i;
import kotlinx.a.b.j.c;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/MapLikeDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "keyDescriptor", "valueDescriptor", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "elementsCount", "", "getElementsCount", "()I", "getKeyDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "getSerialName", "()Ljava/lang/String;", "getValueDescriptor", "equals", "", "other", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "Lkotlinx/serialization/internal/NamedMapClassDescriptor;", "Lkotlinx/serialization/internal/LinkedHashMapClassDesc;", "Lkotlinx/serialization/internal/HashMapClassDesc;", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract class z
  implements e
{
  private final String ajCG;
  private final e ajDD;
  private final e ajDE;
  private final int ajDb;
  
  private z(String paramString, e parame1, e parame2)
  {
    this.ajCG = paramString;
    this.ajDD = parame1;
    this.ajDE = parame2;
    this.ajDb = 2;
  }
  
  public final e aMJ(int paramInt)
  {
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Illegal index " + paramInt + ", " + this.ajCG + " expects only non-negative indices").toString()));
    }
    switch (paramInt % 2)
    {
    default: 
      throw ((Throwable)new IllegalStateException("Unreached".toString()));
    case 0: 
      return this.ajDD;
    }
    return this.ajDE;
  }
  
  public final String aMK(int paramInt)
  {
    return String.valueOf(paramInt);
  }
  
  public final int bJN(String paramString)
  {
    s.u(paramString, "name");
    Integer localInteger = n.bJF(paramString);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw ((Throwable)new IllegalArgumentException(paramString + " is not a valid map index"));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((z)this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof z)) {
      return false;
    }
    if ((s.p(this.ajCG, ((z)paramObject).ajCG) ^ true)) {
      return false;
    }
    if ((s.p(this.ajDD, ((z)paramObject).ajDD) ^ true)) {
      return false;
    }
    return !(s.p(this.ajDE, ((z)paramObject).ajDE) ^ true);
  }
  
  public int hashCode()
  {
    return (this.ajCG.hashCode() * 31 + this.ajDD.hashCode()) * 31 + this.ajDE.hashCode();
  }
  
  public final String kFa()
  {
    return this.ajCG;
  }
  
  public final int kFb()
  {
    return this.ajDb;
  }
  
  public final boolean kFc()
  {
    return false;
  }
  
  public final i kFd()
  {
    return (i)j.c.ajDl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.z
 * JD-Core Version:    0.7.0.1
 */