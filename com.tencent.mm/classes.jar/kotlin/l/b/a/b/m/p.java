package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.c.ai;
import kotlin.l.b.a.b.b.l;

public final class p
{
  public static ba a(List<as> paramList1, ay paramay, l paraml, List<as> paramList2)
  {
    AppMethodBeat.i(60639);
    if (paramList1 == null) {
      atM(0);
    }
    if (paramay == null) {
      atM(1);
    }
    if (paraml == null) {
      atM(2);
    }
    if (paramList2 == null) {
      atM(3);
    }
    paramList1 = a(paramList1, paramay, paraml, paramList2, null);
    if (paramList1 == null)
    {
      paramList1 = new AssertionError("Substitution failed");
      AppMethodBeat.o(60639);
      throw paramList1;
    }
    if (paramList1 == null) {
      atM(4);
    }
    AppMethodBeat.o(60639);
    return paramList1;
  }
  
  public static ba a(List<as> paramList1, ay paramay, l paraml, List<as> paramList2, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(60640);
    if (paramList1 == null) {
      atM(5);
    }
    if (paramay == null) {
      atM(6);
    }
    if (paraml == null) {
      atM(7);
    }
    if (paramList2 == null) {
      atM(8);
    }
    Object localObject1 = new HashMap();
    HashMap localHashMap = new HashMap();
    int i = 0;
    Object localObject2 = paramList1.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      as localas = (as)((Iterator)localObject2).next();
      ai localai = ai.a(paraml, localas.hzL(), localas.hAK(), localas.hAJ(), localas.hAH(), i, an.ThK, localas.hAI());
      ((Map)localObject1).put(localas.hzz(), new ax(localai.hAG()));
      localHashMap.put(localas, localai);
      paramList2.add(localai);
      i += 1;
    }
    paramay = ba.b(paramay, au.cB((Map)localObject1));
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (as)paramList1.next();
      paraml = (ai)localHashMap.get(paramList2);
      paramList2 = paramList2.hyo().iterator();
      while (paramList2.hasNext())
      {
        localObject1 = (ab)paramList2.next();
        localObject2 = paramay.c((ab)localObject1, bh.TOR);
        if (localObject2 == null)
        {
          AppMethodBeat.o(60640);
          return null;
        }
        if ((localObject2 != localObject1) && (paramArrayOfBoolean != null)) {
          paramArrayOfBoolean[0] = true;
        }
        paraml.K((ab)localObject2);
      }
      paraml.setInitialized();
    }
    AppMethodBeat.o(60640);
    return paramay;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.p
 * JD-Core Version:    0.7.0.1
 */