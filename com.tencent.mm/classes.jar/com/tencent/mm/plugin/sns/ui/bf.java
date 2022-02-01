package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class bf
  extends d<p>
{
  private int Afb;
  private int Afc;
  private a Azy;
  private com.tencent.mm.plugin.sns.data.d Azz;
  private boolean dsB;
  List<p> list;
  private String rmb;
  private boolean sVq;
  private String userName;
  private Comparator<p> zwo;
  
  public bf(a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99057);
    this.userName = "";
    this.list = new ArrayList();
    this.dsB = false;
    this.Afb = 0;
    this.Afc = 0;
    this.rmb = "";
    this.sVq = false;
    this.zwo = new Comparator() {};
    this.Azy = parama;
    this.userName = paramString;
    this.dsB = paramBoolean;
    AppMethodBeat.o(99057);
  }
  
  private int b(int paramInt1, int paramInt2, List<p> paramList)
  {
    AppMethodBeat.i(99065);
    this.Azz.dWf();
    if ((this.dsB) && (paramInt1 == 0))
    {
      AppMethodBeat.o(99065);
      return 1;
    }
    Object localObject;
    TimeLineObject localTimeLineObject;
    if (paramInt1 + 1 < paramInt2)
    {
      localObject = (p)paramList.get(paramInt1 + 1);
      this.Azz.ztj = ((p)localObject).field_head;
      localTimeLineObject = ((p)localObject).ebP();
      this.Azz.ztm = localTimeLineObject.HUD;
      this.Azz.ztk = al.aA(((p)localObject).field_localPrivate, this.dsB);
      this.Azz.ztl = ((p)localObject).field_type;
      if (localTimeLineObject.HUG != null) {
        this.Azz.sud = localTimeLineObject.HUG.Gtx.size();
      }
    }
    else
    {
      if (paramInt1 + 2 < paramInt2)
      {
        localObject = (p)paramList.get(paramInt1 + 2);
        this.Azz.zts = ((p)localObject).field_head;
        localTimeLineObject = ((p)localObject).ebP();
        this.Azz.ztn = localTimeLineObject.HUD;
        this.Azz.ztt = al.aA(((p)localObject).field_localPrivate, this.dsB);
        this.Azz.ztu = ((p)localObject).field_type;
        if (localTimeLineObject.HUG == null) {
          break label371;
        }
        this.Azz.ztv = localTimeLineObject.HUG.Gtx.size();
      }
      label248:
      paramList = (p)paramList.get(paramInt1);
      this.Azz.zti = paramList.field_head;
      localObject = paramList.ebP();
      this.Azz.zto = ((TimeLineObject)localObject).HUD;
      this.Azz.ztp = paramList.field_type;
      this.Azz.ztr = al.aA(paramList.field_localPrivate, this.dsB);
      if (((TimeLineObject)localObject).HUG == null) {
        break label382;
      }
    }
    label371:
    label382:
    for (this.Azz.ztq = ((TimeLineObject)localObject).HUG.Gtx.size();; this.Azz.ztq = 0)
    {
      if (!this.Azz.dWg()) {
        break label393;
      }
      AppMethodBeat.o(99065);
      return 1;
      this.Azz.sud = 0;
      break;
      this.Azz.ztv = 0;
      break label248;
    }
    label393:
    if (this.Azz.dWh())
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
    if (this.dsB)
    {
      p localp = new p((byte)0);
      localp.field_snsId = 0L;
      localp.AdJ = -1;
      localp.setCreateTime((int)(System.currentTimeMillis() / 1000L));
      paramList.add(0, localp);
    }
    AppMethodBeat.o(99066);
  }
  
  private void f(boolean paramBoolean, List<p> paramList)
  {
    AppMethodBeat.i(99067);
    this.Azz = new com.tencent.mm.plugin.sns.data.d();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    long l = System.currentTimeMillis();
    int m = 0;
    int k = 0;
    int i = 0;
    e(paramBoolean, paramList);
    int n = paramList.size();
    ae.d("MicroMsg.SnsSelfHelper", "initFixType ".concat(String.valueOf(n)));
    int j = 0;
    while (j < n)
    {
      int i1 = b(j, n, paramList);
      localHashMap1.put(Integer.valueOf(i), Integer.valueOf(m));
      localHashMap2.put(Integer.valueOf(i), Integer.valueOf(i1));
      m += i1;
      localHashMap3.put(Integer.valueOf(i), Integer.valueOf(k));
      k += hV(j, i1);
      j += i1;
      i += 1;
    }
    this.Afb = i;
    this.Afc = paramList.size();
    ae.d("MicroMsg.SnsSelfHelper", "icount " + this.Afb);
    this.list = paramList;
    r.bk("SnsphotoAdapter initFixType ", l);
    this.Azy.b(this.list, localHashMap1, localHashMap2, localHashMap3, this.Afc, this.Afb);
    AppMethodBeat.o(99067);
  }
  
  private int hV(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    if ((this.dsB) && (paramInt1 == 0)) {
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
          if (this.Azz.ztp == 1) {
            paramInt1 = 1;
          }
        }
        i = paramInt1;
        if (paramInt2 >= 2)
        {
          i = paramInt1;
          if (this.Azz.ztl == 1) {
            i = paramInt1 + 1;
          }
        }
        paramInt1 = i;
      } while (paramInt2 < 3);
      paramInt1 = i;
    } while (this.Azz.ztu != 1);
    return i + 1;
  }
  
  public final List<p> Zz()
  {
    AppMethodBeat.i(99059);
    List localList = al.a(this.userName, this.dsB, this.rmb, this.sVq);
    ae.i("MicroMsg.SnsSelfHelper", "loadData thread: %d count: %d", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()) });
    AppMethodBeat.o(99059);
    return localList;
  }
  
  public final void egh()
  {
    AppMethodBeat.i(99062);
    Collections.sort(this.list, this.zwo);
    AppMethodBeat.o(99062);
  }
  
  final void egi()
  {
    AppMethodBeat.i(99063);
    f(false, this.list);
    AppMethodBeat.o(99063);
  }
  
  public final void gd(List<p> paramList)
  {
    AppMethodBeat.i(99058);
    if (this.Azy != null)
    {
      if (paramList != null) {
        f(true, paramList);
      }
      this.Azy.egf();
    }
    AppMethodBeat.o(99058);
  }
  
  final boolean gh(List<Integer> paramList)
  {
    AppMethodBeat.i(99060);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(99060);
      return false;
    }
    ae.d("MicroMsg.SnsSelfHelper", "remove Items");
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
        if ((localp != null) && (localp.AdJ == j))
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
  
  final boolean gi(List<Integer> paramList)
  {
    AppMethodBeat.i(99061);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(99061);
      return false;
    }
    ae.d("MicroMsg.SnsSelfHelper", "change Items");
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
        if (localp.AdJ == j)
        {
          ae.d("MicroMsg.SnsSelfHelper", "update list localId ".concat(String.valueOf(j)));
          this.list.remove(i);
          ((LinkedList)localObject).add(ah.dXE().Rw(j));
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
  
  public final void j(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(99064);
    ae.d("MicroMsg.SnsSelfHelper", "limitSeq ".concat(String.valueOf(paramString)));
    this.rmb = paramString;
    this.sVq = paramBoolean1;
    nh(paramBoolean2);
    AppMethodBeat.o(99064);
  }
  
  public static abstract interface a
  {
    public abstract void b(List<p> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, Map<Integer, Integer> paramMap3, int paramInt1, int paramInt2);
    
    public abstract void egf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf
 * JD-Core Version:    0.7.0.1
 */