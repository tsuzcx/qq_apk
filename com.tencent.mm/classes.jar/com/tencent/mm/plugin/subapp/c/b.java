package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
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
  private Queue<a> zPZ = null;
  private boolean zQa = false;
  
  private void eaG()
  {
    AppMethodBeat.i(28921);
    if (this.zQa)
    {
      AppMethodBeat.o(28921);
      return;
    }
    if (this.zPZ.size() == 0)
    {
      AppMethodBeat.o(28921);
      return;
    }
    Object localObject = (a)this.zPZ.peek();
    if (((a)localObject).zQb.size() == 0)
    {
      this.zPZ.poll();
      az.ayM();
      c.agA().set(8193, ((a)localObject).iEE);
      az.ayM();
      c.agA().set(8449, Long.valueOf(bs.aNx()));
      AppMethodBeat.o(28921);
      return;
    }
    localObject = (String)((a)localObject).zQb.peek();
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      AppMethodBeat.o(28921);
      return;
    }
    this.zQa = true;
    localObject = new a((String)localObject);
    az.agi().a(141, this);
    az.agi().a((n)localObject, 0);
    AppMethodBeat.o(28921);
  }
  
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(28920);
    parama = z.a(parama.fXi.DPV);
    if (this.zPZ == null) {
      this.zPZ = new LinkedList();
    }
    parama = new a(parama);
    if (parama.iEE != null)
    {
      this.zPZ.offer(parama);
      eaG();
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
      this.zQa = false;
      AppMethodBeat.o(28922);
      return;
    }
    az.agi().b(141, this);
    paramString = ((a)paramn).url;
    paramn = (a)this.zPZ.peek();
    if ((paramn == null) || (paramn.zQb.size() == 0))
    {
      ac.e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
      this.zPZ = new LinkedList();
      this.zQa = false;
      AppMethodBeat.o(28922);
      return;
    }
    if (paramn.zQb.size() == 0)
    {
      ac.e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
      this.zPZ.poll();
      this.zQa = false;
      AppMethodBeat.o(28922);
      return;
    }
    if (!((String)paramn.zQb.peek()).equals(paramString))
    {
      ac.e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
      this.zPZ.poll();
      this.zQa = false;
      AppMethodBeat.o(28922);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.e("MicroMsg.PushMessageExtension", "down failed [" + paramInt1 + "," + paramInt2 + "] ignore this message : img:[" + paramString + "] ");
      this.zPZ.poll();
      this.zQa = false;
      AppMethodBeat.o(28922);
      return;
    }
    paramn.zQb.poll();
    this.zQa = false;
    eaG();
    AppMethodBeat.o(28922);
  }
  
  static final class a
  {
    public String iEE;
    public Queue<String> zQb;
    
    a(String paramString)
    {
      AppMethodBeat.i(28919);
      this.iEE = paramString;
      this.zQb = new LinkedList();
      ac.d("MicroMsg.PushMessageExtension", "DoSceneStruct:".concat(String.valueOf(paramString)));
      paramString = com.tencent.mm.pluginsdk.i.a.a.bN(ai.getContext(), paramString);
      if ((paramString == null) || (paramString.size() <= 0))
      {
        ac.e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
        AppMethodBeat.o(28919);
        return;
      }
      int i = 0;
      while (i < paramString.size())
      {
        Object localObject = ((com.tencent.mm.pluginsdk.i.a.a)paramString.get(i)).Dmk;
        if (localObject != null)
        {
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext()) {
            this.zQb.offer(((Map.Entry)((Iterator)localObject).next()).getValue());
          }
        }
        i += 1;
      }
      AppMethodBeat.o(28919);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.b
 * JD-Core Version:    0.7.0.1
 */