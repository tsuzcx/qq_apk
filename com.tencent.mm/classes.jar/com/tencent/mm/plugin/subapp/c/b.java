package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public final class b
  implements h, i
{
  private Queue<a> MdG = null;
  private boolean MdH = false;
  
  private void ghD()
  {
    AppMethodBeat.i(28921);
    if (this.MdH)
    {
      AppMethodBeat.o(28921);
      return;
    }
    if (this.MdG.size() == 0)
    {
      AppMethodBeat.o(28921);
      return;
    }
    Object localObject = (a)this.MdG.peek();
    if (((a)localObject).MdI.size() == 0)
    {
      this.MdG.poll();
      bh.beI();
      c.aHp().i(8193, ((a)localObject).mMG);
      bh.beI();
      c.aHp().i(8449, Long.valueOf(Util.nowSecond()));
      AppMethodBeat.o(28921);
      return;
    }
    localObject = (String)((a)localObject).MdI.peek();
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      AppMethodBeat.o(28921);
      return;
    }
    this.MdH = true;
    localObject = new a((String)localObject);
    bh.aGY().a(141, this);
    bh.aGY().a((q)localObject, 0);
    AppMethodBeat.o(28921);
  }
  
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(28920);
    parama = z.a(parama.jQG.RIF);
    if (this.MdG == null) {
      this.MdG = new LinkedList();
    }
    parama = new a(parama);
    if (parama.mMG != null)
    {
      this.MdG.offer(parama);
      ghD();
    }
    AppMethodBeat.o(28920);
    return null;
  }
  
  public final void b(h.c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(28922);
    if (paramq.getType() != 141)
    {
      this.MdH = false;
      AppMethodBeat.o(28922);
      return;
    }
    bh.aGY().b(141, this);
    paramString = ((a)paramq).url;
    paramq = (a)this.MdG.peek();
    if ((paramq == null) || (paramq.MdI.size() == 0))
    {
      Log.e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
      this.MdG = new LinkedList();
      this.MdH = false;
      AppMethodBeat.o(28922);
      return;
    }
    if (paramq.MdI.size() == 0)
    {
      Log.e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
      this.MdG.poll();
      this.MdH = false;
      AppMethodBeat.o(28922);
      return;
    }
    if (!((String)paramq.MdI.peek()).equals(paramString))
    {
      Log.e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
      this.MdG.poll();
      this.MdH = false;
      AppMethodBeat.o(28922);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.PushMessageExtension", "down failed [" + paramInt1 + "," + paramInt2 + "] ignore this message : img:[" + paramString + "] ");
      this.MdG.poll();
      this.MdH = false;
      AppMethodBeat.o(28922);
      return;
    }
    paramq.MdI.poll();
    this.MdH = false;
    ghD();
    AppMethodBeat.o(28922);
  }
  
  static final class a
  {
    public Queue<String> MdI;
    public String mMG;
    
    a(String paramString)
    {
      AppMethodBeat.i(28919);
      this.mMG = paramString;
      this.MdI = new LinkedList();
      Log.d("MicroMsg.PushMessageExtension", "DoSceneStruct:".concat(String.valueOf(paramString)));
      paramString = com.tencent.mm.pluginsdk.l.a.a.cy(MMApplicationContext.getContext(), paramString);
      if ((paramString == null) || (paramString.size() <= 0))
      {
        Log.e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
        AppMethodBeat.o(28919);
        return;
      }
      int i = 0;
      while (i < paramString.size())
      {
        Object localObject = ((com.tencent.mm.pluginsdk.l.a.a)paramString.get(i)).Rbc;
        if (localObject != null)
        {
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext()) {
            this.MdI.offer(((Map.Entry)((Iterator)localObject).next()).getValue());
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