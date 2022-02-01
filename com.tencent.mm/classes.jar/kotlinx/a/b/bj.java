package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.n;
import kotlinx.a.s;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"defer", "Lkotlinx/serialization/SerialDescriptor;", "deferred", "Lkotlin/Function0;", "cachedSerialNames", "", "", "cast", "Lkotlinx/serialization/KSerializer;", "T", "readExactNBytes", "", "Ljava/io/InputStream;", "Lkotlinx/io/InputStream;", "bytes", "", "kotlinx-serialization-runtime"})
public final class bj
{
  public static final n ap(a<? extends n> parama)
  {
    AppMethodBeat.i(225473);
    p.h(parama, "deferred");
    parama = (n)new a(parama);
    AppMethodBeat.o(225473);
    return parama;
  }
  
  public static final Set<String> e(n paramn)
  {
    AppMethodBeat.i(225472);
    p.h(paramn, "$this$cachedSerialNames");
    if ((paramn instanceof au))
    {
      paramn = ((au)paramn).hOG().keySet();
      AppMethodBeat.o(225472);
      return paramn;
    }
    HashSet localHashSet = new HashSet(paramn.hOC());
    int j = paramn.hOC();
    int i = 0;
    while (i < j)
    {
      ((Collection)localHashSet).add(paramn.awc(i));
      i += 1;
    }
    paramn = (Set)localHashSet;
    AppMethodBeat.o(225472);
    return paramn;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlinx/serialization/internal/UtilKt$defer$1", "Lkotlinx/serialization/SerialDescriptor;", "elementsCount", "", "getElementsCount", "()I", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "original", "getOriginal", "()Lkotlinx/serialization/SerialDescriptor;", "original$delegate", "Lkotlin/Lazy;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "", "kotlinx-serialization-runtime"})
  public static final class a
    implements n
  {
    private final f TZc;
    
    a(a parama)
    {
      AppMethodBeat.i(225431);
      this.TZc = g.ah(parama);
      AppMethodBeat.o(225431);
    }
    
    private final n hOM()
    {
      AppMethodBeat.i(225424);
      n localn = (n)this.TZc.getValue();
      AppMethodBeat.o(225424);
      return localn;
    }
    
    public final String awc(int paramInt)
    {
      AppMethodBeat.i(225428);
      String str = hOM().awc(paramInt);
      AppMethodBeat.o(225428);
      return str;
    }
    
    public final n awd(int paramInt)
    {
      AppMethodBeat.i(225430);
      n localn = hOM().awd(paramInt);
      AppMethodBeat.o(225430);
      return localn;
    }
    
    public final int buF(String paramString)
    {
      AppMethodBeat.i(225429);
      p.h(paramString, "name");
      int i = hOM().buF(paramString);
      AppMethodBeat.o(225429);
      return i;
    }
    
    public final s hOA()
    {
      AppMethodBeat.i(225426);
      s locals = hOM().hOA();
      AppMethodBeat.o(225426);
      return locals;
    }
    
    public final boolean hOB()
    {
      return false;
    }
    
    public final int hOC()
    {
      AppMethodBeat.i(225427);
      int i = hOM().hOC();
      AppMethodBeat.o(225427);
      return i;
    }
    
    public final String hOz()
    {
      AppMethodBeat.i(225425);
      String str = hOM().hOz();
      AppMethodBeat.o(225425);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.a.b.bj
 * JD-Core Version:    0.7.0.1
 */