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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"defer", "Lkotlinx/serialization/SerialDescriptor;", "deferred", "Lkotlin/Function0;", "cachedSerialNames", "", "", "cast", "Lkotlinx/serialization/KSerializer;", "T", "readExactNBytes", "", "Ljava/io/InputStream;", "Lkotlinx/io/InputStream;", "bytes", "", "kotlinx-serialization-runtime"})
public final class bj
{
  public static final n W(a<? extends n> parama)
  {
    AppMethodBeat.i(191113);
    p.h(parama, "deferred");
    parama = (n)new a(parama);
    AppMethodBeat.o(191113);
    return parama;
  }
  
  public static final Set<String> e(n paramn)
  {
    AppMethodBeat.i(191112);
    p.h(paramn, "$this$cachedSerialNames");
    if ((paramn instanceof au))
    {
      paramn = ((au)paramn).gwX().keySet();
      AppMethodBeat.o(191112);
      return paramn;
    }
    HashSet localHashSet = new HashSet(paramn.gwT());
    int j = paramn.gwT();
    int i = 0;
    while (i < j)
    {
      ((Collection)localHashSet).add(paramn.alJ(i));
      i += 1;
    }
    paramn = (Set)localHashSet;
    AppMethodBeat.o(191112);
    return paramn;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlinx/serialization/internal/UtilKt$defer$1", "Lkotlinx/serialization/SerialDescriptor;", "elementsCount", "", "getElementsCount", "()I", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "original", "getOriginal", "()Lkotlinx/serialization/SerialDescriptor;", "original$delegate", "Lkotlin/Lazy;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "", "kotlinx-serialization-runtime"})
  public static final class a
    implements n
  {
    private final f NNb;
    
    a(a parama)
    {
      AppMethodBeat.i(191071);
      this.NNb = g.O(parama);
      AppMethodBeat.o(191071);
    }
    
    private final n gxd()
    {
      AppMethodBeat.i(191064);
      n localn = (n)this.NNb.getValue();
      AppMethodBeat.o(191064);
      return localn;
    }
    
    public final String alJ(int paramInt)
    {
      AppMethodBeat.i(191068);
      String str = gxd().alJ(paramInt);
      AppMethodBeat.o(191068);
      return str;
    }
    
    public final n alK(int paramInt)
    {
      AppMethodBeat.i(191070);
      n localn = gxd().alK(paramInt);
      AppMethodBeat.o(191070);
      return localn;
    }
    
    public final int bdm(String paramString)
    {
      AppMethodBeat.i(191069);
      p.h(paramString, "name");
      int i = gxd().bdm(paramString);
      AppMethodBeat.o(191069);
      return i;
    }
    
    public final String gwQ()
    {
      AppMethodBeat.i(191065);
      String str = gxd().gwQ();
      AppMethodBeat.o(191065);
      return str;
    }
    
    public final s gwR()
    {
      AppMethodBeat.i(191066);
      s locals = gxd().gwR();
      AppMethodBeat.o(191066);
      return locals;
    }
    
    public final boolean gwS()
    {
      return false;
    }
    
    public final int gwT()
    {
      AppMethodBeat.i(191067);
      int i = gxd().gwT();
      AppMethodBeat.o(191067);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.bj
 * JD-Core Version:    0.7.0.1
 */