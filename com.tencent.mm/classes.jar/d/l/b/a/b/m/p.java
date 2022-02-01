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
      ajW(0);
    }
    if (paramay == null) {
      ajW(1);
    }
    if (paraml == null) {
      ajW(2);
    }
    if (paramList2 == null) {
      ajW(3);
    }
    paramList1 = a(paramList1, paramay, paraml, paramList2, null);
    if (paramList1 == null)
    {
      paramList1 = new AssertionError("Substitution failed");
      AppMethodBeat.o(60639);
      throw paramList1;
    }
    if (paramList1 == null) {
      ajW(4);
    }
    AppMethodBeat.o(60639);
    return paramList1;
  }
  
  public static ba a(List<as> paramList1, ay paramay, l paraml, List<as> paramList2, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(60640);
    if (paramList1 == null) {
      ajW(5);
    }
    if (paramay == null) {
      ajW(6);
    }
    if (paraml == null) {
      ajW(7);
    }
    if (paramList2 == null) {
      ajW(8);
    }
    Object localObject1 = new HashMap();
    HashMap localHashMap = new HashMap();
    int i = 0;
    Object localObject2 = paramList1.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      as localas = (as)((Iterator)localObject2).next();
      ai localai = ai.a(paraml, localas.gmj(), localas.gni(), localas.gnh(), localas.gnf(), i, an.Nsc, localas.gng());
      ((Map)localObject1).put(localas.glW(), new ax(localai.gne()));
      localHashMap.put(localas, localai);
      paramList2.add(localai);
      i += 1;
    }
    paramay = ba.b(paramay, au.co((Map)localObject1));
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (as)paramList1.next();
      paraml = (ai)localHashMap.get(paramList2);
      paramList2 = paramList2.gkL().iterator();
      while (paramList2.hasNext())
      {
        localObject1 = (ab)paramList2.next();
        localObject2 = paramay.c((ab)localObject1, bh.NZX);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.p
 * JD-Core Version:    0.7.0.1
 */