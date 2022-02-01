package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.c;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class bd
  extends d<p>
{
  private boolean diE;
  List<p> list;
  Comparator<p> wDj;
  private boolean xEc;
  private bc.a xEd;
  private c xEe;
  boolean xEg;
  private int xjP;
  private int xjQ;
  
  public bd(bc.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(99068);
    this.diE = false;
    this.list = new ArrayList();
    this.xjP = 0;
    this.xjQ = 0;
    this.xEg = false;
    this.xEc = false;
    this.wDj = new Comparator() {};
    this.xEd = parama;
    this.diE = paramBoolean;
    AppMethodBeat.o(99068);
  }
  
  public final List<p> VZ()
  {
    AppMethodBeat.i(99072);
    List localList = aj.iE(q.su(aj.wET), q.su(aj.wEU));
    ad.i("MicroMsg.SnsSelfAdapterSearchHelper", "loadData thread: %d count: %d", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()) });
    AppMethodBeat.o(99072);
    return localList;
  }
  
  public final void ac(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99069);
    this.xEc = paramBoolean1;
    lQ(paramBoolean2);
    AppMethodBeat.o(99069);
  }
  
  final void f(boolean paramBoolean, List<p> paramList)
  {
    AppMethodBeat.i(187720);
    this.xEe = new c();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    long l = System.currentTimeMillis();
    int j = 0;
    int i1 = 0;
    p localp;
    if ((paramBoolean) && (this.diE))
    {
      localp = new p((byte)0);
      localp.field_snsId = 0L;
      localp.xiB = -1;
      localp.setCreateTime((int)(System.currentTimeMillis() / 1000L));
      paramList.add(0, localp);
    }
    int i3 = paramList.size();
    ad.d("MicroMsg.SnsSelfAdapterSearchHelper", "initFixType ".concat(String.valueOf(i3)));
    int n = 0;
    int m = 0;
    if (n < i3)
    {
      this.xEe.drT();
      TimeLineObject localTimeLineObject;
      label264:
      label376:
      int i;
      label477:
      label489:
      int i2;
      if (n + 1 < i3)
      {
        localp = (p)paramList.get(n + 1);
        this.xEe.wAh = localp.field_head;
        localTimeLineObject = localp.dxy();
        this.xEe.wAl = localTimeLineObject.Etj;
        this.xEe.wAi = aj.ap(localp.field_localPrivate, this.diE);
        this.xEe.wAj = localp.field_type;
        if (localTimeLineObject.Etm != null) {
          this.xEe.wAk = localTimeLineObject.Etm.DaC.size();
        }
      }
      else
      {
        if (n + 2 < i3)
        {
          localp = (p)paramList.get(n + 2);
          this.xEe.wAr = localp.field_head;
          localTimeLineObject = localp.dxy();
          this.xEe.wAm = localTimeLineObject.Etj;
          this.xEe.wAs = aj.ap(localp.field_localPrivate, this.diE);
          this.xEe.wAt = localp.field_type;
          if (localTimeLineObject.Etm == null) {
            break label600;
          }
          this.xEe.wAu = localTimeLineObject.Etm.DaC.size();
        }
        localp = (p)paramList.get(n);
        this.xEe.wAg = localp.field_head;
        localTimeLineObject = localp.dxy();
        this.xEe.wAn = localTimeLineObject.Etj;
        this.xEe.wAo = localp.field_type;
        this.xEe.wAq = aj.ap(localp.field_localPrivate, this.diE);
        if (localTimeLineObject.Etm == null) {
          break label611;
        }
        this.xEe.wAp = localTimeLineObject.Etm.DaC.size();
        if (!this.xEe.drU()) {
          break label622;
        }
        i = 1;
        localHashMap1.put(Integer.valueOf(m), Integer.valueOf(j));
        localHashMap2.put(Integer.valueOf(m), Integer.valueOf(i));
        i2 = j + i;
        localHashMap3.put(Integer.valueOf(m), Integer.valueOf(i1));
        if ((!this.diE) || (n != 0)) {
          break label642;
        }
        j = 0;
      }
      for (;;)
      {
        i1 += j;
        n = i + n;
        m += 1;
        j = i2;
        break;
        this.xEe.wAk = 0;
        break label264;
        label600:
        this.xEe.wAu = 0;
        break label376;
        label611:
        this.xEe.wAp = 0;
        break label477;
        label622:
        if (this.xEe.drV())
        {
          i = 2;
          break label489;
        }
        i = 3;
        break label489;
        label642:
        int k = 0;
        j = k;
        if (i > 0)
        {
          j = k;
          if (this.xEe.wAo == 1) {
            j = 1;
          }
        }
        k = j;
        if (i >= 2)
        {
          k = j;
          if (this.xEe.wAj == 1) {
            k = j + 1;
          }
        }
        j = k;
        if (i >= 3)
        {
          j = k;
          if (this.xEe.wAt == 1) {
            j = k + 1;
          }
        }
      }
    }
    this.xjP = m;
    this.xjQ = paramList.size();
    ad.d("MicroMsg.SnsSelfAdapterSearchHelper", "icount " + this.xjP);
    this.list = paramList;
    q.be("SnsphotoAdapter initFixType ", l);
    this.xEd.b(this.list, localHashMap1, localHashMap2, localHashMap3, this.xjQ, this.xjP);
    AppMethodBeat.o(187720);
  }
  
  public final void fB(List<p> paramList)
  {
    AppMethodBeat.i(99071);
    if (this.xEd != null)
    {
      if (paramList != null) {
        f(this.xEg, paramList);
      }
      this.xEd.dBL();
    }
    AppMethodBeat.o(99071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd
 * JD-Core Version:    0.7.0.1
 */