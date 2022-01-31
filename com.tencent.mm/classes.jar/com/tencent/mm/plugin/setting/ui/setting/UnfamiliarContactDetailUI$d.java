package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.az.b.a;
import com.tencent.mm.az.b.c;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.bjq;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.wr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class UnfamiliarContactDetailUI$d
  implements f, Runnable
{
  int index;
  int oDT;
  LinkedList<j.b> qLA;
  UnfamiliarContactDetailUI.g qLw;
  Collection<Integer> qLx;
  int qLy;
  LinkedList<String> qLz;
  
  UnfamiliarContactDetailUI$d(Collection<Integer> paramCollection, UnfamiliarContactDetailUI.g paramg)
  {
    AppMethodBeat.i(127663);
    this.oDT = 0;
    this.qLy = 0;
    this.index = 0;
    this.qLz = new LinkedList();
    this.qLA = new LinkedList();
    this.qLx = paramg;
    Object localObject;
    this.qLw = localObject;
    AppMethodBeat.o(127663);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(127665);
    if (paramm.getType() == 681)
    {
      if ((((com.tencent.mm.az.b)paramm).fLG == null) || ((b.c)((com.tencent.mm.az.b)paramm).fLG.getRespObj() == null))
      {
        ab.e("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] rr is null!");
        AppMethodBeat.o(127665);
        return;
      }
      Object localObject = ((b.c)((com.tencent.mm.az.b)paramm).fLG.getRespObj()).fLL;
      if ((((bjp)localObject).Ret != 0) || (((bjp)localObject).xxX == null) || (((bjp)localObject).xxX.xaU == null))
      {
        ab.e("MicroMsg.UnfamiliarContactUI", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((bjp)localObject).Ret) });
        AppMethodBeat.o(127665);
        return;
      }
      paramString = ((com.tencent.mm.az.b)paramm).fLH;
      paramm = ((bjp)localObject).xxX.xaU;
      ab.i("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] list size:%s, result:%s", new Object[] { Integer.valueOf(paramString.size()), Integer.valueOf(paramm.size()) });
      paramInt1 = 0;
      if (paramInt1 < paramString.size())
      {
        localObject = (j.b)paramString.get(paramInt1);
        if (((j.b)localObject).getCmdId() != 4) {
          ab.w("MicroMsg.UnfamiliarContactUI", "cmdId:%s operation:%s", new Object[] { Integer.valueOf(((j.b)localObject).getCmdId()), localObject.toString() });
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          this.oDT -= 1;
          localObject = (wr)((j.b)localObject).oDZ;
          if (((Integer)paramm.get(paramInt1)).intValue() == 0)
          {
            this.qLy += 1;
            localObject = ((j)g.E(j.class)).YA().arw(aa.a(((wr)localObject).wOT));
            if (localObject != null)
            {
              ((ad)localObject).Ny();
              bf.a(((aq)localObject).field_username, null);
              ((j)g.E(j.class)).YA().b(((aq)localObject).field_username, (ad)localObject);
              ((j)g.E(j.class)).YF().arF(((aq)localObject).field_username);
              this.qLz.add(((aq)localObject).field_username);
            }
          }
          else
          {
            ab.e("MicroMsg.UnfamiliarContactUI", "delete contact fail! ret:%s", new Object[] { paramm.get(paramInt1), aa.a(((wr)localObject).wOT) });
          }
        }
      }
      if (this.oDT <= 0)
      {
        paramString = this.qLz.iterator();
        while (paramString.hasNext())
        {
          paramm = (String)paramString.next();
          localObject = UnfamiliarContactDetailUI.f(this.qLi).iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((UnfamiliarContactDetailUI.b)((Iterator)localObject).next()).contact.field_username.equals(paramm)) {
              ((Iterator)localObject).remove();
            }
          }
        }
        UnfamiliarContactDetailUI.a(this.qLi, UnfamiliarContactDetailUI.f(this.qLi));
        this.qLi.runOnUiThread(new UnfamiliarContactDetailUI.d.1(this));
      }
    }
    AppMethodBeat.o(127665);
  }
  
  public final void run()
  {
    AppMethodBeat.i(127664);
    this.oDT = this.qLx.size();
    Iterator localIterator = this.qLx.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      this.index += 1;
      int j = this.qLx.size();
      int k = this.index;
      if (UnfamiliarContactDetailUI.e(this.qLi) != null)
      {
        ad localad = UnfamiliarContactDetailUI.e(this.qLi).Dg(i).contact;
        if (ad.arf(localad.field_username))
        {
          ((a)g.E(a.class)).wg(localad.field_username);
        }
        else
        {
          wr localwr = new wr();
          localwr.wOT = new bwc().aoF(bo.nullAsNil(localad.field_username));
          this.qLA.add(new j.a(4, localwr));
          if ((this.qLA.size() % 20 == 0) || (k == j))
          {
            g.RM();
            g.RK().eHt.a(new com.tencent.mm.az.b(this.qLA), 0);
            this.qLA.clear();
          }
        }
      }
    }
    AppMethodBeat.o(127664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.d
 * JD-Core Version:    0.7.0.1
 */