package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.ay.a;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bk;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.c.b;
import kotlin.l.b.a.b.m.d.a;
import kotlin.r;

public final class k
{
  private static final List<az> a(bk parambk, b paramb)
  {
    AppMethodBeat.i(191700);
    if (parambk.klR().size() != parambk.kzm().klq().size())
    {
      AppMethodBeat.o(191700);
      return null;
    }
    List localList = parambk.klR();
    Object localObject1 = (Iterable)localList;
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject1).hasNext()) {
        if (((az)((Iterator)localObject1).next()).kAN() == bl.ajqM)
        {
          i = 1;
          label114:
          if (i != 0) {
            break label134;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label141;
      }
      AppMethodBeat.o(191700);
      return null;
      i = 0;
      break label114;
      label134:
      break;
    }
    label141:
    localObject1 = (Iterable)localList;
    Object localObject2 = parambk.kzm().klq();
    s.s(localObject2, "type.constructor.parameters");
    localObject1 = (Iterable)p.d((Iterable)localObject1, (Iterable)localObject2);
    Object localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    Object localObject4 = ((Iterable)localObject1).iterator();
    Object localObject5;
    while (((Iterator)localObject4).hasNext())
    {
      localObject1 = (r)((Iterator)localObject4).next();
      localObject2 = (az)((r)localObject1).bsC;
      localObject5 = (ba)((r)localObject1).bsD;
      if (((az)localObject2).kAN() == bl.ajqM)
      {
        localObject1 = localObject2;
        ((Collection)localObject3).add(localObject1);
      }
      else
      {
        if ((!((az)localObject2).kAM()) && (((az)localObject2).kAN() == bl.ajqN)) {}
        for (localObject1 = ((az)localObject2).koG().kAK();; localObject1 = null)
        {
          s.s(localObject5, "parameter");
          localObject1 = a.aF((ad)new i(paramb, (bk)localObject1, (az)localObject2, (ba)localObject5));
          break;
        }
      }
    }
    paramb = (List)localObject3;
    localObject1 = ay.ajqs;
    localObject1 = ay.a.a(parambk.kzm(), paramb).kAO();
    int k = localList.size() - 1;
    if (k >= 0) {}
    int j;
    for (i = 0;; i = j)
    {
      j = i + 1;
      localObject2 = (az)localList.get(i);
      localObject3 = (az)paramb.get(i);
      if (((az)localObject2).kAN() != bl.ajqM)
      {
        localObject4 = ((ba)parambk.kzm().klq().get(i)).klF();
        s.s(localObject4, "type.constructor.parameters[index].upperBounds");
        localObject5 = (Iterable)localObject4;
        localObject4 = (Collection)new ArrayList();
        localObject5 = ((Iterable)localObject5).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          ad localad = (ad)((Iterator)localObject5).next();
          ((Collection)localObject4).add(f.a.ajqZ.x((kotlin.l.b.a.b.m.c.i)((be)localObject1).b(localad, bl.ajqM).kAK()));
        }
        localObject4 = (List)localObject4;
        if ((!((az)localObject2).kAM()) && (((az)localObject2).kAN() == bl.ajqO)) {
          ((Collection)localObject4).add(f.a.ajqZ.x((kotlin.l.b.a.b.m.c.i)((az)localObject2).koG().kAK()));
        }
        ((i)((az)localObject3).koG()).ajrd.pg((List)localObject4);
      }
      if (j > k)
      {
        AppMethodBeat.o(191700);
        return paramb;
      }
    }
  }
  
  public static final al a(al paramal, b paramb)
  {
    AppMethodBeat.i(61083);
    s.u(paramal, "type");
    s.u(paramb, "status");
    paramb = a((bk)paramal, paramb);
    if (paramb == null)
    {
      AppMethodBeat.o(61083);
      return null;
    }
    paramal = a((bk)paramal, paramb);
    AppMethodBeat.o(61083);
    return paramal;
  }
  
  private static final al a(bk parambk, List<? extends az> paramList)
  {
    AppMethodBeat.i(191691);
    parambk = ae.c(parambk.knl(), parambk.kzm(), paramList, parambk.ksB());
    AppMethodBeat.o(191691);
    return parambk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.k
 * JD-Core Version:    0.7.0.1
 */