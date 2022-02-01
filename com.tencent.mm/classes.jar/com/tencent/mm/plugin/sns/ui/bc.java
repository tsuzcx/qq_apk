package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.c;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class bc
  extends d<p>
{
  private boolean diE;
  List<p> list;
  private String pLA;
  private String userName;
  private Comparator<p> wDj;
  private boolean xEc;
  private a xEd;
  private c xEe;
  private int xjP;
  private int xjQ;
  
  public bc(a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99057);
    this.userName = "";
    this.list = new ArrayList();
    this.diE = false;
    this.xjP = 0;
    this.xjQ = 0;
    this.pLA = "";
    this.xEc = false;
    this.wDj = new Comparator() {};
    this.xEd = parama;
    this.userName = paramString;
    this.diE = paramBoolean;
    AppMethodBeat.o(99057);
  }
  
  private int b(int paramInt1, int paramInt2, List<p> paramList)
  {
    AppMethodBeat.i(99065);
    this.xEe.drT();
    if ((this.diE) && (paramInt1 == 0))
    {
      AppMethodBeat.o(99065);
      return 1;
    }
    Object localObject;
    TimeLineObject localTimeLineObject;
    if (paramInt1 + 1 < paramInt2)
    {
      localObject = (p)paramList.get(paramInt1 + 1);
      this.xEe.wAh = ((p)localObject).field_head;
      localTimeLineObject = ((p)localObject).dxy();
      this.xEe.wAl = localTimeLineObject.Etj;
      this.xEe.wAi = aj.ap(((p)localObject).field_localPrivate, this.diE);
      this.xEe.wAj = ((p)localObject).field_type;
      if (localTimeLineObject.Etm != null) {
        this.xEe.wAk = localTimeLineObject.Etm.DaC.size();
      }
    }
    else
    {
      if (paramInt1 + 2 < paramInt2)
      {
        localObject = (p)paramList.get(paramInt1 + 2);
        this.xEe.wAr = ((p)localObject).field_head;
        localTimeLineObject = ((p)localObject).dxy();
        this.xEe.wAm = localTimeLineObject.Etj;
        this.xEe.wAs = aj.ap(((p)localObject).field_localPrivate, this.diE);
        this.xEe.wAt = ((p)localObject).field_type;
        if (localTimeLineObject.Etm == null) {
          break label371;
        }
        this.xEe.wAu = localTimeLineObject.Etm.DaC.size();
      }
      label248:
      paramList = (p)paramList.get(paramInt1);
      this.xEe.wAg = paramList.field_head;
      localObject = paramList.dxy();
      this.xEe.wAn = ((TimeLineObject)localObject).Etj;
      this.xEe.wAo = paramList.field_type;
      this.xEe.wAq = aj.ap(paramList.field_localPrivate, this.diE);
      if (((TimeLineObject)localObject).Etm == null) {
        break label382;
      }
    }
    label371:
    label382:
    for (this.xEe.wAp = ((TimeLineObject)localObject).Etm.DaC.size();; this.xEe.wAp = 0)
    {
      if (!this.xEe.drU()) {
        break label393;
      }
      AppMethodBeat.o(99065);
      return 1;
      this.xEe.wAk = 0;
      break;
      this.xEe.wAu = 0;
      break label248;
    }
    label393:
    if (this.xEe.drV())
    {
      AppMethodBeat.o(99065);
      return 2;
    }
    AppMethodBeat.o(99065);
    return 3;
  }
  
  private void e(boolean paramBoolean, List<p> paramList)
  {
    AppMethodBeat.i(99066);
    if (!paramBoolean)
    {
      AppMethodBeat.o(99066);
      return;
    }
    if (this.diE)
    {
      p localp = new p((byte)0);
      localp.field_snsId = 0L;
      localp.xiB = -1;
      localp.setCreateTime((int)(System.currentTimeMillis() / 1000L));
      paramList.add(0, localp);
    }
    AppMethodBeat.o(99066);
  }
  
  private void f(boolean paramBoolean, List<p> paramList)
  {
    AppMethodBeat.i(99067);
    this.xEe = new c();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    long l = System.currentTimeMillis();
    int m = 0;
    int k = 0;
    int i = 0;
    e(paramBoolean, paramList);
    int n = paramList.size();
    ad.d("MicroMsg.SnsSelfHelper", "initFixType ".concat(String.valueOf(n)));
    int j = 0;
    while (j < n)
    {
      int i1 = b(j, n, paramList);
      localHashMap1.put(Integer.valueOf(i), Integer.valueOf(m));
      localHashMap2.put(Integer.valueOf(i), Integer.valueOf(i1));
      m += i1;
      localHashMap3.put(Integer.valueOf(i), Integer.valueOf(k));
      k += hs(j, i1);
      j += i1;
      i += 1;
    }
    this.xjP = i;
    this.xjQ = paramList.size();
    ad.d("MicroMsg.SnsSelfHelper", "icount " + this.xjP);
    this.list = paramList;
    com.tencent.mm.plugin.sns.data.q.be("SnsphotoAdapter initFixType ", l);
    this.xEd.b(this.list, localHashMap1, localHashMap2, localHashMap3, this.xjQ, this.xjP);
    AppMethodBeat.o(99067);
  }
  
  private int hs(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    if ((this.diE) && (paramInt1 == 0)) {
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
          if (this.xEe.wAo == 1) {
            paramInt1 = 1;
          }
        }
        i = paramInt1;
        if (paramInt2 >= 2)
        {
          i = paramInt1;
          if (this.xEe.wAj == 1) {
            i = paramInt1 + 1;
          }
        }
        paramInt1 = i;
      } while (paramInt2 < 3);
      paramInt1 = i;
    } while (this.xEe.wAt != 1);
    return i + 1;
  }
  
  public final List<p> VZ()
  {
    AppMethodBeat.i(99059);
    List localList = aj.a(this.userName, this.diE, this.pLA, this.xEc);
    ad.i("MicroMsg.SnsSelfHelper", "loadData thread: %d count: %d", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()) });
    AppMethodBeat.o(99059);
    return localList;
  }
  
  public final void dBN()
  {
    AppMethodBeat.i(99062);
    Collections.sort(this.list, this.wDj);
    AppMethodBeat.o(99062);
  }
  
  final void dBO()
  {
    AppMethodBeat.i(99063);
    f(false, this.list);
    AppMethodBeat.o(99063);
  }
  
  public final void fB(List<p> paramList)
  {
    AppMethodBeat.i(99058);
    if (this.xEd != null)
    {
      if (paramList != null) {
        f(true, paramList);
      }
      this.xEd.dBL();
    }
    AppMethodBeat.o(99058);
  }
  
  final boolean fF(List<Integer> paramList)
  {
    AppMethodBeat.i(99060);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(99060);
      return false;
    }
    ad.d("MicroMsg.SnsSelfHelper", "remove Items");
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
        p localp = (p)this.list.get(i);
        if ((localp != null) && (localp.xiB == j))
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
  
  final boolean fG(List<Integer> paramList)
  {
    AppMethodBeat.i(99061);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(99061);
      return false;
    }
    ad.d("MicroMsg.SnsSelfHelper", "change Items");
    Object localObject = new LinkedList();
    int i = 1;
    boolean bool = false;
    if (i < this.list.size())
    {
      p localp = (p)this.list.get(i);
      if (localp == null) {
        break label226;
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        int j = ((Integer)localIterator.next()).intValue();
        if (localp.xiB == j)
        {
          ad.d("MicroMsg.SnsSelfHelper", "update list localId ".concat(String.valueOf(j)));
          this.list.remove(i);
          ((LinkedList)localObject).add(af.dtu().Ne(j));
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
        localObject = (p)paramList.next();
        this.list.add(localObject);
      }
      AppMethodBeat.o(99061);
      return bool;
    }
  }
  
  public final void g(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99064);
    ad.d("MicroMsg.SnsSelfHelper", "limitSeq ".concat(String.valueOf(paramString)));
    this.pLA = paramString;
    this.xEc = paramBoolean1;
    lQ(paramBoolean2);
    AppMethodBeat.o(99064);
  }
  
  public static abstract interface a
  {
    public abstract void b(List<p> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, Map<Integer, Integer> paramMap3, int paramInt1, int paramInt2);
    
    public abstract void dBL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bc
 * JD-Core Version:    0.7.0.1
 */