package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import kotlinx.a.n;
import kotlinx.a.s;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/SerialDescriptorForNullable;", "Lkotlinx/serialization/SerialDescriptor;", "original", "(Lkotlinx/serialization/SerialDescriptor;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementsCount", "", "getElementsCount", "()I", "isNullable", "", "()Z", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "name", "", "getName", "()Ljava/lang/String;", "serialName", "getSerialName", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "getElementName", "getEntityAnnotations", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-runtime"})
public final class bb
  implements n
{
  private final String NLG;
  private final n NMQ;
  
  public bb(n paramn)
  {
    AppMethodBeat.i(191191);
    this.NMQ = paramn;
    this.NLG = (this.NMQ.gwQ() + "?");
    AppMethodBeat.o(191191);
  }
  
  public final String alJ(int paramInt)
  {
    AppMethodBeat.i(191196);
    String str = this.NMQ.alJ(paramInt);
    AppMethodBeat.o(191196);
    return str;
  }
  
  public final n alK(int paramInt)
  {
    AppMethodBeat.i(191194);
    n localn = this.NMQ.alK(paramInt);
    AppMethodBeat.o(191194);
    return localn;
  }
  
  public final int bdm(String paramString)
  {
    AppMethodBeat.i(191195);
    p.h(paramString, "name");
    int i = this.NMQ.bdm(paramString);
    AppMethodBeat.o(191195);
    return i;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191188);
    if ((bb)this == paramObject)
    {
      AppMethodBeat.o(191188);
      return true;
    }
    if (!(paramObject instanceof bb))
    {
      AppMethodBeat.o(191188);
      return false;
    }
    if ((p.i(this.NMQ, ((bb)paramObject).NMQ) ^ true))
    {
      AppMethodBeat.o(191188);
      return false;
    }
    AppMethodBeat.o(191188);
    return true;
  }
  
  public final String gwQ()
  {
    return this.NLG;
  }
  
  public final s gwR()
  {
    AppMethodBeat.i(191193);
    s locals = this.NMQ.gwR();
    AppMethodBeat.o(191193);
    return locals;
  }
  
  public final boolean gwS()
  {
    return true;
  }
  
  public final int gwT()
  {
    AppMethodBeat.i(191192);
    int i = this.NMQ.gwT();
    AppMethodBeat.o(191192);
    return i;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191190);
    int i = this.NMQ.hashCode();
    AppMethodBeat.o(191190);
    return i * 31;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191189);
    String str = this.NMQ + '?';
    AppMethodBeat.o(191189);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.bb
 * JD-Core Version:    0.7.0.1
 */