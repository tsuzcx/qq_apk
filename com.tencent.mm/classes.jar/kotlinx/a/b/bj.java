package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlinx.a.n;
import kotlinx.a.s;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"defer", "Lkotlinx/serialization/SerialDescriptor;", "deferred", "Lkotlin/Function0;", "cachedSerialNames", "", "", "cast", "Lkotlinx/serialization/KSerializer;", "T", "readExactNBytes", "", "Ljava/io/InputStream;", "Lkotlinx/io/InputStream;", "bytes", "", "kotlinx-serialization-runtime"})
public final class bj
{
  public static final n W(a<? extends n> parama)
  {
    AppMethodBeat.i(199701);
    p.h(parama, "deferred");
    parama = (n)new a(parama);
    AppMethodBeat.o(199701);
    return parama;
  }
  
  public static final Set<String> e(n paramn)
  {
    AppMethodBeat.i(199700);
    p.h(paramn, "$this$cachedSerialNames");
    if ((paramn instanceof au))
    {
      paramn = ((au)paramn).gBz().keySet();
      AppMethodBeat.o(199700);
      return paramn;
    }
    HashSet localHashSet = new HashSet(paramn.gBv());
    int j = paramn.gBv();
    int i = 0;
    while (i < j)
    {
      ((Collection)localHashSet).add(paramn.amt(i));
      i += 1;
    }
    paramn = (Set)localHashSet;
    AppMethodBeat.o(199700);
    return paramn;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlinx/serialization/internal/UtilKt$defer$1", "Lkotlinx/serialization/SerialDescriptor;", "elementsCount", "", "getElementsCount", "()I", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "original", "getOriginal", "()Lkotlinx/serialization/SerialDescriptor;", "original$delegate", "Lkotlin/Lazy;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "", "kotlinx-serialization-runtime"})
  public static final class a
    implements n
  {
    private final f Okh;
    
    a(a parama)
    {
      AppMethodBeat.i(199659);
      this.Okh = g.O(parama);
      AppMethodBeat.o(199659);
    }
    
    private final n gBF()
    {
      AppMethodBeat.i(199652);
      n localn = (n)this.Okh.getValue();
      AppMethodBeat.o(199652);
      return localn;
    }
    
    public final String amt(int paramInt)
    {
      AppMethodBeat.i(199656);
      String str = gBF().amt(paramInt);
      AppMethodBeat.o(199656);
      return str;
    }
    
    public final n amu(int paramInt)
    {
      AppMethodBeat.i(199658);
      n localn = gBF().amu(paramInt);
      AppMethodBeat.o(199658);
      return localn;
    }
    
    public final int beQ(String paramString)
    {
      AppMethodBeat.i(199657);
      p.h(paramString, "name");
      int i = gBF().beQ(paramString);
      AppMethodBeat.o(199657);
      return i;
    }
    
    public final String gBs()
    {
      AppMethodBeat.i(199653);
      String str = gBF().gBs();
      AppMethodBeat.o(199653);
      return str;
    }
    
    public final s gBt()
    {
      AppMethodBeat.i(199654);
      s locals = gBF().gBt();
      AppMethodBeat.o(199654);
      return locals;
    }
    
    public final boolean gBu()
    {
      return false;
    }
    
    public final int gBv()
    {
      AppMethodBeat.i(199655);
      int i = gBF().gBv();
      AppMethodBeat.o(199655);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.bj
 * JD-Core Version:    0.7.0.1
 */