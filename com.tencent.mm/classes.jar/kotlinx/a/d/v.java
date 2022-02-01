package kotlinx.a.d;

import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.a.b.e;
import kotlinx.a.b.i;
import kotlinx.a.b.j.b;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/ListLikeDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementDescriptor", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getElementDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementsCount", "", "getElementsCount", "()I", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "equals", "", "other", "", "getElementAnnotations", "", "", "index", "getElementIndex", "name", "", "getElementName", "hashCode", "isElementOptional", "Lkotlinx/serialization/internal/PrimitiveArrayDescriptor;", "Lkotlinx/serialization/internal/ArrayClassDesc;", "Lkotlinx/serialization/internal/ArrayListClassDesc;", "Lkotlinx/serialization/internal/NamedListClassDescriptor;", "Lkotlinx/serialization/internal/LinkedHashSetClassDesc;", "Lkotlinx/serialization/internal/HashSetClassDesc;", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract class v
  implements e
{
  private final int ajDb;
  private final e ajDy;
  
  private v(e parame)
  {
    this.ajDy = parame;
    this.ajDb = 1;
  }
  
  public final e aMJ(int paramInt)
  {
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Illegal index " + paramInt + ", " + kFa() + " expects only non-negative indices").toString()));
    }
    return this.ajDy;
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
    throw ((Throwable)new IllegalArgumentException(paramString + " is not a valid list index"));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((v)this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof v)) {
      return false;
    }
    return (s.p(this.ajDy, ((v)paramObject).ajDy)) && (s.p(kFa(), ((v)paramObject).kFa()));
  }
  
  public int hashCode()
  {
    return this.ajDy.hashCode() * 31 + kFa().hashCode();
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
    return (i)j.b.ajDk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.v
 * JD-Core Version:    0.7.0.1
 */