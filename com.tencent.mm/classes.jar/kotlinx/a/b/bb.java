package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.n;
import kotlinx.a.s;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/SerialDescriptorForNullable;", "Lkotlinx/serialization/SerialDescriptor;", "original", "(Lkotlinx/serialization/SerialDescriptor;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementsCount", "", "getElementsCount", "()I", "isNullable", "", "()Z", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "name", "", "getName", "()Ljava/lang/String;", "serialName", "getSerialName", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "getElementName", "getEntityAnnotations", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-runtime"})
public final class bb
  implements n
{
  private final String TXI;
  private final n TYR;
  
  public bb(n paramn)
  {
    AppMethodBeat.i(225551);
    this.TYR = paramn;
    this.TXI = (this.TYR.hOz() + "?");
    AppMethodBeat.o(225551);
  }
  
  public final String awc(int paramInt)
  {
    AppMethodBeat.i(225556);
    String str = this.TYR.awc(paramInt);
    AppMethodBeat.o(225556);
    return str;
  }
  
  public final n awd(int paramInt)
  {
    AppMethodBeat.i(225554);
    n localn = this.TYR.awd(paramInt);
    AppMethodBeat.o(225554);
    return localn;
  }
  
  public final int buF(String paramString)
  {
    AppMethodBeat.i(225555);
    p.h(paramString, "name");
    int i = this.TYR.buF(paramString);
    AppMethodBeat.o(225555);
    return i;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(225548);
    if ((bb)this == paramObject)
    {
      AppMethodBeat.o(225548);
      return true;
    }
    if (!(paramObject instanceof bb))
    {
      AppMethodBeat.o(225548);
      return false;
    }
    if ((p.j(this.TYR, ((bb)paramObject).TYR) ^ true))
    {
      AppMethodBeat.o(225548);
      return false;
    }
    AppMethodBeat.o(225548);
    return true;
  }
  
  public final s hOA()
  {
    AppMethodBeat.i(225553);
    s locals = this.TYR.hOA();
    AppMethodBeat.o(225553);
    return locals;
  }
  
  public final boolean hOB()
  {
    return true;
  }
  
  public final int hOC()
  {
    AppMethodBeat.i(225552);
    int i = this.TYR.hOC();
    AppMethodBeat.o(225552);
    return i;
  }
  
  public final String hOz()
  {
    return this.TXI;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(225550);
    int i = this.TYR.hashCode();
    AppMethodBeat.o(225550);
    return i * 31;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(225549);
    String str = this.TYR + '?';
    AppMethodBeat.o(225549);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.a.b.bb
 * JD-Core Version:    0.7.0.1
 */