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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "Lkotlinx/serialization/SerialDescriptor;", "serialName", "", "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "elementsCount", "", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "added", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classAnnotations", "", "getElementsCount", "()I", "flags", "", "indices", "", "getIndices", "()Ljava/util/Map;", "indices$delegate", "Lkotlin/Lazy;", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "names", "", "[Ljava/lang/String;", "namesSet", "", "getNamesSet$kotlinx_serialization_runtime", "()Ljava/util/Set;", "propertiesAnnotations", "[Ljava/util/List;", "getSerialName", "()Ljava/lang/String;", "addElement", "", "name", "isOptional", "", "buildIndices", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "getElementName", "hashCode", "isElementOptional", "pushAnnotation", "annotation", "pushClassAnnotation", "a", "toString", "kotlinx-serialization-runtime"})
public class au
  implements n
{
  private boolean[] Eh;
  private final String abAX;
  private int abBY;
  final String[] abBZ;
  private final int abBf;
  private final List<Annotation>[] abCa;
  private final f abCb;
  private final u<?> abCc;
  
  public au(String paramString, u<?> paramu)
  {
    AppMethodBeat.i(254573);
    this.abAX = paramString;
    this.abCc = paramu;
    this.abBf = 6;
    this.abBY = -1;
    int j = this.abBf;
    paramString = new String[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = "[UNINITIALIZED]";
      i += 1;
    }
    this.abBZ = paramString;
    this.abCa = new List[this.abBf];
    this.Eh = new boolean[this.abBf];
    this.abCb = g.ar((a)new a(this));
    AppMethodBeat.o(254573);
  }
  
  public final String aFX(int paramInt)
  {
    return this.abBZ[paramInt];
  }
  
  public final n aFY(int paramInt)
  {
    AppMethodBeat.i(254559);
    Object localObject = this.abCc;
    if (localObject != null)
    {
      localObject = localObject.gPf()[paramInt];
      if (localObject != null)
      {
        localObject = ((h)localObject).gPe();
        if (localObject != null) {
          break label94;
        }
      }
    }
    localObject = (Throwable)new IndexOutOfBoundsException(this.abAX + " descriptor has only " + this.abBf + " elements, index: " + paramInt);
    AppMethodBeat.o(254559);
    throw ((Throwable)localObject);
    label94:
    AppMethodBeat.o(254559);
    return localObject;
  }
  
  public final int bHI(String paramString)
  {
    AppMethodBeat.i(254561);
    p.k(paramString, "name");
    paramString = (Integer)iTN().get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(254561);
      return i;
    }
    AppMethodBeat.o(254561);
    return -3;
  }
  
  public final void ei(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(254557);
    p.k(paramString, "name");
    String[] arrayOfString = this.abBZ;
    this.abBY += 1;
    arrayOfString[this.abBY] = paramString;
    this.Eh[this.abBY] = paramBoolean;
    this.abCa[this.abBY] = null;
    AppMethodBeat.o(254557);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(254564);
    if ((au)this == paramObject)
    {
      AppMethodBeat.o(254564);
      return true;
    }
    if (!(paramObject instanceof n))
    {
      AppMethodBeat.o(254564);
      return false;
    }
    if ((p.h(this.abAX, ((n)paramObject).iTF()) ^ true))
    {
      AppMethodBeat.o(254564);
      return false;
    }
    if ((p.h(r.d(this), r.d((n)paramObject)) ^ true))
    {
      AppMethodBeat.o(254564);
      return false;
    }
    AppMethodBeat.o(254564);
    return true;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(254566);
    int i = this.abAX.hashCode();
    int j = r.d(this).hashCode();
    AppMethodBeat.o(254566);
    return i * 31 + j;
  }
  
  public final String iTF()
  {
    return this.abAX;
  }
  
  public final s iTG()
  {
    return (s)w.a.abBh;
  }
  
  public final boolean iTH()
  {
    return false;
  }
  
  public final int iTI()
  {
    return this.abBf;
  }
  
  final Map<String, Integer> iTN()
  {
    AppMethodBeat.i(254556);
    Map localMap = (Map)this.abCb.getValue();
    AppMethodBeat.o(254556);
    return localMap;
  }
  
  public String toString()
  {
    AppMethodBeat.i(254569);
    String str = j.a((Iterable)iTN().entrySet(), (CharSequence)", ", (CharSequence)(this.abAX + '('), (CharSequence)")", 0, null, (b)new b(this), 24);
    AppMethodBeat.o(254569);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "", "invoke"})
  static final class a
    extends q
    implements a<Map<String, ? extends Integer>>
  {
    a(au paramau)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.au
 * JD-Core Version:    0.7.0.1
 */