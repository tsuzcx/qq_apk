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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"defer", "Lkotlinx/serialization/SerialDescriptor;", "deferred", "Lkotlin/Function0;", "cachedSerialNames", "", "", "cast", "Lkotlinx/serialization/KSerializer;", "T", "readExactNBytes", "", "Ljava/io/InputStream;", "Lkotlinx/io/InputStream;", "bytes", "", "kotlinx-serialization-runtime"})
public final class bj
{
  public static final n az(a<? extends n> parama)
  {
    AppMethodBeat.i(254418);
    p.k(parama, "deferred");
    parama = (n)new a(parama);
    AppMethodBeat.o(254418);
    return parama;
  }
  
  public static final Set<String> e(n paramn)
  {
    AppMethodBeat.i(254417);
    p.k(paramn, "$this$cachedSerialNames");
    if ((paramn instanceof au))
    {
      paramn = ((au)paramn).iTN().keySet();
      AppMethodBeat.o(254417);
      return paramn;
    }
    HashSet localHashSet = new HashSet(paramn.iTI());
    int j = paramn.iTI();
    int i = 0;
    while (i < j)
    {
      ((Collection)localHashSet).add(paramn.aFX(i));
      i += 1;
    }
    paramn = (Set)localHashSet;
    AppMethodBeat.o(254417);
    return paramn;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlinx/serialization/internal/UtilKt$defer$1", "Lkotlinx/serialization/SerialDescriptor;", "elementsCount", "", "getElementsCount", "()I", "kind", "Lkotlinx/serialization/SerialKind;", "getKind", "()Lkotlinx/serialization/SerialKind;", "original", "getOriginal", "()Lkotlinx/serialization/SerialDescriptor;", "original$delegate", "Lkotlin/Lazy;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "", "kotlinx-serialization-runtime"})
  public static final class a
    implements n
  {
    private final f abCs;
    
    a(a parama)
    {
      AppMethodBeat.i(254317);
      this.abCs = g.ar(parama);
      AppMethodBeat.o(254317);
    }
    
    private final n iTT()
    {
      AppMethodBeat.i(254304);
      n localn = (n)this.abCs.getValue();
      AppMethodBeat.o(254304);
      return localn;
    }
    
    public final String aFX(int paramInt)
    {
      AppMethodBeat.i(254311);
      String str = iTT().aFX(paramInt);
      AppMethodBeat.o(254311);
      return str;
    }
    
    public final n aFY(int paramInt)
    {
      AppMethodBeat.i(254315);
      n localn = iTT().aFY(paramInt);
      AppMethodBeat.o(254315);
      return localn;
    }
    
    public final int bHI(String paramString)
    {
      AppMethodBeat.i(254313);
      p.k(paramString, "name");
      int i = iTT().bHI(paramString);
      AppMethodBeat.o(254313);
      return i;
    }
    
    public final String iTF()
    {
      AppMethodBeat.i(254306);
      String str = iTT().iTF();
      AppMethodBeat.o(254306);
      return str;
    }
    
    public final s iTG()
    {
      AppMethodBeat.i(254309);
      s locals = iTT().iTG();
      AppMethodBeat.o(254309);
      return locals;
    }
    
    public final boolean iTH()
    {
      return false;
    }
    
    public final int iTI()
    {
      AppMethodBeat.i(254310);
      int i = iTT().iTI();
      AppMethodBeat.o(254310);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.bj
 * JD-Core Version:    0.7.0.1
 */