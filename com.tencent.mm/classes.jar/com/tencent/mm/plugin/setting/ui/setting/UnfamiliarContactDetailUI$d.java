package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.a.c;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.bcm;
import com.tencent.mm.protocal.c.bcn;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.sr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class UnfamiliarContactDetailUI$d
  implements f, Runnable
{
  int index = 0;
  int mdx = 0;
  UnfamiliarContactDetailUI.g nXm;
  Collection<Integer> nXn;
  int nXo = 0;
  LinkedList<String> nXp = new LinkedList();
  LinkedList<i.b> nXq = new LinkedList();
  
  UnfamiliarContactDetailUI$d(Collection<Integer> paramCollection, UnfamiliarContactDetailUI.g paramg)
  {
    this.nXn = paramg;
    Object localObject;
    this.nXm = localObject;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() == 681)
    {
      if ((((com.tencent.mm.ay.a)paramm).evQ != null) && ((a.c)((com.tencent.mm.ay.a)paramm).evQ.evT != null)) {
        break label50;
      }
      y.e("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] rr is null!");
    }
    label50:
    Object localObject;
    do
    {
      return;
      localObject = ((a.c)((com.tencent.mm.ay.a)paramm).evQ.evT).evV;
      if ((((bcm)localObject).sze != 0) || (((bcm)localObject).txP == null) || (((bcm)localObject).txP.tcC == null))
      {
        y.e("MicroMsg.UnfamiliarContactUI", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((bcm)localObject).sze) });
        return;
      }
      paramString = ((com.tencent.mm.ay.a)paramm).evR;
      paramm = ((bcm)localObject).txP.tcC;
      y.i("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] list size:%s, result:%s", new Object[] { Integer.valueOf(paramString.size()), Integer.valueOf(paramm.size()) });
      paramInt1 = 0;
      if (paramInt1 < paramString.size())
      {
        localObject = (i.b)paramString.get(paramInt1);
        if (((i.b)localObject).getCmdId() != 4) {
          y.w("MicroMsg.UnfamiliarContactUI", "cmdId:%s operation:%s", new Object[] { Integer.valueOf(((i.b)localObject).getCmdId()), localObject.toString() });
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          this.mdx -= 1;
          localObject = (sr)((i.b)localObject).mdD;
          if (((Integer)paramm.get(paramInt1)).intValue() == 0)
          {
            this.nXo += 1;
            localObject = ((j)g.r(j.class)).Fw().abl(aa.a(((sr)localObject).sQs));
            if (localObject != null)
            {
              ((ad)localObject).AI();
              com.tencent.mm.model.bd.a(((ao)localObject).field_username, null);
              ((j)g.r(j.class)).Fw().a(((ao)localObject).field_username, (ad)localObject);
              ((j)g.r(j.class)).FB().abu(((ao)localObject).field_username);
              this.nXp.add(((ao)localObject).field_username);
            }
          }
          else
          {
            y.e("MicroMsg.UnfamiliarContactUI", "delete contact fail! ret:%s", new Object[] { paramm.get(paramInt1), aa.a(((sr)localObject).sQs) });
          }
        }
      }
    } while (this.mdx > 0);
    paramString = this.nXp.iterator();
    while (paramString.hasNext())
    {
      paramm = (String)paramString.next();
      localObject = UnfamiliarContactDetailUI.f(this.nWX).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((UnfamiliarContactDetailUI.b)((Iterator)localObject).next()).dnp.field_username.equals(paramm)) {
          ((Iterator)localObject).remove();
        }
      }
    }
    UnfamiliarContactDetailUI.a(this.nWX, UnfamiliarContactDetailUI.f(this.nWX));
    this.nWX.runOnUiThread(new UnfamiliarContactDetailUI.d.1(this));
  }
  
  public final void run()
  {
    this.mdx = this.nXn.size();
    Iterator localIterator = this.nXn.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      this.index += 1;
      int j = this.nXn.size();
      int k = this.index;
      if (UnfamiliarContactDetailUI.e(this.nWX) != null)
      {
        ad localad = UnfamiliarContactDetailUI.e(this.nWX).xi(i).dnp;
        if (ad.aaU(localad.field_username))
        {
          ((com.tencent.mm.openim.a.a)g.r(com.tencent.mm.openim.a.a.class)).oO(localad.field_username);
        }
        else
        {
          sr localsr = new sr();
          localsr.sQs = new bml().YI(bk.pm(localad.field_username));
          this.nXq.add(new i.a(4, localsr));
          if ((this.nXq.size() % 20 == 0) || (k == j))
          {
            g.DQ();
            g.DO().dJT.a(new com.tencent.mm.ay.a(this.nXq), 0);
            this.nXq.clear();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.d
 * JD-Core Version:    0.7.0.1
 */