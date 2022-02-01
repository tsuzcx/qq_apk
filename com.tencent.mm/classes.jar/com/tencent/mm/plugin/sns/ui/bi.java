package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class bi
  extends d<SnsInfo>
{
  private Comparator<SnsInfo> DGA;
  private a EIS;
  private e EIT;
  private int Eny;
  private int Enz;
  private boolean dJM;
  List<SnsInfo> list;
  private String sNG;
  private String userName;
  private boolean vUk;
  
  public bi(a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99057);
    this.userName = "";
    this.list = new ArrayList();
    this.dJM = false;
    this.Eny = 0;
    this.Enz = 0;
    this.sNG = "";
    this.vUk = false;
    this.DGA = new Comparator() {};
    this.EIS = parama;
    this.userName = paramString;
    this.dJM = paramBoolean;
    AppMethodBeat.o(99057);
  }
  
  private int b(int paramInt1, int paramInt2, List<SnsInfo> paramList)
  {
    AppMethodBeat.i(99065);
    this.EIT.eZq();
    if ((this.dJM) && (paramInt1 == 0))
    {
      AppMethodBeat.o(99065);
      return 1;
    }
    Object localObject;
    TimeLineObject localTimeLineObject;
    if (paramInt1 + 1 < paramInt2)
    {
      localObject = (SnsInfo)paramList.get(paramInt1 + 1);
      this.EIT.DDu = ((SnsInfo)localObject).getHead();
      localTimeLineObject = ((SnsInfo)localObject).getTimeLine();
      this.EIT.DDx = localTimeLineObject.ContentDesc;
      this.EIT.DDv = an.aQ(((SnsInfo)localObject).getLocalPrivate(), this.dJM);
      this.EIT.DDw = ((SnsInfo)localObject).getTypeFlag();
      if (localTimeLineObject.ContentObj != null) {
        this.EIT.uUn = localTimeLineObject.ContentObj.LoV.size();
      }
    }
    else
    {
      if (paramInt1 + 2 < paramInt2)
      {
        localObject = (SnsInfo)paramList.get(paramInt1 + 2);
        this.EIT.DDD = ((SnsInfo)localObject).getHead();
        localTimeLineObject = ((SnsInfo)localObject).getTimeLine();
        this.EIT.DDy = localTimeLineObject.ContentDesc;
        this.EIT.DDE = an.aQ(((SnsInfo)localObject).getLocalPrivate(), this.dJM);
        this.EIT.DDF = ((SnsInfo)localObject).getTypeFlag();
        if (localTimeLineObject.ContentObj == null) {
          break label371;
        }
        this.EIT.DDG = localTimeLineObject.ContentObj.LoV.size();
      }
      label248:
      paramList = (SnsInfo)paramList.get(paramInt1);
      this.EIT.DDt = paramList.getHead();
      localObject = paramList.getTimeLine();
      this.EIT.DDz = ((TimeLineObject)localObject).ContentDesc;
      this.EIT.DDA = paramList.getTypeFlag();
      this.EIT.DDC = an.aQ(paramList.getLocalPrivate(), this.dJM);
      if (((TimeLineObject)localObject).ContentObj == null) {
        break label382;
      }
    }
    label371:
    label382:
    for (this.EIT.DDB = ((TimeLineObject)localObject).ContentObj.LoV.size();; this.EIT.DDB = 0)
    {
      if (!this.EIT.eZr()) {
        break label393;
      }
      AppMethodBeat.o(99065);
      return 1;
      this.EIT.uUn = 0;
      break;
      this.EIT.DDG = 0;
      break label248;
    }
    label393:
    if (this.EIT.eZs())
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
    if (this.dJM)
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
    this.EIT = new e();
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
      k += iQ(j, i1);
      j += i1;
      i += 1;
    }
    this.Eny = i;
    this.Enz = paramList.size();
    Log.d("MicroMsg.SnsSelfHelper", "icount " + this.Eny);
    this.list = paramList;
    r.bm("SnsphotoAdapter initFixType ", l);
    this.EIS.b(this.list, localHashMap1, localHashMap2, localHashMap3, this.Enz, this.Eny);
    AppMethodBeat.o(99067);
  }
  
  private int iQ(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    if ((this.dJM) && (paramInt1 == 0)) {
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
          if (this.EIT.DDA == 1) {
            paramInt1 = 1;
          }
        }
        i = paramInt1;
        if (paramInt2 >= 2)
        {
          i = paramInt1;
          if (this.EIT.DDw == 1) {
            i = paramInt1 + 1;
          }
        }
        paramInt1 = i;
      } while (paramInt2 < 3);
      paramInt1 = i;
    } while (this.EIT.DDF != 1);
    return i + 1;
  }
  
  public final List<SnsInfo> anm()
  {
    AppMethodBeat.i(99059);
    List localList = an.a(this.userName, this.dJM, this.sNG, this.vUk);
    Log.i("MicroMsg.SnsSelfHelper", "loadData thread: %d count: %d", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()) });
    AppMethodBeat.o(99059);
    return localList;
  }
  
  public final void fiH()
  {
    AppMethodBeat.i(99062);
    Collections.sort(this.list, this.DGA);
    AppMethodBeat.o(99062);
  }
  
  final void fiI()
  {
    AppMethodBeat.i(99063);
    g(false, this.list);
    AppMethodBeat.o(99063);
  }
  
  public final void gZ(List<SnsInfo> paramList)
  {
    AppMethodBeat.i(99058);
    if (this.EIS != null)
    {
      if (paramList != null) {
        g(true, paramList);
      }
      this.EIS.fiF();
    }
    AppMethodBeat.o(99058);
  }
  
  final boolean he(List<Integer> paramList)
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
  
  final boolean hf(List<Integer> paramList)
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
          ((LinkedList)localObject).add(aj.faO().Zr(j));
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
    this.sNG = paramString;
    this.vUk = paramBoolean1;
    pN(paramBoolean2);
    AppMethodBeat.o(99064);
  }
  
  public static abstract interface a
  {
    public abstract void b(List<SnsInfo> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, Map<Integer, Integer> paramMap3, int paramInt1, int paramInt2);
    
    public abstract void fiF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bi
 * JD-Core Version:    0.7.0.1
 */