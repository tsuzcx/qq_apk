package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public final class b
  implements e, f
{
  private Queue<a> BhA = null;
  private boolean BhB = false;
  
  private void emW()
  {
    AppMethodBeat.i(28921);
    if (this.BhB)
    {
      AppMethodBeat.o(28921);
      return;
    }
    if (this.BhA.size() == 0)
    {
      AppMethodBeat.o(28921);
      return;
    }
    Object localObject = (a)this.BhA.peek();
    if (((a)localObject).BhC.size() == 0)
    {
      this.BhA.poll();
      ba.aBQ();
      c.ajl().set(8193, ((a)localObject).iXN);
      ba.aBQ();
      c.ajl().set(8449, Long.valueOf(bt.aQJ()));
      AppMethodBeat.o(28921);
      return;
    }
    localObject = (String)((a)localObject).BhC.peek();
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      AppMethodBeat.o(28921);
      return;
    }
    this.BhB = true;
    localObject = new a((String)localObject);
    ba.aiU().a(141, this);
    ba.aiU().a((n)localObject, 0);
    AppMethodBeat.o(28921);
  }
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(28920);
    parama = z.a(parama.gqE.Fvk);
    if (this.BhA == null) {
      this.BhA = new LinkedList();
    }
    parama = new a(parama);
    if (parama.iXN != null)
    {
      this.BhA.offer(parama);
      emW();
    }
    AppMethodBeat.o(28920);
    return null;
  }
  
  public final void b(e.c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(28922);
    if (paramn.getType() != 141)
    {
      this.BhB = false;
      AppMethodBeat.o(28922);
      return;
    }
    ba.aiU().b(141, this);
    paramString = ((a)paramn).url;
    paramn = (a)this.BhA.peek();
    if ((paramn == null) || (paramn.BhC.size() == 0))
    {
      ad.e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
      this.BhA = new LinkedList();
      this.BhB = false;
      AppMethodBeat.o(28922);
      return;
    }
    if (paramn.BhC.size() == 0)
    {
      ad.e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
      this.BhA.poll();
      this.BhB = false;
      AppMethodBeat.o(28922);
      return;
    }
    if (!((String)paramn.BhC.peek()).equals(paramString))
    {
      ad.e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
      this.BhA.poll();
      this.BhB = false;
      AppMethodBeat.o(28922);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.PushMessageExtension", "down failed [" + paramInt1 + "," + paramInt2 + "] ignore this message : img:[" + paramString + "] ");
      this.BhA.poll();
      this.BhB = false;
      AppMethodBeat.o(28922);
      return;
    }
    paramn.BhC.poll();
    this.BhB = false;
    emW();
    AppMethodBeat.o(28922);
  }
  
  static final class a
  {
    public Queue<String> BhC;
    public String iXN;
    
    a(String paramString)
    {
      AppMethodBeat.i(28919);
      this.iXN = paramString;
      this.BhC = new LinkedList();
      ad.d("MicroMsg.PushMessageExtension", "DoSceneStruct:".concat(String.valueOf(paramString)));
      paramString = com.tencent.mm.pluginsdk.k.a.a.bR(aj.getContext(), paramString);
      if ((paramString == null) || (paramString.size() <= 0))
      {
        ad.e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
        AppMethodBeat.o(28919);
        return;
      }
      int i = 0;
      while (i < paramString.size())
      {
        Object localObject = ((com.tencent.mm.pluginsdk.k.a.a)paramString.get(i)).ERm;
        if (localObject != null)
        {
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext()) {
            this.BhC.offer(((Map.Entry)((Iterator)localObject).next()).getValue());
          }
        }
        i += 1;
      }
      AppMethodBeat.o(28919);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.b
 * JD-Core Version:    0.7.0.1
 */