package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public final class b
  implements f, g
{
  private Queue<a> yCL = null;
  private boolean yCM = false;
  
  private void dMg()
  {
    AppMethodBeat.i(28921);
    if (this.yCM)
    {
      AppMethodBeat.o(28921);
      return;
    }
    if (this.yCL.size() == 0)
    {
      AppMethodBeat.o(28921);
      return;
    }
    Object localObject = (a)this.yCL.peek();
    if (((a)localObject).yCN.size() == 0)
    {
      this.yCL.poll();
      az.arV();
      c.afk().set(8193, ((a)localObject).iev);
      az.arV();
      c.afk().set(8449, Long.valueOf(bt.aGK()));
      AppMethodBeat.o(28921);
      return;
    }
    localObject = (String)((a)localObject).yCN.peek();
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      AppMethodBeat.o(28921);
      return;
    }
    this.yCM = true;
    localObject = new a((String)localObject);
    az.aeS().a(141, this);
    az.aeS().a((n)localObject, 0);
    AppMethodBeat.o(28921);
  }
  
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(28920);
    parama = z.a(parama.fTo.Cxz);
    if (this.yCL == null) {
      this.yCL = new LinkedList();
    }
    parama = new a(parama);
    if (parama.iev != null)
    {
      this.yCL.offer(parama);
      dMg();
    }
    AppMethodBeat.o(28920);
    return null;
  }
  
  public final void b(f.c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(28922);
    if (paramn.getType() != 141)
    {
      this.yCM = false;
      AppMethodBeat.o(28922);
      return;
    }
    az.aeS().b(141, this);
    paramString = ((a)paramn).url;
    paramn = (a)this.yCL.peek();
    if ((paramn == null) || (paramn.yCN.size() == 0))
    {
      ad.e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
      this.yCL = new LinkedList();
      this.yCM = false;
      AppMethodBeat.o(28922);
      return;
    }
    if (paramn.yCN.size() == 0)
    {
      ad.e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
      this.yCL.poll();
      this.yCM = false;
      AppMethodBeat.o(28922);
      return;
    }
    if (!((String)paramn.yCN.peek()).equals(paramString))
    {
      ad.e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
      this.yCL.poll();
      this.yCM = false;
      AppMethodBeat.o(28922);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.PushMessageExtension", "down failed [" + paramInt1 + "," + paramInt2 + "] ignore this message : img:[" + paramString + "] ");
      this.yCL.poll();
      this.yCM = false;
      AppMethodBeat.o(28922);
      return;
    }
    paramn.yCN.poll();
    this.yCM = false;
    dMg();
    AppMethodBeat.o(28922);
  }
  
  static final class a
  {
    public String iev;
    public Queue<String> yCN;
    
    a(String paramString)
    {
      AppMethodBeat.i(28919);
      this.iev = paramString;
      this.yCN = new LinkedList();
      ad.d("MicroMsg.PushMessageExtension", "DoSceneStruct:".concat(String.valueOf(paramString)));
      paramString = com.tencent.mm.pluginsdk.i.a.a.bM(aj.getContext(), paramString);
      if ((paramString == null) || (paramString.size() <= 0))
      {
        ad.e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
        AppMethodBeat.o(28919);
        return;
      }
      int i = 0;
      while (i < paramString.size())
      {
        Object localObject = ((com.tencent.mm.pluginsdk.i.a.a)paramString.get(i)).BTU;
        if (localObject != null)
        {
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext()) {
            this.yCN.offer(((Map.Entry)((Iterator)localObject).next()).getValue());
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