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
import kotlin.a.j;
import kotlin.a.y;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/SerialDescriptorImpl;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/SerialKind;", "elementsCount", "", "builder", "Lkotlinx/serialization/SerialDescriptorBuilder;", "(Ljava/lang/String;Lkotlinx/serialization/SerialKind;ILkotlinx/serialization/SerialDescriptorBuilder;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementAnnotations", "", "[Ljava/util/List;", "elementDescriptors", "[Lkotlinx/serialization/SerialDescriptor;", "elementNames", "[Ljava/lang/String;", "elementOptionality", "", "getElementsCount", "()I", "isNullable", "", "()Z", "getKind", "()Lkotlinx/serialization/SerialKind;", "name2Index", "", "getSerialName", "()Ljava/lang/String;", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-runtime"})
final class q
  implements n
{
  private final List<Annotation> aaLz;
  private final boolean abAR;
  private final String abAX;
  final String[] abAZ;
  final n[] abBa;
  private final List<Annotation>[] abBb;
  private final boolean[] abBc;
  private final Map<String, Integer> abBd;
  private final s abBe;
  private final int abBf;
  
  public q(String paramString, s params, int paramInt, o paramo)
  {
    AppMethodBeat.i(254185);
    this.abAX = paramString;
    this.abBe = params;
    this.abBf = paramInt;
    this.abAR = paramo.abAR;
    this.aaLz = paramo.aaLz;
    paramString = ((Collection)paramo.abAS).toArray(new String[0]);
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(254185);
      throw paramString;
    }
    this.abAZ = ((String[])paramString);
    paramString = ((Collection)paramo.abAU).toArray(new n[0]);
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(254185);
      throw paramString;
    }
    this.abBa = ((n[])paramString);
    paramString = ((Collection)paramo.abAV).toArray(new List[0]);
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(254185);
      throw paramString;
    }
    this.abBb = ((List[])paramString);
    this.abBc = j.q((Collection)paramo.abAW);
    params = e.ad(this.abAZ);
    paramString = (Collection)new ArrayList(j.a(params, 10));
    params = params.iterator();
    while (params.hasNext())
    {
      paramo = (y)params.next();
      paramString.add(kotlin.s.M(paramo.value, Integer.valueOf(paramo.index)));
    }
    this.abBd = ae.E((Iterable)paramString);
    AppMethodBeat.o(254185);
  }
  
  public final String aFX(int paramInt)
  {
    return this.abAZ[paramInt];
  }
  
  public final n aFY(int paramInt)
  {
    return this.abBa[paramInt];
  }
  
  public final int bHI(String paramString)
  {
    AppMethodBeat.i(254177);
    p.k(paramString, "name");
    paramString = (Integer)this.abBd.get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(254177);
      return i;
    }
    AppMethodBeat.o(254177);
    return -3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(254179);
    if ((q)this == paramObject)
    {
      AppMethodBeat.o(254179);
      return true;
    }
    if (!(paramObject instanceof n))
    {
      AppMethodBeat.o(254179);
      return false;
    }
    if ((p.h(this.abAX, ((n)paramObject).iTF()) ^ true))
    {
      AppMethodBeat.o(254179);
      return false;
    }
    AppMethodBeat.o(254179);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(254181);
    int i = this.abAX.hashCode();
    AppMethodBeat.o(254181);
    return i;
  }
  
  public final String iTF()
  {
    return this.abAX;
  }
  
  public final s iTG()
  {
    return this.abBe;
  }
  
  public final boolean iTH()
  {
    return this.abAR;
  }
  
  public final int iTI()
  {
    return this.abBf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(254183);
    String str = j.a((Iterable)i.ou(0, this.abBf), (CharSequence)", ", (CharSequence)(this.abAX + '('), (CharSequence)")", 0, null, (b)new a(this), 24);
    AppMethodBeat.o(254183);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.q
 * JD-Core Version:    0.7.0.1
 */