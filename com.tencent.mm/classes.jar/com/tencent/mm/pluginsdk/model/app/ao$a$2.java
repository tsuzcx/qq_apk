package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ah.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class ao$a$2
  implements Runnable
{
  ao$a$2(ao.a parama, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    long l3 = 0L;
    int i = 0;
    ao.a.uC();
    long l1;
    long l2;
    if (this.bEe.getType() == 222)
    {
      y.d("MicroMsg.SceneAppMsg", "onSceneEnd  SendAppMsg errtype:" + this.bEf + " errCode:" + this.bEg);
      i = 0;
      l1 = -1L;
      l2 = l3;
      if (l1 != -1L)
      {
        l2 = l3;
        if (this.rVh.bDU.get(Long.valueOf(l1)) != null)
        {
          l2 = ((g.a)this.rVh.bDU.get(Long.valueOf(l1))).zJ();
          this.rVh.bDU.remove(Long.valueOf(l1));
        }
      }
      y.d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + this.bEe.getType() + " errtype:" + this.bEf + " errCode:" + this.bEg + " retCode:" + i + " rowid:" + l1 + " time:" + l2);
      if (this.bEf != 0) {
        ao.a.d(this.rVh);
      }
      y.d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + ao.a.access$000() + " stop:" + ao.a.e(this.rVh) + " running:" + ao.a.f(this.rVh) + " recving:" + ao.a.g(this.rVh) + " sending:" + ao.a.h(this.rVh));
      if (ao.a.e(this.rVh) <= 0) {
        break label642;
      }
      ao.a.i(this.rVh);
    }
    for (;;)
    {
      ao.a.uD();
      return;
      if (this.bEe.getType() == 221)
      {
        ao.a.a(this.rVh);
        l1 = ((ac)this.bEe).rUD;
        i = ((ac)this.bEe).retCode;
        break;
      }
      if (this.bEe.getType() == 220)
      {
        ao.a.b(this.rVh);
        l2 = ((al)this.bEe).rUD;
        int j = ((al)this.bEe).retCode;
        Object localObject1 = (al)this.bEe;
        label449:
        Object localObject2;
        if (((al)localObject1).rUA == null)
        {
          localObject1 = null;
          localObject2 = (al)this.bEe;
          if (((al)localObject2).rUA != null) {
            break label598;
          }
        }
        label598:
        for (l1 = 0L;; l1 = ((al)localObject2).rUA.field_msgInfoId)
        {
          localObject2 = (String)ao.a.c(this.rVh).remove(Long.valueOf(l1));
          if (!bk.bl(((al)this.bEe).eoQ)) {
            i = 1;
          }
          if ((i == 0) && (!bk.bl((String)localObject1)))
          {
            b localb = new b();
            ap.avh().b(l2, localb);
            if (localb.ujK == l2)
            {
              l.a(localb.field_msgInfoId, (String)localObject1, null);
              y.d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
              ao.a.C(localb.field_msgInfoId, (String)localObject2);
            }
          }
          i = j;
          l1 = l2;
          break;
          localObject1 = ((al)localObject1).rUA.field_mediaSvrId;
          break label449;
        }
      }
      y.e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + this.bEe.getType());
      ao.a.uD();
      return;
      label642:
      if ((!ao.a.h(this.rVh)) && (!ao.a.g(this.rVh))) {
        ao.a.j(this.rVh);
      }
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|onSceneEnd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ao.a.2
 * JD-Core Version:    0.7.0.1
 */