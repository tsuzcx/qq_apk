package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.a.e;
import kotlin.a.j;

public enum h
{
  public static final Set<h> abiw;
  public static final Set<h> abix;
  public static final a abiy;
  private final boolean abiv;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(59800);
    Object localObject1 = new h("VISIBILITY", 0, true);
    abii = (h)localObject1;
    Object localObject2 = new h("MODALITY", 1, true);
    abij = (h)localObject2;
    h localh1 = new h("OVERRIDE", 2, true);
    abik = localh1;
    h localh2 = new h("ANNOTATIONS", 3, false);
    abil = localh2;
    h localh3 = new h("INNER", 4, true);
    abim = localh3;
    h localh4 = new h("MEMBER_KIND", 5, true);
    abin = localh4;
    h localh5 = new h("DATA", 6, true);
    abio = localh5;
    h localh6 = new h("INLINE", 7, true);
    abip = localh6;
    h localh7 = new h("EXPECT", 8, true);
    abiq = localh7;
    h localh8 = new h("ACTUAL", 9, true);
    abir = localh8;
    h localh9 = new h("CONST", 10, true);
    abis = localh9;
    h localh10 = new h("LATEINIT", 11, true);
    abit = localh10;
    abiu = new h[] { localObject1, localObject2, localh1, localh2, localh3, localh4, localh5, localh6, localh7, localh8, localh9, localh10 };
    abiy = new a((byte)0);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList();
    int j = localObject1.length;
    while (i < j)
    {
      localh1 = localObject1[i];
      if (localh1.abiv) {
        ((Collection)localObject2).add(localh1);
      }
      i += 1;
    }
    abiw = j.r((Iterable)localObject2);
    abix = e.ac(values());
    AppMethodBeat.o(59800);
  }
  
  private h(boolean paramBoolean)
  {
    this.abiv = paramBoolean;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.i.h
 * JD-Core Version:    0.7.0.1
 */