package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
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
  private Queue<a> FJJ = null;
  private boolean FJK = false;
  
  private void fte()
  {
    AppMethodBeat.i(28921);
    if (this.FJK)
    {
      AppMethodBeat.o(28921);
      return;
    }
    if (this.FJJ.size() == 0)
    {
      AppMethodBeat.o(28921);
      return;
    }
    Object localObject = (a)this.FJJ.peek();
    if (((a)localObject).FJL.size() == 0)
    {
      this.FJJ.poll();
      bg.aVF();
      c.azQ().set(8193, ((a)localObject).jVt);
      bg.aVF();
      c.azQ().set(8449, Long.valueOf(Util.nowSecond()));
      AppMethodBeat.o(28921);
      return;
    }
    localObject = (String)((a)localObject).FJL.peek();
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      AppMethodBeat.o(28921);
      return;
    }
    this.FJK = true;
    localObject = new a((String)localObject);
    bg.azz().a(141, this);
    bg.azz().a((q)localObject, 0);
    AppMethodBeat.o(28921);
  }
  
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(28920);
    parama = z.a(parama.heO.KHn);
    if (this.FJJ == null) {
      this.FJJ = new LinkedList();
    }
    parama = new a(parama);
    if (parama.jVt != null)
    {
      this.FJJ.offer(parama);
      fte();
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
      this.FJK = false;
      AppMethodBeat.o(28922);
      return;
    }
    bg.azz().b(141, this);
    paramString = ((a)paramq).url;
    paramq = (a)this.FJJ.peek();
    if ((paramq == null) || (paramq.FJL.size() == 0))
    {
      Log.e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
      this.FJJ = new LinkedList();
      this.FJK = false;
      AppMethodBeat.o(28922);
      return;
    }
    if (paramq.FJL.size() == 0)
    {
      Log.e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
      this.FJJ.poll();
      this.FJK = false;
      AppMethodBeat.o(28922);
      return;
    }
    if (!((String)paramq.FJL.peek()).equals(paramString))
    {
      Log.e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
      this.FJJ.poll();
      this.FJK = false;
      AppMethodBeat.o(28922);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.PushMessageExtension", "down failed [" + paramInt1 + "," + paramInt2 + "] ignore this message : img:[" + paramString + "] ");
      this.FJJ.poll();
      this.FJK = false;
      AppMethodBeat.o(28922);
      return;
    }
    paramq.FJL.poll();
    this.FJK = false;
    fte();
    AppMethodBeat.o(28922);
  }
  
  static final class a
  {
    public Queue<String> FJL;
    public String jVt;
    
    a(String paramString)
    {
      AppMethodBeat.i(28919);
      this.jVt = paramString;
      this.FJL = new LinkedList();
      Log.d("MicroMsg.PushMessageExtension", "DoSceneStruct:".concat(String.valueOf(paramString)));
      paramString = com.tencent.mm.pluginsdk.k.a.a.cm(MMApplicationContext.getContext(), paramString);
      if ((paramString == null) || (paramString.size() <= 0))
      {
        Log.e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
        AppMethodBeat.o(28919);
        return;
      }
      int i = 0;
      while (i < paramString.size())
      {
        Object localObject = ((com.tencent.mm.pluginsdk.k.a.a)paramString.get(i)).Kaz;
        if (localObject != null)
        {
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext()) {
            this.FJL.offer(((Map.Entry)((Iterator)localObject).next()).getValue());
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