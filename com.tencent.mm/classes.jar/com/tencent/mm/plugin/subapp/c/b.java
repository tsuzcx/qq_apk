package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.util.LinkedList;
import java.util.Queue;

public final class b
  implements g, h
{
  private Queue<b.a> SEW = null;
  private boolean SEX = false;
  
  private void hAW()
  {
    AppMethodBeat.i(28921);
    if (this.SEX)
    {
      AppMethodBeat.o(28921);
      return;
    }
    if (this.SEW.size() == 0)
    {
      AppMethodBeat.o(28921);
      return;
    }
    Object localObject = (b.a)this.SEW.peek();
    if (((b.a)localObject).SEY.size() == 0)
    {
      this.SEW.poll();
      bh.bCz();
      c.ban().B(8193, ((b.a)localObject).pJo);
      bh.bCz();
      c.ban().B(8449, Long.valueOf(Util.nowSecond()));
      AppMethodBeat.o(28921);
      return;
    }
    localObject = (String)((b.a)localObject).SEY.peek();
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      AppMethodBeat.o(28921);
      return;
    }
    this.SEX = true;
    localObject = new a((String)localObject);
    bh.aZW().a(141, this);
    bh.aZW().a((p)localObject, 0);
    AppMethodBeat.o(28921);
  }
  
  public final g.b b(g.a parama)
  {
    AppMethodBeat.i(28920);
    parama = w.a(parama.mpN.YFG);
    if (this.SEW == null) {
      this.SEW = new LinkedList();
    }
    parama = new b.a(parama);
    if (parama.pJo != null)
    {
      this.SEW.offer(parama);
      hAW();
    }
    AppMethodBeat.o(28920);
    return null;
  }
  
  public final void b(g.c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(28922);
    if (paramp.getType() != 141)
    {
      this.SEX = false;
      AppMethodBeat.o(28922);
      return;
    }
    bh.aZW().b(141, this);
    paramString = ((a)paramp).url;
    paramp = (b.a)this.SEW.peek();
    if ((paramp == null) || (paramp.SEY.size() == 0))
    {
      Log.e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
      this.SEW = new LinkedList();
      this.SEX = false;
      AppMethodBeat.o(28922);
      return;
    }
    if (paramp.SEY.size() == 0)
    {
      Log.e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
      this.SEW.poll();
      this.SEX = false;
      AppMethodBeat.o(28922);
      return;
    }
    if (!((String)paramp.SEY.peek()).equals(paramString))
    {
      Log.e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
      this.SEW.poll();
      this.SEX = false;
      AppMethodBeat.o(28922);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.PushMessageExtension", "down failed [" + paramInt1 + "," + paramInt2 + "] ignore this message : img:[" + paramString + "] ");
      this.SEW.poll();
      this.SEX = false;
      AppMethodBeat.o(28922);
      return;
    }
    paramp.SEY.poll();
    this.SEX = false;
    hAW();
    AppMethodBeat.o(28922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.b
 * JD-Core Version:    0.7.0.1
 */