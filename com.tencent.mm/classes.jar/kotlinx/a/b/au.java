package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.f;
import d.g;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.r;
import kotlinx.a.s;
import kotlinx.a.w.a;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "elementsCount", "", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "added", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classAnnotations", "", "getElementsCount", "()I", "flags", "", "indices", "", "getIndices", "()Ljava/util/Map;", "indices$delegate", "Lkotlin/Lazy;", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "names", "", "[Ljava/lang/String;", "namesSet", "", "getNamesSet$kotlinx_serialization_runtime", "()Ljava/util/Set;", "propertiesAnnotations", "[Ljava/util/List;", "getSerialName", "()Ljava/lang/String;", "addElement", "", "name", "isOptional", "", "buildIndices", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "getElementName", "hashCode", "isElementOptional", "pushAnnotation", "annotation", "pushClassAnnotation", "a", "toString", "kotlinx-serialization-runtime"})
public class au
  implements n
{
  private final String NLG;
  private final int NLO;
  private int NMI;
  final String[] NMJ;
  private final List<Annotation>[] NMK;
  private final f NML;
  private final u<?> NMM;
  private boolean[] flags;
  
  public au(String paramString, u<?> paramu)
  {
    AppMethodBeat.i(191167);
    this.NLG = paramString;
    this.NMM = paramu;
    this.NLO = 6;
    this.NMI = -1;
    int j = this.NLO;
    paramString = new String[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = "[UNINITIALIZED]";
      i += 1;
    }
    this.NMJ = paramString;
    this.NMK = new List[this.NLO];
    this.flags = new boolean[this.NLO];
    this.NML = g.O((a)new a(this));
    AppMethodBeat.o(191167);
  }
  
  public final String alJ(int paramInt)
  {
    return this.NMJ[paramInt];
  }
  
  public final n alK(int paramInt)
  {
    AppMethodBeat.i(191162);
    Object localObject = this.NMM;
    if (localObject != null)
    {
      localObject = localObject.eLk()[paramInt];
      if (localObject != null)
      {
        localObject = ((h)localObject).eLj();
        if (localObject != null) {
          break label94;
        }
      }
    }
    localObject = (Throwable)new IndexOutOfBoundsException(this.NLG + " descriptor has only " + this.NLO + " elements, index: " + paramInt);
    AppMethodBeat.o(191162);
    throw ((Throwable)localObject);
    label94:
    AppMethodBeat.o(191162);
    return localObject;
  }
  
  public final int bdm(String paramString)
  {
    AppMethodBeat.i(191163);
    p.h(paramString, "name");
    paramString = (Integer)gwX().get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(191163);
      return i;
    }
    AppMethodBeat.o(191163);
    return -3;
  }
  
  public final void dw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(191161);
    p.h(paramString, "name");
    String[] arrayOfString = this.NMJ;
    this.NMI += 1;
    arrayOfString[this.NMI] = paramString;
    this.flags[this.NMI] = paramBoolean;
    this.NMK[this.NMI] = null;
    AppMethodBeat.o(191161);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191164);
    if ((au)this == paramObject)
    {
      AppMethodBeat.o(191164);
      return true;
    }
    if (!(paramObject instanceof n))
    {
      AppMethodBeat.o(191164);
      return false;
    }
    if ((p.i(this.NLG, ((n)paramObject).gwQ()) ^ true))
    {
      AppMethodBeat.o(191164);
      return false;
    }
    if ((p.i(r.d(this), r.d((n)paramObject)) ^ true))
    {
      AppMethodBeat.o(191164);
      return false;
    }
    AppMethodBeat.o(191164);
    return true;
  }
  
  public final String gwQ()
  {
    return this.NLG;
  }
  
  public final s gwR()
  {
    return (s)w.a.NLQ;
  }
  
  public final boolean gwS()
  {
    return false;
  }
  
  public final int gwT()
  {
    return this.NLO;
  }
  
  final Map<String, Integer> gwX()
  {
    AppMethodBeat.i(191160);
    Map localMap = (Map)this.NML.getValue();
    AppMethodBeat.o(191160);
    return localMap;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(191165);
    int i = this.NLG.hashCode();
    int j = r.d(this).hashCode();
    AppMethodBeat.o(191165);
    return i * 31 + j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(191166);
    String str = j.a((Iterable)gwX().entrySet(), (CharSequence)", ", (CharSequence)(this.NLG + '('), (CharSequence)")", 0, null, (b)new b(this), 24);
    AppMethodBeat.o(191166);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "", "invoke"})
  static final class a
    extends q
    implements a<Map<String, ? extends Integer>>
  {
    a(au paramau)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "", "invoke"})
  static final class b
    extends q
    implements b<Map.Entry<? extends String, ? extends Integer>, String>
  {
    b(au paramau)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.au
 * JD-Core Version:    0.7.0.1
 */