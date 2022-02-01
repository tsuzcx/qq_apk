package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class bk
  extends d<SnsInfo>
{
  private boolean ABX;
  private Comparator<SnsInfo> JTy;
  private int KAH;
  private int KAI;
  private a KWU;
  private g KWV;
  private boolean fCB;
  List<SnsInfo> list;
  private String userName;
  private String wtB;
  
  public bk(a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99057);
    this.userName = "";
    this.list = new ArrayList();
    this.fCB = false;
    this.KAH = 0;
    this.KAI = 0;
    this.wtB = "";
    this.ABX = false;
    this.JTy = new Comparator() {};
    this.KWU = parama;
    this.userName = paramString;
    this.fCB = paramBoolean;
    AppMethodBeat.o(99057);
  }
  
  private int b(int paramInt1, int paramInt2, List<SnsInfo> paramList)
  {
    AppMethodBeat.i(99065);
    this.KWV.fNi();
    if ((this.fCB) && (paramInt1 == 0))
    {
      AppMethodBeat.o(99065);
      return 1;
    }
    Object localObject;
    TimeLineObject localTimeLineObject;
    if (paramInt1 + 1 < paramInt2)
    {
      localObject = (SnsInfo)paramList.get(paramInt1 + 1);
      this.KWV.JPZ = ((SnsInfo)localObject).getHead();
      localTimeLineObject = ((SnsInfo)localObject).getTimeLine();
      this.KWV.JQc = localTimeLineObject.ContentDesc;
      this.KWV.JQa = an.aZ(((SnsInfo)localObject).getLocalPrivate(), this.fCB);
      this.KWV.JQb = ((SnsInfo)localObject).getTypeFlag();
      if (localTimeLineObject.ContentObj != null) {
        this.KWV.zKD = localTimeLineObject.ContentObj.Sqr.size();
      }
    }
    else
    {
      if (paramInt1 + 2 < paramInt2)
      {
        localObject = (SnsInfo)paramList.get(paramInt1 + 2);
        this.KWV.JQi = ((SnsInfo)localObject).getHead();
        localTimeLineObject = ((SnsInfo)localObject).getTimeLine();
        this.KWV.JQd = localTimeLineObject.ContentDesc;
        this.KWV.JQj = an.aZ(((SnsInfo)localObject).getLocalPrivate(), this.fCB);
        this.KWV.JQk = ((SnsInfo)localObject).getTypeFlag();
        if (localTimeLineObject.ContentObj == null) {
          break label371;
        }
        this.KWV.JQl = localTimeLineObject.ContentObj.Sqr.size();
      }
      label248:
      paramList = (SnsInfo)paramList.get(paramInt1);
      this.KWV.JPY = paramList.getHead();
      localObject = paramList.getTimeLine();
      this.KWV.JQe = ((TimeLineObject)localObject).ContentDesc;
      this.KWV.JQf = paramList.getTypeFlag();
      this.KWV.JQh = an.aZ(paramList.getLocalPrivate(), this.fCB);
      if (((TimeLineObject)localObject).ContentObj == null) {
        break label382;
      }
    }
    label371:
    label382:
    for (this.KWV.JQg = ((TimeLineObject)localObject).ContentObj.Sqr.size();; this.KWV.JQg = 0)
    {
      if (!this.KWV.fNj()) {
        break label393;
      }
      AppMethodBeat.o(99065);
      return 1;
      this.KWV.zKD = 0;
      break;
      this.KWV.JQl = 0;
      break label248;
    }
    label393:
    if (this.KWV.fNk())
    {
      AppMethodBeat.o(99065);
      return 2;
    }
    AppMethodBeat.o(99065);
    return 3;
  }
  
  private void f(boolean paramBoolean, List<SnsInfo> paramList)
  {
    AppMethodBeat.i(99066);
    if (!paramBoolean)
    {
      AppMethodBeat.o(99066);
      return;
    }
    if (this.fCB)
    {
      SnsInfo localSnsInfo = new SnsInfo(0L);
      localSnsInfo.field_snsId = 0L;
      localSnsInfo.localid = -1;
      localSnsInfo.setCreateTime((int)(System.currentTimeMillis() / 1000L));
      paramList.add(0, localSnsInfo);
    }
    AppMethodBeat.o(99066);
  }
  
  private void g(boolean paramBoolean, List<SnsInfo> paramList)
  {
    AppMethodBeat.i(99067);
    this.KWV = new g();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    long l = System.currentTimeMillis();
    int m = 0;
    int k = 0;
    int i = 0;
    f(paramBoolean, paramList);
    int n = paramList.size();
    Log.d("MicroMsg.SnsSelfHelper", "initFixType ".concat(String.valueOf(n)));
    int j = 0;
    while (j < n)
    {
      int i1 = b(j, n, paramList);
      localHashMap1.put(Integer.valueOf(i), Integer.valueOf(m));
      localHashMap2.put(Integer.valueOf(i), Integer.valueOf(i1));
      m += i1;
      localHashMap3.put(Integer.valueOf(i), Integer.valueOf(k));
      k += jZ(j, i1);
      j += i1;
      i += 1;
    }
    this.KAH = i;
    this.KAI = paramList.size();
    Log.d("MicroMsg.SnsSelfHelper", "icount " + this.KAH);
    this.list = paramList;
    t.bp("SnsphotoAdapter initFixType ", l);
    this.KWU.b(this.list, localHashMap1, localHashMap2, localHashMap3, this.KAI, this.KAH);
    AppMethodBeat.o(99067);
  }
  
  private int jZ(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    if ((this.fCB) && (paramInt1 == 0)) {
      paramInt1 = j;
    }
    do
    {
      do
      {
        return paramInt1;
        paramInt1 = i;
        if (paramInt2 > 0)
        {
          paramInt1 = i;
          if (this.KWV.JQf == 1) {
            paramInt1 = 1;
          }
        }
        i = paramInt1;
        if (paramInt2 >= 2)
        {
          i = paramInt1;
          if (this.KWV.JQb == 1) {
            i = paramInt1 + 1;
          }
        }
        paramInt1 = i;
      } while (paramInt2 < 3);
      paramInt1 = i;
    } while (this.KWV.JQk != 1);
    return i + 1;
  }
  
  public final List<SnsInfo> ato()
  {
    AppMethodBeat.i(99059);
    List localList = an.a(this.userName, this.fCB, this.wtB, this.ABX);
    Log.i("MicroMsg.SnsSelfHelper", "loadData thread: %d count: %d", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()) });
    AppMethodBeat.o(99059);
    return localList;
  }
  
  public final void fWV()
  {
    AppMethodBeat.i(99062);
    Collections.sort(this.list, this.JTy);
    AppMethodBeat.o(99062);
  }
  
  final void fWW()
  {
    AppMethodBeat.i(99063);
    g(false, this.list);
    AppMethodBeat.o(99063);
  }
  
  public final void hH(List<SnsInfo> paramList)
  {
    AppMethodBeat.i(99058);
    if (this.KWU != null)
    {
      if (paramList != null) {
        g(true, paramList);
      }
      this.KWU.fWT();
    }
    AppMethodBeat.o(99058);
  }
  
  final boolean hN(List<Integer> paramList)
  {
    AppMethodBeat.i(99060);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(99060);
      return false;
    }
    Log.d("MicroMsg.SnsSelfHelper", "remove Items");
    paramList = paramList.iterator();
    boolean bool = false;
    label137:
    while (paramList.hasNext())
    {
      int j = ((Integer)paramList.next()).intValue();
      int k = this.list.size();
      int i = 1;
      for (;;)
      {
        if (i >= k) {
          break label137;
        }
        SnsInfo localSnsInfo = (SnsInfo)this.list.get(i);
        if ((localSnsInfo != null) && (localSnsInfo.localid == j))
        {
          this.list.remove(i);
          bool = true;
          break;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(99060);
    return bool;
  }
  
  final boolean hO(List<Integer> paramList)
  {
    AppMethodBeat.i(99061);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(99061);
      return false;
    }
    Log.d("MicroMsg.SnsSelfHelper", "change Items");
    Object localObject = new LinkedList();
    int i = 1;
    boolean bool = false;
    if (i < this.list.size())
    {
      SnsInfo localSnsInfo = (SnsInfo)this.list.get(i);
      if (localSnsInfo == null) {
        break label226;
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        int j = ((Integer)localIterator.next()).intValue();
        if (localSnsInfo.localid == j)
        {
          Log.d("MicroMsg.SnsSelfHelper", "update list localId ".concat(String.valueOf(j)));
          this.list.remove(i);
          ((LinkedList)localObject).add(aj.fOI().agI(j));
          i -= 1;
          bool = true;
        }
      }
    }
    label226:
    for (;;)
    {
      i += 1;
      break;
      paramList = ((LinkedList)localObject).iterator();
      while (paramList.hasNext())
      {
        localObject = (SnsInfo)paramList.next();
        this.list.add(localObject);
      }
      AppMethodBeat.o(99061);
      return bool;
    }
  }
  
  public final void k(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99064);
    Log.d("MicroMsg.SnsSelfHelper", "limitSeq ".concat(String.valueOf(paramString)));
    this.wtB = paramString;
    this.ABX = paramBoolean1;
    sk(paramBoolean2);
    AppMethodBeat.o(99064);
  }
  
  public static abstract interface a
  {
    public abstract void b(List<SnsInfo> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, Map<Integer, Integer> paramMap3, int paramInt1, int paramInt2);
    
    public abstract void fWT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bk
 * JD-Core Version:    0.7.0.1
 */