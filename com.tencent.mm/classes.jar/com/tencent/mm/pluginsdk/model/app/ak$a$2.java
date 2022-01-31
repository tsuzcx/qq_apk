package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.record.b.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

final class ak$a$2
  implements Runnable
{
  ak$a$2(ak.a parama, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(27395);
    ak.a.EU();
    long l1;
    long l2;
    if (this.ckS.getType() == 222)
    {
      ab.d("MicroMsg.SceneAppMsg", "onSceneEnd  SendAppMsg errtype:" + this.val$errType + " errCode:" + this.val$errCode);
      i = 0;
      l1 = -1L;
      long l3 = 0L;
      l2 = l3;
      if (l1 != -1L)
      {
        l2 = l3;
        if (this.vLU.ckJ.get(Long.valueOf(l1)) != null)
        {
          l2 = ((g.a)this.vLU.ckJ.get(Long.valueOf(l1))).Mm();
          this.vLU.ckJ.remove(Long.valueOf(l1));
        }
      }
      ab.d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + this.ckS.getType() + " errtype:" + this.val$errType + " errCode:" + this.val$errCode + " retCode:" + i + " rowid:" + l1 + " time:" + l2);
      if (this.val$errType != 0) {
        ak.a.d(this.vLU);
      }
      ab.d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + ak.a.access$000() + " stop:" + ak.a.e(this.vLU) + " running:" + ak.a.f(this.vLU) + " recving:" + ak.a.g(this.vLU) + " sending:" + ak.a.h(this.vLU));
      if (ak.a.e(this.vLU) <= 0) {
        break label661;
      }
      ak.a.i(this.vLU);
    }
    for (;;)
    {
      ak.a.EV();
      AppMethodBeat.o(27395);
      return;
      if (this.ckS.getType() == 221)
      {
        ak.a.a(this.vLU);
        l1 = ((e)this.ckS).pYi;
        i = ((e)this.ckS).retCode;
        break;
      }
      if (this.ckS.getType() == 220)
      {
        ak.a.b(this.vLU);
        l2 = ((ah)this.ckS).pYi;
        int j = ((ah)this.ckS).retCode;
        Object localObject1 = (ah)this.ckS;
        label461:
        Object localObject2;
        if (((ah)localObject1).pYg == null)
        {
          localObject1 = null;
          localObject2 = (ah)this.ckS;
          if (((ah)localObject2).pYg != null) {
            break label611;
          }
        }
        label611:
        for (l1 = 0L;; l1 = ((ah)localObject2).pYg.field_msgInfoId)
        {
          localObject2 = (String)ak.a.c(this.vLU).remove(Long.valueOf(l1));
          if (!bo.isNullOrNil(((ah)this.ckS).fFo)) {
            i = 1;
          }
          if ((i == 0) && (!bo.isNullOrNil((String)localObject1)))
          {
            b localb = new b();
            al.aUJ().get(l2, localb);
            if (localb.systemRowid == l2)
            {
              l.a(localb.field_msgInfoId, (String)localObject1, null, true);
              ab.d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
              ak.a.B(localb.field_msgInfoId, (String)localObject2);
            }
          }
          i = j;
          l1 = l2;
          break;
          localObject1 = ((ah)localObject1).pYg.field_mediaSvrId;
          break label461;
        }
      }
      ab.e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + this.ckS.getType());
      ak.a.EV();
      AppMethodBeat.o(27395);
      return;
      label661:
      if ((!ak.a.h(this.vLU)) && (!ak.a.g(this.vLU))) {
        ak.a.j(this.vLU);
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(27396);
    String str = super.toString() + "|onSceneEnd";
    AppMethodBeat.o(27396);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ak.a.2
 * JD-Core Version:    0.7.0.1
 */