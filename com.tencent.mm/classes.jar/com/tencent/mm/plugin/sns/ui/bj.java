package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class bj
  extends d<SnsInfo>
{
  Comparator<SnsInfo> DGA;
  private bi.a EIS;
  private e EIT;
  boolean EIV;
  private int Eny;
  private int Enz;
  private boolean dJM;
  List<SnsInfo> list;
  private boolean vUk;
  
  public bj(bi.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(99068);
    this.dJM = false;
    this.list = new ArrayList();
    this.Eny = 0;
    this.Enz = 0;
    this.EIV = false;
    this.vUk = false;
    this.DGA = new Comparator() {};
    this.EIS = parama;
    this.dJM = paramBoolean;
    AppMethodBeat.o(99068);
  }
  
  public final List<SnsInfo> anm()
  {
    AppMethodBeat.i(99072);
    List localList = an.kh(r.Jc(an.DIf), r.Jc(an.DIg));
    Log.i("MicroMsg.SnsSelfAdapterSearchHelper", "loadData thread: %d count: %d", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()) });
    AppMethodBeat.o(99072);
    return localList;
  }
  
  public final void aq(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99069);
    this.vUk = paramBoolean1;
    pN(paramBoolean2);
    AppMethodBeat.o(99069);
  }
  
  final void g(boolean paramBoolean, List<SnsInfo> paramList)
  {
    AppMethodBeat.i(203636);
    this.EIT = new e();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    long l = System.currentTimeMillis();
    int j = 0;
    int i1 = 0;
    SnsInfo localSnsInfo;
    if ((paramBoolean) && (this.dJM))
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
      this.EIT.eZq();
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
        this.EIT.DDu = localSnsInfo.getHead();
        localTimeLineObject = localSnsInfo.getTimeLine();
        this.EIT.DDx = localTimeLineObject.ContentDesc;
        this.EIT.DDv = an.aQ(localSnsInfo.getLocalPrivate(), this.dJM);
        this.EIT.DDw = localSnsInfo.getTypeFlag();
        if (localTimeLineObject.ContentObj != null) {
          this.EIT.uUn = localTimeLineObject.ContentObj.LoV.size();
        }
      }
      else
      {
        if (n + 2 < i3)
        {
          localSnsInfo = (SnsInfo)paramList.get(n + 2);
          this.EIT.DDD = localSnsInfo.getHead();
          localTimeLineObject = localSnsInfo.getTimeLine();
          this.EIT.DDy = localTimeLineObject.ContentDesc;
          this.EIT.DDE = an.aQ(localSnsInfo.getLocalPrivate(), this.dJM);
          this.EIT.DDF = localSnsInfo.getTypeFlag();
          if (localTimeLineObject.ContentObj == null) {
            break label600;
          }
          this.EIT.DDG = localTimeLineObject.ContentObj.LoV.size();
        }
        localSnsInfo = (SnsInfo)paramList.get(n);
        this.EIT.DDt = localSnsInfo.getHead();
        localTimeLineObject = localSnsInfo.getTimeLine();
        this.EIT.DDz = localTimeLineObject.ContentDesc;
        this.EIT.DDA = localSnsInfo.getTypeFlag();
        this.EIT.DDC = an.aQ(localSnsInfo.getLocalPrivate(), this.dJM);
        if (localTimeLineObject.ContentObj == null) {
          break label611;
        }
        this.EIT.DDB = localTimeLineObject.ContentObj.LoV.size();
        if (!this.EIT.eZr()) {
          break label622;
        }
        i = 1;
        localHashMap1.put(Integer.valueOf(m), Integer.valueOf(j));
        localHashMap2.put(Integer.valueOf(m), Integer.valueOf(i));
        i2 = j + i;
        localHashMap3.put(Integer.valueOf(m), Integer.valueOf(i1));
        if ((!this.dJM) || (n != 0)) {
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
        this.EIT.uUn = 0;
        break label264;
        label600:
        this.EIT.DDG = 0;
        break label376;
        label611:
        this.EIT.DDB = 0;
        break label477;
        label622:
        if (this.EIT.eZs())
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
          if (this.EIT.DDA == 1) {
            j = 1;
          }
        }
        k = j;
        if (i >= 2)
        {
          k = j;
          if (this.EIT.DDw == 1) {
            k = j + 1;
          }
        }
        j = k;
        if (i >= 3)
        {
          j = k;
          if (this.EIT.DDF == 1) {
            j = k + 1;
          }
        }
      }
    }
    this.Eny = m;
    this.Enz = paramList.size();
    Log.d("MicroMsg.SnsSelfAdapterSearchHelper", "icount " + this.Eny);
    this.list = paramList;
    r.bm("SnsphotoAdapter initFixType ", l);
    this.EIS.b(this.list, localHashMap1, localHashMap2, localHashMap3, this.Enz, this.Eny);
    AppMethodBeat.o(203636);
  }
  
  public final void gZ(List<SnsInfo> paramList)
  {
    AppMethodBeat.i(99071);
    if (this.EIS != null)
    {
      if (paramList != null) {
        g(this.EIV, paramList);
      }
      this.EIS.fiF();
    }
    AppMethodBeat.o(99071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bj
 * JD-Core Version:    0.7.0.1
 */