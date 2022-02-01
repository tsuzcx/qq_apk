package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlinx.a.b.e;
import kotlinx.a.b.i;
import kotlinx.a.b.j.a;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "elementsCount", "", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "_hashCode", "get_hashCode", "()I", "_hashCode$delegate", "Lkotlin/Lazy;", "added", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classAnnotations", "", "getElementsCount", "elementsOptionality", "", "indices", "", "getIndices", "()Ljava/util/Map;", "indices$delegate", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "names", "", "[Ljava/lang/String;", "namesSet", "", "getNamesSet$kotlinx_serialization_runtime", "()Ljava/util/Set;", "propertiesAnnotations", "[Ljava/util/List;", "getSerialName", "()Ljava/lang/String;", "typeParameterDescriptors", "getTypeParameterDescriptors", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParameterDescriptors$delegate", "addElement", "", "name", "isOptional", "", "buildIndices", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "getElementName", "hashCode", "isElementOptional", "pushAnnotation", "annotation", "pushClassAnnotation", "a", "toString", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class ag
  implements e
{
  private final String ajCG;
  private final j ajCZ;
  private int ajDJ;
  final String[] ajDK;
  private final List<Annotation>[] ajDL;
  private boolean[] ajDM;
  private final j ajDN;
  private final j ajDO;
  final k<?> ajDP;
  private final int ajDb;
  
  public ag(String paramString, k<?> paramk)
  {
    AppMethodBeat.i(188662);
    this.ajCG = paramString;
    this.ajDP = paramk;
    this.ajDb = 6;
    this.ajDJ = -1;
    int j = this.ajDb;
    paramString = new String[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = "[UNINITIALIZED]";
      i += 1;
    }
    this.ajDK = paramString;
    this.ajDL = new List[this.ajDb];
    this.ajDM = new boolean[this.ajDb];
    this.ajDN = kotlin.k.cm((a)new b(this));
    this.ajDO = kotlin.k.cm((a)new d(this));
    this.ajCZ = kotlin.k.cm((a)new a(this));
    AppMethodBeat.o(188662);
  }
  
  public final e aMJ(int paramInt)
  {
    AppMethodBeat.i(188718);
    Object localObject = this.ajDP;
    if (localObject != null)
    {
      localObject = ((k)localObject).iov();
      if (localObject != null)
      {
        localObject = localObject[paramInt];
        if (localObject != null)
        {
          localObject = ((kotlinx.a.b)localObject).iou();
          if (localObject != null) {
            break label100;
          }
        }
      }
    }
    localObject = (Throwable)new IndexOutOfBoundsException(this.ajCG + " descriptor has only " + this.ajDb + " elements, index: " + paramInt);
    AppMethodBeat.o(188718);
    throw ((Throwable)localObject);
    label100:
    AppMethodBeat.o(188718);
    return localObject;
  }
  
  public final String aMK(int paramInt)
  {
    return this.ajDK[paramInt];
  }
  
  public final int bJN(String paramString)
  {
    AppMethodBeat.i(188734);
    s.u(paramString, "name");
    paramString = (Integer)kFu().get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(188734);
      return i;
    }
    AppMethodBeat.o(188734);
    return -3;
  }
  
  public final void eX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(188710);
    s.u(paramString, "name");
    String[] arrayOfString = this.ajDK;
    this.ajDJ += 1;
    arrayOfString[this.ajDJ] = paramString;
    this.ajDM[this.ajDJ] = paramBoolean;
    this.ajDL[this.ajDJ] = null;
    AppMethodBeat.o(188710);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188745);
    if (this != paramObject)
    {
      if (!(paramObject instanceof ag))
      {
        AppMethodBeat.o(188745);
        return false;
      }
      if ((s.p(kFa(), ((e)paramObject).kFa()) ^ true))
      {
        AppMethodBeat.o(188745);
        return false;
      }
      ag localag = (ag)paramObject;
      if (!Arrays.equals(kFv(), localag.kFv()))
      {
        AppMethodBeat.o(188745);
        return false;
      }
      if (kFb() != ((e)paramObject).kFb())
      {
        AppMethodBeat.o(188745);
        return false;
      }
      int j = kFb();
      int i = 0;
      while (i < j)
      {
        if ((s.p(aMJ(i).kFa(), ((e)paramObject).aMJ(i).kFa()) ^ true))
        {
          AppMethodBeat.o(188745);
          return false;
        }
        if ((s.p(aMJ(i).kFd(), ((e)paramObject).aMJ(i).kFd()) ^ true))
        {
          AppMethodBeat.o(188745);
          return false;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(188745);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188751);
    int i = ((Number)this.ajCZ.getValue()).intValue();
    AppMethodBeat.o(188751);
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
    return (i)j.a.ajDj;
  }
  
  final Map<String, Integer> kFu()
  {
    AppMethodBeat.i(188687);
    Map localMap = (Map)this.ajDN.getValue();
    AppMethodBeat.o(188687);
    return localMap;
  }
  
  final e[] kFv()
  {
    AppMethodBeat.i(188697);
    e[] arrayOfe = (e[])this.ajDO.getValue();
    AppMethodBeat.o(188697);
    return arrayOfe;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188759);
    String str = p.a((Iterable)kFu().entrySet(), (CharSequence)", ", (CharSequence)(this.ajCG + '('), (CharSequence)")", 0, null, (kotlin.g.a.b)new c(this), 24);
    AppMethodBeat.o(188759);
    return str;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 4, 0})
  static final class a
    extends u
    implements a<Integer>
  {
    a(ag paramag)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "", "", "invoke"}, k=3, mv={1, 4, 0})
  static final class b
    extends u
    implements a<Map<String, ? extends Integer>>
  {
    b(ag paramag)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "", "", "invoke"}, k=3, mv={1, 4, 0})
  static final class c
    extends u
    implements kotlin.g.a.b<Map.Entry<? extends String, ? extends Integer>, CharSequence>
  {
    c(ag paramag)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "invoke", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;"}, k=3, mv={1, 4, 0})
  static final class d
    extends u
    implements a<e[]>
  {
    d(ag paramag)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.ag
 * JD-Core Version:    0.7.0.1
 */