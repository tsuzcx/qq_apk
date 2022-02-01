package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.aj;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.m.d.a;

public final class q
{
  public static be a(List<ba> paramList1, bc parambc, l paraml, List<ba> paramList2)
  {
    AppMethodBeat.i(60639);
    if (paramList1 == null) {
      aKu(0);
    }
    if (parambc == null) {
      aKu(1);
    }
    if (paraml == null) {
      aKu(2);
    }
    if (paramList2 == null) {
      aKu(3);
    }
    paramList1 = a(paramList1, parambc, paraml, paramList2, null);
    if (paramList1 == null)
    {
      paramList1 = new AssertionError("Substitution failed");
      AppMethodBeat.o(60639);
      throw paramList1;
    }
    if (paramList1 == null) {
      aKu(4);
    }
    AppMethodBeat.o(60639);
    return paramList1;
  }
  
  public static be a(List<ba> paramList1, bc parambc, l paraml, List<ba> paramList2, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(60640);
    if (paramList1 == null) {
      aKu(5);
    }
    if (parambc == null) {
      aKu(6);
    }
    if (paraml == null) {
      aKu(7);
    }
    if (paramList2 == null) {
      aKu(8);
    }
    Object localObject1 = new HashMap();
    HashMap localHashMap = new HashMap();
    int i = 0;
    Iterator localIterator = paramList1.iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (ba)localIterator.next();
      aj localaj = aj.a(paraml, ((ba)localObject2).knl(), ((ba)localObject2).kon(), ((ba)localObject2).kom(), ((ba)localObject2).kok(), i, av.aiHu, ((ba)localObject2).kol());
      ((Map)localObject1).put(((ba)localObject2).kmZ(), new bb(localaj.koj()));
      localHashMap.put(localObject2, localaj);
      paramList2.add(localaj);
      i += 1;
    }
    paramList2 = ay.dE((Map)localObject1);
    paraml = be.b(parambc, paramList2);
    parambc = be.b(parambc.kAP(), paramList2);
    paramList2 = paramList1.iterator();
    while (paramList2.hasNext())
    {
      paramList1 = (ba)paramList2.next();
      localObject1 = (aj)localHashMap.get(paramList1);
      localIterator = paramList1.klF().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (ad)localIterator.next();
        paramList1 = ((ad)localObject2).kzm().knA();
        if (((paramList1 instanceof ba)) && (a.e((ba)paramList1))) {}
        for (paramList1 = paraml;; paramList1 = parambc)
        {
          paramList1 = paramList1.c((ad)localObject2, bl.ajqO);
          if (paramList1 != null) {
            break;
          }
          AppMethodBeat.o(60640);
          return null;
        }
        if ((paramList1 != localObject2) && (paramArrayOfBoolean != null)) {
          paramArrayOfBoolean[0] = true;
        }
        ((aj)localObject1).D(paramList1);
      }
      ((aj)localObject1).kqm();
    }
    AppMethodBeat.o(60640);
    return paraml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.q
 * JD-Core Version:    0.7.0.1
 */