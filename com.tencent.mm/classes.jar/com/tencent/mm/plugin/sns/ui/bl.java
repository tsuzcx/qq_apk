package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class bl
  extends d<SnsInfo>
{
  private boolean Gdb;
  private Comparator<SnsInfo> QqB;
  private int Rao;
  private int Rap;
  private a RwO;
  private g RwP;
  private boolean hHq;
  List<SnsInfo> list;
  private String userName;
  private String zPH;
  
  public bl(a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99057);
    this.userName = "";
    this.list = new ArrayList();
    this.hHq = false;
    this.Rao = 0;
    this.Rap = 0;
    this.zPH = "";
    this.Gdb = false;
    this.QqB = new Comparator() {};
    this.RwO = parama;
    this.userName = paramString;
    this.hHq = paramBoolean;
    AppMethodBeat.o(99057);
  }
  
  private int b(int paramInt1, int paramInt2, List<SnsInfo> paramList)
  {
    AppMethodBeat.i(99065);
    this.RwP.heJ();
    if ((this.hHq) && (paramInt1 == 0))
    {
      AppMethodBeat.o(99065);
      return 1;
    }
    Object localObject;
    TimeLineObject localTimeLineObject;
    if (paramInt1 + 1 < paramInt2)
    {
      localObject = (SnsInfo)paramList.get(paramInt1 + 1);
      this.RwP.QmG = ((SnsInfo)localObject).getHead();
      localTimeLineObject = ((SnsInfo)localObject).getTimeLine();
      this.RwP.QmJ = localTimeLineObject.ContentDesc;
      this.RwP.QmH = ap.bG(((SnsInfo)localObject).getLocalPrivate(), this.hHq);
      this.RwP.QmI = ((SnsInfo)localObject).getTypeFlag();
      if (localTimeLineObject.ContentObj != null) {
        this.RwP.EVk = localTimeLineObject.ContentObj.Zpr.size();
      }
    }
    else
    {
      if (paramInt1 + 2 < paramInt2)
      {
        localObject = (SnsInfo)paramList.get(paramInt1 + 2);
        this.RwP.QmP = ((SnsInfo)localObject).getHead();
        localTimeLineObject = ((SnsInfo)localObject).getTimeLine();
        this.RwP.QmK = localTimeLineObject.ContentDesc;
        this.RwP.QmQ = ap.bG(((SnsInfo)localObject).getLocalPrivate(), this.hHq);
        this.RwP.QmR = ((SnsInfo)localObject).getTypeFlag();
        if (localTimeLineObject.ContentObj == null) {
          break label371;
        }
        this.RwP.QmS = localTimeLineObject.ContentObj.Zpr.size();
      }
      label248:
      paramList = (SnsInfo)paramList.get(paramInt1);
      this.RwP.QmF = paramList.getHead();
      localObject = paramList.getTimeLine();
      this.RwP.QmL = ((TimeLineObject)localObject).ContentDesc;
      this.RwP.QmM = paramList.getTypeFlag();
      this.RwP.QmO = ap.bG(paramList.getLocalPrivate(), this.hHq);
      if (((TimeLineObject)localObject).ContentObj == null) {
        break label382;
      }
    }
    label371:
    label382:
    for (this.RwP.QmN = ((TimeLineObject)localObject).ContentObj.Zpr.size();; this.RwP.QmN = 0)
    {
      if (!this.RwP.heK()) {
        break label393;
      }
      AppMethodBeat.o(99065);
      return 1;
      this.RwP.EVk = 0;
      break;
      this.RwP.QmS = 0;
      break label248;
    }
    label393:
    if (this.RwP.heL())
    {
      AppMethodBeat.o(99065);
      return 2;
    }
    AppMethodBeat.o(99065);
    return 3;
  }
  
  private void h(boolean paramBoolean, List<SnsInfo> paramList)
  {
    AppMethodBeat.i(99066);
    if (!paramBoolean)
    {
      AppMethodBeat.o(99066);
      return;
    }
    if (this.hHq)
    {
      SnsInfo localSnsInfo = new SnsInfo(0L);
      localSnsInfo.field_snsId = 0L;
      localSnsInfo.localid = -1;
      localSnsInfo.setCreateTime((int)(System.currentTimeMillis() / 1000L));
      paramList.add(0, localSnsInfo);
    }
    AppMethodBeat.o(99066);
  }
  
  private void i(boolean paramBoolean, List<SnsInfo> paramList)
  {
    AppMethodBeat.i(99067);
    this.RwP = new g();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    long l = System.currentTimeMillis();
    int m = 0;
    int k = 0;
    int i = 0;
    h(paramBoolean, paramList);
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
      k += lL(j, i1);
      j += i1;
      i += 1;
    }
    this.Rao = i;
    this.Rap = paramList.size();
    Log.d("MicroMsg.SnsSelfHelper", "icount " + this.Rao);
    this.list = paramList;
    t.bB("SnsphotoAdapter initFixType ", l);
    this.RwO.b(this.list, localHashMap1, localHashMap2, localHashMap3, this.Rap, this.Rao);
    AppMethodBeat.o(99067);
  }
  
  private int lL(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    if ((this.hHq) && (paramInt1 == 0)) {
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
          if (this.RwP.QmM == 1) {
            paramInt1 = 1;
          }
        }
        i = paramInt1;
        if (paramInt2 >= 2)
        {
          i = paramInt1;
          if (this.RwP.QmI == 1) {
            i = paramInt1 + 1;
          }
        }
        paramInt1 = i;
      } while (paramInt2 < 3);
      paramInt1 = i;
    } while (this.RwP.QmR != 1);
    return i + 1;
  }
  
  public final List<SnsInfo> aNv()
  {
    int i = 0;
    AppMethodBeat.i(99059);
    List localList = ap.a(this.userName, this.hHq, this.zPH, this.Gdb);
    long l = Thread.currentThread().getId();
    if (localList == null) {}
    for (;;)
    {
      Log.i("MicroMsg.SnsSelfHelper", "loadData thread: %d count: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(99059);
      return localList;
      i = localList.size();
    }
  }
  
  public final void hpo()
  {
    AppMethodBeat.i(99062);
    Collections.sort(this.list, this.QqB);
    AppMethodBeat.o(99062);
  }
  
  final void hpp()
  {
    AppMethodBeat.i(99063);
    i(false, this.list);
    AppMethodBeat.o(99063);
  }
  
  public final void kI(List<SnsInfo> paramList)
  {
    AppMethodBeat.i(99058);
    if (this.RwO != null)
    {
      if (paramList != null) {
        i(true, paramList);
      }
      this.RwO.hpm();
    }
    AppMethodBeat.o(99058);
  }
  
  final boolean kO(List<Integer> paramList)
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
  
  final boolean kP(List<Integer> paramList)
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
          ((LinkedList)localObject).add(al.hgB().alB(j));
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
  
  public final void m(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99064);
    Log.d("MicroMsg.SnsSelfHelper", "limitSeq ".concat(String.valueOf(paramString)));
    this.zPH = paramString;
    this.Gdb = paramBoolean1;
    wq(paramBoolean2);
    AppMethodBeat.o(99064);
  }
  
  public static abstract interface a
  {
    public abstract void b(List<SnsInfo> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, Map<Integer, Integer> paramMap3, int paramInt1, int paramInt2);
    
    public abstract void hpm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bl
 * JD-Core Version:    0.7.0.1
 */