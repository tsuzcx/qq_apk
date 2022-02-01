package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.ba.b.a;
import com.tencent.mm.ba.b.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cxo;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class UnfamiliarContactDetailUI$d
  extends com.tencent.f.i.b
  implements i
{
  UnfamiliarContactDetailUI.g Dfu;
  Collection<Integer> Dfv;
  int Dfw;
  LinkedList<String> Dfx;
  LinkedList<k.b> Dfy;
  int index;
  int zqp;
  
  UnfamiliarContactDetailUI$d(Collection<Integer> paramCollection, UnfamiliarContactDetailUI.g paramg)
  {
    AppMethodBeat.i(74599);
    this.zqp = 0;
    this.Dfw = 0;
    this.index = 0;
    this.Dfx = new LinkedList();
    this.Dfy = new LinkedList();
    this.Dfv = paramg;
    Object localObject;
    this.Dfu = localObject;
    AppMethodBeat.o(74599);
  }
  
  public final boolean cancel()
  {
    AppMethodBeat.i(182596);
    super.cancel();
    if (this.Dfu != null)
    {
      UnfamiliarContactDetailUI.b(this.Dfg).clear();
      this.Dfu.eTJ();
    }
    AppMethodBeat.o(182596);
    return false;
  }
  
  public final String getKey()
  {
    return "delete_contact_task";
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(74601);
    if (paramq.getType() == 681)
    {
      if ((((com.tencent.mm.ba.b)paramq).jgb == null) || ((b.c)((com.tencent.mm.ba.b)paramq).jgb.getRespObj() == null))
      {
        Log.e("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] rr is null!");
        AppMethodBeat.o(74601);
        return;
      }
      Object localObject = ((b.c)((com.tencent.mm.ba.b)paramq).jgb.getRespObj()).jgg;
      if ((((cxn)localObject).Ret != 0) || (((cxn)localObject).MBY == null) || (((cxn)localObject).MBY.LRr == null))
      {
        Log.e("MicroMsg.UnfamiliarContactUI", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(((cxn)localObject).Ret) });
        AppMethodBeat.o(74601);
        return;
      }
      paramString = ((com.tencent.mm.ba.b)paramq).jgc;
      paramq = ((cxn)localObject).MBY.LRr;
      Log.i("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] list size:%s, result:%s", new Object[] { Integer.valueOf(paramString.size()), Integer.valueOf(paramq.size()) });
      paramInt1 = 0;
      if (paramInt1 < paramString.size())
      {
        localObject = (k.b)paramString.get(paramInt1);
        if (((k.b)localObject).getCmdId() != 4) {
          Log.w("MicroMsg.UnfamiliarContactUI", "cmdId:%s operation:%s", new Object[] { Integer.valueOf(((k.b)localObject).getCmdId()), localObject.toString() });
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          this.zqp -= 1;
          localObject = (afh)((k.b)localObject).zqv;
          if (((Integer)paramq.get(paramInt1)).intValue() == 0)
          {
            this.Dfw += 1;
            localObject = ((l)g.af(l.class)).aSN().Kn(z.a(((afh)localObject).Lqk));
            if (localObject != null)
            {
              ((as)localObject).aqR();
              bp.a(((ax)localObject).field_username, null);
              ((l)g.af(l.class)).aSN().c(((ax)localObject).field_username, (as)localObject);
              ((l)g.af(l.class)).aST().bjW(((ax)localObject).field_username);
              this.Dfx.add(((ax)localObject).field_username);
            }
          }
          else
          {
            Log.e("MicroMsg.UnfamiliarContactUI", "delete contact fail! ret:%s", new Object[] { paramq.get(paramInt1), z.a(((afh)localObject).Lqk) });
          }
        }
      }
      if (this.zqp <= 0)
      {
        paramString = this.Dfx.iterator();
        while (paramString.hasNext())
        {
          paramq = (String)paramString.next();
          localObject = UnfamiliarContactDetailUI.f(this.Dfg).iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((UnfamiliarContactDetailUI.b)((Iterator)localObject).next()).contact.field_username.equals(paramq)) {
              ((Iterator)localObject).remove();
            }
          }
        }
        UnfamiliarContactDetailUI.a(this.Dfg, UnfamiliarContactDetailUI.f(this.Dfg));
        this.Dfg.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74598);
            if (UnfamiliarContactDetailUI.d.this.Dfu != null)
            {
              UnfamiliarContactDetailUI.d.this.Dfu.il(UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.d.this.Dfg).size(), UnfamiliarContactDetailUI.d.this.Dfw);
              UnfamiliarContactDetailUI.b(UnfamiliarContactDetailUI.d.this.Dfg).clear();
            }
            AppMethodBeat.o(74598);
          }
        });
      }
    }
    AppMethodBeat.o(74601);
  }
  
  public final void run()
  {
    AppMethodBeat.i(74600);
    this.zqp = this.Dfv.size();
    Iterator localIterator = this.Dfv.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      this.index += 1;
      int j = this.Dfv.size();
      int k = this.index;
      if (UnfamiliarContactDetailUI.e(this.Dfg) != null)
      {
        as localas = UnfamiliarContactDetailUI.e(this.Dfg).Xs(i).contact;
        if (as.bjp(localas.field_username))
        {
          ((r)g.af(r.class)).EG(localas.field_username);
        }
        else
        {
          afh localafh = new afh();
          localafh.Lqk = new dqi().bhy(Util.nullAsNil(localas.field_username));
          this.Dfy.add(new k.a(4, localafh));
          if ((this.Dfy.size() % 20 == 0) || (k == j))
          {
            g.aAi();
            g.aAg().hqi.a(new com.tencent.mm.ba.b(this.Dfy), 0);
            this.Dfy.clear();
          }
        }
      }
    }
    AppMethodBeat.o(74600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.d
 * JD-Core Version:    0.7.0.1
 */