package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.a.e;
import kotlin.a.j;

public enum h
{
  public static final Set<h> TFS;
  public static final Set<h> TFT;
  public static final a TFU;
  private final boolean TFR;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(59800);
    Object localObject1 = new h("VISIBILITY", 0, true);
    TFE = (h)localObject1;
    Object localObject2 = new h("MODALITY", 1, true);
    TFF = (h)localObject2;
    h localh1 = new h("OVERRIDE", 2, true);
    TFG = localh1;
    h localh2 = new h("ANNOTATIONS", 3, false);
    TFH = localh2;
    h localh3 = new h("INNER", 4, true);
    TFI = localh3;
    h localh4 = new h("MEMBER_KIND", 5, true);
    TFJ = localh4;
    h localh5 = new h("DATA", 6, true);
    TFK = localh5;
    h localh6 = new h("INLINE", 7, true);
    TFL = localh6;
    h localh7 = new h("EXPECT", 8, true);
    TFM = localh7;
    h localh8 = new h("ACTUAL", 9, true);
    TFN = localh8;
    h localh9 = new h("CONST", 10, true);
    TFO = localh9;
    h localh10 = new h("LATEINIT", 11, true);
    TFP = localh10;
    TFQ = new h[] { localObject1, localObject2, localh1, localh2, localh3, localh4, localh5, localh6, localh7, localh8, localh9, localh10 };
    TFU = new a((byte)0);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList();
    int j = localObject1.length;
    while (i < j)
    {
      localh1 = localObject1[i];
      if (localh1.TFR) {
        ((Collection)localObject2).add(localh1);
      }
      i += 1;
    }
    TFS = j.r((Iterable)localObject2);
    TFT = e.Y(values());
    AppMethodBeat.o(59800);
  }
  
  private h(boolean paramBoolean)
  {
    this.TFR = paramBoolean;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.i.h
 * JD-Core Version:    0.7.0.1
 */