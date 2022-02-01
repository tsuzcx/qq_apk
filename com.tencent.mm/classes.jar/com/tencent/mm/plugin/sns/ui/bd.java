package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.c;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class bd
  extends d<p>
{
  private boolean dfZ;
  List<p> list;
  Comparator<p> xPE;
  private boolean yQQ;
  private bc.a yQR;
  private c yQS;
  boolean yQU;
  private int ywI;
  private int ywJ;
  
  public bd(bc.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(99068);
    this.dfZ = false;
    this.list = new ArrayList();
    this.ywI = 0;
    this.ywJ = 0;
    this.yQU = false;
    this.yQQ = false;
    this.xPE = new Comparator() {};
    this.yQR = parama;
    this.dfZ = paramBoolean;
    AppMethodBeat.o(99068);
  }
  
  public final List<p> WX()
  {
    AppMethodBeat.i(99072);
    List localList = aj.jb(q.wX(aj.xRo), q.wX(aj.xRp));
    ac.i("MicroMsg.SnsSelfAdapterSearchHelper", "loadData thread: %d count: %d", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()) });
    AppMethodBeat.o(99072);
    return localList;
  }
  
  public final void af(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99069);
    this.yQQ = paramBoolean1;
    mJ(paramBoolean2);
    AppMethodBeat.o(99069);
  }
  
  final void f(boolean paramBoolean, List<p> paramList)
  {
    AppMethodBeat.i(200535);
    this.yQS = new c();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    long l = System.currentTimeMillis();
    int j = 0;
    int i1 = 0;
    p localp;
    if ((paramBoolean) && (this.dfZ))
    {
      localp = new p((byte)0);
      localp.field_snsId = 0L;
      localp.yvp = -1;
      localp.setCreateTime((int)(System.currentTimeMillis() / 1000L));
      paramList.add(0, localp);
    }
    int i3 = paramList.size();
    ac.d("MicroMsg.SnsSelfAdapterSearchHelper", "initFixType ".concat(String.valueOf(i3)));
    int n = 0;
    int m = 0;
    if (n < i3)
    {
      this.yQS.dGs();
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
        this.yQS.xMB = localp.field_head;
        localTimeLineObject = localp.dLV();
        this.yQS.xME = localTimeLineObject.FQl;
        this.yQS.xMC = aj.as(localp.field_localPrivate, this.dfZ);
        this.yQS.xMD = localp.field_type;
        if (localTimeLineObject.FQo != null) {
          this.yQS.rvG = localTimeLineObject.FQo.Etz.size();
        }
      }
      else
      {
        if (n + 2 < i3)
        {
          localp = (p)paramList.get(n + 2);
          this.yQS.xMK = localp.field_head;
          localTimeLineObject = localp.dLV();
          this.yQS.xMF = localTimeLineObject.FQl;
          this.yQS.xML = aj.as(localp.field_localPrivate, this.dfZ);
          this.yQS.xMM = localp.field_type;
          if (localTimeLineObject.FQo == null) {
            break label600;
          }
          this.yQS.xMN = localTimeLineObject.FQo.Etz.size();
        }
        localp = (p)paramList.get(n);
        this.yQS.xMA = localp.field_head;
        localTimeLineObject = localp.dLV();
        this.yQS.xMG = localTimeLineObject.FQl;
        this.yQS.xMH = localp.field_type;
        this.yQS.xMJ = aj.as(localp.field_localPrivate, this.dfZ);
        if (localTimeLineObject.FQo == null) {
          break label611;
        }
        this.yQS.xMI = localTimeLineObject.FQo.Etz.size();
        if (!this.yQS.dGt()) {
          break label622;
        }
        i = 1;
        localHashMap1.put(Integer.valueOf(m), Integer.valueOf(j));
        localHashMap2.put(Integer.valueOf(m), Integer.valueOf(i));
        i2 = j + i;
        localHashMap3.put(Integer.valueOf(m), Integer.valueOf(i1));
        if ((!this.dfZ) || (n != 0)) {
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
        this.yQS.rvG = 0;
        break label264;
        label600:
        this.yQS.xMN = 0;
        break label376;
        label611:
        this.yQS.xMI = 0;
        break label477;
        label622:
        if (this.yQS.dGu())
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
          if (this.yQS.xMH == 1) {
            j = 1;
          }
        }
        k = j;
        if (i >= 2)
        {
          k = j;
          if (this.yQS.xMD == 1) {
            k = j + 1;
          }
        }
        j = k;
        if (i >= 3)
        {
          j = k;
          if (this.yQS.xMM == 1) {
            j = k + 1;
          }
        }
      }
    }
    this.ywI = m;
    this.ywJ = paramList.size();
    ac.d("MicroMsg.SnsSelfAdapterSearchHelper", "icount " + this.ywI);
    this.list = paramList;
    q.bg("SnsphotoAdapter initFixType ", l);
    this.yQR.b(this.list, localHashMap1, localHashMap2, localHashMap3, this.ywJ, this.ywI);
    AppMethodBeat.o(200535);
  }
  
  public final void fJ(List<p> paramList)
  {
    AppMethodBeat.i(99071);
    if (this.yQR != null)
    {
      if (paramList != null) {
        f(this.yQU, paramList);
      }
      this.yQR.dQi();
    }
    AppMethodBeat.o(99071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd
 * JD-Core Version:    0.7.0.1
 */