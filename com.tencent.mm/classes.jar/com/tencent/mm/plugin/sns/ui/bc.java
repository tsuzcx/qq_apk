package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.c;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
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
  private boolean dfZ;
  List<p> list;
  private String qui;
  private String userName;
  private Comparator<p> xPE;
  private boolean yQQ;
  private a yQR;
  private c yQS;
  private int ywI;
  private int ywJ;
  
  public bc(a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99057);
    this.userName = "";
    this.list = new ArrayList();
    this.dfZ = false;
    this.ywI = 0;
    this.ywJ = 0;
    this.qui = "";
    this.yQQ = false;
    this.xPE = new Comparator() {};
    this.yQR = parama;
    this.userName = paramString;
    this.dfZ = paramBoolean;
    AppMethodBeat.o(99057);
  }
  
  private int b(int paramInt1, int paramInt2, List<p> paramList)
  {
    AppMethodBeat.i(99065);
    this.yQS.dGs();
    if ((this.dfZ) && (paramInt1 == 0))
    {
      AppMethodBeat.o(99065);
      return 1;
    }
    Object localObject;
    TimeLineObject localTimeLineObject;
    if (paramInt1 + 1 < paramInt2)
    {
      localObject = (p)paramList.get(paramInt1 + 1);
      this.yQS.xMB = ((p)localObject).field_head;
      localTimeLineObject = ((p)localObject).dLV();
      this.yQS.xME = localTimeLineObject.FQl;
      this.yQS.xMC = aj.as(((p)localObject).field_localPrivate, this.dfZ);
      this.yQS.xMD = ((p)localObject).field_type;
      if (localTimeLineObject.FQo != null) {
        this.yQS.rvG = localTimeLineObject.FQo.Etz.size();
      }
    }
    else
    {
      if (paramInt1 + 2 < paramInt2)
      {
        localObject = (p)paramList.get(paramInt1 + 2);
        this.yQS.xMK = ((p)localObject).field_head;
        localTimeLineObject = ((p)localObject).dLV();
        this.yQS.xMF = localTimeLineObject.FQl;
        this.yQS.xML = aj.as(((p)localObject).field_localPrivate, this.dfZ);
        this.yQS.xMM = ((p)localObject).field_type;
        if (localTimeLineObject.FQo == null) {
          break label371;
        }
        this.yQS.xMN = localTimeLineObject.FQo.Etz.size();
      }
      label248:
      paramList = (p)paramList.get(paramInt1);
      this.yQS.xMA = paramList.field_head;
      localObject = paramList.dLV();
      this.yQS.xMG = ((TimeLineObject)localObject).FQl;
      this.yQS.xMH = paramList.field_type;
      this.yQS.xMJ = aj.as(paramList.field_localPrivate, this.dfZ);
      if (((TimeLineObject)localObject).FQo == null) {
        break label382;
      }
    }
    label371:
    label382:
    for (this.yQS.xMI = ((TimeLineObject)localObject).FQo.Etz.size();; this.yQS.xMI = 0)
    {
      if (!this.yQS.dGt()) {
        break label393;
      }
      AppMethodBeat.o(99065);
      return 1;
      this.yQS.rvG = 0;
      break;
      this.yQS.xMN = 0;
      break label248;
    }
    label393:
    if (this.yQS.dGu())
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
    if (this.dfZ)
    {
      p localp = new p((byte)0);
      localp.field_snsId = 0L;
      localp.yvp = -1;
      localp.setCreateTime((int)(System.currentTimeMillis() / 1000L));
      paramList.add(0, localp);
    }
    AppMethodBeat.o(99066);
  }
  
  private void f(boolean paramBoolean, List<p> paramList)
  {
    AppMethodBeat.i(99067);
    this.yQS = new c();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    long l = System.currentTimeMillis();
    int m = 0;
    int k = 0;
    int i = 0;
    e(paramBoolean, paramList);
    int n = paramList.size();
    ac.d("MicroMsg.SnsSelfHelper", "initFixType ".concat(String.valueOf(n)));
    int j = 0;
    while (j < n)
    {
      int i1 = b(j, n, paramList);
      localHashMap1.put(Integer.valueOf(i), Integer.valueOf(m));
      localHashMap2.put(Integer.valueOf(i), Integer.valueOf(i1));
      m += i1;
      localHashMap3.put(Integer.valueOf(i), Integer.valueOf(k));
      k += hB(j, i1);
      j += i1;
      i += 1;
    }
    this.ywI = i;
    this.ywJ = paramList.size();
    ac.d("MicroMsg.SnsSelfHelper", "icount " + this.ywI);
    this.list = paramList;
    com.tencent.mm.plugin.sns.data.q.bg("SnsphotoAdapter initFixType ", l);
    this.yQR.b(this.list, localHashMap1, localHashMap2, localHashMap3, this.ywJ, this.ywI);
    AppMethodBeat.o(99067);
  }
  
  private int hB(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    if ((this.dfZ) && (paramInt1 == 0)) {
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
          if (this.yQS.xMH == 1) {
            paramInt1 = 1;
          }
        }
        i = paramInt1;
        if (paramInt2 >= 2)
        {
          i = paramInt1;
          if (this.yQS.xMD == 1) {
            i = paramInt1 + 1;
          }
        }
        paramInt1 = i;
      } while (paramInt2 < 3);
      paramInt1 = i;
    } while (this.yQS.xMM != 1);
    return i + 1;
  }
  
  public final List<p> WX()
  {
    AppMethodBeat.i(99059);
    List localList = aj.a(this.userName, this.dfZ, this.qui, this.yQQ);
    ac.i("MicroMsg.SnsSelfHelper", "loadData thread: %d count: %d", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()) });
    AppMethodBeat.o(99059);
    return localList;
  }
  
  public final void dQk()
  {
    AppMethodBeat.i(99062);
    Collections.sort(this.list, this.xPE);
    AppMethodBeat.o(99062);
  }
  
  final void dQl()
  {
    AppMethodBeat.i(99063);
    f(false, this.list);
    AppMethodBeat.o(99063);
  }
  
  public final void fJ(List<p> paramList)
  {
    AppMethodBeat.i(99058);
    if (this.yQR != null)
    {
      if (paramList != null) {
        f(true, paramList);
      }
      this.yQR.dQi();
    }
    AppMethodBeat.o(99058);
  }
  
  final boolean fN(List<Integer> paramList)
  {
    AppMethodBeat.i(99060);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(99060);
      return false;
    }
    ac.d("MicroMsg.SnsSelfHelper", "remove Items");
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
        if ((localp != null) && (localp.yvp == j))
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
  
  final boolean fO(List<Integer> paramList)
  {
    AppMethodBeat.i(99061);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(99061);
      return false;
    }
    ac.d("MicroMsg.SnsSelfHelper", "change Items");
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
        if (localp.yvp == j)
        {
          ac.d("MicroMsg.SnsSelfHelper", "update list localId ".concat(String.valueOf(j)));
          this.list.remove(i);
          ((LinkedList)localObject).add(af.dHR().Ph(j));
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
  
  public final void h(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99064);
    ac.d("MicroMsg.SnsSelfHelper", "limitSeq ".concat(String.valueOf(paramString)));
    this.qui = paramString;
    this.yQQ = paramBoolean1;
    mJ(paramBoolean2);
    AppMethodBeat.o(99064);
  }
  
  public static abstract interface a
  {
    public abstract void b(List<p> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, Map<Integer, Integer> paramMap3, int paramInt1, int paramInt2);
    
    public abstract void dQi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bc
 * JD-Core Version:    0.7.0.1
 */