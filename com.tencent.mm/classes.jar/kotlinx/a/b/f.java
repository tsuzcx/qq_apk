package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ae;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.v;
import kotlinx.a.d.af;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/descriptors/SerialDescriptorImpl;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "elementsCount", "", "typeParameters", "", "builder", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;ILjava/util/List;Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)V", "_hashCode", "get_hashCode", "()I", "_hashCode$delegate", "Lkotlin/Lazy;", "annotations", "", "getAnnotations", "()Ljava/util/List;", "elementAnnotations", "", "[Ljava/util/List;", "elementDescriptors", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementNames", "[Ljava/lang/String;", "elementOptionality", "", "getElementsCount", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "name2Index", "", "getSerialName", "()Ljava/lang/String;", "typeParametersDescriptors", "equals", "", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class f
  implements e
{
  private final List<Annotation> aYF;
  private final String ajCG;
  final String[] ajCT;
  final e[] ajCU;
  private final List<Annotation>[] ajCV;
  private final boolean[] ajCW;
  private final Map<String, Integer> ajCX;
  final e[] ajCY;
  private final j ajCZ;
  private final i ajDa;
  private final int ajDb;
  
  public f(String paramString, i parami, int paramInt, List<? extends e> paramList, a parama)
  {
    AppMethodBeat.i(188436);
    this.ajCG = paramString;
    this.ajDa = parami;
    this.ajDb = paramInt;
    this.aYF = parama.aYF;
    paramString = ((Collection)parama.ajCB).toArray(new String[0]);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(188436);
      throw paramString;
    }
    this.ajCT = ((String[])paramString);
    this.ajCU = af.pi(parama.ajCD);
    paramString = ((Collection)parama.ajCE).toArray(new List[0]);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(188436);
      throw paramString;
    }
    this.ajCV = ((List[])paramString);
    this.ajCW = p.G((Collection)parama.ajCF);
    parami = kotlin.a.k.ah(this.ajCT);
    paramString = (Collection)new ArrayList(p.a(parami, 10));
    parami = parami.iterator();
    while (parami.hasNext())
    {
      parama = (ae)parami.next();
      paramString.add(v.Y(parama.value, Integer.valueOf(parama.index)));
    }
    this.ajCX = ak.F((Iterable)paramString);
    this.ajCY = af.pi(paramList);
    this.ajCZ = kotlin.k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(188436);
  }
  
  public final e aMJ(int paramInt)
  {
    return this.ajCU[paramInt];
  }
  
  public final String aMK(int paramInt)
  {
    return this.ajCT[paramInt];
  }
  
  public final int bJN(String paramString)
  {
    AppMethodBeat.i(188450);
    s.u(paramString, "name");
    paramString = (Integer)this.ajCX.get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(188450);
      return i;
    }
    AppMethodBeat.o(188450);
    return -3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188466);
    if (this != paramObject)
    {
      if (!(paramObject instanceof f))
      {
        AppMethodBeat.o(188466);
        return false;
      }
      if ((s.p(kFa(), ((e)paramObject).kFa()) ^ true))
      {
        AppMethodBeat.o(188466);
        return false;
      }
      f localf = (f)paramObject;
      if (!Arrays.equals(this.ajCY, localf.ajCY))
      {
        AppMethodBeat.o(188466);
        return false;
      }
      if (kFb() != ((e)paramObject).kFb())
      {
        AppMethodBeat.o(188466);
        return false;
      }
      int j = kFb();
      int i = 0;
      while (i < j)
      {
        if ((s.p(aMJ(i).kFa(), ((e)paramObject).aMJ(i).kFa()) ^ true))
        {
          AppMethodBeat.o(188466);
          return false;
        }
        if ((s.p(aMJ(i).kFd(), ((e)paramObject).aMJ(i).kFd()) ^ true))
        {
          AppMethodBeat.o(188466);
          return false;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(188466);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188475);
    int i = ((Number)this.ajCZ.getValue()).intValue();
    AppMethodBeat.o(188475);
    return i;
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
    return this.ajDa;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188487);
    String str = p.a((Iterable)kotlin.k.k.qt(0, this.ajDb), (CharSequence)", ", (CharSequence)(this.ajCG + '('), (CharSequence)")", 0, null, (b)new b(this), 24);
    AppMethodBeat.o(188487);
    return str;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 4, 0})
  static final class a
    extends u
    implements kotlin.g.a.a<Integer>
  {
    a(f paramf)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 4, 0})
  static final class b
    extends u
    implements b<Integer, CharSequence>
  {
    b(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.b.f
 * JD-Core Version:    0.7.0.1
 */