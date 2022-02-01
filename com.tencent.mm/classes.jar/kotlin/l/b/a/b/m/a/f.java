package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.s;
import kotlin.l.b.a.b.j.a.a.c;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bi;
import kotlin.l.b.a.b.m.bk;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.d.a;
import kotlin.l.b.a.b.m.x;
import kotlin.l.e;

public abstract class f
{
  private static al d(al paramal)
  {
    int i = 1;
    Object localObject1 = null;
    Object localObject2 = paramal.kzm();
    label40:
    label46:
    Object localObject3;
    Object localObject4;
    if ((localObject2 instanceof c))
    {
      localObject1 = ((c)localObject2).ajjx;
      if (((az)localObject1).kAN() == bl.ajqN)
      {
        if (i == 0) {
          break label150;
        }
        if (localObject1 != null) {
          break label155;
        }
        localObject1 = null;
      }
      for (;;)
      {
        if (((c)localObject2).ajjy == null)
        {
          localObject3 = (c)localObject2;
          localObject4 = ((c)localObject2).ajjx;
          Object localObject5 = (Iterable)((c)localObject2).kpG();
          Collection localCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject5, 10));
          localObject5 = ((Iterable)localObject5).iterator();
          for (;;)
          {
            if (((Iterator)localObject5).hasNext())
            {
              localCollection.add(((ad)((Iterator)localObject5).next()).kAK());
              continue;
              i = 0;
              break;
              label150:
              localObject1 = null;
              break label40;
              label155:
              localObject1 = ((az)localObject1).koG();
              if (localObject1 == null)
              {
                localObject1 = null;
                break label46;
              }
              localObject1 = ((ad)localObject1).kAK();
              break label46;
            }
          }
          ((c)localObject3).ajjy = new j((az)localObject4, (List)localCollection, (byte)0);
        }
      }
      localObject3 = kotlin.l.b.a.b.m.c.b.ajrC;
      localObject2 = ((c)localObject2).ajjy;
      s.checkNotNull(localObject2);
      return (al)new i((kotlin.l.b.a.b.m.c.b)localObject3, (j)localObject2, (bk)localObject1, paramal.knl(), paramal.ksB(), 32);
    }
    if ((localObject2 instanceof kotlin.l.b.a.b.j.b.p)) {
      throw null;
    }
    if (((localObject2 instanceof ac)) && (paramal.ksB()))
    {
      paramal = (ac)localObject2;
      localObject4 = (Iterable)paramal.ajpO;
      localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      for (i = 0; ((Iterator)localObject4).hasNext(); i = 1) {
        ((Collection)localObject3).add(a.at((ad)((Iterator)localObject4).next()));
      }
      localObject3 = (List)localObject3;
      if (i == 0)
      {
        paramal = null;
        if (paramal != null) {
          break label413;
        }
        paramal = (ac)localObject2;
      }
      label413:
      for (;;)
      {
        return paramal.kAJ();
        paramal = paramal.ajpN;
        if (paramal == null) {}
        for (paramal = (al)localObject1;; paramal = a.at(paramal))
        {
          paramal = new ac((Collection)localObject3).ag(paramal);
          break;
        }
      }
    }
    return paramal;
  }
  
  public final bk x(kotlin.l.b.a.b.m.c.i parami)
  {
    s.u(parami, "type");
    if (!(parami instanceof ad)) {
      throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
    }
    bk localbk = ((ad)parami).kAK();
    if ((localbk instanceof al)) {
      parami = (bk)d((al)localbk);
    }
    for (;;)
    {
      return bi.a(parami, (ad)localbk, (kotlin.g.a.b)new b());
      if (!(localbk instanceof x)) {
        break;
      }
      parami = d(((x)localbk).ajpE);
      al localal = d(((x)localbk).ajpF);
      if ((parami != ((x)localbk).ajpE) || (localal != ((x)localbk).ajpF)) {
        parami = ae.a(parami, localal);
      } else {
        parami = localbk;
      }
    }
    throw new kotlin.p();
  }
  
  public static final class a
    extends f
  {
    public static final a ajqZ;
    
    static
    {
      AppMethodBeat.i(191681);
      ajqZ = new a();
      AppMethodBeat.o(191681);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.f
 * JD-Core Version:    0.7.0.1
 */