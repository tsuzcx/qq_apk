package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class bm
  extends d<SnsInfo>
{
  private boolean Gdb;
  Comparator<SnsInfo> QqB;
  private int Rao;
  private int Rap;
  private bl.a RwO;
  private g RwP;
  boolean RwR;
  private boolean hHq;
  List<SnsInfo> list;
  
  public bm(bl.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(99068);
    this.hHq = false;
    this.list = new ArrayList();
    this.Rao = 0;
    this.Rap = 0;
    this.RwR = false;
    this.Gdb = false;
    this.QqB = new Comparator() {};
    this.RwO = parama;
    this.hHq = paramBoolean;
    AppMethodBeat.o(99068);
  }
  
  public final List<SnsInfo> aNv()
  {
    int i = 0;
    AppMethodBeat.i(99072);
    List localList = ap.mf(t.uB(ap.maxId), t.uB(ap.Qsh));
    long l = Thread.currentThread().getId();
    if (localList == null) {}
    for (;;)
    {
      Log.i("MicroMsg.SnsSelfAdapterSearchHelper", "loadData thread: %d count: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(99072);
      return localList;
      i = localList.size();
    }
  }
  
  public final void aX(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99069);
    this.Gdb = paramBoolean1;
    wq(paramBoolean2);
    AppMethodBeat.o(99069);
  }
  
  final void i(boolean paramBoolean, List<SnsInfo> paramList)
  {
    AppMethodBeat.i(308353);
    this.RwP = new g();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    long l = System.currentTimeMillis();
    int j = 0;
    int i1 = 0;
    SnsInfo localSnsInfo;
    if ((paramBoolean) && (this.hHq))
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
      this.RwP.heJ();
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
        this.RwP.QmG = localSnsInfo.getHead();
        localTimeLineObject = localSnsInfo.getTimeLine();
        this.RwP.QmJ = localTimeLineObject.ContentDesc;
        this.RwP.QmH = ap.bG(localSnsInfo.getLocalPrivate(), this.hHq);
        this.RwP.QmI = localSnsInfo.getTypeFlag();
        if (localTimeLineObject.ContentObj != null) {
          this.RwP.EVk = localTimeLineObject.ContentObj.Zpr.size();
        }
      }
      else
      {
        if (n + 2 < i3)
        {
          localSnsInfo = (SnsInfo)paramList.get(n + 2);
          this.RwP.QmP = localSnsInfo.getHead();
          localTimeLineObject = localSnsInfo.getTimeLine();
          this.RwP.QmK = localTimeLineObject.ContentDesc;
          this.RwP.QmQ = ap.bG(localSnsInfo.getLocalPrivate(), this.hHq);
          this.RwP.QmR = localSnsInfo.getTypeFlag();
          if (localTimeLineObject.ContentObj == null) {
            break label600;
          }
          this.RwP.QmS = localTimeLineObject.ContentObj.Zpr.size();
        }
        localSnsInfo = (SnsInfo)paramList.get(n);
        this.RwP.QmF = localSnsInfo.getHead();
        localTimeLineObject = localSnsInfo.getTimeLine();
        this.RwP.QmL = localTimeLineObject.ContentDesc;
        this.RwP.QmM = localSnsInfo.getTypeFlag();
        this.RwP.QmO = ap.bG(localSnsInfo.getLocalPrivate(), this.hHq);
        if (localTimeLineObject.ContentObj == null) {
          break label611;
        }
        this.RwP.QmN = localTimeLineObject.ContentObj.Zpr.size();
        if (!this.RwP.heK()) {
          break label622;
        }
        i = 1;
        localHashMap1.put(Integer.valueOf(m), Integer.valueOf(j));
        localHashMap2.put(Integer.valueOf(m), Integer.valueOf(i));
        i2 = j + i;
        localHashMap3.put(Integer.valueOf(m), Integer.valueOf(i1));
        if ((!this.hHq) || (n != 0)) {
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
        this.RwP.EVk = 0;
        break label264;
        label600:
        this.RwP.QmS = 0;
        break label376;
        label611:
        this.RwP.QmN = 0;
        break label477;
        label622:
        if (this.RwP.heL())
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
          if (this.RwP.QmM == 1) {
            j = 1;
          }
        }
        k = j;
        if (i >= 2)
        {
          k = j;
          if (this.RwP.QmI == 1) {
            k = j + 1;
          }
        }
        j = k;
        if (i >= 3)
        {
          j = k;
          if (this.RwP.QmR == 1) {
            j = k + 1;
          }
        }
      }
    }
    this.Rao = m;
    this.Rap = paramList.size();
    Log.d("MicroMsg.SnsSelfAdapterSearchHelper", "icount " + this.Rao);
    this.list = paramList;
    t.bB("SnsphotoAdapter initFixType ", l);
    this.RwO.b(this.list, localHashMap1, localHashMap2, localHashMap3, this.Rap, this.Rao);
    AppMethodBeat.o(308353);
  }
  
  public final void kI(List<SnsInfo> paramList)
  {
    AppMethodBeat.i(99071);
    if (this.RwO != null)
    {
      if (paramList != null) {
        i(this.RwR, paramList);
      }
      this.RwO.hpm();
    }
    AppMethodBeat.o(99071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bm
 * JD-Core Version:    0.7.0.1
 */