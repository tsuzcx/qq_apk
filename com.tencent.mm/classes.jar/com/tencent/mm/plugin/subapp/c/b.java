package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
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
  private Queue<a> ByY = null;
  private boolean ByZ = false;
  
  private void eqF()
  {
    AppMethodBeat.i(28921);
    if (this.ByZ)
    {
      AppMethodBeat.o(28921);
      return;
    }
    if (this.ByY.size() == 0)
    {
      AppMethodBeat.o(28921);
      return;
    }
    Object localObject = (a)this.ByY.peek();
    if (((a)localObject).Bza.size() == 0)
    {
      this.ByY.poll();
      bc.aCg();
      c.ajA().set(8193, ((a)localObject).jaG);
      bc.aCg();
      c.ajA().set(8449, Long.valueOf(bu.aRi()));
      AppMethodBeat.o(28921);
      return;
    }
    localObject = (String)((a)localObject).Bza.peek();
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      AppMethodBeat.o(28921);
      return;
    }
    this.ByZ = true;
    localObject = new a((String)localObject);
    bc.ajj().a(141, this);
    bc.ajj().a((n)localObject, 0);
    AppMethodBeat.o(28921);
  }
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(28920);
    parama = z.a(parama.gte.FNI);
    if (this.ByY == null) {
      this.ByY = new LinkedList();
    }
    parama = new a(parama);
    if (parama.jaG != null)
    {
      this.ByY.offer(parama);
      eqF();
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
      this.ByZ = false;
      AppMethodBeat.o(28922);
      return;
    }
    bc.ajj().b(141, this);
    paramString = ((a)paramn).url;
    paramn = (a)this.ByY.peek();
    if ((paramn == null) || (paramn.Bza.size() == 0))
    {
      ae.e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
      this.ByY = new LinkedList();
      this.ByZ = false;
      AppMethodBeat.o(28922);
      return;
    }
    if (paramn.Bza.size() == 0)
    {
      ae.e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
      this.ByY.poll();
      this.ByZ = false;
      AppMethodBeat.o(28922);
      return;
    }
    if (!((String)paramn.Bza.peek()).equals(paramString))
    {
      ae.e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
      this.ByY.poll();
      this.ByZ = false;
      AppMethodBeat.o(28922);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.e("MicroMsg.PushMessageExtension", "down failed [" + paramInt1 + "," + paramInt2 + "] ignore this message : img:[" + paramString + "] ");
      this.ByY.poll();
      this.ByZ = false;
      AppMethodBeat.o(28922);
      return;
    }
    paramn.Bza.poll();
    this.ByZ = false;
    eqF();
    AppMethodBeat.o(28922);
  }
  
  static final class a
  {
    public Queue<String> Bza;
    public String jaG;
    
    a(String paramString)
    {
      AppMethodBeat.i(28919);
      this.jaG = paramString;
      this.Bza = new LinkedList();
      ae.d("MicroMsg.PushMessageExtension", "DoSceneStruct:".concat(String.valueOf(paramString)));
      paramString = com.tencent.mm.pluginsdk.k.a.a.bS(ak.getContext(), paramString);
      if ((paramString == null) || (paramString.size() <= 0))
      {
        ae.e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
        AppMethodBeat.o(28919);
        return;
      }
      int i = 0;
      while (i < paramString.size())
      {
        Object localObject = ((com.tencent.mm.pluginsdk.k.a.a)paramString.get(i)).FjH;
        if (localObject != null)
        {
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext()) {
            this.Bza.offer(((Map.Entry)((Iterator)localObject).next()).getValue());
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