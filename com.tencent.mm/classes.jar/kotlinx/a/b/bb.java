package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.n;
import kotlinx.a.s;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/SerialDescriptorForNullable;", "Lkotlinx/serialization/SerialDescriptor;", "original", "(Lkotlinx/serialization/SerialDescriptor;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementsCount", "", "getElementsCount", "()I", "isNullable", "", "()Z", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "name", "", "getName", "()Ljava/lang/String;", "serialName", "getSerialName", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "getElementName", "getEntityAnnotations", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-runtime"})
public final class bb
  implements n
{
  private final String abAX;
  private final n abCg;
  
  public bb(n paramn)
  {
    AppMethodBeat.i(254659);
    this.abCg = paramn;
    this.abAX = (this.abCg.iTF() + "?");
    AppMethodBeat.o(254659);
  }
  
  public final String aFX(int paramInt)
  {
    AppMethodBeat.i(254667);
    String str = this.abCg.aFX(paramInt);
    AppMethodBeat.o(254667);
    return str;
  }
  
  public final n aFY(int paramInt)
  {
    AppMethodBeat.i(254664);
    n localn = this.abCg.aFY(paramInt);
    AppMethodBeat.o(254664);
    return localn;
  }
  
  public final int bHI(String paramString)
  {
    AppMethodBeat.i(254666);
    p.k(paramString, "name");
    int i = this.abCg.bHI(paramString);
    AppMethodBeat.o(254666);
    return i;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(254655);
    if ((bb)this == paramObject)
    {
      AppMethodBeat.o(254655);
      return true;
    }
    if (!(paramObject instanceof bb))
    {
      AppMethodBeat.o(254655);
      return false;
    }
    if ((p.h(this.abCg, ((bb)paramObject).abCg) ^ true))
    {
      AppMethodBeat.o(254655);
      return false;
    }
    AppMethodBeat.o(254655);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(254657);
    int i = this.abCg.hashCode();
    AppMethodBeat.o(254657);
    return i * 31;
  }
  
  public final String iTF()
  {
    return this.abAX;
  }
  
  public final s iTG()
  {
    AppMethodBeat.i(254663);
    s locals = this.abCg.iTG();
    AppMethodBeat.o(254663);
    return locals;
  }
  
  public final boolean iTH()
  {
    return true;
  }
  
  public final int iTI()
  {
    AppMethodBeat.i(254661);
    int i = this.abCg.iTI();
    AppMethodBeat.o(254661);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(254656);
    String str = this.abCg + '?';
    AppMethodBeat.o(254656);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.bb
 * JD-Core Version:    0.7.0.1
 */