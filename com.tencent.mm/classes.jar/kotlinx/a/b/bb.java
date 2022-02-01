package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import kotlinx.a.n;
import kotlinx.a.s;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/SerialDescriptorForNullable;", "Lkotlinx/serialization/SerialDescriptor;", "original", "(Lkotlinx/serialization/SerialDescriptor;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementsCount", "", "getElementsCount", "()I", "isNullable", "", "()Z", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "name", "", "getName", "()Ljava/lang/String;", "serialName", "getSerialName", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "getElementName", "getEntityAnnotations", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-runtime"})
public final class bb
  implements n
{
  private final String OiM;
  private final n OjW;
  
  public bb(n paramn)
  {
    AppMethodBeat.i(199779);
    this.OjW = paramn;
    this.OiM = (this.OjW.gBs() + "?");
    AppMethodBeat.o(199779);
  }
  
  public final String amt(int paramInt)
  {
    AppMethodBeat.i(199784);
    String str = this.OjW.amt(paramInt);
    AppMethodBeat.o(199784);
    return str;
  }
  
  public final n amu(int paramInt)
  {
    AppMethodBeat.i(199782);
    n localn = this.OjW.amu(paramInt);
    AppMethodBeat.o(199782);
    return localn;
  }
  
  public final int beQ(String paramString)
  {
    AppMethodBeat.i(199783);
    p.h(paramString, "name");
    int i = this.OjW.beQ(paramString);
    AppMethodBeat.o(199783);
    return i;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(199776);
    if ((bb)this == paramObject)
    {
      AppMethodBeat.o(199776);
      return true;
    }
    if (!(paramObject instanceof bb))
    {
      AppMethodBeat.o(199776);
      return false;
    }
    if ((p.i(this.OjW, ((bb)paramObject).OjW) ^ true))
    {
      AppMethodBeat.o(199776);
      return false;
    }
    AppMethodBeat.o(199776);
    return true;
  }
  
  public final String gBs()
  {
    return this.OiM;
  }
  
  public final s gBt()
  {
    AppMethodBeat.i(199781);
    s locals = this.OjW.gBt();
    AppMethodBeat.o(199781);
    return locals;
  }
  
  public final boolean gBu()
  {
    return true;
  }
  
  public final int gBv()
  {
    AppMethodBeat.i(199780);
    int i = this.OjW.gBv();
    AppMethodBeat.o(199780);
    return i;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(199778);
    int i = this.OjW.hashCode();
    AppMethodBeat.o(199778);
    return i * 31;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199777);
    String str = this.OjW + '?';
    AppMethodBeat.o(199777);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.bb
 * JD-Core Version:    0.7.0.1
 */