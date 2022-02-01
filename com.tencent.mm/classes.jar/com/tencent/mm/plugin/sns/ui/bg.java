package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class bg
  extends d<p>
{
  private int Afb;
  private int Afc;
  boolean AzB;
  private bf.a Azy;
  private com.tencent.mm.plugin.sns.data.d Azz;
  private boolean dsB;
  List<p> list;
  private boolean sVq;
  Comparator<p> zwo;
  
  public bg(bf.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(99068);
    this.dsB = false;
    this.list = new ArrayList();
    this.Afb = 0;
    this.Afc = 0;
    this.AzB = false;
    this.sVq = false;
    this.zwo = new Comparator() {};
    this.Azy = parama;
    this.dsB = paramBoolean;
    AppMethodBeat.o(99068);
  }
  
  public final List<p> Zz()
  {
    AppMethodBeat.i(99072);
    List localList = al.ju(r.zW(al.zxX), r.zW(al.zxY));
    ae.i("MicroMsg.SnsSelfAdapterSearchHelper", "loadData thread: %d count: %d", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()) });
    AppMethodBeat.o(99072);
    return localList;
  }
  
  public final void ai(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99069);
    this.sVq = paramBoolean1;
    nh(paramBoolean2);
    AppMethodBeat.o(99069);
  }
  
  final void f(boolean paramBoolean, List<p> paramList)
  {
    AppMethodBeat.i(219923);
    this.Azz = new com.tencent.mm.plugin.sns.data.d();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    long l = System.currentTimeMillis();
    int j = 0;
    int i1 = 0;
    p localp;
    if ((paramBoolean) && (this.dsB))
    {
      localp = new p((byte)0);
      localp.field_snsId = 0L;
      localp.AdJ = -1;
      localp.setCreateTime((int)(System.currentTimeMillis() / 1000L));
      paramList.add(0, localp);
    }
    int i3 = paramList.size();
    ae.d("MicroMsg.SnsSelfAdapterSearchHelper", "initFixType ".concat(String.valueOf(i3)));
    int n = 0;
    int m = 0;
    if (n < i3)
    {
      this.Azz.dWf();
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
        this.Azz.ztj = localp.field_head;
        localTimeLineObject = localp.ebP();
        this.Azz.ztm = localTimeLineObject.HUD;
        this.Azz.ztk = al.aA(localp.field_localPrivate, this.dsB);
        this.Azz.ztl = localp.field_type;
        if (localTimeLineObject.HUG != null) {
          this.Azz.sud = localTimeLineObject.HUG.Gtx.size();
        }
      }
      else
      {
        if (n + 2 < i3)
        {
          localp = (p)paramList.get(n + 2);
          this.Azz.zts = localp.field_head;
          localTimeLineObject = localp.ebP();
          this.Azz.ztn = localTimeLineObject.HUD;
          this.Azz.ztt = al.aA(localp.field_localPrivate, this.dsB);
          this.Azz.ztu = localp.field_type;
          if (localTimeLineObject.HUG == null) {
            break label600;
          }
          this.Azz.ztv = localTimeLineObject.HUG.Gtx.size();
        }
        localp = (p)paramList.get(n);
        this.Azz.zti = localp.field_head;
        localTimeLineObject = localp.ebP();
        this.Azz.zto = localTimeLineObject.HUD;
        this.Azz.ztp = localp.field_type;
        this.Azz.ztr = al.aA(localp.field_localPrivate, this.dsB);
        if (localTimeLineObject.HUG == null) {
          break label611;
        }
        this.Azz.ztq = localTimeLineObject.HUG.Gtx.size();
        if (!this.Azz.dWg()) {
          break label622;
        }
        i = 1;
        localHashMap1.put(Integer.valueOf(m), Integer.valueOf(j));
        localHashMap2.put(Integer.valueOf(m), Integer.valueOf(i));
        i2 = j + i;
        localHashMap3.put(Integer.valueOf(m), Integer.valueOf(i1));
        if ((!this.dsB) || (n != 0)) {
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
        this.Azz.sud = 0;
        break label264;
        label600:
        this.Azz.ztv = 0;
        break label376;
        label611:
        this.Azz.ztq = 0;
        break label477;
        label622:
        if (this.Azz.dWh())
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
          if (this.Azz.ztp == 1) {
            j = 1;
          }
        }
        k = j;
        if (i >= 2)
        {
          k = j;
          if (this.Azz.ztl == 1) {
            k = j + 1;
          }
        }
        j = k;
        if (i >= 3)
        {
          j = k;
          if (this.Azz.ztu == 1) {
            j = k + 1;
          }
        }
      }
    }
    this.Afb = m;
    this.Afc = paramList.size();
    ae.d("MicroMsg.SnsSelfAdapterSearchHelper", "icount " + this.Afb);
    this.list = paramList;
    r.bk("SnsphotoAdapter initFixType ", l);
    this.Azy.b(this.list, localHashMap1, localHashMap2, localHashMap3, this.Afc, this.Afb);
    AppMethodBeat.o(219923);
  }
  
  public final void gd(List<p> paramList)
  {
    AppMethodBeat.i(99071);
    if (this.Azy != null)
    {
      if (paramList != null) {
        f(this.AzB, paramList);
      }
      this.Azy.egf();
    }
    AppMethodBeat.o(99071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bg
 * JD-Core Version:    0.7.0.1
 */