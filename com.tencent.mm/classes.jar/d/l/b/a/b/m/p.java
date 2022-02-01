package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.c.ai;
import d.l.b.a.b.b.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class p
{
  public static ba a(List<as> paramList1, ay paramay, l paraml, List<as> paramList2)
  {
    AppMethodBeat.i(60639);
    if (paramList1 == null) {
      ajm(0);
    }
    if (paramay == null) {
      ajm(1);
    }
    if (paraml == null) {
      ajm(2);
    }
    if (paramList2 == null) {
      ajm(3);
    }
    paramList1 = a(paramList1, paramay, paraml, paramList2, null);
    if (paramList1 == null)
    {
      paramList1 = new AssertionError("Substitution failed");
      AppMethodBeat.o(60639);
      throw paramList1;
    }
    if (paramList1 == null) {
      ajm(4);
    }
    AppMethodBeat.o(60639);
    return paramList1;
  }
  
  public static ba a(List<as> paramList1, ay paramay, l paraml, List<as> paramList2, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(60640);
    if (paramList1 == null) {
      ajm(5);
    }
    if (paramay == null) {
      ajm(6);
    }
    if (paraml == null) {
      ajm(7);
    }
    if (paramList2 == null) {
      ajm(8);
    }
    Object localObject1 = new HashMap();
    HashMap localHashMap = new HashMap();
    int i = 0;
    Object localObject2 = paramList1.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      as localas = (as)((Iterator)localObject2).next();
      ai localai = ai.a(paraml, localas.ghH(), localas.giG(), localas.giF(), localas.giD(), i, an.MUX, localas.giE());
      ((Map)localObject1).put(localas.ghu(), new ax(localai.giC()));
      localHashMap.put(localas, localai);
      paramList2.add(localai);
      i += 1;
    }
    paramay = ba.b(paramay, au.cj((Map)localObject1));
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (as)paramList1.next();
      paraml = (ai)localHashMap.get(paramList2);
      paramList2 = paramList2.ggj().iterator();
      while (paramList2.hasNext())
      {
        localObject1 = (ab)paramList2.next();
        localObject2 = paramay.c((ab)localObject1, bh.NCQ);
        if (localObject2 == null)
        {
          AppMethodBeat.o(60640);
          return null;
        }
        if ((localObject2 != localObject1) && (paramArrayOfBoolean != null)) {
          paramArrayOfBoolean[0] = true;
        }
        paraml.L((ab)localObject2);
      }
      paraml.setInitialized();
    }
    AppMethodBeat.o(60640);
    return paramay;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.p
 * JD-Core Version:    0.7.0.1
 */