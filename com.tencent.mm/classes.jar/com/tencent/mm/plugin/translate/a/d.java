package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cls;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.LinkedList;
import java.util.Queue;

public final class d
  implements f
{
  public int index;
  private long start;
  public SparseArray<c.c> toX;
  public boolean toY;
  public b toZ;
  a tpa;
  public ap tpb;
  
  public d(int paramInt, a parama)
  {
    AppMethodBeat.i(26069);
    this.toX = null;
    this.toY = false;
    this.tpb = new ap(new d.1(this), false);
    this.index = paramInt;
    this.tpa = parama;
    AppMethodBeat.o(26069);
  }
  
  public final void cKU()
  {
    this.toZ = null;
    this.toY = false;
  }
  
  public final boolean e(Queue<c.c> paramQueue)
  {
    AppMethodBeat.i(26070);
    if (this.toY)
    {
      AppMethodBeat.o(26070);
      return false;
    }
    this.toX = new SparseArray();
    if (paramQueue.size() == 0)
    {
      AppMethodBeat.o(26070);
      return false;
    }
    this.toY = true;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    if ((i < 512) && (paramQueue.size() > 0))
    {
      c.c localc = (c.c)paramQueue.peek();
      int j = localc.cKn.getBytes().length;
      cls localcls;
      if ((i == 0) || (i + j <= 512))
      {
        paramQueue.poll();
        localcls = new cls();
        localcls.xVJ = localc.toU;
        localcls.xVK = localc.cKn;
        localcls.wYl = new SKBuiltinBuffer_t().setBuffer(localc.dHc);
        if ((localc.type == 1) || (t.lA(localc.source))) {
          localcls.xVL = localc.source;
        }
        switch (localc.type)
        {
        }
      }
      for (;;)
      {
        ab.d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", new Object[] { Integer.valueOf(localc.type), Integer.valueOf(localcls.Scene), localc.id });
        localLinkedList.add(localcls);
        this.toX.put(localc.toU, localc);
        i += j;
        break;
        localcls.Scene = 4;
        continue;
        localcls.Scene = 1;
        continue;
        localcls.Scene = 2;
        continue;
        localcls.Scene = 3;
      }
    }
    this.toZ = new b(localLinkedList);
    aw.Rc().a(this.toZ, 0);
    this.start = System.currentTimeMillis();
    this.tpb.ag(60000L, 60000L);
    AppMethodBeat.o(26070);
    return true;
  }
  
  public final void init()
  {
    AppMethodBeat.i(26071);
    aw.Rc().a(631, this);
    AppMethodBeat.o(26071);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(26072);
    if (this.toZ != paramm)
    {
      ab.e("MicroMsg.WorkingTranslate", "not my translate work");
      AppMethodBeat.o(26072);
      return;
    }
    this.tpb.stopTimer();
    ab.d("MicroMsg.WorkingTranslate", "translate take time : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
    if (((b)paramm).toP != null) {}
    for (int i = ((b)paramm).toP.size();; i = 0)
    {
      ab.d("MicroMsg.WorkingTranslate", "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      cKU();
      this.tpa.a(paramInt2, this.toX, ((b)paramm).toP);
      AppMethodBeat.o(26072);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.d
 * JD-Core Version:    0.7.0.1
 */