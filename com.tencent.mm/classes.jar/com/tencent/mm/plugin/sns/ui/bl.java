package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class bl
  extends d<SnsInfo>
{
  private boolean ABX;
  Comparator<SnsInfo> JTy;
  private int KAH;
  private int KAI;
  private bk.a KWU;
  private g KWV;
  boolean KWX;
  private boolean fCB;
  List<SnsInfo> list;
  
  public bl(bk.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(99068);
    this.fCB = false;
    this.list = new ArrayList();
    this.KAH = 0;
    this.KAI = 0;
    this.KWX = false;
    this.ABX = false;
    this.JTy = new Comparator() {};
    this.KWU = parama;
    this.fCB = paramBoolean;
    AppMethodBeat.o(99068);
  }
  
  public final void aC(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99069);
    this.ABX = paramBoolean1;
    sk(paramBoolean2);
    AppMethodBeat.o(99069);
  }
  
  public final List<SnsInfo> ato()
  {
    AppMethodBeat.i(99072);
    List localList = an.kC(t.Qv(an.JVf), t.Qv(an.JVg));
    Log.i("MicroMsg.SnsSelfAdapterSearchHelper", "loadData thread: %d count: %d", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()) });
    AppMethodBeat.o(99072);
    return localList;
  }
  
  final void g(boolean paramBoolean, List<SnsInfo> paramList)
  {
    AppMethodBeat.i(269821);
    this.KWV = new g();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    long l = System.currentTimeMillis();
    int j = 0;
    int i1 = 0;
    SnsInfo localSnsInfo;
    if ((paramBoolean) && (this.fCB))
    {
      localSnsInfo = new SnsInfo(0L);
      localSnsInfo.field_snsId = 0L;
      localSnsInfo.localid = -1;
      localSnsInfo.setCreateTime((int)(System.currentTimeMillis() / 1000L));
      paramList.add(0, localSnsInfo);
    }
    int i3 = paramList.size();
    Log.d("MicroMsg.SnsSelfAdapterSearchHelper", "initFixType ".concat(String.valueOf(i3)));
    int n = 0;
    int m = 0;
    if (n < i3)
    {
      this.KWV.fNi();
      TimeLineObject localTimeLineObject;
      label264:
      label376:
      int i;
      label477:
      label489:
      int i2;
      if (n + 1 < i3)
      {
        localSnsInfo = (SnsInfo)paramList.get(n + 1);
        this.KWV.JPZ = localSnsInfo.getHead();
        localTimeLineObject = localSnsInfo.getTimeLine();
        this.KWV.JQc = localTimeLineObject.ContentDesc;
        this.KWV.JQa = an.aZ(localSnsInfo.getLocalPrivate(), this.fCB);
        this.KWV.JQb = localSnsInfo.getTypeFlag();
        if (localTimeLineObject.ContentObj != null) {
          this.KWV.zKD = localTimeLineObject.ContentObj.Sqr.size();
        }
      }
      else
      {
        if (n + 2 < i3)
        {
          localSnsInfo = (SnsInfo)paramList.get(n + 2);
          this.KWV.JQi = localSnsInfo.getHead();
          localTimeLineObject = localSnsInfo.getTimeLine();
          this.KWV.JQd = localTimeLineObject.ContentDesc;
          this.KWV.JQj = an.aZ(localSnsInfo.getLocalPrivate(), this.fCB);
          this.KWV.JQk = localSnsInfo.getTypeFlag();
          if (localTimeLineObject.ContentObj == null) {
            break label600;
          }
          this.KWV.JQl = localTimeLineObject.ContentObj.Sqr.size();
        }
        localSnsInfo = (SnsInfo)paramList.get(n);
        this.KWV.JPY = localSnsInfo.getHead();
        localTimeLineObject = localSnsInfo.getTimeLine();
        this.KWV.JQe = localTimeLineObject.ContentDesc;
        this.KWV.JQf = localSnsInfo.getTypeFlag();
        this.KWV.JQh = an.aZ(localSnsInfo.getLocalPrivate(), this.fCB);
        if (localTimeLineObject.ContentObj == null) {
          break label611;
        }
        this.KWV.JQg = localTimeLineObject.ContentObj.Sqr.size();
        if (!this.KWV.fNj()) {
          break label622;
        }
        i = 1;
        localHashMap1.put(Integer.valueOf(m), Integer.valueOf(j));
        localHashMap2.put(Integer.valueOf(m), Integer.valueOf(i));
        i2 = j + i;
        localHashMap3.put(Integer.valueOf(m), Integer.valueOf(i1));
        if ((!this.fCB) || (n != 0)) {
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
        this.KWV.zKD = 0;
        break label264;
        label600:
        this.KWV.JQl = 0;
        break label376;
        label611:
        this.KWV.JQg = 0;
        break label477;
        label622:
        if (this.KWV.fNk())
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
          if (this.KWV.JQf == 1) {
            j = 1;
          }
        }
        k = j;
        if (i >= 2)
        {
          k = j;
          if (this.KWV.JQb == 1) {
            k = j + 1;
          }
        }
        j = k;
        if (i >= 3)
        {
          j = k;
          if (this.KWV.JQk == 1) {
            j = k + 1;
          }
        }
      }
    }
    this.KAH = m;
    this.KAI = paramList.size();
    Log.d("MicroMsg.SnsSelfAdapterSearchHelper", "icount " + this.KAH);
    this.list = paramList;
    t.bp("SnsphotoAdapter initFixType ", l);
    this.KWU.b(this.list, localHashMap1, localHashMap2, localHashMap3, this.KAI, this.KAH);
    AppMethodBeat.o(269821);
  }
  
  public final void hH(List<SnsInfo> paramList)
  {
    AppMethodBeat.i(99071);
    if (this.KWU != null)
    {
      if (paramList != null) {
        g(this.KWX, paramList);
      }
      this.KWU.fWT();
    }
    AppMethodBeat.o(99071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bl
 * JD-Core Version:    0.7.0.1
 */