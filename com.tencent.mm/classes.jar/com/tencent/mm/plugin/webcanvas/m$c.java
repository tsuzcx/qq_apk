package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class m$c
  implements Runnable
{
  public static final c IAH;
  
  static
  {
    AppMethodBeat.i(224701);
    IAH = new c();
    AppMethodBeat.o(224701);
  }
  
  public final void run()
  {
    AppMethodBeat.i(224700);
    long l1 = System.currentTimeMillis();
    Object localObject1 = j.ac(new String[] { "wxf337cbaa27790d8e", "wxfedb0854e2b1820d", "wx97b7aebac2183fd2" });
    Object localObject2 = m.IAG;
    ((ArrayList)localObject1).addAll((Collection)m.fWI());
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      Object localObject3 = new StringBuilder();
      Object localObject4 = m.IAG;
      localObject4 = new o(m.fWG() + '/' + (String)localObject2 + '/');
      localObject3 = m.IAG;
      localObject3 = m.fWT();
      Object localObject5 = m.IAG;
      localObject3 = ((MultiProcessMMKV)localObject3).decodeString(m.aWE((String)localObject2), "");
      localObject5 = m.IAG;
      localObject5 = m.fWT();
      Object localObject6 = m.IAG;
      long l2 = ((MultiProcessMMKV)localObject5).decodeLong(m.aWF((String)localObject2), 0L);
      localObject5 = m.IAG.aWH((String)localObject2);
      if ((((o)localObject4).exists()) && (((o)localObject4).isDirectory()))
      {
        localObject4 = ((o)localObject4).het();
        if (localObject4 != null)
        {
          int j = localObject4.length;
          int i = 0;
          label234:
          if (i < j)
          {
            localObject6 = localObject4[i];
            p.g(localObject6, "file");
            if ((Util.isEqual(((o)localObject6).getAbsolutePath(), (String)localObject3)) || (Util.isEqual(((o)localObject6).getAbsolutePath(), (String)localObject5))) {
              break label342;
            }
            ((o)localObject6).delete();
            Log.i("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg appId=" + (String)localObject2 + ", path=" + ((o)localObject6).getAbsolutePath() + '}');
            localObject6 = l.IAx;
            l.LV(120L);
          }
          for (;;)
          {
            i += 1;
            break label234;
            break;
            label342:
            m localm = m.IAG;
            if ((m.fWI().contains(localObject2)) && ((p.j("wxa06c02b5c00ff39b", localObject2) ^ true)) && (l2 != 0L) && (l1 - l2 > 2592000000L))
            {
              ((o)localObject6).delete();
              Log.i("MicroMsg.WebCanvasStorageLogic", "clearInvalidPkg on timeout appId=" + (String)localObject2 + ", path=" + ((o)localObject6).getAbsolutePath() + '}');
              localObject6 = l.IAx;
              l.LV(121L);
            }
          }
        }
      }
    }
    AppMethodBeat.o(224700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.m.c
 * JD-Core Version:    0.7.0.1
 */