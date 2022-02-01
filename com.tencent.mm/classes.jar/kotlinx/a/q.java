package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.e;
import d.a.j;
import d.a.y;
import d.g.a.b;
import d.g.b.p;
import d.k.h;
import d.l;
import d.u;
import d.v;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/SerialDescriptorImpl;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/SerialKind;", "elementsCount", "", "builder", "Lkotlinx/serialization/SerialDescriptorBuilder;", "(Ljava/lang/String;Lkotlinx/serialization/SerialKind;ILkotlinx/serialization/SerialDescriptorBuilder;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementAnnotations", "", "[Ljava/util/List;", "elementDescriptors", "[Lkotlinx/serialization/SerialDescriptor;", "elementNames", "[Ljava/lang/String;", "elementOptionality", "", "getElementsCount", "()I", "isNullable", "", "()Z", "getKind", "()Lkotlinx/serialization/SerialKind;", "name2Index", "", "getSerialName", "()Ljava/lang/String;", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-runtime"})
final class q
  implements n
{
  private final List<Annotation> MVS;
  private final boolean NLA;
  private final String NLG;
  final String[] NLI;
  final n[] NLJ;
  private final List<Annotation>[] NLK;
  private final boolean[] NLL;
  private final Map<String, Integer> NLM;
  private final s NLN;
  private final int NLO;
  
  public q(String paramString, s params, int paramInt, o paramo)
  {
    AppMethodBeat.i(191011);
    this.NLG = paramString;
    this.NLN = params;
    this.NLO = paramInt;
    this.NLA = paramo.NLA;
    this.MVS = paramo.MVS;
    paramString = ((Collection)paramo.NLB).toArray(new String[0]);
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(191011);
      throw paramString;
    }
    this.NLI = ((String[])paramString);
    paramString = ((Collection)paramo.NLD).toArray(new n[0]);
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(191011);
      throw paramString;
    }
    this.NLJ = ((n[])paramString);
    paramString = ((Collection)paramo.NLE).toArray(new List[0]);
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(191011);
      throw paramString;
    }
    this.NLK = ((List[])paramString);
    this.NLL = j.p((Collection)paramo.NLF);
    params = e.Z(this.NLI);
    paramString = (Collection)new ArrayList(j.a(params, 10));
    params = params.iterator();
    while (params.hasNext())
    {
      paramo = (y)params.next();
      paramString.add(u.S(paramo.value, Integer.valueOf(paramo.index)));
    }
    this.NLM = ae.A((Iterable)paramString);
    AppMethodBeat.o(191011);
  }
  
  public final String alJ(int paramInt)
  {
    return this.NLI[paramInt];
  }
  
  public final n alK(int paramInt)
  {
    return this.NLJ[paramInt];
  }
  
  public final int bdm(String paramString)
  {
    AppMethodBeat.i(191007);
    p.h(paramString, "name");
    paramString = (Integer)this.NLM.get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(191007);
      return i;
    }
    AppMethodBeat.o(191007);
    return -3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191008);
    if ((q)this == paramObject)
    {
      AppMethodBeat.o(191008);
      return true;
    }
    if (!(paramObject instanceof n))
    {
      AppMethodBeat.o(191008);
      return false;
    }
    if ((p.i(this.NLG, ((n)paramObject).gwQ()) ^ true))
    {
      AppMethodBeat.o(191008);
      return false;
    }
    AppMethodBeat.o(191008);
    return true;
  }
  
  public final String gwQ()
  {
    return this.NLG;
  }
  
  public final s gwR()
  {
    return this.NLN;
  }
  
  public final boolean gwS()
  {
    return this.NLA;
  }
  
  public final int gwT()
  {
    return this.NLO;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191009);
    int i = this.NLG.hashCode();
    AppMethodBeat.o(191009);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191010);
    String str = j.a((Iterable)h.lo(0, this.NLO), (CharSequence)", ", (CharSequence)(this.NLG + '('), (CharSequence)")", 0, null, (b)new a(this), 24);
    AppMethodBeat.o(191010);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends d.g.b.q
    implements b<Integer, String>
  {
    a(q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.q
 * JD-Core Version:    0.7.0.1
 */