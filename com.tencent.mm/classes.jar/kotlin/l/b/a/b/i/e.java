package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.a.k;
import kotlin.a.p;

public enum e
{
  public static final e.a ajgU;
  public static final Set<e> ajgW;
  public static final Set<e> ajgX;
  private final boolean ajgV;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(59800);
    ajgY = new e("VISIBILITY", 0, true);
    ajgZ = new e("MODALITY", 1, true);
    ajha = new e("OVERRIDE", 2, true);
    ajhb = new e("ANNOTATIONS", 3, false);
    ajhc = new e("INNER", 4, true);
    ajhd = new e("MEMBER_KIND", 5, true);
    ajhe = new e("DATA", 6, true);
    ajhf = new e("INLINE", 7, true);
    ajhg = new e("EXPECT", 8, true);
    ajhh = new e("ACTUAL", 9, true);
    ajhi = new e("CONST", 10, true);
    ajhj = new e("LATEINIT", 11, true);
    ajhk = new e("FUN", 12, true);
    ajhl = new e("VALUE", 13, true);
    ajhm = new e[] { ajgY, ajgZ, ajha, ajhb, ajhc, ajhd, ajhe, ajhf, ajhg, ajhh, ajhi, ajhj, ajhk, ajhl };
    ajgU = new e.a((byte)0);
    e[] arrayOfe = values();
    Collection localCollection = (Collection)new ArrayList();
    int j = arrayOfe.length;
    while (i < j)
    {
      e locale = arrayOfe[i];
      if (locale.ajgV) {
        localCollection.add(locale);
      }
      i += 1;
    }
    ajgW = p.r((Iterable)localCollection);
    ajgX = k.ag(values());
    AppMethodBeat.o(59800);
  }
  
  private e(boolean paramBoolean)
  {
    this.ajgV = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.i.e
 * JD-Core Version:    0.7.0.1
 */