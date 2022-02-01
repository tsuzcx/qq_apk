package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.c;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class bg
  extends d<p>
{
  private bf.a Aim;
  private c Ain;
  boolean Aip;
  private boolean drv;
  List<p> list;
  private boolean sKd;
  private int zNU;
  private int zNV;
  Comparator<p> zfy;
  
  public bg(bf.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(99068);
    this.drv = false;
    this.list = new ArrayList();
    this.zNU = 0;
    this.zNV = 0;
    this.Aip = false;
    this.sKd = false;
    this.zfy = new Comparator() {};
    this.Aim = parama;
    this.drv = paramBoolean;
    AppMethodBeat.o(99068);
  }
  
  public final List<p> Zq()
  {
    AppMethodBeat.i(99072);
    List localList = ak.jn(q.zx(ak.zhi), q.zx(ak.zhj));
    ad.i("MicroMsg.SnsSelfAdapterSearchHelper", "loadData thread: %d count: %d", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()) });
    AppMethodBeat.o(99072);
    return localList;
  }
  
  public final void aj(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99069);
    this.sKd = paramBoolean1;
    nd(paramBoolean2);
    AppMethodBeat.o(99069);
  }
  
  final void f(boolean paramBoolean, List<p> paramList)
  {
    AppMethodBeat.i(198382);
    this.Ain = new c();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    long l = System.currentTimeMillis();
    int j = 0;
    int i1 = 0;
    p localp;
    if ((paramBoolean) && (this.drv))
    {
      localp = new p((byte)0);
      localp.field_snsId = 0L;
      localp.zMC = -1;
      localp.setCreateTime((int)(System.currentTimeMillis() / 1000L));
      paramList.add(0, localp);
    }
    int i3 = paramList.size();
    ad.d("MicroMsg.SnsSelfAdapterSearchHelper", "initFixType ".concat(String.valueOf(i3)));
    int n = 0;
    int m = 0;
    if (n < i3)
    {
      this.Ain.dSF();
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
        this.Ain.zct = localp.field_head;
        localTimeLineObject = localp.dYl();
        this.Ain.zcw = localTimeLineObject.HAQ;
        this.Ain.zcu = ak.ax(localp.field_localPrivate, this.drv);
        this.Ain.zcv = localp.field_type;
        if (localTimeLineObject.HAT != null) {
          this.Ain.slg = localTimeLineObject.HAT.GaQ.size();
        }
      }
      else
      {
        if (n + 2 < i3)
        {
          localp = (p)paramList.get(n + 2);
          this.Ain.zcC = localp.field_head;
          localTimeLineObject = localp.dYl();
          this.Ain.zcx = localTimeLineObject.HAQ;
          this.Ain.zcD = ak.ax(localp.field_localPrivate, this.drv);
          this.Ain.zcE = localp.field_type;
          if (localTimeLineObject.HAT == null) {
            break label600;
          }
          this.Ain.zcF = localTimeLineObject.HAT.GaQ.size();
        }
        localp = (p)paramList.get(n);
        this.Ain.zcs = localp.field_head;
        localTimeLineObject = localp.dYl();
        this.Ain.zcy = localTimeLineObject.HAQ;
        this.Ain.zcz = localp.field_type;
        this.Ain.zcB = ak.ax(localp.field_localPrivate, this.drv);
        if (localTimeLineObject.HAT == null) {
          break label611;
        }
        this.Ain.zcA = localTimeLineObject.HAT.GaQ.size();
        if (!this.Ain.dSG()) {
          break label622;
        }
        i = 1;
        localHashMap1.put(Integer.valueOf(m), Integer.valueOf(j));
        localHashMap2.put(Integer.valueOf(m), Integer.valueOf(i));
        i2 = j + i;
        localHashMap3.put(Integer.valueOf(m), Integer.valueOf(i1));
        if ((!this.drv) || (n != 0)) {
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
        this.Ain.slg = 0;
        break label264;
        label600:
        this.Ain.zcF = 0;
        break label376;
        label611:
        this.Ain.zcA = 0;
        break label477;
        label622:
        if (this.Ain.dSH())
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
          if (this.Ain.zcz == 1) {
            j = 1;
          }
        }
        k = j;
        if (i >= 2)
        {
          k = j;
          if (this.Ain.zcv == 1) {
            k = j + 1;
          }
        }
        j = k;
        if (i >= 3)
        {
          j = k;
          if (this.Ain.zcE == 1) {
            j = k + 1;
          }
        }
      }
    }
    this.zNU = m;
    this.zNV = paramList.size();
    ad.d("MicroMsg.SnsSelfAdapterSearchHelper", "icount " + this.zNU);
    this.list = paramList;
    q.bj("SnsphotoAdapter initFixType ", l);
    this.Aim.b(this.list, localHashMap1, localHashMap2, localHashMap3, this.zNV, this.zNU);
    AppMethodBeat.o(198382);
  }
  
  public final void fU(List<p> paramList)
  {
    AppMethodBeat.i(99071);
    if (this.Aim != null)
    {
      if (paramList != null) {
        f(this.Aip, paramList);
      }
      this.Aim.ecy();
    }
    AppMethodBeat.o(99071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bg
 * JD-Core Version:    0.7.0.1
 */