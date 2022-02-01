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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "elementsCount", "", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "added", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classAnnotations", "", "getElementsCount", "()I", "flags", "", "indices", "", "getIndices", "()Ljava/util/Map;", "indices$delegate", "Lkotlin/Lazy;", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "names", "", "[Ljava/lang/String;", "namesSet", "", "getNamesSet$kotlinx_serialization_runtime", "()Ljava/util/Set;", "propertiesAnnotations", "[Ljava/util/List;", "getSerialName", "()Ljava/lang/String;", "addElement", "", "name", "isOptional", "", "buildIndices", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "getElementName", "hashCode", "isElementOptional", "pushAnnotation", "annotation", "pushClassAnnotation", "a", "toString", "kotlinx-serialization-runtime"})
public class au
  implements n
{
  private final String OiM;
  private final int OiU;
  private int OjO;
  final String[] OjP;
  private final List<Annotation>[] OjQ;
  private final f OjR;
  private final u<?> OjS;
  private boolean[] flags;
  
  public au(String paramString, u<?> paramu)
  {
    AppMethodBeat.i(199755);
    this.OiM = paramString;
    this.OjS = paramu;
    this.OiU = 6;
    this.OjO = -1;
    int j = this.OiU;
    paramString = new String[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = "[UNINITIALIZED]";
      i += 1;
    }
    this.OjP = paramString;
    this.OjQ = new List[this.OiU];
    this.flags = new boolean[this.OiU];
    this.OjR = g.O((a)new a(this));
    AppMethodBeat.o(199755);
  }
  
  public final String amt(int paramInt)
  {
    return this.OjP[paramInt];
  }
  
  public final n amu(int paramInt)
  {
    AppMethodBeat.i(199750);
    Object localObject = this.OjS;
    if (localObject != null)
    {
      localObject = localObject.eOS()[paramInt];
      if (localObject != null)
      {
        localObject = ((h)localObject).eOR();
        if (localObject != null) {
          break label94;
        }
      }
    }
    localObject = (Throwable)new IndexOutOfBoundsException(this.OiM + " descriptor has only " + this.OiU + " elements, index: " + paramInt);
    AppMethodBeat.o(199750);
    throw ((Throwable)localObject);
    label94:
    AppMethodBeat.o(199750);
    return localObject;
  }
  
  public final int beQ(String paramString)
  {
    AppMethodBeat.i(199751);
    p.h(paramString, "name");
    paramString = (Integer)gBz().get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(199751);
      return i;
    }
    AppMethodBeat.o(199751);
    return -3;
  }
  
  public final void dz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(199749);
    p.h(paramString, "name");
    String[] arrayOfString = this.OjP;
    this.OjO += 1;
    arrayOfString[this.OjO] = paramString;
    this.flags[this.OjO] = paramBoolean;
    this.OjQ[this.OjO] = null;
    AppMethodBeat.o(199749);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(199752);
    if ((au)this == paramObject)
    {
      AppMethodBeat.o(199752);
      return true;
    }
    if (!(paramObject instanceof n))
    {
      AppMethodBeat.o(199752);
      return false;
    }
    if ((p.i(this.OiM, ((n)paramObject).gBs()) ^ true))
    {
      AppMethodBeat.o(199752);
      return false;
    }
    if ((p.i(r.d(this), r.d((n)paramObject)) ^ true))
    {
      AppMethodBeat.o(199752);
      return false;
    }
    AppMethodBeat.o(199752);
    return true;
  }
  
  public final String gBs()
  {
    return this.OiM;
  }
  
  public final s gBt()
  {
    return (s)w.a.OiW;
  }
  
  public final boolean gBu()
  {
    return false;
  }
  
  public final int gBv()
  {
    return this.OiU;
  }
  
  final Map<String, Integer> gBz()
  {
    AppMethodBeat.i(199748);
    Map localMap = (Map)this.OjR.getValue();
    AppMethodBeat.o(199748);
    return localMap;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(199753);
    int i = this.OiM.hashCode();
    int j = r.d(this).hashCode();
    AppMethodBeat.o(199753);
    return i * 31 + j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(199754);
    String str = j.a((Iterable)gBz().entrySet(), (CharSequence)", ", (CharSequence)(this.OiM + '('), (CharSequence)")", 0, null, (b)new b(this), 24);
    AppMethodBeat.o(199754);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "", "invoke"})
  static final class a
    extends q
    implements a<Map<String, ? extends Integer>>
  {
    a(au paramau)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "", "invoke"})
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