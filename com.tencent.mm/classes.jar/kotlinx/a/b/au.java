package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.r;
import kotlinx.a.s;
import kotlinx.a.w.a;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "elementsCount", "", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "added", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classAnnotations", "", "getElementsCount", "()I", "flags", "", "indices", "", "getIndices", "()Ljava/util/Map;", "indices$delegate", "Lkotlin/Lazy;", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "names", "", "[Ljava/lang/String;", "namesSet", "", "getNamesSet$kotlinx_serialization_runtime", "()Ljava/util/Set;", "propertiesAnnotations", "[Ljava/util/List;", "getSerialName", "()Ljava/lang/String;", "addElement", "", "name", "isOptional", "", "buildIndices", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "getElementName", "hashCode", "isElementOptional", "pushAnnotation", "annotation", "pushClassAnnotation", "a", "toString", "kotlinx-serialization-runtime"})
public class au
  implements n
{
  private final String TXI;
  private final int TXQ;
  private int TYJ;
  final String[] TYK;
  private final List<Annotation>[] TYL;
  private final f TYM;
  private final u<?> TYN;
  private boolean[] flags;
  
  public au(String paramString, u<?> paramu)
  {
    AppMethodBeat.i(225527);
    this.TXI = paramString;
    this.TYN = paramu;
    this.TXQ = 6;
    this.TYJ = -1;
    int j = this.TXQ;
    paramString = new String[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = "[UNINITIALIZED]";
      i += 1;
    }
    this.TYK = paramString;
    this.TYL = new List[this.TXQ];
    this.flags = new boolean[this.TXQ];
    this.TYM = g.ah((a)new a(this));
    AppMethodBeat.o(225527);
  }
  
  public final String awc(int paramInt)
  {
    return this.TYK[paramInt];
  }
  
  public final n awd(int paramInt)
  {
    AppMethodBeat.i(225522);
    Object localObject = this.TYN;
    if (localObject != null)
    {
      localObject = localObject.fWw()[paramInt];
      if (localObject != null)
      {
        localObject = ((h)localObject).fWv();
        if (localObject != null) {
          break label94;
        }
      }
    }
    localObject = (Throwable)new IndexOutOfBoundsException(this.TXI + " descriptor has only " + this.TXQ + " elements, index: " + paramInt);
    AppMethodBeat.o(225522);
    throw ((Throwable)localObject);
    label94:
    AppMethodBeat.o(225522);
    return localObject;
  }
  
  public final int buF(String paramString)
  {
    AppMethodBeat.i(225523);
    p.h(paramString, "name");
    paramString = (Integer)hOG().get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(225523);
      return i;
    }
    AppMethodBeat.o(225523);
    return -3;
  }
  
  public final void dV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(225521);
    p.h(paramString, "name");
    String[] arrayOfString = this.TYK;
    this.TYJ += 1;
    arrayOfString[this.TYJ] = paramString;
    this.flags[this.TYJ] = paramBoolean;
    this.TYL[this.TYJ] = null;
    AppMethodBeat.o(225521);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(225524);
    if ((au)this == paramObject)
    {
      AppMethodBeat.o(225524);
      return true;
    }
    if (!(paramObject instanceof n))
    {
      AppMethodBeat.o(225524);
      return false;
    }
    if ((p.j(this.TXI, ((n)paramObject).hOz()) ^ true))
    {
      AppMethodBeat.o(225524);
      return false;
    }
    if ((p.j(r.d(this), r.d((n)paramObject)) ^ true))
    {
      AppMethodBeat.o(225524);
      return false;
    }
    AppMethodBeat.o(225524);
    return true;
  }
  
  public final s hOA()
  {
    return (s)w.a.TXS;
  }
  
  public final boolean hOB()
  {
    return false;
  }
  
  public final int hOC()
  {
    return this.TXQ;
  }
  
  final Map<String, Integer> hOG()
  {
    AppMethodBeat.i(225520);
    Map localMap = (Map)this.TYM.getValue();
    AppMethodBeat.o(225520);
    return localMap;
  }
  
  public final String hOz()
  {
    return this.TXI;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(225525);
    int i = this.TXI.hashCode();
    int j = r.d(this).hashCode();
    AppMethodBeat.o(225525);
    return i * 31 + j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(225526);
    String str = j.a((Iterable)hOG().entrySet(), (CharSequence)", ", (CharSequence)(this.TXI + '('), (CharSequence)")", 0, null, (b)new b(this), 24);
    AppMethodBeat.o(225526);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "", "invoke"})
  static final class a
    extends q
    implements a<Map<String, ? extends Integer>>
  {
    a(au paramau)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.a.b.au
 * JD-Core Version:    0.7.0.1
 */