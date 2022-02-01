package kotlin.l.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a.p;
import kotlin.l.b.a.b.d.a.w;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.c;

public final class a
{
  public static final a aiBf;
  private static final Set<b> aiBg;
  
  static
  {
    AppMethodBeat.i(191373);
    aiBf = new a();
    Object localObject = (Iterable)p.listOf(new c[] { w.aiPt, w.aiPB, w.aiPC, w.aiPw, w.aiPx, w.aiPz });
    Collection localCollection = (Collection)new LinkedHashSet();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(b.s((c)((Iterator)localObject).next()));
    }
    aiBg = (Set)localCollection;
    AppMethodBeat.o(191373);
  }
  
  public static Set<b> kmC()
  {
    return aiBg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */