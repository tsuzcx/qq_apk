package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.e;
import kotlin.a.y;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/SerialDescriptorImpl;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/SerialKind;", "elementsCount", "", "builder", "Lkotlinx/serialization/SerialDescriptorBuilder;", "(Ljava/lang/String;Lkotlinx/serialization/SerialKind;ILkotlinx/serialization/SerialDescriptorBuilder;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementAnnotations", "", "[Ljava/util/List;", "elementDescriptors", "[Lkotlinx/serialization/SerialDescriptor;", "elementNames", "[Ljava/lang/String;", "elementOptionality", "", "getElementsCount", "()I", "isNullable", "", "()Z", "getKind", "()Lkotlinx/serialization/SerialKind;", "name2Index", "", "getSerialName", "()Ljava/lang/String;", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-runtime"})
final class q
  implements n
{
  private final boolean TXC;
  private final String TXI;
  final String[] TXK;
  final n[] TXL;
  private final List<Annotation>[] TXM;
  private final boolean[] TXN;
  private final Map<String, Integer> TXO;
  private final s TXP;
  private final int TXQ;
  private final List<Annotation> TiF;
  
  public q(String paramString, s params, int paramInt, o paramo)
  {
    AppMethodBeat.i(225371);
    this.TXI = paramString;
    this.TXP = params;
    this.TXQ = paramInt;
    this.TXC = paramo.TXC;
    this.TiF = paramo.TiF;
    paramString = ((Collection)paramo.TXD).toArray(new String[0]);
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(225371);
      throw paramString;
    }
    this.TXK = ((String[])paramString);
    paramString = ((Collection)paramo.TXF).toArray(new n[0]);
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(225371);
      throw paramString;
    }
    this.TXL = ((n[])paramString);
    paramString = ((Collection)paramo.TXG).toArray(new List[0]);
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(225371);
      throw paramString;
    }
    this.TXM = ((List[])paramString);
    this.TXN = kotlin.a.j.s((Collection)paramo.TXH);
    params = e.Z(this.TXK);
    paramString = (Collection)new ArrayList(kotlin.a.j.a(params, 10));
    params = params.iterator();
    while (params.hasNext())
    {
      paramo = (y)params.next();
      paramString.add(kotlin.s.U(paramo.value, Integer.valueOf(paramo.index)));
    }
    this.TXO = ae.E((Iterable)paramString);
    AppMethodBeat.o(225371);
  }
  
  public final String awc(int paramInt)
  {
    return this.TXK[paramInt];
  }
  
  public final n awd(int paramInt)
  {
    return this.TXL[paramInt];
  }
  
  public final int buF(String paramString)
  {
    AppMethodBeat.i(225367);
    p.h(paramString, "name");
    paramString = (Integer)this.TXO.get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(225367);
      return i;
    }
    AppMethodBeat.o(225367);
    return -3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(225368);
    if ((q)this == paramObject)
    {
      AppMethodBeat.o(225368);
      return true;
    }
    if (!(paramObject instanceof n))
    {
      AppMethodBeat.o(225368);
      return false;
    }
    if ((p.j(this.TXI, ((n)paramObject).hOz()) ^ true))
    {
      AppMethodBeat.o(225368);
      return false;
    }
    AppMethodBeat.o(225368);
    return true;
  }
  
  public final s hOA()
  {
    return this.TXP;
  }
  
  public final boolean hOB()
  {
    return this.TXC;
  }
  
  public final int hOC()
  {
    return this.TXQ;
  }
  
  public final String hOz()
  {
    return this.TXI;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(225369);
    int i = this.TXI.hashCode();
    AppMethodBeat.o(225369);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(225370);
    String str = kotlin.a.j.a((Iterable)kotlin.k.j.mY(0, this.TXQ), (CharSequence)", ", (CharSequence)(this.TXI + '('), (CharSequence)")", 0, null, (b)new a(this), 24);
    AppMethodBeat.o(225370);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements b<Integer, String>
  {
    a(q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.q
 * JD-Core Version:    0.7.0.1
 */