package com.tencent.mm.plugin.performance;

import android.widget.Toast;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class a$a
  implements Runnable
{
  boolean psg;
  
  a$a(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(111021);
    Object localObject1 = new LinkedList();
    Object localObject2 = a.a(this.psf, this.psg, (List)localObject1);
    int j = localObject2[0];
    int k = localObject2[1];
    int i;
    if (j > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a.b)((Iterator)localObject1).next();
        long l = ((a.b)localObject2).psi / j;
        if (l > 0L)
        {
          ArrayList localArrayList = new ArrayList(4);
          IDKey localIDKey = new IDKey();
          localIDKey.SetID(1013);
          localIDKey.SetKey(a.a(l, (a.b)localObject2));
          localIDKey.SetValue(1L);
          localArrayList.add(localIDKey);
          localIDKey = new IDKey();
          localIDKey.SetValue(l);
          localIDKey.SetID(1013);
          localIDKey.SetKey(a.a((a.b)localObject2));
          localArrayList.add(localIDKey);
          localIDKey = new IDKey();
          localIDKey.SetID(1013);
          localIDKey.SetKey(a.b((a.b)localObject2));
          localIDKey.SetValue(1L);
          localArrayList.add(localIDKey);
          e.qrI.b(localArrayList, false);
          if (l <= 3000L) {
            break label311;
          }
          i = 1;
        }
      }
    }
    label311:
    for (;;)
    {
      break;
      if ((i != 0) && (bp.dub())) {
        Toast.makeText(ah.getContext(), String.format("微信后台 %s/%s min严重耗电!", new Object[] { Integer.valueOf(j), Integer.valueOf(k) }), 10000).show();
      }
      a.a(this.psf);
      AppMethodBeat.o(111021);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a.a
 * JD-Core Version:    0.7.0.1
 */