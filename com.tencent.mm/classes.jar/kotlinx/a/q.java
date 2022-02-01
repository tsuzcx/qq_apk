package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.e;
import d.a.y;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.u;
import d.v;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/SerialDescriptorImpl;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/SerialKind;", "elementsCount", "", "builder", "Lkotlinx/serialization/SerialDescriptorBuilder;", "(Ljava/lang/String;Lkotlinx/serialization/SerialKind;ILkotlinx/serialization/SerialDescriptorBuilder;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementAnnotations", "", "[Ljava/util/List;", "elementDescriptors", "[Lkotlinx/serialization/SerialDescriptor;", "elementNames", "[Ljava/lang/String;", "elementOptionality", "", "getElementsCount", "()I", "isNullable", "", "()Z", "getKind", "()Lkotlinx/serialization/SerialKind;", "name2Index", "", "getSerialName", "()Ljava/lang/String;", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-runtime"})
final class q
  implements n
{
  private final List<Annotation> NsX;
  private final boolean OiG;
  private final String OiM;
  final String[] OiO;
  final n[] OiP;
  private final List<Annotation>[] OiQ;
  private final boolean[] OiR;
  private final Map<String, Integer> OiS;
  private final s OiT;
  private final int OiU;
  
  public q(String paramString, s params, int paramInt, o paramo)
  {
    AppMethodBeat.i(199599);
    this.OiM = paramString;
    this.OiT = params;
    this.OiU = paramInt;
    this.OiG = paramo.OiG;
    this.NsX = paramo.NsX;
    paramString = ((Collection)paramo.OiH).toArray(new String[0]);
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(199599);
      throw paramString;
    }
    this.OiO = ((String[])paramString);
    paramString = ((Collection)paramo.OiJ).toArray(new n[0]);
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(199599);
      throw paramString;
    }
    this.OiP = ((n[])paramString);
    paramString = ((Collection)paramo.OiK).toArray(new List[0]);
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(199599);
      throw paramString;
    }
    this.OiQ = ((List[])paramString);
    this.OiR = d.a.j.p((Collection)paramo.OiL);
    params = e.Y(this.OiO);
    paramString = (Collection)new ArrayList(d.a.j.a(params, 10));
    params = params.iterator();
    while (params.hasNext())
    {
      paramo = (y)params.next();
      paramString.add(u.R(paramo.value, Integer.valueOf(paramo.index)));
    }
    this.OiS = ae.A((Iterable)paramString);
    AppMethodBeat.o(199599);
  }
  
  public final String amt(int paramInt)
  {
    return this.OiO[paramInt];
  }
  
  public final n amu(int paramInt)
  {
    return this.OiP[paramInt];
  }
  
  public final int beQ(String paramString)
  {
    AppMethodBeat.i(199595);
    p.h(paramString, "name");
    paramString = (Integer)this.OiS.get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(199595);
      return i;
    }
    AppMethodBeat.o(199595);
    return -3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(199596);
    if ((q)this == paramObject)
    {
      AppMethodBeat.o(199596);
      return true;
    }
    if (!(paramObject instanceof n))
    {
      AppMethodBeat.o(199596);
      return false;
    }
    if ((p.i(this.OiM, ((n)paramObject).gBs()) ^ true))
    {
      AppMethodBeat.o(199596);
      return false;
    }
    AppMethodBeat.o(199596);
    return true;
  }
  
  public final String gBs()
  {
    return this.OiM;
  }
  
  public final s gBt()
  {
    return this.OiT;
  }
  
  public final boolean gBu()
  {
    return this.OiG;
  }
  
  public final int gBv()
  {
    return this.OiU;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(199597);
    int i = this.OiM.hashCode();
    AppMethodBeat.o(199597);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199598);
    String str = d.a.j.a((Iterable)d.k.j.lv(0, this.OiU), (CharSequence)", ", (CharSequence)(this.OiM + '('), (CharSequence)")", 0, null, (b)new a(this), 24);
    AppMethodBeat.o(199598);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
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