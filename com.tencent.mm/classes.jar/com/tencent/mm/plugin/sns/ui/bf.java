package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.c;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.sdk.platformtools.ad;
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
  private a Aim;
  private c Ain;
  private boolean drv;
  List<p> list;
  private String rdV;
  private boolean sKd;
  private String userName;
  private int zNU;
  private int zNV;
  private Comparator<p> zfy;
  
  public bf(a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99057);
    this.userName = "";
    this.list = new ArrayList();
    this.drv = false;
    this.zNU = 0;
    this.zNV = 0;
    this.rdV = "";
    this.sKd = false;
    this.zfy = new Comparator() {};
    this.Aim = parama;
    this.userName = paramString;
    this.drv = paramBoolean;
    AppMethodBeat.o(99057);
  }
  
  private int b(int paramInt1, int paramInt2, List<p> paramList)
  {
    AppMethodBeat.i(99065);
    this.Ain.dSF();
    if ((this.drv) && (paramInt1 == 0))
    {
      AppMethodBeat.o(99065);
      return 1;
    }
    Object localObject;
    TimeLineObject localTimeLineObject;
    if (paramInt1 + 1 < paramInt2)
    {
      localObject = (p)paramList.get(paramInt1 + 1);
      this.Ain.zct = ((p)localObject).field_head;
      localTimeLineObject = ((p)localObject).dYl();
      this.Ain.zcw = localTimeLineObject.HAQ;
      this.Ain.zcu = ak.ax(((p)localObject).field_localPrivate, this.drv);
      this.Ain.zcv = ((p)localObject).field_type;
      if (localTimeLineObject.HAT != null) {
        this.Ain.slg = localTimeLineObject.HAT.GaQ.size();
      }
    }
    else
    {
      if (paramInt1 + 2 < paramInt2)
      {
        localObject = (p)paramList.get(paramInt1 + 2);
        this.Ain.zcC = ((p)localObject).field_head;
        localTimeLineObject = ((p)localObject).dYl();
        this.Ain.zcx = localTimeLineObject.HAQ;
        this.Ain.zcD = ak.ax(((p)localObject).field_localPrivate, this.drv);
        this.Ain.zcE = ((p)localObject).field_type;
        if (localTimeLineObject.HAT == null) {
          break label371;
        }
        this.Ain.zcF = localTimeLineObject.HAT.GaQ.size();
      }
      label248:
      paramList = (p)paramList.get(paramInt1);
      this.Ain.zcs = paramList.field_head;
      localObject = paramList.dYl();
      this.Ain.zcy = ((TimeLineObject)localObject).HAQ;
      this.Ain.zcz = paramList.field_type;
      this.Ain.zcB = ak.ax(paramList.field_localPrivate, this.drv);
      if (((TimeLineObject)localObject).HAT == null) {
        break label382;
      }
    }
    label371:
    label382:
    for (this.Ain.zcA = ((TimeLineObject)localObject).HAT.GaQ.size();; this.Ain.zcA = 0)
    {
      if (!this.Ain.dSG()) {
        break label393;
      }
      AppMethodBeat.o(99065);
      return 1;
      this.Ain.slg = 0;
      break;
      this.Ain.zcF = 0;
      break label248;
    }
    label393:
    if (this.Ain.dSH())
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
    if (this.drv)
    {
      p localp = new p((byte)0);
      localp.field_snsId = 0L;
      localp.zMC = -1;
      localp.setCreateTime((int)(System.currentTimeMillis() / 1000L));
      paramList.add(0, localp);
    }
    AppMethodBeat.o(99066);
  }
  
  private void f(boolean paramBoolean, List<p> paramList)
  {
    AppMethodBeat.i(99067);
    this.Ain = new c();
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
      k += hS(j, i1);
      j += i1;
      i += 1;
    }
    this.zNU = i;
    this.zNV = paramList.size();
    ad.d("MicroMsg.SnsSelfHelper", "icount " + this.zNU);
    this.list = paramList;
    com.tencent.mm.plugin.sns.data.q.bj("SnsphotoAdapter initFixType ", l);
    this.Aim.b(this.list, localHashMap1, localHashMap2, localHashMap3, this.zNV, this.zNU);
    AppMethodBeat.o(99067);
  }
  
  private int hS(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    if ((this.drv) && (paramInt1 == 0)) {
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
          if (this.Ain.zcz == 1) {
            paramInt1 = 1;
          }
        }
        i = paramInt1;
        if (paramInt2 >= 2)
        {
          i = paramInt1;
          if (this.Ain.zcv == 1) {
            i = paramInt1 + 1;
          }
        }
        paramInt1 = i;
      } while (paramInt2 < 3);
      paramInt1 = i;
    } while (this.Ain.zcE != 1);
    return i + 1;
  }
  
  public final List<p> Zq()
  {
    AppMethodBeat.i(99059);
    List localList = ak.a(this.userName, this.drv, this.rdV, this.sKd);
    ad.i("MicroMsg.SnsSelfHelper", "loadData thread: %d count: %d", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(localList.size()) });
    AppMethodBeat.o(99059);
    return localList;
  }
  
  public final void ecA()
  {
    AppMethodBeat.i(99062);
    Collections.sort(this.list, this.zfy);
    AppMethodBeat.o(99062);
  }
  
  final void ecB()
  {
    AppMethodBeat.i(99063);
    f(false, this.list);
    AppMethodBeat.o(99063);
  }
  
  public final void fU(List<p> paramList)
  {
    AppMethodBeat.i(99058);
    if (this.Aim != null)
    {
      if (paramList != null) {
        f(true, paramList);
      }
      this.Aim.ecy();
    }
    AppMethodBeat.o(99058);
  }
  
  final boolean fY(List<Integer> paramList)
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
        if ((localp != null) && (localp.zMC == j))
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
  
  final boolean fZ(List<Integer> paramList)
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
        if (localp.zMC == j)
        {
          ad.d("MicroMsg.SnsSelfHelper", "update list localId ".concat(String.valueOf(j)));
          this.list.remove(i);
          ((LinkedList)localObject).add(ag.dUe().QP(j));
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
    ad.d("MicroMsg.SnsSelfHelper", "limitSeq ".concat(String.valueOf(paramString)));
    this.rdV = paramString;
    this.sKd = paramBoolean1;
    nd(paramBoolean2);
    AppMethodBeat.o(99064);
  }
  
  public static abstract interface a
  {
    public abstract void b(List<p> paramList, Map<Integer, Integer> paramMap1, Map<Integer, Integer> paramMap2, Map<Integer, Integer> paramMap3, int paramInt1, int paramInt2);
    
    public abstract void ecy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf
 * JD-Core Version:    0.7.0.1
 */